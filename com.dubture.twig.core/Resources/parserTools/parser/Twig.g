grammar Twig;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  TWIG_VAR;
  ARRAY_OPEN;
  ARRAY_CLOSE;
}

@header {
  package com.dubture.twig.core.parser.ast;
}
@lexer::header {
  package com.dubture.twig.core.parser.ast;  
}


@lexer::members {

  // flag to switch the lexer state
  // between raw and twig context
  private boolean insideTag = false;  
  
  // is still raw content ahead or do we see a twig tag?
  private boolean rawAhead() {
  
    if(insideTag) return false;
    int ch1 = input.LA(1), ch2 = input.LA(2);
    return !(
        (ch1 == '{' && ch2 == '{') ||
        // 37 = percentage sign, this is a bug in antlr it seems:
        // http://www.antlr.org/pipermail/antlr-interest/2007-June/021188.html
        (ch1 == '{' && ch2 == 37) ||
        (ch1 == '{' && ch2 == '#')
    );
    
  }    
}

// PARSER RULES

template
  : (template_body)* EOF!
  ; 
  
template_body
  : twig_print | twig_block
  ;
  
twig_print 
  : T_OPEN_PRINT^ body? T_CLOSE_PRINT
  ;
  
twig_block
  : T_OPEN_STMT IDENT^  body? T_CLOSE_STMT
  ;
  
body
  // in the tree we are only interested in the expressions inside the print statement
  // so throw away the | and . operators
  : expression ( (('|' | ',' | '~')? )! expression)*
  ;
  
functionCallStatement 
  // we need the closing parenthesis in the tree walker to detecte the absolute
  // end position of the statement, but we can throw away the opening paren
  : IDENT^ T_OPEN_PAREN! functionParameters T_CLOSE_PAREN
  ;
  
functionParameters
  : expression (','! expression)*
  ;  
    
expression 
  : term
  | functionCallStatement
  | hash
  | array
  | variable_access
  ;
  
variable_access
  : DOT^ expression
  ;
  
  
array
  : array_open^ (expression (','! expression)*)? array_close
  ;
  
array_open
  : '[' -> ARRAY_OPEN
  ;
  
array_close
  : ']' -> ARRAY_CLOSE
  ;  
  
hash
  : T_OPEN_CURLY^ hash_body T_CLOSE_CURLY
  ;
  
hash_body
  : hash_argument (',' hash_argument)*
  ;
  
hash_argument
  : expression COLON! expression
  ;
 
term 
  : IDENT
  | NUMBER
  | STRING
  | SQ_STRING
  ;

// LEXER RULES

// send raw content to hidden channel  
RAW   : ({rawAhead()}?=> . )+ { $channel=HIDDEN; };

T_OPEN_PRINT @after { insideTag=true; }   : '{{';    
T_CLOSE_PRINT @after { insideTag=false; } : '}}';

T_OPEN_STMT @after { insideTag=true; }    : '{%';  
T_CLOSE_STMT @after {insideTag=false; }   : '%}';
  
T_OPEN_CMT @after { insideTag=true; }     : '{#';  
T_CLOSE_CMT @after { insideTag=false; }   : '#}';

T_OPEN_PAREN: '(';  
T_CLOSE_PAREN: ')';

T_OPEN_CURLY: '{';  
T_CLOSE_CURLY: '}';

DOT   : '.';
COLON : ':';

// double quoted string
STRING          
@init{StringBuilder lBuf = new StringBuilder();}
    :   
           '"' 
           ( escaped=ESC {lBuf.append(escaped.getText());} | 
             normal=~('"'|'\\'|'\n'|'\r')     {lBuf.appendCodePoint(normal);} )* 
           '"'     
           {setText(lBuf.toString());}
    ;
    
// single quoted string
SQ_STRING          
@init{StringBuilder lBuf = new StringBuilder();}
    :   
           '\'' 
           ( escaped=ESC {lBuf.append(escaped.getText());} | 
             normal=~('\''|'\\'|'\n'|'\r')     {lBuf.appendCodePoint(normal);} )* 
           '\''     
           {setText(lBuf.toString());}
    ;    

// escape characters
fragment
ESC
    :   '\\'
        (       'n'    {setText("\n");}
        |       'r'    {setText("\r");}
        |       't'    {setText("\t");}
        |       'b'    {setText("\b");}
        |       'f'    {setText("\f");}
        |       '"'    {setText("\"");}
        |       '\''   {setText("\'");}
        |       '/'    {setText("/");}
        |       '\\'   {setText("\\");}
//        |       ('u')+ i=HEX_DIGIT j=HEX_DIGIT k=HEX_DIGIT l=HEX_DIGIT   {setText(ParserUtil.hexToChar(i.getText(),j.getText(),k.getText(),l.getText()));}

        )
    ;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';

NUMBER : DIGIT+;
IDENT : (LETTER)(LETTER | DIGIT)+;
PUNCTUATION:  '?'   | ','   | '\'';
WS: (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;} ;