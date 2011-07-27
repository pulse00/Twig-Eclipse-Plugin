package com.dubture.twig.core.codeassist;

import org.eclipse.php.core.codeassist.ICompletionContext;


/**
 * Interface for the completionContextResolvers extension point.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public interface ITwigCompletionContextResolver {

	
	ICompletionContext[]  createContexts();
	
}
