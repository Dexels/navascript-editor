package com.dexels.navajo.xtext.navascript.navajobridge.stub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;

import com.dexels.navajo.expression.api.FunctionDefinition;
import com.dexels.navajo.mapping.compiler.meta.MapDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.AdapterClassDefinition;
import com.dexels.navajo.xtext.navascript.navajobridge.AdapterInterrogator;

public class NavajoProxyStub implements EventHandler {

	private EventAdmin myEventAdmin;

	private Map<String, AdapterClassDefinition> adapters = new TreeMap<>();
	private Map<String, FunctionDefinition> functions = new TreeMap<>();

	public void init(MapDefinitionInterrogatorImpl mdii) throws Exception {

		List<MapDefinition> allAdapters = mdii.getAdapters();
		functions = mdii.getFunctions();

		for ( MapDefinition md : allAdapters ) {
			if ( md.objectName != null && !"".equals(md.objectName)) {
				try {
					adapters.put(md.tagName, new AdapterClassDefinition(md));
				} catch (Exception e) {
					System.err.println("Could not add " + md.tagName + ": " + e.getLocalizedMessage());
				}
			}
		}

	}

	public void activate() {
		System.err.println("In NavajoProxyStub.activate()");
		try {
			MapDefinitionInterrogatorImpl mdii = new MapDefinitionInterrogatorImpl();
			init(mdii);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public void deactivate() {
		System.err.println("In NavajoProxyStub.deactivate()");
	}

	private void sendResponse() {
		Map<String,Object> map = new HashMap<>();
		map.put("adapters", adapters);
		map.put("functions", functions);
		Event e = new Event(AdapterInterrogator.ADAPTER_OVERVIEW, map);
		myEventAdmin.postEvent(e);
	}

	public void setEventAdmin(EventAdmin e) {
		myEventAdmin = e;
	}

	public void clearEventAdmin(EventAdmin e) {
		System.err.println("In NavajoProxyStub.clearEventAdmin()");
	}


	@Override
	public void handleEvent(Event event) {
		System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> Received event: " + event);
		sendResponse();
	}
	

}
