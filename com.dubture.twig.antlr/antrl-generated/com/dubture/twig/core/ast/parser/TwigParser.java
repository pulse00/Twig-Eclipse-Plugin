// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g 2011-12-30 14:55:47

  package com.dubture.twig.core.ast.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "FUNCTIONNAME", "IDENT", "LETTER", "NUMBER", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_PRINT", "T_OPEN_STMT", "WS"
    };

    public static final int EOF=-1;
    public static final int DIGIT=4;
    public static final int FUNCTIONNAME=5;
    public static final int IDENT=6;
    public static final int LETTER=7;
    public static final int NUMBER=8;
    public static final int T_CLOSE_PRINT=9;
    public static final int T_CLOSE_STMT=10;
    public static final int T_OPEN_PRINT=11;
    public static final int T_OPEN_STMT=12;
    public static final int WS=13;

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:21:1: template returns [AstNode node] : twig_print ;
    public final TwigParser.template_return template() throws RecognitionException {
        TwigParser.template_return retval = new TwigParser.template_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        TwigParser.twig_print_return twig_print1 =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:22:3: ( twig_print )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:22:5: twig_print
            {
            root_0 = (TwigCommonTree)adaptor.nil();


            pushFollow(FOLLOW_twig_print_in_template69);
            twig_print1=twig_print();

            state._fsp--;

            adaptor.addChild(root_0, twig_print1.getTree());

             retval.node = (twig_print1!=null?twig_print1.node:null); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:25:1: twig_print returns [AstNode node] : T_OPEN_PRINT ! (e= expression )* T_CLOSE_PRINT !;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        Token T_OPEN_PRINT2=null;
        Token T_CLOSE_PRINT3=null;
        TwigParser.expression_return e =null;


        TwigCommonTree T_OPEN_PRINT2_tree=null;
        TwigCommonTree T_CLOSE_PRINT3_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:26:3: ( T_OPEN_PRINT ! (e= expression )* T_CLOSE_PRINT !)
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:26:5: T_OPEN_PRINT ! (e= expression )* T_CLOSE_PRINT !
            {
            root_0 = (TwigCommonTree)adaptor.nil();


            T_OPEN_PRINT2=(Token)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print91); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:6: (e= expression )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IDENT||LA1_0==NUMBER) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:27:6: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_print101);
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

            T_CLOSE_PRINT3=(Token)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print111); 

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


    public static class expression_return extends ParserRuleReturnScope {
        public AstNode node;
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:31:1: expression returns [AstNode node] : t= term ;
    public final TwigParser.expression_return expression() throws RecognitionException {
        TwigParser.expression_return retval = new TwigParser.expression_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        TwigParser.term_return t =null;



        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:32:3: (t= term )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:32:5: t= term
            {
            root_0 = (TwigCommonTree)adaptor.nil();


            pushFollow(FOLLOW_term_in_expression135);
            t=term();

            state._fsp--;

            adaptor.addChild(root_0, t.getTree());

             retval.node = new TermNode((t!=null?t.node:null)); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:35:1: term returns [AstNode node] : ( IDENT | NUMBER );
    public final TwigParser.term_return term() throws RecognitionException {
        TwigParser.term_return retval = new TwigParser.term_return();
        retval.start = input.LT(1);


        TwigCommonTree root_0 = null;

        Token IDENT4=null;
        Token NUMBER5=null;

        TwigCommonTree IDENT4_tree=null;
        TwigCommonTree NUMBER5_tree=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:36:3: ( IDENT | NUMBER )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT) ) {
                alt2=1;
            }
            else if ( (LA2_0==NUMBER) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:36:5: IDENT
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();


                    IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_term156); 
                    IDENT4_tree = 
                    (TwigCommonTree)adaptor.create(IDENT4)
                    ;
                    adaptor.addChild(root_0, IDENT4_tree);


                     retval.node = new IdentNode((IDENT4!=null?IDENT4.getText():null)); 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/Twig.g:37:5: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();


                    NUMBER5=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term164); 
                    NUMBER5_tree = 
                    (TwigCommonTree)adaptor.create(NUMBER5)
                    ;
                    adaptor.addChild(root_0, NUMBER5_tree);


                     retval.node = new NumberNode(Integer.parseInt((NUMBER5!=null?NUMBER5.getText():null))); 

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


 

    public static final BitSet FOLLOW_twig_print_in_template69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print91 = new BitSet(new long[]{0x0000000000000340L});
    public static final BitSet FOLLOW_expression_in_twig_print101 = new BitSet(new long[]{0x0000000000000340L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_expression135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term164 = new BitSet(new long[]{0x0000000000000002L});

}