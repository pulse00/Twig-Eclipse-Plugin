package org.eclipse.twig.ui.editor.folding;

import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.php.internal.ui.folding.IStructuredTextFoldingProvider;

@SuppressWarnings("restriction")
public class StructuredTextFoldingProvider implements
		IStructuredTextFoldingProvider {

	@Override
	public void install(ProjectionViewer viewer) {

		
		System.err.println("install");
		
	}

	@Override
	public void uninstall() {

		System.err.println("uninstall");
		
	}

	@Override
	public void initialize() {

		System.err.println("initialize");
		
	}

}
