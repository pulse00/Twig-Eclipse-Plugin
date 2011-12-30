/*
 * This file is part of the PDT Extensions eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.core.ast.parser;

import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;

/**
 *
 */
public class TwigCommonTree extends CommonTree implements AstNode {
    
    public TwigCommonTree(Token payload) {        
        super(payload);
    }

    public TwigCommonTree(TokenStream input, Token start, Token stop) {

    }
    
    @Override
    public void accept(Visitor visitor) {

        if (!visitor.beginVisit(this)) {            
            visitor.endVisit(this);
            return;
        }
        
        try {           
            if (children != null) {
                for (Object o : getChildren()) {
                    if (o instanceof AstNode) {
                        AstNode node = (AstNode) o;
                        visitor.beginVisit(node);
                        if (node != null && visitor != null) {
                            node.accept(visitor); 
                        }
                        visitor.endVisit(node);
                    }                
                }
            }
        } catch (Exception e) {            
            System.err.println(e.getMessage());            
        } finally {
            visitor.endVisit(this);            
        }
    }    
}