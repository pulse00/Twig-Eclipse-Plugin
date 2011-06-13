package org.eclipse.twig.ui.editor.contentassist;

import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalCollector;
import org.eclipse.twig.core.TwigNature;


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


	public TwigCompletionProposalCollector(IDocument document,
			ISourceModule cu, boolean explicit) {
		super(document, cu, explicit);

	}

	@Override
	protected String getNatureId() {

		return TwigNature.NATURE_ID;

	}
}