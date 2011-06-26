package org.eclipse.twig.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class TwigCorePlugin extends Plugin {
	
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.twig.core";

	public static final int INTERNAL_ERROR = 10001;

	private static final boolean DEBUG = false;
	
	
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

	public static void log(Exception e) {
		
		log(new Status(IStatus.ERROR, PLUGIN_ID, INTERNAL_ERROR,
				"PHPCore plugin internal error", e)); //$NON-NLS-1$
		
	}

	private static void log(Status status) {
		getDefault().getLog().log(status);
		
	}
	
	public boolean isDLTK3() {
		
		String version = Platform.getBundle("org.eclipse.dltk.core").getHeaders().get("Bundle-Version");		
		return version.startsWith("3");
		
	}

	public static void debug(String message) {

		if (DEBUG) {			
			System.err.println(message);
		}		
	}
}
