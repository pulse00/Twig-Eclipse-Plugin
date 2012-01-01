// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g 2012-01-01 10:30:01

  package com.dubture.twig.core.ast.parser; 


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigTreeWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "T_OPEN_PRINT"
    };

    public static final int EOF=-1;
    public static final int IDENT=4;
    public static final int T_OPEN_PRINT=5;

    // delegates
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public TwigTreeWalker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public TwigTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return TwigTreeWalker.tokenNames; }
    public String getGrammarFileName() { return "/Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g"; }



    // $ANTLR start "template"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:13:1: template returns [AstNode node] : (p= twig_print )* ;
    public final AstNode template() throws RecognitionException {
        AstNode node = null;


        AstNode p =null;



            List<AstNode> statements = new ArrayList<AstNode>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:17:3: ( (p= twig_print )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:17:5: (p= twig_print )*
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:17:5: (p= twig_print )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==T_OPEN_PRINT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:17:6: p= twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_template66);
            	    p=twig_print();

            	    state._fsp--;


            	     statements.add(p); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


             node = new Template(statements); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "template"



    // $ANTLR start "twig_print"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:20:1: twig_print returns [AstNode node] : ^( T_OPEN_PRINT (e= expression )* ) ;
    public final AstNode twig_print() throws RecognitionException {
        AstNode node = null;


        AstNode e =null;



            List<AstNode> expressions = new ArrayList<AstNode>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:24:3: ( ^( T_OPEN_PRINT (e= expression )* ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:24:5: ^( T_OPEN_PRINT (e= expression )* )
            {
            match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print99); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:24:20: (e= expression )*
                loop2:
                do {
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==IDENT) ) {
                        alt2=1;
                    }


                    switch (alt2) {
                	case 1 :
                	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:24:21: e= expression
                	    {
                	    pushFollow(FOLLOW_expression_in_twig_print104);
                	    e=expression();

                	    state._fsp--;


                	     expressions.add(e); 

                	    }
                	    break;

                	default :
                	    break loop2;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


             node = new PrintStatement(expressions); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "twig_print"



    // $ANTLR start "expression"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:27:1: expression returns [AstNode node] : ( ^( IDENT e= expression ) | IDENT );
    public final AstNode expression() throws RecognitionException {
        AstNode node = null;


        CommonTree IDENT1=null;
        CommonTree IDENT2=null;
        AstNode e =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:28:3: ( ^( IDENT e= expression ) | IDENT )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENT) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==DOWN) ) {
                    alt3=1;
                }
                else if ( ((LA3_1 >= UP && LA3_1 <= IDENT)) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:28:5: ^( IDENT e= expression )
                    {
                    IDENT1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression130); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression134);
                    e=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 


                     node = new FunctionCall(e, (IDENT1!=null?IDENT1.getText():null)); 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:29:5: IDENT
                    {
                    IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression143); 

                     node = new IdentNode((IDENT2!=null?IDENT2.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "expression"

    // Delegated rules


 

    public static final BitSet FOLLOW_twig_print_in_template66 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_twig_print104 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_IDENT_in_expression130 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression134 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_expression143 = new BitSet(new long[]{0x0000000000000002L});

}