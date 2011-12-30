package com.dubture.twig.core.parser.ast.visitor;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;

import com.dubture.twig.core.parser.ast.node.PrintStatement;
import com.dubture.twig.core.parser.ast.node.TwigCallExpression;

public abstract class TwigASTVisitor extends ASTVisitor
{

    public boolean visit(PrintStatement s) throws Exception
    {
        return visitGeneral(s);
    }

    public boolean endvisit(PrintStatement s) throws Exception
    {
        endvisitGeneral(s);
        return false;
    }

    public boolean visit(TwigCallExpression s) throws Exception
    {
        return visitGeneral(s);
    }

    public boolean endvisit(TwigCallExpression s) throws Exception
    {
        endvisitGeneral(s);
        return false;
    }

    @Override
    public boolean visit(ASTNode s) throws Exception
    {

        Class<? extends ASTNode> nodeClass = s.getClass();
        if (nodeClass.equals(PrintStatement.class)) {
            return visit((PrintStatement) s);
        } else if (nodeClass.equals(TwigCallExpression.class)) {
            return visit((TwigCallExpression) s);
        }

        return true;
    }

    @Override
    public boolean endvisit(ASTNode s) throws Exception
    {

        Class<? extends ASTNode> nodeClass = s.getClass();
        if (nodeClass.equals(PrintStatement.class)) {
            return endvisit((PrintStatement) s);
        } else if (nodeClass.equals(TwigCallExpression.class)) {
            return endvisit((TwigCallExpression) s);
        }

        return true;
    }

}
