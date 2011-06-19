parser grammar TwigParser;

options {
output = AST;
TokenLabelType=CommonToken;
ASTLabelType=TwigCommonTree;
tokenVocab=TwigLexer;
}

tokens {
TWIG_PR_STMT;
TWIG_VAR;
LITERAL_ARG;
}

@header {
package org.eclipse.twig.core.compiler.ast.parser;

import org.eclipse.twig.core.compiler.ast.parser.error.IErrorReporter;
}


@members {

    private IErrorReporter errorReporter = null;
    
    public TwigParser(TokenStream input, IErrorReporter errorReporter) {
        this(input, new RecognizerSharedState());
        this.errorReporter = errorReporter;
    }

	public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        
		String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);        
        errorReporter.reportError(hdr,msg,e);
        
    }    
    
    public void setErrorReporter(IErrorReporter errorReporter) {
        this.errorReporter = errorReporter;
    }
    
	protected Object recoverFromMismatchedToken(IntStream input,
				int ttype, BitSet follow) throws RecognitionException
	{   
	    throw new MismatchedTokenException(ttype, input);
	}       
	
    public Object recoverFromMismatchedSet(IntStream input,
    			RecognitionException e, BitSet follow) throws RecognitionException 
    { 
		throw new MismatchedSetException(follow, input);
   	}
	
}


common_node
	: NONCONTROL_CHAR+
	;
// an annotation starts with @ followed by 
// the name of the annotation optionally followed 
// by argument list in parentheses
twig_print_statement
  :  PRINT_OPEN twig_print PRINT_CLOSE
    ->^(TWIG_PR_STMT twig_print)
  ;
  

twig_print
  : p_input (PIPE p_input)*
  ;
  
p_input
  : variable | method | STRING_LITERAL
  ;
  
  
variable
  : param=STRING (DOT (STRING))*
    ->^(TWIG_VAR $param)
  ;
  
method
  : STRING METHOD_START arguments? METHOD_END
  ; 
  
arguments
  : argument  (COMMA (argument))*
  ;

argument
: literal_argument | json
;


literal_argument
  : param=STRING_LITERAL
    -> ^(LITERAL_ARG $param)
  ;


json
  : JSON_START json_arguments? JSON_END
  ;
  
json_arguments
  : json_argument (COMMA (json_argument))*
  ;
  
json_argument
  : STRING_LITERAL ASIG STRING_LITERAL
  ;