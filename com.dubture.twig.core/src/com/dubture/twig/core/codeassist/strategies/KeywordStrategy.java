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

import com.dubture.twig.core.codeassist.context.KeywordContext;

/**
 * 
 * Completes Twig keywords.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings({"restriction", "deprecation"})
public class KeywordStrategy extends AbstractTwigCompletionStrategy
{

    private String[] KEYWORDS = new String[]{"as", "in", "true", "false", "as",
            "with"};

    public KeywordStrategy(ICompletionContext context)
    {
        super(context);

    }

    @Override
    public void apply(ICompletionReporter reporter) throws Exception
    {

        KeywordContext ctx = (KeywordContext) getContext();
        String prefix = ctx.getPrefix();
        SourceRange range = getReplacementRange(getContext());

        for (String keyword : KEYWORDS) {
            if (CodeAssistUtils.startsWithIgnoreCase(keyword, prefix)) {
                reporter.reportKeyword(keyword, "", range);
            }
        }
    }
}
