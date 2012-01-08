/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.NumericLiteral;

public class NumberNode extends NumericLiteral
{
    public NumberNode(int start, int end, long value)
    {
        super(start, end, value);
    }
}
