package org.eclipse.twig.core.model;

import org.eclipse.core.resources.IFile;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;


@SuppressWarnings("restriction")
public class Filter {

	private String name;
	
	public Filter(IFile file, Scalar name) {

		this.name = name.getValue().replace("'", "").replace("\"", "");
		
	}

	public String getName() {

		return name;
	}

	public ModelElement getType() {

		return null;
	}
}
