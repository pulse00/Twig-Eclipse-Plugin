package com.dubture.twig.core.ast.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import com.dubture.twig.core.ast.parser.TwigParser.template_return;

public class Test {
	
	public static void main(String[] args) throws RecognitionException {

		CharStream charstream = new ANTLRStringStream("{{ foo }}");
		TwigLexer lexer = new TwigLexer(charstream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		TwigParser parser = new TwigParser(tokenStream);
		
		parser.setTreeAdaptor(new TwigTreeAdaptor());
		template_return template = parser.template();				
		TwigCommonTree ast = template.tree;
		
		Visitor visitor = new Visitor() {
            
            @Override
            public boolean beginVisit(AstNode node) {

                System.err.println("begin visit " + node.getClass());
                
                return true;
                
            }
            
            @Override
            public boolean endVisit(AstNode node) {

                System.err.println("end visit " + node.getClass());
                
                return true;                
            }
            
            
        };
        
        ast.accept(visitor);
		


	}
}