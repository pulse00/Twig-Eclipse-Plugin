package org.eclipse.twig.core.compiler.ast.parser;

import java.io.InputStream;

import org.eclipse.twig.core.ast.scanner.TwigAstLexer;

public class CompilerAstLexer extends TwigAstLexer {

	public CompilerAstLexer(InputStream in) {
		super(in);
	}

	public CompilerAstLexer(java.io.Reader in) {
		super(in);
	}

}
