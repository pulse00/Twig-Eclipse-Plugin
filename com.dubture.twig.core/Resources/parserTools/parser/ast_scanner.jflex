/* --------------------------Usercode Section------------------------ */

package com.dubture.twig.core.parser.ast;   

import java_cup.runtime.*;
import java_cup.sym;
      
%%
   
/* -----------------Options and Declarations Section----------------- */
   
%class TwigAstLexer
%public
%unicode
%line
    
/* Will switch to a CUP compatibility mode to interface with a CUP generated parser */
%cup

%caseless

%standalone


/* %debug */

/* make the lexer public */


   
/* Declarations */

%{   
       
    protected int getTokenStartPosition() {
        return yy_startRead - yy_pushbackPos;
    }
    
    protected int getTokenLength() {
        return yy_markedPos - yy_startRead;
    }

    
       
    private Symbol symbol(int type) {
    
		int leftPosition = getTokenStartPosition();    
        return new Symbol(type, leftPosition, leftPosition + getTokenLength());
    }
    
    private Symbol fullSymbol(int type) {

        Symbol symbol = symbol(type);
        symbol.value = yytext();
        return symbol;    
    }
    
    public boolean isEOF() {
        return yy_atEOF;
    }
%}

/* Macro Declarations  */
   
TWIG_VAR_OPEN = "{{"
TWIG_VAR_CLOSE = "}}"

TWIG_STMT_OPEN = "{%"
TWIG_STMT_CLOSE = "%}"

LABEL=[a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*
WHITESPACE=[ \n\r\t]+

ANY_CHAR=[.]
DOUBLE_QUOTES_CHARS=(([^\"\\]|("\\"{ANY_CHAR})))

/* 

LNUM=[0-9]+
DNUM=([0-9]*"."[0-9]+)|([0-9]+"."[0-9]*)
EXPONENT_DNUM=(({LNUM}|{DNUM})[eE][+-]?{LNUM})
HNUM="0x"[0-9a-fA-F]+
TABS_AND_SPACES=[ \t]* 
BACKQUOTE_CHARS=(([^`\\]|("\\"{ANY_CHAR})))
NEWLINE=("\r"|"\n"|"\r\n")

*/


/* lexical states */

%state ST_TWIG_VAR
%state ST_TWIG_BLOCK
%state ST_TWIG_BLOCK_NAME
%state ST_DOUBLE_QUOTES
%state ST_BACKQUOTE

   
%%
/* ------------------------Lexical Rules Section---------------------- */
      
<YYINITIAL> (  ( [^{] | "{" [^?%s{] )+  ) |" {s" | "{" {
	// raw content
	return symbol(ParserConstants.T_INLINE_HTML);
}
   
<YYINITIAL> {
   
    {TWIG_VAR_OPEN}  { 
        yybegin(ST_TWIG_VAR);
        return symbol(ParserConstants.TWIG_VAR_OPEN);
    }
    
    
    {TWIG_STMT_OPEN}  { 
        yybegin(ST_TWIG_BLOCK_NAME);
        return symbol(ParserConstants.TWIG_STMT_OPEN);
    }
        
    /* Don't do anything if whitespace is found */
    {WHITESPACE}       { /* just skip what was found, do nothing */ }   
}

/* after opening block tags, scanning for block name {% NAME */
<ST_TWIG_BLOCK_NAME> {

    {LABEL} {
        yybegin(ST_TWIG_BLOCK);
        return fullSymbol(ParserConstants.T_BLOCK_NAME);
    }
    
    /* Don't do anything if whitespace is found */
    {WHITESPACE}       { /* just skip what was found, do nothing */ }       
    
}

/* inside block tags {% %} */
<ST_TWIG_BLOCK> {

    {TWIG_STMT_CLOSE}  {  
        yybegin(YYINITIAL);
        return symbol(ParserConstants.TWIG_STMT_CLOSE);
    }
    
    {LABEL} {
        return fullSymbol(ParserConstants.T_VARIABLE);    
    }   
    
    {WHITESPACE} { 
 
    }
    
    "," { }
}

/* inside VAR tags {{ }} */
<ST_TWIG_VAR> {

    {TWIG_VAR_CLOSE}  {  
        yybegin(YYINITIAL);
        return symbol(ParserConstants.TWIG_VAR_CLOSE);
    }
    
    {LABEL} {
        return fullSymbol(ParserConstants.T_VARIABLE);    
    }
    
    {WHITESPACE} { 
     
    }

}
<ST_TWIG_BLOCK, ST_TWIG_VAR> {

	"("					{ return symbol(ParserConstants.T_OPEN_PARENTHESE); }
	")"					{ return symbol(ParserConstants.T_CLOSE_PARENTHESE); }
}


/* double quoted string */
<ST_TWIG_BLOCK, ST_TWIG_VAR>(b?[\"]{DOUBLE_QUOTES_CHARS}*[\"]) {
    return fullSymbol(ParserConstants.T_CONSTANT_ENCAPSED_STRING);
}

/* single quoted string */
<ST_TWIG_BLOCK, ST_TWIG_VAR>(b?[']([^'\\]|("\\"{ANY_CHAR}))*[']) {
    return fullSymbol(ParserConstants.T_CONSTANT_ENCAPSED_STRING);
}

<ST_TWIG_BLOCK, ST_TWIG_VAR, ST_TWIG_BLOCK_NAME, YYINITIAL> {ANY_CHAR} {
	// do nothing
}
