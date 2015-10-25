package com.dubture.twig.ui.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

import com.dubture.twig.core.codeassist.CompletionProposal;
import com.dubture.twig.ui.editor.contentassist.proposals.KeywordCompletionProposal;

public class DefaultCompletionProposalProvider implements ICompletionProposalProvider {

	@Override
	public ICompletionProposal createCompletionProposal(CompletionProposal proposal) {
		switch (proposal.getKind()) {
		case CompletionProposal.KEYWORD:
			return new KeywordCompletionProposal(proposal.getName(), proposal.getReplaceStart(),
					proposal.getReplaceEnd(), proposal.getRelevance());
		case CompletionProposal.TAG_REF:
			return new KeywordCompletionProposal(proposal.getName() + " ", proposal.getReplaceStart(),
					proposal.getReplaceEnd(), proposal.getRelevance());
		}
		return null;
	}

}
