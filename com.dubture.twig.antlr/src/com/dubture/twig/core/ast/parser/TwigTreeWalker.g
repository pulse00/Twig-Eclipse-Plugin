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
  @init {
    List<AstNode> statements = new ArrayList<AstNode>();
  }
  : (p=twig_print { statements.add(p); })* { node = new Template(statements); }
  ;
  
twig_print returns [AstNode node]
  @init {
    List<AstNode> expressions = new ArrayList<AstNode>();
  }
  : ^(TWIG_VAR (e=expression { expressions.add(e); })*) { node = new PrintStatement(expressions); }
  ;
 
expression returns [AstNode node]
  : ^(IDENT e=expression) { node = new FunctionCall(e, $IDENT.text); }
  | IDENT { node = new IdentNode($IDENT.text); }
  ;
