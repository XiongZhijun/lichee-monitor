/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client;

import java.io.IOException;
import java.util.Map.Entry;

import org.apache.zookeeper.ZooKeeper;
import org.upas.lichee.client.helper.Config;
import org.upas.lichee.client.helper.ConfigHelper;
import org.upas.lichee.client.utils.PathUtils;
import org.upas.lichee.client.zookeeper.ZooKeeperFactory;
import org.upas.lichee.client.zookeeper.ZooKeeperHelper;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class Startup {

	public static void main(String[] args) throws IOException {
		ZooKeeper zk = ZooKeeperFactory.createZooKeeper();
		ZooKeeperHelper helper = new ZooKeeperHelper(zk);
		init(helper);
	}

	private static void init(ZooKeeperHelper helper) {
		String hostPath = PathUtils.join(
				AppProperties.INSTANCE.getZooKeeperBasePath(), "/hosts",
				AppProperties.INSTANCE.getLocalHostName());
		helper.initPath(hostPath);
		ConfigHelper configHelper = new ConfigHelper("configs.json");
		for (Entry<String, Config> entry : configHelper) {
			String key = entry.getKey();
			Config config = entry.getValue();
			helper.initPath(PathUtils.join(hostPath, key, "configs"), config);
			helper.initPath(PathUtils.join(hostPath, key, "datas"));
		}
	}

}
