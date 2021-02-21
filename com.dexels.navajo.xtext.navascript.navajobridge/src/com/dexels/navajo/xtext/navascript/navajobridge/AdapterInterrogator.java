package com.dexels.navajo.xtext.navascript.navajobridge;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventHandler;

import com.dexels.navajo.expression.api.FunctionDefinition;
import com.dexels.navajo.mapping.compiler.meta.KeywordException;
import com.dexels.navajo.mapping.compiler.meta.MapMetaData;

public class AdapterInterrogator implements EventHandler {

	public final static String FETCH_ADAPTERS = "adapter_fetch";
	public final static String ADAPTER_OVERVIEW = "adapter_overview";

	Map<String, AdapterClassDefinition> myAdapters = null;
	Map<String, FunctionDefinition> myFunctions = null;

	private EventAdmin myEventAdmin;

	public void activate() {
		EclipseLogger.log("In AdapterInterrogator.activate()....");
		fetchAdapters();
	}

	public void deactivate() {
		EclipseLogger.log("In AdapterInterrogator.deactivate()....");
	}

	public void setEventAdmin(EventAdmin e) {
		EclipseLogger.log("In AdapterInterrogator.setEventAdmin(): " + e);
		myEventAdmin = e;
	}

	public void clearEventAdmin(EventAdmin e) {
		EclipseLogger.log("In AdapterInterrogator.clearEventAdmin(): " + e);
	}

	private void fetchAdapters() {

		Map<String,String> map = new HashMap<>();
		Event e = new Event(FETCH_ADAPTERS, map);
		myEventAdmin.postEvent(e);

	}

	public AdapterClassDefinition getAdapter(String s) {
		EclipseLogger.log("In getAdapters(" + s + ")");
		if ( myAdapters != null ) {
			return myAdapters.get(s);
		} else {
			return null;
		}
	}

	public FunctionDefinition getFunction(String s) {
		return myFunctions.get(s);
	}

	public String [] getAdapters() {

		EclipseLogger.log("In getAdapters()....");
		System.out.println(">>>>>>>>>>> In get Addapt");

		if ( myAdapters != null ) {

			Set<String> keySet = myAdapters.keySet();
			String [] adapters = new String[keySet.size()];
			adapters = (String []) keySet.toArray(adapters);

			return adapters;
		} else {

			// Alternative.
			try {
				MapMetaData mmd = MapMetaData.getInstance();

				return new String[] {"mmd =" + mmd, "definitions = " + mmd.getMapDefinitions() };
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (KeywordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return new String[]{"Could not call getInstance for MapMetaData"};


		}
	}

	public String [] getFunctions() {

		EclipseLogger.log("In getFunctions()....");

		if ( myFunctions != null ) {

			Set<String> keySet = myFunctions.keySet();
			String [] functions = new String[keySet.size()];
			functions = (String []) keySet.toArray(functions);

			return functions;
		} else {
			return null;
		}
	}


	@Override
	public void handleEvent(Event event) {
		if ( event.getTopic().equals(ADAPTER_OVERVIEW)) {
			myAdapters =  (Map<String, AdapterClassDefinition>) event.getProperty("adapters");
			myFunctions =  (Map<String, FunctionDefinition>) event.getProperty("functions");
		}
	}
}
