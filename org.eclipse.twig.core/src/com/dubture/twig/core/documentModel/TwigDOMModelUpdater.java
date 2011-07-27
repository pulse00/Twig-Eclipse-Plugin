package org.eclipse.twig.core.documentModel;

import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.wst.xml.core.internal.document.DOMModelImpl;
import org.eclipse.wst.xml.core.internal.document.XMLModelUpdater;

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
public class TwigDOMModelUpdater extends XMLModelUpdater {
	
	public TwigDOMModelUpdater(DOMModelImpl model) {
		super(model);
	}
	
	protected boolean isNestedTagClose(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_CLOSE
				|| regionType == TwigRegionContext.TWIG_CLOSE;
	}	

}
