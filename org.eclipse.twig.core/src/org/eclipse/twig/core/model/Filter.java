package org.eclipse.twig.core.model;

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
public class Filter {

	private String name;
	
	public Filter(Scalar name) {

		this.name = name.getValue().replace("'", "").replace("\"", "");
		
	}

	public Filter(String elementName) {

		this.name = elementName;
	}

	public String getName() {

		return name;
	}

	public ModelElement getType() {

		return null;
	}
}
