/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.model;

import org.json.simple.JSONObject;


/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class Tag extends TwigType {
	
	private String startTag;
	private String endTag;	

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
	public String getMetadata() {

		return "";
	}

	@Override
	public void setMetadata(JSONObject data) {
		// TODO Auto-generated method stub
		
	}
}
