package org.eclipse.twig.ui.editor.configuration;

import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalComputer;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;


/**
 * 
 * Creates the {@link TwigTemplateCompletionProcessor}
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigCompletionProposalComputer extends
	ScriptCompletionProposalComputer {

	public TwigCompletionProposalComputer() {

	}
	
	
	@Override
	protected TemplateCompletionProcessor createTemplateProposalComputer(
			ScriptContentAssistInvocationContext context) {
	

		return null;
//		System.err.println("create template processor");
//		return new TwigTemplateCompletionProcessor(context);
		
	}


	@Override
	protected ScriptCompletionProposalCollector createCollector(
			ScriptContentAssistInvocationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

}
