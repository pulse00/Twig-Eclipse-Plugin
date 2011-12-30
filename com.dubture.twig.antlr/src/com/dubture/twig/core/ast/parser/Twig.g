grammar Twig;

options {
  language = Java;
  output=AST;
  ASTLabelType=TwigCommonTree;
}


@header {
  package com.dubture.twig.core.ast.parser;
}

@lexer::header {
  package com.dubture.twig.core.ast.parser;  
}

template returns [AstNode node]
  : e=twig_print { $node = new PrintNode($e.node); }
  ; 
  
twig_print returns [AstNode node]
  : T_OPEN_PRINT! 
    e=expression* { $node = new ExpressionNode($e.node); } 
    T_CLOSE_PRINT!
  ;
  
functionCallStatement returns [AstNode node]
  : IDENT 
    '(' f=functionParameters ')' { $node = new FunctionCall($f.node, $IDENT.text); }
  ;
  
functionParameters returns [AstNode node]
  : expression { $node = new FunctionParameter($expression.node); }
  ;  
    
expression returns [AstNode node]
  : t=term { $node = new TermNode($t.node); }
  | functionCallStatement { $node = new ExpressionNode($functionCallStatement.node); }
  ;
  
term returns [AstNode node]
  : IDENT { $node = new IdentNode($IDENT.text); }
  | NUMBER { $node = new NumberNode(Integer.parseInt($NUMBER.text)); }
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