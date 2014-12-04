/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.server.datas;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.stereotype.Component;
import org.upasx.lichee.model.MonitorItemConfig;
import org.upasx.lichee.server.datas.model.DiskData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Xiong Zhijun
 * @date Dec 4, 2014
 *
 */
@Component("disk")
public class DiskDataHandler implements DataHandler {

	@Override
	public void handle(MonitorItemConfig config, String data) {
		Type type = new TypeToken<List<DiskData>>() {
		}.getType();
		List<DiskData> disks = new Gson().fromJson(data, type);
		System.out.println(disks.get(0).percent);
	}

}
