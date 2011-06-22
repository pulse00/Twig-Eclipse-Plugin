// $ANTLR 3.3 Nov 30, 2010 12:45:30 TwigParser.g 2011-06-22 00:34:40

package org.eclipse.twig.core.parser;

import org.eclipse.twig.core.parser.error.IErrorReporter;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PRINT_OPEN", "PRINT_CLOSE", "CTRL_OPEN", "CTRL_CLOSE", "METHOD_START", "METHOD_END", "ARRAY_START", "ARRAY_END", "ASIG", "TILDE", "PIPE", "DDOT", "DOT", "COLON", "COMMA", "BSLASH", "JSON_START", "JSON_END", "QM", "BLOCK", "ENDBLOCK", "FOR", "ENDFOR", "ELSE", "IF", "ELSEIF", "ENDIF", "IN", "TWIG_AS", "MACRO", "ENDMACRO", "IMPORT", "FROM", "SET", "ENDSET", "INCLUDE", "WITH", "ONLY", "DIGIT", "NUMBER", "STRING_CHAR", "STRING", "NONCONTROL_CHAR", "STRING_LITERAL", "LOWER", "UPPER", "UNDER", "LETTER", "SYMBOL", "WHITESPACE", "TWIG_PR_STMT", "TWIG_VAR", "LITERAL_ARG"
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
    public static final int BLOCK=23;
    public static final int ENDBLOCK=24;
    public static final int FOR=25;
    public static final int ENDFOR=26;
    public static final int ELSE=27;
    public static final int IF=28;
    public static final int ELSEIF=29;
    public static final int ENDIF=30;
    public static final int IN=31;
    public static final int TWIG_AS=32;
    public static final int MACRO=33;
    public static final int ENDMACRO=34;
    public static final int IMPORT=35;
    public static final int FROM=36;
    public static final int SET=37;
    public static final int ENDSET=38;
    public static final int INCLUDE=39;
    public static final int WITH=40;
    public static final int ONLY=41;
    public static final int DIGIT=42;
    public static final int NUMBER=43;
    public static final int STRING_CHAR=44;
    public static final int STRING=45;
    public static final int NONCONTROL_CHAR=46;
    public static final int STRING_LITERAL=47;
    public static final int LOWER=48;
    public static final int UPPER=49;
    public static final int UNDER=50;
    public static final int LETTER=51;
    public static final int SYMBOL=52;
    public static final int WHITESPACE=53;
    public static final int TWIG_PR_STMT=54;
    public static final int TWIG_VAR=55;
    public static final int LITERAL_ARG=56;

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
            
    		if (errorReporter == null)
    			return;
    		
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
    // TwigParser.g:67:1: twig_control_statement : CTRL_OPEN ( twig_control )? CTRL_CLOSE ;
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
            // TwigParser.g:68:3: ( CTRL_OPEN ( twig_control )? CTRL_CLOSE )
            // TwigParser.g:68:5: CTRL_OPEN ( twig_control )? CTRL_CLOSE
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            CTRL_OPEN3=(CommonToken)match(input,CTRL_OPEN,FOLLOW_CTRL_OPEN_in_twig_control_statement89); 
            CTRL_OPEN3_tree = (TwigCommonTree)adaptor.create(CTRL_OPEN3);
            adaptor.addChild(root_0, CTRL_OPEN3_tree);

            // TwigParser.g:68:15: ( twig_control )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=BLOCK && LA2_0<=ENDIF)||(LA2_0>=MACRO && LA2_0<=INCLUDE)||LA2_0==STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // TwigParser.g:68:15: twig_control
                    {
                    pushFollow(FOLLOW_twig_control_in_twig_control_statement91);
                    twig_control4=twig_control();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_control4.getTree());

                    }
                    break;

            }

            CTRL_CLOSE5=(CommonToken)match(input,CTRL_CLOSE,FOLLOW_CTRL_CLOSE_in_twig_control_statement94); 
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
    // TwigParser.g:72:1: twig_control : ( twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include | twig_block );
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

        TwigParser.twig_block_return twig_block16 = null;


        TwigCommonTree ENDFOR7_tree=null;
        TwigCommonTree ELSE8_tree=null;
        TwigCommonTree ENDIF11_tree=null;

        try {
            // TwigParser.g:73:3: ( twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include | twig_block )
            int alt3=11;
            switch ( input.LA(1) ) {
            case FOR:
                {
                alt3=1;
                }
                break;
            case ENDFOR:
                {
                alt3=2;
                }
                break;
            case ELSE:
                {
                alt3=3;
                }
                break;
            case IF:
            case STRING:
                {
                alt3=4;
                }
                break;
            case ELSEIF:
                {
                alt3=5;
                }
                break;
            case ENDIF:
                {
                alt3=6;
                }
                break;
            case MACRO:
            case ENDMACRO:
                {
                alt3=7;
                }
                break;
            case IMPORT:
            case FROM:
                {
                alt3=8;
                }
                break;
            case SET:
            case ENDSET:
                {
                alt3=9;
                }
                break;
            case INCLUDE:
                {
                alt3=10;
                }
                break;
            case BLOCK:
            case ENDBLOCK:
                {
                alt3=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // TwigParser.g:73:5: twig_for
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_for_in_twig_control108);
                    twig_for6=twig_for();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_for6.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:73:16: ENDFOR
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDFOR7=(CommonToken)match(input,ENDFOR,FOLLOW_ENDFOR_in_twig_control112); 
                    ENDFOR7_tree = (TwigCommonTree)adaptor.create(ENDFOR7);
                    adaptor.addChild(root_0, ENDFOR7_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:73:25: ELSE
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ELSE8=(CommonToken)match(input,ELSE,FOLLOW_ELSE_in_twig_control116); 
                    ELSE8_tree = (TwigCommonTree)adaptor.create(ELSE8);
                    adaptor.addChild(root_0, ELSE8_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:73:32: twig_if
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_if_in_twig_control120);
                    twig_if9=twig_if();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_if9.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:73:42: twig_elseif
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_elseif_in_twig_control124);
                    twig_elseif10=twig_elseif();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_elseif10.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:73:56: ENDIF
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDIF11=(CommonToken)match(input,ENDIF,FOLLOW_ENDIF_in_twig_control128); 
                    ENDIF11_tree = (TwigCommonTree)adaptor.create(ENDIF11);
                    adaptor.addChild(root_0, ENDIF11_tree);


                    }
                    break;
                case 7 :
                    // TwigParser.g:73:64: twig_macro
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_macro_in_twig_control132);
                    twig_macro12=twig_macro();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_macro12.getTree());

                    }
                    break;
                case 8 :
                    // TwigParser.g:73:77: twig_import
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_import_in_twig_control136);
                    twig_import13=twig_import();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_import13.getTree());

                    }
                    break;
                case 9 :
                    // TwigParser.g:73:91: twig_set
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_set_in_twig_control140);
                    twig_set14=twig_set();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_set14.getTree());

                    }
                    break;
                case 10 :
                    // TwigParser.g:73:102: twig_include
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_include_in_twig_control144);
                    twig_include15=twig_include();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_include15.getTree());

                    }
                    break;
                case 11 :
                    // TwigParser.g:73:117: twig_block
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_block_in_twig_control148);
                    twig_block16=twig_block();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_block16.getTree());

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

    public static class twig_block_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_block"
    // TwigParser.g:77:1: twig_block : ( ( BLOCK twig_block_param ) | ( ENDBLOCK ) );
    public final TwigParser.twig_block_return twig_block() throws RecognitionException {
        TwigParser.twig_block_return retval = new TwigParser.twig_block_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken BLOCK17=null;
        CommonToken ENDBLOCK19=null;
        TwigParser.twig_block_param_return twig_block_param18 = null;


        TwigCommonTree BLOCK17_tree=null;
        TwigCommonTree ENDBLOCK19_tree=null;

        try {
            // TwigParser.g:78:3: ( ( BLOCK twig_block_param ) | ( ENDBLOCK ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==BLOCK) ) {
                alt4=1;
            }
            else if ( (LA4_0==ENDBLOCK) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // TwigParser.g:78:5: ( BLOCK twig_block_param )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:78:5: ( BLOCK twig_block_param )
                    // TwigParser.g:78:6: BLOCK twig_block_param
                    {
                    BLOCK17=(CommonToken)match(input,BLOCK,FOLLOW_BLOCK_in_twig_block167); 
                    BLOCK17_tree = (TwigCommonTree)adaptor.create(BLOCK17);
                    adaptor.addChild(root_0, BLOCK17_tree);

                    pushFollow(FOLLOW_twig_block_param_in_twig_block169);
                    twig_block_param18=twig_block_param();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_block_param18.getTree());

                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:78:32: ( ENDBLOCK )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:78:32: ( ENDBLOCK )
                    // TwigParser.g:78:33: ENDBLOCK
                    {
                    ENDBLOCK19=(CommonToken)match(input,ENDBLOCK,FOLLOW_ENDBLOCK_in_twig_block175); 
                    ENDBLOCK19_tree = (TwigCommonTree)adaptor.create(ENDBLOCK19);
                    adaptor.addChild(root_0, ENDBLOCK19_tree);


                    }


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
    // $ANTLR end "twig_block"

    public static class twig_block_param_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_block_param"
    // TwigParser.g:81:1: twig_block_param : ( variable | method ) ( twig_print )? ;
    public final TwigParser.twig_block_param_return twig_block_param() throws RecognitionException {
        TwigParser.twig_block_param_return retval = new TwigParser.twig_block_param_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.variable_return variable20 = null;

        TwigParser.method_return method21 = null;

        TwigParser.twig_print_return twig_print22 = null;



        try {
            // TwigParser.g:82:3: ( ( variable | method ) ( twig_print )? )
            // TwigParser.g:82:5: ( variable | method ) ( twig_print )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:82:5: ( variable | method )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // TwigParser.g:82:6: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_block_param192);
                    variable20=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable20.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:82:17: method
                    {
                    pushFollow(FOLLOW_method_in_twig_block_param196);
                    method21=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method21.getTree());

                    }
                    break;

            }

            // TwigParser.g:82:25: ( twig_print )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ARRAY_START||LA6_0==STRING||LA6_0==STRING_LITERAL) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // TwigParser.g:82:25: twig_print
                    {
                    pushFollow(FOLLOW_twig_print_in_twig_block_param199);
                    twig_print22=twig_print();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_print22.getTree());

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
    // $ANTLR end "twig_block_param"

    public static class twig_include_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_include"
    // TwigParser.g:85:1: twig_include : INCLUDE ( include_ternary | include_statement ) ;
    public final TwigParser.twig_include_return twig_include() throws RecognitionException {
        TwigParser.twig_include_return retval = new TwigParser.twig_include_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken INCLUDE23=null;
        TwigParser.include_ternary_return include_ternary24 = null;

        TwigParser.include_statement_return include_statement25 = null;


        TwigCommonTree INCLUDE23_tree=null;

        try {
            // TwigParser.g:86:3: ( INCLUDE ( include_ternary | include_statement ) )
            // TwigParser.g:86:5: INCLUDE ( include_ternary | include_statement )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            INCLUDE23=(CommonToken)match(input,INCLUDE,FOLLOW_INCLUDE_in_twig_include215); 
            INCLUDE23_tree = (TwigCommonTree)adaptor.create(INCLUDE23);
            adaptor.addChild(root_0, INCLUDE23_tree);

            // TwigParser.g:86:13: ( include_ternary | include_statement )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==STRING_LITERAL) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==QM) ) {
                    alt7=1;
                }
                else if ( (LA7_1==CTRL_CLOSE||(LA7_1>=WITH && LA7_1<=ONLY)) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==NUMBER||LA7_0==STRING) ) {
                alt7=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // TwigParser.g:86:14: include_ternary
                    {
                    pushFollow(FOLLOW_include_ternary_in_twig_include218);
                    include_ternary24=include_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, include_ternary24.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:86:32: include_statement
                    {
                    pushFollow(FOLLOW_include_statement_in_twig_include222);
                    include_statement25=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement25.getTree());

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
    // TwigParser.g:89:1: include_ternary : twig_ternary ( ONLY )? ;
    public final TwigParser.include_ternary_return include_ternary() throws RecognitionException {
        TwigParser.include_ternary_return retval = new TwigParser.include_ternary_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ONLY27=null;
        TwigParser.twig_ternary_return twig_ternary26 = null;


        TwigCommonTree ONLY27_tree=null;

        try {
            // TwigParser.g:90:3: ( twig_ternary ( ONLY )? )
            // TwigParser.g:90:5: twig_ternary ( ONLY )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_ternary_in_include_ternary238);
            twig_ternary26=twig_ternary();

            state._fsp--;

            adaptor.addChild(root_0, twig_ternary26.getTree());
            // TwigParser.g:90:18: ( ONLY )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ONLY) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // TwigParser.g:90:18: ONLY
                    {
                    ONLY27=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_ternary240); 
                    ONLY27_tree = (TwigCommonTree)adaptor.create(ONLY27);
                    adaptor.addChild(root_0, ONLY27_tree);


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
    // TwigParser.g:93:1: include_statement : ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )? )? ;
    public final TwigParser.include_statement_return include_statement() throws RecognitionException {
        TwigParser.include_statement_return retval = new TwigParser.include_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL28=null;
        CommonToken ONLY29=null;
        CommonToken WITH30=null;
        CommonToken STRING_LITERAL32=null;
        CommonToken ONLY35=null;
        TwigParser.variable_return variable31 = null;

        TwigParser.method_return method33 = null;

        TwigParser.json_return json34 = null;


        TwigCommonTree STRING_LITERAL28_tree=null;
        TwigCommonTree ONLY29_tree=null;
        TwigCommonTree WITH30_tree=null;
        TwigCommonTree STRING_LITERAL32_tree=null;
        TwigCommonTree ONLY35_tree=null;

        try {
            // TwigParser.g:94:3: ( ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )? )? )
            // TwigParser.g:94:5: ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )? )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:94:5: ( STRING_LITERAL )
            // TwigParser.g:94:6: STRING_LITERAL
            {
            STRING_LITERAL28=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement257); 
            STRING_LITERAL28_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL28);
            adaptor.addChild(root_0, STRING_LITERAL28_tree);


            }

            // TwigParser.g:94:22: ( ONLY )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ONLY) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // TwigParser.g:94:22: ONLY
                    {
                    ONLY29=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement260); 
                    ONLY29_tree = (TwigCommonTree)adaptor.create(ONLY29);
                    adaptor.addChild(root_0, ONLY29_tree);


                    }
                    break;

            }

            // TwigParser.g:94:28: ( WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==WITH) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // TwigParser.g:94:29: WITH ( variable | STRING_LITERAL | method | json ) ( ONLY )?
                    {
                    WITH30=(CommonToken)match(input,WITH,FOLLOW_WITH_in_include_statement264); 
                    WITH30_tree = (TwigCommonTree)adaptor.create(WITH30);
                    adaptor.addChild(root_0, WITH30_tree);

                    // TwigParser.g:94:34: ( variable | STRING_LITERAL | method | json )
                    int alt10=4;
                    alt10 = dfa10.predict(input);
                    switch (alt10) {
                        case 1 :
                            // TwigParser.g:94:35: variable
                            {
                            pushFollow(FOLLOW_variable_in_include_statement267);
                            variable31=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable31.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:94:46: STRING_LITERAL
                            {
                            STRING_LITERAL32=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement271); 
                            STRING_LITERAL32_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL32);
                            adaptor.addChild(root_0, STRING_LITERAL32_tree);


                            }
                            break;
                        case 3 :
                            // TwigParser.g:94:63: method
                            {
                            pushFollow(FOLLOW_method_in_include_statement275);
                            method33=method();

                            state._fsp--;

                            adaptor.addChild(root_0, method33.getTree());

                            }
                            break;
                        case 4 :
                            // TwigParser.g:94:72: json
                            {
                            pushFollow(FOLLOW_json_in_include_statement279);
                            json34=json();

                            state._fsp--;

                            adaptor.addChild(root_0, json34.getTree());

                            }
                            break;

                    }

                    // TwigParser.g:94:78: ( ONLY )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==ONLY) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // TwigParser.g:94:78: ONLY
                            {
                            ONLY35=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement282); 
                            ONLY35_tree = (TwigCommonTree)adaptor.create(ONLY35);
                            adaptor.addChild(root_0, ONLY35_tree);


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
    // TwigParser.g:97:1: twig_set : ( ( SET twig_assignment ( COMMA twig_assignment )* ) | ENDSET );
    public final TwigParser.twig_set_return twig_set() throws RecognitionException {
        TwigParser.twig_set_return retval = new TwigParser.twig_set_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken SET36=null;
        CommonToken COMMA38=null;
        CommonToken ENDSET40=null;
        TwigParser.twig_assignment_return twig_assignment37 = null;

        TwigParser.twig_assignment_return twig_assignment39 = null;


        TwigCommonTree SET36_tree=null;
        TwigCommonTree COMMA38_tree=null;
        TwigCommonTree ENDSET40_tree=null;

        try {
            // TwigParser.g:98:3: ( ( SET twig_assignment ( COMMA twig_assignment )* ) | ENDSET )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==SET) ) {
                alt14=1;
            }
            else if ( (LA14_0==ENDSET) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // TwigParser.g:98:5: ( SET twig_assignment ( COMMA twig_assignment )* )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:98:5: ( SET twig_assignment ( COMMA twig_assignment )* )
                    // TwigParser.g:98:6: SET twig_assignment ( COMMA twig_assignment )*
                    {
                    SET36=(CommonToken)match(input,SET,FOLLOW_SET_in_twig_set301); 
                    SET36_tree = (TwigCommonTree)adaptor.create(SET36);
                    adaptor.addChild(root_0, SET36_tree);

                    pushFollow(FOLLOW_twig_assignment_in_twig_set303);
                    twig_assignment37=twig_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_assignment37.getTree());
                    // TwigParser.g:98:26: ( COMMA twig_assignment )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // TwigParser.g:98:27: COMMA twig_assignment
                    	    {
                    	    COMMA38=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_set306); 
                    	    COMMA38_tree = (TwigCommonTree)adaptor.create(COMMA38);
                    	    adaptor.addChild(root_0, COMMA38_tree);

                    	    pushFollow(FOLLOW_twig_assignment_in_twig_set308);
                    	    twig_assignment39=twig_assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, twig_assignment39.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:98:54: ENDSET
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDSET40=(CommonToken)match(input,ENDSET,FOLLOW_ENDSET_in_twig_set315); 
                    ENDSET40_tree = (TwigCommonTree)adaptor.create(ENDSET40);
                    adaptor.addChild(root_0, ENDSET40_tree);


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
    // TwigParser.g:101:1: twig_assignment : twig_left_assignment ( ASIG twig_right_assignment )? ;
    public final TwigParser.twig_assignment_return twig_assignment() throws RecognitionException {
        TwigParser.twig_assignment_return retval = new TwigParser.twig_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ASIG42=null;
        TwigParser.twig_left_assignment_return twig_left_assignment41 = null;

        TwigParser.twig_right_assignment_return twig_right_assignment43 = null;


        TwigCommonTree ASIG42_tree=null;

        try {
            // TwigParser.g:102:3: ( twig_left_assignment ( ASIG twig_right_assignment )? )
            // TwigParser.g:102:6: twig_left_assignment ( ASIG twig_right_assignment )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_left_assignment_in_twig_assignment330);
            twig_left_assignment41=twig_left_assignment();

            state._fsp--;

            adaptor.addChild(root_0, twig_left_assignment41.getTree());
            // TwigParser.g:102:27: ( ASIG twig_right_assignment )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ASIG) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // TwigParser.g:102:28: ASIG twig_right_assignment
                    {
                    ASIG42=(CommonToken)match(input,ASIG,FOLLOW_ASIG_in_twig_assignment333); 
                    ASIG42_tree = (TwigCommonTree)adaptor.create(ASIG42);
                    adaptor.addChild(root_0, ASIG42_tree);

                    pushFollow(FOLLOW_twig_right_assignment_in_twig_assignment335);
                    twig_right_assignment43=twig_right_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_right_assignment43.getTree());

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
    // TwigParser.g:105:1: twig_left_assignment : ( variable ( COMMA variable )* ) ;
    public final TwigParser.twig_left_assignment_return twig_left_assignment() throws RecognitionException {
        TwigParser.twig_left_assignment_return retval = new TwigParser.twig_left_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA45=null;
        TwigParser.variable_return variable44 = null;

        TwigParser.variable_return variable46 = null;


        TwigCommonTree COMMA45_tree=null;

        try {
            // TwigParser.g:106:3: ( ( variable ( COMMA variable )* ) )
            // TwigParser.g:106:5: ( variable ( COMMA variable )* )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:106:5: ( variable ( COMMA variable )* )
            // TwigParser.g:106:6: variable ( COMMA variable )*
            {
            pushFollow(FOLLOW_variable_in_twig_left_assignment353);
            variable44=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable44.getTree());
            // TwigParser.g:106:15: ( COMMA variable )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==COMMA) ) {
                    int LA16_2 = input.LA(2);

                    if ( (LA16_2==STRING) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // TwigParser.g:106:16: COMMA variable
            	    {
            	    COMMA45=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_left_assignment356); 
            	    COMMA45_tree = (TwigCommonTree)adaptor.create(COMMA45);
            	    adaptor.addChild(root_0, COMMA45_tree);

            	    pushFollow(FOLLOW_variable_in_twig_left_assignment358);
            	    variable46=variable();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable46.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // TwigParser.g:109:1: twig_right_assignment : ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) )* ;
    public final TwigParser.twig_right_assignment_return twig_right_assignment() throws RecognitionException {
        TwigParser.twig_right_assignment_return retval = new TwigParser.twig_right_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL47=null;
        CommonToken COMMA53=null;
        CommonToken STRING_LITERAL54=null;
        TwigParser.variable_return variable48 = null;

        TwigParser.method_return method49 = null;

        TwigParser.array_return array50 = null;

        TwigParser.json_return json51 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument52 = null;

        TwigParser.variable_return variable55 = null;

        TwigParser.method_return method56 = null;

        TwigParser.array_return array57 = null;

        TwigParser.json_return json58 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument59 = null;


        TwigCommonTree STRING_LITERAL47_tree=null;
        TwigCommonTree COMMA53_tree=null;
        TwigCommonTree STRING_LITERAL54_tree=null;

        try {
            // TwigParser.g:110:3: ( ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) )* )
            // TwigParser.g:110:5: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:110:5: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )
            int alt17=6;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // TwigParser.g:110:6: STRING_LITERAL
                    {
                    STRING_LITERAL47=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment377); 
                    STRING_LITERAL47_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL47);
                    adaptor.addChild(root_0, STRING_LITERAL47_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:110:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_right_assignment381);
                    variable48=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable48.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:110:34: method
                    {
                    pushFollow(FOLLOW_method_in_twig_right_assignment385);
                    method49=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method49.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:110:43: array
                    {
                    pushFollow(FOLLOW_array_in_twig_right_assignment389);
                    array50=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array50.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:110:51: json
                    {
                    pushFollow(FOLLOW_json_in_twig_right_assignment393);
                    json51=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json51.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:110:58: twig_tilde_argument
                    {
                    pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment397);
                    twig_tilde_argument52=twig_tilde_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_tilde_argument52.getTree());

                    }
                    break;

            }

            // TwigParser.g:110:79: ( COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1==ARRAY_START||LA19_1==JSON_START||LA19_1==STRING||LA19_1==STRING_LITERAL) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // TwigParser.g:110:80: COMMA ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )
            	    {
            	    COMMA53=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_right_assignment401); 
            	    COMMA53_tree = (TwigCommonTree)adaptor.create(COMMA53);
            	    adaptor.addChild(root_0, COMMA53_tree);

            	    // TwigParser.g:110:86: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )
            	    int alt18=6;
            	    alt18 = dfa18.predict(input);
            	    switch (alt18) {
            	        case 1 :
            	            // TwigParser.g:110:87: STRING_LITERAL
            	            {
            	            STRING_LITERAL54=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment404); 
            	            STRING_LITERAL54_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL54);
            	            adaptor.addChild(root_0, STRING_LITERAL54_tree);


            	            }
            	            break;
            	        case 2 :
            	            // TwigParser.g:110:104: variable
            	            {
            	            pushFollow(FOLLOW_variable_in_twig_right_assignment408);
            	            variable55=variable();

            	            state._fsp--;

            	            adaptor.addChild(root_0, variable55.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // TwigParser.g:110:115: method
            	            {
            	            pushFollow(FOLLOW_method_in_twig_right_assignment412);
            	            method56=method();

            	            state._fsp--;

            	            adaptor.addChild(root_0, method56.getTree());

            	            }
            	            break;
            	        case 4 :
            	            // TwigParser.g:110:124: array
            	            {
            	            pushFollow(FOLLOW_array_in_twig_right_assignment416);
            	            array57=array();

            	            state._fsp--;

            	            adaptor.addChild(root_0, array57.getTree());

            	            }
            	            break;
            	        case 5 :
            	            // TwigParser.g:110:132: json
            	            {
            	            pushFollow(FOLLOW_json_in_twig_right_assignment420);
            	            json58=json();

            	            state._fsp--;

            	            adaptor.addChild(root_0, json58.getTree());

            	            }
            	            break;
            	        case 6 :
            	            // TwigParser.g:110:139: twig_tilde_argument
            	            {
            	            pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment424);
            	            twig_tilde_argument59=twig_tilde_argument();

            	            state._fsp--;

            	            adaptor.addChild(root_0, twig_tilde_argument59.getTree());

            	            }
            	            break;

            	    }


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
    // $ANTLR end "twig_right_assignment"

    public static class twig_tilde_argument_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_tilde_argument"
    // TwigParser.g:113:1: twig_tilde_argument : ( STRING_LITERAL | variable | method | array | json ) TILDE ( STRING_LITERAL | variable | method | array | json ) ;
    public final TwigParser.twig_tilde_argument_return twig_tilde_argument() throws RecognitionException {
        TwigParser.twig_tilde_argument_return retval = new TwigParser.twig_tilde_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL60=null;
        CommonToken TILDE65=null;
        CommonToken STRING_LITERAL66=null;
        TwigParser.variable_return variable61 = null;

        TwigParser.method_return method62 = null;

        TwigParser.array_return array63 = null;

        TwigParser.json_return json64 = null;

        TwigParser.variable_return variable67 = null;

        TwigParser.method_return method68 = null;

        TwigParser.array_return array69 = null;

        TwigParser.json_return json70 = null;


        TwigCommonTree STRING_LITERAL60_tree=null;
        TwigCommonTree TILDE65_tree=null;
        TwigCommonTree STRING_LITERAL66_tree=null;

        try {
            // TwigParser.g:114:3: ( ( STRING_LITERAL | variable | method | array | json ) TILDE ( STRING_LITERAL | variable | method | array | json ) )
            // TwigParser.g:114:5: ( STRING_LITERAL | variable | method | array | json ) TILDE ( STRING_LITERAL | variable | method | array | json )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:114:5: ( STRING_LITERAL | variable | method | array | json )
            int alt20=5;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // TwigParser.g:114:6: STRING_LITERAL
                    {
                    STRING_LITERAL60=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument443); 
                    STRING_LITERAL60_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL60);
                    adaptor.addChild(root_0, STRING_LITERAL60_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:114:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument447);
                    variable61=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable61.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:114:34: method
                    {
                    pushFollow(FOLLOW_method_in_twig_tilde_argument451);
                    method62=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method62.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:114:43: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument455);
                    array63=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array63.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:114:51: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument459);
                    json64=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json64.getTree());

                    }
                    break;

            }

            TILDE65=(CommonToken)match(input,TILDE,FOLLOW_TILDE_in_twig_tilde_argument462); 
            TILDE65_tree = (TwigCommonTree)adaptor.create(TILDE65);
            adaptor.addChild(root_0, TILDE65_tree);

            // TwigParser.g:114:63: ( STRING_LITERAL | variable | method | array | json )
            int alt21=5;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // TwigParser.g:114:64: STRING_LITERAL
                    {
                    STRING_LITERAL66=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument465); 
                    STRING_LITERAL66_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL66);
                    adaptor.addChild(root_0, STRING_LITERAL66_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:114:81: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument469);
                    variable67=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable67.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:114:92: method
                    {
                    pushFollow(FOLLOW_method_in_twig_tilde_argument473);
                    method68=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method68.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:114:101: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument477);
                    array69=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array69.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:114:109: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument481);
                    json70=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json70.getTree());

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
    // TwigParser.g:117:1: twig_import : ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )? ;
    public final TwigParser.twig_import_return twig_import() throws RecognitionException {
        TwigParser.twig_import_return retval = new TwigParser.twig_import_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken FROM71=null;
        CommonToken STRING_LITERAL72=null;
        CommonToken IMPORT73=null;
        CommonToken STRING_LITERAL74=null;
        CommonToken TWIG_AS76=null;
        CommonToken STRING77=null;
        CommonToken COMMA78=null;
        CommonToken STRING79=null;
        TwigParser.variable_return variable75 = null;


        TwigCommonTree FROM71_tree=null;
        TwigCommonTree STRING_LITERAL72_tree=null;
        TwigCommonTree IMPORT73_tree=null;
        TwigCommonTree STRING_LITERAL74_tree=null;
        TwigCommonTree TWIG_AS76_tree=null;
        TwigCommonTree STRING77_tree=null;
        TwigCommonTree COMMA78_tree=null;
        TwigCommonTree STRING79_tree=null;

        try {
            // TwigParser.g:118:3: ( ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )? )
            // TwigParser.g:118:5: ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:118:5: ( FROM ( STRING_LITERAL ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FROM) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // TwigParser.g:118:6: FROM ( STRING_LITERAL )
                    {
                    FROM71=(CommonToken)match(input,FROM,FOLLOW_FROM_in_twig_import498); 
                    FROM71_tree = (TwigCommonTree)adaptor.create(FROM71);
                    adaptor.addChild(root_0, FROM71_tree);

                    // TwigParser.g:118:11: ( STRING_LITERAL )
                    // TwigParser.g:118:12: STRING_LITERAL
                    {
                    STRING_LITERAL72=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import501); 
                    STRING_LITERAL72_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL72);
                    adaptor.addChild(root_0, STRING_LITERAL72_tree);


                    }


                    }
                    break;

            }

            IMPORT73=(CommonToken)match(input,IMPORT,FOLLOW_IMPORT_in_twig_import506); 
            IMPORT73_tree = (TwigCommonTree)adaptor.create(IMPORT73);
            adaptor.addChild(root_0, IMPORT73_tree);

            // TwigParser.g:118:37: ( STRING_LITERAL | variable )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==STRING_LITERAL) ) {
                alt23=1;
            }
            else if ( (LA23_0==STRING) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // TwigParser.g:118:38: STRING_LITERAL
                    {
                    STRING_LITERAL74=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import509); 
                    STRING_LITERAL74_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL74);
                    adaptor.addChild(root_0, STRING_LITERAL74_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:118:55: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_import513);
                    variable75=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable75.getTree());

                    }
                    break;

            }

            // TwigParser.g:118:65: ( TWIG_AS ( STRING ( COMMA STRING )* ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==TWIG_AS) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // TwigParser.g:118:66: TWIG_AS ( STRING ( COMMA STRING )* )
                    {
                    TWIG_AS76=(CommonToken)match(input,TWIG_AS,FOLLOW_TWIG_AS_in_twig_import517); 
                    TWIG_AS76_tree = (TwigCommonTree)adaptor.create(TWIG_AS76);
                    adaptor.addChild(root_0, TWIG_AS76_tree);

                    // TwigParser.g:118:74: ( STRING ( COMMA STRING )* )
                    // TwigParser.g:118:75: STRING ( COMMA STRING )*
                    {
                    STRING77=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import520); 
                    STRING77_tree = (TwigCommonTree)adaptor.create(STRING77);
                    adaptor.addChild(root_0, STRING77_tree);

                    // TwigParser.g:118:82: ( COMMA STRING )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==COMMA) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // TwigParser.g:118:83: COMMA STRING
                    	    {
                    	    COMMA78=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_import523); 
                    	    COMMA78_tree = (TwigCommonTree)adaptor.create(COMMA78);
                    	    adaptor.addChild(root_0, COMMA78_tree);

                    	    STRING79=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import525); 
                    	    STRING79_tree = (TwigCommonTree)adaptor.create(STRING79);
                    	    adaptor.addChild(root_0, STRING79_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
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
    // TwigParser.g:121:1: twig_macro : ( ( MACRO ( variable | method ) ) | ENDMACRO );
    public final TwigParser.twig_macro_return twig_macro() throws RecognitionException {
        TwigParser.twig_macro_return retval = new TwigParser.twig_macro_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken MACRO80=null;
        CommonToken ENDMACRO83=null;
        TwigParser.variable_return variable81 = null;

        TwigParser.method_return method82 = null;


        TwigCommonTree MACRO80_tree=null;
        TwigCommonTree ENDMACRO83_tree=null;

        try {
            // TwigParser.g:122:3: ( ( MACRO ( variable | method ) ) | ENDMACRO )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==MACRO) ) {
                alt27=1;
            }
            else if ( (LA27_0==ENDMACRO) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // TwigParser.g:122:5: ( MACRO ( variable | method ) )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:122:5: ( MACRO ( variable | method ) )
                    // TwigParser.g:122:6: MACRO ( variable | method )
                    {
                    MACRO80=(CommonToken)match(input,MACRO,FOLLOW_MACRO_in_twig_macro547); 
                    MACRO80_tree = (TwigCommonTree)adaptor.create(MACRO80);
                    adaptor.addChild(root_0, MACRO80_tree);

                    // TwigParser.g:122:12: ( variable | method )
                    int alt26=2;
                    alt26 = dfa26.predict(input);
                    switch (alt26) {
                        case 1 :
                            // TwigParser.g:122:13: variable
                            {
                            pushFollow(FOLLOW_variable_in_twig_macro550);
                            variable81=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable81.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:122:24: method
                            {
                            pushFollow(FOLLOW_method_in_twig_macro554);
                            method82=method();

                            state._fsp--;

                            adaptor.addChild(root_0, method82.getTree());

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:122:35: ENDMACRO
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDMACRO83=(CommonToken)match(input,ENDMACRO,FOLLOW_ENDMACRO_in_twig_macro560); 
                    ENDMACRO83_tree = (TwigCommonTree)adaptor.create(ENDMACRO83);
                    adaptor.addChild(root_0, ENDMACRO83_tree);


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
    // TwigParser.g:125:1: twig_if : ( IF variable | method );
    public final TwigParser.twig_if_return twig_if() throws RecognitionException {
        TwigParser.twig_if_return retval = new TwigParser.twig_if_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken IF84=null;
        TwigParser.variable_return variable85 = null;

        TwigParser.method_return method86 = null;


        TwigCommonTree IF84_tree=null;

        try {
            // TwigParser.g:126:3: ( IF variable | method )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==IF) ) {
                alt28=1;
            }
            else if ( (LA28_0==STRING) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // TwigParser.g:126:5: IF variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    IF84=(CommonToken)match(input,IF,FOLLOW_IF_in_twig_if575); 
                    IF84_tree = (TwigCommonTree)adaptor.create(IF84);
                    adaptor.addChild(root_0, IF84_tree);

                    pushFollow(FOLLOW_variable_in_twig_if577);
                    variable85=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable85.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:126:19: method
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_in_twig_if581);
                    method86=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method86.getTree());

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
    // TwigParser.g:129:1: twig_elseif : ELSEIF ( variable | method ) ;
    public final TwigParser.twig_elseif_return twig_elseif() throws RecognitionException {
        TwigParser.twig_elseif_return retval = new TwigParser.twig_elseif_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ELSEIF87=null;
        TwigParser.variable_return variable88 = null;

        TwigParser.method_return method89 = null;


        TwigCommonTree ELSEIF87_tree=null;

        try {
            // TwigParser.g:130:3: ( ELSEIF ( variable | method ) )
            // TwigParser.g:130:5: ELSEIF ( variable | method )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ELSEIF87=(CommonToken)match(input,ELSEIF,FOLLOW_ELSEIF_in_twig_elseif596); 
            ELSEIF87_tree = (TwigCommonTree)adaptor.create(ELSEIF87);
            adaptor.addChild(root_0, ELSEIF87_tree);

            // TwigParser.g:130:12: ( variable | method )
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // TwigParser.g:130:13: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_elseif599);
                    variable88=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable88.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:130:24: method
                    {
                    pushFollow(FOLLOW_method_in_twig_elseif603);
                    method89=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method89.getTree());

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
    // TwigParser.g:133:1: twig_for : FOR STRING IN for_arguments ;
    public final TwigParser.twig_for_return twig_for() throws RecognitionException {
        TwigParser.twig_for_return retval = new TwigParser.twig_for_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken FOR90=null;
        CommonToken STRING91=null;
        CommonToken IN92=null;
        TwigParser.for_arguments_return for_arguments93 = null;


        TwigCommonTree FOR90_tree=null;
        TwigCommonTree STRING91_tree=null;
        TwigCommonTree IN92_tree=null;

        try {
            // TwigParser.g:134:3: ( FOR STRING IN for_arguments )
            // TwigParser.g:134:5: FOR STRING IN for_arguments
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            FOR90=(CommonToken)match(input,FOR,FOLLOW_FOR_in_twig_for619); 
            FOR90_tree = (TwigCommonTree)adaptor.create(FOR90);
            adaptor.addChild(root_0, FOR90_tree);

            STRING91=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_for621); 
            STRING91_tree = (TwigCommonTree)adaptor.create(STRING91);
            adaptor.addChild(root_0, STRING91_tree);

            IN92=(CommonToken)match(input,IN,FOLLOW_IN_in_twig_for623); 
            IN92_tree = (TwigCommonTree)adaptor.create(IN92);
            adaptor.addChild(root_0, IN92_tree);

            pushFollow(FOLLOW_for_arguments_in_twig_for625);
            for_arguments93=for_arguments();

            state._fsp--;

            adaptor.addChild(root_0, for_arguments93.getTree());

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
    // TwigParser.g:137:1: for_arguments : for_value ( PIPE for_value )* ;
    public final TwigParser.for_arguments_return for_arguments() throws RecognitionException {
        TwigParser.for_arguments_return retval = new TwigParser.for_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE95=null;
        TwigParser.for_value_return for_value94 = null;

        TwigParser.for_value_return for_value96 = null;


        TwigCommonTree PIPE95_tree=null;

        try {
            // TwigParser.g:138:3: ( for_value ( PIPE for_value )* )
            // TwigParser.g:138:5: for_value ( PIPE for_value )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_for_value_in_for_arguments640);
            for_value94=for_value();

            state._fsp--;

            adaptor.addChild(root_0, for_value94.getTree());
            // TwigParser.g:138:15: ( PIPE for_value )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==PIPE) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // TwigParser.g:138:16: PIPE for_value
            	    {
            	    PIPE95=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_for_arguments643); 
            	    PIPE95_tree = (TwigCommonTree)adaptor.create(PIPE95);
            	    adaptor.addChild(root_0, PIPE95_tree);

            	    pushFollow(FOLLOW_for_value_in_for_arguments645);
            	    for_value96=for_value();

            	    state._fsp--;

            	    adaptor.addChild(root_0, for_value96.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
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
    // TwigParser.g:141:1: for_value : ( STRING | STRING_LITERAL | method | range );
    public final TwigParser.for_value_return for_value() throws RecognitionException {
        TwigParser.for_value_return retval = new TwigParser.for_value_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING97=null;
        CommonToken STRING_LITERAL98=null;
        TwigParser.method_return method99 = null;

        TwigParser.range_return range100 = null;


        TwigCommonTree STRING97_tree=null;
        TwigCommonTree STRING_LITERAL98_tree=null;

        try {
            // TwigParser.g:142:3: ( STRING | STRING_LITERAL | method | range )
            int alt31=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                switch ( input.LA(2) ) {
                case DDOT:
                    {
                    alt31=4;
                    }
                    break;
                case CTRL_CLOSE:
                case PIPE:
                    {
                    alt31=1;
                    }
                    break;
                case METHOD_START:
                case DOT:
                    {
                    alt31=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }

                }
                break;
            case STRING_LITERAL:
                {
                int LA31_2 = input.LA(2);

                if ( (LA31_2==DDOT) ) {
                    alt31=4;
                }
                else if ( (LA31_2==CTRL_CLOSE||LA31_2==PIPE) ) {
                    alt31=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 2, input);

                    throw nvae;
                }
                }
                break;
            case NUMBER:
                {
                alt31=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // TwigParser.g:142:5: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING97=(CommonToken)match(input,STRING,FOLLOW_STRING_in_for_value662); 
                    STRING97_tree = (TwigCommonTree)adaptor.create(STRING97);
                    adaptor.addChild(root_0, STRING97_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:142:14: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL98=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_for_value666); 
                    STRING_LITERAL98_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL98);
                    adaptor.addChild(root_0, STRING_LITERAL98_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:142:31: method
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_in_for_value670);
                    method99=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method99.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:142:40: range
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_range_in_for_value674);
                    range100=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range100.getTree());

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
    // TwigParser.g:145:1: range : ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) ;
    public final TwigParser.range_return range() throws RecognitionException {
        TwigParser.range_return retval = new TwigParser.range_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set101=null;
        CommonToken DDOT102=null;
        CommonToken set103=null;

        TwigCommonTree set101_tree=null;
        TwigCommonTree DDOT102_tree=null;
        TwigCommonTree set103_tree=null;

        try {
            // TwigParser.g:146:3: ( ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) )
            // TwigParser.g:146:5: ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set101=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set101));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            DDOT102=(CommonToken)match(input,DDOT,FOLLOW_DDOT_in_range701); 
            DDOT102_tree = (TwigCommonTree)adaptor.create(DDOT102);
            adaptor.addChild(root_0, DDOT102_tree);

            set103=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set103));
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
    // TwigParser.g:149:1: twig_ternary : ( STRING_LITERAL | NUMBER | variable | method ) QM ( STRING_LITERAL | NUMBER | variable | method ) COLON ( STRING_LITERAL | NUMBER | variable | method ) ;
    public final TwigParser.twig_ternary_return twig_ternary() throws RecognitionException {
        TwigParser.twig_ternary_return retval = new TwigParser.twig_ternary_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL104=null;
        CommonToken NUMBER105=null;
        CommonToken QM108=null;
        CommonToken STRING_LITERAL109=null;
        CommonToken NUMBER110=null;
        CommonToken COLON113=null;
        CommonToken STRING_LITERAL114=null;
        CommonToken NUMBER115=null;
        TwigParser.variable_return variable106 = null;

        TwigParser.method_return method107 = null;

        TwigParser.variable_return variable111 = null;

        TwigParser.method_return method112 = null;

        TwigParser.variable_return variable116 = null;

        TwigParser.method_return method117 = null;


        TwigCommonTree STRING_LITERAL104_tree=null;
        TwigCommonTree NUMBER105_tree=null;
        TwigCommonTree QM108_tree=null;
        TwigCommonTree STRING_LITERAL109_tree=null;
        TwigCommonTree NUMBER110_tree=null;
        TwigCommonTree COLON113_tree=null;
        TwigCommonTree STRING_LITERAL114_tree=null;
        TwigCommonTree NUMBER115_tree=null;

        try {
            // TwigParser.g:150:3: ( ( STRING_LITERAL | NUMBER | variable | method ) QM ( STRING_LITERAL | NUMBER | variable | method ) COLON ( STRING_LITERAL | NUMBER | variable | method ) )
            // TwigParser.g:150:5: ( STRING_LITERAL | NUMBER | variable | method ) QM ( STRING_LITERAL | NUMBER | variable | method ) COLON ( STRING_LITERAL | NUMBER | variable | method )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:150:5: ( STRING_LITERAL | NUMBER | variable | method )
            int alt32=4;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // TwigParser.g:150:6: STRING_LITERAL
                    {
                    STRING_LITERAL104=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary730); 
                    STRING_LITERAL104_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL104);
                    adaptor.addChild(root_0, STRING_LITERAL104_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:150:23: NUMBER
                    {
                    NUMBER105=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary734); 
                    NUMBER105_tree = (TwigCommonTree)adaptor.create(NUMBER105);
                    adaptor.addChild(root_0, NUMBER105_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:150:32: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary738);
                    variable106=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable106.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:150:43: method
                    {
                    pushFollow(FOLLOW_method_in_twig_ternary742);
                    method107=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method107.getTree());

                    }
                    break;

            }

            QM108=(CommonToken)match(input,QM,FOLLOW_QM_in_twig_ternary745); 
            QM108_tree = (TwigCommonTree)adaptor.create(QM108);
            adaptor.addChild(root_0, QM108_tree);

            // TwigParser.g:150:54: ( STRING_LITERAL | NUMBER | variable | method )
            int alt33=4;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // TwigParser.g:150:55: STRING_LITERAL
                    {
                    STRING_LITERAL109=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary748); 
                    STRING_LITERAL109_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL109);
                    adaptor.addChild(root_0, STRING_LITERAL109_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:150:72: NUMBER
                    {
                    NUMBER110=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary752); 
                    NUMBER110_tree = (TwigCommonTree)adaptor.create(NUMBER110);
                    adaptor.addChild(root_0, NUMBER110_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:150:81: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary756);
                    variable111=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable111.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:150:92: method
                    {
                    pushFollow(FOLLOW_method_in_twig_ternary760);
                    method112=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method112.getTree());

                    }
                    break;

            }

            COLON113=(CommonToken)match(input,COLON,FOLLOW_COLON_in_twig_ternary763); 
            COLON113_tree = (TwigCommonTree)adaptor.create(COLON113);
            adaptor.addChild(root_0, COLON113_tree);

            // TwigParser.g:150:106: ( STRING_LITERAL | NUMBER | variable | method )
            int alt34=4;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // TwigParser.g:150:107: STRING_LITERAL
                    {
                    STRING_LITERAL114=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary766); 
                    STRING_LITERAL114_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL114);
                    adaptor.addChild(root_0, STRING_LITERAL114_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:150:124: NUMBER
                    {
                    NUMBER115=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary770); 
                    NUMBER115_tree = (TwigCommonTree)adaptor.create(NUMBER115);
                    adaptor.addChild(root_0, NUMBER115_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:150:133: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary774);
                    variable116=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable116.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:150:144: method
                    {
                    pushFollow(FOLLOW_method_in_twig_ternary778);
                    method117=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method117.getTree());

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
    // TwigParser.g:155:1: twig_print_statement : PRINT_OPEN ( twig_print )? PRINT_CLOSE -> ^( TWIG_PR_STMT ( twig_print )? ) ;
    public final TwigParser.twig_print_statement_return twig_print_statement() throws RecognitionException {
        TwigParser.twig_print_statement_return retval = new TwigParser.twig_print_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PRINT_OPEN118=null;
        CommonToken PRINT_CLOSE120=null;
        TwigParser.twig_print_return twig_print119 = null;


        TwigCommonTree PRINT_OPEN118_tree=null;
        TwigCommonTree PRINT_CLOSE120_tree=null;
        RewriteRuleTokenStream stream_PRINT_OPEN=new RewriteRuleTokenStream(adaptor,"token PRINT_OPEN");
        RewriteRuleTokenStream stream_PRINT_CLOSE=new RewriteRuleTokenStream(adaptor,"token PRINT_CLOSE");
        RewriteRuleSubtreeStream stream_twig_print=new RewriteRuleSubtreeStream(adaptor,"rule twig_print");
        try {
            // TwigParser.g:156:3: ( PRINT_OPEN ( twig_print )? PRINT_CLOSE -> ^( TWIG_PR_STMT ( twig_print )? ) )
            // TwigParser.g:156:6: PRINT_OPEN ( twig_print )? PRINT_CLOSE
            {
            PRINT_OPEN118=(CommonToken)match(input,PRINT_OPEN,FOLLOW_PRINT_OPEN_in_twig_print_statement796);  
            stream_PRINT_OPEN.add(PRINT_OPEN118);

            // TwigParser.g:156:17: ( twig_print )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==ARRAY_START||LA35_0==STRING||LA35_0==STRING_LITERAL) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // TwigParser.g:156:17: twig_print
                    {
                    pushFollow(FOLLOW_twig_print_in_twig_print_statement798);
                    twig_print119=twig_print();

                    state._fsp--;

                    stream_twig_print.add(twig_print119.getTree());

                    }
                    break;

            }

            PRINT_CLOSE120=(CommonToken)match(input,PRINT_CLOSE,FOLLOW_PRINT_CLOSE_in_twig_print_statement801);  
            stream_PRINT_CLOSE.add(PRINT_CLOSE120);



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
            // 157:5: -> ^( TWIG_PR_STMT ( twig_print )? )
            {
                // TwigParser.g:157:7: ^( TWIG_PR_STMT ( twig_print )? )
                {
                TwigCommonTree root_1 = (TwigCommonTree)adaptor.nil();
                root_1 = (TwigCommonTree)adaptor.becomeRoot((TwigCommonTree)adaptor.create(TWIG_PR_STMT, "TWIG_PR_STMT"), root_1);

                // TwigParser.g:157:22: ( twig_print )?
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
    // TwigParser.g:160:1: twig_print : p_input ( PIPE p_input )* ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE122=null;
        TwigParser.p_input_return p_input121 = null;

        TwigParser.p_input_return p_input123 = null;


        TwigCommonTree PIPE122_tree=null;

        try {
            // TwigParser.g:161:3: ( p_input ( PIPE p_input )* )
            // TwigParser.g:161:5: p_input ( PIPE p_input )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_p_input_in_twig_print828);
            p_input121=p_input();

            state._fsp--;

            adaptor.addChild(root_0, p_input121.getTree());
            // TwigParser.g:161:13: ( PIPE p_input )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==PIPE) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // TwigParser.g:161:14: PIPE p_input
            	    {
            	    PIPE122=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_print831); 
            	    PIPE122_tree = (TwigCommonTree)adaptor.create(PIPE122);
            	    adaptor.addChild(root_0, PIPE122_tree);

            	    pushFollow(FOLLOW_p_input_in_twig_print833);
            	    p_input123=p_input();

            	    state._fsp--;

            	    adaptor.addChild(root_0, p_input123.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
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
    // TwigParser.g:164:1: p_input : ( variable | method | array | STRING_LITERAL );
    public final TwigParser.p_input_return p_input() throws RecognitionException {
        TwigParser.p_input_return retval = new TwigParser.p_input_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL127=null;
        TwigParser.variable_return variable124 = null;

        TwigParser.method_return method125 = null;

        TwigParser.array_return array126 = null;


        TwigCommonTree STRING_LITERAL127_tree=null;

        try {
            // TwigParser.g:165:3: ( variable | method | array | STRING_LITERAL )
            int alt37=4;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // TwigParser.g:165:5: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_p_input850);
                    variable124=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable124.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:165:16: method
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_in_p_input854);
                    method125=method();

                    state._fsp--;

                    adaptor.addChild(root_0, method125.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:165:25: array
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_array_in_p_input858);
                    array126=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array126.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:165:33: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL127=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_p_input862); 
                    STRING_LITERAL127_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL127);
                    adaptor.addChild(root_0, STRING_LITERAL127_tree);


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
    // TwigParser.g:169:1: array : ARRAY_START array_elements ARRAY_END ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ARRAY_START128=null;
        CommonToken ARRAY_END130=null;
        TwigParser.array_elements_return array_elements129 = null;


        TwigCommonTree ARRAY_START128_tree=null;
        TwigCommonTree ARRAY_END130_tree=null;

        try {
            // TwigParser.g:170:3: ( ARRAY_START array_elements ARRAY_END )
            // TwigParser.g:170:5: ARRAY_START array_elements ARRAY_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ARRAY_START128=(CommonToken)match(input,ARRAY_START,FOLLOW_ARRAY_START_in_array880); 
            ARRAY_START128_tree = (TwigCommonTree)adaptor.create(ARRAY_START128);
            adaptor.addChild(root_0, ARRAY_START128_tree);

            pushFollow(FOLLOW_array_elements_in_array882);
            array_elements129=array_elements();

            state._fsp--;

            adaptor.addChild(root_0, array_elements129.getTree());
            ARRAY_END130=(CommonToken)match(input,ARRAY_END,FOLLOW_ARRAY_END_in_array884); 
            ARRAY_END130_tree = (TwigCommonTree)adaptor.create(ARRAY_END130);
            adaptor.addChild(root_0, ARRAY_END130_tree);


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
    // TwigParser.g:173:1: array_elements : array_element ( COMMA array_element )* ;
    public final TwigParser.array_elements_return array_elements() throws RecognitionException {
        TwigParser.array_elements_return retval = new TwigParser.array_elements_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA132=null;
        TwigParser.array_element_return array_element131 = null;

        TwigParser.array_element_return array_element133 = null;


        TwigCommonTree COMMA132_tree=null;

        try {
            // TwigParser.g:174:3: ( array_element ( COMMA array_element )* )
            // TwigParser.g:174:5: array_element ( COMMA array_element )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_array_element_in_array_elements899);
            array_element131=array_element();

            state._fsp--;

            adaptor.addChild(root_0, array_element131.getTree());
            // TwigParser.g:174:19: ( COMMA array_element )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==COMMA) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // TwigParser.g:174:20: COMMA array_element
            	    {
            	    COMMA132=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_array_elements902); 
            	    COMMA132_tree = (TwigCommonTree)adaptor.create(COMMA132);
            	    adaptor.addChild(root_0, COMMA132_tree);

            	    pushFollow(FOLLOW_array_element_in_array_elements904);
            	    array_element133=array_element();

            	    state._fsp--;

            	    adaptor.addChild(root_0, array_element133.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
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
    // TwigParser.g:177:1: array_element : ( STRING | STRING_LITERAL | NUMBER | json );
    public final TwigParser.array_element_return array_element() throws RecognitionException {
        TwigParser.array_element_return retval = new TwigParser.array_element_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING134=null;
        CommonToken STRING_LITERAL135=null;
        CommonToken NUMBER136=null;
        TwigParser.json_return json137 = null;


        TwigCommonTree STRING134_tree=null;
        TwigCommonTree STRING_LITERAL135_tree=null;
        TwigCommonTree NUMBER136_tree=null;

        try {
            // TwigParser.g:178:3: ( STRING | STRING_LITERAL | NUMBER | json )
            int alt39=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt39=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt39=2;
                }
                break;
            case NUMBER:
                {
                alt39=3;
                }
                break;
            case JSON_START:
                {
                alt39=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // TwigParser.g:178:5: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING134=(CommonToken)match(input,STRING,FOLLOW_STRING_in_array_element921); 
                    STRING134_tree = (TwigCommonTree)adaptor.create(STRING134);
                    adaptor.addChild(root_0, STRING134_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:178:14: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL135=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_array_element925); 
                    STRING_LITERAL135_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL135);
                    adaptor.addChild(root_0, STRING_LITERAL135_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:178:31: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER136=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_array_element929); 
                    NUMBER136_tree = (TwigCommonTree)adaptor.create(NUMBER136);
                    adaptor.addChild(root_0, NUMBER136_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:178:40: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_array_element933);
                    json137=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json137.getTree());

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
    // TwigParser.g:181:1: variable : param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) ;
    public final TwigParser.variable_return variable() throws RecognitionException {
        TwigParser.variable_return retval = new TwigParser.variable_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;
        CommonToken DOT138=null;
        CommonToken STRING139=null;

        TwigCommonTree param_tree=null;
        TwigCommonTree DOT138_tree=null;
        TwigCommonTree STRING139_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // TwigParser.g:182:3: (param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) )
            // TwigParser.g:182:5: param= STRING ( DOT ( STRING ) )*
            {
            param=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable950);  
            stream_STRING.add(param);

            // TwigParser.g:182:18: ( DOT ( STRING ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==DOT) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // TwigParser.g:182:19: DOT ( STRING )
            	    {
            	    DOT138=(CommonToken)match(input,DOT,FOLLOW_DOT_in_variable953);  
            	    stream_DOT.add(DOT138);

            	    // TwigParser.g:182:23: ( STRING )
            	    // TwigParser.g:182:24: STRING
            	    {
            	    STRING139=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable956);  
            	    stream_STRING.add(STRING139);


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
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
            // 183:5: -> ^( TWIG_VAR $param)
            {
                // TwigParser.g:183:7: ^( TWIG_VAR $param)
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
    // TwigParser.g:186:1: method : variable METHOD_START ( arguments )? METHOD_END ;
    public final TwigParser.method_return method() throws RecognitionException {
        TwigParser.method_return retval = new TwigParser.method_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken METHOD_START141=null;
        CommonToken METHOD_END143=null;
        TwigParser.variable_return variable140 = null;

        TwigParser.arguments_return arguments142 = null;


        TwigCommonTree METHOD_START141_tree=null;
        TwigCommonTree METHOD_END143_tree=null;

        try {
            // TwigParser.g:187:3: ( variable METHOD_START ( arguments )? METHOD_END )
            // TwigParser.g:187:5: variable METHOD_START ( arguments )? METHOD_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_in_method986);
            variable140=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable140.getTree());
            METHOD_START141=(CommonToken)match(input,METHOD_START,FOLLOW_METHOD_START_in_method988); 
            METHOD_START141_tree = (TwigCommonTree)adaptor.create(METHOD_START141);
            adaptor.addChild(root_0, METHOD_START141_tree);

            // TwigParser.g:187:27: ( arguments )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==JSON_START||LA41_0==NUMBER||LA41_0==STRING||LA41_0==STRING_LITERAL) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // TwigParser.g:187:27: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_method990);
                    arguments142=arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, arguments142.getTree());

                    }
                    break;

            }

            METHOD_END143=(CommonToken)match(input,METHOD_END,FOLLOW_METHOD_END_in_method993); 
            METHOD_END143_tree = (TwigCommonTree)adaptor.create(METHOD_END143);
            adaptor.addChild(root_0, METHOD_END143_tree);


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
    // TwigParser.g:190:1: arguments : argument ( COMMA ( argument ) )* ;
    public final TwigParser.arguments_return arguments() throws RecognitionException {
        TwigParser.arguments_return retval = new TwigParser.arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA145=null;
        TwigParser.argument_return argument144 = null;

        TwigParser.argument_return argument146 = null;


        TwigCommonTree COMMA145_tree=null;

        try {
            // TwigParser.g:191:3: ( argument ( COMMA ( argument ) )* )
            // TwigParser.g:191:5: argument ( COMMA ( argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_argument_in_arguments1009);
            argument144=argument();

            state._fsp--;

            adaptor.addChild(root_0, argument144.getTree());
            // TwigParser.g:191:15: ( COMMA ( argument ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==COMMA) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // TwigParser.g:191:16: COMMA ( argument )
            	    {
            	    COMMA145=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_arguments1013); 
            	    COMMA145_tree = (TwigCommonTree)adaptor.create(COMMA145);
            	    adaptor.addChild(root_0, COMMA145_tree);

            	    // TwigParser.g:191:22: ( argument )
            	    // TwigParser.g:191:23: argument
            	    {
            	    pushFollow(FOLLOW_argument_in_arguments1016);
            	    argument146=argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, argument146.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // TwigParser.g:194:1: argument : ( literal_argument | STRING | json | NUMBER );
    public final TwigParser.argument_return argument() throws RecognitionException {
        TwigParser.argument_return retval = new TwigParser.argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING148=null;
        CommonToken NUMBER150=null;
        TwigParser.literal_argument_return literal_argument147 = null;

        TwigParser.json_return json149 = null;


        TwigCommonTree STRING148_tree=null;
        TwigCommonTree NUMBER150_tree=null;

        try {
            // TwigParser.g:195:1: ( literal_argument | STRING | json | NUMBER )
            int alt43=4;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt43=1;
                }
                break;
            case STRING:
                {
                alt43=2;
                }
                break;
            case JSON_START:
                {
                alt43=3;
                }
                break;
            case NUMBER:
                {
                alt43=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // TwigParser.g:195:3: literal_argument
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_argument_in_argument1030);
                    literal_argument147=literal_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, literal_argument147.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:195:22: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING148=(CommonToken)match(input,STRING,FOLLOW_STRING_in_argument1034); 
                    STRING148_tree = (TwigCommonTree)adaptor.create(STRING148);
                    adaptor.addChild(root_0, STRING148_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:195:31: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_argument1038);
                    json149=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json149.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:195:38: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER150=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_argument1042); 
                    NUMBER150_tree = (TwigCommonTree)adaptor.create(NUMBER150);
                    adaptor.addChild(root_0, NUMBER150_tree);


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
    // TwigParser.g:198:1: literal_argument : param= STRING_LITERAL -> ^( LITERAL_ARG $param) ;
    public final TwigParser.literal_argument_return literal_argument() throws RecognitionException {
        TwigParser.literal_argument_return retval = new TwigParser.literal_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;

        TwigCommonTree param_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");

        try {
            // TwigParser.g:199:3: (param= STRING_LITERAL -> ^( LITERAL_ARG $param) )
            // TwigParser.g:199:5: param= STRING_LITERAL
            {
            param=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal_argument1055);  
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
            // 200:5: -> ^( LITERAL_ARG $param)
            {
                // TwigParser.g:200:8: ^( LITERAL_ARG $param)
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
    // TwigParser.g:203:1: json : JSON_START ( json_arguments )? JSON_END ;
    public final TwigParser.json_return json() throws RecognitionException {
        TwigParser.json_return retval = new TwigParser.json_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken JSON_START151=null;
        CommonToken JSON_END153=null;
        TwigParser.json_arguments_return json_arguments152 = null;


        TwigCommonTree JSON_START151_tree=null;
        TwigCommonTree JSON_END153_tree=null;

        try {
            // TwigParser.g:204:3: ( JSON_START ( json_arguments )? JSON_END )
            // TwigParser.g:204:5: JSON_START ( json_arguments )? JSON_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            JSON_START151=(CommonToken)match(input,JSON_START,FOLLOW_JSON_START_in_json1081); 
            JSON_START151_tree = (TwigCommonTree)adaptor.create(JSON_START151);
            adaptor.addChild(root_0, JSON_START151_tree);

            // TwigParser.g:204:16: ( json_arguments )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==STRING||LA44_0==STRING_LITERAL) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // TwigParser.g:204:16: json_arguments
                    {
                    pushFollow(FOLLOW_json_arguments_in_json1083);
                    json_arguments152=json_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, json_arguments152.getTree());

                    }
                    break;

            }

            JSON_END153=(CommonToken)match(input,JSON_END,FOLLOW_JSON_END_in_json1086); 
            JSON_END153_tree = (TwigCommonTree)adaptor.create(JSON_END153);
            adaptor.addChild(root_0, JSON_END153_tree);


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
    // TwigParser.g:207:1: json_arguments : json_argument ( COMMA ( json_argument ) )* ;
    public final TwigParser.json_arguments_return json_arguments() throws RecognitionException {
        TwigParser.json_arguments_return retval = new TwigParser.json_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA155=null;
        TwigParser.json_argument_return json_argument154 = null;

        TwigParser.json_argument_return json_argument156 = null;


        TwigCommonTree COMMA155_tree=null;

        try {
            // TwigParser.g:208:3: ( json_argument ( COMMA ( json_argument ) )* )
            // TwigParser.g:208:5: json_argument ( COMMA ( json_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_json_argument_in_json_arguments1101);
            json_argument154=json_argument();

            state._fsp--;

            adaptor.addChild(root_0, json_argument154.getTree());
            // TwigParser.g:208:19: ( COMMA ( json_argument ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==COMMA) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // TwigParser.g:208:20: COMMA ( json_argument )
            	    {
            	    COMMA155=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_json_arguments1104); 
            	    COMMA155_tree = (TwigCommonTree)adaptor.create(COMMA155);
            	    adaptor.addChild(root_0, COMMA155_tree);

            	    // TwigParser.g:208:26: ( json_argument )
            	    // TwigParser.g:208:27: json_argument
            	    {
            	    pushFollow(FOLLOW_json_argument_in_json_arguments1107);
            	    json_argument156=json_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, json_argument156.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
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
    // TwigParser.g:211:1: json_argument : ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) ;
    public final TwigParser.json_argument_return json_argument() throws RecognitionException {
        TwigParser.json_argument_return retval = new TwigParser.json_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set157=null;
        CommonToken COLON158=null;
        CommonToken set159=null;

        TwigCommonTree set157_tree=null;
        TwigCommonTree COLON158_tree=null;
        TwigCommonTree set159_tree=null;

        try {
            // TwigParser.g:212:3: ( ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) )
            // TwigParser.g:212:5: ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set157=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set157));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // TwigParser.g:212:31: ( COLON )
            // TwigParser.g:212:32: COLON
            {
            COLON158=(CommonToken)match(input,COLON,FOLLOW_COLON_in_json_argument1134); 
            COLON158_tree = (TwigCommonTree)adaptor.create(COLON158);
            adaptor.addChild(root_0, COLON158_tree);


            }

            set159=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set159));
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


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA37 dfa37 = new DFA37(this);
    static final String DFA5_eotS =
        "\6\uffff";
    static final String DFA5_eofS =
        "\6\uffff";
    static final String DFA5_minS =
        "\1\55\1\7\1\55\2\uffff\1\7";
    static final String DFA5_maxS =
        "\1\55\1\57\1\55\2\uffff\1\57";
    static final String DFA5_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA5_specialS =
        "\6\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\3\1\4\1\uffff\1\3\5\uffff\1\2\34\uffff\1\3\1\uffff\1\3",
            "\1\5",
            "",
            "",
            "\1\3\1\4\1\uffff\1\3\5\uffff\1\2\34\uffff\1\3\1\uffff\1\3"
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
            return "82:5: ( variable | method )";
        }
    }
    static final String DFA10_eotS =
        "\10\uffff";
    static final String DFA10_eofS =
        "\10\uffff";
    static final String DFA10_minS =
        "\1\24\1\7\2\uffff\1\55\2\uffff\1\7";
    static final String DFA10_maxS =
        "\1\57\1\51\2\uffff\1\55\2\uffff\1\51";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\4\1\uffff\1\1\1\3\1\uffff";
    static final String DFA10_specialS =
        "\10\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\30\uffff\1\1\1\uffff\1\2",
            "\1\5\1\6\7\uffff\1\4\30\uffff\1\5",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\5\1\6\7\uffff\1\4\30\uffff\1\5"
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
            return "94:34: ( variable | STRING_LITERAL | method | json )";
        }
    }
    static final String DFA17_eotS =
        "\112\uffff";
    static final String DFA17_eofS =
        "\112\uffff";
    static final String DFA17_minS =
        "\1\12\2\7\1\24\1\25\2\uffff\1\55\1\uffff\1\11\3\13\1\25\1\21\2\7"+
        "\2\11\1\25\1\11\1\7\1\24\1\7\1\21\1\13\1\55\1\uffff\1\24\1\21\1"+
        "\11\1\uffff\3\13\1\25\1\uffff\1\55\1\22\2\11\1\25\1\11\1\55\1\21"+
        "\1\13\1\22\1\55\1\21\1\11\1\22\2\55\1\21\2\55\1\22\1\21\1\55\1\22"+
        "\1\21\2\55\1\22\2\55\1\21\1\22\1\21\1\22\2\55\2\22";
    static final String DFA17_maxS =
        "\1\57\2\22\2\57\2\uffff\1\55\1\uffff\1\57\3\22\1\57\1\21\4\22\1"+
        "\57\2\22\1\57\1\22\1\21\1\22\1\57\1\uffff\1\57\1\21\1\22\1\uffff"+
        "\3\22\1\57\1\uffff\1\57\1\25\2\22\1\57\1\22\1\57\1\21\1\22\1\25"+
        "\1\57\1\21\1\22\1\25\2\57\1\21\2\57\1\25\1\21\1\57\1\25\1\21\2\57"+
        "\1\25\2\57\1\21\1\25\1\21\1\25\2\57\2\25";
    static final String DFA17_acceptS =
        "\5\uffff\1\1\1\6\1\uffff\1\2\22\uffff\1\5\3\uffff\1\3\4\uffff\1"+
        "\4\45\uffff";
    static final String DFA17_specialS =
        "\112\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\3\11\uffff\1\4\30\uffff\1\2\1\uffff\1\1",
            "\1\5\5\uffff\1\6\4\uffff\1\5",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\15\26\uffff\1\14\1\uffff\1\12\1\uffff\1\13",
            "\1\17\27\uffff\1\16\1\uffff\1\16",
            "",
            "",
            "\1\20",
            "",
            "\1\25\12\uffff\1\23\26\uffff\1\24\1\uffff\1\22\1\uffff\1\21",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\31\27\uffff\1\30\1\uffff\1\30",
            "\1\32",
            "\1\33\5\uffff\1\6\4\uffff\1\33",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\36\27\uffff\1\35\1\uffff\1\35",
            "\1\25\10\uffff\1\34",
            "\1\37\5\uffff\1\6\4\uffff\1\37",
            "\1\43\26\uffff\1\42\1\uffff\1\40\1\uffff\1\41",
            "\1\44\5\uffff\1\6\4\uffff\1\44",
            "\1\45",
            "\1\27\6\uffff\1\26",
            "\1\46\1\uffff\1\46",
            "",
            "\1\51\26\uffff\1\52\1\uffff\1\50\1\uffff\1\47",
            "\1\53",
            "\1\25\10\uffff\1\34",
            "",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\55\27\uffff\1\54\1\uffff\1\54",
            "",
            "\1\56\1\uffff\1\56",
            "\1\57\2\uffff\1\17",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\61\27\uffff\1\60\1\uffff\1\60",
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
            return "110:5: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )";
        }
    }
    static final String DFA18_eotS =
        "\112\uffff";
    static final String DFA18_eofS =
        "\112\uffff";
    static final String DFA18_minS =
        "\1\12\2\7\1\24\1\25\2\uffff\1\55\1\uffff\1\11\3\13\1\25\1\21\2\7"+
        "\2\11\1\25\1\11\1\7\1\24\1\7\1\21\1\13\1\55\1\uffff\1\24\1\21\1"+
        "\11\1\uffff\3\13\1\25\1\uffff\1\55\1\22\2\11\1\25\1\11\1\55\1\21"+
        "\1\13\1\22\1\55\1\21\1\11\1\22\2\55\1\21\2\55\1\22\1\21\1\55\1\22"+
        "\1\21\2\55\1\22\2\55\1\21\1\22\1\21\1\22\2\55\2\22";
    static final String DFA18_maxS =
        "\1\57\2\22\2\57\2\uffff\1\55\1\uffff\1\57\3\22\1\57\1\21\4\22\1"+
        "\57\2\22\1\57\1\22\1\21\1\22\1\57\1\uffff\1\57\1\21\1\22\1\uffff"+
        "\3\22\1\57\1\uffff\1\57\1\25\2\22\1\57\1\22\1\57\1\21\1\22\1\25"+
        "\1\57\1\21\1\22\1\25\2\57\1\21\2\57\1\25\1\21\1\57\1\25\1\21\2\57"+
        "\1\25\2\57\1\21\1\25\1\21\1\25\2\57\2\25";
    static final String DFA18_acceptS =
        "\5\uffff\1\1\1\6\1\uffff\1\2\22\uffff\1\5\3\uffff\1\3\4\uffff\1"+
        "\4\45\uffff";
    static final String DFA18_specialS =
        "\112\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\3\11\uffff\1\4\30\uffff\1\2\1\uffff\1\1",
            "\1\5\5\uffff\1\6\4\uffff\1\5",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\15\26\uffff\1\14\1\uffff\1\12\1\uffff\1\13",
            "\1\17\27\uffff\1\16\1\uffff\1\16",
            "",
            "",
            "\1\20",
            "",
            "\1\25\12\uffff\1\23\26\uffff\1\24\1\uffff\1\22\1\uffff\1\21",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\31\27\uffff\1\30\1\uffff\1\30",
            "\1\32",
            "\1\33\5\uffff\1\6\4\uffff\1\33",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\36\27\uffff\1\35\1\uffff\1\35",
            "\1\25\10\uffff\1\34",
            "\1\37\5\uffff\1\6\4\uffff\1\37",
            "\1\43\26\uffff\1\42\1\uffff\1\40\1\uffff\1\41",
            "\1\44\5\uffff\1\6\4\uffff\1\44",
            "\1\45",
            "\1\27\6\uffff\1\26",
            "\1\46\1\uffff\1\46",
            "",
            "\1\51\26\uffff\1\52\1\uffff\1\50\1\uffff\1\47",
            "\1\53",
            "\1\25\10\uffff\1\34",
            "",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\55\27\uffff\1\54\1\uffff\1\54",
            "",
            "\1\56\1\uffff\1\56",
            "\1\57\2\uffff\1\17",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\61\27\uffff\1\60\1\uffff\1\60",
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
            return "110:86: ( STRING_LITERAL | variable | method | array | json | twig_tilde_argument )";
        }
    }
    static final String DFA20_eotS =
        "\11\uffff";
    static final String DFA20_eofS =
        "\11\uffff";
    static final String DFA20_minS =
        "\1\12\1\uffff\1\10\2\uffff\1\55\2\uffff\1\10";
    static final String DFA20_maxS =
        "\1\57\1\uffff\1\20\2\uffff\1\55\2\uffff\1\20";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\2\1\3\1\uffff";
    static final String DFA20_specialS =
        "\11\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\11\uffff\1\4\30\uffff\1\2\1\uffff\1\1",
            "",
            "\1\7\4\uffff\1\6\2\uffff\1\5",
            "",
            "",
            "\1\10",
            "",
            "",
            "\1\7\4\uffff\1\6\2\uffff\1\5"
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "114:5: ( STRING_LITERAL | variable | method | array | json )";
        }
    }
    static final String DFA21_eotS =
        "\11\uffff";
    static final String DFA21_eofS =
        "\11\uffff";
    static final String DFA21_minS =
        "\1\12\1\uffff\1\7\2\uffff\1\55\2\uffff\1\7";
    static final String DFA21_maxS =
        "\1\57\1\uffff\1\22\2\uffff\1\55\2\uffff\1\22";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\2\1\3\1\uffff";
    static final String DFA21_specialS =
        "\11\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\11\uffff\1\4\30\uffff\1\2\1\uffff\1\1",
            "",
            "\1\6\1\7\7\uffff\1\5\1\uffff\1\6",
            "",
            "",
            "\1\10",
            "",
            "",
            "\1\6\1\7\7\uffff\1\5\1\uffff\1\6"
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "114:63: ( STRING_LITERAL | variable | method | array | json )";
        }
    }
    static final String DFA26_eotS =
        "\6\uffff";
    static final String DFA26_eofS =
        "\6\uffff";
    static final String DFA26_minS =
        "\1\55\1\7\1\55\2\uffff\1\7";
    static final String DFA26_maxS =
        "\1\55\1\20\1\55\2\uffff\1\20";
    static final String DFA26_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA26_specialS =
        "\6\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1",
            "\1\3\1\4\7\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\3\1\4\7\uffff\1\2"
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "122:12: ( variable | method )";
        }
    }
    static final String DFA29_eotS =
        "\6\uffff";
    static final String DFA29_eofS =
        "\6\uffff";
    static final String DFA29_minS =
        "\1\55\1\7\1\55\2\uffff\1\7";
    static final String DFA29_maxS =
        "\1\55\1\20\1\55\2\uffff\1\20";
    static final String DFA29_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA29_specialS =
        "\6\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1",
            "\1\3\1\4\7\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\3\1\4\7\uffff\1\2"
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
            return "130:12: ( variable | method )";
        }
    }
    static final String DFA32_eotS =
        "\10\uffff";
    static final String DFA32_eofS =
        "\10\uffff";
    static final String DFA32_minS =
        "\1\53\2\uffff\1\10\1\55\2\uffff\1\10";
    static final String DFA32_maxS =
        "\1\57\2\uffff\1\26\1\55\2\uffff\1\26";
    static final String DFA32_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA32_specialS =
        "\10\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\6\7\uffff\1\4\5\uffff\1\5",
            "\1\7",
            "",
            "",
            "\1\6\7\uffff\1\4\5\uffff\1\5"
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
            return "150:5: ( STRING_LITERAL | NUMBER | variable | method )";
        }
    }
    static final String DFA33_eotS =
        "\10\uffff";
    static final String DFA33_eofS =
        "\10\uffff";
    static final String DFA33_minS =
        "\1\53\2\uffff\1\10\1\55\2\uffff\1\10";
    static final String DFA33_maxS =
        "\1\57\2\uffff\1\21\1\55\2\uffff\1\21";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA33_specialS =
        "\10\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\6\7\uffff\1\4\1\5",
            "\1\7",
            "",
            "",
            "\1\6\7\uffff\1\4\1\5"
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "150:54: ( STRING_LITERAL | NUMBER | variable | method )";
        }
    }
    static final String DFA34_eotS =
        "\10\uffff";
    static final String DFA34_eofS =
        "\10\uffff";
    static final String DFA34_minS =
        "\1\53\2\uffff\1\7\1\55\2\uffff\1\7";
    static final String DFA34_maxS =
        "\1\57\2\uffff\1\51\1\55\2\uffff\1\51";
    static final String DFA34_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA34_specialS =
        "\10\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\5\1\6\7\uffff\1\4\30\uffff\1\5",
            "\1\7",
            "",
            "",
            "\1\5\1\6\7\uffff\1\4\30\uffff\1\5"
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "150:106: ( STRING_LITERAL | NUMBER | variable | method )";
        }
    }
    static final String DFA37_eotS =
        "\10\uffff";
    static final String DFA37_eofS =
        "\10\uffff";
    static final String DFA37_minS =
        "\1\12\1\5\2\uffff\1\55\2\uffff\1\5";
    static final String DFA37_maxS =
        "\1\57\1\20\2\uffff\1\55\2\uffff\1\20";
    static final String DFA37_acceptS =
        "\2\uffff\1\3\1\4\1\uffff\1\1\1\2\1\uffff";
    static final String DFA37_specialS =
        "\10\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\2\42\uffff\1\1\1\uffff\1\3",
            "\1\5\1\uffff\1\5\1\6\5\uffff\1\5\1\uffff\1\4",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\5\1\uffff\1\5\1\6\5\uffff\1\5\1\uffff\1\4"
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "164:1: p_input : ( variable | method | array | STRING_LITERAL );";
        }
    }
 

    public static final BitSet FOLLOW_twig_print_statement_in_twig_source69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_control_statement_in_twig_source73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTRL_OPEN_in_twig_control_statement89 = new BitSet(new long[]{0x000020FE7F800080L});
    public static final BitSet FOLLOW_twig_control_in_twig_control_statement91 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CTRL_CLOSE_in_twig_control_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_for_in_twig_control108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDFOR_in_twig_control112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_twig_control116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_if_in_twig_control120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_elseif_in_twig_control124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDIF_in_twig_control128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_macro_in_twig_control132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_import_in_twig_control136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_set_in_twig_control140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_include_in_twig_control144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_block_in_twig_control148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_twig_block167 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_twig_block_param_in_twig_block169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDBLOCK_in_twig_block175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_block_param192 = new BitSet(new long[]{0x0000A00010000402L});
    public static final BitSet FOLLOW_method_in_twig_block_param196 = new BitSet(new long[]{0x0000A00010000402L});
    public static final BitSet FOLLOW_twig_print_in_twig_block_param199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_twig_include215 = new BitSet(new long[]{0x0000A80010000000L});
    public static final BitSet FOLLOW_include_ternary_in_twig_include218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_twig_include222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_ternary_in_include_ternary238 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_ternary240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement257 = new BitSet(new long[]{0x0000030000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement260 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_WITH_in_include_statement264 = new BitSet(new long[]{0x0000A00010100000L});
    public static final BitSet FOLLOW_variable_in_include_statement267 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement271 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_method_in_include_statement275 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_json_in_include_statement279 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_twig_set301 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set303 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_set306 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set308 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ENDSET_in_twig_set315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_left_assignment_in_twig_assignment330 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ASIG_in_twig_assignment333 = new BitSet(new long[]{0x0000A00010100400L});
    public static final BitSet FOLLOW_twig_right_assignment_in_twig_assignment335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment353 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_left_assignment356 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment358 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment377 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment381 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_method_in_twig_right_assignment385 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment389 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment393 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment397 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_right_assignment401 = new BitSet(new long[]{0x0000A00010100400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment404 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment408 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_method_in_twig_right_assignment412 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment416 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment420 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment424 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument443 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument447 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_method_in_twig_tilde_argument451 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument455 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument459 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_TILDE_in_twig_tilde_argument462 = new BitSet(new long[]{0x0000A00010100400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_tilde_argument473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_twig_import498 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import501 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IMPORT_in_twig_import506 = new BitSet(new long[]{0x0000A00010000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import509 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_variable_in_twig_import513 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_TWIG_AS_in_twig_import517 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import520 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_import523 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import525 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_MACRO_in_twig_macro547 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_variable_in_twig_macro550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_macro554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDMACRO_in_twig_macro560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_twig_if575 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_variable_in_twig_if577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_if581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSEIF_in_twig_elseif596 = new BitSet(new long[]{0x0000200010000000L});
    public static final BitSet FOLLOW_variable_in_twig_elseif599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_elseif603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_twig_for619 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_for621 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_IN_in_twig_for623 = new BitSet(new long[]{0x0000A80010000000L});
    public static final BitSet FOLLOW_for_arguments_in_twig_for625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_value_in_for_arguments640 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_PIPE_in_for_arguments643 = new BitSet(new long[]{0x0000A80010000000L});
    public static final BitSet FOLLOW_for_value_in_for_arguments645 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_STRING_in_for_value662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_for_value666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_for_value670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_for_value674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_range689 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_range701 = new BitSet(new long[]{0x0000A80000000000L});
    public static final BitSet FOLLOW_set_in_range703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary730 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary734 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary738 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_method_in_twig_ternary742 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_QM_in_twig_ternary745 = new BitSet(new long[]{0x0000A80010000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary748 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary752 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary756 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_method_in_twig_ternary760 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_twig_ternary763 = new BitSet(new long[]{0x0000A80010000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_ternary774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_twig_ternary778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_OPEN_in_twig_print_statement796 = new BitSet(new long[]{0x0000A00010000420L});
    public static final BitSet FOLLOW_twig_print_in_twig_print_statement798 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_PRINT_CLOSE_in_twig_print_statement801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_p_input_in_twig_print828 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_PIPE_in_twig_print831 = new BitSet(new long[]{0x0000A00010000400L});
    public static final BitSet FOLLOW_p_input_in_twig_print833 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_variable_in_p_input850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_in_p_input854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_p_input858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_p_input862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_START_in_array880 = new BitSet(new long[]{0x0000A80010100000L});
    public static final BitSet FOLLOW_array_elements_in_array882 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ARRAY_END_in_array884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_element_in_array_elements899 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_array_elements902 = new BitSet(new long[]{0x0000A80010100000L});
    public static final BitSet FOLLOW_array_element_in_array_elements904 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_in_array_element921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_array_element925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_array_element929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_array_element933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_variable950 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_DOT_in_variable953 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_STRING_in_variable956 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_variable_in_method986 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_METHOD_START_in_method988 = new BitSet(new long[]{0x0000A80010100200L});
    public static final BitSet FOLLOW_arguments_in_method990 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_METHOD_END_in_method993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_arguments1009 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_arguments1013 = new BitSet(new long[]{0x0000A80010100000L});
    public static final BitSet FOLLOW_argument_in_arguments1016 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_literal_argument_in_argument1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_argument1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_argument1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_argument1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal_argument1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_START_in_json1081 = new BitSet(new long[]{0x0000A00000200000L});
    public static final BitSet FOLLOW_json_arguments_in_json1083 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JSON_END_in_json1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1101 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_json_arguments1104 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1107 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_set_in_json_argument1125 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_json_argument1134 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_set_in_json_argument1137 = new BitSet(new long[]{0x0000000000000002L});

}