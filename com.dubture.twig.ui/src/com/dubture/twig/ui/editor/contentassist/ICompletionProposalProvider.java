/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.contentassist;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

import com.dubture.twig.core.codeassist.CompletionProposal;

public interface ICompletionProposalProvider {

	ICompletionProposal createCompletionProposal(CompletionProposal proposal);
}
