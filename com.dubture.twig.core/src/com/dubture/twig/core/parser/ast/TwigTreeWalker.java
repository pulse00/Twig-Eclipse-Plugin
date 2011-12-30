// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g 2011-12-30 23:20:32

  package com.dubture.twig.core.parser.ast;
  
  import com.dubture.twig.core.parser.ast.node.*;   
  import org.eclipse.dltk.ast.statements.Statement;
  import org.eclipse.dltk.ast.expressions.Expression;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TwigTreeWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "LETTER", "NUMBER", "TWIG_VAR", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "'('", "')'", "','"
    };

    public static final int EOF=-1;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int DIGIT=4;
    public static final int IDENT=5;
    public static final int LETTER=6;
    public static final int NUMBER=7;
    public static final int TWIG_VAR=8;
    public static final int T_CLOSE_PRINT=9;
    public static final int T_CLOSE_STMT=10;
    public static final int T_OPEN_PRINT=11;
    public static final int T_OPEN_STMT=12;
    public static final int WS=13;

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
    public String getGrammarFileName() { return "/Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g"; }



    // $ANTLR start "module"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:18:1: module returns [TwigModuleDeclaration node] : (p= twig_print )* ;
    public final TwigModuleDeclaration module() throws RecognitionException {
        TwigModuleDeclaration node = null;


        Statement p =null;



            List<Statement> statements = new ArrayList<Statement>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:24:3: ( (p= twig_print )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:24:5: (p= twig_print )*
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:24:5: (p= twig_print )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==T_OPEN_PRINT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:24:6: p= twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_module71);
            	    p=twig_print();

            	    state._fsp--;


            	     statements.add(p); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


             node = new TwigModuleDeclaration(0, statements); 

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
    // $ANTLR end "module"



    // $ANTLR start "twig_print"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:28:1: twig_print returns [Statement statement] : ^( T_OPEN_PRINT (e= expression )* T_CLOSE_PRINT ) ;
    public final Statement twig_print() throws RecognitionException {
        Statement statement = null;


        CommonTree T_OPEN_PRINT1=null;
        CommonTree T_CLOSE_PRINT2=null;
        Expression e =null;



            List<Expression> expressions = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:34:3: ( ^( T_OPEN_PRINT (e= expression )* T_CLOSE_PRINT ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:34:5: ^( T_OPEN_PRINT (e= expression )* T_CLOSE_PRINT )
            {
            T_OPEN_PRINT1=(CommonTree)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print113); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:34:20: (e= expression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:34:21: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_print118);
            	    e=expression();

            	    state._fsp--;


            	     expressions.add(e); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            T_CLOSE_PRINT2=(CommonTree)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print124); 

            match(input, Token.UP, null); 


                 
                  CommonToken startToken = (CommonToken) T_OPEN_PRINT1.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_PRINT2.getToken();
                  statement = new PrintStatement(startToken.getStartIndex(), endToken.getStopIndex(), expressions);            
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return statement;
    }
    // $ANTLR end "twig_print"



    // $ANTLR start "expression"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:42:1: expression returns [Expression node] : ( ^( IDENT e= expression ) | IDENT );
    public final Expression expression() throws RecognitionException {
        Expression node = null;


        CommonTree IDENT3=null;
        CommonTree IDENT4=null;
        Expression e =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:44:3: ( ^( IDENT e= expression ) | IDENT )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENT) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==DOWN) ) {
                    alt3=1;
                }
                else if ( (LA3_1==UP||LA3_1==IDENT||LA3_1==T_CLOSE_PRINT) ) {
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
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:44:5: ^( IDENT e= expression )
                    {
                    IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression152); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_expression_in_expression156);
                    e=expression();

                    state._fsp--;


                    match(input, Token.UP, null); 


                     node = new TwigCallExpression(e, (IDENT3!=null?IDENT3.getText():null)); 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:47:5: IDENT
                    {
                    IDENT4=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression175); 

                     node = new IdentNode((IDENT4!=null?IDENT4.getText():null)); 

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


 

    public static final BitSet FOLLOW_twig_print_in_module71 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_twig_print118 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_expression152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression156 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_expression175 = new BitSet(new long[]{0x0000000000000002L});

}