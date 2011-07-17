package org.eclipse.twig.core.parser;

public class TwigStatementVisitor implements ITwigNodeVisitor {

	
	private int type = -1;
	
	private String text = null;
	
	
	@Override
	public void beginVisit(TwigCommonTree node) {

//		if (node.getType() == TwigParser.BLOCK || node.getType() == TwigParser.ENDBLOCK 
//				|| node.getType() == TwigParser.FOR || node.getType() == TwigParser.ENDFOR
//				|| node.getType() == TwigParser.IF || node.getType() == TwigParser.ENDIF
//				|| node.getType() == TwigParser.MACRO || node.getType() == TwigParser.ENDMACRO) {
//			
//			type = node.getType();
//			
//		} else if (node.getType() == TwigParser.STRING) {			
//			text = node.getText();
//		}

	}

	@Override
	public void endVisit(TwigCommonTree node) {


	}
	
	
	public int getStatementType() {
		
		return type;
		
	}
	
	public String getStatementArgument() {
		

		return text;
		
	}

}
