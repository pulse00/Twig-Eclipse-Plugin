// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2012-01-03 19:46:05

  package com.dubture.twig.core.parser.ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "BODY", "CALL", "COLON", "COMMA", "DIGIT", "DISPATCH", "DOT", "ESC", "FILTER", "ID", "IDENT", "LETTER", "LHS", "NUMBER", "PARAMS", "PIPE", "QMARK", "RAW", "RHS", "SQ_STRING", "STRING", "TILDE", "T_CLOSE_CMT", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "'['", "']'"
    };

    public static final int EOF=-1;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int ARRAY_CLOSE=4;
    public static final int ARRAY_OPEN=5;
    public static final int BODY=6;
    public static final int CALL=7;
    public static final int COLON=8;
    public static final int COMMA=9;
    public static final int DIGIT=10;
    public static final int DISPATCH=11;
    public static final int DOT=12;
    public static final int ESC=13;
    public static final int FILTER=14;
    public static final int ID=15;
    public static final int IDENT=16;
    public static final int LETTER=17;
    public static final int LHS=18;
    public static final int NUMBER=19;
    public static final int PARAMS=20;
    public static final int PIPE=21;
    public static final int QMARK=22;
    public static final int RAW=23;
    public static final int RHS=24;
    public static final int SQ_STRING=25;
    public static final int STRING=26;
    public static final int TILDE=27;
    public static final int T_CLOSE_CMT=28;
    public static final int T_CLOSE_CURLY=29;
    public static final int T_CLOSE_PAREN=30;
    public static final int T_CLOSE_PRINT=31;
    public static final int T_CLOSE_STMT=32;
    public static final int T_OPEN_CMT=33;
    public static final int T_OPEN_CURLY=34;
    public static final int T_OPEN_PAREN=35;
    public static final int T_OPEN_PRINT=36;
    public static final int T_OPEN_STMT=37;
    public static final int WS=38;

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:70:1: template : ( twig_print | twig_block )* EOF !;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF3=null;
        TwigParser.twig_print_return twig_print1 =null;

        TwigParser.twig_block_return twig_block2 =null;


        CommonTree EOF3_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:3: ( ( twig_print | twig_block )* EOF !)
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:5: ( twig_print | twig_block )* EOF !
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:5: ( twig_print | twig_block )*
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
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:6: twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_template125);
            	    twig_print1=twig_print();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_print1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:19: twig_block
            	    {
            	    pushFollow(FOLLOW_twig_block_in_template129);
            	    twig_block2=twig_block();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_block2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_template133); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:74:1: twig_print : T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT ;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:75:3: ( T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:75:5: T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_PRINT4=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print151); 
            T_OPEN_PRINT4_tree = 
            (CommonTree)adaptor.create(T_OPEN_PRINT4)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_PRINT4_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:75:19: ( body )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT||LA2_0==NUMBER||LA2_0==QMARK||(LA2_0 >= SQ_STRING && LA2_0 <= STRING)||LA2_0==T_OPEN_CURLY||LA2_0==39) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:75:19: body
                    {
                    pushFollow(FOLLOW_body_in_twig_print154);
                    body5=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body5.getTree());

                    }
                    break;

            }


            T_CLOSE_PRINT6=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print157); 
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:78:1: twig_block : T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT ;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:79:3: ( T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:79:5: T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_STMT7=(Token)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block172); 
            T_OPEN_STMT7_tree = 
            (CommonTree)adaptor.create(T_OPEN_STMT7)
            ;
            adaptor.addChild(root_0, T_OPEN_STMT7_tree);


            IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_twig_block174); 
            IDENT8_tree = 
            (CommonTree)adaptor.create(IDENT8)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT8_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:79:24: ( body )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENT||LA3_0==NUMBER||LA3_0==QMARK||(LA3_0 >= SQ_STRING && LA3_0 <= STRING)||LA3_0==T_OPEN_CURLY||LA3_0==39) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:79:24: body
                    {
                    pushFollow(FOLLOW_body_in_twig_block177);
                    body9=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body9.getTree());

                    }
                    break;

            }


            T_CLOSE_STMT10=(Token)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block180); 
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:82:1: body : expression ( ( ( COMMA )? ) ! expression )* ;
    public final TwigParser.body_return body() throws RecognitionException {
        TwigParser.body_return retval = new TwigParser.body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA12=null;
        TwigParser.expression_return expression11 =null;

        TwigParser.expression_return expression13 =null;


        CommonTree COMMA12_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:3: ( expression ( ( ( COMMA )? ) ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:5: expression ( ( ( COMMA )? ) ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_body201);
            expression11=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression11.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:16: ( ( ( COMMA )? ) ! expression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA||LA5_0==IDENT||LA5_0==NUMBER||LA5_0==QMARK||(LA5_0 >= SQ_STRING && LA5_0 <= STRING)||LA5_0==T_OPEN_CURLY||LA5_0==39) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:18: ( ( COMMA )? ) ! expression
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:18: ( ( COMMA )? )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:19: ( COMMA )?
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:19: ( COMMA )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==COMMA) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:19: COMMA
            	            {
            	            COMMA12=(Token)match(input,COMMA,FOLLOW_COMMA_in_body206); 
            	            COMMA12_tree = 
            	            (CommonTree)adaptor.create(COMMA12)
            	            ;
            	            adaptor.addChild(root_0, COMMA12_tree);


            	            }
            	            break;

            	    }


            	    }


            	    pushFollow(FOLLOW_expression_in_body211);
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


    public static class params_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "params"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:88:1: params : expression ( COMMA ! expression )* ;
    public final TwigParser.params_return params() throws RecognitionException {
        TwigParser.params_return retval = new TwigParser.params_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA15=null;
        TwigParser.expression_return expression14 =null;

        TwigParser.expression_return expression16 =null;


        CommonTree COMMA15_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:89:3: ( expression ( COMMA ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:89:5: expression ( COMMA ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_params228);
            expression14=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression14.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:89:16: ( COMMA ! expression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:89:17: COMMA ! expression
            	    {
            	    COMMA15=(Token)match(input,COMMA,FOLLOW_COMMA_in_params231); 

            	    pushFollow(FOLLOW_expression_in_params234);
            	    expression16=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression16.getTree());

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
    // $ANTLR end "params"


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:92:1: expression : ( term | hash | array | ternary );
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.term_return term17 =null;

        TwigParser.hash_return hash18 =null;

        TwigParser.array_return array19 =null;

        TwigParser.ternary_return ternary20 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:3: ( term | hash | array | ternary )
            int alt7=4;
            switch ( input.LA(1) ) {
            case IDENT:
            case NUMBER:
            case SQ_STRING:
            case STRING:
                {
                alt7=1;
                }
                break;
            case T_OPEN_CURLY:
                {
                alt7=2;
                }
                break;
            case 39:
                {
                alt7=3;
                }
                break;
            case QMARK:
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
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:5: term
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_term_in_expression256);
                    term17=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term17.getTree());

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:94:5: hash
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_hash_in_expression262);
                    hash18=hash();

                    state._fsp--;

                    adaptor.addChild(root_0, hash18.getTree());

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:95:5: array
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_array_in_expression268);
                    array19=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array19.getTree());

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:96:5: ternary
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_ternary_in_expression274);
                    ternary20=ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, ternary20.getTree());

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


    public static class ternary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ternary"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:99:1: ternary : QMARK ^ expression COLON expression ;
    public final TwigParser.ternary_return ternary() throws RecognitionException {
        TwigParser.ternary_return retval = new TwigParser.ternary_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token QMARK21=null;
        Token COLON23=null;
        TwigParser.expression_return expression22 =null;

        TwigParser.expression_return expression24 =null;


        CommonTree QMARK21_tree=null;
        CommonTree COLON23_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:100:3: ( QMARK ^ expression COLON expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:100:5: QMARK ^ expression COLON expression
            {
            root_0 = (CommonTree)adaptor.nil();


            QMARK21=(Token)match(input,QMARK,FOLLOW_QMARK_in_ternary289); 
            QMARK21_tree = 
            (CommonTree)adaptor.create(QMARK21)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(QMARK21_tree, root_0);


            pushFollow(FOLLOW_expression_in_ternary292);
            expression22=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression22.getTree());

            COLON23=(Token)match(input,COLON,FOLLOW_COLON_in_ternary294); 
            COLON23_tree = 
            (CommonTree)adaptor.create(COLON23)
            ;
            adaptor.addChild(root_0, COLON23_tree);


            pushFollow(FOLLOW_expression_in_ternary296);
            expression24=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression24.getTree());

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
    // $ANTLR end "ternary"


    public static class concat_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "concat"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:103:1: concat : TILDE ^ expression ;
    public final TwigParser.concat_return concat() throws RecognitionException {
        TwigParser.concat_return retval = new TwigParser.concat_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token TILDE25=null;
        TwigParser.expression_return expression26 =null;


        CommonTree TILDE25_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:104:3: ( TILDE ^ expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:104:5: TILDE ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            TILDE25=(Token)match(input,TILDE,FOLLOW_TILDE_in_concat311); 
            TILDE25_tree = 
            (CommonTree)adaptor.create(TILDE25)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(TILDE25_tree, root_0);


            pushFollow(FOLLOW_expression_in_concat314);
            expression26=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression26.getTree());

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
    // $ANTLR end "concat"


    public static class array_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:107:1: array : array_open ^ ( expression ( COMMA ! expression )* )? array_close ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA29=null;
        TwigParser.array_open_return array_open27 =null;

        TwigParser.expression_return expression28 =null;

        TwigParser.expression_return expression30 =null;

        TwigParser.array_close_return array_close31 =null;


        CommonTree COMMA29_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:3: ( array_open ^ ( expression ( COMMA ! expression )* )? array_close )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:5: array_open ^ ( expression ( COMMA ! expression )* )? array_close
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_array_open_in_array329);
            array_open27=array_open();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(array_open27.getTree(), root_0);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:17: ( expression ( COMMA ! expression )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENT||LA9_0==NUMBER||LA9_0==QMARK||(LA9_0 >= SQ_STRING && LA9_0 <= STRING)||LA9_0==T_OPEN_CURLY||LA9_0==39) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:18: expression ( COMMA ! expression )*
                    {
                    pushFollow(FOLLOW_expression_in_array333);
                    expression28=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression28.getTree());

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:29: ( COMMA ! expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:30: COMMA ! expression
                    	    {
                    	    COMMA29=(Token)match(input,COMMA,FOLLOW_COMMA_in_array336); 

                    	    pushFollow(FOLLOW_expression_in_array339);
                    	    expression30=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expression30.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_array_close_in_array345);
            array_close31=array_close();

            state._fsp--;

            adaptor.addChild(root_0, array_close31.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:111:1: array_open : '[' -> ARRAY_OPEN ;
    public final TwigParser.array_open_return array_open() throws RecognitionException {
        TwigParser.array_open_return retval = new TwigParser.array_open_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal32=null;

        CommonTree char_literal32_tree=null;
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:112:3: ( '[' -> ARRAY_OPEN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:112:5: '['
            {
            char_literal32=(Token)match(input,39,FOLLOW_39_in_array_open360);  
            stream_39.add(char_literal32);


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
            // 112:9: -> ARRAY_OPEN
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:115:1: array_close : ']' -> ARRAY_CLOSE ;
    public final TwigParser.array_close_return array_close() throws RecognitionException {
        TwigParser.array_close_return retval = new TwigParser.array_close_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal33=null;

        CommonTree char_literal33_tree=null;
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:116:3: ( ']' -> ARRAY_CLOSE )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:116:5: ']'
            {
            char_literal33=(Token)match(input,40,FOLLOW_40_in_array_close379);  
            stream_40.add(char_literal33);


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
            // 116:9: -> ARRAY_CLOSE
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:119:1: hash : T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY ;
    public final TwigParser.hash_return hash() throws RecognitionException {
        TwigParser.hash_return retval = new TwigParser.hash_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_CURLY34=null;
        Token T_CLOSE_CURLY36=null;
        TwigParser.hash_body_return hash_body35 =null;


        CommonTree T_OPEN_CURLY34_tree=null;
        CommonTree T_CLOSE_CURLY36_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:120:3: ( T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:120:5: T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_CURLY34=(Token)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash400); 
            T_OPEN_CURLY34_tree = 
            (CommonTree)adaptor.create(T_OPEN_CURLY34)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_CURLY34_tree, root_0);


            pushFollow(FOLLOW_hash_body_in_hash403);
            hash_body35=hash_body();

            state._fsp--;

            adaptor.addChild(root_0, hash_body35.getTree());

            T_CLOSE_CURLY36=(Token)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash405); 
            T_CLOSE_CURLY36_tree = 
            (CommonTree)adaptor.create(T_CLOSE_CURLY36)
            ;
            adaptor.addChild(root_0, T_CLOSE_CURLY36_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:123:1: hash_body : hash_argument ( COMMA hash_argument )* ;
    public final TwigParser.hash_body_return hash_body() throws RecognitionException {
        TwigParser.hash_body_return retval = new TwigParser.hash_body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA38=null;
        TwigParser.hash_argument_return hash_argument37 =null;

        TwigParser.hash_argument_return hash_argument39 =null;


        CommonTree COMMA38_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:124:3: ( hash_argument ( COMMA hash_argument )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:124:5: hash_argument ( COMMA hash_argument )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_hash_argument_in_hash_body420);
            hash_argument37=hash_argument();

            state._fsp--;

            adaptor.addChild(root_0, hash_argument37.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:124:19: ( COMMA hash_argument )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==COMMA) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:124:20: COMMA hash_argument
            	    {
            	    COMMA38=(Token)match(input,COMMA,FOLLOW_COMMA_in_hash_body423); 
            	    COMMA38_tree = 
            	    (CommonTree)adaptor.create(COMMA38)
            	    ;
            	    adaptor.addChild(root_0, COMMA38_tree);


            	    pushFollow(FOLLOW_hash_argument_in_hash_body425);
            	    hash_argument39=hash_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, hash_argument39.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:127:1: hash_argument : expression COLON ! expression ;
    public final TwigParser.hash_argument_return hash_argument() throws RecognitionException {
        TwigParser.hash_argument_return retval = new TwigParser.hash_argument_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COLON41=null;
        TwigParser.expression_return expression40 =null;

        TwigParser.expression_return expression42 =null;


        CommonTree COLON41_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:128:3: ( expression COLON ! expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:128:5: expression COLON ! expression
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_hash_argument442);
            expression40=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression40.getTree());

            COLON41=(Token)match(input,COLON,FOLLOW_COLON_in_hash_argument444); 

            pushFollow(FOLLOW_expression_in_hash_argument447);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:131:1: term : ( ( IDENT -> ID ) ( ( T_OPEN_PAREN params T_CLOSE_PAREN -> ^( CALL ID params ) ) ( DOT expression -> ^( DISPATCH ^( LHS ^( CALL ID params ) ) ^( RHS expression ) ) )? | DOT expression -> ^( DISPATCH ^( LHS ID ) ^( RHS expression ) ) | PIPE expression -> ^( FILTER ^( LHS ID ) ^( RHS expression ) ) )? | NUMBER | STRING | SQ_STRING );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token IDENT43=null;
        Token T_OPEN_PAREN44=null;
        Token T_CLOSE_PAREN46=null;
        Token DOT47=null;
        Token DOT49=null;
        Token PIPE51=null;
        Token NUMBER53=null;
        Token STRING54=null;
        Token SQ_STRING55=null;
        TwigParser.params_return params45 =null;

        TwigParser.expression_return expression48 =null;

        TwigParser.expression_return expression50 =null;

        TwigParser.expression_return expression52 =null;


        CommonTree IDENT43_tree=null;
        CommonTree T_OPEN_PAREN44_tree=null;
        CommonTree T_CLOSE_PAREN46_tree=null;
        CommonTree DOT47_tree=null;
        CommonTree DOT49_tree=null;
        CommonTree PIPE51_tree=null;
        CommonTree NUMBER53_tree=null;
        CommonTree STRING54_tree=null;
        CommonTree SQ_STRING55_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
        RewriteRuleTokenStream stream_PIPE=new RewriteRuleTokenStream(adaptor,"token PIPE");
        RewriteRuleTokenStream stream_T_OPEN_PAREN=new RewriteRuleTokenStream(adaptor,"token T_OPEN_PAREN");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_T_CLOSE_PAREN=new RewriteRuleTokenStream(adaptor,"token T_CLOSE_PAREN");
        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_params=new RewriteRuleSubtreeStream(adaptor,"rule params");
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:3: ( ( IDENT -> ID ) ( ( T_OPEN_PAREN params T_CLOSE_PAREN -> ^( CALL ID params ) ) ( DOT expression -> ^( DISPATCH ^( LHS ^( CALL ID params ) ) ^( RHS expression ) ) )? | DOT expression -> ^( DISPATCH ^( LHS ID ) ^( RHS expression ) ) | PIPE expression -> ^( FILTER ^( LHS ID ) ^( RHS expression ) ) )? | NUMBER | STRING | SQ_STRING )
            int alt13=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt13=1;
                }
                break;
            case NUMBER:
                {
                alt13=2;
                }
                break;
            case STRING:
                {
                alt13=3;
                }
                break;
            case SQ_STRING:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }

            switch (alt13) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:5: ( IDENT -> ID ) ( ( T_OPEN_PAREN params T_CLOSE_PAREN -> ^( CALL ID params ) ) ( DOT expression -> ^( DISPATCH ^( LHS ^( CALL ID params ) ) ^( RHS expression ) ) )? | DOT expression -> ^( DISPATCH ^( LHS ID ) ^( RHS expression ) ) | PIPE expression -> ^( FILTER ^( LHS ID ) ^( RHS expression ) ) )?
                    {
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:5: ( IDENT -> ID )
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:6: IDENT
                    {
                    IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_term463);  
                    stream_IDENT.add(IDENT43);


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
                    // 132:12: -> ID
                    {
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(ID, "ID")
                        );

                    }


                    retval.tree = root_0;

                    }


                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:20: ( ( T_OPEN_PAREN params T_CLOSE_PAREN -> ^( CALL ID params ) ) ( DOT expression -> ^( DISPATCH ^( LHS ^( CALL ID params ) ) ^( RHS expression ) ) )? | DOT expression -> ^( DISPATCH ^( LHS ID ) ^( RHS expression ) ) | PIPE expression -> ^( FILTER ^( LHS ID ) ^( RHS expression ) ) )?
                    int alt12=4;
                    switch ( input.LA(1) ) {
                        case T_OPEN_PAREN:
                            {
                            alt12=1;
                            }
                            break;
                        case DOT:
                            {
                            alt12=2;
                            }
                            break;
                        case PIPE:
                            {
                            alt12=3;
                            }
                            break;
                    }

                    switch (alt12) {
                        case 1 :
                            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:22: ( T_OPEN_PAREN params T_CLOSE_PAREN -> ^( CALL ID params ) ) ( DOT expression -> ^( DISPATCH ^( LHS ^( CALL ID params ) ) ^( RHS expression ) ) )?
                            {
                            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:22: ( T_OPEN_PAREN params T_CLOSE_PAREN -> ^( CALL ID params ) )
                            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:23: T_OPEN_PAREN params T_CLOSE_PAREN
                            {
                            T_OPEN_PAREN44=(Token)match(input,T_OPEN_PAREN,FOLLOW_T_OPEN_PAREN_in_term474);  
                            stream_T_OPEN_PAREN.add(T_OPEN_PAREN44);


                            pushFollow(FOLLOW_params_in_term476);
                            params45=params();

                            state._fsp--;

                            stream_params.add(params45.getTree());

                            T_CLOSE_PAREN46=(Token)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_term478);  
                            stream_T_CLOSE_PAREN.add(T_CLOSE_PAREN46);


                            // AST REWRITE
                            // elements: params
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 132:57: -> ^( CALL ID params )
                            {
                                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:60: ^( CALL ID params )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(
                                (CommonTree)adaptor.create(CALL, "CALL")
                                , root_1);

                                adaptor.addChild(root_1, 
                                (CommonTree)adaptor.create(ID, "ID")
                                );

                                adaptor.addChild(root_1, stream_params.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }


                            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:79: ( DOT expression -> ^( DISPATCH ^( LHS ^( CALL ID params ) ) ^( RHS expression ) ) )?
                            int alt11=2;
                            int LA11_0 = input.LA(1);

                            if ( (LA11_0==DOT) ) {
                                alt11=1;
                            }
                            switch (alt11) {
                                case 1 :
                                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:80: DOT expression
                                    {
                                    DOT47=(Token)match(input,DOT,FOLLOW_DOT_in_term492);  
                                    stream_DOT.add(DOT47);


                                    pushFollow(FOLLOW_expression_in_term494);
                                    expression48=expression();

                                    state._fsp--;

                                    stream_expression.add(expression48.getTree());

                                    // AST REWRITE
                                    // elements: params, expression
                                    // token labels: 
                                    // rule labels: retval
                                    // token list labels: 
                                    // rule list labels: 
                                    // wildcard labels: 
                                    retval.tree = root_0;
                                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                                    root_0 = (CommonTree)adaptor.nil();
                                    // 132:95: -> ^( DISPATCH ^( LHS ^( CALL ID params ) ) ^( RHS expression ) )
                                    {
                                        // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:98: ^( DISPATCH ^( LHS ^( CALL ID params ) ) ^( RHS expression ) )
                                        {
                                        CommonTree root_1 = (CommonTree)adaptor.nil();
                                        root_1 = (CommonTree)adaptor.becomeRoot(
                                        (CommonTree)adaptor.create(DISPATCH, "DISPATCH")
                                        , root_1);

                                        // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:109: ^( LHS ^( CALL ID params ) )
                                        {
                                        CommonTree root_2 = (CommonTree)adaptor.nil();
                                        root_2 = (CommonTree)adaptor.becomeRoot(
                                        (CommonTree)adaptor.create(LHS, "LHS")
                                        , root_2);

                                        // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:115: ^( CALL ID params )
                                        {
                                        CommonTree root_3 = (CommonTree)adaptor.nil();
                                        root_3 = (CommonTree)adaptor.becomeRoot(
                                        (CommonTree)adaptor.create(CALL, "CALL")
                                        , root_3);

                                        adaptor.addChild(root_3, 
                                        (CommonTree)adaptor.create(ID, "ID")
                                        );

                                        adaptor.addChild(root_3, stream_params.nextTree());

                                        adaptor.addChild(root_2, root_3);
                                        }

                                        adaptor.addChild(root_1, root_2);
                                        }

                                        // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:134: ^( RHS expression )
                                        {
                                        CommonTree root_2 = (CommonTree)adaptor.nil();
                                        root_2 = (CommonTree)adaptor.becomeRoot(
                                        (CommonTree)adaptor.create(RHS, "RHS")
                                        , root_2);

                                        adaptor.addChild(root_2, stream_expression.nextTree());

                                        adaptor.addChild(root_1, root_2);
                                        }

                                        adaptor.addChild(root_0, root_1);
                                        }

                                    }


                                    retval.tree = root_0;

                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:133:25: DOT expression
                            {
                            DOT49=(Token)match(input,DOT,FOLLOW_DOT_in_term546);  
                            stream_DOT.add(DOT49);


                            pushFollow(FOLLOW_expression_in_term548);
                            expression50=expression();

                            state._fsp--;

                            stream_expression.add(expression50.getTree());

                            // AST REWRITE
                            // elements: expression
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 133:41: -> ^( DISPATCH ^( LHS ID ) ^( RHS expression ) )
                            {
                                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:133:44: ^( DISPATCH ^( LHS ID ) ^( RHS expression ) )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(
                                (CommonTree)adaptor.create(DISPATCH, "DISPATCH")
                                , root_1);

                                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:133:55: ^( LHS ID )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot(
                                (CommonTree)adaptor.create(LHS, "LHS")
                                , root_2);

                                adaptor.addChild(root_2, 
                                (CommonTree)adaptor.create(ID, "ID")
                                );

                                adaptor.addChild(root_1, root_2);
                                }

                                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:133:65: ^( RHS expression )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot(
                                (CommonTree)adaptor.create(RHS, "RHS")
                                , root_2);

                                adaptor.addChild(root_2, stream_expression.nextTree());

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;
                        case 3 :
                            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:134:25: PIPE expression
                            {
                            PIPE51=(Token)match(input,PIPE,FOLLOW_PIPE_in_term593);  
                            stream_PIPE.add(PIPE51);


                            pushFollow(FOLLOW_expression_in_term595);
                            expression52=expression();

                            state._fsp--;

                            stream_expression.add(expression52.getTree());

                            // AST REWRITE
                            // elements: expression
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (CommonTree)adaptor.nil();
                            // 134:42: -> ^( FILTER ^( LHS ID ) ^( RHS expression ) )
                            {
                                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:134:45: ^( FILTER ^( LHS ID ) ^( RHS expression ) )
                                {
                                CommonTree root_1 = (CommonTree)adaptor.nil();
                                root_1 = (CommonTree)adaptor.becomeRoot(
                                (CommonTree)adaptor.create(FILTER, "FILTER")
                                , root_1);

                                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:134:54: ^( LHS ID )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot(
                                (CommonTree)adaptor.create(LHS, "LHS")
                                , root_2);

                                adaptor.addChild(root_2, 
                                (CommonTree)adaptor.create(ID, "ID")
                                );

                                adaptor.addChild(root_1, root_2);
                                }

                                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:134:64: ^( RHS expression )
                                {
                                CommonTree root_2 = (CommonTree)adaptor.nil();
                                root_2 = (CommonTree)adaptor.becomeRoot(
                                (CommonTree)adaptor.create(RHS, "RHS")
                                , root_2);

                                adaptor.addChild(root_2, stream_expression.nextTree());

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:136:5: NUMBER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    NUMBER53=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term642); 
                    NUMBER53_tree = 
                    (CommonTree)adaptor.create(NUMBER53)
                    ;
                    adaptor.addChild(root_0, NUMBER53_tree);


                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:137:5: STRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    STRING54=(Token)match(input,STRING,FOLLOW_STRING_in_term648); 
                    STRING54_tree = 
                    (CommonTree)adaptor.create(STRING54)
                    ;
                    adaptor.addChild(root_0, STRING54_tree);


                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:138:5: SQ_STRING
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    SQ_STRING55=(Token)match(input,SQ_STRING,FOLLOW_SQ_STRING_in_term654); 
                    SQ_STRING55_tree = 
                    (CommonTree)adaptor.create(SQ_STRING55)
                    ;
                    adaptor.addChild(root_0, SQ_STRING55_tree);


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
    // $ANTLR end "term"

    // Delegated rules


 

    public static final BitSet FOLLOW_twig_print_in_template125 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_twig_block_in_template129 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_EOF_in_template133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print151 = new BitSet(new long[]{0x0000008486490000L});
    public static final BitSet FOLLOW_body_in_twig_print154 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block172 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_IDENT_in_twig_block174 = new BitSet(new long[]{0x0000008506490000L});
    public static final BitSet FOLLOW_body_in_twig_block177 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_body201 = new BitSet(new long[]{0x0000008406490202L});
    public static final BitSet FOLLOW_COMMA_in_body206 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_body211 = new BitSet(new long[]{0x0000008406490202L});
    public static final BitSet FOLLOW_expression_in_params228 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_COMMA_in_params231 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_params234 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_term_in_expression256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternary_in_expression274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMARK_in_ternary289 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_ternary292 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_ternary294 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_ternary296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_concat311 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_concat314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_open_in_array329 = new BitSet(new long[]{0x0000018406490000L});
    public static final BitSet FOLLOW_expression_in_array333 = new BitSet(new long[]{0x0000010000000200L});
    public static final BitSet FOLLOW_COMMA_in_array336 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_array339 = new BitSet(new long[]{0x0000010000000200L});
    public static final BitSet FOLLOW_array_close_in_array345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_array_open360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_array_close379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash400 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_hash_body_in_hash403 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_argument_in_hash_body420 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_COMMA_in_hash_body423 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_hash_argument_in_hash_body425 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_expression_in_hash_argument442 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_COLON_in_hash_argument444 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_hash_argument447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term463 = new BitSet(new long[]{0x0000000800201002L});
    public static final BitSet FOLLOW_T_OPEN_PAREN_in_term474 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_params_in_term476 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_term478 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_DOT_in_term492 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_term494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_term546 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_term548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE_in_term593 = new BitSet(new long[]{0x0000008406490000L});
    public static final BitSet FOLLOW_expression_in_term595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_term648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQ_STRING_in_term654 = new BitSet(new long[]{0x0000000000000002L});

}