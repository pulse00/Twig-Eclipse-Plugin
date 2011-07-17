package org.eclipse.twig.ui.editor;

import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalLabelProvider;
import org.eclipse.twig.core.model.Tag;
import org.eclipse.twig.ui.TwigPluginImages;


/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigCompletionProposalLabelProvider extends
		PHPCompletionProposalLabelProvider {

	
	@Override
	public ImageDescriptor createTypeImageDescriptor(CompletionProposal proposal) {

		IModelElement element = proposal.getModelElement();
		
		
		if (element.getClass() == Tag.class) {
			
			return TwigPluginImages.DESC_OBJS_TAG;

		} 
		
		return super.createTypeImageDescriptor(proposal);
	}
}
