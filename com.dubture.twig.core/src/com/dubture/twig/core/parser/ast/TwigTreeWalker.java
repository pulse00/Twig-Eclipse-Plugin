// $ANTLR 3.4 /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g 2012-01-01 16:29:04

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARRAY_CLOSE", "ARRAY_OPEN", "COLON", "DIGIT", "DOT", "ESC", "IDENT", "LETTER", "NUMBER", "PUNCTUATION", "RAW", "SQ_STRING", "STRING", "TWIG_VAR", "T_CLOSE_CMT", "T_CLOSE_CURLY", "T_CLOSE_PAREN", "T_CLOSE_PRINT", "T_CLOSE_STMT", "T_OPEN_CMT", "T_OPEN_CURLY", "T_OPEN_PAREN", "T_OPEN_PRINT", "T_OPEN_STMT", "WS", "','", "'['", "']'", "'|'", "'~'"
    };

    public static final int EOF=-1;
    public static final int T__29=29;
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
    public static final int PUNCTUATION=13;
    public static final int RAW=14;
    public static final int SQ_STRING=15;
    public static final int STRING=16;
    public static final int TWIG_VAR=17;
    public static final int T_CLOSE_CMT=18;
    public static final int T_CLOSE_CURLY=19;
    public static final int T_CLOSE_PAREN=20;
    public static final int T_CLOSE_PRINT=21;
    public static final int T_CLOSE_STMT=22;
    public static final int T_OPEN_CMT=23;
    public static final int T_OPEN_CURLY=24;
    public static final int T_OPEN_PAREN=25;
    public static final int T_OPEN_PRINT=26;
    public static final int T_OPEN_STMT=27;
    public static final int WS=28;

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:19:1: module returns [TwigModuleDeclaration node] : ( (p= twig_print ) | (b= twig_block ) )* ;
    public final TwigModuleDeclaration module() throws RecognitionException {
        TwigModuleDeclaration node = null;


        Statement p =null;

        Statement b =null;



            List<Statement> statements = new ArrayList<Statement>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:3: ( ( (p= twig_print ) | (b= twig_block ) )* )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:25:7: ( (p= twig_print ) | (b= twig_block ) )*
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
            T_OPEN_PRINT1=(CommonTree)match(input,T_OPEN_PRINT,FOLLOW_T_OPEN_PRINT_in_twig_print127); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:35:20: (e= expression )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ARRAY_OPEN||LA2_0==DOT||LA2_0==IDENT||LA2_0==NUMBER||(LA2_0 >= SQ_STRING && LA2_0 <= STRING)||LA2_0==T_OPEN_CURLY) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:35:21: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_print132);
            	    e=expression();

            	    state._fsp--;


            	     expressions.add(e); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            T_CLOSE_PRINT2=(CommonTree)match(input,T_CLOSE_PRINT,FOLLOW_T_CLOSE_PRINT_in_twig_print138); 

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
            T_OPEN_STMT3=(CommonTree)match(input,T_OPEN_STMT,FOLLOW_T_OPEN_STMT_in_twig_block177); 

            match(input, Token.DOWN, null); 
            IDENT5=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_twig_block179); 

            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:49:25: (e= expression )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ARRAY_OPEN||LA3_0==DOT||LA3_0==IDENT||LA3_0==NUMBER||(LA3_0 >= SQ_STRING && LA3_0 <= STRING)||LA3_0==T_OPEN_CURLY) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:49:26: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_twig_block184);
            	    e=expression();

            	    state._fsp--;


            	     expressions.add(e); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            T_CLOSE_STMT4=(CommonTree)match(input,T_CLOSE_STMT,FOLLOW_T_CLOSE_STMT_in_twig_block190); 

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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:57:1: expression returns [Expression node] : (f= function |t= term |h= hash |a= array |v= variable_access );
    public final Expression expression() throws RecognitionException {
        Expression node = null;


        Expression f =null;

        Expression t =null;

        Expression h =null;

        Expression a =null;

        VariableAccess v =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:58:3: (f= function |t= term |h= hash |a= array |v= variable_access )
            int alt4=5;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==DOWN) ) {
                    alt4=1;
                }
                else if ( ((LA4_1 >= UP && LA4_1 <= ARRAY_OPEN)||LA4_1==DOT||LA4_1==IDENT||LA4_1==NUMBER||(LA4_1 >= SQ_STRING && LA4_1 <= STRING)||(LA4_1 >= T_CLOSE_CURLY && LA4_1 <= T_CLOSE_STMT)||LA4_1==T_OPEN_CURLY) ) {
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
            case SQ_STRING:
            case STRING:
                {
                alt4=2;
                }
                break;
            case T_OPEN_CURLY:
                {
                alt4=3;
                }
                break;
            case ARRAY_OPEN:
                {
                alt4=4;
                }
                break;
            case DOT:
                {
                alt4=5;
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
                    pushFollow(FOLLOW_function_in_expression218);
                    f=function();

                    state._fsp--;


                     node = f; 

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:59:5: t= term
                    {
                    pushFollow(FOLLOW_term_in_expression228);
                    t=term();

                    state._fsp--;


                     node = t; 

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:60:5: h= hash
                    {
                    pushFollow(FOLLOW_hash_in_expression238);
                    h=hash();

                    state._fsp--;


                     node = h; 

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:61:5: a= array
                    {
                    pushFollow(FOLLOW_array_in_expression248);
                    a=array();

                    state._fsp--;


                     node = a; 

                    }
                    break;
                case 5 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:62:5: v= variable_access
                    {
                    pushFollow(FOLLOW_variable_access_in_expression258);
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



    // $ANTLR start "term"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:65:1: term returns [Expression node] : ( IDENT | NUMBER | STRING | SQ_STRING );
    public final Expression term() throws RecognitionException {
        Expression node = null;


        CommonTree IDENT6=null;
        CommonTree NUMBER7=null;
        CommonTree STRING8=null;
        CommonTree SQ_STRING9=null;

        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:66:3: ( IDENT | NUMBER | STRING | SQ_STRING )
            int alt5=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt5=1;
                }
                break;
            case NUMBER:
                {
                alt5=2;
                }
                break;
            case STRING:
                {
                alt5=3;
                }
                break;
            case SQ_STRING:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:66:5: IDENT
                    {
                    IDENT6=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_term277); 

                     
                          CommonToken startToken = (CommonToken) IDENT6.getToken();
                          node = new IdentNode(startToken.getStartIndex(), startToken.getStopIndex(), (IDENT6!=null?IDENT6.getText():null)); 
                        

                    }
                    break;
                case 2 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:71:5: NUMBER
                    {
                    NUMBER7=(CommonTree)match(input,NUMBER,FOLLOW_NUMBER_in_term290); 


                          CommonToken startToken = (CommonToken) NUMBER7.getToken();
                          node = new NumberNode(startToken.getStartIndex(), startToken.getStopIndex(), Integer.parseInt((NUMBER7!=null?NUMBER7.getText():null))); 
                        

                    }
                    break;
                case 3 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:76:5: STRING
                    {
                    STRING8=(CommonTree)match(input,STRING,FOLLOW_STRING_in_term303); 


                          node = new StringLiteral(0,0, (STRING8!=null?STRING8.getText():null));
                        

                    }
                    break;
                case 4 :
                    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:80:5: SQ_STRING
                    {
                    SQ_STRING9=(CommonTree)match(input,SQ_STRING,FOLLOW_SQ_STRING_in_term318); 


                          node = new StringLiteral(0,0, (SQ_STRING9!=null?SQ_STRING9.getText():null));
                        

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
    // $ANTLR end "term"



    // $ANTLR start "variable_access"
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:86:1: variable_access returns [VariableAccess node] : ^( DOT e= expression ) ;
    public final VariableAccess variable_access() throws RecognitionException {
        VariableAccess node = null;


        CommonTree DOT10=null;
        Expression e =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:87:3: ( ^( DOT e= expression ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:87:5: ^( DOT e= expression )
            {
            DOT10=(CommonTree)match(input,DOT,FOLLOW_DOT_in_variable_access350); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_expression_in_variable_access354);
            e=expression();

            state._fsp--;


            match(input, Token.UP, null); 



                  CommonToken startToken = (CommonToken) DOT10.getToken();     
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:94:1: array returns [Expression node] : ^( ARRAY_OPEN (e= expression )* ARRAY_CLOSE ) ;
    public final Expression array() throws RecognitionException {
        Expression node = null;


        CommonTree ARRAY_OPEN11=null;
        CommonTree ARRAY_CLOSE12=null;
        Expression e =null;



            List<Expression> arguments = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:100:3: ( ^( ARRAY_OPEN (e= expression )* ARRAY_CLOSE ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:100:5: ^( ARRAY_OPEN (e= expression )* ARRAY_CLOSE )
            {
            ARRAY_OPEN11=(CommonTree)match(input,ARRAY_OPEN,FOLLOW_ARRAY_OPEN_in_array389); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:100:18: (e= expression )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ARRAY_OPEN||LA6_0==DOT||LA6_0==IDENT||LA6_0==NUMBER||(LA6_0 >= SQ_STRING && LA6_0 <= STRING)||LA6_0==T_OPEN_CURLY) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:100:19: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_array394);
            	    e=expression();

            	    state._fsp--;


            	     arguments.add(e); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            ARRAY_CLOSE12=(CommonTree)match(input,ARRAY_CLOSE,FOLLOW_ARRAY_CLOSE_in_array400); 

            match(input, Token.UP, null); 



                  CommonToken startToken = (CommonToken) ARRAY_OPEN11.getToken();
                  CommonToken endToken = (CommonToken) ARRAY_CLOSE12.getToken();    
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:110:1: hash returns [Expression node] : ^( T_OPEN_CURLY (h= hash_argument )* T_CLOSE_CURLY ) ;
    public final Expression hash() throws RecognitionException {
        Expression node = null;


        CommonTree T_OPEN_CURLY13=null;
        CommonTree T_CLOSE_CURLY14=null;
        Expression h =null;



            List<Expression> expressions = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:116:3: ( ^( T_OPEN_CURLY (h= hash_argument )* T_CLOSE_CURLY ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:116:5: ^( T_OPEN_CURLY (h= hash_argument )* T_CLOSE_CURLY )
            {
            T_OPEN_CURLY13=(CommonTree)match(input,T_OPEN_CURLY,FOLLOW_T_OPEN_CURLY_in_hash442); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:116:20: (h= hash_argument )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ARRAY_OPEN||LA7_0==DOT||LA7_0==IDENT||LA7_0==NUMBER||(LA7_0 >= SQ_STRING && LA7_0 <= STRING)||LA7_0==T_OPEN_CURLY) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:116:22: h= hash_argument
            	    {
            	    pushFollow(FOLLOW_hash_argument_in_hash448);
            	    h=hash_argument();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            T_CLOSE_CURLY14=(CommonTree)match(input,T_CLOSE_CURLY,FOLLOW_T_CLOSE_CURLY_in_hash452); 

            match(input, Token.UP, null); 



                  CommonToken startToken = (CommonToken) T_OPEN_CURLY13.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_CURLY14.getToken();
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:125:1: hash_argument returns [Expression node] : left= expression right= expression ;
    public final Expression hash_argument() throws RecognitionException {
        Expression node = null;


        Expression left =null;

        Expression right =null;


        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:126:3: (left= expression right= expression )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:126:5: left= expression right= expression
            {
            pushFollow(FOLLOW_expression_in_hash_argument482);
            left=expression();

            state._fsp--;


            pushFollow(FOLLOW_expression_in_hash_argument486);
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
    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:133:1: function returns [Expression node] : ^( IDENT (e= expression )* T_CLOSE_PAREN ) ;
    public final Expression function() throws RecognitionException {
        Expression node = null;


        CommonTree IDENT15=null;
        CommonTree T_CLOSE_PAREN16=null;
        Expression e =null;



            List<Expression> arguments = new ArrayList<Expression>();
          
        try {
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:139:3: ( ^( IDENT (e= expression )* T_CLOSE_PAREN ) )
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:139:5: ^( IDENT (e= expression )* T_CLOSE_PAREN )
            {
            IDENT15=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_function523); 

            match(input, Token.DOWN, null); 
            // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:139:13: (e= expression )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ARRAY_OPEN||LA8_0==DOT||LA8_0==IDENT||LA8_0==NUMBER||(LA8_0 >= SQ_STRING && LA8_0 <= STRING)||LA8_0==T_OPEN_CURLY) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/sobert/Documents/workspaces/main/Twig-Eclipse-Plugin/com.dubture.twig.core/Resources/parserTools/parser/TwigTreeWalker.g:139:14: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_function528);
            	    e=expression();

            	    state._fsp--;


            	     arguments.add(e); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            T_CLOSE_PAREN16=(CommonTree)match(input,T_CLOSE_PAREN,FOLLOW_T_CLOSE_PAREN_in_function535); 

            match(input, Token.UP, null); 


                
                  CommonToken startToken = (CommonToken) IDENT15.getToken();
                  CommonToken endToken = (CommonToken) T_CLOSE_PAREN16.getToken();     
                  node = new TwigCallExpression(startToken.getStartIndex(), endToken.getStopIndex(), (IDENT15!=null?IDENT15.getText():null), arguments); 
                

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


 

    public static final BitSet FOLLOW_twig_print_in_module74 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_twig_block_in_module84 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_T_OPEN_PRINT_in_twig_print127 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_twig_print132 = new BitSet(new long[]{0x0000000001219520L});
    public static final BitSet FOLLOW_T_CLOSE_PRINT_in_twig_print138 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_T_OPEN_STMT_in_twig_block177 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_twig_block179 = new BitSet(new long[]{0x0000000001419520L});
    public static final BitSet FOLLOW_expression_in_twig_block184 = new BitSet(new long[]{0x0000000001419520L});
    public static final BitSet FOLLOW_T_CLOSE_STMT_in_twig_block190 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_function_in_expression218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_expression228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hash_in_expression238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_expression248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_access_in_expression258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_term303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQ_STRING_in_term318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_variable_access350 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_variable_access354 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARRAY_OPEN_in_array389 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_array394 = new BitSet(new long[]{0x0000000001019530L});
    public static final BitSet FOLLOW_ARRAY_CLOSE_in_array400 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_T_OPEN_CURLY_in_hash442 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_hash_argument_in_hash448 = new BitSet(new long[]{0x0000000001099520L});
    public static final BitSet FOLLOW_T_CLOSE_CURLY_in_hash452 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_hash_argument482 = new BitSet(new long[]{0x0000000001019520L});
    public static final BitSet FOLLOW_expression_in_hash_argument486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_function523 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_function528 = new BitSet(new long[]{0x0000000001119520L});
    public static final BitSet FOLLOW_T_CLOSE_PAREN_in_function535 = new BitSet(new long[]{0x0000000000000008L});

}