// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2012-01-01 13:11:37

  package com.dubture.twig.core.parser.ast;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int ARRAY_CLOSE=4;
    public static final int ARRAY_OPEN=5;
    public static final int BUFFER=6;
    public static final int COLON=7;
    public static final int DIGIT=8;
    public static final int DOT=9;
    public static final int ESC=10;
    public static final int IDENT=11;
    public static final int LETTER=12;
    public static final int NUMBER=13;
    public static final int PUNCTUATION=14;
    public static final int STRING=15;
    public static final int TWIG_VAR=16;
    public static final int T_CLOSE_CMT=17;
    public static final int T_CLOSE_CURLY=18;
    public static final int T_CLOSE_PAREN=19;
    public static final int T_CLOSE_PRINT=20;
    public static final int T_CLOSE_STMT=21;
    public static final int T_OPEN_CMT=22;
    public static final int T_OPEN_CURLY=23;
    public static final int T_OPEN_PAREN=24;
    public static final int T_OPEN_PRINT=25;
    public static final int T_OPEN_STMT=26;
    public static final int WS=27;

      private boolean insideTag = false;  


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public TwigLexer() {} 
    public TwigLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TwigLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g"; }

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:14:7: ( ',' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:14:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:15:7: ( '[' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:15:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:16:7: ( ']' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:16:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:17:7: ( '|' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:17:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:18:7: ( '~' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:18:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:98:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:99:16: ( '0' .. '9' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "T_OPEN_PAREN"
    public final void mT_OPEN_PAREN() throws RecognitionException {
        try {
            int _type = T_OPEN_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:101:13: ( '(' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:101:15: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_OPEN_PAREN"

    // $ANTLR start "T_CLOSE_PAREN"
    public final void mT_CLOSE_PAREN() throws RecognitionException {
        try {
            int _type = T_CLOSE_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:102:14: ( ')' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:102:16: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_CLOSE_PAREN"

    // $ANTLR start "T_OPEN_CURLY"
    public final void mT_OPEN_CURLY() throws RecognitionException {
        try {
            int _type = T_OPEN_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:105:13: ( '{' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:105:15: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_OPEN_CURLY"

    // $ANTLR start "T_CLOSE_CURLY"
    public final void mT_CLOSE_CURLY() throws RecognitionException {
        try {
            int _type = T_CLOSE_CURLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:106:14: ( '}' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:106:16: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_CLOSE_CURLY"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:6: ( ':' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "T_OPEN_PRINT"
    public final void mT_OPEN_PRINT() throws RecognitionException {
        try {
            int _type = T_OPEN_PRINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:115:3: ( '{{' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:115:5: '{{'
            {
            match("{{"); 



            }

            state.type = _type;
            state.channel = _channel;

                insideTag=true;
                System.err.println("INSIDE TAG");     
              
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_OPEN_PRINT"

    // $ANTLR start "T_CLOSE_PRINT"
    public final void mT_CLOSE_PRINT() throws RecognitionException {
        try {
            int _type = T_CLOSE_PRINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:122:3: ( '}}' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:122:5: '}}'
            {
            match("}}"); 



            }

            state.type = _type;
            state.channel = _channel;

                insideTag=false;
                System.err.println("OUTSITE TAG");
              
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_CLOSE_PRINT"

    // $ANTLR start "T_OPEN_STMT"
    public final void mT_OPEN_STMT() throws RecognitionException {
        try {
            int _type = T_OPEN_STMT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:128:3: ( '{%' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:128:5: '{%'
            {
            match("{%"); 



            }

            state.type = _type;
            state.channel = _channel;

                insideTag=true;
              
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_OPEN_STMT"

    // $ANTLR start "T_CLOSE_STMT"
    public final void mT_CLOSE_STMT() throws RecognitionException {
        try {
            int _type = T_CLOSE_STMT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:134:3: ( '%}' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:134:5: '%}'
            {
            match("%}"); 



            }

            state.type = _type;
            state.channel = _channel;

                insideTag=false;
              
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_CLOSE_STMT"

    // $ANTLR start "T_OPEN_CMT"
    public final void mT_OPEN_CMT() throws RecognitionException {
        try {
            int _type = T_OPEN_CMT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:140:3: ( '{#' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:140:5: '{#'
            {
            match("{#"); 



            }

            state.type = _type;
            state.channel = _channel;

                insideTag=true;
              
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_OPEN_CMT"

    // $ANTLR start "T_CLOSE_CMT"
    public final void mT_CLOSE_CMT() throws RecognitionException {
        try {
            int _type = T_CLOSE_CMT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:146:3: ( '#}' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:146:5: '#}'
            {
            match("#}"); 



            }

            state.type = _type;
            state.channel = _channel;

                insideTag=false;
              
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T_CLOSE_CMT"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:148:3: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:148:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:148:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||(LA1_0 >= '\f' && LA1_0 <= '\r')||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "BUFFER"
    public final void mBUFFER() throws RecognitionException {
        try {
            int _type = BUFFER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:151:3: ({...}? => (~ ( T_OPEN_PRINT | T_CLOSE_PRINT | T_OPEN_STMT | T_CLOSE_STMT ) )+ )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:151:5: {...}? => (~ ( T_OPEN_PRINT | T_CLOSE_PRINT | T_OPEN_STMT | T_CLOSE_STMT ) )+
            {
            if ( !(( !insideTag)) ) {
                throw new FailedPredicateException(input, "BUFFER", " !insideTag");
            }

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:151:22: (~ ( T_OPEN_PRINT | T_CLOSE_PRINT | T_OPEN_STMT | T_CLOSE_STMT ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:151:22: ~ ( T_OPEN_PRINT | T_CLOSE_PRINT | T_OPEN_STMT | T_CLOSE_STMT )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BUFFER"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:153:4: ( '.' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:153:6: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken escaped=null;
            int normal;

            StringBuilder lBuf = new StringBuilder();
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:157:5: ( '\"' (escaped= ESC |normal=~ ( '\"' | '\\\\' | '\\n' | '\\r' ) )* '\"' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:158:12: '\"' (escaped= ESC |normal=~ ( '\"' | '\\\\' | '\\n' | '\\r' ) )* '\"'
            {
            match('\"'); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:159:12: (escaped= ESC |normal=~ ( '\"' | '\\\\' | '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:159:14: escaped= ESC
            	    {
            	    int escapedStart348 = getCharIndex();
            	    int escapedStartLine348 = getLine();
            	    int escapedStartCharPos348 = getCharPositionInLine();
            	    mESC(); 
            	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart348, getCharIndex()-1);
            	    escaped.setLine(escapedStartLine348);
            	    escaped.setCharPositionInLine(escapedStartCharPos348);


            	    lBuf.append(escaped.getText());

            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:160:14: normal=~ ( '\"' | '\\\\' | '\\n' | '\\r' )
            	    {
            	    normal= input.LA(1);

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    lBuf.appendCodePoint(normal);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match('\"'); 

            setText(lBuf.toString());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:168:5: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:168:9: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' )
            {
            match('\\'); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:169:9: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' )
            int alt4=9;
            switch ( input.LA(1) ) {
            case 'n':
                {
                alt4=1;
                }
                break;
            case 'r':
                {
                alt4=2;
                }
                break;
            case 't':
                {
                alt4=3;
                }
                break;
            case 'b':
                {
                alt4=4;
                }
                break;
            case 'f':
                {
                alt4=5;
                }
                break;
            case '\"':
                {
                alt4=6;
                }
                break;
            case '\'':
                {
                alt4=7;
                }
                break;
            case '/':
                {
                alt4=8;
                }
                break;
            case '\\':
                {
                alt4=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:169:17: 'n'
                    {
                    match('n'); 

                    setText("\n");

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:170:17: 'r'
                    {
                    match('r'); 

                    setText("\r");

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:171:17: 't'
                    {
                    match('t'); 

                    setText("\t");

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:172:17: 'b'
                    {
                    match('b'); 

                    setText("\b");

                    }
                    break;
                case 5 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:173:17: 'f'
                    {
                    match('f'); 

                    setText("\f");

                    }
                    break;
                case 6 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:174:17: '\"'
                    {
                    match('\"'); 

                    setText("\"");

                    }
                    break;
                case 7 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:175:17: '\\''
                    {
                    match('\''); 

                    setText("\'");

                    }
                    break;
                case 8 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:176:17: '/'
                    {
                    match('/'); 

                    setText("/");

                    }
                    break;
                case 9 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:177:17: '\\\\'
                    {
                    match('\\'); 

                    setText("\\");

                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:183:8: ( ( DIGIT )+ )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:183:10: ( DIGIT )+
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:183:10: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:184:7: ( ( LETTER ) ( LETTER | DIGIT )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:184:9: ( LETTER ) ( LETTER | DIGIT )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:184:17: ( LETTER | DIGIT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "PUNCTUATION"
    public final void mPUNCTUATION() throws RecognitionException {
        try {
            int _type = PUNCTUATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:185:12: ( '?' | ',' | '\\'' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            if ( input.LA(1)=='\''||input.LA(1)==','||input.LA(1)=='?' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUNCTUATION"

    public void mTokens() throws RecognitionException {
        // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:8: ( T__28 | T__29 | T__30 | T__31 | T__32 | T_OPEN_PAREN | T_CLOSE_PAREN | T_OPEN_CURLY | T_CLOSE_CURLY | COLON | T_OPEN_PRINT | T_CLOSE_PRINT | T_OPEN_STMT | T_CLOSE_STMT | T_OPEN_CMT | T_CLOSE_CMT | WS | BUFFER | DOT | STRING | NUMBER | IDENT | PUNCTUATION )
        int alt7=23;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:10: T__28
                {
                mT__28(); 


                }
                break;
            case 2 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:16: T__29
                {
                mT__29(); 


                }
                break;
            case 3 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:22: T__30
                {
                mT__30(); 


                }
                break;
            case 4 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:28: T__31
                {
                mT__31(); 


                }
                break;
            case 5 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:34: T__32
                {
                mT__32(); 


                }
                break;
            case 6 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:40: T_OPEN_PAREN
                {
                mT_OPEN_PAREN(); 


                }
                break;
            case 7 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:53: T_CLOSE_PAREN
                {
                mT_CLOSE_PAREN(); 


                }
                break;
            case 8 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:67: T_OPEN_CURLY
                {
                mT_OPEN_CURLY(); 


                }
                break;
            case 9 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:80: T_CLOSE_CURLY
                {
                mT_CLOSE_CURLY(); 


                }
                break;
            case 10 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:94: COLON
                {
                mCOLON(); 


                }
                break;
            case 11 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:100: T_OPEN_PRINT
                {
                mT_OPEN_PRINT(); 


                }
                break;
            case 12 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:113: T_CLOSE_PRINT
                {
                mT_CLOSE_PRINT(); 


                }
                break;
            case 13 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:127: T_OPEN_STMT
                {
                mT_OPEN_STMT(); 


                }
                break;
            case 14 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:139: T_CLOSE_STMT
                {
                mT_CLOSE_STMT(); 


                }
                break;
            case 15 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:152: T_OPEN_CMT
                {
                mT_OPEN_CMT(); 


                }
                break;
            case 16 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:163: T_CLOSE_CMT
                {
                mT_CLOSE_CMT(); 


                }
                break;
            case 17 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:175: WS
                {
                mWS(); 


                }
                break;
            case 18 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:178: BUFFER
                {
                mBUFFER(); 


                }
                break;
            case 19 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:185: DOT
                {
                mDOT(); 


                }
                break;
            case 20 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:189: STRING
                {
                mSTRING(); 


                }
                break;
            case 21 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:196: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 22 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:203: IDENT
                {
                mIDENT(); 


                }
                break;
            case 23 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:209: PUNCTUATION
                {
                mPUNCTUATION(); 


                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\36\1\40\1\41\2\23"+
        "\1\44\1\45\1\23\1\51\1\52\1\54\10\uffff\1\63\1\64\1\65\1\uffff\1"+
        "\67\2\uffff\1\72\1\73\2\uffff\2\23\1\107\2\uffff\1\112\22\uffff"+
        "\11\23\14\uffff";
    static final String DFA7_eofS =
        "\123\uffff";
    static final String DFA7_minS =
        "\13\0\2\175\6\0\2\uffff\21\0\1\42\6\0\6\uffff\3\0\1\uffff\1\0\2"+
        "\uffff\2\0\2\uffff\12\0\2\uffff\1\0\10\uffff";
    static final String DFA7_maxS =
        "\13\uffff\2\175\6\uffff\2\uffff\6\0\3\uffff\1\0\1\uffff\2\0\2\uffff"+
        "\2\0\1\164\2\uffff\2\0\1\uffff\1\0\6\uffff\3\0\1\uffff\1\0\2\uffff"+
        "\2\0\2\uffff\11\uffff\1\0\2\uffff\1\0\10\uffff";
    static final String DFA7_acceptS =
        "\23\uffff\1\22\1\1\30\uffff\1\2\1\3\1\4\1\5\1\6\1\7\3\uffff\1\10"+
        "\1\uffff\1\11\1\12\2\uffff\1\21\1\23\12\uffff\1\25\1\26\1\uffff"+
        "\1\27\1\13\1\15\1\17\1\14\1\16\1\20\1\24";
    static final String DFA7_specialS =
        "\1\17\1\54\1\73\1\66\1\57\1\52\1\43\1\35\1\42\1\55\1\12\1\62\1\50"+
        "\1\46\1\63\1\67\1\33\1\71\1\65\2\uffff\1\20\1\16\1\15\1\14\1\13"+
        "\1\11\1\22\1\40\1\36\1\10\1\3\1\7\1\6\1\45\1\60\1\32\1\30\1\72\1"+
        "\70\1\51\1\27\1\24\1\64\1\25\6\uffff\1\5\1\2\1\0\1\uffff\1\4\2\uffff"+
        "\1\1\1\31\2\uffff\1\56\1\61\1\47\1\53\1\41\1\44\1\34\1\37\1\21\1"+
        "\26\2\uffff\1\23\10\uffff}>";
    static final String[] DFA7_transitionS = {
            "\11\23\2\15\1\23\2\15\22\23\1\15\1\23\1\17\1\14\1\23\1\13\1"+
            "\23\1\22\1\6\1\7\2\23\1\1\1\23\1\16\1\23\12\20\1\12\4\23\1\22"+
            "\1\23\32\21\1\2\1\23\1\3\3\23\32\21\1\10\1\4\1\11\1\5\uff81"+
            "\23",
            "\0\23",
            "\0\23",
            "\0\23",
            "\0\23",
            "\0\23",
            "\0\23",
            "\0\23",
            "\43\23\1\35\1\23\1\34\125\23\1\33\uff84\23",
            "\175\23\1\37\uff82\23",
            "\0\23",
            "\1\42",
            "\1\43",
            "\11\23\2\15\1\23\2\15\22\23\1\15\uffdf\23",
            "\0\23",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\60\23\12\20\uffc6\23",
            "\60\23\12\53\7\23\32\53\6\23\32\53\uff85\23",
            "\0\23",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\0\23",
            "\0\23",
            "\0\23",
            "\1\uffff",
            "\0\23",
            "\1\uffff",
            "\1\uffff",
            "\0\23",
            "\0\23",
            "\1\uffff",
            "\1\uffff",
            "\1\103\4\uffff\1\104\7\uffff\1\105\54\uffff\1\106\5\uffff\1"+
            "\101\3\uffff\1\102\7\uffff\1\76\3\uffff\1\77\1\uffff\1\100",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\0\23",
            "\1\uffff",
            "\1\uffff",
            "\60\23\12\53\7\23\32\53\6\23\32\53\uff85\23",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__28 | T__29 | T__30 | T__31 | T__32 | T_OPEN_PAREN | T_CLOSE_PAREN | T_OPEN_CURLY | T_CLOSE_CURLY | COLON | T_OPEN_PRINT | T_CLOSE_PRINT | T_OPEN_STMT | T_CLOSE_STMT | T_OPEN_CMT | T_CLOSE_CMT | WS | BUFFER | DOT | STRING | NUMBER | IDENT | PUNCTUATION );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_53 = input.LA(1);

                         
                        int index7_53 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 78;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_53);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA7_58 = input.LA(1);

                         
                        int index7_58 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 80;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_58);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA7_52 = input.LA(1);

                         
                        int index7_52 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 77;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_52);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA7_31 = input.LA(1);

                         
                        int index7_31 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_31 >= '\u0000' && LA7_31 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 55;

                         
                        input.seek(index7_31);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA7_55 = input.LA(1);

                         
                        int index7_55 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 79;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_55);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA7_51 = input.LA(1);

                         
                        int index7_51 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 76;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_51);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA7_33 = input.LA(1);

                         
                        int index7_33 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 57;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_33);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA7_32 = input.LA(1);

                         
                        int index7_32 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 56;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_32);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA7_30 = input.LA(1);

                         
                        int index7_30 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 54;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_30);

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA7_26 = input.LA(1);

                         
                        int index7_26 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 50;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_26);

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA7_10 = input.LA(1);

                         
                        int index7_10 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_10 >= '\u0000' && LA7_10 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 33;

                         
                        input.seek(index7_10);

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA7_25 = input.LA(1);

                         
                        int index7_25 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 49;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_25);

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA7_24 = input.LA(1);

                         
                        int index7_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 48;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_24);

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA7_23 = input.LA(1);

                         
                        int index7_23 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 47;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_23);

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA7_22 = input.LA(1);

                         
                        int index7_22 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 46;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_22);

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA7_0 = input.LA(1);

                         
                        int index7_0 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_0==',') ) {s = 1;}

                        else if ( (LA7_0=='[') ) {s = 2;}

                        else if ( (LA7_0==']') ) {s = 3;}

                        else if ( (LA7_0=='|') ) {s = 4;}

                        else if ( (LA7_0=='~') ) {s = 5;}

                        else if ( (LA7_0=='(') ) {s = 6;}

                        else if ( (LA7_0==')') ) {s = 7;}

                        else if ( (LA7_0=='{') ) {s = 8;}

                        else if ( (LA7_0=='}') ) {s = 9;}

                        else if ( (LA7_0==':') ) {s = 10;}

                        else if ( (LA7_0=='%') ) {s = 11;}

                        else if ( (LA7_0=='#') ) {s = 12;}

                        else if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||(LA7_0 >= '\f' && LA7_0 <= '\r')||LA7_0==' ') ) {s = 13;}

                        else if ( (LA7_0=='.') ) {s = 14;}

                        else if ( (LA7_0=='\"') ) {s = 15;}

                        else if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {s = 16;}

                        else if ( ((LA7_0 >= 'A' && LA7_0 <= 'Z')||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {s = 17;}

                        else if ( (LA7_0=='\''||LA7_0=='?') ) {s = 18;}

                        else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\b')||LA7_0=='\u000B'||(LA7_0 >= '\u000E' && LA7_0 <= '\u001F')||LA7_0=='!'||LA7_0=='$'||LA7_0=='&'||(LA7_0 >= '*' && LA7_0 <= '+')||LA7_0=='-'||LA7_0=='/'||(LA7_0 >= ';' && LA7_0 <= '>')||LA7_0=='@'||LA7_0=='\\'||(LA7_0 >= '^' && LA7_0 <= '`')||(LA7_0 >= '\u007F' && LA7_0 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                         
                        input.seek(index7_0);

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA7_21 = input.LA(1);

                         
                        int index7_21 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 45;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_21);

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA7_70 = input.LA(1);

                         
                        int index7_70 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_70=='\"') ) {s = 40;}

                        else if ( (LA7_70=='\\') ) {s = 38;}

                        else if ( ((LA7_70 >= '\u0000' && LA7_70 <= '\t')||(LA7_70 >= '\u000B' && LA7_70 <= '\f')||(LA7_70 >= '\u000E' && LA7_70 <= '!')||(LA7_70 >= '#' && LA7_70 <= '[')||(LA7_70 >= ']' && LA7_70 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_70);

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA7_27 = input.LA(1);

                         
                        int index7_27 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_27 >= '\u0000' && LA7_27 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 51;

                         
                        input.seek(index7_27);

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA7_74 = input.LA(1);

                         
                        int index7_74 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (( !insideTag)) ) {s = 19;}

                        else if ( (true) ) {s = 73;}

                         
                        input.seek(index7_74);

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA7_42 = input.LA(1);

                         
                        int index7_42 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (( !insideTag)) ) {s = 19;}

                        else if ( (true) ) {s = 73;}

                         
                        input.seek(index7_42);

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA7_44 = input.LA(1);

                         
                        int index7_44 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (( !insideTag)) ) {s = 19;}

                        else if ( (true) ) {s = 75;}

                         
                        input.seek(index7_44);

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA7_71 = input.LA(1);

                         
                        int index7_71 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (( !insideTag)) ) {s = 19;}

                        else if ( (true) ) {s = 82;}

                         
                        input.seek(index7_71);

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA7_41 = input.LA(1);

                         
                        int index7_41 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (( !insideTag)) ) {s = 19;}

                        else if ( (true) ) {s = 72;}

                         
                        input.seek(index7_41);

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA7_37 = input.LA(1);

                         
                        int index7_37 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (( !insideTag)) ) {s = 19;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index7_37);

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA7_59 = input.LA(1);

                         
                        int index7_59 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 81;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_59);

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA7_36 = input.LA(1);

                         
                        int index7_36 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!((( !insideTag)))) ) {s = 60;}

                        else if ( (( !insideTag)) ) {s = 19;}

                         
                        input.seek(index7_36);

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA7_16 = input.LA(1);

                         
                        int index7_16 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_16 >= '0' && LA7_16 <= '9')) ) {s = 16;}

                        else if ( ((LA7_16 >= '\u0000' && LA7_16 <= '/')||(LA7_16 >= ':' && LA7_16 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 41;

                         
                        input.seek(index7_16);

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA7_68 = input.LA(1);

                         
                        int index7_68 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_68=='\"') ) {s = 40;}

                        else if ( (LA7_68=='\\') ) {s = 38;}

                        else if ( ((LA7_68 >= '\u0000' && LA7_68 <= '\t')||(LA7_68 >= '\u000B' && LA7_68 <= '\f')||(LA7_68 >= '\u000E' && LA7_68 <= '!')||(LA7_68 >= '#' && LA7_68 <= '[')||(LA7_68 >= ']' && LA7_68 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_68);

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA7_7 = input.LA(1);

                         
                        int index7_7 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_7 >= '\u0000' && LA7_7 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 26;

                         
                        input.seek(index7_7);

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA7_29 = input.LA(1);

                         
                        int index7_29 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_29 >= '\u0000' && LA7_29 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 53;

                         
                        input.seek(index7_29);

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA7_69 = input.LA(1);

                         
                        int index7_69 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_69=='\"') ) {s = 40;}

                        else if ( (LA7_69=='\\') ) {s = 38;}

                        else if ( ((LA7_69 >= '\u0000' && LA7_69 <= '\t')||(LA7_69 >= '\u000B' && LA7_69 <= '\f')||(LA7_69 >= '\u000E' && LA7_69 <= '!')||(LA7_69 >= '#' && LA7_69 <= '[')||(LA7_69 >= ']' && LA7_69 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_69);

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA7_28 = input.LA(1);

                         
                        int index7_28 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_28 >= '\u0000' && LA7_28 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 52;

                         
                        input.seek(index7_28);

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA7_66 = input.LA(1);

                         
                        int index7_66 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_66=='\"') ) {s = 40;}

                        else if ( (LA7_66=='\\') ) {s = 38;}

                        else if ( ((LA7_66 >= '\u0000' && LA7_66 <= '\t')||(LA7_66 >= '\u000B' && LA7_66 <= '\f')||(LA7_66 >= '\u000E' && LA7_66 <= '!')||(LA7_66 >= '#' && LA7_66 <= '[')||(LA7_66 >= ']' && LA7_66 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_66);

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA7_8 = input.LA(1);

                         
                        int index7_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_8=='{') ) {s = 27;}

                        else if ( (LA7_8=='%') ) {s = 28;}

                        else if ( (LA7_8=='#') ) {s = 29;}

                        else if ( ((LA7_8 >= '\u0000' && LA7_8 <= '\"')||LA7_8=='$'||(LA7_8 >= '&' && LA7_8 <= 'z')||(LA7_8 >= '|' && LA7_8 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 30;

                         
                        input.seek(index7_8);

                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA7_6 = input.LA(1);

                         
                        int index7_6 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_6 >= '\u0000' && LA7_6 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 25;

                         
                        input.seek(index7_6);

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA7_67 = input.LA(1);

                         
                        int index7_67 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_67=='\"') ) {s = 40;}

                        else if ( (LA7_67=='\\') ) {s = 38;}

                        else if ( ((LA7_67 >= '\u0000' && LA7_67 <= '\t')||(LA7_67 >= '\u000B' && LA7_67 <= '\f')||(LA7_67 >= '\u000E' && LA7_67 <= '!')||(LA7_67 >= '#' && LA7_67 <= '[')||(LA7_67 >= ']' && LA7_67 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_67);

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA7_34 = input.LA(1);

                         
                        int index7_34 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_34 >= '\u0000' && LA7_34 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 58;

                         
                        input.seek(index7_34);

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA7_13 = input.LA(1);

                         
                        int index7_13 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_13 >= '\t' && LA7_13 <= '\n')||(LA7_13 >= '\f' && LA7_13 <= '\r')||LA7_13==' ') ) {s = 13;}

                        else if ( ((LA7_13 >= '\u0000' && LA7_13 <= '\b')||LA7_13=='\u000B'||(LA7_13 >= '\u000E' && LA7_13 <= '\u001F')||(LA7_13 >= '!' && LA7_13 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 36;

                         
                        input.seek(index7_13);

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA7_64 = input.LA(1);

                         
                        int index7_64 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_64=='\"') ) {s = 40;}

                        else if ( (LA7_64=='\\') ) {s = 38;}

                        else if ( ((LA7_64 >= '\u0000' && LA7_64 <= '\t')||(LA7_64 >= '\u000B' && LA7_64 <= '\f')||(LA7_64 >= '\u000E' && LA7_64 <= '!')||(LA7_64 >= '#' && LA7_64 <= '[')||(LA7_64 >= ']' && LA7_64 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_64);

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA7_12 = input.LA(1);

                         
                        int index7_12 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_12=='}') ) {s = 35;}

                        else s = 19;

                         
                        input.seek(index7_12);

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA7_40 = input.LA(1);

                         
                        int index7_40 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_40 >= '\u0000' && LA7_40 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 71;

                         
                        input.seek(index7_40);

                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA7_5 = input.LA(1);

                         
                        int index7_5 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_5 >= '\u0000' && LA7_5 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 24;

                         
                        input.seek(index7_5);

                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA7_65 = input.LA(1);

                         
                        int index7_65 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_65=='\"') ) {s = 40;}

                        else if ( (LA7_65=='\\') ) {s = 38;}

                        else if ( ((LA7_65 >= '\u0000' && LA7_65 <= '\t')||(LA7_65 >= '\u000B' && LA7_65 <= '\f')||(LA7_65 >= '\u000E' && LA7_65 <= '!')||(LA7_65 >= '#' && LA7_65 <= '[')||(LA7_65 >= ']' && LA7_65 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_65);

                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA7_1 = input.LA(1);

                         
                        int index7_1 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_1 >= '\u0000' && LA7_1 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 20;

                         
                        input.seek(index7_1);

                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA7_9 = input.LA(1);

                         
                        int index7_9 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_9=='}') ) {s = 31;}

                        else if ( ((LA7_9 >= '\u0000' && LA7_9 <= '|')||(LA7_9 >= '~' && LA7_9 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 32;

                         
                        input.seek(index7_9);

                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA7_62 = input.LA(1);

                         
                        int index7_62 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_62=='\"') ) {s = 40;}

                        else if ( (LA7_62=='\\') ) {s = 38;}

                        else if ( ((LA7_62 >= '\u0000' && LA7_62 <= '\t')||(LA7_62 >= '\u000B' && LA7_62 <= '\f')||(LA7_62 >= '\u000E' && LA7_62 <= '!')||(LA7_62 >= '#' && LA7_62 <= '[')||(LA7_62 >= ']' && LA7_62 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_62);

                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA7_4 = input.LA(1);

                         
                        int index7_4 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_4 >= '\u0000' && LA7_4 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 23;

                         
                        input.seek(index7_4);

                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA7_35 = input.LA(1);

                         
                        int index7_35 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_35 >= '\u0000' && LA7_35 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 59;

                         
                        input.seek(index7_35);

                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA7_63 = input.LA(1);

                         
                        int index7_63 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_63=='\"') ) {s = 40;}

                        else if ( (LA7_63=='\\') ) {s = 38;}

                        else if ( ((LA7_63 >= '\u0000' && LA7_63 <= '\t')||(LA7_63 >= '\u000B' && LA7_63 <= '\f')||(LA7_63 >= '\u000E' && LA7_63 <= '!')||(LA7_63 >= '#' && LA7_63 <= '[')||(LA7_63 >= ']' && LA7_63 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_63);

                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA7_11 = input.LA(1);

                         
                        int index7_11 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_11=='}') ) {s = 34;}

                        else s = 19;

                         
                        input.seek(index7_11);

                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA7_14 = input.LA(1);

                         
                        int index7_14 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_14 >= '\u0000' && LA7_14 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 37;

                         
                        input.seek(index7_14);

                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA7_43 = input.LA(1);

                         
                        int index7_43 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_43 >= '0' && LA7_43 <= '9')||(LA7_43 >= 'A' && LA7_43 <= 'Z')||(LA7_43 >= 'a' && LA7_43 <= 'z')) ) {s = 43;}

                        else if ( ((LA7_43 >= '\u0000' && LA7_43 <= '/')||(LA7_43 >= ':' && LA7_43 <= '@')||(LA7_43 >= '[' && LA7_43 <= '`')||(LA7_43 >= '{' && LA7_43 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 74;

                         
                        input.seek(index7_43);

                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA7_18 = input.LA(1);

                         
                        int index7_18 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_18 >= '\u0000' && LA7_18 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 44;

                         
                        input.seek(index7_18);

                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA7_3 = input.LA(1);

                         
                        int index7_3 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_3 >= '\u0000' && LA7_3 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 22;

                         
                        input.seek(index7_3);

                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA7_15 = input.LA(1);

                         
                        int index7_15 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_15=='\\') ) {s = 38;}

                        else if ( ((LA7_15 >= '\u0000' && LA7_15 <= '\t')||(LA7_15 >= '\u000B' && LA7_15 <= '\f')||(LA7_15 >= '\u000E' && LA7_15 <= '!')||(LA7_15 >= '#' && LA7_15 <= '[')||(LA7_15 >= ']' && LA7_15 <= '\uFFFF')) ) {s = 39;}

                        else if ( (LA7_15=='\"') ) {s = 40;}

                        else s = 19;

                         
                        input.seek(index7_15);

                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA7_39 = input.LA(1);

                         
                        int index7_39 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_39=='\"') ) {s = 40;}

                        else if ( (LA7_39=='\\') ) {s = 38;}

                        else if ( ((LA7_39 >= '\u0000' && LA7_39 <= '\t')||(LA7_39 >= '\u000B' && LA7_39 <= '\f')||(LA7_39 >= '\u000E' && LA7_39 <= '!')||(LA7_39 >= '#' && LA7_39 <= '[')||(LA7_39 >= ']' && LA7_39 <= '\uFFFF')) ) {s = 39;}

                        else s = 19;

                         
                        input.seek(index7_39);

                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA7_17 = input.LA(1);

                         
                        int index7_17 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_17 >= '0' && LA7_17 <= '9')||(LA7_17 >= 'A' && LA7_17 <= 'Z')||(LA7_17 >= 'a' && LA7_17 <= 'z')) ) {s = 43;}

                        else if ( ((LA7_17 >= '\u0000' && LA7_17 <= '/')||(LA7_17 >= ':' && LA7_17 <= '@')||(LA7_17 >= '[' && LA7_17 <= '`')||(LA7_17 >= '{' && LA7_17 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 42;

                         
                        input.seek(index7_17);

                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA7_38 = input.LA(1);

                         
                        int index7_38 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA7_38=='n') ) {s = 62;}

                        else if ( (LA7_38=='r') ) {s = 63;}

                        else if ( (LA7_38=='t') ) {s = 64;}

                        else if ( (LA7_38=='b') ) {s = 65;}

                        else if ( (LA7_38=='f') ) {s = 66;}

                        else if ( (LA7_38=='\"') ) {s = 67;}

                        else if ( (LA7_38=='\'') ) {s = 68;}

                        else if ( (LA7_38=='/') ) {s = 69;}

                        else if ( (LA7_38=='\\') ) {s = 70;}

                        else s = 19;

                         
                        input.seek(index7_38);

                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA7_2 = input.LA(1);

                         
                        int index7_2 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA7_2 >= '\u0000' && LA7_2 <= '\uFFFF')) && (( !insideTag))) {s = 19;}

                        else s = 21;

                         
                        input.seek(index7_2);

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}