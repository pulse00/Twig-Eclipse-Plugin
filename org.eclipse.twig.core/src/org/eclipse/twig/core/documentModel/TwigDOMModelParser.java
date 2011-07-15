package org.eclipse.twig.core.documentModel;

import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.xml.core.internal.document.DOMModelImpl;
import org.eclipse.wst.xml.core.internal.document.XMLModelParser;

@SuppressWarnings("restriction")
public class TwigDOMModelParser extends XMLModelParser {

	public static final String TWIG_TAG_NAME = "TWIG"; //$NON-NLS-1$

	public TwigDOMModelParser(DOMModelImpl model) {
		super(model);
	}

	protected boolean isNestedContent(String regionType) {
		return regionType == TwigRegionContext.TWIG_CONTENT;
	}

	protected boolean isNestedTag(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_OPEN
				|| regionType == TwigRegionContext.TWIG_STMT_CLOSE;
	}

	protected boolean isNestedTagOpen(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_OPEN;
	}

	protected String computeNestedTag(String regionType, String tagName,
			IStructuredDocumentRegion structuredDocumentRegion,
			ITextRegion region) {
		return TWIG_TAG_NAME;
	}

	protected boolean isNestedTagClose(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_CLOSE;
	}
}
