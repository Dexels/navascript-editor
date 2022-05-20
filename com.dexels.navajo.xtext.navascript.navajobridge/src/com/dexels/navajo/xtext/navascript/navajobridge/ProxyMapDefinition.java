package com.dexels.navajo.xtext.navascript.navajobridge;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.dexels.navajo.mapping.compiler.meta.MapDefinition;

public class ProxyMapDefinition {

	private Set<String> methods = new TreeSet<>();
	private Set<String> values = new TreeSet<>();

	private Map<String, ProxyMethodDefinition> methodDefinitions = new TreeMap<>();
	private Map<String, ProxyValueDefinition> valueDefinitions = new TreeMap<>();

	public Object mapDefinition;
	public Class mapDefinitionClass;
	public Class objectClass;
	public String objectName;
	public String description;
	public String tagName;
	public boolean abstractMap;
	public ClassLoader objectClassLoader;

	
	public void setObjectClassLoader(ClassLoader objectClassLoader) {
		this.objectClassLoader = objectClassLoader;
	}

	public ProxyMapDefinition() {
		// Empty proxymapdefinition.
	}
	
	public ProxyMapDefinition(Object actual, Class mapDefinitionClass) throws InstantiationException {
		mapDefinition = actual;
		this.mapDefinitionClass = mapDefinitionClass;
		init();
	}

	private Object getSetter(String fieldName) {
		try {
			Field f_objectName  = mapDefinitionClass.getDeclaredField(fieldName);
			return f_objectName.get(mapDefinition);
		} catch (Exception e) {
			System.err.println("Could not set " + fieldName + ": " + e);
			return null;
		}
	}

	private void init() throws InstantiationException {

		try {
			Method mMethod = mapDefinitionClass.getDeclaredMethod("getMethodDefinitions");
			Set<String> mResult = (Set<String>) mMethod.invoke(mapDefinition);
			methods.addAll(mResult);
		} catch (Exception e) {
			System.err.println("Could not call getMethoDefinitions: " + e);
		}

		// Loop over all methods
		try {
			Method mdMethod = mapDefinitionClass.getDeclaredMethod("getMethodDefinition", String.class);
			for ( String mString : methods ) {
				try {
					Object mdObject = mdMethod.invoke(mapDefinition, mString);
					Class mdClass = mdObject.getClass();
					ProxyMethodDefinition pmd = new ProxyMethodDefinition(mdObject, mdClass);
					methodDefinitions.put(mString, pmd);
					//System.err.println("&&&&& added method " + mString + ": " + pmd);
				} catch (Exception e) {
					System.err.println("Could not call getMethodDefinition(" + mString + "): " + e);
				}
			}
		} catch (Exception e) {
			System.err.println("Could not find getMethodDefinition: " + e);
		}

		try {
			Method vMethod = mapDefinitionClass.getDeclaredMethod("getValueDefinitions");
			Set<String> vResult = (Set<String>) vMethod.invoke(mapDefinition);
			values.addAll(vResult);
		} catch (Exception e) {
			System.err.println("Could not call getValueDefinitions: " + e);
		}
		// Loop over all values

		try {
			Method vdMethod = mapDefinitionClass.getDeclaredMethod("getValueDefinition", String.class);
			for ( String vString : values ) {
				try {

					Object vdObject = vdMethod.invoke(mapDefinition, vString);
					Class mdClass = vdObject.getClass();
					ProxyValueDefinition pvd = new ProxyValueDefinition(vdObject, mdClass);
					valueDefinitions.put(vString, pvd);
				} catch (Exception e) {
					System.err.println("Could not call getValueDefinition(" + vString + "): " + e);
				}
			}
		} catch (Exception e) {
			System.err.println("Could not find getValueDefinition: " + e);
		}

		objectName = (String) getSetter("objectName");
		description = (String) getSetter("description");
		tagName = (String) getSetter("tagName");
		abstractMap = (Boolean) getSetter("abstractMap");

		try {
			//ClassLoader currentCL = Thread.currentThread().getContextClassLoader();
			//Thread.currentThread().setContextClassLoader(mapDefinitionClass.getClassLoader());
			if( objectClassLoader != null ) {
				objectClass = Class.forName(objectName, true, objectClassLoader);
			} else {
				objectClass = Class.forName(objectName, true, mapDefinitionClass.getClassLoader());
			}
			//Thread.currentThread().setContextClassLoader(currentCL);
		} catch (Throwable t) {
			System.err.println("Could not instantiate class: " + objectName + ": " + t.getMessage());
		}
		//System.err.println(">>>>>>>>>>>>>>" + tagName + " has object " + objectClass);

	}

	public ProxyMethodDefinition getMethodDefinition(String s) {
		return methodDefinitions.get(s);
	}

	public ProxyValueDefinition getValueDefinition(String s) {
		return valueDefinitions.get(s);
	}

	public Set<String> getMethodDefinitions() {
		return methods;
	}

	public Set<String> getValueDefinitions() {
		return values;
	}

}
