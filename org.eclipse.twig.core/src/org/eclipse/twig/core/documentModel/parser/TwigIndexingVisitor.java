package org.eclipse.twig.core.documentModel.parser;


import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.IElementRequestor.FieldInfo;
import org.eclipse.twig.core.compiler.ast.parser.ITwigNodeVisitor;
import org.eclipse.twig.core.compiler.ast.parser.TwigCommonTree;
import org.eclipse.twig.core.compiler.ast.parser.TwigParser;

public class TwigIndexingVisitor implements ITwigNodeVisitor {

	private IElementRequestor requestor;
	
	
	public TwigIndexingVisitor(IElementRequestor requestor) {

		this.requestor = requestor;
	}

	@Override
	public void beginVisit(TwigCommonTree node) {

		if (node.getType() == TwigParser.STRING) {
			
			FieldInfo info = new FieldInfo();
			info.name = node.getText();
			info.nameSourceStart = node.getTokenStartIndex();
			info.nameSourceEnd = node.getTokenStopIndex();
			info.modifiers = Modifiers.AccPublic;
			info.declarationStart = node.getTokenStartIndex();
			
			requestor.enterField(info);
			requestor.exitField(node.getTokenStopIndex());					
			
		}
	}
	

	@Override
	public void endVisit(TwigCommonTree node) {


	}

}
