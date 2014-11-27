/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.zookeeper;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Xiong Zhijun
 * @date Nov 22, 2014
 *
 */
@Lazy(false)
@Component
public class LicheeZooKeeperFactoryBean implements FactoryBean<LicheeZooKeeper> {
	@Value("${zookeeper.servers}")
	private String zooKeeperServers;
	@Value("${zookeeper.session.timeout}")
	private int zooKeeperSessionTimeout;

	@Override
	public LicheeZooKeeper getObject() throws Exception {
		return new LicheeZooKeeper(zooKeeperServers, zooKeeperSessionTimeout);
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
