/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.jobs;

import org.quartz.JobExecutionContext;
import org.upas.lichee.client.AppProperties;
import org.upas.lichee.client.AgentContext;
import org.upas.lichee.client.cmd.CommandUtils;
import org.upas.lichee.client.helper.MonitorItemConfig;

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
		System.out.println(result);
	}

}
