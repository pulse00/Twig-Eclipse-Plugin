// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2012-01-02 23:59:12

  package com.dubture.twig.core.parser.ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "COLON", "COMMA", "DIGIT", "DOT", "ESC", "IDENT", "LETTER", "NUMBER", "PIPE", "QMARK", "RAW", "SQ_STRING", "STRING", "TILDE", "T_CLOSE_CMT", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "'['", "']'"
    };

    public static final int EOF=-1;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int ARRAY_CLOSE=4;
    public static final int ARRAY_OPEN=5;
    public static final int COLON=6;
    public static final int COMMA=7;
    public static final int DIGIT=8;
    public static final int DOT=9;
    public static final int ESC=10;
    public static final int IDENT=11;
    public static final int LETTER=12;
    public static final int NUMBER=13;
    public static final int PIPE=14;
    public static final int QMARK=15;
    public static final int RAW=16;
    public static final int SQ_STRING=17;
    public static final int STRING=18;
    public static final int TILDE=19;
    public static final int T_CLOSE_CMT=20;
    public static final int T_CLOSE_CURLY=21;
    public static final int T_CLOSE_PAREN=22;
    public static final int T_CLOSE_PRINT=23;
    public static final int T_CLOSE_STMT=24;
    public static final int T_OPEN_CMT=25;
    public static final int T_OPEN_CURLY=26;
    public static final int T_OPEN_PAREN=27;
    public static final int T_OPEN_PRINT=28;
    public static final int T_OPEN_STMT=29;
    public static final int WS=30;

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:61:1: template : ( twig_print | twig_block )* EOF !;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF3=null;
        TwigParser.twig_print_return twig_print1 =null;

        TwigParser.twig_block_return twig_block2 =null;


        CommonTree EOF3_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:3: ( ( twig_print | twig_block )* EOF !)
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:5: ( twig_print | twig_block )* EOF !
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:5: ( twig_print | twig_block )*
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
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:6: twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_template82);
            	    twig_print1=twig_print();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_print1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:19: twig_block
            	    {
            	    pushFollow(FOLLOW_twig_block_in_template86);
            	    twig_block2=twig_block();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_block2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_template90); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:65:1: twig_print : T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT ;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:3: ( T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:5: T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_PRINT4=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print108); 
            T_OPEN_PRINT4_tree = 
            (CommonTree)adaptor.create(T_OPEN_PRINT4)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_PRINT4_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:19: ( body )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==DOT||LA2_0==IDENT||(LA2_0 >= NUMBER && LA2_0 <= QMARK)||(LA2_0 >= SQ_STRING && LA2_0 <= STRING)||LA2_0==T_OPEN_CURLY||LA2_0==31) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:66:19: body
                    {
                    pushFollow(FOLLOW_body_in_twig_print111);
                    body5=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body5.getTree());

                    }
                    break;

            }


            T_CLOSE_PRINT6=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print114); 
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:69:1: twig_block : T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT ;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:70:3: ( T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:70:5: T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_STMT7=(Token)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block129); 
            T_OPEN_STMT7_tree = 
            (CommonTree)adaptor.create(T_OPEN_STMT7)
            ;
            adaptor.addChild(root_0, T_OPEN_STMT7_tree);


            IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_twig_block131); 
            IDENT8_tree = 
            (CommonTree)adaptor.create(IDENT8)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT8_tree, root_0);


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:70:24: ( body )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DOT||LA3_0==IDENT||(LA3_0 >= NUMBER && LA3_0 <= QMARK)||(LA3_0 >= SQ_STRING && LA3_0 <= STRING)||LA3_0==T_OPEN_CURLY||LA3_0==31) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:70:24: body
                    {
                    pushFollow(FOLLOW_body_in_twig_block134);
                    body9=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body9.getTree());

                    }
                    break;

            }


            T_CLOSE_STMT10=(Token)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block137); 
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:73:1: body : expression ( ( ( COMMA )? ) ! expression )* ;
    public final TwigParser.body_return body() throws RecognitionException {
        TwigParser.body_return retval = new TwigParser.body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA12=null;
        TwigParser.expression_return expression11 =null;

        TwigParser.expression_return expression13 =null;


        CommonTree COMMA12_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:3: ( expression ( ( ( COMMA )? ) ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:5: expression ( ( ( COMMA )? ) ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_body158);
            expression11=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression11.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:16: ( ( ( COMMA )? ) ! expression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA||LA5_0==DOT||LA5_0==IDENT||(LA5_0 >= NUMBER && LA5_0 <= QMARK)||(LA5_0 >= SQ_STRING && LA5_0 <= STRING)||LA5_0==T_OPEN_CURLY||LA5_0==31) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:18: ( ( COMMA )? ) ! expression
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:18: ( ( COMMA )? )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:19: ( COMMA )?
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:19: ( COMMA )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==COMMA) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:19: COMMA
            	            {
            	            COMMA12=(Token)match(input,COMMA,FOLLOW_COMMA_in_body163); 
            	            COMMA12_tree = 
            	            (CommonTree)adaptor.create(COMMA12)
            	            ;
            	            adaptor.addChild(root_0, COMMA12_tree);


            	            }
            	            break;

            	    }


            	    }


            	    pushFollow(FOLLOW_expression_in_body168);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:79:1: functionCallStatement : IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN ;
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
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:82:3: ( IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:82:5: IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionCallStatement192); 
            IDENT14_tree = 
            (CommonTree)adaptor.create(IDENT14)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT14_tree, root_0);


            T_OPEN_PAREN15=(Token)match(input,T_OPEN_PAREN,FOLLOW_T_OPEN_PAREN_in_functionCallStatement195); 

            pushFollow(FOLLOW_functionParameters_in_functionCallStatement198);
            functionParameters16=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, functionParameters16.getTree());

            T_CLOSE_PAREN17=(Token)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_functionCallStatement200); 
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:1: functionParameters : expression ( COMMA ! expression )* ;
    public final TwigParser.functionParameters_return functionParameters() throws RecognitionException {
        TwigParser.functionParameters_return retval = new TwigParser.functionParameters_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA19=null;
        TwigParser.expression_return expression18 =null;

        TwigParser.expression_return expression20 =null;


        CommonTree COMMA19_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:86:3: ( expression ( COMMA ! expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:86:5: expression ( COMMA ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_functionParameters215);
            expression18=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression18.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:86:16: ( COMMA ! expression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:86:17: COMMA ! expression
            	    {
            	    COMMA19=(Token)match(input,COMMA,FOLLOW_COMMA_in_functionParameters218); 

            	    pushFollow(FOLLOW_expression_in_functionParameters221);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:89:1: expression : ( term | functionCallStatement | hash | array | variable_access | filter | ternary );
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.term_return term21 =null;

        TwigParser.functionCallStatement_return functionCallStatement22 =null;

        TwigParser.hash_return hash23 =null;

        TwigParser.array_return array24 =null;

        TwigParser.variable_access_return variable_access25 =null;

        TwigParser.filter_return filter26 =null;

        TwigParser.ternary_return ternary27 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:90:3: ( term | functionCallStatement | hash | array | variable_access | filter | ternary )
            int alt7=7;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==T_OPEN_PAREN) ) {
                    alt7=2;
                }
                else if ( (LA7_1==EOF||(LA7_1 >= COLON && LA7_1 <= COMMA)||LA7_1==DOT||LA7_1==IDENT||(LA7_1 >= NUMBER && LA7_1 <= QMARK)||(LA7_1 >= SQ_STRING && LA7_1 <= STRING)||(LA7_1 >= T_CLOSE_CURLY && LA7_1 <= T_CLOSE_STMT)||LA7_1==T_OPEN_CURLY||(LA7_1 >= 31 && LA7_1 <= 32)) ) {
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
            case SQ_STRING:
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
            case 31:
                {
                alt7=4;
                }
                break;
            case DOT:
                {
                alt7=5;
                }
                break;
            case PIPE:
                {
                alt7=6;
                }
                break;
            case QMARK:
                {
                alt7=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:90:5: term
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_term_in_expression243);
                    term21=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term21.getTree());

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:91:5: functionCallStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionCallStatement_in_expression249);
                    functionCallStatement22=functionCallStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCallStatement22.getTree());

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:92:5: hash
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_hash_in_expression255);
                    hash23=hash();

                    state._fsp--;

                    adaptor.addChild(root_0, hash23.getTree());

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:93:5: array
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_array_in_expression261);
                    array24=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array24.getTree());

                    }
                    break;
                case 5 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:94:5: variable_access
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_variable_access_in_expression267);
                    variable_access25=variable_access();

                    state._fsp--;

                    adaptor.addChild(root_0, variable_access25.getTree());

                    }
                    break;
                case 6 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:95:5: filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_filter_in_expression273);
                    filter26=filter();

                    state._fsp--;

                    adaptor.addChild(root_0, filter26.getTree());

                    }
                    break;
                case 7 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:96:5: ternary
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_ternary_in_expression279);
                    ternary27=ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, ternary27.getTree());

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

        Token QMARK28=null;
        Token COLON30=null;
        TwigParser.expression_return expression29 =null;

        TwigParser.expression_return expression31 =null;


        CommonTree QMARK28_tree=null;
        CommonTree COLON30_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:100:3: ( QMARK ^ expression COLON expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:100:5: QMARK ^ expression COLON expression
            {
            root_0 = (CommonTree)adaptor.nil();


            QMARK28=(Token)match(input,QMARK,FOLLOW_QMARK_in_ternary294); 
            QMARK28_tree = 
            (CommonTree)adaptor.create(QMARK28)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(QMARK28_tree, root_0);


            pushFollow(FOLLOW_expression_in_ternary297);
            expression29=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression29.getTree());

            COLON30=(Token)match(input,COLON,FOLLOW_COLON_in_ternary299); 
            COLON30_tree = 
            (CommonTree)adaptor.create(COLON30)
            ;
            adaptor.addChild(root_0, COLON30_tree);


            pushFollow(FOLLOW_expression_in_ternary301);
            expression31=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression31.getTree());

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

        Token TILDE32=null;
        TwigParser.expression_return expression33 =null;


        CommonTree TILDE32_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:104:3: ( TILDE ^ expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:104:5: TILDE ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            TILDE32=(Token)match(input,TILDE,FOLLOW_TILDE_in_concat316); 
            TILDE32_tree = 
            (CommonTree)adaptor.create(TILDE32)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(TILDE32_tree, root_0);


            pushFollow(FOLLOW_expression_in_concat319);
            expression33=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression33.getTree());

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


    public static class filter_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:107:1: filter : PIPE ^ expression ;
    public final TwigParser.filter_return filter() throws RecognitionException {
        TwigParser.filter_return retval = new TwigParser.filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token PIPE34=null;
        TwigParser.expression_return expression35 =null;


        CommonTree PIPE34_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:3: ( PIPE ^ expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:108:5: PIPE ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            PIPE34=(Token)match(input,PIPE,FOLLOW_PIPE_in_filter334); 
            PIPE34_tree = 
            (CommonTree)adaptor.create(PIPE34)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(PIPE34_tree, root_0);


            pushFollow(FOLLOW_expression_in_filter337);
            expression35=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression35.getTree());

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
    // $ANTLR end "filter"


    public static class variable_access_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variable_access"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:111:1: variable_access : DOT ^ expression ;
    public final TwigParser.variable_access_return variable_access() throws RecognitionException {
        TwigParser.variable_access_return retval = new TwigParser.variable_access_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DOT36=null;
        TwigParser.expression_return expression37 =null;


        CommonTree DOT36_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:112:3: ( DOT ^ expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:112:5: DOT ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            DOT36=(Token)match(input,DOT,FOLLOW_DOT_in_variable_access352); 
            DOT36_tree = 
            (CommonTree)adaptor.create(DOT36)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(DOT36_tree, root_0);


            pushFollow(FOLLOW_expression_in_variable_access355);
            expression37=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression37.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:115:1: array : array_open ^ ( expression ( COMMA ! expression )* )? array_close ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA40=null;
        TwigParser.array_open_return array_open38 =null;

        TwigParser.expression_return expression39 =null;

        TwigParser.expression_return expression41 =null;

        TwigParser.array_close_return array_close42 =null;


        CommonTree COMMA40_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:116:3: ( array_open ^ ( expression ( COMMA ! expression )* )? array_close )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:116:5: array_open ^ ( expression ( COMMA ! expression )* )? array_close
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_array_open_in_array370);
            array_open38=array_open();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(array_open38.getTree(), root_0);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:116:17: ( expression ( COMMA ! expression )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==DOT||LA9_0==IDENT||(LA9_0 >= NUMBER && LA9_0 <= QMARK)||(LA9_0 >= SQ_STRING && LA9_0 <= STRING)||LA9_0==T_OPEN_CURLY||LA9_0==31) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:116:18: expression ( COMMA ! expression )*
                    {
                    pushFollow(FOLLOW_expression_in_array374);
                    expression39=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression39.getTree());

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:116:29: ( COMMA ! expression )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:116:30: COMMA ! expression
                    	    {
                    	    COMMA40=(Token)match(input,COMMA,FOLLOW_COMMA_in_array377); 

                    	    pushFollow(FOLLOW_expression_in_array380);
                    	    expression41=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expression41.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }


            pushFollow(FOLLOW_array_close_in_array386);
            array_close42=array_close();

            state._fsp--;

            adaptor.addChild(root_0, array_close42.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:119:1: array_open : '[' -> ARRAY_OPEN ;
    public final TwigParser.array_open_return array_open() throws RecognitionException {
        TwigParser.array_open_return retval = new TwigParser.array_open_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal43=null;

        CommonTree char_literal43_tree=null;
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:120:3: ( '[' -> ARRAY_OPEN )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:120:5: '['
            {
            char_literal43=(Token)match(input,31,FOLLOW_31_in_array_open401);  
            stream_31.add(char_literal43);


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
            // 120:9: -> ARRAY_OPEN
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:123:1: array_close : ']' -> ARRAY_CLOSE ;
    public final TwigParser.array_close_return array_close() throws RecognitionException {
        TwigParser.array_close_return retval = new TwigParser.array_close_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal44=null;

        CommonTree char_literal44_tree=null;
        RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:124:3: ( ']' -> ARRAY_CLOSE )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:124:5: ']'
            {
            char_literal44=(Token)match(input,32,FOLLOW_32_in_array_close420);  
            stream_32.add(char_literal44);


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
            // 124:9: -> ARRAY_CLOSE
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:127:1: hash : T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY ;
    public final TwigParser.hash_return hash() throws RecognitionException {
        TwigParser.hash_return retval = new TwigParser.hash_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_CURLY45=null;
        Token T_CLOSE_CURLY47=null;
        TwigParser.hash_body_return hash_body46 =null;


        CommonTree T_OPEN_CURLY45_tree=null;
        CommonTree T_CLOSE_CURLY47_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:128:3: ( T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:128:5: T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY
            {
            root_0 = (CommonTree)adaptor.nil();


            T_OPEN_CURLY45=(Token)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash441); 
            T_OPEN_CURLY45_tree = 
            (CommonTree)adaptor.create(T_OPEN_CURLY45)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_CURLY45_tree, root_0);


            pushFollow(FOLLOW_hash_body_in_hash444);
            hash_body46=hash_body();

            state._fsp--;

            adaptor.addChild(root_0, hash_body46.getTree());

            T_CLOSE_CURLY47=(Token)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash446); 
            T_CLOSE_CURLY47_tree = 
            (CommonTree)adaptor.create(T_CLOSE_CURLY47)
            ;
            adaptor.addChild(root_0, T_CLOSE_CURLY47_tree);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:131:1: hash_body : hash_argument ( COMMA hash_argument )* ;
    public final TwigParser.hash_body_return hash_body() throws RecognitionException {
        TwigParser.hash_body_return retval = new TwigParser.hash_body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COMMA49=null;
        TwigParser.hash_argument_return hash_argument48 =null;

        TwigParser.hash_argument_return hash_argument50 =null;


        CommonTree COMMA49_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:3: ( hash_argument ( COMMA hash_argument )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:5: hash_argument ( COMMA hash_argument )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_hash_argument_in_hash_body461);
            hash_argument48=hash_argument();

            state._fsp--;

            adaptor.addChild(root_0, hash_argument48.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:19: ( COMMA hash_argument )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==COMMA) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:132:20: COMMA hash_argument
            	    {
            	    COMMA49=(Token)match(input,COMMA,FOLLOW_COMMA_in_hash_body464); 
            	    COMMA49_tree = 
            	    (CommonTree)adaptor.create(COMMA49)
            	    ;
            	    adaptor.addChild(root_0, COMMA49_tree);


            	    pushFollow(FOLLOW_hash_argument_in_hash_body466);
            	    hash_argument50=hash_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, hash_argument50.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:135:1: hash_argument : expression COLON ! expression ;
    public final TwigParser.hash_argument_return hash_argument() throws RecognitionException {
        TwigParser.hash_argument_return retval = new TwigParser.hash_argument_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COLON52=null;
        TwigParser.expression_return expression51 =null;

        TwigParser.expression_return expression53 =null;


        CommonTree COLON52_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:136:3: ( expression COLON ! expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:136:5: expression COLON ! expression
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_hash_argument483);
            expression51=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression51.getTree());

            COLON52=(Token)match(input,COLON,FOLLOW_COLON_in_hash_argument485); 

            pushFollow(FOLLOW_expression_in_hash_argument488);
            expression53=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression53.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:139:1: term : ( IDENT | NUMBER | STRING | SQ_STRING );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set54=null;

        CommonTree set54_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:140:3: ( IDENT | NUMBER | STRING | SQ_STRING )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set54=(Token)input.LT(1);

            if ( input.LA(1)==IDENT||input.LA(1)==NUMBER||(input.LA(1) >= SQ_STRING && input.LA(1) <= STRING) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set54)
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


 

    public static final BitSet FOLLOW_twig_print_in_template82 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_twig_block_in_template86 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_EOF_in_template90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print108 = new BitSet(new long[]{0x000000008486EA00L});
    public static final BitSet FOLLOW_body_in_twig_print111 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block129 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_twig_block131 = new BitSet(new long[]{0x000000008506EA00L});
    public static final BitSet FOLLOW_body_in_twig_block134 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_body158 = new BitSet(new long[]{0x000000008406EA82L});
    public static final BitSet FOLLOW_COMMA_in_body163 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_expression_in_body168 = new BitSet(new long[]{0x000000008406EA82L});
    public static final BitSet FOLLOW_IDENT_in_functionCallStatement192 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_T_OPEN_PAREN_in_functionCallStatement195 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement198 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_functionCallStatement200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters215 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_COMMA_in_functionParameters218 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_expression_in_functionParameters221 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_term_in_expression243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_access_in_expression267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_in_expression273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternary_in_expression279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMARK_in_ternary294 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_expression_in_ternary297 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLON_in_ternary299 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_expression_in_ternary301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_concat316 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_expression_in_concat319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE_in_filter334 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_expression_in_filter337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_variable_access352 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_expression_in_variable_access355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_open_in_array370 = new BitSet(new long[]{0x000000018406EA00L});
    public static final BitSet FOLLOW_expression_in_array374 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_COMMA_in_array377 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_expression_in_array380 = new BitSet(new long[]{0x0000000100000080L});
    public static final BitSet FOLLOW_array_close_in_array386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_array_open401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_array_close420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash441 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_hash_body_in_hash444 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_argument_in_hash_body461 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_COMMA_in_hash_body464 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_hash_argument_in_hash_body466 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_expression_in_hash_argument483 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLON_in_hash_argument485 = new BitSet(new long[]{0x000000008406EA00L});
    public static final BitSet FOLLOW_expression_in_hash_argument488 = new BitSet(new long[]{0x0000000000000002L});

}