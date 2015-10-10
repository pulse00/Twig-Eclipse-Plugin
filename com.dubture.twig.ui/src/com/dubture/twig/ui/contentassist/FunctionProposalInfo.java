/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.contentassist;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.ui.text.completion.MemberProposalInfo;

public class FunctionProposalInfo extends MemberProposalInfo {

	public FunctionProposalInfo(IScriptProject project, CompletionProposal proposal) {
		super(project, proposal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getInfo(IProgressMonitor monitor) {

		try {

			// Function tag = (Function) getModelElement();

			// if (tag != null && tag.getPHPClass() != null) {
			// return tag.getPHPClass() + " <br/><br/>";
			// }

			return "";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
}
