package org.eclipse.twig.core.model;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPDocBlock;
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
public class Test extends TwigType {
	
	protected PHPDocBlock doc;
	private IScriptProject project;	

	
	public Test(ModelElement parent, String name) {
		super(parent, name);

	}

	public Test(String elemName) {

		super(null, elemName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getMetadata() {
		
		JSONObject data = new JSONObject();
		data.put(PHPCLASS, phpClass);
		data.put(DOC, getDocString());
		data.put(INTERNAL, internalFunction);
		
		return data.toString();
	}

	@Override
	public void setMetadata(JSONObject data) {

		phpClass = (String) data.get(PHPCLASS);
		description= (String) data.get(DOC);
		internalFunction = (String) data.get(INTERNAL);		
		
	}

	public void addDoc(PHPDocBlock doc) {

		this.doc = doc;
		
	}
	
	protected String getDocString() {
		
		if (description != null)
			return description;
		
		if (doc == null)
			return "";
		
		
		
		String longDesc = doc.getLongDescription() != null ? doc.getLongDescription() : "";
		String shortDesc = doc.getShortDescription() != null ? doc.getShortDescription() : "";
		
		System.err.println("long: " + longDesc);
		System.err.println("short: " + shortDesc);
		
		description = shortDesc +  longDesc;
		return description;		
		
	}

	public void setScriptProject(IScriptProject project) {

		this.project = project;
	}
	
	
	@Override
	public IScriptProject getScriptProject() {
		
		return project;
	}


}
