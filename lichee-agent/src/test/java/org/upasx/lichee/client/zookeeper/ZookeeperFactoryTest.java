/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.client.zookeeper;

import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.upasx.lichee.zookeeper.ZooKeeperFactory;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class ZookeeperFactoryTest {

	@Test
	public void testCreateZookeeper() throws KeeperException,
			InterruptedException {
		ZooKeeper zk = ZooKeeperFactory.createZooKeeper();
		List<String> children = zk.getChildren("/", false);
		System.out.println(children);
	}

}
