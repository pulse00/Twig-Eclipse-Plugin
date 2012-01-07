package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.statements.Statement;

public class PrintStatement extends Statement
{
    protected List<Expression> expressions;

    public PrintStatement(int start, int end, List<Expression> expressions)
    {
        this.expressions = expressions;
//        System.err.println("print with " + expressions.size() + " expressions");
        
        for (Expression expression : expressions) {
            
//            System.err.println(expression.getClass());
            if (expression instanceof Variable) {
                
                Variable var = (Variable) expression;
//                System.err.println(var.getValue());
            }
        }
    }

    @Override
    public void traverse(ASTVisitor visitor) throws Exception
    {
        if (visitor.visit(this)) {

            if (expressions != null) {
                for (Expression exp : expressions) {

                    if (exp != null) {
                        exp.traverse(visitor);
                    }

                }
            }
            visitor.endvisit(this);
        }
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.PRINT_STATEMENT;
    }
}
