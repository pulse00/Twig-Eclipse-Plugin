// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2012-01-01 20:38:13

  package com.dubture.twig.core.parser.ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "COLON", "DIGIT", "DOT", "ESC", "IDENT", "LETTER", "NUMBER", "PUNCTUATION", "RAW", "SQ_STRING", "STRING", "TWIG_VAR", "T_CLOSE_CMT", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','", "'['", "']'", "'|'", "'~'"
    };

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:47:1: template : ( template_body )* EOF !;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF2=null;
        TwigParser.template_body_return template_body1 =null;


        CommonTree EOF2_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:3: ( ( template_body )* EOF !)
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:5: ( template_body )* EOF !
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:5: ( template_body )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= T_OPEN_PRINT && LA1_0 <= T_OPEN_STMT)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:6: template_body
            	    {
            	    pushFollow(FOLLOW_template_body_in_template87);
            	    template_body1=template_body();

            	    state._fsp--;

            	    adaptor.addChild(root_0, template_body1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_template91); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:51:1: template_body : ( twig_print | twig_block );
    public final TwigParser.template_body_return template_body() throws RecognitionException {
        TwigParser.template_body_return retval = new TwigParser.template_body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.twig_print_return twig_print3 =null;

        TwigParser.twig_block_return twig_block4 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:3: ( twig_print | twig_block )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==T_OPEN_PRINT) ) {
                alt2=1;
            }
            else if ( (LA2_0==T_OPEN_STMT) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:5: twig_print
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_twig_print_in_template_body108);
                    twig_print3=twig_print();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_print3.getTree());

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:18: twig_block
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_twig_block_in_template_body112);
                    twig_block4=twig_block();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_block4.getTree());

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
    // $ANTLR end "template_body"


    public static class twig_print_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "twig_print"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:55:1: twig_print : T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT ;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:3: ( T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:5: T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_PRINT5=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print128); 
            T_OPEN_PRINT5_tree = 
            (CommonTree)adaptor.create(T_OPEN_PRINT5)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_PRINT5_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:19: ( body )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DOT||LA3_0==IDENT||LA3_0==NUMBER||(LA3_0 >= SQ_STRING && LA3_0 <= STRING)||LA3_0==T_OPEN_CURLY||LA3_0==30) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:19: body
                    {
                    pushFollow(FOLLOW_body_in_twig_print131);
                    body6=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body6.getTree());

                    }
                    break;

            }


            T_CLOSE_PRINT7=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print134); 
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:1: twig_block : T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT ;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:60:3: ( T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:60:5: T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_STMT8=(Token)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block149); 
            T_OPEN_STMT8_tree = 
            (CommonTree)adaptor.create(T_OPEN_STMT8)
            ;
            adaptor.addChild(root_0, T_OPEN_STMT8_tree);


            IDENT9=(Token)match(input,IDENT,FOLLOW_IDENT_in_twig_block151); 
            IDENT9_tree = 
            (CommonTree)adaptor.create(IDENT9)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT9_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:60:25: ( body )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==DOT||LA4_0==IDENT||LA4_0==NUMBER||(LA4_0 >= SQ_STRING && LA4_0 <= STRING)||LA4_0==T_OPEN_CURLY||LA4_0==30) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:60:25: body
                    {
                    pushFollow(FOLLOW_body_in_twig_block155);
                    body10=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body10.getTree());

                    }
                    break;

            }


            T_CLOSE_STMT11=(Token)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block158); 
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:63:1: body : expression ( ( ( '|' | ',' | '~' )? ) ! expression )* ;
    public final TwigParser.body_return body() throws RecognitionException {
        TwigParser.body_return retval = new TwigParser.body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set13=null;
        TwigParser.expression_return expression12 =null;

        TwigParser.expression_return expression14 =null;


        CommonTree set13_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:3: ( expression ( ( ( '|' | ',' | '~' )? ) ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:5: expression ( ( ( '|' | ',' | '~' )? ) ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_body179);
            expression12=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression12.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:16: ( ( ( '|' | ',' | '~' )? ) ! expression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==DOT||LA6_0==IDENT||LA6_0==NUMBER||(LA6_0 >= SQ_STRING && LA6_0 <= STRING)||LA6_0==T_OPEN_CURLY||(LA6_0 >= 29 && LA6_0 <= 30)||(LA6_0 >= 32 && LA6_0 <= 33)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:18: ( ( '|' | ',' | '~' )? ) ! expression
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:18: ( ( '|' | ',' | '~' )? )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:19: ( '|' | ',' | '~' )?
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:19: ( '|' | ',' | '~' )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==29||(LA5_0 >= 32 && LA5_0 <= 33)) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            	            {
            	            set13=(Token)input.LT(1);

            	            if ( input.LA(1)==29||(input.LA(1) >= 32 && input.LA(1) <= 33) ) {
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


            	    pushFollow(FOLLOW_expression_in_body200);
            	    expression14=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression14.getTree());

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
    // $ANTLR end "body"


    public static class functionCallStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCallStatement"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:69:1: functionCallStatement : IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN ;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:72:3: ( IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:72:5: IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENT15=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionCallStatement224); 
            IDENT15_tree = 
            (CommonTree)adaptor.create(IDENT15)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT15_tree, root_0);


            T_OPEN_PAREN16=(Token)match(input,T_OPEN_PAREN,FOLLOW_T_OPEN_PAREN_in_functionCallStatement227); 

            pushFollow(FOLLOW_functionParameters_in_functionCallStatement230);
            functionParameters17=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, functionParameters17.getTree());

            T_CLOSE_PAREN18=(Token)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_functionCallStatement232); 
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:75:1: functionParameters : expression ( ',' ! expression )* ;
    public final TwigParser.functionParameters_return functionParameters() throws RecognitionException {
        TwigParser.functionParameters_return retval = new TwigParser.functionParameters_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal20=null;
        TwigParser.expression_return expression19 =null;

        TwigParser.expression_return expression21 =null;


        CommonTree char_literal20_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:3: ( expression ( ',' ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:5: expression ( ',' ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_functionParameters247);
            expression19=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression19.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:16: ( ',' ! expression )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==29) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:17: ',' ! expression
            	    {
            	    char_literal20=(Token)match(input,29,FOLLOW_29_in_functionParameters250); 

            	    pushFollow(FOLLOW_expression_in_functionParameters253);
            	    expression21=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression21.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:79:1: expression : ( term | functionCallStatement | hash | array | variable_access );
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:80:3: ( term | functionCallStatement | hash | array | variable_access )
            int alt8=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==T_OPEN_PAREN) ) {
                    alt8=2;
                }
                else if ( (LA8_1==COLON||LA8_1==DOT||LA8_1==IDENT||LA8_1==NUMBER||(LA8_1 >= SQ_STRING && LA8_1 <= STRING)||(LA8_1 >= T_CLOSE_CURLY && LA8_1 <= T_CLOSE_STMT)||LA8_1==T_OPEN_CURLY||(LA8_1 >= 29 && LA8_1 <= 33)) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
            case SQ_STRING:
            case STRING:
                {
                alt8=1;
                }
                break;
            case T_OPEN_CURLY:
                {
                alt8=3;
                }
                break;
            case 30:
                {
                alt8=4;
                }
                break;
            case DOT:
                {
                alt8=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:80:5: term
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_term_in_expression275);
                    term22=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term22.getTree());

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:81:5: functionCallStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionCallStatement_in_expression281);
                    functionCallStatement23=functionCallStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCallStatement23.getTree());

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:82:5: hash
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_hash_in_expression287);
                    hash24=hash();

                    state._fsp--;

                    adaptor.addChild(root_0, hash24.getTree());

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:83:5: array
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_array_in_expression293);
                    array25=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array25.getTree());

                    }
                    break;
                case 5 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:84:5: variable_access
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_variable_access_in_expression299);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:87:1: variable_access : DOT ^ expression ;
    public final TwigParser.variable_access_return variable_access() throws RecognitionException {
        TwigParser.variable_access_return retval = new TwigParser.variable_access_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DOT27=null;
        TwigParser.expression_return expression28 =null;


        CommonTree DOT27_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:88:3: ( DOT ^ expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:88:5: DOT ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            DOT27=(Token)match(input,DOT,FOLLOW_DOT_in_variable_access314); 
            DOT27_tree = 
            (CommonTree)adaptor.create(DOT27)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(DOT27_tree, root_0);


            pushFollow(FOLLOW_expression_in_variable_access317);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:92:1: array : array_open ^ ( expression ( ',' ! expression )* )? array_close ;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:3: ( array_open ^ ( expression ( ',' ! expression )* )? array_close )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:5: array_open ^ ( expression ( ',' ! expression )* )? array_close
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_array_open_in_array335);
            array_open29=array_open();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(array_open29.getTree(), root_0);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:17: ( expression ( ',' ! expression )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==DOT||LA10_0==IDENT||LA10_0==NUMBER||(LA10_0 >= SQ_STRING && LA10_0 <= STRING)||LA10_0==T_OPEN_CURLY||LA10_0==30) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:18: expression ( ',' ! expression )*
                    {
                    pushFollow(FOLLOW_expression_in_array339);
                    expression30=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression30.getTree());

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:29: ( ',' ! expression )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==29) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:30: ',' ! expression
                    	    {
                    	    char_literal31=(Token)match(input,29,FOLLOW_29_in_array342); 

                    	    pushFollow(FOLLOW_expression_in_array345);
                    	    expression32=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expression32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_array_close_in_array351);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:96:1: array_open : '[' -> ARRAY_OPEN ;
    public final TwigParser.array_open_return array_open() throws RecognitionException {
        TwigParser.array_open_return retval = new TwigParser.array_open_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal34=null;

        CommonTree char_literal34_tree=null;
        RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:97:3: ( '[' -> ARRAY_OPEN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:97:5: '['
            {
            char_literal34=(Token)match(input,30,FOLLOW_30_in_array_open366);  
            stream_30.add(char_literal34);


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
            // 97:9: -> ARRAY_OPEN
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:100:1: array_close : ']' -> ARRAY_CLOSE ;
    public final TwigParser.array_close_return array_close() throws RecognitionException {
        TwigParser.array_close_return retval = new TwigParser.array_close_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal35=null;

        CommonTree char_literal35_tree=null;
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:101:3: ( ']' -> ARRAY_CLOSE )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:101:5: ']'
            {
            char_literal35=(Token)match(input,31,FOLLOW_31_in_array_close385);  
            stream_31.add(char_literal35);


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
            // 101:9: -> ARRAY_CLOSE
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:104:1: hash : T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY ;
    public final TwigParser.hash_return hash() throws RecognitionException {
        TwigParser.hash_return retval = new TwigParser.hash_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_CURLY36=null;
        Token T_CLOSE_CURLY38=null;
        TwigParser.hash_body_return hash_body37 =null;


        CommonTree T_OPEN_CURLY36_tree=null;
        CommonTree T_CLOSE_CURLY38_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:105:3: ( T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:105:5: T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_CURLY36=(Token)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash406); 
            T_OPEN_CURLY36_tree = 
            (CommonTree)adaptor.create(T_OPEN_CURLY36)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_CURLY36_tree, root_0);


            pushFollow(FOLLOW_hash_body_in_hash409);
            hash_body37=hash_body();

            state._fsp--;

            adaptor.addChild(root_0, hash_body37.getTree());

            T_CLOSE_CURLY38=(Token)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash411); 
            T_CLOSE_CURLY38_tree = 
            (CommonTree)adaptor.create(T_CLOSE_CURLY38)
            ;
            adaptor.addChild(root_0, T_CLOSE_CURLY38_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:1: hash_body : hash_argument ( ',' hash_argument )* ;
    public final TwigParser.hash_body_return hash_body() throws RecognitionException {
        TwigParser.hash_body_return retval = new TwigParser.hash_body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal40=null;
        TwigParser.hash_argument_return hash_argument39 =null;

        TwigParser.hash_argument_return hash_argument41 =null;


        CommonTree char_literal40_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:109:3: ( hash_argument ( ',' hash_argument )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:109:5: hash_argument ( ',' hash_argument )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_hash_argument_in_hash_body426);
            hash_argument39=hash_argument();

            state._fsp--;

            adaptor.addChild(root_0, hash_argument39.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:109:19: ( ',' hash_argument )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==29) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:109:20: ',' hash_argument
            	    {
            	    char_literal40=(Token)match(input,29,FOLLOW_29_in_hash_body429); 
            	    char_literal40_tree = 
            	    (CommonTree)adaptor.create(char_literal40)
            	    ;
            	    adaptor.addChild(root_0, char_literal40_tree);


            	    pushFollow(FOLLOW_hash_argument_in_hash_body431);
            	    hash_argument41=hash_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, hash_argument41.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // $ANTLR end "hash_body"


    public static class hash_argument_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hash_argument"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:112:1: hash_argument : expression COLON ! expression ;
    public final TwigParser.hash_argument_return hash_argument() throws RecognitionException {
        TwigParser.hash_argument_return retval = new TwigParser.hash_argument_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COLON43=null;
        TwigParser.expression_return expression42 =null;

        TwigParser.expression_return expression44 =null;


        CommonTree COLON43_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:113:3: ( expression COLON ! expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:113:5: expression COLON ! expression
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_hash_argument448);
            expression42=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression42.getTree());

            COLON43=(Token)match(input,COLON,FOLLOW_COLON_in_hash_argument450); 

            pushFollow(FOLLOW_expression_in_hash_argument453);
            expression44=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression44.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:116:1: term : ( IDENT | NUMBER | STRING | SQ_STRING );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set45=null;

        CommonTree set45_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:117:3: ( IDENT | NUMBER | STRING | SQ_STRING )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set45=(Token)input.LT(1);

            if ( input.LA(1)==IDENT||input.LA(1)==NUMBER||(input.LA(1) >= SQ_STRING && input.LA(1) <= STRING) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set45)
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


 

    public static final BitSet FOLLOW_template_body_in_template87 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_EOF_in_template91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_print_in_template_body108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_block_in_template_body112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print128 = new BitSet(new long[]{0x0000000041219500L});
    public static final BitSet FOLLOW_body_in_twig_print131 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block149 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDENT_in_twig_block151 = new BitSet(new long[]{0x0000000041419500L});
    public static final BitSet FOLLOW_body_in_twig_block155 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_body179 = new BitSet(new long[]{0x0000000361019502L});
    public static final BitSet FOLLOW_expression_in_body200 = new BitSet(new long[]{0x0000000361019502L});
    public static final BitSet FOLLOW_IDENT_in_functionCallStatement224 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_T_OPEN_PAREN_in_functionCallStatement227 = new BitSet(new long[]{0x0000000041019500L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement230 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_functionCallStatement232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters247 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_functionParameters250 = new BitSet(new long[]{0x0000000041019500L});
    public static final BitSet FOLLOW_expression_in_functionParameters253 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_term_in_expression275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_access_in_expression299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_variable_access314 = new BitSet(new long[]{0x0000000041019500L});
    public static final BitSet FOLLOW_expression_in_variable_access317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_open_in_array335 = new BitSet(new long[]{0x00000000C1019500L});
    public static final BitSet FOLLOW_expression_in_array339 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_29_in_array342 = new BitSet(new long[]{0x0000000041019500L});
    public static final BitSet FOLLOW_expression_in_array345 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_array_close_in_array351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_array_open366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_array_close385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash406 = new BitSet(new long[]{0x0000000041019500L});
    public static final BitSet FOLLOW_hash_body_in_hash409 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_argument_in_hash_body426 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_hash_body429 = new BitSet(new long[]{0x0000000041019500L});
    public static final BitSet FOLLOW_hash_argument_in_hash_body431 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_expression_in_hash_argument448 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLON_in_hash_argument450 = new BitSet(new long[]{0x0000000041019500L});
    public static final BitSet FOLLOW_expression_in_hash_argument453 = new BitSet(new long[]{0x0000000000000002L});

}