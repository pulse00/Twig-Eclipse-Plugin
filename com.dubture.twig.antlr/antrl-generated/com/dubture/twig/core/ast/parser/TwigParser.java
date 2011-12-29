// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g 2011-12-29 21:16:07

  package com.dubture.twig.core.ast.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "INTEGER", "WS", "','", "'.'", "':'", "':='", "';'", "'='", "'Integer'", "'begin'", "'constant'", "'end'", "'program'", "'var'"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int IDENT=4;
    public static final int INTEGER=5;
    public static final int WS=6;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public TwigParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TwigParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return TwigParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g"; }



    // $ANTLR start "program"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:15:1: program : 'program' IDENT '=' ( constant | variable )* 'begin' 'end' IDENT '.' ;
    public final void program() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:16:3: ( 'program' IDENT '=' ( constant | variable )* 'begin' 'end' IDENT '.' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:16:5: 'program' IDENT '=' ( constant | variable )* 'begin' 'end' IDENT '.'
            {
            match(input,17,FOLLOW_17_in_program41); 

            match(input,IDENT,FOLLOW_IDENT_in_program43); 

            match(input,12,FOLLOW_12_in_program45); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:17:5: ( constant | variable )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==15) ) {
                    alt1=1;
                }
                else if ( (LA1_0==18) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:17:6: constant
            	    {
            	    pushFollow(FOLLOW_constant_in_program52);
            	    constant();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:17:17: variable
            	    {
            	    pushFollow(FOLLOW_variable_in_program56);
            	    variable();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match(input,14,FOLLOW_14_in_program64); 

            match(input,16,FOLLOW_16_in_program70); 

            match(input,IDENT,FOLLOW_IDENT_in_program72); 

            match(input,8,FOLLOW_8_in_program74); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "constant"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:22:1: constant : 'constant' IDENT ':' type ':=' expression ';' ;
    public final void constant() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:23:3: ( 'constant' IDENT ':' type ':=' expression ';' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:23:5: 'constant' IDENT ':' type ':=' expression ';'
            {
            match(input,15,FOLLOW_15_in_constant87); 

            match(input,IDENT,FOLLOW_IDENT_in_constant89); 

            match(input,9,FOLLOW_9_in_constant91); 

            pushFollow(FOLLOW_type_in_constant93);
            type();

            state._fsp--;


            match(input,10,FOLLOW_10_in_constant95); 

            pushFollow(FOLLOW_expression_in_constant97);
            expression();

            state._fsp--;


            match(input,11,FOLLOW_11_in_constant99); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "constant"



    // $ANTLR start "variable"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:26:1: variable : 'var' IDENT ( ',' IDENT )* ':' type ';' ;
    public final void variable() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:3: ( 'var' IDENT ( ',' IDENT )* ':' type ';' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:5: 'var' IDENT ( ',' IDENT )* ':' type ';'
            {
            match(input,18,FOLLOW_18_in_variable112); 

            match(input,IDENT,FOLLOW_IDENT_in_variable114); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:18: ( ',' IDENT )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==7) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:19: ',' IDENT
            	    {
            	    match(input,7,FOLLOW_7_in_variable118); 

            	    match(input,IDENT,FOLLOW_IDENT_in_variable120); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,9,FOLLOW_9_in_variable124); 

            pushFollow(FOLLOW_type_in_variable126);
            type();

            state._fsp--;


            match(input,11,FOLLOW_11_in_variable128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "variable"



    // $ANTLR start "type"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:30:1: type : 'Integer' ;
    public final void type() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:31:3: ( 'Integer' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:31:5: 'Integer'
            {
            match(input,13,FOLLOW_13_in_type145); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "type"



    // $ANTLR start "expression"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:34:1: expression : INTEGER ;
    public final void expression() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:35:3: ( INTEGER )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:35:5: INTEGER
            {
            match(input,INTEGER,FOLLOW_INTEGER_in_expression160); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "expression"

    // Delegated rules


 

    public static final BitSet FOLLOW_17_in_program41 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program43 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_program45 = new BitSet(new long[]{0x000000000004C000L});
    public static final BitSet FOLLOW_constant_in_program52 = new BitSet(new long[]{0x000000000004C000L});
    public static final BitSet FOLLOW_variable_in_program56 = new BitSet(new long[]{0x000000000004C000L});
    public static final BitSet FOLLOW_14_in_program64 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_program70 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program72 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_program74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_constant87 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_constant89 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_constant91 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_type_in_constant93 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_constant95 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_constant97 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_constant99 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_variable112 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_variable114 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_7_in_variable118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_variable120 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_9_in_variable124 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_type_in_variable126 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_variable128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_type145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_expression160 = new BitSet(new long[]{0x0000000000000002L});

}