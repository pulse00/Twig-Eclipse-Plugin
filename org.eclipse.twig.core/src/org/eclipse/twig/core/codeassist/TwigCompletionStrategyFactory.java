package org.eclipse.twig.core.codeassist;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.core.codeassist.ICompletionStrategy;
import org.eclipse.php.core.codeassist.ICompletionStrategyFactory;
import org.eclipse.twig.core.codeassist.context.AbstractTwigCompletionContext;
import org.eclipse.twig.core.codeassist.context.FilterContext;
import org.eclipse.twig.core.codeassist.context.KeywordContext;
import org.eclipse.twig.core.codeassist.context.VariableFieldContext;
import org.eclipse.twig.core.codeassist.strategies.AbstractTwigCompletionStrategy;
import org.eclipse.twig.core.codeassist.strategies.FilterStrategy;
import org.eclipse.twig.core.codeassist.strategies.KeywordStrategy;
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
			}
		}
		
		return (ICompletionStrategy[]) result
		        .toArray(new ICompletionStrategy[result.size()]);

		
	}
}
