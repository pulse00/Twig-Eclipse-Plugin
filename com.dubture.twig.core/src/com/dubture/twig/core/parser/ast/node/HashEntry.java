package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Expression;

public class HashEntry extends Expression
{

    private final Expression key;
    private final Expression value;

    public HashEntry(Expression left, Expression right)
    {
        this.key = left;
        this.value = right;        
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.HASH_ENTRY;
    }

    public Expression getKey()
    {
        return key;
    }

    public Expression getValue()
    {
        return value;
    }

}
