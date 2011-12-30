grammar Twig;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

tokens {
  FUNCTION_IDENTIFIER;
  TWIG_VAR;
}

@header {
  package com.dubture.twig.core.ast.parser;
}

@lexer::header {
  package com.dubture.twig.core.ast.parser;  
}

template
  : twig_print*
  ; 
  
twig_print
  : twig_var^ (expression)* T_CLOSE_PRINT!
  ;
  
twig_var
  : T_OPEN_PRINT -> TWIG_VAR
  ;
  
functionCallStatement 
  : functionIdentifier^ '('! functionParameters ')'!
  ;
  
functionIdentifier
  : IDENT -> FUNCTION_IDENTIFIER
  ;
  
functionParameters
  : expression (',' expression)*
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
  
T_OPEN_PRINT: '{{';  
T_CLOSE_PRINT: '}}';

T_OPEN_STMT: '{%';  
T_CLOSE_STMT: '%}';

NUMBER : DIGIT+;
IDENT : (LETTER)(LETTER | DIGIT)*;
WS: (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;} ;