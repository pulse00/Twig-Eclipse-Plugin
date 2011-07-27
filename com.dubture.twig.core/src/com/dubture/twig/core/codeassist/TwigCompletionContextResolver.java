package com.dubture.twig.core.codeassist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.core.codeassist.ICompletionContextResolver;
import org.eclipse.php.internal.core.codeassist.contexts.CompletionContextResolver;

import com.dubture.twig.core.codeassist.context.AbstractTwigCompletionContext;
import com.dubture.twig.core.codeassist.context.FilterContext;
import com.dubture.twig.core.codeassist.context.FunctionContext;
import com.dubture.twig.core.codeassist.context.KeywordContext;
import com.dubture.twig.core.codeassist.context.QuotesContext;
import com.dubture.twig.core.codeassist.context.TagContext;
import com.dubture.twig.core.codeassist.context.TemplateVariablesContext;
import com.dubture.twig.core.codeassist.context.TestContext;
import com.dubture.twig.core.codeassist.context.VariableFieldContext;
import com.dubture.twig.core.log.Logger;


/**
 * 
 * Factory for the {@link AbstractTwigCompletionContext}. 
 * 
 * 
 * Collects CompletionContexts from extension points and
 * merges them to the internal ones.
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class TwigCompletionContextResolver extends CompletionContextResolver implements
		ICompletionContextResolver {

	private static final String CONTEXTYFACTORY_ID = "com.dubture.twig.core.completionContextResolvers";
	

	@Override
	public ICompletionContext[] createContexts() {

		List<ICompletionContext> contexts = new ArrayList<ICompletionContext>();
		
		contexts.add(new AbstractTwigCompletionContext());
		contexts.add(new KeywordContext());
		contexts.add(new FilterContext());
		contexts.add(new VariableFieldContext());
		contexts.add(new TemplateVariablesContext());
		contexts.add(new QuotesContext());
		contexts.add(new FunctionContext());
		contexts.add(new TagContext());
		contexts.add(new TestContext());
		
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(CONTEXTYFACTORY_ID);		
		
		try {
			
			for (IConfigurationElement e : config) {
				
				final Object object = e.createExecutableExtension("class");
				
				if (object instanceof ITwigCompletionContextResolver) {					
					ITwigCompletionContextResolver resolver = (ITwigCompletionContextResolver) object;					
					contexts.addAll(Arrays.asList(resolver.createContexts()));					
				}
			}
			
		} catch (Exception e) {
			Logger.logException(e);		
		}		
		
		return (ICompletionContext[]) contexts.toArray(new ICompletionContext[contexts.size()]);
				
	}	
}