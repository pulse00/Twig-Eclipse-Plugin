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
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;

/**
 * 
 * 
 * The {@link Function} class represents a Twig_Function_Method
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class Filter extends TwigCallable {

	public Filter(ModelElement parent, String name) {
		super(parent, name);

		if (parent != null) {
			setScriptProject(parent.getScriptProject());
		}
	}

	public Filter(Scalar name) {
		super(null, name.getValue().replace("'", "").replace("\"", ""));
	}

	public Filter(String elementName) {
		super(null, elementName);
	}
}
