package org.eclipse.twig.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class TwigCorePlugin extends Plugin {
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.twig.core";
	public static final String NATURE_ID = PLUGIN_ID + ".TwigNature";
	
	
	// The shared instance	
	private static TwigCorePlugin plugin;


	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		super.stop(bundleContext);
		plugin = null;
	}
	
	public static TwigCorePlugin getDefault() {
		
		return plugin;		
		
	}
	
	

}
