/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.zookeeper;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.upasx.lichee.LicheeException;
import org.upasx.lichee.utils.PathUtils;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class LicheeZooKeeper {

	private ZooKeeper zk;

	public LicheeZooKeeper(ZooKeeper zk) {
		super();
		this.zk = zk;
	}

	public String initPath(String path, Object value) {
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
			initPath(parentPath, null);
		}
		try {
			byte[] data;
			if (value == null) {
				data = null;
			} else {
				data = value.toString().getBytes("UTF-8");
			}
			return zk.create(path, data, Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT);
		} catch (Exception e) {
			throw new LicheeException("create " + path + " failed.", e);
		}
	}

	public String initPath(String parentPath, String subPath, Object data) {
		return initPath(PathUtils.join(parentPath, subPath), data);
	}

	public void initPath(String path) {
		initPath(path, null);
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

	public String getData(String path) {
		try {
			byte[] data = zk.getData(path, true, null);
			if (data == null) {
				return null;
			}
			return new String(data, "UTF-8");
		} catch (Exception e) {
			throw new LicheeException("get data from " + path + " failed.", e);
		}
	}

}
