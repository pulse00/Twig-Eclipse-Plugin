// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g 2011-12-30 16:45:36

  package com.dubture.twig.core.ast.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "LETTER", "NUMBER", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "'('", "')'"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int DIGIT=4;
    public static final int IDENT=5;
    public static final int LETTER=6;
    public static final int NUMBER=7;
    public static final int T_CLOSE_PRINT=8;
    public static final int T_CLOSE_STMT=9;
    public static final int T_OPEN_PRINT=10;
    public static final int T_OPEN_STMT=11;
    public static final int WS=12;

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
        public AstNode node;
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "template"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:18:1: template returns [AstNode node] : e= twig_print ;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        TwigParser.twig_print_return e =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:19:3: (e= twig_print )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:19:5: e= twig_print
            {
            root_0 = (TwigCommonTree)adaptor.nil();


            pushFollow(FOLLOW_twig_print_in_template62);
            e=twig_print();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());

             retval.node = new PrintNode((e!=null?e.node:null)); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (TwigCommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (TwigCommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "template"


    public static class twig_print_return extends ParserRuleReturnScope {
        public AstNode node;
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "twig_print"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:22:1: twig_print returns [AstNode node] : T_OPEN_PRINT ! (e= expression )* T_CLOSE_PRINT !;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        Token T_OPEN_PRINT1=null;
        Token T_CLOSE_PRINT2=null;
        TwigParser.expression_return e =null;


        TwigCommonTree T_OPEN_PRINT1_tree=null;
        TwigCommonTree T_CLOSE_PRINT2_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:23:3: ( T_OPEN_PRINT ! (e= expression )* T_CLOSE_PRINT !)
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:23:5: T_OPEN_PRINT ! (e= expression )* T_CLOSE_PRINT !
            {
            root_0 = (TwigCommonTree)adaptor.nil();


            T_OPEN_PRINT1=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print84); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:24:6: (e= expression )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENT||LA1_0==NUMBER) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:24:6: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_print94);
            	    e=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


             retval.node = new ExpressionNode((e!=null?e.node:null)); 

            T_CLOSE_PRINT2=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print104); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (TwigCommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (TwigCommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "twig_print"


    public static class functionCallStatement_return extends ParserRuleReturnScope {
        public AstNode node;
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionCallStatement"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:28:1: functionCallStatement returns [AstNode node] : IDENT '(' f= functionParameters ')' ;
    public final TwigParser.functionCallStatement_return functionCallStatement() throws RecognitionException {
        TwigParser.functionCallStatement_return retval = new TwigParser.functionCallStatement_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        Token IDENT3=null;
        Token char_literal4=null;
        Token char_literal5=null;
        TwigParser.functionParameters_return f =null;


        TwigCommonTree IDENT3_tree=null;
        TwigCommonTree char_literal4_tree=null;
        TwigCommonTree char_literal5_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:29:3: ( IDENT '(' f= functionParameters ')' )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:29:5: IDENT '(' f= functionParameters ')'
            {
            root_0 = (TwigCommonTree)adaptor.nil();


            IDENT3=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionCallStatement124); 
            IDENT3_tree = 
            (TwigCommonTree)adaptor.create(IDENT3)
            ;
            adaptor.addChild(root_0, IDENT3_tree);


            char_literal4=(Token)match(input,13,FOLLOW_13_in_functionCallStatement131); 
            char_literal4_tree = 
            (TwigCommonTree)adaptor.create(char_literal4)
            ;
            adaptor.addChild(root_0, char_literal4_tree);


            pushFollow(FOLLOW_functionParameters_in_functionCallStatement135);
            f=functionParameters();

            state._fsp--;

            adaptor.addChild(root_0, f.getTree());

            char_literal5=(Token)match(input,14,FOLLOW_14_in_functionCallStatement137); 
            char_literal5_tree = 
            (TwigCommonTree)adaptor.create(char_literal5)
            ;
            adaptor.addChild(root_0, char_literal5_tree);


             retval.node = new FunctionCall((f!=null?f.node:null), (IDENT3!=null?IDENT3.getText():null)); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (TwigCommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (TwigCommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionCallStatement"


    public static class functionParameters_return extends ParserRuleReturnScope {
        public AstNode node;
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "functionParameters"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:33:1: functionParameters returns [AstNode node] : expression ;
    public final TwigParser.functionParameters_return functionParameters() throws RecognitionException {
        TwigParser.functionParameters_return retval = new TwigParser.functionParameters_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        TwigParser.expression_return expression6 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:34:3: ( expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:34:5: expression
            {
            root_0 = (TwigCommonTree)adaptor.nil();


            pushFollow(FOLLOW_expression_in_functionParameters158);
            expression6=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression6.getTree());

             retval.node = new FunctionParameter((expression6!=null?expression6.node:null)); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (TwigCommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (TwigCommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "functionParameters"


    public static class expression_return extends ParserRuleReturnScope {
        public AstNode node;
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:37:1: expression returns [AstNode node] : (t= term | functionCallStatement );
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        TwigParser.term_return t =null;

        TwigParser.functionCallStatement_return functionCallStatement7 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:38:3: (t= term | functionCallStatement )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==13) ) {
                    alt2=2;
                }
                else if ( (LA2_1==IDENT||(LA2_1 >= NUMBER && LA2_1 <= T_CLOSE_PRINT)||LA2_1==14) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA2_0==NUMBER) ) {
                alt2=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:38:5: t= term
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();


                    pushFollow(FOLLOW_term_in_expression185);
                    t=term();

                    state._fsp--;

                    adaptor.addChild(root_0, t.getTree());

                     retval.node = new TermNode((t!=null?t.node:null)); 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:39:5: functionCallStatement
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();


                    pushFollow(FOLLOW_functionCallStatement_in_expression193);
                    functionCallStatement7=functionCallStatement();

                    state._fsp--;

                    adaptor.addChild(root_0, functionCallStatement7.getTree());

                     retval.node = new ExpressionNode((functionCallStatement7!=null?functionCallStatement7.node:null)); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (TwigCommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (TwigCommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class term_return extends ParserRuleReturnScope {
        public AstNode node;
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:42:1: term returns [AstNode node] : ( IDENT | NUMBER );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        Token IDENT8=null;
        Token NUMBER9=null;

        TwigCommonTree IDENT8_tree=null;
        TwigCommonTree NUMBER9_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:43:3: ( IDENT | NUMBER )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENT) ) {
                alt3=1;
            }
            else if ( (LA3_0==NUMBER) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:43:5: IDENT
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();


                    IDENT8=(Token)match(input,IDENT,FOLLOW_IDENT_in_term214); 
                    IDENT8_tree = 
                    (TwigCommonTree)adaptor.create(IDENT8)
                    ;
                    adaptor.addChild(root_0, IDENT8_tree);


                     retval.node = new IdentNode((IDENT8!=null?IDENT8.getText():null)); 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:44:5: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();


                    NUMBER9=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term222); 
                    NUMBER9_tree = 
                    (TwigCommonTree)adaptor.create(NUMBER9)
                    ;
                    adaptor.addChild(root_0, NUMBER9_tree);


                     retval.node = new NumberNode(Integer.parseInt((NUMBER9!=null?NUMBER9.getText():null))); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (TwigCommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (TwigCommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "term"

    // Delegated rules


 

    public static final BitSet FOLLOW_twig_print_in_template62 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print84 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_expression_in_twig_print94 = new BitSet(new long[]{0x00000000000001A0L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_functionCallStatement124 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_functionCallStatement131 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_functionParameters_in_functionCallStatement135 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_functionCallStatement137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_functionParameters158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_expression185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCallStatement_in_expression193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term222 = new BitSet(new long[]{0x0000000000000002L});

}