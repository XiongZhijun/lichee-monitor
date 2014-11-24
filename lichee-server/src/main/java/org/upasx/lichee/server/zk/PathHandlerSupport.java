/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 22, 2014
 *
 */
public abstract class PathHandlerSupport implements PathHandler, Watcher {

	@Autowired
	protected LicheeZooKeeper licheeZooKeeper;

	@Override
	public void handle(String path) {
		Iterable<String> children = licheeZooKeeper.getChildren(path, this);
		for (String child : children) {
			handleChild(path, child);
		}
	}

	protected abstract void handleChild(String parent, String child);

	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeChildrenChanged) {
			handle(event.getPath());
		}
	}

	public LicheeZooKeeper getLicheeZooKeeper() {
		return licheeZooKeeper;
	}

	public void setLicheeZooKeeper(LicheeZooKeeper licheeZooKeeper) {
		this.licheeZooKeeper = licheeZooKeeper;
	}

}
