package com.dubture.twig.core.ast.parser;

public abstract class AbstractAstNode implements AstNode {
	
	protected AstNode parent;

	public AbstractAstNode(AstNode parent) {

		this.parent = parent;
	}
	
}
