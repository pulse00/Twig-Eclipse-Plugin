package org.eclipse.twig.core;

import org.eclipse.php.internal.core.ast.nodes.ASTNode;
import org.eclipse.php.internal.core.ast.nodes.Program;
import org.eclipse.php.internal.core.search.IOccurrencesFinder;
import org.eclipse.twig.core.parser.TwigCommonTree;
import org.eclipse.twig.core.parser.TwigNodeVisitor;

public class AbstractOccurrencesFinder extends TwigNodeVisitor implements IOccurrencesFinder {

		
	@Override
	public void beginVisit(TwigCommonTree node) {
		// TODO Auto-generated method stub
		super.beginVisit(node);
	}
	
	@Override
	public void endVisit(TwigCommonTree node) {
		// TODO Auto-generated method stub
		super.endVisit(node);
	}
	
	
	@Override
	public String initialize(Program root, int offset, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String initialize(Program root, ASTNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJobLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnformattedPluralLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnformattedSingularLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Program getASTRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OccurrenceLocation[] getOccurrences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSearchKind() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

}
