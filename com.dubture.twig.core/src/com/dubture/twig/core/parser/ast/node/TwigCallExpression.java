package com.dubture.twig.core.parser.ast.node;

import java.util.Iterator;
import java.util.List;

import org.eclipse.dltk.ast.expressions.Expression;

public class TwigCallExpression extends Expression
{
    
    protected final List<Expression> arguments;
    protected final String name;

    public TwigCallExpression(int startIndex, int stopIndex, String name, List<Expression> arguments)
    {
        super(startIndex, stopIndex);
        this.name = name;
        this.arguments = arguments;
        
        System.err.println("creating function " + name + " with " + arguments.size() + " arguments");
        
        for (Expression expression : arguments) {
            System.err.println(expression.getClass());
        }
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.CALL_EXPRESSION;
    }
    
    public List<Expression> getArguments()
    {
        return arguments;
    }

    public String getName()
    {
        return name;
    }    
}
