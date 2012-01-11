package com.dubture.twig.core.parser.ast.visitor;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.statements.Statement;

import com.dubture.twig.core.parser.ast.node.BlockName;
import com.dubture.twig.core.parser.ast.node.BlockStatement;
import com.dubture.twig.core.parser.ast.node.PrintStatement;
import com.dubture.twig.core.parser.ast.node.StringLiteral;
import com.dubture.twig.core.parser.ast.node.TwigCallExpression;
import com.dubture.twig.core.parser.ast.node.Variable;

public abstract class TwigASTVisitor extends ASTVisitor
{

    public boolean visit(PrintStatement s) throws Exception
    {
        return visitGeneral(s);
    }

    public boolean endvisit(PrintStatement s) throws Exception
    {
        endvisitGeneral(s);
        return false;
    }
    
    public boolean visit(Variable s) throws Exception
    {
        return visitGeneral(s);
    }

    public boolean endvisit(Variable s) throws Exception
    {
        endvisitGeneral(s);
        return false;
    }
    
    public boolean visit(StringLiteral s) throws Exception
    {
        return visitGeneral(s);
    }

    public boolean endvisit(StringLiteral s) throws Exception
    {
        endvisitGeneral(s);
        return false;
    }
    
    public boolean visit(BlockName s) throws Exception
    {
        return visitGeneral(s);
    }

    public boolean endvisit(BlockName s) throws Exception
    {
        endvisitGeneral(s);
        return false;
    }
        
    public boolean visit(BlockStatement block) throws Exception
    {        
       return visitGeneral(block);
    }
    
    public boolean endvisit(BlockStatement block) throws Exception
    {
        endvisitGeneral(block);
        return false;
    }

    public boolean visit(TwigCallExpression s) throws Exception
    {
        return visitGeneral(s);
    }

    public boolean endvisit(TwigCallExpression s) throws Exception
    {
        endvisitGeneral(s);
        return false;
    }
    
    
    public boolean visit(Expression s) throws Exception
    {
        Class<? extends ASTNode> nodeClass = s.getClass();
        if (nodeClass.equals(Variable.class)) {
            return visit((Variable)s);
        } else if (nodeClass.equals(BlockName.class)) {
            return visit((BlockName)s);
        } else if (nodeClass.equals(TwigCallExpression.class)) {
            return visit((TwigCallExpression) s);
        } else if (nodeClass.equals(StringLiteral.class)) {
            return visit((StringLiteral)s);
        }

        return true;

    }

    public boolean endvisit(Expression s) throws Exception
    {
        Class<? extends ASTNode> nodeClass = s.getClass();
        if (nodeClass.equals(Variable.class)) {
            return endvisit((Variable)s);
        } else if (nodeClass.equals(BlockName.class)) {
            return endvisit((BlockName)s);
        } else if (nodeClass.equals(TwigCallExpression.class)) {
            return endvisit((TwigCallExpression) s);
        } else if (nodeClass.equals(StringLiteral.class)) {
            return endvisit((StringLiteral)s);
        }
        return true;

    } 
    
    public boolean visit(Statement s) throws Exception
    {

        Class<? extends ASTNode> nodeClass = s.getClass();
        if (nodeClass.equals(PrintStatement.class)) {
            return visit((PrintStatement) s);
        } else if (nodeClass.equals(BlockStatement.class)) {
            return visit((BlockStatement)s);
        } else if (nodeClass.equals(Variable.class)) {
            return visit((Variable)s);
        }

        return true;
    }
    
    @Override
    public boolean endvisit(Statement s) throws Exception
    {

        Class<? extends ASTNode> nodeClass = s.getClass();
        if (nodeClass.equals(PrintStatement.class)) {
            return endvisit((PrintStatement) s);
        } else if (nodeClass.equals(BlockStatement.class)) {
            return endvisit((BlockStatement)s);
        } else if (nodeClass.equals(Variable.class)) {
            return endvisit((Variable)s);
        }
        
        return true;
    }
}
