package com.dubture.twig.ui.editor.contentassist.proposals;

import org.eclipse.dltk.ui.DLTKPluginImages;

public class KeywordCompletionProposal extends TwigCompletionProposal {

	public KeywordCompletionProposal(String keyword, int offset, int end, int relevance) {
		super(keyword, keyword, DLTKPluginImages.get(DLTKPluginImages.IMG_OBJS_KEYWORD), offset, end, relevance);
	}
}
