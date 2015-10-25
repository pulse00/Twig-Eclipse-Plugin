package com.dubture.twig.core.test;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class TwigCoreTestPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.dubture.twig.core";

	public static final String EDITOR_ID = "com.dubture.twig.editor";

	public static final int INTERNAL_ERROR = 10001;

	// The shared instance
	private static TwigCoreTestPlugin plugin;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		plugin = this;

	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		super.stop(bundleContext);
		plugin = null;
	}

	public static TwigCoreTestPlugin getDefault() {
		return plugin;
	}

	private static final String isDebugMode = "com.dubture.twig.core.test/debug";

	public static boolean debug() {

		String debugOption = Platform.getDebugOption(isDebugMode); // $NON-NLS-1$
		return getDefault().isDebugging() && "true".equalsIgnoreCase(debugOption);

	}
}