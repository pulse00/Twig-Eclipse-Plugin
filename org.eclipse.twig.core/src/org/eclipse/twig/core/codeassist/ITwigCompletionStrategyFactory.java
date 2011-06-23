package org.eclipse.twig.core.codeassist;

import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.twig.core.codeassist.strategies.AbstractTwigCompletionStrategy;


/**
 * 
 * Interface for the completionStrategyResolvers extension point.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public interface ITwigCompletionStrategyFactory {
	
	AbstractTwigCompletionStrategy[] create(ICompletionContext[] contexts);	

}