// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g 2011-12-29 21:39:40

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:15:1: program : 'program' IDENT '=' ( constant | variable )* 'begin' ( statement )* 'end' IDENT '.' ;
    public final void program() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:16:3: ( 'program' IDENT '=' ( constant | variable )* 'begin' ( statement )* 'end' IDENT '.' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:16:5: 'program' IDENT '=' ( constant | variable )* 'begin' ( statement )* 'end' IDENT '.'
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

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:19:5: ( statement )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:19:5: statement
            	    {
            	    pushFollow(FOLLOW_statement_in_program70);
            	    statement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,16,FOLLOW_16_in_program77); 

            match(input,IDENT,FOLLOW_IDENT_in_program79); 

            match(input,8,FOLLOW_8_in_program81); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:23:1: constant : 'constant' IDENT ':' type ':=' expression ';' ;
    public final void constant() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:24:3: ( 'constant' IDENT ':' type ':=' expression ';' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:24:5: 'constant' IDENT ':' type ':=' expression ';'
            {
            match(input,15,FOLLOW_15_in_constant94); 

            match(input,IDENT,FOLLOW_IDENT_in_constant96); 

            match(input,9,FOLLOW_9_in_constant98); 

            pushFollow(FOLLOW_type_in_constant100);
            type();

            state._fsp--;


            match(input,10,FOLLOW_10_in_constant102); 

            pushFollow(FOLLOW_expression_in_constant104);
            expression();

            state._fsp--;


            match(input,11,FOLLOW_11_in_constant106); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:1: variable : 'var' IDENT ( ',' IDENT )* ':' type ';' ;
    public final void variable() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:28:3: ( 'var' IDENT ( ',' IDENT )* ':' type ';' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:28:5: 'var' IDENT ( ',' IDENT )* ':' type ';'
            {
            match(input,18,FOLLOW_18_in_variable119); 

            match(input,IDENT,FOLLOW_IDENT_in_variable121); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:28:18: ( ',' IDENT )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==7) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:28:19: ',' IDENT
            	    {
            	    match(input,7,FOLLOW_7_in_variable125); 

            	    match(input,IDENT,FOLLOW_IDENT_in_variable127); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,9,FOLLOW_9_in_variable131); 

            pushFollow(FOLLOW_type_in_variable133);
            type();

            state._fsp--;


            match(input,11,FOLLOW_11_in_variable135); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:31:1: type : 'Integer' ;
    public final void type() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:32:3: ( 'Integer' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:32:5: 'Integer'
            {
            match(input,13,FOLLOW_13_in_type152); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:35:1: expression : INTEGER ;
    public final void expression() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:36:3: ( INTEGER )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:36:5: INTEGER
            {
            match(input,INTEGER,FOLLOW_INTEGER_in_expression167); 

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



    // $ANTLR start "statement"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:39:1: statement : assignment ;
    public final void statement() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:40:3: ( assignment )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:40:5: assignment
            {
            pushFollow(FOLLOW_assignment_in_statement181);
            assignment();

            state._fsp--;


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
    // $ANTLR end "statement"



    // $ANTLR start "assignment"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:43:1: assignment : IDENT ':=' expression ';' ;
    public final void assignment() throws RecognitionException {
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:44:3: ( IDENT ':=' expression ';' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:44:5: IDENT ':=' expression ';'
            {
            match(input,IDENT,FOLLOW_IDENT_in_assignment196); 

            match(input,10,FOLLOW_10_in_assignment198); 

            pushFollow(FOLLOW_expression_in_assignment200);
            expression();

            state._fsp--;


            match(input,11,FOLLOW_11_in_assignment202); 

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
    // $ANTLR end "assignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_17_in_program41 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program43 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_program45 = new BitSet(new long[]{0x000000000004C000L});
    public static final BitSet FOLLOW_constant_in_program52 = new BitSet(new long[]{0x000000000004C000L});
    public static final BitSet FOLLOW_variable_in_program56 = new BitSet(new long[]{0x000000000004C000L});
    public static final BitSet FOLLOW_14_in_program64 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_statement_in_program70 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_16_in_program77 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program79 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_program81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_constant94 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_constant96 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_constant98 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_type_in_constant100 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_constant102 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_constant104 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_constant106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_variable119 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_variable121 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_7_in_variable125 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_variable127 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_9_in_variable131 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_type_in_variable133 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_variable135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_type152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_expression167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignment_in_statement181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assignment196 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_assignment198 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_assignment200 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_assignment202 = new BitSet(new long[]{0x0000000000000002L});

}