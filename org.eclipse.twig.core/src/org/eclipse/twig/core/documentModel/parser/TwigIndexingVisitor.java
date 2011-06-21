package org.eclipse.twig.core.documentModel.parser;


import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.IElementRequestor.FieldInfo;
import org.eclipse.twig.core.compiler.ast.parser.ITwigNodeVisitor;
import org.eclipse.twig.core.compiler.ast.parser.TwigCommonTree;
import org.eclipse.twig.core.compiler.ast.parser.TwigParser;


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

		if (node.getType() == TwigParser.STRING) {
			
			int start = node.getTokenStartIndex() + offset;
			int end =  start + node.getText().length();
			
			FieldInfo info = new FieldInfo();
			info.name = node.getText();
			info.nameSourceStart = start;
			info.nameSourceEnd = end;
			info.modifiers = Modifiers.AccPublic;
			info.declarationStart = start;
			
			requestor.enterField(info);
			requestor.exitField(end);					
			
		}
	}
	

	@Override
	public void endVisit(TwigCommonTree node) {


	}
}