package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.expressions.Expression;

public class TwigCallExpression extends Expression
{
 
    public TwigCallExpression(int startIndex, int stopIndex, String name, List<Expression> arguments)
    {
        super(startIndex, stopIndex);
        
        System.err.println("twig function " + name + " called with " + arguments.size() + " arguments");
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.CALL_EXPRESSION;
    }
}
