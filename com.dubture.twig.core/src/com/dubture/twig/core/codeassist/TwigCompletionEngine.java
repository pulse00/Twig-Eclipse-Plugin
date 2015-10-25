/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Dawid Pakula <zulus@w3des.net>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.jface.text.IDocument;

import com.dubture.twig.core.ExtensionManager;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.IFilter;
import com.dubture.twig.core.model.IFunction;
import com.dubture.twig.core.model.ITag;
import com.dubture.twig.core.model.ITest;
import com.dubture.twig.internal.core.codeassist.CompletionCompanion;

public class TwigCompletionEngine implements ICompletionReporter {

	private CompletionRequestor requestor;

	private IProgressMonitor monitor;

	private IProject project;

	private ISourceRange sourceRange;

	protected ITwigCompletionContextResolver[] getContextResolvers() {
		return ExtensionManager.getInstance().getCompletionContextResolvers();
	}

	protected ITwigCompletionStrategyFactory[] getStrategyFactories() {
		return ExtensionManager.getInstance().getCompletionStrategyResolvers();
	}

	public void complete(IDocument document) {
		ITwigCompletionContextResolver[] contextResolvers = getContextResolvers();
		ITwigCompletionStrategyFactory[] strategyFactories = getStrategyFactories();
		ICompletionCompanion companion = new CompletionCompanion(project);
		List<ICompletionContext> validContexts = new LinkedList<ICompletionContext>();
		try {
			for (ITwigCompletionContextResolver resolver : contextResolvers) {
				for (ICompletionContext ctx : resolver.createContexts(project)) {
					ctx.init(companion);
					if (ctx.isValid(document, sourceRange.getOffset(), monitor)) {
						validContexts.add(ctx);
					}
				}
			}
			if (validContexts.size() > 1) {
				for (Iterator<ICompletionContext> iterator = validContexts.iterator(); iterator.hasNext();) {
					if (iterator.next().isExclusive()) {
						iterator.remove();
					}
				}
			}
		} catch (Throwable e) {
			Logger.logException(e);
		}
		ICompletionContext[] result = validContexts.toArray(new ICompletionContext[validContexts.size()]);
		if (monitor.isCanceled() || result.length == 0) {
			return;
		}

		for (ITwigCompletionStrategyFactory factory : strategyFactories) {
			for (ICompletionStrategy str : factory.create(result)) {
				str.init(companion);
				try {
					str.apply(this);
				} catch (Exception e) {
					requestor.setErrorMessage(e.getMessage());
					Logger.logException(e);
				}

				if (monitor.isCanceled()) {
					return;
				}

			}
		}
	}

	public CompletionRequestor getRequestor() {
		return requestor;
	}

	public IProject getProject() {
		return project;
	}

	public ISourceRange getSourceRange() {
		return sourceRange;
	}

	public IProgressMonitor getMonitor() {
		return monitor;
	}

	public void setMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public void setRequestor(CompletionRequestor requestor) {
		this.requestor = requestor;
	}

	public void setSourceRange(ISourceRange sourceRange) {
		this.sourceRange = sourceRange;
	}

	@Override
	public void acceptProposal(CompletionProposal proposal) {
		requestor.acceptProposal(proposal);
	}

	@Override
	public void reportResource(IPath path, ISourceRange position) {
		reportResource(path, position, ICompletionProposalFlag.NO_FLAGS);
	}

	@Override
	public void reportResource(IPath path, ISourceRange position, ICompletionProposalFlag[] flags) {
		reportResource(path, null, position, flags);
	}

	@Override
	public void reportResource(IPath path, String completion, ISourceRange position, ICompletionProposalFlag[] flags) {
		CompletionProposal proposal = new CompletionProposal(CompletionProposal.RESOURCE_REF);
		proposal.setCompletion(completion == null ? path.toString() : completion);
		proposal.setFlags(flags);
		proposal.setName(path.lastSegment());
		proposal.setReplaceRange(position.getOffset(), position.getOffset() + position.getLength());

		acceptProposal(proposal);
	}

	@Override
	public void reportFilter(IFilter filter, ISourceRange position) {
		reportFilter(filter, position, ICompletionProposalFlag.NO_FLAGS);
	}

	@Override
	public void reportFilter(IFilter filter, ISourceRange position, ICompletionProposalFlag[] flags) {
		reportFilter(filter, null, position, flags);
	}

	@Override
	public void reportFilter(IFilter filter, String completion, ISourceRange position,
			ICompletionProposalFlag[] flags) {
		CompletionProposal proposal = new CompletionProposal(CompletionProposal.FILTER_REF);

		proposal.setCompletion(completion == null ? filter.getElementName() : completion);
		proposal.setFlags(flags);
		proposal.setReplaceRange(position.getOffset(), position.getOffset() + position.getLength());
		proposal.setName(filter.getElementName());
		proposal.setModelElement(filter);
		proposal.setParameterNames(filter.getParameterNames());

		acceptProposal(proposal);
	}

	@Override
	public void reportFunction(IFunction function, ISourceRange position) {
		reportFunction(function, position, ICompletionProposalFlag.NO_FLAGS);
	}

	@Override
	public void reportFunction(IFunction function, ISourceRange position, ICompletionProposalFlag[] flags) {
		reportFunction(function, null, position, flags);
	}

	@Override
	public void reportFunction(IFunction function, String completion, ISourceRange position,
			ICompletionProposalFlag[] flags) {
		CompletionProposal proposal = new CompletionProposal(CompletionProposal.METHOD_REF);

		proposal.setCompletion(completion == null ? function.getElementName() : completion);
		proposal.setFlags(flags);
		proposal.setReplaceRange(position.getOffset(), position.getOffset() + position.getLength());
		proposal.setName(function.getElementName());
		proposal.setModelElement(function);
		proposal.setParameterNames(function.getParameterNames());

		acceptProposal(proposal);
	}

	@Override
	public void reportTag(ITag tag, ISourceRange position) {
		reportTag(tag, position, ICompletionProposalFlag.NO_FLAGS);
	}

	@Override
	public void reportTag(ITag tag, ISourceRange position, ICompletionProposalFlag[] flags) {
		reportTag(tag, null, position, flags);

	}

	@Override
	public void reportTag(ITag tag, String completion, ISourceRange position, ICompletionProposalFlag[] flags) {
		CompletionProposal proposal = new CompletionProposal(CompletionProposal.TAG_REF);

		proposal.setCompletion(completion == null ? tag.getElementName() : completion);
		proposal.setFlags(flags);
		proposal.setReplaceRange(position.getOffset(), position.getOffset() + position.getLength());
		proposal.setName(tag.getElementName());
		proposal.setModelElement(tag);

		acceptProposal(proposal);
	}

	@Override
	public void reportTest(ITest test, ISourceRange position) {
		reportTest(test, position, ICompletionProposalFlag.NO_FLAGS);
	}

	@Override
	public void reportTest(ITest test, ISourceRange position, ICompletionProposalFlag[] flags) {
		reportTest(test, null, position, flags);

	}

	@Override
	public void reportTest(ITest test, String completion, ISourceRange position, ICompletionProposalFlag[] flags) {
		CompletionProposal proposal = new CompletionProposal(CompletionProposal.TEST_REF);

		proposal.setCompletion(completion == null ? test.getElementName() : completion);
		proposal.setFlags(flags);
		proposal.setReplaceRange(position.getOffset(), position.getOffset() + position.getLength());
		proposal.setName(test.getElementName());
		proposal.setModelElement(test);

		acceptProposal(proposal);
	}

	@Override
	public void reportKeyword(String keyword, ISourceRange position) {
		reportKeyword(keyword, position, ICompletionProposalFlag.NO_FLAGS);
	}

	@Override
	public void reportKeyword(String keyword, ISourceRange position, ICompletionProposalFlag[] flags) {
		CompletionProposal proposal = new CompletionProposal(CompletionProposal.KEYWORD);

		proposal.setName(keyword);
		proposal.setCompletion(keyword);
		proposal.setFlags(flags);
		proposal.setReplaceRange(position.getOffset(), position.getOffset() + position.getLength());

		acceptProposal(proposal);
	}

}
