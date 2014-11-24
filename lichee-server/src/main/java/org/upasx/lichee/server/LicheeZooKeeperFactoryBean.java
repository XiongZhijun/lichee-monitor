/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;
import org.upasx.lichee.zookeeper.ZooKeeperFactory;

/**
 * @author Xiong Zhijun
 * @date Nov 22, 2014
 *
 */
@Component
public class LicheeZooKeeperFactoryBean implements FactoryBean<LicheeZooKeeper> {

	@Override
	public LicheeZooKeeper getObject() throws Exception {
		return new LicheeZooKeeper(ZooKeeperFactory.createZooKeeper());
	}

	@Override
	public Class<?> getObjectType() {
		return LicheeZooKeeper.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
