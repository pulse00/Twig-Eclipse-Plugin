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

import com.dubture.twig.core.util.Debug;

public class ArrayDeclaration extends Expression
{

    protected final List<Expression> arguments;

    public ArrayDeclaration(int startIndex, int endIndex,
            List<Expression> arguments)
    {
        super(startIndex, endIndex);
        this.arguments = arguments;

        if (Debug.debugLexer) {
            System.err.println("creating array with " + arguments.size()
                    + " arguments");
        }
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.ARRAY;
    }
}
