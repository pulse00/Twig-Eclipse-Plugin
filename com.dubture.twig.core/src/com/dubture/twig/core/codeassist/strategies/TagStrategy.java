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
import com.dubture.twig.core.codeassist.context.TagContext;
import com.dubture.twig.core.model.ITag;
import com.dubture.twig.core.model.TwigModelAccess;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 */

@SuppressWarnings({ "restriction" })
public class TagStrategy extends AbstractTwigCompletionStrategy {

	public TagStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		TagContext ctx = (TagContext) getContext();
		ITag[] tags = TwigModelAccess.getDefault().findTags(ctx.getScriptProject());
		ISourceRange range = getReplacementRange(ctx);

		String prefix = ctx.getPrefix();

		for (ITag tag : tags) {
			if (CodeAssistUtils.startsWithIgnoreCase(tag.getElementName(), prefix)) {
				reporter.reportTag(tag, range);
			}
		}
	}
}
