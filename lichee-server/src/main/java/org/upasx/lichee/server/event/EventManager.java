package org.upasx.lichee.server.event;

import java.util.List;

import org.upasx.lichee.event.IEvent;
import org.upasx.lichee.event.IEventListener;
import org.upasx.lichee.event.IEventSource;

/**
 * 
 * @author Rick Liu 2014年11月30日
 *
 */
public class EventManager {

	public static EventManager INSTANCE = new EventManager();
	
	private EventManager() {}
	
	public static void registerListener(IEventSource source, IEventListener listener) {
		source.addListener(listener);
	}
	
	public static void notifyListener(IEventListener listener, IEvent event) {
		listener.handleEvent(event);
	}
	
	public static void notifyListeners(List<IEventListener> listeners, IEvent event) {
		for (IEventListener listener : listeners) {
			listener.handleEvent(event);
		}
	}
	
	
}
