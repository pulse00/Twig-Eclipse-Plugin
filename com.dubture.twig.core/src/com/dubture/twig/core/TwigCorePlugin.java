/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core;

import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import com.dubture.twig.core.model.TwigModelAccess;

public class TwigCorePlugin extends Plugin
{

    // The plug-in ID
    public static final String PLUGIN_ID = "com.dubture.twig.core";

    public static final String EDITOR_ID = "com.dubture.twig.editor";

    public static final int INTERNAL_ERROR = 10001;

    private Boolean _isDltk3 = null;

    // The shared instance
    private static TwigCorePlugin plugin;

    /*
     * (non-Javadoc)
     *
     * @see
     * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext bundleContext) throws Exception
    {
        super.start(bundleContext);
        plugin = this;

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IResourceChangeListener listener = new IResourceChangeListener()
        {

            @Override
            public void resourceChanged(IResourceChangeEvent event)
            {

                TwigModelAccess.getDefault().clearCache();

            }
        };

        workspace.addResourceChangeListener(listener,
                IResourceChangeEvent.PRE_BUILD);

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    public void stop(BundleContext bundleContext) throws Exception
    {
        super.stop(bundleContext);
        plugin = null;
    }

    public static TwigCorePlugin getDefault()
    {

        return plugin;

    }

    public static void log(Exception e)
    {

        log(new Status(IStatus.ERROR, PLUGIN_ID, INTERNAL_ERROR,
                "PHPCore plugin internal error", e)); //$NON-NLS-1$

    }

    private static void log(Status status)
    {
        getDefault().getLog().log(status);

    }

    public boolean isDLTK3()
    {

        if (_isDltk3 != null)
            return _isDltk3;

        String version = Platform.getBundle("org.eclipse.dltk.core")
                .getHeaders().get("Bundle-Version");
        int v = Character.digit(version.charAt(0), 10);
        return _isDltk3 = v >= 3;

    }

    private static final String isDebugMode = "com.dubture.twig.core/debug";

    public static boolean debug()
    {

        String debugOption = Platform.getDebugOption(isDebugMode); //$NON-NLS-1$
        return getDefault().isDebugging()
                && "true".equalsIgnoreCase(debugOption);

    }
}
