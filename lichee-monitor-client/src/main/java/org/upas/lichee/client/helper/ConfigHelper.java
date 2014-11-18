/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.helper;

import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public class ConfigHelper implements Iterable<Entry<String, Config>> {
	private Map<String, Config> configs;

	public ConfigHelper(String path) {
		Gson gson = new GsonBuilder().registerTypeAdapter(Config.class,
				new ConfigJsonHelper()).create();
		InputStreamReader reader = new InputStreamReader(
				ClassLoader.getSystemResourceAsStream(path));
		try {
			this.configs = gson.fromJson(reader,
					new TypeToken<Map<String, Config>>() {
					}.getType());
		} finally {
			IOUtils.closeQuietly(reader);
		}
	}

	public Map<String, Config> getConfigs() {
		return configs;
	}

	@Override
	public Iterator<Entry<String, Config>> iterator() {
		return this.configs.entrySet().iterator();
	}
}
