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
  
  : (p=twig_print { statements.add(p); })* 
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
 
expression returns [Expression node]
  : f=function { node = f; }
  | IDENT { node = new IdentNode($IDENT.text); }
  | h=hash { node = h; }
  ;
 
// again, in this tree we need the open/closing brackets for positioning
hash returns [Expression node]

  @init {
    Map<Expression, Expression> expressions = new HashMap<Expression, Expression>();
  }  

  : ^(T_OPEN_CURLY (left=expression COLON right=expression { expressions.put(left, right); } )* T_CLOSE_CURLY)
    {
      CommonToken startToken = (CommonToken) $T_OPEN_CURLY.getToken();
      CommonToken endToken = (CommonToken) $T_CLOSE_CURLY.getToken();
      node = new Hash(startToken.getStartIndex(), endToken.getStopIndex(), expressions);
    }
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