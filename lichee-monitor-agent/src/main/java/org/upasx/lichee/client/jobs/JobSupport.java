/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.client.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.upasx.lichee.client.AgentContext;
import org.upasx.lichee.model.MonitorItemConfig;

/**
 * @author Xiong Zhijun
 * @date Nov 20, 2014
 */
public abstract class JobSupport implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		MonitorItemConfig config = (MonitorItemConfig) jobDataMap.get("config");
		AgentContext agentContext = (AgentContext) jobDataMap.get("context");
		execute(context, agentContext, config);
	}

	protected abstract void execute(JobExecutionContext context,
			AgentContext agentContext, MonitorItemConfig config);

}
