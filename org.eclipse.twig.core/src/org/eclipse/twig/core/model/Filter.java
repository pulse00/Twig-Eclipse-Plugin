package org.eclipse.twig.core.model;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceType;
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
public class Filter extends SourceType {

	
	private String phpClass;
	
	
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

	public String getName() {

		return name;
	}

	public ModelElement getType() {

		return null;
	}

	public void setPHPClass(String clazz) {

		phpClass = clazz;
		
	}
	
	public String getPHPClass() {
		
		return this.phpClass;
	}
	
	@Override
	public int getFlags() throws ModelException {

		return Modifiers.AccPublic;
	}
	
	@Override
	public Object getElementInfo() throws ModelException {

		return new FakeTypeElementInfo();
	}
	
	@Override
	protected Object openWhenClosed(Object info, IProgressMonitor monitor)
			throws ModelException {

		return new FakeTypeElementInfo();

	}	
}
