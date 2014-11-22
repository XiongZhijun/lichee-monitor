/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.model;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.upasx.lichee.utils.PathUtils;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public class MonitorItemConfigList implements Iterable<MonitorItemConfig> {
	private List<MonitorItemConfig> configs = new ArrayList<MonitorItemConfig>();

	public Iterator<MonitorItemConfig> iterator() {
		return this.configs.iterator();
	}

	@Override
	public String toString() {
		return new Gson().toJson(configs);
	}

	public static MonitorItemConfigList createByClassPathFile() {
		InputStreamReader reader = new InputStreamReader(
				ClassLoader.getSystemResourceAsStream("configs.json"));
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

	public static MonitorItemConfigList getByZooKeeperPath(
			LicheeZooKeeper helper, String path) {
		MonitorItemConfigList configList = new MonitorItemConfigList();
		for (String child : helper.iterateChildren(path)) {
			String data = helper.getData(PathUtils.join(child, "configs"));
			if (StringUtils.isBlank(data)) {
				continue;
			}
			MonitorItemConfig config = new Gson().fromJson(data,
					MonitorItemConfig.class);
			configList.configs.add(config);

		}
		return configList;
	}
}
