/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.contentassist;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.wst.sse.ui.contentassist.CompletionProposalInvocationContext;
import org.eclipse.wst.sse.ui.contentassist.ICompletionProposalComputer;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("rawtypes")
public class TwigCompletionProposalComputer implements ICompletionProposalComputer {

	public TwigCompletionProposalComputer() {

	}

	@Override
	public void sessionStarted() {
		;
	}

	@Override
	public List computeCompletionProposals(CompletionProposalInvocationContext context, IProgressMonitor monitor) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public List computeContextInformation(CompletionProposalInvocationContext context, IProgressMonitor monitor) {
		return Collections.EMPTY_LIST;
	}

	@Override
	public String getErrorMessage() {
		return null;
	}

	@Override
	public void sessionEnded() {

	}

}
