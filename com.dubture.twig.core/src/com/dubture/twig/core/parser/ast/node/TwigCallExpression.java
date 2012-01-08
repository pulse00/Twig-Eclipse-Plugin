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

public class TwigCallExpression extends Expression
{

    protected final List<Expression> arguments;
    protected final String name;

    public TwigCallExpression(int startIndex, int stopIndex, String name,
            List<Expression> arguments)
    {
        super(startIndex, stopIndex);
        this.name = name;
        this.arguments = arguments;
    }

    @Override
    public int getKind()
    {
        return ASTNodeKinds.CALL_EXPRESSION;
    }

    public List<Expression> getArguments()
    {
        return arguments;
    }

    public String getName()
    {
        return name;
    }
}
