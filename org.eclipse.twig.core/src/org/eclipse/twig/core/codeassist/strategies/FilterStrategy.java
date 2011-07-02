package org.eclipse.twig.core.codeassist.strategies;

import org.eclipse.dltk.core.IType;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceRange;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.CodeAssistUtils;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.php.internal.core.codeassist.strategies.AbstractCompletionStrategy;
import org.eclipse.php.internal.core.typeinference.FakeMethod;
import org.eclipse.twig.core.codeassist.context.FilterContext;
import org.eclipse.twig.core.log.Logger;
import org.eclipse.twig.core.model.Filter;
import org.eclipse.twig.core.model.TwigModelAccess;

/**
 * 
 * {@link FilterStrategy} for filter completion.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings({ "restriction", "deprecation" })
public class FilterStrategy extends AbstractCompletionStrategy {

	
	public FilterStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		try {

			FilterContext ctx = (FilterContext) getContext();
			TwigModelAccess model = TwigModelAccess.getInstance();
			IType filterType = model.getFilterType(ctx.getSourceModule());
			
			if (filterType == null) {
				return;
			}
			
			String prefix = ctx.getPrefix();
			SourceRange range = getReplacementRange(getContext());
			
			for (Filter filter : model.getFilters()) {				
				if (CodeAssistUtils.startsWithIgnoreCase(filter.getName(), prefix)) {					
					FakeMethod method = new FakeMethod((ModelElement) filterType, filter.getName());
					reporter.reportMethod(method, "", range);					
				}
			}
			
		} catch (Exception e) {
			Logger.logException(e);
		}	
	}	
}