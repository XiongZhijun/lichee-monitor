/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
public class DataChangeHandler implements PathHandler, Watcher {
	protected LicheeZooKeeper licheeZooKeeper;
	protected String path;

	public DataChangeHandler(LicheeZooKeeper licheeZooKeeper, String path) {
		super();
		this.licheeZooKeeper = licheeZooKeeper;
		this.path = path;
	}

	@Override
	public void handle() {

	}

	@Override
	public void process(WatchedEvent event) {
		
	}

}
