package com.dubture.twig.core.parser.ast.visitor;

import org.eclipse.dltk.compiler.problem.IProblemReporter;

import com.dubture.twig.core.parser.ast.node.BlockStatement;

public class SourceParserVisitor extends TwigASTVisitor
{
    private final IProblemReporter reporter;

    public SourceParserVisitor(IProblemReporter reporter)
    {
        this.reporter = reporter;

    }

    @Override
    public boolean visit(BlockStatement block) throws Exception
    {
//        if ("block".equals(block.getName())) {
//
//            List childs = block.getChilds();
//
//            if (childs != null && childs.size() > 0) {
//
//                Object name = childs.get(0);
//
//                if (name instanceof Variable) {
//
//                }
//            }
//        }
        return super.visit(block);
    }

    @Override
    public boolean endvisit(BlockStatement block) throws Exception
    {
        return super.endvisit(block);
    }

}
