/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.helper;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.upas.lichee.client.helper.Config.MonitorType;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public class ConfigJsonHelper implements JsonDeserializer<Config>,
		JsonSerializer<Config> {

	@Override
	public Config deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		if (!(json instanceof JsonObject)) {
			return null;
		}
		JsonObject jsonObject = (JsonObject) json;
		Map<String, String> map = context.deserialize(jsonObject,
				new TypeToken<Map<String, String>>() {
				}.getType());
		Config config = new Config();
		config.cron = map.get("cron");
		config.description = map.get("description");
		String monitorTypeStr = map.get("monitorType");
		config.monitorType = StringUtils.isBlank(monitorTypeStr) ? MonitorType.Percent
				: MonitorType.valueOf(monitorTypeStr);
		map.remove("cron");
		map.remove("description");
		map.remove("monitorType");
		config.properties = map;
		return config;
	}

	@Override
	public JsonElement serialize(Config config, Type typeOfSrc,
			JsonSerializationContext context) {
		if (config == null) {
			return null;
		}
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("cron", config.cron);
		map.put("description", config.description);
		map.put("monitorType", config.monitorType.name());
		map.putAll(config.properties);
		return context.serialize(map);
	}
}
