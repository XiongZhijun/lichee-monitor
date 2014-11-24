/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.datas;

import java.util.HashMap;
import java.util.Map;

import org.upasx.lichee.model.MonitorItemConfig;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
public class DataHandlerManager {
	private Map<String, DataHandler> dataHandlerMap = new HashMap<String, DataHandler>();

	public DataHandler getDataHandler(MonitorItemConfig config) {
		DataHandler dataHandler = dataHandlerMap.get(config.monitorItemName);
		if (dataHandler == null) {
			return DataHandler.DEFAULT_HANDLER;
		}
		return dataHandler;
	}

	public void setDataHandlerMap(Map<String, DataHandler> dataHandlerMap) {
		this.dataHandlerMap = dataHandlerMap;
	}
}
