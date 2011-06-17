package org.eclipse.twig.core.codeassist.strategies;


import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.php.internal.core.codeassist.strategies.AbstractCompletionStrategy;
import org.eclipse.twig.core.codeassist.TwigCompletionContext;

/**
 * 
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class TwigCompletionStrategy extends AbstractCompletionStrategy {

	public TwigCompletionStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		if (!(getContext() instanceof TwigCompletionContext))
			return;
		
		TwigCompletionContext ctx = (TwigCompletionContext) getContext();
		
		System.err.println(ctx.getTwigScriptRegion().getType());
		
		System.err.println(ctx.getStatementText().toString());


	}
}
