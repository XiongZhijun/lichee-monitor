/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.datas;

import org.upasx.lichee.model.MonitorItemConfig;

/**
 * @author Xiong Zhijun
 * @date Nov 24, 2014
 *
 */
public interface DataHandler {

	void handle(MonitorItemConfig config, String data);

	DataHandler DEFAULT_HANDLER = new DataHandler() {
		public void handle(MonitorItemConfig config, String data) {
		}
	};
}
