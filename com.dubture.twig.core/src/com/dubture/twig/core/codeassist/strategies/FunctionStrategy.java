/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist.strategies;

import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.php.internal.core.codeassist.CodeAssistUtils;

import com.dubture.twig.core.codeassist.ICompletionContext;
import com.dubture.twig.core.codeassist.ICompletionReporter;
import com.dubture.twig.core.codeassist.context.FunctionContext;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.IFunction;
import com.dubture.twig.core.model.TwigModelAccess;

/**
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings({ "restriction" })
public class FunctionStrategy extends AbstractTwigCompletionStrategy {

	public FunctionStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		try {

			FunctionContext ctx = (FunctionContext) getContext();
			TwigModelAccess model = TwigModelAccess.getDefault();

			String prefix = ctx.getPrefix();
			ISourceRange range = getReplacementRange(getContext());

			IFunction[] functions = model.getFunctions(ctx.getScriptProject());

			for (IFunction function : functions) {
				if (CodeAssistUtils.startsWithIgnoreCase(function.getElementName(), prefix)) {

					reporter.reportFunction(function, range);
				}
			}

		} catch (Exception e) {
			Logger.logException(e);
		}
	}
}
