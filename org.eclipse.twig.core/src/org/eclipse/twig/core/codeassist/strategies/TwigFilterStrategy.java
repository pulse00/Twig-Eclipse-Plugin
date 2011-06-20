package org.eclipse.twig.core.codeassist.strategies;

import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceRange;
import org.eclipse.dltk.internal.core.hierarchy.FakeType;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.CodeAssistUtils;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.php.internal.core.codeassist.strategies.AbstractCompletionStrategy;
import org.eclipse.php.internal.core.typeinference.FakeMethod;
import org.eclipse.twig.core.codeassist.context.TwigFilterContext;

/**
 * 
 * {@link TwigFilterStrategy} for filter completion.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings({ "restriction", "deprecation" })
public class TwigFilterStrategy extends AbstractCompletionStrategy {

	
	private String[] FILTERS = new String[] { "date", "format", "replace", "url_encode", "json_encode","date" ,
			"format" ,"replace" ,"url_encode" ,"json_encode" ,"title" ,"capitalize" ,"upper" ,
			"lower" ,"striptags" ,"join" ,"reverse" ,"length" ,"sort" ,"default" ,"keys" ,"escape", "e" ,"raw" ,"merge" };
	
	public TwigFilterStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		try {

			TwigFilterContext ctx = (TwigFilterContext) getContext();

			
			String prefix = ctx.getPrefix();
			SourceRange range = getReplacementRange(getContext());
			String suffix = "";
			
			FakeType type = new FakeType((ModelElement) ctx.getSourceModule(), "filter");
			
			for (String keyword : FILTERS) {		
				if (CodeAssistUtils.startsWithIgnoreCase(keyword, prefix)) {
										
					FakeMethod method = new FakeMethod(type, keyword);
					reporter.reportMethod(method, "", range);
//					reporter.reportKeyword(keyword, suffix, range);

				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
