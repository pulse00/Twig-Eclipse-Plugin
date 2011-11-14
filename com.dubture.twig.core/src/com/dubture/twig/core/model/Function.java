/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.model;

import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceMethod;
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;


/**
 * 
 * ... DLTK {@link SourceMethod} is private ....
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class Function extends TwigCallable {

	

	
	public Function(ModelElement parent, String name) {
		
		super(parent, name);
	}
	
	public Function(Scalar scalar) {

		super(null, null);
		name = scalar.getValue().replaceAll("['\"]", "");
		
	}
	public Function(String elementName) {

		super(null, elementName);
		
	}



}
