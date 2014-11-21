package org.upasx.lichee.configs;

public class AppProperties extends PropertiesSupport {
	public static final String APP_PROPERTIES = "app.properties";

	public static final AppProperties INSTANCE = new AppProperties();

	private AppProperties() {
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

	public String getScriptHomeDir() {
		return getString("scripts.home.dir", "scripts/");
	}
}
