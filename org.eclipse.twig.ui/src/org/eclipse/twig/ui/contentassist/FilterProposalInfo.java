package org.eclipse.twig.ui.contentassist;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.ui.text.completion.MemberProposalInfo;
import org.eclipse.twig.core.model.Filter;

/**
 * 
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class FilterProposalInfo extends MemberProposalInfo {

	public FilterProposalInfo(IScriptProject project,
			CompletionProposal proposal) {
		super(project, proposal);

	}
	
	
	@Override
	public String getInfo(IProgressMonitor monitor) {
 
		try {
			
			Filter tag = (Filter) getModelElement();
			
			if (tag != null && tag.getPHPClass() != null) {
				return tag.getPHPClass() + " <br/><br/>";
			}
			
			
			return "";			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}				

}
