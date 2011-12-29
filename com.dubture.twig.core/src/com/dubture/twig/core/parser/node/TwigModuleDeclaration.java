package com.dubture.twig.core.parser.node;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;

public class TwigModuleDeclaration extends ModuleDeclaration {

	public TwigModuleDeclaration(int start, int end) {		
		super(end - start, true);
	}

}
