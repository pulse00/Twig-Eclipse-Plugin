package org.eclipse.twig.core.codeassist.strategies;

import org.eclipse.dltk.internal.core.SourceRange;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.CodeAssistUtils;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.php.internal.core.codeassist.strategies.AbstractCompletionStrategy;
import org.eclipse.twig.core.codeassist.context.FunctionContext;
import org.eclipse.twig.core.log.Logger;
import org.eclipse.twig.core.model.Function;
import org.eclipse.twig.core.model.TwigModelAccess;

/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings({ "restriction", "deprecation" })
public class FunctionStrategy extends AbstractCompletionStrategy {

	public FunctionStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		try {

			FunctionContext ctx = (FunctionContext) getContext();
			TwigModelAccess model = TwigModelAccess.getDefault();
			
			String prefix = ctx.getPrefix();
			SourceRange range = getReplacementRange(getContext());
			
			Function[] functions = model.getFunctions(ctx.getSourceModule().getScriptProject());
				
			for (Function function : functions) {				
				if (CodeAssistUtils.startsWithIgnoreCase(function.getElementName(), prefix)) {					
			
					reporter.reportType(function, "", range);					
				}
			}
			
		} catch (Exception e) {
			Logger.logException(e);
		}			
	}
}