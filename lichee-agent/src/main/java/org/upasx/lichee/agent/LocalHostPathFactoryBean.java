/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.agent;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.upasx.lichee.utils.EnvironmentUtils;
import org.upasx.lichee.utils.PathUtils;

/**
 * @author Xiong Zhijun
 * @date Nov 27, 2014
 *
 */
@Component("local.host.path")
public class LocalHostPathFactoryBean implements FactoryBean<String> {

	@Autowired
	@Qualifier("hosts.path")
	private String hostsPath;
	@Value("${lichee.host.name}")
	private String localHostName;

	@Override
	public String getObject() throws Exception {
		if (StringUtils.isBlank(localHostName)) {
			localHostName = EnvironmentUtils.getLocalHostName();
		}
		return PathUtils.join(this.hostsPath, localHostName);
	}

	@Override
	public Class<?> getObjectType() {
		return String.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
