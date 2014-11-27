/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.zookeeper;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.upasx.lichee.utils.PathUtils;

/**
 * @author Xiong Zhijun
 * @date Nov 26, 2014
 *
 */
@Component("hosts.path")
public class HostsPathFactoryBean implements FactoryBean<String> {

	@Value("${zookeeper.base.path}")
	private String basePath;

	@Override
	public String getObject() throws Exception {
		basePath = StringUtils.isBlank(basePath) ? "/lichee-monitor" : basePath;
		return PathUtils.join(basePath, "hosts");
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
