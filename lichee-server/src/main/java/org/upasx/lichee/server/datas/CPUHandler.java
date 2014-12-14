/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.datas;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upasx.lichee.model.AlarmEntity;
import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.server.datas.model.CpuData;
import org.upasx.lichee.server.event.EventManager;
import org.upasx.lichee.server.strategy.IStrategy;
import org.upasx.lichee.server.strategy.StrategyFactory;
import org.upasx.lichee.server.strategy.StrategyType;

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
	
	private String IDLE_NAME = "idle";
	
	@Override
	public void handle(MonitorItemConfig config, String data) {
		CpuData cpuData = new Gson().fromJson(data, CpuData.class);
			
		double cpuIdle = cpuData.idle;
		Map<String, List<AlarmEntity>> properties = config.properties;
		if (properties != null) {
			List<AlarmEntity> entities = properties.get(IDLE_NAME);
			if (entities != null && entities.size() > 0) {
				IStrategy strategy = null;
				for (AlarmEntity entity : entities) {
					if (StrategyType.MIN_VALUE.equals(entity.name)) {
						strategy = StrategyFactory.createStrategy(StrategyType.MIN_VALUE);
						strategy.process("cpu", IDLE_NAME, entity.value, Double.toString(cpuIdle));
					}
				}
			}
		}
		
		// fire event to notify listeners
		/*if (alarm) {
			IEvent event = new CPUEvent();
			event.addParam(key, value);
			eventManager.fireEvent(event);
		}*/
	}

}
