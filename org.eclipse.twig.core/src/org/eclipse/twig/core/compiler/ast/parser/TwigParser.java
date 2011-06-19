// $ANTLR 3.3 Nov 30, 2010 12:45:30 TwigParser.g 2011-06-19 19:07:07

package org.eclipse.twig.core.compiler.ast.parser;

import org.eclipse.twig.core.compiler.ast.parser.error.IErrorReporter;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PRINT_OPEN", "PRINT_CLOSE", "STMT_OPEN", "STMT_CLOSE", "METHOD_START", "METHOD_END", "ASIG", "PIPE", "DOT", "COMMA", "BSLASH", "JSON_START", "JSON_END", "STRING_CHAR", "STRING", "NONCONTROL_CHAR", "STRING_LITERAL", "LOWER", "UPPER", "DIGIT", "UNDER", "LETTER", "SYMBOL", "WHITESPACE", "TWIG_PR_STMT", "TWIG_VAR", "LITERAL_ARG"
    };
    public static final int EOF=-1;
    public static final int PRINT_OPEN=4;
    public static final int PRINT_CLOSE=5;
    public static final int STMT_OPEN=6;
    public static final int STMT_CLOSE=7;
    public static final int METHOD_START=8;
    public static final int METHOD_END=9;
    public static final int ASIG=10;
    public static final int PIPE=11;
    public static final int DOT=12;
    public static final int COMMA=13;
    public static final int BSLASH=14;
    public static final int JSON_START=15;
    public static final int JSON_END=16;
    public static final int STRING_CHAR=17;
    public static final int STRING=18;
    public static final int NONCONTROL_CHAR=19;
    public static final int STRING_LITERAL=20;
    public static final int LOWER=21;
    public static final int UPPER=22;
    public static final int DIGIT=23;
    public static final int UNDER=24;
    public static final int LETTER=25;
    public static final int SYMBOL=26;
    public static final int WHITESPACE=27;
    public static final int TWIG_PR_STMT=28;
    public static final int TWIG_VAR=29;
    public static final int LITERAL_ARG=30;

    // delegates
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
    public String getGrammarFileName() { return "TwigParser.g"; }



        private IErrorReporter errorReporter = null;
        
        public TwigParser(TokenStream input, IErrorReporter errorReporter) {
            this(input, new RecognizerSharedState());
            this.errorReporter = errorReporter;
        }

    	public void displayRecognitionError(String[] tokenNames,
                                            RecognitionException e) {
            
    		String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);        
            errorReporter.reportError(hdr,msg,e);
            
        }    
        
        public void setErrorReporter(IErrorReporter errorReporter) {
            this.errorReporter = errorReporter;
        }
        
    	protected Object recoverFromMismatchedToken(IntStream input,
    				int ttype, BitSet follow) throws RecognitionException
    	{   
    	    throw new MismatchedTokenException(ttype, input);
    	}       
    	
        public Object recoverFromMismatchedSet(IntStream input,
        			RecognitionException e, BitSet follow) throws RecognitionException 
        { 
    		throw new MismatchedSetException(follow, input);
       	}
    	


    public static class common_node_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "common_node"
    // TwigParser.g:60:1: common_node : ( NONCONTROL_CHAR )+ ;
    public final TwigParser.common_node_return common_node() throws RecognitionException {
        TwigParser.common_node_return retval = new TwigParser.common_node_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken NONCONTROL_CHAR1=null;

        TwigCommonTree NONCONTROL_CHAR1_tree=null;

        try {
            // TwigParser.g:61:2: ( ( NONCONTROL_CHAR )+ )
            // TwigParser.g:61:4: ( NONCONTROL_CHAR )+
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:61:4: ( NONCONTROL_CHAR )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==NONCONTROL_CHAR) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // TwigParser.g:61:4: NONCONTROL_CHAR
            	    {
            	    NONCONTROL_CHAR1=(CommonToken)match(input,NONCONTROL_CHAR,FOLLOW_NONCONTROL_CHAR_in_common_node68); 
            	    NONCONTROL_CHAR1_tree = (TwigCommonTree)adaptor.create(NONCONTROL_CHAR1);
            	    adaptor.addChild(root_0, NONCONTROL_CHAR1_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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
        }
        return retval;
    }
    // $ANTLR end "common_node"

    public static class twig_print_statement_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_print_statement"
    // TwigParser.g:66:1: twig_print_statement : PRINT_OPEN twig_print PRINT_CLOSE -> ^( TWIG_PR_STMT twig_print ) ;
    public final TwigParser.twig_print_statement_return twig_print_statement() throws RecognitionException {
        TwigParser.twig_print_statement_return retval = new TwigParser.twig_print_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PRINT_OPEN2=null;
        CommonToken PRINT_CLOSE4=null;
        TwigParser.twig_print_return twig_print3 = null;


        TwigCommonTree PRINT_OPEN2_tree=null;
        TwigCommonTree PRINT_CLOSE4_tree=null;
        RewriteRuleTokenStream stream_PRINT_OPEN=new RewriteRuleTokenStream(adaptor,"token PRINT_OPEN");
        RewriteRuleTokenStream stream_PRINT_CLOSE=new RewriteRuleTokenStream(adaptor,"token PRINT_CLOSE");
        RewriteRuleSubtreeStream stream_twig_print=new RewriteRuleSubtreeStream(adaptor,"rule twig_print");
        try {
            // TwigParser.g:67:3: ( PRINT_OPEN twig_print PRINT_CLOSE -> ^( TWIG_PR_STMT twig_print ) )
            // TwigParser.g:67:6: PRINT_OPEN twig_print PRINT_CLOSE
            {
            PRINT_OPEN2=(CommonToken)match(input,PRINT_OPEN,FOLLOW_PRINT_OPEN_in_twig_print_statement84);  
            stream_PRINT_OPEN.add(PRINT_OPEN2);

            pushFollow(FOLLOW_twig_print_in_twig_print_statement86);
            twig_print3=twig_print();

            state._fsp--;

            stream_twig_print.add(twig_print3.getTree());
            PRINT_CLOSE4=(CommonToken)match(input,PRINT_CLOSE,FOLLOW_PRINT_CLOSE_in_twig_print_statement88);  
            stream_PRINT_CLOSE.add(PRINT_CLOSE4);



            // AST REWRITE
            // elements: twig_print
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (TwigCommonTree)adaptor.nil();
            // 68:5: -> ^( TWIG_PR_STMT twig_print )
            {
                // TwigParser.g:68:7: ^( TWIG_PR_STMT twig_print )
                {
                TwigCommonTree root_1 = (TwigCommonTree)adaptor.nil();
                root_1 = (TwigCommonTree)adaptor.becomeRoot((TwigCommonTree)adaptor.create(TWIG_PR_STMT, "TWIG_PR_STMT"), root_1);

                adaptor.addChild(root_1, stream_twig_print.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
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
        }
        return retval;
    }
    // $ANTLR end "twig_print_statement"

    public static class twig_print_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_print"
    // TwigParser.g:72:1: twig_print : p_input ( PIPE p_input )* ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE6=null;
        TwigParser.p_input_return p_input5 = null;

        TwigParser.p_input_return p_input7 = null;


        TwigCommonTree PIPE6_tree=null;

        try {
            // TwigParser.g:73:3: ( p_input ( PIPE p_input )* )
            // TwigParser.g:73:5: p_input ( PIPE p_input )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_p_input_in_twig_print115);
            p_input5=p_input();

            state._fsp--;

            adaptor.addChild(root_0, p_input5.getTree());
            // TwigParser.g:73:13: ( PIPE p_input )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==PIPE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // TwigParser.g:73:14: PIPE p_input
            	    {
            	    PIPE6=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_print118); 
            	    PIPE6_tree = (TwigCommonTree)adaptor.create(PIPE6);
            	    adaptor.addChild(root_0, PIPE6_tree);

            	    pushFollow(FOLLOW_p_input_in_twig_print120);
            	    p_input7=p_input();

            	    state._fsp--;

            	    adaptor.addChild(root_0, p_input7.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
        }
        return retval;
    }
    // $ANTLR end "twig_print"

    public static class p_input_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "p_input"
    // TwigParser.g:76:1: p_input : ( variable | method | STRING_LITERAL );
    public final TwigParser.p_input_return p_input() throws RecognitionException {
        TwigParser.p_input_return retval = new TwigParser.p_input_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL10=null;
        TwigParser.variable_return variable8 = null;

        TwigParser.method_return method9 = null;


        TwigCommonTree STRING_LITERAL10_tree=null;

        try {
            // TwigParser.g:77:3: ( variable | method | STRING_LITERAL )
            int alt3=3;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==STRING) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==METHOD_START) ) {
                    alt3=2;
                }
                else if ( (LA3_1==PRINT_CLOSE||(LA3_1>=PIPE && LA3_1<=DOT)) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==STRING_LITERAL) ) {
                alt3=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // TwigParser.g:77:5: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_p_input137);
                    variable8=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable8.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:77:16: method
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_in_p_input141);
                    method9=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method9.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:77:25: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL10=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_p_input145); 
                    STRING_LITERAL10_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL10);
                    adaptor.addChild(root_0, STRING_LITERAL10_tree);


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
        }
        return retval;
    }
    // $ANTLR end "p_input"

    public static class variable_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable"
    // TwigParser.g:81:1: variable : param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) ;
    public final TwigParser.variable_return variable() throws RecognitionException {
        TwigParser.variable_return retval = new TwigParser.variable_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;
        CommonToken DOT11=null;
        CommonToken STRING12=null;

        TwigCommonTree param_tree=null;
        TwigCommonTree DOT11_tree=null;
        TwigCommonTree STRING12_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // TwigParser.g:82:3: (param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) )
            // TwigParser.g:82:5: param= STRING ( DOT ( STRING ) )*
            {
            param=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable165);  
            stream_STRING.add(param);

            // TwigParser.g:82:18: ( DOT ( STRING ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DOT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // TwigParser.g:82:19: DOT ( STRING )
            	    {
            	    DOT11=(CommonToken)match(input,DOT,FOLLOW_DOT_in_variable168);  
            	    stream_DOT.add(DOT11);

            	    // TwigParser.g:82:23: ( STRING )
            	    // TwigParser.g:82:24: STRING
            	    {
            	    STRING12=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable171);  
            	    stream_STRING.add(STRING12);


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);



            // AST REWRITE
            // elements: param
            // token labels: param
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_param=new RewriteRuleTokenStream(adaptor,"token param",param);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (TwigCommonTree)adaptor.nil();
            // 83:5: -> ^( TWIG_VAR $param)
            {
                // TwigParser.g:83:7: ^( TWIG_VAR $param)
                {
                TwigCommonTree root_1 = (TwigCommonTree)adaptor.nil();
                root_1 = (TwigCommonTree)adaptor.becomeRoot((TwigCommonTree)adaptor.create(TWIG_VAR, "TWIG_VAR"), root_1);

                adaptor.addChild(root_1, stream_param.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
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
        }
        return retval;
    }
    // $ANTLR end "variable"

    public static class method_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method"
    // TwigParser.g:86:1: method : STRING METHOD_START ( arguments )? METHOD_END ;
    public final TwigParser.method_return method() throws RecognitionException {
        TwigParser.method_return retval = new TwigParser.method_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING13=null;
        CommonToken METHOD_START14=null;
        CommonToken METHOD_END16=null;
        TwigParser.arguments_return arguments15 = null;


        TwigCommonTree STRING13_tree=null;
        TwigCommonTree METHOD_START14_tree=null;
        TwigCommonTree METHOD_END16_tree=null;

        try {
            // TwigParser.g:87:3: ( STRING METHOD_START ( arguments )? METHOD_END )
            // TwigParser.g:87:5: STRING METHOD_START ( arguments )? METHOD_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            STRING13=(CommonToken)match(input,STRING,FOLLOW_STRING_in_method201); 
            STRING13_tree = (TwigCommonTree)adaptor.create(STRING13);
            adaptor.addChild(root_0, STRING13_tree);

            METHOD_START14=(CommonToken)match(input,METHOD_START,FOLLOW_METHOD_START_in_method203); 
            METHOD_START14_tree = (TwigCommonTree)adaptor.create(METHOD_START14);
            adaptor.addChild(root_0, METHOD_START14_tree);

            // TwigParser.g:87:25: ( arguments )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==JSON_START||LA5_0==STRING_LITERAL) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // TwigParser.g:87:25: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_method205);
                    arguments15=arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, arguments15.getTree());

                    }
                    break;

            }

            METHOD_END16=(CommonToken)match(input,METHOD_END,FOLLOW_METHOD_END_in_method208); 
            METHOD_END16_tree = (TwigCommonTree)adaptor.create(METHOD_END16);
            adaptor.addChild(root_0, METHOD_END16_tree);


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
        }
        return retval;
    }
    // $ANTLR end "method"

    public static class arguments_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arguments"
    // TwigParser.g:90:1: arguments : argument ( COMMA ( argument ) )* ;
    public final TwigParser.arguments_return arguments() throws RecognitionException {
        TwigParser.arguments_return retval = new TwigParser.arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA18=null;
        TwigParser.argument_return argument17 = null;

        TwigParser.argument_return argument19 = null;


        TwigCommonTree COMMA18_tree=null;

        try {
            // TwigParser.g:91:3: ( argument ( COMMA ( argument ) )* )
            // TwigParser.g:91:5: argument ( COMMA ( argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_argument_in_arguments224);
            argument17=argument();

            state._fsp--;

            adaptor.addChild(root_0, argument17.getTree());
            // TwigParser.g:91:15: ( COMMA ( argument ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==COMMA) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // TwigParser.g:91:16: COMMA ( argument )
            	    {
            	    COMMA18=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_arguments228); 
            	    COMMA18_tree = (TwigCommonTree)adaptor.create(COMMA18);
            	    adaptor.addChild(root_0, COMMA18_tree);

            	    // TwigParser.g:91:22: ( argument )
            	    // TwigParser.g:91:23: argument
            	    {
            	    pushFollow(FOLLOW_argument_in_arguments231);
            	    argument19=argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, argument19.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


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
        }
        return retval;
    }
    // $ANTLR end "arguments"

    public static class argument_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argument"
    // TwigParser.g:94:1: argument : ( literal_argument | json );
    public final TwigParser.argument_return argument() throws RecognitionException {
        TwigParser.argument_return retval = new TwigParser.argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.literal_argument_return literal_argument20 = null;

        TwigParser.json_return json21 = null;



        try {
            // TwigParser.g:95:1: ( literal_argument | json )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==STRING_LITERAL) ) {
                alt7=1;
            }
            else if ( (LA7_0==JSON_START) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // TwigParser.g:95:3: literal_argument
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_argument_in_argument245);
                    literal_argument20=literal_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, literal_argument20.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:95:22: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_argument249);
                    json21=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json21.getTree());

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
        }
        return retval;
    }
    // $ANTLR end "argument"

    public static class literal_argument_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal_argument"
    // TwigParser.g:99:1: literal_argument : param= STRING_LITERAL -> ^( LITERAL_ARG $param) ;
    public final TwigParser.literal_argument_return literal_argument() throws RecognitionException {
        TwigParser.literal_argument_return retval = new TwigParser.literal_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;

        TwigCommonTree param_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");

        try {
            // TwigParser.g:100:3: (param= STRING_LITERAL -> ^( LITERAL_ARG $param) )
            // TwigParser.g:100:5: param= STRING_LITERAL
            {
            param=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal_argument263);  
            stream_STRING_LITERAL.add(param);



            // AST REWRITE
            // elements: param
            // token labels: param
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_param=new RewriteRuleTokenStream(adaptor,"token param",param);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (TwigCommonTree)adaptor.nil();
            // 101:5: -> ^( LITERAL_ARG $param)
            {
                // TwigParser.g:101:8: ^( LITERAL_ARG $param)
                {
                TwigCommonTree root_1 = (TwigCommonTree)adaptor.nil();
                root_1 = (TwigCommonTree)adaptor.becomeRoot((TwigCommonTree)adaptor.create(LITERAL_ARG, "LITERAL_ARG"), root_1);

                adaptor.addChild(root_1, stream_param.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;
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
        }
        return retval;
    }
    // $ANTLR end "literal_argument"

    public static class json_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "json"
    // TwigParser.g:105:1: json : JSON_START ( json_arguments )? JSON_END ;
    public final TwigParser.json_return json() throws RecognitionException {
        TwigParser.json_return retval = new TwigParser.json_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken JSON_START22=null;
        CommonToken JSON_END24=null;
        TwigParser.json_arguments_return json_arguments23 = null;


        TwigCommonTree JSON_START22_tree=null;
        TwigCommonTree JSON_END24_tree=null;

        try {
            // TwigParser.g:106:3: ( JSON_START ( json_arguments )? JSON_END )
            // TwigParser.g:106:5: JSON_START ( json_arguments )? JSON_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            JSON_START22=(CommonToken)match(input,JSON_START,FOLLOW_JSON_START_in_json290); 
            JSON_START22_tree = (TwigCommonTree)adaptor.create(JSON_START22);
            adaptor.addChild(root_0, JSON_START22_tree);

            // TwigParser.g:106:16: ( json_arguments )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==STRING_LITERAL) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // TwigParser.g:106:16: json_arguments
                    {
                    pushFollow(FOLLOW_json_arguments_in_json292);
                    json_arguments23=json_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, json_arguments23.getTree());

                    }
                    break;

            }

            JSON_END24=(CommonToken)match(input,JSON_END,FOLLOW_JSON_END_in_json295); 
            JSON_END24_tree = (TwigCommonTree)adaptor.create(JSON_END24);
            adaptor.addChild(root_0, JSON_END24_tree);


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
        }
        return retval;
    }
    // $ANTLR end "json"

    public static class json_arguments_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "json_arguments"
    // TwigParser.g:109:1: json_arguments : json_argument ( COMMA ( json_argument ) )* ;
    public final TwigParser.json_arguments_return json_arguments() throws RecognitionException {
        TwigParser.json_arguments_return retval = new TwigParser.json_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA26=null;
        TwigParser.json_argument_return json_argument25 = null;

        TwigParser.json_argument_return json_argument27 = null;


        TwigCommonTree COMMA26_tree=null;

        try {
            // TwigParser.g:110:3: ( json_argument ( COMMA ( json_argument ) )* )
            // TwigParser.g:110:5: json_argument ( COMMA ( json_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_json_argument_in_json_arguments310);
            json_argument25=json_argument();

            state._fsp--;

            adaptor.addChild(root_0, json_argument25.getTree());
            // TwigParser.g:110:19: ( COMMA ( json_argument ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==COMMA) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // TwigParser.g:110:20: COMMA ( json_argument )
            	    {
            	    COMMA26=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_json_arguments313); 
            	    COMMA26_tree = (TwigCommonTree)adaptor.create(COMMA26);
            	    adaptor.addChild(root_0, COMMA26_tree);

            	    // TwigParser.g:110:26: ( json_argument )
            	    // TwigParser.g:110:27: json_argument
            	    {
            	    pushFollow(FOLLOW_json_argument_in_json_arguments316);
            	    json_argument27=json_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, json_argument27.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


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
        }
        return retval;
    }
    // $ANTLR end "json_arguments"

    public static class json_argument_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "json_argument"
    // TwigParser.g:113:1: json_argument : STRING_LITERAL ASIG STRING_LITERAL ;
    public final TwigParser.json_argument_return json_argument() throws RecognitionException {
        TwigParser.json_argument_return retval = new TwigParser.json_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL28=null;
        CommonToken ASIG29=null;
        CommonToken STRING_LITERAL30=null;

        TwigCommonTree STRING_LITERAL28_tree=null;
        TwigCommonTree ASIG29_tree=null;
        TwigCommonTree STRING_LITERAL30_tree=null;

        try {
            // TwigParser.g:114:3: ( STRING_LITERAL ASIG STRING_LITERAL )
            // TwigParser.g:114:5: STRING_LITERAL ASIG STRING_LITERAL
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            STRING_LITERAL28=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_json_argument334); 
            STRING_LITERAL28_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL28);
            adaptor.addChild(root_0, STRING_LITERAL28_tree);

            ASIG29=(CommonToken)match(input,ASIG,FOLLOW_ASIG_in_json_argument336); 
            ASIG29_tree = (TwigCommonTree)adaptor.create(ASIG29);
            adaptor.addChild(root_0, ASIG29_tree);

            STRING_LITERAL30=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_json_argument338); 
            STRING_LITERAL30_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL30);
            adaptor.addChild(root_0, STRING_LITERAL30_tree);


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
        }
        return retval;
    }
    // $ANTLR end "json_argument"

    // Delegated rules


 

    public static final BitSet FOLLOW_NONCONTROL_CHAR_in_common_node68 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_PRINT_OPEN_in_twig_print_statement84 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_twig_print_in_twig_print_statement86 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_PRINT_CLOSE_in_twig_print_statement88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_p_input_in_twig_print115 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_PIPE_in_twig_print118 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_p_input_in_twig_print120 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_variable_in_p_input137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_p_input141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_p_input145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_variable165 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_DOT_in_variable168 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_STRING_in_variable171 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_STRING_in_method201 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_METHOD_START_in_method203 = new BitSet(new long[]{0x0000000000108200L});
    public static final BitSet FOLLOW_arguments_in_method205 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_METHOD_END_in_method208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_arguments224 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_COMMA_in_arguments228 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_argument_in_arguments231 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_literal_argument_in_argument245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_argument249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal_argument263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_START_in_json290 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_json_arguments_in_json292 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_JSON_END_in_json295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments310 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_COMMA_in_json_arguments313 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments316 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_json_argument334 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ASIG_in_json_argument336 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_json_argument338 = new BitSet(new long[]{0x0000000000000002L});

}