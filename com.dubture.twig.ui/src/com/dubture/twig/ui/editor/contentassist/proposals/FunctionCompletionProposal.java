package com.dubture.twig.ui.editor.contentassist.proposals;

import org.eclipse.dltk.ui.DLTKPluginImages;

import com.dubture.twig.core.model.IFunction;

public class FunctionCompletionProposal extends TwigCompletionProposal {
	public FunctionCompletionProposal(IFunction function, int offset, int end, int relevance) {
		super(function.getElementName(), function.getElementName() + "()",
				DLTKPluginImages.get(DLTKPluginImages.IMG_METHOD_PUBLIC), offset, end, relevance);
		setCursorPosition(getCursorPosition() - 1);
	}
}
