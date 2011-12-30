package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Literal;

public class IdentNode extends Literal
{

    protected IdentNode(int start, int end)
    {
        super(start, end);

    }

    public IdentNode(String string)
    {
        super(0, 0);
    }

    @Override
    public int getKind()
    {

        return ASTNodeKinds.IDENT;
    }

}
