/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.ast.node;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.statements.Statement;

public class PrintStatement extends Statement {
	protected List<Expression> expressions;

	public PrintStatement(int start, int end, List<Expression> expressions) {
		super(start, end);
		this.expressions = expressions;

	}

	@Override
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {

			if (expressions != null) {
				for (Expression exp : expressions) {

					if (exp != null) {
						exp.traverse(visitor);
					}
				}
			}
			visitor.endvisit(this);
		}
	}

	@Override
	public int getKind() {
		return ASTNodeKinds.PRINT_STATEMENT;
	}
}
