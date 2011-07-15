package org.eclipse.twig.core.format.htmlFormatters;


import org.eclipse.twig.core.documentModel.dom.ElementImplForTwig;
import org.eclipse.twig.core.format.TwigFormatter;
import org.eclipse.wst.sse.core.internal.format.IStructuredFormatPreferences;
import org.eclipse.wst.sse.core.internal.format.IStructuredFormatter;
import org.w3c.dom.Node;

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

	public IStructuredFormatter createFormatter(Node node,
			IStructuredFormatPreferences formatPreferences) {
		IStructuredFormatter formatter = null;

		switch (node.getNodeType()) {
		case Node.ELEMENT_NODE:
			if (node instanceof ElementImplForTwig
					&& ((ElementImplForTwig) node).isTwigTag()) {
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
