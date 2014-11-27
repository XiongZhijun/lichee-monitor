/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import org.upasx.lichee.server.datas.CPUHandler;
import org.upasx.lichee.server.datas.DataHandler;

/**
 * @author Xiong Zhijun
 * @date Nov 27, 2014
 *
 */
@Component("data.handler.map")
public class DataHandlerMapFactoryBean implements
		FactoryBean<Map<String, DataHandler>> {

	@Override
	public Map<String, DataHandler> getObject() throws Exception {
		Map<String, DataHandler> map = new HashMap<String, DataHandler>();
		map.put("cpu", new CPUHandler());
		return map;
	}

	@Override
	public Class<?> getObjectType() {
		return Map.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
