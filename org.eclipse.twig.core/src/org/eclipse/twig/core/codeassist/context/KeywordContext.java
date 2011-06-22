package org.eclipse.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.jface.text.BadLocationException;

public class KeywordContext extends AbstractTwigCompletionContext {
	
	
	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {
			
		try {
			if (super.isValid(sourceModule, offset, requestor)) {
								
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