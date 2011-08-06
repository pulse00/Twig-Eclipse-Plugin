lexer grammar TwigLexer;


@header {
package com.dubture.twig.core.parser;

import com.dubture.twig.core.parser.error.IErrorReporter;
import com.dubture.twig.core.TwigCorePlugin;
import com.dubture.twig.core.log.Logger;


}


// add custom fields to the generated code
@members {

    private IErrorReporter errorReporter = null;

    public TwigLexer(CharStream input, IErrorReporter errorReporter) {
        this(input, new RecognizerSharedState());
        this.errorReporter = errorReporter;
    }
    
	public void displayRecognitionError(String[] tokenNames,
                                        RecognitionException e) {
        
        
        if(errorReporter == null) {
		  Logger.log(Logger.WARNING, "Lexer has no error reporter instance!");
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


                    
// control characters
PRINT_OPEN		: '{{';
PRINT_CLOSE		: '}}';
CTRL_OPEN		: '{%';
CTRL_CLOSE		: '%}';
METHOD_START	: '(';
METHOD_END		: ')';
ARRAY_START		: '[';
ARRAY_END		: ']';
ASIG 			: '=';
LARGER			: '>';
SMALLER			: '<';
EQUAL			: '==';
NOTEQUAL		: '!=';
TILDE			: '~';
MINUS			: '-';
PIPE 			: '|';
DDOT 			: '..';
DOT 			: '.';
COLON 			: ':';
COMMA			: ( ' '* ',' ' '*);
BSLASH			: '\\';
JSON_START  	: '{' ;
JSON_END		: '}' ;
QM				: '?';
IN				: 'in';
TWIG_AS			: 'as';
NOT				: 'not';
WITH			: 'with';
ONLY			: 'only';
IS				: 'is';
DEFINED			: 'defined';



// strings


NUMBER : DIGIT+;
STRING : STRING_CHAR+;



STRING_LITERAL
: '"' NONCONTROL_CHAR* '"'
| '\'' NONCONTROL_CHAR* '\''
;

fragment STRING_CHAR  : LOWER | UPPER | DIGIT | UNDER ;
fragment NONCONTROL_CHAR: LETTER | DIGIT | SYMBOL;
fragment LETTER	: LOWER | UPPER;
fragment LOWER	: 'a'..'z';
fragment UPPER	: 'A'..'Z';
fragment DIGIT	: '0'..'9';
fragment UNDER : '_';
fragment SYMBOL: UNDER | '-' | '/'  | '<'  | '>' | '\\'  | ':' | ';' | ' ' | '%' | '.' | '|' | '#' | '@' | '=' | '{' | '}' | '(' | ')';

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ { $channel = HIDDEN; };
