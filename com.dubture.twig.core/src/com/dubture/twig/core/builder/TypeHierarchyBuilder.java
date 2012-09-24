package com.dubture.twig.core.builder;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.dltk.core.IType;
import org.eclipse.dltk.core.ITypeHierarchy;
import org.eclipse.dltk.core.ITypeHierarchy.Mode;
import org.eclipse.dltk.core.ITypeHierarchyBuilder;

public class TypeHierarchyBuilder implements ITypeHierarchyBuilder {

	public TypeHierarchyBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ITypeHierarchy build(IType type, Mode mode, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
		System.err.println("build");
		return null;
	}

}
