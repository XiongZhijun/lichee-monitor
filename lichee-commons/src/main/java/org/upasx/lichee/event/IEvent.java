package org.upasx.lichee.event;

/**
 * 
 * @author Rick Liu 2014Äê11ÔÂ30ÈÕ
 *
 */
public interface IEvent {

	public static final String EVENT_CPU_ALARM = "cpu_alarm";
	public static final String EVENT_MEMORY_ALARM = "memory_alarm";
	
	public Object getSource();
	
	public String getEventCode();
}
