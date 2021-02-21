package com.dexels.navajo.xtext.navascript.navajobridge.stub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.dexels.navajo.document.nanoimpl.CaseSensitiveXMLElement;
import com.dexels.navajo.document.nanoimpl.XMLElement;
import com.dexels.navajo.expression.api.FunctionDefinition;
import com.dexels.navajo.mapping.compiler.meta.KeywordException;
import com.dexels.navajo.mapping.compiler.meta.MapDefinition;
import com.dexels.navajo.mapping.compiler.meta.MapMetaData;
import com.dexels.navajo.xtext.navascript.navajobridge.EclipseLogger;
import com.dexels.navajo.xtext.navascript.navajobridge.OSGIRuntime;

@SuppressWarnings("unused")
public class MapDefinitionInterrogatorImpl  {


	MapMetaData mapMetaData = null;
	private Map<String,FunctionDefinition> functions = new TreeMap<>();

	@SuppressWarnings("unchecked")
	public MapDefinitionInterrogatorImpl()  {

		EclipseLogger.log("InMapDefinitionInterrogatorImpl() constructor ");
		
		try {
			mapMetaData = MapMetaData.getInstance();
			Set<String> adapters = mapMetaData.getMapDefinitions();
			for ( String a : adapters ) {
				EclipseLogger.log(">>>>>>>>>>>>>>>>>>>>>>>>>>> Adapters: " + a);
			}
			BundleContext context;

			context = OSGIRuntime.getDefaultBundleContext();

			ServiceReference<?> [] services = context.getAllServiceReferences(FunctionDefinition.class.getName(), null);

			EclipseLogger.log("Found " + services.length + " services...");

			for ( ServiceReference sr : services ) {
				String functionName = (String) sr.getProperty("functionName");
				FunctionDefinition fd = (FunctionDefinition) context.getService(sr);
				EclipseLogger.log("Adding function " + functionName + ": " + fd);
				functions.put(functionName, fd);

			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}

	}

	public boolean isMethod(String adapter, String m) throws Exception {
		try {
			if (  mapMetaData.getMapDefinition(adapter) == null ) {
				throw new Exception("Could not find adapter: " + adapter);
			}
			return ( mapMetaData.getMapDefinition(adapter).getMethodDefinition(m) != null);
		} catch (ClassNotFoundException e) {
			throw new Exception(e);
		} catch (KeywordException e) {
			throw new Exception(e);
		}
	}

	private boolean isRegularField(String adapter, String m) throws Exception {
		if (  mapMetaData.getMapDefinition(adapter) == null ) {
			throw new Exception("Could not find adapter: " + adapter + " for field " + m);
		} 
		String className = mapMetaData.getMapDefinition(adapter).objectName;
		Class c = Class.forName(className);
		return c.getDeclaredField(m) != null;
	}

	public boolean isDeclaredField(String className, String m)  {
		try {
			Class c = Class.forName(className);
			return c.getDeclaredField(m) != null;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isField(String adapter, String m) throws Exception {

		try {
			if (  mapMetaData.getMapDefinition(adapter) == null ) {
				// Try regular field
				if ( isRegularField(adapter, m) ) {
					return true;
				}
				throw new Exception("Could not find adapter: " + adapter);
			} 
			String objectName = mapMetaData.getMapDefinition(adapter).objectName;
			boolean isDefinedField = ( mapMetaData.getMapDefinition(adapter).getValueDefinition(m) != null);
			boolean isDeclaredField = isDeclaredField(objectName, m);
			return isDefinedField || isDeclaredField;
		} catch (ClassNotFoundException e) {
			throw new Exception(e);
		} catch (KeywordException e) {
			throw new Exception(e);
		}
	}

	public MapDefinition getAdapter(String adapter) throws Exception{

		return mapMetaData.getMapDefinition(adapter);

	}

	public Map<String,FunctionDefinition> getFunctions() throws Exception {
		return functions;
	}

	public List<MapDefinition> getAdapters() throws Exception{

		ArrayList<MapDefinition> allMaps = new ArrayList<>();

		Set<String> definitions = mapMetaData.getMapDefinitions();
		for ( String s : definitions ) {
			allMaps.add(mapMetaData.getMapDefinition(s));
		}

		return allMaps;
	}

	public void describeAdapter(String adapter) throws Exception {

		MapDefinition md = mapMetaData.getMapDefinition(adapter);

		Set<String> methods = md.getMethodDefinitions();		

		System.err.println("Adapter " + adapter + " methods:");

		for ( String s : methods ) {
			System.err.println("\t" + s);
		}

		Set<String> values = md.getValueDefinitions();

		System.err.println("Adapter " + adapter + " fields:");

		for ( String s : values ) {
			System.err.println("\t" + s);
		}

	}

	public static void main (String [] args) throws Exception {

		MapDefinitionInterrogatorImpl m = new MapDefinitionInterrogatorImpl();

		String adapter = "sqlquery";
		String field = "doUpdate";

		m.describeAdapter(adapter);

	}

	public boolean isValidClass(String className) {
		try {
			Class c = Class.forName(className);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isValidAdapter(String adapter)  {
		try {
			return ( mapMetaData.getMapDefinition(adapter) != null ) ;
		} catch (Exception e) {
			return false;
		}
	}
}

