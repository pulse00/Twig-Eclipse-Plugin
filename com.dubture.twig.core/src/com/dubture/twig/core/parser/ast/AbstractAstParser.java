/*
 * This file is part of the Twig Eclipse Plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.core.parser.ast;

import java.util.LinkedList;

import org.eclipse.dltk.ast.statements.Statement;

import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;

import java_cup.runtime.lr_parser;

abstract class AbstractAstParser extends lr_parser {

	/** Default constructor. */
	public AbstractAstParser() {

	}

	/** Constructor which sets the default scanner. */
	public AbstractAstParser(java_cup.runtime.Scanner s) {
		super(s);
	}

	private TwigModuleDeclaration module = new TwigModuleDeclaration(0, new LinkedList<Statement>());

	public TwigModuleDeclaration getModuleDeclaration() {
		return module;
	}

	public void addStatement(Statement s) {
		module.addStatement(s);
	}

}
