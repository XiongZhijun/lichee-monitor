/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
@Component
public class MonitorItemHanlder extends PathHandlerSupport {
	@Autowired
	private DataWatcherFactory dataWatcherFactory;

	@Override
	protected void handleChild(String parent, String child) {
		if (child.endsWith("/datas")) {
			licheeZooKeeper.registWatcher(child,
					dataWatcherFactory.getWatcher(child));
		}
	}

}
