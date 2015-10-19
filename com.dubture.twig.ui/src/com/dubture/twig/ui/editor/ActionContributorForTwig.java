/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor;

import org.eclipse.wst.html.ui.internal.edit.ui.ActionContributorHTML;

/**
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
@SuppressWarnings("restriction")
public class ActionContributorForTwig extends ActionContributorHTML {

	private static final String[] EDITOR_IDS = { "com.dubture.twig.core.twigtemplate", //$NON-NLS-1$
			"org.eclipse.wst.sse.ui.StructuredTextEditor" }; //$NON-NLS-1$

	@Override
	protected String[] getExtensionIDs() {
		return EDITOR_IDS;
	}

}
