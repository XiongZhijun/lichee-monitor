/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.agent;

import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Nov 21, 2014
 */
public class AgentContext {
	private LicheeZooKeeper zooKeeperHelper;
	private String hostPath;

	/**
	 * @return the zooKeeperHelper
	 */
	public LicheeZooKeeper getZooKeeperHelper() {
		return zooKeeperHelper;
	}

	/**
	 * @param zooKeeperHelper
	 *            the zooKeeperHelper to set
	 */
	public void setZooKeeperHelper(LicheeZooKeeper zooKeeperHelper) {
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
