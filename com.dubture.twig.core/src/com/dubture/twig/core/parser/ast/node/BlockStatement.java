/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.statements.Statement;

import com.dubture.twig.core.TwigCoreConstants;

public class BlockStatement extends Statement
{

    protected final BlockName name;
    private final List<Statement> statements;

    public BlockStatement(int startIndex, int stopIndex, BlockName name2,
            List<Statement> statements)
    {
        super(startIndex, stopIndex);        
        this.name = name2;
        this.statements = statements;


    }

    public BlockName getName()
    {
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
    
    public boolean isBlock() 
    {
        return TwigCoreConstants.START_BLOCK.equals(name);       
    }
}
