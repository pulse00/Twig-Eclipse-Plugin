/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Literal;

/**
 * 
 * A twig variable.
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class Variable extends Literal
{

    public Variable(int startIndex, int stopIndex, String string)
    {
        super(startIndex, stopIndex);
        fLiteralValue = string;
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.IDENTIFIER;
    }

    public String toString()
    {
        return fLiteralValue;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Variable)) {
            return false;
        }

        Variable other = (Variable) obj;

        return other.sourceStart() == sourceStart() && other.sourceEnd() == sourceEnd()
                && other.getValue() == getValue();

    }
}
