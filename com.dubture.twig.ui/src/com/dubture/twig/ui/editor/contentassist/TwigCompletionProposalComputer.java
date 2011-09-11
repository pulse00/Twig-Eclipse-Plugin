package com.dubture.twig.ui.editor.contentassist;

import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalComputer;
import org.eclipse.php.internal.ui.editor.contentassist.PHPContentAssistInvocationContext;


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
	PHPCompletionProposalComputer {

	public TwigCompletionProposalComputer() {

	}
	
	
	@Override
	protected TemplateCompletionProcessor createTemplateProposalComputer(
			ScriptContentAssistInvocationContext context) {
	
		boolean explicit = false;
		if (context instanceof PHPContentAssistInvocationContext) {
			explicit = ((PHPContentAssistInvocationContext) context)
					.isExplicit();
		}
		
		return new TwigTemplateCompletionProcessor(context, explicit);
		
		
	}


	@Override
	protected ScriptCompletionProposalCollector createCollector(
			ScriptContentAssistInvocationContext context) {

		return new TwigCompletionProposalCollector(context.getDocument(), context.getSourceModule(), true);
		
	}

}
