/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.client.helper;

import org.junit.Test;
import org.upasx.lichee.model.MonitorItemConfigList;

/**
 * @author Xiong Zhijun
 * @date Nov 18, 2014
 */
public class ConfigHelperTest {

	@Test
	public void test() {
		MonitorItemConfigList configHelper = MonitorItemConfigList
				.createByClassPathFile();

		System.out.println(configHelper);
	}

}
