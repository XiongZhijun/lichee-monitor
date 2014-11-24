/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.zk;

import java.util.HashMap;
import java.util.Map;

import org.apache.zookeeper.Watcher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
@Component
public class DataWatcherFactory implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Autowired
	private LicheeZooKeeper licheeZooKeeper;
	
	private Map<String, Watcher> pathWatcherMap = new HashMap<String, Watcher>();

	public synchronized Watcher getWatcher(String path) {
		Watcher watcher = pathWatcherMap.get(path);
		if (watcher == null) {
			watcher = new DataWatcher(path);
			applicationContext.getAutowireCapableBeanFactory().autowireBean(
					watcher);
			pathWatcherMap.put(path, watcher);
		}
		return watcher;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}
