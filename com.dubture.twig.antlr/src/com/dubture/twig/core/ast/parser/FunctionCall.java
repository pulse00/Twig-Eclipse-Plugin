package com.dubture.twig.core.ast.parser;

public class FunctionCall extends AbstractAstNode {

	protected String name;
	
	public FunctionCall(AstNode parent, String name) {
		super(parent);
		
		this.name = name;

	}

	@Override
	public void accept(Visitor visitor) {

		visitor.beginVisit(this);		
		System.err.println("the functions name is " + name);		
		visitor.endVisit(this);

	}
}
