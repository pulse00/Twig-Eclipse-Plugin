package org.eclipse.twig.core.codeassist.strategies;

import org.eclipse.dltk.core.IType;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceRange;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.CodeAssistUtils;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.php.internal.core.codeassist.strategies.AbstractCompletionStrategy;
import org.eclipse.php.internal.core.typeinference.FakeMethod;
import org.eclipse.twig.core.codeassist.context.FunctionContext;
import org.eclipse.twig.core.log.Logger;
import org.eclipse.twig.core.model.Function;
import org.eclipse.twig.core.model.TwigModelAccess;

@SuppressWarnings({ "restriction", "deprecation" })
public class FunctionStrategy extends AbstractCompletionStrategy {

	public FunctionStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		try {

			FunctionContext ctx = (FunctionContext) getContext();
			TwigModelAccess model = TwigModelAccess.getInstance();
			IType functionType = model.getFunctionType(ctx.getSourceModule());
			
			if (functionType == null) {
				return;
			}
			
			String prefix = ctx.getPrefix();
			SourceRange range = getReplacementRange(getContext());
			
			for (Function function : model.getFunctions()) {				
				if (CodeAssistUtils.startsWithIgnoreCase(function.getName(), prefix)) {					
					FakeMethod method = new FakeMethod((ModelElement) functionType, function.getName());
					reporter.reportMethod(method, "", range);					
				}
			}
			
		} catch (Exception e) {
			Logger.logException(e);
		}			

	}

}
