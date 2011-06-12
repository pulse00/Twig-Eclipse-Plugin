package org.eclipse.twig.ui.editor.configuration;

import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.text.completion.AbstractScriptCompletionProposal;
import org.eclipse.dltk.ui.text.completion.IScriptCompletionProposal;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalCollector;
import org.eclipse.php.internal.ui.util.PHPPluginImages;
import org.eclipse.twig.core.TwigNature;

@SuppressWarnings("restriction")
public class TwigCompletionProposalCollector extends
		PHPCompletionProposalCollector {


	public TwigCompletionProposalCollector(IDocument document,
			ISourceModule cu, boolean explicit) {
		super(document, cu, explicit);

	}

	@Override
	protected String getNatureId() {

		
		System.err.println("get collector id");
		return TwigNature.NATURE_ID;

	}
	
	
	protected IScriptCompletionProposal createKeywordProposal(
			CompletionProposal proposal) {
		

		System.err.println("create keyword proposal");
		
		
		return super.createKeywordProposal(proposal);
	}
	

}
