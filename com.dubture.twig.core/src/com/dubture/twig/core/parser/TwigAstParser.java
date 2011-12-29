package com.dubture.twig.core.parser;

import org.antlr.runtime.TokenStream;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;

import com.dubture.twig.core.parser.node.TwigModuleDeclaration;

public class TwigAstParser extends TwigParser {

	public TwigAstParser(TokenStream input) {
		super(input);
	}
	
	public IModuleDeclaration getModuleDeclaration() {
		
		TwigModuleDeclaration module = new TwigModuleDeclaration(0, 100);		
		return module;
	}

}
