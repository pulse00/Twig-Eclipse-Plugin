package org.eclipse.twig.core.model;

import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;

@SuppressWarnings("restriction")
public class Function {
	
	private String name;
	
	public Function(Scalar name) {

		this.name = name.getValue().replaceAll("['\"]", "");
		
		
	}
	public Function(String elementName) {

		this.name = elementName;
	}

	public String getName() {

		return name;
	}

	public ModelElement getType() {

		return null;
	}	

}
