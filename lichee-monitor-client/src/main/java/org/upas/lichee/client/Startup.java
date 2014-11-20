/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client;

import java.io.IOException;

import org.apache.zookeeper.ZooKeeper;
import org.upas.lichee.client.helper.MonitorItemConfig;
import org.upas.lichee.client.helper.MonitorItemConfigList;
import org.upas.lichee.client.jobs.JobManager;
import org.upas.lichee.client.utils.PathUtils;
import org.upas.lichee.client.zookeeper.ZooKeeperFactory;
import org.upas.lichee.client.zookeeper.ZooKeeperHelper;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class Startup {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		ZooKeeper zk = ZooKeeperFactory.createZooKeeper();
		ZooKeeperHelper helper = new ZooKeeperHelper(zk);
		String hostPath = PathUtils.join(
				AppProperties.INSTANCE.getZooKeeperBasePath(), "/hosts",
				AppProperties.INSTANCE.getLocalHostName());
		init(helper, hostPath);

		MonitorItemConfigList configList = MonitorItemConfigList
				.getByZooKeeperPath(helper, hostPath);
		new JobManager().startJobs(configList);
		while (true) {
			Thread.sleep(100000);
		}
	}

	private static void init(ZooKeeperHelper helper, String hostPath) {
		helper.initPath(hostPath);
		MonitorItemConfigList configList = MonitorItemConfigList
				.createByClassPathFile();
		for (MonitorItemConfig config : configList) {
			String itemName = config.monitorItemName;
			helper.initPath(PathUtils.join(hostPath, itemName, "configs"),
					config);
			helper.initPath(PathUtils.join(hostPath, itemName, "datas"));
		}
	}
}
