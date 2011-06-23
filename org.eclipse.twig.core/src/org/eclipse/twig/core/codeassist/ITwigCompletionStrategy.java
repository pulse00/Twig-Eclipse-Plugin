package org.eclipse.twig.core.codeassist;

import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;

@SuppressWarnings("restriction")
public interface ITwigCompletionStrategy {
	
	void setContext(ICompletionContext context);
	void apply(ICompletionReporter reporter);
}
