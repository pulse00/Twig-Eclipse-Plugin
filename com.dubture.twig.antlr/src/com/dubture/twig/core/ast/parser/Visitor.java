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
 * Basic interface for the visitor pattern
 */
public interface Visitor {

    /**
     * 
     * @param node
     */
    boolean beginVisit(AstNode node);
    
    /**
     * 
     * @param node
     */
    boolean endVisit(AstNode node);
}
