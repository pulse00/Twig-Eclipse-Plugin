// $ANTLR 3.3 Nov 30, 2010 12:45:30 TwigParser.g 2011-06-19 21:51:04

package org.eclipse.twig.core.compiler.ast.parser;

import org.eclipse.twig.core.compiler.ast.parser.error.IErrorReporter;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PRINT_OPEN", "PRINT_CLOSE", "CTRL_OPEN", "CTRL_CLOSE", "METHOD_START", "METHOD_END", "ARRAY_START", "ARRAY_END", "ASIG", "TILDE", "PIPE", "DDOT", "DOT", "COLON", "COMMA", "BSLASH", "JSON_START", "JSON_END", "QM", "FOR", "ENDFOR", "ELSE", "IF", "ELSEIF", "ENDIF", "IN", "TWIG_AS", "MACRO", "ENDMACRO", "IMPORT", "FROM", "SET", "ENDSET", "INCLUDE", "WITH", "ONLY", "DIGIT", "NUMBER", "STRING_CHAR", "STRING", "NONCONTROL_CHAR", "STRING_LITERAL", "LOWER", "UPPER", "UNDER", "LETTER", "SYMBOL", "WHITESPACE", "TWIG_PR_STMT", "TWIG_VAR", "LITERAL_ARG"
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
    public static final int TILDE=13;
    public static final int PIPE=14;
    public static final int DDOT=15;
    public static final int DOT=16;
    public static final int COLON=17;
    public static final int COMMA=18;
    public static final int BSLASH=19;
    public static final int JSON_START=20;
    public static final int JSON_END=21;
    public static final int QM=22;
    public static final int FOR=23;
    public static final int ENDFOR=24;
    public static final int ELSE=25;
    public static final int IF=26;
    public static final int ELSEIF=27;
    public static final int ENDIF=28;
    public static final int IN=29;
    public static final int TWIG_AS=30;
    public static final int MACRO=31;
    public static final int ENDMACRO=32;
    public static final int IMPORT=33;
    public static final int FROM=34;
    public static final int SET=35;
    public static final int ENDSET=36;
    public static final int INCLUDE=37;
    public static final int WITH=38;
    public static final int ONLY=39;
    public static final int DIGIT=40;
    public static final int NUMBER=41;
    public static final int STRING_CHAR=42;
    public static final int STRING=43;
    public static final int NONCONTROL_CHAR=44;
    public static final int STRING_LITERAL=45;
    public static final int LOWER=46;
    public static final int UPPER=47;
    public static final int UNDER=48;
    public static final int LETTER=49;
    public static final int SYMBOL=50;
    public static final int WHITESPACE=51;
    public static final int TWIG_PR_STMT=52;
    public static final int TWIG_VAR=53;
    public static final int LITERAL_ARG=54;

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
    	


    public static class twig_source_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_source"
    // TwigParser.g:60:1: twig_source : ( twig_print_statement | twig_control_statement );
    public final TwigParser.twig_source_return twig_source() throws RecognitionException {
        TwigParser.twig_source_return retval = new TwigParser.twig_source_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.twig_print_statement_return twig_print_statement1 = null;

        TwigParser.twig_control_statement_return twig_control_statement2 = null;



        try {
            // TwigParser.g:61:3: ( twig_print_statement | twig_control_statement )
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
                    // TwigParser.g:61:5: twig_print_statement
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_print_statement_in_twig_source69);
                    twig_print_statement1=twig_print_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_print_statement1.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:61:28: twig_control_statement
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_control_statement_in_twig_source73);
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
    // TwigParser.g:67:1: twig_control_statement : CTRL_OPEN twig_control CTRL_CLOSE ;
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
            // TwigParser.g:68:3: ( CTRL_OPEN twig_control CTRL_CLOSE )
            // TwigParser.g:68:5: CTRL_OPEN twig_control CTRL_CLOSE
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            CTRL_OPEN3=(CommonToken)match(input,CTRL_OPEN,FOLLOW_CTRL_OPEN_in_twig_control_statement89); 
            CTRL_OPEN3_tree = (TwigCommonTree)adaptor.create(CTRL_OPEN3);
            adaptor.addChild(root_0, CTRL_OPEN3_tree);

            pushFollow(FOLLOW_twig_control_in_twig_control_statement91);
            twig_control4=twig_control();

            state._fsp--;

            adaptor.addChild(root_0, twig_control4.getTree());
            CTRL_CLOSE5=(CommonToken)match(input,CTRL_CLOSE,FOLLOW_CTRL_CLOSE_in_twig_control_statement93); 
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
    // TwigParser.g:72:1: twig_control : ( twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include );
    public final TwigParser.twig_control_return twig_control() throws RecognitionException {
        TwigParser.twig_control_return retval = new TwigParser.twig_control_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ENDFOR7=null;
        CommonToken ELSE8=null;
        CommonToken ENDIF11=null;
        TwigParser.twig_for_return twig_for6 = null;

        TwigParser.twig_if_return twig_if9 = null;

        TwigParser.twig_elseif_return twig_elseif10 = null;

        TwigParser.twig_macro_return twig_macro12 = null;

        TwigParser.twig_import_return twig_import13 = null;

        TwigParser.twig_set_return twig_set14 = null;

        TwigParser.twig_include_return twig_include15 = null;


        TwigCommonTree ENDFOR7_tree=null;
        TwigCommonTree ELSE8_tree=null;
        TwigCommonTree ENDIF11_tree=null;

        try {
            // TwigParser.g:73:3: ( twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include )
            int alt2=10;
            switch ( input.LA(1) ) {
            case FOR:
                {
                alt2=1;
                }
                break;
            case ENDFOR:
                {
                alt2=2;
                }
                break;
            case ELSE:
                {
                alt2=3;
                }
                break;
            case IF:
            case STRING:
                {
                alt2=4;
                }
                break;
            case ELSEIF:
                {
                alt2=5;
                }
                break;
            case ENDIF:
                {
                alt2=6;
                }
                break;
            case MACRO:
            case ENDMACRO:
                {
                alt2=7;
                }
                break;
            case IMPORT:
            case FROM:
                {
                alt2=8;
                }
                break;
            case SET:
            case ENDSET:
                {
                alt2=9;
                }
                break;
            case INCLUDE:
                {
                alt2=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // TwigParser.g:73:5: twig_for
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_for_in_twig_control107);
                    twig_for6=twig_for();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_for6.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:73:16: ENDFOR
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDFOR7=(CommonToken)match(input,ENDFOR,FOLLOW_ENDFOR_in_twig_control111); 
                    ENDFOR7_tree = (TwigCommonTree)adaptor.create(ENDFOR7);
                    adaptor.addChild(root_0, ENDFOR7_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:73:25: ELSE
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ELSE8=(CommonToken)match(input,ELSE,FOLLOW_ELSE_in_twig_control115); 
                    ELSE8_tree = (TwigCommonTree)adaptor.create(ELSE8);
                    adaptor.addChild(root_0, ELSE8_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:73:32: twig_if
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_if_in_twig_control119);
                    twig_if9=twig_if();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_if9.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:73:42: twig_elseif
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_elseif_in_twig_control123);
                    twig_elseif10=twig_elseif();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_elseif10.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:73:56: ENDIF
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDIF11=(CommonToken)match(input,ENDIF,FOLLOW_ENDIF_in_twig_control127); 
                    ENDIF11_tree = (TwigCommonTree)adaptor.create(ENDIF11);
                    adaptor.addChild(root_0, ENDIF11_tree);


                    }
                    break;
                case 7 :
                    // TwigParser.g:73:64: twig_macro
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_macro_in_twig_control131);
                    twig_macro12=twig_macro();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_macro12.getTree());

                    }
                    break;
                case 8 :
                    // TwigParser.g:73:77: twig_import
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_import_in_twig_control135);
                    twig_import13=twig_import();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_import13.getTree());

                    }
                    break;
                case 9 :
                    // TwigParser.g:73:91: twig_set
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_set_in_twig_control139);
                    twig_set14=twig_set();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_set14.getTree());

                    }
                    break;
                case 10 :
                    // TwigParser.g:73:102: twig_include
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_include_in_twig_control143);
                    twig_include15=twig_include();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_include15.getTree());

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
    // $ANTLR end "twig_control"

    public static class twig_include_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_include"
    // TwigParser.g:76:1: twig_include : INCLUDE ( include_ternary | include_statement ) ;
    public final TwigParser.twig_include_return twig_include() throws RecognitionException {
        TwigParser.twig_include_return retval = new TwigParser.twig_include_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken INCLUDE16=null;
        TwigParser.include_ternary_return include_ternary17 = null;

        TwigParser.include_statement_return include_statement18 = null;


        TwigCommonTree INCLUDE16_tree=null;

        try {
            // TwigParser.g:77:3: ( INCLUDE ( include_ternary | include_statement ) )
            // TwigParser.g:77:5: INCLUDE ( include_ternary | include_statement )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            INCLUDE16=(CommonToken)match(input,INCLUDE,FOLLOW_INCLUDE_in_twig_include158); 
            INCLUDE16_tree = (TwigCommonTree)adaptor.create(INCLUDE16);
            adaptor.addChild(root_0, INCLUDE16_tree);

            // TwigParser.g:77:13: ( include_ternary | include_statement )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==STRING_LITERAL) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==QM) ) {
                    alt3=1;
                }
                else if ( (LA3_1==CTRL_CLOSE||(LA3_1>=WITH && LA3_1<=ONLY)) ) {
                    alt3=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==NUMBER||LA3_0==STRING) ) {
                alt3=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // TwigParser.g:77:14: include_ternary
                    {
                    pushFollow(FOLLOW_include_ternary_in_twig_include161);
                    include_ternary17=include_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, include_ternary17.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:77:32: include_statement
                    {
                    pushFollow(FOLLOW_include_statement_in_twig_include165);
                    include_statement18=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement18.getTree());

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
    // $ANTLR end "twig_include"

    public static class include_ternary_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "include_ternary"
    // TwigParser.g:80:1: include_ternary : twig_ternary ( ONLY )? ;
    public final TwigParser.include_ternary_return include_ternary() throws RecognitionException {
        TwigParser.include_ternary_return retval = new TwigParser.include_ternary_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ONLY20=null;
        TwigParser.twig_ternary_return twig_ternary19 = null;


        TwigCommonTree ONLY20_tree=null;

        try {
            // TwigParser.g:81:3: ( twig_ternary ( ONLY )? )
            // TwigParser.g:81:5: twig_ternary ( ONLY )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_ternary_in_include_ternary181);
            twig_ternary19=twig_ternary();

            state._fsp--;

            adaptor.addChild(root_0, twig_ternary19.getTree());
            // TwigParser.g:81:18: ( ONLY )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ONLY) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // TwigParser.g:81:18: ONLY
                    {
                    ONLY20=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_ternary183); 
                    ONLY20_tree = (TwigCommonTree)adaptor.create(ONLY20);
                    adaptor.addChild(root_0, ONLY20_tree);


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
    // $ANTLR end "include_ternary"

    public static class include_statement_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "include_statement"
    // TwigParser.g:84:1: include_statement : ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )? )? ;
    public final TwigParser.include_statement_return include_statement() throws RecognitionException {
        TwigParser.include_statement_return retval = new TwigParser.include_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL21=null;
        CommonToken ONLY22=null;
        CommonToken WITH23=null;
        CommonToken STRING_LITERAL25=null;
        CommonToken ONLY28=null;
        TwigParser.variable_return variable24 = null;

        TwigParser.method_return method26 = null;

        TwigParser.json_return json27 = null;


        TwigCommonTree STRING_LITERAL21_tree=null;
        TwigCommonTree ONLY22_tree=null;
        TwigCommonTree WITH23_tree=null;
        TwigCommonTree STRING_LITERAL25_tree=null;
        TwigCommonTree ONLY28_tree=null;

        try {
            // TwigParser.g:85:3: ( ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )? )? )
            // TwigParser.g:85:5: ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )? )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:85:5: ( STRING_LITERAL )
            // TwigParser.g:85:6: STRING_LITERAL
            {
            STRING_LITERAL21=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement200); 
            STRING_LITERAL21_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL21);
            adaptor.addChild(root_0, STRING_LITERAL21_tree);


            }

            // TwigParser.g:85:22: ( ONLY )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==ONLY) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // TwigParser.g:85:22: ONLY
                    {
                    ONLY22=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement203); 
                    ONLY22_tree = (TwigCommonTree)adaptor.create(ONLY22);
                    adaptor.addChild(root_0, ONLY22_tree);


                    }
                    break;

            }

            // TwigParser.g:85:28: ( WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==WITH) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // TwigParser.g:85:29: WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )?
                    {
                    WITH23=(CommonToken)match(input,WITH,FOLLOW_WITH_in_include_statement207); 
                    WITH23_tree = (TwigCommonTree)adaptor.create(WITH23);
                    adaptor.addChild(root_0, WITH23_tree);

                    // TwigParser.g:85:34: ( variable | STRING_LITERAL | method | json )
                    int alt6=4;
                    alt6 = dfa6.predict(input);
                    switch (alt6) {
                        case 1 :
                            // TwigParser.g:85:35: variable
                            {
                            pushFollow(FOLLOW_variable_in_include_statement210);
                            variable24=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable24.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:85:46: STRING_LITERAL
                            {
                            STRING_LITERAL25=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement214); 
                            STRING_LITERAL25_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL25);
                            adaptor.addChild(root_0, STRING_LITERAL25_tree);


                            }
                            break;
                        case 3 :
                            // TwigParser.g:85:63: method
                            {
                            pushFollow(FOLLOW_method_in_include_statement218);
                            method26=method();

                            state._fsp--;

                            adaptor.addChild(root_0, method26.getTree());

                            }
                            break;
                        case 4 :
                            // TwigParser.g:85:72: json
                            {
                            pushFollow(FOLLOW_json_in_include_statement222);
                            json27=json();

                            state._fsp--;

                            adaptor.addChild(root_0, json27.getTree());

                            }
                            break;

                    }

                    // TwigParser.g:85:78: ( ONLY )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==ONLY) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // TwigParser.g:85:78: ONLY
                            {
                            ONLY28=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement225); 
                            ONLY28_tree = (TwigCommonTree)adaptor.create(ONLY28);
                            adaptor.addChild(root_0, ONLY28_tree);


                            }
                            break;

                    }


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
    // $ANTLR end "include_statement"

    public static class twig_set_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_set"
    // TwigParser.g:88:1: twig_set : ( ( SET twig_assignment ( COMMA twig_assignment )* ) | ENDSET );
    public final TwigParser.twig_set_return twig_set() throws RecognitionException {
        TwigParser.twig_set_return retval = new TwigParser.twig_set_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken SET29=null;
        CommonToken COMMA31=null;
        CommonToken ENDSET33=null;
        TwigParser.twig_assignment_return twig_assignment30 = null;

        TwigParser.twig_assignment_return twig_assignment32 = null;


        TwigCommonTree SET29_tree=null;
        TwigCommonTree COMMA31_tree=null;
        TwigCommonTree ENDSET33_tree=null;

        try {
            // TwigParser.g:89:3: ( ( SET twig_assignment ( COMMA twig_assignment )* ) | ENDSET )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==SET) ) {
                alt10=1;
            }
            else if ( (LA10_0==ENDSET) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // TwigParser.g:89:5: ( SET twig_assignment ( COMMA twig_assignment )* )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:89:5: ( SET twig_assignment ( COMMA twig_assignment )* )
                    // TwigParser.g:89:6: SET twig_assignment ( COMMA twig_assignment )*
                    {
                    SET29=(CommonToken)match(input,SET,FOLLOW_SET_in_twig_set244); 
                    SET29_tree = (TwigCommonTree)adaptor.create(SET29);
                    adaptor.addChild(root_0, SET29_tree);

                    pushFollow(FOLLOW_twig_assignment_in_twig_set246);
                    twig_assignment30=twig_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_assignment30.getTree());
                    // TwigParser.g:89:26: ( COMMA twig_assignment )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==COMMA) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // TwigParser.g:89:27: COMMA twig_assignment
                    	    {
                    	    COMMA31=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_set249); 
                    	    COMMA31_tree = (TwigCommonTree)adaptor.create(COMMA31);
                    	    adaptor.addChild(root_0, COMMA31_tree);

                    	    pushFollow(FOLLOW_twig_assignment_in_twig_set251);
                    	    twig_assignment32=twig_assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, twig_assignment32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:89:54: ENDSET
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDSET33=(CommonToken)match(input,ENDSET,FOLLOW_ENDSET_in_twig_set258); 
                    ENDSET33_tree = (TwigCommonTree)adaptor.create(ENDSET33);
                    adaptor.addChild(root_0, ENDSET33_tree);


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
    // $ANTLR end "twig_set"

    public static class twig_assignment_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_assignment"
    // TwigParser.g:92:1: twig_assignment : twig_left_assignment ( ASIG twig_right_assignment )? ;
    public final TwigParser.twig_assignment_return twig_assignment() throws RecognitionException {
        TwigParser.twig_assignment_return retval = new TwigParser.twig_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ASIG35=null;
        TwigParser.twig_left_assignment_return twig_left_assignment34 = null;

        TwigParser.twig_right_assignment_return twig_right_assignment36 = null;


        TwigCommonTree ASIG35_tree=null;

        try {
            // TwigParser.g:93:3: ( twig_left_assignment ( ASIG twig_right_assignment )? )
            // TwigParser.g:93:6: twig_left_assignment ( ASIG twig_right_assignment )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_left_assignment_in_twig_assignment273);
            twig_left_assignment34=twig_left_assignment();

            state._fsp--;

            adaptor.addChild(root_0, twig_left_assignment34.getTree());
            // TwigParser.g:93:27: ( ASIG twig_right_assignment )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ASIG) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // TwigParser.g:93:28: ASIG twig_right_assignment
                    {
                    ASIG35=(CommonToken)match(input,ASIG,FOLLOW_ASIG_in_twig_assignment276); 
                    ASIG35_tree = (TwigCommonTree)adaptor.create(ASIG35);
                    adaptor.addChild(root_0, ASIG35_tree);

                    pushFollow(FOLLOW_twig_right_assignment_in_twig_assignment278);
                    twig_right_assignment36=twig_right_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_right_assignment36.getTree());

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
    // $ANTLR end "twig_assignment"

    public static class twig_left_assignment_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_left_assignment"
    // TwigParser.g:96:1: twig_left_assignment : ( variable ( COMMA variable )* ) ;
    public final TwigParser.twig_left_assignment_return twig_left_assignment() throws RecognitionException {
        TwigParser.twig_left_assignment_return retval = new TwigParser.twig_left_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA38=null;
        TwigParser.variable_return variable37 = null;

        TwigParser.variable_return variable39 = null;


        TwigCommonTree COMMA38_tree=null;

        try {
            // TwigParser.g:97:3: ( ( variable ( COMMA variable )* ) )
            // TwigParser.g:97:5: ( variable ( COMMA variable )* )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:97:5: ( variable ( COMMA variable )* )
            // TwigParser.g:97:6: variable ( COMMA variable )*
            {
            pushFollow(FOLLOW_variable_in_twig_left_assignment296);
            variable37=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable37.getTree());
            // TwigParser.g:97:15: ( COMMA variable )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==COMMA) ) {
                    int LA12_2 = input.LA(2);

                    if ( (LA12_2==STRING) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // TwigParser.g:97:16: COMMA variable
            	    {
            	    COMMA38=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_left_assignment299); 
            	    COMMA38_tree = (TwigCommonTree)adaptor.create(COMMA38);
            	    adaptor.addChild(root_0, COMMA38_tree);

            	    pushFollow(FOLLOW_variable_in_twig_left_assignment301);
            	    variable39=variable();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable39.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


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
    // $ANTLR end "twig_left_assignment"

    public static class twig_right_assignment_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_right_assignment"
    // TwigParser.g:100:1: twig_right_assignment : ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) )* ;
    public final TwigParser.twig_right_assignment_return twig_right_assignment() throws RecognitionException {
        TwigParser.twig_right_assignment_return retval = new TwigParser.twig_right_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL40=null;
        CommonToken COMMA46=null;
        CommonToken STRING_LITERAL47=null;
        TwigParser.variable_return variable41 = null;

        TwigParser.method_return method42 = null;

        TwigParser.array_return array43 = null;

        TwigParser.json_return json44 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument45 = null;

        TwigParser.variable_return variable48 = null;

        TwigParser.method_return method49 = null;

        TwigParser.array_return array50 = null;

        TwigParser.json_return json51 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument52 = null;


        TwigCommonTree STRING_LITERAL40_tree=null;
        TwigCommonTree COMMA46_tree=null;
        TwigCommonTree STRING_LITERAL47_tree=null;

        try {
            // TwigParser.g:101:3: ( ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) )* )
            // TwigParser.g:101:5: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:101:5: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )
            int alt13=6;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // TwigParser.g:101:6: STRING_LITERAL
                    {
                    STRING_LITERAL40=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment320); 
                    STRING_LITERAL40_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL40);
                    adaptor.addChild(root_0, STRING_LITERAL40_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:101:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_right_assignment324);
                    variable41=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable41.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:101:34: method
                    {
                    pushFollow(FOLLOW_method_in_twig_right_assignment328);
                    method42=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method42.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:101:43: array
                    {
                    pushFollow(FOLLOW_array_in_twig_right_assignment332);
                    array43=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array43.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:101:51: json
                    {
                    pushFollow(FOLLOW_json_in_twig_right_assignment336);
                    json44=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json44.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:101:58: twig_tilde_argument
                    {
                    pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment340);
                    twig_tilde_argument45=twig_tilde_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_tilde_argument45.getTree());

                    }
                    break;

            }

            // TwigParser.g:101:79: ( COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==COMMA) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==ARRAY_START||LA15_1==JSON_START||LA15_1==STRING||LA15_1==STRING_LITERAL) ) {
                        alt15=1;
                    }


                }


                switch (alt15) {
            	case 1 :
            	    // TwigParser.g:101:80: COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )
            	    {
            	    COMMA46=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_right_assignment344); 
            	    COMMA46_tree = (TwigCommonTree)adaptor.create(COMMA46);
            	    adaptor.addChild(root_0, COMMA46_tree);

            	    // TwigParser.g:101:86: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )
            	    int alt14=6;
            	    alt14 = dfa14.predict(input);
            	    switch (alt14) {
            	        case 1 :
            	            // TwigParser.g:101:87: STRING_LITERAL
            	            {
            	            STRING_LITERAL47=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment347); 
            	            STRING_LITERAL47_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL47);
            	            adaptor.addChild(root_0, STRING_LITERAL47_tree);


            	            }
            	            break;
            	        case 2 :
            	            // TwigParser.g:101:104: variable
            	            {
            	            pushFollow(FOLLOW_variable_in_twig_right_assignment351);
            	            variable48=variable();

            	            state._fsp--;

            	            adaptor.addChild(root_0, variable48.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // TwigParser.g:101:115: method
            	            {
            	            pushFollow(FOLLOW_method_in_twig_right_assignment355);
            	            method49=method();

            	            state._fsp--;

            	            adaptor.addChild(root_0, method49.getTree());

            	            }
            	            break;
            	        case 4 :
            	            // TwigParser.g:101:124: array
            	            {
            	            pushFollow(FOLLOW_array_in_twig_right_assignment359);
            	            array50=array();

            	            state._fsp--;

            	            adaptor.addChild(root_0, array50.getTree());

            	            }
            	            break;
            	        case 5 :
            	            // TwigParser.g:101:132: json
            	            {
            	            pushFollow(FOLLOW_json_in_twig_right_assignment363);
            	            json51=json();

            	            state._fsp--;

            	            adaptor.addChild(root_0, json51.getTree());

            	            }
            	            break;
            	        case 6 :
            	            // TwigParser.g:101:139: twig_tilde_argument
            	            {
            	            pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment367);
            	            twig_tilde_argument52=twig_tilde_argument();

            	            state._fsp--;

            	            adaptor.addChild(root_0, twig_tilde_argument52.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "twig_right_assignment"

    public static class twig_tilde_argument_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_tilde_argument"
    // TwigParser.g:104:1: twig_tilde_argument : ( STRING_LITERAL | variable | method | array | json ) TILDE ( STRING_LITERAL | variable | method | array | json ) ;
    public final TwigParser.twig_tilde_argument_return twig_tilde_argument() throws RecognitionException {
        TwigParser.twig_tilde_argument_return retval = new TwigParser.twig_tilde_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL53=null;
        CommonToken TILDE58=null;
        CommonToken STRING_LITERAL59=null;
        TwigParser.variable_return variable54 = null;

        TwigParser.method_return method55 = null;

        TwigParser.array_return array56 = null;

        TwigParser.json_return json57 = null;

        TwigParser.variable_return variable60 = null;

        TwigParser.method_return method61 = null;

        TwigParser.array_return array62 = null;

        TwigParser.json_return json63 = null;


        TwigCommonTree STRING_LITERAL53_tree=null;
        TwigCommonTree TILDE58_tree=null;
        TwigCommonTree STRING_LITERAL59_tree=null;

        try {
            // TwigParser.g:105:3: ( ( STRING_LITERAL | variable | method | array | json ) TILDE ( STRING_LITERAL | variable | method | array | json ) )
            // TwigParser.g:105:5: ( STRING_LITERAL | variable | method | array | json ) TILDE ( STRING_LITERAL | variable | method | array | json )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:105:5: ( STRING_LITERAL | variable | method | array | json )
            int alt16=5;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // TwigParser.g:105:6: STRING_LITERAL
                    {
                    STRING_LITERAL53=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument386); 
                    STRING_LITERAL53_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL53);
                    adaptor.addChild(root_0, STRING_LITERAL53_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:105:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument390);
                    variable54=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable54.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:105:34: method
                    {
                    pushFollow(FOLLOW_method_in_twig_tilde_argument394);
                    method55=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method55.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:105:43: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument398);
                    array56=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array56.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:105:51: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument402);
                    json57=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json57.getTree());

                    }
                    break;

            }

            TILDE58=(CommonToken)match(input,TILDE,FOLLOW_TILDE_in_twig_tilde_argument405); 
            TILDE58_tree = (TwigCommonTree)adaptor.create(TILDE58);
            adaptor.addChild(root_0, TILDE58_tree);

            // TwigParser.g:105:63: ( STRING_LITERAL | variable | method | array | json )
            int alt17=5;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // TwigParser.g:105:64: STRING_LITERAL
                    {
                    STRING_LITERAL59=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument408); 
                    STRING_LITERAL59_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL59);
                    adaptor.addChild(root_0, STRING_LITERAL59_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:105:81: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument412);
                    variable60=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable60.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:105:92: method
                    {
                    pushFollow(FOLLOW_method_in_twig_tilde_argument416);
                    method61=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method61.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:105:101: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument420);
                    array62=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array62.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:105:109: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument424);
                    json63=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json63.getTree());

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
    // $ANTLR end "twig_tilde_argument"

    public static class twig_import_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_import"
    // TwigParser.g:108:1: twig_import : ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )? ;
    public final TwigParser.twig_import_return twig_import() throws RecognitionException {
        TwigParser.twig_import_return retval = new TwigParser.twig_import_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken FROM64=null;
        CommonToken STRING_LITERAL65=null;
        CommonToken IMPORT66=null;
        CommonToken STRING_LITERAL67=null;
        CommonToken TWIG_AS69=null;
        CommonToken STRING70=null;
        CommonToken COMMA71=null;
        CommonToken STRING72=null;
        TwigParser.variable_return variable68 = null;


        TwigCommonTree FROM64_tree=null;
        TwigCommonTree STRING_LITERAL65_tree=null;
        TwigCommonTree IMPORT66_tree=null;
        TwigCommonTree STRING_LITERAL67_tree=null;
        TwigCommonTree TWIG_AS69_tree=null;
        TwigCommonTree STRING70_tree=null;
        TwigCommonTree COMMA71_tree=null;
        TwigCommonTree STRING72_tree=null;

        try {
            // TwigParser.g:109:3: ( ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )? )
            // TwigParser.g:109:5: ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:109:5: ( FROM ( STRING_LITERAL ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==FROM) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // TwigParser.g:109:6: FROM ( STRING_LITERAL )
                    {
                    FROM64=(CommonToken)match(input,FROM,FOLLOW_FROM_in_twig_import441); 
                    FROM64_tree = (TwigCommonTree)adaptor.create(FROM64);
                    adaptor.addChild(root_0, FROM64_tree);

                    // TwigParser.g:109:11: ( STRING_LITERAL )
                    // TwigParser.g:109:12: STRING_LITERAL
                    {
                    STRING_LITERAL65=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import444); 
                    STRING_LITERAL65_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL65);
                    adaptor.addChild(root_0, STRING_LITERAL65_tree);


                    }


                    }
                    break;

            }

            IMPORT66=(CommonToken)match(input,IMPORT,FOLLOW_IMPORT_in_twig_import449); 
            IMPORT66_tree = (TwigCommonTree)adaptor.create(IMPORT66);
            adaptor.addChild(root_0, IMPORT66_tree);

            // TwigParser.g:109:37: ( STRING_LITERAL | variable )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==STRING_LITERAL) ) {
                alt19=1;
            }
            else if ( (LA19_0==STRING) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // TwigParser.g:109:38: STRING_LITERAL
                    {
                    STRING_LITERAL67=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import452); 
                    STRING_LITERAL67_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL67);
                    adaptor.addChild(root_0, STRING_LITERAL67_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:109:55: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_import456);
                    variable68=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable68.getTree());

                    }
                    break;

            }

            // TwigParser.g:109:65: ( TWIG_AS ( STRING ( COMMA STRING )* ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==TWIG_AS) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // TwigParser.g:109:66: TWIG_AS ( STRING ( COMMA STRING )* )
                    {
                    TWIG_AS69=(CommonToken)match(input,TWIG_AS,FOLLOW_TWIG_AS_in_twig_import460); 
                    TWIG_AS69_tree = (TwigCommonTree)adaptor.create(TWIG_AS69);
                    adaptor.addChild(root_0, TWIG_AS69_tree);

                    // TwigParser.g:109:74: ( STRING ( COMMA STRING )* )
                    // TwigParser.g:109:75: STRING ( COMMA STRING )*
                    {
                    STRING70=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import463); 
                    STRING70_tree = (TwigCommonTree)adaptor.create(STRING70);
                    adaptor.addChild(root_0, STRING70_tree);

                    // TwigParser.g:109:82: ( COMMA STRING )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==COMMA) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // TwigParser.g:109:83: COMMA STRING
                    	    {
                    	    COMMA71=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_import466); 
                    	    COMMA71_tree = (TwigCommonTree)adaptor.create(COMMA71);
                    	    adaptor.addChild(root_0, COMMA71_tree);

                    	    STRING72=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import468); 
                    	    STRING72_tree = (TwigCommonTree)adaptor.create(STRING72);
                    	    adaptor.addChild(root_0, STRING72_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }


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
    // $ANTLR end "twig_import"

    public static class twig_macro_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_macro"
    // TwigParser.g:112:1: twig_macro : ( ( MACRO ( variable | method ) ) | ENDMACRO );
    public final TwigParser.twig_macro_return twig_macro() throws RecognitionException {
        TwigParser.twig_macro_return retval = new TwigParser.twig_macro_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken MACRO73=null;
        CommonToken ENDMACRO76=null;
        TwigParser.variable_return variable74 = null;

        TwigParser.method_return method75 = null;


        TwigCommonTree MACRO73_tree=null;
        TwigCommonTree ENDMACRO76_tree=null;

        try {
            // TwigParser.g:113:3: ( ( MACRO ( variable | method ) ) | ENDMACRO )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==MACRO) ) {
                alt23=1;
            }
            else if ( (LA23_0==ENDMACRO) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // TwigParser.g:113:5: ( MACRO ( variable | method ) )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:113:5: ( MACRO ( variable | method ) )
                    // TwigParser.g:113:6: MACRO ( variable | method )
                    {
                    MACRO73=(CommonToken)match(input,MACRO,FOLLOW_MACRO_in_twig_macro490); 
                    MACRO73_tree = (TwigCommonTree)adaptor.create(MACRO73);
                    adaptor.addChild(root_0, MACRO73_tree);

                    // TwigParser.g:113:12: ( variable | method )
                    int alt22=2;
                    alt22 = dfa22.predict(input);
                    switch (alt22) {
                        case 1 :
                            // TwigParser.g:113:13: variable
                            {
                            pushFollow(FOLLOW_variable_in_twig_macro493);
                            variable74=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable74.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:113:24: method
                            {
                            pushFollow(FOLLOW_method_in_twig_macro497);
                            method75=method();

                            state._fsp--;

                            adaptor.addChild(root_0, method75.getTree());

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:113:35: ENDMACRO
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDMACRO76=(CommonToken)match(input,ENDMACRO,FOLLOW_ENDMACRO_in_twig_macro503); 
                    ENDMACRO76_tree = (TwigCommonTree)adaptor.create(ENDMACRO76);
                    adaptor.addChild(root_0, ENDMACRO76_tree);


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
    // $ANTLR end "twig_macro"

    public static class twig_if_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_if"
    // TwigParser.g:116:1: twig_if : ( IF variable | method );
    public final TwigParser.twig_if_return twig_if() throws RecognitionException {
        TwigParser.twig_if_return retval = new TwigParser.twig_if_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken IF77=null;
        TwigParser.variable_return variable78 = null;

        TwigParser.method_return method79 = null;


        TwigCommonTree IF77_tree=null;

        try {
            // TwigParser.g:117:3: ( IF variable | method )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==IF) ) {
                alt24=1;
            }
            else if ( (LA24_0==STRING) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // TwigParser.g:117:5: IF variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    IF77=(CommonToken)match(input,IF,FOLLOW_IF_in_twig_if518); 
                    IF77_tree = (TwigCommonTree)adaptor.create(IF77);
                    adaptor.addChild(root_0, IF77_tree);

                    pushFollow(FOLLOW_variable_in_twig_if520);
                    variable78=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable78.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:117:19: method
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_in_twig_if524);
                    method79=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method79.getTree());

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
    // $ANTLR end "twig_if"

    public static class twig_elseif_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_elseif"
    // TwigParser.g:120:1: twig_elseif : ELSEIF ( variable | method ) ;
    public final TwigParser.twig_elseif_return twig_elseif() throws RecognitionException {
        TwigParser.twig_elseif_return retval = new TwigParser.twig_elseif_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ELSEIF80=null;
        TwigParser.variable_return variable81 = null;

        TwigParser.method_return method82 = null;


        TwigCommonTree ELSEIF80_tree=null;

        try {
            // TwigParser.g:121:3: ( ELSEIF ( variable | method ) )
            // TwigParser.g:121:5: ELSEIF ( variable | method )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ELSEIF80=(CommonToken)match(input,ELSEIF,FOLLOW_ELSEIF_in_twig_elseif539); 
            ELSEIF80_tree = (TwigCommonTree)adaptor.create(ELSEIF80);
            adaptor.addChild(root_0, ELSEIF80_tree);

            // TwigParser.g:121:12: ( variable | method )
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // TwigParser.g:121:13: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_elseif542);
                    variable81=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable81.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:121:24: method
                    {
                    pushFollow(FOLLOW_method_in_twig_elseif546);
                    method82=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method82.getTree());

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
    // $ANTLR end "twig_elseif"

    public static class twig_for_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_for"
    // TwigParser.g:124:1: twig_for : FOR STRING IN for_arguments ;
    public final TwigParser.twig_for_return twig_for() throws RecognitionException {
        TwigParser.twig_for_return retval = new TwigParser.twig_for_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken FOR83=null;
        CommonToken STRING84=null;
        CommonToken IN85=null;
        TwigParser.for_arguments_return for_arguments86 = null;


        TwigCommonTree FOR83_tree=null;
        TwigCommonTree STRING84_tree=null;
        TwigCommonTree IN85_tree=null;

        try {
            // TwigParser.g:125:3: ( FOR STRING IN for_arguments )
            // TwigParser.g:125:5: FOR STRING IN for_arguments
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            FOR83=(CommonToken)match(input,FOR,FOLLOW_FOR_in_twig_for562); 
            FOR83_tree = (TwigCommonTree)adaptor.create(FOR83);
            adaptor.addChild(root_0, FOR83_tree);

            STRING84=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_for564); 
            STRING84_tree = (TwigCommonTree)adaptor.create(STRING84);
            adaptor.addChild(root_0, STRING84_tree);

            IN85=(CommonToken)match(input,IN,FOLLOW_IN_in_twig_for566); 
            IN85_tree = (TwigCommonTree)adaptor.create(IN85);
            adaptor.addChild(root_0, IN85_tree);

            pushFollow(FOLLOW_for_arguments_in_twig_for568);
            for_arguments86=for_arguments();

            state._fsp--;

            adaptor.addChild(root_0, for_arguments86.getTree());

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
    // $ANTLR end "twig_for"

    public static class for_arguments_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "for_arguments"
    // TwigParser.g:128:1: for_arguments : for_value ( PIPE for_value )* ;
    public final TwigParser.for_arguments_return for_arguments() throws RecognitionException {
        TwigParser.for_arguments_return retval = new TwigParser.for_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE88=null;
        TwigParser.for_value_return for_value87 = null;

        TwigParser.for_value_return for_value89 = null;


        TwigCommonTree PIPE88_tree=null;

        try {
            // TwigParser.g:129:3: ( for_value ( PIPE for_value )* )
            // TwigParser.g:129:5: for_value ( PIPE for_value )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_for_value_in_for_arguments583);
            for_value87=for_value();

            state._fsp--;

            adaptor.addChild(root_0, for_value87.getTree());
            // TwigParser.g:129:15: ( PIPE for_value )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==PIPE) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // TwigParser.g:129:16: PIPE for_value
            	    {
            	    PIPE88=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_for_arguments586); 
            	    PIPE88_tree = (TwigCommonTree)adaptor.create(PIPE88);
            	    adaptor.addChild(root_0, PIPE88_tree);

            	    pushFollow(FOLLOW_for_value_in_for_arguments588);
            	    for_value89=for_value();

            	    state._fsp--;

            	    adaptor.addChild(root_0, for_value89.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
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
    // $ANTLR end "for_arguments"

    public static class for_value_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "for_value"
    // TwigParser.g:132:1: for_value : ( STRING | STRING_LITERAL | method | range );
    public final TwigParser.for_value_return for_value() throws RecognitionException {
        TwigParser.for_value_return retval = new TwigParser.for_value_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING90=null;
        CommonToken STRING_LITERAL91=null;
        TwigParser.method_return method92 = null;

        TwigParser.range_return range93 = null;


        TwigCommonTree STRING90_tree=null;
        TwigCommonTree STRING_LITERAL91_tree=null;

        try {
            // TwigParser.g:133:3: ( STRING | STRING_LITERAL | method | range )
            int alt27=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                switch ( input.LA(2) ) {
                case DDOT:
                    {
                    alt27=4;
                    }
                    break;
                case CTRL_CLOSE:
                case PIPE:
                    {
                    alt27=1;
                    }
                    break;
                case METHOD_START:
                case DOT:
                    {
                    alt27=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }

                }
                break;
            case STRING_LITERAL:
                {
                int LA27_2 = input.LA(2);

                if ( (LA27_2==DDOT) ) {
                    alt27=4;
                }
                else if ( (LA27_2==CTRL_CLOSE||LA27_2==PIPE) ) {
                    alt27=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 2, input);

                    throw nvae;
                }
                }
                break;
            case NUMBER:
                {
                alt27=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // TwigParser.g:133:5: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING90=(CommonToken)match(input,STRING,FOLLOW_STRING_in_for_value605); 
                    STRING90_tree = (TwigCommonTree)adaptor.create(STRING90);
                    adaptor.addChild(root_0, STRING90_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:133:14: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL91=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_for_value609); 
                    STRING_LITERAL91_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL91);
                    adaptor.addChild(root_0, STRING_LITERAL91_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:133:31: method
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_in_for_value613);
                    method92=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method92.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:133:40: range
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_range_in_for_value617);
                    range93=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range93.getTree());

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
    // $ANTLR end "for_value"

    public static class range_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "range"
    // TwigParser.g:136:1: range : ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) ;
    public final TwigParser.range_return range() throws RecognitionException {
        TwigParser.range_return retval = new TwigParser.range_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set94=null;
        CommonToken DDOT95=null;
        CommonToken set96=null;

        TwigCommonTree set94_tree=null;
        TwigCommonTree DDOT95_tree=null;
        TwigCommonTree set96_tree=null;

        try {
            // TwigParser.g:137:3: ( ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) )
            // TwigParser.g:137:5: ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set94=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set94));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            DDOT95=(CommonToken)match(input,DDOT,FOLLOW_DDOT_in_range644); 
            DDOT95_tree = (TwigCommonTree)adaptor.create(DDOT95);
            adaptor.addChild(root_0, DDOT95_tree);

            set96=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set96));
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
    // TwigParser.g:140:1: twig_ternary : ( STRING_LITERAL | NUMBER | variable | method ) QM ( STRING_LITERAL | NUMBER | variable | method ) COLON ( STRING_LITERAL | NUMBER | variable | method ) ;
    public final TwigParser.twig_ternary_return twig_ternary() throws RecognitionException {
        TwigParser.twig_ternary_return retval = new TwigParser.twig_ternary_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL97=null;
        CommonToken NUMBER98=null;
        CommonToken QM101=null;
        CommonToken STRING_LITERAL102=null;
        CommonToken NUMBER103=null;
        CommonToken COLON106=null;
        CommonToken STRING_LITERAL107=null;
        CommonToken NUMBER108=null;
        TwigParser.variable_return variable99 = null;

        TwigParser.method_return method100 = null;

        TwigParser.variable_return variable104 = null;

        TwigParser.method_return method105 = null;

        TwigParser.variable_return variable109 = null;

        TwigParser.method_return method110 = null;


        TwigCommonTree STRING_LITERAL97_tree=null;
        TwigCommonTree NUMBER98_tree=null;
        TwigCommonTree QM101_tree=null;
        TwigCommonTree STRING_LITERAL102_tree=null;
        TwigCommonTree NUMBER103_tree=null;
        TwigCommonTree COLON106_tree=null;
        TwigCommonTree STRING_LITERAL107_tree=null;
        TwigCommonTree NUMBER108_tree=null;

        try {
            // TwigParser.g:141:3: ( ( STRING_LITERAL | NUMBER | variable | method ) QM ( STRING_LITERAL | NUMBER | variable | method ) COLON ( STRING_LITERAL | NUMBER | variable | method ) )
            // TwigParser.g:141:5: ( STRING_LITERAL | NUMBER | variable | method ) QM ( STRING_LITERAL | NUMBER | variable | method ) COLON ( STRING_LITERAL | NUMBER | variable | method )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:141:5: ( STRING_LITERAL | NUMBER | variable | method )
            int alt28=4;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // TwigParser.g:141:6: STRING_LITERAL
                    {
                    STRING_LITERAL97=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary673); 
                    STRING_LITERAL97_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL97);
                    adaptor.addChild(root_0, STRING_LITERAL97_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:141:23: NUMBER
                    {
                    NUMBER98=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary677); 
                    NUMBER98_tree = (TwigCommonTree)adaptor.create(NUMBER98);
                    adaptor.addChild(root_0, NUMBER98_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:141:32: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary681);
                    variable99=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable99.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:141:43: method
                    {
                    pushFollow(FOLLOW_method_in_twig_ternary685);
                    method100=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method100.getTree());

                    }
                    break;

            }

            QM101=(CommonToken)match(input,QM,FOLLOW_QM_in_twig_ternary688); 
            QM101_tree = (TwigCommonTree)adaptor.create(QM101);
            adaptor.addChild(root_0, QM101_tree);

            // TwigParser.g:141:54: ( STRING_LITERAL | NUMBER | variable | method )
            int alt29=4;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // TwigParser.g:141:55: STRING_LITERAL
                    {
                    STRING_LITERAL102=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary691); 
                    STRING_LITERAL102_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL102);
                    adaptor.addChild(root_0, STRING_LITERAL102_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:141:72: NUMBER
                    {
                    NUMBER103=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary695); 
                    NUMBER103_tree = (TwigCommonTree)adaptor.create(NUMBER103);
                    adaptor.addChild(root_0, NUMBER103_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:141:81: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary699);
                    variable104=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable104.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:141:92: method
                    {
                    pushFollow(FOLLOW_method_in_twig_ternary703);
                    method105=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method105.getTree());

                    }
                    break;

            }

            COLON106=(CommonToken)match(input,COLON,FOLLOW_COLON_in_twig_ternary706); 
            COLON106_tree = (TwigCommonTree)adaptor.create(COLON106);
            adaptor.addChild(root_0, COLON106_tree);

            // TwigParser.g:141:106: ( STRING_LITERAL | NUMBER | variable | method )
            int alt30=4;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // TwigParser.g:141:107: STRING_LITERAL
                    {
                    STRING_LITERAL107=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary709); 
                    STRING_LITERAL107_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL107);
                    adaptor.addChild(root_0, STRING_LITERAL107_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:141:124: NUMBER
                    {
                    NUMBER108=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary713); 
                    NUMBER108_tree = (TwigCommonTree)adaptor.create(NUMBER108);
                    adaptor.addChild(root_0, NUMBER108_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:141:133: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary717);
                    variable109=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable109.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:141:144: method
                    {
                    pushFollow(FOLLOW_method_in_twig_ternary721);
                    method110=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method110.getTree());

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

    public static class twig_print_statement_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_print_statement"
    // TwigParser.g:146:1: twig_print_statement : PRINT_OPEN twig_print PRINT_CLOSE -> ^( TWIG_PR_STMT twig_print ) ;
    public final TwigParser.twig_print_statement_return twig_print_statement() throws RecognitionException {
        TwigParser.twig_print_statement_return retval = new TwigParser.twig_print_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PRINT_OPEN111=null;
        CommonToken PRINT_CLOSE113=null;
        TwigParser.twig_print_return twig_print112 = null;


        TwigCommonTree PRINT_OPEN111_tree=null;
        TwigCommonTree PRINT_CLOSE113_tree=null;
        RewriteRuleTokenStream stream_PRINT_OPEN=new RewriteRuleTokenStream(adaptor,"token PRINT_OPEN");
        RewriteRuleTokenStream stream_PRINT_CLOSE=new RewriteRuleTokenStream(adaptor,"token PRINT_CLOSE");
        RewriteRuleSubtreeStream stream_twig_print=new RewriteRuleSubtreeStream(adaptor,"rule twig_print");
        try {
            // TwigParser.g:147:3: ( PRINT_OPEN twig_print PRINT_CLOSE -> ^( TWIG_PR_STMT twig_print ) )
            // TwigParser.g:147:6: PRINT_OPEN twig_print PRINT_CLOSE
            {
            PRINT_OPEN111=(CommonToken)match(input,PRINT_OPEN,FOLLOW_PRINT_OPEN_in_twig_print_statement739);  
            stream_PRINT_OPEN.add(PRINT_OPEN111);

            pushFollow(FOLLOW_twig_print_in_twig_print_statement741);
            twig_print112=twig_print();

            state._fsp--;

            stream_twig_print.add(twig_print112.getTree());
            PRINT_CLOSE113=(CommonToken)match(input,PRINT_CLOSE,FOLLOW_PRINT_CLOSE_in_twig_print_statement743);  
            stream_PRINT_CLOSE.add(PRINT_CLOSE113);



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
            // 148:5: -> ^( TWIG_PR_STMT twig_print )
            {
                // TwigParser.g:148:7: ^( TWIG_PR_STMT twig_print )
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
    // TwigParser.g:151:1: twig_print : p_input ( PIPE p_input )* ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE115=null;
        TwigParser.p_input_return p_input114 = null;

        TwigParser.p_input_return p_input116 = null;


        TwigCommonTree PIPE115_tree=null;

        try {
            // TwigParser.g:152:3: ( p_input ( PIPE p_input )* )
            // TwigParser.g:152:5: p_input ( PIPE p_input )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_p_input_in_twig_print769);
            p_input114=p_input();

            state._fsp--;

            adaptor.addChild(root_0, p_input114.getTree());
            // TwigParser.g:152:13: ( PIPE p_input )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==PIPE) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // TwigParser.g:152:14: PIPE p_input
            	    {
            	    PIPE115=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_print772); 
            	    PIPE115_tree = (TwigCommonTree)adaptor.create(PIPE115);
            	    adaptor.addChild(root_0, PIPE115_tree);

            	    pushFollow(FOLLOW_p_input_in_twig_print774);
            	    p_input116=p_input();

            	    state._fsp--;

            	    adaptor.addChild(root_0, p_input116.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
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
    // TwigParser.g:155:1: p_input : ( variable | method | array | STRING_LITERAL );
    public final TwigParser.p_input_return p_input() throws RecognitionException {
        TwigParser.p_input_return retval = new TwigParser.p_input_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL120=null;
        TwigParser.variable_return variable117 = null;

        TwigParser.method_return method118 = null;

        TwigParser.array_return array119 = null;


        TwigCommonTree STRING_LITERAL120_tree=null;

        try {
            // TwigParser.g:156:3: ( variable | method | array | STRING_LITERAL )
            int alt32=4;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // TwigParser.g:156:5: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_p_input791);
                    variable117=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable117.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:156:16: method
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_in_p_input795);
                    method118=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method118.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:156:25: array
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_array_in_p_input799);
                    array119=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array119.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:156:33: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL120=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_p_input803); 
                    STRING_LITERAL120_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL120);
                    adaptor.addChild(root_0, STRING_LITERAL120_tree);


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

    public static class array_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "array"
    // TwigParser.g:160:1: array : ARRAY_START array_elements ARRAY_END ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ARRAY_START121=null;
        CommonToken ARRAY_END123=null;
        TwigParser.array_elements_return array_elements122 = null;


        TwigCommonTree ARRAY_START121_tree=null;
        TwigCommonTree ARRAY_END123_tree=null;

        try {
            // TwigParser.g:161:3: ( ARRAY_START array_elements ARRAY_END )
            // TwigParser.g:161:5: ARRAY_START array_elements ARRAY_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ARRAY_START121=(CommonToken)match(input,ARRAY_START,FOLLOW_ARRAY_START_in_array821); 
            ARRAY_START121_tree = (TwigCommonTree)adaptor.create(ARRAY_START121);
            adaptor.addChild(root_0, ARRAY_START121_tree);

            pushFollow(FOLLOW_array_elements_in_array823);
            array_elements122=array_elements();

            state._fsp--;

            adaptor.addChild(root_0, array_elements122.getTree());
            ARRAY_END123=(CommonToken)match(input,ARRAY_END,FOLLOW_ARRAY_END_in_array825); 
            ARRAY_END123_tree = (TwigCommonTree)adaptor.create(ARRAY_END123);
            adaptor.addChild(root_0, ARRAY_END123_tree);


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
    // TwigParser.g:164:1: array_elements : array_element ( COMMA array_element )* ;
    public final TwigParser.array_elements_return array_elements() throws RecognitionException {
        TwigParser.array_elements_return retval = new TwigParser.array_elements_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA125=null;
        TwigParser.array_element_return array_element124 = null;

        TwigParser.array_element_return array_element126 = null;


        TwigCommonTree COMMA125_tree=null;

        try {
            // TwigParser.g:165:3: ( array_element ( COMMA array_element )* )
            // TwigParser.g:165:5: array_element ( COMMA array_element )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_array_element_in_array_elements840);
            array_element124=array_element();

            state._fsp--;

            adaptor.addChild(root_0, array_element124.getTree());
            // TwigParser.g:165:19: ( COMMA array_element )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==COMMA) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // TwigParser.g:165:20: COMMA array_element
            	    {
            	    COMMA125=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_array_elements843); 
            	    COMMA125_tree = (TwigCommonTree)adaptor.create(COMMA125);
            	    adaptor.addChild(root_0, COMMA125_tree);

            	    pushFollow(FOLLOW_array_element_in_array_elements845);
            	    array_element126=array_element();

            	    state._fsp--;

            	    adaptor.addChild(root_0, array_element126.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // TwigParser.g:168:1: array_element : ( STRING | STRING_LITERAL | NUMBER | json );
    public final TwigParser.array_element_return array_element() throws RecognitionException {
        TwigParser.array_element_return retval = new TwigParser.array_element_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING127=null;
        CommonToken STRING_LITERAL128=null;
        CommonToken NUMBER129=null;
        TwigParser.json_return json130 = null;


        TwigCommonTree STRING127_tree=null;
        TwigCommonTree STRING_LITERAL128_tree=null;
        TwigCommonTree NUMBER129_tree=null;

        try {
            // TwigParser.g:169:3: ( STRING | STRING_LITERAL | NUMBER | json )
            int alt34=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt34=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt34=2;
                }
                break;
            case NUMBER:
                {
                alt34=3;
                }
                break;
            case JSON_START:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // TwigParser.g:169:5: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING127=(CommonToken)match(input,STRING,FOLLOW_STRING_in_array_element862); 
                    STRING127_tree = (TwigCommonTree)adaptor.create(STRING127);
                    adaptor.addChild(root_0, STRING127_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:169:14: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL128=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_array_element866); 
                    STRING_LITERAL128_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL128);
                    adaptor.addChild(root_0, STRING_LITERAL128_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:169:31: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER129=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_array_element870); 
                    NUMBER129_tree = (TwigCommonTree)adaptor.create(NUMBER129);
                    adaptor.addChild(root_0, NUMBER129_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:169:40: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_array_element874);
                    json130=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json130.getTree());

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

    public static class variable_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable"
    // TwigParser.g:172:1: variable : param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) ;
    public final TwigParser.variable_return variable() throws RecognitionException {
        TwigParser.variable_return retval = new TwigParser.variable_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;
        CommonToken DOT131=null;
        CommonToken STRING132=null;

        TwigCommonTree param_tree=null;
        TwigCommonTree DOT131_tree=null;
        TwigCommonTree STRING132_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // TwigParser.g:173:3: (param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) )
            // TwigParser.g:173:5: param= STRING ( DOT ( STRING ) )*
            {
            param=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable891);  
            stream_STRING.add(param);

            // TwigParser.g:173:18: ( DOT ( STRING ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==DOT) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // TwigParser.g:173:19: DOT ( STRING )
            	    {
            	    DOT131=(CommonToken)match(input,DOT,FOLLOW_DOT_in_variable894);  
            	    stream_DOT.add(DOT131);

            	    // TwigParser.g:173:23: ( STRING )
            	    // TwigParser.g:173:24: STRING
            	    {
            	    STRING132=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable897);  
            	    stream_STRING.add(STRING132);


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
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
            // 174:5: -> ^( TWIG_VAR $param)
            {
                // TwigParser.g:174:7: ^( TWIG_VAR $param)
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
    // TwigParser.g:177:1: method : variable METHOD_START ( arguments )? METHOD_END ;
    public final TwigParser.method_return method() throws RecognitionException {
        TwigParser.method_return retval = new TwigParser.method_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken METHOD_START134=null;
        CommonToken METHOD_END136=null;
        TwigParser.variable_return variable133 = null;

        TwigParser.arguments_return arguments135 = null;


        TwigCommonTree METHOD_START134_tree=null;
        TwigCommonTree METHOD_END136_tree=null;

        try {
            // TwigParser.g:178:3: ( variable METHOD_START ( arguments )? METHOD_END )
            // TwigParser.g:178:5: variable METHOD_START ( arguments )? METHOD_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_in_method927);
            variable133=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable133.getTree());
            METHOD_START134=(CommonToken)match(input,METHOD_START,FOLLOW_METHOD_START_in_method929); 
            METHOD_START134_tree = (TwigCommonTree)adaptor.create(METHOD_START134);
            adaptor.addChild(root_0, METHOD_START134_tree);

            // TwigParser.g:178:27: ( arguments )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==JSON_START||LA36_0==NUMBER||LA36_0==STRING||LA36_0==STRING_LITERAL) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // TwigParser.g:178:27: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_method931);
                    arguments135=arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, arguments135.getTree());

                    }
                    break;

            }

            METHOD_END136=(CommonToken)match(input,METHOD_END,FOLLOW_METHOD_END_in_method934); 
            METHOD_END136_tree = (TwigCommonTree)adaptor.create(METHOD_END136);
            adaptor.addChild(root_0, METHOD_END136_tree);


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
    // TwigParser.g:181:1: arguments : argument ( COMMA ( argument ) )* ;
    public final TwigParser.arguments_return arguments() throws RecognitionException {
        TwigParser.arguments_return retval = new TwigParser.arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA138=null;
        TwigParser.argument_return argument137 = null;

        TwigParser.argument_return argument139 = null;


        TwigCommonTree COMMA138_tree=null;

        try {
            // TwigParser.g:182:3: ( argument ( COMMA ( argument ) )* )
            // TwigParser.g:182:5: argument ( COMMA ( argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_argument_in_arguments950);
            argument137=argument();

            state._fsp--;

            adaptor.addChild(root_0, argument137.getTree());
            // TwigParser.g:182:15: ( COMMA ( argument ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==COMMA) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // TwigParser.g:182:16: COMMA ( argument )
            	    {
            	    COMMA138=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_arguments954); 
            	    COMMA138_tree = (TwigCommonTree)adaptor.create(COMMA138);
            	    adaptor.addChild(root_0, COMMA138_tree);

            	    // TwigParser.g:182:22: ( argument )
            	    // TwigParser.g:182:23: argument
            	    {
            	    pushFollow(FOLLOW_argument_in_arguments957);
            	    argument139=argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, argument139.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // TwigParser.g:185:1: argument : ( literal_argument | STRING | json | NUMBER );
    public final TwigParser.argument_return argument() throws RecognitionException {
        TwigParser.argument_return retval = new TwigParser.argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING141=null;
        CommonToken NUMBER143=null;
        TwigParser.literal_argument_return literal_argument140 = null;

        TwigParser.json_return json142 = null;


        TwigCommonTree STRING141_tree=null;
        TwigCommonTree NUMBER143_tree=null;

        try {
            // TwigParser.g:186:1: ( literal_argument | STRING | json | NUMBER )
            int alt38=4;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt38=1;
                }
                break;
            case STRING:
                {
                alt38=2;
                }
                break;
            case JSON_START:
                {
                alt38=3;
                }
                break;
            case NUMBER:
                {
                alt38=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // TwigParser.g:186:3: literal_argument
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_argument_in_argument971);
                    literal_argument140=literal_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, literal_argument140.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:186:22: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING141=(CommonToken)match(input,STRING,FOLLOW_STRING_in_argument975); 
                    STRING141_tree = (TwigCommonTree)adaptor.create(STRING141);
                    adaptor.addChild(root_0, STRING141_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:186:31: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_argument979);
                    json142=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json142.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:186:38: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER143=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_argument983); 
                    NUMBER143_tree = (TwigCommonTree)adaptor.create(NUMBER143);
                    adaptor.addChild(root_0, NUMBER143_tree);


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
    // TwigParser.g:189:1: literal_argument : param= STRING_LITERAL -> ^( LITERAL_ARG $param) ;
    public final TwigParser.literal_argument_return literal_argument() throws RecognitionException {
        TwigParser.literal_argument_return retval = new TwigParser.literal_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;

        TwigCommonTree param_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");

        try {
            // TwigParser.g:190:3: (param= STRING_LITERAL -> ^( LITERAL_ARG $param) )
            // TwigParser.g:190:5: param= STRING_LITERAL
            {
            param=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal_argument996);  
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
            // 191:5: -> ^( LITERAL_ARG $param)
            {
                // TwigParser.g:191:8: ^( LITERAL_ARG $param)
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
    // TwigParser.g:194:1: json : JSON_START ( json_arguments )? JSON_END ;
    public final TwigParser.json_return json() throws RecognitionException {
        TwigParser.json_return retval = new TwigParser.json_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken JSON_START144=null;
        CommonToken JSON_END146=null;
        TwigParser.json_arguments_return json_arguments145 = null;


        TwigCommonTree JSON_START144_tree=null;
        TwigCommonTree JSON_END146_tree=null;

        try {
            // TwigParser.g:195:3: ( JSON_START ( json_arguments )? JSON_END )
            // TwigParser.g:195:5: JSON_START ( json_arguments )? JSON_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            JSON_START144=(CommonToken)match(input,JSON_START,FOLLOW_JSON_START_in_json1022); 
            JSON_START144_tree = (TwigCommonTree)adaptor.create(JSON_START144);
            adaptor.addChild(root_0, JSON_START144_tree);

            // TwigParser.g:195:16: ( json_arguments )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==STRING||LA39_0==STRING_LITERAL) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // TwigParser.g:195:16: json_arguments
                    {
                    pushFollow(FOLLOW_json_arguments_in_json1024);
                    json_arguments145=json_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, json_arguments145.getTree());

                    }
                    break;

            }

            JSON_END146=(CommonToken)match(input,JSON_END,FOLLOW_JSON_END_in_json1027); 
            JSON_END146_tree = (TwigCommonTree)adaptor.create(JSON_END146);
            adaptor.addChild(root_0, JSON_END146_tree);


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
    // TwigParser.g:198:1: json_arguments : json_argument ( COMMA ( json_argument ) )* ;
    public final TwigParser.json_arguments_return json_arguments() throws RecognitionException {
        TwigParser.json_arguments_return retval = new TwigParser.json_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA148=null;
        TwigParser.json_argument_return json_argument147 = null;

        TwigParser.json_argument_return json_argument149 = null;


        TwigCommonTree COMMA148_tree=null;

        try {
            // TwigParser.g:199:3: ( json_argument ( COMMA ( json_argument ) )* )
            // TwigParser.g:199:5: json_argument ( COMMA ( json_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_json_argument_in_json_arguments1042);
            json_argument147=json_argument();

            state._fsp--;

            adaptor.addChild(root_0, json_argument147.getTree());
            // TwigParser.g:199:19: ( COMMA ( json_argument ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==COMMA) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // TwigParser.g:199:20: COMMA ( json_argument )
            	    {
            	    COMMA148=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_json_arguments1045); 
            	    COMMA148_tree = (TwigCommonTree)adaptor.create(COMMA148);
            	    adaptor.addChild(root_0, COMMA148_tree);

            	    // TwigParser.g:199:26: ( json_argument )
            	    // TwigParser.g:199:27: json_argument
            	    {
            	    pushFollow(FOLLOW_json_argument_in_json_arguments1048);
            	    json_argument149=json_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, json_argument149.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
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
    // TwigParser.g:202:1: json_argument : ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) ;
    public final TwigParser.json_argument_return json_argument() throws RecognitionException {
        TwigParser.json_argument_return retval = new TwigParser.json_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set150=null;
        CommonToken COLON151=null;
        CommonToken set152=null;

        TwigCommonTree set150_tree=null;
        TwigCommonTree COLON151_tree=null;
        TwigCommonTree set152_tree=null;

        try {
            // TwigParser.g:203:3: ( ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) )
            // TwigParser.g:203:5: ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set150=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set150));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // TwigParser.g:203:31: ( COLON )
            // TwigParser.g:203:32: COLON
            {
            COLON151=(CommonToken)match(input,COLON,FOLLOW_COLON_in_json_argument1075); 
            COLON151_tree = (TwigCommonTree)adaptor.create(COLON151);
            adaptor.addChild(root_0, COLON151_tree);


            }

            set152=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set152));
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
    // $ANTLR end "json_argument"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA16 dfa16 = new DFA16(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA22 dfa22 = new DFA22(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA32 dfa32 = new DFA32(this);
    static final String DFA6_eotS =
        "\10\uffff";
    static final String DFA6_eofS =
        "\10\uffff";
    static final String DFA6_minS =
        "\1\24\1\7\2\uffff\1\53\2\uffff\1\7";
    static final String DFA6_maxS =
        "\1\55\1\47\2\uffff\1\53\2\uffff\1\47";
    static final String DFA6_acceptS =
        "\2\uffff\1\2\1\4\1\uffff\1\1\1\3\1\uffff";
    static final String DFA6_specialS =
        "\10\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\3\26\uffff\1\1\1\uffff\1\2",
            "\1\5\1\6\7\uffff\1\4\26\uffff\1\5",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\5\1\6\7\uffff\1\4\26\uffff\1\5"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "85:34: ( variable | STRING_LITERAL | method | json )";
        }
    }
    static final String DFA13_eotS =
        "\112\uffff";
    static final String DFA13_eofS =
        "\112\uffff";
    static final String DFA13_minS =
        "\1\12\2\7\1\24\1\25\2\uffff\1\53\1\uffff\1\11\3\13\1\25\1\21\2\7"+
        "\2\11\1\25\1\11\1\7\1\24\1\7\1\21\1\13\1\53\1\uffff\1\24\1\21\1"+
        "\11\1\uffff\3\13\1\25\1\uffff\1\53\1\22\2\11\1\25\1\11\1\53\1\21"+
        "\1\13\1\22\1\53\1\21\1\11\1\22\2\53\1\21\2\53\1\22\1\21\1\53\1\22"+
        "\1\21\2\53\1\22\2\53\1\21\1\22\1\21\1\22\2\53\2\22";
    static final String DFA13_maxS =
        "\1\55\2\22\2\55\2\uffff\1\53\1\uffff\1\55\3\22\1\55\1\21\4\22\1"+
        "\55\2\22\1\55\1\22\1\21\1\22\1\55\1\uffff\1\55\1\21\1\22\1\uffff"+
        "\3\22\1\55\1\uffff\1\55\1\25\2\22\1\55\1\22\1\55\1\21\1\22\1\25"+
        "\1\55\1\21\1\22\1\25\2\55\1\21\2\55\1\25\1\21\1\55\1\25\1\21\2\55"+
        "\1\25\2\55\1\21\1\25\1\21\1\25\2\55\2\25";
    static final String DFA13_acceptS =
        "\5\uffff\1\1\1\6\1\uffff\1\2\22\uffff\1\5\3\uffff\1\3\4\uffff\1"+
        "\4\45\uffff";
    static final String DFA13_specialS =
        "\112\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\3\11\uffff\1\4\26\uffff\1\2\1\uffff\1\1",
            "\1\5\5\uffff\1\6\4\uffff\1\5",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\15\24\uffff\1\14\1\uffff\1\12\1\uffff\1\13",
            "\1\17\25\uffff\1\16\1\uffff\1\16",
            "",
            "",
            "\1\20",
            "",
            "\1\25\12\uffff\1\23\24\uffff\1\24\1\uffff\1\22\1\uffff\1\21",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\31\25\uffff\1\30\1\uffff\1\30",
            "\1\32",
            "\1\33\5\uffff\1\6\4\uffff\1\33",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\36\25\uffff\1\35\1\uffff\1\35",
            "\1\25\10\uffff\1\34",
            "\1\37\5\uffff\1\6\4\uffff\1\37",
            "\1\43\24\uffff\1\42\1\uffff\1\40\1\uffff\1\41",
            "\1\44\5\uffff\1\6\4\uffff\1\44",
            "\1\45",
            "\1\27\6\uffff\1\26",
            "\1\46\1\uffff\1\46",
            "",
            "\1\51\24\uffff\1\52\1\uffff\1\50\1\uffff\1\47",
            "\1\53",
            "\1\25\10\uffff\1\34",
            "",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\55\25\uffff\1\54\1\uffff\1\54",
            "",
            "\1\56\1\uffff\1\56",
            "\1\57\2\uffff\1\17",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\61\25\uffff\1\60\1\uffff\1\60",
            "\1\25\10\uffff\1\34",
            "\1\62\1\uffff\1\62",
            "\1\63",
            "\1\27\6\uffff\1\26",
            "\1\64\2\uffff\1\31",
            "\1\65\1\uffff\1\65",
            "\1\66",
            "\1\25\10\uffff\1\34",
            "\1\67\2\uffff\1\36",
            "\1\70\1\uffff\1\70",
            "\1\71\1\uffff\1\71",
            "\1\72",
            "\1\73\1\uffff\1\73",
            "\1\74\1\uffff\1\74",
            "\1\75\2\uffff\1\55",
            "\1\76",
            "\1\77\1\uffff\1\77",
            "\1\100\2\uffff\1\61",
            "\1\101",
            "\1\102\1\uffff\1\102",
            "\1\103\1\uffff\1\103",
            "\1\57\2\uffff\1\17",
            "\1\104\1\uffff\1\104",
            "\1\105\1\uffff\1\105",
            "\1\106",
            "\1\64\2\uffff\1\31",
            "\1\107",
            "\1\67\2\uffff\1\36",
            "\1\110\1\uffff\1\110",
            "\1\111\1\uffff\1\111",
            "\1\75\2\uffff\1\55",
            "\1\100\2\uffff\1\61"
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "101:5: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )";
        }
    }
    static final String DFA14_eotS =
        "\112\uffff";
    static final String DFA14_eofS =
        "\112\uffff";
    static final String DFA14_minS =
        "\1\12\2\7\1\24\1\25\2\uffff\1\53\1\uffff\1\11\3\13\1\25\1\21\2\7"+
        "\2\11\1\25\1\11\1\7\1\24\1\7\1\21\1\13\1\53\1\uffff\1\24\1\21\1"+
        "\11\1\uffff\3\13\1\25\1\uffff\1\53\1\22\2\11\1\25\1\11\1\53\1\21"+
        "\1\13\1\22\1\53\1\21\1\11\1\22\2\53\1\21\2\53\1\22\1\21\1\53\1\22"+
        "\1\21\2\53\1\22\2\53\1\21\1\22\1\21\1\22\2\53\2\22";
    static final String DFA14_maxS =
        "\1\55\2\22\2\55\2\uffff\1\53\1\uffff\1\55\3\22\1\55\1\21\4\22\1"+
        "\55\2\22\1\55\1\22\1\21\1\22\1\55\1\uffff\1\55\1\21\1\22\1\uffff"+
        "\3\22\1\55\1\uffff\1\55\1\25\2\22\1\55\1\22\1\55\1\21\1\22\1\25"+
        "\1\55\1\21\1\22\1\25\2\55\1\21\2\55\1\25\1\21\1\55\1\25\1\21\2\55"+
        "\1\25\2\55\1\21\1\25\1\21\1\25\2\55\2\25";
    static final String DFA14_acceptS =
        "\5\uffff\1\1\1\6\1\uffff\1\2\22\uffff\1\5\3\uffff\1\3\4\uffff\1"+
        "\4\45\uffff";
    static final String DFA14_specialS =
        "\112\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\3\11\uffff\1\4\26\uffff\1\2\1\uffff\1\1",
            "\1\5\5\uffff\1\6\4\uffff\1\5",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\15\24\uffff\1\14\1\uffff\1\12\1\uffff\1\13",
            "\1\17\25\uffff\1\16\1\uffff\1\16",
            "",
            "",
            "\1\20",
            "",
            "\1\25\12\uffff\1\23\24\uffff\1\24\1\uffff\1\22\1\uffff\1\21",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\31\25\uffff\1\30\1\uffff\1\30",
            "\1\32",
            "\1\33\5\uffff\1\6\4\uffff\1\33",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\36\25\uffff\1\35\1\uffff\1\35",
            "\1\25\10\uffff\1\34",
            "\1\37\5\uffff\1\6\4\uffff\1\37",
            "\1\43\24\uffff\1\42\1\uffff\1\40\1\uffff\1\41",
            "\1\44\5\uffff\1\6\4\uffff\1\44",
            "\1\45",
            "\1\27\6\uffff\1\26",
            "\1\46\1\uffff\1\46",
            "",
            "\1\51\24\uffff\1\52\1\uffff\1\50\1\uffff\1\47",
            "\1\53",
            "\1\25\10\uffff\1\34",
            "",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\55\25\uffff\1\54\1\uffff\1\54",
            "",
            "\1\56\1\uffff\1\56",
            "\1\57\2\uffff\1\17",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\61\25\uffff\1\60\1\uffff\1\60",
            "\1\25\10\uffff\1\34",
            "\1\62\1\uffff\1\62",
            "\1\63",
            "\1\27\6\uffff\1\26",
            "\1\64\2\uffff\1\31",
            "\1\65\1\uffff\1\65",
            "\1\66",
            "\1\25\10\uffff\1\34",
            "\1\67\2\uffff\1\36",
            "\1\70\1\uffff\1\70",
            "\1\71\1\uffff\1\71",
            "\1\72",
            "\1\73\1\uffff\1\73",
            "\1\74\1\uffff\1\74",
            "\1\75\2\uffff\1\55",
            "\1\76",
            "\1\77\1\uffff\1\77",
            "\1\100\2\uffff\1\61",
            "\1\101",
            "\1\102\1\uffff\1\102",
            "\1\103\1\uffff\1\103",
            "\1\57\2\uffff\1\17",
            "\1\104\1\uffff\1\104",
            "\1\105\1\uffff\1\105",
            "\1\106",
            "\1\64\2\uffff\1\31",
            "\1\107",
            "\1\67\2\uffff\1\36",
            "\1\110\1\uffff\1\110",
            "\1\111\1\uffff\1\111",
            "\1\75\2\uffff\1\55",
            "\1\100\2\uffff\1\61"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "101:86: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )";
        }
    }
    static final String DFA16_eotS =
        "\11\uffff";
    static final String DFA16_eofS =
        "\11\uffff";
    static final String DFA16_minS =
        "\1\12\1\uffff\1\10\2\uffff\1\53\2\uffff\1\10";
    static final String DFA16_maxS =
        "\1\55\1\uffff\1\20\2\uffff\1\53\2\uffff\1\20";
    static final String DFA16_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\2\1\3\1\uffff";
    static final String DFA16_specialS =
        "\11\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\3\11\uffff\1\4\26\uffff\1\2\1\uffff\1\1",
            "",
            "\1\7\4\uffff\1\6\2\uffff\1\5",
            "",
            "",
            "\1\10",
            "",
            "",
            "\1\7\4\uffff\1\6\2\uffff\1\5"
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "105:5: ( STRING_LITERAL | variable | method | array | json )";
        }
    }
    static final String DFA17_eotS =
        "\11\uffff";
    static final String DFA17_eofS =
        "\11\uffff";
    static final String DFA17_minS =
        "\1\12\1\uffff\1\7\2\uffff\1\53\2\uffff\1\7";
    static final String DFA17_maxS =
        "\1\55\1\uffff\1\22\2\uffff\1\53\2\uffff\1\22";
    static final String DFA17_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\2\1\3\1\uffff";
    static final String DFA17_specialS =
        "\11\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\3\11\uffff\1\4\26\uffff\1\2\1\uffff\1\1",
            "",
            "\1\6\1\7\7\uffff\1\5\1\uffff\1\6",
            "",
            "",
            "\1\10",
            "",
            "",
            "\1\6\1\7\7\uffff\1\5\1\uffff\1\6"
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
            return "105:63: ( STRING_LITERAL | variable | method | array | json )";
        }
    }
    static final String DFA22_eotS =
        "\6\uffff";
    static final String DFA22_eofS =
        "\6\uffff";
    static final String DFA22_minS =
        "\1\53\1\7\1\53\2\uffff\1\7";
    static final String DFA22_maxS =
        "\1\53\1\20\1\53\2\uffff\1\20";
    static final String DFA22_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA22_specialS =
        "\6\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1",
            "\1\3\1\4\7\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\3\1\4\7\uffff\1\2"
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "113:12: ( variable | method )";
        }
    }
    static final String DFA25_eotS =
        "\6\uffff";
    static final String DFA25_eofS =
        "\6\uffff";
    static final String DFA25_minS =
        "\1\53\1\7\1\53\2\uffff\1\7";
    static final String DFA25_maxS =
        "\1\53\1\20\1\53\2\uffff\1\20";
    static final String DFA25_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA25_specialS =
        "\6\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\1",
            "\1\3\1\4\7\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\3\1\4\7\uffff\1\2"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "121:12: ( variable | method )";
        }
    }
    static final String DFA28_eotS =
        "\10\uffff";
    static final String DFA28_eofS =
        "\10\uffff";
    static final String DFA28_minS =
        "\1\51\2\uffff\1\10\1\53\2\uffff\1\10";
    static final String DFA28_maxS =
        "\1\55\2\uffff\1\26\1\53\2\uffff\1\26";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA28_specialS =
        "\10\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\6\7\uffff\1\4\5\uffff\1\5",
            "\1\7",
            "",
            "",
            "\1\6\7\uffff\1\4\5\uffff\1\5"
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "141:5: ( STRING_LITERAL | NUMBER | variable | method )";
        }
    }
    static final String DFA29_eotS =
        "\10\uffff";
    static final String DFA29_eofS =
        "\10\uffff";
    static final String DFA29_minS =
        "\1\51\2\uffff\1\10\1\53\2\uffff\1\10";
    static final String DFA29_maxS =
        "\1\55\2\uffff\1\21\1\53\2\uffff\1\21";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA29_specialS =
        "\10\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\6\7\uffff\1\4\1\5",
            "\1\7",
            "",
            "",
            "\1\6\7\uffff\1\4\1\5"
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "141:54: ( STRING_LITERAL | NUMBER | variable | method )";
        }
    }
    static final String DFA30_eotS =
        "\10\uffff";
    static final String DFA30_eofS =
        "\10\uffff";
    static final String DFA30_minS =
        "\1\51\2\uffff\1\7\1\53\2\uffff\1\7";
    static final String DFA30_maxS =
        "\1\55\2\uffff\1\47\1\53\2\uffff\1\47";
    static final String DFA30_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA30_specialS =
        "\10\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\5\1\6\7\uffff\1\4\26\uffff\1\5",
            "\1\7",
            "",
            "",
            "\1\5\1\6\7\uffff\1\4\26\uffff\1\5"
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "141:106: ( STRING_LITERAL | NUMBER | variable | method )";
        }
    }
    static final String DFA32_eotS =
        "\10\uffff";
    static final String DFA32_eofS =
        "\10\uffff";
    static final String DFA32_minS =
        "\1\12\1\5\2\uffff\1\53\2\uffff\1\5";
    static final String DFA32_maxS =
        "\1\55\1\20\2\uffff\1\53\2\uffff\1\20";
    static final String DFA32_acceptS =
        "\2\uffff\1\3\1\4\1\uffff\1\1\1\2\1\uffff";
    static final String DFA32_specialS =
        "\10\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\2\40\uffff\1\1\1\uffff\1\3",
            "\1\5\2\uffff\1\6\5\uffff\1\5\1\uffff\1\4",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\5\2\uffff\1\6\5\uffff\1\5\1\uffff\1\4"
    };

    static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
    static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
    static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
    static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
    static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
    static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
    static final short[][] DFA32_transition;

    static {
        int numStates = DFA32_transitionS.length;
        DFA32_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
        }
    }

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = DFA32_eot;
            this.eof = DFA32_eof;
            this.min = DFA32_min;
            this.max = DFA32_max;
            this.accept = DFA32_accept;
            this.special = DFA32_special;
            this.transition = DFA32_transition;
        }
        public String getDescription() {
            return "155:1: p_input : ( variable | method | array | STRING_LITERAL );";
        }
    }
 

    public static final BitSet FOLLOW_twig_print_statement_in_twig_source69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_control_statement_in_twig_source73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTRL_OPEN_in_twig_control_statement89 = new BitSet(new long[]{0x0000083F9F800000L});
    public static final BitSet FOLLOW_twig_control_in_twig_control_statement91 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CTRL_CLOSE_in_twig_control_statement93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_for_in_twig_control107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDFOR_in_twig_control111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_twig_control115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_if_in_twig_control119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_elseif_in_twig_control123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDIF_in_twig_control127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_macro_in_twig_control131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_import_in_twig_control135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_set_in_twig_control139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_include_in_twig_control143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_twig_include158 = new BitSet(new long[]{0x00002A0004000000L});
    public static final BitSet FOLLOW_include_ternary_in_twig_include161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_twig_include165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_ternary_in_include_ternary181 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_ternary183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement200 = new BitSet(new long[]{0x000000C000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement203 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_WITH_in_include_statement207 = new BitSet(new long[]{0x0000280004100000L});
    public static final BitSet FOLLOW_variable_in_include_statement210 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement214 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_method_in_include_statement218 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_json_in_include_statement222 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_twig_set244 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set246 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_set249 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set251 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ENDSET_in_twig_set258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_left_assignment_in_twig_assignment273 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ASIG_in_twig_assignment276 = new BitSet(new long[]{0x0000280004100400L});
    public static final BitSet FOLLOW_twig_right_assignment_in_twig_assignment278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment296 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_left_assignment299 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment301 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment320 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment324 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_method_in_twig_right_assignment328 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment332 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment336 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment340 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_right_assignment344 = new BitSet(new long[]{0x0000280004100400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment347 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment351 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_method_in_twig_right_assignment355 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment359 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment363 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment367 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument386 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument390 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_method_in_twig_tilde_argument394 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument398 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument402 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_TILDE_in_twig_tilde_argument405 = new BitSet(new long[]{0x0000280004100400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_tilde_argument416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_twig_import441 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import444 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_IMPORT_in_twig_import449 = new BitSet(new long[]{0x0000280004000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import452 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_variable_in_twig_import456 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_TWIG_AS_in_twig_import460 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import463 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_import466 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import468 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_MACRO_in_twig_macro490 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_variable_in_twig_macro493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_macro497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDMACRO_in_twig_macro503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_twig_if518 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_variable_in_twig_if520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_if524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSEIF_in_twig_elseif539 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_variable_in_twig_elseif542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_elseif546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_twig_for562 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_for564 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_IN_in_twig_for566 = new BitSet(new long[]{0x00002A0004000000L});
    public static final BitSet FOLLOW_for_arguments_in_twig_for568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_value_in_for_arguments583 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_PIPE_in_for_arguments586 = new BitSet(new long[]{0x00002A0004000000L});
    public static final BitSet FOLLOW_for_value_in_for_arguments588 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_STRING_in_for_value605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_for_value609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_for_value613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_for_value617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_range632 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_range644 = new BitSet(new long[]{0x00002A0000000000L});
    public static final BitSet FOLLOW_set_in_range646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary673 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary677 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary681 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_method_in_twig_ternary685 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_QM_in_twig_ternary688 = new BitSet(new long[]{0x00002A0004000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary691 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary695 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary699 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_method_in_twig_ternary703 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_twig_ternary706 = new BitSet(new long[]{0x00002A0004000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_ternary717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_ternary721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_OPEN_in_twig_print_statement739 = new BitSet(new long[]{0x0000280004000400L});
    public static final BitSet FOLLOW_twig_print_in_twig_print_statement741 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_PRINT_CLOSE_in_twig_print_statement743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_p_input_in_twig_print769 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_PIPE_in_twig_print772 = new BitSet(new long[]{0x0000280004000400L});
    public static final BitSet FOLLOW_p_input_in_twig_print774 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_variable_in_p_input791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_p_input795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_p_input799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_p_input803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_START_in_array821 = new BitSet(new long[]{0x00002A0004100000L});
    public static final BitSet FOLLOW_array_elements_in_array823 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ARRAY_END_in_array825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_element_in_array_elements840 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_array_elements843 = new BitSet(new long[]{0x00002A0004100000L});
    public static final BitSet FOLLOW_array_element_in_array_elements845 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_in_array_element862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_array_element866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_array_element870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_array_element874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_variable891 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_DOT_in_variable894 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_STRING_in_variable897 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_variable_in_method927 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_METHOD_START_in_method929 = new BitSet(new long[]{0x00002A0004100200L});
    public static final BitSet FOLLOW_arguments_in_method931 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_METHOD_END_in_method934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_arguments950 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_arguments954 = new BitSet(new long[]{0x00002A0004100000L});
    public static final BitSet FOLLOW_argument_in_arguments957 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_literal_argument_in_argument971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_argument975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_argument979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_argument983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal_argument996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_START_in_json1022 = new BitSet(new long[]{0x0000280000200000L});
    public static final BitSet FOLLOW_json_arguments_in_json1024 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JSON_END_in_json1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1042 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_json_arguments1045 = new BitSet(new long[]{0x0000280000000000L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1048 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_set_in_json_argument1066 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_json_argument1075 = new BitSet(new long[]{0x0000280000000000L});
    public static final BitSet FOLLOW_set_in_json_argument1078 = new BitSet(new long[]{0x0000000000000002L});

}