/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import org.apache.zookeeper.Watcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Xiong Zhijun
 * @date Nov 22, 2014
 *
 */
@Component
public class HostsPathHandler extends PathHandlerSupport implements
		PathHandler, Watcher {
	@Autowired
	private HostPathHandler hostPathHandler;

	@Override
	protected void handleChild(String parent, String host) {
		hostPathHandler.handle(host);
	}

}
