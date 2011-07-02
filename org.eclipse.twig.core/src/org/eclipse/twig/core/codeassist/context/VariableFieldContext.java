package org.eclipse.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.php.internal.core.util.text.TextSequence;
import org.eclipse.twig.core.log.Logger;
import org.eclipse.twig.core.util.text.TwigTextSequenceUtilities;

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
	
	@SuppressWarnings("restriction")
	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {
	
		if (super.isValid(sourceModule, offset, requestor)) {
						
			try {
				
				TextSequence statement = getStatementText();
				
				if (TwigTextSequenceUtilities.isInField(statement)) {
					
					variable = TwigTextSequenceUtilities.getVariable(statement);
					return true;
				}
				
				return true;
				
				
			} catch (Exception e) {
				Logger.logException(e);
			}
		}		
		return false;
	}	
}