/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.datas;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upasx.lichee.model.MonitorItemConfig;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
@Component
public class DataHandlerManager {
	@Autowired
	private Map<String, DataHandler> dataHandlerMap;

	public DataHandler getDataHandler(MonitorItemConfig config) {
		DataHandler dataHandler = dataHandlerMap.get(config.monitorType);
		if (dataHandler == null) {
			return DataHandler.DEFAULT_HANDLER;
		}
		return dataHandler;
	}

	public void setDataHandlerMap(Map<String, DataHandler> dataHandlerMap) {
		this.dataHandlerMap = dataHandlerMap;
	}
}
