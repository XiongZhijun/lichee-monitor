package org.upasx.lichee.server.event;

import org.upasx.lichee.event.IEvent;

public class MemoryEvent extends EventBase {

	@Override
	public String getEventCode() {
		return IEvent.EVENT_MEMORY_ALARM;
	}

}
