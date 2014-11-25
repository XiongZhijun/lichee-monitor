/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author Xiong Zhijun
 * @date Nov 25, 2014
 *
 */
public class EmptyWatcher implements Watcher {

	@Override
	public void process(WatchedEvent event) {

	}

}
