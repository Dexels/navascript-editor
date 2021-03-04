package com.dexels.navajo.xtext.navascript.navajobridge;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProxyMetaData {

	private static ProxyMetaData instance = new ProxyMetaData();

	private Set<String> maps = new TreeSet<>();
	private Map<String, ProxyMapDefinition> mapDefinitions = new TreeMap<>();

	public static ProxyMetaData getInstance() {
		return instance;
	}

	public void addMapMetaData(Object o, Class c) {
		try {			
			Method m = c.getDeclaredMethod("getMapDefinitions");
			Set<String> rMapDefinitions = (Set<String>) m.invoke(o);
			maps = new TreeSet(rMapDefinitions);
			for ( String s : maps ) {
				if ( !mapDefinitions.containsKey(s)) {
					try {
						Method m2 = c.getDeclaredMethod("getMapDefinition", String.class);
						Object rMapDefinition = m2.invoke(o, s);
						Class cMapDefinition = rMapDefinition.getClass();
						ProxyMapDefinition pmd = new ProxyMapDefinition(rMapDefinition, cMapDefinition);
						mapDefinitions.put(s, pmd);
						System.err.println("@@@@@@@@@@ Added adapter " + s + " with ProxyMapDefinition: " + pmd);
					} catch (Throwable e) {
						e.printStackTrace(System.err);
						System.err.println("Could not add adapter " + s + ": " + e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public Set<String> getMapDefinitions() {
		return maps;
	}

	public ProxyMapDefinition getMapDefinition(String s) {
		return mapDefinitions.get(s);
	}
}
