// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2012-01-01 13:11:36

  package com.dubture.twig.core.parser.ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "BUFFER", "COLON", "DIGIT", "DOT", "ESC", "IDENT", "LETTER", "NUMBER", "PUNCTUATION", "STRING", "TWIG_VAR", "T_CLOSE_CMT", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','", "'['", "']'", "'|'", "'~'"
    };

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:27:1: template : template_body ^ EOF !;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF2=null;
        TwigParser.template_body_return template_body1 =null;


        CommonTree EOF2_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:28:3: ( template_body ^ EOF !)
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:28:5: template_body ^ EOF !
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_template_body_in_template84);
            template_body1=template_body();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(template_body1.getTree(), root_0);

            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_template87); 

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


    public static class template_body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "template_body"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:31:1: template_body : ( twig_print | twig_block )* ;
    public final TwigParser.template_body_return template_body() throws RecognitionException {
        TwigParser.template_body_return retval = new TwigParser.template_body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.twig_print_return twig_print3 =null;

        TwigParser.twig_block_return twig_block4 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:32:3: ( ( twig_print | twig_block )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:32:5: ( twig_print | twig_block )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:32:5: ( twig_print | twig_block )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==T_OPEN_PRINT) ) {
                    alt1=1;
                }
                else if ( (LA1_0==T_OPEN_STMT) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:32:7: twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_template_body107);
            	    twig_print3=twig_print();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_print3.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:32:20: twig_block
            	    {
            	    pushFollow(FOLLOW_twig_block_in_template_body111);
            	    twig_block4=twig_block();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_block4.getTree());

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
    // $ANTLR end "template_body"


    public static class twig_print_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "twig_print"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:35:1: twig_print : T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_PRINT5=null;
        Token T_CLOSE_PRINT7=null;
        TwigParser.body_return body6 =null;


        CommonTree T_OPEN_PRINT5_tree=null;
        CommonTree T_CLOSE_PRINT7_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:3: ( T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:5: T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_PRINT5=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print135); 
            T_OPEN_PRINT5_tree = 
            (CommonTree)adaptor.create(T_OPEN_PRINT5)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_PRINT5_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:19: ( body )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==DOT||LA2_0==IDENT||LA2_0==NUMBER||LA2_0==STRING||LA2_0==T_OPEN_CURLY||LA2_0==29) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:19: body
                    {
                    pushFollow(FOLLOW_body_in_twig_print138);
                    body6=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body6.getTree());

                    }
                    break;

            }


            T_CLOSE_PRINT7=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print141); 
            T_CLOSE_PRINT7_tree = 
            (CommonTree)adaptor.create(T_CLOSE_PRINT7)
            ;
            adaptor.addChild(root_0, T_CLOSE_PRINT7_tree);


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


    public static class twig_block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "twig_block"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:41:1: twig_block : T_OPEN_STMT ^ IDENT ( body )? T_CLOSE_STMT ;
    public final TwigParser.twig_block_return twig_block() throws RecognitionException {
        TwigParser.twig_block_return retval = new TwigParser.twig_block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_STMT8=null;
        Token IDENT9=null;
        Token T_CLOSE_STMT11=null;
        TwigParser.body_return body10 =null;


        CommonTree T_OPEN_STMT8_tree=null;
        CommonTree IDENT9_tree=null;
        CommonTree T_CLOSE_STMT11_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:42:3: ( T_OPEN_STMT ^ IDENT ( body )? T_CLOSE_STMT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:42:5: T_OPEN_STMT ^ IDENT ( body )? T_CLOSE_STMT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_STMT8=(Token)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block156); 
            T_OPEN_STMT8_tree = 
            (CommonTree)adaptor.create(T_OPEN_STMT8)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_STMT8_tree, root_0);


            IDENT9=(Token)match(input,IDENT,FOLLOW_IDENT_in_twig_block159); 
            IDENT9_tree = 
            (CommonTree)adaptor.create(IDENT9)
            ;
            adaptor.addChild(root_0, IDENT9_tree);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:42:24: ( body )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DOT||LA3_0==IDENT||LA3_0==NUMBER||LA3_0==STRING||LA3_0==T_OPEN_CURLY||LA3_0==29) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:42:24: body
                    {
                    pushFollow(FOLLOW_body_in_twig_block161);
                    body10=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body10.getTree());

                    }
                    break;

            }


            T_CLOSE_STMT11=(Token)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block164); 
            T_CLOSE_STMT11_tree = 
            (CommonTree)adaptor.create(T_CLOSE_STMT11)
            ;
            adaptor.addChild(root_0, T_CLOSE_STMT11_tree);


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
    // $ANTLR end "twig_block"


    public static class body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "body"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:45:1: body : expression ( ( ( '|' | ',' | '~' )? ) ! expression )* ;
    public final TwigParser.body_return body() throws RecognitionException {
        TwigParser.body_return retval = new TwigParser.body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set13=null;
        TwigParser.expression_return expression12 =null;

        TwigParser.expression_return expression14 =null;


        CommonTree set13_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:46:3: ( expression ( ( ( '|' | ',' | '~' )? ) ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:46:5: expression ( ( ( '|' | ',' | '~' )? ) ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_body179);
            expression12=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression12.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:46:16: ( ( ( '|' | ',' | '~' )? ) ! expression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==DOT||LA5_0==IDENT||LA5_0==NUMBER||LA5_0==STRING||LA5_0==T_OPEN_CURLY||(LA5_0 >= 28 && LA5_0 <= 29)||(LA5_0 >= 31 && LA5_0 <= 32)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:46:18: ( ( '|' | ',' | '~' )? ) ! expression
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:46:18: ( ( '|' | ',' | '~' )? )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:46:19: ( '|' | ',' | '~' )?
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:46:19: ( '|' | ',' | '~' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==28||(LA4_0 >= 31 && LA4_0 <= 32)) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            	            {
            	            set13=(Token)input.LT(1);

            	            if ( input.LA(1)==28||(input.LA(1) >= 31 && input.LA(1) <= 32) ) {
            	                input.consume();
            	                adaptor.addChild(root_0, 
            	                (CommonTree)adaptor.create(set13)
            	                );
            	                state.errorRecovery=false;
            	            }
            	            else {
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                throw mse;
            	            }


            	            }
            	            break;

            	    }


            	    }


            	    pushFollow(FOLLOW_expression_in_body199);
            	    expression14=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression14.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
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
    // $ANTLR end "body"


    public static class functionCallStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCallStatement"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:49:1: functionCallStatement : IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN ;
    public final TwigParser.functionCallStatement_return functionCallStatement() throws RecognitionException {
        TwigParser.functionCallStatement_return retval = new TwigParser.functionCallStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token IDENT15=null;
        Token T_OPEN_PAREN16=null;
        Token T_CLOSE_PAREN18=null;
        TwigParser.functionParameters_return functionParameters17 =null;


        CommonTree IDENT15_tree=null;
        CommonTree T_OPEN_PAREN16_tree=null;
        CommonTree T_CLOSE_PAREN18_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:3: ( IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:5: IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionCallStatement223); 
            IDENT15_tree = 
            (CommonTree)adaptor.create(IDENT15)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT15_tree, root_0);


            T_OPEN_PAREN16=(Token)match(input,T_OPEN_PAREN,FOLLOW_T_OPEN_PAREN_in_functionCallStatement226); 

            pushFollow(FOLLOW_functionParameters_in_functionCallStatement229);
            functionParameters17=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, functionParameters17.getTree());

            T_CLOSE_PAREN18=(Token)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_functionCallStatement231); 
            T_CLOSE_PAREN18_tree = 
            (CommonTree)adaptor.create(T_CLOSE_PAREN18)
            ;
            adaptor.addChild(root_0, T_CLOSE_PAREN18_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:55:1: functionParameters : expression ( ',' ! expression )* ;
    public final TwigParser.functionParameters_return functionParameters() throws RecognitionException {
        TwigParser.functionParameters_return retval = new TwigParser.functionParameters_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal20=null;
        TwigParser.expression_return expression19 =null;

        TwigParser.expression_return expression21 =null;


        CommonTree char_literal20_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:3: ( expression ( ',' ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:5: expression ( ',' ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_functionParameters246);
            expression19=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression19.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:16: ( ',' ! expression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==28) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:17: ',' ! expression
            	    {
            	    char_literal20=(Token)match(input,28,FOLLOW_28_in_functionParameters249); 

            	    pushFollow(FOLLOW_expression_in_functionParameters252);
            	    expression21=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression21.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:1: expression : ( term | functionCallStatement | hash | array | variable_access );
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.term_return term22 =null;

        TwigParser.functionCallStatement_return functionCallStatement23 =null;

        TwigParser.hash_return hash24 =null;

        TwigParser.array_return array25 =null;

        TwigParser.variable_access_return variable_access26 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:60:3: ( term | functionCallStatement | hash | array | variable_access )
            int alt7=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==T_OPEN_PAREN) ) {
                    alt7=2;
                }
                else if ( (LA7_1==COLON||LA7_1==DOT||LA7_1==IDENT||LA7_1==NUMBER||LA7_1==STRING||(LA7_1 >= T_CLOSE_CURLY && LA7_1 <= T_CLOSE_STMT)||LA7_1==T_OPEN_CURLY||(LA7_1 >= 28 && LA7_1 <= 32)) ) {
                    alt7=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
            case STRING:
                {
                alt7=1;
                }
                break;
            case T_OPEN_CURLY:
                {
                alt7=3;
                }
                break;
            case 29:
                {
                alt7=4;
                }
                break;
            case DOT:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:60:5: term
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_term_in_expression274);
                    term22=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term22.getTree());

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:61:5: functionCallStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionCallStatement_in_expression280);
                    functionCallStatement23=functionCallStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCallStatement23.getTree());

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:5: hash
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_hash_in_expression286);
                    hash24=hash();

                    state._fsp--;

                    adaptor.addChild(root_0, hash24.getTree());

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:63:5: array
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_array_in_expression292);
                    array25=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array25.getTree());

                    }
                    break;
                case 5 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:64:5: variable_access
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_variable_access_in_expression298);
                    variable_access26=variable_access();

                    state._fsp--;

                    adaptor.addChild(root_0, variable_access26.getTree());

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


    public static class variable_access_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variable_access"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:67:1: variable_access : DOT ^ expression ;
    public final TwigParser.variable_access_return variable_access() throws RecognitionException {
        TwigParser.variable_access_return retval = new TwigParser.variable_access_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DOT27=null;
        TwigParser.expression_return expression28 =null;


        CommonTree DOT27_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:68:3: ( DOT ^ expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:68:5: DOT ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            DOT27=(Token)match(input,DOT,FOLLOW_DOT_in_variable_access313); 
            DOT27_tree = 
            (CommonTree)adaptor.create(DOT27)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(DOT27_tree, root_0);


            pushFollow(FOLLOW_expression_in_variable_access316);
            expression28=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression28.getTree());

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
    // $ANTLR end "variable_access"


    public static class array_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:72:1: array : array_open ^ ( expression ( ',' ! expression )* )? array_close ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal31=null;
        TwigParser.array_open_return array_open29 =null;

        TwigParser.expression_return expression30 =null;

        TwigParser.expression_return expression32 =null;

        TwigParser.array_close_return array_close33 =null;


        CommonTree char_literal31_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:73:3: ( array_open ^ ( expression ( ',' ! expression )* )? array_close )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:73:5: array_open ^ ( expression ( ',' ! expression )* )? array_close
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_array_open_in_array334);
            array_open29=array_open();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(array_open29.getTree(), root_0);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:73:17: ( expression ( ',' ! expression )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==DOT||LA9_0==IDENT||LA9_0==NUMBER||LA9_0==STRING||LA9_0==T_OPEN_CURLY||LA9_0==29) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:73:18: expression ( ',' ! expression )*
                    {
                    pushFollow(FOLLOW_expression_in_array338);
                    expression30=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression30.getTree());

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:73:29: ( ',' ! expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==28) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:73:30: ',' ! expression
                    	    {
                    	    char_literal31=(Token)match(input,28,FOLLOW_28_in_array341); 

                    	    pushFollow(FOLLOW_expression_in_array344);
                    	    expression32=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expression32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_array_close_in_array350);
            array_close33=array_close();

            state._fsp--;

            adaptor.addChild(root_0, array_close33.getTree());

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
    // $ANTLR end "array"


    public static class array_open_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array_open"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:1: array_open : '[' -> ARRAY_OPEN ;
    public final TwigParser.array_open_return array_open() throws RecognitionException {
        TwigParser.array_open_return retval = new TwigParser.array_open_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal34=null;

        CommonTree char_literal34_tree=null;
        RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:77:3: ( '[' -> ARRAY_OPEN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:77:5: '['
            {
            char_literal34=(Token)match(input,29,FOLLOW_29_in_array_open365);  
            stream_29.add(char_literal34);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 77:9: -> ARRAY_OPEN
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(ARRAY_OPEN, "ARRAY_OPEN")
                );

            }


            retval.tree = root_0;

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
    // $ANTLR end "array_open"


    public static class array_close_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array_close"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:80:1: array_close : ']' -> ARRAY_CLOSE ;
    public final TwigParser.array_close_return array_close() throws RecognitionException {
        TwigParser.array_close_return retval = new TwigParser.array_close_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal35=null;

        CommonTree char_literal35_tree=null;
        RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:81:3: ( ']' -> ARRAY_CLOSE )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:81:5: ']'
            {
            char_literal35=(Token)match(input,30,FOLLOW_30_in_array_close384);  
            stream_30.add(char_literal35);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 81:9: -> ARRAY_CLOSE
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(ARRAY_CLOSE, "ARRAY_CLOSE")
                );

            }


            retval.tree = root_0;

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
    // $ANTLR end "array_close"


    public static class hash_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hash"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:84:1: hash : T_OPEN_CURLY ^ hash_argument ( ',' hash_argument )* T_CLOSE_CURLY ;
    public final TwigParser.hash_return hash() throws RecognitionException {
        TwigParser.hash_return retval = new TwigParser.hash_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_CURLY36=null;
        Token char_literal38=null;
        Token T_CLOSE_CURLY40=null;
        TwigParser.hash_argument_return hash_argument37 =null;

        TwigParser.hash_argument_return hash_argument39 =null;


        CommonTree T_OPEN_CURLY36_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree T_CLOSE_CURLY40_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:3: ( T_OPEN_CURLY ^ hash_argument ( ',' hash_argument )* T_CLOSE_CURLY )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:5: T_OPEN_CURLY ^ hash_argument ( ',' hash_argument )* T_CLOSE_CURLY
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_CURLY36=(Token)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash405); 
            T_OPEN_CURLY36_tree = 
            (CommonTree)adaptor.create(T_OPEN_CURLY36)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_CURLY36_tree, root_0);


            pushFollow(FOLLOW_hash_argument_in_hash408);
            hash_argument37=hash_argument();

            state._fsp--;

            adaptor.addChild(root_0, hash_argument37.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:33: ( ',' hash_argument )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==28) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:34: ',' hash_argument
            	    {
            	    char_literal38=(Token)match(input,28,FOLLOW_28_in_hash411); 
            	    char_literal38_tree = 
            	    (CommonTree)adaptor.create(char_literal38)
            	    ;
            	    adaptor.addChild(root_0, char_literal38_tree);


            	    pushFollow(FOLLOW_hash_argument_in_hash413);
            	    hash_argument39=hash_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, hash_argument39.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            T_CLOSE_CURLY40=(Token)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash417); 
            T_CLOSE_CURLY40_tree = 
            (CommonTree)adaptor.create(T_CLOSE_CURLY40)
            ;
            adaptor.addChild(root_0, T_CLOSE_CURLY40_tree);


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


    public static class hash_argument_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hash_argument"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:88:1: hash_argument : expression COLON ! expression ;
    public final TwigParser.hash_argument_return hash_argument() throws RecognitionException {
        TwigParser.hash_argument_return retval = new TwigParser.hash_argument_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COLON42=null;
        TwigParser.expression_return expression41 =null;

        TwigParser.expression_return expression43 =null;


        CommonTree COLON42_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:89:3: ( expression COLON ! expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:89:5: expression COLON ! expression
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_hash_argument433);
            expression41=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression41.getTree());

            COLON42=(Token)match(input,COLON,FOLLOW_COLON_in_hash_argument435); 

            pushFollow(FOLLOW_expression_in_hash_argument438);
            expression43=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression43.getTree());

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
    // $ANTLR end "hash_argument"


    public static class term_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:92:1: term : ( IDENT | NUMBER | STRING );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set44=null;

        CommonTree set44_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:3: ( IDENT | NUMBER | STRING )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set44=(Token)input.LT(1);

            if ( input.LA(1)==IDENT||input.LA(1)==NUMBER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set44)
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


 

    public static final BitSet FOLLOW_template_body_in_template84 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_template87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_print_in_template_body107 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_twig_block_in_template_body111 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print135 = new BitSet(new long[]{0x000000002090AA00L});
    public static final BitSet FOLLOW_body_in_twig_print138 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block156 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_twig_block159 = new BitSet(new long[]{0x0000000020A0AA00L});
    public static final BitSet FOLLOW_body_in_twig_block161 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_body179 = new BitSet(new long[]{0x00000001B080AA02L});
    public static final BitSet FOLLOW_expression_in_body199 = new BitSet(new long[]{0x00000001B080AA02L});
    public static final BitSet FOLLOW_IDENT_in_functionCallStatement223 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_T_OPEN_PAREN_in_functionCallStatement226 = new BitSet(new long[]{0x000000002080AA00L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement229 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_functionCallStatement231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters246 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_functionParameters249 = new BitSet(new long[]{0x000000002080AA00L});
    public static final BitSet FOLLOW_expression_in_functionParameters252 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_term_in_expression274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_access_in_expression298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_variable_access313 = new BitSet(new long[]{0x000000002080AA00L});
    public static final BitSet FOLLOW_expression_in_variable_access316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_open_in_array334 = new BitSet(new long[]{0x000000006080AA00L});
    public static final BitSet FOLLOW_expression_in_array338 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_28_in_array341 = new BitSet(new long[]{0x000000002080AA00L});
    public static final BitSet FOLLOW_expression_in_array344 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_array_close_in_array350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_array_open365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_array_close384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash405 = new BitSet(new long[]{0x000000002080AA00L});
    public static final BitSet FOLLOW_hash_argument_in_hash408 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_hash411 = new BitSet(new long[]{0x000000002080AA00L});
    public static final BitSet FOLLOW_hash_argument_in_hash413 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_hash_argument433 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_COLON_in_hash_argument435 = new BitSet(new long[]{0x000000002080AA00L});
    public static final BitSet FOLLOW_expression_in_hash_argument438 = new BitSet(new long[]{0x0000000000000002L});

}