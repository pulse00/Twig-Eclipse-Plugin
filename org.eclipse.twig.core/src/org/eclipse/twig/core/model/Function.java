package org.eclipse.twig.core.model;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceMethod;
import org.eclipse.dltk.internal.core.SourceType;
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
public class Function extends SourceType {
	
	
	private String phpClass;
	
	
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

	public String getName() {

		return name;
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

	public String getPhpClass() {
		return phpClass;
	}

	public void setPhpClass(String phpClass) {
		this.phpClass = phpClass;
	}	

}
