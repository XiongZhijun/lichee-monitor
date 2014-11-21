/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.jobs;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author Xiong Zhijun
 * @date Nov 19, 2014
 */
public class JobTest {

	@Test
	public void test() throws SchedulerException, InterruptedException {
		JobDetail job = newJob(MyJob.class).withIdentity("job1", "group1")
				.build();
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
				.startNow().withSchedule(cronSchedule("0/5 * * * * ?")).build();
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);
		Thread.sleep(100000);
	}

	public static class MyJob implements Job {

		@Override
		public void execute(JobExecutionContext context)
				throws JobExecutionException {
			System.out.println("job done");
		}

	}
}
