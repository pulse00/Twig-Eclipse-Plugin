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
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceRange;

import com.dubture.twig.core.codeassist.ICompletionContext;
import com.dubture.twig.core.codeassist.ICompletionReporter;
import com.dubture.twig.core.codeassist.context.TestContext;
import com.dubture.twig.core.model.ITest;
import com.dubture.twig.core.model.TwigModelAccess;

public class TestStrategy extends KeywordStrategy {

	public TestStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		TestContext ctx = (TestContext) getContext();

		IScriptProject project = ctx.getScriptProject();
		ITest[] tests = TwigModelAccess.getDefault().getTests(project);
		ISourceRange range = getReplacementRange(ctx);
		String prefix = ctx.getPrefix();

		for (ITest test : tests) {
			if (StringUtils.startsWithIgnoreCase(test.getElementName(), prefix)) {
				reporter.reportTest(test, range);
			}

		}
	}
}
