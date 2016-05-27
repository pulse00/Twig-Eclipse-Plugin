package com.dubture.twig.ui.editor.contentassist.proposals;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

public class TwigCompletionProposal extends AbstractTwigCompletionProposal {
	public TwigCompletionProposal(StyledString name, String replacement, Image image, int offset, int end,
			int relevance) {
		setStyledDisplayString(name);
		setReplacementString(replacement);
		setReplacementOffset(offset);
		setReplacementLength(end > 0 ? end - offset : 0);
		setCursorPosition(replacement.length());
		setImage(image);
	}

	public TwigCompletionProposal(String name, String replacement, Image image, int offset, int end, int relevance) {
		this(new StyledString(name), replacement, image, offset, end, relevance);
	}
}
