/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.ast.visitor;

import org.eclipse.dltk.compiler.problem.IProblemReporter;

public class SourceParserVisitor extends TwigASTVisitor
{
    private final IProblemReporter reporter;

    public SourceParserVisitor(IProblemReporter reporter)
    {
        this.reporter = reporter;
    }

    public IProblemReporter getReporter() {
        return reporter;
    }
}
