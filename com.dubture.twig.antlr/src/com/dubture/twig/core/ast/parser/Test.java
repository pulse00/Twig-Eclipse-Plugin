package com.dubture.twig.core.ast.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class Test {
	
	public static void main(String[] args) throws RecognitionException {

		CharStream charstream = new ANTLRStringStream("program XLSample = begin end XLSample.");
		TwigLexer lexer = new TwigLexer(charstream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		TwigParser parser = new TwigParser(tokenStream);
		
		parser.program();
		
		System.err.println("done");

	}

}
