package org.eclipse.twig.ui.editor.contentassist;

import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalCollector;
import org.eclipse.twig.core.TwigNature;
import org.eclipse.twig.ui.editor.TwigCompletionProposalLabelProvider;


/**
 * {@link TwigCompletionProposalCollector}
 * 
 *  
 *  Just here to provide the correct nature id.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigCompletionProposalCollector extends
		PHPCompletionProposalCollector {


	private TwigCompletionProposalLabelProvider lProvider = null;
	
	
	public TwigCompletionProposalCollector(IDocument document,
			ISourceModule cu, boolean explicit) {
		super(document, cu, explicit);

	}
	
	
	@Override
	public CompletionProposalLabelProvider getLabelProvider() {
		
		if (lProvider == null)
			lProvider = new TwigCompletionProposalLabelProvider();
		
		return lProvider;
	}

	@Override
	protected String getNatureId() {

		return TwigNature.NATURE_ID;

	}
	
	
	
}