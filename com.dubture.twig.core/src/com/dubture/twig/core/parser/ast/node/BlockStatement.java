package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.statements.Statement;

public class BlockStatement extends Statement
{

    protected final String name;
    private final List<Expression> expressions;

    public BlockStatement(int startIndex, int stopIndex, String name, List<Expression> expressions)
    {
        super(startIndex, stopIndex);
        this.name = name;
        this.expressions = expressions;
        
//        System.err.println("creating block statement '" + name +  "' with " + expressions.size() + " children:");
//        
//        for (Expression expr : expressions) {
//            System.err.println(expr.getClass());
//        }
        
    }
    
    public String getName() 
    {        
        return name; 
    }
    
    public void traverse(ASTVisitor visitor) throws Exception {
        final boolean visit = visitor.visit(this);
        if (visit) {
            if ( expressions != null) {                
                for (Expression exp : expressions) {
                    exp.traverse(visitor);
                }                
            }
        }
        visitor.endvisit(this);
    }
    
    

    @Override
    public int getKind()
    {
        return ASTNodeKinds.BLOCK_STATEMENT;
    }
}
