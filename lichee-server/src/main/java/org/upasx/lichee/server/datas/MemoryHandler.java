/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.datas;

import org.springframework.stereotype.Component;
import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.server.datas.model.MemoryData;

import com.google.gson.Gson;

/**
 * @author Xiong Zhijun
 * @date Dec 4, 2014
 *
 */
@Component("memory")
public class MemoryHandler implements DataHandler {

	@Override
	public void handle(MonitorItemConfig config, String data) {
		MemoryData memoryData = new Gson().fromJson(data, MemoryData.class);
		System.out.println(memoryData.percent);
	}

}
