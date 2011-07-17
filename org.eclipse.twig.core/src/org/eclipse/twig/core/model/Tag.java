package org.eclipse.twig.core.model;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.SourceType;

/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class Tag extends SourceType {
	
	private String startTag;
	private String endTag;	
	private String phpClass;
	private String description;
	
	
	public Tag(String startTag) {

		super(null, startTag);
		this.startTag = startTag;
		
	}

	public Tag() {

		super(null, null);
		
	}

	public String getStartTag() {
		return startTag;
	}

	public void setStartTag(String startTag) {
		
		this.name = startTag;
		this.startTag = startTag;
	}

	public String getEndTag() {
		return endTag;
	}

	public void setEndTag(String endTag) {
		this.endTag = endTag;
	}
	
	
	@Override
	public String toString() {

		return startTag + " : " + endTag;
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

	public void setPHPClass(String clazz) {
		
		this.phpClass = clazz;
		
	}
	
	public String getPHpClass() {
		
		return phpClass;
	}

	public void setDescription(String desc) {

		this.description = desc;
		
	}	
	
	public String getDescription() {
		
		return description;
		
	}
}