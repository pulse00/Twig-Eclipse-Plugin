package org.eclipse.twig.core.model;

import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceMethod;
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;
import org.json.simple.JSONObject;


/**
 * 
 * ... DLTK {@link SourceMethod} is private ....
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class Function extends TwigType {
	
	
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



	@SuppressWarnings("unchecked")
	public String getMetadata() {

		JSONObject metadata = new JSONObject();
		
		if (phpClass != null)
			metadata.put(PHPCLASS, getPhpClass());
		
		return metadata.toJSONString();
	}

	@Override
	public void setMetadata(JSONObject data) {
		// TODO Auto-generated method stub
		
	}

}
