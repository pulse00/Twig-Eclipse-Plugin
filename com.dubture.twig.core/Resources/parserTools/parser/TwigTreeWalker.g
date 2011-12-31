tree grammar TwigTreeWalker;

options {
  language = Java;
  tokenVocab = Twig;
  ASTLabelType = CommonTree;
}

@header {
  package com.dubture.twig.core.parser.ast;
  
  import java.util.Map;
  import java.util.HashMap;  
  import com.dubture.twig.core.parser.ast.node.*;   
  import org.eclipse.dltk.ast.statements.Statement;
  import org.eclipse.dltk.ast.expressions.Expression;
}

module returns [TwigModuleDeclaration node]

  @init {
    List<Statement> statements = new ArrayList<Statement>();
  }
  
  :   ( (p=twig_print) { statements.add(p);} | (b=twig_block) { statements.add(b); } )* EOF
    { node = new TwigModuleDeclaration(0, statements); }
  ;
  
twig_print returns [Statement node]

  @init {
    List<Expression> expressions = new ArrayList<Expression>();
  }
  
  : ^(T_OPEN_PRINT (e=expression { expressions.add(e); })* T_CLOSE_PRINT) 
    {     
      CommonToken startToken = (CommonToken) $T_OPEN_PRINT.getToken();
      CommonToken endToken = (CommonToken) $T_CLOSE_PRINT.getToken();
      node = new PrintStatement(startToken.getStartIndex(), endToken.getStopIndex(), expressions);            
    }
  ;
  
twig_block returns [Statement node]

  @init {
    List<Expression> expressions = new ArrayList<Expression>();
  }
  
  : ^(T_OPEN_STMT IDENT (e=expression { expressions.add(e); })* T_CLOSE_STMT) 
    {     
      CommonToken startToken = (CommonToken) $T_OPEN_STMT.getToken();
      CommonToken endToken = (CommonToken) $T_CLOSE_STMT.getToken();
      node = new BlockStatement(startToken.getStartIndex(), endToken.getStopIndex(), $IDENT.text, expressions);            
    }
  ;
 
expression returns [Expression node]
  : f=function { node = f; }
  | IDENT 
    { 
      CommonToken startToken = (CommonToken) $IDENT.getToken();
      node = new IdentNode(startToken.getStartIndex(), startToken.getStopIndex(), $IDENT.text); 
    }
  | NUMBER 
    {
      CommonToken startToken = (CommonToken) $NUMBER.getToken();     
      node = new NumberNode(startToken.getStartIndex(), startToken.getStopIndex(), Integer.parseInt($NUMBER.text)); 
    }
  | STRING
    {
      node = new StringLiteral(0,0, $STRING.text);
    }
  | h=hash { node = h; }
  | a=array { node = a; }
  | v=variable_access { node = v; }
  ;
  
  
variable_access returns [VariableAccess node]
  : ^(DOT e=expression)
    {
      CommonToken startToken = (CommonToken) $DOT.getToken();     
      node = new VariableAccess(startToken.getStartIndex(), startToken.getStopIndex(), e); 
    }
  ;
 
array returns [Expression node]

  @init {
    List<Expression> arguments = new ArrayList<Expression>();
  }

  : ^(ARRAY_OPEN (e=expression { arguments.add(e); })* ARRAY_CLOSE)
    {
      CommonToken startToken = (CommonToken) $ARRAY_OPEN.getToken();
      CommonToken endToken = (CommonToken) $ARRAY_CLOSE.getToken();    
      node = new ArrayDeclaration(startToken.getStartIndex(), endToken.getStartIndex(), arguments);
    }
  ;
  
  
// again, in this tree we need the open/closing brackets for positioning
hash returns [Expression node]

  @init {
    List<Expression> expressions = new ArrayList<Expression>();
  }  

  : ^(T_OPEN_CURLY ( h=hash_argument)* T_CLOSE_CURLY)
    {
      CommonToken startToken = (CommonToken) $T_OPEN_CURLY.getToken();
      CommonToken endToken = (CommonToken) $T_CLOSE_CURLY.getToken();
      node = new Hash(startToken.getStartIndex(), endToken.getStopIndex(), expressions);
    }
  ;
  
 
hash_argument returns [Expression node]
  : left=expression right=expression { node = new HashEntry(left,right); }
  ;  

  
// a function tree has is passed in in the form <IDENT expression T_CLOSE_PAREN>
// we need the close parenthesis to get the absolute end position of the function in 
// the template
function returns [Expression node]

  @init {
    List<Expression> arguments = new ArrayList<Expression>();
  }

  : ^(IDENT (e=expression { arguments.add(e); })*  T_CLOSE_PAREN) 
    {    
      CommonToken startToken = (CommonToken) $IDENT.getToken();
      CommonToken endToken = (CommonToken) $T_CLOSE_PAREN.getToken();     
      node = new TwigCallExpression(startToken.getStartIndex(), endToken.getStopIndex(), $IDENT.text, arguments); 
    }
  ;