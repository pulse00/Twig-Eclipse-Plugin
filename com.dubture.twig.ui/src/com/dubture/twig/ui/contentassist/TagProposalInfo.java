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

import com.dubture.twig.core.model.Tag;
import com.dubture.twig.ui.utils.HTMLUtils;

/**
 * 
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
public class TagProposalInfo extends MemberProposalInfo {

	public TagProposalInfo(IScriptProject project, CompletionProposal proposal) {
		super(project, proposal);

	}

	@Override
	public String getInfo(IProgressMonitor monitor) {

		try {

			Tag tag = (Tag) getModelElement();

			if (tag != null) {
				return HTMLUtils.tag2Html(tag);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
}
