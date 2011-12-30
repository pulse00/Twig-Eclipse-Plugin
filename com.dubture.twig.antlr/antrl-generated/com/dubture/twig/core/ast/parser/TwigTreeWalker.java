// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g 2011-12-30 18:39:42

  package com.dubture.twig.core.ast.parser; 


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigTreeWalker extends TreeParser {
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


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:14:3: ( (p= twig_print )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:14:5: (p= twig_print )*
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:14:6: (p= twig_print )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==TWIG_VAR) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:14:6: p= twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_template58);
            	    p=twig_print();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


             node = new Template(p); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:17:1: twig_print returns [AstNode node] : ^( TWIG_VAR (e= expression )* ) ;
    public final AstNode twig_print() throws RecognitionException {
        AstNode node = null;


        AstNode e =null;



            List<AstNode> expressions = new ArrayList<AstNode>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:21:3: ( ^( TWIG_VAR (e= expression )* ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:21:5: ^( TWIG_VAR (e= expression )* )
            {
            match(input,TWIG_VAR,FOLLOW_TWIG_VAR_in_twig_print88); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:21:16: (e= expression )*
                loop2:
                do {
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( ((LA2_0 >= FUNCTION_IDENTIFIER && LA2_0 <= IDENT)) ) {
                        alt2=1;
                    }


                    switch (alt2) {
                	case 1 :
                	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:21:17: e= expression
                	    {
                	    pushFollow(FOLLOW_expression_in_twig_print93);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:24:1: expression returns [AstNode node] : ( ^( FUNCTION_IDENTIFIER e= expression ) | IDENT );
    public final AstNode expression() throws RecognitionException {
        AstNode node = null;


        CommonTree FUNCTION_IDENTIFIER1=null;
        CommonTree IDENT2=null;
        AstNode e =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:25:3: ( ^( FUNCTION_IDENTIFIER e= expression ) | IDENT )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==FUNCTION_IDENTIFIER) ) {
                alt3=1;
            }
            else if ( (LA3_0==IDENT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:25:5: ^( FUNCTION_IDENTIFIER e= expression )
                    {
                    FUNCTION_IDENTIFIER1=(CommonTree)match(input,FUNCTION_IDENTIFIER,FOLLOW_FUNCTION_IDENTIFIER_in_expression119); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression123);
                    e=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 


                     node = new FunctionCall(e, (FUNCTION_IDENTIFIER1!=null?FUNCTION_IDENTIFIER1.getText():null)); 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.antlr/src/com/dubture/twig/core/ast/parser/TwigTreeWalker.g:26:5: IDENT
                    {
                    IDENT2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression132); 

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


 

    public static final BitSet FOLLOW_twig_print_in_template58 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_TWIG_VAR_in_twig_print88 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_twig_print93 = new BitSet(new long[]{0x0000000000000068L});
    public static final BitSet FOLLOW_FUNCTION_IDENTIFIER_in_expression119 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression123 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_expression132 = new BitSet(new long[]{0x0000000000000002L});

}