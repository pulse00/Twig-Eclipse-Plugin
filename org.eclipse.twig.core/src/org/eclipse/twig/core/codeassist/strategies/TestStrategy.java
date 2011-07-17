package org.eclipse.twig.core.codeassist.strategies;


import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.internal.core.SourceRange;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.twig.core.codeassist.context.TestContext;
import org.eclipse.twig.core.model.Test;
import org.eclipse.twig.core.model.TwigModelAccess;

@SuppressWarnings({ "restriction", "deprecation" })
public class TestStrategy extends KeywordStrategy {

	public TestStrategy(ICompletionContext context) {
		super(context);

	}
	
	
	@Override
	public void apply(ICompletionReporter reporter) throws Exception {
	
		TestContext ctx = (TestContext) getContext();
		
		IScriptProject project = ctx.getSourceModule().getScriptProject();
		Test[] tests = TwigModelAccess.getDefault().getTests(project);
		SourceRange range = getReplacementRange(ctx);
		
		for (Test test : tests) {
			
			test.setScriptProject(project);			
			reporter.reportType(test, "", range);
			
		}
	}
}