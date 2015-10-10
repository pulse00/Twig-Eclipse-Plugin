/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.provisional.contenttype;

import com.dubture.twig.core.TwigCorePlugin;

/**
 * 
 * @see http ://code.google.com/p/smartypdt/source/browse/trunk/org.eclipse.php.
 *      smarty
 *      .core/src/org/eclipse/php/smarty/internal/core/documentModel/provisional
 *      /contenttype/ContentTypeIdForSmarty.java
 * 
 */
public class ContentTypeIdForTwig {

	public final static String CONTENT_TYPE_ID_TWIG = getConstantString();

	/**
	 * Don't allow instantiation.
	 */
	private ContentTypeIdForTwig() {
		super();
	}

	static String getConstantString() {
		return TwigCorePlugin.PLUGIN_ID + ".twigtemplate"; //$NON-NLS-1$
	}
}
