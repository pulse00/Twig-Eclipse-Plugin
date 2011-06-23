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
import org.eclipse.twig.core.codeassist.context.KeywordContext;
import org.eclipse.twig.core.codeassist.context.TemplateVariablesContext;
import org.eclipse.twig.core.codeassist.context.VariableFieldContext;
import org.eclipse.twig.core.codeassist.strategies.AbstractTwigCompletionStrategy;
import org.eclipse.twig.core.codeassist.strategies.FilterStrategy;
import org.eclipse.twig.core.codeassist.strategies.KeywordStrategy;
import org.eclipse.twig.core.codeassist.strategies.TemplateVariablesStrategy;
import org.eclipse.twig.core.codeassist.strategies.VariableFieldStrategy;


/**
 * 
 * Factory for the twig completion strategies.
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
	
	private static ITwigCompletionStrategy[] strategies = null;

	@Override
	public ICompletionStrategy[] create(ICompletionContext[] contexts) {
		
		List<ICompletionStrategy> result = new LinkedList<ICompletionStrategy>();
		
		for (ICompletionContext context : contexts) {
			if (context.getClass() == KeywordContext.class) {
				result.add(new KeywordStrategy(context));
			} else if (context.getClass() == FilterContext.class) {				
				result.add(new FilterStrategy(context));
			} else if (context.getClass() == VariableFieldContext.class) {				
				result.add(new VariableFieldStrategy(context));
			} else if (context.getClass() == TemplateVariablesContext.class) {				
				result.add(new TemplateVariablesStrategy(context));
			}
		}
		
		return (ICompletionStrategy[]) result
		        .toArray(new ICompletionStrategy[result.size()]);
		
	}
	
	
	public static ITwigCompletionStrategy[] getStrategies() {

		if (strategies != null)
			return strategies;
		
		
		List<ITwigCompletionStrategy> result = new LinkedList<ITwigCompletionStrategy>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(STRATEGYFACTORY_ID);		
		
		try {
			
			for (IConfigurationElement e : config) {
				
				final Object object = e.createExecutableExtension("class");
				
				if (object instanceof ITwigCompletionStrategyFactory) {										
					ITwigCompletionStrategyFactory factory = (ITwigCompletionStrategyFactory) object;
					result.addAll(Arrays.asList(factory.createStrategies()));
				}
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
		strategies = (ITwigCompletionStrategy[]) result
		        .toArray(new ITwigCompletionStrategy[result.size()]);
		
		return strategies;
		
	}
}