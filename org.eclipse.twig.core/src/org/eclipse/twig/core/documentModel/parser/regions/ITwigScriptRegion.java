package org.eclipse.twig.core.documentModel.parser.regions;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;

@SuppressWarnings("restriction")
public interface ITwigScriptRegion extends ITextRegion {

	ITextRegion getTwigToken(int i) throws BadLocationException;
		


}
