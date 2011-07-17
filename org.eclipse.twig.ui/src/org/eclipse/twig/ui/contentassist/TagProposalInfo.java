package org.eclipse.twig.ui.contentassist;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.ui.text.completion.MemberProposalInfo;
import org.eclipse.twig.core.model.Tag;

public class TagProposalInfo extends MemberProposalInfo {

	public TagProposalInfo(IScriptProject project, CompletionProposal proposal) {
		super(project, proposal);

	}
	
	@Override
	public String getInfo(IProgressMonitor monitor) {
 
		try {
			
			Tag tag = (Tag) getModelElement();
			
			if (tag != null) {
				
				
				return tag.getPhpClass() + " <br/><br/>" + tag.getDescription();
			}
			
			
			return "";			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}			

}
