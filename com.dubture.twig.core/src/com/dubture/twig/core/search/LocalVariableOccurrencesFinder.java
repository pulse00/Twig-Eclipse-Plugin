package com.dubture.twig.core.search;

import com.dubture.twig.core.parser.ITwigNodeVisitor;
import com.dubture.twig.core.parser.TwigCommonTree;
import com.dubture.twig.core.parser.TwigParser;


/**
 * 
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class LocalVariableOccurrencesFinder extends AbstractOccurrencesFinder {


	@Override
	protected ITwigNodeVisitor getVisitor(int offset) {

		return new NodeVisitor(offset);
		
	}
	
	private class NodeVisitor implements ITwigNodeVisitor {

		private final int curOffset;

		public NodeVisitor(int offset) {

			this.curOffset = offset;
		}


		@Override
		public void beginVisit(TwigCommonTree node) {

			int nodeStart = node.getCharPositionInLine() + curOffset /*+ 1*/;
			int length = node.getText() != null ? node.getText().length() : 0;
			
			if (node.getType() == twigNode.getType() && node.getType() == TwigParser.STRING) {
				
				String text  = node.getText();
				
				if (twigNode.getName().equals(text)) {
					OccurrenceLocation location = new OccurrenceLocation(nodeStart, length, F_READ_OCCURRENCE, text);
					locations.add(location);
				}
			}
		}

		@Override
		public void endVisit(TwigCommonTree node) {


		}		
	}
}