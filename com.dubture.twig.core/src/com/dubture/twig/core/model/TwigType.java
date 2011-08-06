package com.dubture.twig.core.model;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceType;
import org.json.simple.JSONObject;

/**
 * 
 * Base class for Twig types.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public abstract class TwigType extends SourceType {

	public static final String PHPCLASS = "phpClass";
	public static final String DOC = "doc";
	public static final String ARGS = "args";
	public static final String INTERNAL = "internal";
	public static final String IS_OPEN_CLOSE = "is_open_close";
	
	protected String phpClass;
	protected String internalFunction;
	protected String description;
	
	public TwigType(ModelElement parent, String name) {
		super(parent, name);

	}
	
	public String getPhpClass() {
		return phpClass;
	}

	public void setPhpClass(String phpClass) {
		this.phpClass = phpClass;
	}

	public String getInternalFunction() {
		return internalFunction;
	}

	public void setInternalFunction(String internalFunction) {
		this.internalFunction = internalFunction;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	public abstract String getMetadata();
	
	public abstract void setMetadata(JSONObject data);

}
