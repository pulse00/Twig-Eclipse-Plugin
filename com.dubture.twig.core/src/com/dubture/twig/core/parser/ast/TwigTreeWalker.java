// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g 2011-12-31 16:54:18

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "COLON", "DIGIT", "DOT", "ESC", "IDENT", "LETTER", "NUMBER", "PUNCTUATION", "STRING", "TWIG_VAR", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','", "'['", "']'", "'|'", "'~'"
    };

    public static final int EOF=-1;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int ARRAY_CLOSE=4;
    public static final int ARRAY_OPEN=5;
    public static final int COLON=6;
    public static final int DIGIT=7;
    public static final int DOT=8;
    public static final int ESC=9;
    public static final int IDENT=10;
    public static final int LETTER=11;
    public static final int NUMBER=12;
    public static final int PUNCTUATION=13;
    public static final int STRING=14;
    public static final int TWIG_VAR=15;
    public static final int T_CLOSE_CURLY=16;
    public static final int T_CLOSE_PAREN=17;
    public static final int T_CLOSE_PRINT=18;
    public static final int T_CLOSE_STMT=19;
    public static final int T_OPEN_CURLY=20;
    public static final int T_OPEN_PAREN=21;
    public static final int T_OPEN_PRINT=22;
    public static final int T_OPEN_STMT=23;
    public static final int WS=24;

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:19:1: module returns [TwigModuleDeclaration node] : ( (p= twig_print ) | (b= twig_block ) )* EOF ;
    public final TwigModuleDeclaration module() throws RecognitionException {
        TwigModuleDeclaration node = null;


        Statement p =null;

        Statement b =null;



            List<Statement> statements = new ArrayList<Statement>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:3: ( ( (p= twig_print ) | (b= twig_block ) )* EOF )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:7: ( (p= twig_print ) | (b= twig_block ) )* EOF
            {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:7: ( (p= twig_print ) | (b= twig_block ) )*
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
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:9: (p= twig_print )
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:9: (p= twig_print )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:10: p= twig_print
            	    {
            	    pushFollow(FOLLOW_twig_print_in_module74);
            	    p=twig_print();

            	    state._fsp--;


            	    }


            	     statements.add(p);

            	    }
            	    break;
            	case 2 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:48: (b= twig_block )
            	    {
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:48: (b= twig_block )
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:49: b= twig_block
            	    {
            	    pushFollow(FOLLOW_twig_block_in_module84);
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


            match(input,EOF,FOLLOW_EOF_in_module92); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:29:1: twig_print returns [Statement node] : ^( T_OPEN_PRINT (e= expression )* T_CLOSE_PRINT ) ;
    public final Statement twig_print() throws RecognitionException {
        Statement node = null;


        CommonTree T_OPEN_PRINT1=null;
        CommonTree T_CLOSE_PRINT2=null;
        Expression e =null;



            List<Expression> expressions = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:35:3: ( ^( T_OPEN_PRINT (e= expression )* T_CLOSE_PRINT ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:35:5: ^( T_OPEN_PRINT (e= expression )* T_CLOSE_PRINT )
            {
            T_OPEN_PRINT1=(CommonTree)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print129); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:35:20: (e= expression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ARRAY_OPEN||LA2_0==DOT||LA2_0==IDENT||LA2_0==NUMBER||LA2_0==STRING||LA2_0==T_OPEN_CURLY) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:35:21: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_print134);
            	    e=expression();

            	    state._fsp--;


            	     expressions.add(e); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            T_CLOSE_PRINT2=(CommonTree)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print140); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:43:1: twig_block returns [Statement node] : ^( T_OPEN_STMT IDENT (e= expression )* T_CLOSE_STMT ) ;
    public final Statement twig_block() throws RecognitionException {
        Statement node = null;


        CommonTree T_OPEN_STMT3=null;
        CommonTree T_CLOSE_STMT4=null;
        CommonTree IDENT5=null;
        Expression e =null;



            List<Expression> expressions = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:49:3: ( ^( T_OPEN_STMT IDENT (e= expression )* T_CLOSE_STMT ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:49:5: ^( T_OPEN_STMT IDENT (e= expression )* T_CLOSE_STMT )
            {
            T_OPEN_STMT3=(CommonTree)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block179); 

            match(input, Token.DOWN, null); 
            IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_twig_block181); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:49:25: (e= expression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ARRAY_OPEN||LA3_0==DOT||LA3_0==IDENT||LA3_0==NUMBER||LA3_0==STRING||LA3_0==T_OPEN_CURLY) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:49:26: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_block186);
            	    e=expression();

            	    state._fsp--;


            	     expressions.add(e); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            T_CLOSE_STMT4=(CommonTree)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block192); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:57:1: expression returns [Expression node] : (f= function | IDENT | NUMBER | STRING |h= hash |a= array |v= variable_access );
    public final Expression expression() throws RecognitionException {
        Expression node = null;


        CommonTree IDENT6=null;
        CommonTree NUMBER7=null;
        CommonTree STRING8=null;
        Expression f =null;

        Expression h =null;

        Expression a =null;

        VariableAccess v =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:58:3: (f= function | IDENT | NUMBER | STRING |h= hash |a= array |v= variable_access )
            int alt4=7;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==DOWN) ) {
                    alt4=1;
                }
                else if ( ((LA4_1 >= UP && LA4_1 <= ARRAY_OPEN)||LA4_1==DOT||LA4_1==IDENT||LA4_1==NUMBER||LA4_1==STRING||(LA4_1 >= T_CLOSE_CURLY && LA4_1 <= T_OPEN_CURLY)) ) {
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
            case STRING:
                {
                alt4=4;
                }
                break;
            case T_OPEN_CURLY:
                {
                alt4=5;
                }
                break;
            case ARRAY_OPEN:
                {
                alt4=6;
                }
                break;
            case DOT:
                {
                alt4=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:58:5: f= function
                    {
                    pushFollow(FOLLOW_function_in_expression220);
                    f=function();

                    state._fsp--;


                     node = f; 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:59:5: IDENT
                    {
                    IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression228); 

                     
                          CommonToken startToken = (CommonToken) IDENT6.getToken();
                          node = new IdentNode(startToken.getStartIndex(), startToken.getStopIndex(), (IDENT6!=null?IDENT6.getText():null)); 
                        

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:64:5: NUMBER
                    {
                    NUMBER7=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_expression241); 


                          CommonToken startToken = (CommonToken) NUMBER7.getToken();     
                          node = new NumberNode(startToken.getStartIndex(), startToken.getStopIndex(), Integer.parseInt((NUMBER7!=null?NUMBER7.getText():null))); 
                        

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:69:5: STRING
                    {
                    STRING8=(CommonTree)match(input,STRING,FOLLOW_STRING_in_expression254); 


                          node = new StringLiteral(0,0, (STRING8!=null?STRING8.getText():null));
                        

                    }
                    break;
                case 5 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:73:5: h= hash
                    {
                    pushFollow(FOLLOW_hash_in_expression268);
                    h=hash();

                    state._fsp--;


                     node = h; 

                    }
                    break;
                case 6 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:74:5: a= array
                    {
                    pushFollow(FOLLOW_array_in_expression278);
                    a=array();

                    state._fsp--;


                     node = a; 

                    }
                    break;
                case 7 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:75:5: v= variable_access
                    {
                    pushFollow(FOLLOW_variable_access_in_expression288);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:79:1: variable_access returns [VariableAccess node] : ^( DOT e= expression ) ;
    public final VariableAccess variable_access() throws RecognitionException {
        VariableAccess node = null;


        CommonTree DOT9=null;
        Expression e =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:80:3: ( ^( DOT e= expression ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:80:5: ^( DOT e= expression )
            {
            DOT9=(CommonTree)match(input,DOT,FOLLOW_DOT_in_variable_access313); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_variable_access317);
            e=expression();

            state._fsp--;


            match(input, Token.UP, null); 



                  CommonToken startToken = (CommonToken) DOT9.getToken();     
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:87:1: array returns [Expression node] : ^( ARRAY_OPEN (e= expression )* ARRAY_CLOSE ) ;
    public final Expression array() throws RecognitionException {
        Expression node = null;


        CommonTree ARRAY_OPEN10=null;
        CommonTree ARRAY_CLOSE11=null;
        Expression e =null;



            List<Expression> arguments = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:93:3: ( ^( ARRAY_OPEN (e= expression )* ARRAY_CLOSE ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:93:5: ^( ARRAY_OPEN (e= expression )* ARRAY_CLOSE )
            {
            ARRAY_OPEN10=(CommonTree)match(input,ARRAY_OPEN,FOLLOW_ARRAY_OPEN_in_array352); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:93:18: (e= expression )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ARRAY_OPEN||LA5_0==DOT||LA5_0==IDENT||LA5_0==NUMBER||LA5_0==STRING||LA5_0==T_OPEN_CURLY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:93:19: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_array357);
            	    e=expression();

            	    state._fsp--;


            	     arguments.add(e); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            ARRAY_CLOSE11=(CommonTree)match(input,ARRAY_CLOSE,FOLLOW_ARRAY_CLOSE_in_array363); 

            match(input, Token.UP, null); 



                  CommonToken startToken = (CommonToken) ARRAY_OPEN10.getToken();
                  CommonToken endToken = (CommonToken) ARRAY_CLOSE11.getToken();    
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:103:1: hash returns [Expression node] : ^( T_OPEN_CURLY (h= hash_argument )* T_CLOSE_CURLY ) ;
    public final Expression hash() throws RecognitionException {
        Expression node = null;


        CommonTree T_OPEN_CURLY12=null;
        CommonTree T_CLOSE_CURLY13=null;
        Expression h =null;



            List<Expression> expressions = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:109:3: ( ^( T_OPEN_CURLY (h= hash_argument )* T_CLOSE_CURLY ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:109:5: ^( T_OPEN_CURLY (h= hash_argument )* T_CLOSE_CURLY )
            {
            T_OPEN_CURLY12=(CommonTree)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash405); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:109:20: (h= hash_argument )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ARRAY_OPEN||LA6_0==DOT||LA6_0==IDENT||LA6_0==NUMBER||LA6_0==STRING||LA6_0==T_OPEN_CURLY) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:109:22: h= hash_argument
            	    {
            	    pushFollow(FOLLOW_hash_argument_in_hash411);
            	    h=hash_argument();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            T_CLOSE_CURLY13=(CommonTree)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash415); 

            match(input, Token.UP, null); 



                  CommonToken startToken = (CommonToken) T_OPEN_CURLY12.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_CURLY13.getToken();
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:118:1: hash_argument returns [Expression node] : left= expression right= expression ;
    public final Expression hash_argument() throws RecognitionException {
        Expression node = null;


        Expression left =null;

        Expression right =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:119:3: (left= expression right= expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:119:5: left= expression right= expression
            {
            pushFollow(FOLLOW_expression_in_hash_argument445);
            left=expression();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_hash_argument449);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:126:1: function returns [Expression node] : ^( IDENT (e= expression )* T_CLOSE_PAREN ) ;
    public final Expression function() throws RecognitionException {
        Expression node = null;


        CommonTree IDENT14=null;
        CommonTree T_CLOSE_PAREN15=null;
        Expression e =null;



            List<Expression> arguments = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:132:3: ( ^( IDENT (e= expression )* T_CLOSE_PAREN ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:132:5: ^( IDENT (e= expression )* T_CLOSE_PAREN )
            {
            IDENT14=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function486); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:132:13: (e= expression )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ARRAY_OPEN||LA7_0==DOT||LA7_0==IDENT||LA7_0==NUMBER||LA7_0==STRING||LA7_0==T_OPEN_CURLY) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:132:14: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_function491);
            	    e=expression();

            	    state._fsp--;


            	     arguments.add(e); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            T_CLOSE_PAREN15=(CommonTree)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_function498); 

            match(input, Token.UP, null); 


                
                  CommonToken startToken = (CommonToken) IDENT14.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_PAREN15.getToken();     
                  node = new TwigCallExpression(startToken.getStartIndex(), endToken.getStopIndex(), (IDENT14!=null?IDENT14.getText():null), arguments); 
                

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


 

    public static final BitSet FOLLOW_twig_print_in_module74 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_twig_block_in_module84 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_EOF_in_module92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print129 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_twig_print134 = new BitSet(new long[]{0x0000000000145520L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print140 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block179 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_twig_block181 = new BitSet(new long[]{0x0000000000185520L});
    public static final BitSet FOLLOW_expression_in_twig_block186 = new BitSet(new long[]{0x0000000000185520L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block192 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_function_in_expression220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_expression228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_expression241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expression254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_access_in_expression288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_variable_access313 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_variable_access317 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_OPEN_in_array352 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_array357 = new BitSet(new long[]{0x0000000000105530L});
    public static final BitSet FOLLOW_ARRAY_CLOSE_in_array363 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash405 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_hash_argument_in_hash411 = new BitSet(new long[]{0x0000000000115520L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash415 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_hash_argument445 = new BitSet(new long[]{0x0000000000105520L});
    public static final BitSet FOLLOW_expression_in_hash_argument449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_function486 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_function491 = new BitSet(new long[]{0x0000000000125520L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_function498 = new BitSet(new long[]{0x0000000000000008L});

}