package org.eclipse.twig.core.documentModel.parser.regions;

import org.eclipse.core.resources.IProject;
import org.eclipse.twig.core.documentModel.parser.AbstractTwigLexer;
import org.eclipse.wst.sse.core.internal.parser.ForeignRegion;

@SuppressWarnings("restriction")
public class TwigScriptRegion extends ForeignRegion implements ITwigScriptRegion {

	private static final String TWIG_SCRIPT = "Twig Script";

	public TwigScriptRegion(String newContext, int newStart, int newTextLength,
			int newLength) {
		super(newContext, newStart, newTextLength, newLength);
		
		

	}
	
	public TwigScriptRegion(String newContext, int startOffset,
			IProject project, AbstractTwigLexer twigLexer) {
		super(newContext, startOffset, 0, 0, TwigScriptRegion.TWIG_SCRIPT);
		
	}
}