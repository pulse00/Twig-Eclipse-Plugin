package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.NumericLiteral;

public class NumberNode extends NumericLiteral
{

    public NumberNode(int start, int end, long value)
    {
        super(start, end, value);
        
        System.err.println("creating numeric node with value " + value  + " at " + start + " - " + end);

    }

}
