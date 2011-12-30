grammar Twig;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  TWIG_VAR;
}

@header {
  package com.dubture.twig.core.parser.ast;
}
@lexer::header {
  package com.dubture.twig.core.parser.ast;  
}


template
  : twig_print*
  ; 
  
twig_print
  : T_OPEN_PRINT^ (expression)* T_CLOSE_PRINT
  ;
  
  
functionCallStatement 
  : IDENT^ T_OPEN_PAREN! functionParameters T_CLOSE_PAREN
  ;
  
functionParameters
  : expression (','! expression)*
  ;  
    
expression 
  : term
  | functionCallStatement
  ;
 
 
term 
  : IDENT
  | NUMBER 
  ;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';

T_OPEN_PAREN: '(';  
T_CLOSE_PAREN: ')';

T_OPEN_PRINT: '{{';  
T_CLOSE_PRINT: '}}';

T_OPEN_STMT: '{%';  
T_CLOSE_STMT: '%}';

NUMBER : DIGIT+;
IDENT : (LETTER)(LETTER | DIGIT)*;
WS: (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;} ;