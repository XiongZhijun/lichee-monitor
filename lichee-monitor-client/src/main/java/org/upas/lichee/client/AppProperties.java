package org.upas.lichee.client;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.upas.lichee.client.utils.HostUtils;

public class AppProperties {
	public static final String APP_PROPERTIES = "app.properties";

	public static final AppProperties INSTANCE = new AppProperties();
	private Properties properties = new Properties();

	protected AppProperties() {
		String propertiesFile = APP_PROPERTIES;
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(
					propertiesFile));
		} catch (IOException e) {
			throw new LicheeException("Load " + propertiesFile + " falied.", e);
		}
	}

	public String getZooKeeperServers() {
		return properties.getProperty("zookeeper.servers");
	}

	public int getZooKeeperSessionTimeout() {
		return Integer.parseInt(properties
				.getProperty("zookeeper.session.timeout"));
	}

	public String getZooKeeperBasePath() {
		String property = properties.getProperty("zookeeper.base.path");
		if (StringUtils.isBlank(property)) {
			return "/lichee-monitor";
		}
		return property;
	}

	public String getLocalHostName() {
		String hostName = properties.getProperty("local.host.name");
		if (hostName == null || hostName.trim().length() == 0) {
			hostName = HostUtils.getHostName();
		}
		if (hostName == null || hostName.trim().length() == 0) {
			hostName = HostUtils.getHostAddress();
		}
		return hostName;
	}
}
