/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel;

import org.eclipse.wst.html.core.internal.document.DOMStyleModelImpl;
import org.eclipse.wst.sse.core.internal.provisional.IndexedRegion;
import org.eclipse.wst.xml.core.internal.document.XMLModelParser;
import org.eclipse.wst.xml.core.internal.document.XMLModelUpdater;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.w3c.dom.Document;

import com.dubture.twig.core.documentModel.dom.DOMDocumentForTwig;

@SuppressWarnings("restriction")
public class DOMModelForTwig extends DOMStyleModelImpl {

	@Override
	protected Document internalCreateDocument() {
		DOMDocumentForTwig document = new DOMDocumentForTwig();
		document.setModel(this);
		return document;
	}

	@Override
	protected XMLModelParser createModelParser() {

		return new TwigDOMModelParser(this);
	}

	@Override
	protected XMLModelUpdater createModelUpdater() {
		return new TwigDOMModelUpdater(this);
	}

	@Override
	public IndexedRegion getIndexedRegion(int offset) {
		IndexedRegion result = super.getIndexedRegion(offset);
		if (result == null && offset == getDocument().getEndOffset()) {
			return (IDOMNode) getDocument().getLastChild();
		}
		return super.getIndexedRegion(offset);
	}

}
