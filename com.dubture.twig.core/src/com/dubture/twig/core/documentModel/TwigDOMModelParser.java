/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel;

import org.eclipse.dltk.internal.core.util.LRUCache;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.xml.core.internal.document.DOMModelImpl;
import org.eclipse.wst.xml.core.internal.document.XMLModelParser;

import com.dubture.twig.core.TwigCorePlugin;
import com.dubture.twig.core.documentModel.parser.TwigRegionContext;
import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;

/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class TwigDOMModelParser extends XMLModelParser {

	public static final String TWIG_PRINT_TAG = "print"; //$NON-NLS-1$
	public static final String TWIG_STMT_TAG = "statement"; //$NON-NLS-1$

	private final LRUCache cache;

	public TwigDOMModelParser(DOMModelImpl model) {
		super(model);

		cache = new LRUCache();

	}

	@Override
	protected boolean isNestedContent(String regionType) {
		return regionType == TwigRegionContext.TWIG_CONTENT;
	}

	@Override
	protected boolean isNestedTag(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_OPEN || regionType == TwigRegionContext.TWIG_OPEN
				|| regionType == TwigRegionContext.TWIG_CLOSE || regionType == TwigRegionContext.TWIG_STMT_CLOSE;
	}

	@Override
	protected boolean isNestedTagOpen(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_OPEN || regionType == TwigRegionContext.TWIG_OPEN;
	}

	@Override
	protected String computeNestedTag(String regionType, String tagName,
			IStructuredDocumentRegion structuredDocumentRegion, ITextRegion region) {

		if (regionType.equals(TwigRegionTypes.TWIG_STMT_OPEN)) {
			try {

				String text = structuredDocumentRegion.getText();
				Object cached = cache.get(text);

				if (cached != null) {
					return (String) cached;
				}
			} catch (Exception e) {
				TwigCorePlugin.log(e);
			}

			return TWIG_STMT_TAG;

		} else if (regionType.equals(TwigRegionTypes.TWIG_OPEN)) {

			return TWIG_PRINT_TAG;
		}

		return TWIG_STMT_TAG;
	}

	@Override
	protected boolean isNestedTagClose(String regionType) {
		return regionType == TwigRegionContext.TWIG_STMT_CLOSE || regionType == TwigRegionContext.TWIG_CLOSE;
	}
}
