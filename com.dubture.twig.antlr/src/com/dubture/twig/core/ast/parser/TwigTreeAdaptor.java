/*
 * This file is part of the PDT Extensions eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.core.ast.parser;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;


/**
 *
 */
public class TwigTreeAdaptor extends CommonTreeAdaptor {

    public Object create(Token payload) {
        
        return new TwigCommonTree(payload);
    }
    
    
    @Override
    public Object errorNode(TokenStream input, Token start, Token stop,
            RecognitionException e) {

        return new TwigCommonTree(input, start, stop);
    }    
}
