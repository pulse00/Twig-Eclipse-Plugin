/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser;

import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;


/**
 * 
 * {@link TwigCommonTree} is responsible for traversing
 * the Twig AST.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigCommonTree extends org.antlr.runtime.tree.CommonTree {

	public TwigCommonTree(Token payload) {
		super(payload);

	}

	public TwigCommonTree(TokenStream input, Token start, Token stop) {
		

	}
	
	@Override
    public TwigCommonTree getChild(int i) {
    	
        if (children == null || i >= children.size()) {
            return null;
        }
        return (TwigCommonTree)children.get(i);
    }
    
    @Override
    public CommonToken getToken() {
        return (CommonToken)token;
    }
    
    @SuppressWarnings("unchecked")
	public List<TwigCommonTree> getChildTrees() {
    	    	
    	return (List<TwigCommonTree>) getChildren();
    	
    }

    /**
     * Traverse the Twig tree.
     * 
     * @param visitor
     */
	public void accept(ITwigNodeVisitor visitor) {

		visitor.beginVisit(this);
		
		for (int i = 0; i < getChildCount(); i++) {
			TwigCommonTree child = (TwigCommonTree) getChild(i);
			child.accept(visitor);
			
		}
		
		visitor.endVisit(this);
		
	}	

}
