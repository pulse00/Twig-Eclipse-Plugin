package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Literal;

public class IdentNode extends Literal
{

    public IdentNode(int startIndex, int stopIndex, String string)
    {
        super(startIndex, stopIndex);
        fLiteralValue = string;
//        System.err.println("ident node: " + string);
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.IDENT;
    }

    public String toString()
    {
        return fLiteralValue;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof IdentNode)) {
            return false;
        }

        IdentNode other = (IdentNode) obj;

        return other.start() == start() && other.end() == end()
                && other.getValue() == getValue();

    }
}
