package org.eclipse.twig.core.format;

import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;

@SuppressWarnings("restriction")
public class TwigCloseTagIndentationStrategy extends DefaultIndentationStrategy {
	
	public void placeMatchingBlanks(final IStructuredDocument document,
			final StringBuffer result, final int lineNumber, final int forOffset) {
		// Ignore default behavior (don't add previous line's blanks)
	}
	

}
