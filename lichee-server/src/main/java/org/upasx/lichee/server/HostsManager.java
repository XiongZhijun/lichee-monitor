/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.upasx.lichee.configs.AppProperties;
import org.upasx.lichee.server.zk.HostsPathHandler;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 22, 2014
 *
 */
@Component
@Lazy(false)
public class HostsManager {
	private String hostsPath = AppProperties.INSTANCE.getHostsPath();
	@Autowired
	private LicheeZooKeeper licheeZooKeeper;

	@PostConstruct
	public void init() {
		licheeZooKeeper.initPath(hostsPath);
		HostsPathHandler handler = new HostsPathHandler(licheeZooKeeper,
				hostsPath);
		handler.handle();
	}

}
