/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client;

import java.io.IOException;

import org.apache.zookeeper.ZooKeeper;
import org.upas.lichee.client.zookeeper.ZooKeeperFactory;
import org.upas.lichee.client.zookeeper.ZooKeeperHelper;

import com.google.gson.Gson;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class Startup {

	public static void main(String[] args) throws IOException {
		ZooKeeper zk = ZooKeeperFactory.createZooKeeper();
		ZooKeeperHelper helper = new ZooKeeperHelper(zk);
		init(helper);
	}

	private static void init(ZooKeeperHelper helper) {
		String hostPath = PathUtils.join(
				AppProperties.INSTANCE.getZooKeeperBasePath(), "/hosts",
				AppProperties.INSTANCE.getLocalHostName());
		helper.initPath(hostPath);
		String cpuConfigsPath = helper.initPath(hostPath, "cpu/configs");
		helper.initPath(hostPath, "cpu/datas");
		String memoryConfigPath = helper.initPath(hostPath, "memory/configs");
		helper.initPath(hostPath, "memory/datas");

		helper.setData(cpuConfigsPath, new Configs("scripts/cpu.py"));
		helper.setData(memoryConfigPath, new Configs("scripts/memory.py"));
	}

	static class Configs {
		String cmd;

		public Configs(String cmd) {
			super();
			this.cmd = cmd;
		}

		@Override
		public String toString() {
			return new Gson().toJson(this);
		}
	}

}
