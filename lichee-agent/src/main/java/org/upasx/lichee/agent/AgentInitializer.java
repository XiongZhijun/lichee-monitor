/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.agent;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.model.MonitorItemConfigList;
import org.upasx.lichee.utils.PathUtils;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 26, 2014
 *
 */
@Component("agent.initializer")
@Lazy(false)
public class AgentInitializer {
	@Autowired
	private LicheeZooKeeper licheeZooKeeper;
	@Autowired
	@Qualifier("local.host.path")
	private String hostPath;

	@PostConstruct
	public void init() {
		licheeZooKeeper.initPath(hostPath);
		MonitorItemConfigList configList = MonitorItemConfigList
				.createByClassPathFile();
		for (MonitorItemConfig config : configList) {
			String itemName = config.monitorItemName;
			licheeZooKeeper.initPath(
					PathUtils.join(hostPath, itemName, "configs"), config);
			licheeZooKeeper.initPath(PathUtils
					.join(hostPath, itemName, "datas"));
		}
	}
}
