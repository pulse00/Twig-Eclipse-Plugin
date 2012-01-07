package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.statements.Statement;

public class BlockStatement extends Statement
{

    protected final String name;
    private final List<Statement> statements;

    public BlockStatement(int startIndex, int stopIndex, String name, List<Statement> statements)
    {
        super(startIndex, stopIndex);
        this.name = name;
        this.statements = statements;
        
//        System.err.println("creating block statement '" + name +  "' with " + statements.size() + " children:");
//        
//        for (Object expr : statements) {
//            System.err.println(expr.getClass());
//        }
        
    }
    
    public String getName() 
    {        
//        System.err.println("+++ name is " + name);
        return name; 
    }
    
    public void traverse(ASTVisitor visitor) throws Exception {
        final boolean visit = visitor.visit(this);
        if (visit) {
            if ( statements != null) {                
                for (Statement exp : statements) {
                    exp.traverse(visitor);
                }                
            }
        }
        visitor.endvisit(this);
    }
    
    public String getBlockName()
    {
        if (statements != null && statements.size() > 0) {
            
            Statement statement = statements.get(0);
            
            if (statement instanceof Variable) {
                Variable var = (Variable) statement;
                
                return var.getValue();
            }            
        }        
        
        return "";
        
    }
    
    
    @Override
    public int getKind()
    {
        return ASTNodeKinds.BLOCK_STATEMENT;
    }
}
