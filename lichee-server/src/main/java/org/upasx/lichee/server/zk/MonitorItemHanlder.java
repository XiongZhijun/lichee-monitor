/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
public class MonitorItemHanlder extends PathHandlerSupport {

	public MonitorItemHanlder(LicheeZooKeeper licheeZooKeeper,
			String monitorItem) {
		super(licheeZooKeeper, monitorItem);
	}

	@Override
	protected void handleChild(final String child) {
		if (child.endsWith("/datas")) {
			final Watcher watcher = new Watcher() {
				public void process(WatchedEvent event) {
					if (event.getType() == EventType.NodeDataChanged) {
						String data = licheeZooKeeper.getData(child, this);
						System.out.println(data);
					}
				}

			};
			licheeZooKeeper.registWatcher(child, watcher);
		}
	}
}
