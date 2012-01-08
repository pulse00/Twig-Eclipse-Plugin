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

import org.eclipse.dltk.ast.expressions.Expression;

public class Hash extends Expression
{
    private final List<Expression> expressions;

    public Hash(int startIndex, int stopIndex, List<Expression> expressions)
    {
        super(startIndex, stopIndex);
        this.expressions = expressions;
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.HASH;
    }

}
