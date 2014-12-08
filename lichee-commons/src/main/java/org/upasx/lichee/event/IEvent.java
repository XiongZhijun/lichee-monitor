package org.upasx.lichee.event;

import java.util.Map;

/**
 * 
 * @author Rick Liu 2014��11��30��
 *
 */
public interface IEvent {

	public static final String EVENT_CPU_ALARM = "cpu_alarm";
	public static final String EVENT_MEMORY_ALARM = "memory_alarm";
	public static final String EVENT_DISK_ALARM = "disk_alarm";
	
	public String getEventCode();
	
	public Map<String, String> getParameters();
	
	public void addParam(String key, String value);
}
