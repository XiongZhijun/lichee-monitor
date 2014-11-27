/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.upasx.lichee.model.MonitorItemConfigList;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 27, 2014
 *
 */
@Service
public class MonitorItemService {
	@Autowired
	private LicheeZooKeeper licheeZooKeeper;
	@Autowired
	@Qualifier("local.host.path")
	private String localHostPath;

	public MonitorItemConfigList getAllMonitorItemConfigs() {
		return MonitorItemConfigList.getByZooKeeperPath(licheeZooKeeper,
				localHostPath);
	}
}
