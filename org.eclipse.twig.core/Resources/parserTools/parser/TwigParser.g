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


twig_source
  : twig_print_statement | twig_control_statement
  ;


// twig control statements start

twig_control_statement
  : CTRL_OPEN twig_control? CTRL_CLOSE
  ;


twig_control
  : twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include
  ;
  
twig_include
  : INCLUDE (include_ternary | include_statement)
  ;
  
include_ternary
  : twig_ternary ONLY?
  ;
  
include_statement
  : (STRING_LITERAL) ONLY? (WITH (variable | STRING_LITERAL | method | json) ONLY?)?
  ;
  
twig_set
  : (SET twig_assignment (COMMA twig_assignment)*) | ENDSET
  ;
 
twig_assignment
  :  twig_left_assignment (ASIG twig_right_assignment)?
  ;
  
twig_left_assignment
  : (variable (COMMA variable)*)
  ;
  
twig_right_assignment
  : (STRING_LITERAL | variable | method | array | json | twig_tilde_argument) (COMMA (STRING_LITERAL | variable | method | array | json | twig_tilde_argument))*
  ;
  
twig_tilde_argument
  : (STRING_LITERAL | variable | method | array | json) TILDE (STRING_LITERAL | variable | method | array | json)
  ;
  
twig_import
  : (FROM (STRING_LITERAL))? IMPORT (STRING_LITERAL | variable) (TWIG_AS (STRING (COMMA STRING)*))?
  ;
   
twig_macro
  : (MACRO (variable | method)) | ENDMACRO
  ;
  
twig_if
  : IF variable | method
  ;
  
twig_elseif
  : ELSEIF (variable | method)
  ;
  
twig_for
  : FOR STRING IN for_arguments
  ;
  
for_arguments
  : for_value (PIPE for_value)*
  ;
  
for_value
  : STRING | STRING_LITERAL | method | range
  ;
  
range
  : (NUMBER | STRING_LITERAL | STRING) DDOT (NUMBER | STRING_LITERAL | STRING) 
  ;
  
twig_ternary
  : (STRING_LITERAL | NUMBER | variable | method) QM (STRING_LITERAL | NUMBER | variable | method) COLON (STRING_LITERAL | NUMBER | variable | method) 
  ;

// twig print statements start

twig_print_statement
  :  PRINT_OPEN twig_print? PRINT_CLOSE
    ->^(TWIG_PR_STMT twig_print?)
  ;
  
twig_print
  : p_input (PIPE p_input)*
  ;
  
p_input
  : variable | method | array | STRING_LITERAL
  ;
  
  
array
  : ARRAY_START array_elements ARRAY_END
  ;
  
array_elements
  : array_element (COMMA array_element)*
  ;
  
array_element
  : STRING | STRING_LITERAL | NUMBER | json
  ;
  
variable
  : param=STRING (DOT (STRING))*
    ->^(TWIG_VAR $param)
  ;
  
method
  : variable METHOD_START arguments? METHOD_END
  ; 
  
arguments
  : argument  (COMMA (argument))*
  ;

argument
: literal_argument | STRING | json | NUMBER
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
  : (STRING_LITERAL | STRING) (COLON) (STRING_LITERAL | STRING) 
  ;