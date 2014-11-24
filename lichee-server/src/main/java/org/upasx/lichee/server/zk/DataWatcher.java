/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.server.datas.DataHandler;
import org.upasx.lichee.server.datas.DataHandlerManager;
import org.upasx.lichee.utils.PathUtils;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
public class DataWatcher implements Watcher {
	@Autowired
	private LicheeZooKeeper licheeZooKeeper;
	@Autowired
	private DataHandlerManager dataHandlerManager;
	private String dataPath;

	public DataWatcher(String dataPath) {
		super();
		this.dataPath = dataPath;
	}

	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeDataChanged) {
			String data = licheeZooKeeper.getData(dataPath, this);
			String parent = PathUtils.getParent(dataPath);
			String configPath = PathUtils.join(parent, "configs");
			String configStr = licheeZooKeeper.getData(configPath, null);
			MonitorItemConfig config = MonitorItemConfig.fromString(configStr);
			DataHandler dataHandler = dataHandlerManager.getDataHandler(config);
			dataHandler.handle(config, data);
		}
	}
}
