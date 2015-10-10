/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.contentassist;

import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.ui.text.completion.ProposalInfo;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector;
import org.eclipse.jface.resource.ImageDescriptor;

public interface ICompletionProposalProvider {
	ProposalInfo createScriptCompletionProposal(CompletionProposal proposal,
			ScriptCompletionProposalCollector collector);

	ImageDescriptor createTypeImageDescriptor(CompletionProposal proposal);
}
