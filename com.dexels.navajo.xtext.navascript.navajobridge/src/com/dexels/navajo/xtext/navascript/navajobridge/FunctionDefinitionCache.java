package com.dexels.navajo.xtext.navascript.navajobridge;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FunctionDefinitionCache {

	static FunctionDefinitionCache instance = new FunctionDefinitionCache();

	Map<String, ProxyFunctionDefinition> cache = new TreeMap<>();


	public static FunctionDefinitionCache getInstance() {
		return instance;
	}

	public void addFunctionDefinition(String name, ProxyFunctionDefinition fd) {
		//System.err.println(">>>> adding function " + name + ": " + fd);
		cache.put(name, fd);
	}

	public ProxyFunctionDefinition getFunction(String s) {
		return cache.get(s);
	}
	
	public Set<String> getFunctions() {
		return cache.keySet();
	}
}
