/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.model;

import java.util.Map;

import com.google.gson.Gson;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public class MonitorItemConfig {

	public String monitorItemName;

	public String cron;

	public String monitorType;

	public String description;

	public String command;

	public Map<String, String> properties;

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
