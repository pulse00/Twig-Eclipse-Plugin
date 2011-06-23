package org.eclipse.twig.core.codeassist;

import org.eclipse.twig.core.codeassist.context.AbstractTwigCompletionContext;


/**
 * Interface for the completionContextResolvers extension point.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public interface ITwigCompletionContextResolver {

	
	 AbstractTwigCompletionContext[]  createContexts();
	
}
