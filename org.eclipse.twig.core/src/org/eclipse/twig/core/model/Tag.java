package org.eclipse.twig.core.model;

/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class Tag {
	
	private String startTag;
	private String endTag;
	
	public Tag(String startTag) {

		this.startTag = startTag;
		
	}

	public Tag() {

	}

	public String getStartTag() {
		return startTag;
	}

	public void setStartTag(String startTag) {
		this.startTag = startTag;
	}

	public String getEndTag() {
		return endTag;
	}

	public void setEndTag(String endTag) {
		this.endTag = endTag;
	}
}