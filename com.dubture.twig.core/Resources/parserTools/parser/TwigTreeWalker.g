tree grammar TwigTreeWalker;

options {
  language = Java;
  tokenVocab = Twig;
  ASTLabelType = CommonTree;
}

@header {
  package com.dubture.twig.core.parser.ast;
  import com.dubture.twig.core.parser.ast.node.*; 
  
  import org.eclipse.dltk.ast.statements.Statement;
  import org.eclipse.dltk.ast.expressions.Expression;
}

module returns [TwigModuleDeclaration node]
  @init {
    List<Statement> statements = new ArrayList<Statement>();
  }
  : (p=twig_print { statements.add(p); })* { node = new TwigModuleDeclaration(0, statements); }
  ;
  
twig_print returns [Statement statement]
  @init {
    List<Expression> expressions = new ArrayList<Expression>();
  }
  : ^(T_OPEN_PRINT (e=expression { expressions.add(e); })*) { statement = new PrintStatement(0, 0, expressions); }
  ;
 
expression returns [Expression node]
  : ^(IDENT e=expression) { node = new TwigCallExpression(e, $IDENT.text); }
  | IDENT { node = new IdentNode($IDENT.text); }
  ;
