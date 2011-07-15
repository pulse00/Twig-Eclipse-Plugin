package org.eclipse.twig.core.documentModel.dom;

import org.eclipse.wst.html.core.internal.document.DocumentStyleImpl;
import org.eclipse.wst.xml.core.internal.document.DocumentImpl;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * 
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class DOMDocumentForTwig extends DocumentStyleImpl {
	
	public DOMDocumentForTwig() {
		super();
	}

	protected DOMDocumentForTwig(DocumentImpl that) {
		super(that);
	}

	public Node cloneNode(boolean deep) {
		DOMDocumentForTwig cloned = new DOMDocumentForTwig(this);
		if (deep)
			cloned.importChildNodes(this, true);
		return cloned;
	}

	/**
	 * createElement method
	 * 
	 * @return org.w3c.dom.Element
	 * @param tagName
	 *            java.lang.String
	 */
	
	public Element createElement(String tagName) throws DOMException {
		checkTagNameValidity(tagName);

		ElementImplForTwig element = new ElementImplForTwig();
		element.setOwnerDocument(this);
		element.setTagName(tagName);
		return element;
	}

	/**
	 * createAttribute method
	 * 
	 * @return org.w3c.dom.Attr
	 * @param name
	 *            java.lang.String
	 */
	public Attr createAttribute(String name) throws DOMException {
		
		AttrImplForTwig attr = new AttrImplForTwig();
		attr.setOwnerDocument(this);
		attr.setName(name);
		return attr;
	}

	/**
	 * createTextNode method
	 * 
	 * @return org.w3c.dom.Text
	 * @param data
	 *            java.lang.String
	 */
	public Text createTextNode(String data) {
		TextImplForTwig text = new TextImplForTwig();
		text.setOwnerDocument(this);
		text.setData(data);
		return text;
	}

	public void setModel(IDOMModel model) {
		super.setModel(model);
	}	

}
