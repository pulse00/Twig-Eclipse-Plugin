/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Expression;

public class HashEntry extends Expression
{

    private final Expression key;
    private final Expression value;

    public HashEntry(Expression left, Expression right)
    {
        this.key = left;
        this.value = right;        
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.HASH_ENTRY;
    }

    public Expression getKey()
    {
        return key;
    }

    public Expression getValue()
    {
        return value;
    }

}
