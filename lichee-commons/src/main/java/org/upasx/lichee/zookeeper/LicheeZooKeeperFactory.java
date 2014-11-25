/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.zookeeper;

import org.upasx.lichee.configs.AppProperties;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class LicheeZooKeeperFactory {
	private static AppProperties appProperties = AppProperties.INSTANCE;

	public static LicheeZooKeeper createZooKeeper() {
		return new LicheeZooKeeper(appProperties.getZooKeeperServers(),
				appProperties.getZooKeeperSessionTimeout());
	}
}
