/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.client.jobs;

import org.quartz.JobExecutionContext;
import org.upasx.lichee.client.AgentContext;
import org.upasx.lichee.client.cmd.CommandUtils;
import org.upasx.lichee.configs.AppProperties;
import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.utils.PathUtils;
import org.upasx.lichee.zookeeper.ZooKeeperHelper;

/**
 * @author Xiong Zhijun
 * @date Nov 20, 2014
 */
public class DefaultJob extends JobSupport {

	@Override
	protected void execute(JobExecutionContext context,
			AgentContext agentContext, MonitorItemConfig config) {
		StringBuilder cmd = new StringBuilder(
				AppProperties.INSTANCE.getScriptHomeDir());
		if (!cmd.toString().endsWith("/")) {
			cmd.append("/");
		}
		cmd.append(config.command);
		String result = CommandUtils.execute(cmd.toString());
		ZooKeeperHelper zooKeeperHelper = agentContext.getZooKeeperHelper();
		zooKeeperHelper.setData(PathUtils.join(agentContext.getHostPath(),
				config.monitorItemName, "datas"), result);
	}
}
