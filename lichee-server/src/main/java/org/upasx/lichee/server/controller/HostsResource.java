/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
