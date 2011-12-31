package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Literal;

public class IdentNode extends Literal
{
    private final String value;

    public IdentNode(int startIndex, int stopIndex, String string)
    {
        super(startIndex, stopIndex);
        this.value = string;        
        System.err.println("ident node: " + string);        
    }

    @Override
    public int getKind()
    {

        return ASTNodeKinds.IDENT;
    }
    
    public String toString() {
        
        return value;
    }

}
