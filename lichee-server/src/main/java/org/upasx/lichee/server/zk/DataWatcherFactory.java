/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import java.util.HashMap;
import java.util.Map;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
@Component
public class DataWatcherFactory {
	@Autowired
	private LicheeZooKeeper licheeZooKeeper;
	private Map<String, Watcher> pathWatcherMap = new HashMap<String, Watcher>();

	public synchronized Watcher getWatcher(String path) {
		Watcher watcher = pathWatcherMap.get(path);
		if (watcher == null) {
			watcher = new DataWatcher(path, licheeZooKeeper);
			pathWatcherMap.put(path, watcher);
		}
		return watcher;
	}

	class DataWatcher implements Watcher {
		private String path;
		private LicheeZooKeeper licheeZooKeeper;

		public DataWatcher(String path, LicheeZooKeeper licheeZooKeeper) {
			super();
			this.path = path;
			this.licheeZooKeeper = licheeZooKeeper;
		}

		@Override
		public void process(WatchedEvent event) {
			if (event.getType() == EventType.NodeDataChanged) {
				String data = licheeZooKeeper.getData(path, this);
				System.out.println("get data : " + data);
			}
		}

	}
}
