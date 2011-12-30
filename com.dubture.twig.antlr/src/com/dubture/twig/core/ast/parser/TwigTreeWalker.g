tree grammar TwigTreeWalker;

options {
  language = Java;
  tokenVocab = Twig;
  ASTLabelType = CommonTree;
}

@header {
  package com.dubture.twig.core.ast.parser; 
}

template returns [AstNode node]
  : p=twig_print* { node = new Template(p); }
  ;
  
twig_print returns [AstNode node]
  @init {
    List<AstNode> expressions = new ArrayList<AstNode>();
  }
  : ^(TWIG_VAR (e=expression { expressions.add(e); })*) { node = new PrintStatement(expressions); }
  ;
 
expression returns [AstNode node]
  : ^(FUNCTION_IDENTIFIER e=expression) { node = new FunctionCall(e, $FUNCTION_IDENTIFIER.text); }
  | IDENT { node = new IdentNode($IDENT.text); }
  ;
