/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.templates;

import org.eclipse.dltk.ui.templates.ScriptTemplateAccess;
import org.eclipse.jface.preference.IPreferenceStore;

import com.dubture.twig.ui.TwigUICorePlugin;

/**
 * 
 * Provide access to the eclipse code templates from the
 * {@link IPreferenceStore} .
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class TwigTemplateAccess extends ScriptTemplateAccess {

	private static final String CUSTOM_TEMPLATES_KEY = "com.dubture.twig.Templates"; //$NON-NLS-1$

	private static TwigTemplateAccess instance;

	public static TwigTemplateAccess getInstance() {
		if (instance == null) {
			instance = new TwigTemplateAccess();
		}

		return instance;
	}

	@Override
	protected String getContextTypeId() {

		return TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID;
	}

	@Override
	protected String getCustomTemplatesKey() {

		return CUSTOM_TEMPLATES_KEY;

	}

	@Override
	protected IPreferenceStore getPreferenceStore() {

		return TwigUICorePlugin.getDefault().getPreferenceStore();
	}

}
