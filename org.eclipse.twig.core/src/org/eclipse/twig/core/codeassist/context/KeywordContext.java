package org.eclipse.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;


/**
 * 
 * Context for twig Keywords.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class KeywordContext extends AbstractTwigCompletionContext {
	
	
	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {
			
		try {
			if (super.isValid(sourceModule, offset, requestor)) {
								
				if (getPartitionType() == TwigPartitionTypes.TWIG_QUOTED_STRING)
					return false;
				
				
				String prefix = getPrefix();
				
				if (!prefix.contains(".") && !prefix.contains("\"") && !prefix.contains("'"))
					return true;
				
			}
		} catch (BadLocationException e) {

			e.printStackTrace();
		}		
		
		return false;
	}
}