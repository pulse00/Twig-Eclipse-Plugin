package org.eclipse.twig.core.codeassist;

import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.strategies.AbstractCompletionStrategy;


/**
 * 
 * Interface for the completionStrategyResolvers extension point.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public interface ITwigCompletionStrategyFactory {
	
	AbstractCompletionStrategy[] create(ICompletionContext[] contexts);	

}