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
TWIG_TAG;
LITERAL_ARG;
}

@header {
package com.dubture.twig.core.parser;

import com.dubture.twig.core.parser.error.IErrorReporter;
import com.dubture.twig.core.TwigCorePlugin;
import com.dubture.twig.core.log.Logger;


}


@members {

    private IErrorReporter errorReporter = null;
    
    public TwigParser(TokenStream input, IErrorReporter errorReporter) {
        this(input, new RecognizerSharedState());
        this.errorReporter = errorReporter;
    }

	public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {

        
            if(errorReporter == null) {
            	Logger.log(Logger.WARNING, "Parser has no error reporter instance!");
         	   
             	return;
            }
            	

        	
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
  : MINUS? twig_control_tag twig_control_body*
  ;
  
  
twig_control_tag
  : param=STRING
    ->^(TWIG_TAG $param)
  ;  
  
twig_control_body
  : STRING_LITERAL | ASIG | PIPE | TILDE | NUMBER | COMMA | QM | COLON | range | eq_check | var_or_field | method_chain | keyword | array | json | in_check
  ;
  
   
in_check
  : METHOD_START (STRING_LITERAL | var_or_field) IN (STRING_LITERAL | var_or_field) METHOD_END
  ;
  
range
  : (NUMBER | STRING_LITERAL | STRING) DDOT (NUMBER | STRING_LITERAL | STRING) 
  ;
  
twig_ternary
  : (STRING_LITERAL | NUMBER | var_or_field | method_chain | eq_check) QM (STRING_LITERAL | NUMBER | var_or_field | method_chain) COLON (STRING_LITERAL | NUMBER | var_or_field | method_chain) 
  ;


eq_check
  : (var_or_field | method_chain | NUMBER | STRING_LITERAL) (EQUAL | NOTEQUAL | LARGER | SMALLER) (var_or_field | method_chain | NUMBER | STRING_LITERAL)
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
  : var_or_field | method_chain | array | STRING_LITERAL | twig_ternary | twig_not | concat
  ;
  
concat
  : concat_operand (TILDE concat_operand)+
  ;
  
concat_operand
  : (STRING_LITERAL | var_or_field | method_chain)
  ;
  
twig_not
  : NOT (twig_ternary | var_or_field | method_chain)
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
  

var_or_field
  : variable | field_access
  ;  

variable
  : param=STRING
    ->^(TWIG_VAR $param)
  ;
  
field_access
  : STRING (DOT STRING)+
  ;
  
 
method_chain
  : method (DOT method)*
  ;
  
method
  : var_or_field METHOD_START arguments? METHOD_END
  ; 
  
arguments
  : argument  (COMMA (argument))*
  ;

argument
: literal_argument | json | NUMBER | var_or_field
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
  : (STRING_LITERAL | var_or_field) (COLON) (STRING_LITERAL |  var_or_field) 
  ;
  
keyword
  : IS | DEFINED | IN | TWIG_AS | NOT | WITH | ONLY
  ;