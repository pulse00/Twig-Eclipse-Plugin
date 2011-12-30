package com.dubture.twig.core.ast.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import com.dubture.twig.core.ast.parser.TwigParser.template_return;

public class Test {
	
	public static void main(String[] args) throws RecognitionException {

//		CharStream charstream = new ANTLRStringStream("{{  foo(aha) bar  }}  {{  bar  }}");
		CharStream charstream = new ANTLRStringStream("{{  foo(bar)  }}");
		TwigLexer lexer = new TwigLexer(charstream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		TwigParser parser = new TwigParser(tokenStream);
		
		template_return template = parser.template();
		
		System.err.println("BUILT TREE");
		System.err.println(template.tree.toStringTree());
		System.err.println();
		
		CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(template.tree);		
		TwigTreeWalker walker = new TwigTreeWalker(nodeStream);		
		AstNode root = walker.template();
		
		System.err.println("root node is " + root.getClass());
		
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
        
        root.accept(visitor);		
        
        System.err.println("done");

	}
}