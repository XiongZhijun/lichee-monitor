/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.helper;

import org.junit.Test;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public class ConfigHelperTest {

	@Test
	public void test() {
		MonitorItemConfigList configHelper = new MonitorItemConfigList("configs.json");

		System.out.println(configHelper.getConfigs());
	}

}
