package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.statements.Statement;

public class BlockStatement extends Statement
{

    protected final String name;
    private final List<Statement> statements;

    public BlockStatement(int startIndex, int stopIndex, String name,
            List<Statement> statements)
    {
        super(startIndex, stopIndex);
        this.name = name;
        this.statements = statements;

        // System.err.println("creating block statement '" + name + "' with " +
        // statements.size() + " children:");
        //
        // for (Object expr : statements) {
        // System.err.println(expr.getClass());
        // }

    }

    public String getName()
    {
        // System.err.println("+++ name is " + name);
        return name;
    }

    public void traverse(ASTVisitor visitor) throws Exception
    {
        final boolean visit = visitor.visit(this);
        if (visit) {
            if (statements != null) {
                for (Statement exp : statements) {
                    exp.traverse(visitor);
                }
            }
        }
        visitor.endvisit(this);
    }

    public Statement getFirstChild()
    {
        if (statements != null && statements.size() > 0) {
            return statements.get(0);
        }

        return null;

    }

    /**
     * Get the BlockName variable: {% block NAME %}
     * 
     * @return the first block variable or null if none available
     */
    public Variable getBlockName()
    {
        Statement first = getFirstChild();
        
        if (first == null) {
            return null;
        }
        Statement statement = first;

        if (statement instanceof Variable) {
            return (Variable) statement;
        }
        return null;
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.BLOCK_STATEMENT;
    }
}
