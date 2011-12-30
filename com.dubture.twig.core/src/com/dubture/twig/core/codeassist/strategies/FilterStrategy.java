/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist.strategies;

import org.eclipse.dltk.internal.core.SourceRange;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.CodeAssistUtils;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.php.internal.core.codeassist.strategies.AbstractCompletionStrategy;

import com.dubture.twig.core.codeassist.context.FilterContext;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.Filter;
import com.dubture.twig.core.model.TwigModelAccess;

/**
 * 
 * {@link FilterStrategy} for filter completion.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings({"restriction", "deprecation"})
public class FilterStrategy extends AbstractCompletionStrategy
{

    public FilterStrategy(ICompletionContext context)
    {
        super(context);

    }

    @Override
    public void apply(ICompletionReporter reporter) throws Exception
    {

        try {

            FilterContext ctx = (FilterContext) getContext();
            TwigModelAccess model = TwigModelAccess.getDefault();

            String prefix = ctx.getPrefix();
            SourceRange range = getReplacementRange(getContext());

            Filter[] filters = model.getFilters(ctx.getSourceModule()
                    .getScriptProject());

            for (Filter filter : filters) {
                if (CodeAssistUtils.startsWithIgnoreCase(
                        filter.getElementName(), prefix)) {

                    filter.setScriptProject(ctx.getSourceModule()
                            .getScriptProject());
                    reporter.reportType(filter, "", range);
                }
            }

        } catch (Exception e) {
            Logger.logException(e);
        }
    }
}
