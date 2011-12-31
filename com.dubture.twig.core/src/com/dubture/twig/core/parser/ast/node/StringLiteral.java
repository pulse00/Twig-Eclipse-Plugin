/*
 * This file is part of the PDT Extensions eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Literal;

/**
 *
 */
public class StringLiteral extends Literal {

    /**
     * @param start
     * @param end
     * @param string 
     */
    public StringLiteral(int start, int end, String string) {
        super(start, end);
        
        System.err.println("create string literal with " + string);

    }

    /* (non-Javadoc)
     * @see org.eclipse.dltk.ast.statements.Statement#getKind()
     */
    @Override
    public int getKind() {
        // TODO Auto-generated method stub
        return 0;
    }

}
