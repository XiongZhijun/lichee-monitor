package org.upasx.lichee.server.event;

import java.util.HashMap;
import java.util.Map;

import org.upasx.lichee.event.IEvent;

public abstract class EventBase implements IEvent {

	protected Map<String, String> eventParams = new HashMap<String, String>();
	
	@Override
	public abstract String getEventCode();

	@Override
	public Map<String, String> getParameters() {
		return eventParams;
	}
	
	@Override
	public void addParam(String key, String value) {
		eventParams.put(key, value);
	}
}
