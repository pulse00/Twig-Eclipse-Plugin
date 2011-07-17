package org.eclipse.twig.core.documentModel.parser;


import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.IElementRequestor.FieldInfo;
import org.eclipse.twig.core.index.ITwigElementRequestor.BlockInfo;
import org.eclipse.twig.core.parser.ITwigNodeVisitor;
import org.eclipse.twig.core.parser.TwigCommonTree;
import org.eclipse.twig.core.parser.TwigParser;


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
	
	public TwigIndexingVisitor(IElementRequestor requestor, int offset) {

		this.requestor = requestor;
		this.offset = offset;
	}

	@Override
	public void beginVisit(TwigCommonTree node) {

		String text = node.getText();
		int start = node.getCharPositionInLine() + offset;
		int end =  text != null ? start + node.getText().length() : 0;
		
		switch (node.getType()) {
				
		case TwigParser.STRING:
			
			if (block == null) {
				
				FieldInfo info = new FieldInfo();
				info.name = node.getText();
				info.nameSourceStart = start;
				info.nameSourceEnd = end;
				info.modifiers = Modifiers.AccPublic;
				info.declarationStart = start;
				
				
				requestor.enterField(info);
				requestor.exitField(end);
				
			} else {

				if (block.parameterNames == null || block.parameterNames.length == 0) {
					String[] params = new String[] { node.getText() };
					block.parameterNames = params;
					block.parameterTypes = new String[] { "string" };
					block.parameterInitializers = new String[] { "none" };
					block.returnType = "string";
					block.isConstructor = false;
				}
			}
			
			
			break;
			
		case TwigParser.BLOCK:
		case TwigParser.MACRO:
		case TwigParser.IF:
		case TwigParser.FOR:
			
			
			block = new BlockInfo();
			
			block.name = text;
			block.nameSourceStart = start;
			block.nameSourceEnd = end;
			block.modifiers = Modifiers.AccPublic;
			block.declarationStart = start;
			
			requestor.enterMethod(block);			
			
			break;

			
		case TwigParser.ENDBLOCK:
		case TwigParser.ENDMACRO:
		case TwigParser.ENDIF:
		case TwigParser.ENDFOR:
			
			requestor.exitMethod(end);
			
			break;
			
		default:
			break;
		}
		
	}
	

	@Override
	public void endVisit(TwigCommonTree node) {

		
		switch (node.getType()) {
		
			
		case TwigParser.ENDBLOCK:
		case TwigParser.ENDMACRO:
		case TwigParser.ENDIF:
		case TwigParser.ENDFOR:		

			block = null;
			break;
			
		}

	}
}