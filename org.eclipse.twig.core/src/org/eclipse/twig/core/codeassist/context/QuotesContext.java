package org.eclipse.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;


/**
 * 
 * A context for staying inside a twig quotes string, ie
 * 
 * 
 * <pre>
 * 
 *   {{ path('|    <--- quotes context
 * 
 * </pre>
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class QuotesContext extends AbstractTwigCompletionContext {
	
	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {

		if (super.isValid(sourceModule, offset, requestor)) {
		
			return getPartitionType() == TwigPartitionTypes.TWIG_QUOTED_STRING;			
			
		}		
		
		return false;
	}

}
