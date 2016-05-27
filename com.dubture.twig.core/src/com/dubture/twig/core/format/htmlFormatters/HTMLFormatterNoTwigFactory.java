/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.format.htmlFormatters;

import org.eclipse.wst.sse.core.internal.format.IStructuredFormatPreferences;
import org.eclipse.wst.sse.core.internal.format.IStructuredFormatter;
import org.w3c.dom.Node;

import com.dubture.twig.core.documentModel.dom.ElementImplForTwig;
import com.dubture.twig.core.format.TwigFormatter;

@SuppressWarnings("restriction")
public class HTMLFormatterNoTwigFactory {

	private static HTMLFormatterNoTwigFactory fInstance = null;

	public int start;
	public int length;

	public static synchronized HTMLFormatterNoTwigFactory getInstance() {
		if (fInstance == null) {
			fInstance = new HTMLFormatterNoTwigFactory();
		}
		return fInstance;
	}

	public IStructuredFormatter createFormatter(Node node, IStructuredFormatPreferences formatPreferences) {
		IStructuredFormatter formatter = null;

		switch (node.getNodeType()) {
		case Node.ELEMENT_NODE:
			if (node instanceof ElementImplForTwig && ((ElementImplForTwig) node).isTwigTag()) {
				formatter = new TwigFormatter(start, length);

			} else {
				formatter = new HtmlElementFormatterNoTwig();
			}

			break;
		case Node.TEXT_NODE:
			if (isEmbeddedCSS(node)) {
				formatter = new EmbeddedCSSFormatterNoTwig();
			} else {
				formatter = new HTMLTextFormatterNoTwig();
			}
			break;
		default:
			formatter = new HTMLFormatterNoTwig();
			break;
		}

		// init FormatPreferences
		formatter.setFormatPreferences(formatPreferences);

		return formatter;
	}

	/**
	 */
	private boolean isEmbeddedCSS(Node node) {
		if (node == null)
			return false;
		Node parent = node.getParentNode();
		if (parent == null)
			return false;
		if (parent.getNodeType() != Node.ELEMENT_NODE)
			return false;
		String name = parent.getNodeName();
		if (name == null)
			return false;
		return name.equalsIgnoreCase("STYLE");//$NON-NLS-1$
	}

}
