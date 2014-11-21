/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.client;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * @author Xiong Zhijun
 * @date Nov 20, 2014
 */
public abstract class PropertiesSupport {
	private Properties properties = new Properties();

	protected PropertiesSupport(String propertiesFile) {
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(
					propertiesFile));
		} catch (IOException e) {
			throw new LicheeException("Load " + propertiesFile + " falied.", e);
		}
	}

	public String getString(String key) {
		return properties.getProperty(key);
	}

	public String getString(String key, String defaultValue) {
		String property = properties.getProperty(key);
		return StringUtils.isBlank(property) ? defaultValue : property;
	}

	public int getInt(String key) {
		String property = properties.getProperty(key);
		return NumberUtils.toInt(property);
	}

}
