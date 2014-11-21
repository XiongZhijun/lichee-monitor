/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.agent;

import org.upasx.lichee.zookeeper.ZooKeeperHelper;

/**
 * @author Xiong Zhijun
 * @date Nov 21, 2014
 */
public class AgentContext {
	private ZooKeeperHelper zooKeeperHelper;
	private String hostPath;

	/**
	 * @return the zooKeeperHelper
	 */
	public ZooKeeperHelper getZooKeeperHelper() {
		return zooKeeperHelper;
	}

	/**
	 * @param zooKeeperHelper
	 *            the zooKeeperHelper to set
	 */
	public void setZooKeeperHelper(ZooKeeperHelper zooKeeperHelper) {
		this.zooKeeperHelper = zooKeeperHelper;
	}

	/**
	 * @return the hostPath
	 */
	public String getHostPath() {
		return hostPath;
	}

	/**
	 * @param hostPath
	 *            the hostPath to set
	 */
	public void setHostPath(String hostPath) {
		this.hostPath = hostPath;
	}

}
