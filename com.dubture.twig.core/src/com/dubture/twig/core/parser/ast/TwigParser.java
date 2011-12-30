// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2011-12-30 23:04:24

  package com.dubture.twig.core.parser.ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "LETTER", "NUMBER", "TWIG_VAR", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "'('", "')'", "','"
    };

    public static final int EOF=-1;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int DIGIT=4;
    public static final int IDENT=5;
    public static final int LETTER=6;
    public static final int NUMBER=7;
    public static final int TWIG_VAR=8;
    public static final int T_CLOSE_PRINT=9;
    public static final int T_CLOSE_STMT=10;
    public static final int T_OPEN_PRINT=11;
    public static final int T_OPEN_STMT=12;
    public static final int WS=13;

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

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return TwigParser.tokenNames; }
    public String getGrammarFileName() { return "/Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g"; }


    public static class template_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "template"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:21:1: template : ( twig_print )* ;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.twig_print_return twig_print1 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:22:3: ( ( twig_print )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:22:5: ( twig_print )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:22:5: ( twig_print )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==T_OPEN_PRINT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:22:5: twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_template65);
            	    twig_print1=twig_print();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_print1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "template"


    public static class twig_print_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "twig_print"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:25:1: twig_print : T_OPEN_PRINT ^ ( expression )* T_CLOSE_PRINT ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_PRINT2=null;
        Token T_CLOSE_PRINT4=null;
        TwigParser.expression_return expression3 =null;


        CommonTree T_OPEN_PRINT2_tree=null;
        CommonTree T_CLOSE_PRINT4_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:26:3: ( T_OPEN_PRINT ^ ( expression )* T_CLOSE_PRINT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:26:5: T_OPEN_PRINT ^ ( expression )* T_CLOSE_PRINT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_PRINT2=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print82); 
            T_OPEN_PRINT2_tree = 
            (CommonTree)adaptor.create(T_OPEN_PRINT2)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_PRINT2_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:26:19: ( expression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT||LA2_0==NUMBER) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:26:20: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_print86);
            	    expression3=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression3.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            T_CLOSE_PRINT4=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print90); 
            T_CLOSE_PRINT4_tree = 
            (CommonTree)adaptor.create(T_CLOSE_PRINT4)
            ;
            adaptor.addChild(root_0, T_CLOSE_PRINT4_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "twig_print"


    public static class functionCallStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCallStatement"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:1: functionCallStatement : IDENT ^ '(' ! functionParameters ')' !;
    public final TwigParser.functionCallStatement_return functionCallStatement() throws RecognitionException {
        TwigParser.functionCallStatement_return retval = new TwigParser.functionCallStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token IDENT5=null;
        Token char_literal6=null;
        Token char_literal8=null;
        TwigParser.functionParameters_return functionParameters7 =null;


        CommonTree IDENT5_tree=null;
        CommonTree char_literal6_tree=null;
        CommonTree char_literal8_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:31:3: ( IDENT ^ '(' ! functionParameters ')' !)
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:31:5: IDENT ^ '(' ! functionParameters ')' !
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENT5=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionCallStatement109); 
            IDENT5_tree = 
            (CommonTree)adaptor.create(IDENT5)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT5_tree, root_0);


            char_literal6=(Token)match(input,14,FOLLOW_14_in_functionCallStatement112); 

            pushFollow(FOLLOW_functionParameters_in_functionCallStatement115);
            functionParameters7=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, functionParameters7.getTree());

            char_literal8=(Token)match(input,15,FOLLOW_15_in_functionCallStatement117); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionCallStatement"


    public static class functionParameters_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionParameters"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:1: functionParameters : expression ( ',' expression )* ;
    public final TwigParser.functionParameters_return functionParameters() throws RecognitionException {
        TwigParser.functionParameters_return retval = new TwigParser.functionParameters_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal10=null;
        TwigParser.expression_return expression9 =null;

        TwigParser.expression_return expression11 =null;


        CommonTree char_literal10_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:3: ( expression ( ',' expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:5: expression ( ',' expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_functionParameters133);
            expression9=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression9.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:16: ( ',' expression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:17: ',' expression
            	    {
            	    char_literal10=(Token)match(input,16,FOLLOW_16_in_functionParameters136); 
            	    char_literal10_tree = 
            	    (CommonTree)adaptor.create(char_literal10)
            	    ;
            	    adaptor.addChild(root_0, char_literal10_tree);


            	    pushFollow(FOLLOW_expression_in_functionParameters138);
            	    expression11=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression11.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionParameters"


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:1: expression : ( term | functionCallStatement );
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.term_return term12 =null;

        TwigParser.functionCallStatement_return functionCallStatement13 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:39:3: ( term | functionCallStatement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENT) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==14) ) {
                    alt4=2;
                }
                else if ( (LA4_1==IDENT||LA4_1==NUMBER||LA4_1==T_CLOSE_PRINT||(LA4_1 >= 15 && LA4_1 <= 16)) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA4_0==NUMBER) ) {
                alt4=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:39:5: term
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_term_in_expression160);
                    term12=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term12.getTree());

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:40:5: functionCallStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionCallStatement_in_expression166);
                    functionCallStatement13=functionCallStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCallStatement13.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class term_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:44:1: term : ( IDENT | NUMBER );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set14=null;

        CommonTree set14_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:45:3: ( IDENT | NUMBER )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set14=(Token)input.LT(1);

            if ( input.LA(1)==IDENT||input.LA(1)==NUMBER ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set14)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "term"

    // Delegated rules


 

    public static final BitSet FOLLOW_twig_print_in_template65 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print82 = new BitSet(new long[]{0x00000000000002A0L});
    public static final BitSet FOLLOW_expression_in_twig_print86 = new BitSet(new long[]{0x00000000000002A0L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_functionCallStatement109 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_functionCallStatement112 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement115 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_functionCallStatement117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters133 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_functionParameters136 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_expression_in_functionParameters138 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_term_in_expression160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression166 = new BitSet(new long[]{0x0000000000000002L});

}