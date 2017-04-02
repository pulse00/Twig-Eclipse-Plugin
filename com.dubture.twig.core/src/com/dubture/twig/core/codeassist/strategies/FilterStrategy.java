/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist.strategies;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.dltk.core.ISourceRange;

import com.dubture.twig.core.codeassist.ICompletionContext;
import com.dubture.twig.core.codeassist.ICompletionReporter;
import com.dubture.twig.core.codeassist.context.FilterContext;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.IFilter;
import com.dubture.twig.core.model.TwigModelAccess;

/**
 * {@link FilterStrategy} for filter completion.
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 */

public class FilterStrategy extends AbstractTwigCompletionStrategy {

	public FilterStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		try {

			FilterContext ctx = (FilterContext) getContext();
			TwigModelAccess model = TwigModelAccess.getDefault();

			String prefix = ctx.getPrefix();
			ISourceRange range = getReplacementRange(getContext());

			IFilter[] filters = model.getFilters(ctx.getScriptProject());

			for (IFilter filter : filters) {
				if (StringUtils.startsWithIgnoreCase(filter.getElementName(), prefix)) {
					reporter.reportFilter(filter, range);
				}
			}

		} catch (Exception e) {
			Logger.logException(e);
		}
	}
}
