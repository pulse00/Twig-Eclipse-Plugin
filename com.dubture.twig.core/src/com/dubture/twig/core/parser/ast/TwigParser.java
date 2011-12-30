// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2011-12-31 00:44:01

  package com.dubture.twig.core.parser.ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COLON", "DIGIT", "IDENT", "LETTER", "NUMBER", "PUNCTUATION", "TWIG_VAR", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','"
    };

    public static final int EOF=-1;
    public static final int T__20=20;
    public static final int COLON=4;
    public static final int DIGIT=5;
    public static final int IDENT=6;
    public static final int LETTER=7;
    public static final int NUMBER=8;
    public static final int PUNCTUATION=9;
    public static final int TWIG_VAR=10;
    public static final int T_CLOSE_CURLY=11;
    public static final int T_CLOSE_PAREN=12;
    public static final int T_CLOSE_PRINT=13;
    public static final int T_CLOSE_STMT=14;
    public static final int T_OPEN_CURLY=15;
    public static final int T_OPEN_PAREN=16;
    public static final int T_OPEN_PRINT=17;
    public static final int T_OPEN_STMT=18;
    public static final int WS=19;

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

                if ( (LA2_0==IDENT||LA2_0==NUMBER||LA2_0==T_OPEN_CURLY) ) {
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:1: functionCallStatement : IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN ;
    public final TwigParser.functionCallStatement_return functionCallStatement() throws RecognitionException {
        TwigParser.functionCallStatement_return retval = new TwigParser.functionCallStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token IDENT5=null;
        Token T_OPEN_PAREN6=null;
        Token T_CLOSE_PAREN8=null;
        TwigParser.functionParameters_return functionParameters7 =null;


        CommonTree IDENT5_tree=null;
        CommonTree T_OPEN_PAREN6_tree=null;
        CommonTree T_CLOSE_PAREN8_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:31:3: ( IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:31:5: IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENT5=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionCallStatement109); 
            IDENT5_tree = 
            (CommonTree)adaptor.create(IDENT5)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT5_tree, root_0);


            T_OPEN_PAREN6=(Token)match(input,T_OPEN_PAREN,FOLLOW_T_OPEN_PAREN_in_functionCallStatement112); 

            pushFollow(FOLLOW_functionParameters_in_functionCallStatement115);
            functionParameters7=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, functionParameters7.getTree());

            T_CLOSE_PAREN8=(Token)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_functionCallStatement117); 
            T_CLOSE_PAREN8_tree = 
            (CommonTree)adaptor.create(T_CLOSE_PAREN8)
            ;
            adaptor.addChild(root_0, T_CLOSE_PAREN8_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:1: functionParameters : expression ( ',' ! expression )* ;
    public final TwigParser.functionParameters_return functionParameters() throws RecognitionException {
        TwigParser.functionParameters_return retval = new TwigParser.functionParameters_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal10=null;
        TwigParser.expression_return expression9 =null;

        TwigParser.expression_return expression11 =null;


        CommonTree char_literal10_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:3: ( expression ( ',' ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:5: expression ( ',' ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_functionParameters132);
            expression9=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression9.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:16: ( ',' ! expression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:17: ',' ! expression
            	    {
            	    char_literal10=(Token)match(input,20,FOLLOW_20_in_functionParameters135); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:1: expression : ( term | functionCallStatement | hash );
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.term_return term12 =null;

        TwigParser.functionCallStatement_return functionCallStatement13 =null;

        TwigParser.hash_return hash14 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:39:3: ( term | functionCallStatement | hash )
            int alt4=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==T_OPEN_PAREN) ) {
                    alt4=2;
                }
                else if ( (LA4_1==COLON||LA4_1==IDENT||LA4_1==NUMBER||(LA4_1 >= T_CLOSE_CURLY && LA4_1 <= T_CLOSE_PRINT)||LA4_1==T_OPEN_CURLY||LA4_1==20) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                alt4=1;
                }
                break;
            case T_OPEN_CURLY:
                {
                alt4=3;
                }
                break;
            default:
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
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:41:5: hash
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_hash_in_expression172);
                    hash14=hash();

                    state._fsp--;

                    adaptor.addChild(root_0, hash14.getTree());

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


    public static class hash_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hash"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:44:1: hash : T_OPEN_CURLY ^ ( hash_body )* T_CLOSE_CURLY ;
    public final TwigParser.hash_return hash() throws RecognitionException {
        TwigParser.hash_return retval = new TwigParser.hash_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_CURLY15=null;
        Token T_CLOSE_CURLY17=null;
        TwigParser.hash_body_return hash_body16 =null;


        CommonTree T_OPEN_CURLY15_tree=null;
        CommonTree T_CLOSE_CURLY17_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:45:3: ( T_OPEN_CURLY ^ ( hash_body )* T_CLOSE_CURLY )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:45:5: T_OPEN_CURLY ^ ( hash_body )* T_CLOSE_CURLY
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_CURLY15=(Token)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash187); 
            T_OPEN_CURLY15_tree = 
            (CommonTree)adaptor.create(T_OPEN_CURLY15)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_CURLY15_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:45:19: ( hash_body )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT||LA5_0==NUMBER||LA5_0==T_OPEN_CURLY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:45:19: hash_body
            	    {
            	    pushFollow(FOLLOW_hash_body_in_hash190);
            	    hash_body16=hash_body();

            	    state._fsp--;

            	    adaptor.addChild(root_0, hash_body16.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            T_CLOSE_CURLY17=(Token)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash193); 
            T_CLOSE_CURLY17_tree = 
            (CommonTree)adaptor.create(T_CLOSE_CURLY17)
            ;
            adaptor.addChild(root_0, T_CLOSE_CURLY17_tree);


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
    // $ANTLR end "hash"


    public static class hash_body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hash_body"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:1: hash_body : expression ( COLON expression ) ;
    public final TwigParser.hash_body_return hash_body() throws RecognitionException {
        TwigParser.hash_body_return retval = new TwigParser.hash_body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COLON19=null;
        TwigParser.expression_return expression18 =null;

        TwigParser.expression_return expression20 =null;


        CommonTree COLON19_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:49:3: ( expression ( COLON expression ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:49:5: expression ( COLON expression )
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_hash_body209);
            expression18=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression18.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:49:16: ( COLON expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:49:17: COLON expression
            {
            COLON19=(Token)match(input,COLON,FOLLOW_COLON_in_hash_body212); 
            COLON19_tree = 
            (CommonTree)adaptor.create(COLON19)
            ;
            adaptor.addChild(root_0, COLON19_tree);


            pushFollow(FOLLOW_expression_in_hash_body214);
            expression20=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression20.getTree());

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
    // $ANTLR end "hash_body"


    public static class term_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:1: term : ( IDENT | NUMBER );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set21=null;

        CommonTree set21_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:53:3: ( IDENT | NUMBER )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set21=(Token)input.LT(1);

            if ( input.LA(1)==IDENT||input.LA(1)==NUMBER ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set21)
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


 

    public static final BitSet FOLLOW_twig_print_in_template65 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print82 = new BitSet(new long[]{0x000000000000A140L});
    public static final BitSet FOLLOW_expression_in_twig_print86 = new BitSet(new long[]{0x000000000000A140L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_functionCallStatement109 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_T_OPEN_PAREN_in_functionCallStatement112 = new BitSet(new long[]{0x0000000000008140L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement115 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_functionCallStatement117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters132 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_functionParameters135 = new BitSet(new long[]{0x0000000000008140L});
    public static final BitSet FOLLOW_expression_in_functionParameters138 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_term_in_expression160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash187 = new BitSet(new long[]{0x0000000000008940L});
    public static final BitSet FOLLOW_hash_body_in_hash190 = new BitSet(new long[]{0x0000000000008940L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_hash_body209 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COLON_in_hash_body212 = new BitSet(new long[]{0x0000000000008140L});
    public static final BitSet FOLLOW_expression_in_hash_body214 = new BitSet(new long[]{0x0000000000000002L});

}