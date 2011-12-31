// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2011-12-31 11:37:46

  package com.dubture.twig.core.parser.ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "COLON", "DIGIT", "IDENT", "LETTER", "NUMBER", "PUNCTUATION", "TWIG_VAR", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','", "'.'", "'['", "']'", "'|'", "'~'"
    };

    public static final int EOF=-1;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int ARRAY_CLOSE=4;
    public static final int ARRAY_OPEN=5;
    public static final int COLON=6;
    public static final int DIGIT=7;
    public static final int IDENT=8;
    public static final int LETTER=9;
    public static final int NUMBER=10;
    public static final int PUNCTUATION=11;
    public static final int TWIG_VAR=12;
    public static final int T_CLOSE_CURLY=13;
    public static final int T_CLOSE_PAREN=14;
    public static final int T_CLOSE_PRINT=15;
    public static final int T_CLOSE_STMT=16;
    public static final int T_OPEN_CURLY=17;
    public static final int T_OPEN_PAREN=18;
    public static final int T_OPEN_PRINT=19;
    public static final int T_OPEN_STMT=20;
    public static final int WS=21;

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:23:1: template : ( twig_print | twig_block )* ;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.twig_print_return twig_print1 =null;

        TwigParser.twig_block_return twig_block2 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:24:3: ( ( twig_print | twig_block )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:24:5: ( twig_print | twig_block )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:24:5: ( twig_print | twig_block )*
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
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:24:6: twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_template76);
            	    twig_print1=twig_print();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_print1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:24:19: twig_block
            	    {
            	    pushFollow(FOLLOW_twig_block_in_template80);
            	    twig_block2=twig_block();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_block2.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:27:1: twig_print : T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_PRINT3=null;
        Token T_CLOSE_PRINT5=null;
        TwigParser.body_return body4 =null;


        CommonTree T_OPEN_PRINT3_tree=null;
        CommonTree T_CLOSE_PRINT5_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:3: ( T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:5: T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_PRINT3=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print105); 
            T_OPEN_PRINT3_tree = 
            (CommonTree)adaptor.create(T_OPEN_PRINT3)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_PRINT3_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:19: ( body )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT||LA2_0==NUMBER||LA2_0==T_OPEN_CURLY||LA2_0==24) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:19: body
                    {
                    pushFollow(FOLLOW_body_in_twig_print108);
                    body4=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body4.getTree());

                    }
                    break;

            }


            T_CLOSE_PRINT5=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print111); 
            T_CLOSE_PRINT5_tree = 
            (CommonTree)adaptor.create(T_CLOSE_PRINT5)
            ;
            adaptor.addChild(root_0, T_CLOSE_PRINT5_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:33:1: twig_block : T_OPEN_STMT ^ IDENT ( body )? T_CLOSE_STMT ;
    public final TwigParser.twig_block_return twig_block() throws RecognitionException {
        TwigParser.twig_block_return retval = new TwigParser.twig_block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_STMT6=null;
        Token IDENT7=null;
        Token T_CLOSE_STMT9=null;
        TwigParser.body_return body8 =null;


        CommonTree T_OPEN_STMT6_tree=null;
        CommonTree IDENT7_tree=null;
        CommonTree T_CLOSE_STMT9_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:3: ( T_OPEN_STMT ^ IDENT ( body )? T_CLOSE_STMT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:5: T_OPEN_STMT ^ IDENT ( body )? T_CLOSE_STMT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_STMT6=(Token)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block126); 
            T_OPEN_STMT6_tree = 
            (CommonTree)adaptor.create(T_OPEN_STMT6)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_STMT6_tree, root_0);


            IDENT7=(Token)match(input,IDENT,FOLLOW_IDENT_in_twig_block129); 
            IDENT7_tree = 
            (CommonTree)adaptor.create(IDENT7)
            ;
            adaptor.addChild(root_0, IDENT7_tree);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:24: ( body )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENT||LA3_0==NUMBER||LA3_0==T_OPEN_CURLY||LA3_0==24) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:24: body
                    {
                    pushFollow(FOLLOW_body_in_twig_block131);
                    body8=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body8.getTree());

                    }
                    break;

            }


            T_CLOSE_STMT9=(Token)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block134); 
            T_CLOSE_STMT9_tree = 
            (CommonTree)adaptor.create(T_CLOSE_STMT9)
            ;
            adaptor.addChild(root_0, T_CLOSE_STMT9_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:37:1: body : expression ( ( ( '|' | '.' | ',' | '~' )? ) ! expression )* ;
    public final TwigParser.body_return body() throws RecognitionException {
        TwigParser.body_return retval = new TwigParser.body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set11=null;
        TwigParser.expression_return expression10 =null;

        TwigParser.expression_return expression12 =null;


        CommonTree set11_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:3: ( expression ( ( ( '|' | '.' | ',' | '~' )? ) ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:5: expression ( ( ( '|' | '.' | ',' | '~' )? ) ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_body149);
            expression10=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression10.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:16: ( ( ( '|' | '.' | ',' | '~' )? ) ! expression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT||LA5_0==NUMBER||LA5_0==T_OPEN_CURLY||(LA5_0 >= 22 && LA5_0 <= 24)||(LA5_0 >= 26 && LA5_0 <= 27)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:18: ( ( '|' | '.' | ',' | '~' )? ) ! expression
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:18: ( ( '|' | '.' | ',' | '~' )? )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:19: ( '|' | '.' | ',' | '~' )?
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:19: ( '|' | '.' | ',' | '~' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( ((LA4_0 >= 22 && LA4_0 <= 23)||(LA4_0 >= 26 && LA4_0 <= 27)) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            	            {
            	            set11=(Token)input.LT(1);

            	            if ( (input.LA(1) >= 22 && input.LA(1) <= 23)||(input.LA(1) >= 26 && input.LA(1) <= 27) ) {
            	                input.consume();
            	                adaptor.addChild(root_0, 
            	                (CommonTree)adaptor.create(set11)
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


            	    pushFollow(FOLLOW_expression_in_body173);
            	    expression12=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression12.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:41:1: functionCallStatement : IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN ;
    public final TwigParser.functionCallStatement_return functionCallStatement() throws RecognitionException {
        TwigParser.functionCallStatement_return retval = new TwigParser.functionCallStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token IDENT13=null;
        Token T_OPEN_PAREN14=null;
        Token T_CLOSE_PAREN16=null;
        TwigParser.functionParameters_return functionParameters15 =null;


        CommonTree IDENT13_tree=null;
        CommonTree T_OPEN_PAREN14_tree=null;
        CommonTree T_CLOSE_PAREN16_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:44:3: ( IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:44:5: IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionCallStatement197); 
            IDENT13_tree = 
            (CommonTree)adaptor.create(IDENT13)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT13_tree, root_0);


            T_OPEN_PAREN14=(Token)match(input,T_OPEN_PAREN,FOLLOW_T_OPEN_PAREN_in_functionCallStatement200); 

            pushFollow(FOLLOW_functionParameters_in_functionCallStatement203);
            functionParameters15=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, functionParameters15.getTree());

            T_CLOSE_PAREN16=(Token)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_functionCallStatement205); 
            T_CLOSE_PAREN16_tree = 
            (CommonTree)adaptor.create(T_CLOSE_PAREN16)
            ;
            adaptor.addChild(root_0, T_CLOSE_PAREN16_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:47:1: functionParameters : expression ( ',' ! expression )* ;
    public final TwigParser.functionParameters_return functionParameters() throws RecognitionException {
        TwigParser.functionParameters_return retval = new TwigParser.functionParameters_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal18=null;
        TwigParser.expression_return expression17 =null;

        TwigParser.expression_return expression19 =null;


        CommonTree char_literal18_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:3: ( expression ( ',' ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:5: expression ( ',' ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_functionParameters220);
            expression17=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression17.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:16: ( ',' ! expression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==22) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:17: ',' ! expression
            	    {
            	    char_literal18=(Token)match(input,22,FOLLOW_22_in_functionParameters223); 

            	    pushFollow(FOLLOW_expression_in_functionParameters226);
            	    expression19=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression19.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:51:1: expression : ( term | functionCallStatement | hash | array );
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.term_return term20 =null;

        TwigParser.functionCallStatement_return functionCallStatement21 =null;

        TwigParser.hash_return hash22 =null;

        TwigParser.array_return array23 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:3: ( term | functionCallStatement | hash | array )
            int alt7=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==T_OPEN_PAREN) ) {
                    alt7=2;
                }
                else if ( (LA7_1==COLON||LA7_1==IDENT||LA7_1==NUMBER||(LA7_1 >= T_CLOSE_CURLY && LA7_1 <= T_OPEN_CURLY)||(LA7_1 >= 22 && LA7_1 <= 27)) ) {
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
                {
                alt7=1;
                }
                break;
            case T_OPEN_CURLY:
                {
                alt7=3;
                }
                break;
            case 24:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:5: term
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_term_in_expression248);
                    term20=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term20.getTree());

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:53:5: functionCallStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionCallStatement_in_expression254);
                    functionCallStatement21=functionCallStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCallStatement21.getTree());

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:54:5: hash
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_hash_in_expression260);
                    hash22=hash();

                    state._fsp--;

                    adaptor.addChild(root_0, hash22.getTree());

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:55:5: array
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_array_in_expression266);
                    array23=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array23.getTree());

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


    public static class array_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:58:1: array : array_open ^ ( expression ( ',' ! expression )* )? array_close ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal26=null;
        TwigParser.array_open_return array_open24 =null;

        TwigParser.expression_return expression25 =null;

        TwigParser.expression_return expression27 =null;

        TwigParser.array_close_return array_close28 =null;


        CommonTree char_literal26_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:3: ( array_open ^ ( expression ( ',' ! expression )* )? array_close )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:5: array_open ^ ( expression ( ',' ! expression )* )? array_close
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_array_open_in_array281);
            array_open24=array_open();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(array_open24.getTree(), root_0);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:17: ( expression ( ',' ! expression )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENT||LA9_0==NUMBER||LA9_0==T_OPEN_CURLY||LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:18: expression ( ',' ! expression )*
                    {
                    pushFollow(FOLLOW_expression_in_array285);
                    expression25=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression25.getTree());

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:29: ( ',' ! expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==22) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:30: ',' ! expression
                    	    {
                    	    char_literal26=(Token)match(input,22,FOLLOW_22_in_array288); 

                    	    pushFollow(FOLLOW_expression_in_array291);
                    	    expression27=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expression27.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_array_close_in_array297);
            array_close28=array_close();

            state._fsp--;

            adaptor.addChild(root_0, array_close28.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:1: array_open : '[' -> ARRAY_OPEN ;
    public final TwigParser.array_open_return array_open() throws RecognitionException {
        TwigParser.array_open_return retval = new TwigParser.array_open_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal29=null;

        CommonTree char_literal29_tree=null;
        RewriteRuleTokenStream stream_24=new RewriteRuleTokenStream(adaptor,"token 24");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:63:3: ( '[' -> ARRAY_OPEN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:63:5: '['
            {
            char_literal29=(Token)match(input,24,FOLLOW_24_in_array_open312);  
            stream_24.add(char_literal29);


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
            // 63:9: -> ARRAY_OPEN
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:1: array_close : ']' -> ARRAY_CLOSE ;
    public final TwigParser.array_close_return array_close() throws RecognitionException {
        TwigParser.array_close_return retval = new TwigParser.array_close_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal30=null;

        CommonTree char_literal30_tree=null;
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:67:3: ( ']' -> ARRAY_CLOSE )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:67:5: ']'
            {
            char_literal30=(Token)match(input,25,FOLLOW_25_in_array_close331);  
            stream_25.add(char_literal30);


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
            // 67:9: -> ARRAY_CLOSE
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:70:1: hash : T_OPEN_CURLY ^ hash_argument ( ',' hash_argument )* T_CLOSE_CURLY ;
    public final TwigParser.hash_return hash() throws RecognitionException {
        TwigParser.hash_return retval = new TwigParser.hash_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_CURLY31=null;
        Token char_literal33=null;
        Token T_CLOSE_CURLY35=null;
        TwigParser.hash_argument_return hash_argument32 =null;

        TwigParser.hash_argument_return hash_argument34 =null;


        CommonTree T_OPEN_CURLY31_tree=null;
        CommonTree char_literal33_tree=null;
        CommonTree T_CLOSE_CURLY35_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:3: ( T_OPEN_CURLY ^ hash_argument ( ',' hash_argument )* T_CLOSE_CURLY )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:5: T_OPEN_CURLY ^ hash_argument ( ',' hash_argument )* T_CLOSE_CURLY
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_CURLY31=(Token)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash352); 
            T_OPEN_CURLY31_tree = 
            (CommonTree)adaptor.create(T_OPEN_CURLY31)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_CURLY31_tree, root_0);


            pushFollow(FOLLOW_hash_argument_in_hash355);
            hash_argument32=hash_argument();

            state._fsp--;

            adaptor.addChild(root_0, hash_argument32.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:33: ( ',' hash_argument )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:34: ',' hash_argument
            	    {
            	    char_literal33=(Token)match(input,22,FOLLOW_22_in_hash358); 
            	    char_literal33_tree = 
            	    (CommonTree)adaptor.create(char_literal33)
            	    ;
            	    adaptor.addChild(root_0, char_literal33_tree);


            	    pushFollow(FOLLOW_hash_argument_in_hash360);
            	    hash_argument34=hash_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, hash_argument34.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            T_CLOSE_CURLY35=(Token)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash364); 
            T_CLOSE_CURLY35_tree = 
            (CommonTree)adaptor.create(T_CLOSE_CURLY35)
            ;
            adaptor.addChild(root_0, T_CLOSE_CURLY35_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:74:1: hash_argument : expression COLON ! expression ;
    public final TwigParser.hash_argument_return hash_argument() throws RecognitionException {
        TwigParser.hash_argument_return retval = new TwigParser.hash_argument_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COLON37=null;
        TwigParser.expression_return expression36 =null;

        TwigParser.expression_return expression38 =null;


        CommonTree COLON37_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:75:3: ( expression COLON ! expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:75:5: expression COLON ! expression
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_hash_argument380);
            expression36=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression36.getTree());

            COLON37=(Token)match(input,COLON,FOLLOW_COLON_in_hash_argument382); 

            pushFollow(FOLLOW_expression_in_hash_argument385);
            expression38=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression38.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:78:1: term : ( IDENT | NUMBER );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set39=null;

        CommonTree set39_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:79:3: ( IDENT | NUMBER )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set39=(Token)input.LT(1);

            if ( input.LA(1)==IDENT||input.LA(1)==NUMBER ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set39)
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


 

    public static final BitSet FOLLOW_twig_print_in_template76 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_twig_block_in_template80 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print105 = new BitSet(new long[]{0x0000000001028500L});
    public static final BitSet FOLLOW_body_in_twig_print108 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block126 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENT_in_twig_block129 = new BitSet(new long[]{0x0000000001030500L});
    public static final BitSet FOLLOW_body_in_twig_block131 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_body149 = new BitSet(new long[]{0x000000000DC20502L});
    public static final BitSet FOLLOW_expression_in_body173 = new BitSet(new long[]{0x000000000DC20502L});
    public static final BitSet FOLLOW_IDENT_in_functionCallStatement197 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_T_OPEN_PAREN_in_functionCallStatement200 = new BitSet(new long[]{0x0000000001020500L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement203 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_functionCallStatement205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters220 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_functionParameters223 = new BitSet(new long[]{0x0000000001020500L});
    public static final BitSet FOLLOW_expression_in_functionParameters226 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_term_in_expression248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_open_in_array281 = new BitSet(new long[]{0x0000000003020500L});
    public static final BitSet FOLLOW_expression_in_array285 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_22_in_array288 = new BitSet(new long[]{0x0000000001020500L});
    public static final BitSet FOLLOW_expression_in_array291 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_array_close_in_array297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_array_open312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_array_close331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash352 = new BitSet(new long[]{0x0000000001020500L});
    public static final BitSet FOLLOW_hash_argument_in_hash355 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_22_in_hash358 = new BitSet(new long[]{0x0000000001020500L});
    public static final BitSet FOLLOW_hash_argument_in_hash360 = new BitSet(new long[]{0x0000000000402000L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_hash_argument380 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLON_in_hash_argument382 = new BitSet(new long[]{0x0000000001020500L});
    public static final BitSet FOLLOW_expression_in_hash_argument385 = new BitSet(new long[]{0x0000000000000002L});

}