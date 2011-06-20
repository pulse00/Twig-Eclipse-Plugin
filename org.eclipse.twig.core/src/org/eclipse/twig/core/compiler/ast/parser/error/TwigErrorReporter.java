package org.eclipse.twig.core.compiler.ast.parser.error;

import org.antlr.runtime.RecognitionException;
import org.eclipse.dltk.compiler.problem.DefaultProblem;
import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;
import org.eclipse.twig.core.TwigCorePlugin;
import org.eclipse.twig.core.TwigCorePreferences;


/**
 * 
 * 
 * The {@link TwigErrorReporter} reports syntaxerrors to the
 *  DLTK ProblemReporting engine.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigErrorReporter implements IErrorReporter {

	
	private IProblemReporter reporter;
	private int offset;
	private int line;
	private String filename;
	
	
	public TwigErrorReporter(IProblemReporter problemReporter, String filename) {

		reporter = problemReporter;
		this.filename = filename;
		
	}
	

	
	@Override
	@SuppressWarnings("deprecation")
	public void reportError(String header, String message,
			RecognitionException e) {


		// disabled due to 3.6 incompatibility
		// see https://github.com/pulse00/Twig-Eclipse-Plugin/issues/8
		return;
//		ProblemSeverity severity = TwigCorePreferences.getSyntaxErrorSeverity();
//		
//		if (severity == null || severity == ProblemSeverity.IGNORE)
//			return;
//		
//		IProblem problem = new DefaultProblem(filename, message, IProblem.Syntax,
//				new String[0], severity, offset, offset+1, line);
//		
//		reporter.reportProblem(problem);

	}



	public void setOffset(int offset2, int line2) {
	
		offset = offset2;
		line = line2;
		
	}
}
