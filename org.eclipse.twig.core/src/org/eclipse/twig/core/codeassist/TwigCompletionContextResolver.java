package org.eclipse.twig.core.codeassist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.core.codeassist.ICompletionContextResolver;
import org.eclipse.php.internal.core.codeassist.contexts.CompletionContextResolver;
import org.eclipse.twig.core.codeassist.context.AbstractTwigCompletionContext;
import org.eclipse.twig.core.codeassist.context.FilterContext;
import org.eclipse.twig.core.codeassist.context.KeywordContext;
import org.eclipse.twig.core.codeassist.context.TemplateVariablesContext;
import org.eclipse.twig.core.codeassist.context.VariableFieldContext;


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

	private static final String CONTEXTYFACTORY_ID = "org.eclipse.twig.core.completionContextResolvers";
	

	@Override
	public ICompletionContext[] createContexts() {

		List<ICompletionContext> contexts = new ArrayList<ICompletionContext>();
		
		contexts.add(new AbstractTwigCompletionContext());
		contexts.add(new KeywordContext());
		contexts.add(new FilterContext());
		contexts.add(new VariableFieldContext());
		contexts.add(new TemplateVariablesContext());		
		
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
			e.printStackTrace();			
		}		
		
		return (ICompletionContext[]) contexts.toArray(new ICompletionContext[contexts.size()]);
				
	}	
}