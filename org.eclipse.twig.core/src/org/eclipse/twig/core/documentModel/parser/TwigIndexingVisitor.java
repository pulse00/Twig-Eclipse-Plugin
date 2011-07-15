package org.eclipse.twig.core.documentModel.parser;


import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.IElementRequestor.FieldInfo;
import org.eclipse.twig.core.ITwigElementRequestor.BlockInfo;
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
			
			FieldInfo info = new FieldInfo();
			info.name = node.getText();
			info.nameSourceStart = start;
			info.nameSourceEnd = end;
			info.modifiers = Modifiers.AccPublic;
			info.declarationStart = start;
			
			
			requestor.enterField(info);
			requestor.exitField(end);								
			break;
			
		case TwigParser.BLOCK:
		case TwigParser.MACRO:
		case TwigParser.IF:
		case TwigParser.FOR:
			
			
			BlockInfo block = new BlockInfo();
			
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


	}
}