/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.agent;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.upasx.lichee.agent.jobs.JobManager;
import org.upasx.lichee.model.MonitorItemConfigList;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 27, 2014
 *
 */
@Service
@DependsOn("agent.initializer")
@Lazy(false)
public class JobStarter {
	@Autowired
	private MonitorItemService monitorItemService;
	@Autowired
	private JobManager jobManager;
	@Autowired
	private LicheeZooKeeper licheeZooKeeper;
	@Autowired
	@Qualifier("local.host.path")
	private String localHostPath;

	@PostConstruct
	public void startJobs() {
		MonitorItemConfigList configs = monitorItemService
				.getAllMonitorItemConfigs();
		AgentContext context = new AgentContext();
		context.setHostPath(localHostPath);
		context.setZooKeeperHelper(licheeZooKeeper);
		jobManager.startJobs(context, configs);
	}
}
