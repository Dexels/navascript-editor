package com.dexels.navajo.xtext.navascript.navajobridge;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ProxyMethodDefinition {

	private Object realObject;
	private Class<?> realClass;

	private Set<String> parameters = new TreeSet<>();
	private Map<String,ProxyParameterDefinition> parameterDefinitions = new TreeMap<>();
	
	public String name;
	

	public ProxyMethodDefinition(Object real, Class<?> realClass) {
		this.realObject = real;
		this.realClass = realClass;
		init();
	}

	private void init() {
		try {
			Method nMethod = realClass.getDeclaredMethod("getName");
			name = (String) nMethod.invoke(realObject);
			
			Method pMethod = realClass.getDeclaredMethod("getParameters");
			Set<String> pResult = (Set<String>) pMethod.invoke(realObject);
			parameters.addAll(pResult);
			
			Method pdMethod = realClass.getDeclaredMethod("getParameterDefinition", String.class);
			for ( String p : pResult ) {
				Object pdObject = pdMethod.invoke(realObject, p);
				Class<? extends Object> pdClass = pdObject.getClass();
				ProxyParameterDefinition ppd = new ProxyParameterDefinition(pdObject, pdClass);
				parameterDefinitions.put(p, ppd);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	public Set<String> getParameters() {
		return parameters;
	}
	
	public String getName() {
		return name;
	}
	
	public ProxyParameterDefinition getParameterDefinition(String s) {
		return parameterDefinitions.get(s);
	}
}
