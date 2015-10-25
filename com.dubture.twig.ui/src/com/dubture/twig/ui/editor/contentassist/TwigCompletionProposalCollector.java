package com.dubture.twig.ui.editor.contentassist;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

import com.dubture.twig.core.codeassist.CompletionProposal;
import com.dubture.twig.core.codeassist.CompletionRequestor;
import com.dubture.twig.ui.extension.ExtensionManager;

public class TwigCompletionProposalCollector extends CompletionRequestor {
	private ICompletionProposalProvider[] completionPropoviders;
	private List<CompletionProposal> unprocessedProposals = new LinkedList<CompletionProposal>();

	@Override
	public void beginSession() {
		super.beginSession();
		if (completionPropoviders == null) {
			completionPropoviders = getProviders();
		}
	}

	protected ICompletionProposalProvider[] getProviders() {
		return ExtensionManager.getInstance().getProposalExtensions();
	}

	@Override
	public void acceptProposal(CompletionProposal proposal) {
		unprocessedProposals.add(proposal);
	}

	@Override
	public void endSession() {
		super.endSession();
		synchronized (unprocessedProposals) {
			unprocessedProposals.clear();
		}
	}

	public ICompletionProposal[] getProposals() {
		List<ICompletionProposal> result = new LinkedList<ICompletionProposal>();

		for (CompletionProposal pr : unprocessedProposals) {
			ICompletionProposal proposal = getProposal(pr);
			if (proposal != null) {
				result.add(proposal);
			}
		}
		unprocessedProposals.clear();
		return result.toArray(new ICompletionProposal[result.size()]);
	}

	protected ICompletionProposal getProposal(CompletionProposal proposal) {
		for (ICompletionProposalProvider provider : completionPropoviders) {
			ICompletionProposal twigProposal = provider.createCompletionProposal(proposal);
			if (twigProposal != null) {
				return twigProposal;
			}
		}

		return null;
	}

}
