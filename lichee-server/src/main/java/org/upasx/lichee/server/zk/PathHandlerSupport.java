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
 * @date Nov 22, 2014
 *
 */
public abstract class PathHandlerSupport implements PathHandler, Watcher {

	protected LicheeZooKeeper licheeZooKeeper;
	protected String path;

	public PathHandlerSupport(LicheeZooKeeper licheeZooKeeper, String path) {
		super();
		this.licheeZooKeeper = licheeZooKeeper;
		this.path = path;
	}

	@Override
	public void handle() {
		Iterable<String> children = licheeZooKeeper.getChildren(path, this);
		for (String child : children) {
			handleChild(child);
		}
	}

	protected abstract void handleChild(String child);

	@Override
	public void process(WatchedEvent event) {
		handle();
	}
}
