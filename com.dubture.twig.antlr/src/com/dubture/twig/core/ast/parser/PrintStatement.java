package com.dubture.twig.core.ast.parser;

import java.util.List;

public class PrintStatement implements AstNode {

	protected List<AstNode> expressions;
	
	
	public PrintStatement(List<AstNode> expressions) {

		this.expressions = expressions;		
		
	}

	@Override
	public void accept(Visitor visitor) {

		visitor.beginVisit(this);

		for (AstNode expression : expressions) {			
			expression.accept(visitor);
		}
		
		visitor.endVisit(this);
	}

}
