package com.dexels.navajo.xtext.navascript.navajobridge;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.core.JavaModel;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.osgi.service.resolver.State;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.wiring.BundleWiring;

import java.sql.SQLException;

import com.dexels.navajo.mapping.compiler.meta.MapMetaData;

import navajoextension.AbstractCoreExtension;

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

		String output = javaProject.getOutputLocation().toPortableString();
		urls = new URL[entries.length + 1];

		if (idx != -1) {
			wsPath = wsPath.substring(0, idx);
		} else {
			output = output.substring(firstEntryLocation.length());
		}
		urls[i++] = new File(wsPath + output).toURL();

		//System.out.println("ClassLoader " + output);

		String fullPath = null;

		for (IClasspathEntry entry : entries) {
			//System.err.println("cp: " + entry);
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

			urls[i++] = new File(fullPath).toURL();
		}

		URLClassLoader classLoader = new URLClassLoader(urls, java.sql.SQLException.class.getClassLoader());

		return classLoader;
	}

	public static void findVersionClasses() throws Exception {


		PlatformUI u;

		System.err.println("*************************************************************");

		IWorkspace workspace = ResourcesPlugin.getWorkspace();

		IProject [] ips = workspace.getRoot().getProjects();
		for ( IProject p : ips) {
			System.err.println(">>>>>> Project: " + p + "(" + p.getClass().getName() + ")");
			if ( JavaProject.hasJavaNature(p) ) {

				IJavaProject jp = JavaCore.create(p);

				System.err.println("Java project: jp");
				ClassLoader cl = getProjectClassLoader(jp);

				try {
					Class.forName("navajo.ExtensionDefinition", true, cl);
					Class.forName("com.dexels.navajo.mapping.compiler.meta.KeywordException", true, cl);
					Class foundClass = Class.forName("com.dexels.navajo.mapping.compiler.meta.MapMetaData", true, cl);
					System.err.println("found class: " + foundClass);
					Method m = foundClass.getDeclaredMethod("getInstance");
					System.err.println("found getInstance method: " + m);
					Object o = m.invoke(null);
					System.err.println(">>>>>>>>> mmd: " + o);
					Method m2 = foundClass.getDeclaredMethod("getMapDefinitions");
					System.err.println("found getMapDefinitions method: " + m2);
					Object o2 = m2.invoke(o);
					System.err.println("Map definitions: " + o2);
					System.err.println("Found MapMetaData class in project: " + p.getName());
					ProxyMetaData pmd = ProxyMetaData.getInstance();
					System.err.println(">>>>>> getMapDefinitions: " + pmd.getMapDefinitions());
					pmd.addMapMetaData(o, foundClass);
					
				} catch (Throwable e) {
					//e.printStackTrace(System.err);
					System.err.println("Could not find MapMetaData in project: " + p.getName() + ": " + e.getMessage());
				}

			}

		}
	}
}
