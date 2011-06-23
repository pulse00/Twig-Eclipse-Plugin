package org.eclipse.twig.core.codeassist;

import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.core.codeassist.ICompletionContextResolver;
import org.eclipse.php.internal.core.codeassist.contexts.CompletionContextResolver;
import org.eclipse.twig.core.codeassist.context.AbstractTwigCompletionContext;
import org.eclipse.twig.core.codeassist.context.FilterContext;
import org.eclipse.twig.core.codeassist.context.TemplateVariablesContext;
import org.eclipse.twig.core.codeassist.context.KeywordContext;
import org.eclipse.twig.core.codeassist.context.VariableFieldContext;


/**
 * 
 * Factory for the {@link AbstractTwigCompletionContext}. 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class TwigCompletionContextResolver extends CompletionContextResolver implements
		ICompletionContextResolver {


	@Override
	public ICompletionContext[] createContexts() {

		return new ICompletionContext[] { 
				new AbstractTwigCompletionContext(),
				new KeywordContext(),
				new FilterContext(),
				new VariableFieldContext(),
				new TemplateVariablesContext(),
		};
	}	
}