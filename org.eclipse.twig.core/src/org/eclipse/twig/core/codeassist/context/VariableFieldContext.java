package org.eclipse.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;

/**
 * 
 * A {@link VariableFieldContext} detects completion of twig
 * variables:
 * 
 * <pre>
 * 
 * {{ user.| 
 * 
 * </pre>
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
public class VariableFieldContext extends AbstractTwigCompletionContext {

	
	private String variable = null;
	
	public String getVariable() {
		
		return variable;
		
	}
	
	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {
	
		if (super.isValid(sourceModule, offset, requestor)) {
						
			try {
				
				String prefix = getPrefix();
				
				if (prefix != null) {					
					if (prefix.endsWith(".")) {						
						variable = prefix.substring(0, prefix.length() - 1);
						return true;
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return false;
	}	
}