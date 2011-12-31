package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.expressions.Expression;

public class Hash extends Expression
{
    private final List<Expression> expressions;

    public Hash(int startIndex, int stopIndex, List<Expression> expressions)
    {
        super(startIndex, stopIndex);
        this.expressions = expressions;
        
        System.err.println("creating hash at " + startIndex + " to " + stopIndex + " with " + expressions.size() + " items:");
        
        for (Expression e : expressions) {
            System.err.println(e.getClass());
        }

    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.HASH;
    }

}
