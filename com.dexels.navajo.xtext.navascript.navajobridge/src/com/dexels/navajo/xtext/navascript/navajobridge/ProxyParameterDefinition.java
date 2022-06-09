package com.dexels.navajo.xtext.navascript.navajobridge;

public class ProxyParameterDefinition extends ProxyValueDefinition {

	private String field;

	public ProxyParameterDefinition(Object real, Class<?> realClass) {
		super(real, realClass);
		init();
	}

	private void init() {
		try {
			field = getGetter("getField");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	public String getField() {
		return field;
	}



}
