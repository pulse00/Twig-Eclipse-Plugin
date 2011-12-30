package com.dubture.twig.core.parser.ast.node;

import java.util.Iterator;
import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.statements.Statement;

public class PrintStatement extends Statement {

	
	protected List<Expression> expressions;
	
	
	public PrintStatement(int start, int end, List<Expression> expressions) {
		
		this.expressions = expressions;

	}

	@Override
	public int getKind() {

		return ASTNodeKinds.PRINT_STATEMENT;
	}
	
	
	@Override
	public void traverse(ASTVisitor visitor) throws Exception {

		System.err.println("visiting print statement");
		if (visitor.visit(this)) {
			
			for (Expression exp : expressions) {
				exp.traverse(visitor);
			}
			visitor.endvisit(this);
		}
	}

}
