package com.dubture.twig.core.documentModel.dom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.wst.xml.core.internal.document.TextImpl;
import org.w3c.dom.Document;

import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;

@SuppressWarnings("restriction")
public class TextImplForTwig extends TextImpl implements IAdaptable, IImplForTwig {

	private IModelElement modelElement;

	protected TextImplForTwig() {
		super();
	}

	protected TextImplForTwig(Document doc, String data) {
		super();
		setOwnerDocument(doc);
		setData(data);
	}

	protected boolean isNotNestedContent(String regionType) {
		return regionType != TwigRegionTypes.TWIG_CONTENT;
	}

	protected void setOwnerDocument(Document ownerDocument) {
		super.setOwnerDocument(ownerDocument);
	}

	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	public IModelElement getModelElement() {
		return modelElement;
	}

	public void setModelElement(IModelElement modelElement) {
		this.modelElement = modelElement;
	}
}