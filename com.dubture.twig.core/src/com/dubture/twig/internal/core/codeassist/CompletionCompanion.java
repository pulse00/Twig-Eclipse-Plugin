package com.dubture.twig.internal.core.codeassist;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;

import com.dubture.twig.core.codeassist.ICompletionCompanion;

public class CompletionCompanion implements ICompletionCompanion {

	private Map<Attribute, Object> attrs = new HashMap<ICompletionCompanion.Attribute, Object>();
	private IProject project;

	public CompletionCompanion(IProject project) {
		this.project = project;
	}

	@Override
	public void put(Attribute attr, Object value) {
		attrs.put(attr, value);
	}

	@Override
	public Object get(Attribute attr) {
		return attrs.get(attr);
	}

	@Override
	public IProject getProject() {
		return project;
	}

}
