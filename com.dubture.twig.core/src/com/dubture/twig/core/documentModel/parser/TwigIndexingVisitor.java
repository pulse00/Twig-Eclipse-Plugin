/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.parser;


import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.IElementRequestor.FieldInfo;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IScriptProject;

import com.dubture.twig.core.index.ITwigElementRequestor.BlockInfo;
import com.dubture.twig.core.model.TwigModelAccess;
import com.dubture.twig.core.parser.ITwigNodeVisitor;
import com.dubture.twig.core.parser.TwigCommonTree;
import com.dubture.twig.core.parser.TwigParser;


/**
 * 
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
public class TwigIndexingVisitor implements ITwigNodeVisitor {

	private IElementRequestor requestor;
	private int offset;
	
	private BlockInfo block = null;
	private TwigModelAccess model = TwigModelAccess.getDefault();
	
	private IModelElement modelElement;
	
	public TwigIndexingVisitor(IElementRequestor requestor, int offset, IModelElement modelElement) {

		this.requestor = requestor;
		this.offset = offset;
		this.modelElement = modelElement;
	}

	@Override
	public void beginVisit(TwigCommonTree node) {

		String text = node.getText();
		int start = node.getCharPositionInLine() + offset;
		int end =  text != null ? start + node.getText().length() : 0;
		
		switch (node.getType()) {
				
		case TwigParser.STRING:
			
//			if (block == null) {
//				
//
//				FieldInfo info = new FieldInfo();
//				info.name = node.getText();
//				info.nameSourceStart = start;
//				info.nameSourceEnd = end;
//				info.modifiers = Modifiers.AccPublic;
//				info.declarationStart = start;
//				
//				System.err.println("report field info " +info.name);
//				
//				requestor.enterField(info);
//				requestor.exitField(end);
//				
//			} else {
//
//				if (block.parameterNames == null || block.parameterNames.length == 0) {
//					String[] params = new String[] { node.getText() };
//					block.parameterNames = params;
//					block.parameterTypes = new String[] { "string" };
//					block.parameterInitializers = new String[] { "none" };
//					block.returnType = "string";
//					block.isConstructor = false;
//				}
//			}
//			
			
			break;
			
		case TwigParser.TWIG_TAG:

			block = new BlockInfo();
			
			if (node.getChildCount() == 1) {
				
				TwigCommonTree child = node.getChild(0);
				IScriptProject project = modelElement.getScriptProject();
				String childText = child.getText();
				
				if (model.isStartTag(project, childText) && model.hasEndTag(project, childText)) {
					
					block.name = child.getText();
					block.nameSourceStart = start;
					block.nameSourceEnd = end;
					block.modifiers = Modifiers.AccPublic;
					block.declarationStart = start;
					
					requestor.enterMethod(block);			
					
				} else if (model.isEndTag(modelElement.getScriptProject(), child.getText())) {

					requestor.exitMethod(end);
					
				}
			}
			
			break;
			
		default:
			break;
		}		
	}
	

	@Override
	public void endVisit(TwigCommonTree node) {

		
	}
}
