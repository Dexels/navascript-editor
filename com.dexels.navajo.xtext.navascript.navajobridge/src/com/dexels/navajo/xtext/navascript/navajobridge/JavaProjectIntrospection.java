package com.dexels.navajo.xtext.navascript.navajobridge;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Vector;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.JavaModel;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.pde.core.target.ITargetPlatformService;
import org.eclipse.pde.core.target.TargetBundle;
import org.eclipse.pde.internal.core.target.TargetPlatformService;
import org.eclipse.ui.PlatformUI;

import com.dexels.navajo.document.nanoimpl.CaseSensitiveXMLElement;
import com.dexels.navajo.document.nanoimpl.XMLElement;
import com.dexels.navajo.expression.api.FunctionDefinition;
import com.dexels.navajo.mapping.compiler.meta.MapDefinition;

public class JavaProjectIntrospection {


	public static ClassLoader getProjectClassLoader(IJavaProject javaProject) throws Exception {

		IClasspathEntry[] entries = javaProject.getResolvedClasspath(true);
		String wsPath = javaProject.getProject().getLocation().toPortableString();
		String firstEntryLocation = javaProject.getPath().toPortableString();
		int idx = wsPath.indexOf(firstEntryLocation);

		URL[] urls = null;
		int i = 0;

		//System.out.println("ClassLoader " + wsPath);
		//System.out.println("ClassLoader " + firstEntryLocation);

		List<URL> tpurls = getTargetPlatformURLs();

		String output = javaProject.getOutputLocation().toPortableString();
		urls = new URL[entries.length + 1 + tpurls.size()];

		// First add TP URLs.
		for ( URL u : tpurls ) {
			urls[i++] = u;
		}

		if (idx != -1) {
			wsPath = wsPath.substring(0, idx);
		} else {
			output = output.substring(firstEntryLocation.length());
		}
		urls[i++] = new File(wsPath + output).toURL();

		//System.out.println("ClassLoader " + output);

		String fullPath = null;

		for (IClasspathEntry entry : entries) {
			if (entry.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
				IResource project = ResourcesPlugin.getWorkspace().getRoot().findMember(entry.getPath());
				String projectPath = JavaCore.create(project.getProject()).getOutputLocation().toPortableString();
				fullPath = wsPath + projectPath;
			} else {
				Object resource = JavaModel.getTarget(entry.getPath(), true);


				if (resource instanceof IResource) {
					IResource iFile = (IResource) resource;
					fullPath = iFile.getLocation().toPortableString();
				} else if (resource instanceof File) {
					File file = (File) resource;
					fullPath = file.getAbsolutePath();
				}
			}

			//System.err.println("cp: " + entry + " / " + fullPath + " / " + entry.getEntryKind());

			urls[i++] = new File(fullPath).toURL();
		}


		System.err.println("Added total of " + urls.length + " entries to classloader...");
		URLClassLoader classLoader = new URLClassLoader(urls, java.sql.SQLException.class.getClassLoader());

		return classLoader;
	}


	private static void readAdaptersFromDefinitionFile(Object fd, ClassLoader cl) {

		CaseSensitiveXMLElement xml = new CaseSensitiveXMLElement();

		try {
			Method mStream = fd.getClass().getMethod("getDefinitionAsStream");
			InputStream fis = (InputStream) mStream.invoke(fd);
			xml.parseFromStream(fis);
			fis.close();
			Vector<XMLElement> children = xml.getChildren();
			for (XMLElement element: children) {
				addMapDefinition(element, cl);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static MapDefinition addMapDefinition(XMLElement map, ClassLoader cl) throws Exception {
		MapDefinition md = MapDefinition.parseDef(map);
		ProxyMetaData pmd = ProxyMetaData.getInstance();
		pmd.addMapDefinition(md, cl);
		return md;
	}

	private static void readFunctionsFromDefinitionFile(Object fd) {
		// Read config file.

		CaseSensitiveXMLElement xml = new CaseSensitiveXMLElement();

		try {
			Method mStream = fd.getClass().getMethod("getDefinitionAsStream");

			InputStream fis = (InputStream) mStream.invoke(fd);

			xml.parseFromStream(fis);
			fis.close();

			Vector<XMLElement> children = xml.getChildren();
			for (int i = 0; i < children.size(); i++) {
				// Get object, usage and description.
				XMLElement element = children.get(i);

				if(element.getName().equals("function")) {
					parseFunction(element);
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void parseFunction(XMLElement element) {
		Vector<XMLElement> def = element.getChildren();
		String name = (String) element.getAttribute("name");
		String object = (String) element.getAttribute("class");
		String description = null;
		String inputParams = null;
		String resultParam = null;
		for (int j = 0; j < def.size(); j++) {
			if ( def.get(j).getName().equals("description")) {
				description =  def.get(j).getContent();
			}
			if ( def.get(j).getName().equals("input")) {
				inputParams =  def.get(j).getContent();
			}
			if ( def.get(j).getName().equals("result")) {
				resultParam =  def.get(j).getContent();
			}
		}
		if ( name != null ) {			
			ProxyFunctionDefinition functionDefinition = new ProxyFunctionDefinition(object, description, inputParams, resultParam);
			//functionDefinition.setXmlElement(element);
			FunctionDefinitionCache.getInstance().addFunctionDefinition(name, functionDefinition);
		}
	}

	public static List<URL> getTargetPlatformURLs() {

		List<URL> urls = new ArrayList<>();
		ITargetPlatformService tpService = TargetPlatformService.getDefault();

		try {
			TargetBundle [] all = tpService.getWorkspaceTargetDefinition().getAllBundles();
			for ( TargetBundle tb : all ) {
				URL u = tb.getBundleInfo().getLocation().toURL();
				urls.add(u);
			}
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}

		return urls;

	}

	private static void addAdditionalAdapters(String adapterClassName, ClassLoader cl) {
		// getDefinitionAsStream

		try {
			Class foundClass = Class.forName(adapterClassName, true, cl);
			Object adapterObject = foundClass.getDeclaredConstructor().newInstance();
			System.err.println("LOADED " + adapterClassName + " OBJECT: " + adapterObject);
			readAdaptersFromDefinitionFile(adapterObject, cl);
		} catch (Throwable t) {
			System.err.println("could not load MONGO lib: " + t);
		}

	}
	
	private static void addAdditionalFunctions(String adapterClassName, ClassLoader cl) {
		// getDefinitionAsStream

		try {
			Class foundClass = Class.forName(adapterClassName, true, cl);
			Object adapterObject = foundClass.getDeclaredConstructor().newInstance();
			System.err.println("LOADED " + adapterClassName + " OBJECT: " + adapterObject);
			readFunctionsFromDefinitionFile(adapterObject);
		} catch (Throwable t) {
			System.err.println("could not load MONGO lib: " + t);
		}

	}

	public static synchronized void findVersionClasses() throws Exception {


		PlatformUI u;

		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		IProject [] ips = workspace.getRoot().getProjects();
		for ( IProject p : ips) {
			if ( JavaProject.hasJavaNature(p) ) {

				IJavaProject jp = JavaCore.create(p);

				//System.err.println("Java project: jp");
				ClassLoader cl = getProjectClassLoader(jp);
				
				try {

					Class slc = Class.forName("navajo.ExtensionDefinition", true, cl);
					ServiceLoader extensionLoaders = ServiceLoader.load(slc, cl);
					for (Object loader : extensionLoaders ) {
						System.err.println(">>>>>>>>>> Found service: " + loader);
						readFunctionsFromDefinitionFile(loader);

					}

					Class.forName("com.dexels.navajo.mapping.compiler.meta.KeywordException", true, cl);
					Class foundClass = Class.forName("com.dexels.navajo.mapping.compiler.meta.MapMetaData", true, cl);
					//System.err.println("found class: " + foundClass);
					Method m = foundClass.getDeclaredMethod("getInstance");
					//System.err.println("found getInstance method: " + m);
					Object o = m.invoke(null);
					//System.err.println(">>>>>>>>> mmd: " + o);
					Method m2 = foundClass.getDeclaredMethod("getMapDefinitions");
					//System.err.println("found getMapDefinitions method: " + m2);
					Object o2 = m2.invoke(o, null);
					//System.err.println("Map definitions: " + o2);
					//System.err.println("Found MapMetaData class in project: " + p.getName());
					ProxyMetaData pmd = ProxyMetaData.getInstance();
					//System.err.println(">>>>>> getMapDefinitions: " + pmd.getMapDefinitions());
					pmd.addMapMetaData(o, foundClass);

				} catch (Throwable e) {
					//e.printStackTrace(System.err);
					System.err.println("Could not find MapMetaData in project: " + p.getName() + ": " + e.getMessage());
				}
				
				//addAdditionalAdapters("com.dexels.navajo.mongo.adapter.MongoAdapterLibrary", cl);
				//addAdditionalFunctions("com.dexels.navajo.mongo.functions.MongoFunctionDefinitions", cl);

			}

		}
	}

}
