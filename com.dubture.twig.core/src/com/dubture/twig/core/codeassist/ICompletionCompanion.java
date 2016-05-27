package com.dubture.twig.core.codeassist;

import org.eclipse.core.resources.IProject;

/**
 * Cache between completion contexts and resolvers
 * 
 * @author zulus
 */
public interface ICompletionCompanion {
	public interface Attribute {

	}

	public void put(Attribute attr, Object value);

	public Object get(Attribute attr);

	public IProject getProject();
}
