/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.outline;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;

import com.dubture.twig.core.documentModel.TwigDOMModelParser;
import com.dubture.twig.core.documentModel.dom.ElementImplForTwig;
import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;
import com.dubture.twig.core.documentModel.parser.regions.TwigScriptRegion;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.TwigPluginImages;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class TwigOutlineLabelProvider extends XMLLabelProvider {

	public TwigOutlineLabelProvider() {
		super();
	}

	@Override
	public Image getImage(Object o) {
		if (o instanceof ElementImplForTwig) {
			ElementImplForTwig element = (ElementImplForTwig) o;
			if (TwigDOMModelParser.TWIG_STMT_TAG.equals(element.getNodeName())) {
				return TwigPluginImages.get(TwigPluginImages.IMG_OBJS_STATEMENT);
			} else if (TwigDOMModelParser.TWIG_STMT_TAG.equals(element.getNodeName())) {
				return TwigPluginImages.get(TwigPluginImages.IMG_OBJS_PRINT);
			}
		}
		return super.getImage(o);
	}

	@Override
	public String getText(Object o) {

		if (o instanceof ElementImplForTwig) {
			ElementImplForTwig element = (ElementImplForTwig) o;
			if (TwigDOMModelParser.TWIG_STMT_TAG.equals(element.getNodeName())) {
				IStructuredDocumentRegion flatNode = element.getFirstStructuredDocumentRegion();
				if (flatNode.getNumberOfRegions() > 1) {
					ITextRegion scriptRegion = flatNode.getRegions().get(1);
					if (scriptRegion instanceof TwigScriptRegion) {
						TwigScriptRegion twig = (TwigScriptRegion) scriptRegion;
						if (twig.getTokenCount() > 0) {
							try {
								ITextRegion nameRegion = null;
								for (int i = 0; i < twig.getTokenCount(); i++) {
									if (TwigRegionTypes.TWIG_BLOCKNAME.equals(twig.getTwigTokenType(i))) {
										nameRegion = twig.getTwigToken(i);
									}
								}
								if (nameRegion == null) {
									return element.getTagName();
								}
								return flatNode.getText(scriptRegion)
										.substring(nameRegion.getStart(), nameRegion.getEnd()).trim();
							} catch (BadLocationException e) {
								Logger.logException(e);
							}
						}
					}

				}
			}
			return element.getTagName();
		}

		return super.getText(o);
	}
}
