package com.dubture.twig.ui.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

public interface ITwigCompletionProposal extends ICompletionProposal {
	public int getRelevance();
}
