package org.upas.lichee.client;

import org.upas.lichee.client.utils.HostUtils;

public class AppProperties extends PropertiesSupport {
	public static final String APP_PROPERTIES = "app.properties";

	public static final AppProperties INSTANCE = new AppProperties();

	public AppProperties() {
		super(APP_PROPERTIES);
	}

	public String getZooKeeperServers() {
		return getString("zookeeper.servers");
	}

	public int getZooKeeperSessionTimeout() {
		return getInt("zookeeper.session.timeout");
	}

	public String getZooKeeperBasePath() {
		return getString("zookeeper.base.path", "/lichee-monitor");
	}

	public String getLocalHostName() {
		String hostName = getString("local.host.name");
		if (hostName == null || hostName.trim().length() == 0) {
			hostName = HostUtils.getHostName();
		}
		if (hostName == null || hostName.trim().length() == 0) {
			hostName = HostUtils.getHostAddress();
		}
		return hostName;
	}
}
