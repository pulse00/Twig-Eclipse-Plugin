// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2011-12-31 16:54:15

  package com.dubture.twig.core.parser.ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "COLON", "DIGIT", "DOT", "ESC", "IDENT", "LETTER", "NUMBER", "PUNCTUATION", "STRING", "TWIG_VAR", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','", "'['", "']'", "'|'", "'~'"
    };

    public static final int EOF=-1;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
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
    public static final int STRING=14;
    public static final int TWIG_VAR=15;
    public static final int T_CLOSE_CURLY=16;
    public static final int T_CLOSE_PAREN=17;
    public static final int T_CLOSE_PRINT=18;
    public static final int T_CLOSE_STMT=19;
    public static final int T_OPEN_CURLY=20;
    public static final int T_OPEN_PAREN=21;
    public static final int T_OPEN_PRINT=22;
    public static final int T_OPEN_STMT=23;
    public static final int WS=24;

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:23:1: template : ( twig_print | twig_block )* EOF ;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF3=null;
        TwigParser.twig_print_return twig_print1 =null;

        TwigParser.twig_block_return twig_block2 =null;


        CommonTree EOF3_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:24:3: ( ( twig_print | twig_block )* EOF )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:24:5: ( twig_print | twig_block )* EOF
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


            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_template84); 
            EOF3_tree = 
            (CommonTree)adaptor.create(EOF3)
            ;
            adaptor.addChild(root_0, EOF3_tree);


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

        Token T_OPEN_PRINT4=null;
        Token T_CLOSE_PRINT6=null;
        TwigParser.body_return body5 =null;


        CommonTree T_OPEN_PRINT4_tree=null;
        CommonTree T_CLOSE_PRINT6_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:3: ( T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:5: T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_PRINT4=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print107); 
            T_OPEN_PRINT4_tree = 
            (CommonTree)adaptor.create(T_OPEN_PRINT4)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_PRINT4_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:19: ( body )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==DOT||LA2_0==IDENT||LA2_0==NUMBER||LA2_0==STRING||LA2_0==T_OPEN_CURLY||LA2_0==26) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:30:19: body
                    {
                    pushFollow(FOLLOW_body_in_twig_print110);
                    body5=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body5.getTree());

                    }
                    break;

            }


            T_CLOSE_PRINT6=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print113); 
            T_CLOSE_PRINT6_tree = 
            (CommonTree)adaptor.create(T_CLOSE_PRINT6)
            ;
            adaptor.addChild(root_0, T_CLOSE_PRINT6_tree);


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

        Token T_OPEN_STMT7=null;
        Token IDENT8=null;
        Token T_CLOSE_STMT10=null;
        TwigParser.body_return body9 =null;


        CommonTree T_OPEN_STMT7_tree=null;
        CommonTree IDENT8_tree=null;
        CommonTree T_CLOSE_STMT10_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:3: ( T_OPEN_STMT ^ IDENT ( body )? T_CLOSE_STMT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:5: T_OPEN_STMT ^ IDENT ( body )? T_CLOSE_STMT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_STMT7=(Token)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block128); 
            T_OPEN_STMT7_tree = 
            (CommonTree)adaptor.create(T_OPEN_STMT7)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_STMT7_tree, root_0);


            IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_twig_block131); 
            IDENT8_tree = 
            (CommonTree)adaptor.create(IDENT8)
            ;
            adaptor.addChild(root_0, IDENT8_tree);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:24: ( body )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DOT||LA3_0==IDENT||LA3_0==NUMBER||LA3_0==STRING||LA3_0==T_OPEN_CURLY||LA3_0==26) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:34:24: body
                    {
                    pushFollow(FOLLOW_body_in_twig_block133);
                    body9=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body9.getTree());

                    }
                    break;

            }


            T_CLOSE_STMT10=(Token)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block136); 
            T_CLOSE_STMT10_tree = 
            (CommonTree)adaptor.create(T_CLOSE_STMT10)
            ;
            adaptor.addChild(root_0, T_CLOSE_STMT10_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:37:1: body : expression ( ( ( '|' | ',' | '~' )? ) ! expression )* ;
    public final TwigParser.body_return body() throws RecognitionException {
        TwigParser.body_return retval = new TwigParser.body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set12=null;
        TwigParser.expression_return expression11 =null;

        TwigParser.expression_return expression13 =null;


        CommonTree set12_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:3: ( expression ( ( ( '|' | ',' | '~' )? ) ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:5: expression ( ( ( '|' | ',' | '~' )? ) ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_body151);
            expression11=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression11.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:16: ( ( ( '|' | ',' | '~' )? ) ! expression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==DOT||LA5_0==IDENT||LA5_0==NUMBER||LA5_0==STRING||LA5_0==T_OPEN_CURLY||(LA5_0 >= 25 && LA5_0 <= 26)||(LA5_0 >= 28 && LA5_0 <= 29)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:18: ( ( '|' | ',' | '~' )? ) ! expression
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:18: ( ( '|' | ',' | '~' )? )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:19: ( '|' | ',' | '~' )?
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:38:19: ( '|' | ',' | '~' )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==25||(LA4_0 >= 28 && LA4_0 <= 29)) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            	            {
            	            set12=(Token)input.LT(1);

            	            if ( input.LA(1)==25||(input.LA(1) >= 28 && input.LA(1) <= 29) ) {
            	                input.consume();
            	                adaptor.addChild(root_0, 
            	                (CommonTree)adaptor.create(set12)
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


            	    pushFollow(FOLLOW_expression_in_body171);
            	    expression13=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression13.getTree());

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

        Token IDENT14=null;
        Token T_OPEN_PAREN15=null;
        Token T_CLOSE_PAREN17=null;
        TwigParser.functionParameters_return functionParameters16 =null;


        CommonTree IDENT14_tree=null;
        CommonTree T_OPEN_PAREN15_tree=null;
        CommonTree T_CLOSE_PAREN17_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:44:3: ( IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:44:5: IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionCallStatement195); 
            IDENT14_tree = 
            (CommonTree)adaptor.create(IDENT14)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT14_tree, root_0);


            T_OPEN_PAREN15=(Token)match(input,T_OPEN_PAREN,FOLLOW_T_OPEN_PAREN_in_functionCallStatement198); 

            pushFollow(FOLLOW_functionParameters_in_functionCallStatement201);
            functionParameters16=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, functionParameters16.getTree());

            T_CLOSE_PAREN17=(Token)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_functionCallStatement203); 
            T_CLOSE_PAREN17_tree = 
            (CommonTree)adaptor.create(T_CLOSE_PAREN17)
            ;
            adaptor.addChild(root_0, T_CLOSE_PAREN17_tree);


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

        Token char_literal19=null;
        TwigParser.expression_return expression18 =null;

        TwigParser.expression_return expression20 =null;


        CommonTree char_literal19_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:3: ( expression ( ',' ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:5: expression ( ',' ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_functionParameters218);
            expression18=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression18.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:16: ( ',' ! expression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==25) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:17: ',' ! expression
            	    {
            	    char_literal19=(Token)match(input,25,FOLLOW_25_in_functionParameters221); 

            	    pushFollow(FOLLOW_expression_in_functionParameters224);
            	    expression20=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression20.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:51:1: expression : ( term | functionCallStatement | hash | array | variable_access );
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.term_return term21 =null;

        TwigParser.functionCallStatement_return functionCallStatement22 =null;

        TwigParser.hash_return hash23 =null;

        TwigParser.array_return array24 =null;

        TwigParser.variable_access_return variable_access25 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:3: ( term | functionCallStatement | hash | array | variable_access )
            int alt7=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==T_OPEN_PAREN) ) {
                    alt7=2;
                }
                else if ( (LA7_1==COLON||LA7_1==DOT||LA7_1==IDENT||LA7_1==NUMBER||LA7_1==STRING||(LA7_1 >= T_CLOSE_CURLY && LA7_1 <= T_OPEN_CURLY)||(LA7_1 >= 25 && LA7_1 <= 29)) ) {
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
            case 26:
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
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:5: term
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_term_in_expression246);
                    term21=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term21.getTree());

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:53:5: functionCallStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionCallStatement_in_expression252);
                    functionCallStatement22=functionCallStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCallStatement22.getTree());

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:54:5: hash
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_hash_in_expression258);
                    hash23=hash();

                    state._fsp--;

                    adaptor.addChild(root_0, hash23.getTree());

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:55:5: array
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_array_in_expression264);
                    array24=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array24.getTree());

                    }
                    break;
                case 5 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:5: variable_access
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_variable_access_in_expression270);
                    variable_access25=variable_access();

                    state._fsp--;

                    adaptor.addChild(root_0, variable_access25.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:1: variable_access : DOT ^ expression ;
    public final TwigParser.variable_access_return variable_access() throws RecognitionException {
        TwigParser.variable_access_return retval = new TwigParser.variable_access_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DOT26=null;
        TwigParser.expression_return expression27 =null;


        CommonTree DOT26_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:60:3: ( DOT ^ expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:60:5: DOT ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            DOT26=(Token)match(input,DOT,FOLLOW_DOT_in_variable_access285); 
            DOT26_tree = 
            (CommonTree)adaptor.create(DOT26)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(DOT26_tree, root_0);


            pushFollow(FOLLOW_expression_in_variable_access288);
            expression27=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression27.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:64:1: array : array_open ^ ( expression ( ',' ! expression )* )? array_close ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal30=null;
        TwigParser.array_open_return array_open28 =null;

        TwigParser.expression_return expression29 =null;

        TwigParser.expression_return expression31 =null;

        TwigParser.array_close_return array_close32 =null;


        CommonTree char_literal30_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:65:3: ( array_open ^ ( expression ( ',' ! expression )* )? array_close )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:65:5: array_open ^ ( expression ( ',' ! expression )* )? array_close
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_array_open_in_array306);
            array_open28=array_open();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(array_open28.getTree(), root_0);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:65:17: ( expression ( ',' ! expression )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==DOT||LA9_0==IDENT||LA9_0==NUMBER||LA9_0==STRING||LA9_0==T_OPEN_CURLY||LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:65:18: expression ( ',' ! expression )*
                    {
                    pushFollow(FOLLOW_expression_in_array310);
                    expression29=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression29.getTree());

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:65:29: ( ',' ! expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==25) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:65:30: ',' ! expression
                    	    {
                    	    char_literal30=(Token)match(input,25,FOLLOW_25_in_array313); 

                    	    pushFollow(FOLLOW_expression_in_array316);
                    	    expression31=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expression31.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_array_close_in_array322);
            array_close32=array_close();

            state._fsp--;

            adaptor.addChild(root_0, array_close32.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:68:1: array_open : '[' -> ARRAY_OPEN ;
    public final TwigParser.array_open_return array_open() throws RecognitionException {
        TwigParser.array_open_return retval = new TwigParser.array_open_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal33=null;

        CommonTree char_literal33_tree=null;
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:69:3: ( '[' -> ARRAY_OPEN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:69:5: '['
            {
            char_literal33=(Token)match(input,26,FOLLOW_26_in_array_open337);  
            stream_26.add(char_literal33);


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
            // 69:9: -> ARRAY_OPEN
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:72:1: array_close : ']' -> ARRAY_CLOSE ;
    public final TwigParser.array_close_return array_close() throws RecognitionException {
        TwigParser.array_close_return retval = new TwigParser.array_close_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal34=null;

        CommonTree char_literal34_tree=null;
        RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:73:3: ( ']' -> ARRAY_CLOSE )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:73:5: ']'
            {
            char_literal34=(Token)match(input,27,FOLLOW_27_in_array_close356);  
            stream_27.add(char_literal34);


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
            // 73:9: -> ARRAY_CLOSE
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:1: hash : T_OPEN_CURLY ^ hash_argument ( ',' hash_argument )* T_CLOSE_CURLY ;
    public final TwigParser.hash_return hash() throws RecognitionException {
        TwigParser.hash_return retval = new TwigParser.hash_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_CURLY35=null;
        Token char_literal37=null;
        Token T_CLOSE_CURLY39=null;
        TwigParser.hash_argument_return hash_argument36 =null;

        TwigParser.hash_argument_return hash_argument38 =null;


        CommonTree T_OPEN_CURLY35_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree T_CLOSE_CURLY39_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:77:3: ( T_OPEN_CURLY ^ hash_argument ( ',' hash_argument )* T_CLOSE_CURLY )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:77:5: T_OPEN_CURLY ^ hash_argument ( ',' hash_argument )* T_CLOSE_CURLY
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_CURLY35=(Token)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash377); 
            T_OPEN_CURLY35_tree = 
            (CommonTree)adaptor.create(T_OPEN_CURLY35)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_CURLY35_tree, root_0);


            pushFollow(FOLLOW_hash_argument_in_hash380);
            hash_argument36=hash_argument();

            state._fsp--;

            adaptor.addChild(root_0, hash_argument36.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:77:33: ( ',' hash_argument )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==25) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:77:34: ',' hash_argument
            	    {
            	    char_literal37=(Token)match(input,25,FOLLOW_25_in_hash383); 
            	    char_literal37_tree = 
            	    (CommonTree)adaptor.create(char_literal37)
            	    ;
            	    adaptor.addChild(root_0, char_literal37_tree);


            	    pushFollow(FOLLOW_hash_argument_in_hash385);
            	    hash_argument38=hash_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, hash_argument38.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            T_CLOSE_CURLY39=(Token)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash389); 
            T_CLOSE_CURLY39_tree = 
            (CommonTree)adaptor.create(T_CLOSE_CURLY39)
            ;
            adaptor.addChild(root_0, T_CLOSE_CURLY39_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:80:1: hash_argument : expression COLON ! expression ;
    public final TwigParser.hash_argument_return hash_argument() throws RecognitionException {
        TwigParser.hash_argument_return retval = new TwigParser.hash_argument_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COLON41=null;
        TwigParser.expression_return expression40 =null;

        TwigParser.expression_return expression42 =null;


        CommonTree COLON41_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:81:3: ( expression COLON ! expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:81:5: expression COLON ! expression
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_hash_argument405);
            expression40=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression40.getTree());

            COLON41=(Token)match(input,COLON,FOLLOW_COLON_in_hash_argument407); 

            pushFollow(FOLLOW_expression_in_hash_argument410);
            expression42=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression42.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:84:1: term : ( IDENT | NUMBER | STRING );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set43=null;

        CommonTree set43_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:3: ( IDENT | NUMBER | STRING )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set43=(Token)input.LT(1);

            if ( input.LA(1)==IDENT||input.LA(1)==NUMBER||input.LA(1)==STRING ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set43)
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


 

    public static final BitSet FOLLOW_twig_print_in_template76 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_twig_block_in_template80 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_EOF_in_template84 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print107 = new BitSet(new long[]{0x0000000004145500L});
    public static final BitSet FOLLOW_body_in_twig_print110 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block128 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDENT_in_twig_block131 = new BitSet(new long[]{0x0000000004185500L});
    public static final BitSet FOLLOW_body_in_twig_block133 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_body151 = new BitSet(new long[]{0x0000000036105502L});
    public static final BitSet FOLLOW_expression_in_body171 = new BitSet(new long[]{0x0000000036105502L});
    public static final BitSet FOLLOW_IDENT_in_functionCallStatement195 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_T_OPEN_PAREN_in_functionCallStatement198 = new BitSet(new long[]{0x0000000004105500L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement201 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_functionCallStatement203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters218 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_functionParameters221 = new BitSet(new long[]{0x0000000004105500L});
    public static final BitSet FOLLOW_expression_in_functionParameters224 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_term_in_expression246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_access_in_expression270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_variable_access285 = new BitSet(new long[]{0x0000000004105500L});
    public static final BitSet FOLLOW_expression_in_variable_access288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_open_in_array306 = new BitSet(new long[]{0x000000000C105500L});
    public static final BitSet FOLLOW_expression_in_array310 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_25_in_array313 = new BitSet(new long[]{0x0000000004105500L});
    public static final BitSet FOLLOW_expression_in_array316 = new BitSet(new long[]{0x000000000A000000L});
    public static final BitSet FOLLOW_array_close_in_array322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_array_open337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_array_close356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash377 = new BitSet(new long[]{0x0000000004105500L});
    public static final BitSet FOLLOW_hash_argument_in_hash380 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_25_in_hash383 = new BitSet(new long[]{0x0000000004105500L});
    public static final BitSet FOLLOW_hash_argument_in_hash385 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_hash_argument405 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLON_in_hash_argument407 = new BitSet(new long[]{0x0000000004105500L});
    public static final BitSet FOLLOW_expression_in_hash_argument410 = new BitSet(new long[]{0x0000000000000002L});

}