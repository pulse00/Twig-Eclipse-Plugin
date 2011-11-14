/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
// $ANTLR 3.3 Nov 30, 2010 12:45:30 TwigParser.g 2011-08-06 21:21:24

package com.dubture.twig.core.parser;

import com.dubture.twig.core.parser.error.IErrorReporter;
import com.dubture.twig.core.TwigCorePlugin;
import com.dubture.twig.core.log.Logger;




import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PRINT_OPEN", "PRINT_CLOSE", "CTRL_OPEN", "CTRL_CLOSE", "METHOD_START", "METHOD_END", "ARRAY_START", "ARRAY_END", "ASIG", "LARGER", "SMALLER", "EQUAL", "NOTEQUAL", "TILDE", "MINUS", "PIPE", "DDOT", "DOT", "COLON", "COMMA", "BSLASH", "JSON_START", "JSON_END", "QM", "IN", "TWIG_AS", "NOT", "WITH", "ONLY", "IS", "DEFINED", "DIGIT", "NUMBER", "STRING_CHAR", "STRING", "NONCONTROL_CHAR", "STRING_LITERAL", "LOWER", "UPPER", "UNDER", "LETTER", "SYMBOL", "WHITESPACE", "TWIG_PR_STMT", "TWIG_VAR", "TWIG_TAG", "LITERAL_ARG"
    };
    public static final int EOF=-1;
    public static final int PRINT_OPEN=4;
    public static final int PRINT_CLOSE=5;
    public static final int CTRL_OPEN=6;
    public static final int CTRL_CLOSE=7;
    public static final int METHOD_START=8;
    public static final int METHOD_END=9;
    public static final int ARRAY_START=10;
    public static final int ARRAY_END=11;
    public static final int ASIG=12;
    public static final int LARGER=13;
    public static final int SMALLER=14;
    public static final int EQUAL=15;
    public static final int NOTEQUAL=16;
    public static final int TILDE=17;
    public static final int MINUS=18;
    public static final int PIPE=19;
    public static final int DDOT=20;
    public static final int DOT=21;
    public static final int COLON=22;
    public static final int COMMA=23;
    public static final int BSLASH=24;
    public static final int JSON_START=25;
    public static final int JSON_END=26;
    public static final int QM=27;
    public static final int IN=28;
    public static final int TWIG_AS=29;
    public static final int NOT=30;
    public static final int WITH=31;
    public static final int ONLY=32;
    public static final int IS=33;
    public static final int DEFINED=34;
    public static final int DIGIT=35;
    public static final int NUMBER=36;
    public static final int STRING_CHAR=37;
    public static final int STRING=38;
    public static final int NONCONTROL_CHAR=39;
    public static final int STRING_LITERAL=40;
    public static final int LOWER=41;
    public static final int UPPER=42;
    public static final int UNDER=43;
    public static final int LETTER=44;
    public static final int SYMBOL=45;
    public static final int WHITESPACE=46;
    public static final int TWIG_PR_STMT=47;
    public static final int TWIG_VAR=48;
    public static final int TWIG_TAG=49;
    public static final int LITERAL_ARG=50;

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

            
                if(errorReporter == null) {
                	Logger.log(Logger.WARNING, "Parser has no error reporter instance!");
             	   
                 	return;
                }
                	

            	
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
    	


    public static class twig_source_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_source"
    // TwigParser.g:74:1: twig_source : ( twig_print_statement | twig_control_statement );
    public final TwigParser.twig_source_return twig_source() throws RecognitionException {
        TwigParser.twig_source_return retval = new TwigParser.twig_source_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.twig_print_statement_return twig_print_statement1 = null;

        TwigParser.twig_control_statement_return twig_control_statement2 = null;



        try {
            // TwigParser.g:75:3: ( twig_print_statement | twig_control_statement )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==PRINT_OPEN) ) {
                alt1=1;
            }
            else if ( (LA1_0==CTRL_OPEN) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // TwigParser.g:75:5: twig_print_statement
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_print_statement_in_twig_source72);
                    twig_print_statement1=twig_print_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_print_statement1.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:75:28: twig_control_statement
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_control_statement_in_twig_source76);
                    twig_control_statement2=twig_control_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_control_statement2.getTree());

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
    // $ANTLR end "twig_source"

    public static class twig_control_statement_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_control_statement"
    // TwigParser.g:80:1: twig_control_statement : CTRL_OPEN ( twig_control )? CTRL_CLOSE ;
    public final TwigParser.twig_control_statement_return twig_control_statement() throws RecognitionException {
        TwigParser.twig_control_statement_return retval = new TwigParser.twig_control_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken CTRL_OPEN3=null;
        CommonToken CTRL_CLOSE5=null;
        TwigParser.twig_control_return twig_control4 = null;


        TwigCommonTree CTRL_OPEN3_tree=null;
        TwigCommonTree CTRL_CLOSE5_tree=null;

        try {
            // TwigParser.g:81:3: ( CTRL_OPEN ( twig_control )? CTRL_CLOSE )
            // TwigParser.g:81:5: CTRL_OPEN ( twig_control )? CTRL_CLOSE
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            CTRL_OPEN3=(CommonToken)match(input,CTRL_OPEN,FOLLOW_CTRL_OPEN_in_twig_control_statement91); 
            CTRL_OPEN3_tree = (TwigCommonTree)adaptor.create(CTRL_OPEN3);
            adaptor.addChild(root_0, CTRL_OPEN3_tree);

            // TwigParser.g:81:15: ( twig_control )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==MINUS||LA2_0==STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // TwigParser.g:81:15: twig_control
                    {
                    pushFollow(FOLLOW_twig_control_in_twig_control_statement93);
                    twig_control4=twig_control();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_control4.getTree());

                    }
                    break;

            }

            CTRL_CLOSE5=(CommonToken)match(input,CTRL_CLOSE,FOLLOW_CTRL_CLOSE_in_twig_control_statement96); 
            CTRL_CLOSE5_tree = (TwigCommonTree)adaptor.create(CTRL_CLOSE5);
            adaptor.addChild(root_0, CTRL_CLOSE5_tree);


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
    // $ANTLR end "twig_control_statement"

    public static class twig_control_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_control"
    // TwigParser.g:84:1: twig_control : ( MINUS )? twig_control_tag ( twig_control_body )* ;
    public final TwigParser.twig_control_return twig_control() throws RecognitionException {
        TwigParser.twig_control_return retval = new TwigParser.twig_control_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken MINUS6=null;
        TwigParser.twig_control_tag_return twig_control_tag7 = null;

        TwigParser.twig_control_body_return twig_control_body8 = null;


        TwigCommonTree MINUS6_tree=null;

        try {
            // TwigParser.g:85:3: ( ( MINUS )? twig_control_tag ( twig_control_body )* )
            // TwigParser.g:85:5: ( MINUS )? twig_control_tag ( twig_control_body )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:85:5: ( MINUS )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==MINUS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // TwigParser.g:85:5: MINUS
                    {
                    MINUS6=(CommonToken)match(input,MINUS,FOLLOW_MINUS_in_twig_control109); 
                    MINUS6_tree = (TwigCommonTree)adaptor.create(MINUS6);
                    adaptor.addChild(root_0, MINUS6_tree);


                    }
                    break;

            }

            pushFollow(FOLLOW_twig_control_tag_in_twig_control112);
            twig_control_tag7=twig_control_tag();

            state._fsp--;

            adaptor.addChild(root_0, twig_control_tag7.getTree());
            // TwigParser.g:85:29: ( twig_control_body )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==METHOD_START||LA4_0==ARRAY_START||LA4_0==ASIG||LA4_0==TILDE||LA4_0==PIPE||(LA4_0>=COLON && LA4_0<=COMMA)||LA4_0==JSON_START||(LA4_0>=QM && LA4_0<=DEFINED)||LA4_0==NUMBER||LA4_0==STRING||LA4_0==STRING_LITERAL) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // TwigParser.g:85:29: twig_control_body
            	    {
            	    pushFollow(FOLLOW_twig_control_body_in_twig_control114);
            	    twig_control_body8=twig_control_body();

            	    state._fsp--;

            	    adaptor.addChild(root_0, twig_control_body8.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
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
    // $ANTLR end "twig_control"

    public static class twig_control_tag_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_control_tag"
    // TwigParser.g:89:1: twig_control_tag : param= STRING -> ^( TWIG_TAG $param) ;
    public final TwigParser.twig_control_tag_return twig_control_tag() throws RecognitionException {
        TwigParser.twig_control_tag_return retval = new TwigParser.twig_control_tag_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;

        TwigCommonTree param_tree=null;
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // TwigParser.g:90:3: (param= STRING -> ^( TWIG_TAG $param) )
            // TwigParser.g:90:5: param= STRING
            {
            param=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_control_tag135);  
            stream_STRING.add(param);



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
            // 91:5: -> ^( TWIG_TAG $param)
            {
                // TwigParser.g:91:7: ^( TWIG_TAG $param)
                {
                TwigCommonTree root_1 = (TwigCommonTree)adaptor.nil();
                root_1 = (TwigCommonTree)adaptor.becomeRoot((TwigCommonTree)adaptor.create(TWIG_TAG, "TWIG_TAG"), root_1);

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
    // $ANTLR end "twig_control_tag"

    public static class twig_control_body_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_control_body"
    // TwigParser.g:94:1: twig_control_body : ( STRING_LITERAL | ASIG | PIPE | TILDE | NUMBER | COMMA | QM | COLON | range | eq_check | var_or_field | method_chain | keyword | array | json | in_check );
    public final TwigParser.twig_control_body_return twig_control_body() throws RecognitionException {
        TwigParser.twig_control_body_return retval = new TwigParser.twig_control_body_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL9=null;
        CommonToken ASIG10=null;
        CommonToken PIPE11=null;
        CommonToken TILDE12=null;
        CommonToken NUMBER13=null;
        CommonToken COMMA14=null;
        CommonToken QM15=null;
        CommonToken COLON16=null;
        TwigParser.range_return range17 = null;

        TwigParser.eq_check_return eq_check18 = null;

        TwigParser.var_or_field_return var_or_field19 = null;

        TwigParser.method_chain_return method_chain20 = null;

        TwigParser.keyword_return keyword21 = null;

        TwigParser.array_return array22 = null;

        TwigParser.json_return json23 = null;

        TwigParser.in_check_return in_check24 = null;


        TwigCommonTree STRING_LITERAL9_tree=null;
        TwigCommonTree ASIG10_tree=null;
        TwigCommonTree PIPE11_tree=null;
        TwigCommonTree TILDE12_tree=null;
        TwigCommonTree NUMBER13_tree=null;
        TwigCommonTree COMMA14_tree=null;
        TwigCommonTree QM15_tree=null;
        TwigCommonTree COLON16_tree=null;

        try {
            // TwigParser.g:95:3: ( STRING_LITERAL | ASIG | PIPE | TILDE | NUMBER | COMMA | QM | COLON | range | eq_check | var_or_field | method_chain | keyword | array | json | in_check )
            int alt5=16;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // TwigParser.g:95:5: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL9=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_control_body164); 
                    STRING_LITERAL9_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL9);
                    adaptor.addChild(root_0, STRING_LITERAL9_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:95:22: ASIG
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ASIG10=(CommonToken)match(input,ASIG,FOLLOW_ASIG_in_twig_control_body168); 
                    ASIG10_tree = (TwigCommonTree)adaptor.create(ASIG10);
                    adaptor.addChild(root_0, ASIG10_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:95:29: PIPE
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    PIPE11=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_control_body172); 
                    PIPE11_tree = (TwigCommonTree)adaptor.create(PIPE11);
                    adaptor.addChild(root_0, PIPE11_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:95:36: TILDE
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    TILDE12=(CommonToken)match(input,TILDE,FOLLOW_TILDE_in_twig_control_body176); 
                    TILDE12_tree = (TwigCommonTree)adaptor.create(TILDE12);
                    adaptor.addChild(root_0, TILDE12_tree);


                    }
                    break;
                case 5 :
                    // TwigParser.g:95:44: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER13=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_control_body180); 
                    NUMBER13_tree = (TwigCommonTree)adaptor.create(NUMBER13);
                    adaptor.addChild(root_0, NUMBER13_tree);


                    }
                    break;
                case 6 :
                    // TwigParser.g:95:53: COMMA
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    COMMA14=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_control_body184); 
                    COMMA14_tree = (TwigCommonTree)adaptor.create(COMMA14);
                    adaptor.addChild(root_0, COMMA14_tree);


                    }
                    break;
                case 7 :
                    // TwigParser.g:95:61: QM
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    QM15=(CommonToken)match(input,QM,FOLLOW_QM_in_twig_control_body188); 
                    QM15_tree = (TwigCommonTree)adaptor.create(QM15);
                    adaptor.addChild(root_0, QM15_tree);


                    }
                    break;
                case 8 :
                    // TwigParser.g:95:66: COLON
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    COLON16=(CommonToken)match(input,COLON,FOLLOW_COLON_in_twig_control_body192); 
                    COLON16_tree = (TwigCommonTree)adaptor.create(COLON16);
                    adaptor.addChild(root_0, COLON16_tree);


                    }
                    break;
                case 9 :
                    // TwigParser.g:95:74: range
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_range_in_twig_control_body196);
                    range17=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range17.getTree());

                    }
                    break;
                case 10 :
                    // TwigParser.g:95:82: eq_check
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_eq_check_in_twig_control_body200);
                    eq_check18=eq_check();

                    state._fsp--;

                    adaptor.addChild(root_0, eq_check18.getTree());

                    }
                    break;
                case 11 :
                    // TwigParser.g:95:93: var_or_field
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_var_or_field_in_twig_control_body204);
                    var_or_field19=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field19.getTree());

                    }
                    break;
                case 12 :
                    // TwigParser.g:95:108: method_chain
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_chain_in_twig_control_body208);
                    method_chain20=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain20.getTree());

                    }
                    break;
                case 13 :
                    // TwigParser.g:95:123: keyword
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_keyword_in_twig_control_body212);
                    keyword21=keyword();

                    state._fsp--;

                    adaptor.addChild(root_0, keyword21.getTree());

                    }
                    break;
                case 14 :
                    // TwigParser.g:95:133: array
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_array_in_twig_control_body216);
                    array22=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array22.getTree());

                    }
                    break;
                case 15 :
                    // TwigParser.g:95:141: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_twig_control_body220);
                    json23=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json23.getTree());

                    }
                    break;
                case 16 :
                    // TwigParser.g:95:148: in_check
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_in_check_in_twig_control_body224);
                    in_check24=in_check();

                    state._fsp--;

                    adaptor.addChild(root_0, in_check24.getTree());

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
    // $ANTLR end "twig_control_body"

    public static class in_check_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "in_check"
    // TwigParser.g:99:1: in_check : METHOD_START ( STRING_LITERAL | var_or_field ) IN ( STRING_LITERAL | var_or_field ) METHOD_END ;
    public final TwigParser.in_check_return in_check() throws RecognitionException {
        TwigParser.in_check_return retval = new TwigParser.in_check_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken METHOD_START25=null;
        CommonToken STRING_LITERAL26=null;
        CommonToken IN28=null;
        CommonToken STRING_LITERAL29=null;
        CommonToken METHOD_END31=null;
        TwigParser.var_or_field_return var_or_field27 = null;

        TwigParser.var_or_field_return var_or_field30 = null;


        TwigCommonTree METHOD_START25_tree=null;
        TwigCommonTree STRING_LITERAL26_tree=null;
        TwigCommonTree IN28_tree=null;
        TwigCommonTree STRING_LITERAL29_tree=null;
        TwigCommonTree METHOD_END31_tree=null;

        try {
            // TwigParser.g:100:3: ( METHOD_START ( STRING_LITERAL | var_or_field ) IN ( STRING_LITERAL | var_or_field ) METHOD_END )
            // TwigParser.g:100:5: METHOD_START ( STRING_LITERAL | var_or_field ) IN ( STRING_LITERAL | var_or_field ) METHOD_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            METHOD_START25=(CommonToken)match(input,METHOD_START,FOLLOW_METHOD_START_in_in_check243); 
            METHOD_START25_tree = (TwigCommonTree)adaptor.create(METHOD_START25);
            adaptor.addChild(root_0, METHOD_START25_tree);

            // TwigParser.g:100:18: ( STRING_LITERAL | var_or_field )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==STRING_LITERAL) ) {
                alt6=1;
            }
            else if ( (LA6_0==STRING) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // TwigParser.g:100:19: STRING_LITERAL
                    {
                    STRING_LITERAL26=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_in_check246); 
                    STRING_LITERAL26_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL26);
                    adaptor.addChild(root_0, STRING_LITERAL26_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:100:36: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_in_check250);
                    var_or_field27=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field27.getTree());

                    }
                    break;

            }

            IN28=(CommonToken)match(input,IN,FOLLOW_IN_in_in_check253); 
            IN28_tree = (TwigCommonTree)adaptor.create(IN28);
            adaptor.addChild(root_0, IN28_tree);

            // TwigParser.g:100:53: ( STRING_LITERAL | var_or_field )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==STRING_LITERAL) ) {
                alt7=1;
            }
            else if ( (LA7_0==STRING) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // TwigParser.g:100:54: STRING_LITERAL
                    {
                    STRING_LITERAL29=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_in_check256); 
                    STRING_LITERAL29_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL29);
                    adaptor.addChild(root_0, STRING_LITERAL29_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:100:71: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_in_check260);
                    var_or_field30=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field30.getTree());

                    }
                    break;

            }

            METHOD_END31=(CommonToken)match(input,METHOD_END,FOLLOW_METHOD_END_in_in_check263); 
            METHOD_END31_tree = (TwigCommonTree)adaptor.create(METHOD_END31);
            adaptor.addChild(root_0, METHOD_END31_tree);


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
    // $ANTLR end "in_check"

    public static class range_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "range"
    // TwigParser.g:103:1: range : ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) ;
    public final TwigParser.range_return range() throws RecognitionException {
        TwigParser.range_return retval = new TwigParser.range_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set32=null;
        CommonToken DDOT33=null;
        CommonToken set34=null;

        TwigCommonTree set32_tree=null;
        TwigCommonTree DDOT33_tree=null;
        TwigCommonTree set34_tree=null;

        try {
            // TwigParser.g:104:3: ( ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) )
            // TwigParser.g:104:5: ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set32=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set32));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            DDOT33=(CommonToken)match(input,DDOT,FOLLOW_DDOT_in_range290); 
            DDOT33_tree = (TwigCommonTree)adaptor.create(DDOT33);
            adaptor.addChild(root_0, DDOT33_tree);

            set34=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set34));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "range"

    public static class twig_ternary_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_ternary"
    // TwigParser.g:107:1: twig_ternary : ( STRING_LITERAL | NUMBER | var_or_field | method_chain | eq_check ) QM ( STRING_LITERAL | NUMBER | var_or_field | method_chain ) COLON ( STRING_LITERAL | NUMBER | var_or_field | method_chain ) ;
    public final TwigParser.twig_ternary_return twig_ternary() throws RecognitionException {
        TwigParser.twig_ternary_return retval = new TwigParser.twig_ternary_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL35=null;
        CommonToken NUMBER36=null;
        CommonToken QM40=null;
        CommonToken STRING_LITERAL41=null;
        CommonToken NUMBER42=null;
        CommonToken COLON45=null;
        CommonToken STRING_LITERAL46=null;
        CommonToken NUMBER47=null;
        TwigParser.var_or_field_return var_or_field37 = null;

        TwigParser.method_chain_return method_chain38 = null;

        TwigParser.eq_check_return eq_check39 = null;

        TwigParser.var_or_field_return var_or_field43 = null;

        TwigParser.method_chain_return method_chain44 = null;

        TwigParser.var_or_field_return var_or_field48 = null;

        TwigParser.method_chain_return method_chain49 = null;


        TwigCommonTree STRING_LITERAL35_tree=null;
        TwigCommonTree NUMBER36_tree=null;
        TwigCommonTree QM40_tree=null;
        TwigCommonTree STRING_LITERAL41_tree=null;
        TwigCommonTree NUMBER42_tree=null;
        TwigCommonTree COLON45_tree=null;
        TwigCommonTree STRING_LITERAL46_tree=null;
        TwigCommonTree NUMBER47_tree=null;

        try {
            // TwigParser.g:108:3: ( ( STRING_LITERAL | NUMBER | var_or_field | method_chain | eq_check ) QM ( STRING_LITERAL | NUMBER | var_or_field | method_chain ) COLON ( STRING_LITERAL | NUMBER | var_or_field | method_chain ) )
            // TwigParser.g:108:5: ( STRING_LITERAL | NUMBER | var_or_field | method_chain | eq_check ) QM ( STRING_LITERAL | NUMBER | var_or_field | method_chain ) COLON ( STRING_LITERAL | NUMBER | var_or_field | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:108:5: ( STRING_LITERAL | NUMBER | var_or_field | method_chain | eq_check )
            int alt8=5;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // TwigParser.g:108:6: STRING_LITERAL
                    {
                    STRING_LITERAL35=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary319); 
                    STRING_LITERAL35_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL35);
                    adaptor.addChild(root_0, STRING_LITERAL35_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:108:23: NUMBER
                    {
                    NUMBER36=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary323); 
                    NUMBER36_tree = (TwigCommonTree)adaptor.create(NUMBER36);
                    adaptor.addChild(root_0, NUMBER36_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:108:32: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_twig_ternary327);
                    var_or_field37=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field37.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:108:47: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary331);
                    method_chain38=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain38.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:108:62: eq_check
                    {
                    pushFollow(FOLLOW_eq_check_in_twig_ternary335);
                    eq_check39=eq_check();

                    state._fsp--;

                    adaptor.addChild(root_0, eq_check39.getTree());

                    }
                    break;

            }

            QM40=(CommonToken)match(input,QM,FOLLOW_QM_in_twig_ternary338); 
            QM40_tree = (TwigCommonTree)adaptor.create(QM40);
            adaptor.addChild(root_0, QM40_tree);

            // TwigParser.g:108:75: ( STRING_LITERAL | NUMBER | var_or_field | method_chain )
            int alt9=4;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // TwigParser.g:108:76: STRING_LITERAL
                    {
                    STRING_LITERAL41=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary341); 
                    STRING_LITERAL41_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL41);
                    adaptor.addChild(root_0, STRING_LITERAL41_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:108:93: NUMBER
                    {
                    NUMBER42=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary345); 
                    NUMBER42_tree = (TwigCommonTree)adaptor.create(NUMBER42);
                    adaptor.addChild(root_0, NUMBER42_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:108:102: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_twig_ternary349);
                    var_or_field43=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field43.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:108:117: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary353);
                    method_chain44=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain44.getTree());

                    }
                    break;

            }

            COLON45=(CommonToken)match(input,COLON,FOLLOW_COLON_in_twig_ternary356); 
            COLON45_tree = (TwigCommonTree)adaptor.create(COLON45);
            adaptor.addChild(root_0, COLON45_tree);

            // TwigParser.g:108:137: ( STRING_LITERAL | NUMBER | var_or_field | method_chain )
            int alt10=4;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // TwigParser.g:108:138: STRING_LITERAL
                    {
                    STRING_LITERAL46=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary359); 
                    STRING_LITERAL46_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL46);
                    adaptor.addChild(root_0, STRING_LITERAL46_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:108:155: NUMBER
                    {
                    NUMBER47=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary363); 
                    NUMBER47_tree = (TwigCommonTree)adaptor.create(NUMBER47);
                    adaptor.addChild(root_0, NUMBER47_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:108:164: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_twig_ternary367);
                    var_or_field48=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field48.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:108:179: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary371);
                    method_chain49=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain49.getTree());

                    }
                    break;

            }


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
    // $ANTLR end "twig_ternary"

    public static class eq_check_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eq_check"
    // TwigParser.g:112:1: eq_check : ( var_or_field | method_chain | NUMBER | STRING_LITERAL ) ( EQUAL | NOTEQUAL | LARGER | SMALLER ) ( var_or_field | method_chain | NUMBER | STRING_LITERAL ) ;
    public final TwigParser.eq_check_return eq_check() throws RecognitionException {
        TwigParser.eq_check_return retval = new TwigParser.eq_check_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken NUMBER52=null;
        CommonToken STRING_LITERAL53=null;
        CommonToken set54=null;
        CommonToken NUMBER57=null;
        CommonToken STRING_LITERAL58=null;
        TwigParser.var_or_field_return var_or_field50 = null;

        TwigParser.method_chain_return method_chain51 = null;

        TwigParser.var_or_field_return var_or_field55 = null;

        TwigParser.method_chain_return method_chain56 = null;


        TwigCommonTree NUMBER52_tree=null;
        TwigCommonTree STRING_LITERAL53_tree=null;
        TwigCommonTree set54_tree=null;
        TwigCommonTree NUMBER57_tree=null;
        TwigCommonTree STRING_LITERAL58_tree=null;

        try {
            // TwigParser.g:113:3: ( ( var_or_field | method_chain | NUMBER | STRING_LITERAL ) ( EQUAL | NOTEQUAL | LARGER | SMALLER ) ( var_or_field | method_chain | NUMBER | STRING_LITERAL ) )
            // TwigParser.g:113:5: ( var_or_field | method_chain | NUMBER | STRING_LITERAL ) ( EQUAL | NOTEQUAL | LARGER | SMALLER ) ( var_or_field | method_chain | NUMBER | STRING_LITERAL )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:113:5: ( var_or_field | method_chain | NUMBER | STRING_LITERAL )
            int alt11=4;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // TwigParser.g:113:6: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_eq_check388);
                    var_or_field50=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field50.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:113:21: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_eq_check392);
                    method_chain51=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain51.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:113:36: NUMBER
                    {
                    NUMBER52=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_eq_check396); 
                    NUMBER52_tree = (TwigCommonTree)adaptor.create(NUMBER52);
                    adaptor.addChild(root_0, NUMBER52_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:113:45: STRING_LITERAL
                    {
                    STRING_LITERAL53=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_eq_check400); 
                    STRING_LITERAL53_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL53);
                    adaptor.addChild(root_0, STRING_LITERAL53_tree);


                    }
                    break;

            }

            set54=(CommonToken)input.LT(1);
            if ( (input.LA(1)>=LARGER && input.LA(1)<=NOTEQUAL) ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set54));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // TwigParser.g:113:99: ( var_or_field | method_chain | NUMBER | STRING_LITERAL )
            int alt12=4;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // TwigParser.g:113:100: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_eq_check420);
                    var_or_field55=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field55.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:113:115: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_eq_check424);
                    method_chain56=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain56.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:113:130: NUMBER
                    {
                    NUMBER57=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_eq_check428); 
                    NUMBER57_tree = (TwigCommonTree)adaptor.create(NUMBER57);
                    adaptor.addChild(root_0, NUMBER57_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:113:139: STRING_LITERAL
                    {
                    STRING_LITERAL58=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_eq_check432); 
                    STRING_LITERAL58_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL58);
                    adaptor.addChild(root_0, STRING_LITERAL58_tree);


                    }
                    break;

            }


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
    // $ANTLR end "eq_check"

    public static class twig_print_statement_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_print_statement"
    // TwigParser.g:118:1: twig_print_statement : PRINT_OPEN ( twig_print )? PRINT_CLOSE -> ^( TWIG_PR_STMT ( twig_print )? ) ;
    public final TwigParser.twig_print_statement_return twig_print_statement() throws RecognitionException {
        TwigParser.twig_print_statement_return retval = new TwigParser.twig_print_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PRINT_OPEN59=null;
        CommonToken PRINT_CLOSE61=null;
        TwigParser.twig_print_return twig_print60 = null;


        TwigCommonTree PRINT_OPEN59_tree=null;
        TwigCommonTree PRINT_CLOSE61_tree=null;
        RewriteRuleTokenStream stream_PRINT_OPEN=new RewriteRuleTokenStream(adaptor,"token PRINT_OPEN");
        RewriteRuleTokenStream stream_PRINT_CLOSE=new RewriteRuleTokenStream(adaptor,"token PRINT_CLOSE");
        RewriteRuleSubtreeStream stream_twig_print=new RewriteRuleSubtreeStream(adaptor,"rule twig_print");
        try {
            // TwigParser.g:119:3: ( PRINT_OPEN ( twig_print )? PRINT_CLOSE -> ^( TWIG_PR_STMT ( twig_print )? ) )
            // TwigParser.g:119:6: PRINT_OPEN ( twig_print )? PRINT_CLOSE
            {
            PRINT_OPEN59=(CommonToken)match(input,PRINT_OPEN,FOLLOW_PRINT_OPEN_in_twig_print_statement453);  
            stream_PRINT_OPEN.add(PRINT_OPEN59);

            // TwigParser.g:119:17: ( twig_print )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ARRAY_START||LA13_0==NOT||LA13_0==NUMBER||LA13_0==STRING||LA13_0==STRING_LITERAL) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // TwigParser.g:119:17: twig_print
                    {
                    pushFollow(FOLLOW_twig_print_in_twig_print_statement455);
                    twig_print60=twig_print();

                    state._fsp--;

                    stream_twig_print.add(twig_print60.getTree());

                    }
                    break;

            }

            PRINT_CLOSE61=(CommonToken)match(input,PRINT_CLOSE,FOLLOW_PRINT_CLOSE_in_twig_print_statement458);  
            stream_PRINT_CLOSE.add(PRINT_CLOSE61);



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
            // 120:5: -> ^( TWIG_PR_STMT ( twig_print )? )
            {
                // TwigParser.g:120:7: ^( TWIG_PR_STMT ( twig_print )? )
                {
                TwigCommonTree root_1 = (TwigCommonTree)adaptor.nil();
                root_1 = (TwigCommonTree)adaptor.becomeRoot((TwigCommonTree)adaptor.create(TWIG_PR_STMT, "TWIG_PR_STMT"), root_1);

                // TwigParser.g:120:22: ( twig_print )?
                if ( stream_twig_print.hasNext() ) {
                    adaptor.addChild(root_1, stream_twig_print.nextTree());

                }
                stream_twig_print.reset();

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
    // TwigParser.g:123:1: twig_print : p_input ( PIPE p_input )* ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE63=null;
        TwigParser.p_input_return p_input62 = null;

        TwigParser.p_input_return p_input64 = null;


        TwigCommonTree PIPE63_tree=null;

        try {
            // TwigParser.g:124:3: ( p_input ( PIPE p_input )* )
            // TwigParser.g:124:5: p_input ( PIPE p_input )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_p_input_in_twig_print485);
            p_input62=p_input();

            state._fsp--;

            adaptor.addChild(root_0, p_input62.getTree());
            // TwigParser.g:124:13: ( PIPE p_input )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==PIPE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // TwigParser.g:124:14: PIPE p_input
            	    {
            	    PIPE63=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_print488); 
            	    PIPE63_tree = (TwigCommonTree)adaptor.create(PIPE63);
            	    adaptor.addChild(root_0, PIPE63_tree);

            	    pushFollow(FOLLOW_p_input_in_twig_print490);
            	    p_input64=p_input();

            	    state._fsp--;

            	    adaptor.addChild(root_0, p_input64.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // TwigParser.g:127:1: p_input : ( var_or_field | method_chain | array | STRING_LITERAL | twig_ternary | twig_not | concat );
    public final TwigParser.p_input_return p_input() throws RecognitionException {
        TwigParser.p_input_return retval = new TwigParser.p_input_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL68=null;
        TwigParser.var_or_field_return var_or_field65 = null;

        TwigParser.method_chain_return method_chain66 = null;

        TwigParser.array_return array67 = null;

        TwigParser.twig_ternary_return twig_ternary69 = null;

        TwigParser.twig_not_return twig_not70 = null;

        TwigParser.concat_return concat71 = null;


        TwigCommonTree STRING_LITERAL68_tree=null;

        try {
            // TwigParser.g:128:3: ( var_or_field | method_chain | array | STRING_LITERAL | twig_ternary | twig_not | concat )
            int alt15=7;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // TwigParser.g:128:5: var_or_field
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_var_or_field_in_p_input507);
                    var_or_field65=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field65.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:128:20: method_chain
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_chain_in_p_input511);
                    method_chain66=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain66.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:128:35: array
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_array_in_p_input515);
                    array67=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array67.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:128:43: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL68=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_p_input519); 
                    STRING_LITERAL68_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL68);
                    adaptor.addChild(root_0, STRING_LITERAL68_tree);


                    }
                    break;
                case 5 :
                    // TwigParser.g:128:60: twig_ternary
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_ternary_in_p_input523);
                    twig_ternary69=twig_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_ternary69.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:128:75: twig_not
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_not_in_p_input527);
                    twig_not70=twig_not();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_not70.getTree());

                    }
                    break;
                case 7 :
                    // TwigParser.g:128:86: concat
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_concat_in_p_input531);
                    concat71=concat();

                    state._fsp--;

                    adaptor.addChild(root_0, concat71.getTree());

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

    public static class concat_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concat"
    // TwigParser.g:131:1: concat : concat_operand ( TILDE concat_operand )+ ;
    public final TwigParser.concat_return concat() throws RecognitionException {
        TwigParser.concat_return retval = new TwigParser.concat_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken TILDE73=null;
        TwigParser.concat_operand_return concat_operand72 = null;

        TwigParser.concat_operand_return concat_operand74 = null;


        TwigCommonTree TILDE73_tree=null;

        try {
            // TwigParser.g:132:3: ( concat_operand ( TILDE concat_operand )+ )
            // TwigParser.g:132:5: concat_operand ( TILDE concat_operand )+
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_concat_operand_in_concat546);
            concat_operand72=concat_operand();

            state._fsp--;

            adaptor.addChild(root_0, concat_operand72.getTree());
            // TwigParser.g:132:20: ( TILDE concat_operand )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==TILDE) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // TwigParser.g:132:21: TILDE concat_operand
            	    {
            	    TILDE73=(CommonToken)match(input,TILDE,FOLLOW_TILDE_in_concat549); 
            	    TILDE73_tree = (TwigCommonTree)adaptor.create(TILDE73);
            	    adaptor.addChild(root_0, TILDE73_tree);

            	    pushFollow(FOLLOW_concat_operand_in_concat551);
            	    concat_operand74=concat_operand();

            	    state._fsp--;

            	    adaptor.addChild(root_0, concat_operand74.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
    // $ANTLR end "concat"

    public static class concat_operand_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concat_operand"
    // TwigParser.g:135:1: concat_operand : ( STRING_LITERAL | var_or_field | method_chain ) ;
    public final TwigParser.concat_operand_return concat_operand() throws RecognitionException {
        TwigParser.concat_operand_return retval = new TwigParser.concat_operand_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL75=null;
        TwigParser.var_or_field_return var_or_field76 = null;

        TwigParser.method_chain_return method_chain77 = null;


        TwigCommonTree STRING_LITERAL75_tree=null;

        try {
            // TwigParser.g:136:3: ( ( STRING_LITERAL | var_or_field | method_chain ) )
            // TwigParser.g:136:5: ( STRING_LITERAL | var_or_field | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:136:5: ( STRING_LITERAL | var_or_field | method_chain )
            int alt17=3;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // TwigParser.g:136:6: STRING_LITERAL
                    {
                    STRING_LITERAL75=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_concat_operand569); 
                    STRING_LITERAL75_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL75);
                    adaptor.addChild(root_0, STRING_LITERAL75_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:136:23: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_concat_operand573);
                    var_or_field76=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field76.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:136:38: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_concat_operand577);
                    method_chain77=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain77.getTree());

                    }
                    break;

            }


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
    // $ANTLR end "concat_operand"

    public static class twig_not_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_not"
    // TwigParser.g:139:1: twig_not : NOT ( twig_ternary | var_or_field | method_chain ) ;
    public final TwigParser.twig_not_return twig_not() throws RecognitionException {
        TwigParser.twig_not_return retval = new TwigParser.twig_not_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken NOT78=null;
        TwigParser.twig_ternary_return twig_ternary79 = null;

        TwigParser.var_or_field_return var_or_field80 = null;

        TwigParser.method_chain_return method_chain81 = null;


        TwigCommonTree NOT78_tree=null;

        try {
            // TwigParser.g:140:3: ( NOT ( twig_ternary | var_or_field | method_chain ) )
            // TwigParser.g:140:5: NOT ( twig_ternary | var_or_field | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            NOT78=(CommonToken)match(input,NOT,FOLLOW_NOT_in_twig_not593); 
            NOT78_tree = (TwigCommonTree)adaptor.create(NOT78);
            adaptor.addChild(root_0, NOT78_tree);

            // TwigParser.g:140:9: ( twig_ternary | var_or_field | method_chain )
            int alt18=3;
            alt18 = dfa18.predict(input);
            switch (alt18) {
                case 1 :
                    // TwigParser.g:140:10: twig_ternary
                    {
                    pushFollow(FOLLOW_twig_ternary_in_twig_not596);
                    twig_ternary79=twig_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_ternary79.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:140:25: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_twig_not600);
                    var_or_field80=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field80.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:140:40: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_not604);
                    method_chain81=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain81.getTree());

                    }
                    break;

            }


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
    // $ANTLR end "twig_not"

    public static class array_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array"
    // TwigParser.g:143:1: array : ARRAY_START array_elements ARRAY_END ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ARRAY_START82=null;
        CommonToken ARRAY_END84=null;
        TwigParser.array_elements_return array_elements83 = null;


        TwigCommonTree ARRAY_START82_tree=null;
        TwigCommonTree ARRAY_END84_tree=null;

        try {
            // TwigParser.g:144:3: ( ARRAY_START array_elements ARRAY_END )
            // TwigParser.g:144:5: ARRAY_START array_elements ARRAY_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ARRAY_START82=(CommonToken)match(input,ARRAY_START,FOLLOW_ARRAY_START_in_array620); 
            ARRAY_START82_tree = (TwigCommonTree)adaptor.create(ARRAY_START82);
            adaptor.addChild(root_0, ARRAY_START82_tree);

            pushFollow(FOLLOW_array_elements_in_array622);
            array_elements83=array_elements();

            state._fsp--;

            adaptor.addChild(root_0, array_elements83.getTree());
            ARRAY_END84=(CommonToken)match(input,ARRAY_END,FOLLOW_ARRAY_END_in_array624); 
            ARRAY_END84_tree = (TwigCommonTree)adaptor.create(ARRAY_END84);
            adaptor.addChild(root_0, ARRAY_END84_tree);


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
    // $ANTLR end "array"

    public static class array_elements_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array_elements"
    // TwigParser.g:147:1: array_elements : array_element ( COMMA array_element )* ;
    public final TwigParser.array_elements_return array_elements() throws RecognitionException {
        TwigParser.array_elements_return retval = new TwigParser.array_elements_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA86=null;
        TwigParser.array_element_return array_element85 = null;

        TwigParser.array_element_return array_element87 = null;


        TwigCommonTree COMMA86_tree=null;

        try {
            // TwigParser.g:148:3: ( array_element ( COMMA array_element )* )
            // TwigParser.g:148:5: array_element ( COMMA array_element )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_array_element_in_array_elements639);
            array_element85=array_element();

            state._fsp--;

            adaptor.addChild(root_0, array_element85.getTree());
            // TwigParser.g:148:19: ( COMMA array_element )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // TwigParser.g:148:20: COMMA array_element
            	    {
            	    COMMA86=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_array_elements642); 
            	    COMMA86_tree = (TwigCommonTree)adaptor.create(COMMA86);
            	    adaptor.addChild(root_0, COMMA86_tree);

            	    pushFollow(FOLLOW_array_element_in_array_elements644);
            	    array_element87=array_element();

            	    state._fsp--;

            	    adaptor.addChild(root_0, array_element87.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // $ANTLR end "array_elements"

    public static class array_element_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array_element"
    // TwigParser.g:151:1: array_element : ( STRING | STRING_LITERAL | NUMBER | json );
    public final TwigParser.array_element_return array_element() throws RecognitionException {
        TwigParser.array_element_return retval = new TwigParser.array_element_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING88=null;
        CommonToken STRING_LITERAL89=null;
        CommonToken NUMBER90=null;
        TwigParser.json_return json91 = null;


        TwigCommonTree STRING88_tree=null;
        TwigCommonTree STRING_LITERAL89_tree=null;
        TwigCommonTree NUMBER90_tree=null;

        try {
            // TwigParser.g:152:3: ( STRING | STRING_LITERAL | NUMBER | json )
            int alt20=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt20=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt20=2;
                }
                break;
            case NUMBER:
                {
                alt20=3;
                }
                break;
            case JSON_START:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // TwigParser.g:152:5: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING88=(CommonToken)match(input,STRING,FOLLOW_STRING_in_array_element661); 
                    STRING88_tree = (TwigCommonTree)adaptor.create(STRING88);
                    adaptor.addChild(root_0, STRING88_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:152:14: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL89=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_array_element665); 
                    STRING_LITERAL89_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL89);
                    adaptor.addChild(root_0, STRING_LITERAL89_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:152:31: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER90=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_array_element669); 
                    NUMBER90_tree = (TwigCommonTree)adaptor.create(NUMBER90);
                    adaptor.addChild(root_0, NUMBER90_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:152:40: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_array_element673);
                    json91=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json91.getTree());

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
    // $ANTLR end "array_element"

    public static class var_or_field_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "var_or_field"
    // TwigParser.g:156:1: var_or_field : ( variable | field_access );
    public final TwigParser.var_or_field_return var_or_field() throws RecognitionException {
        TwigParser.var_or_field_return retval = new TwigParser.var_or_field_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.variable_return variable92 = null;

        TwigParser.field_access_return field_access93 = null;



        try {
            // TwigParser.g:157:3: ( variable | field_access )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==STRING) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==PRINT_CLOSE||(LA21_1>=CTRL_CLOSE && LA21_1<=ARRAY_START)||(LA21_1>=ASIG && LA21_1<=TILDE)||LA21_1==PIPE||(LA21_1>=COLON && LA21_1<=COMMA)||(LA21_1>=JSON_START && LA21_1<=DEFINED)||LA21_1==NUMBER||LA21_1==STRING||LA21_1==STRING_LITERAL) ) {
                    alt21=1;
                }
                else if ( (LA21_1==DOT) ) {
                    alt21=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // TwigParser.g:157:5: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_var_or_field689);
                    variable92=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable92.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:157:16: field_access
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_field_access_in_var_or_field693);
                    field_access93=field_access();

                    state._fsp--;

                    adaptor.addChild(root_0, field_access93.getTree());

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
    // $ANTLR end "var_or_field"

    public static class variable_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable"
    // TwigParser.g:160:1: variable : param= STRING -> ^( TWIG_VAR $param) ;
    public final TwigParser.variable_return variable() throws RecognitionException {
        TwigParser.variable_return retval = new TwigParser.variable_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;

        TwigCommonTree param_tree=null;
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // TwigParser.g:161:3: (param= STRING -> ^( TWIG_VAR $param) )
            // TwigParser.g:161:5: param= STRING
            {
            param=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable710);  
            stream_STRING.add(param);



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
            // 162:5: -> ^( TWIG_VAR $param)
            {
                // TwigParser.g:162:7: ^( TWIG_VAR $param)
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

    public static class field_access_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "field_access"
    // TwigParser.g:165:1: field_access : STRING ( DOT STRING )+ ;
    public final TwigParser.field_access_return field_access() throws RecognitionException {
        TwigParser.field_access_return retval = new TwigParser.field_access_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING94=null;
        CommonToken DOT95=null;
        CommonToken STRING96=null;

        TwigCommonTree STRING94_tree=null;
        TwigCommonTree DOT95_tree=null;
        TwigCommonTree STRING96_tree=null;

        try {
            // TwigParser.g:166:3: ( STRING ( DOT STRING )+ )
            // TwigParser.g:166:5: STRING ( DOT STRING )+
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            STRING94=(CommonToken)match(input,STRING,FOLLOW_STRING_in_field_access737); 
            STRING94_tree = (TwigCommonTree)adaptor.create(STRING94);
            adaptor.addChild(root_0, STRING94_tree);

            // TwigParser.g:166:12: ( DOT STRING )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==DOT) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // TwigParser.g:166:13: DOT STRING
            	    {
            	    DOT95=(CommonToken)match(input,DOT,FOLLOW_DOT_in_field_access740); 
            	    DOT95_tree = (TwigCommonTree)adaptor.create(DOT95);
            	    adaptor.addChild(root_0, DOT95_tree);

            	    STRING96=(CommonToken)match(input,STRING,FOLLOW_STRING_in_field_access742); 
            	    STRING96_tree = (TwigCommonTree)adaptor.create(STRING96);
            	    adaptor.addChild(root_0, STRING96_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
    // $ANTLR end "field_access"

    public static class method_chain_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method_chain"
    // TwigParser.g:170:1: method_chain : method ( DOT method )* ;
    public final TwigParser.method_chain_return method_chain() throws RecognitionException {
        TwigParser.method_chain_return retval = new TwigParser.method_chain_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken DOT98=null;
        TwigParser.method_return method97 = null;

        TwigParser.method_return method99 = null;


        TwigCommonTree DOT98_tree=null;

        try {
            // TwigParser.g:171:3: ( method ( DOT method )* )
            // TwigParser.g:171:5: method ( DOT method )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_method_in_method_chain761);
            method97=method();

            state._fsp--;

            adaptor.addChild(root_0, method97.getTree());
            // TwigParser.g:171:12: ( DOT method )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==DOT) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // TwigParser.g:171:13: DOT method
            	    {
            	    DOT98=(CommonToken)match(input,DOT,FOLLOW_DOT_in_method_chain764); 
            	    DOT98_tree = (TwigCommonTree)adaptor.create(DOT98);
            	    adaptor.addChild(root_0, DOT98_tree);

            	    pushFollow(FOLLOW_method_in_method_chain766);
            	    method99=method();

            	    state._fsp--;

            	    adaptor.addChild(root_0, method99.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end "method_chain"

    public static class method_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method"
    // TwigParser.g:174:1: method : var_or_field METHOD_START ( arguments )? METHOD_END ;
    public final TwigParser.method_return method() throws RecognitionException {
        TwigParser.method_return retval = new TwigParser.method_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken METHOD_START101=null;
        CommonToken METHOD_END103=null;
        TwigParser.var_or_field_return var_or_field100 = null;

        TwigParser.arguments_return arguments102 = null;


        TwigCommonTree METHOD_START101_tree=null;
        TwigCommonTree METHOD_END103_tree=null;

        try {
            // TwigParser.g:175:3: ( var_or_field METHOD_START ( arguments )? METHOD_END )
            // TwigParser.g:175:5: var_or_field METHOD_START ( arguments )? METHOD_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_var_or_field_in_method783);
            var_or_field100=var_or_field();

            state._fsp--;

            adaptor.addChild(root_0, var_or_field100.getTree());
            METHOD_START101=(CommonToken)match(input,METHOD_START,FOLLOW_METHOD_START_in_method785); 
            METHOD_START101_tree = (TwigCommonTree)adaptor.create(METHOD_START101);
            adaptor.addChild(root_0, METHOD_START101_tree);

            // TwigParser.g:175:31: ( arguments )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==JSON_START||LA24_0==NUMBER||LA24_0==STRING||LA24_0==STRING_LITERAL) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // TwigParser.g:175:31: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_method787);
                    arguments102=arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, arguments102.getTree());

                    }
                    break;

            }

            METHOD_END103=(CommonToken)match(input,METHOD_END,FOLLOW_METHOD_END_in_method790); 
            METHOD_END103_tree = (TwigCommonTree)adaptor.create(METHOD_END103);
            adaptor.addChild(root_0, METHOD_END103_tree);


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
    // TwigParser.g:178:1: arguments : argument ( COMMA ( argument ) )* ;
    public final TwigParser.arguments_return arguments() throws RecognitionException {
        TwigParser.arguments_return retval = new TwigParser.arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA105=null;
        TwigParser.argument_return argument104 = null;

        TwigParser.argument_return argument106 = null;


        TwigCommonTree COMMA105_tree=null;

        try {
            // TwigParser.g:179:3: ( argument ( COMMA ( argument ) )* )
            // TwigParser.g:179:5: argument ( COMMA ( argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_argument_in_arguments806);
            argument104=argument();

            state._fsp--;

            adaptor.addChild(root_0, argument104.getTree());
            // TwigParser.g:179:15: ( COMMA ( argument ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==COMMA) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // TwigParser.g:179:16: COMMA ( argument )
            	    {
            	    COMMA105=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_arguments810); 
            	    COMMA105_tree = (TwigCommonTree)adaptor.create(COMMA105);
            	    adaptor.addChild(root_0, COMMA105_tree);

            	    // TwigParser.g:179:22: ( argument )
            	    // TwigParser.g:179:23: argument
            	    {
            	    pushFollow(FOLLOW_argument_in_arguments813);
            	    argument106=argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, argument106.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // TwigParser.g:182:1: argument : ( literal_argument | json | NUMBER | var_or_field );
    public final TwigParser.argument_return argument() throws RecognitionException {
        TwigParser.argument_return retval = new TwigParser.argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken NUMBER109=null;
        TwigParser.literal_argument_return literal_argument107 = null;

        TwigParser.json_return json108 = null;

        TwigParser.var_or_field_return var_or_field110 = null;


        TwigCommonTree NUMBER109_tree=null;

        try {
            // TwigParser.g:183:1: ( literal_argument | json | NUMBER | var_or_field )
            int alt26=4;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt26=1;
                }
                break;
            case JSON_START:
                {
                alt26=2;
                }
                break;
            case NUMBER:
                {
                alt26=3;
                }
                break;
            case STRING:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // TwigParser.g:183:3: literal_argument
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_argument_in_argument827);
                    literal_argument107=literal_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, literal_argument107.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:183:22: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_argument831);
                    json108=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json108.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:183:29: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER109=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_argument835); 
                    NUMBER109_tree = (TwigCommonTree)adaptor.create(NUMBER109);
                    adaptor.addChild(root_0, NUMBER109_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:183:38: var_or_field
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_var_or_field_in_argument839);
                    var_or_field110=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field110.getTree());

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
    // TwigParser.g:186:1: literal_argument : param= STRING_LITERAL -> ^( LITERAL_ARG $param) ;
    public final TwigParser.literal_argument_return literal_argument() throws RecognitionException {
        TwigParser.literal_argument_return retval = new TwigParser.literal_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;

        TwigCommonTree param_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");

        try {
            // TwigParser.g:187:3: (param= STRING_LITERAL -> ^( LITERAL_ARG $param) )
            // TwigParser.g:187:5: param= STRING_LITERAL
            {
            param=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal_argument852);  
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
            // 188:5: -> ^( LITERAL_ARG $param)
            {
                // TwigParser.g:188:8: ^( LITERAL_ARG $param)
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
    // TwigParser.g:191:1: json : JSON_START ( json_arguments )? JSON_END ;
    public final TwigParser.json_return json() throws RecognitionException {
        TwigParser.json_return retval = new TwigParser.json_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken JSON_START111=null;
        CommonToken JSON_END113=null;
        TwigParser.json_arguments_return json_arguments112 = null;


        TwigCommonTree JSON_START111_tree=null;
        TwigCommonTree JSON_END113_tree=null;

        try {
            // TwigParser.g:192:3: ( JSON_START ( json_arguments )? JSON_END )
            // TwigParser.g:192:5: JSON_START ( json_arguments )? JSON_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            JSON_START111=(CommonToken)match(input,JSON_START,FOLLOW_JSON_START_in_json878); 
            JSON_START111_tree = (TwigCommonTree)adaptor.create(JSON_START111);
            adaptor.addChild(root_0, JSON_START111_tree);

            // TwigParser.g:192:16: ( json_arguments )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==STRING||LA27_0==STRING_LITERAL) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // TwigParser.g:192:16: json_arguments
                    {
                    pushFollow(FOLLOW_json_arguments_in_json880);
                    json_arguments112=json_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, json_arguments112.getTree());

                    }
                    break;

            }

            JSON_END113=(CommonToken)match(input,JSON_END,FOLLOW_JSON_END_in_json883); 
            JSON_END113_tree = (TwigCommonTree)adaptor.create(JSON_END113);
            adaptor.addChild(root_0, JSON_END113_tree);


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
    // TwigParser.g:195:1: json_arguments : json_argument ( COMMA ( json_argument ) )* ;
    public final TwigParser.json_arguments_return json_arguments() throws RecognitionException {
        TwigParser.json_arguments_return retval = new TwigParser.json_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA115=null;
        TwigParser.json_argument_return json_argument114 = null;

        TwigParser.json_argument_return json_argument116 = null;


        TwigCommonTree COMMA115_tree=null;

        try {
            // TwigParser.g:196:3: ( json_argument ( COMMA ( json_argument ) )* )
            // TwigParser.g:196:5: json_argument ( COMMA ( json_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_json_argument_in_json_arguments898);
            json_argument114=json_argument();

            state._fsp--;

            adaptor.addChild(root_0, json_argument114.getTree());
            // TwigParser.g:196:19: ( COMMA ( json_argument ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==COMMA) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // TwigParser.g:196:20: COMMA ( json_argument )
            	    {
            	    COMMA115=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_json_arguments901); 
            	    COMMA115_tree = (TwigCommonTree)adaptor.create(COMMA115);
            	    adaptor.addChild(root_0, COMMA115_tree);

            	    // TwigParser.g:196:26: ( json_argument )
            	    // TwigParser.g:196:27: json_argument
            	    {
            	    pushFollow(FOLLOW_json_argument_in_json_arguments904);
            	    json_argument116=json_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, json_argument116.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // TwigParser.g:199:1: json_argument : ( STRING_LITERAL | var_or_field ) ( COLON ) ( STRING_LITERAL | var_or_field ) ;
    public final TwigParser.json_argument_return json_argument() throws RecognitionException {
        TwigParser.json_argument_return retval = new TwigParser.json_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL117=null;
        CommonToken COLON119=null;
        CommonToken STRING_LITERAL120=null;
        TwigParser.var_or_field_return var_or_field118 = null;

        TwigParser.var_or_field_return var_or_field121 = null;


        TwigCommonTree STRING_LITERAL117_tree=null;
        TwigCommonTree COLON119_tree=null;
        TwigCommonTree STRING_LITERAL120_tree=null;

        try {
            // TwigParser.g:200:3: ( ( STRING_LITERAL | var_or_field ) ( COLON ) ( STRING_LITERAL | var_or_field ) )
            // TwigParser.g:200:5: ( STRING_LITERAL | var_or_field ) ( COLON ) ( STRING_LITERAL | var_or_field )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:200:5: ( STRING_LITERAL | var_or_field )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==STRING_LITERAL) ) {
                alt29=1;
            }
            else if ( (LA29_0==STRING) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // TwigParser.g:200:6: STRING_LITERAL
                    {
                    STRING_LITERAL117=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_json_argument923); 
                    STRING_LITERAL117_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL117);
                    adaptor.addChild(root_0, STRING_LITERAL117_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:200:23: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_json_argument927);
                    var_or_field118=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field118.getTree());

                    }
                    break;

            }

            // TwigParser.g:200:37: ( COLON )
            // TwigParser.g:200:38: COLON
            {
            COLON119=(CommonToken)match(input,COLON,FOLLOW_COLON_in_json_argument931); 
            COLON119_tree = (TwigCommonTree)adaptor.create(COLON119);
            adaptor.addChild(root_0, COLON119_tree);


            }

            // TwigParser.g:200:45: ( STRING_LITERAL | var_or_field )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==STRING_LITERAL) ) {
                alt30=1;
            }
            else if ( (LA30_0==STRING) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // TwigParser.g:200:46: STRING_LITERAL
                    {
                    STRING_LITERAL120=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_json_argument935); 
                    STRING_LITERAL120_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL120);
                    adaptor.addChild(root_0, STRING_LITERAL120_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:200:64: var_or_field
                    {
                    pushFollow(FOLLOW_var_or_field_in_json_argument940);
                    var_or_field121=var_or_field();

                    state._fsp--;

                    adaptor.addChild(root_0, var_or_field121.getTree());

                    }
                    break;

            }


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

    public static class keyword_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyword"
    // TwigParser.g:203:1: keyword : ( IS | DEFINED | IN | TWIG_AS | NOT | WITH | ONLY );
    public final TwigParser.keyword_return keyword() throws RecognitionException {
        TwigParser.keyword_return retval = new TwigParser.keyword_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set122=null;

        TwigCommonTree set122_tree=null;

        try {
            // TwigParser.g:204:3: ( IS | DEFINED | IN | TWIG_AS | NOT | WITH | ONLY )
            // TwigParser.g:
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set122=(CommonToken)input.LT(1);
            if ( (input.LA(1)>=IN && input.LA(1)<=DEFINED) ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set122));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


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
    // $ANTLR end "keyword"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA5_eotS =
        "\u0088\uffff";
    static final String DFA5_eofS =
        "\u0088\uffff";
    static final String DFA5_minS =
        "\1\10\1\7\3\uffff\1\7\3\uffff\1\7\10\uffff\1\46\1\11\1\uffff\1\7"+
        "\1\11\1\32\2\11\1\7\1\31\1\26\1\25\1\11\2\46\1\uffff\1\11\1\32\2"+
        "\11\2\46\1\11\1\10\1\26\1\25\1\11\1\46\1\27\2\25\1\11\3\46\1\11"+
        "\2\46\1\11\1\32\2\11\1\7\1\10\1\27\2\25\1\26\2\25\1\31\1\26\1\25"+
        "\1\11\5\46\1\11\1\32\2\11\2\46\1\11\1\26\2\25\1\27\2\25\1\26\1\25"+
        "\1\11\1\46\1\27\2\25\5\46\1\11\2\46\1\27\3\25\1\27\2\25\1\26\2\25"+
        "\5\46\1\25\1\26\2\25\1\27\2\25\3\46\1\27\3\25\1\46\1\25";
    static final String DFA5_maxS =
        "\2\50\3\uffff\1\50\3\uffff\1\50\10\uffff\1\46\1\50\1\uffff\1\50"+
        "\1\34\1\50\1\27\1\34\2\50\2\26\1\27\2\46\1\uffff\1\27\1\50\2\27"+
        "\1\50\1\46\1\34\1\25\2\26\1\27\1\46\2\32\1\26\1\50\1\46\1\50\1\46"+
        "\1\27\1\50\1\46\1\27\1\50\2\27\1\50\1\25\2\32\3\26\1\32\1\50\2\26"+
        "\1\27\1\46\1\50\1\46\1\50\1\46\1\27\1\50\2\27\1\50\1\46\1\27\2\26"+
        "\3\32\3\26\1\27\1\46\2\32\1\26\1\50\2\46\1\50\1\46\1\27\1\50\1\46"+
        "\2\32\1\26\3\32\3\26\1\32\1\46\1\50\1\46\1\50\1\46\1\32\2\26\3\32"+
        "\1\26\1\50\2\46\2\32\1\26\1\32\1\46\1\32";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\uffff\1\6\1\7\1\10\1\uffff\1\15\1\16\1\17"+
        "\1\20\1\11\1\1\1\12\1\5\2\uffff\1\13\14\uffff\1\14\146\uffff";
    static final String DFA5_specialS =
        "\u0088\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\15\1\uffff\1\13\1\uffff\1\2\4\uffff\1\4\1\uffff\1\3\2\uffff"+
            "\1\10\1\6\1\uffff\1\14\1\uffff\1\7\7\12\1\uffff\1\5\1\uffff"+
            "\1\11\1\uffff\1\1",
            "\2\17\1\uffff\1\17\1\uffff\1\17\4\20\1\17\1\uffff\1\17\1\16"+
            "\1\uffff\2\17\1\uffff\1\17\1\uffff\10\17\1\uffff\1\17\1\uffff"+
            "\1\17\1\uffff\1\17",
            "",
            "",
            "",
            "\2\21\1\uffff\1\21\1\uffff\1\21\4\20\1\21\1\uffff\1\21\1\16"+
            "\1\uffff\2\21\1\uffff\1\21\1\uffff\10\21\1\uffff\1\21\1\uffff"+
            "\1\21\1\uffff\1\21",
            "",
            "",
            "",
            "\1\24\1\23\1\uffff\1\24\1\uffff\1\24\4\20\1\24\1\uffff\1\24"+
            "\1\16\1\22\2\24\1\uffff\1\24\1\uffff\10\24\1\uffff\1\24\1\uffff"+
            "\1\24\1\uffff\1\24",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\25",
            "\1\32\17\uffff\1\27\12\uffff\1\30\1\uffff\1\31\1\uffff\1\26",
            "",
            "\1\24\1\23\1\uffff\1\24\1\uffff\1\24\4\20\1\24\1\uffff\1\24"+
            "\1\uffff\1\22\2\24\1\uffff\1\24\1\uffff\10\24\1\uffff\1\24\1"+
            "\uffff\1\24\1\uffff\1\24",
            "\1\32\15\uffff\1\33\4\uffff\1\24",
            "\1\36\13\uffff\1\35\1\uffff\1\34",
            "\1\32\15\uffff\1\33",
            "\1\32\13\uffff\1\37\1\uffff\1\33\4\uffff\1\24",
            "\2\41\1\uffff\1\41\1\uffff\1\41\4\20\1\41\1\uffff\1\41\1\uffff"+
            "\1\40\2\41\1\uffff\1\41\1\uffff\10\41\1\uffff\1\41\1\uffff\1"+
            "\41\1\uffff\1\41",
            "\1\43\12\uffff\1\44\1\uffff\1\45\1\uffff\1\42",
            "\1\46",
            "\1\47\1\46",
            "\1\32\15\uffff\1\33",
            "\1\50",
            "\1\51",
            "",
            "\1\32\15\uffff\1\33",
            "\1\54\13\uffff\1\53\1\uffff\1\52",
            "\1\32\15\uffff\1\33",
            "\1\32\13\uffff\1\55\1\uffff\1\33",
            "\1\57\1\uffff\1\56",
            "\1\60",
            "\1\32\13\uffff\1\37\1\uffff\1\33\4\uffff\1\24",
            "\1\61\14\uffff\1\62",
            "\1\63",
            "\1\64\1\63",
            "\1\32\15\uffff\1\33",
            "\1\65",
            "\1\66\2\uffff\1\36",
            "\1\67\1\uffff\1\66\2\uffff\1\36",
            "\1\47\1\46",
            "\1\74\17\uffff\1\71\12\uffff\1\72\1\uffff\1\73\1\uffff\1\70",
            "\1\75",
            "\1\77\1\uffff\1\76",
            "\1\100",
            "\1\32\13\uffff\1\55\1\uffff\1\33",
            "\1\102\1\uffff\1\101",
            "\1\103",
            "\1\74\15\uffff\1\104",
            "\1\107\13\uffff\1\106\1\uffff\1\105",
            "\1\74\15\uffff\1\104",
            "\1\74\13\uffff\1\110\1\uffff\1\104",
            "\2\41\1\uffff\1\41\1\uffff\1\41\4\20\1\41\1\uffff\1\41\1\uffff"+
            "\1\40\2\41\1\uffff\1\41\1\uffff\10\41\1\uffff\1\41\1\uffff\1"+
            "\41\1\uffff\1\41",
            "\1\61\14\uffff\1\62",
            "\1\111\2\uffff\1\54",
            "\1\112\1\uffff\1\111\2\uffff\1\54",
            "\1\64\1\63",
            "\1\113",
            "\1\114\1\113",
            "\1\67\1\uffff\1\66\2\uffff\1\36",
            "\1\116\12\uffff\1\117\1\uffff\1\120\1\uffff\1\115",
            "\1\121",
            "\1\122\1\121",
            "\1\74\15\uffff\1\104",
            "\1\123",
            "\1\125\1\uffff\1\124",
            "\1\126",
            "\1\130\1\uffff\1\127",
            "\1\131",
            "\1\74\15\uffff\1\104",
            "\1\134\13\uffff\1\133\1\uffff\1\132",
            "\1\74\15\uffff\1\104",
            "\1\74\13\uffff\1\135\1\uffff\1\104",
            "\1\137\1\uffff\1\136",
            "\1\140",
            "\1\74\13\uffff\1\110\1\uffff\1\104",
            "\1\141",
            "\1\142\1\141",
            "\1\112\1\uffff\1\111\2\uffff\1\54",
            "\1\66\2\uffff\1\36",
            "\1\143\1\uffff\1\66\2\uffff\1\36",
            "\1\114\1\113",
            "\1\144",
            "\1\145\1\144",
            "\1\74\15\uffff\1\104",
            "\1\146",
            "\1\147\2\uffff\1\107",
            "\1\150\1\uffff\1\147\2\uffff\1\107",
            "\1\122\1\121",
            "\1\152\1\uffff\1\151",
            "\1\153",
            "\1\154",
            "\1\156\1\uffff\1\155",
            "\1\157",
            "\1\74\13\uffff\1\135\1\uffff\1\104",
            "\1\161\1\uffff\1\160",
            "\1\162",
            "\1\111\2\uffff\1\54",
            "\1\163\1\uffff\1\111\2\uffff\1\54",
            "\1\142\1\141",
            "\1\143\1\uffff\1\66\2\uffff\1\36",
            "\1\164\2\uffff\1\134",
            "\1\165\1\uffff\1\164\2\uffff\1\134",
            "\1\145\1\144",
            "\1\166",
            "\1\167\1\166",
            "\1\150\1\uffff\1\147\2\uffff\1\107",
            "\1\170",
            "\1\172\1\uffff\1\171",
            "\1\173",
            "\1\175\1\uffff\1\174",
            "\1\176",
            "\1\163\1\uffff\1\111\2\uffff\1\54",
            "\1\177",
            "\1\u0080\1\177",
            "\1\165\1\uffff\1\164\2\uffff\1\134",
            "\1\147\2\uffff\1\107",
            "\1\u0081\1\uffff\1\147\2\uffff\1\107",
            "\1\167\1\166",
            "\1\u0083\1\uffff\1\u0082",
            "\1\u0084",
            "\1\u0085",
            "\1\164\2\uffff\1\134",
            "\1\u0086\1\uffff\1\164\2\uffff\1\134",
            "\1\u0080\1\177",
            "\1\u0081\1\uffff\1\147\2\uffff\1\107",
            "\1\u0087",
            "\1\u0086\1\uffff\1\164\2\uffff\1\134"
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "94:1: twig_control_body : ( STRING_LITERAL | ASIG | PIPE | TILDE | NUMBER | COMMA | QM | COLON | range | eq_check | var_or_field | method_chain | keyword | array | json | in_check );";
        }
    }
    static final String DFA8_eotS =
        "\175\uffff";
    static final String DFA8_eofS =
        "\175\uffff";
    static final String DFA8_minS =
        "\1\44\2\15\1\10\4\uffff\1\46\1\11\1\10\1\11\1\32\2\11\1\15\1\31"+
        "\1\26\1\25\1\11\2\46\1\uffff\1\11\1\32\2\11\2\46\1\11\1\10\1\26"+
        "\1\25\1\11\1\46\1\27\2\25\1\11\3\46\1\11\2\46\1\11\1\32\2\11\1\15"+
        "\1\10\1\27\2\25\1\26\2\25\1\31\1\26\1\25\1\11\5\46\1\11\1\32\2\11"+
        "\2\46\1\11\1\26\2\25\1\27\2\25\1\26\1\25\1\11\1\46\1\27\2\25\5\46"+
        "\1\11\2\46\1\27\3\25\1\27\2\25\1\26\2\25\5\46\1\25\1\26\2\25\1\27"+
        "\2\25\3\46\1\27\3\25\1\46\1\25";
    static final String DFA8_maxS =
        "\1\50\3\33\4\uffff\1\46\1\50\1\33\1\27\1\50\2\27\1\33\1\50\2\26"+
        "\1\27\2\46\1\uffff\1\27\1\50\2\27\1\50\1\46\1\27\1\25\2\26\1\27"+
        "\1\46\2\32\1\26\1\50\1\46\1\50\1\46\1\27\1\50\1\46\1\27\1\50\2\27"+
        "\1\33\1\25\2\32\3\26\1\32\1\50\2\26\1\27\1\46\1\50\1\46\1\50\1\46"+
        "\1\27\1\50\2\27\1\50\1\46\1\27\2\26\3\32\3\26\1\27\1\46\2\32\1\26"+
        "\1\50\2\46\1\50\1\46\1\27\1\50\1\46\2\32\1\26\3\32\3\26\1\32\1\46"+
        "\1\50\1\46\1\50\1\46\1\32\2\26\3\32\1\26\1\50\2\46\2\32\1\26\1\32"+
        "\1\46\1\32";
    static final String DFA8_acceptS =
        "\4\uffff\1\1\1\5\1\2\1\3\16\uffff\1\4\146\uffff";
    static final String DFA8_specialS =
        "\175\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "\4\5\12\uffff\1\4",
            "\4\5\12\uffff\1\6",
            "\1\11\4\uffff\4\5\4\uffff\1\10\5\uffff\1\7",
            "",
            "",
            "",
            "",
            "\1\12",
            "\1\17\17\uffff\1\14\12\uffff\1\15\1\uffff\1\16\1\uffff\1\13",
            "\1\11\4\uffff\4\5\4\uffff\1\10\5\uffff\1\7",
            "\1\17\15\uffff\1\20",
            "\1\23\13\uffff\1\22\1\uffff\1\21",
            "\1\17\15\uffff\1\20",
            "\1\17\13\uffff\1\24\1\uffff\1\20",
            "\4\5\4\uffff\1\25\5\uffff\1\26",
            "\1\30\12\uffff\1\31\1\uffff\1\32\1\uffff\1\27",
            "\1\33",
            "\1\34\1\33",
            "\1\17\15\uffff\1\20",
            "\1\35",
            "\1\36",
            "",
            "\1\17\15\uffff\1\20",
            "\1\41\13\uffff\1\40\1\uffff\1\37",
            "\1\17\15\uffff\1\20",
            "\1\17\13\uffff\1\42\1\uffff\1\20",
            "\1\44\1\uffff\1\43",
            "\1\45",
            "\1\17\13\uffff\1\24\1\uffff\1\20",
            "\1\46\14\uffff\1\47",
            "\1\50",
            "\1\51\1\50",
            "\1\17\15\uffff\1\20",
            "\1\52",
            "\1\53\2\uffff\1\23",
            "\1\54\1\uffff\1\53\2\uffff\1\23",
            "\1\34\1\33",
            "\1\61\17\uffff\1\56\12\uffff\1\57\1\uffff\1\60\1\uffff\1\55",
            "\1\62",
            "\1\64\1\uffff\1\63",
            "\1\65",
            "\1\17\13\uffff\1\42\1\uffff\1\20",
            "\1\67\1\uffff\1\66",
            "\1\70",
            "\1\61\15\uffff\1\71",
            "\1\74\13\uffff\1\73\1\uffff\1\72",
            "\1\61\15\uffff\1\71",
            "\1\61\13\uffff\1\75\1\uffff\1\71",
            "\4\5\4\uffff\1\25\5\uffff\1\26",
            "\1\46\14\uffff\1\47",
            "\1\76\2\uffff\1\41",
            "\1\77\1\uffff\1\76\2\uffff\1\41",
            "\1\51\1\50",
            "\1\100",
            "\1\101\1\100",
            "\1\54\1\uffff\1\53\2\uffff\1\23",
            "\1\103\12\uffff\1\104\1\uffff\1\105\1\uffff\1\102",
            "\1\106",
            "\1\107\1\106",
            "\1\61\15\uffff\1\71",
            "\1\110",
            "\1\112\1\uffff\1\111",
            "\1\113",
            "\1\115\1\uffff\1\114",
            "\1\116",
            "\1\61\15\uffff\1\71",
            "\1\121\13\uffff\1\120\1\uffff\1\117",
            "\1\61\15\uffff\1\71",
            "\1\61\13\uffff\1\122\1\uffff\1\71",
            "\1\124\1\uffff\1\123",
            "\1\125",
            "\1\61\13\uffff\1\75\1\uffff\1\71",
            "\1\126",
            "\1\127\1\126",
            "\1\77\1\uffff\1\76\2\uffff\1\41",
            "\1\53\2\uffff\1\23",
            "\1\130\1\uffff\1\53\2\uffff\1\23",
            "\1\101\1\100",
            "\1\131",
            "\1\132\1\131",
            "\1\61\15\uffff\1\71",
            "\1\133",
            "\1\134\2\uffff\1\74",
            "\1\135\1\uffff\1\134\2\uffff\1\74",
            "\1\107\1\106",
            "\1\137\1\uffff\1\136",
            "\1\140",
            "\1\141",
            "\1\143\1\uffff\1\142",
            "\1\144",
            "\1\61\13\uffff\1\122\1\uffff\1\71",
            "\1\146\1\uffff\1\145",
            "\1\147",
            "\1\76\2\uffff\1\41",
            "\1\150\1\uffff\1\76\2\uffff\1\41",
            "\1\127\1\126",
            "\1\130\1\uffff\1\53\2\uffff\1\23",
            "\1\151\2\uffff\1\121",
            "\1\152\1\uffff\1\151\2\uffff\1\121",
            "\1\132\1\131",
            "\1\153",
            "\1\154\1\153",
            "\1\135\1\uffff\1\134\2\uffff\1\74",
            "\1\155",
            "\1\157\1\uffff\1\156",
            "\1\160",
            "\1\162\1\uffff\1\161",
            "\1\163",
            "\1\150\1\uffff\1\76\2\uffff\1\41",
            "\1\164",
            "\1\165\1\164",
            "\1\152\1\uffff\1\151\2\uffff\1\121",
            "\1\134\2\uffff\1\74",
            "\1\166\1\uffff\1\134\2\uffff\1\74",
            "\1\154\1\153",
            "\1\170\1\uffff\1\167",
            "\1\171",
            "\1\172",
            "\1\151\2\uffff\1\121",
            "\1\173\1\uffff\1\151\2\uffff\1\121",
            "\1\165\1\164",
            "\1\166\1\uffff\1\134\2\uffff\1\74",
            "\1\174",
            "\1\173\1\uffff\1\151\2\uffff\1\121"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "108:5: ( STRING_LITERAL | NUMBER | var_or_field | method_chain | eq_check )";
        }
    }
    static final String DFA9_eotS =
        "\10\uffff";
    static final String DFA9_eofS =
        "\10\uffff";
    static final String DFA9_minS =
        "\1\44\2\uffff\1\10\1\uffff\1\46\1\uffff\1\10";
    static final String DFA9_maxS =
        "\1\50\2\uffff\1\26\1\uffff\1\46\1\uffff\1\26";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\3\1\uffff\1\4\1\uffff";
    static final String DFA9_specialS =
        "\10\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\6\14\uffff\1\5\1\4",
            "",
            "\1\7",
            "",
            "\1\6\14\uffff\1\5\1\4"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "108:75: ( STRING_LITERAL | NUMBER | var_or_field | method_chain )";
        }
    }
    static final String DFA10_eotS =
        "\10\uffff";
    static final String DFA10_eofS =
        "\10\uffff";
    static final String DFA10_minS =
        "\1\44\2\uffff\1\5\1\uffff\1\46\1\uffff\1\5";
    static final String DFA10_maxS =
        "\1\50\2\uffff\1\25\1\uffff\1\46\1\uffff\1\25";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\3\1\uffff\1\4\1\uffff";
    static final String DFA10_specialS =
        "\10\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\4\2\uffff\1\6\12\uffff\1\4\1\uffff\1\5",
            "",
            "\1\7",
            "",
            "\1\4\2\uffff\1\6\12\uffff\1\4\1\uffff\1\5"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "108:137: ( STRING_LITERAL | NUMBER | var_or_field | method_chain )";
        }
    }
    static final String DFA11_eotS =
        "\10\uffff";
    static final String DFA11_eofS =
        "\10\uffff";
    static final String DFA11_minS =
        "\1\44\1\10\3\uffff\1\46\1\uffff\1\10";
    static final String DFA11_maxS =
        "\1\50\1\25\3\uffff\1\46\1\uffff\1\25";
    static final String DFA11_acceptS =
        "\2\uffff\1\3\1\4\1\1\1\uffff\1\2\1\uffff";
    static final String DFA11_specialS =
        "\10\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\uffff\1\1\1\uffff\1\3",
            "\1\6\4\uffff\4\4\4\uffff\1\5",
            "",
            "",
            "",
            "\1\7",
            "",
            "\1\6\4\uffff\4\4\4\uffff\1\5"
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "113:5: ( var_or_field | method_chain | NUMBER | STRING_LITERAL )";
        }
    }
    static final String DFA12_eotS =
        "\15\uffff";
    static final String DFA12_eofS =
        "\15\uffff";
    static final String DFA12_minS =
        "\1\44\1\7\3\uffff\1\11\1\46\2\11\1\uffff\1\7\1\46\1\11";
    static final String DFA12_maxS =
        "\2\50\3\uffff\1\50\1\46\2\34\1\uffff\1\50\1\46\1\34";
    static final String DFA12_acceptS =
        "\2\uffff\1\3\1\4\1\1\4\uffff\1\2\3\uffff";
    static final String DFA12_specialS =
        "\15\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\2\1\uffff\1\1\1\uffff\1\3",
            "\1\4\1\5\1\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1"+
            "\uffff\1\6\2\4\1\uffff\1\4\1\uffff\10\4\1\uffff\1\4\1\uffff"+
            "\1\4\1\uffff\1\4",
            "",
            "",
            "",
            "\1\11\17\uffff\1\11\12\uffff\1\11\1\uffff\1\10\1\uffff\1\7",
            "\1\12",
            "\1\11\15\uffff\1\11\4\uffff\1\4",
            "\1\11\13\uffff\1\13\1\uffff\1\11\4\uffff\1\4",
            "",
            "\1\4\1\5\1\uffff\1\4\1\uffff\1\4\4\uffff\1\4\1\uffff\1\4\1"+
            "\uffff\1\6\2\4\1\uffff\1\4\1\uffff\10\4\1\uffff\1\4\1\uffff"+
            "\1\4\1\uffff\1\4",
            "\1\14",
            "\1\11\13\uffff\1\13\1\uffff\1\11\4\uffff\1\4"
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "113:99: ( var_or_field | method_chain | NUMBER | STRING_LITERAL )";
        }
    }
    static final String DFA15_eotS =
        "\176\uffff";
    static final String DFA15_eofS =
        "\176\uffff";
    static final String DFA15_minS =
        "\1\12\1\5\1\uffff\1\5\3\uffff\1\46\1\11\2\uffff\1\5\1\11\1\32\2"+
        "\11\1\5\1\31\1\26\1\25\1\11\2\46\1\uffff\1\11\1\32\2\11\2\46\1\11"+
        "\1\10\1\26\1\25\1\11\1\46\1\27\2\25\1\11\3\46\1\11\2\46\1\11\1\32"+
        "\2\11\1\5\1\10\1\27\2\25\1\26\2\25\1\31\1\26\1\25\1\11\5\46\1\11"+
        "\1\32\2\11\2\46\1\11\1\26\2\25\1\27\2\25\1\26\1\25\1\11\1\46\1\27"+
        "\2\25\5\46\1\11\2\46\1\27\3\25\1\27\2\25\1\26\2\25\5\46\1\25\1\26"+
        "\2\25\1\27\2\25\3\46\1\27\3\25\1\46\1\25";
    static final String DFA15_maxS =
        "\1\50\1\33\1\uffff\1\33\3\uffff\1\46\1\50\2\uffff\1\33\1\27\1\50"+
        "\2\27\1\33\1\50\2\26\1\27\2\46\1\uffff\1\27\1\50\2\27\1\50\1\46"+
        "\1\27\1\25\2\26\1\27\1\46\2\32\1\26\1\50\1\46\1\50\1\46\1\27\1\50"+
        "\1\46\1\27\1\50\2\27\1\33\1\25\2\32\3\26\1\32\1\50\2\26\1\27\1\46"+
        "\1\50\1\46\1\50\1\46\1\27\1\50\2\27\1\50\1\46\1\27\2\26\3\32\3\26"+
        "\1\27\1\46\2\32\1\26\1\50\2\46\1\50\1\46\1\27\1\50\1\46\2\32\1\26"+
        "\3\32\3\26\1\32\1\46\1\50\1\46\1\50\1\46\1\32\2\26\3\32\1\26\1\50"+
        "\2\46\2\32\1\26\1\32\1\46\1\32";
    static final String DFA15_acceptS =
        "\2\uffff\1\3\1\uffff\1\5\1\6\1\1\2\uffff\1\7\1\4\14\uffff\1\2\146"+
        "\uffff";
    static final String DFA15_specialS =
        "\176\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\2\23\uffff\1\5\5\uffff\1\4\1\uffff\1\1\1\uffff\1\3",
            "\1\6\2\uffff\1\10\4\uffff\4\4\1\11\1\uffff\1\6\1\uffff\1\7"+
            "\5\uffff\1\4",
            "",
            "\1\12\7\uffff\4\4\1\11\1\uffff\1\12\7\uffff\1\4",
            "",
            "",
            "",
            "\1\13",
            "\1\20\17\uffff\1\15\12\uffff\1\16\1\uffff\1\17\1\uffff\1\14",
            "",
            "",
            "\1\6\2\uffff\1\10\4\uffff\4\4\1\11\1\uffff\1\6\1\uffff\1\7"+
            "\5\uffff\1\4",
            "\1\20\15\uffff\1\21",
            "\1\24\13\uffff\1\23\1\uffff\1\22",
            "\1\20\15\uffff\1\21",
            "\1\20\13\uffff\1\25\1\uffff\1\21",
            "\1\27\7\uffff\4\4\1\11\1\uffff\1\27\1\uffff\1\26\5\uffff\1"+
            "\4",
            "\1\31\12\uffff\1\32\1\uffff\1\33\1\uffff\1\30",
            "\1\34",
            "\1\35\1\34",
            "\1\20\15\uffff\1\21",
            "\1\36",
            "\1\37",
            "",
            "\1\20\15\uffff\1\21",
            "\1\42\13\uffff\1\41\1\uffff\1\40",
            "\1\20\15\uffff\1\21",
            "\1\20\13\uffff\1\43\1\uffff\1\21",
            "\1\45\1\uffff\1\44",
            "\1\46",
            "\1\20\13\uffff\1\25\1\uffff\1\21",
            "\1\47\14\uffff\1\50",
            "\1\51",
            "\1\52\1\51",
            "\1\20\15\uffff\1\21",
            "\1\53",
            "\1\54\2\uffff\1\24",
            "\1\55\1\uffff\1\54\2\uffff\1\24",
            "\1\35\1\34",
            "\1\62\17\uffff\1\57\12\uffff\1\60\1\uffff\1\61\1\uffff\1\56",
            "\1\63",
            "\1\65\1\uffff\1\64",
            "\1\66",
            "\1\20\13\uffff\1\43\1\uffff\1\21",
            "\1\70\1\uffff\1\67",
            "\1\71",
            "\1\62\15\uffff\1\72",
            "\1\75\13\uffff\1\74\1\uffff\1\73",
            "\1\62\15\uffff\1\72",
            "\1\62\13\uffff\1\76\1\uffff\1\72",
            "\1\27\7\uffff\4\4\1\11\1\uffff\1\27\1\uffff\1\26\5\uffff\1"+
            "\4",
            "\1\47\14\uffff\1\50",
            "\1\77\2\uffff\1\42",
            "\1\100\1\uffff\1\77\2\uffff\1\42",
            "\1\52\1\51",
            "\1\101",
            "\1\102\1\101",
            "\1\55\1\uffff\1\54\2\uffff\1\24",
            "\1\104\12\uffff\1\105\1\uffff\1\106\1\uffff\1\103",
            "\1\107",
            "\1\110\1\107",
            "\1\62\15\uffff\1\72",
            "\1\111",
            "\1\113\1\uffff\1\112",
            "\1\114",
            "\1\116\1\uffff\1\115",
            "\1\117",
            "\1\62\15\uffff\1\72",
            "\1\122\13\uffff\1\121\1\uffff\1\120",
            "\1\62\15\uffff\1\72",
            "\1\62\13\uffff\1\123\1\uffff\1\72",
            "\1\125\1\uffff\1\124",
            "\1\126",
            "\1\62\13\uffff\1\76\1\uffff\1\72",
            "\1\127",
            "\1\130\1\127",
            "\1\100\1\uffff\1\77\2\uffff\1\42",
            "\1\54\2\uffff\1\24",
            "\1\131\1\uffff\1\54\2\uffff\1\24",
            "\1\102\1\101",
            "\1\132",
            "\1\133\1\132",
            "\1\62\15\uffff\1\72",
            "\1\134",
            "\1\135\2\uffff\1\75",
            "\1\136\1\uffff\1\135\2\uffff\1\75",
            "\1\110\1\107",
            "\1\140\1\uffff\1\137",
            "\1\141",
            "\1\142",
            "\1\144\1\uffff\1\143",
            "\1\145",
            "\1\62\13\uffff\1\123\1\uffff\1\72",
            "\1\147\1\uffff\1\146",
            "\1\150",
            "\1\77\2\uffff\1\42",
            "\1\151\1\uffff\1\77\2\uffff\1\42",
            "\1\130\1\127",
            "\1\131\1\uffff\1\54\2\uffff\1\24",
            "\1\152\2\uffff\1\122",
            "\1\153\1\uffff\1\152\2\uffff\1\122",
            "\1\133\1\132",
            "\1\154",
            "\1\155\1\154",
            "\1\136\1\uffff\1\135\2\uffff\1\75",
            "\1\156",
            "\1\160\1\uffff\1\157",
            "\1\161",
            "\1\163\1\uffff\1\162",
            "\1\164",
            "\1\151\1\uffff\1\77\2\uffff\1\42",
            "\1\165",
            "\1\166\1\165",
            "\1\153\1\uffff\1\152\2\uffff\1\122",
            "\1\135\2\uffff\1\75",
            "\1\167\1\uffff\1\135\2\uffff\1\75",
            "\1\155\1\154",
            "\1\171\1\uffff\1\170",
            "\1\172",
            "\1\173",
            "\1\152\2\uffff\1\122",
            "\1\174\1\uffff\1\152\2\uffff\1\122",
            "\1\166\1\165",
            "\1\167\1\uffff\1\135\2\uffff\1\75",
            "\1\175",
            "\1\174\1\uffff\1\152\2\uffff\1\122"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "127:1: p_input : ( var_or_field | method_chain | array | STRING_LITERAL | twig_ternary | twig_not | concat );";
        }
    }
    static final String DFA17_eotS =
        "\7\uffff";
    static final String DFA17_eofS =
        "\7\uffff";
    static final String DFA17_minS =
        "\1\46\1\uffff\1\5\1\uffff\1\46\1\uffff\1\5";
    static final String DFA17_maxS =
        "\1\50\1\uffff\1\25\1\uffff\1\46\1\uffff\1\25";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\uffff\1\3\1\uffff";
    static final String DFA17_specialS =
        "\7\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\2\1\uffff\1\1",
            "",
            "\1\3\2\uffff\1\5\10\uffff\1\3\1\uffff\1\3\1\uffff\1\4",
            "",
            "\1\6",
            "",
            "\1\3\2\uffff\1\5\10\uffff\1\3\1\uffff\1\3\1\uffff\1\4"
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "136:5: ( STRING_LITERAL | var_or_field | method_chain )";
        }
    }
    static final String DFA18_eotS =
        "\171\uffff";
    static final String DFA18_eofS =
        "\171\uffff";
    static final String DFA18_minS =
        "\1\44\1\uffff\1\5\1\46\1\11\1\uffff\1\5\1\11\1\32\2\11\1\5\1\31"+
        "\1\26\1\25\1\11\2\46\1\uffff\1\11\1\32\2\11\2\46\1\11\1\10\1\26"+
        "\1\25\1\11\1\46\1\27\2\25\1\11\3\46\1\11\2\46\1\11\1\32\2\11\1\5"+
        "\1\10\1\27\2\25\1\26\2\25\1\31\1\26\1\25\1\11\5\46\1\11\1\32\2\11"+
        "\2\46\1\11\1\26\2\25\1\27\2\25\1\26\1\25\1\11\1\46\1\27\2\25\5\46"+
        "\1\11\2\46\1\27\3\25\1\27\2\25\1\26\2\25\5\46\1\25\1\26\2\25\1\27"+
        "\2\25\3\46\1\27\3\25\1\46\1\25";
    static final String DFA18_maxS =
        "\1\50\1\uffff\1\33\1\46\1\50\1\uffff\1\33\1\27\1\50\2\27\1\33\1"+
        "\50\2\26\1\27\2\46\1\uffff\1\27\1\50\2\27\1\50\1\46\1\27\1\25\2"+
        "\26\1\27\1\46\2\32\1\26\1\50\1\46\1\50\1\46\1\27\1\50\1\46\1\27"+
        "\1\50\2\27\1\33\1\25\2\32\3\26\1\32\1\50\2\26\1\27\1\46\1\50\1\46"+
        "\1\50\1\46\1\27\1\50\2\27\1\50\1\46\1\27\2\26\3\32\3\26\1\27\1\46"+
        "\2\32\1\26\1\50\2\46\1\50\1\46\1\27\1\50\1\46\2\32\1\26\3\32\3\26"+
        "\1\32\1\46\1\50\1\46\1\50\1\46\1\32\2\26\3\32\1\26\1\50\2\46\2\32"+
        "\1\26\1\32\1\46\1\32";
    static final String DFA18_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\14\uffff\1\3\146\uffff";
    static final String DFA18_specialS =
        "\171\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1\1\uffff\1\2\1\uffff\1\1",
            "",
            "\1\5\2\uffff\1\4\4\uffff\4\1\2\uffff\1\5\1\uffff\1\3\5\uffff"+
            "\1\1",
            "\1\6",
            "\1\13\17\uffff\1\10\12\uffff\1\11\1\uffff\1\12\1\uffff\1\7",
            "",
            "\1\5\2\uffff\1\4\4\uffff\4\1\2\uffff\1\5\1\uffff\1\3\5\uffff"+
            "\1\1",
            "\1\13\15\uffff\1\14",
            "\1\17\13\uffff\1\16\1\uffff\1\15",
            "\1\13\15\uffff\1\14",
            "\1\13\13\uffff\1\20\1\uffff\1\14",
            "\1\22\7\uffff\4\1\2\uffff\1\22\1\uffff\1\21\5\uffff\1\1",
            "\1\24\12\uffff\1\25\1\uffff\1\26\1\uffff\1\23",
            "\1\27",
            "\1\30\1\27",
            "\1\13\15\uffff\1\14",
            "\1\31",
            "\1\32",
            "",
            "\1\13\15\uffff\1\14",
            "\1\35\13\uffff\1\34\1\uffff\1\33",
            "\1\13\15\uffff\1\14",
            "\1\13\13\uffff\1\36\1\uffff\1\14",
            "\1\40\1\uffff\1\37",
            "\1\41",
            "\1\13\13\uffff\1\20\1\uffff\1\14",
            "\1\42\14\uffff\1\43",
            "\1\44",
            "\1\45\1\44",
            "\1\13\15\uffff\1\14",
            "\1\46",
            "\1\47\2\uffff\1\17",
            "\1\50\1\uffff\1\47\2\uffff\1\17",
            "\1\30\1\27",
            "\1\55\17\uffff\1\52\12\uffff\1\53\1\uffff\1\54\1\uffff\1\51",
            "\1\56",
            "\1\60\1\uffff\1\57",
            "\1\61",
            "\1\13\13\uffff\1\36\1\uffff\1\14",
            "\1\63\1\uffff\1\62",
            "\1\64",
            "\1\55\15\uffff\1\65",
            "\1\70\13\uffff\1\67\1\uffff\1\66",
            "\1\55\15\uffff\1\65",
            "\1\55\13\uffff\1\71\1\uffff\1\65",
            "\1\22\7\uffff\4\1\2\uffff\1\22\1\uffff\1\21\5\uffff\1\1",
            "\1\42\14\uffff\1\43",
            "\1\72\2\uffff\1\35",
            "\1\73\1\uffff\1\72\2\uffff\1\35",
            "\1\45\1\44",
            "\1\74",
            "\1\75\1\74",
            "\1\50\1\uffff\1\47\2\uffff\1\17",
            "\1\77\12\uffff\1\100\1\uffff\1\101\1\uffff\1\76",
            "\1\102",
            "\1\103\1\102",
            "\1\55\15\uffff\1\65",
            "\1\104",
            "\1\106\1\uffff\1\105",
            "\1\107",
            "\1\111\1\uffff\1\110",
            "\1\112",
            "\1\55\15\uffff\1\65",
            "\1\115\13\uffff\1\114\1\uffff\1\113",
            "\1\55\15\uffff\1\65",
            "\1\55\13\uffff\1\116\1\uffff\1\65",
            "\1\120\1\uffff\1\117",
            "\1\121",
            "\1\55\13\uffff\1\71\1\uffff\1\65",
            "\1\122",
            "\1\123\1\122",
            "\1\73\1\uffff\1\72\2\uffff\1\35",
            "\1\47\2\uffff\1\17",
            "\1\124\1\uffff\1\47\2\uffff\1\17",
            "\1\75\1\74",
            "\1\125",
            "\1\126\1\125",
            "\1\55\15\uffff\1\65",
            "\1\127",
            "\1\130\2\uffff\1\70",
            "\1\131\1\uffff\1\130\2\uffff\1\70",
            "\1\103\1\102",
            "\1\133\1\uffff\1\132",
            "\1\134",
            "\1\135",
            "\1\137\1\uffff\1\136",
            "\1\140",
            "\1\55\13\uffff\1\116\1\uffff\1\65",
            "\1\142\1\uffff\1\141",
            "\1\143",
            "\1\72\2\uffff\1\35",
            "\1\144\1\uffff\1\72\2\uffff\1\35",
            "\1\123\1\122",
            "\1\124\1\uffff\1\47\2\uffff\1\17",
            "\1\145\2\uffff\1\115",
            "\1\146\1\uffff\1\145\2\uffff\1\115",
            "\1\126\1\125",
            "\1\147",
            "\1\150\1\147",
            "\1\131\1\uffff\1\130\2\uffff\1\70",
            "\1\151",
            "\1\153\1\uffff\1\152",
            "\1\154",
            "\1\156\1\uffff\1\155",
            "\1\157",
            "\1\144\1\uffff\1\72\2\uffff\1\35",
            "\1\160",
            "\1\161\1\160",
            "\1\146\1\uffff\1\145\2\uffff\1\115",
            "\1\130\2\uffff\1\70",
            "\1\162\1\uffff\1\130\2\uffff\1\70",
            "\1\150\1\147",
            "\1\164\1\uffff\1\163",
            "\1\165",
            "\1\166",
            "\1\145\2\uffff\1\115",
            "\1\167\1\uffff\1\145\2\uffff\1\115",
            "\1\161\1\160",
            "\1\162\1\uffff\1\130\2\uffff\1\70",
            "\1\170",
            "\1\167\1\uffff\1\145\2\uffff\1\115"
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "140:9: ( twig_ternary | var_or_field | method_chain )";
        }
    }
 

    public static final BitSet FOLLOW_twig_print_statement_in_twig_source72 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_control_statement_in_twig_source76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTRL_OPEN_in_twig_control_statement91 = new BitSet(new long[]{0x0000004000040080L});
    public static final BitSet FOLLOW_twig_control_in_twig_control_statement93 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CTRL_CLOSE_in_twig_control_statement96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_twig_control109 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_twig_control_tag_in_twig_control112 = new BitSet(new long[]{0x00000157FACA1502L});
    public static final BitSet FOLLOW_twig_control_body_in_twig_control114 = new BitSet(new long[]{0x00000157FACA1502L});
    public static final BitSet FOLLOW_STRING_in_twig_control_tag135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_control_body164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASIG_in_twig_control_body168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PIPE_in_twig_control_body172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_twig_control_body176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_twig_control_body180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_twig_control_body184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QM_in_twig_control_body188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_twig_control_body192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_twig_control_body196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_eq_check_in_twig_control_body200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_or_field_in_twig_control_body204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_control_body208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_keyword_in_twig_control_body212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_twig_control_body216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_twig_control_body220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_in_check_in_twig_control_body224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METHOD_START_in_in_check243 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_in_check246 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_var_or_field_in_in_check250 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_IN_in_in_check253 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_in_check256 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_var_or_field_in_in_check260 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_METHOD_END_in_in_check263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_range278 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_DDOT_in_range290 = new BitSet(new long[]{0x0000015000000000L});
    public static final BitSet FOLLOW_set_in_range292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary319 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary323 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_var_or_field_in_twig_ternary327 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary331 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_eq_check_in_twig_ternary335 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_QM_in_twig_ternary338 = new BitSet(new long[]{0x0000015000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary341 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary345 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_var_or_field_in_twig_ternary349 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary353 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_COLON_in_twig_ternary356 = new BitSet(new long[]{0x0000015000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_or_field_in_twig_ternary367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_or_field_in_eq_check388 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_method_chain_in_eq_check392 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_NUMBER_in_eq_check396 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_eq_check400 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_set_in_eq_check403 = new BitSet(new long[]{0x0000015000000000L});
    public static final BitSet FOLLOW_var_or_field_in_eq_check420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_eq_check424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_eq_check428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_eq_check432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_OPEN_in_twig_print_statement453 = new BitSet(new long[]{0x0000015040000420L});
    public static final BitSet FOLLOW_twig_print_in_twig_print_statement455 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_PRINT_CLOSE_in_twig_print_statement458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_p_input_in_twig_print485 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_PIPE_in_twig_print488 = new BitSet(new long[]{0x0000015040000400L});
    public static final BitSet FOLLOW_p_input_in_twig_print490 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_var_or_field_in_p_input507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_p_input511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_p_input515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_p_input519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_ternary_in_p_input523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_not_in_p_input527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concat_in_p_input531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concat_operand_in_concat546 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_TILDE_in_concat549 = new BitSet(new long[]{0x0000015040000400L});
    public static final BitSet FOLLOW_concat_operand_in_concat551 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_concat_operand569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_or_field_in_concat_operand573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_concat_operand577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_twig_not593 = new BitSet(new long[]{0x0000015000000000L});
    public static final BitSet FOLLOW_twig_ternary_in_twig_not596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_or_field_in_twig_not600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_not604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_START_in_array620 = new BitSet(new long[]{0x0000015002000000L});
    public static final BitSet FOLLOW_array_elements_in_array622 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ARRAY_END_in_array624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_element_in_array_elements639 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_COMMA_in_array_elements642 = new BitSet(new long[]{0x0000015002000000L});
    public static final BitSet FOLLOW_array_element_in_array_elements644 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_STRING_in_array_element661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_array_element665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_array_element669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_array_element673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_var_or_field689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_access_in_var_or_field693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_variable710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_field_access737 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DOT_in_field_access740 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_STRING_in_field_access742 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_method_in_method_chain761 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_DOT_in_method_chain764 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_method_in_method_chain766 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_var_or_field_in_method783 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_METHOD_START_in_method785 = new BitSet(new long[]{0x0000015002000200L});
    public static final BitSet FOLLOW_arguments_in_method787 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_METHOD_END_in_method790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_arguments806 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_COMMA_in_arguments810 = new BitSet(new long[]{0x0000015002000000L});
    public static final BitSet FOLLOW_argument_in_arguments813 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_literal_argument_in_argument827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_argument831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_argument835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_or_field_in_argument839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal_argument852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_START_in_json878 = new BitSet(new long[]{0x0000014004000000L});
    public static final BitSet FOLLOW_json_arguments_in_json880 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_JSON_END_in_json883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments898 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_COMMA_in_json_arguments901 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments904 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_json_argument923 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_var_or_field_in_json_argument927 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_COLON_in_json_argument931 = new BitSet(new long[]{0x0000014000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_json_argument935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_var_or_field_in_json_argument940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_keyword0 = new BitSet(new long[]{0x0000000000000002L});

}
