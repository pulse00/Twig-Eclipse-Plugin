// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g 2011-12-31 00:44:03

  package com.dubture.twig.core.parser.ast;
  
  import java.util.Map;
  import java.util.HashMap;  
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "COLON", "DIGIT", "IDENT", "LETTER", "NUMBER", "PUNCTUATION", "TWIG_VAR", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','"
    };

    public static final int EOF=-1;
    public static final int T__20=20;
    public static final int COLON=4;
    public static final int DIGIT=5;
    public static final int IDENT=6;
    public static final int LETTER=7;
    public static final int NUMBER=8;
    public static final int PUNCTUATION=9;
    public static final int TWIG_VAR=10;
    public static final int T_CLOSE_CURLY=11;
    public static final int T_CLOSE_PAREN=12;
    public static final int T_CLOSE_PRINT=13;
    public static final int T_CLOSE_STMT=14;
    public static final int T_OPEN_CURLY=15;
    public static final int T_OPEN_PAREN=16;
    public static final int T_OPEN_PRINT=17;
    public static final int T_OPEN_STMT=18;
    public static final int WS=19;

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:20:1: module returns [TwigModuleDeclaration node] : (p= twig_print )* ;
    public final TwigModuleDeclaration module() throws RecognitionException {
        TwigModuleDeclaration node = null;


        Statement p =null;



            List<Statement> statements = new ArrayList<Statement>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:3: ( (p= twig_print )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:5: (p= twig_print )*
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:5: (p= twig_print )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==T_OPEN_PRINT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:6: p= twig_print
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:30:1: twig_print returns [Statement node] : ^( T_OPEN_PRINT (e= expression )* T_CLOSE_PRINT ) ;
    public final Statement twig_print() throws RecognitionException {
        Statement node = null;


        CommonTree T_OPEN_PRINT1=null;
        CommonTree T_CLOSE_PRINT2=null;
        Expression e =null;



            List<Expression> expressions = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:36:3: ( ^( T_OPEN_PRINT (e= expression )* T_CLOSE_PRINT ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:36:5: ^( T_OPEN_PRINT (e= expression )* T_CLOSE_PRINT )
            {
            T_OPEN_PRINT1=(CommonTree)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print113); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:36:20: (e= expression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==IDENT||LA2_0==T_OPEN_CURLY) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:36:21: e= expression
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
                  node = new PrintStatement(startToken.getStartIndex(), endToken.getStopIndex(), expressions);            
                

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:44:1: expression returns [Expression node] : (f= function | IDENT |h= hash );
    public final Expression expression() throws RecognitionException {
        Expression node = null;


        CommonTree IDENT3=null;
        Expression f =null;

        Expression h =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:45:3: (f= function | IDENT |h= hash )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENT) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==DOWN) ) {
                    alt3=1;
                }
                else if ( (LA3_1==COLON||LA3_1==IDENT||(LA3_1 >= T_CLOSE_CURLY && LA3_1 <= T_CLOSE_PRINT)||LA3_1==T_OPEN_CURLY) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA3_0==T_OPEN_CURLY) ) {
                alt3=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:45:5: f= function
                    {
                    pushFollow(FOLLOW_function_in_expression152);
                    f=function();

                    state._fsp--;


                     node = f; 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:46:5: IDENT
                    {
                    IDENT3=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression160); 

                     node = new IdentNode((IDENT3!=null?IDENT3.getText():null)); 

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:47:5: h= hash
                    {
                    pushFollow(FOLLOW_hash_in_expression170);
                    h=hash();

                    state._fsp--;


                     node = h; 

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



    // $ANTLR start "hash"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:51:1: hash returns [Expression node] : ^( T_OPEN_CURLY (left= expression COLON right= expression )* T_CLOSE_CURLY ) ;
    public final Expression hash() throws RecognitionException {
        Expression node = null;


        CommonTree T_OPEN_CURLY4=null;
        CommonTree T_CLOSE_CURLY5=null;
        Expression left =null;

        Expression right =null;



            Map<Expression, Expression> expressions = new HashMap<Expression, Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:57:3: ( ^( T_OPEN_CURLY (left= expression COLON right= expression )* T_CLOSE_CURLY ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:57:5: ^( T_OPEN_CURLY (left= expression COLON right= expression )* T_CLOSE_CURLY )
            {
            T_OPEN_CURLY4=(CommonTree)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash203); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:57:20: (left= expression COLON right= expression )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IDENT||LA4_0==T_OPEN_CURLY) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:57:21: left= expression COLON right= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_hash208);
            	    left=expression();

            	    state._fsp--;


            	    match(input,COLON,FOLLOW_COLON_in_hash210); 

            	    pushFollow(FOLLOW_expression_in_hash214);
            	    right=expression();

            	    state._fsp--;


            	     expressions.put(left, right); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            T_CLOSE_CURLY5=(CommonTree)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash221); 

            match(input, Token.UP, null); 



                  CommonToken startToken = (CommonToken) T_OPEN_CURLY4.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_CURLY5.getToken();
                  node = new Hash(startToken.getStartIndex(), endToken.getStopIndex(), expressions);
                

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
    // $ANTLR end "hash"



    // $ANTLR start "function"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:68:1: function returns [Expression node] : ^( IDENT (e= expression )* T_CLOSE_PAREN ) ;
    public final Expression function() throws RecognitionException {
        Expression node = null;


        CommonTree IDENT6=null;
        CommonTree T_CLOSE_PAREN7=null;
        Expression e =null;



            List<Expression> arguments = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:74:3: ( ^( IDENT (e= expression )* T_CLOSE_PAREN ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:74:5: ^( IDENT (e= expression )* T_CLOSE_PAREN )
            {
            IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function262); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:74:13: (e= expression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT||LA5_0==T_OPEN_CURLY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:74:14: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_function267);
            	    e=expression();

            	    state._fsp--;


            	     arguments.add(e); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            T_CLOSE_PAREN7=(CommonTree)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_function274); 

            match(input, Token.UP, null); 


                
                  CommonToken startToken = (CommonToken) IDENT6.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_PAREN7.getToken();     
                  node = new TwigCallExpression(startToken.getStartIndex(), endToken.getStopIndex(), (IDENT6!=null?IDENT6.getText():null), arguments); 
                

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
    // $ANTLR end "function"

    // Delegated rules


 

    public static final BitSet FOLLOW_twig_print_in_module71 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print113 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_twig_print118 = new BitSet(new long[]{0x000000000000A040L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print124 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_function_in_expression152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_expression160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash203 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_hash208 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COLON_in_hash210 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_expression_in_hash214 = new BitSet(new long[]{0x0000000000008840L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash221 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_function262 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_function267 = new BitSet(new long[]{0x0000000000009040L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_function274 = new BitSet(new long[]{0x0000000000000008L});

}