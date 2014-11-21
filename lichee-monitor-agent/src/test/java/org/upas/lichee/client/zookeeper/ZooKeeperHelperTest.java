/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.zookeeper;

import java.util.Properties;

import org.junit.Test;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class ZooKeeperHelperTest {

	@Test
	public void testInitPath() {
		ZooKeeperHelper helper = new ZooKeeperHelper(
				ZooKeeperFactory.createZooKeeper());
		helper.initPath("/a/b/c/d");
		System.out.println(System.getenv());
		Properties properties = System.getProperties();
		for (Object key : properties.keySet()) {
			System.out.println(key + " : "
					+ properties.getProperty((String) key));
		}
	}

}
