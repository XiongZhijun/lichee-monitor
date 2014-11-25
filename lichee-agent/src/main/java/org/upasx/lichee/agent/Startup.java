/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.agent;

import java.io.IOException;

import org.upasx.lichee.agent.jobs.JobManager;
import org.upasx.lichee.configs.AppProperties;
import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.model.MonitorItemConfigList;
import org.upasx.lichee.utils.EnvironmentUtils;
import org.upasx.lichee.utils.PathUtils;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;
import org.upasx.lichee.zookeeper.LicheeZooKeeperFactory;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class Startup {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		LicheeZooKeeper zk = LicheeZooKeeperFactory.createZooKeeper();
		String hostPath = PathUtils.join(AppProperties.INSTANCE.getHostsPath(),
				EnvironmentUtils.getLocalHostName());
		AgentContext context = new AgentContext();
		context.setZooKeeperHelper(zk);
		context.setHostPath(hostPath);
		init(zk, hostPath);

		MonitorItemConfigList configList = MonitorItemConfigList
				.getByZooKeeperPath(zk, hostPath);
		new JobManager().startJobs(context, configList);
		while (true) {
			Thread.sleep(100000);
		}
	}

	private static void init(LicheeZooKeeper helper, String hostPath) {
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
