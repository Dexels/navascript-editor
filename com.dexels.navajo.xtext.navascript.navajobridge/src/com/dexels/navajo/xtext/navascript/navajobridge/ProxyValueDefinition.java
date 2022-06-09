package com.dexels.navajo.xtext.navascript.navajobridge;

import java.lang.reflect.Method;

public class ProxyValueDefinition {

	private Object realObject;
	private Class<?> realClass;

	private String direction;
	private String map;
	private String mapType;
	private String name;
	private String required;
	private String value;

	public ProxyValueDefinition(Object real, Class<?> realClass) {
		this.realObject = real;
		this.realClass = realClass;
		init();
	}

	protected String getGetter(String method) {
		try {
			Method dMethod = realClass.getMethod(method);
			String result = (String) dMethod.invoke(realObject);
			return result;
		} catch (Exception e) {
			System.err.println("Could not getGetter(" + method + "): " + e);
			return null;
		}
	}

	private void init() {
		direction = getGetter("getDirection");
		map = getGetter("getMap");
		mapType = getGetter("getMapType");
		name = getGetter("getName");
		required = getGetter("getRequired");
		value = getGetter("getValue");
	}

	public String getDirection() {
		return direction;
	}

	public String getMap() {
		return map;
	}

	public String getMapType() {
		return mapType;
	}

	public String getName() {
		return name;
	}

	public String getRequired() {
		return required;
	}

	public String getValue() {
		return value;
	}


}
