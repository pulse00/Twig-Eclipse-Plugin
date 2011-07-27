package com.dubture.twig.core.codeassist.strategies;

import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.internal.core.SourceRange;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;

import com.dubture.twig.core.codeassist.context.TagContext;
import com.dubture.twig.core.model.Tag;
import com.dubture.twig.core.model.TwigModelAccess;


/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings({ "restriction", "deprecation" })
public class TagStrategy extends AbstractTwigCompletionStrategy {

	public TagStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		TagContext ctx = (TagContext) getContext();
		ISourceModule module = ctx.getSourceModule();
		Tag[] tags = TwigModelAccess.getDefault().findTags(module.getScriptProject());
		SourceRange range = getReplacementRange(ctx);
		
		for (Tag tag : tags) {
			reporter.reportType(tag, "", range);
		}
	}
}
