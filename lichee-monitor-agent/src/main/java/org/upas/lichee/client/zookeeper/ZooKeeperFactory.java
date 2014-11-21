/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.ZooKeeper;
import org.upas.lichee.client.AppProperties;
import org.upas.lichee.client.LicheeException;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class ZooKeeperFactory {
	private static AppProperties appProperties = AppProperties.INSTANCE;

	public static ZooKeeper createZooKeeper() {
		try {
			return new ZooKeeper(appProperties.getZooKeeperServers(),
					appProperties.getZooKeeperSessionTimeout(), null);
		} catch (IOException e) {
			throw new LicheeException("Init zookeeper failed.", e);
		}
	}
}
