package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.statements.Statement;

public class TwigModuleDeclaration extends ModuleDeclaration {

	public TwigModuleDeclaration(int sourceLength) {
		super(sourceLength);

	}

	public TwigModuleDeclaration(int length, List<Statement> statements) {
		super(length);
		
		for (Statement statement : statements) {		
			addStatement(statement);
		}
	}
}
