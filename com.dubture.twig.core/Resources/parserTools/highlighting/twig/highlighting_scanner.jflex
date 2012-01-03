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

package com.dubture.twig.core.documentModel.parser;

import org.eclipse.php.internal.core.util.collections.IntHashtable;
import org.eclipse.wst.sse.core.utils.StringUtils;
import com.dubture.twig.core.util.Debug;

%%

%public
%class TwigLexer
%extends com.dubture.twig.core.documentModel.parser.AbstractTwigLexer
%type String
%unicode
%caseless

%state ST_TWIG_IN_PRINT
%state ST_TWIG_IN_STATEMENT
%state ST_TWIG_IN_STATEMENT_BODY
%state ST_TWIG_DOUBLE_QUOTES
%state ST_TWIG_SINGLE_QUOTES
%state ST_TWIG_HIGHLIGHTING_ERROR
%state ST_TWIG_COMMENT
%state ST_TWIG_HASH


%{

    private boolean insideRaw = false;
    
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
LABEL=[a-zA-Z_\x7f-\xff][a-zA-Z0-9_\x7f-\xff]*

KEYWORD="not"|"in"|"as"|"is"|"defined"|"and"|"with"|"or"|"only"

TWIG_WHITESPACE=[ \n\r\t]+
TOKENS=[:,.\[\]()|\^&+-//*=!~$<>?@]
NUMBER=([0-9])+


%%

/***********************************************************************************************
**************************************** T W I G  ***********************************************
***********************************************************************************************/

<ST_TWIG_IN_STATEMENT, ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH> {KEYWORD} {

	if(Debug.debugTokenizer)
		dump("TWIG KEYWORD");

	return TWIG_KEYWORD;
}

<ST_TWIG_IN_STATEMENT, ST_TWIG_HASH> "-" {

	if(Debug.debugTokenizer)
		dump("TWIG MINUS");
    

	return TWIG_MINUS;

}

<ST_TWIG_IN_STATEMENT> {LABEL} {

	if(Debug.debugTokenizer)
		dump("TWIG KEYWORD");

    if (tokenizer != null) {        
        if ("raw".equals(yytext())) {
            insideRaw = true;
            tokenizer.startRaw();    
        } else if ("endraw".equals(yytext())) {
            insideRaw = true;
            tokenizer.endRaw();                
        }
    }
    
    pushState(ST_TWIG_IN_STATEMENT_BODY);

	pushState(ST_TWIG_IN_STATEMENT_BODY);
	return TWIG_KEYWORD;
}


<ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH> {LABEL} {

	if(Debug.debugTokenizer)
		dump("TWIG LABEL");

	return TWIG_LABEL;
}

<ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH> {NUMBER} {

	if(Debug.debugTokenizer)
		dump("TWIG NUMBER");

    return TWIG_NUMBER;
}

<ST_TWIG_COMMENT> "#}"{TWIG_WHITESPACE}? {

	if(Debug.debugTokenizer)
		dump("TWIG COMMENT CLOSE");
		

	return TWIG_COMMENT_CLOSE;
}

<ST_TWIG_IN_PRINT> "}}"{TWIG_WHITESPACE}? {

	if(Debug.debugTokenizer)
		dump("TWIG_CLOSETAG");

	return TWIG_CLOSETAG;
}

<ST_TWIG_IN_STATEMENT> "%}"{TWIG_WHITESPACE}? {

	if(Debug.debugTokenizer)
		dump("TWIG_STMT_CLOSE");

	return TWIG_STMT_CLOSE;
}

<ST_TWIG_IN_STATEMENT_BODY> "%}"{TWIG_WHITESPACE}? {

	if(Debug.debugTokenizer)
		dump("TWIG_STMT_CLOSE");

	popState();
	return TWIG_STMT_CLOSE;
}



<ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH> {TWIG_WHITESPACE} {

	if(Debug.debugTokenizer)
		dump("TWIG WHITESPACE");

	return TWIG_WHITESPACE;
}


<ST_TWIG_COMMENT> .|\r|\n {
// see github #41
//<ST_TWIG_COMMENT> [^#]+ {

	if(Debug.debugTokenizer)
		dump("TWIG COMMENT");

	return TWIG_COMMENT;
	
}


<ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH> "{" {

	if(Debug.debugTokenizer)
		dump("TWIG JSON START");

	pushState(ST_TWIG_HASH);		
    return TWIG_HASH_START;
}

<ST_TWIG_HASH> "}" {

	if(Debug.debugTokenizer)
		dump("TWIG JSON END");

	//yybegin(ST_TWIG_HASH)
	popState();
    return TWIG_HASH_END;
}



<ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH>([']([^'\\]|("\\".))*[']) {

	if(Debug.debugTokenizer)
		dump("TWIG_CONSTANT_ENCAPSED_STRING");

    return TWIG_CONSTANT_ENCAPSED_STRING;
}

<ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH>([\"]([^\"\\]|("\\".))*[\"]) {

	if(Debug.debugTokenizer)
		dump("TWIG_CONSTANT_ENCAPSED_STRING");

    return TWIG_CONSTANT_ENCAPSED_STRING;
}

// ST_TWIG_DOUBLE_QUOTES // 
<ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH>([\"]) {

	if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES START");

	pushState(ST_TWIG_DOUBLE_QUOTES);
    return TWIG_DOUBLE_QUOTES_START;
}

<ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH>([']) {

	if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES START");

	pushState(ST_TWIG_SINGLE_QUOTES);
    return TWIG_SINGLE_QUOTES_START;
}


<ST_TWIG_DOUBLE_QUOTES>([\"]) {

	if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES END");

	popState();
    return TWIG_DOUBLE_QUOTES_END;
}

<ST_TWIG_SINGLE_QUOTES>([']) {

	if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES END");

	popState();
    return TWIG_SINGLE_QUOTES_END;
}


<ST_TWIG_DOUBLE_QUOTES>([^\"])+ {

	if(Debug.debugTokenizer)
		dump("TWIG DOUBLE QUOTES CONTENT");

    return TWIG_DOUBLE_QUOTES_CONTENT;
}

<ST_TWIG_SINGLE_QUOTES>([^'])+ {

	if(Debug.debugTokenizer)
		dump("TWIG SINGLE QUOTES CONTENT");

    return TWIG_SINGLE_QUOTES_CONTENT;
}


<ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_HASH> {TOKENS} {

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
<ST_TWIG_IN_STATEMENT, ST_TWIG_IN_STATEMENT_BODY, ST_TWIG_IN_PRINT, ST_TWIG_COMMENT, ST_TWIG_DOUBLE_QUOTES, ST_TWIG_SINGLE_QUOTES, ST_TWIG_HASH>. {

	if(Debug.debugTokenizer)
		dump("TWIG HIGHLIGHT ERROR");

	reportError();
    yypushback(1);
    pushState(ST_TWIG_HIGHLIGHTING_ERROR);

}