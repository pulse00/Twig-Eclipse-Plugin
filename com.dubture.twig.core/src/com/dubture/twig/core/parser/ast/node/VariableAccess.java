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
public class VariableAccess extends Expression {

    /**
     * @param startIndex
     * @param stopIndex
     * @param e
     */
    public VariableAccess(int startIndex, int stopIndex, Expression expression) {
        super(startIndex, stopIndex);
        
        System.err.println("creating variable access with " + expression.getClass());
    }

    @Override
    public int getKind() {

        return ASTNodeKinds.VARIABLE_ACCESS;
    }

}
