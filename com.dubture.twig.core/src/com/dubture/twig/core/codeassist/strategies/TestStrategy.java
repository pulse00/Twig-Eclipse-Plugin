/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist.strategies;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.CodeAssistUtils;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;

import com.dubture.twig.core.codeassist.context.TestContext;
import com.dubture.twig.core.model.Test;
import com.dubture.twig.core.model.TwigModelAccess;

@SuppressWarnings({"restriction"})
public class TestStrategy extends KeywordStrategy
{

    public TestStrategy(ICompletionContext context)
    {
        super(context);

    }

    @Override
    public void apply(ICompletionReporter reporter) throws Exception
    {

        TestContext ctx = (TestContext) getContext();

        IScriptProject project = ctx.getSourceModule().getScriptProject();
        Test[] tests = TwigModelAccess.getDefault().getTests(project);
        ISourceRange range = getReplacementRange(ctx);
        String prefix = ctx.getPrefix();

        for (Test test : tests) {
            if (CodeAssistUtils.startsWithIgnoreCase(test.getElementName(),
                    prefix)) {
                test.setScriptProject(project);
                reporter.reportType(test, "", range);
            }

        }
    }
}
