/*
 * This file is part of the PDT Extensions eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.core.ast.parser;

/**
 *
 */
public class IdentNode implements AstNode {

    public IdentNode(String text) {
//        System.err.println("creating ident node " + text);
    }
    /* (non-Javadoc)
     * @see com.dubture.twig.core.ast.parser.AstNode#accept(com.dubture.twig.core.ast.parser.Visitor)
     */
    @Override
    public void accept(Visitor visitor) {
        // TODO Auto-generated method stub

    }

}
