/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui;

import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public class TwigPluginImages {

	public static final IPath ICONS_PATH = new Path("/ico/full"); //$NON-NLS-1$

	private static final String NAME_PREFIX = "com.dubture.twig.ui."; //$NON-NLS-1$
	private static final int NAME_PREFIX_LENGTH = NAME_PREFIX.length();

	// The plug-in registry
	private static ImageRegistry fgImageRegistry = null;

	private static HashMap<String, ImageDescriptor> fgAvoidSWTErrorMap = null;
	private static final String T_OBJ = "obj16"; //$NON-NLS-1$

	public static final String IMG_OBJS_TAG = NAME_PREFIX + "block-small-icon.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_FILTER = NAME_PREFIX + "filter-icon.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_FUNCTION = NAME_PREFIX + "paren.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_TEST = NAME_PREFIX + "question-small-icon.gif"; //$NON-NLS-1$
	public static final String IMG_OBJS_STATEMENT = NAME_PREFIX + "statement.png"; // $NON-NLS-N$
	public static final String IMG_OBJS_PRINT = NAME_PREFIX + "print.png"; // $NON-NLS-N$

	public static final ImageDescriptor DESC_OBJS_TAG = createManagedFromKey(T_OBJ, IMG_OBJS_TAG);
	public static final ImageDescriptor DESC_OBJS_FILTER = createManagedFromKey(T_OBJ, IMG_OBJS_FILTER);
	public static final ImageDescriptor DESC_OBJS_FUNCTION = createManagedFromKey(T_OBJ, IMG_OBJS_FUNCTION);
	public static final ImageDescriptor DESC_OBJS_TEST = createManagedFromKey(T_OBJ, IMG_OBJS_TEST);
	public static final ImageDescriptor DESC_OBJS_STATEMENT = createManagedFromKey(T_OBJ, IMG_OBJS_STATEMENT);
	public static final ImageDescriptor DESC_OBJS_PRINT = createManagedFromKey(T_OBJ, IMG_OBJS_PRINT);

	private static final String T_WIZBAN = "wizban"; //$NON-NLS-1$

	public static final ImageDescriptor DESC_WIZBAN_ADD_TWIG_FILE = create(T_WIZBAN, "new_file.gif");//$NON-NLS-1$

	private static ImageDescriptor createManagedFromKey(String prefix, String key) {
		return createManaged(prefix, key.substring(NAME_PREFIX_LENGTH), key);
	}

	private static ImageDescriptor createManaged(String prefix, String name, String key) {
		try {
			ImageDescriptor result = create(prefix, name, true);
			if (fgAvoidSWTErrorMap == null) {
				fgAvoidSWTErrorMap = new HashMap<String, ImageDescriptor>();
			}
			fgAvoidSWTErrorMap.put(key, result);
			if (fgImageRegistry != null) {
				// Plugin.logErrorMessage("Image registry already defined");
				// //$NON-NLS-1$

			}
			return result;
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/*
	 * Creates an image descriptor for the given prefix and name in the Symfony
	 * UI bundle. The path can contain variables like $NL$. If no image could be
	 * found, <code>useMissingImageDescriptor</code> decides if either the
	 * 'missing image descriptor' is returned or <code>null</code>. or
	 * <code>null</code>.
	 */
	private static ImageDescriptor create(String prefix, String name, boolean useMissingImageDescriptor) {
		IPath path = ICONS_PATH.append(prefix).append(name);

		return createImageDescriptor(TwigUICorePlugin.getDefault().getBundle(), path, useMissingImageDescriptor);
	}

	/*
	 * Creates an image descriptor for the given prefix and name in the Symfony
	 * UI bundle. The path can contain variables like $NL$. If no image could be
	 * found, the 'missing image descriptor' is returned.
	 */
	private static ImageDescriptor create(String prefix, String name) {
		return create(prefix, name, true);
	}

	/*
	 * Creates an image descriptor for the given path in a bundle. The path can
	 * contain variables like $NL$. If no image could be found,
	 * <code>useMissingImageDescriptor</code> decides if either the 'missing
	 * image descriptor' is returned or <code>null</code>. Added for 3.1.1.
	 */
	public static ImageDescriptor createImageDescriptor(Bundle bundle, IPath path, boolean useMissingImageDescriptor) {
		URL url = FileLocator.find(bundle, path, null);
		if (url != null) {
			return ImageDescriptor.createFromURL(url);
		}
		if (useMissingImageDescriptor) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
		return null;
	}

	/*
	 * Helper method to access the image registry from the PHPPlugin class.
	 */
	static ImageRegistry getImageRegistry() {
		if (fgImageRegistry == null) {
			fgImageRegistry = new ImageRegistry();
			for (Entry<String, ImageDescriptor> entry : fgAvoidSWTErrorMap.entrySet()) {
				fgImageRegistry.put(entry.getKey(), entry.getValue());
			}
			fgAvoidSWTErrorMap = null;
		}
		return fgImageRegistry;
	}

	/**
	 * Returns the image managed under the given key in this registry.
	 * 
	 * @param key
	 *            the image's key
	 * @return the image managed under the given key
	 */
	public static Image get(String key) {
		return getImageRegistry().get(key);
	}

}
