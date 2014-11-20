/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.jobs;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.upas.lichee.client.JobConfigsProperties;
import org.upas.lichee.client.LicheeException;
import org.upas.lichee.client.helper.MonitorItemConfig;

/**
 * @author Xiong Zhijun
 * @date Nov 20, 2014
 */
public class JobManager {

	private Scheduler scheduler;

	public JobManager() {
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
		} catch (SchedulerException e) {
			throw new LicheeException("create and start schedule failed.", e);
		}

	}

	public void startJobs(Iterable<MonitorItemConfig> configIterator) {
		for (MonitorItemConfig config : configIterator) {
			Class<Job> cls = JobConfigsProperties.INSTANCE
					.getClass(config.monitorType);
			JobDataMap newJobDataMap = new JobDataMap();
			newJobDataMap.put("config", config);
			JobDetail job = newJob(cls)
					.withIdentity("job-" + config.monitorItemName,
							"monitor-group").setJobData(newJobDataMap).build();
			Trigger trigger = newTrigger()
					.withIdentity("trigger" + config.monitorItemName,
							"monitor-group").startNow()
					.withSchedule(cronSchedule(config.cron)).build();
			schedule(job, trigger);
		}
	}

	private void schedule(JobDetail job, Trigger trigger) {
		try {
			scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			throw new LicheeException(e.getMessage(), e);
		}
	}
}
