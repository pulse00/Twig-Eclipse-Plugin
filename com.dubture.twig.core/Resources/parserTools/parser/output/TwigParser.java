// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g 2012-01-01 21:47:38

  package com.dubture.twig.core.parser.ast;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "COLON", "DIGIT", "DOT", "ESC", "IDENT", "LETTER", "NUMBER", "PIPE", "PUNCTUATION", "RAW", "SQ_STRING", "STRING", "TWIG_VAR", "T_CLOSE_CMT", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','", "'['", "']'", "'~'"
    };

    public static final int EOF=-1;
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
    public static final int PIPE=13;
    public static final int PUNCTUATION=14;
    public static final int RAW=15;
    public static final int SQ_STRING=16;
    public static final int STRING=17;
    public static final int TWIG_VAR=18;
    public static final int T_CLOSE_CMT=19;
    public static final int T_CLOSE_CURLY=20;
    public static final int T_CLOSE_PAREN=21;
    public static final int T_CLOSE_PRINT=22;
    public static final int T_CLOSE_STMT=23;
    public static final int T_OPEN_CMT=24;
    public static final int T_OPEN_CURLY=25;
    public static final int T_OPEN_PAREN=26;
    public static final int T_OPEN_PRINT=27;
    public static final int T_OPEN_STMT=28;
    public static final int WS=29;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "hash", "hash_body", "variable_access", "template", "body", 
    "functionCallStatement", "array_open", "array_close", "expression", 
    "twig_block", "twig_print", "hash_argument", "functionParameters", "term", 
    "filter", "array"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public TwigParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public TwigParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this,port,adaptor);
        setDebugListener(proxy);
        setTokenStream(new DebugTokenStream(input,proxy));
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);
        proxy.setTreeAdaptor(adap);
    }

public TwigParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg);
     
    TreeAdaptor adap = new CommonTreeAdaptor();
    setTreeAdaptor(adap);


}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

protected DebugTreeAdaptor adaptor;
public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = new DebugTreeAdaptor(dbg,adaptor);


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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:47:1: template : ( twig_print | twig_block )* EOF !;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF3=null;
        TwigParser.twig_print_return twig_print1 =null;

        TwigParser.twig_block_return twig_block2 =null;


        CommonTree EOF3_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "template");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(47, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:3: ( ( twig_print | twig_block )* EOF !)
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:5: ( twig_print | twig_block )* EOF !
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(48,5);
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:5: ( twig_print | twig_block )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=3;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==T_OPEN_PRINT) ) {
                    alt1=1;
                }
                else if ( (LA1_0==T_OPEN_STMT) ) {
                    alt1=2;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:6: twig_print
            	    {
            	    dbg.location(48,6);
            	    pushFollow(FOLLOW_twig_print_in_template87);
            	    twig_print1=twig_print();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_print1.getTree());

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:48:19: twig_block
            	    {
            	    dbg.location(48,19);
            	    pushFollow(FOLLOW_twig_block_in_template91);
            	    twig_block2=twig_block();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_block2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(48,35);
            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_template95); 

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
        dbg.location(49, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "template");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "template"


    public static class twig_print_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "twig_print"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:51:1: twig_print : T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_PRINT4=null;
        Token T_CLOSE_PRINT6=null;
        TwigParser.body_return body5 =null;


        CommonTree T_OPEN_PRINT4_tree=null;
        CommonTree T_CLOSE_PRINT6_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "twig_print");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(51, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:3: ( T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:5: T_OPEN_PRINT ^ ( body )? T_CLOSE_PRINT
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(52,17);
            T_OPEN_PRINT4=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print113); 
            T_OPEN_PRINT4_tree = 
            (CommonTree)adaptor.create(T_OPEN_PRINT4)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_PRINT4_tree, root_0);

            dbg.location(52,19);
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:19: ( body )?
            int alt2=2;
            try { dbg.enterSubRule(2);
            try { dbg.enterDecision(2, decisionCanBacktrack[2]);

            int LA2_0 = input.LA(1);

            if ( (LA2_0==DOT||LA2_0==IDENT||(LA2_0 >= NUMBER && LA2_0 <= PIPE)||(LA2_0 >= SQ_STRING && LA2_0 <= STRING)||LA2_0==T_OPEN_CURLY||LA2_0==31) ) {
                alt2=1;
            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:52:19: body
                    {
                    dbg.location(52,19);
                    pushFollow(FOLLOW_body_in_twig_print116);
                    body5=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body5.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(2);}

            dbg.location(52,25);
            T_CLOSE_PRINT6=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print119); 
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
        dbg.location(53, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "twig_print");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "twig_print"


    public static class twig_block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "twig_block"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:55:1: twig_block : T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT ;
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

        try { dbg.enterRule(getGrammarFileName(), "twig_block");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(55, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:3: ( T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:5: T_OPEN_STMT IDENT ^ ( body )? T_CLOSE_STMT
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(56,5);
            T_OPEN_STMT7=(Token)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block134); 
            T_OPEN_STMT7_tree = 
            (CommonTree)adaptor.create(T_OPEN_STMT7)
            ;
            adaptor.addChild(root_0, T_OPEN_STMT7_tree);

            dbg.location(56,22);
            IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_twig_block136); 
            IDENT8_tree = 
            (CommonTree)adaptor.create(IDENT8)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT8_tree, root_0);

            dbg.location(56,25);
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:25: ( body )?
            int alt3=2;
            try { dbg.enterSubRule(3);
            try { dbg.enterDecision(3, decisionCanBacktrack[3]);

            int LA3_0 = input.LA(1);

            if ( (LA3_0==DOT||LA3_0==IDENT||(LA3_0 >= NUMBER && LA3_0 <= PIPE)||(LA3_0 >= SQ_STRING && LA3_0 <= STRING)||LA3_0==T_OPEN_CURLY||LA3_0==31) ) {
                alt3=1;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:56:25: body
                    {
                    dbg.location(56,25);
                    pushFollow(FOLLOW_body_in_twig_block140);
                    body9=body();

                    state._fsp--;

                    adaptor.addChild(root_0, body9.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}

            dbg.location(56,31);
            T_CLOSE_STMT10=(Token)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block143); 
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
        dbg.location(57, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "twig_block");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "twig_block"


    public static class body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "body"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:59:1: body : expression ( ( ( ',' | '~' )? ) ! expression )* ;
    public final TwigParser.body_return body() throws RecognitionException {
        TwigParser.body_return retval = new TwigParser.body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set12=null;
        TwigParser.expression_return expression11 =null;

        TwigParser.expression_return expression13 =null;


        CommonTree set12_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(59, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:3: ( expression ( ( ( ',' | '~' )? ) ! expression )* )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:5: expression ( ( ( ',' | '~' )? ) ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(62,5);
            pushFollow(FOLLOW_expression_in_body164);
            expression11=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression11.getTree());
            dbg.location(62,16);
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:16: ( ( ( ',' | '~' )? ) ! expression )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==DOT||LA5_0==IDENT||(LA5_0 >= NUMBER && LA5_0 <= PIPE)||(LA5_0 >= SQ_STRING && LA5_0 <= STRING)||LA5_0==T_OPEN_CURLY||(LA5_0 >= 30 && LA5_0 <= 31)||LA5_0==33) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:18: ( ( ',' | '~' )? ) ! expression
            	    {
            	    dbg.location(62,33);
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:18: ( ( ',' | '~' )? )
            	    dbg.enterAlt(1);

            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:19: ( ',' | '~' )?
            	    {
            	    dbg.location(62,19);
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:62:19: ( ',' | '~' )?
            	    int alt4=2;
            	    try { dbg.enterSubRule(4);
            	    try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==30||LA4_0==33) ) {
            	        alt4=1;
            	    }
            	    } finally {dbg.exitDecision(4);}

            	    switch (alt4) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            	            {
            	            dbg.location(62,19);
            	            set12=(Token)input.LT(1);

            	            if ( input.LA(1)==30||input.LA(1)==33 ) {
            	                input.consume();
            	                adaptor.addChild(root_0, 
            	                (CommonTree)adaptor.create(set12)
            	                );
            	                state.errorRecovery=false;
            	            }
            	            else {
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                dbg.recognitionException(mse);
            	                throw mse;
            	            }


            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(4);}


            	    }

            	    dbg.location(62,35);
            	    pushFollow(FOLLOW_expression_in_body181);
            	    expression13=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression13.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);
            } finally {dbg.exitSubRule(5);}


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
        dbg.location(63, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "body"


    public static class functionCallStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCallStatement"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:65:1: functionCallStatement : IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN ;
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

        try { dbg.enterRule(getGrammarFileName(), "functionCallStatement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(65, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:68:3: ( IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:68:5: IDENT ^ T_OPEN_PAREN ! functionParameters T_CLOSE_PAREN
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(68,10);
            IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionCallStatement205); 
            IDENT14_tree = 
            (CommonTree)adaptor.create(IDENT14)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(IDENT14_tree, root_0);

            dbg.location(68,24);
            T_OPEN_PAREN15=(Token)match(input,T_OPEN_PAREN,FOLLOW_T_OPEN_PAREN_in_functionCallStatement208); 
            dbg.location(68,26);
            pushFollow(FOLLOW_functionParameters_in_functionCallStatement211);
            functionParameters16=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, functionParameters16.getTree());
            dbg.location(68,45);
            T_CLOSE_PAREN17=(Token)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_functionCallStatement213); 
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
        dbg.location(69, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "functionCallStatement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "functionCallStatement"


    public static class functionParameters_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionParameters"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:71:1: functionParameters : expression ( ',' ! expression )* ;
    public final TwigParser.functionParameters_return functionParameters() throws RecognitionException {
        TwigParser.functionParameters_return retval = new TwigParser.functionParameters_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal19=null;
        TwigParser.expression_return expression18 =null;

        TwigParser.expression_return expression20 =null;


        CommonTree char_literal19_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "functionParameters");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(71, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:72:3: ( expression ( ',' ! expression )* )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:72:5: expression ( ',' ! expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(72,5);
            pushFollow(FOLLOW_expression_in_functionParameters228);
            expression18=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression18.getTree());
            dbg.location(72,16);
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:72:16: ( ',' ! expression )*
            try { dbg.enterSubRule(6);

            loop6:
            do {
                int alt6=2;
                try { dbg.enterDecision(6, decisionCanBacktrack[6]);

                int LA6_0 = input.LA(1);

                if ( (LA6_0==30) ) {
                    alt6=1;
                }


                } finally {dbg.exitDecision(6);}

                switch (alt6) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:72:17: ',' ! expression
            	    {
            	    dbg.location(72,20);
            	    char_literal19=(Token)match(input,30,FOLLOW_30_in_functionParameters231); 
            	    dbg.location(72,22);
            	    pushFollow(FOLLOW_expression_in_functionParameters234);
            	    expression20=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression20.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);
            } finally {dbg.exitSubRule(6);}


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
        dbg.location(73, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "functionParameters");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "functionParameters"


    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:75:1: expression : ( term | functionCallStatement | hash | array | variable_access | filter );
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



        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(75, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:3: ( term | functionCallStatement | hash | array | variable_access | filter )
            int alt7=6;
            try { dbg.enterDecision(7, decisionCanBacktrack[7]);

            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==T_OPEN_PAREN) ) {
                    alt7=2;
                }
                else if ( (LA7_1==COLON||LA7_1==DOT||LA7_1==IDENT||(LA7_1 >= NUMBER && LA7_1 <= PIPE)||(LA7_1 >= SQ_STRING && LA7_1 <= STRING)||(LA7_1 >= T_CLOSE_CURLY && LA7_1 <= T_CLOSE_STMT)||LA7_1==T_OPEN_CURLY||(LA7_1 >= 30 && LA7_1 <= 33)) ) {
                    alt7=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    dbg.recognitionException(nvae);
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(7);}

            switch (alt7) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:76:5: term
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(76,5);
                    pushFollow(FOLLOW_term_in_expression256);
                    term21=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term21.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:77:5: functionCallStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(77,5);
                    pushFollow(FOLLOW_functionCallStatement_in_expression262);
                    functionCallStatement22=functionCallStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCallStatement22.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:78:5: hash
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(78,5);
                    pushFollow(FOLLOW_hash_in_expression268);
                    hash23=hash();

                    state._fsp--;

                    adaptor.addChild(root_0, hash23.getTree());

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:79:5: array
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(79,5);
                    pushFollow(FOLLOW_array_in_expression274);
                    array24=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array24.getTree());

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:80:5: variable_access
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(80,5);
                    pushFollow(FOLLOW_variable_access_in_expression280);
                    variable_access25=variable_access();

                    state._fsp--;

                    adaptor.addChild(root_0, variable_access25.getTree());

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:81:5: filter
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    dbg.location(81,5);
                    pushFollow(FOLLOW_filter_in_expression286);
                    filter26=filter();

                    state._fsp--;

                    adaptor.addChild(root_0, filter26.getTree());

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
        dbg.location(82, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expression"


    public static class filter_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "filter"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:85:1: filter : PIPE ^ expression ;
    public final TwigParser.filter_return filter() throws RecognitionException {
        TwigParser.filter_return retval = new TwigParser.filter_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token PIPE27=null;
        TwigParser.expression_return expression28 =null;


        CommonTree PIPE27_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "filter");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(85, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:86:3: ( PIPE ^ expression )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:86:5: PIPE ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(86,9);
            PIPE27=(Token)match(input,PIPE,FOLLOW_PIPE_in_filter304); 
            PIPE27_tree = 
            (CommonTree)adaptor.create(PIPE27)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(PIPE27_tree, root_0);

            dbg.location(86,11);
            pushFollow(FOLLOW_expression_in_filter307);
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
        dbg.location(87, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "filter");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "filter"


    public static class variable_access_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "variable_access"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:89:1: variable_access : DOT ^ expression ;
    public final TwigParser.variable_access_return variable_access() throws RecognitionException {
        TwigParser.variable_access_return retval = new TwigParser.variable_access_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DOT29=null;
        TwigParser.expression_return expression30 =null;


        CommonTree DOT29_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "variable_access");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(89, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:90:3: ( DOT ^ expression )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:90:5: DOT ^ expression
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(90,8);
            DOT29=(Token)match(input,DOT,FOLLOW_DOT_in_variable_access322); 
            DOT29_tree = 
            (CommonTree)adaptor.create(DOT29)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(DOT29_tree, root_0);

            dbg.location(90,10);
            pushFollow(FOLLOW_expression_in_variable_access325);
            expression30=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression30.getTree());

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
        dbg.location(91, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "variable_access");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "variable_access"


    public static class array_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:94:1: array : array_open ^ ( expression ( ',' ! expression )* )? array_close ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal33=null;
        TwigParser.array_open_return array_open31 =null;

        TwigParser.expression_return expression32 =null;

        TwigParser.expression_return expression34 =null;

        TwigParser.array_close_return array_close35 =null;


        CommonTree char_literal33_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "array");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(94, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:95:3: ( array_open ^ ( expression ( ',' ! expression )* )? array_close )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:95:5: array_open ^ ( expression ( ',' ! expression )* )? array_close
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(95,15);
            pushFollow(FOLLOW_array_open_in_array343);
            array_open31=array_open();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(array_open31.getTree(), root_0);
            dbg.location(95,17);
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:95:17: ( expression ( ',' ! expression )* )?
            int alt9=2;
            try { dbg.enterSubRule(9);
            try { dbg.enterDecision(9, decisionCanBacktrack[9]);

            int LA9_0 = input.LA(1);

            if ( (LA9_0==DOT||LA9_0==IDENT||(LA9_0 >= NUMBER && LA9_0 <= PIPE)||(LA9_0 >= SQ_STRING && LA9_0 <= STRING)||LA9_0==T_OPEN_CURLY||LA9_0==31) ) {
                alt9=1;
            }
            } finally {dbg.exitDecision(9);}

            switch (alt9) {
                case 1 :
                    dbg.enterAlt(1);

                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:95:18: expression ( ',' ! expression )*
                    {
                    dbg.location(95,18);
                    pushFollow(FOLLOW_expression_in_array347);
                    expression32=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression32.getTree());
                    dbg.location(95,29);
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:95:29: ( ',' ! expression )*
                    try { dbg.enterSubRule(8);

                    loop8:
                    do {
                        int alt8=2;
                        try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==30) ) {
                            alt8=1;
                        }


                        } finally {dbg.exitDecision(8);}

                        switch (alt8) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:95:30: ',' ! expression
                    	    {
                    	    dbg.location(95,33);
                    	    char_literal33=(Token)match(input,30,FOLLOW_30_in_array350); 
                    	    dbg.location(95,35);
                    	    pushFollow(FOLLOW_expression_in_array353);
                    	    expression34=expression();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, expression34.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(8);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(9);}

            dbg.location(95,50);
            pushFollow(FOLLOW_array_close_in_array359);
            array_close35=array_close();

            state._fsp--;

            adaptor.addChild(root_0, array_close35.getTree());

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
        dbg.location(96, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "array"


    public static class array_open_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array_open"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:98:1: array_open : '[' -> ARRAY_OPEN ;
    public final TwigParser.array_open_return array_open() throws RecognitionException {
        TwigParser.array_open_return retval = new TwigParser.array_open_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal36=null;

        CommonTree char_literal36_tree=null;
        RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");

        try { dbg.enterRule(getGrammarFileName(), "array_open");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(98, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:99:3: ( '[' -> ARRAY_OPEN )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:99:5: '['
            {
            dbg.location(99,5);
            char_literal36=(Token)match(input,31,FOLLOW_31_in_array_open374);  
            stream_31.add(char_literal36);


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
            // 99:9: -> ARRAY_OPEN
            {
                dbg.location(99,12);
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
        dbg.location(100, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_open");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "array_open"


    public static class array_close_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "array_close"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:102:1: array_close : ']' -> ARRAY_CLOSE ;
    public final TwigParser.array_close_return array_close() throws RecognitionException {
        TwigParser.array_close_return retval = new TwigParser.array_close_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal37=null;

        CommonTree char_literal37_tree=null;
        RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");

        try { dbg.enterRule(getGrammarFileName(), "array_close");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(102, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:103:3: ( ']' -> ARRAY_CLOSE )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:103:5: ']'
            {
            dbg.location(103,5);
            char_literal37=(Token)match(input,32,FOLLOW_32_in_array_close393);  
            stream_32.add(char_literal37);


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
            // 103:9: -> ARRAY_CLOSE
            {
                dbg.location(103,12);
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
        dbg.location(104, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "array_close");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "array_close"


    public static class hash_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hash"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:106:1: hash : T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY ;
    public final TwigParser.hash_return hash() throws RecognitionException {
        TwigParser.hash_return retval = new TwigParser.hash_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_CURLY38=null;
        Token T_CLOSE_CURLY40=null;
        TwigParser.hash_body_return hash_body39 =null;


        CommonTree T_OPEN_CURLY38_tree=null;
        CommonTree T_CLOSE_CURLY40_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "hash");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(106, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:107:3: ( T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:107:5: T_OPEN_CURLY ^ hash_body T_CLOSE_CURLY
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(107,17);
            T_OPEN_CURLY38=(Token)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash414); 
            T_OPEN_CURLY38_tree = 
            (CommonTree)adaptor.create(T_OPEN_CURLY38)
            ;
            root_0 = (CommonTree)adaptor.becomeRoot(T_OPEN_CURLY38_tree, root_0);

            dbg.location(107,19);
            pushFollow(FOLLOW_hash_body_in_hash417);
            hash_body39=hash_body();

            state._fsp--;

            adaptor.addChild(root_0, hash_body39.getTree());
            dbg.location(107,29);
            T_CLOSE_CURLY40=(Token)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash419); 
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
        dbg.location(108, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "hash");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "hash"


    public static class hash_body_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hash_body"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:110:1: hash_body : hash_argument ( ',' hash_argument )* ;
    public final TwigParser.hash_body_return hash_body() throws RecognitionException {
        TwigParser.hash_body_return retval = new TwigParser.hash_body_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal42=null;
        TwigParser.hash_argument_return hash_argument41 =null;

        TwigParser.hash_argument_return hash_argument43 =null;


        CommonTree char_literal42_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "hash_body");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(110, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:111:3: ( hash_argument ( ',' hash_argument )* )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:111:5: hash_argument ( ',' hash_argument )*
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(111,5);
            pushFollow(FOLLOW_hash_argument_in_hash_body434);
            hash_argument41=hash_argument();

            state._fsp--;

            adaptor.addChild(root_0, hash_argument41.getTree());
            dbg.location(111,19);
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:111:19: ( ',' hash_argument )*
            try { dbg.enterSubRule(10);

            loop10:
            do {
                int alt10=2;
                try { dbg.enterDecision(10, decisionCanBacktrack[10]);

                int LA10_0 = input.LA(1);

                if ( (LA10_0==30) ) {
                    alt10=1;
                }


                } finally {dbg.exitDecision(10);}

                switch (alt10) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:111:20: ',' hash_argument
            	    {
            	    dbg.location(111,20);
            	    char_literal42=(Token)match(input,30,FOLLOW_30_in_hash_body437); 
            	    char_literal42_tree = 
            	    (CommonTree)adaptor.create(char_literal42)
            	    ;
            	    adaptor.addChild(root_0, char_literal42_tree);

            	    dbg.location(111,24);
            	    pushFollow(FOLLOW_hash_argument_in_hash_body439);
            	    hash_argument43=hash_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, hash_argument43.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);
            } finally {dbg.exitSubRule(10);}


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
        dbg.location(112, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "hash_body");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "hash_body"


    public static class hash_argument_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "hash_argument"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:114:1: hash_argument : expression COLON ! expression ;
    public final TwigParser.hash_argument_return hash_argument() throws RecognitionException {
        TwigParser.hash_argument_return retval = new TwigParser.hash_argument_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token COLON45=null;
        TwigParser.expression_return expression44 =null;

        TwigParser.expression_return expression46 =null;


        CommonTree COLON45_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "hash_argument");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(114, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:115:3: ( expression COLON ! expression )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:115:5: expression COLON ! expression
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(115,5);
            pushFollow(FOLLOW_expression_in_hash_argument456);
            expression44=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression44.getTree());
            dbg.location(115,21);
            COLON45=(Token)match(input,COLON,FOLLOW_COLON_in_hash_argument458); 
            dbg.location(115,23);
            pushFollow(FOLLOW_expression_in_hash_argument461);
            expression46=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression46.getTree());

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
        dbg.location(116, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "hash_argument");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "hash_argument"


    public static class term_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:118:1: term : ( IDENT | NUMBER | STRING | SQ_STRING );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set47=null;

        CommonTree set47_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "term");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(118, 0);

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:119:3: ( IDENT | NUMBER | STRING | SQ_STRING )
            dbg.enterAlt(1);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/Twig.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(119,3);
            set47=(Token)input.LT(1);

            if ( input.LA(1)==IDENT||input.LA(1)==NUMBER||(input.LA(1) >= SQ_STRING && input.LA(1) <= STRING) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set47)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(123, 2);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "term");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "term"

    // Delegated rules


 

    public static final BitSet FOLLOW_twig_print_in_template87 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_twig_block_in_template91 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_EOF_in_template95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print113 = new BitSet(new long[]{0x0000000082433500L});
    public static final BitSet FOLLOW_body_in_twig_print116 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block134 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDENT_in_twig_block136 = new BitSet(new long[]{0x0000000082833500L});
    public static final BitSet FOLLOW_body_in_twig_block140 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_body164 = new BitSet(new long[]{0x00000002C2033502L});
    public static final BitSet FOLLOW_expression_in_body181 = new BitSet(new long[]{0x00000002C2033502L});
    public static final BitSet FOLLOW_IDENT_in_functionCallStatement205 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_T_OPEN_PAREN_in_functionCallStatement208 = new BitSet(new long[]{0x0000000082033500L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement211 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_functionCallStatement213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters228 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_functionParameters231 = new BitSet(new long[]{0x0000000082033500L});
    public static final BitSet FOLLOW_expression_in_functionParameters234 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_term_in_expression256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_access_in_expression280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filter_in_expression286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE_in_filter304 = new BitSet(new long[]{0x0000000082033500L});
    public static final BitSet FOLLOW_expression_in_filter307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_variable_access322 = new BitSet(new long[]{0x0000000082033500L});
    public static final BitSet FOLLOW_expression_in_variable_access325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_open_in_array343 = new BitSet(new long[]{0x0000000182033500L});
    public static final BitSet FOLLOW_expression_in_array347 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_30_in_array350 = new BitSet(new long[]{0x0000000082033500L});
    public static final BitSet FOLLOW_expression_in_array353 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_array_close_in_array359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_array_open374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_array_close393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash414 = new BitSet(new long[]{0x0000000082033500L});
    public static final BitSet FOLLOW_hash_body_in_hash417 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_argument_in_hash_body434 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_hash_body437 = new BitSet(new long[]{0x0000000082033500L});
    public static final BitSet FOLLOW_hash_argument_in_hash_body439 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_expression_in_hash_argument456 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_COLON_in_hash_argument458 = new BitSet(new long[]{0x0000000082033500L});
    public static final BitSet FOLLOW_expression_in_hash_argument461 = new BitSet(new long[]{0x0000000000000002L});

}