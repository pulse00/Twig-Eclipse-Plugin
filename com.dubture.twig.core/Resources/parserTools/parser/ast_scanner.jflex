/* --------------------------Usercode Section------------------------ */
   
import java_cup.runtime.*;
import java_cup.sym;
      
%%
   
/* -----------------Options and Declarations Section----------------- */
   
%class TwigAstLexer

/*
  The current line number can be accessed with the variable yyline
  and the current column number with the variable yycolumn.
*/
%line
%column
    
/* Will switch to a CUP compatibility mode to interface with a CUP generated parser */
%cup

/* %debug */
   
/* Declarations */

%{   
       
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    
    private Symbol fullSymbol(int type) {

        Symbol symbol = symbol(type);
        symbol.value = yytext();
        System.err.println("creating full symbol " + type + " " + symbol.value);
        return symbol;    
    }
    
    public boolean isEOF() {
        return zzAtEOF;
    }
%}

/* Macro Declarations  */
   
TWIG_VAR_OPEN = "{{"
TWIG_VAR_CLOSE = "}}"

TWIG_STMT_OPEN = "{%"
TWIG_STMT_CLOSE = "%}"

LNUM=[0-9]+
DNUM=([0-9]*"."[0-9]+)|([0-9]+"."[0-9]*)
EXPONENT_DNUM=(({LNUM}|{DNUM})[eE][+-]?{LNUM})
HNUM="0x"[0-9a-fA-F]+
LABEL=[a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*
WHITESPACE=[ \n\r\t]+
TABS_AND_SPACES=[ \t]*
ANY_CHAR=[^]
NEWLINE=("\r"|"\n"|"\r\n")

DOUBLE_QUOTES_CHARS=(([^\"\\]|("\\"{ANY_CHAR})))
BACKQUOTE_CHARS=(([^`\\]|("\\"{ANY_CHAR})))


/* lexical states */

%state ST_TWIG_VAR
%state ST_TWIG_BLOCK
%state ST_TWIG_BLOCK_NAME
%state ST_DOUBLE_QUOTES
%state ST_BACKQUOTE

   
%%
/* ------------------------Lexical Rules Section---------------------- */
      
<YYINITIAL> (  ( [^{] | "{" [^?%s{] )+  ) |" {s" | "{" {
    System.err.println("raw content");
    return symbol(ParserConstants.T_RAW);
}
   
<YYINITIAL> {
   
    {TWIG_VAR_OPEN}  {
        System.err.println("twig open var"); 
        yybegin(ST_TWIG_VAR);
    }
    
    {TWIG_STMT_OPEN}  {
        System.err.println("twig open block"); 
        yybegin(ST_TWIG_BLOCK_NAME);
    }
        
    /* Don't do anything if whitespace is found */
    {WHITESPACE}       { /* just skip what was found, do nothing */ }   
}

/* after opening block tags, scanning for block name {% NAME */
<ST_TWIG_BLOCK_NAME> {

    {LABEL} {
        System.err.println("label in block name");
        yybegin(ST_TWIG_BLOCK);
        return fullSymbol(ParserConstants.T_BLOCK_NAME);
    }
    
    {TWIG_STMT_CLOSE}  { 
        System.err.println("twig close"); 
        yybegin(YYINITIAL);
    }
    
    /* Don't do anything if whitespace is found */
    {WHITESPACE}       { /* just skip what was found, do nothing */ }       
    
}

/* inside block tags {% %} */
<ST_TWIG_BLOCK> {

    {TWIG_STMT_CLOSE}  { 
        System.err.println("twig close"); 
        yybegin(YYINITIAL);
    }
    
    {LABEL} {
        return fullSymbol(ParserConstants.T_VARIABLE);    
    }
    
    {WHITESPACE} { 
        System.err.println("ws in print"); /* just skip what was found, do nothing */ 
    }
    
    /* sc are allowed in block tags */
    "," { }
}

/* inside VAR tags {{ }} */
<ST_TWIG_VAR> {

    {TWIG_VAR_CLOSE}  { 
        System.err.println("twig close"); 
        yybegin(YYINITIAL);
    }
    
    {LABEL} {
        return fullSymbol(ParserConstants.T_VARIABLE);    
    }
    
    {WHITESPACE} { 
        System.err.println("ws in print"); /* just skip what was found, do nothing */ 
    }

}

/* double quoted string */
<ST_TWIG_BLOCK, ST_TWIG_VAR>(b?[\"]{DOUBLE_QUOTES_CHARS}*[\"]) {
    return fullSymbol(ParserConstants.T_CONSTANT_ENCAPSED_STRING);
}

/* single quoted string */
<ST_TWIG_BLOCK, ST_TWIG_VAR>(b?[']([^'\\]|("\\"{ANY_CHAR}))*[']) {
    return fullSymbol(ParserConstants.T_CONSTANT_ENCAPSED_STRING);
}

/* No token was found for the input so through an error.  Print out an
   Illegal character message with the illegal character that was found. */
ANY_CHAR                { throw new Error("Illegal character <"+yytext()+">"); }
