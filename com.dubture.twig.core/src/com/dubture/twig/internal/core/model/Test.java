/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.internal.core.model;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.php.internal.core.compiler.ast.nodes.PHPDocBlock;
import org.json.simple.JSONObject;

import com.dubture.twig.core.model.ITest;

/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class Test extends TwigType implements ITest {

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
		description = (String) data.get(DOC);
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

		description = shortDesc + longDesc;
		return description;

	}

	public void setScriptProject(IScriptProject project) {

		this.project = project;
	}

	@Override
	public IScriptProject getScriptProject() {

		return project;
	}

	@Override
	public int getKind() {
		return TEST;
	}
}
