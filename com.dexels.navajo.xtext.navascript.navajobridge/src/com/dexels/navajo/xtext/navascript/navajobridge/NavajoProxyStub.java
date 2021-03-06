package com.dexels.navajo.xtext.navascript.navajobridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;

import com.dexels.navajo.expression.api.FunctionDefinition;

public class NavajoProxyStub implements IResourceChangeListener {

	private static volatile NavajoProxyStub instance = null;
	private Map<String, AdapterClassDefinition> adapters = new TreeMap<>();

	private ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

	public static NavajoProxyStub getInstance() {
		return instance;
	}

	public void init()  {
		tpe.execute(new Runnable() {
			@Override
			public void run() {

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
							ProxyMapDefinition pmd = ProxyMetaData.getInstance().getMapDefinition(md);
							if ( pmd != null && pmd.tagName != null  ) {
								AdapterClassDefinition acd = new AdapterClassDefinition(pmd, ( pmd.mapDefinitionClass != null? pmd.mapDefinitionClass.getClassLoader() : null));
								adapters.put(md, acd);
								System.err.println(">>>>>>>>>> Stored adapter " + md + ", with AdapterClassDefinition: " + acd);
							} else {
								System.err.println("Could not find " + md + " in ProxyMetaData");
							}
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void activate() {
		try {
			instance = this;
			init();
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			workspace.addResourceChangeListener(this);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		System.err.println(">>>>>>>>>>>>>> NavajoProxyStub has been activated()");
	}

	public void deactivate() {
		System.err.println("In NavajoProxyStub.deactivate()");
	}


	public AdapterClassDefinition getAdapter(String s) {
		AdapterClassDefinition acd = adapters.get(s);
		return acd;
	}

	public FunctionDefinition getFunction(String s) {
		return FunctionDefinitionCache.getInstance().getFunction(s);
	}

	public String [] getAdapters() {

		ProxyMetaData pmd = ProxyMetaData.getInstance();
		Set<String> keySet = pmd.getMapDefinitions();
		String [] adapters = new String[keySet.size()];
		adapters = (String []) keySet.toArray(adapters);

		return adapters;

	}

	public String [] getFunctions() {

		System.err.println("In getFunctions()....");

		Set<String> all = FunctionDefinitionCache.getInstance().getFunctions();
		String [] fArray = new String[all.size()];
		fArray = all.toArray(fArray);
		return fArray;
	}

	private List<IFile> findChangedFiles(IResourceDelta delta) {
		IResourceDelta [] children = delta.getAffectedChildren();
		List<IFile> changedFiles = new ArrayList<>();
		if ( delta.getResource() instanceof IFile) {
			changedFiles.add((IFile) delta.getResource());
		} else {
			for ( IResourceDelta ird : children ) {
				List<IFile> changedChildren = findChangedFiles(ird);
				changedFiles.addAll(changedChildren);
			}
		}
		return changedFiles;
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		IResourceDelta delta = event.getDelta();
		List<IFile> changedFiles = findChangedFiles(delta);
		boolean hasJavaFile = false;
		for ( IFile f : changedFiles ) {
			//System.err.println(">>>> changed file: " + f.getName() + " / " + f.getFileExtension());
			if ( f.getFileExtension().equals("java")) {
				hasJavaFile = true;
				System.err.println("THIS JAVA FILE HAS CHANGED: " + f.getName());
			}
		}
		if ( hasJavaFile ) {
			if ( tpe.getQueue().size() > 0 ) { // Existing init() is running. Skip this one.
				return;
			}
			System.err.println("CHANGED JAVA FILE. CALL INIT() AGAIN!!!!!!!!!!");
			init();
		}
	}

}
