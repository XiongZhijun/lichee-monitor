/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.zookeeper;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.upas.lichee.client.LicheeException;
import org.upas.lichee.client.PathUtils;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class ZooKeeperHelper {

	private ZooKeeper zk;

	public ZooKeeperHelper(ZooKeeper zk) {
		super();
		this.zk = zk;
	}

	public String initPath(String path) {
		Stat exists;
		try {
			exists = zk.exists(path, false);
		} catch (Exception e) {
			throw new LicheeException("Check " + path + " exists failed.", e);
		}
		if (exists != null) {
			return path;
		}
		int index = path.lastIndexOf("/");
		if (index > 0) {
			String parentPath = path.substring(0, index);
			initPath(parentPath);
		}
		try {
			return zk.create(path, null, Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);
		} catch (Exception e) {
			throw new LicheeException("create " + path + " failed.", e);
		}
	}

	public String initPath(String parentPath, String subPath) {
		return initPath(PathUtils.join(parentPath, subPath));
	}

	public Iterable<String> iterateChildren(String path) {
		List<String> children;
		try {
			children = zk.getChildren(path, false);
		} catch (Exception e) {
			throw new LicheeException("get children failed", e);
		}
		List<String> childFullPaths = new ArrayList<String>();
		for (String child : children) {
			StringBuilder fullPath = new StringBuilder(path);
			if (!path.endsWith("/") && !child.startsWith("/")) {
				fullPath.append("/");
			}
			fullPath.append(child);
			childFullPaths.add(fullPath.toString());
		}
		return childFullPaths;
	}

	public void setData(String path, Object data) {
		try {
			byte[] bytes = data.toString().getBytes("UTF-8");
			zk.setData(path, bytes, -1);
		} catch (Exception e) {
			throw new LicheeException("set data to " + path + " failed", e);
		}
	}

}
