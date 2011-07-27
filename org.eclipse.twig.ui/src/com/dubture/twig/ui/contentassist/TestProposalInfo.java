package org.eclipse.twig.ui.contentassist;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.ui.text.completion.MemberProposalInfo;
import org.eclipse.twig.core.model.Test;
import org.eclipse.twig.ui.utils.HTMLUtils;

public class TestProposalInfo extends MemberProposalInfo {

	public TestProposalInfo(IScriptProject project, CompletionProposal proposal) {
		super(project, proposal);

	}
	
	
	@Override
	public String getInfo(IProgressMonitor monitor) {

		try {					
			Test test = (Test) getModelElement();
			if (test != null)
				return HTMLUtils.test2Html(test);
			
		} catch (ModelException e) {

			e.printStackTrace();
		}
			
		return "";
	}

}
