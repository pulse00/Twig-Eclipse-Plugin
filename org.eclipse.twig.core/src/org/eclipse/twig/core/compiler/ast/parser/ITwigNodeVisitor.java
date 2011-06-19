package org.eclipse.twig.core.compiler.ast.parser;


/**
 * 
 * Interface for Twig node visitors.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public interface ITwigNodeVisitor {
	
	
	void beginVisit(TwigCommonTree node);
	void endVisit(TwigCommonTree node);	

}
