package com.dexels.navajo.xtext.navascript.navajobridge;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.framework.Bundle;

import com.dexels.navajo.document.NavajoFactory;
import com.dexels.navajo.document.Property;
import com.dexels.navajo.mapping.compiler.meta.MapDefinition;
import com.dexels.navajo.mapping.compiler.meta.MethodDefinition;
import com.dexels.navajo.mapping.compiler.meta.ParameterDefinition;
import com.dexels.navajo.mapping.compiler.meta.ValueDefinition;

public class AdapterClassDefinition  {

	private ProxyMapDefinition myDefinition;
	private Class classDefinition;
	private ClassLoader classLoader;

	public AdapterClassDefinition(ProxyMapDefinition m, ClassLoader cl) throws Exception {
		myDefinition = m;
		try {
			classLoader = cl;
			if ( cl != null ) {
				classDefinition = Class.forName(m.objectName, true, classLoader);
			}
		} catch (Throwable e) {
			System.err.println("Could not find class for adapter: " + m.tagName + " (" + e.getLocalizedMessage() + ")");
		}
	}

	public AdapterClassDefinition(Class m, ClassLoader cl) throws Exception {
		classLoader = cl;
		classDefinition = m;
	}

	public ProxyMapDefinition getMapDefinition() {
		return myDefinition;
	}

	private boolean checkClassDefinition() {
		if ( classDefinition == null ) {
			return false;
		}
		return true;
	}

	public String getObjectName() {
		if ( myDefinition != null ) {
			return myDefinition.objectName;
		} else {
			return null;
		}
	}
	public List<ProxyValueDefinition> getDeclaredValues() {

		List<ProxyValueDefinition> valuesDefinitions = new ArrayList<>();

		Set<String> values = myDefinition.getValueDefinitions();
		for ( String v : values ) {
			ProxyValueDefinition vd = myDefinition.getValueDefinition(v);
			valuesDefinitions.add(vd);
		}

		return valuesDefinitions;
	}

	public ProxyValueDefinition getDeclaredValue(String name) {

		return myDefinition.getValueDefinition(name);
	}

	public Set<ProxyMethodDefinition> getMethods() {
		if ( myDefinition != null ) {
			Set<ProxyMethodDefinition> methods = new HashSet<>();
			for ( String m : myDefinition.getMethodDefinitions() ) {
				ProxyMethodDefinition md = myDefinition.getMethodDefinition(m);
				methods.add(md);
			}
			return methods;
		}
		return null;
	}

	private String getType(Type type) throws Exception {

		if ( type.getTypeName().equals("int") || type.getTypeName().equals("java.lang.Integer") ) {
			return Property.INTEGER_PROPERTY;
		}
		if ( type.getTypeName().equals("double") || type.getTypeName().equals("float") || type.getTypeName().equals("java.lang.Double")  || type.getTypeName().equals("java.lang.Float") ) {
			return Property.FLOAT_PROPERTY;
		}
		if ( type.getTypeName().equals("boolean")|| type.getTypeName().equals("java.lang.Boolean") ) {
			return Property.BOOLEAN_PROPERTY;
		}

		if ( type.getTypeName().indexOf(".") != -1 && classLoader != null) { // object
			return getType(Class.forName(type.getTypeName(), true, classLoader));
		}

		return type.getTypeName();
	}

	private String getType(Class c) throws Exception {
		Property p = NavajoFactory.getInstance().createProperty(NavajoFactory.getInstance().createNavajo(), "aap", "", "", "");
		Object object = c.getDeclaredConstructor().newInstance();
		p.setAnyValue(object);
		return p.getType();
	}

	public String getType(String field) throws Exception {
		if ( !checkClassDefinition()) {
			return null;
		}
		Field f = classDefinition.getDeclaredField(field);
		if ( !f.getType().isPrimitive() ) {
			return getType(f.getType());
		} else {
			return getType(f.getGenericType());
		}
	}

	public AdapterClassDefinition getAdapterClass(String field) throws Exception {
		if ( !checkClassDefinition()) {
			return null;
		}
		Field f = classDefinition.getDeclaredField(field);
		if ( f.getType().isPrimitive()) {
			throw new Exception("Cannot create AdapterClassDefinition for primitive type");
		}
		if ( classLoader != null ) {
			return new AdapterClassDefinition(f.getType(), classLoader);
		} else {
			return null;
		}
	}

	public boolean isSetter(String field)  {

		if ( !checkClassDefinition()) {
			return getSetters().contains(field);
		}

		String method = "set" + (field.charAt(0)+"").toUpperCase() + field.substring(1);
		try {
			Field f = classDefinition.getDeclaredField(field);
			Method m = classDefinition.getMethod(method, f.getType());
			if ( m != null ) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			return false;
		}
		return false;
	}


	public boolean isGetter(String field)  {

		if ( !checkClassDefinition()) {
			return getGetters().contains(field);
		}

		String method = "get" + (field.charAt(0)+"").toUpperCase() + field.substring(1);
		try {
			Method m = classDefinition.getMethod(method);
			if ( m != null ) {
				return true;
			} 
		} catch (Exception e) {
		}
		try {
			Method [] methods = classDefinition.getMethods();
			for ( Method met : methods ) {
				if ( met.getName().equals(method)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			return false;
		}
		return false;
	}

	public Set<String> getGetters() { // Use definition not object.

		if ( !checkClassDefinition()) { 
			Set<String> result = new HashSet<>();
			Set<String> values = myDefinition.getValueDefinitions();
			for ( String v : values ) {
				ProxyValueDefinition vd = myDefinition.getValueDefinition(v);
				if ( "out".equals(vd.getDirection()) ){
					result.add(v);
				}
			}
			return result;
		}

		Set<String> set = new HashSet<>();

		Method [] methods = classDefinition.getMethods();
		for ( Method m : methods ) {
			if ( m.getName().startsWith("get")) {
				String name = m.getName().substring(3);
				name = (name.charAt(0)+"").toLowerCase() + name.substring(1);
				set.add(name);
			}
		}
		return set;
	}

	public Set<String> getSetters() {

		if ( !checkClassDefinition()) { // Use definition not object.
			Set<String> result = new HashSet<>();
			Set<String> values = myDefinition.getValueDefinitions();
			for ( String v : values ) {
				ProxyValueDefinition vd = myDefinition.getValueDefinition(v);
				if ( "in".equals(vd.getDirection()) ){
					result.add(v);
				}
			}
			return result;
		}

		Set<String> set = new HashSet<>();

		Method [] methods = classDefinition.getMethods();
		for ( Method m : methods ) {
			if ( m.getName().startsWith("set")) {
				String name = m.getName().substring(3);
				name = (name.charAt(0)+"").toLowerCase() + name.substring(1);
				set.add(name);
			}
		}
		return set;
	}

	public Set<String> missingRequiredParameters(String method, List<String> arguments) {

		Set<String> missing = new HashSet<>();

		if ( myDefinition.getMethodDefinition(method) == null ) {
			return missing;
		}

		Set<String> definedParameters = myDefinition.getMethodDefinition(method).getParameters();

		// Check for required
		for ( String dp : definedParameters ) {
			ProxyParameterDefinition pd = myDefinition.getMethodDefinition(method).getParameterDefinition(dp);
			if ( "true".equals(pd.getRequired()) && !arguments.contains(dp) ) {
				missing.add(dp);
			}
		}

		return missing;
	}

	public Set<String> unknownParameters(String method, List<String> arguments) {

		Set<String> missing = new HashSet<>();

		if ( myDefinition.getMethodDefinition(method) == null ) {
			return missing;
		}

		Set<String> definedParameters = myDefinition.getMethodDefinition(method).getParameters();

		// Check for unknown parameters
		for (String a : arguments ) {
			if ( a != null ) {
				if ( !definedParameters.contains(a)) {
					missing.add(a);
				}
			}
		}
		return missing;
	}

	public List<List<String>> getGetterTypeSignatures(String field) {

		if ( !checkClassDefinition()) {
			return null;
		}

		String method = "get" + (field.charAt(0)+"").toUpperCase() + field.substring(1);
		List<List<String>> signatures = new ArrayList<>();
		try {
			Method [] methods = classDefinition.getMethods();
			for ( Method met : methods ) {
				List<String> parameters = new ArrayList<>();
				if ( met.getName().equals(method)) {
					Type [] methodParameters = met.getGenericParameterTypes();
					for ( Type t : methodParameters ) {
						String propertyType = getType(t);
						parameters.add(propertyType);
					}
					signatures.add(parameters);
				}
			}
			return signatures;
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return signatures;
		}
	}

	private void printSignature(String field) {
		List<List<String>> signatures  = getGetterTypeSignatures(field);
		System.err.println(field + ": " + signatures);
	}

}
