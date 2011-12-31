package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.expressions.Expression;

public class ArrayDeclaration extends Expression
{

    protected final List<Expression> arguments;    

    public ArrayDeclaration(int startIndex, int endIndex, List<Expression> arguments)
    {
        super(startIndex, endIndex);
        this.arguments = arguments;
        
        System.err.println("creating array with " + arguments.size() + " arguments");

    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.ARRAY;
    }

}
