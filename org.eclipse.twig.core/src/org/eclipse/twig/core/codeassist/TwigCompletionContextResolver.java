package org.eclipse.twig.core.codeassist;

import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.core.codeassist.ICompletionContextResolver;
import org.eclipse.php.internal.core.codeassist.contexts.CompletionContextResolver;

@SuppressWarnings("restriction")
public class TwigCompletionContextResolver extends CompletionContextResolver implements
		ICompletionContextResolver {


	@Override
	public ICompletionContext[] createContexts() {

		System.err.println("create context");
		return new ICompletionContext[] { 
				new TwigCompletionContext(),
		};
	}
	
}
