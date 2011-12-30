package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Expression;

public class TwigCallExpression extends Expression
{

    public TwigCallExpression(Expression e, String string)
    {

    }

    @Override
    public int getKind()
    {

        return ASTNodeKinds.CALL_EXPRESSION;
    }

}
