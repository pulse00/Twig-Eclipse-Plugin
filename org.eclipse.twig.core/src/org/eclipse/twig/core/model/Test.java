package org.eclipse.twig.core.model;

import org.eclipse.dltk.internal.core.ModelElement;
import org.json.simple.JSONObject;

@SuppressWarnings("restriction")
public class Test extends TwigType {
	
	
	public Test(ModelElement parent, String name) {
		super(parent, name);

	}

	public Test(String elemName) {

		super(null, elemName);
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
