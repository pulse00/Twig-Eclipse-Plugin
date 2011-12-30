package com.dubture.twig.core.ast.parser;

import java.util.List;

public class Template implements AstNode {

	protected List<AstNode> statements;
	
	public Template(List<AstNode> statements) {

		this.statements = statements;
		System.err.println("created template containing " + statements.size() + " statements");
	}

	@Override
	public void accept(Visitor visitor) {
		
		visitor.beginVisit(this);

		for (AstNode statement : statements) {			
			statement.accept(visitor);	
		}
		
		visitor.endVisit(this);

	}

}
