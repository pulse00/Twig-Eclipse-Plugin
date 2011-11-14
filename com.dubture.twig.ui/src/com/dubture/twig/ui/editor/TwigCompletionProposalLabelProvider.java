/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor;

import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalLabelProvider;

import com.dubture.twig.core.model.Filter;
import com.dubture.twig.core.model.Function;
import com.dubture.twig.core.model.Tag;
import com.dubture.twig.core.model.Test;
import com.dubture.twig.ui.TwigPluginImages;


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

		} else if (element.getClass() == Filter.class) {
			
			return TwigPluginImages.DESC_OBJS_FILTER;
		} else if (element.getClass() == Function.class) {
			
			return TwigPluginImages.DESC_OBJS_FUNCTION;
		} else if (element.getClass() == Test.class) {
			
			return TwigPluginImages.DESC_OBJS_TEST;
		}
		
		return super.createTypeImageDescriptor(proposal);
	}
}
