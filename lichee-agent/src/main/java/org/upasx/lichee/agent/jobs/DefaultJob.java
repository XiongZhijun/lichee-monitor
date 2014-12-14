/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.agent.jobs;

import org.quartz.JobExecutionContext;
import org.upasx.lichee.agent.AgentContext;
import org.upasx.lichee.command.CommandBuilder;
import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.utils.CommandUtils;
import org.upasx.lichee.utils.PathUtils;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 20, 2014
 */
public class DefaultJob extends JobSupport {

	@Override
	protected void execute(JobExecutionContext context,
			AgentContext agentContext, MonitorItemConfig config,
			CommandBuilder commandBuilder) {
		String cmd = commandBuilder.buildCommand(config.command);
		String result = CommandUtils.execute(cmd);
		LicheeZooKeeper zooKeeperHelper = agentContext.getZooKeeperHelper();
		zooKeeperHelper.setData(PathUtils.join(agentContext.getHostPath(),
				config.monitorItemName, "datas"), result);
		System.out.println(result);
	}
}
