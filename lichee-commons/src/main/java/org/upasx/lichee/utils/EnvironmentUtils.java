/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.utils;

import org.apache.commons.lang.StringUtils;

/**
 * @author Xiong Zhijun
 * @date Nov 21, 2014
 */
public class EnvironmentUtils {

	public static String getLocalHostName() {
		String hostName = System.getenv("local.host.name");
		if (StringUtils.isBlank(hostName)) {
			hostName = System.getProperty("local.host.name");
		}
		if (StringUtils.isBlank(hostName)) {
			hostName = HostUtils.getHostName();
		}
		if (StringUtils.isBlank(hostName)) {
			hostName = HostUtils.getHostAddress();
		}
		return hostName;
	}
}
