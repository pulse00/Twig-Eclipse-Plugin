package org.eclipse.twig.core.search;

import org.eclipse.twig.core.parser.ITwigNodeVisitor;
import org.eclipse.twig.core.parser.TwigCommonTree;

/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class OpenCloseTagFinder extends AbstractOccurrencesFinder {

	@Override
	protected ITwigNodeVisitor getVisitor(int offset) {

		return new OpenCloseTagVisitor(offset);
	}
	
	
	private class OpenCloseTagVisitor implements ITwigNodeVisitor {

		private final int offset;		
		private int nestCount = 0;
		
		public OpenCloseTagVisitor(int offset) {
			
			this.offset = offset;
			
		}
		
		@Override
		public void beginVisit(TwigCommonTree node) {
			
			

			
		}

		@Override
		public void endVisit(TwigCommonTree node) {

			
		}		
	}
}