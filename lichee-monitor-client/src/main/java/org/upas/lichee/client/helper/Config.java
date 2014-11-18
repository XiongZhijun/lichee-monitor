/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.helper;

import java.util.Map;

import com.google.gson.GsonBuilder;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public class Config {

	public String cron;

	public MonitorType monitorType;

	public String description;

	public String command;

	public Map<String, String> properties;

	@Override
	public String toString() {
		return new GsonBuilder()
				.registerTypeAdapter(Config.class, new ConfigJsonHelper())
				.create().toJson(this);
	}

	public static enum MonitorType {
		Percent, Quantity, Percent_Quantity, Access
	}

}
