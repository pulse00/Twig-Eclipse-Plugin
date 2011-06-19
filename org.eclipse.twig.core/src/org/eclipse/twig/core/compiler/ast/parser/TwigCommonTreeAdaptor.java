package org.eclipse.twig.core.compiler.ast.parser;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;


/**
 * 
 * The {@link TreeAdaptor} for the {@link TwigCommonTree}.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigCommonTreeAdaptor extends CommonTreeAdaptor {
	
    public Object create(Token payload) {
        return new TwigCommonTree(payload);
    }
    
    
    @Override
    public Object errorNode(TokenStream input, Token start, Token stop,
    		RecognitionException e) {

    	return new TwigCommonTree(input, start, stop);
    }
}