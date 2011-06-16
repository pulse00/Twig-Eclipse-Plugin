package org.eclipse.twig.core.codeassist.strategies;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.core.codeassist.ICompletionStrategy;
import org.eclipse.php.core.codeassist.ICompletionStrategyFactory;
import org.eclipse.twig.core.codeassist.TwigCompletionContext;


/**
 * 
 * Factory for the twig completion strategies.
 * 
 * @see TwigCompletionStrategy
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
			if (context.getClass() == TwigCompletionContext.class) {
				result.add(new TwigCompletionStrategy(context));
			} 
		}
		
		return (ICompletionStrategy[]) result
		        .toArray(new ICompletionStrategy[result.size()]);

		
	}
}
