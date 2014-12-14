/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.upasx.lichee.utils.PathUtils;
import org.upasx.lichee.zookeeper.LicheeZooKeeper;

/**
 * @author Xiong Zhijun
 * @date Dec 7, 2014
 *
 */
@RestController
public class HostsResource {

	@Autowired
	private LicheeZooKeeper licheeZooKeeper;
	@Autowired
	@Qualifier("hosts.path")
	private String hostsPath;

	@RequestMapping("/hosts")
	public List<String> hosts() {
		List<String> children = this.licheeZooKeeper.getChildren(hostsPath,
				null);
		return children;
	}

	@RequestMapping("/hosts/{host}")
	public List<String> host(@PathVariable("host") String host) {
		List<String> children = this.licheeZooKeeper.getChildren(
				PathUtils.join(hostsPath, host), null);
		return children;
	}

	@RequestMapping("/hosts/{host}/{item}/datas")
	public String hostDatas(@PathVariable("host") String host,
			@PathVariable("item") String item) {
		String data = this.licheeZooKeeper.getData(
				PathUtils.join(hostsPath, host, item, "datas"), null);
		return data;
	}

	@RequestMapping("/hosts/{host}/{item}/configs")
	public String hostConfigs(@PathVariable("host") String host,
			@PathVariable("item") String item) {
		String data = this.licheeZooKeeper.getData(
				PathUtils.join(hostsPath, host, item, "configs"), null);
		return data;
	}
}
