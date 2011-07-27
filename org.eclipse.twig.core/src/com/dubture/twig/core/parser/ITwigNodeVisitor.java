package com.dubture.twig.core.parser;


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
