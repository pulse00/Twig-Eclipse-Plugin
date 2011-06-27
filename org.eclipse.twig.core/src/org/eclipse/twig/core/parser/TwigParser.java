// $ANTLR 3.3 Nov 30, 2010 12:45:30 TwigParser.g 2011-06-27 23:31:24

package org.eclipse.twig.core.parser;

import org.eclipse.twig.core.parser.error.IErrorReporter;
import org.eclipse.twig.core.TwigCorePlugin;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PRINT_OPEN", "PRINT_CLOSE", "CTRL_OPEN", "CTRL_CLOSE", "METHOD_START", "METHOD_END", "ARRAY_START", "ARRAY_END", "ASIG", "TILDE", "PIPE", "DDOT", "DOT", "COLON", "COMMA", "BSLASH", "JSON_START", "JSON_END", "QM", "BLOCK", "ENDBLOCK", "FOR", "ENDFOR", "ELSE", "IF", "ELSEIF", "ENDIF", "IN", "TWIG_AS", "MACRO", "ENDMACRO", "IMPORT", "EXTENDS", "FROM", "SET", "ENDSET", "INCLUDE", "WITH", "ONLY", "DIGIT", "NUMBER", "STRING_CHAR", "STRING", "NONCONTROL_CHAR", "STRING_LITERAL", "LOWER", "UPPER", "UNDER", "LETTER", "SYMBOL", "WHITESPACE", "TWIG_PR_STMT", "TWIG_VAR", "LITERAL_ARG"
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
    public static final int EXTENDS=36;
    public static final int FROM=37;
    public static final int SET=38;
    public static final int ENDSET=39;
    public static final int INCLUDE=40;
    public static final int WITH=41;
    public static final int ONLY=42;
    public static final int DIGIT=43;
    public static final int NUMBER=44;
    public static final int STRING_CHAR=45;
    public static final int STRING=46;
    public static final int NONCONTROL_CHAR=47;
    public static final int STRING_LITERAL=48;
    public static final int LOWER=49;
    public static final int UPPER=50;
    public static final int UNDER=51;
    public static final int LETTER=52;
    public static final int SYMBOL=53;
    public static final int WHITESPACE=54;
    public static final int TWIG_PR_STMT=55;
    public static final int TWIG_VAR=56;
    public static final int LITERAL_ARG=57;

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
             	   TwigCorePlugin.debug("Parser has no error reporter instance!");
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
    // TwigParser.g:70:1: twig_source : ( twig_print_statement | twig_control_statement );
    public final TwigParser.twig_source_return twig_source() throws RecognitionException {
        TwigParser.twig_source_return retval = new TwigParser.twig_source_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.twig_print_statement_return twig_print_statement1 = null;

        TwigParser.twig_control_statement_return twig_control_statement2 = null;



        try {
            // TwigParser.g:71:3: ( twig_print_statement | twig_control_statement )
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
                    // TwigParser.g:71:5: twig_print_statement
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_print_statement_in_twig_source69);
                    twig_print_statement1=twig_print_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_print_statement1.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:71:28: twig_control_statement
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
    // TwigParser.g:77:1: twig_control_statement : CTRL_OPEN ( twig_control )? CTRL_CLOSE ;
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
            // TwigParser.g:78:3: ( CTRL_OPEN ( twig_control )? CTRL_CLOSE )
            // TwigParser.g:78:5: CTRL_OPEN ( twig_control )? CTRL_CLOSE
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            CTRL_OPEN3=(CommonToken)match(input,CTRL_OPEN,FOLLOW_CTRL_OPEN_in_twig_control_statement89); 
            CTRL_OPEN3_tree = (TwigCommonTree)adaptor.create(CTRL_OPEN3);
            adaptor.addChild(root_0, CTRL_OPEN3_tree);

            // TwigParser.g:78:15: ( twig_control )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=BLOCK && LA2_0<=ENDIF)||(LA2_0>=MACRO && LA2_0<=INCLUDE)||LA2_0==STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // TwigParser.g:78:15: twig_control
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
    // TwigParser.g:82:1: twig_control : ( twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include | twig_block | twig_extends );
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

        TwigParser.twig_extends_return twig_extends17 = null;


        TwigCommonTree ENDFOR7_tree=null;
        TwigCommonTree ELSE8_tree=null;
        TwigCommonTree ENDIF11_tree=null;

        try {
            // TwigParser.g:83:3: ( twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include | twig_block | twig_extends )
            int alt3=12;
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
            case EXTENDS:
                {
                alt3=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // TwigParser.g:83:5: twig_for
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_for_in_twig_control108);
                    twig_for6=twig_for();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_for6.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:83:16: ENDFOR
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDFOR7=(CommonToken)match(input,ENDFOR,FOLLOW_ENDFOR_in_twig_control112); 
                    ENDFOR7_tree = (TwigCommonTree)adaptor.create(ENDFOR7);
                    adaptor.addChild(root_0, ENDFOR7_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:83:25: ELSE
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ELSE8=(CommonToken)match(input,ELSE,FOLLOW_ELSE_in_twig_control116); 
                    ELSE8_tree = (TwigCommonTree)adaptor.create(ELSE8);
                    adaptor.addChild(root_0, ELSE8_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:83:32: twig_if
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_if_in_twig_control120);
                    twig_if9=twig_if();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_if9.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:83:42: twig_elseif
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_elseif_in_twig_control124);
                    twig_elseif10=twig_elseif();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_elseif10.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:83:56: ENDIF
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDIF11=(CommonToken)match(input,ENDIF,FOLLOW_ENDIF_in_twig_control128); 
                    ENDIF11_tree = (TwigCommonTree)adaptor.create(ENDIF11);
                    adaptor.addChild(root_0, ENDIF11_tree);


                    }
                    break;
                case 7 :
                    // TwigParser.g:83:64: twig_macro
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_macro_in_twig_control132);
                    twig_macro12=twig_macro();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_macro12.getTree());

                    }
                    break;
                case 8 :
                    // TwigParser.g:83:77: twig_import
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_import_in_twig_control136);
                    twig_import13=twig_import();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_import13.getTree());

                    }
                    break;
                case 9 :
                    // TwigParser.g:83:91: twig_set
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_set_in_twig_control140);
                    twig_set14=twig_set();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_set14.getTree());

                    }
                    break;
                case 10 :
                    // TwigParser.g:83:102: twig_include
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_include_in_twig_control144);
                    twig_include15=twig_include();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_include15.getTree());

                    }
                    break;
                case 11 :
                    // TwigParser.g:83:117: twig_block
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_block_in_twig_control148);
                    twig_block16=twig_block();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_block16.getTree());

                    }
                    break;
                case 12 :
                    // TwigParser.g:83:130: twig_extends
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_extends_in_twig_control152);
                    twig_extends17=twig_extends();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_extends17.getTree());

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

    public static class twig_extends_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_extends"
    // TwigParser.g:86:1: twig_extends : EXTENDS STRING_LITERAL ;
    public final TwigParser.twig_extends_return twig_extends() throws RecognitionException {
        TwigParser.twig_extends_return retval = new TwigParser.twig_extends_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken EXTENDS18=null;
        CommonToken STRING_LITERAL19=null;

        TwigCommonTree EXTENDS18_tree=null;
        TwigCommonTree STRING_LITERAL19_tree=null;

        try {
            // TwigParser.g:87:3: ( EXTENDS STRING_LITERAL )
            // TwigParser.g:87:5: EXTENDS STRING_LITERAL
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            EXTENDS18=(CommonToken)match(input,EXTENDS,FOLLOW_EXTENDS_in_twig_extends167); 
            EXTENDS18_tree = (TwigCommonTree)adaptor.create(EXTENDS18);
            adaptor.addChild(root_0, EXTENDS18_tree);

            STRING_LITERAL19=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_extends169); 
            STRING_LITERAL19_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL19);
            adaptor.addChild(root_0, STRING_LITERAL19_tree);


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
    // $ANTLR end "twig_extends"

    public static class twig_block_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_block"
    // TwigParser.g:90:1: twig_block : ( ( BLOCK twig_block_param ) | ( ENDBLOCK ) );
    public final TwigParser.twig_block_return twig_block() throws RecognitionException {
        TwigParser.twig_block_return retval = new TwigParser.twig_block_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken BLOCK20=null;
        CommonToken ENDBLOCK22=null;
        TwigParser.twig_block_param_return twig_block_param21 = null;


        TwigCommonTree BLOCK20_tree=null;
        TwigCommonTree ENDBLOCK22_tree=null;

        try {
            // TwigParser.g:91:3: ( ( BLOCK twig_block_param ) | ( ENDBLOCK ) )
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
                    // TwigParser.g:91:5: ( BLOCK twig_block_param )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:91:5: ( BLOCK twig_block_param )
                    // TwigParser.g:91:6: BLOCK twig_block_param
                    {
                    BLOCK20=(CommonToken)match(input,BLOCK,FOLLOW_BLOCK_in_twig_block186); 
                    BLOCK20_tree = (TwigCommonTree)adaptor.create(BLOCK20);
                    adaptor.addChild(root_0, BLOCK20_tree);

                    pushFollow(FOLLOW_twig_block_param_in_twig_block188);
                    twig_block_param21=twig_block_param();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_block_param21.getTree());

                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:91:32: ( ENDBLOCK )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:91:32: ( ENDBLOCK )
                    // TwigParser.g:91:33: ENDBLOCK
                    {
                    ENDBLOCK22=(CommonToken)match(input,ENDBLOCK,FOLLOW_ENDBLOCK_in_twig_block194); 
                    ENDBLOCK22_tree = (TwigCommonTree)adaptor.create(ENDBLOCK22);
                    adaptor.addChild(root_0, ENDBLOCK22_tree);


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
    // TwigParser.g:94:1: twig_block_param : ( variable | method_chain ) ( twig_print )? ;
    public final TwigParser.twig_block_param_return twig_block_param() throws RecognitionException {
        TwigParser.twig_block_param_return retval = new TwigParser.twig_block_param_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.variable_return variable23 = null;

        TwigParser.method_chain_return method_chain24 = null;

        TwigParser.twig_print_return twig_print25 = null;



        try {
            // TwigParser.g:95:3: ( ( variable | method_chain ) ( twig_print )? )
            // TwigParser.g:95:5: ( variable | method_chain ) ( twig_print )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:95:5: ( variable | method_chain )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // TwigParser.g:95:6: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_block_param211);
                    variable23=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable23.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:95:17: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_block_param215);
                    method_chain24=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain24.getTree());

                    }
                    break;

            }

            // TwigParser.g:95:31: ( twig_print )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ARRAY_START||LA6_0==STRING||LA6_0==STRING_LITERAL) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // TwigParser.g:95:31: twig_print
                    {
                    pushFollow(FOLLOW_twig_print_in_twig_block_param218);
                    twig_print25=twig_print();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_print25.getTree());

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
    // TwigParser.g:98:1: twig_include : INCLUDE ( include_ternary | include_statement ) ;
    public final TwigParser.twig_include_return twig_include() throws RecognitionException {
        TwigParser.twig_include_return retval = new TwigParser.twig_include_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken INCLUDE26=null;
        TwigParser.include_ternary_return include_ternary27 = null;

        TwigParser.include_statement_return include_statement28 = null;


        TwigCommonTree INCLUDE26_tree=null;

        try {
            // TwigParser.g:99:3: ( INCLUDE ( include_ternary | include_statement ) )
            // TwigParser.g:99:5: INCLUDE ( include_ternary | include_statement )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            INCLUDE26=(CommonToken)match(input,INCLUDE,FOLLOW_INCLUDE_in_twig_include234); 
            INCLUDE26_tree = (TwigCommonTree)adaptor.create(INCLUDE26);
            adaptor.addChild(root_0, INCLUDE26_tree);

            // TwigParser.g:99:13: ( include_ternary | include_statement )
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
                    // TwigParser.g:99:14: include_ternary
                    {
                    pushFollow(FOLLOW_include_ternary_in_twig_include237);
                    include_ternary27=include_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, include_ternary27.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:99:32: include_statement
                    {
                    pushFollow(FOLLOW_include_statement_in_twig_include241);
                    include_statement28=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement28.getTree());

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
    // TwigParser.g:102:1: include_ternary : twig_ternary ( ONLY )? ;
    public final TwigParser.include_ternary_return include_ternary() throws RecognitionException {
        TwigParser.include_ternary_return retval = new TwigParser.include_ternary_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ONLY30=null;
        TwigParser.twig_ternary_return twig_ternary29 = null;


        TwigCommonTree ONLY30_tree=null;

        try {
            // TwigParser.g:103:3: ( twig_ternary ( ONLY )? )
            // TwigParser.g:103:5: twig_ternary ( ONLY )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_ternary_in_include_ternary257);
            twig_ternary29=twig_ternary();

            state._fsp--;

            adaptor.addChild(root_0, twig_ternary29.getTree());
            // TwigParser.g:103:18: ( ONLY )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ONLY) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // TwigParser.g:103:18: ONLY
                    {
                    ONLY30=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_ternary259); 
                    ONLY30_tree = (TwigCommonTree)adaptor.create(ONLY30);
                    adaptor.addChild(root_0, ONLY30_tree);


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
    // TwigParser.g:106:1: include_statement : ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )? ;
    public final TwigParser.include_statement_return include_statement() throws RecognitionException {
        TwigParser.include_statement_return retval = new TwigParser.include_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL31=null;
        CommonToken ONLY32=null;
        CommonToken WITH33=null;
        CommonToken STRING_LITERAL35=null;
        CommonToken ONLY38=null;
        TwigParser.variable_return variable34 = null;

        TwigParser.method_chain_return method_chain36 = null;

        TwigParser.json_return json37 = null;


        TwigCommonTree STRING_LITERAL31_tree=null;
        TwigCommonTree ONLY32_tree=null;
        TwigCommonTree WITH33_tree=null;
        TwigCommonTree STRING_LITERAL35_tree=null;
        TwigCommonTree ONLY38_tree=null;

        try {
            // TwigParser.g:107:3: ( ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )? )
            // TwigParser.g:107:5: ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:107:5: ( STRING_LITERAL )
            // TwigParser.g:107:6: STRING_LITERAL
            {
            STRING_LITERAL31=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement276); 
            STRING_LITERAL31_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL31);
            adaptor.addChild(root_0, STRING_LITERAL31_tree);


            }

            // TwigParser.g:107:22: ( ONLY )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ONLY) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // TwigParser.g:107:22: ONLY
                    {
                    ONLY32=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement279); 
                    ONLY32_tree = (TwigCommonTree)adaptor.create(ONLY32);
                    adaptor.addChild(root_0, ONLY32_tree);


                    }
                    break;

            }

            // TwigParser.g:107:28: ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==WITH) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // TwigParser.g:107:29: WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )?
                    {
                    WITH33=(CommonToken)match(input,WITH,FOLLOW_WITH_in_include_statement283); 
                    WITH33_tree = (TwigCommonTree)adaptor.create(WITH33);
                    adaptor.addChild(root_0, WITH33_tree);

                    // TwigParser.g:107:34: ( variable | STRING_LITERAL | method_chain | json )
                    int alt10=4;
                    alt10 = dfa10.predict(input);
                    switch (alt10) {
                        case 1 :
                            // TwigParser.g:107:35: variable
                            {
                            pushFollow(FOLLOW_variable_in_include_statement286);
                            variable34=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable34.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:107:46: STRING_LITERAL
                            {
                            STRING_LITERAL35=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement290); 
                            STRING_LITERAL35_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL35);
                            adaptor.addChild(root_0, STRING_LITERAL35_tree);


                            }
                            break;
                        case 3 :
                            // TwigParser.g:107:63: method_chain
                            {
                            pushFollow(FOLLOW_method_chain_in_include_statement294);
                            method_chain36=method_chain();

                            state._fsp--;

                            adaptor.addChild(root_0, method_chain36.getTree());

                            }
                            break;
                        case 4 :
                            // TwigParser.g:107:78: json
                            {
                            pushFollow(FOLLOW_json_in_include_statement298);
                            json37=json();

                            state._fsp--;

                            adaptor.addChild(root_0, json37.getTree());

                            }
                            break;

                    }

                    // TwigParser.g:107:84: ( ONLY )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==ONLY) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // TwigParser.g:107:84: ONLY
                            {
                            ONLY38=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement301); 
                            ONLY38_tree = (TwigCommonTree)adaptor.create(ONLY38);
                            adaptor.addChild(root_0, ONLY38_tree);


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
    // TwigParser.g:110:1: twig_set : ( ( SET twig_assignment ( COMMA twig_assignment )* ) | ENDSET );
    public final TwigParser.twig_set_return twig_set() throws RecognitionException {
        TwigParser.twig_set_return retval = new TwigParser.twig_set_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken SET39=null;
        CommonToken COMMA41=null;
        CommonToken ENDSET43=null;
        TwigParser.twig_assignment_return twig_assignment40 = null;

        TwigParser.twig_assignment_return twig_assignment42 = null;


        TwigCommonTree SET39_tree=null;
        TwigCommonTree COMMA41_tree=null;
        TwigCommonTree ENDSET43_tree=null;

        try {
            // TwigParser.g:111:3: ( ( SET twig_assignment ( COMMA twig_assignment )* ) | ENDSET )
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
                    // TwigParser.g:111:5: ( SET twig_assignment ( COMMA twig_assignment )* )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:111:5: ( SET twig_assignment ( COMMA twig_assignment )* )
                    // TwigParser.g:111:6: SET twig_assignment ( COMMA twig_assignment )*
                    {
                    SET39=(CommonToken)match(input,SET,FOLLOW_SET_in_twig_set320); 
                    SET39_tree = (TwigCommonTree)adaptor.create(SET39);
                    adaptor.addChild(root_0, SET39_tree);

                    pushFollow(FOLLOW_twig_assignment_in_twig_set322);
                    twig_assignment40=twig_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_assignment40.getTree());
                    // TwigParser.g:111:26: ( COMMA twig_assignment )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // TwigParser.g:111:27: COMMA twig_assignment
                    	    {
                    	    COMMA41=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_set325); 
                    	    COMMA41_tree = (TwigCommonTree)adaptor.create(COMMA41);
                    	    adaptor.addChild(root_0, COMMA41_tree);

                    	    pushFollow(FOLLOW_twig_assignment_in_twig_set327);
                    	    twig_assignment42=twig_assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, twig_assignment42.getTree());

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
                    // TwigParser.g:111:54: ENDSET
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDSET43=(CommonToken)match(input,ENDSET,FOLLOW_ENDSET_in_twig_set334); 
                    ENDSET43_tree = (TwigCommonTree)adaptor.create(ENDSET43);
                    adaptor.addChild(root_0, ENDSET43_tree);


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
    // TwigParser.g:114:1: twig_assignment : twig_left_assignment ( ASIG twig_right_assignment )? ;
    public final TwigParser.twig_assignment_return twig_assignment() throws RecognitionException {
        TwigParser.twig_assignment_return retval = new TwigParser.twig_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ASIG45=null;
        TwigParser.twig_left_assignment_return twig_left_assignment44 = null;

        TwigParser.twig_right_assignment_return twig_right_assignment46 = null;


        TwigCommonTree ASIG45_tree=null;

        try {
            // TwigParser.g:115:3: ( twig_left_assignment ( ASIG twig_right_assignment )? )
            // TwigParser.g:115:6: twig_left_assignment ( ASIG twig_right_assignment )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_left_assignment_in_twig_assignment349);
            twig_left_assignment44=twig_left_assignment();

            state._fsp--;

            adaptor.addChild(root_0, twig_left_assignment44.getTree());
            // TwigParser.g:115:27: ( ASIG twig_right_assignment )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ASIG) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // TwigParser.g:115:28: ASIG twig_right_assignment
                    {
                    ASIG45=(CommonToken)match(input,ASIG,FOLLOW_ASIG_in_twig_assignment352); 
                    ASIG45_tree = (TwigCommonTree)adaptor.create(ASIG45);
                    adaptor.addChild(root_0, ASIG45_tree);

                    pushFollow(FOLLOW_twig_right_assignment_in_twig_assignment354);
                    twig_right_assignment46=twig_right_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_right_assignment46.getTree());

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
    // TwigParser.g:118:1: twig_left_assignment : ( variable ( COMMA variable )* ) ;
    public final TwigParser.twig_left_assignment_return twig_left_assignment() throws RecognitionException {
        TwigParser.twig_left_assignment_return retval = new TwigParser.twig_left_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA48=null;
        TwigParser.variable_return variable47 = null;

        TwigParser.variable_return variable49 = null;


        TwigCommonTree COMMA48_tree=null;

        try {
            // TwigParser.g:119:3: ( ( variable ( COMMA variable )* ) )
            // TwigParser.g:119:5: ( variable ( COMMA variable )* )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:119:5: ( variable ( COMMA variable )* )
            // TwigParser.g:119:6: variable ( COMMA variable )*
            {
            pushFollow(FOLLOW_variable_in_twig_left_assignment372);
            variable47=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable47.getTree());
            // TwigParser.g:119:15: ( COMMA variable )*
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
            	    // TwigParser.g:119:16: COMMA variable
            	    {
            	    COMMA48=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_left_assignment375); 
            	    COMMA48_tree = (TwigCommonTree)adaptor.create(COMMA48);
            	    adaptor.addChild(root_0, COMMA48_tree);

            	    pushFollow(FOLLOW_variable_in_twig_left_assignment377);
            	    variable49=variable();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable49.getTree());

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
    // TwigParser.g:122:1: twig_right_assignment : ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) )* ;
    public final TwigParser.twig_right_assignment_return twig_right_assignment() throws RecognitionException {
        TwigParser.twig_right_assignment_return retval = new TwigParser.twig_right_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL50=null;
        CommonToken COMMA56=null;
        CommonToken STRING_LITERAL57=null;
        TwigParser.variable_return variable51 = null;

        TwigParser.method_chain_return method_chain52 = null;

        TwigParser.array_return array53 = null;

        TwigParser.json_return json54 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument55 = null;

        TwigParser.variable_return variable58 = null;

        TwigParser.method_chain_return method_chain59 = null;

        TwigParser.array_return array60 = null;

        TwigParser.json_return json61 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument62 = null;


        TwigCommonTree STRING_LITERAL50_tree=null;
        TwigCommonTree COMMA56_tree=null;
        TwigCommonTree STRING_LITERAL57_tree=null;

        try {
            // TwigParser.g:123:3: ( ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) )* )
            // TwigParser.g:123:5: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:123:5: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )
            int alt17=6;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // TwigParser.g:123:6: STRING_LITERAL
                    {
                    STRING_LITERAL50=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment396); 
                    STRING_LITERAL50_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL50);
                    adaptor.addChild(root_0, STRING_LITERAL50_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:123:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_right_assignment400);
                    variable51=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable51.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:123:34: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_right_assignment404);
                    method_chain52=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain52.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:123:49: array
                    {
                    pushFollow(FOLLOW_array_in_twig_right_assignment408);
                    array53=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array53.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:123:57: json
                    {
                    pushFollow(FOLLOW_json_in_twig_right_assignment412);
                    json54=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json54.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:123:64: twig_tilde_argument
                    {
                    pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment416);
                    twig_tilde_argument55=twig_tilde_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_tilde_argument55.getTree());

                    }
                    break;

            }

            // TwigParser.g:123:85: ( COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) )*
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
            	    // TwigParser.g:123:86: COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )
            	    {
            	    COMMA56=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_right_assignment420); 
            	    COMMA56_tree = (TwigCommonTree)adaptor.create(COMMA56);
            	    adaptor.addChild(root_0, COMMA56_tree);

            	    // TwigParser.g:123:92: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )
            	    int alt18=6;
            	    alt18 = dfa18.predict(input);
            	    switch (alt18) {
            	        case 1 :
            	            // TwigParser.g:123:93: STRING_LITERAL
            	            {
            	            STRING_LITERAL57=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment423); 
            	            STRING_LITERAL57_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL57);
            	            adaptor.addChild(root_0, STRING_LITERAL57_tree);


            	            }
            	            break;
            	        case 2 :
            	            // TwigParser.g:123:110: variable
            	            {
            	            pushFollow(FOLLOW_variable_in_twig_right_assignment427);
            	            variable58=variable();

            	            state._fsp--;

            	            adaptor.addChild(root_0, variable58.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // TwigParser.g:123:121: method_chain
            	            {
            	            pushFollow(FOLLOW_method_chain_in_twig_right_assignment431);
            	            method_chain59=method_chain();

            	            state._fsp--;

            	            adaptor.addChild(root_0, method_chain59.getTree());

            	            }
            	            break;
            	        case 4 :
            	            // TwigParser.g:123:136: array
            	            {
            	            pushFollow(FOLLOW_array_in_twig_right_assignment435);
            	            array60=array();

            	            state._fsp--;

            	            adaptor.addChild(root_0, array60.getTree());

            	            }
            	            break;
            	        case 5 :
            	            // TwigParser.g:123:144: json
            	            {
            	            pushFollow(FOLLOW_json_in_twig_right_assignment439);
            	            json61=json();

            	            state._fsp--;

            	            adaptor.addChild(root_0, json61.getTree());

            	            }
            	            break;
            	        case 6 :
            	            // TwigParser.g:123:151: twig_tilde_argument
            	            {
            	            pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment443);
            	            twig_tilde_argument62=twig_tilde_argument();

            	            state._fsp--;

            	            adaptor.addChild(root_0, twig_tilde_argument62.getTree());

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
    // TwigParser.g:126:1: twig_tilde_argument : ( STRING_LITERAL | variable | method_chain | array | json ) TILDE ( STRING_LITERAL | variable | method_chain | array | json ) ;
    public final TwigParser.twig_tilde_argument_return twig_tilde_argument() throws RecognitionException {
        TwigParser.twig_tilde_argument_return retval = new TwigParser.twig_tilde_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL63=null;
        CommonToken TILDE68=null;
        CommonToken STRING_LITERAL69=null;
        TwigParser.variable_return variable64 = null;

        TwigParser.method_chain_return method_chain65 = null;

        TwigParser.array_return array66 = null;

        TwigParser.json_return json67 = null;

        TwigParser.variable_return variable70 = null;

        TwigParser.method_chain_return method_chain71 = null;

        TwigParser.array_return array72 = null;

        TwigParser.json_return json73 = null;


        TwigCommonTree STRING_LITERAL63_tree=null;
        TwigCommonTree TILDE68_tree=null;
        TwigCommonTree STRING_LITERAL69_tree=null;

        try {
            // TwigParser.g:127:3: ( ( STRING_LITERAL | variable | method_chain | array | json ) TILDE ( STRING_LITERAL | variable | method_chain | array | json ) )
            // TwigParser.g:127:5: ( STRING_LITERAL | variable | method_chain | array | json ) TILDE ( STRING_LITERAL | variable | method_chain | array | json )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:127:5: ( STRING_LITERAL | variable | method_chain | array | json )
            int alt20=5;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // TwigParser.g:127:6: STRING_LITERAL
                    {
                    STRING_LITERAL63=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument462); 
                    STRING_LITERAL63_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL63);
                    adaptor.addChild(root_0, STRING_LITERAL63_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:127:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument466);
                    variable64=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable64.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:127:34: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_tilde_argument470);
                    method_chain65=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain65.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:127:49: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument474);
                    array66=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array66.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:127:57: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument478);
                    json67=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json67.getTree());

                    }
                    break;

            }

            TILDE68=(CommonToken)match(input,TILDE,FOLLOW_TILDE_in_twig_tilde_argument481); 
            TILDE68_tree = (TwigCommonTree)adaptor.create(TILDE68);
            adaptor.addChild(root_0, TILDE68_tree);

            // TwigParser.g:127:69: ( STRING_LITERAL | variable | method_chain | array | json )
            int alt21=5;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // TwigParser.g:127:70: STRING_LITERAL
                    {
                    STRING_LITERAL69=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument484); 
                    STRING_LITERAL69_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL69);
                    adaptor.addChild(root_0, STRING_LITERAL69_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:127:87: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument488);
                    variable70=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable70.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:127:98: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_tilde_argument492);
                    method_chain71=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain71.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:127:113: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument496);
                    array72=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array72.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:127:121: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument500);
                    json73=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json73.getTree());

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
    // TwigParser.g:130:1: twig_import : ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )? ;
    public final TwigParser.twig_import_return twig_import() throws RecognitionException {
        TwigParser.twig_import_return retval = new TwigParser.twig_import_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken FROM74=null;
        CommonToken STRING_LITERAL75=null;
        CommonToken IMPORT76=null;
        CommonToken STRING_LITERAL77=null;
        CommonToken TWIG_AS79=null;
        CommonToken STRING80=null;
        CommonToken COMMA81=null;
        CommonToken STRING82=null;
        TwigParser.variable_return variable78 = null;


        TwigCommonTree FROM74_tree=null;
        TwigCommonTree STRING_LITERAL75_tree=null;
        TwigCommonTree IMPORT76_tree=null;
        TwigCommonTree STRING_LITERAL77_tree=null;
        TwigCommonTree TWIG_AS79_tree=null;
        TwigCommonTree STRING80_tree=null;
        TwigCommonTree COMMA81_tree=null;
        TwigCommonTree STRING82_tree=null;

        try {
            // TwigParser.g:131:3: ( ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )? )
            // TwigParser.g:131:5: ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:131:5: ( FROM ( STRING_LITERAL ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==FROM) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // TwigParser.g:131:6: FROM ( STRING_LITERAL )
                    {
                    FROM74=(CommonToken)match(input,FROM,FOLLOW_FROM_in_twig_import517); 
                    FROM74_tree = (TwigCommonTree)adaptor.create(FROM74);
                    adaptor.addChild(root_0, FROM74_tree);

                    // TwigParser.g:131:11: ( STRING_LITERAL )
                    // TwigParser.g:131:12: STRING_LITERAL
                    {
                    STRING_LITERAL75=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import520); 
                    STRING_LITERAL75_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL75);
                    adaptor.addChild(root_0, STRING_LITERAL75_tree);


                    }


                    }
                    break;

            }

            IMPORT76=(CommonToken)match(input,IMPORT,FOLLOW_IMPORT_in_twig_import525); 
            IMPORT76_tree = (TwigCommonTree)adaptor.create(IMPORT76);
            adaptor.addChild(root_0, IMPORT76_tree);

            // TwigParser.g:131:37: ( STRING_LITERAL | variable )
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
                    // TwigParser.g:131:38: STRING_LITERAL
                    {
                    STRING_LITERAL77=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import528); 
                    STRING_LITERAL77_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL77);
                    adaptor.addChild(root_0, STRING_LITERAL77_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:131:55: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_import532);
                    variable78=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable78.getTree());

                    }
                    break;

            }

            // TwigParser.g:131:65: ( TWIG_AS ( STRING ( COMMA STRING )* ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==TWIG_AS) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // TwigParser.g:131:66: TWIG_AS ( STRING ( COMMA STRING )* )
                    {
                    TWIG_AS79=(CommonToken)match(input,TWIG_AS,FOLLOW_TWIG_AS_in_twig_import536); 
                    TWIG_AS79_tree = (TwigCommonTree)adaptor.create(TWIG_AS79);
                    adaptor.addChild(root_0, TWIG_AS79_tree);

                    // TwigParser.g:131:74: ( STRING ( COMMA STRING )* )
                    // TwigParser.g:131:75: STRING ( COMMA STRING )*
                    {
                    STRING80=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import539); 
                    STRING80_tree = (TwigCommonTree)adaptor.create(STRING80);
                    adaptor.addChild(root_0, STRING80_tree);

                    // TwigParser.g:131:82: ( COMMA STRING )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==COMMA) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // TwigParser.g:131:83: COMMA STRING
                    	    {
                    	    COMMA81=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_import542); 
                    	    COMMA81_tree = (TwigCommonTree)adaptor.create(COMMA81);
                    	    adaptor.addChild(root_0, COMMA81_tree);

                    	    STRING82=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import544); 
                    	    STRING82_tree = (TwigCommonTree)adaptor.create(STRING82);
                    	    adaptor.addChild(root_0, STRING82_tree);


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
    // TwigParser.g:134:1: twig_macro : ( ( MACRO ( variable | method_chain ) ) | ENDMACRO );
    public final TwigParser.twig_macro_return twig_macro() throws RecognitionException {
        TwigParser.twig_macro_return retval = new TwigParser.twig_macro_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken MACRO83=null;
        CommonToken ENDMACRO86=null;
        TwigParser.variable_return variable84 = null;

        TwigParser.method_chain_return method_chain85 = null;


        TwigCommonTree MACRO83_tree=null;
        TwigCommonTree ENDMACRO86_tree=null;

        try {
            // TwigParser.g:135:3: ( ( MACRO ( variable | method_chain ) ) | ENDMACRO )
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
                    // TwigParser.g:135:5: ( MACRO ( variable | method_chain ) )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:135:5: ( MACRO ( variable | method_chain ) )
                    // TwigParser.g:135:6: MACRO ( variable | method_chain )
                    {
                    MACRO83=(CommonToken)match(input,MACRO,FOLLOW_MACRO_in_twig_macro566); 
                    MACRO83_tree = (TwigCommonTree)adaptor.create(MACRO83);
                    adaptor.addChild(root_0, MACRO83_tree);

                    // TwigParser.g:135:12: ( variable | method_chain )
                    int alt26=2;
                    alt26 = dfa26.predict(input);
                    switch (alt26) {
                        case 1 :
                            // TwigParser.g:135:13: variable
                            {
                            pushFollow(FOLLOW_variable_in_twig_macro569);
                            variable84=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable84.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:135:24: method_chain
                            {
                            pushFollow(FOLLOW_method_chain_in_twig_macro573);
                            method_chain85=method_chain();

                            state._fsp--;

                            adaptor.addChild(root_0, method_chain85.getTree());

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:135:41: ENDMACRO
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDMACRO86=(CommonToken)match(input,ENDMACRO,FOLLOW_ENDMACRO_in_twig_macro579); 
                    ENDMACRO86_tree = (TwigCommonTree)adaptor.create(ENDMACRO86);
                    adaptor.addChild(root_0, ENDMACRO86_tree);


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
    // TwigParser.g:138:1: twig_if : ( IF variable | method_chain );
    public final TwigParser.twig_if_return twig_if() throws RecognitionException {
        TwigParser.twig_if_return retval = new TwigParser.twig_if_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken IF87=null;
        TwigParser.variable_return variable88 = null;

        TwigParser.method_chain_return method_chain89 = null;


        TwigCommonTree IF87_tree=null;

        try {
            // TwigParser.g:139:3: ( IF variable | method_chain )
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
                    // TwigParser.g:139:5: IF variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    IF87=(CommonToken)match(input,IF,FOLLOW_IF_in_twig_if594); 
                    IF87_tree = (TwigCommonTree)adaptor.create(IF87);
                    adaptor.addChild(root_0, IF87_tree);

                    pushFollow(FOLLOW_variable_in_twig_if596);
                    variable88=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable88.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:139:19: method_chain
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_chain_in_twig_if600);
                    method_chain89=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain89.getTree());

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
    // TwigParser.g:142:1: twig_elseif : ELSEIF ( variable | method_chain ) ;
    public final TwigParser.twig_elseif_return twig_elseif() throws RecognitionException {
        TwigParser.twig_elseif_return retval = new TwigParser.twig_elseif_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ELSEIF90=null;
        TwigParser.variable_return variable91 = null;

        TwigParser.method_chain_return method_chain92 = null;


        TwigCommonTree ELSEIF90_tree=null;

        try {
            // TwigParser.g:143:3: ( ELSEIF ( variable | method_chain ) )
            // TwigParser.g:143:5: ELSEIF ( variable | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ELSEIF90=(CommonToken)match(input,ELSEIF,FOLLOW_ELSEIF_in_twig_elseif615); 
            ELSEIF90_tree = (TwigCommonTree)adaptor.create(ELSEIF90);
            adaptor.addChild(root_0, ELSEIF90_tree);

            // TwigParser.g:143:12: ( variable | method_chain )
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // TwigParser.g:143:13: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_elseif618);
                    variable91=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable91.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:143:24: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_elseif622);
                    method_chain92=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain92.getTree());

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
    // TwigParser.g:146:1: twig_for : FOR STRING IN for_arguments ;
    public final TwigParser.twig_for_return twig_for() throws RecognitionException {
        TwigParser.twig_for_return retval = new TwigParser.twig_for_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken FOR93=null;
        CommonToken STRING94=null;
        CommonToken IN95=null;
        TwigParser.for_arguments_return for_arguments96 = null;


        TwigCommonTree FOR93_tree=null;
        TwigCommonTree STRING94_tree=null;
        TwigCommonTree IN95_tree=null;

        try {
            // TwigParser.g:147:3: ( FOR STRING IN for_arguments )
            // TwigParser.g:147:5: FOR STRING IN for_arguments
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            FOR93=(CommonToken)match(input,FOR,FOLLOW_FOR_in_twig_for638); 
            FOR93_tree = (TwigCommonTree)adaptor.create(FOR93);
            adaptor.addChild(root_0, FOR93_tree);

            STRING94=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_for640); 
            STRING94_tree = (TwigCommonTree)adaptor.create(STRING94);
            adaptor.addChild(root_0, STRING94_tree);

            IN95=(CommonToken)match(input,IN,FOLLOW_IN_in_twig_for642); 
            IN95_tree = (TwigCommonTree)adaptor.create(IN95);
            adaptor.addChild(root_0, IN95_tree);

            pushFollow(FOLLOW_for_arguments_in_twig_for644);
            for_arguments96=for_arguments();

            state._fsp--;

            adaptor.addChild(root_0, for_arguments96.getTree());

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
    // TwigParser.g:150:1: for_arguments : for_value ( PIPE for_value )* ;
    public final TwigParser.for_arguments_return for_arguments() throws RecognitionException {
        TwigParser.for_arguments_return retval = new TwigParser.for_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE98=null;
        TwigParser.for_value_return for_value97 = null;

        TwigParser.for_value_return for_value99 = null;


        TwigCommonTree PIPE98_tree=null;

        try {
            // TwigParser.g:151:3: ( for_value ( PIPE for_value )* )
            // TwigParser.g:151:5: for_value ( PIPE for_value )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_for_value_in_for_arguments659);
            for_value97=for_value();

            state._fsp--;

            adaptor.addChild(root_0, for_value97.getTree());
            // TwigParser.g:151:15: ( PIPE for_value )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==PIPE) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // TwigParser.g:151:16: PIPE for_value
            	    {
            	    PIPE98=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_for_arguments662); 
            	    PIPE98_tree = (TwigCommonTree)adaptor.create(PIPE98);
            	    adaptor.addChild(root_0, PIPE98_tree);

            	    pushFollow(FOLLOW_for_value_in_for_arguments664);
            	    for_value99=for_value();

            	    state._fsp--;

            	    adaptor.addChild(root_0, for_value99.getTree());

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
    // TwigParser.g:154:1: for_value : ( STRING | STRING_LITERAL | method_chain | range );
    public final TwigParser.for_value_return for_value() throws RecognitionException {
        TwigParser.for_value_return retval = new TwigParser.for_value_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING100=null;
        CommonToken STRING_LITERAL101=null;
        TwigParser.method_chain_return method_chain102 = null;

        TwigParser.range_return range103 = null;


        TwigCommonTree STRING100_tree=null;
        TwigCommonTree STRING_LITERAL101_tree=null;

        try {
            // TwigParser.g:155:3: ( STRING | STRING_LITERAL | method_chain | range )
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
                    // TwigParser.g:155:5: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING100=(CommonToken)match(input,STRING,FOLLOW_STRING_in_for_value681); 
                    STRING100_tree = (TwigCommonTree)adaptor.create(STRING100);
                    adaptor.addChild(root_0, STRING100_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:155:14: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL101=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_for_value685); 
                    STRING_LITERAL101_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL101);
                    adaptor.addChild(root_0, STRING_LITERAL101_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:155:31: method_chain
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_chain_in_for_value689);
                    method_chain102=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain102.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:155:46: range
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_range_in_for_value693);
                    range103=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range103.getTree());

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
    // TwigParser.g:158:1: range : ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) ;
    public final TwigParser.range_return range() throws RecognitionException {
        TwigParser.range_return retval = new TwigParser.range_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set104=null;
        CommonToken DDOT105=null;
        CommonToken set106=null;

        TwigCommonTree set104_tree=null;
        TwigCommonTree DDOT105_tree=null;
        TwigCommonTree set106_tree=null;

        try {
            // TwigParser.g:159:3: ( ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) )
            // TwigParser.g:159:5: ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set104=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set104));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            DDOT105=(CommonToken)match(input,DDOT,FOLLOW_DDOT_in_range720); 
            DDOT105_tree = (TwigCommonTree)adaptor.create(DDOT105);
            adaptor.addChild(root_0, DDOT105_tree);

            set106=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set106));
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
    // TwigParser.g:162:1: twig_ternary : ( STRING_LITERAL | NUMBER | variable | method_chain ) QM ( STRING_LITERAL | NUMBER | variable | method_chain ) COLON ( STRING_LITERAL | NUMBER | variable | method_chain ) ;
    public final TwigParser.twig_ternary_return twig_ternary() throws RecognitionException {
        TwigParser.twig_ternary_return retval = new TwigParser.twig_ternary_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL107=null;
        CommonToken NUMBER108=null;
        CommonToken QM111=null;
        CommonToken STRING_LITERAL112=null;
        CommonToken NUMBER113=null;
        CommonToken COLON116=null;
        CommonToken STRING_LITERAL117=null;
        CommonToken NUMBER118=null;
        TwigParser.variable_return variable109 = null;

        TwigParser.method_chain_return method_chain110 = null;

        TwigParser.variable_return variable114 = null;

        TwigParser.method_chain_return method_chain115 = null;

        TwigParser.variable_return variable119 = null;

        TwigParser.method_chain_return method_chain120 = null;


        TwigCommonTree STRING_LITERAL107_tree=null;
        TwigCommonTree NUMBER108_tree=null;
        TwigCommonTree QM111_tree=null;
        TwigCommonTree STRING_LITERAL112_tree=null;
        TwigCommonTree NUMBER113_tree=null;
        TwigCommonTree COLON116_tree=null;
        TwigCommonTree STRING_LITERAL117_tree=null;
        TwigCommonTree NUMBER118_tree=null;

        try {
            // TwigParser.g:163:3: ( ( STRING_LITERAL | NUMBER | variable | method_chain ) QM ( STRING_LITERAL | NUMBER | variable | method_chain ) COLON ( STRING_LITERAL | NUMBER | variable | method_chain ) )
            // TwigParser.g:163:5: ( STRING_LITERAL | NUMBER | variable | method_chain ) QM ( STRING_LITERAL | NUMBER | variable | method_chain ) COLON ( STRING_LITERAL | NUMBER | variable | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:163:5: ( STRING_LITERAL | NUMBER | variable | method_chain )
            int alt32=4;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // TwigParser.g:163:6: STRING_LITERAL
                    {
                    STRING_LITERAL107=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary749); 
                    STRING_LITERAL107_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL107);
                    adaptor.addChild(root_0, STRING_LITERAL107_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:163:23: NUMBER
                    {
                    NUMBER108=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary753); 
                    NUMBER108_tree = (TwigCommonTree)adaptor.create(NUMBER108);
                    adaptor.addChild(root_0, NUMBER108_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:163:32: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary757);
                    variable109=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable109.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:163:43: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary761);
                    method_chain110=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain110.getTree());

                    }
                    break;

            }

            QM111=(CommonToken)match(input,QM,FOLLOW_QM_in_twig_ternary764); 
            QM111_tree = (TwigCommonTree)adaptor.create(QM111);
            adaptor.addChild(root_0, QM111_tree);

            // TwigParser.g:163:60: ( STRING_LITERAL | NUMBER | variable | method_chain )
            int alt33=4;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // TwigParser.g:163:61: STRING_LITERAL
                    {
                    STRING_LITERAL112=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary767); 
                    STRING_LITERAL112_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL112);
                    adaptor.addChild(root_0, STRING_LITERAL112_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:163:78: NUMBER
                    {
                    NUMBER113=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary771); 
                    NUMBER113_tree = (TwigCommonTree)adaptor.create(NUMBER113);
                    adaptor.addChild(root_0, NUMBER113_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:163:87: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary775);
                    variable114=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable114.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:163:98: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary779);
                    method_chain115=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain115.getTree());

                    }
                    break;

            }

            COLON116=(CommonToken)match(input,COLON,FOLLOW_COLON_in_twig_ternary782); 
            COLON116_tree = (TwigCommonTree)adaptor.create(COLON116);
            adaptor.addChild(root_0, COLON116_tree);

            // TwigParser.g:163:118: ( STRING_LITERAL | NUMBER | variable | method_chain )
            int alt34=4;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // TwigParser.g:163:119: STRING_LITERAL
                    {
                    STRING_LITERAL117=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary785); 
                    STRING_LITERAL117_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL117);
                    adaptor.addChild(root_0, STRING_LITERAL117_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:163:136: NUMBER
                    {
                    NUMBER118=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary789); 
                    NUMBER118_tree = (TwigCommonTree)adaptor.create(NUMBER118);
                    adaptor.addChild(root_0, NUMBER118_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:163:145: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary793);
                    variable119=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable119.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:163:156: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary797);
                    method_chain120=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain120.getTree());

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
    // TwigParser.g:168:1: twig_print_statement : PRINT_OPEN ( twig_print )? PRINT_CLOSE -> ^( TWIG_PR_STMT ( twig_print )? ) ;
    public final TwigParser.twig_print_statement_return twig_print_statement() throws RecognitionException {
        TwigParser.twig_print_statement_return retval = new TwigParser.twig_print_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PRINT_OPEN121=null;
        CommonToken PRINT_CLOSE123=null;
        TwigParser.twig_print_return twig_print122 = null;


        TwigCommonTree PRINT_OPEN121_tree=null;
        TwigCommonTree PRINT_CLOSE123_tree=null;
        RewriteRuleTokenStream stream_PRINT_OPEN=new RewriteRuleTokenStream(adaptor,"token PRINT_OPEN");
        RewriteRuleTokenStream stream_PRINT_CLOSE=new RewriteRuleTokenStream(adaptor,"token PRINT_CLOSE");
        RewriteRuleSubtreeStream stream_twig_print=new RewriteRuleSubtreeStream(adaptor,"rule twig_print");
        try {
            // TwigParser.g:169:3: ( PRINT_OPEN ( twig_print )? PRINT_CLOSE -> ^( TWIG_PR_STMT ( twig_print )? ) )
            // TwigParser.g:169:6: PRINT_OPEN ( twig_print )? PRINT_CLOSE
            {
            PRINT_OPEN121=(CommonToken)match(input,PRINT_OPEN,FOLLOW_PRINT_OPEN_in_twig_print_statement815);  
            stream_PRINT_OPEN.add(PRINT_OPEN121);

            // TwigParser.g:169:17: ( twig_print )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==ARRAY_START||LA35_0==STRING||LA35_0==STRING_LITERAL) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // TwigParser.g:169:17: twig_print
                    {
                    pushFollow(FOLLOW_twig_print_in_twig_print_statement817);
                    twig_print122=twig_print();

                    state._fsp--;

                    stream_twig_print.add(twig_print122.getTree());

                    }
                    break;

            }

            PRINT_CLOSE123=(CommonToken)match(input,PRINT_CLOSE,FOLLOW_PRINT_CLOSE_in_twig_print_statement820);  
            stream_PRINT_CLOSE.add(PRINT_CLOSE123);



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
            // 170:5: -> ^( TWIG_PR_STMT ( twig_print )? )
            {
                // TwigParser.g:170:7: ^( TWIG_PR_STMT ( twig_print )? )
                {
                TwigCommonTree root_1 = (TwigCommonTree)adaptor.nil();
                root_1 = (TwigCommonTree)adaptor.becomeRoot((TwigCommonTree)adaptor.create(TWIG_PR_STMT, "TWIG_PR_STMT"), root_1);

                // TwigParser.g:170:22: ( twig_print )?
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
    // TwigParser.g:173:1: twig_print : p_input ( PIPE p_input )* ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE125=null;
        TwigParser.p_input_return p_input124 = null;

        TwigParser.p_input_return p_input126 = null;


        TwigCommonTree PIPE125_tree=null;

        try {
            // TwigParser.g:174:3: ( p_input ( PIPE p_input )* )
            // TwigParser.g:174:5: p_input ( PIPE p_input )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_p_input_in_twig_print847);
            p_input124=p_input();

            state._fsp--;

            adaptor.addChild(root_0, p_input124.getTree());
            // TwigParser.g:174:13: ( PIPE p_input )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==PIPE) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // TwigParser.g:174:14: PIPE p_input
            	    {
            	    PIPE125=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_print850); 
            	    PIPE125_tree = (TwigCommonTree)adaptor.create(PIPE125);
            	    adaptor.addChild(root_0, PIPE125_tree);

            	    pushFollow(FOLLOW_p_input_in_twig_print852);
            	    p_input126=p_input();

            	    state._fsp--;

            	    adaptor.addChild(root_0, p_input126.getTree());

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
    // TwigParser.g:177:1: p_input : ( variable | method_chain | array | STRING_LITERAL );
    public final TwigParser.p_input_return p_input() throws RecognitionException {
        TwigParser.p_input_return retval = new TwigParser.p_input_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL130=null;
        TwigParser.variable_return variable127 = null;

        TwigParser.method_chain_return method_chain128 = null;

        TwigParser.array_return array129 = null;


        TwigCommonTree STRING_LITERAL130_tree=null;

        try {
            // TwigParser.g:178:3: ( variable | method_chain | array | STRING_LITERAL )
            int alt37=4;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // TwigParser.g:178:5: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_p_input869);
                    variable127=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable127.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:178:16: method_chain
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_chain_in_p_input873);
                    method_chain128=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain128.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:178:31: array
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_array_in_p_input877);
                    array129=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array129.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:178:39: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL130=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_p_input881); 
                    STRING_LITERAL130_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL130);
                    adaptor.addChild(root_0, STRING_LITERAL130_tree);


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
    // TwigParser.g:182:1: array : ARRAY_START array_elements ARRAY_END ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ARRAY_START131=null;
        CommonToken ARRAY_END133=null;
        TwigParser.array_elements_return array_elements132 = null;


        TwigCommonTree ARRAY_START131_tree=null;
        TwigCommonTree ARRAY_END133_tree=null;

        try {
            // TwigParser.g:183:3: ( ARRAY_START array_elements ARRAY_END )
            // TwigParser.g:183:5: ARRAY_START array_elements ARRAY_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ARRAY_START131=(CommonToken)match(input,ARRAY_START,FOLLOW_ARRAY_START_in_array899); 
            ARRAY_START131_tree = (TwigCommonTree)adaptor.create(ARRAY_START131);
            adaptor.addChild(root_0, ARRAY_START131_tree);

            pushFollow(FOLLOW_array_elements_in_array901);
            array_elements132=array_elements();

            state._fsp--;

            adaptor.addChild(root_0, array_elements132.getTree());
            ARRAY_END133=(CommonToken)match(input,ARRAY_END,FOLLOW_ARRAY_END_in_array903); 
            ARRAY_END133_tree = (TwigCommonTree)adaptor.create(ARRAY_END133);
            adaptor.addChild(root_0, ARRAY_END133_tree);


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
    // TwigParser.g:186:1: array_elements : array_element ( COMMA array_element )* ;
    public final TwigParser.array_elements_return array_elements() throws RecognitionException {
        TwigParser.array_elements_return retval = new TwigParser.array_elements_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA135=null;
        TwigParser.array_element_return array_element134 = null;

        TwigParser.array_element_return array_element136 = null;


        TwigCommonTree COMMA135_tree=null;

        try {
            // TwigParser.g:187:3: ( array_element ( COMMA array_element )* )
            // TwigParser.g:187:5: array_element ( COMMA array_element )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_array_element_in_array_elements918);
            array_element134=array_element();

            state._fsp--;

            adaptor.addChild(root_0, array_element134.getTree());
            // TwigParser.g:187:19: ( COMMA array_element )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==COMMA) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // TwigParser.g:187:20: COMMA array_element
            	    {
            	    COMMA135=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_array_elements921); 
            	    COMMA135_tree = (TwigCommonTree)adaptor.create(COMMA135);
            	    adaptor.addChild(root_0, COMMA135_tree);

            	    pushFollow(FOLLOW_array_element_in_array_elements923);
            	    array_element136=array_element();

            	    state._fsp--;

            	    adaptor.addChild(root_0, array_element136.getTree());

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
    // TwigParser.g:190:1: array_element : ( STRING | STRING_LITERAL | NUMBER | json );
    public final TwigParser.array_element_return array_element() throws RecognitionException {
        TwigParser.array_element_return retval = new TwigParser.array_element_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING137=null;
        CommonToken STRING_LITERAL138=null;
        CommonToken NUMBER139=null;
        TwigParser.json_return json140 = null;


        TwigCommonTree STRING137_tree=null;
        TwigCommonTree STRING_LITERAL138_tree=null;
        TwigCommonTree NUMBER139_tree=null;

        try {
            // TwigParser.g:191:3: ( STRING | STRING_LITERAL | NUMBER | json )
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
                    // TwigParser.g:191:5: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING137=(CommonToken)match(input,STRING,FOLLOW_STRING_in_array_element940); 
                    STRING137_tree = (TwigCommonTree)adaptor.create(STRING137);
                    adaptor.addChild(root_0, STRING137_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:191:14: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL138=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_array_element944); 
                    STRING_LITERAL138_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL138);
                    adaptor.addChild(root_0, STRING_LITERAL138_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:191:31: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER139=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_array_element948); 
                    NUMBER139_tree = (TwigCommonTree)adaptor.create(NUMBER139);
                    adaptor.addChild(root_0, NUMBER139_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:191:40: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_array_element952);
                    json140=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json140.getTree());

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
    // TwigParser.g:194:1: variable : param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) ;
    public final TwigParser.variable_return variable() throws RecognitionException {
        TwigParser.variable_return retval = new TwigParser.variable_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;
        CommonToken DOT141=null;
        CommonToken STRING142=null;

        TwigCommonTree param_tree=null;
        TwigCommonTree DOT141_tree=null;
        TwigCommonTree STRING142_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // TwigParser.g:195:3: (param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) )
            // TwigParser.g:195:5: param= STRING ( DOT ( STRING ) )*
            {
            param=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable969);  
            stream_STRING.add(param);

            // TwigParser.g:195:18: ( DOT ( STRING ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==DOT) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // TwigParser.g:195:19: DOT ( STRING )
            	    {
            	    DOT141=(CommonToken)match(input,DOT,FOLLOW_DOT_in_variable972);  
            	    stream_DOT.add(DOT141);

            	    // TwigParser.g:195:23: ( STRING )
            	    // TwigParser.g:195:24: STRING
            	    {
            	    STRING142=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable975);  
            	    stream_STRING.add(STRING142);


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
            // 196:5: -> ^( TWIG_VAR $param)
            {
                // TwigParser.g:196:7: ^( TWIG_VAR $param)
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

    public static class method_chain_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "method_chain"
    // TwigParser.g:200:1: method_chain : method ( DOT method )* ;
    public final TwigParser.method_chain_return method_chain() throws RecognitionException {
        TwigParser.method_chain_return retval = new TwigParser.method_chain_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken DOT144=null;
        TwigParser.method_return method143 = null;

        TwigParser.method_return method145 = null;


        TwigCommonTree DOT144_tree=null;

        try {
            // TwigParser.g:201:3: ( method ( DOT method )* )
            // TwigParser.g:201:5: method ( DOT method )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_method_in_method_chain1007);
            method143=method();

            state._fsp--;

            adaptor.addChild(root_0, method143.getTree());
            // TwigParser.g:201:12: ( DOT method )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==DOT) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // TwigParser.g:201:13: DOT method
            	    {
            	    DOT144=(CommonToken)match(input,DOT,FOLLOW_DOT_in_method_chain1010); 
            	    DOT144_tree = (TwigCommonTree)adaptor.create(DOT144);
            	    adaptor.addChild(root_0, DOT144_tree);

            	    pushFollow(FOLLOW_method_in_method_chain1012);
            	    method145=method();

            	    state._fsp--;

            	    adaptor.addChild(root_0, method145.getTree());

            	    }
            	    break;

            	default :
            	    break loop41;
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
    // TwigParser.g:204:1: method : variable METHOD_START ( arguments )? METHOD_END ;
    public final TwigParser.method_return method() throws RecognitionException {
        TwigParser.method_return retval = new TwigParser.method_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken METHOD_START147=null;
        CommonToken METHOD_END149=null;
        TwigParser.variable_return variable146 = null;

        TwigParser.arguments_return arguments148 = null;


        TwigCommonTree METHOD_START147_tree=null;
        TwigCommonTree METHOD_END149_tree=null;

        try {
            // TwigParser.g:205:3: ( variable METHOD_START ( arguments )? METHOD_END )
            // TwigParser.g:205:5: variable METHOD_START ( arguments )? METHOD_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_in_method1029);
            variable146=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable146.getTree());
            METHOD_START147=(CommonToken)match(input,METHOD_START,FOLLOW_METHOD_START_in_method1031); 
            METHOD_START147_tree = (TwigCommonTree)adaptor.create(METHOD_START147);
            adaptor.addChild(root_0, METHOD_START147_tree);

            // TwigParser.g:205:27: ( arguments )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==JSON_START||LA42_0==NUMBER||LA42_0==STRING||LA42_0==STRING_LITERAL) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // TwigParser.g:205:27: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_method1033);
                    arguments148=arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, arguments148.getTree());

                    }
                    break;

            }

            METHOD_END149=(CommonToken)match(input,METHOD_END,FOLLOW_METHOD_END_in_method1036); 
            METHOD_END149_tree = (TwigCommonTree)adaptor.create(METHOD_END149);
            adaptor.addChild(root_0, METHOD_END149_tree);


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
    // TwigParser.g:208:1: arguments : argument ( COMMA ( argument ) )* ;
    public final TwigParser.arguments_return arguments() throws RecognitionException {
        TwigParser.arguments_return retval = new TwigParser.arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA151=null;
        TwigParser.argument_return argument150 = null;

        TwigParser.argument_return argument152 = null;


        TwigCommonTree COMMA151_tree=null;

        try {
            // TwigParser.g:209:3: ( argument ( COMMA ( argument ) )* )
            // TwigParser.g:209:5: argument ( COMMA ( argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_argument_in_arguments1052);
            argument150=argument();

            state._fsp--;

            adaptor.addChild(root_0, argument150.getTree());
            // TwigParser.g:209:15: ( COMMA ( argument ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==COMMA) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // TwigParser.g:209:16: COMMA ( argument )
            	    {
            	    COMMA151=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_arguments1056); 
            	    COMMA151_tree = (TwigCommonTree)adaptor.create(COMMA151);
            	    adaptor.addChild(root_0, COMMA151_tree);

            	    // TwigParser.g:209:22: ( argument )
            	    // TwigParser.g:209:23: argument
            	    {
            	    pushFollow(FOLLOW_argument_in_arguments1059);
            	    argument152=argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, argument152.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
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
    // TwigParser.g:212:1: argument : ( literal_argument | STRING | json | NUMBER );
    public final TwigParser.argument_return argument() throws RecognitionException {
        TwigParser.argument_return retval = new TwigParser.argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING154=null;
        CommonToken NUMBER156=null;
        TwigParser.literal_argument_return literal_argument153 = null;

        TwigParser.json_return json155 = null;


        TwigCommonTree STRING154_tree=null;
        TwigCommonTree NUMBER156_tree=null;

        try {
            // TwigParser.g:213:1: ( literal_argument | STRING | json | NUMBER )
            int alt44=4;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt44=1;
                }
                break;
            case STRING:
                {
                alt44=2;
                }
                break;
            case JSON_START:
                {
                alt44=3;
                }
                break;
            case NUMBER:
                {
                alt44=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // TwigParser.g:213:3: literal_argument
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_argument_in_argument1073);
                    literal_argument153=literal_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, literal_argument153.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:213:22: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING154=(CommonToken)match(input,STRING,FOLLOW_STRING_in_argument1077); 
                    STRING154_tree = (TwigCommonTree)adaptor.create(STRING154);
                    adaptor.addChild(root_0, STRING154_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:213:31: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_argument1081);
                    json155=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json155.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:213:38: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER156=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_argument1085); 
                    NUMBER156_tree = (TwigCommonTree)adaptor.create(NUMBER156);
                    adaptor.addChild(root_0, NUMBER156_tree);


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
    // TwigParser.g:216:1: literal_argument : param= STRING_LITERAL -> ^( LITERAL_ARG $param) ;
    public final TwigParser.literal_argument_return literal_argument() throws RecognitionException {
        TwigParser.literal_argument_return retval = new TwigParser.literal_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;

        TwigCommonTree param_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");

        try {
            // TwigParser.g:217:3: (param= STRING_LITERAL -> ^( LITERAL_ARG $param) )
            // TwigParser.g:217:5: param= STRING_LITERAL
            {
            param=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal_argument1098);  
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
            // 218:5: -> ^( LITERAL_ARG $param)
            {
                // TwigParser.g:218:8: ^( LITERAL_ARG $param)
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
    // TwigParser.g:221:1: json : JSON_START ( json_arguments )? JSON_END ;
    public final TwigParser.json_return json() throws RecognitionException {
        TwigParser.json_return retval = new TwigParser.json_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken JSON_START157=null;
        CommonToken JSON_END159=null;
        TwigParser.json_arguments_return json_arguments158 = null;


        TwigCommonTree JSON_START157_tree=null;
        TwigCommonTree JSON_END159_tree=null;

        try {
            // TwigParser.g:222:3: ( JSON_START ( json_arguments )? JSON_END )
            // TwigParser.g:222:5: JSON_START ( json_arguments )? JSON_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            JSON_START157=(CommonToken)match(input,JSON_START,FOLLOW_JSON_START_in_json1124); 
            JSON_START157_tree = (TwigCommonTree)adaptor.create(JSON_START157);
            adaptor.addChild(root_0, JSON_START157_tree);

            // TwigParser.g:222:16: ( json_arguments )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==STRING||LA45_0==STRING_LITERAL) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // TwigParser.g:222:16: json_arguments
                    {
                    pushFollow(FOLLOW_json_arguments_in_json1126);
                    json_arguments158=json_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, json_arguments158.getTree());

                    }
                    break;

            }

            JSON_END159=(CommonToken)match(input,JSON_END,FOLLOW_JSON_END_in_json1129); 
            JSON_END159_tree = (TwigCommonTree)adaptor.create(JSON_END159);
            adaptor.addChild(root_0, JSON_END159_tree);


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
    // TwigParser.g:225:1: json_arguments : json_argument ( COMMA ( json_argument ) )* ;
    public final TwigParser.json_arguments_return json_arguments() throws RecognitionException {
        TwigParser.json_arguments_return retval = new TwigParser.json_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA161=null;
        TwigParser.json_argument_return json_argument160 = null;

        TwigParser.json_argument_return json_argument162 = null;


        TwigCommonTree COMMA161_tree=null;

        try {
            // TwigParser.g:226:3: ( json_argument ( COMMA ( json_argument ) )* )
            // TwigParser.g:226:5: json_argument ( COMMA ( json_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_json_argument_in_json_arguments1144);
            json_argument160=json_argument();

            state._fsp--;

            adaptor.addChild(root_0, json_argument160.getTree());
            // TwigParser.g:226:19: ( COMMA ( json_argument ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==COMMA) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // TwigParser.g:226:20: COMMA ( json_argument )
            	    {
            	    COMMA161=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_json_arguments1147); 
            	    COMMA161_tree = (TwigCommonTree)adaptor.create(COMMA161);
            	    adaptor.addChild(root_0, COMMA161_tree);

            	    // TwigParser.g:226:26: ( json_argument )
            	    // TwigParser.g:226:27: json_argument
            	    {
            	    pushFollow(FOLLOW_json_argument_in_json_arguments1150);
            	    json_argument162=json_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, json_argument162.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
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
    // TwigParser.g:229:1: json_argument : ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) ;
    public final TwigParser.json_argument_return json_argument() throws RecognitionException {
        TwigParser.json_argument_return retval = new TwigParser.json_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set163=null;
        CommonToken COLON164=null;
        CommonToken set165=null;

        TwigCommonTree set163_tree=null;
        TwigCommonTree COLON164_tree=null;
        TwigCommonTree set165_tree=null;

        try {
            // TwigParser.g:230:3: ( ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) )
            // TwigParser.g:230:5: ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set163=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set163));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // TwigParser.g:230:31: ( COLON )
            // TwigParser.g:230:32: COLON
            {
            COLON164=(CommonToken)match(input,COLON,FOLLOW_COLON_in_json_argument1177); 
            COLON164_tree = (TwigCommonTree)adaptor.create(COLON164);
            adaptor.addChild(root_0, COLON164_tree);


            }

            set165=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set165));
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
        "\1\56\1\7\1\56\2\uffff\1\7";
    static final String DFA5_maxS =
        "\1\56\1\60\1\56\2\uffff\1\60";
    static final String DFA5_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA5_specialS =
        "\6\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1",
            "\1\3\1\4\1\uffff\1\3\5\uffff\1\2\35\uffff\1\3\1\uffff\1\3",
            "\1\5",
            "",
            "",
            "\1\3\1\4\1\uffff\1\3\5\uffff\1\2\35\uffff\1\3\1\uffff\1\3"
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
            return "95:5: ( variable | method_chain )";
        }
    }
    static final String DFA10_eotS =
        "\10\uffff";
    static final String DFA10_eofS =
        "\10\uffff";
    static final String DFA10_minS =
        "\1\24\1\7\2\uffff\1\56\2\uffff\1\7";
    static final String DFA10_maxS =
        "\1\60\1\52\2\uffff\1\56\2\uffff\1\52";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\4\1\uffff\1\1\1\3\1\uffff";
    static final String DFA10_specialS =
        "\10\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\3\31\uffff\1\1\1\uffff\1\2",
            "\1\5\1\6\7\uffff\1\4\31\uffff\1\5",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\5\1\6\7\uffff\1\4\31\uffff\1\5"
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
            return "107:34: ( variable | STRING_LITERAL | method_chain | json )";
        }
    }
    static final String DFA17_eotS =
        "\151\uffff";
    static final String DFA17_eofS =
        "\151\uffff";
    static final String DFA17_minS =
        "\1\12\2\7\1\24\1\25\2\uffff\1\56\1\uffff\1\11\3\13\1\25\1\21\2\7"+
        "\2\11\1\25\1\11\1\7\1\24\1\7\1\21\1\13\1\56\1\uffff\1\24\1\21\1"+
        "\11\1\56\1\uffff\3\13\1\25\1\uffff\1\56\1\22\2\11\1\25\1\11\1\56"+
        "\1\10\1\21\1\13\1\22\1\56\1\21\1\11\1\22\1\56\1\11\2\56\1\21\2\56"+
        "\1\10\2\11\1\25\1\11\1\7\1\22\1\21\1\56\1\22\1\21\1\24\1\21\1\11"+
        "\2\56\1\22\2\56\2\11\1\25\1\11\1\56\1\21\1\22\1\21\1\22\1\21\1\11"+
        "\1\22\4\56\3\22\1\21\2\56\1\21\1\22\1\56\1\22";
    static final String DFA17_maxS =
        "\1\60\2\22\2\60\2\uffff\1\56\1\uffff\1\60\3\22\1\60\1\21\4\22\1"+
        "\60\2\22\1\60\1\22\1\21\1\22\1\60\1\uffff\1\60\1\21\1\22\1\56\1"+
        "\uffff\3\22\1\60\1\uffff\1\60\1\25\2\22\1\60\1\22\1\60\1\20\1\21"+
        "\1\22\1\25\1\60\1\21\1\22\1\25\1\56\3\60\1\21\2\60\1\20\2\22\1\60"+
        "\2\22\1\25\1\21\1\60\1\25\1\21\1\60\1\21\1\22\2\60\1\25\2\60\2\22"+
        "\1\60\1\22\1\60\1\21\1\25\1\21\1\25\1\21\1\22\1\25\4\60\3\25\1\21"+
        "\2\60\1\21\1\25\1\60\1\25";
    static final String DFA17_acceptS =
        "\5\uffff\1\1\1\6\1\uffff\1\2\22\uffff\1\5\4\uffff\1\3\4\uffff\1"+
        "\4\103\uffff";
    static final String DFA17_specialS =
        "\151\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\3\11\uffff\1\4\31\uffff\1\2\1\uffff\1\1",
            "\1\5\5\uffff\1\6\4\uffff\1\5",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\15\27\uffff\1\14\1\uffff\1\12\1\uffff\1\13",
            "\1\17\30\uffff\1\16\1\uffff\1\16",
            "",
            "",
            "\1\20",
            "",
            "\1\25\12\uffff\1\23\27\uffff\1\24\1\uffff\1\22\1\uffff\1\21",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\31\30\uffff\1\30\1\uffff\1\30",
            "\1\32",
            "\1\33\5\uffff\1\6\4\uffff\1\33",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\36\30\uffff\1\35\1\uffff\1\35",
            "\1\25\10\uffff\1\34",
            "\1\40\5\uffff\1\6\2\uffff\1\37\1\uffff\1\40",
            "\1\44\27\uffff\1\43\1\uffff\1\41\1\uffff\1\42",
            "\1\45\5\uffff\1\6\4\uffff\1\45",
            "\1\46",
            "\1\27\6\uffff\1\26",
            "\1\47\1\uffff\1\47",
            "",
            "\1\52\27\uffff\1\53\1\uffff\1\51\1\uffff\1\50",
            "\1\54",
            "\1\25\10\uffff\1\34",
            "\1\55",
            "",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\57\30\uffff\1\56\1\uffff\1\56",
            "",
            "\1\60\1\uffff\1\60",
            "\1\61\2\uffff\1\17",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\63\30\uffff\1\62\1\uffff\1\62",
            "\1\25\10\uffff\1\34",
            "\1\64\1\uffff\1\64",
            "\1\66\7\uffff\1\65",
            "\1\67",
            "\1\27\6\uffff\1\26",
            "\1\70\2\uffff\1\31",
            "\1\71\1\uffff\1\71",
            "\1\72",
            "\1\25\10\uffff\1\34",
            "\1\73\2\uffff\1\36",
            "\1\74",
            "\1\101\12\uffff\1\77\27\uffff\1\100\1\uffff\1\76\1\uffff\1"+
            "\75",
            "\1\102\1\uffff\1\102",
            "\1\103\1\uffff\1\103",
            "\1\104",
            "\1\105\1\uffff\1\105",
            "\1\106\1\uffff\1\106",
            "\1\66\7\uffff\1\65",
            "\1\101\10\uffff\1\107",
            "\1\101\10\uffff\1\107",
            "\1\111\30\uffff\1\110\1\uffff\1\110",
            "\1\101\10\uffff\1\107",
            "\1\40\5\uffff\1\6\2\uffff\1\37\1\uffff\1\40",
            "\1\112\2\uffff\1\57",
            "\1\113",
            "\1\114\1\uffff\1\114",
            "\1\115\2\uffff\1\63",
            "\1\116",
            "\1\121\27\uffff\1\122\1\uffff\1\120\1\uffff\1\117",
            "\1\123",
            "\1\101\10\uffff\1\107",
            "\1\124\1\uffff\1\124",
            "\1\125\1\uffff\1\125",
            "\1\61\2\uffff\1\17",
            "\1\126\1\uffff\1\126",
            "\1\127\1\uffff\1\127",
            "\1\101\10\uffff\1\107",
            "\1\101\10\uffff\1\107",
            "\1\131\30\uffff\1\130\1\uffff\1\130",
            "\1\101\10\uffff\1\107",
            "\1\132\1\uffff\1\132",
            "\1\133",
            "\1\70\2\uffff\1\31",
            "\1\134",
            "\1\73\2\uffff\1\36",
            "\1\135",
            "\1\101\10\uffff\1\107",
            "\1\136\2\uffff\1\111",
            "\1\137\1\uffff\1\137",
            "\1\140\1\uffff\1\140",
            "\1\141\1\uffff\1\141",
            "\1\142\1\uffff\1\142",
            "\1\112\2\uffff\1\57",
            "\1\115\2\uffff\1\63",
            "\1\143\2\uffff\1\131",
            "\1\144",
            "\1\145\1\uffff\1\145",
            "\1\146\1\uffff\1\146",
            "\1\147",
            "\1\136\2\uffff\1\111",
            "\1\150\1\uffff\1\150",
            "\1\143\2\uffff\1\131"
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
            return "123:5: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )";
        }
    }
    static final String DFA18_eotS =
        "\151\uffff";
    static final String DFA18_eofS =
        "\151\uffff";
    static final String DFA18_minS =
        "\1\12\2\7\1\24\1\25\2\uffff\1\56\1\uffff\1\11\3\13\1\25\1\21\2\7"+
        "\2\11\1\25\1\11\1\7\1\24\1\7\1\21\1\13\1\56\1\uffff\1\24\1\21\1"+
        "\11\1\56\1\uffff\3\13\1\25\1\uffff\1\56\1\22\2\11\1\25\1\11\1\56"+
        "\1\10\1\21\1\13\1\22\1\56\1\21\1\11\1\22\1\56\1\11\2\56\1\21\2\56"+
        "\1\10\2\11\1\25\1\11\1\7\1\22\1\21\1\56\1\22\1\21\1\24\1\21\1\11"+
        "\2\56\1\22\2\56\2\11\1\25\1\11\1\56\1\21\1\22\1\21\1\22\1\21\1\11"+
        "\1\22\4\56\3\22\1\21\2\56\1\21\1\22\1\56\1\22";
    static final String DFA18_maxS =
        "\1\60\2\22\2\60\2\uffff\1\56\1\uffff\1\60\3\22\1\60\1\21\4\22\1"+
        "\60\2\22\1\60\1\22\1\21\1\22\1\60\1\uffff\1\60\1\21\1\22\1\56\1"+
        "\uffff\3\22\1\60\1\uffff\1\60\1\25\2\22\1\60\1\22\1\60\1\20\1\21"+
        "\1\22\1\25\1\60\1\21\1\22\1\25\1\56\3\60\1\21\2\60\1\20\2\22\1\60"+
        "\2\22\1\25\1\21\1\60\1\25\1\21\1\60\1\21\1\22\2\60\1\25\2\60\2\22"+
        "\1\60\1\22\1\60\1\21\1\25\1\21\1\25\1\21\1\22\1\25\4\60\3\25\1\21"+
        "\2\60\1\21\1\25\1\60\1\25";
    static final String DFA18_acceptS =
        "\5\uffff\1\1\1\6\1\uffff\1\2\22\uffff\1\5\4\uffff\1\3\4\uffff\1"+
        "\4\103\uffff";
    static final String DFA18_specialS =
        "\151\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\3\11\uffff\1\4\31\uffff\1\2\1\uffff\1\1",
            "\1\5\5\uffff\1\6\4\uffff\1\5",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\15\27\uffff\1\14\1\uffff\1\12\1\uffff\1\13",
            "\1\17\30\uffff\1\16\1\uffff\1\16",
            "",
            "",
            "\1\20",
            "",
            "\1\25\12\uffff\1\23\27\uffff\1\24\1\uffff\1\22\1\uffff\1\21",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\31\30\uffff\1\30\1\uffff\1\30",
            "\1\32",
            "\1\33\5\uffff\1\6\4\uffff\1\33",
            "\1\10\1\11\4\uffff\1\6\2\uffff\1\7\1\uffff\1\10",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\36\30\uffff\1\35\1\uffff\1\35",
            "\1\25\10\uffff\1\34",
            "\1\40\5\uffff\1\6\2\uffff\1\37\1\uffff\1\40",
            "\1\44\27\uffff\1\43\1\uffff\1\41\1\uffff\1\42",
            "\1\45\5\uffff\1\6\4\uffff\1\45",
            "\1\46",
            "\1\27\6\uffff\1\26",
            "\1\47\1\uffff\1\47",
            "",
            "\1\52\27\uffff\1\53\1\uffff\1\51\1\uffff\1\50",
            "\1\54",
            "\1\25\10\uffff\1\34",
            "\1\55",
            "",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\27\6\uffff\1\26",
            "\1\57\30\uffff\1\56\1\uffff\1\56",
            "",
            "\1\60\1\uffff\1\60",
            "\1\61\2\uffff\1\17",
            "\1\25\10\uffff\1\34",
            "\1\25\10\uffff\1\34",
            "\1\63\30\uffff\1\62\1\uffff\1\62",
            "\1\25\10\uffff\1\34",
            "\1\64\1\uffff\1\64",
            "\1\66\7\uffff\1\65",
            "\1\67",
            "\1\27\6\uffff\1\26",
            "\1\70\2\uffff\1\31",
            "\1\71\1\uffff\1\71",
            "\1\72",
            "\1\25\10\uffff\1\34",
            "\1\73\2\uffff\1\36",
            "\1\74",
            "\1\101\12\uffff\1\77\27\uffff\1\100\1\uffff\1\76\1\uffff\1"+
            "\75",
            "\1\102\1\uffff\1\102",
            "\1\103\1\uffff\1\103",
            "\1\104",
            "\1\105\1\uffff\1\105",
            "\1\106\1\uffff\1\106",
            "\1\66\7\uffff\1\65",
            "\1\101\10\uffff\1\107",
            "\1\101\10\uffff\1\107",
            "\1\111\30\uffff\1\110\1\uffff\1\110",
            "\1\101\10\uffff\1\107",
            "\1\40\5\uffff\1\6\2\uffff\1\37\1\uffff\1\40",
            "\1\112\2\uffff\1\57",
            "\1\113",
            "\1\114\1\uffff\1\114",
            "\1\115\2\uffff\1\63",
            "\1\116",
            "\1\121\27\uffff\1\122\1\uffff\1\120\1\uffff\1\117",
            "\1\123",
            "\1\101\10\uffff\1\107",
            "\1\124\1\uffff\1\124",
            "\1\125\1\uffff\1\125",
            "\1\61\2\uffff\1\17",
            "\1\126\1\uffff\1\126",
            "\1\127\1\uffff\1\127",
            "\1\101\10\uffff\1\107",
            "\1\101\10\uffff\1\107",
            "\1\131\30\uffff\1\130\1\uffff\1\130",
            "\1\101\10\uffff\1\107",
            "\1\132\1\uffff\1\132",
            "\1\133",
            "\1\70\2\uffff\1\31",
            "\1\134",
            "\1\73\2\uffff\1\36",
            "\1\135",
            "\1\101\10\uffff\1\107",
            "\1\136\2\uffff\1\111",
            "\1\137\1\uffff\1\137",
            "\1\140\1\uffff\1\140",
            "\1\141\1\uffff\1\141",
            "\1\142\1\uffff\1\142",
            "\1\112\2\uffff\1\57",
            "\1\115\2\uffff\1\63",
            "\1\143\2\uffff\1\131",
            "\1\144",
            "\1\145\1\uffff\1\145",
            "\1\146\1\uffff\1\146",
            "\1\147",
            "\1\136\2\uffff\1\111",
            "\1\150\1\uffff\1\150",
            "\1\143\2\uffff\1\131"
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
            return "123:92: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )";
        }
    }
    static final String DFA20_eotS =
        "\11\uffff";
    static final String DFA20_eofS =
        "\11\uffff";
    static final String DFA20_minS =
        "\1\12\1\uffff\1\10\2\uffff\1\56\2\uffff\1\10";
    static final String DFA20_maxS =
        "\1\60\1\uffff\1\20\2\uffff\1\56\2\uffff\1\20";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\2\1\3\1\uffff";
    static final String DFA20_specialS =
        "\11\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\11\uffff\1\4\31\uffff\1\2\1\uffff\1\1",
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
            return "127:5: ( STRING_LITERAL | variable | method_chain | array | json )";
        }
    }
    static final String DFA21_eotS =
        "\11\uffff";
    static final String DFA21_eofS =
        "\11\uffff";
    static final String DFA21_minS =
        "\1\12\1\uffff\1\7\2\uffff\1\56\2\uffff\1\7";
    static final String DFA21_maxS =
        "\1\60\1\uffff\1\22\2\uffff\1\56\2\uffff\1\22";
    static final String DFA21_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\2\1\3\1\uffff";
    static final String DFA21_specialS =
        "\11\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\11\uffff\1\4\31\uffff\1\2\1\uffff\1\1",
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
            return "127:69: ( STRING_LITERAL | variable | method_chain | array | json )";
        }
    }
    static final String DFA26_eotS =
        "\6\uffff";
    static final String DFA26_eofS =
        "\6\uffff";
    static final String DFA26_minS =
        "\1\56\1\7\1\56\2\uffff\1\7";
    static final String DFA26_maxS =
        "\1\56\1\20\1\56\2\uffff\1\20";
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
            return "135:12: ( variable | method_chain )";
        }
    }
    static final String DFA29_eotS =
        "\6\uffff";
    static final String DFA29_eofS =
        "\6\uffff";
    static final String DFA29_minS =
        "\1\56\1\7\1\56\2\uffff\1\7";
    static final String DFA29_maxS =
        "\1\56\1\20\1\56\2\uffff\1\20";
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
            return "143:12: ( variable | method_chain )";
        }
    }
    static final String DFA32_eotS =
        "\10\uffff";
    static final String DFA32_eofS =
        "\10\uffff";
    static final String DFA32_minS =
        "\1\54\2\uffff\1\10\1\56\2\uffff\1\10";
    static final String DFA32_maxS =
        "\1\60\2\uffff\1\26\1\56\2\uffff\1\26";
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
            return "163:5: ( STRING_LITERAL | NUMBER | variable | method_chain )";
        }
    }
    static final String DFA33_eotS =
        "\10\uffff";
    static final String DFA33_eofS =
        "\10\uffff";
    static final String DFA33_minS =
        "\1\54\2\uffff\1\10\1\56\2\uffff\1\10";
    static final String DFA33_maxS =
        "\1\60\2\uffff\1\21\1\56\2\uffff\1\21";
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
            return "163:60: ( STRING_LITERAL | NUMBER | variable | method_chain )";
        }
    }
    static final String DFA34_eotS =
        "\10\uffff";
    static final String DFA34_eofS =
        "\10\uffff";
    static final String DFA34_minS =
        "\1\54\2\uffff\1\7\1\56\2\uffff\1\7";
    static final String DFA34_maxS =
        "\1\60\2\uffff\1\52\1\56\2\uffff\1\52";
    static final String DFA34_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA34_specialS =
        "\10\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\5\1\6\7\uffff\1\4\31\uffff\1\5",
            "\1\7",
            "",
            "",
            "\1\5\1\6\7\uffff\1\4\31\uffff\1\5"
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
            return "163:118: ( STRING_LITERAL | NUMBER | variable | method_chain )";
        }
    }
    static final String DFA37_eotS =
        "\10\uffff";
    static final String DFA37_eofS =
        "\10\uffff";
    static final String DFA37_minS =
        "\1\12\1\5\2\uffff\1\56\2\uffff\1\5";
    static final String DFA37_maxS =
        "\1\60\1\20\2\uffff\1\56\2\uffff\1\20";
    static final String DFA37_acceptS =
        "\2\uffff\1\3\1\4\1\uffff\1\1\1\2\1\uffff";
    static final String DFA37_specialS =
        "\10\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\2\43\uffff\1\1\1\uffff\1\3",
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
            return "177:1: p_input : ( variable | method_chain | array | STRING_LITERAL );";
        }
    }
 

    public static final BitSet FOLLOW_twig_print_statement_in_twig_source69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_control_statement_in_twig_source73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTRL_OPEN_in_twig_control_statement89 = new BitSet(new long[]{0x000041FE7F800080L});
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
    public static final BitSet FOLLOW_twig_extends_in_twig_control152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_twig_extends167 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_extends169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_twig_block186 = new BitSet(new long[]{0x0000400010000000L});
    public static final BitSet FOLLOW_twig_block_param_in_twig_block188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDBLOCK_in_twig_block194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_block_param211 = new BitSet(new long[]{0x0001400010000402L});
    public static final BitSet FOLLOW_method_chain_in_twig_block_param215 = new BitSet(new long[]{0x0001400010000402L});
    public static final BitSet FOLLOW_twig_print_in_twig_block_param218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_twig_include234 = new BitSet(new long[]{0x0001500010000000L});
    public static final BitSet FOLLOW_include_ternary_in_twig_include237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_twig_include241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_ternary_in_include_ternary257 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_ternary259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement276 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement279 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_WITH_in_include_statement283 = new BitSet(new long[]{0x0001400010100000L});
    public static final BitSet FOLLOW_variable_in_include_statement286 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement290 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_method_chain_in_include_statement294 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_json_in_include_statement298 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_twig_set320 = new BitSet(new long[]{0x0000400010000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set322 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_set325 = new BitSet(new long[]{0x0000400010000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set327 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ENDSET_in_twig_set334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_left_assignment_in_twig_assignment349 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ASIG_in_twig_assignment352 = new BitSet(new long[]{0x0001400010100400L});
    public static final BitSet FOLLOW_twig_right_assignment_in_twig_assignment354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment372 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_left_assignment375 = new BitSet(new long[]{0x0000400010000000L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment377 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment396 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment400 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_method_chain_in_twig_right_assignment404 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment408 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment412 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment416 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_right_assignment420 = new BitSet(new long[]{0x0001400010100400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment423 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment427 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_method_chain_in_twig_right_assignment431 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment435 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment439 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment443 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument462 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument466 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_method_chain_in_twig_tilde_argument470 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument474 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument478 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_TILDE_in_twig_tilde_argument481 = new BitSet(new long[]{0x0001400010100400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_tilde_argument492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_twig_import517 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import520 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_IMPORT_in_twig_import525 = new BitSet(new long[]{0x0001400010000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import528 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_variable_in_twig_import532 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_TWIG_AS_in_twig_import536 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import539 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_twig_import542 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import544 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_MACRO_in_twig_macro566 = new BitSet(new long[]{0x0000400010000000L});
    public static final BitSet FOLLOW_variable_in_twig_macro569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_macro573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDMACRO_in_twig_macro579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_twig_if594 = new BitSet(new long[]{0x0000400010000000L});
    public static final BitSet FOLLOW_variable_in_twig_if596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_if600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSEIF_in_twig_elseif615 = new BitSet(new long[]{0x0000400010000000L});
    public static final BitSet FOLLOW_variable_in_twig_elseif618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_elseif622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_twig_for638 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_for640 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_IN_in_twig_for642 = new BitSet(new long[]{0x0001500010000000L});
    public static final BitSet FOLLOW_for_arguments_in_twig_for644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_value_in_for_arguments659 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_PIPE_in_for_arguments662 = new BitSet(new long[]{0x0001500010000000L});
    public static final BitSet FOLLOW_for_value_in_for_arguments664 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_STRING_in_for_value681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_for_value685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_for_value689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_for_value693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_range708 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_DDOT_in_range720 = new BitSet(new long[]{0x0001500000000000L});
    public static final BitSet FOLLOW_set_in_range722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary749 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary753 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary757 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary761 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_QM_in_twig_ternary764 = new BitSet(new long[]{0x0001500010000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary767 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary771 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary775 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary779 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_twig_ternary782 = new BitSet(new long[]{0x0001500010000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_ternary793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_OPEN_in_twig_print_statement815 = new BitSet(new long[]{0x0001400010000420L});
    public static final BitSet FOLLOW_twig_print_in_twig_print_statement817 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_PRINT_CLOSE_in_twig_print_statement820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_p_input_in_twig_print847 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_PIPE_in_twig_print850 = new BitSet(new long[]{0x0001400010000400L});
    public static final BitSet FOLLOW_p_input_in_twig_print852 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_variable_in_p_input869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_p_input873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_p_input877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_p_input881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_START_in_array899 = new BitSet(new long[]{0x0001500010100000L});
    public static final BitSet FOLLOW_array_elements_in_array901 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ARRAY_END_in_array903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_element_in_array_elements918 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_array_elements921 = new BitSet(new long[]{0x0001500010100000L});
    public static final BitSet FOLLOW_array_element_in_array_elements923 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_in_array_element940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_array_element944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_array_element948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_array_element952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_variable969 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_DOT_in_variable972 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_STRING_in_variable975 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_method_in_method_chain1007 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_DOT_in_method_chain1010 = new BitSet(new long[]{0x0000400010000000L});
    public static final BitSet FOLLOW_method_in_method_chain1012 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_variable_in_method1029 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_METHOD_START_in_method1031 = new BitSet(new long[]{0x0001500010100200L});
    public static final BitSet FOLLOW_arguments_in_method1033 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_METHOD_END_in_method1036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_arguments1052 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_arguments1056 = new BitSet(new long[]{0x0001500010100000L});
    public static final BitSet FOLLOW_argument_in_arguments1059 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_literal_argument_in_argument1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_argument1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_argument1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_argument1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal_argument1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_START_in_json1124 = new BitSet(new long[]{0x0001400000200000L});
    public static final BitSet FOLLOW_json_arguments_in_json1126 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_JSON_END_in_json1129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1144 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_COMMA_in_json_arguments1147 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1150 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_set_in_json_argument1168 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON_in_json_argument1177 = new BitSet(new long[]{0x0001400000000000L});
    public static final BitSet FOLLOW_set_in_json_argument1180 = new BitSet(new long[]{0x0000000000000002L});

}