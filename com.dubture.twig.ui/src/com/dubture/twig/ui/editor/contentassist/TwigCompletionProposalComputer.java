/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.contentassist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.ITextFileBuffer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.SourceRange;
import org.eclipse.wst.sse.ui.contentassist.CompletionProposalInvocationContext;
import org.eclipse.wst.sse.ui.contentassist.ICompletionProposalComputer;

import com.dubture.twig.core.codeassist.TwigCompletionEngine;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("rawtypes")
public class TwigCompletionProposalComputer implements ICompletionProposalComputer {

	private TwigCompletionProposalCollector collector;

	public TwigCompletionProposalComputer() {
		collector = new TwigCompletionProposalCollector();
	}

	@Override
	public void sessionStarted() {
		collector.beginSession();
	}

	@Override
	public List computeCompletionProposals(CompletionProposalInvocationContext context, IProgressMonitor monitor) {
		TwigCompletionEngine twigCompletionEngine = new TwigCompletionEngine();
		twigCompletionEngine.setMonitor(monitor);
		twigCompletionEngine.setRequestor(collector);
		twigCompletionEngine.setSourceRange(new SourceRange(context.getInvocationOffset(), 0));
		ITextFileBuffer fileBuffer = FileBuffers.getTextFileBufferManager().getTextFileBuffer(context.getDocument());
		if (fileBuffer != null) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(fileBuffer.getLocation());
			if (file != null && file.exists()) {
				twigCompletionEngine.setProject(file.getProject());
			}
		}
		twigCompletionEngine.complete(context.getDocument());
		return Arrays.asList(collector.getProposals());
	}

	@Override
	public List computeContextInformation(CompletionProposalInvocationContext context, IProgressMonitor monitor) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public String getErrorMessage() {
		return collector.getErrorMessage();
	}

	@Override
	public void sessionEnded() {
		collector.endSession();
	}

}
