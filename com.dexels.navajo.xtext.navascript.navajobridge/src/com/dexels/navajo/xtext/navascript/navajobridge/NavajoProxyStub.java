package com.dexels.navajo.xtext.navascript.navajobridge;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.dexels.navajo.expression.api.FunctionDefinition;

public class NavajoProxyStub {

	private static volatile NavajoProxyStub instance = null;

	private Map<String, FunctionDefinition> functions = new TreeMap<>();
	private Map<String, AdapterClassDefinition> adapters = new TreeMap<>();
	private Map<String, ClassLoader> classloaders = new HashMap<>();

	private boolean init = false;

	public static NavajoProxyStub getInstance() {
		return instance;
	}

	public synchronized void init()  {

		if ( init ) {
			return;
		}
		try {
			JavaProjectIntrospection.findVersionClasses();
		} catch (Exception e) {

		}

		System.err.println("**********************************************************************************");
		System.err.println("**********************************************************************************");
		System.err.println("**********************************************************************************");
		System.err.println("**********************************************************************************");

		try {
			Set<String> allAdapters = ProxyMetaData.getInstance().getMapDefinitions();

			for ( String md : allAdapters ) {
				
				if ( md != null ) {
					System.err.println("Processing adapter " + md);					
					ProxyMapDefinition pmd = ProxyMetaData.getInstance().getMapDefinition(md);
					System.err.println("Processing adapter " + md + " with proxymap " + pmd + " and tagName: " + (pmd != null ? pmd.tagName :  " ----" ));
					if ( pmd != null && pmd.tagName != null && adapters.get(md) == null ) {
						AdapterClassDefinition acd = new AdapterClassDefinition(pmd, ( pmd.mapDefinitionClass != null? pmd.mapDefinitionClass.getClassLoader() : null));
						adapters.put(md, acd);
						System.err.println(">>>>>>>>>> Stored adapter " + md + ", with AdapterClassDefinition: " + acd);
					} else {
						System.err.println("Could not find " + md + " in ProxyMetaData");
					}
				}
			}

			init = true;

		} catch (Exception e1) {
			e1.printStackTrace();
		}



	}

	private void populateFunctions() throws Exception {

		BundleContext context = OSGIRuntime.getDefaultBundleContext();

		ServiceReference<?> [] services = context.getAllServiceReferences(FunctionDefinition.class.getName(), null);

		System.err.println("Found " + services.length + " services...");

		for ( ServiceReference sr : services ) {
			String functionName = (String) sr.getProperty("functionName");
			FunctionDefinition fd = (FunctionDefinition) context.getService(sr);
			System.err.println("Adding function " + functionName + ": " + fd);
			functions.put(functionName, fd);

		}

	}

	public void activate() {
		try {
			instance = this;
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		System.err.println(">>>>>>>>>>>>>> NavajoProxyStub has been activated()");
	}

	public void deactivate() {
		System.err.println("In NavajoProxyStub.deactivate()");
	}


	public AdapterClassDefinition getAdapter(String s) {
		init();
		AdapterClassDefinition acd = adapters.get(s);
		return acd;
	}

	public FunctionDefinition getFunction(String s) {
		return functions.get(s);
	}

	public String [] getAdapters() {

		init();


		ProxyMetaData pmd = ProxyMetaData.getInstance();
		Set<String> keySet = pmd.getMapDefinitions();
		String [] adapters = new String[keySet.size()];
		adapters = (String []) keySet.toArray(adapters);

		return adapters;

	}

	public String [] getFunctions() {

		System.err.println("In getFunctions()....");

		if ( functions != null ) {

			Set<String> keySet = functions.keySet();
			String [] functions = new String[keySet.size()];
			functions = (String []) keySet.toArray(functions);

			return functions;
		} else {
			return null;
		}
	}

}
