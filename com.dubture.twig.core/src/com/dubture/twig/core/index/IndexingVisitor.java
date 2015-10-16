package com.dubture.twig.core.index;

import org.eclipse.core.resources.IFile;

import com.dubture.indexing.core.index.AbstractIndexingVisitor;

public class IndexingVisitor extends AbstractIndexingVisitor
		implements com.dubture.indexing.core.index.IndexingVisitor {

	@Override
	public void resourceDeleted(IFile file) {

	}

	@Override
	public void visit(Object file) {
		System.out.println(getResource().getFullPath().toString());
		System.out.println(file);
	}

}
