// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g 2011-12-30 18:39:41

  package com.dubture.twig.core.ast.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "FUNCTION_IDENTIFIER", "IDENT", "LETTER", "NUMBER", "TWIG_VAR", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "'('", "')'", "','"
    };

    public static final int EOF=-1;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int DIGIT=4;
    public static final int FUNCTION_IDENTIFIER=5;
    public static final int IDENT=6;
    public static final int LETTER=7;
    public static final int NUMBER=8;
    public static final int TWIG_VAR=9;
    public static final int T_CLOSE_PRINT=10;
    public static final int T_CLOSE_STMT=11;
    public static final int T_OPEN_PRINT=12;
    public static final int T_OPEN_STMT=13;
    public static final int WS=14;

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
    public String getGrammarFileName() { return "/Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g"; }


    public static class template_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "template"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:22:1: template : ( twig_print )* ;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.twig_print_return twig_print1 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:23:3: ( ( twig_print )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:23:5: ( twig_print )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:23:5: ( twig_print )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==T_OPEN_PRINT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:23:5: twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_template70);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:26:1: twig_print : twig_var ^ ( expression )* T_CLOSE_PRINT !;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_CLOSE_PRINT4=null;
        TwigParser.twig_var_return twig_var2 =null;

        TwigParser.expression_return expression3 =null;


        CommonTree T_CLOSE_PRINT4_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:3: ( twig_var ^ ( expression )* T_CLOSE_PRINT !)
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:5: twig_var ^ ( expression )* T_CLOSE_PRINT !
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_twig_var_in_twig_print87);
            twig_var2=twig_var();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(twig_var2.getTree(), root_0);

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:15: ( expression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT||LA2_0==NUMBER) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:16: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_print91);
            	    expression3=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression3.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            T_CLOSE_PRINT4=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print95); 

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


    public static class twig_var_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "twig_var"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:30:1: twig_var : T_OPEN_PRINT -> TWIG_VAR ;
    public final TwigParser.twig_var_return twig_var() throws RecognitionException {
        TwigParser.twig_var_return retval = new TwigParser.twig_var_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token T_OPEN_PRINT5=null;

        CommonTree T_OPEN_PRINT5_tree=null;
        RewriteRuleTokenStream stream_T_OPEN_PRINT=new RewriteRuleTokenStream(adaptor,"token T_OPEN_PRINT");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:31:3: ( T_OPEN_PRINT -> TWIG_VAR )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:31:5: T_OPEN_PRINT
            {
            T_OPEN_PRINT5=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_var111);  
            stream_T_OPEN_PRINT.add(T_OPEN_PRINT5);


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
            // 31:18: -> TWIG_VAR
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(TWIG_VAR, "TWIG_VAR")
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
    // $ANTLR end "twig_var"


    public static class functionCallStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCallStatement"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:34:1: functionCallStatement : functionIdentifier ^ '(' ! functionParameters ')' !;
    public final TwigParser.functionCallStatement_return functionCallStatement() throws RecognitionException {
        TwigParser.functionCallStatement_return retval = new TwigParser.functionCallStatement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal7=null;
        Token char_literal9=null;
        TwigParser.functionIdentifier_return functionIdentifier6 =null;

        TwigParser.functionParameters_return functionParameters8 =null;


        CommonTree char_literal7_tree=null;
        CommonTree char_literal9_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:35:3: ( functionIdentifier ^ '(' ! functionParameters ')' !)
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:35:5: functionIdentifier ^ '(' ! functionParameters ')' !
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_functionIdentifier_in_functionCallStatement131);
            functionIdentifier6=functionIdentifier();

            state._fsp--;

            root_0 = (CommonTree)adaptor.becomeRoot(functionIdentifier6.getTree(), root_0);

            char_literal7=(Token)match(input,15,FOLLOW_15_in_functionCallStatement134); 

            pushFollow(FOLLOW_functionParameters_in_functionCallStatement137);
            functionParameters8=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, functionParameters8.getTree());

            char_literal9=(Token)match(input,16,FOLLOW_16_in_functionCallStatement139); 

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


    public static class functionIdentifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionIdentifier"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:38:1: functionIdentifier : IDENT -> FUNCTION_IDENTIFIER ;
    public final TwigParser.functionIdentifier_return functionIdentifier() throws RecognitionException {
        TwigParser.functionIdentifier_return retval = new TwigParser.functionIdentifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token IDENT10=null;

        CommonTree IDENT10_tree=null;
        RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:39:3: ( IDENT -> FUNCTION_IDENTIFIER )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:39:5: IDENT
            {
            IDENT10=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionIdentifier155);  
            stream_IDENT.add(IDENT10);


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
            // 39:11: -> FUNCTION_IDENTIFIER
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(FUNCTION_IDENTIFIER, "FUNCTION_IDENTIFIER")
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
    // $ANTLR end "functionIdentifier"


    public static class functionParameters_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionParameters"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:42:1: functionParameters : expression ( ',' expression )* ;
    public final TwigParser.functionParameters_return functionParameters() throws RecognitionException {
        TwigParser.functionParameters_return retval = new TwigParser.functionParameters_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal12=null;
        TwigParser.expression_return expression11 =null;

        TwigParser.expression_return expression13 =null;


        CommonTree char_literal12_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:43:3: ( expression ( ',' expression )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:43:5: expression ( ',' expression )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_functionParameters174);
            expression11=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression11.getTree());

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:43:16: ( ',' expression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:43:17: ',' expression
            	    {
            	    char_literal12=(Token)match(input,17,FOLLOW_17_in_functionParameters177); 
            	    char_literal12_tree = 
            	    (CommonTree)adaptor.create(char_literal12)
            	    ;
            	    adaptor.addChild(root_0, char_literal12_tree);


            	    pushFollow(FOLLOW_expression_in_functionParameters179);
            	    expression13=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expression13.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:46:1: expression : ( term | functionCallStatement );
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        TwigParser.term_return term14 =null;

        TwigParser.functionCallStatement_return functionCallStatement15 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:47:3: ( term | functionCallStatement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==IDENT) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==IDENT||LA4_1==NUMBER||LA4_1==T_CLOSE_PRINT||(LA4_1 >= 16 && LA4_1 <= 17)) ) {
                    alt4=1;
                }
                else if ( (LA4_1==15) ) {
                    alt4=2;
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
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:47:5: term
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_term_in_expression201);
                    term14=term();

                    state._fsp--;

                    adaptor.addChild(root_0, term14.getTree());

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:48:5: functionCallStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionCallStatement_in_expression207);
                    functionCallStatement15=functionCallStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCallStatement15.getTree());

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:51:1: term : ( IDENT | NUMBER );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set16=null;

        CommonTree set16_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:52:3: ( IDENT | NUMBER )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set16=(Token)input.LT(1);

            if ( input.LA(1)==IDENT||input.LA(1)==NUMBER ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set16)
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


 

    public static final BitSet FOLLOW_twig_print_in_template70 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_twig_var_in_twig_print87 = new BitSet(new long[]{0x0000000000000540L});
    public static final BitSet FOLLOW_expression_in_twig_print91 = new BitSet(new long[]{0x0000000000000540L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_var111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionIdentifier_in_functionCallStatement131 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_functionCallStatement134 = new BitSet(new long[]{0x0000000000000140L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement137 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_functionCallStatement139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_functionIdentifier155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters174 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_functionParameters177 = new BitSet(new long[]{0x0000000000000140L});
    public static final BitSet FOLLOW_expression_in_functionParameters179 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_term_in_expression201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression207 = new BitSet(new long[]{0x0000000000000002L});

}