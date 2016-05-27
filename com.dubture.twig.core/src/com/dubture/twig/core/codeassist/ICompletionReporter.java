package com.dubture.twig.core.codeassist;

import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.core.ISourceRange;

import com.dubture.twig.core.model.IFilter;
import com.dubture.twig.core.model.IFunction;
import com.dubture.twig.core.model.ITag;
import com.dubture.twig.core.model.ITest;

/**
 * TODO: relevance support
 * 
 * @noimplement
 * @noextend
 * @author zulus
 */
public interface ICompletionReporter {
	public void acceptProposal(CompletionProposal proposal);

	public void reportResource(IPath path, ISourceRange position);

	public void reportResource(IPath path, ISourceRange position, ICompletionProposalFlag[] flags);

	public void reportResource(IPath path, String completion, ISourceRange position, ICompletionProposalFlag[] flags);

	public void reportFilter(IFilter filter, ISourceRange position);

	public void reportFilter(IFilter filter, ISourceRange position, ICompletionProposalFlag[] flags);

	public void reportFilter(IFilter filter, String completion, ISourceRange position, ICompletionProposalFlag[] flags);

	public void reportFunction(IFunction filter, ISourceRange position);

	public void reportFunction(IFunction filter, ISourceRange position, ICompletionProposalFlag[] flags);

	public void reportFunction(IFunction filter, String completion, ISourceRange position,
			ICompletionProposalFlag[] flags);

	public void reportTag(ITag filter, ISourceRange position);

	public void reportTag(ITag filter, ISourceRange position, ICompletionProposalFlag[] flags);

	public void reportTag(ITag filter, String completion, ISourceRange position, ICompletionProposalFlag[] flags);

	public void reportTest(ITest filter, ISourceRange position);

	public void reportTest(ITest filter, ISourceRange position, ICompletionProposalFlag[] flags);

	public void reportTest(ITest filter, String completion, ISourceRange position, ICompletionProposalFlag[] flags);

	public void reportKeyword(String keyword, ISourceRange position);

	public void reportKeyword(String keyword, ISourceRange position, ICompletionProposalFlag[] flags);
}
