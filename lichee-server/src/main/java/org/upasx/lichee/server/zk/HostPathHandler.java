/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
public class HostPathHandler extends PathHandlerSupport {

	public HostPathHandler(LicheeZooKeeper licheeZooKeeper, String host) {
		super(licheeZooKeeper, host);
	}

	@Override
	protected void handleChild(String monitorItem) {
		new MonitorItemHanlder(licheeZooKeeper, monitorItem).handle();
	}

}
