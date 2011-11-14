/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser;

public class TwigStatementVisitor implements ITwigNodeVisitor {

	
	private int type = -1;
	
	private String text = null;
	
	
	@Override
	public void beginVisit(TwigCommonTree node) {

		if (node.getType() == TwigParser.TWIG_TAG) {

			if (node.getChildCount() == 1) {
				
				type = node.getType();
				
				TwigCommonTree child = node.getChild(0);
				text = child.getText();				
				
			}
		}
	}

	@Override
	public void endVisit(TwigCommonTree node) {


	}
	
	
	public int getStatementType() {
		
		return type;
		
	}
	
	public String getTag() {
		

		return text;
		
	}

}
