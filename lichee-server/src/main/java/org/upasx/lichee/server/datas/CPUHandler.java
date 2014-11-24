/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.datas;

import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.server.datas.model.CpuData;

import com.google.gson.Gson;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
public class CPUHandler implements DataHandler {

	@Override
	public void handle(MonitorItemConfig config, String data) {
		CpuData cpuData = new Gson().fromJson(data, CpuData.class);
		System.out.println(cpuData.idle);
	}

}
