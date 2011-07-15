package org.eclipse.twig.core.documentModel.dom;

import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.wst.xml.core.internal.document.AttrImpl;
import org.w3c.dom.Document;

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
