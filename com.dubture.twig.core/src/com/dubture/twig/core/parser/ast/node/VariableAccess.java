/*
 * This file is part of the PDT Extensions eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Expression;

/**
 *
 */
public class VariableAccess extends Expression
{

    private final Expression lhs;
    private final Expression rhs;

    /**
     * @param startIndex
     * @param stopIndex
     * @param expression
     */
    public VariableAccess(int startIndex, int stopIndex, Expression lhs,
            Expression rhs)
    {
        super(startIndex, stopIndex);
        this.lhs = lhs;
        this.rhs = rhs;

    }

    @Override
    public int getKind()
    {

        return ASTNodeKinds.VARIABLE_ACCESS;
    }

}
