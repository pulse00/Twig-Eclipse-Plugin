/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.error;

import org.eclipse.dltk.compiler.problem.DefaultProblem;
import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.compiler.problem.ProblemSeverity;

import com.dubture.twig.core.TwigCorePlugin;
import com.dubture.twig.core.TwigCorePreferences;

/**
 * 
 * 
 * The {@link TwigErrorReporter} reports syntaxerrors to the DLTK
 * ProblemReporting engine.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class TwigErrorReporter
{

    private IProblemReporter reporter;
    private int offset;
    private int line;
    private String filename;

    public TwigErrorReporter(IProblemReporter problemReporter, String filename)
    {

        reporter = problemReporter;
        this.filename = filename;

    }

    @SuppressWarnings("deprecation")
    public void reportError(String header, String message)
    {

        // disabled due to 3.6 incompatibility
        // see https://github.com/pulse00/Twig-Eclipse-Plugin/issues/8
        if (!TwigCorePlugin.getDefault().isDLTK3()) {
            return;
        }

        ProblemSeverity severity = TwigCorePreferences.getSyntaxErrorSeverity();

        if (severity == null || severity == ProblemSeverity.IGNORE)
            return;

        IProblem problem = new DefaultProblem(filename, message,
                IProblem.Syntax, new String[0], severity, offset, offset + 1,
                line);

        reporter.reportProblem(problem);

    }

    public void setOffset(int offset2, int line2)
    {

        offset = offset2;
        line = line2;

    }
}
