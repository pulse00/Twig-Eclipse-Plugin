package org.eclipse.twig.ui.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.php.internal.ui.editor.highlighter.LineStyleProviderForPhp;
import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.twig.ui.PreferenceConstants;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;

/**
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class LineStyleProviderForTwig extends LineStyleProviderForPhp {


	static {
		fColorTypes.put(TwigRegionContext.TWIG_OPEN, PreferenceConstants.EDITOR_BOUNDARYMARKER_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_CLOSE, PreferenceConstants.EDITOR_BOUNDARYMARKER_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_CONTENT, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_COMMENT, PreferenceConstants.EDITOR_COMMENT_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_VARIABLE, PreferenceConstants.EDITOR_VARIABLE_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_DELIMITER, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_WHITESPACE, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_NUMBER, PreferenceConstants.EDITOR_NUMBER_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_LABEL, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING, PreferenceConstants.EDITOR_STRING_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_DOUBLE_QUOTES_CONTENT, PreferenceConstants.EDITOR_STRING_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_DOUBLE_QUOTES_START, PreferenceConstants.EDITOR_STRING_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_DOUBLE_QUOTES_END, PreferenceConstants.EDITOR_STRING_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_BACKTICK_END, PreferenceConstants.EDITOR_LABEL_COLOR);
		fColorTypes.put(TwigRegionContext.TWIG_BACKTICK_START, PreferenceConstants.EDITOR_LABEL_COLOR);
	}

	protected TextAttribute getAttributeFor(ITextRegion region) {
		final String type = region.getType();
		if (type != null && type.startsWith("TWIG_")) {
			return getAttributeFor(type);
		}

		return super.getAttributeFor(region);
	}	

}
