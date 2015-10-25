/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.dom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.wst.xml.core.internal.document.TextImpl;
import org.w3c.dom.Document;

import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;

@SuppressWarnings("restriction")
public class TextImplForTwig extends TextImpl implements IAdaptable, IImplForTwig {

	protected TextImplForTwig() {
		super();
	}

	protected TextImplForTwig(Document doc, String data) {
		super();
		setOwnerDocument(doc);
		setData(data);
	}

	@Override
	protected boolean isNotNestedContent(String regionType) {
		return regionType != TwigRegionTypes.TWIG_CONTENT;
	}

	@Override
	protected void setOwnerDocument(Document ownerDocument) {
		super.setOwnerDocument(ownerDocument);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getAdapter(Class adapter) {
		return Platform.getAdapterManager().getAdapter(this, adapter);
	}

	@Override
	public boolean isTwigTag() {
		return false;
	}
}
