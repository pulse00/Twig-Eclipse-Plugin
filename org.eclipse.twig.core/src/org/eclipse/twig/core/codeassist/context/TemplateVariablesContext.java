package org.eclipse.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;


/**
 * 
 * Completion context for local template variables, ie:
 * 
 * 
 * <pre>
 * 
 * 	{% for user in users %}
 *     {{ |  <--- completes user and users
 *    
 * 
 * </pre>
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TemplateVariablesContext extends
		AbstractTwigCompletionContext {
	
	
	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {
	
		if (super.isValid(sourceModule, offset, requestor)) {
			
			try {
				
				String prefix = getPrefix();
				
				if (prefix != null) {					
					if (!prefix.contains(".") && !prefix.contains("[") && !prefix.contains("]")) {
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