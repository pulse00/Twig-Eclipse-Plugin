// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g 2011-12-31 16:16:21

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "COLON", "DIGIT", "DOT", "IDENT", "LETTER", "NUMBER", "PUNCTUATION", "TWIG_VAR", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','", "'['", "']'", "'|'", "'~'"
    };

    public static final int EOF=-1;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int ARRAY_CLOSE=4;
    public static final int ARRAY_OPEN=5;
    public static final int COLON=6;
    public static final int DIGIT=7;
    public static final int DOT=8;
    public static final int IDENT=9;
    public static final int LETTER=10;
    public static final int NUMBER=11;
    public static final int PUNCTUATION=12;
    public static final int TWIG_VAR=13;
    public static final int T_CLOSE_CURLY=14;
    public static final int T_CLOSE_PAREN=15;
    public static final int T_CLOSE_PRINT=16;
    public static final int T_CLOSE_STMT=17;
    public static final int T_OPEN_CURLY=18;
    public static final int T_OPEN_PAREN=19;
    public static final int T_OPEN_PRINT=20;
    public static final int T_OPEN_STMT=21;
    public static final int WS=22;

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:20:1: module returns [TwigModuleDeclaration node] : ( (p= twig_print ) | (b= twig_block ) )* ;
    public final TwigModuleDeclaration module() throws RecognitionException {
        TwigModuleDeclaration node = null;


        Statement p =null;

        Statement b =null;



            List<Statement> statements = new ArrayList<Statement>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:3: ( ( (p= twig_print ) | (b= twig_block ) )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:7: ( (p= twig_print ) | (b= twig_block ) )*
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:7: ( (p= twig_print ) | (b= twig_block ) )*
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
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:9: (p= twig_print )
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:9: (p= twig_print )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:10: p= twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_module75);
            	    p=twig_print();

            	    state._fsp--;


            	    }


            	     statements.add(p);

            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:48: (b= twig_block )
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:48: (b= twig_block )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:26:49: b= twig_block
            	    {
            	    pushFollow(FOLLOW_twig_block_in_module85);
            	    b=twig_block();

            	    state._fsp--;


            	    }


            	     statements.add(b); 

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
            T_OPEN_PRINT1=(CommonTree)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print128); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:36:20: (e= expression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ARRAY_OPEN||(LA2_0 >= DOT && LA2_0 <= IDENT)||LA2_0==NUMBER||LA2_0==T_OPEN_CURLY) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:36:21: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_print133);
            	    e=expression();

            	    state._fsp--;


            	     expressions.add(e); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            T_CLOSE_PRINT2=(CommonTree)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print139); 

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



    // $ANTLR start "twig_block"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:44:1: twig_block returns [Statement node] : ^( T_OPEN_STMT IDENT (e= expression )* T_CLOSE_STMT ) ;
    public final Statement twig_block() throws RecognitionException {
        Statement node = null;


        CommonTree T_OPEN_STMT3=null;
        CommonTree T_CLOSE_STMT4=null;
        CommonTree IDENT5=null;
        Expression e =null;



            List<Expression> expressions = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:50:3: ( ^( T_OPEN_STMT IDENT (e= expression )* T_CLOSE_STMT ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:50:5: ^( T_OPEN_STMT IDENT (e= expression )* T_CLOSE_STMT )
            {
            T_OPEN_STMT3=(CommonTree)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block178); 

            match(input, Token.DOWN, null); 
            IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_twig_block180); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:50:25: (e= expression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ARRAY_OPEN||(LA3_0 >= DOT && LA3_0 <= IDENT)||LA3_0==NUMBER||LA3_0==T_OPEN_CURLY) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:50:26: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_block185);
            	    e=expression();

            	    state._fsp--;


            	     expressions.add(e); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            T_CLOSE_STMT4=(CommonTree)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block191); 

            match(input, Token.UP, null); 


                 
                  CommonToken startToken = (CommonToken) T_OPEN_STMT3.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_STMT4.getToken();
                  node = new BlockStatement(startToken.getStartIndex(), endToken.getStopIndex(), (IDENT5!=null?IDENT5.getText():null), expressions);            
                

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
    // $ANTLR end "twig_block"



    // $ANTLR start "expression"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:58:1: expression returns [Expression node] : (f= function | IDENT | NUMBER |h= hash |a= array |v= variable_access );
    public final Expression expression() throws RecognitionException {
        Expression node = null;


        CommonTree IDENT6=null;
        CommonTree NUMBER7=null;
        Expression f =null;

        Expression h =null;

        Expression a =null;

        VariableAccess v =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:59:3: (f= function | IDENT | NUMBER |h= hash |a= array |v= variable_access )
            int alt4=6;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==DOWN) ) {
                    alt4=1;
                }
                else if ( ((LA4_1 >= ARRAY_CLOSE && LA4_1 <= ARRAY_OPEN)||(LA4_1 >= DOT && LA4_1 <= IDENT)||LA4_1==NUMBER||(LA4_1 >= T_CLOSE_CURLY && LA4_1 <= T_OPEN_CURLY)) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
                }
                break;
            case NUMBER:
                {
                alt4=3;
                }
                break;
            case T_OPEN_CURLY:
                {
                alt4=4;
                }
                break;
            case ARRAY_OPEN:
                {
                alt4=5;
                }
                break;
            case DOT:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:59:5: f= function
                    {
                    pushFollow(FOLLOW_function_in_expression219);
                    f=function();

                    state._fsp--;


                     node = f; 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:60:5: IDENT
                    {
                    IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression227); 

                     
                          CommonToken startToken = (CommonToken) IDENT6.getToken();
                          node = new IdentNode(startToken.getStartIndex(), startToken.getStopIndex(), (IDENT6!=null?IDENT6.getText():null)); 
                        

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:65:5: NUMBER
                    {
                    NUMBER7=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_expression240); 


                          CommonToken startToken = (CommonToken) NUMBER7.getToken();     
                          node = new NumberNode(startToken.getStartIndex(), startToken.getStopIndex(), Integer.parseInt((NUMBER7!=null?NUMBER7.getText():null))); 
                        

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:70:5: h= hash
                    {
                    pushFollow(FOLLOW_hash_in_expression255);
                    h=hash();

                    state._fsp--;


                     node = h; 

                    }
                    break;
                case 5 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:71:5: a= array
                    {
                    pushFollow(FOLLOW_array_in_expression265);
                    a=array();

                    state._fsp--;


                     node = a; 

                    }
                    break;
                case 6 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:72:5: v= variable_access
                    {
                    pushFollow(FOLLOW_variable_access_in_expression275);
                    v=variable_access();

                    state._fsp--;


                     node = v; 

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



    // $ANTLR start "variable_access"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:75:1: variable_access returns [VariableAccess node] : DOT e= expression ;
    public final VariableAccess variable_access() throws RecognitionException {
        VariableAccess node = null;


        CommonTree DOT8=null;
        Expression e =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:76:3: ( DOT e= expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:76:5: DOT e= expression
            {
            DOT8=(CommonTree)match(input,DOT,FOLLOW_DOT_in_variable_access296); 

            pushFollow(FOLLOW_expression_in_variable_access300);
            e=expression();

            state._fsp--;



                  CommonToken startToken = (CommonToken) DOT8.getToken();     
                  node = new VariableAccess(startToken.getStartIndex(), startToken.getStopIndex(), e); 
                

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
    // $ANTLR end "variable_access"



    // $ANTLR start "array"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:83:1: array returns [Expression node] : ^( ARRAY_OPEN (e= expression )* ARRAY_CLOSE ) ;
    public final Expression array() throws RecognitionException {
        Expression node = null;


        CommonTree ARRAY_OPEN9=null;
        CommonTree ARRAY_CLOSE10=null;
        Expression e =null;



            List<Expression> arguments = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:89:3: ( ^( ARRAY_OPEN (e= expression )* ARRAY_CLOSE ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:89:5: ^( ARRAY_OPEN (e= expression )* ARRAY_CLOSE )
            {
            ARRAY_OPEN9=(CommonTree)match(input,ARRAY_OPEN,FOLLOW_ARRAY_OPEN_in_array334); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:89:18: (e= expression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ARRAY_OPEN||(LA5_0 >= DOT && LA5_0 <= IDENT)||LA5_0==NUMBER||LA5_0==T_OPEN_CURLY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:89:19: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_array339);
            	    e=expression();

            	    state._fsp--;


            	     arguments.add(e); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            ARRAY_CLOSE10=(CommonTree)match(input,ARRAY_CLOSE,FOLLOW_ARRAY_CLOSE_in_array345); 

            match(input, Token.UP, null); 



                  CommonToken startToken = (CommonToken) ARRAY_OPEN9.getToken();
                  CommonToken endToken = (CommonToken) ARRAY_CLOSE10.getToken();    
                  node = new ArrayDeclaration(startToken.getStartIndex(), endToken.getStartIndex(), arguments);
                

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
    // $ANTLR end "array"



    // $ANTLR start "hash"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:99:1: hash returns [Expression node] : ^( T_OPEN_CURLY (h= hash_argument )* T_CLOSE_CURLY ) ;
    public final Expression hash() throws RecognitionException {
        Expression node = null;


        CommonTree T_OPEN_CURLY11=null;
        CommonTree T_CLOSE_CURLY12=null;
        Expression h =null;



            List<Expression> expressions = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:105:3: ( ^( T_OPEN_CURLY (h= hash_argument )* T_CLOSE_CURLY ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:105:5: ^( T_OPEN_CURLY (h= hash_argument )* T_CLOSE_CURLY )
            {
            T_OPEN_CURLY11=(CommonTree)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash387); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:105:20: (h= hash_argument )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ARRAY_OPEN||(LA6_0 >= DOT && LA6_0 <= IDENT)||LA6_0==NUMBER||LA6_0==T_OPEN_CURLY) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:105:22: h= hash_argument
            	    {
            	    pushFollow(FOLLOW_hash_argument_in_hash393);
            	    h=hash_argument();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            T_CLOSE_CURLY12=(CommonTree)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash397); 

            match(input, Token.UP, null); 



                  CommonToken startToken = (CommonToken) T_OPEN_CURLY11.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_CURLY12.getToken();
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



    // $ANTLR start "hash_argument"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:114:1: hash_argument returns [Expression node] : left= expression right= expression ;
    public final Expression hash_argument() throws RecognitionException {
        Expression node = null;


        Expression left =null;

        Expression right =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:115:3: (left= expression right= expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:115:5: left= expression right= expression
            {
            pushFollow(FOLLOW_expression_in_hash_argument427);
            left=expression();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_hash_argument431);
            right=expression();

            state._fsp--;


             node = new HashEntry(left,right); 

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
    // $ANTLR end "hash_argument"



    // $ANTLR start "function"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:122:1: function returns [Expression node] : ^( IDENT (e= expression )* T_CLOSE_PAREN ) ;
    public final Expression function() throws RecognitionException {
        Expression node = null;


        CommonTree IDENT13=null;
        CommonTree T_CLOSE_PAREN14=null;
        Expression e =null;



            List<Expression> arguments = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:128:3: ( ^( IDENT (e= expression )* T_CLOSE_PAREN ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:128:5: ^( IDENT (e= expression )* T_CLOSE_PAREN )
            {
            IDENT13=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function468); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:128:13: (e= expression )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ARRAY_OPEN||(LA7_0 >= DOT && LA7_0 <= IDENT)||LA7_0==NUMBER||LA7_0==T_OPEN_CURLY) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:128:14: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_function473);
            	    e=expression();

            	    state._fsp--;


            	     arguments.add(e); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            T_CLOSE_PAREN14=(CommonTree)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_function480); 

            match(input, Token.UP, null); 


                
                  CommonToken startToken = (CommonToken) IDENT13.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_PAREN14.getToken();     
                  node = new TwigCallExpression(startToken.getStartIndex(), endToken.getStopIndex(), (IDENT13!=null?IDENT13.getText():null), arguments); 
                

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


 

    public static final BitSet FOLLOW_twig_print_in_module75 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_twig_block_in_module85 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_twig_print133 = new BitSet(new long[]{0x0000000000050B20L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print139 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_twig_block180 = new BitSet(new long[]{0x0000000000060B20L});
    public static final BitSet FOLLOW_expression_in_twig_block185 = new BitSet(new long[]{0x0000000000060B20L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block191 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_function_in_expression219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_expression227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_expression240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_access_in_expression275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_variable_access296 = new BitSet(new long[]{0x0000000000040B20L});
    public static final BitSet FOLLOW_expression_in_variable_access300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_OPEN_in_array334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_array339 = new BitSet(new long[]{0x0000000000040B30L});
    public static final BitSet FOLLOW_ARRAY_CLOSE_in_array345 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_hash_argument_in_hash393 = new BitSet(new long[]{0x0000000000044B20L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash397 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_hash_argument427 = new BitSet(new long[]{0x0000000000040B20L});
    public static final BitSet FOLLOW_expression_in_hash_argument431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_function468 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_function473 = new BitSet(new long[]{0x0000000000048B20L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_function480 = new BitSet(new long[]{0x0000000000000008L});

}