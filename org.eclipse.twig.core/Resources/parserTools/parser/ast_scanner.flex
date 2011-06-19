/*******************************************************************************
 * Copyright (c) 2006 Zend Corporation and IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Zend and IBM - Initial implementation
 *******************************************************************************/

package org.eclipse.twig.core.ast.scanner;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.php.internal.core.ast.nodes.IDocumentorLexer;
import org.eclipse.php.internal.core.ast.nodes.Comment;
import java_cup.sym;
import org.eclipse.php.internal.core.ast.nodes.AST;
import java_cup.runtime.Symbol;
import org.eclipse.php.internal.core.ast.scanner.StateStack;
import org.eclipse.twig.core.util.Debug;
import org.eclipse.wst.sse.core.utils.StringUtils;



%%

%class TwigAstLexer
%public
%unicode
%line

/* %cup */
%implements AstLexer
%function next_token
%type java_cup.runtime.Symbol
%eofval{
    return createSymbol(sym.EOF);
%eofval}
%eofclose

%caseless

%standalone
%state ST_IN_SCRIPTING
%state ST_IN_PRINTING
%state ST_DOUBLE_QUOTES
%state ST_BACKQUOTE
%state ST_LOOKING_FOR_PROPERTY
%state ST_LOOKING_FOR_VARNAME


%{
	private final LinkedList commentList = new LinkedList();
    private StateStack stack = new StateStack();
    private char yy_old_buffer[] = new char[ZZ_BUFFERSIZE];
    private int yy_old_pushbackPos;
    protected int commentStartPosition;

	private AST ast;

    public void setAST(AST ast) {
    	this.ast = ast;
    }
    
    
	public void setInScriptingState() {
		yybegin(ST_IN_SCRIPTING);
	}

	public void resetCommentList() {
		commentList.clear();
	}
	
	public LinkedList getCommentList() {
		return commentList;
	}	
	
	protected void addComment(int type) {
		int leftPosition = getTokenStartPosition();
		Comment comment = new Comment(commentStartPosition, leftPosition + getTokenLength(), ast, type);
		commentList.add(comment);
	}	
	
	
	
	
    private void pushState(int state) {
        stack.pushStack(zzLexicalState);
        yybegin(state);
    }

    private void popState() {
        yybegin(stack.popStack());
    }

    public int getCurrentLine() {
        return yyline;
    }

    protected int getTokenStartPosition() {
        return zzStartRead - zzPushbackPos;
    }

    protected int getTokenLength() {
        return zzMarkedPos - zzStartRead;
    }

    public int getLength() {
        return zzEndRead - zzPushbackPos;
    }
    
    private void handleCommentStart() {
		commentStartPosition = getTokenStartPosition();
	}
	
	private void handleLineCommentEnd() {
         addComment(Comment.TYPE_SINGLE_LINE);
    }
    
    private void handleMultilineCommentEnd() {
    	addComment(Comment.TYPE_MULTILINE);
    }

    private void handlePHPDocEnd() {
		addComment(Comment.TYPE_PHPDOC);
    }
    
    protected void handleVarComment() {
    	commentStartPosition = zzStartRead;
    	addComment(Comment.TYPE_MULTILINE);
    }
        
    private Symbol createFullSymbol(int symbolNumber) {
        Symbol symbol = createSymbol(symbolNumber);
        symbol.value = yytext();
        return symbol;
    }

    protected Symbol createSymbol(int symbolNumber) {
        int leftPosition = getTokenStartPosition();
        return new Symbol(symbolNumber, leftPosition, leftPosition + getTokenLength());
    }

    public int[] getParamenters(){
    	return new int[]{zzMarkedPos, zzPushbackPos, zzCurrentPos, zzStartRead, zzEndRead, yyline};
    }
    
	protected boolean parsePHPDoc(){	
		final IDocumentorLexer documentorLexer = getDocumentorLexer(zzReader);
		if(documentorLexer == null){
			return false;
		}
		yypushback(zzMarkedPos - zzStartRead);
		int[] parameters = getParamenters();
		documentorLexer.reset(zzReader, zzBuffer, parameters);
		Object phpDocBlock = documentorLexer.parse();
		commentList.add(phpDocBlock);
		reset(zzReader, documentorLexer.getBuffer(), documentorLexer.getParamenters());
		return true;
	}
	
	
	protected IDocumentorLexer getDocumentorLexer(java.io.Reader  reader) {
		return null;
	}
	
	public void reset(java.io.Reader  reader, char[] buffer, int[] parameters){
		this.zzReader = reader;
		this.zzBuffer = buffer;
		this.zzMarkedPos = parameters[0];
		this.zzPushbackPos = parameters[1];
		this.zzCurrentPos = parameters[2];
		this.zzStartRead = parameters[3];
		this.zzEndRead = parameters[4];
		this.yyline = parameters[5];  
		this.yychar = this.zzStartRead - this.zzPushbackPos;
	}
	
	private final void dump(String s) {
		if (Debug.debugLexer) {
			System.err.println(s + " (" + yychar + "-" + //$NON-NLS-2$//$NON-NLS-1$
				(yylength() + yychar) + "):\'" +//$NON-NLS-1$
					StringUtils.escape(yytext()) + "\'");//$NON-NLS-1$
		}
	}
	

%}

LNUM=[0-9]+
DNUM=([0-9]*"."[0-9]+)|([0-9]+"."[0-9]*)
EXPONENT_DNUM=(({LNUM}|{DNUM})[eE][+-]?{LNUM})
HNUM="0x"[0-9a-fA-F]+
LABEL=[a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*
WHITESPACE=[ \n\r\t]+
TABS_AND_SPACES=[ \t]*
ANY_CHAR=[^]
NEWLINE=("\r"|"\n"|"\r\n")
DOUBLE_QUOTES_LITERAL_DOLLAR=("$"+([^a-zA-Z_\x7f-\xff$\"\\{]|("\\"{ANY_CHAR})))
BACKQUOTE_LITERAL_DOLLAR=("$"+([^a-zA-Z_\x7f-\xff$`\\{]|("\\"{ANY_CHAR})))
DOUBLE_QUOTES_CHARS=("{"*([^$\"\\{]|("\\"{ANY_CHAR}))|{DOUBLE_QUOTES_LITERAL_DOLLAR})
BACKQUOTE_CHARS=("{"*([^$`\\{]|("\\"{ANY_CHAR}))|{BACKQUOTE_LITERAL_DOLLAR})

%%

<ST_IN_SCRIPTING>"if" {
	return createSymbol(ParserConstants.T_IF);
}

<ST_IN_SCRIPTING>"elseif" {
	return createSymbol(ParserConstants.T_ELSEIF);
}

<ST_IN_SCRIPTING>"endif" {
	return createSymbol(ParserConstants.T_ENDIF);
}

<ST_IN_SCRIPTING>"else" {
	return createSymbol(ParserConstants.T_ELSE);
}

<ST_IN_SCRIPTING>"for" {
	return createSymbol(ParserConstants.T_FOR);
}

<ST_IN_SCRIPTING>"endfor" {
	return createSymbol(ParserConstants.T_ENDFOR);
}

<ST_IN_SCRIPTING>"as" {
	return createSymbol(ParserConstants.T_AS);
}

<ST_IN_SCRIPTING>"extends" {
	return createSymbol(ParserConstants.T_EXTENDS);
}


<ST_IN_SCRIPTING>"." {
	
	dump("CREATING OBJECT OPERATOR IN SCRIPTING STATE");
    pushState(ST_LOOKING_FOR_PROPERTY);
    return createSymbol(ParserConstants.T_OBJECT_OPERATOR);
}

<ST_IN_SCRIPTING,ST_LOOKING_FOR_PROPERTY>{WHITESPACE}+ {

	dump("WHITESPACE");
}

<ST_LOOKING_FOR_PROPERTY>"." {

	dump("CREATING OBJECT OPERATOR IN LOOKING FOR PROPERTY STATE");
	return createSymbol(ParserConstants.T_OBJECT_OPERATOR);
}

<ST_LOOKING_FOR_PROPERTY>{LABEL} {

	dump("IN PROPERTY LOOKUP CREATE STRING");
    popState();
    return createFullSymbol(ParserConstants.T_STRING);
}

<ST_LOOKING_FOR_PROPERTY>{ANY_CHAR} {
    yypushback(yylength());
    popState();
}



<ST_IN_SCRIPTING>"include" {
	return createSymbol(ParserConstants.T_INCLUDE);
}

<ST_IN_SCRIPTING>"use" {
	return createSymbol(ParserConstants.T_USE);
}

<ST_IN_SCRIPTING>"++" {
	return createSymbol(ParserConstants.T_INC);
}

<ST_IN_SCRIPTING>"--" {
	return createSymbol(ParserConstants.T_DEC);
}

<ST_IN_SCRIPTING>"==" {
	return createSymbol(ParserConstants.T_IS_EQUAL);
}

<ST_IN_SCRIPTING>"!="|"<>" {
	return createSymbol(ParserConstants.T_IS_NOT_EQUAL);
}

<ST_IN_SCRIPTING>"<=" {
	return createSymbol(ParserConstants.T_IS_SMALLER_OR_EQUAL);
}

<ST_IN_SCRIPTING>">=" {
	return createSymbol(ParserConstants.T_IS_GREATER_OR_EQUAL);
}

<ST_IN_SCRIPTING>"+=" {
	return createSymbol(ParserConstants.T_PLUS_EQUAL);
}

<ST_IN_SCRIPTING>"-=" {
	return createSymbol(ParserConstants.T_MINUS_EQUAL);
}

<ST_IN_SCRIPTING>"*=" {
	return createSymbol(ParserConstants.T_MUL_EQUAL);
}

<ST_IN_SCRIPTING>"/=" {
	return createSymbol(ParserConstants.T_DIV_EQUAL);
}

<ST_IN_SCRIPTING>".=" {
	return createSymbol(ParserConstants.T_CONCAT_EQUAL);
}

<ST_IN_SCRIPTING>"%=" {
	return createSymbol(ParserConstants.T_MOD_EQUAL);
}

<ST_IN_SCRIPTING>"<<=" {
	return createSymbol(ParserConstants.T_SL_EQUAL);
}

<ST_IN_SCRIPTING>">>=" {
	return createSymbol(ParserConstants.T_SR_EQUAL);
}

<ST_IN_SCRIPTING>"&=" {
	return createSymbol(ParserConstants.T_AND_EQUAL);
}

<ST_IN_SCRIPTING>"|=" {
	return createSymbol(ParserConstants.T_OR_EQUAL);
}

<ST_IN_SCRIPTING>"^=" {
	return createSymbol(ParserConstants.T_XOR_EQUAL);
}

<ST_IN_SCRIPTING>"||" {
	return createSymbol(ParserConstants.T_BOOLEAN_OR);
}

<ST_IN_SCRIPTING>"&&" {
	return createSymbol(ParserConstants.T_BOOLEAN_AND);
}

<ST_IN_SCRIPTING>"OR" {
	return createSymbol(ParserConstants.T_LOGICAL_OR);
}

<ST_IN_SCRIPTING>"AND" {
	return createSymbol(ParserConstants.T_LOGICAL_AND);
}

<ST_IN_SCRIPTING>"XOR" {
	return createSymbol(ParserConstants.T_LOGICAL_XOR);
}

<ST_IN_SCRIPTING>"<<" {
	return createSymbol(ParserConstants.T_SL);
}

<ST_IN_SCRIPTING>">>" {
	return createSymbol(ParserConstants.T_SR);
}

// TOKENS
<ST_IN_SCRIPTING> {
    ";"                     {return createSymbol(ParserConstants.T_SEMICOLON);}
    ":"                     {return createSymbol(ParserConstants.T_NEKUDOTAIM);}
    ","                     {return createSymbol(ParserConstants.T_COMMA);}
    "."                     {return createSymbol(ParserConstants.T_NEKUDA);}
    "["                     {return createSymbol(ParserConstants.T_OPEN_RECT);}
    "]"                     {return createSymbol(ParserConstants.T_CLOSE_RECT);}
    "("                     {return createSymbol(ParserConstants.T_OPEN_PARENTHESE);}
    ")"                     {return createSymbol(ParserConstants.T_CLOSE_PARENTHESE);}
    "|"                     {return createSymbol(ParserConstants.T_OR);}
    "^"                     {return createSymbol(ParserConstants.T_KOVA);}
    "&"                     {return createSymbol(ParserConstants.T_REFERENCE);}
    "+"                     {return createSymbol(ParserConstants.T_PLUS);}
    "-"                     {return createSymbol(ParserConstants.T_MINUS);}
    "/"                     {return createSymbol(ParserConstants.T_DIV);}
    "*"                     {return createSymbol(ParserConstants.T_TIMES);}
    "="                     {return createSymbol(ParserConstants.T_EQUAL);}
    "%"                     {return createSymbol(ParserConstants.T_PRECENT);}
    "!"                     {return createSymbol(ParserConstants.T_NOT);}
    "~"                     {return createSymbol(ParserConstants.T_TILDA);}
    "$"                     {return createSymbol(ParserConstants.T_DOLLAR);}
    "<"                     {return createSymbol(ParserConstants.T_RGREATER);}
    ">"                     {return createSymbol(ParserConstants.T_LGREATER);}
    "?"                     {return createSymbol(ParserConstants.T_QUESTION_MARK);}
    "@"                     {return createSymbol(ParserConstants.T_AT);}
}

<ST_IN_SCRIPTING>"{" {
    pushState(ST_IN_SCRIPTING);
    return createSymbol(ParserConstants.T_CURLY_OPEN);

}


<ST_IN_SCRIPTING>"}" {
	/* This is a temporary fix which is dependant on flex and it's implementation */
    if (!stack.isEmpty()) {
        popState();
    }
    return createSymbol(ParserConstants.T_CURLY_CLOSE);
}

<ST_LOOKING_FOR_VARNAME>{LABEL} {
    popState();
    pushState(ST_IN_SCRIPTING);
    return createFullSymbol(ParserConstants.T_STRING_VARNAME);
}

<ST_LOOKING_FOR_VARNAME>{ANY_CHAR} {
    yypushback(yylength());
    popState();
    pushState(ST_IN_SCRIPTING);
}

<ST_IN_SCRIPTING>{LNUM} {
    return createFullSymbol(ParserConstants.T_LNUMBER);
}

<ST_IN_SCRIPTING>{HNUM} {
    return createFullSymbol(ParserConstants.T_DNUMBER);
}


<ST_IN_SCRIPTING>{DNUM}|{EXPONENT_DNUM} {
    return createFullSymbol(ParserConstants.T_DNUMBER);
}


<YYINITIAL>"{{"([ \t]|{NEWLINE}) {

	dump("START TWIG SCRIPTING");
    yybegin(ST_IN_SCRIPTING);

}

<ST_IN_SCRIPTING,ST_DOUBLE_QUOTES,ST_BACKQUOTE>{LABEL} {

	dump("FOUND T_VARIABLE");
    return createFullSymbol(ParserConstants.T_VARIABLE);
}

<ST_DOUBLE_QUOTES,ST_BACKQUOTE>{LABEL}"."[a-zA-Z_\x7f-\xff] {

	dump("FOUND LOOKING FOR PROPERTY");
	yypushback(3);
	pushState(ST_LOOKING_FOR_PROPERTY);
	return createFullSymbol(ParserConstants.T_VARIABLE);
}




<ST_IN_SCRIPTING>"define" {
    /* not a keyword, hust for recognize constans.*/
    return createFullSymbol(ParserConstants.T_DEFINE);
}

<ST_IN_SCRIPTING>{LABEL} {
    return createFullSymbol(ParserConstants.T_STRING);
}

<ST_IN_SCRIPTING>{WHITESPACE} {
}





<ST_IN_SCRIPTING>"/*"{WHITESPACE}*"@var"{WHITESPACE}("$"?){LABEL}{WHITESPACE}(("\\"|{LABEL}|"|")+)*{WHITESPACE}?"*/" {
    handleVarComment();
    //return createFullSymbol(ParserConstants.T_VAR_COMMENT);
}



<ST_IN_SCRIPTING>"/**/" {
	handleCommentStart();
}



<ST_IN_SCRIPTING>("}}"){NEWLINE}? {

	dump("END TWIG SCRIPTING");
	if (Debug.debugLexer)
		System.out.println();
		
    yybegin(YYINITIAL);
    return createSymbol(ParserConstants.T_SEMICOLON);  /* implicit ';' at php-end tag */
}


<ST_IN_SCRIPTING>(b?[\"]{DOUBLE_QUOTES_CHARS}*("{"*|"$"*)[\"]) {
    return createFullSymbol(ParserConstants.T_CONSTANT_ENCAPSED_STRING);
}

<ST_IN_SCRIPTING>(b?[']([^'\\]|("\\"{ANY_CHAR}))*[']) {
    return createFullSymbol(ParserConstants.T_CONSTANT_ENCAPSED_STRING);
}

<ST_IN_SCRIPTING>b?[\"] {
    yybegin(ST_DOUBLE_QUOTES);
    return createSymbol(ParserConstants.T_QUATE);
}


<ST_IN_SCRIPTING>[`] {
    yybegin(ST_BACKQUOTE);
    return createSymbol(ParserConstants.T_BACKQUATE);
}




<ST_DOUBLE_QUOTES,ST_BACKQUOTE>"{$" {
    pushState(ST_IN_SCRIPTING);
    yypushback(yylength()-1);
    return createSymbol(ParserConstants.T_CURLY_OPEN_WITH_DOLAR);
}

<ST_DOUBLE_QUOTES>{DOUBLE_QUOTES_CHARS}+ {
	return createFullSymbol(ParserConstants.T_ENCAPSED_AND_WHITESPACE);
}

/*
The original parsing rule was {DOUBLE_QUOTES_CHARS}*("{"{2,}|"$"{2,}|(("{"+|"$"+)[\"]))
but jflex doesn't support a{n,} so we changed a{2,} to aa+
*/
<ST_DOUBLE_QUOTES>{DOUBLE_QUOTES_CHARS}*("{""{"+|"$""$"+|(("{"+|"$"+)[\"])) {
    yypushback(1);
    return createFullSymbol(ParserConstants.T_ENCAPSED_AND_WHITESPACE);
}

<ST_BACKQUOTE>{BACKQUOTE_CHARS}+ {
	return createFullSymbol(ParserConstants.T_ENCAPSED_AND_WHITESPACE);
}

/*
The original parsing rule was {BACKQUOTE_CHARS}*("{"{2,}|"$"{2,}|(("{"+|"$"+)[`]))
but jflex doesn't support a{n,} so we changed a{2,} to aa+
*/
<ST_BACKQUOTE>{BACKQUOTE_CHARS}*("{""{"+|"$""$"+|(("{"+|"$"+)[`])) {
	yypushback(1);
	return createFullSymbol(ParserConstants.T_ENCAPSED_AND_WHITESPACE);
}


/*
The original parsing rule was {HEREDOC_CHARS}*({HEREDOC_NEWLINE}+({LABEL}";"?)?)?("{"{2,}|"$"{2,})
but jflex doesn't support a{n,} so we changed a{2,} to aa+
*/

<ST_DOUBLE_QUOTES>[\"] {
    yybegin(ST_IN_SCRIPTING);
    return createSymbol(ParserConstants.T_QUATE);
}

<ST_BACKQUOTE>[`] {
    yybegin(ST_IN_SCRIPTING);
    return createSymbol(ParserConstants.T_BACKQUATE);
}

<ST_IN_SCRIPTING,YYINITIAL,ST_DOUBLE_QUOTES,ST_BACKQUOTE>{ANY_CHAR} {
	// do nothing
}