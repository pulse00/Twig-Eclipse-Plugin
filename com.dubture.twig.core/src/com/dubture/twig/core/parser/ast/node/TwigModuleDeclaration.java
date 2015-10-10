/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.ast.node;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.statements.Statement;

public class TwigModuleDeclaration extends ModuleDeclaration {
	protected List<BlockStatement> blocks;

	public TwigModuleDeclaration(int length, List<Statement> statements) {
		super(length);

		for (Statement statement : statements) {
			addStatement(statement);
		}
	}

	public List<BlockStatement> getBlocks() {
		if (blocks != null) {
			return blocks;
		}

		blocks = new LinkedList<BlockStatement>();

		for (Object o : getStatements()) {
			if (o instanceof BlockStatement) {
				blocks.add((BlockStatement) o);
			}
		}

		return blocks;

	}

	public BlockStatement getExtends() {
		for (BlockStatement block : getBlocks()) {
			BlockName name = block.getName();

			if (name != null && "extends".equals(name.getValue())) {
				return block;
			}
		}

		return null;
	}
}
