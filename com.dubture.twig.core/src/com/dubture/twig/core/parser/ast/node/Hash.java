package com.dubture.twig.core.parser.ast.node;

import java.util.Map;

import org.eclipse.dltk.ast.expressions.Expression;

public class Hash extends Expression
{
    public Hash(int startIndex, int stopIndex, Map<Expression, Expression> expressions)
    {
        super(startIndex, stopIndex);
        
        System.err.println("creating hash at " + startIndex + " to " + stopIndex + " with " + expressions.size() + " items");

    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.HASH;
    }

}
