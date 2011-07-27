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
	}
	
	public Filter(Scalar name) {

		super(null, null);
		this.name = name.getValue().replace("'", "").replace("\"", "");
		
	}

	public Filter(String elementName) {

		super(null, elementName);

	}


}
