package com.dexels.navajo.xtext.navascript.navajobridge;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.dexels.navajo.mapping.compiler.meta.MapDefinition;

public class ProxyMetaData {

	private static ProxyMetaData instance = new ProxyMetaData();

	private Set<String> maps = new TreeSet<>();
	private Map<String, ProxyMapDefinition> mapDefinitions = new TreeMap<>();

	public static ProxyMetaData getInstance() {
		return instance;
	}

	public void addMapDefinition(MapDefinition md, ClassLoader cl) {
		try {
			if ( !mapDefinitions.containsKey(md.tagName)) {
				ProxyMapDefinition pmd = new ProxyMapDefinition(md, md.getClass());
				pmd.setObjectClassLoader(cl);
				mapDefinitions.put(md.tagName, pmd);
				maps.add(md.tagName);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMapMetaData(Object o, Class<?> c) {
		try {			
			Method m = c.getDeclaredMethod("getMapDefinitions");
			Set<String> rMapDefinitions = (Set<String>) m.invoke(o);
			Set<String> newMaps = new TreeSet<String>(rMapDefinitions);
			for ( String s : newMaps ) {
				if ( !mapDefinitions.containsKey(s)) {
					try {
						Method m2 = c.getDeclaredMethod("getMapDefinition", String.class);
						Object rMapDefinition = m2.invoke(o, s);
						Class<? extends Object> cMapDefinition = rMapDefinition.getClass();
						ProxyMapDefinition pmd = new ProxyMapDefinition(rMapDefinition, cMapDefinition);
						mapDefinitions.put(s, pmd);
						//System.err.println("@@@@@@@@@@ Added adapter " + s + " with ProxyMapDefinition: " + pmd);
					} catch (Throwable e) {
						e.printStackTrace(System.err);
						System.err.println("Could not add adapter " + s + ": " + e.getMessage());
					}
				}
			}
			maps.addAll(newMaps);
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
