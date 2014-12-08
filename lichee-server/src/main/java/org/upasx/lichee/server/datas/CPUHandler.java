/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.datas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upasx.lichee.event.IEvent;
import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.server.datas.model.CpuData;
import org.upasx.lichee.server.event.CPUEvent;
import org.upasx.lichee.server.event.EventManager;

import com.google.gson.Gson;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
@Component("cpu")
public class CPUHandler implements DataHandler {

	@Autowired
	private EventManager eventManager;
	
	@Override
	public void handle(MonitorItemConfig config, String data) {
		CpuData cpuData = new Gson().fromJson(data, CpuData.class);
		System.out.println(cpuData.idle);
		
		// fire event to notify listeners
		/*if (alarm) {
			IEvent event = new CPUEvent();
			event.addParam(key, value);
			eventManager.fireEvent(event);
		}*/
	}

}
