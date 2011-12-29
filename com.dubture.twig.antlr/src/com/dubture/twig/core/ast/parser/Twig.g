grammar Twig;

options {
  language = Java;
}

@header {
  package com.dubture.twig.core.ast.parser;
}

@lexer::header {
  package com.dubture.twig.core.ast.parser;  
}

program
  : 'program' IDENT '='
    (constant | variable)*
    'begin'
    statement*
    'end' IDENT '.'
  ;

constant
  : 'constant' IDENT ':' type ':=' expression ';'
  ;

variable
  : 'var' IDENT  (',' IDENT)* ':' type ';'
  ;  
  
type
  : 'Integer'
  ;
  
expression
  : INTEGER
  ;
 
statement
  : assignment
  ;
  
assignment
  : IDENT ':=' expression ';'
  ;
     
INTEGER : '0'..'9'+;
IDENT : ('a'..'z' | 'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')*;
WS: (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;} ;