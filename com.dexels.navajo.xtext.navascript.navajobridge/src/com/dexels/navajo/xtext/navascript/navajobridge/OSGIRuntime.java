package com.dexels.navajo.xtext.navascript.navajobridge;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class OSGIRuntime extends Plugin {

	private static BundleContext bundleContext;
	
	@Override
	public void start(BundleContext arg0) throws Exception {
		super.start(arg0);
		bundleContext = arg0;
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		
	}

	public static BundleContext getDefaultBundleContext() {
        Bundle b = org.osgi.framework.FrameworkUtil.getBundle(OSGIRuntime.class);
        if (b != null) {
            return b.getBundleContext();
        }
        return bundleContext;
    }
	
}
