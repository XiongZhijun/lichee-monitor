package org.upasx.lichee.model;

import com.google.gson.Gson;

/**
 * 
 * @author Andy
 *
 */
public class AlarmEntity {
	
	public String name;
	public String value;
	
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public static AlarmEntity fromString(String json) {
		return new Gson().fromJson(json, AlarmEntity.class);
	}
	
}
