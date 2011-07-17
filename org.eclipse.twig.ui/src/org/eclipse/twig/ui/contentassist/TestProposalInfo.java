package org.eclipse.twig.ui.contentassist;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.ui.text.completion.MemberProposalInfo;

public class TestProposalInfo extends MemberProposalInfo {

	public TestProposalInfo(IScriptProject project, CompletionProposal proposal) {
		super(project, proposal);

	}
	
	
	@Override
	public String getInfo(IProgressMonitor monitor) {

	
		return "info";
	}

}
