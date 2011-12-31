package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.statements.Statement;

public class BlockStatement extends Statement
{

    protected final String name;

    public BlockStatement(int startIndex, int stopIndex, String name, List<Expression> expressions)
    {
        super(startIndex, stopIndex);
        this.name = name;
        
        System.err.println("creating block statement " + name +  " with " + expressions.size() + " children:");
        
        for (Expression expr : expressions) {
            System.err.println(expr.getClass());
        }
        
    }

    @Override
    public int getKind()
    {

        return 0;
    }

}
