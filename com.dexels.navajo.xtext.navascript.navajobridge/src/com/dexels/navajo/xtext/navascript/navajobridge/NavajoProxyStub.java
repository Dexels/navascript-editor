package com.dexels.navajo.xtext.navascript.navajobridge;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;

public class NavajoProxyStub implements IResourceChangeListener {

	private static volatile NavajoProxyStub instance = null;
	private Map<String, AdapterClassDefinition> adapters = new TreeMap<>();

	private ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

	private static final Logger logger = Logger.getLogger(NavajoProxyStub.class);
	
	private IWorkspace myWorkspace;
	private Set<String> allScripts = new HashSet<>();
	private boolean resourceChangeListenerActive = false;
	private boolean initRunning = false;
	
	public static NavajoProxyStub getInstance() {
		return instance;
	}

	public synchronized void init()  {
		if ( initRunning ) {
			return;
		}
		initRunning = true;
		final NavajoProxyStub instance = this;
		tpe.execute(new Runnable() {
			@Override
			public void run() {

				adapters.clear();
				
				try {
					JavaProjectIntrospection.findVersionClasses(myWorkspace);
				} catch (Exception e) {

				}

				try {
					Set<String> allAdapters = ProxyMetaData.getInstance().getMapDefinitions();

					for ( String md : allAdapters ) {

						if ( md != null ) {
							ProxyMapDefinition pmd = ProxyMetaData.getInstance().getMapDefinition(md);
							if ( pmd != null && pmd.tagName != null  ) {
								ClassLoader acl = null;
								if ( pmd.objectClassLoader != null ) {
									acl = pmd.objectClassLoader;
								} else if ( pmd.mapDefinition != null ) {
									acl = pmd.mapDefinitionClass.getClassLoader();
								} else {
									acl = null;
								}
								AdapterClassDefinition acd = new AdapterClassDefinition(pmd, acl);
								adapters.put(md, acd);
							} else {
								logger.warn("Could not find " + md + " in ProxyMetaData");
							}
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				if (!resourceChangeListenerActive) {
					myWorkspace.addResourceChangeListener(instance);
					resourceChangeListenerActive = true;
				}
				
				initRunning = false;
			}
		});
	}
	
	public void clearMyWorkspace(IWorkspace myWorkspace) {
		this.myWorkspace = null;
	}
	
	public void setMyWorkspace(IWorkspace myWorkspace) {
		this.myWorkspace = myWorkspace;
	}

	public void activate() {
		try {
			instance = this;
			init();
			scanProjectsWithScripts();
		} catch (Exception e) {
			logger.error(e);
		}
	}

	private void findScripts(File f, String scriptPath) {
		if ( f.isDirectory() ) {
			for ( File child : f.listFiles() ) {
				findScripts(child, scriptPath);
			}
		}
		if ( f.getName().endsWith(".ns") || f.getName().endsWith(".xml") || f.getName().endsWith(".java") ) {
			String name = f.getAbsolutePath();
			int extensionStart =  name.lastIndexOf(".");
			name = name.substring(0, extensionStart);
			name = name.replaceAll(scriptPath, "");
			allScripts.add(name);
		}
	}
	
	private void scanProjectsWithScripts() {
		tpe.execute(() -> {
			IProject [] projects =  myWorkspace.getRoot().getProjects();
			for ( IProject project : projects ) {
				IFolder scriptsFolder = project.getFolder("scripts");
				File scripts = scriptsFolder.getRawLocation().makeAbsolute().toFile();
				findScripts(scripts, scripts.getAbsolutePath());
			}
		});
	}

	public void deactivate() {
	}


	public AdapterClassDefinition getAdapter(String s) {
		AdapterClassDefinition acd = adapters.get(s);
		return acd;
	}

	public void addAdapter(String name, AdapterClassDefinition adapterClassDefinition) {
		adapters.put(name, adapterClassDefinition);
	}
	
	public ProxyFunctionDefinition getFunction(String s) {
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
		Set<String> all = FunctionDefinitionCache.getInstance().getFunctions();
		String [] fArray = new String[all.size()];
		fArray = all.toArray(fArray);
		return fArray;
	}

	public Set<String> getScripts() throws IOException {
		return allScripts;
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
		boolean hasScriptFile = false;
		for ( IFile f : changedFiles ) {
			if ( f != null && f.getFileExtension() != null && f.getFileExtension().equals("java")) {
				hasJavaFile = true;
				break;
			}
			if ( f != null && f.getFileExtension() != null &&  ( f.getFileExtension().equals("ns") || f.getFileExtension().equals("xml") )  ) {
				hasScriptFile = true;
				break;
			}
		}
		if ( hasJavaFile ) {
			init();
		}
		if ( hasScriptFile || hasJavaFile ) {
			scanProjectsWithScripts();
		}
	}

}
