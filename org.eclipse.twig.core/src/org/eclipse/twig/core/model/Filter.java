package org.eclipse.twig.core.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.php.internal.core.compiler.ast.nodes.FormalParameter;
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPDocBlock;
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
public class Filter extends TwigType {

	private PHPDocBlock doc;	
	private JSONArray filterArguments = new JSONArray();
	
	private Map<String, String> arguments = new HashMap<String, String>();
	
	private IScriptProject _project;
	
	
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
	
	private String getDocString() {
		
		if (description != null)
			return description;
		
		if (doc == null)
			return "";
		
		
		
		String longDesc = doc.getLongDescription() != null ? doc.getLongDescription() : "";
		String shortDesc = doc.getShortDescription() != null ? doc.getShortDescription() : "";
		
		description = longDesc + shortDesc;
		return description;		
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public String getMetadata() {
		
		JSONObject data = new JSONObject();
		data.put(PHPCLASS, phpClass);
		data.put(DOC, getDocString());
		data.put(ARGS, filterArguments);
		data.put(INTERNAL, internalFunction);
		
		return data.toString();
	}

	public void addDoc(PHPDocBlock doc) {

		this.doc = doc;
		
	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public void setMetadata(JSONObject data) {
				
		phpClass = (String) data.get(PHPCLASS);
		description= (String) data.get(DOC);
		filterArguments = (JSONArray) data.get(ARGS);
		internalFunction = (String) data.get(INTERNAL);
		
		
		for (Object o : filterArguments) {
			
			JSONObject json = (JSONObject) o;
			
			if (json == null)
				continue;
			
			
			Iterator it = json.keySet().iterator();
			
			while(it.hasNext()) {
				
				String param = (String) it.next();				
				String def = (String) json.get(param);
				arguments.put(param, def);
				
			}
			
		}
		
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addArgs(List arguments) {

		JSONArray args = new JSONArray();
		
		for (Object o : arguments) {
			
			FormalParameter param = (FormalParameter) o;
			
			if (param == null)
				continue;


			JSONObject arg = new JSONObject();
			ASTNode init = param.getInitialization();
			
			String defaultValue = init != null ? init.getClass().toString() : "";
			
			if (init instanceof Scalar) {				
				Scalar scalar = (Scalar) init;				
				defaultValue = scalar.getValue();
				
			}
			
			this.arguments.put(param.getName(), defaultValue);
			arg.put(param.getName(), defaultValue);
			args.add(arg);
			
		}
		
		filterArguments = args;

	}
	
	public Map<String, String> getArguments() {
		
		return arguments;
		
	}

	public void setScriptProject(IScriptProject scriptProject) {

		_project = scriptProject;
		
	}
	
	public IScriptProject getScriptProject() {

		return _project;
		
	}
}
