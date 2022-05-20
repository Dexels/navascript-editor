package com.dexels.navajo.xtext.navascript.navajobridge;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.dexels.navajo.document.NavajoFactory;
import com.dexels.navajo.document.Property;

public class AdapterClassDefinition  {

	private ProxyMapDefinition myDefinition;
	private Class classDefinition;
	private ClassLoader classLoader;
	private Map<String,String> setterTypes = new HashMap<>();
	private Set<String> setters = new HashSet<>();
	private Set<String> getters = new HashSet<>();
	private Map<String,String> getterTypes = new HashMap<>();

	private static final Set<Class<?>> WRAPPER_TYPE_MAP;
	static {
		WRAPPER_TYPE_MAP = new HashSet<Class<?>>();
		WRAPPER_TYPE_MAP.add(Integer.class);
		WRAPPER_TYPE_MAP.add(Byte.class);
		WRAPPER_TYPE_MAP.add(Character.class);
		WRAPPER_TYPE_MAP.add(Boolean.class);
		WRAPPER_TYPE_MAP.add(Double.class);
		WRAPPER_TYPE_MAP.add(Float.class);
		WRAPPER_TYPE_MAP.add(Long.class);
		WRAPPER_TYPE_MAP.add(Short.class);
		WRAPPER_TYPE_MAP.add(Void.class);
		WRAPPER_TYPE_MAP.add(int.class);
		WRAPPER_TYPE_MAP.add(byte.class);
		WRAPPER_TYPE_MAP.add(char.class);
		WRAPPER_TYPE_MAP.add(boolean.class);
		WRAPPER_TYPE_MAP.add(double.class);
		WRAPPER_TYPE_MAP.add(float.class);
		WRAPPER_TYPE_MAP.add(long.class);
		WRAPPER_TYPE_MAP.add(short.class);
		WRAPPER_TYPE_MAP.add(void.class);
		WRAPPER_TYPE_MAP.add(String.class);
	}
	
	private static final Set<String> PRIMITIVE_TYPES;
	static {
		PRIMITIVE_TYPES = new HashSet<>();
		PRIMITIVE_TYPES.add(Property.STRING_PROPERTY);
		PRIMITIVE_TYPES.add(Property.BINARY_PROPERTY);
		PRIMITIVE_TYPES.add(Property.BOOLEAN_PROPERTY);
		PRIMITIVE_TYPES.add(Property.INTEGER_PROPERTY);
		PRIMITIVE_TYPES.add(Property.FLOAT_PROPERTY);
		PRIMITIVE_TYPES.add(Property.DATE_PROPERTY);
		PRIMITIVE_TYPES.add(Property.CLOCKTIME_PROPERTY);
		PRIMITIVE_TYPES.add(Property.MONEY_PROPERTY);
		PRIMITIVE_TYPES.add(Property.PERCENTAGE_PROPERTY);
		PRIMITIVE_TYPES.add(Property.MEMO_PROPERTY);
	}

	private static final Set<String> EXCLUDED_METHODS;
	static {
		EXCLUDED_METHODS = new HashSet<>();
		EXCLUDED_METHODS.add("wait");
		EXCLUDED_METHODS.add("equals");
		EXCLUDED_METHODS.add("load");
		EXCLUDED_METHODS.add("store");
		EXCLUDED_METHODS.add("kill");
		EXCLUDED_METHODS.add("getClass");
	}

	private static final Logger logger = Logger.getLogger(AdapterClassDefinition.class);

	public static boolean isPrimitiveType(Class source) {
		return WRAPPER_TYPE_MAP.contains(source);
	}

	public AdapterClassDefinition(ProxyMapDefinition m, ClassLoader cl) throws Exception {
		myDefinition = m;
		try {
			classLoader = cl;
			if ( cl != null ) {
				classDefinition = Class.forName(m.objectName, true, classLoader);
			}
		} catch (Throwable e) {
			logger.warn("Could not find class for adapter: " + m.tagName + " (" + e.getLocalizedMessage() + ")");
		}
	}

	public AdapterClassDefinition(Class m, ClassLoader cl) throws Exception {
		classLoader = cl;
		classDefinition = m;
		myDefinition = new ProxyMapDefinition();
	}

	private final String constructGetMethod(String name) {

		StringBuilder methodNameBuffer = new StringBuilder();
		methodNameBuffer.append("get")
		.append((name.charAt(0) + "").toUpperCase())
		.append(name.substring(1, name.length()));

		return methodNameBuffer.toString();
	}

	public AdapterClassDefinition getMappedFieldType(String name, Class<?>...parameterTypes) throws Exception {


		Class returntype = null;
		try {
			String getMethod = constructGetMethod(name);
			Method method = classDefinition.getMethod(getMethod, parameterTypes);
			returntype =  method.getReturnType();
			if ( returntype.isArray() ) {
				returntype = returntype.getComponentType();
			} else if ( isIterableClass(returntype) ) {
				ParameterizedType pt = (ParameterizedType) method.getGenericReturnType();
				returntype = (Class) pt.getActualTypeArguments()[0];
			}
		} catch (Exception e) {
			try {
				// finally try setting field directly
				Field field = classDefinition.getField(name);
				returntype = field.getType();
				if ( returntype.isArray() ) {
					returntype = returntype.getComponentType();
				} else if ( isIterableClass(returntype) ) {
					ParameterizedType pt = (ParameterizedType) classDefinition.getField(name).getGenericType();
					returntype = (Class) pt.getActualTypeArguments()[0];
				}
			} catch (Exception e2 ) {
				throw new Exception("Could not find field: " + name);
			}
		}

		if ( isPrimitiveType(returntype) ) {
			throw new Exception("Cannot map field with type: " + returntype);
		}

		AdapterClassDefinition acd = new AdapterClassDefinition(returntype, this.classLoader);
		//nps.addAdapter(fullyQualifiedName, acd);

		return acd;

	}

	private static boolean isIterableClass(Class<?> clazz) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		computeClassHierarchy( clazz, classes );
		return classes.contains( Iterable.class );
	}

	private static void computeClassHierarchy(Class<?> clazz, List<Class<?>> classes) {
		for ( Class current = clazz; current != null; current = current.getSuperclass() ) {
			if ( classes.contains( current ) ) {
				return;
			}
			classes.add( current );
			for ( Class currentInterface : current.getInterfaces() ) {
				computeClassHierarchy( currentInterface, classes );
			}
		}
	}

	public ProxyMapDefinition getMapDefinition() {
		return myDefinition;
	}

	private boolean checkClassDefinition() {
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
		if ( type.getTypeName().endsWith("Binary")) {
			return Property.BINARY_PROPERTY;
		}
		if ( type.getTypeName().equals("java.lang.String") ) {
			return "string";
		}
		if ( type.getTypeName().equals("java.util.Date") ) {
			return "date";
		}
		if ( type.getTypeName().equals("com.dexels.navajo.document.types.ClockTime") ) {
			return "clocktime";
		}
		if ( type.getTypeName().equals("java.lang.Object")) {
			return "any";
		}
		if ( type.getTypeName().endsWith("Percentage")) {
			return "percentage";
		}
		if ( type.getTypeName().endsWith("Money")) {
			return "money";
		}
		if ( type.getTypeName().endsWith("Memo")) {
			return "memo";
		} else {
			return type.getTypeName();
		}
	}

	private String getType(Class c) throws Exception {
		Property p = NavajoFactory.getInstance().createProperty(NavajoFactory.getInstance().createNavajo(), "aap", "", "", "");
		Object object = c.getDeclaredConstructor().newInstance();
		p.setAnyValue(object);
		return p.getType();
	}

	public String getType(String field)  {
		if ( !checkClassDefinition()) {
			return null;
		}
		if ( setterTypes.get(field) != null ) {
			return setterTypes.get(field);
		}
		if ( getterTypes.get(field) != null ) {
			return getterTypes.get(field);
		}
		return "";
	}

	public AdapterClassDefinition getAdapterClass(String field) throws Exception {
		if ( !checkClassDefinition()) {
			return null;
		}
		Field f = classDefinition.getField(field);
		if ( f.getType().isPrimitive()) {
			throw new Exception("Cannot create AdapterClassDefinition for primitive type");
		}
		if ( classLoader != null ) {
			return new AdapterClassDefinition(f.getType(), classLoader);
		} else {
			return null;
		}
	}

	public Class getClassDefinition() {
		return classDefinition;
	}

	public boolean isSetter(String field)  {
		return getSetters().contains(field);
	}

	public boolean isGetter(String field)  {
		return getGetters().contains(field);
	}
	
	public boolean isPrimitiveType(String field)   {
		try {
			return PRIMITIVE_TYPES.contains(getType(field));
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return false;
		}
	}

	public Set<String> getGetters() { // Use definition and object.

		if ( getters.size() > 0 ) {
			return getters;
		}

		// Get all 'getters' for this class.
		Method [] methods = classDefinition.getMethods();
		for ( Method m : methods ) {
			if ( !EXCLUDED_METHODS.contains(m.getName()) && m.getName().startsWith("get") ) {
				String name = m.getName().substring(3);
				name = (name.charAt(0)+"").toLowerCase() + name.substring(1);
				// getterTypes
				Type rtType = m.getGenericReturnType();
				try {
					String rtString = getType(rtType);
					getters.add(name);
					getterTypes.put(name, rtString);
					
				} catch (Exception e) {
					logger.warn("Could not determine return type for: " + name);
				}	
			}
		}

		// Finally get all Fields for which there is NO getter.
		Field [] fields = classDefinition.getFields();
		for ( Field f : fields ) {
			if ( !getters.contains(f.getName() ) ) {
				try {
					getterTypes.put(f.getName(), getType(f.getGenericType()) );
					getters.add(f.getName());
				} catch (Exception e) {
					logger.warn("Could not find type for " + f.getGenericType() + ": " + e);
				}
			}
		}

		return getters;
	}

	public String getSetterType(String field) {
		getSetters();
		return setterTypes.get(field);
	}

	public String getGetterType(String field) {
		getGetters();
		return getterTypes.get(field);
	}

	public Set<String> getSetters() {

		if ( setters.size() > 0 ) {
			return setters;
		}

		// First get everything from definition.
		if ( !checkClassDefinition()) { 
			Set<String> values = myDefinition.getValueDefinitions();
			for ( String v : values ) {
				ProxyValueDefinition vd = myDefinition.getValueDefinition(v);
				if ( "in".equals(vd.getDirection()) ){
					setters.add(v);
				}
			}
		}

		// Then get all methods that start with 'set'.
		Method [] methods = classDefinition.getMethods();
		for ( Method m : methods ) {
			if ( !EXCLUDED_METHODS.contains(m.getName()) && m.getName().startsWith("set") && m.getParameters().length == 1 ) {
				String name = m.getName().substring(3);
				name = (name.charAt(0)+"").toLowerCase() + name.substring(1);
				Type type = m.getGenericParameterTypes()[0];
				try {
					String tStr = getType(type);
					setterTypes.put(name, tStr);
					setters.add(name);
				} catch (Exception e) {
					logger.warn("Could not find type for " + type + ": " + e);
				}
			}
		}

		// Finally get all Fields for which there is NO setter.
		Field [] fields = classDefinition.getFields();
		for ( Field f : fields ) {
			if ( !setters.contains(f.getName() ) ) {
				try {
					setterTypes.put(f.getName(), getType(f.getGenericType()) );
					setters.add(f.getName());
				} catch (Exception e) {
					logger.warn("Could not find type for " + f.getGenericType() + ": " + e);
				}
			}
		}

		return setters;
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
			return signatures;
		}
	}

}
