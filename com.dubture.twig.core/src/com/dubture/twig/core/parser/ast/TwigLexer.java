// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2012-01-01 20:38:14

  package com.dubture.twig.core.parser.ast;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int ARRAY_CLOSE=4;
    public static final int ARRAY_OPEN=5;
    public static final int COLON=6;
    public static final int DIGIT=7;
    public static final int DOT=8;
    public static final int ESC=9;
    public static final int IDENT=10;
    public static final int LETTER=11;
    public static final int NUMBER=12;
    public static final int PUNCTUATION=13;
    public static final int RAW=14;
    public static final int SQ_STRING=15;
    public static final int STRING=16;
    public static final int TWIG_VAR=17;
    public static final int T_CLOSE_CMT=18;
    public static final int T_CLOSE_CURLY=19;
    public static final int T_CLOSE_PAREN=20;
    public static final int T_CLOSE_PRINT=21;
    public static final int T_CLOSE_STMT=22;
    public static final int T_OPEN_CMT=23;
    public static final int T_OPEN_CURLY=24;
    public static final int T_OPEN_PAREN=25;
    public static final int T_OPEN_PRINT=26;
    public static final int T_OPEN_STMT=27;
    public static final int WS=28;


      // flag to switch the lexer state
      // between raw and twig context
      private boolean insideTag = false;  
      
      // is still raw content ahead or do we see a twig tag?
      private boolean rawAhead() {
      
        if(insideTag) return false;
        int ch1 = input.LA(1), ch2 = input.LA(2);
        return !(
            (ch1 == '{' && ch2 == '{') ||
            // 37 = percentage sign, this is a bug in antlr it seems:
            // http://www.antlr.org/pipermail/antlr-interest/2007-June/021188.html
            (ch1 == '{' && ch2 == 37) ||
            (ch1 == '{' && ch2 == '#')
        );
        
      }    


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

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:32:7: ( ',' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:32:9: ','
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
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:33:7: ( '[' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:33:9: '['
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
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:7: ( ']' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:9: ']'
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
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:7: ( '|' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:9: '|'
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
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:36:7: ( '~' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:36:9: '~'
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
    // $ANTLR end "T__33"

    // $ANTLR start "RAW"
    public final void mRAW() throws RecognitionException {
        try {
            int _type = RAW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:126:7: ( ({...}? => . )+ )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:126:9: ({...}? => . )+
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:126:9: ({...}? => . )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\uFFFF')) && ((rawAhead()))) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:126:10: {...}? => .
            	    {
            	    if ( !((rawAhead())) ) {
            	        throw new FailedPredicateException(input, "RAW", "rawAhead()");
            	    }

            	    matchAny(); 

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


             _channel=HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RAW"

    // $ANTLR start "T_OPEN_PRINT"
    public final void mT_OPEN_PRINT() throws RecognitionException {
        try {
            int _type = T_OPEN_PRINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:128:43: ( '{{' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:128:45: '{{'
            {
            match("{{"); 



            }

            state.type = _type;
            state.channel = _channel;
             insideTag=true; 
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:129:43: ( '}}' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:129:45: '}}'
            {
            match("}}"); 



            }

            state.type = _type;
            state.channel = _channel;
             insideTag=false; 
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:131:43: ( '{%' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:131:45: '{%'
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:43: ( '%}' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:45: '%}'
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:134:43: ( '{#' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:134:45: '{#'
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:135:43: ( '#}' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:135:45: '#}'
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

    // $ANTLR start "T_OPEN_PAREN"
    public final void mT_OPEN_PAREN() throws RecognitionException {
        try {
            int _type = T_OPEN_PAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:137:13: ( '(' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:137:15: '('
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:138:14: ( ')' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:138:16: ')'
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:140:13: ( '{' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:140:15: '{'
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:141:14: ( '}' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:141:16: '}'
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

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:143:7: ( '.' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:143:9: '.'
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

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:144:7: ( ':' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:144:9: ':'
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

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken escaped=null;
            int normal;

            StringBuilder lBuf = new StringBuilder();
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:149:5: ( '\"' (escaped= ESC |normal=~ ( '\"' | '\\\\' | '\\n' | '\\r' ) )* '\"' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:150:12: '\"' (escaped= ESC |normal=~ ( '\"' | '\\\\' | '\\n' | '\\r' ) )* '\"'
            {
            match('\"'); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:151:12: (escaped= ESC |normal=~ ( '\"' | '\\\\' | '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\\') ) {
                    alt2=1;
                }
                else if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '!')||(LA2_0 >= '#' && LA2_0 <= '[')||(LA2_0 >= ']' && LA2_0 <= '\uFFFF')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:151:14: escaped= ESC
            	    {
            	    int escapedStart270 = getCharIndex();
            	    int escapedStartLine270 = getLine();
            	    int escapedStartCharPos270 = getCharPositionInLine();
            	    mESC(); 
            	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart270, getCharIndex()-1);
            	    escaped.setLine(escapedStartLine270);
            	    escaped.setCharPositionInLine(escapedStartCharPos270);


            	    lBuf.append(escaped.getText());

            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:152:14: normal=~ ( '\"' | '\\\\' | '\\n' | '\\r' )
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
            	    break loop2;
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

    // $ANTLR start "SQ_STRING"
    public final void mSQ_STRING() throws RecognitionException {
        try {
            int _type = SQ_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken escaped=null;
            int normal;

            StringBuilder lBuf = new StringBuilder();
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:160:5: ( '\\'' (escaped= ESC |normal=~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )* '\\'' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:161:12: '\\'' (escaped= ESC |normal=~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )* '\\''
            {
            match('\''); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:162:12: (escaped= ESC |normal=~ ( '\\'' | '\\\\' | '\\n' | '\\r' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '&')||(LA3_0 >= '(' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:162:14: escaped= ESC
            	    {
            	    int escapedStart404 = getCharIndex();
            	    int escapedStartLine404 = getLine();
            	    int escapedStartCharPos404 = getCharPositionInLine();
            	    mESC(); 
            	    escaped = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, escapedStart404, getCharIndex()-1);
            	    escaped.setLine(escapedStartLine404);
            	    escaped.setCharPositionInLine(escapedStartCharPos404);


            	    lBuf.append(escaped.getText());

            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:163:14: normal=~ ( '\\'' | '\\\\' | '\\n' | '\\r' )
            	    {
            	    normal= input.LA(1);

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
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


            match('\''); 

            setText(lBuf.toString());

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SQ_STRING"

    // $ANTLR start "ESC"
    public final void mESC() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:172:5: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:172:9: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' )
            {
            match('\\'); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:173:9: ( 'n' | 'r' | 't' | 'b' | 'f' | '\"' | '\\'' | '/' | '\\\\' )
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
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:173:17: 'n'
                    {
                    match('n'); 

                    setText("\n");

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:174:17: 'r'
                    {
                    match('r'); 

                    setText("\r");

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:175:17: 't'
                    {
                    match('t'); 

                    setText("\t");

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:176:17: 'b'
                    {
                    match('b'); 

                    setText("\b");

                    }
                    break;
                case 5 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:177:17: 'f'
                    {
                    match('f'); 

                    setText("\f");

                    }
                    break;
                case 6 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:178:17: '\"'
                    {
                    match('\"'); 

                    setText("\"");

                    }
                    break;
                case 7 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:179:17: '\\''
                    {
                    match('\''); 

                    setText("\'");

                    }
                    break;
                case 8 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:180:17: '/'
                    {
                    match('/'); 

                    setText("/");

                    }
                    break;
                case 9 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:181:17: '\\\\'
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

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:186:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:187:16: ( '0' .. '9' )
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

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:189:8: ( ( DIGIT )+ )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:189:10: ( DIGIT )+
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:189:10: ( DIGIT )+
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:190:7: ( ( LETTER ) ( LETTER | DIGIT )+ )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:190:9: ( LETTER ) ( LETTER | DIGIT )+
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:190:17: ( LETTER | DIGIT )+
            int cnt6=0;
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:191:12: ( '?' | ',' | '\\'' )
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:192:3: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:192:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:192:5: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||(LA7_0 >= '\f' && LA7_0 <= '\r')||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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

    public void mTokens() throws RecognitionException {
        // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:8: ( T__29 | T__30 | T__31 | T__32 | T__33 | RAW | T_OPEN_PRINT | T_CLOSE_PRINT | T_OPEN_STMT | T_CLOSE_STMT | T_OPEN_CMT | T_CLOSE_CMT | T_OPEN_PAREN | T_CLOSE_PAREN | T_OPEN_CURLY | T_CLOSE_CURLY | DOT | COLON | STRING | SQ_STRING | NUMBER | IDENT | PUNCTUATION | WS )
        int alt8=24;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:10: T__29
                {
                mT__29(); 


                }
                break;
            case 2 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:16: T__30
                {
                mT__30(); 


                }
                break;
            case 3 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:22: T__31
                {
                mT__31(); 


                }
                break;
            case 4 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:28: T__32
                {
                mT__32(); 


                }
                break;
            case 5 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:34: T__33
                {
                mT__33(); 


                }
                break;
            case 6 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:40: RAW
                {
                mRAW(); 


                }
                break;
            case 7 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:44: T_OPEN_PRINT
                {
                mT_OPEN_PRINT(); 


                }
                break;
            case 8 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:57: T_CLOSE_PRINT
                {
                mT_CLOSE_PRINT(); 


                }
                break;
            case 9 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:71: T_OPEN_STMT
                {
                mT_OPEN_STMT(); 


                }
                break;
            case 10 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:83: T_CLOSE_STMT
                {
                mT_CLOSE_STMT(); 


                }
                break;
            case 11 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:96: T_OPEN_CMT
                {
                mT_OPEN_CMT(); 


                }
                break;
            case 12 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:107: T_CLOSE_CMT
                {
                mT_CLOSE_CMT(); 


                }
                break;
            case 13 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:119: T_OPEN_PAREN
                {
                mT_OPEN_PAREN(); 


                }
                break;
            case 14 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:132: T_CLOSE_PAREN
                {
                mT_CLOSE_PAREN(); 


                }
                break;
            case 15 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:146: T_OPEN_CURLY
                {
                mT_OPEN_CURLY(); 


                }
                break;
            case 16 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:159: T_CLOSE_CURLY
                {
                mT_CLOSE_CURLY(); 


                }
                break;
            case 17 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:173: DOT
                {
                mDOT(); 


                }
                break;
            case 18 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:177: COLON
                {
                mCOLON(); 


                }
                break;
            case 19 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:183: STRING
                {
                mSTRING(); 


                }
                break;
            case 20 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:190: SQ_STRING
                {
                mSQ_STRING(); 


                }
                break;
            case 21 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:200: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 22 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:207: IDENT
                {
                mIDENT(); 


                }
                break;
            case 23 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:213: PUNCTUATION
                {
                mPUNCTUATION(); 


                }
                break;
            case 24 :
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:1:225: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\1\25\1\26\1\27\1\30\1\31\1\35\1\37\2\24\1\42\1\43\1\44"+
        "\1\45\1\24\1\51\1\55\1\24\1\57\1\60\6\uffff\1\65\1\66\1\67\1\uffff"+
        "\1\71\1\uffff\1\73\1\74\4\uffff\2\24\1\112\1\uffff\2\24\1\125\1"+
        "\uffff\1\127\22\uffff\11\24\2\uffff\11\24\15\uffff";
    static final String DFA8_eofS =
        "\142\uffff";
    static final String DFA8_minS =
        "\10\0\2\175\7\0\1\60\2\0\2\uffff\20\0\1\42\3\0\1\42\6\0\4\uffff"+
        "\3\0\1\uffff\1\0\1\uffff\2\0\4\uffff\12\0\1\uffff\12\0\1\uffff\1"+
        "\0\12\uffff";
    static final String DFA8_maxS =
        "\10\uffff\2\175\7\uffff\1\172\2\uffff\2\uffff\4\0\3\uffff\1\0\1"+
        "\uffff\1\0\2\uffff\4\0\1\164\2\uffff\1\0\1\164\2\uffff\1\0\1\uffff"+
        "\2\0\4\uffff\3\0\1\uffff\1\0\1\uffff\2\0\4\uffff\11\uffff\1\0\1"+
        "\uffff\11\uffff\1\0\1\uffff\1\0\12\uffff";
    static final String DFA8_acceptS =
        "\24\uffff\1\6\1\1\33\uffff\1\2\1\3\1\4\1\5\3\uffff\1\17\1\uffff"+
        "\1\20\2\uffff\1\15\1\16\1\21\1\22\12\uffff\1\27\12\uffff\1\25\1"+
        "\uffff\1\30\1\7\1\11\1\13\1\10\1\12\1\14\1\23\1\24\1\26";
    static final String DFA8_specialS =
        "\1\14\1\67\1\25\1\22\1\17\1\15\1\30\1\46\1\45\1\47\1\60\1\50\1\44"+
        "\1\43\1\42\1\13\1\56\1\100\1\20\1\11\2\uffff\1\66\1\65\1\103\1\104"+
        "\1\4\1\73\1\62\1\75\1\0\1\76\1\64\1\63\1\72\1\74\1\77\1\101\1\70"+
        "\1\41\1\10\1\53\1\51\1\23\1\33\1\55\1\2\1\52\1\61\4\uffff\1\105"+
        "\1\107\1\111\1\uffff\1\106\1\uffff\1\110\1\71\4\uffff\1\34\1\36"+
        "\1\1\1\3\1\5\1\6\1\7\1\12\1\16\1\102\1\uffff\1\40\1\35\1\37\1\31"+
        "\1\32\1\26\1\27\1\21\1\24\1\57\1\uffff\1\54\12\uffff}>";
    static final String[] DFA8_transitionS = {
            "\11\24\2\23\1\24\2\23\22\24\1\23\1\24\1\16\1\11\1\24\1\10\1"+
            "\24\1\17\1\12\1\13\2\24\1\1\1\24\1\14\1\24\12\20\1\15\4\24\1"+
            "\22\1\24\32\21\1\2\1\24\1\3\3\24\32\21\1\6\1\4\1\7\1\5\uff81"+
            "\24",
            "\0\24",
            "\0\24",
            "\0\24",
            "\0\24",
            "\0\24",
            "\43\24\1\34\1\24\1\33\125\24\1\32\uff84\24",
            "\175\24\1\36\uff82\24",
            "\1\40",
            "\1\41",
            "\0\24",
            "\0\24",
            "\0\24",
            "\0\24",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\12\53\1\24\2\53\1\24\31\53\1\54\64\53\1\52\uffa3\53",
            "\60\24\12\20\uffc6\24",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\0\24",
            "\11\24\2\23\1\24\2\23\22\24\1\23\uffdf\24",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\0\24",
            "\0\24",
            "\0\24",
            "\1\uffff",
            "\0\24",
            "\1\uffff",
            "\0\24",
            "\0\24",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\106\4\uffff\1\107\7\uffff\1\110\54\uffff\1\111\5\uffff\1"+
            "\104\3\uffff\1\105\7\uffff\1\101\3\uffff\1\102\1\uffff\1\103",
            "\12\47\1\uffff\2\47\1\uffff\24\47\1\50\71\47\1\46\uffa3\47",
            "\0\24",
            "\1\uffff",
            "\1\121\4\uffff\1\122\7\uffff\1\123\54\uffff\1\124\5\uffff\1"+
            "\117\3\uffff\1\120\7\uffff\1\114\3\uffff\1\115\1\uffff\1\116",
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\0\24",
            "\1\uffff",
            "\60\24\12\56\7\24\32\56\6\24\32\56\uff85\24",
            "\1\uffff",
            "\1\uffff",
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
            "\1\uffff",
            "\1\uffff",
            "",
            "",
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
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\12\53\1\uffff\2\53\1\uffff\31\53\1\54\64\53\1\52\uffa3\53",
            "\1\uffff",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__29 | T__30 | T__31 | T__32 | T__33 | RAW | T_OPEN_PRINT | T_CLOSE_PRINT | T_OPEN_STMT | T_CLOSE_STMT | T_OPEN_CMT | T_CLOSE_CMT | T_OPEN_PAREN | T_CLOSE_PAREN | T_OPEN_CURLY | T_CLOSE_CURLY | DOT | COLON | STRING | SQ_STRING | NUMBER | IDENT | PUNCTUATION | WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA8_30 = input.LA(1);

                         
                        int index8_30 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_30 >= '\u0000' && LA8_30 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 57;

                         
                        input.seek(index8_30);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA8_67 = input.LA(1);

                         
                        int index8_67 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_67=='\"') ) {s = 40;}

                        else if ( (LA8_67=='\\') ) {s = 38;}

                        else if ( ((LA8_67 >= '\u0000' && LA8_67 <= '\t')||(LA8_67 >= '\u000B' && LA8_67 <= '\f')||(LA8_67 >= '\u000E' && LA8_67 <= '!')||(LA8_67 >= '#' && LA8_67 <= '[')||(LA8_67 >= ']' && LA8_67 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_67);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA8_46 = input.LA(1);

                         
                        int index8_46 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_46 >= '0' && LA8_46 <= '9')||(LA8_46 >= 'A' && LA8_46 <= 'Z')||(LA8_46 >= 'a' && LA8_46 <= 'z')) ) {s = 46;}

                        else if ( ((LA8_46 >= '\u0000' && LA8_46 <= '/')||(LA8_46 >= ':' && LA8_46 <= '@')||(LA8_46 >= '[' && LA8_46 <= '`')||(LA8_46 >= '{' && LA8_46 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 87;

                         
                        input.seek(index8_46);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA8_68 = input.LA(1);

                         
                        int index8_68 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_68=='\"') ) {s = 40;}

                        else if ( (LA8_68=='\\') ) {s = 38;}

                        else if ( ((LA8_68 >= '\u0000' && LA8_68 <= '\t')||(LA8_68 >= '\u000B' && LA8_68 <= '\f')||(LA8_68 >= '\u000E' && LA8_68 <= '!')||(LA8_68 >= '#' && LA8_68 <= '[')||(LA8_68 >= ']' && LA8_68 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_68);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA8_26 = input.LA(1);

                         
                        int index8_26 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_26 >= '\u0000' && LA8_26 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 53;

                         
                        input.seek(index8_26);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA8_69 = input.LA(1);

                         
                        int index8_69 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_69=='\"') ) {s = 40;}

                        else if ( (LA8_69=='\\') ) {s = 38;}

                        else if ( ((LA8_69 >= '\u0000' && LA8_69 <= '\t')||(LA8_69 >= '\u000B' && LA8_69 <= '\f')||(LA8_69 >= '\u000E' && LA8_69 <= '!')||(LA8_69 >= '#' && LA8_69 <= '[')||(LA8_69 >= ']' && LA8_69 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_69);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA8_70 = input.LA(1);

                         
                        int index8_70 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_70=='\"') ) {s = 40;}

                        else if ( (LA8_70=='\\') ) {s = 38;}

                        else if ( ((LA8_70 >= '\u0000' && LA8_70 <= '\t')||(LA8_70 >= '\u000B' && LA8_70 <= '\f')||(LA8_70 >= '\u000E' && LA8_70 <= '!')||(LA8_70 >= '#' && LA8_70 <= '[')||(LA8_70 >= ']' && LA8_70 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_70);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA8_71 = input.LA(1);

                         
                        int index8_71 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_71=='\"') ) {s = 40;}

                        else if ( (LA8_71=='\\') ) {s = 38;}

                        else if ( ((LA8_71 >= '\u0000' && LA8_71 <= '\t')||(LA8_71 >= '\u000B' && LA8_71 <= '\f')||(LA8_71 >= '\u000E' && LA8_71 <= '!')||(LA8_71 >= '#' && LA8_71 <= '[')||(LA8_71 >= ']' && LA8_71 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_71);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA8_40 = input.LA(1);

                         
                        int index8_40 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_40 >= '\u0000' && LA8_40 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 74;

                         
                        input.seek(index8_40);

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA8_19 = input.LA(1);

                         
                        int index8_19 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_19 >= '\t' && LA8_19 <= '\n')||(LA8_19 >= '\f' && LA8_19 <= '\r')||LA8_19==' ') ) {s = 19;}

                        else if ( ((LA8_19 >= '\u0000' && LA8_19 <= '\b')||LA8_19=='\u000B'||(LA8_19 >= '\u000E' && LA8_19 <= '\u001F')||(LA8_19 >= '!' && LA8_19 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 48;

                         
                        input.seek(index8_19);

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA8_72 = input.LA(1);

                         
                        int index8_72 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_72=='\"') ) {s = 40;}

                        else if ( (LA8_72=='\\') ) {s = 38;}

                        else if ( ((LA8_72 >= '\u0000' && LA8_72 <= '\t')||(LA8_72 >= '\u000B' && LA8_72 <= '\f')||(LA8_72 >= '\u000E' && LA8_72 <= '!')||(LA8_72 >= '#' && LA8_72 <= '[')||(LA8_72 >= ']' && LA8_72 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_72);

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA8_15 = input.LA(1);

                         
                        int index8_15 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_15=='\\') ) {s = 42;}

                        else if ( ((LA8_15 >= '\u0000' && LA8_15 <= '\t')||(LA8_15 >= '\u000B' && LA8_15 <= '\f')||(LA8_15 >= '\u000E' && LA8_15 <= '&')||(LA8_15 >= '(' && LA8_15 <= '[')||(LA8_15 >= ']' && LA8_15 <= '\uFFFF')) ) {s = 43;}

                        else if ( (LA8_15=='\'') ) {s = 44;}

                        else if ( (LA8_15=='\n'||LA8_15=='\r') && ((rawAhead()))) {s = 20;}

                        else s = 41;

                         
                        input.seek(index8_15);

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA8_0 = input.LA(1);

                         
                        int index8_0 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_0==',') ) {s = 1;}

                        else if ( (LA8_0=='[') ) {s = 2;}

                        else if ( (LA8_0==']') ) {s = 3;}

                        else if ( (LA8_0=='|') ) {s = 4;}

                        else if ( (LA8_0=='~') ) {s = 5;}

                        else if ( (LA8_0=='{') ) {s = 6;}

                        else if ( (LA8_0=='}') ) {s = 7;}

                        else if ( (LA8_0=='%') ) {s = 8;}

                        else if ( (LA8_0=='#') ) {s = 9;}

                        else if ( (LA8_0=='(') ) {s = 10;}

                        else if ( (LA8_0==')') ) {s = 11;}

                        else if ( (LA8_0=='.') ) {s = 12;}

                        else if ( (LA8_0==':') ) {s = 13;}

                        else if ( (LA8_0=='\"') ) {s = 14;}

                        else if ( (LA8_0=='\'') ) {s = 15;}

                        else if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {s = 16;}

                        else if ( ((LA8_0 >= 'A' && LA8_0 <= 'Z')||(LA8_0 >= 'a' && LA8_0 <= 'z')) ) {s = 17;}

                        else if ( (LA8_0=='?') ) {s = 18;}

                        else if ( ((LA8_0 >= '\t' && LA8_0 <= '\n')||(LA8_0 >= '\f' && LA8_0 <= '\r')||LA8_0==' ') ) {s = 19;}

                        else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\b')||LA8_0=='\u000B'||(LA8_0 >= '\u000E' && LA8_0 <= '\u001F')||LA8_0=='!'||LA8_0=='$'||LA8_0=='&'||(LA8_0 >= '*' && LA8_0 <= '+')||LA8_0=='-'||LA8_0=='/'||(LA8_0 >= ';' && LA8_0 <= '>')||LA8_0=='@'||LA8_0=='\\'||(LA8_0 >= '^' && LA8_0 <= '`')||(LA8_0 >= '\u007F' && LA8_0 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                         
                        input.seek(index8_0);

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA8_5 = input.LA(1);

                         
                        int index8_5 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_5 >= '\u0000' && LA8_5 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 25;

                         
                        input.seek(index8_5);

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA8_73 = input.LA(1);

                         
                        int index8_73 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_73=='\"') ) {s = 40;}

                        else if ( (LA8_73=='\\') ) {s = 38;}

                        else if ( ((LA8_73 >= '\u0000' && LA8_73 <= '\t')||(LA8_73 >= '\u000B' && LA8_73 <= '\f')||(LA8_73 >= '\u000E' && LA8_73 <= '!')||(LA8_73 >= '#' && LA8_73 <= '[')||(LA8_73 >= ']' && LA8_73 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_73);

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA8_4 = input.LA(1);

                         
                        int index8_4 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_4 >= '\u0000' && LA8_4 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 24;

                         
                        input.seek(index8_4);

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA8_18 = input.LA(1);

                         
                        int index8_18 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_18 >= '\u0000' && LA8_18 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 47;

                         
                        input.seek(index8_18);

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA8_83 = input.LA(1);

                         
                        int index8_83 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_83=='\'') ) {s = 44;}

                        else if ( (LA8_83=='\\') ) {s = 42;}

                        else if ( ((LA8_83 >= '\u0000' && LA8_83 <= '\t')||(LA8_83 >= '\u000B' && LA8_83 <= '\f')||(LA8_83 >= '\u000E' && LA8_83 <= '&')||(LA8_83 >= '(' && LA8_83 <= '[')||(LA8_83 >= ']' && LA8_83 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_83);

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA8_3 = input.LA(1);

                         
                        int index8_3 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_3 >= '\u0000' && LA8_3 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 23;

                         
                        input.seek(index8_3);

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA8_43 = input.LA(1);

                         
                        int index8_43 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_43=='\'') ) {s = 44;}

                        else if ( (LA8_43=='\\') ) {s = 42;}

                        else if ( ((LA8_43 >= '\u0000' && LA8_43 <= '\t')||(LA8_43 >= '\u000B' && LA8_43 <= '\f')||(LA8_43 >= '\u000E' && LA8_43 <= '&')||(LA8_43 >= '(' && LA8_43 <= '[')||(LA8_43 >= ']' && LA8_43 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_43);

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA8_84 = input.LA(1);

                         
                        int index8_84 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_84=='\'') ) {s = 44;}

                        else if ( (LA8_84=='\\') ) {s = 42;}

                        else if ( ((LA8_84 >= '\u0000' && LA8_84 <= '\t')||(LA8_84 >= '\u000B' && LA8_84 <= '\f')||(LA8_84 >= '\u000E' && LA8_84 <= '&')||(LA8_84 >= '(' && LA8_84 <= '[')||(LA8_84 >= ']' && LA8_84 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_84);

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA8_2 = input.LA(1);

                         
                        int index8_2 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_2 >= '\u0000' && LA8_2 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 22;

                         
                        input.seek(index8_2);

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA8_81 = input.LA(1);

                         
                        int index8_81 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_81=='\'') ) {s = 44;}

                        else if ( (LA8_81=='\\') ) {s = 42;}

                        else if ( ((LA8_81 >= '\u0000' && LA8_81 <= '\t')||(LA8_81 >= '\u000B' && LA8_81 <= '\f')||(LA8_81 >= '\u000E' && LA8_81 <= '&')||(LA8_81 >= '(' && LA8_81 <= '[')||(LA8_81 >= ']' && LA8_81 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_81);

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA8_82 = input.LA(1);

                         
                        int index8_82 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_82=='\'') ) {s = 44;}

                        else if ( (LA8_82=='\\') ) {s = 42;}

                        else if ( ((LA8_82 >= '\u0000' && LA8_82 <= '\t')||(LA8_82 >= '\u000B' && LA8_82 <= '\f')||(LA8_82 >= '\u000E' && LA8_82 <= '&')||(LA8_82 >= '(' && LA8_82 <= '[')||(LA8_82 >= ']' && LA8_82 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_82);

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA8_6 = input.LA(1);

                         
                        int index8_6 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_6=='{') ) {s = 26;}

                        else if ( (LA8_6=='%') ) {s = 27;}

                        else if ( (LA8_6=='#') ) {s = 28;}

                        else if ( ((LA8_6 >= '\u0000' && LA8_6 <= '\"')||LA8_6=='$'||(LA8_6 >= '&' && LA8_6 <= 'z')||(LA8_6 >= '|' && LA8_6 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 29;

                         
                        input.seek(index8_6);

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA8_79 = input.LA(1);

                         
                        int index8_79 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_79=='\'') ) {s = 44;}

                        else if ( (LA8_79=='\\') ) {s = 42;}

                        else if ( ((LA8_79 >= '\u0000' && LA8_79 <= '\t')||(LA8_79 >= '\u000B' && LA8_79 <= '\f')||(LA8_79 >= '\u000E' && LA8_79 <= '&')||(LA8_79 >= '(' && LA8_79 <= '[')||(LA8_79 >= ']' && LA8_79 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_79);

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA8_80 = input.LA(1);

                         
                        int index8_80 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_80=='\'') ) {s = 44;}

                        else if ( (LA8_80=='\\') ) {s = 42;}

                        else if ( ((LA8_80 >= '\u0000' && LA8_80 <= '\t')||(LA8_80 >= '\u000B' && LA8_80 <= '\f')||(LA8_80 >= '\u000E' && LA8_80 <= '&')||(LA8_80 >= '(' && LA8_80 <= '[')||(LA8_80 >= ']' && LA8_80 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_80);

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA8_44 = input.LA(1);

                         
                        int index8_44 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_44 >= '\u0000' && LA8_44 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 85;

                         
                        input.seek(index8_44);

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA8_65 = input.LA(1);

                         
                        int index8_65 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_65=='\"') ) {s = 40;}

                        else if ( (LA8_65=='\\') ) {s = 38;}

                        else if ( ((LA8_65 >= '\u0000' && LA8_65 <= '\t')||(LA8_65 >= '\u000B' && LA8_65 <= '\f')||(LA8_65 >= '\u000E' && LA8_65 <= '!')||(LA8_65 >= '#' && LA8_65 <= '[')||(LA8_65 >= ']' && LA8_65 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_65);

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA8_77 = input.LA(1);

                         
                        int index8_77 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_77=='\'') ) {s = 44;}

                        else if ( (LA8_77=='\\') ) {s = 42;}

                        else if ( ((LA8_77 >= '\u0000' && LA8_77 <= '\t')||(LA8_77 >= '\u000B' && LA8_77 <= '\f')||(LA8_77 >= '\u000E' && LA8_77 <= '&')||(LA8_77 >= '(' && LA8_77 <= '[')||(LA8_77 >= ']' && LA8_77 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_77);

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA8_66 = input.LA(1);

                         
                        int index8_66 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_66=='\"') ) {s = 40;}

                        else if ( (LA8_66=='\\') ) {s = 38;}

                        else if ( ((LA8_66 >= '\u0000' && LA8_66 <= '\t')||(LA8_66 >= '\u000B' && LA8_66 <= '\f')||(LA8_66 >= '\u000E' && LA8_66 <= '!')||(LA8_66 >= '#' && LA8_66 <= '[')||(LA8_66 >= ']' && LA8_66 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_66);

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA8_78 = input.LA(1);

                         
                        int index8_78 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_78=='\'') ) {s = 44;}

                        else if ( (LA8_78=='\\') ) {s = 42;}

                        else if ( ((LA8_78 >= '\u0000' && LA8_78 <= '\t')||(LA8_78 >= '\u000B' && LA8_78 <= '\f')||(LA8_78 >= '\u000E' && LA8_78 <= '&')||(LA8_78 >= '(' && LA8_78 <= '[')||(LA8_78 >= ']' && LA8_78 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_78);

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA8_76 = input.LA(1);

                         
                        int index8_76 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_76=='\'') ) {s = 44;}

                        else if ( (LA8_76=='\\') ) {s = 42;}

                        else if ( ((LA8_76 >= '\u0000' && LA8_76 <= '\t')||(LA8_76 >= '\u000B' && LA8_76 <= '\f')||(LA8_76 >= '\u000E' && LA8_76 <= '&')||(LA8_76 >= '(' && LA8_76 <= '[')||(LA8_76 >= ']' && LA8_76 <= '\uFFFF')) ) {s = 43;}

                        else s = 20;

                         
                        input.seek(index8_76);

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA8_39 = input.LA(1);

                         
                        int index8_39 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_39=='\"') ) {s = 40;}

                        else if ( (LA8_39=='\\') ) {s = 38;}

                        else if ( ((LA8_39 >= '\u0000' && LA8_39 <= '\t')||(LA8_39 >= '\u000B' && LA8_39 <= '\f')||(LA8_39 >= '\u000E' && LA8_39 <= '!')||(LA8_39 >= '#' && LA8_39 <= '[')||(LA8_39 >= ']' && LA8_39 <= '\uFFFF')) ) {s = 39;}

                        else s = 20;

                         
                        input.seek(index8_39);

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA8_14 = input.LA(1);

                         
                        int index8_14 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_14=='\\') ) {s = 38;}

                        else if ( ((LA8_14 >= '\u0000' && LA8_14 <= '\t')||(LA8_14 >= '\u000B' && LA8_14 <= '\f')||(LA8_14 >= '\u000E' && LA8_14 <= '!')||(LA8_14 >= '#' && LA8_14 <= '[')||(LA8_14 >= ']' && LA8_14 <= '\uFFFF')) ) {s = 39;}

                        else if ( (LA8_14=='\"') ) {s = 40;}

                        else s = 20;

                         
                        input.seek(index8_14);

                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA8_13 = input.LA(1);

                         
                        int index8_13 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_13 >= '\u0000' && LA8_13 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 37;

                         
                        input.seek(index8_13);

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA8_12 = input.LA(1);

                         
                        int index8_12 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_12 >= '\u0000' && LA8_12 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 36;

                         
                        input.seek(index8_12);

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA8_8 = input.LA(1);

                         
                        int index8_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_8=='}') ) {s = 32;}

                        else s = 20;

                         
                        input.seek(index8_8);

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA8_7 = input.LA(1);

                         
                        int index8_7 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_7=='}') ) {s = 30;}

                        else if ( ((LA8_7 >= '\u0000' && LA8_7 <= '|')||(LA8_7 >= '~' && LA8_7 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 31;

                         
                        input.seek(index8_7);

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA8_9 = input.LA(1);

                         
                        int index8_9 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_9=='}') ) {s = 33;}

                        else s = 20;

                         
                        input.seek(index8_9);

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA8_11 = input.LA(1);

                         
                        int index8_11 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_11 >= '\u0000' && LA8_11 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 35;

                         
                        input.seek(index8_11);

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA8_42 = input.LA(1);

                         
                        int index8_42 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_42=='n') ) {s = 76;}

                        else if ( (LA8_42=='r') ) {s = 77;}

                        else if ( (LA8_42=='t') ) {s = 78;}

                        else if ( (LA8_42=='b') ) {s = 79;}

                        else if ( (LA8_42=='f') ) {s = 80;}

                        else if ( (LA8_42=='\"') ) {s = 81;}

                        else if ( (LA8_42=='\'') ) {s = 82;}

                        else if ( (LA8_42=='/') ) {s = 83;}

                        else if ( (LA8_42=='\\') ) {s = 84;}

                        else s = 20;

                         
                        input.seek(index8_42);

                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA8_47 = input.LA(1);

                         
                        int index8_47 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 75;}

                         
                        input.seek(index8_47);

                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA8_41 = input.LA(1);

                         
                        int index8_41 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 75;}

                         
                        input.seek(index8_41);

                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA8_87 = input.LA(1);

                         
                        int index8_87 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 97;}

                         
                        input.seek(index8_87);

                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA8_45 = input.LA(1);

                         
                        int index8_45 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 86;}

                         
                        input.seek(index8_45);

                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA8_16 = input.LA(1);

                         
                        int index8_16 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_16 >= '0' && LA8_16 <= '9')) ) {s = 16;}

                        else if ( ((LA8_16 >= '\u0000' && LA8_16 <= '/')||(LA8_16 >= ':' && LA8_16 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 45;

                         
                        input.seek(index8_16);

                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA8_85 = input.LA(1);

                         
                        int index8_85 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 96;}

                         
                        input.seek(index8_85);

                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA8_10 = input.LA(1);

                         
                        int index8_10 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_10 >= '\u0000' && LA8_10 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 34;

                         
                        input.seek(index8_10);

                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA8_48 = input.LA(1);

                         
                        int index8_48 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 88;}

                         
                        input.seek(index8_48);

                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA8_28 = input.LA(1);

                         
                        int index8_28 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_28 >= '\u0000' && LA8_28 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 55;

                         
                        input.seek(index8_28);

                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA8_33 = input.LA(1);

                         
                        int index8_33 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_33 >= '\u0000' && LA8_33 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 60;

                         
                        input.seek(index8_33);

                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA8_32 = input.LA(1);

                         
                        int index8_32 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_32 >= '\u0000' && LA8_32 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 59;

                         
                        input.seek(index8_32);

                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA8_23 = input.LA(1);

                         
                        int index8_23 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((rawAhead())))) ) {s = 50;}

                        else if ( ((rawAhead())) ) {s = 20;}

                         
                        input.seek(index8_23);

                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA8_22 = input.LA(1);

                         
                        int index8_22 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((rawAhead())))) ) {s = 49;}

                        else if ( ((rawAhead())) ) {s = 20;}

                         
                        input.seek(index8_22);

                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA8_1 = input.LA(1);

                         
                        int index8_1 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_1 >= '\u0000' && LA8_1 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 21;

                         
                        input.seek(index8_1);

                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA8_38 = input.LA(1);

                         
                        int index8_38 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA8_38=='n') ) {s = 65;}

                        else if ( (LA8_38=='r') ) {s = 66;}

                        else if ( (LA8_38=='t') ) {s = 67;}

                        else if ( (LA8_38=='b') ) {s = 68;}

                        else if ( (LA8_38=='f') ) {s = 69;}

                        else if ( (LA8_38=='\"') ) {s = 70;}

                        else if ( (LA8_38=='\'') ) {s = 71;}

                        else if ( (LA8_38=='/') ) {s = 72;}

                        else if ( (LA8_38=='\\') ) {s = 73;}

                        else s = 20;

                         
                        input.seek(index8_38);

                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA8_60 = input.LA(1);

                         
                        int index8_60 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 94;}

                         
                        input.seek(index8_60);

                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA8_34 = input.LA(1);

                         
                        int index8_34 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 61;}

                         
                        input.seek(index8_34);

                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA8_27 = input.LA(1);

                         
                        int index8_27 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_27 >= '\u0000' && LA8_27 <= '\uFFFF')) && ((rawAhead()))) {s = 20;}

                        else s = 54;

                         
                        input.seek(index8_27);

                        if ( s>=0 ) return s;
                        break;

                    case 60 : 
                        int LA8_35 = input.LA(1);

                         
                        int index8_35 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 62;}

                         
                        input.seek(index8_35);

                        if ( s>=0 ) return s;
                        break;

                    case 61 : 
                        int LA8_29 = input.LA(1);

                         
                        int index8_29 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 56;}

                         
                        input.seek(index8_29);

                        if ( s>=0 ) return s;
                        break;

                    case 62 : 
                        int LA8_31 = input.LA(1);

                         
                        int index8_31 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 58;}

                         
                        input.seek(index8_31);

                        if ( s>=0 ) return s;
                        break;

                    case 63 : 
                        int LA8_36 = input.LA(1);

                         
                        int index8_36 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 63;}

                         
                        input.seek(index8_36);

                        if ( s>=0 ) return s;
                        break;

                    case 64 : 
                        int LA8_17 = input.LA(1);

                         
                        int index8_17 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA8_17 >= '0' && LA8_17 <= '9')||(LA8_17 >= 'A' && LA8_17 <= 'Z')||(LA8_17 >= 'a' && LA8_17 <= 'z')) ) {s = 46;}

                        else s = 20;

                         
                        input.seek(index8_17);

                        if ( s>=0 ) return s;
                        break;

                    case 65 : 
                        int LA8_37 = input.LA(1);

                         
                        int index8_37 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 64;}

                         
                        input.seek(index8_37);

                        if ( s>=0 ) return s;
                        break;

                    case 66 : 
                        int LA8_74 = input.LA(1);

                         
                        int index8_74 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 95;}

                         
                        input.seek(index8_74);

                        if ( s>=0 ) return s;
                        break;

                    case 67 : 
                        int LA8_24 = input.LA(1);

                         
                        int index8_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((rawAhead())))) ) {s = 51;}

                        else if ( ((rawAhead())) ) {s = 20;}

                         
                        input.seek(index8_24);

                        if ( s>=0 ) return s;
                        break;

                    case 68 : 
                        int LA8_25 = input.LA(1);

                         
                        int index8_25 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((rawAhead())))) ) {s = 52;}

                        else if ( ((rawAhead())) ) {s = 20;}

                         
                        input.seek(index8_25);

                        if ( s>=0 ) return s;
                        break;

                    case 69 : 
                        int LA8_53 = input.LA(1);

                         
                        int index8_53 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 89;}

                         
                        input.seek(index8_53);

                        if ( s>=0 ) return s;
                        break;

                    case 70 : 
                        int LA8_57 = input.LA(1);

                         
                        int index8_57 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 92;}

                         
                        input.seek(index8_57);

                        if ( s>=0 ) return s;
                        break;

                    case 71 : 
                        int LA8_54 = input.LA(1);

                         
                        int index8_54 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 90;}

                         
                        input.seek(index8_54);

                        if ( s>=0 ) return s;
                        break;

                    case 72 : 
                        int LA8_59 = input.LA(1);

                         
                        int index8_59 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 93;}

                         
                        input.seek(index8_59);

                        if ( s>=0 ) return s;
                        break;

                    case 73 : 
                        int LA8_55 = input.LA(1);

                         
                        int index8_55 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((rawAhead())) ) {s = 20;}

                        else if ( (true) ) {s = 91;}

                         
                        input.seek(index8_55);

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 8, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}