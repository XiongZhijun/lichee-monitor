/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import org.apache.zookeeper.Watcher;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 22, 2014
 *
 */
public class HostsPathHandler extends PathHandlerSupport implements
		PathHandler, Watcher {

	public HostsPathHandler(LicheeZooKeeper licheeZooKeeper, String path) {
		super(licheeZooKeeper, path);
	}

	@Override
	protected void handleChild(String host) {
		new HostPathHandler(licheeZooKeeper, host).handle();
	}

}
