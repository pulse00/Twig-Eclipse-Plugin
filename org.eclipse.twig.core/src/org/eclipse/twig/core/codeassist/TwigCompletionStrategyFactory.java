package org.eclipse.twig.core.codeassist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.core.codeassist.ICompletionStrategy;
import org.eclipse.php.core.codeassist.ICompletionStrategyFactory;
import org.eclipse.twig.core.codeassist.context.FilterContext;
import org.eclipse.twig.core.codeassist.context.FunctionContext;
import org.eclipse.twig.core.codeassist.context.KeywordContext;
import org.eclipse.twig.core.codeassist.context.TagContext;
import org.eclipse.twig.core.codeassist.context.TemplateVariablesContext;
import org.eclipse.twig.core.codeassist.context.VariableFieldContext;
import org.eclipse.twig.core.codeassist.strategies.AbstractTwigCompletionStrategy;
import org.eclipse.twig.core.codeassist.strategies.FilterStrategy;
import org.eclipse.twig.core.codeassist.strategies.FunctionStrategy;
import org.eclipse.twig.core.codeassist.strategies.KeywordStrategy;
import org.eclipse.twig.core.codeassist.strategies.TagStrategy;
import org.eclipse.twig.core.codeassist.strategies.TemplateVariablesStrategy;
import org.eclipse.twig.core.log.Logger;


/**
 * 
 * Factory for the twig completion strategies.
 * 
 * Calls the extensions which provide CompletionStrategies
 * and merges them with the internal twig strategies.
 * 
 * @see AbstractTwigCompletionStrategy
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
public class TwigCompletionStrategyFactory implements
		ICompletionStrategyFactory {

	
	private static final String STRATEGYFACTORY_ID = "org.eclipse.twig.core.completionStrategyResolvers";
	
	@Override
	public ICompletionStrategy[] create(ICompletionContext[] contexts) {
		
		List<ICompletionStrategy> result = new LinkedList<ICompletionStrategy>();
		
		for (ICompletionContext context : contexts) {
			if (context.getClass() == KeywordContext.class) {
				result.add(new KeywordStrategy(context));
			} else if (context.getClass() == FilterContext.class) {				
				result.add(new FilterStrategy(context));
			} else if (context.getClass() == VariableFieldContext.class) {
				// can't really do much in a plain twig context, this is the job for extensions
//				result.add(new VariableFieldStrategy(context));
			} else if (context.getClass() == TemplateVariablesContext.class) {				
				result.add(new TemplateVariablesStrategy(context));
			} else if (context.getClass() == FunctionContext.class) {
				result.add(new FunctionStrategy(context));
			} else if (context.getClass() == TagContext.class) {				
				result.add(new TagStrategy(context));
			}
		}
		
		
		
		// load the strategies from extensions
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(STRATEGYFACTORY_ID);		
		
		try {
			
			for (IConfigurationElement e : config) {
				
				final Object object = e.createExecutableExtension("class");
				
				if (object instanceof ITwigCompletionStrategyFactory) {										
					ITwigCompletionStrategyFactory factory = (ITwigCompletionStrategyFactory) object;					
					result.addAll(Arrays.asList(factory.create(contexts)));

				}
			}
			
		} catch (Exception e) {
			Logger.logException(e);
		}		
		
		return (ICompletionStrategy[]) result
		        .toArray(new ICompletionStrategy[result.size()]);
		
	}
}