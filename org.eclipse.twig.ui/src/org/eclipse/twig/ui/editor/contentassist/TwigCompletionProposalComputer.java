package org.eclipse.twig.ui.editor.contentassist;

import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalComputer;


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
	
		return new TwigTemplateCompletionProcessor(context);
		
		
	}


	@Override
	protected ScriptCompletionProposalCollector createCollector(
			ScriptContentAssistInvocationContext context) {

		return new TwigCompletionProposalCollector(context.getDocument(), context.getSourceModule(), true);
		
	}

}
