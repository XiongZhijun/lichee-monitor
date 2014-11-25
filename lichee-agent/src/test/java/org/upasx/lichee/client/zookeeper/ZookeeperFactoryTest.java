/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.client.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.junit.Test;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;
import org.upasx.lichee.zookeeper.LicheeZooKeeperFactory;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class ZookeeperFactoryTest {

	@Test
	public void testCreateZookeeper() throws KeeperException,
			InterruptedException {
		LicheeZooKeeper zk = LicheeZooKeeperFactory.createZooKeeper();
		Iterable<String> children = zk.getChildren("/", null);
		System.out.println(children);
	}

}
