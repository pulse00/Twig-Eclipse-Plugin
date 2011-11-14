/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.preferences;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.dubture.twig.ui.preferences.messages"; //$NON-NLS-1$
	public static String TwigBasePreferencePage_0;
	public static String TwigEditorPreferencePage_0;
	public static String TwigEditorPreferencePage_1;
	public static String TwigEditorPreferencePage_2;
	public static String TwigEditorPreferencePage_3;
	public static String TwigEditorPreferencePage_4;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
