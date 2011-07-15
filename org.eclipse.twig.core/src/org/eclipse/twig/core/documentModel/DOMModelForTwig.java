package org.eclipse.twig.core.documentModel;

import org.eclipse.twig.core.documentModel.dom.DOMDocumentForTwig;
import org.eclipse.wst.html.core.internal.document.DOMStyleModelImpl;
import org.eclipse.wst.sse.core.internal.provisional.IndexedRegion;
import org.eclipse.wst.xml.core.internal.document.XMLModelParser;
import org.eclipse.wst.xml.core.internal.document.XMLModelUpdater;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.w3c.dom.Document;

@SuppressWarnings("restriction")
public class DOMModelForTwig extends DOMStyleModelImpl {
	

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
		if(result == null && offset == getDocument().getEndOffset()){
			return (IDOMNode) getDocument().getLastChild();
		}
		return super.getIndexedRegion(offset);
	}	

}
