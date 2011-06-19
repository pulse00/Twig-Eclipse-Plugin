// $ANTLR 3.3 Nov 30, 2010 12:45:30 TwigLexer.g 2011-06-19 19:07:07

package org.eclipse.twig.core.compiler.ast.parser;

import org.eclipse.twig.core.compiler.ast.parser.error.IErrorReporter;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TwigLexer extends Lexer {
    public static final int EOF=-1;
    public static final int PRINT_OPEN=4;
    public static final int PRINT_CLOSE=5;
    public static final int STMT_OPEN=6;
    public static final int STMT_CLOSE=7;
    public static final int METHOD_START=8;
    public static final int METHOD_END=9;
    public static final int ASIG=10;
    public static final int PIPE=11;
    public static final int DOT=12;
    public static final int COMMA=13;
    public static final int BSLASH=14;
    public static final int JSON_START=15;
    public static final int JSON_END=16;
    public static final int STRING_CHAR=17;
    public static final int STRING=18;
    public static final int NONCONTROL_CHAR=19;
    public static final int STRING_LITERAL=20;
    public static final int LOWER=21;
    public static final int UPPER=22;
    public static final int DIGIT=23;
    public static final int UNDER=24;
    public static final int LETTER=25;
    public static final int SYMBOL=26;
    public static final int WHITESPACE=27;


        private IErrorReporter errorReporter = null;

        public TwigLexer(CharStream input, IErrorReporter errorReporter) {
            this(input, new RecognizerSharedState());
            this.errorReporter = errorReporter;
        }
        
    	public void displayRecognitionError(String[] tokenNames,
                                            RecognitionException e) {
            
    		String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);        
            errorReporter.reportError(hdr,msg,e);
            
        }    
            
        public void setErrorReporter(IErrorReporter errorReporter) {
            this.errorReporter = errorReporter;
        }
        
    	protected Object recoverFromMismatchedToken(IntStream input,
    				int ttype, BitSet follow) throws RecognitionException
    	{   
    	    throw new MismatchedTokenException(ttype, input);
    	}       
    	
        public Object recoverFromMismatchedSet(IntStream input,
        			RecognitionException e, BitSet follow) throws RecognitionException 
        { 
    		throw new MismatchedSetException(follow, input);
       	}
    	


    // delegates
    // delegators

    public TwigLexer() {;} 
    public TwigLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TwigLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "TwigLexer.g"; }

    // $ANTLR start "PRINT_OPEN"
    public final void mPRINT_OPEN() throws RecognitionException {
        try {
            int _type = PRINT_OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:51:13: ( '{{' )
            // TwigLexer.g:51:15: '{{'
            {
            match("{{"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRINT_OPEN"

    // $ANTLR start "PRINT_CLOSE"
    public final void mPRINT_CLOSE() throws RecognitionException {
        try {
            int _type = PRINT_CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:52:14: ( '}}' )
            // TwigLexer.g:52:16: '}}'
            {
            match("}}"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRINT_CLOSE"

    // $ANTLR start "STMT_OPEN"
    public final void mSTMT_OPEN() throws RecognitionException {
        try {
            int _type = STMT_OPEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:53:12: ( '{%' )
            // TwigLexer.g:53:14: '{%'
            {
            match("{%"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STMT_OPEN"

    // $ANTLR start "STMT_CLOSE"
    public final void mSTMT_CLOSE() throws RecognitionException {
        try {
            int _type = STMT_CLOSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:54:13: ( '%}' )
            // TwigLexer.g:54:15: '%}'
            {
            match("%}"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STMT_CLOSE"

    // $ANTLR start "METHOD_START"
    public final void mMETHOD_START() throws RecognitionException {
        try {
            int _type = METHOD_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:55:14: ( '(' )
            // TwigLexer.g:55:16: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "METHOD_START"

    // $ANTLR start "METHOD_END"
    public final void mMETHOD_END() throws RecognitionException {
        try {
            int _type = METHOD_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:56:13: ( ')' )
            // TwigLexer.g:56:15: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "METHOD_END"

    // $ANTLR start "ASIG"
    public final void mASIG() throws RecognitionException {
        try {
            int _type = ASIG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:57:9: ( '=' )
            // TwigLexer.g:57:11: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ASIG"

    // $ANTLR start "PIPE"
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:58:9: ( '|' )
            // TwigLexer.g:58:11: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PIPE"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:59:8: ( '.' )
            // TwigLexer.g:59:10: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:60:9: ( ( ( ' ' )* ',' ( ' ' )* ) )
            // TwigLexer.g:60:11: ( ( ' ' )* ',' ( ' ' )* )
            {
            // TwigLexer.g:60:11: ( ( ' ' )* ',' ( ' ' )* )
            // TwigLexer.g:60:13: ( ' ' )* ',' ( ' ' )*
            {
            // TwigLexer.g:60:13: ( ' ' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // TwigLexer.g:60:13: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(','); 
            // TwigLexer.g:60:22: ( ' ' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // TwigLexer.g:60:22: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "BSLASH"
    public final void mBSLASH() throws RecognitionException {
        try {
            int _type = BSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:61:10: ( '\\\\' )
            // TwigLexer.g:61:12: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BSLASH"

    // $ANTLR start "JSON_START"
    public final void mJSON_START() throws RecognitionException {
        try {
            int _type = JSON_START;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:62:14: ( '{' )
            // TwigLexer.g:62:16: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "JSON_START"

    // $ANTLR start "JSON_END"
    public final void mJSON_END() throws RecognitionException {
        try {
            int _type = JSON_END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:63:11: ( '}' )
            // TwigLexer.g:63:13: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "JSON_END"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:68:8: ( ( STRING_CHAR )+ )
            // TwigLexer.g:68:10: ( STRING_CHAR )+
            {
            // TwigLexer.g:68:10: ( STRING_CHAR )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // TwigLexer.g:68:10: STRING_CHAR
            	    {
            	    mSTRING_CHAR(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:72:1: ( '\"' ( NONCONTROL_CHAR )* '\"' | '\\'' ( NONCONTROL_CHAR )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // TwigLexer.g:72:3: '\"' ( NONCONTROL_CHAR )* '\"'
                    {
                    match('\"'); 
                    // TwigLexer.g:72:7: ( NONCONTROL_CHAR )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='-'||(LA4_0>='/' && LA4_0<=':')||LA4_0=='<'||LA4_0=='>'||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // TwigLexer.g:72:7: NONCONTROL_CHAR
                    	    {
                    	    mNONCONTROL_CHAR(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // TwigLexer.g:73:3: '\\'' ( NONCONTROL_CHAR )* '\\''
                    {
                    match('\''); 
                    // TwigLexer.g:73:8: ( NONCONTROL_CHAR )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='-'||(LA5_0>='/' && LA5_0<=':')||LA5_0=='<'||LA5_0=='>'||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // TwigLexer.g:73:8: NONCONTROL_CHAR
                    	    {
                    	    mNONCONTROL_CHAR(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "STRING_CHAR"
    public final void mSTRING_CHAR() throws RecognitionException {
        try {
            // TwigLexer.g:76:23: ( LOWER | UPPER | DIGIT | UNDER )
            // TwigLexer.g:
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "STRING_CHAR"

    // $ANTLR start "NONCONTROL_CHAR"
    public final void mNONCONTROL_CHAR() throws RecognitionException {
        try {
            // TwigLexer.g:77:25: ( LETTER | DIGIT | SYMBOL )
            // TwigLexer.g:
            {
            if ( input.LA(1)=='-'||(input.LA(1)>='/' && input.LA(1)<=':')||input.LA(1)=='<'||input.LA(1)=='>'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NONCONTROL_CHAR"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // TwigLexer.g:78:17: ( LOWER | UPPER )
            // TwigLexer.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "LOWER"
    public final void mLOWER() throws RecognitionException {
        try {
            // TwigLexer.g:79:16: ( 'a' .. 'z' )
            // TwigLexer.g:79:18: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "LOWER"

    // $ANTLR start "UPPER"
    public final void mUPPER() throws RecognitionException {
        try {
            // TwigLexer.g:80:16: ( 'A' .. 'Z' )
            // TwigLexer.g:80:18: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UPPER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // TwigLexer.g:81:16: ( '0' .. '9' )
            // TwigLexer.g:81:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "UNDER"
    public final void mUNDER() throws RecognitionException {
        try {
            // TwigLexer.g:82:16: ( '_' )
            // TwigLexer.g:82:18: '_'
            {
            match('_'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UNDER"

    // $ANTLR start "SYMBOL"
    public final void mSYMBOL() throws RecognitionException {
        try {
            // TwigLexer.g:83:16: ( UNDER | '-' | '/' | ':' | '<' | '>' )
            // TwigLexer.g:
            {
            if ( input.LA(1)=='-'||input.LA(1)=='/'||input.LA(1)==':'||input.LA(1)=='<'||input.LA(1)=='>'||input.LA(1)=='_' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SYMBOL"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // TwigLexer.g:85:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // TwigLexer.g:85:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // TwigLexer.g:85:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||(LA7_0>='\f' && LA7_0<='\r')||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // TwigLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // TwigLexer.g:1:8: ( PRINT_OPEN | PRINT_CLOSE | STMT_OPEN | STMT_CLOSE | METHOD_START | METHOD_END | ASIG | PIPE | DOT | COMMA | BSLASH | JSON_START | JSON_END | STRING | STRING_LITERAL | WHITESPACE )
        int alt8=16;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // TwigLexer.g:1:10: PRINT_OPEN
                {
                mPRINT_OPEN(); 

                }
                break;
            case 2 :
                // TwigLexer.g:1:21: PRINT_CLOSE
                {
                mPRINT_CLOSE(); 

                }
                break;
            case 3 :
                // TwigLexer.g:1:33: STMT_OPEN
                {
                mSTMT_OPEN(); 

                }
                break;
            case 4 :
                // TwigLexer.g:1:43: STMT_CLOSE
                {
                mSTMT_CLOSE(); 

                }
                break;
            case 5 :
                // TwigLexer.g:1:54: METHOD_START
                {
                mMETHOD_START(); 

                }
                break;
            case 6 :
                // TwigLexer.g:1:67: METHOD_END
                {
                mMETHOD_END(); 

                }
                break;
            case 7 :
                // TwigLexer.g:1:78: ASIG
                {
                mASIG(); 

                }
                break;
            case 8 :
                // TwigLexer.g:1:83: PIPE
                {
                mPIPE(); 

                }
                break;
            case 9 :
                // TwigLexer.g:1:88: DOT
                {
                mDOT(); 

                }
                break;
            case 10 :
                // TwigLexer.g:1:92: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 11 :
                // TwigLexer.g:1:98: BSLASH
                {
                mBSLASH(); 

                }
                break;
            case 12 :
                // TwigLexer.g:1:105: JSON_START
                {
                mJSON_START(); 

                }
                break;
            case 13 :
                // TwigLexer.g:1:116: JSON_END
                {
                mJSON_END(); 

                }
                break;
            case 14 :
                // TwigLexer.g:1:125: STRING
                {
                mSTRING(); 

                }
                break;
            case 15 :
                // TwigLexer.g:1:132: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 16 :
                // TwigLexer.g:1:147: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\1\uffff\1\21\1\23\6\uffff\1\16\12\uffff";
    static final String DFA8_eofS =
        "\24\uffff";
    static final String DFA8_minS =
        "\1\11\1\45\1\175\6\uffff\1\40\12\uffff";
    static final String DFA8_maxS =
        "\1\175\1\173\1\175\6\uffff\1\54\12\uffff";
    static final String DFA8_acceptS =
        "\3\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\12\1\13\1\16\1\17\1"+
        "\20\1\1\1\3\1\14\1\2\1\15";
    static final String DFA8_specialS =
        "\24\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\16\1\uffff\2\16\22\uffff\1\11\1\uffff\1\15\2\uffff\1\3\1"+
            "\uffff\1\15\1\4\1\5\2\uffff\1\12\1\uffff\1\10\1\uffff\12\14"+
            "\3\uffff\1\6\3\uffff\32\14\1\uffff\1\13\2\uffff\1\14\1\uffff"+
            "\32\14\1\1\1\7\1\2",
            "\1\20\125\uffff\1\17",
            "\1\22",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11\13\uffff\1\12",
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
            return "1:1: Tokens : ( PRINT_OPEN | PRINT_CLOSE | STMT_OPEN | STMT_CLOSE | METHOD_START | METHOD_END | ASIG | PIPE | DOT | COMMA | BSLASH | JSON_START | JSON_END | STRING | STRING_LITERAL | WHITESPACE );";
        }
    }
 

}