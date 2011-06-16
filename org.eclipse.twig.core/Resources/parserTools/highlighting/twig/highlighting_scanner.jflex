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

package org.eclipse.twig.core.documentModel.parser;

import org.eclipse.php.internal.core.util.collections.IntHashtable;

%%

%public
%class TwigLexer
%extends org.eclipse.twig.core.documentModel.parser.AbstractTwigLexer
%type String
%unicode
%caseless




%state ST_PHP_IN_SCRIPTING
%state ST_PHP_DOUBLE_QUOTES
%state ST_PHP_BACKQUOTE
%state ST_PHP_QUOTES_AFTER_VARIABLE
%state ST_PHP_HEREDOC
%state ST_PHP_NOWDOC
%state ST_PHP_END_HEREDOC
%state ST_PHP_LOOKING_FOR_PROPERTY
%state ST_PHP_VAR_OFFSET
%state ST_PHP_COMMENT
%state ST_PHP_DOC_COMMENT
%state ST_PHP_LINE_COMMENT
%state ST_PHP_HIGHLIGHTING_ERROR
%state ST_PHP_END_NOWDOC

%{
    public TwigLexer(int state){
        initialize(state);
    }
    public void reset(char array[], int offset, int length) {
        this.zzBuffer = array;
        this.zzCurrentPos = offset;
        this.zzMarkedPos = offset;
        this.zzPushbackPos = offset;
        this.yychar = offset;
        this.zzEndRead = offset + length;
        this.zzStartRead = offset;
        this.zzAtEOF = zzCurrentPos >= zzEndRead;
        this.firstPos = offset;
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
    	initialize(parameters[6]);
    }

    protected boolean isHeredocState(int state){
    	    	return state == ST_PHP_HEREDOC || state == ST_PHP_END_HEREDOC || state == ST_PHP_NOWDOC || state == ST_PHP_END_NOWDOC;
    }
    
    public int[] getParamenters(){
    	return new int[]{zzMarkedPos, zzPushbackPos, zzCurrentPos, zzStartRead, zzEndRead, yyline, zzLexicalState};
    }

    protected int getZZLexicalState() {
        return zzLexicalState;
    }

    protected int getZZMarkedPos() {
        return zzMarkedPos;
    }

    protected int getZZEndRead() {
        return zzEndRead;
    }

    public char[] getZZBuffer() {
        return zzBuffer;
    }
    
    protected int getZZStartRead() {
    	return this.zzStartRead;
    }

    protected int getZZPushBackPosition() {
    	return this.zzPushbackPos;
    }

	protected void pushBack(int i) {
		yypushback(i);
	}

	// A pool of states. To avoid creation of a new state on each createMemento.
	private static final IntHashtable lexerStates = new IntHashtable(100);
	
	protected IntHashtable getLexerStates() {
		return lexerStates;
	}

 // End user code
%}

LNUM=[0-9]+
DNUM=([0-9]*"."[0-9]+)|([0-9]+"."[0-9]*)
EXPONENT_DNUM=(({LNUM}|{DNUM})[eE][+-]?{LNUM}?)
HNUM="0x"[0-9a-fA-F]+
LABEL=[a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*
WHITESPACE=[ \n\r\t]+
TABS_AND_SPACES=[ \t]*
TOKENS=[:,.\[\]()|\^&+-//*=%!~$<>?@]
CLOSE_EXPRESSION=[;]
ANY_CHAR=[^]
NEWLINE=("\r"|"\n"|"\r\n")
DOUBLE_QUOTES_LITERAL_DOLLAR=("$"+([^a-zA-Z_\x7f-\xff$\"\\{]|("\\"{ANY_CHAR})))
BACKQUOTE_LITERAL_DOLLAR=("$"+([^a-zA-Z_\x7f-\xff$`\\{]|("\\"{ANY_CHAR})))
HEREDOC_LITERAL_DOLLAR=("$"+([^a-zA-Z_\x7f-\xff$\n\r\\{]|("\\"[^\n\r])))
HEREDOC_NEWLINE=((({LABEL}";"?((("{"+|"$"+)"\\"?)|"\\"))|(("{"*|"$"*)"\\"?)){NEWLINE})
HEREDOC_CURLY_OR_ESCAPE_OR_DOLLAR=(("{"+[^$\n\r\\{])|("{"*"\\"[^\n\r])|{HEREDOC_LITERAL_DOLLAR})
HEREDOC_NON_LABEL=([^a-zA-Z_\x7f-\xff$\n\r\\{]|{HEREDOC_CURLY_OR_ESCAPE_OR_DOLLAR})
HEREDOC_LABEL_NO_NEWLINE=({LABEL}([^a-zA-Z0-9_\x7f-\xff;$\n\r\\{]|(";"[^$\n\r\\{])|(";"?{HEREDOC_CURLY_OR_ESCAPE_OR_DOLLAR})))
DOUBLE_QUOTES_CHARS=("{"*([^$\"\\{]|("\\"{ANY_CHAR}))|{DOUBLE_QUOTES_LITERAL_DOLLAR})
BACKQUOTE_CHARS=("{"*([^$`\\{]|("\\"{ANY_CHAR}))|{BACKQUOTE_LITERAL_DOLLAR})
HEREDOC_CHARS=("{"*([^$\n\r\\{]|("\\"[^\n\r]))|{HEREDOC_LITERAL_DOLLAR}|({HEREDOC_NEWLINE}+({HEREDOC_NON_LABEL}|{HEREDOC_LABEL_NO_NEWLINE})))
NOWDOC_CHARS=([^\n\r]|{NEWLINE}+([^a-zA-Z_\x7f-\xff\n\r]|({LABEL}([^a-zA-Z0-9_\x7f-\xff;\n\r]|(";"[^\n\r])))))
PHP_OPERATOR="=>"|"++"|"--"|"==="|"!=="|"=="|"!="|"<>"|"<="|">="|"+="|"-="|"*="|"/="|".="|"%="|"<<="|">>="|"&="|"|="|"^="|"||"|"&&"|"OR"|"AND"|"XOR"|"<<"|">>"

%%

/***********************************************************************************************
**************************************** P  H  P ***********************************************
***********************************************************************************************/



<ST_PHP_IN_SCRIPTING>"if" {
    return PHP_IF;
}

<ST_PHP_IN_SCRIPTING>"elseif" {
    return PHP_ELSEIF;
}

<ST_PHP_IN_SCRIPTING>"endif" {
    return PHP_ENDIF;
}

<ST_PHP_IN_SCRIPTING>"else" {
    return PHP_ELSE;
}


<ST_PHP_IN_SCRIPTING>"for" {
    return PHP_FOR;
}

<ST_PHP_IN_SCRIPTING>"endfor" {
    return PHP_ENDFOR;
}


<ST_PHP_IN_SCRIPTING>"as" {
    return PHP_AS;
}


<ST_PHP_IN_SCRIPTING>"extends" {
    return PHP_EXTENDS;
}


<ST_PHP_QUOTES_AFTER_VARIABLE> {
    "->" {
    popState();
    pushState(ST_PHP_LOOKING_FOR_PROPERTY);
    return PHP_OBJECT_OPERATOR;
    }
    {ANY_CHAR} {
        yypushback(1);
        popState();
    }
}

<ST_PHP_IN_SCRIPTING,ST_PHP_LOOKING_FOR_PROPERTY>{WHITESPACE}+ {
	return WHITESPACE;
}

<ST_PHP_LOOKING_FOR_PROPERTY>"->" {
	return PHP_OBJECT_OPERATOR;
}

<ST_PHP_LOOKING_FOR_PROPERTY>{LABEL} {
    popState();
    return PHP_STRING;
}

<ST_PHP_LOOKING_FOR_PROPERTY>{ANY_CHAR} {
    yypushback(1);
    popState();
}

<ST_PHP_IN_SCRIPTING>"::" {
    return PHP_PAAMAYIM_NEKUDOTAYIM;
}

<ST_PHP_IN_SCRIPTING>"\\" {
	return PHP_NS_SEPARATOR;
}



<ST_PHP_IN_SCRIPTING>"true" {
    return PHP_TRUE;
}

<ST_PHP_IN_SCRIPTING>"false" {
    return PHP_FALSE;
}

<ST_PHP_IN_SCRIPTING>{PHP_OPERATOR} {
    return PHP_OPERATOR;
}

<ST_PHP_IN_SCRIPTING>{TOKENS} {
    return PHP_TOKEN;
}

<ST_PHP_IN_SCRIPTING>{CLOSE_EXPRESSION} {
    return PHP_SEMICOLON;
}

<ST_PHP_IN_SCRIPTING>"{" {
    return PHP_CURLY_OPEN;
}

<ST_PHP_DOUBLE_QUOTES,ST_PHP_BACKQUOTE,ST_PHP_HEREDOC>"${" {
    pushState(ST_PHP_IN_SCRIPTING);
    return PHP_TOKEN;
}

<ST_PHP_IN_SCRIPTING>"}" {
    if (!phpStack.isEmpty()) {
        popState();
    }
    return  PHP_CURLY_CLOSE;
}

<ST_PHP_IN_SCRIPTING>{LNUM} {
    return PHP_NUMBER;
}

<ST_PHP_IN_SCRIPTING>{HNUM} {
    return PHP_NUMBER;
}

<ST_PHP_VAR_OFFSET>[0]|([1-9][0-9]*) { /* Offset could be treated as a long */
	return PHP_NUMBER;
}

<ST_PHP_VAR_OFFSET>{LNUM}|{HNUM} {
	return PHP_NUMBER;
}

<ST_PHP_IN_SCRIPTING>{DNUM}|{EXPONENT_DNUM} {
    return PHP_NUMBER;
}


<ST_PHP_IN_SCRIPTING>"$"{LABEL} {
    return PHP_VARIABLE;
}

<ST_PHP_DOUBLE_QUOTES,ST_PHP_BACKQUOTE,ST_PHP_HEREDOC,ST_PHP_VAR_OFFSET>"$"{LABEL} {
    pushState(ST_PHP_QUOTES_AFTER_VARIABLE);
    return PHP_VARIABLE;
}

<ST_PHP_DOUBLE_QUOTES,ST_PHP_HEREDOC,ST_PHP_BACKQUOTE>"$"{LABEL}"[" {
	yypushback(1);
	pushState(ST_PHP_VAR_OFFSET);
	return PHP_VARIABLE;
}

<ST_PHP_VAR_OFFSET>"]" {
	popState();
	return PHP_TOKEN;
}

<ST_PHP_VAR_OFFSET>"[" { 
	return PHP_TOKEN;
}

<ST_PHP_VAR_OFFSET>{TOKENS}|[;{}\"`] {//the difference from the original rules comes from the fact that we took ';' out out of tokens 
	return UNKNOWN_TOKEN;
}

<ST_PHP_VAR_OFFSET>[ \n\r\t\\'#] {
	yypushback(1);
	popState();
	return PHP_ENCAPSED_AND_WHITESPACE;
}

<ST_PHP_IN_SCRIPTING,ST_PHP_VAR_OFFSET>"null" {
    return  PHP_KEYWORD;
}

<ST_PHP_IN_SCRIPTING,ST_PHP_VAR_OFFSET>{LABEL} {
    return  PHP_STRING;
}

<ST_PHP_IN_SCRIPTING>{WHITESPACE} {
    return  WHITESPACE;
}

<ST_PHP_IN_SCRIPTING>([#]|"//") {
    pushState(ST_PHP_LINE_COMMENT);
    return PHP_LINE_COMMENT;
}

<ST_PHP_LINE_COMMENT>"?"|"%"|">" {
    return PHP_LINE_COMMENT;
}

<ST_PHP_LINE_COMMENT>[^\n\r?%>]*{ANY_CHAR} {
	String yytext = yytext();
	switch (yytext.charAt(yytext.length() - 1)) {
		case '?':
		case '%':
		case '>':
			yypushback(1);
			break;
		default:
			popState();
	}
	 return PHP_LINE_COMMENT;
}

<ST_PHP_LINE_COMMENT>{NEWLINE} {
    popState();
    return PHP_LINE_COMMENT;
}


<ST_PHP_IN_SCRIPTING>"/**"(#@\+)?{WHITESPACE} {
    pushState(ST_PHP_DOC_COMMENT);
    return PHPDOC_COMMENT_START;
}

<ST_PHP_IN_SCRIPTING>"/*" {
    pushState(ST_PHP_COMMENT);
    return PHP_COMMENT_START;
}

<ST_PHP_COMMENT>[^*]+ {
    return PHP_COMMENT;
}

<ST_PHP_DOC_COMMENT>"*/" {
    popState();
    return PHPDOC_COMMENT_END;
}

<ST_PHP_COMMENT>"*/" {
    popState();
    return PHP_COMMENT_END;
}

<ST_PHP_COMMENT>"*" {
    return PHP_COMMENT;
}


<ST_PHP_IN_SCRIPTING,ST_PHP_LINE_COMMENT>"?>"{WHITESPACE}? {
	return PHP_CLOSETAG;
}
<ST_PHP_IN_SCRIPTING>"%>"{WHITESPACE}? {
	if (asp_tags) {
	    return PHP_CLOSETAG;
	}
	return UNKNOWN_TOKEN;
}

<ST_PHP_LINE_COMMENT>"%>"{WHITESPACE}? {
	if (asp_tags) {
	    return PHP_CLOSETAG;
	}
	String text = yytext();
	if(text.indexOf('\r') != -1 || text.indexOf('\n') != -1 ){
		popState();
	}
	return PHP_LINE_COMMENT;
}

<ST_PHP_IN_SCRIPTING>(b?[\"]{DOUBLE_QUOTES_CHARS}*("{"*|"$"*)[\"]) {
    return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_IN_SCRIPTING>(b?[']([^'\\]|("\\"{ANY_CHAR}))*[']) {
    return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_IN_SCRIPTING>b?[\"] {
    pushState(ST_PHP_DOUBLE_QUOTES);
    return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_IN_SCRIPTING>b?"<<<"{TABS_AND_SPACES}({LABEL}|([']{LABEL}['])|([\"]{LABEL}[\"])){NEWLINE} {
    int bprefix = (yytext().charAt(0) != '<') ? 1 : 0;
    int startString=3+bprefix;
    
    int hereOrNowDoc_len = yylength()-bprefix-3-1-(yytext().charAt(yylength()-2)=='\r'?1:0);
    while ((yytext().charAt(startString) == ' ') || (yytext().charAt(startString) == '\t')) {
        startString++;
        hereOrNowDoc_len--;
    }
    String hereOrNowDoc = yytext().substring(startString,hereOrNowDoc_len+startString);
    if (hereOrNowDoc.charAt(0) == '\'') {
    	nowdoc = hereOrNowDoc.substring(1, hereOrNowDoc_len-1);
    	nowdoc_len = hereOrNowDoc_len - 2;
    	yybegin(ST_PHP_NOWDOC);
    }
    else if (hereOrNowDoc.charAt(0) == '"') {
    	heredoc = hereOrNowDoc.substring(1, hereOrNowDoc_len-1);
    	heredoc_len = hereOrNowDoc_len - 2;
    	yybegin(ST_PHP_HEREDOC);
    } else {
    	heredoc = hereOrNowDoc;
    	heredoc_len = hereOrNowDoc_len;
    	yybegin(ST_PHP_HEREDOC);
    }
    return PHP_HEREDOC_TAG;
}

<ST_PHP_IN_SCRIPTING>[`] {
    pushState(ST_PHP_BACKQUOTE);
    return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_HEREDOC>{LABEL}";"?[\n\r] {
    int label_len = yylength() - 1;

    if (yytext().charAt(label_len-1)==';') {
	    label_len--;
    }

    if (label_len==heredoc_len && yytext().substring(0,label_len).equals(heredoc)) {
        heredoc=null;
        heredoc_len=0;
        yybegin(ST_PHP_IN_SCRIPTING);
        return PHP_HEREDOC_TAG;
    } else {
        return PHP_CONSTANT_ENCAPSED_STRING;
    }
}

<ST_PHP_HEREDOC>{HEREDOC_CHARS}*{HEREDOC_NEWLINE}+{LABEL}";"?[\n\r] {
    int label_len = yylength() - 1;

    if (yytext().charAt(label_len-1)==';') {
	   label_len--;
    }
    if (label_len > heredoc_len && yytext().substring(label_len - heredoc_len,label_len).equals(heredoc)) {
    	
    	if ((label_len - heredoc_len-2) >= 0 && yytext().charAt(label_len - heredoc_len-2)=='\r') {
        	label_len = label_len-2;
    	} else {
        	label_len--;
    	}
    	yypushback(heredoc_len + (yylength() - label_len));
    	
        yybegin(ST_PHP_END_HEREDOC);
    }
    return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_END_HEREDOC>{NEWLINE}*({ANY_CHAR}[^\n\r;])*{LABEL}";"?[\n\r] {
	int label_len = yylength() - 1;
	int startIndex = 0;
	String yytext = yytext();
	if (yytext.charAt(label_len - 1) == ';') {
		label_len--;
	}
	while (yytext.charAt(startIndex) == '\r'
			|| yytext.charAt(startIndex) == '\n') {
		startIndex++;
	}

	if (label_len > heredoc_len
			&& yytext.substring(startIndex, label_len).equals(
					heredoc)) {
		heredoc = null;
		heredoc_len = 0;
		yybegin(ST_PHP_IN_SCRIPTING);
		return PHP_HEREDOC_TAG;
	} else {
		yybegin(ST_PHP_HEREDOC);
		return PHP_CONSTANT_ENCAPSED_STRING;
	}
}

<ST_PHP_END_HEREDOC>{NEWLINE}*{LABEL}({TABS_AND_SPACES}[^\n\r])+";"?[\n\r] {
	yybegin(ST_PHP_HEREDOC);
	return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_END_HEREDOC>{NEWLINE}*({TABS_AND_SPACES}[^\n\r])+{LABEL}";"?[\n\r] {
	yybegin(ST_PHP_HEREDOC);
	return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_NOWDOC>{LABEL}";"?[\n\r] {
    int label_len = yylength() - 1;

    if (yytext().charAt(label_len-1)==';') {
	    label_len--;
    }

    if (label_len==nowdoc_len && yytext().substring(0,label_len).equals(nowdoc)) {
        nowdoc=null;
        nowdoc_len=0;
        yybegin(ST_PHP_IN_SCRIPTING);
        return PHP_HEREDOC_TAG;
    } else {
        return PHP_CONSTANT_ENCAPSED_STRING;
    }
}

<ST_PHP_NOWDOC>({NOWDOC_CHARS}+{NEWLINE}+|{NEWLINE}+){LABEL}";"?[\n\r] {
	int label_len = yylength() - 1;

	if (yytext().charAt(label_len-1)==';') {
	   label_len--;
    }
    if (label_len > nowdoc_len && yytext().substring(label_len - nowdoc_len,label_len).equals(nowdoc)) {
    	//nowdoc = null;
    	//nowdoc_len = 0;
		//yypushback(1);
		//yybegin(ST_PHP_END_NOWDOC);
		
    	if ((label_len - nowdoc_len-2) >= 0 && yytext().charAt(label_len - nowdoc_len-2)=='\r') {
        	label_len = label_len-2;
    	} else {
        	label_len--;
    	}
    	yypushback(nowdoc_len + (yylength() - label_len));
    	
        yybegin(ST_PHP_END_NOWDOC);
	}
	return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_END_NOWDOC>{NEWLINE}{LABEL}";"?[\n\r] {
	nowdoc = null;
	nowdoc_len = 0;
    yybegin(ST_PHP_IN_SCRIPTING);
    return PHP_HEREDOC_TAG;
}

<ST_PHP_DOUBLE_QUOTES,ST_PHP_BACKQUOTE,ST_PHP_HEREDOC,ST_PHP_QUOTES_AFTER_VARIABLE>"{$" {
    yypushback(1);
    pushState(ST_PHP_IN_SCRIPTING);
    return PHP_CURLY_OPEN;
}

<ST_PHP_DOUBLE_QUOTES>{DOUBLE_QUOTES_CHARS}+ {
	return PHP_ENCAPSED_AND_WHITESPACE;
}

/*
The original parsing rule was {DOUBLE_QUOTES_CHARS}*("{"{2,}|"$"{2,}|(("{"+|"$"+)[\"]))
but jflex doesn't support a{n,} so we changed a{2,} to aa+
*/
<ST_PHP_DOUBLE_QUOTES>{DOUBLE_QUOTES_CHARS}*("{""{"+|"$""$"+|(("{"+|"$"+)[\"])) {
    yypushback(1);
    return PHP_ENCAPSED_AND_WHITESPACE;
}

<ST_PHP_BACKQUOTE>{BACKQUOTE_CHARS}+ {
    return PHP_ENCAPSED_AND_WHITESPACE;
}

/*
The original parsing rule was {BACKQUOTE_CHARS}*("{"{2,}|"$"{2,}|(("{"+|"$"+)[`]))
but jflex doesn't support a{n,} so we changed a{2,} to aa+
*/
<ST_PHP_BACKQUOTE>{BACKQUOTE_CHARS}*("{""{"+|"$""$"+|(("{"+|"$"+)[`])) {
	yypushback(1);
	return PHP_ENCAPSED_AND_WHITESPACE;
}

<ST_PHP_HEREDOC>{HEREDOC_CHARS}*({HEREDOC_NEWLINE}+({LABEL}";"?)?)? {
	if(heredoc!=null&&yytext().startsWith(heredoc)){
		String text = yytext();
		if(heredoc_len < text.length() && (text.charAt(heredoc_len) == '\r'
			|| text.charAt(heredoc_len) == '\n')){
			yypushback(yylength()-heredoc_len-1);
	        heredoc=null;
	        heredoc_len=0;
	        yybegin(ST_PHP_IN_SCRIPTING);
	        return PHP_HEREDOC_TAG;
		}
	}
	return PHP_ENCAPSED_AND_WHITESPACE;
}

/*
The original parsing rule was {HEREDOC_CHARS}*({HEREDOC_NEWLINE}+({LABEL}";"?)?)?("{"{2,}|"$"{2,})
but jflex doesn't support a{n,} so we changed a{2,} to aa+
*/
<ST_PHP_HEREDOC>{HEREDOC_CHARS}*({HEREDOC_NEWLINE}+({LABEL}";"?)?)?("{""{"+|"$""$"+) {
    yypushback(1);
    return PHP_ENCAPSED_AND_WHITESPACE;
}

<ST_PHP_NOWDOC>{NOWDOC_CHARS}*({HEREDOC_NEWLINE}+({LABEL}";"?)?)? {
	return PHP_ENCAPSED_AND_WHITESPACE;
}

<ST_PHP_DOUBLE_QUOTES>[\"] {
    popState();
    return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_BACKQUOTE>[`] {
    popState();
    return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_DOUBLE_QUOTES>. {
    return PHP_CONSTANT_ENCAPSED_STRING;
}

<ST_PHP_BACKQUOTE>. {
    return PHP_CONSTANT_ENCAPSED_STRING;
}

/* ============================================
   Stay in this state until we find a whitespace.
   After we find a whitespace we go the the prev state and try again from the next token.
   ============================================ */
<ST_PHP_HIGHLIGHTING_ERROR> {
	{WHITESPACE}	{popState();return WHITESPACE;}
    .   	        {return UNKNOWN_TOKEN;}
}

/* ============================================
   This rule must be the last in the section!!
   it should contain all the states.
   ============================================ */
<ST_PHP_IN_SCRIPTING,ST_PHP_DOUBLE_QUOTES,ST_PHP_VAR_OFFSET,ST_PHP_BACKQUOTE,ST_PHP_HEREDOC,ST_PHP_END_HEREDOC,ST_PHP_END_NOWDOC,ST_PHP_NOWDOC>. {
    yypushback(1);
    pushState(ST_PHP_HIGHLIGHTING_ERROR);
}
