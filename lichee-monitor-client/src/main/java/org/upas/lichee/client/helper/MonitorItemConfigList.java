/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.helper;

import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public class MonitorItemConfigList implements Iterable<MonitorItemConfig> {
	private List<MonitorItemConfig> configs;

	@Override
	public Iterator<MonitorItemConfig> iterator() {
		return this.configs.iterator();
	}

	@Override
	public String toString() {
		return new Gson().toJson(configs);
	}

	public static MonitorItemConfigList createByClassPathFile(
			String configFilePath) {
		InputStreamReader reader = new InputStreamReader(
				ClassLoader.getSystemResourceAsStream(configFilePath));
		List<MonitorItemConfig> configs;
		try {
			configs = new Gson().fromJson(reader,
					new TypeToken<List<MonitorItemConfig>>() {
					}.getType());
		} finally {
			IOUtils.closeQuietly(reader);
		}
		MonitorItemConfigList configList = new MonitorItemConfigList();
		configList.configs = configs;
		return configList;
	}
}
