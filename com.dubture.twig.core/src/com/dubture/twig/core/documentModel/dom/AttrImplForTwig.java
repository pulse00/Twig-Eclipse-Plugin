/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.dom;

import org.eclipse.wst.xml.core.internal.document.AttrImpl;
import org.w3c.dom.Document;

import com.dubture.twig.core.documentModel.parser.TwigRegionContext;

@SuppressWarnings("restriction")
public class AttrImplForTwig extends AttrImpl {

	protected boolean isNestedLanguageOpening(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_OPEN;
	}

	protected void setOwnerDocument(Document ownerDocument) {
		super.setOwnerDocument(ownerDocument);
	}

	protected void setName(String name) {
		super.setName(name);
	}

}
