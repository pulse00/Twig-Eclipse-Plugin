package org.eclipse.twig.core.model;


public class BlockTag {
	
	private String startTag;
	private String endTag;
	
	public BlockTag(String startTag) {

		this.startTag = startTag;
		
	}

	public BlockTag() {

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