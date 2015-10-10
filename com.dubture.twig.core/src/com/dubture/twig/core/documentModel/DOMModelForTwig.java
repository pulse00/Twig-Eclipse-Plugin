/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel;

import org.eclipse.php.internal.core.documentModel.DOMModelForPHP;
import org.eclipse.wst.sse.core.internal.provisional.IndexedRegion;
import org.eclipse.wst.xml.core.internal.document.XMLModelParser;
import org.eclipse.wst.xml.core.internal.document.XMLModelUpdater;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.w3c.dom.Document;

import com.dubture.twig.core.documentModel.dom.DOMDocumentForTwig;

@SuppressWarnings("restriction")
public class DOMModelForTwig extends DOMModelForPHP {

	protected Document internalCreateDocument() {
		DOMDocumentForTwig document = new DOMDocumentForTwig();
		document.setModel(this);
		return document;
	}

	protected XMLModelParser createModelParser() {

		return new TwigDOMModelParser(this);
	}

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
