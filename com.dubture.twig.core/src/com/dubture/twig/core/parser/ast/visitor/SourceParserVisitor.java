package com.dubture.twig.core.parser.ast.visitor;

import org.eclipse.dltk.compiler.problem.IProblemReporter;

public class SourceParserVisitor extends TwigASTVisitor
{
    private final IProblemReporter reporter;

    public SourceParserVisitor(IProblemReporter reporter)
    {
        this.reporter = reporter;

    }

}
