/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
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
