/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.client;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.quartz.Job;
import org.upasx.lichee.client.jobs.DefaultJob;

/**
 * @author Xiong Zhijun
 * @date Nov 20, 2014
 */
public class JobConfigsProperties extends PropertiesSupport {

	private static final String JOB_CONFIGS_PROPERTIES = "job-configs.properties";

	public static JobConfigsProperties INSTANCE = new JobConfigsProperties();

	protected JobConfigsProperties() {
		super(JOB_CONFIGS_PROPERTIES);
	}

	@SuppressWarnings("unchecked")
	public <T extends Job> Class<T> getClass(String type) {
		String className = getString(type);
		if (StringUtils.isBlank(className)) {
			return (Class<T>) DefaultJob.class;
		}
		try {
			return ClassUtils.getClass(className);
		} catch (ClassNotFoundException e) {
			throw new LicheeException(e.getMessage(), e);
		}
	}

}
