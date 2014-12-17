package org.upasx.lichee.server.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.upasx.lichee.event.IEvent;
import org.upasx.lichee.event.IEventListener;
import org.upasx.lichee.server.event.listener.CPUAlarmListener;
import org.upasx.lichee.server.event.listener.MemoryAlarmListener;

/**
 * 
 * @author Rick Liu 2014年11月30日
 *
 */
@Component("event.manager")
public class EventManager {
	
	private Map<String, List<IEventListener>> listenerMap = new HashMap<String, List<IEventListener>>();
	
	@PostConstruct
	public void initListeners() {
		List<IEventListener> cpuListeners = new ArrayList<IEventListener>();
		cpuListeners.add(new CPUAlarmListener());
		listenerMap.put(IEvent.EVENT_CPU_ALARM, cpuListeners);
		
		List<IEventListener> memoryListeners = new ArrayList<IEventListener>();
		memoryListeners.add(new MemoryAlarmListener());
		listenerMap.put(IEvent.EVENT_MEMORY_ALARM, memoryListeners);
	}
	
	public void registerListener(String eventCode, IEventListener listener) {
		List<IEventListener> listeners = this.listenerMap.get(eventCode);
		if (listeners == null) {
			listeners = new ArrayList<IEventListener>();
		}
		listeners.add(listener);
		listenerMap.put(eventCode, listeners);
	}
	
	public void fireEvent(IEvent event) {
		List<IEventListener> listeners = listenerMap.get(event.getEventCode());
		for (IEventListener listener : listeners) {
			listener.handleEvent(event);
		}
		
	}
	
	
}
