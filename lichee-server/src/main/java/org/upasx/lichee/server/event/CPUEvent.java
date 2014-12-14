package org.upasx.lichee.server.event;

import org.upasx.lichee.event.IEvent;

/**
 * 
 * @author Rick Liu 2014年12月8日
 *
 */
public class CPUEvent extends EventBase {

	@Override
	public String getEventCode() {
		return IEvent.EVENT_CPU_ALARM;
	}

}
