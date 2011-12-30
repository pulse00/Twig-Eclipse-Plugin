package com.dubture.twig.core.ast.parser;

import java.util.List;

public class PrintStatement implements AstNode {

	public PrintStatement(List<AstNode> expressions) {

		System.err.println("creating print node with " + expressions.size() + " children:");
		
		for (AstNode child : expressions) {			
			System.err.println(child.getClass());
		}
	}

	@Override
	public void accept(Visitor visitor) {


	}

}
