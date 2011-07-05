/******************************************************************************** 
 * Copyright (c) 2006 Zend Corporation and IBM Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Zend and IBM - Initial implementation
 ********************************************************************************/

package org.eclipse.twig.core.documentModel.parser;

import org.eclipse.php.internal.core.util.collections.IntHashtable;
import org.eclipse.wst.sse.core.utils.StringUtils;
import org.eclipse.twig.core.util.Debug;

%%

%public
%class TwigLexer
%extends org.eclipse.twig.core.documentModel.parser.AbstractTwigLexer
%type String
%unicode
%caseless

%state ST_TWIG_CONTENT
%state ST_TWIG_DOUBLE_QUOTES
%state ST_TWIG_DOUBLE_QUOTES_SPECIAL
%state ST_TWIG_HIGHLIGHTING_ERROR
%state ST_TWIG_COMMENT


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
	
	private final void dump(String s) {
		if (Debug.debugTokenizer) {
			System.out.println("lexer: " + s + " (" + yychar + "-" + //$NON-NLS-2$//$NON-NLS-1$
				(yylength() + yychar) + "):\'" +//$NON-NLS-1$
					StringUtils.escape(yytext()) + "\'");//$NON-NLS-1$
		}
	}
	
	

 // End user code
%}


// twig macros
//TW_START = \{\{{WHITESPACE}*

//TW_STMT_DEL_LEFT = {WHITESPACE}*\{%{WHITESPACE}*
//TWIG_START = \{\{{WHITESPACE}*
LABEL=[a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*

KEYWORD="extends"|"block"|"endblock"|"for"|"endfor"|"if"|"else"|"endif"|"not"|"in"|"as"|"set"|"include"|"with"|"render"|"import"|"macro"|"endmacro"|"autoescape"|"endautoescape"|"use"|"is"|"defined"

TWIG_WHITESPACE=[ \n\r\t]+
TOKENS=[:,.\[\]()|\^&+-//*=!~$<>?@]
NUMBER=([0-9])+


%%

/***********************************************************************************************
**************************************** T W I G  ***********************************************
***********************************************************************************************/

<ST_TWIG_CONTENT> "$"{LABEL} {

	if (Debug.debugTokenizer)
		dump("TWIG VARIABLE");

	return TWIG_VARIABLE;
}

<ST_TWIG_CONTENT> {KEYWORD} {

	if(Debug.debugTokenizer)
		dump("TWIG KEYWORD");

	return TWIG_KEYWORD;
}


<ST_TWIG_CONTENT> {LABEL} {

	if(Debug.debugTokenizer)
		dump("TWIG LABEL");

	return TWIG_LABEL;
}

<ST_TWIG_CONTENT> {NUMBER} {

	if(Debug.debugTokenizer)
		dump("TWIG NUMBER");

    return TWIG_NUMBER;
}

<ST_TWIG_COMMENT> "#}"{TWIG_WHITESPACE}? {

	if(Debug.debugTokenizer)
		dump("TWIG COMMENT CLOSE");
		

	return TWIG_COMMENT_CLOSE;
}

<ST_TWIG_CONTENT> "}}"{TWIG_WHITESPACE}? {

	if(Debug.debugTokenizer)
		dump("TWIG_CLOSETAG");

	return TWIG_CLOSETAG;
}


<ST_TWIG_CONTENT> "%}"{TWIG_WHITESPACE}? {

	if(Debug.debugTokenizer)
		dump("TWIG_STMT_CLOSE");

	return TWIG_STMT_CLOSE;
}



<ST_TWIG_CONTENT> {TWIG_WHITESPACE} {

	if(Debug.debugTokenizer)
		dump("TWIG WHITESPACE");

	return TWIG_WHITESPACE;
}


//<ST_TWIG_COMMENT> .|\r|\n {
<ST_TWIG_COMMENT> [^#]+ {

	if(Debug.debugTokenizer)
		dump("TWIG COMMENT");

	return TWIG_COMMENT;
	
}


<ST_TWIG_CONTENT> "{" {

	if(Debug.debugTokenizer)
		dump("TWIG JSON START");


    return TWIG_JSON_START;
}

<ST_TWIG_CONTENT> "}" {

	if(Debug.debugTokenizer)
		dump("TWIG JSON END");

	//yybegin(ST_TWIG_JSON)

    return TWIG_JSON_END;
}



<ST_TWIG_CONTENT>([']([^'\\]|("\\".))*[']) {

	if(Debug.debugTokenizer)
		dump("TWIG_CONSTANT_ENCAPSED_STRING");

    return TWIG_CONSTANT_ENCAPSED_STRING;
}

// ST_TWIG_DOUBLE_QUOTES // 
<ST_TWIG_CONTENT>([\"]) {

	if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES START");

	yybegin(ST_TWIG_DOUBLE_QUOTES);
    return TWIG_DOUBLE_QUOTES_START;
}

<ST_TWIG_DOUBLE_QUOTES>([\"]) {

	if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES END");

	yybegin(ST_TWIG_CONTENT);
    return TWIG_DOUBLE_QUOTES_END;
}

<ST_TWIG_DOUBLE_QUOTES>([^`$\"])+ {

	if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES CONTENT");

    return TWIG_DOUBLE_QUOTES_CONTENT;
}

<ST_TWIG_DOUBLE_QUOTES> "$"{LABEL} {

	if (Debug.debugTokenizer)
		dump("TWIG DOLLAR VAR");
		
    return TWIG_VARIABLE;
}

<ST_TWIG_DOUBLE_QUOTES> "$"{LABEL}[\[]{NUMBER}[\]] {

	if (Debug.debugTokenizer)
		System.out.println("variable3");

    return TWIG_VARIABLE;
}

<ST_TWIG_DOUBLE_QUOTES> "$"{LABEL}[\[]{LABEL}[\]] {

	if (Debug.debugTokenizer)
		System.out.println("variable4");

    return TWIG_VARIABLE;
}

<ST_TWIG_DOUBLE_QUOTES> ([\`]) {

	yybegin(ST_TWIG_DOUBLE_QUOTES_SPECIAL);
    return TWIG_BACKTICK_START;
}

<ST_TWIG_DOUBLE_QUOTES_SPECIAL> ([\`]) {

	yybegin(ST_TWIG_DOUBLE_QUOTES);
    return TWIG_BACKTICK_END;
}

<ST_TWIG_DOUBLE_QUOTES_SPECIAL> "$"{LABEL} {

	if (Debug.debugTokenizer)
		System.out.println("variable5");

    return TWIG_VARIABLE;
}

<ST_TWIG_DOUBLE_QUOTES_SPECIAL> [\.\-\>()] {

    return TWIG_DELIMITER;
}

<ST_TWIG_DOUBLE_QUOTES_SPECIAL> {NUMBER} {

    return TWIG_NUMBER;
}

<ST_TWIG_DOUBLE_QUOTES_SPECIAL> {LABEL} {

    return TWIG_LABEL;
}

<ST_TWIG_CONTENT> {TOKENS} {

	if(Debug.debugTokenizer)
		dump("TWIG DELIMITER TOKEN");
	return TWIG_DELIMITER;
}

/* ============================================
   Stay in this state until we find a whitespace.
   After we find a whitespace we go the the prev state and try again from the next token.
   ============================================ */
<ST_TWIG_HIGHLIGHTING_ERROR> {

	{TWIG_WHITESPACE}	{popState();return TWIG_WHITESPACE;}
    .   	        	{return UNKNOWN_TOKEN;}
}


/* ============================================
   This rule must be the last in the section!!
   it should contain all the states.
   ============================================ */
<ST_TWIG_CONTENT, ST_TWIG_COMMENT, ST_TWIG_DOUBLE_QUOTES, ST_TWIG_DOUBLE_QUOTES_SPECIAL>. {

	if(Debug.debugTokenizer)
		dump("TWIG HIGHLIGHT ERROR");

	reportError();
    yypushback(1);
    pushState(ST_TWIG_HIGHLIGHTING_ERROR);

}