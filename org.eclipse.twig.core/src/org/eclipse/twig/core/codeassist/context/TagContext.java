package org.eclipse.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;

/**
 * 
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TagContext extends KeywordContext {
	
	
	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {

		
		if (super.isValid(sourceModule, offset, requestor)) {


			return true;
			
		}
		
		
		return false;
	}

}
