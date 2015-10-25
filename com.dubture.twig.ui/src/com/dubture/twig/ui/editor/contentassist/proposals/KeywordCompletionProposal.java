package com.dubture.twig.ui.editor.contentassist.proposals;

import org.eclipse.dltk.ui.DLTKPluginImages;
import org.eclipse.jface.viewers.StyledString;

public class KeywordCompletionProposal extends AbstractTwigCompletionProposal {

	public KeywordCompletionProposal(String keyword, int offset, int end, int relevance) {
		setStyledDisplayString(new StyledString(keyword));
		setReplacementOffset(offset);
		setReplacementLength(0);
		setReplacementString(keyword);
		setCursorPosition(keyword.length());

		setImage(DLTKPluginImages.get(DLTKPluginImages.IMG_OBJS_KEYWORD));
	}
}
