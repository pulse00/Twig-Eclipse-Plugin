// $ANTLR 3.3 Nov 30, 2010 12:45:30 TwigParser.g 2011-07-10 14:44:24

package org.eclipse.twig.core.parser;

import org.eclipse.twig.core.parser.error.IErrorReporter;
import org.eclipse.twig.core.TwigCorePlugin;
import org.eclipse.twig.core.log.Logger;




import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class TwigParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PRINT_OPEN", "PRINT_CLOSE", "CTRL_OPEN", "CTRL_CLOSE", "METHOD_START", "METHOD_END", "ARRAY_START", "ARRAY_END", "ASIG", "LARGER", "SMALLER", "EQUAL", "NOTEQUAL", "TILDE", "PIPE", "DDOT", "DOT", "COLON", "COMMA", "BSLASH", "JSON_START", "JSON_END", "QM", "BLOCK", "ENDBLOCK", "FOR", "ENDFOR", "ELSE", "IF", "ELSEIF", "ENDIF", "IN", "TWIG_AS", "MACRO", "ENDMACRO", "IMPORT", "EXTENDS", "USE", "FROM", "SET", "NOT", "ENDSET", "INCLUDE", "WITH", "ONLY", "IS", "DEFINED", "DIGIT", "NUMBER", "STRING_CHAR", "STRING", "NONCONTROL_CHAR", "STRING_LITERAL", "LOWER", "UPPER", "UNDER", "LETTER", "SYMBOL", "WHITESPACE", "TWIG_PR_STMT", "TWIG_VAR", "LITERAL_ARG"
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
    public static final int PIPE=18;
    public static final int DDOT=19;
    public static final int DOT=20;
    public static final int COLON=21;
    public static final int COMMA=22;
    public static final int BSLASH=23;
    public static final int JSON_START=24;
    public static final int JSON_END=25;
    public static final int QM=26;
    public static final int BLOCK=27;
    public static final int ENDBLOCK=28;
    public static final int FOR=29;
    public static final int ENDFOR=30;
    public static final int ELSE=31;
    public static final int IF=32;
    public static final int ELSEIF=33;
    public static final int ENDIF=34;
    public static final int IN=35;
    public static final int TWIG_AS=36;
    public static final int MACRO=37;
    public static final int ENDMACRO=38;
    public static final int IMPORT=39;
    public static final int EXTENDS=40;
    public static final int USE=41;
    public static final int FROM=42;
    public static final int SET=43;
    public static final int NOT=44;
    public static final int ENDSET=45;
    public static final int INCLUDE=46;
    public static final int WITH=47;
    public static final int ONLY=48;
    public static final int IS=49;
    public static final int DEFINED=50;
    public static final int DIGIT=51;
    public static final int NUMBER=52;
    public static final int STRING_CHAR=53;
    public static final int STRING=54;
    public static final int NONCONTROL_CHAR=55;
    public static final int STRING_LITERAL=56;
    public static final int LOWER=57;
    public static final int UPPER=58;
    public static final int UNDER=59;
    public static final int LETTER=60;
    public static final int SYMBOL=61;
    public static final int WHITESPACE=62;
    public static final int TWIG_PR_STMT=63;
    public static final int TWIG_VAR=64;
    public static final int LITERAL_ARG=65;

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
    // TwigParser.g:73:1: twig_source : ( twig_print_statement | twig_control_statement );
    public final TwigParser.twig_source_return twig_source() throws RecognitionException {
        TwigParser.twig_source_return retval = new TwigParser.twig_source_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.twig_print_statement_return twig_print_statement1 = null;

        TwigParser.twig_control_statement_return twig_control_statement2 = null;



        try {
            // TwigParser.g:74:3: ( twig_print_statement | twig_control_statement )
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
                    // TwigParser.g:74:5: twig_print_statement
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_print_statement_in_twig_source69);
                    twig_print_statement1=twig_print_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_print_statement1.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:74:28: twig_control_statement
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

            CTRL_OPEN3=(CommonToken)match(input,CTRL_OPEN,FOLLOW_CTRL_OPEN_in_twig_control_statement89); 
            CTRL_OPEN3_tree = (TwigCommonTree)adaptor.create(CTRL_OPEN3);
            adaptor.addChild(root_0, CTRL_OPEN3_tree);

            // TwigParser.g:81:15: ( twig_control )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=BLOCK && LA2_0<=ENDIF)||(LA2_0>=MACRO && LA2_0<=SET)||(LA2_0>=ENDSET && LA2_0<=INCLUDE)||LA2_0==STRING) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // TwigParser.g:81:15: twig_control
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
    // TwigParser.g:85:1: twig_control : ( variable | twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include | twig_block | twig_extends | twig_use | assets );
    public final TwigParser.twig_control_return twig_control() throws RecognitionException {
        TwigParser.twig_control_return retval = new TwigParser.twig_control_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ENDFOR8=null;
        CommonToken ELSE9=null;
        CommonToken ENDIF12=null;
        TwigParser.variable_return variable6 = null;

        TwigParser.twig_for_return twig_for7 = null;

        TwigParser.twig_if_return twig_if10 = null;

        TwigParser.twig_elseif_return twig_elseif11 = null;

        TwigParser.twig_macro_return twig_macro13 = null;

        TwigParser.twig_import_return twig_import14 = null;

        TwigParser.twig_set_return twig_set15 = null;

        TwigParser.twig_include_return twig_include16 = null;

        TwigParser.twig_block_return twig_block17 = null;

        TwigParser.twig_extends_return twig_extends18 = null;

        TwigParser.twig_use_return twig_use19 = null;

        TwigParser.assets_return assets20 = null;


        TwigCommonTree ENDFOR8_tree=null;
        TwigCommonTree ELSE9_tree=null;
        TwigCommonTree ENDIF12_tree=null;

        try {
            // TwigParser.g:86:3: ( variable | twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include | twig_block | twig_extends | twig_use | assets )
            int alt3=15;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // TwigParser.g:86:5: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_twig_control108);
                    variable6=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable6.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:86:16: twig_for
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_for_in_twig_control112);
                    twig_for7=twig_for();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_for7.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:86:27: ENDFOR
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDFOR8=(CommonToken)match(input,ENDFOR,FOLLOW_ENDFOR_in_twig_control116); 
                    ENDFOR8_tree = (TwigCommonTree)adaptor.create(ENDFOR8);
                    adaptor.addChild(root_0, ENDFOR8_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:86:36: ELSE
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ELSE9=(CommonToken)match(input,ELSE,FOLLOW_ELSE_in_twig_control120); 
                    ELSE9_tree = (TwigCommonTree)adaptor.create(ELSE9);
                    adaptor.addChild(root_0, ELSE9_tree);


                    }
                    break;
                case 5 :
                    // TwigParser.g:86:43: twig_if
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_if_in_twig_control124);
                    twig_if10=twig_if();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_if10.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:86:53: twig_elseif
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_elseif_in_twig_control128);
                    twig_elseif11=twig_elseif();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_elseif11.getTree());

                    }
                    break;
                case 7 :
                    // TwigParser.g:86:67: ENDIF
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDIF12=(CommonToken)match(input,ENDIF,FOLLOW_ENDIF_in_twig_control132); 
                    ENDIF12_tree = (TwigCommonTree)adaptor.create(ENDIF12);
                    adaptor.addChild(root_0, ENDIF12_tree);


                    }
                    break;
                case 8 :
                    // TwigParser.g:86:75: twig_macro
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_macro_in_twig_control136);
                    twig_macro13=twig_macro();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_macro13.getTree());

                    }
                    break;
                case 9 :
                    // TwigParser.g:86:88: twig_import
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_import_in_twig_control140);
                    twig_import14=twig_import();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_import14.getTree());

                    }
                    break;
                case 10 :
                    // TwigParser.g:86:102: twig_set
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_set_in_twig_control144);
                    twig_set15=twig_set();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_set15.getTree());

                    }
                    break;
                case 11 :
                    // TwigParser.g:86:113: twig_include
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_include_in_twig_control148);
                    twig_include16=twig_include();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_include16.getTree());

                    }
                    break;
                case 12 :
                    // TwigParser.g:86:128: twig_block
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_block_in_twig_control152);
                    twig_block17=twig_block();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_block17.getTree());

                    }
                    break;
                case 13 :
                    // TwigParser.g:86:141: twig_extends
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_extends_in_twig_control156);
                    twig_extends18=twig_extends();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_extends18.getTree());

                    }
                    break;
                case 14 :
                    // TwigParser.g:86:156: twig_use
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_use_in_twig_control160);
                    twig_use19=twig_use();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_use19.getTree());

                    }
                    break;
                case 15 :
                    // TwigParser.g:86:167: assets
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assets_in_twig_control164);
                    assets20=assets();

                    state._fsp--;

                    adaptor.addChild(root_0, assets20.getTree());

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

    public static class assets_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assets"
    // TwigParser.g:89:1: assets : variable ( STRING_LITERAL )+ ;
    public final TwigParser.assets_return assets() throws RecognitionException {
        TwigParser.assets_return retval = new TwigParser.assets_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL22=null;
        TwigParser.variable_return variable21 = null;


        TwigCommonTree STRING_LITERAL22_tree=null;

        try {
            // TwigParser.g:90:3: ( variable ( STRING_LITERAL )+ )
            // TwigParser.g:90:5: variable ( STRING_LITERAL )+
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_in_assets178);
            variable21=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable21.getTree());
            // TwigParser.g:90:14: ( STRING_LITERAL )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==STRING_LITERAL) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // TwigParser.g:90:14: STRING_LITERAL
            	    {
            	    STRING_LITERAL22=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_assets180); 
            	    STRING_LITERAL22_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL22);
            	    adaptor.addChild(root_0, STRING_LITERAL22_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
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
    // $ANTLR end "assets"

    public static class twig_use_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_use"
    // TwigParser.g:93:1: twig_use : USE STRING_LITERAL ;
    public final TwigParser.twig_use_return twig_use() throws RecognitionException {
        TwigParser.twig_use_return retval = new TwigParser.twig_use_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken USE23=null;
        CommonToken STRING_LITERAL24=null;

        TwigCommonTree USE23_tree=null;
        TwigCommonTree STRING_LITERAL24_tree=null;

        try {
            // TwigParser.g:94:3: ( USE STRING_LITERAL )
            // TwigParser.g:94:5: USE STRING_LITERAL
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            USE23=(CommonToken)match(input,USE,FOLLOW_USE_in_twig_use198); 
            USE23_tree = (TwigCommonTree)adaptor.create(USE23);
            adaptor.addChild(root_0, USE23_tree);

            STRING_LITERAL24=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_use200); 
            STRING_LITERAL24_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL24);
            adaptor.addChild(root_0, STRING_LITERAL24_tree);


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
    // $ANTLR end "twig_use"

    public static class twig_extends_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_extends"
    // TwigParser.g:96:1: twig_extends : EXTENDS STRING_LITERAL ;
    public final TwigParser.twig_extends_return twig_extends() throws RecognitionException {
        TwigParser.twig_extends_return retval = new TwigParser.twig_extends_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken EXTENDS25=null;
        CommonToken STRING_LITERAL26=null;

        TwigCommonTree EXTENDS25_tree=null;
        TwigCommonTree STRING_LITERAL26_tree=null;

        try {
            // TwigParser.g:97:3: ( EXTENDS STRING_LITERAL )
            // TwigParser.g:97:5: EXTENDS STRING_LITERAL
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            EXTENDS25=(CommonToken)match(input,EXTENDS,FOLLOW_EXTENDS_in_twig_extends213); 
            EXTENDS25_tree = (TwigCommonTree)adaptor.create(EXTENDS25);
            adaptor.addChild(root_0, EXTENDS25_tree);

            STRING_LITERAL26=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_extends215); 
            STRING_LITERAL26_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL26);
            adaptor.addChild(root_0, STRING_LITERAL26_tree);


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
    // TwigParser.g:100:1: twig_block : ( ( BLOCK twig_block_param ) | ( ENDBLOCK ( variable )? ) );
    public final TwigParser.twig_block_return twig_block() throws RecognitionException {
        TwigParser.twig_block_return retval = new TwigParser.twig_block_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken BLOCK27=null;
        CommonToken ENDBLOCK29=null;
        TwigParser.twig_block_param_return twig_block_param28 = null;

        TwigParser.variable_return variable30 = null;


        TwigCommonTree BLOCK27_tree=null;
        TwigCommonTree ENDBLOCK29_tree=null;

        try {
            // TwigParser.g:101:3: ( ( BLOCK twig_block_param ) | ( ENDBLOCK ( variable )? ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==BLOCK) ) {
                alt6=1;
            }
            else if ( (LA6_0==ENDBLOCK) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // TwigParser.g:101:5: ( BLOCK twig_block_param )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:101:5: ( BLOCK twig_block_param )
                    // TwigParser.g:101:6: BLOCK twig_block_param
                    {
                    BLOCK27=(CommonToken)match(input,BLOCK,FOLLOW_BLOCK_in_twig_block232); 
                    BLOCK27_tree = (TwigCommonTree)adaptor.create(BLOCK27);
                    adaptor.addChild(root_0, BLOCK27_tree);

                    pushFollow(FOLLOW_twig_block_param_in_twig_block234);
                    twig_block_param28=twig_block_param();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_block_param28.getTree());

                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:101:32: ( ENDBLOCK ( variable )? )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:101:32: ( ENDBLOCK ( variable )? )
                    // TwigParser.g:101:33: ENDBLOCK ( variable )?
                    {
                    ENDBLOCK29=(CommonToken)match(input,ENDBLOCK,FOLLOW_ENDBLOCK_in_twig_block240); 
                    ENDBLOCK29_tree = (TwigCommonTree)adaptor.create(ENDBLOCK29);
                    adaptor.addChild(root_0, ENDBLOCK29_tree);

                    // TwigParser.g:101:42: ( variable )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==STRING) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // TwigParser.g:101:42: variable
                            {
                            pushFollow(FOLLOW_variable_in_twig_block242);
                            variable30=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable30.getTree());

                            }
                            break;

                    }


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
    // TwigParser.g:104:1: twig_block_param : ( variable | method_chain | concat ) ( twig_print )? ;
    public final TwigParser.twig_block_param_return twig_block_param() throws RecognitionException {
        TwigParser.twig_block_param_return retval = new TwigParser.twig_block_param_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.variable_return variable31 = null;

        TwigParser.method_chain_return method_chain32 = null;

        TwigParser.concat_return concat33 = null;

        TwigParser.twig_print_return twig_print34 = null;



        try {
            // TwigParser.g:105:3: ( ( variable | method_chain | concat ) ( twig_print )? )
            // TwigParser.g:105:5: ( variable | method_chain | concat ) ( twig_print )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:105:5: ( variable | method_chain | concat )
            int alt7=3;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // TwigParser.g:105:6: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_block_param260);
                    variable31=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable31.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:105:17: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_block_param264);
                    method_chain32=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain32.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:105:32: concat
                    {
                    pushFollow(FOLLOW_concat_in_twig_block_param268);
                    concat33=concat();

                    state._fsp--;

                    adaptor.addChild(root_0, concat33.getTree());

                    }
                    break;

            }

            // TwigParser.g:105:40: ( twig_print )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ARRAY_START||LA8_0==NOT||LA8_0==NUMBER||LA8_0==STRING||LA8_0==STRING_LITERAL) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // TwigParser.g:105:40: twig_print
                    {
                    pushFollow(FOLLOW_twig_print_in_twig_block_param271);
                    twig_print34=twig_print();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_print34.getTree());

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
    // TwigParser.g:108:1: twig_include : INCLUDE ( include_ternary | include_statement ) ;
    public final TwigParser.twig_include_return twig_include() throws RecognitionException {
        TwigParser.twig_include_return retval = new TwigParser.twig_include_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken INCLUDE35=null;
        TwigParser.include_ternary_return include_ternary36 = null;

        TwigParser.include_statement_return include_statement37 = null;


        TwigCommonTree INCLUDE35_tree=null;

        try {
            // TwigParser.g:109:3: ( INCLUDE ( include_ternary | include_statement ) )
            // TwigParser.g:109:5: INCLUDE ( include_ternary | include_statement )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            INCLUDE35=(CommonToken)match(input,INCLUDE,FOLLOW_INCLUDE_in_twig_include287); 
            INCLUDE35_tree = (TwigCommonTree)adaptor.create(INCLUDE35);
            adaptor.addChild(root_0, INCLUDE35_tree);

            // TwigParser.g:109:13: ( include_ternary | include_statement )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==STRING_LITERAL) ) {
                int LA9_1 = input.LA(2);

                if ( ((LA9_1>=LARGER && LA9_1<=NOTEQUAL)||LA9_1==QM) ) {
                    alt9=1;
                }
                else if ( (LA9_1==CTRL_CLOSE||(LA9_1>=WITH && LA9_1<=ONLY)) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA9_0==NUMBER||LA9_0==STRING) ) {
                alt9=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // TwigParser.g:109:14: include_ternary
                    {
                    pushFollow(FOLLOW_include_ternary_in_twig_include290);
                    include_ternary36=include_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, include_ternary36.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:109:32: include_statement
                    {
                    pushFollow(FOLLOW_include_statement_in_twig_include294);
                    include_statement37=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement37.getTree());

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
    // TwigParser.g:112:1: include_ternary : twig_ternary ( ONLY )? ;
    public final TwigParser.include_ternary_return include_ternary() throws RecognitionException {
        TwigParser.include_ternary_return retval = new TwigParser.include_ternary_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ONLY39=null;
        TwigParser.twig_ternary_return twig_ternary38 = null;


        TwigCommonTree ONLY39_tree=null;

        try {
            // TwigParser.g:113:3: ( twig_ternary ( ONLY )? )
            // TwigParser.g:113:5: twig_ternary ( ONLY )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_ternary_in_include_ternary310);
            twig_ternary38=twig_ternary();

            state._fsp--;

            adaptor.addChild(root_0, twig_ternary38.getTree());
            // TwigParser.g:113:18: ( ONLY )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ONLY) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // TwigParser.g:113:18: ONLY
                    {
                    ONLY39=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_ternary312); 
                    ONLY39_tree = (TwigCommonTree)adaptor.create(ONLY39);
                    adaptor.addChild(root_0, ONLY39_tree);


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
    // TwigParser.g:116:1: include_statement : ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )? ;
    public final TwigParser.include_statement_return include_statement() throws RecognitionException {
        TwigParser.include_statement_return retval = new TwigParser.include_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL40=null;
        CommonToken ONLY41=null;
        CommonToken WITH42=null;
        CommonToken STRING_LITERAL44=null;
        CommonToken ONLY47=null;
        TwigParser.variable_return variable43 = null;

        TwigParser.method_chain_return method_chain45 = null;

        TwigParser.json_return json46 = null;


        TwigCommonTree STRING_LITERAL40_tree=null;
        TwigCommonTree ONLY41_tree=null;
        TwigCommonTree WITH42_tree=null;
        TwigCommonTree STRING_LITERAL44_tree=null;
        TwigCommonTree ONLY47_tree=null;

        try {
            // TwigParser.g:117:3: ( ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )? )
            // TwigParser.g:117:5: ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:117:5: ( STRING_LITERAL )
            // TwigParser.g:117:6: STRING_LITERAL
            {
            STRING_LITERAL40=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement329); 
            STRING_LITERAL40_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL40);
            adaptor.addChild(root_0, STRING_LITERAL40_tree);


            }

            // TwigParser.g:117:22: ( ONLY )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ONLY) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // TwigParser.g:117:22: ONLY
                    {
                    ONLY41=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement332); 
                    ONLY41_tree = (TwigCommonTree)adaptor.create(ONLY41);
                    adaptor.addChild(root_0, ONLY41_tree);


                    }
                    break;

            }

            // TwigParser.g:117:28: ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==WITH) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // TwigParser.g:117:29: WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )?
                    {
                    WITH42=(CommonToken)match(input,WITH,FOLLOW_WITH_in_include_statement336); 
                    WITH42_tree = (TwigCommonTree)adaptor.create(WITH42);
                    adaptor.addChild(root_0, WITH42_tree);

                    // TwigParser.g:117:34: ( variable | STRING_LITERAL | method_chain | json )
                    int alt12=4;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // TwigParser.g:117:35: variable
                            {
                            pushFollow(FOLLOW_variable_in_include_statement339);
                            variable43=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable43.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:117:46: STRING_LITERAL
                            {
                            STRING_LITERAL44=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement343); 
                            STRING_LITERAL44_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL44);
                            adaptor.addChild(root_0, STRING_LITERAL44_tree);


                            }
                            break;
                        case 3 :
                            // TwigParser.g:117:63: method_chain
                            {
                            pushFollow(FOLLOW_method_chain_in_include_statement347);
                            method_chain45=method_chain();

                            state._fsp--;

                            adaptor.addChild(root_0, method_chain45.getTree());

                            }
                            break;
                        case 4 :
                            // TwigParser.g:117:78: json
                            {
                            pushFollow(FOLLOW_json_in_include_statement351);
                            json46=json();

                            state._fsp--;

                            adaptor.addChild(root_0, json46.getTree());

                            }
                            break;

                    }

                    // TwigParser.g:117:84: ( ONLY )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==ONLY) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // TwigParser.g:117:84: ONLY
                            {
                            ONLY47=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement354); 
                            ONLY47_tree = (TwigCommonTree)adaptor.create(ONLY47);
                            adaptor.addChild(root_0, ONLY47_tree);


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
    // TwigParser.g:120:1: twig_set : ( ( SET twig_assignment ( COMMA twig_assignment )* ) | ENDSET );
    public final TwigParser.twig_set_return twig_set() throws RecognitionException {
        TwigParser.twig_set_return retval = new TwigParser.twig_set_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken SET48=null;
        CommonToken COMMA50=null;
        CommonToken ENDSET52=null;
        TwigParser.twig_assignment_return twig_assignment49 = null;

        TwigParser.twig_assignment_return twig_assignment51 = null;


        TwigCommonTree SET48_tree=null;
        TwigCommonTree COMMA50_tree=null;
        TwigCommonTree ENDSET52_tree=null;

        try {
            // TwigParser.g:121:3: ( ( SET twig_assignment ( COMMA twig_assignment )* ) | ENDSET )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==SET) ) {
                alt16=1;
            }
            else if ( (LA16_0==ENDSET) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // TwigParser.g:121:5: ( SET twig_assignment ( COMMA twig_assignment )* )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:121:5: ( SET twig_assignment ( COMMA twig_assignment )* )
                    // TwigParser.g:121:6: SET twig_assignment ( COMMA twig_assignment )*
                    {
                    SET48=(CommonToken)match(input,SET,FOLLOW_SET_in_twig_set373); 
                    SET48_tree = (TwigCommonTree)adaptor.create(SET48);
                    adaptor.addChild(root_0, SET48_tree);

                    pushFollow(FOLLOW_twig_assignment_in_twig_set375);
                    twig_assignment49=twig_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_assignment49.getTree());
                    // TwigParser.g:121:26: ( COMMA twig_assignment )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==COMMA) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // TwigParser.g:121:27: COMMA twig_assignment
                    	    {
                    	    COMMA50=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_set378); 
                    	    COMMA50_tree = (TwigCommonTree)adaptor.create(COMMA50);
                    	    adaptor.addChild(root_0, COMMA50_tree);

                    	    pushFollow(FOLLOW_twig_assignment_in_twig_set380);
                    	    twig_assignment51=twig_assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, twig_assignment51.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:121:54: ENDSET
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDSET52=(CommonToken)match(input,ENDSET,FOLLOW_ENDSET_in_twig_set387); 
                    ENDSET52_tree = (TwigCommonTree)adaptor.create(ENDSET52);
                    adaptor.addChild(root_0, ENDSET52_tree);


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
    // TwigParser.g:124:1: twig_assignment : twig_left_assignment ( ASIG ( twig_right_assignment ( PIPE twig_right_assignment )* ) )? ;
    public final TwigParser.twig_assignment_return twig_assignment() throws RecognitionException {
        TwigParser.twig_assignment_return retval = new TwigParser.twig_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ASIG54=null;
        CommonToken PIPE56=null;
        TwigParser.twig_left_assignment_return twig_left_assignment53 = null;

        TwigParser.twig_right_assignment_return twig_right_assignment55 = null;

        TwigParser.twig_right_assignment_return twig_right_assignment57 = null;


        TwigCommonTree ASIG54_tree=null;
        TwigCommonTree PIPE56_tree=null;

        try {
            // TwigParser.g:125:3: ( twig_left_assignment ( ASIG ( twig_right_assignment ( PIPE twig_right_assignment )* ) )? )
            // TwigParser.g:125:6: twig_left_assignment ( ASIG ( twig_right_assignment ( PIPE twig_right_assignment )* ) )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_left_assignment_in_twig_assignment402);
            twig_left_assignment53=twig_left_assignment();

            state._fsp--;

            adaptor.addChild(root_0, twig_left_assignment53.getTree());
            // TwigParser.g:125:27: ( ASIG ( twig_right_assignment ( PIPE twig_right_assignment )* ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ASIG) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // TwigParser.g:125:28: ASIG ( twig_right_assignment ( PIPE twig_right_assignment )* )
                    {
                    ASIG54=(CommonToken)match(input,ASIG,FOLLOW_ASIG_in_twig_assignment405); 
                    ASIG54_tree = (TwigCommonTree)adaptor.create(ASIG54);
                    adaptor.addChild(root_0, ASIG54_tree);

                    // TwigParser.g:125:33: ( twig_right_assignment ( PIPE twig_right_assignment )* )
                    // TwigParser.g:125:34: twig_right_assignment ( PIPE twig_right_assignment )*
                    {
                    pushFollow(FOLLOW_twig_right_assignment_in_twig_assignment408);
                    twig_right_assignment55=twig_right_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_right_assignment55.getTree());
                    // TwigParser.g:125:56: ( PIPE twig_right_assignment )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==PIPE) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // TwigParser.g:125:57: PIPE twig_right_assignment
                    	    {
                    	    PIPE56=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_assignment411); 
                    	    PIPE56_tree = (TwigCommonTree)adaptor.create(PIPE56);
                    	    adaptor.addChild(root_0, PIPE56_tree);

                    	    pushFollow(FOLLOW_twig_right_assignment_in_twig_assignment413);
                    	    twig_right_assignment57=twig_right_assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, twig_right_assignment57.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
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
    // $ANTLR end "twig_assignment"

    public static class twig_left_assignment_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_left_assignment"
    // TwigParser.g:128:1: twig_left_assignment : ( variable ( COMMA variable )* ) ;
    public final TwigParser.twig_left_assignment_return twig_left_assignment() throws RecognitionException {
        TwigParser.twig_left_assignment_return retval = new TwigParser.twig_left_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA59=null;
        TwigParser.variable_return variable58 = null;

        TwigParser.variable_return variable60 = null;


        TwigCommonTree COMMA59_tree=null;

        try {
            // TwigParser.g:129:3: ( ( variable ( COMMA variable )* ) )
            // TwigParser.g:129:5: ( variable ( COMMA variable )* )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:129:5: ( variable ( COMMA variable )* )
            // TwigParser.g:129:6: variable ( COMMA variable )*
            {
            pushFollow(FOLLOW_variable_in_twig_left_assignment434);
            variable58=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable58.getTree());
            // TwigParser.g:129:15: ( COMMA variable )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==COMMA) ) {
                    int LA19_2 = input.LA(2);

                    if ( (LA19_2==STRING) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // TwigParser.g:129:16: COMMA variable
            	    {
            	    COMMA59=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_left_assignment437); 
            	    COMMA59_tree = (TwigCommonTree)adaptor.create(COMMA59);
            	    adaptor.addChild(root_0, COMMA59_tree);

            	    pushFollow(FOLLOW_variable_in_twig_left_assignment439);
            	    variable60=variable();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable60.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // TwigParser.g:132:1: twig_right_assignment : ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) )* ;
    public final TwigParser.twig_right_assignment_return twig_right_assignment() throws RecognitionException {
        TwigParser.twig_right_assignment_return retval = new TwigParser.twig_right_assignment_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL61=null;
        CommonToken COMMA67=null;
        CommonToken STRING_LITERAL68=null;
        TwigParser.variable_return variable62 = null;

        TwigParser.method_chain_return method_chain63 = null;

        TwigParser.array_return array64 = null;

        TwigParser.json_return json65 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument66 = null;

        TwigParser.variable_return variable69 = null;

        TwigParser.method_chain_return method_chain70 = null;

        TwigParser.array_return array71 = null;

        TwigParser.json_return json72 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument73 = null;


        TwigCommonTree STRING_LITERAL61_tree=null;
        TwigCommonTree COMMA67_tree=null;
        TwigCommonTree STRING_LITERAL68_tree=null;

        try {
            // TwigParser.g:133:3: ( ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) )* )
            // TwigParser.g:133:5: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) ( COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:133:5: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )
            int alt20=6;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // TwigParser.g:133:6: STRING_LITERAL
                    {
                    STRING_LITERAL61=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment458); 
                    STRING_LITERAL61_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL61);
                    adaptor.addChild(root_0, STRING_LITERAL61_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:133:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_right_assignment462);
                    variable62=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable62.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:133:34: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_right_assignment466);
                    method_chain63=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain63.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:133:49: array
                    {
                    pushFollow(FOLLOW_array_in_twig_right_assignment470);
                    array64=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array64.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:133:57: json
                    {
                    pushFollow(FOLLOW_json_in_twig_right_assignment474);
                    json65=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json65.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:133:64: twig_tilde_argument
                    {
                    pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment478);
                    twig_tilde_argument66=twig_tilde_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_tilde_argument66.getTree());

                    }
                    break;

            }

            // TwigParser.g:133:85: ( COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==COMMA) ) {
                    int LA22_2 = input.LA(2);

                    if ( (LA22_2==ARRAY_START||LA22_2==JSON_START||LA22_2==STRING||LA22_2==STRING_LITERAL) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // TwigParser.g:133:86: COMMA ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )
            	    {
            	    COMMA67=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_right_assignment482); 
            	    COMMA67_tree = (TwigCommonTree)adaptor.create(COMMA67);
            	    adaptor.addChild(root_0, COMMA67_tree);

            	    // TwigParser.g:133:92: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )
            	    int alt21=6;
            	    alt21 = dfa21.predict(input);
            	    switch (alt21) {
            	        case 1 :
            	            // TwigParser.g:133:93: STRING_LITERAL
            	            {
            	            STRING_LITERAL68=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment485); 
            	            STRING_LITERAL68_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL68);
            	            adaptor.addChild(root_0, STRING_LITERAL68_tree);


            	            }
            	            break;
            	        case 2 :
            	            // TwigParser.g:133:110: variable
            	            {
            	            pushFollow(FOLLOW_variable_in_twig_right_assignment489);
            	            variable69=variable();

            	            state._fsp--;

            	            adaptor.addChild(root_0, variable69.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // TwigParser.g:133:121: method_chain
            	            {
            	            pushFollow(FOLLOW_method_chain_in_twig_right_assignment493);
            	            method_chain70=method_chain();

            	            state._fsp--;

            	            adaptor.addChild(root_0, method_chain70.getTree());

            	            }
            	            break;
            	        case 4 :
            	            // TwigParser.g:133:136: array
            	            {
            	            pushFollow(FOLLOW_array_in_twig_right_assignment497);
            	            array71=array();

            	            state._fsp--;

            	            adaptor.addChild(root_0, array71.getTree());

            	            }
            	            break;
            	        case 5 :
            	            // TwigParser.g:133:144: json
            	            {
            	            pushFollow(FOLLOW_json_in_twig_right_assignment501);
            	            json72=json();

            	            state._fsp--;

            	            adaptor.addChild(root_0, json72.getTree());

            	            }
            	            break;
            	        case 6 :
            	            // TwigParser.g:133:151: twig_tilde_argument
            	            {
            	            pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment505);
            	            twig_tilde_argument73=twig_tilde_argument();

            	            state._fsp--;

            	            adaptor.addChild(root_0, twig_tilde_argument73.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // TwigParser.g:136:1: twig_tilde_argument : ( STRING_LITERAL | variable | method_chain | array | json ) TILDE ( STRING_LITERAL | variable | method_chain | array | json ) ;
    public final TwigParser.twig_tilde_argument_return twig_tilde_argument() throws RecognitionException {
        TwigParser.twig_tilde_argument_return retval = new TwigParser.twig_tilde_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL74=null;
        CommonToken TILDE79=null;
        CommonToken STRING_LITERAL80=null;
        TwigParser.variable_return variable75 = null;

        TwigParser.method_chain_return method_chain76 = null;

        TwigParser.array_return array77 = null;

        TwigParser.json_return json78 = null;

        TwigParser.variable_return variable81 = null;

        TwigParser.method_chain_return method_chain82 = null;

        TwigParser.array_return array83 = null;

        TwigParser.json_return json84 = null;


        TwigCommonTree STRING_LITERAL74_tree=null;
        TwigCommonTree TILDE79_tree=null;
        TwigCommonTree STRING_LITERAL80_tree=null;

        try {
            // TwigParser.g:137:3: ( ( STRING_LITERAL | variable | method_chain | array | json ) TILDE ( STRING_LITERAL | variable | method_chain | array | json ) )
            // TwigParser.g:137:5: ( STRING_LITERAL | variable | method_chain | array | json ) TILDE ( STRING_LITERAL | variable | method_chain | array | json )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:137:5: ( STRING_LITERAL | variable | method_chain | array | json )
            int alt23=5;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // TwigParser.g:137:6: STRING_LITERAL
                    {
                    STRING_LITERAL74=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument524); 
                    STRING_LITERAL74_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL74);
                    adaptor.addChild(root_0, STRING_LITERAL74_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:137:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument528);
                    variable75=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable75.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:137:34: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_tilde_argument532);
                    method_chain76=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain76.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:137:49: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument536);
                    array77=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array77.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:137:57: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument540);
                    json78=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json78.getTree());

                    }
                    break;

            }

            TILDE79=(CommonToken)match(input,TILDE,FOLLOW_TILDE_in_twig_tilde_argument543); 
            TILDE79_tree = (TwigCommonTree)adaptor.create(TILDE79);
            adaptor.addChild(root_0, TILDE79_tree);

            // TwigParser.g:137:69: ( STRING_LITERAL | variable | method_chain | array | json )
            int alt24=5;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // TwigParser.g:137:70: STRING_LITERAL
                    {
                    STRING_LITERAL80=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument546); 
                    STRING_LITERAL80_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL80);
                    adaptor.addChild(root_0, STRING_LITERAL80_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:137:87: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument550);
                    variable81=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable81.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:137:98: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_tilde_argument554);
                    method_chain82=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain82.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:137:113: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument558);
                    array83=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array83.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:137:121: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument562);
                    json84=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json84.getTree());

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
    // TwigParser.g:140:1: twig_import : ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )? ;
    public final TwigParser.twig_import_return twig_import() throws RecognitionException {
        TwigParser.twig_import_return retval = new TwigParser.twig_import_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken FROM85=null;
        CommonToken STRING_LITERAL86=null;
        CommonToken IMPORT87=null;
        CommonToken STRING_LITERAL88=null;
        CommonToken TWIG_AS90=null;
        CommonToken STRING91=null;
        CommonToken COMMA92=null;
        CommonToken STRING93=null;
        TwigParser.variable_return variable89 = null;


        TwigCommonTree FROM85_tree=null;
        TwigCommonTree STRING_LITERAL86_tree=null;
        TwigCommonTree IMPORT87_tree=null;
        TwigCommonTree STRING_LITERAL88_tree=null;
        TwigCommonTree TWIG_AS90_tree=null;
        TwigCommonTree STRING91_tree=null;
        TwigCommonTree COMMA92_tree=null;
        TwigCommonTree STRING93_tree=null;

        try {
            // TwigParser.g:141:3: ( ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )? )
            // TwigParser.g:141:5: ( FROM ( STRING_LITERAL ) )? IMPORT ( STRING_LITERAL | variable ) ( TWIG_AS ( STRING ( COMMA STRING )* ) )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:141:5: ( FROM ( STRING_LITERAL ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==FROM) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // TwigParser.g:141:6: FROM ( STRING_LITERAL )
                    {
                    FROM85=(CommonToken)match(input,FROM,FOLLOW_FROM_in_twig_import579); 
                    FROM85_tree = (TwigCommonTree)adaptor.create(FROM85);
                    adaptor.addChild(root_0, FROM85_tree);

                    // TwigParser.g:141:11: ( STRING_LITERAL )
                    // TwigParser.g:141:12: STRING_LITERAL
                    {
                    STRING_LITERAL86=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import582); 
                    STRING_LITERAL86_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL86);
                    adaptor.addChild(root_0, STRING_LITERAL86_tree);


                    }


                    }
                    break;

            }

            IMPORT87=(CommonToken)match(input,IMPORT,FOLLOW_IMPORT_in_twig_import587); 
            IMPORT87_tree = (TwigCommonTree)adaptor.create(IMPORT87);
            adaptor.addChild(root_0, IMPORT87_tree);

            // TwigParser.g:141:37: ( STRING_LITERAL | variable )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==STRING_LITERAL) ) {
                alt26=1;
            }
            else if ( (LA26_0==STRING) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // TwigParser.g:141:38: STRING_LITERAL
                    {
                    STRING_LITERAL88=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import590); 
                    STRING_LITERAL88_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL88);
                    adaptor.addChild(root_0, STRING_LITERAL88_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:141:55: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_import594);
                    variable89=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable89.getTree());

                    }
                    break;

            }

            // TwigParser.g:141:65: ( TWIG_AS ( STRING ( COMMA STRING )* ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==TWIG_AS) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // TwigParser.g:141:66: TWIG_AS ( STRING ( COMMA STRING )* )
                    {
                    TWIG_AS90=(CommonToken)match(input,TWIG_AS,FOLLOW_TWIG_AS_in_twig_import598); 
                    TWIG_AS90_tree = (TwigCommonTree)adaptor.create(TWIG_AS90);
                    adaptor.addChild(root_0, TWIG_AS90_tree);

                    // TwigParser.g:141:74: ( STRING ( COMMA STRING )* )
                    // TwigParser.g:141:75: STRING ( COMMA STRING )*
                    {
                    STRING91=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import601); 
                    STRING91_tree = (TwigCommonTree)adaptor.create(STRING91);
                    adaptor.addChild(root_0, STRING91_tree);

                    // TwigParser.g:141:82: ( COMMA STRING )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==COMMA) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // TwigParser.g:141:83: COMMA STRING
                    	    {
                    	    COMMA92=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_import604); 
                    	    COMMA92_tree = (TwigCommonTree)adaptor.create(COMMA92);
                    	    adaptor.addChild(root_0, COMMA92_tree);

                    	    STRING93=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import606); 
                    	    STRING93_tree = (TwigCommonTree)adaptor.create(STRING93);
                    	    adaptor.addChild(root_0, STRING93_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
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
    // TwigParser.g:144:1: twig_macro : ( ( MACRO ( variable | method_chain ) ) | ENDMACRO );
    public final TwigParser.twig_macro_return twig_macro() throws RecognitionException {
        TwigParser.twig_macro_return retval = new TwigParser.twig_macro_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken MACRO94=null;
        CommonToken ENDMACRO97=null;
        TwigParser.variable_return variable95 = null;

        TwigParser.method_chain_return method_chain96 = null;


        TwigCommonTree MACRO94_tree=null;
        TwigCommonTree ENDMACRO97_tree=null;

        try {
            // TwigParser.g:145:3: ( ( MACRO ( variable | method_chain ) ) | ENDMACRO )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==MACRO) ) {
                alt30=1;
            }
            else if ( (LA30_0==ENDMACRO) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // TwigParser.g:145:5: ( MACRO ( variable | method_chain ) )
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    // TwigParser.g:145:5: ( MACRO ( variable | method_chain ) )
                    // TwigParser.g:145:6: MACRO ( variable | method_chain )
                    {
                    MACRO94=(CommonToken)match(input,MACRO,FOLLOW_MACRO_in_twig_macro628); 
                    MACRO94_tree = (TwigCommonTree)adaptor.create(MACRO94);
                    adaptor.addChild(root_0, MACRO94_tree);

                    // TwigParser.g:145:12: ( variable | method_chain )
                    int alt29=2;
                    alt29 = dfa29.predict(input);
                    switch (alt29) {
                        case 1 :
                            // TwigParser.g:145:13: variable
                            {
                            pushFollow(FOLLOW_variable_in_twig_macro631);
                            variable95=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable95.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:145:24: method_chain
                            {
                            pushFollow(FOLLOW_method_chain_in_twig_macro635);
                            method_chain96=method_chain();

                            state._fsp--;

                            adaptor.addChild(root_0, method_chain96.getTree());

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // TwigParser.g:145:41: ENDMACRO
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    ENDMACRO97=(CommonToken)match(input,ENDMACRO,FOLLOW_ENDMACRO_in_twig_macro641); 
                    ENDMACRO97_tree = (TwigCommonTree)adaptor.create(ENDMACRO97);
                    adaptor.addChild(root_0, ENDMACRO97_tree);


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
    // TwigParser.g:148:1: twig_if : IF ( ( variable | method_chain | eq_check ) ( PIPE ( variable | method_chain | eq_check ) )* ) ( IS DEFINED )? ;
    public final TwigParser.twig_if_return twig_if() throws RecognitionException {
        TwigParser.twig_if_return retval = new TwigParser.twig_if_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken IF98=null;
        CommonToken PIPE102=null;
        CommonToken IS106=null;
        CommonToken DEFINED107=null;
        TwigParser.variable_return variable99 = null;

        TwigParser.method_chain_return method_chain100 = null;

        TwigParser.eq_check_return eq_check101 = null;

        TwigParser.variable_return variable103 = null;

        TwigParser.method_chain_return method_chain104 = null;

        TwigParser.eq_check_return eq_check105 = null;


        TwigCommonTree IF98_tree=null;
        TwigCommonTree PIPE102_tree=null;
        TwigCommonTree IS106_tree=null;
        TwigCommonTree DEFINED107_tree=null;

        try {
            // TwigParser.g:149:3: ( IF ( ( variable | method_chain | eq_check ) ( PIPE ( variable | method_chain | eq_check ) )* ) ( IS DEFINED )? )
            // TwigParser.g:149:5: IF ( ( variable | method_chain | eq_check ) ( PIPE ( variable | method_chain | eq_check ) )* ) ( IS DEFINED )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            IF98=(CommonToken)match(input,IF,FOLLOW_IF_in_twig_if656); 
            IF98_tree = (TwigCommonTree)adaptor.create(IF98);
            adaptor.addChild(root_0, IF98_tree);

            // TwigParser.g:149:8: ( ( variable | method_chain | eq_check ) ( PIPE ( variable | method_chain | eq_check ) )* )
            // TwigParser.g:149:10: ( variable | method_chain | eq_check ) ( PIPE ( variable | method_chain | eq_check ) )*
            {
            // TwigParser.g:149:10: ( variable | method_chain | eq_check )
            int alt31=3;
            alt31 = dfa31.predict(input);
            switch (alt31) {
                case 1 :
                    // TwigParser.g:149:11: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_if661);
                    variable99=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable99.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:149:22: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_if665);
                    method_chain100=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain100.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:149:37: eq_check
                    {
                    pushFollow(FOLLOW_eq_check_in_twig_if669);
                    eq_check101=eq_check();

                    state._fsp--;

                    adaptor.addChild(root_0, eq_check101.getTree());

                    }
                    break;

            }

            // TwigParser.g:149:47: ( PIPE ( variable | method_chain | eq_check ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==PIPE) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // TwigParser.g:149:48: PIPE ( variable | method_chain | eq_check )
            	    {
            	    PIPE102=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_if673); 
            	    PIPE102_tree = (TwigCommonTree)adaptor.create(PIPE102);
            	    adaptor.addChild(root_0, PIPE102_tree);

            	    // TwigParser.g:149:53: ( variable | method_chain | eq_check )
            	    int alt32=3;
            	    alt32 = dfa32.predict(input);
            	    switch (alt32) {
            	        case 1 :
            	            // TwigParser.g:149:54: variable
            	            {
            	            pushFollow(FOLLOW_variable_in_twig_if676);
            	            variable103=variable();

            	            state._fsp--;

            	            adaptor.addChild(root_0, variable103.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // TwigParser.g:149:65: method_chain
            	            {
            	            pushFollow(FOLLOW_method_chain_in_twig_if680);
            	            method_chain104=method_chain();

            	            state._fsp--;

            	            adaptor.addChild(root_0, method_chain104.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // TwigParser.g:149:80: eq_check
            	            {
            	            pushFollow(FOLLOW_eq_check_in_twig_if684);
            	            eq_check105=eq_check();

            	            state._fsp--;

            	            adaptor.addChild(root_0, eq_check105.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            // TwigParser.g:149:93: ( IS DEFINED )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==IS) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // TwigParser.g:149:94: IS DEFINED
                    {
                    IS106=(CommonToken)match(input,IS,FOLLOW_IS_in_twig_if691); 
                    IS106_tree = (TwigCommonTree)adaptor.create(IS106);
                    adaptor.addChild(root_0, IS106_tree);

                    DEFINED107=(CommonToken)match(input,DEFINED,FOLLOW_DEFINED_in_twig_if693); 
                    DEFINED107_tree = (TwigCommonTree)adaptor.create(DEFINED107);
                    adaptor.addChild(root_0, DEFINED107_tree);


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
    // $ANTLR end "twig_if"

    public static class twig_elseif_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_elseif"
    // TwigParser.g:152:1: twig_elseif : ELSEIF ( variable | method_chain ) ;
    public final TwigParser.twig_elseif_return twig_elseif() throws RecognitionException {
        TwigParser.twig_elseif_return retval = new TwigParser.twig_elseif_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ELSEIF108=null;
        TwigParser.variable_return variable109 = null;

        TwigParser.method_chain_return method_chain110 = null;


        TwigCommonTree ELSEIF108_tree=null;

        try {
            // TwigParser.g:153:3: ( ELSEIF ( variable | method_chain ) )
            // TwigParser.g:153:5: ELSEIF ( variable | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ELSEIF108=(CommonToken)match(input,ELSEIF,FOLLOW_ELSEIF_in_twig_elseif710); 
            ELSEIF108_tree = (TwigCommonTree)adaptor.create(ELSEIF108);
            adaptor.addChild(root_0, ELSEIF108_tree);

            // TwigParser.g:153:12: ( variable | method_chain )
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // TwigParser.g:153:13: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_elseif713);
                    variable109=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable109.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:153:24: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_elseif717);
                    method_chain110=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain110.getTree());

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
    // TwigParser.g:156:1: twig_for : FOR ( STRING ( COMMA STRING )* ) IN for_arguments ;
    public final TwigParser.twig_for_return twig_for() throws RecognitionException {
        TwigParser.twig_for_return retval = new TwigParser.twig_for_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken FOR111=null;
        CommonToken STRING112=null;
        CommonToken COMMA113=null;
        CommonToken STRING114=null;
        CommonToken IN115=null;
        TwigParser.for_arguments_return for_arguments116 = null;


        TwigCommonTree FOR111_tree=null;
        TwigCommonTree STRING112_tree=null;
        TwigCommonTree COMMA113_tree=null;
        TwigCommonTree STRING114_tree=null;
        TwigCommonTree IN115_tree=null;

        try {
            // TwigParser.g:157:3: ( FOR ( STRING ( COMMA STRING )* ) IN for_arguments )
            // TwigParser.g:157:5: FOR ( STRING ( COMMA STRING )* ) IN for_arguments
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            FOR111=(CommonToken)match(input,FOR,FOLLOW_FOR_in_twig_for733); 
            FOR111_tree = (TwigCommonTree)adaptor.create(FOR111);
            adaptor.addChild(root_0, FOR111_tree);

            // TwigParser.g:157:9: ( STRING ( COMMA STRING )* )
            // TwigParser.g:157:10: STRING ( COMMA STRING )*
            {
            STRING112=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_for736); 
            STRING112_tree = (TwigCommonTree)adaptor.create(STRING112);
            adaptor.addChild(root_0, STRING112_tree);

            // TwigParser.g:157:17: ( COMMA STRING )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==COMMA) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // TwigParser.g:157:18: COMMA STRING
            	    {
            	    COMMA113=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_for739); 
            	    COMMA113_tree = (TwigCommonTree)adaptor.create(COMMA113);
            	    adaptor.addChild(root_0, COMMA113_tree);

            	    STRING114=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_for741); 
            	    STRING114_tree = (TwigCommonTree)adaptor.create(STRING114);
            	    adaptor.addChild(root_0, STRING114_tree);


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            IN115=(CommonToken)match(input,IN,FOLLOW_IN_in_twig_for746); 
            IN115_tree = (TwigCommonTree)adaptor.create(IN115);
            adaptor.addChild(root_0, IN115_tree);

            pushFollow(FOLLOW_for_arguments_in_twig_for748);
            for_arguments116=for_arguments();

            state._fsp--;

            adaptor.addChild(root_0, for_arguments116.getTree());

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
    // TwigParser.g:160:1: for_arguments : for_value ( PIPE for_value )* ;
    public final TwigParser.for_arguments_return for_arguments() throws RecognitionException {
        TwigParser.for_arguments_return retval = new TwigParser.for_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE118=null;
        TwigParser.for_value_return for_value117 = null;

        TwigParser.for_value_return for_value119 = null;


        TwigCommonTree PIPE118_tree=null;

        try {
            // TwigParser.g:161:3: ( for_value ( PIPE for_value )* )
            // TwigParser.g:161:5: for_value ( PIPE for_value )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_for_value_in_for_arguments763);
            for_value117=for_value();

            state._fsp--;

            adaptor.addChild(root_0, for_value117.getTree());
            // TwigParser.g:161:15: ( PIPE for_value )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==PIPE) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // TwigParser.g:161:16: PIPE for_value
            	    {
            	    PIPE118=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_for_arguments766); 
            	    PIPE118_tree = (TwigCommonTree)adaptor.create(PIPE118);
            	    adaptor.addChild(root_0, PIPE118_tree);

            	    pushFollow(FOLLOW_for_value_in_for_arguments768);
            	    for_value119=for_value();

            	    state._fsp--;

            	    adaptor.addChild(root_0, for_value119.getTree());

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
    // $ANTLR end "for_arguments"

    public static class for_value_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "for_value"
    // TwigParser.g:164:1: for_value : ( STRING_LITERAL | method_chain | range | variable );
    public final TwigParser.for_value_return for_value() throws RecognitionException {
        TwigParser.for_value_return retval = new TwigParser.for_value_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL120=null;
        TwigParser.method_chain_return method_chain121 = null;

        TwigParser.range_return range122 = null;

        TwigParser.variable_return variable123 = null;


        TwigCommonTree STRING_LITERAL120_tree=null;

        try {
            // TwigParser.g:165:3: ( STRING_LITERAL | method_chain | range | variable )
            int alt38=4;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // TwigParser.g:165:6: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL120=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_for_value786); 
                    STRING_LITERAL120_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL120);
                    adaptor.addChild(root_0, STRING_LITERAL120_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:165:23: method_chain
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_chain_in_for_value790);
                    method_chain121=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain121.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:165:38: range
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_range_in_for_value794);
                    range122=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range122.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:165:46: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_for_value798);
                    variable123=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable123.getTree());

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
    // TwigParser.g:168:1: range : ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) ;
    public final TwigParser.range_return range() throws RecognitionException {
        TwigParser.range_return retval = new TwigParser.range_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set124=null;
        CommonToken DDOT125=null;
        CommonToken set126=null;

        TwigCommonTree set124_tree=null;
        TwigCommonTree DDOT125_tree=null;
        TwigCommonTree set126_tree=null;

        try {
            // TwigParser.g:169:3: ( ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) )
            // TwigParser.g:169:5: ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set124=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set124));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            DDOT125=(CommonToken)match(input,DDOT,FOLLOW_DDOT_in_range825); 
            DDOT125_tree = (TwigCommonTree)adaptor.create(DDOT125);
            adaptor.addChild(root_0, DDOT125_tree);

            set126=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set126));
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
    // TwigParser.g:172:1: twig_ternary : ( STRING_LITERAL | NUMBER | variable | method_chain | eq_check ) QM ( STRING_LITERAL | NUMBER | variable | method_chain ) COLON ( STRING_LITERAL | NUMBER | variable | method_chain ) ;
    public final TwigParser.twig_ternary_return twig_ternary() throws RecognitionException {
        TwigParser.twig_ternary_return retval = new TwigParser.twig_ternary_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL127=null;
        CommonToken NUMBER128=null;
        CommonToken QM132=null;
        CommonToken STRING_LITERAL133=null;
        CommonToken NUMBER134=null;
        CommonToken COLON137=null;
        CommonToken STRING_LITERAL138=null;
        CommonToken NUMBER139=null;
        TwigParser.variable_return variable129 = null;

        TwigParser.method_chain_return method_chain130 = null;

        TwigParser.eq_check_return eq_check131 = null;

        TwigParser.variable_return variable135 = null;

        TwigParser.method_chain_return method_chain136 = null;

        TwigParser.variable_return variable140 = null;

        TwigParser.method_chain_return method_chain141 = null;


        TwigCommonTree STRING_LITERAL127_tree=null;
        TwigCommonTree NUMBER128_tree=null;
        TwigCommonTree QM132_tree=null;
        TwigCommonTree STRING_LITERAL133_tree=null;
        TwigCommonTree NUMBER134_tree=null;
        TwigCommonTree COLON137_tree=null;
        TwigCommonTree STRING_LITERAL138_tree=null;
        TwigCommonTree NUMBER139_tree=null;

        try {
            // TwigParser.g:173:3: ( ( STRING_LITERAL | NUMBER | variable | method_chain | eq_check ) QM ( STRING_LITERAL | NUMBER | variable | method_chain ) COLON ( STRING_LITERAL | NUMBER | variable | method_chain ) )
            // TwigParser.g:173:5: ( STRING_LITERAL | NUMBER | variable | method_chain | eq_check ) QM ( STRING_LITERAL | NUMBER | variable | method_chain ) COLON ( STRING_LITERAL | NUMBER | variable | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:173:5: ( STRING_LITERAL | NUMBER | variable | method_chain | eq_check )
            int alt39=5;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // TwigParser.g:173:6: STRING_LITERAL
                    {
                    STRING_LITERAL127=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary854); 
                    STRING_LITERAL127_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL127);
                    adaptor.addChild(root_0, STRING_LITERAL127_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:173:23: NUMBER
                    {
                    NUMBER128=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary858); 
                    NUMBER128_tree = (TwigCommonTree)adaptor.create(NUMBER128);
                    adaptor.addChild(root_0, NUMBER128_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:173:32: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary862);
                    variable129=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable129.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:173:43: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary866);
                    method_chain130=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain130.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:173:58: eq_check
                    {
                    pushFollow(FOLLOW_eq_check_in_twig_ternary870);
                    eq_check131=eq_check();

                    state._fsp--;

                    adaptor.addChild(root_0, eq_check131.getTree());

                    }
                    break;

            }

            QM132=(CommonToken)match(input,QM,FOLLOW_QM_in_twig_ternary873); 
            QM132_tree = (TwigCommonTree)adaptor.create(QM132);
            adaptor.addChild(root_0, QM132_tree);

            // TwigParser.g:173:71: ( STRING_LITERAL | NUMBER | variable | method_chain )
            int alt40=4;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // TwigParser.g:173:72: STRING_LITERAL
                    {
                    STRING_LITERAL133=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary876); 
                    STRING_LITERAL133_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL133);
                    adaptor.addChild(root_0, STRING_LITERAL133_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:173:89: NUMBER
                    {
                    NUMBER134=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary880); 
                    NUMBER134_tree = (TwigCommonTree)adaptor.create(NUMBER134);
                    adaptor.addChild(root_0, NUMBER134_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:173:98: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary884);
                    variable135=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable135.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:173:109: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary888);
                    method_chain136=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain136.getTree());

                    }
                    break;

            }

            COLON137=(CommonToken)match(input,COLON,FOLLOW_COLON_in_twig_ternary891); 
            COLON137_tree = (TwigCommonTree)adaptor.create(COLON137);
            adaptor.addChild(root_0, COLON137_tree);

            // TwigParser.g:173:129: ( STRING_LITERAL | NUMBER | variable | method_chain )
            int alt41=4;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // TwigParser.g:173:130: STRING_LITERAL
                    {
                    STRING_LITERAL138=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary894); 
                    STRING_LITERAL138_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL138);
                    adaptor.addChild(root_0, STRING_LITERAL138_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:173:147: NUMBER
                    {
                    NUMBER139=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary898); 
                    NUMBER139_tree = (TwigCommonTree)adaptor.create(NUMBER139);
                    adaptor.addChild(root_0, NUMBER139_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:173:156: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary902);
                    variable140=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable140.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:173:167: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary906);
                    method_chain141=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain141.getTree());

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
    // TwigParser.g:177:1: eq_check : ( variable | method_chain | NUMBER | STRING_LITERAL ) ( EQUAL | NOTEQUAL | LARGER | SMALLER ) ( variable | method_chain | NUMBER | STRING_LITERAL ) ;
    public final TwigParser.eq_check_return eq_check() throws RecognitionException {
        TwigParser.eq_check_return retval = new TwigParser.eq_check_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken NUMBER144=null;
        CommonToken STRING_LITERAL145=null;
        CommonToken set146=null;
        CommonToken NUMBER149=null;
        CommonToken STRING_LITERAL150=null;
        TwigParser.variable_return variable142 = null;

        TwigParser.method_chain_return method_chain143 = null;

        TwigParser.variable_return variable147 = null;

        TwigParser.method_chain_return method_chain148 = null;


        TwigCommonTree NUMBER144_tree=null;
        TwigCommonTree STRING_LITERAL145_tree=null;
        TwigCommonTree set146_tree=null;
        TwigCommonTree NUMBER149_tree=null;
        TwigCommonTree STRING_LITERAL150_tree=null;

        try {
            // TwigParser.g:178:3: ( ( variable | method_chain | NUMBER | STRING_LITERAL ) ( EQUAL | NOTEQUAL | LARGER | SMALLER ) ( variable | method_chain | NUMBER | STRING_LITERAL ) )
            // TwigParser.g:178:5: ( variable | method_chain | NUMBER | STRING_LITERAL ) ( EQUAL | NOTEQUAL | LARGER | SMALLER ) ( variable | method_chain | NUMBER | STRING_LITERAL )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:178:5: ( variable | method_chain | NUMBER | STRING_LITERAL )
            int alt42=4;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // TwigParser.g:178:6: variable
                    {
                    pushFollow(FOLLOW_variable_in_eq_check923);
                    variable142=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable142.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:178:17: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_eq_check927);
                    method_chain143=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain143.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:178:32: NUMBER
                    {
                    NUMBER144=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_eq_check931); 
                    NUMBER144_tree = (TwigCommonTree)adaptor.create(NUMBER144);
                    adaptor.addChild(root_0, NUMBER144_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:178:41: STRING_LITERAL
                    {
                    STRING_LITERAL145=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_eq_check935); 
                    STRING_LITERAL145_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL145);
                    adaptor.addChild(root_0, STRING_LITERAL145_tree);


                    }
                    break;

            }

            set146=(CommonToken)input.LT(1);
            if ( (input.LA(1)>=LARGER && input.LA(1)<=NOTEQUAL) ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set146));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // TwigParser.g:178:95: ( variable | method_chain | NUMBER | STRING_LITERAL )
            int alt43=4;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // TwigParser.g:178:96: variable
                    {
                    pushFollow(FOLLOW_variable_in_eq_check955);
                    variable147=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable147.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:178:107: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_eq_check959);
                    method_chain148=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain148.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:178:122: NUMBER
                    {
                    NUMBER149=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_eq_check963); 
                    NUMBER149_tree = (TwigCommonTree)adaptor.create(NUMBER149);
                    adaptor.addChild(root_0, NUMBER149_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:178:131: STRING_LITERAL
                    {
                    STRING_LITERAL150=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_eq_check967); 
                    STRING_LITERAL150_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL150);
                    adaptor.addChild(root_0, STRING_LITERAL150_tree);


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
    // TwigParser.g:183:1: twig_print_statement : PRINT_OPEN ( twig_print )? PRINT_CLOSE -> ^( TWIG_PR_STMT ( twig_print )? ) ;
    public final TwigParser.twig_print_statement_return twig_print_statement() throws RecognitionException {
        TwigParser.twig_print_statement_return retval = new TwigParser.twig_print_statement_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PRINT_OPEN151=null;
        CommonToken PRINT_CLOSE153=null;
        TwigParser.twig_print_return twig_print152 = null;


        TwigCommonTree PRINT_OPEN151_tree=null;
        TwigCommonTree PRINT_CLOSE153_tree=null;
        RewriteRuleTokenStream stream_PRINT_OPEN=new RewriteRuleTokenStream(adaptor,"token PRINT_OPEN");
        RewriteRuleTokenStream stream_PRINT_CLOSE=new RewriteRuleTokenStream(adaptor,"token PRINT_CLOSE");
        RewriteRuleSubtreeStream stream_twig_print=new RewriteRuleSubtreeStream(adaptor,"rule twig_print");
        try {
            // TwigParser.g:184:3: ( PRINT_OPEN ( twig_print )? PRINT_CLOSE -> ^( TWIG_PR_STMT ( twig_print )? ) )
            // TwigParser.g:184:6: PRINT_OPEN ( twig_print )? PRINT_CLOSE
            {
            PRINT_OPEN151=(CommonToken)match(input,PRINT_OPEN,FOLLOW_PRINT_OPEN_in_twig_print_statement988);  
            stream_PRINT_OPEN.add(PRINT_OPEN151);

            // TwigParser.g:184:17: ( twig_print )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==ARRAY_START||LA44_0==NOT||LA44_0==NUMBER||LA44_0==STRING||LA44_0==STRING_LITERAL) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // TwigParser.g:184:17: twig_print
                    {
                    pushFollow(FOLLOW_twig_print_in_twig_print_statement990);
                    twig_print152=twig_print();

                    state._fsp--;

                    stream_twig_print.add(twig_print152.getTree());

                    }
                    break;

            }

            PRINT_CLOSE153=(CommonToken)match(input,PRINT_CLOSE,FOLLOW_PRINT_CLOSE_in_twig_print_statement993);  
            stream_PRINT_CLOSE.add(PRINT_CLOSE153);



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
            // 185:5: -> ^( TWIG_PR_STMT ( twig_print )? )
            {
                // TwigParser.g:185:7: ^( TWIG_PR_STMT ( twig_print )? )
                {
                TwigCommonTree root_1 = (TwigCommonTree)adaptor.nil();
                root_1 = (TwigCommonTree)adaptor.becomeRoot((TwigCommonTree)adaptor.create(TWIG_PR_STMT, "TWIG_PR_STMT"), root_1);

                // TwigParser.g:185:22: ( twig_print )?
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
    // TwigParser.g:188:1: twig_print : p_input ( PIPE p_input )* ;
    public final TwigParser.twig_print_return twig_print() throws RecognitionException {
        TwigParser.twig_print_return retval = new TwigParser.twig_print_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken PIPE155=null;
        TwigParser.p_input_return p_input154 = null;

        TwigParser.p_input_return p_input156 = null;


        TwigCommonTree PIPE155_tree=null;

        try {
            // TwigParser.g:189:3: ( p_input ( PIPE p_input )* )
            // TwigParser.g:189:5: p_input ( PIPE p_input )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_p_input_in_twig_print1020);
            p_input154=p_input();

            state._fsp--;

            adaptor.addChild(root_0, p_input154.getTree());
            // TwigParser.g:189:13: ( PIPE p_input )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==PIPE) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // TwigParser.g:189:14: PIPE p_input
            	    {
            	    PIPE155=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_print1023); 
            	    PIPE155_tree = (TwigCommonTree)adaptor.create(PIPE155);
            	    adaptor.addChild(root_0, PIPE155_tree);

            	    pushFollow(FOLLOW_p_input_in_twig_print1025);
            	    p_input156=p_input();

            	    state._fsp--;

            	    adaptor.addChild(root_0, p_input156.getTree());

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
    // $ANTLR end "twig_print"

    public static class p_input_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "p_input"
    // TwigParser.g:192:1: p_input : ( variable | method_chain | array | STRING_LITERAL | twig_ternary | twig_not | concat );
    public final TwigParser.p_input_return p_input() throws RecognitionException {
        TwigParser.p_input_return retval = new TwigParser.p_input_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL160=null;
        TwigParser.variable_return variable157 = null;

        TwigParser.method_chain_return method_chain158 = null;

        TwigParser.array_return array159 = null;

        TwigParser.twig_ternary_return twig_ternary161 = null;

        TwigParser.twig_not_return twig_not162 = null;

        TwigParser.concat_return concat163 = null;


        TwigCommonTree STRING_LITERAL160_tree=null;

        try {
            // TwigParser.g:193:3: ( variable | method_chain | array | STRING_LITERAL | twig_ternary | twig_not | concat )
            int alt46=7;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // TwigParser.g:193:5: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_p_input1042);
                    variable157=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable157.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:193:16: method_chain
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_chain_in_p_input1046);
                    method_chain158=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain158.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:193:31: array
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_array_in_p_input1050);
                    array159=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array159.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:193:39: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL160=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_p_input1054); 
                    STRING_LITERAL160_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL160);
                    adaptor.addChild(root_0, STRING_LITERAL160_tree);


                    }
                    break;
                case 5 :
                    // TwigParser.g:193:56: twig_ternary
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_ternary_in_p_input1058);
                    twig_ternary161=twig_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_ternary161.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:193:71: twig_not
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_not_in_p_input1062);
                    twig_not162=twig_not();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_not162.getTree());

                    }
                    break;
                case 7 :
                    // TwigParser.g:193:82: concat
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_concat_in_p_input1066);
                    concat163=concat();

                    state._fsp--;

                    adaptor.addChild(root_0, concat163.getTree());

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
    // TwigParser.g:196:1: concat : concat_operand TILDE concat_operand ( TILDE concat_operand )* ;
    public final TwigParser.concat_return concat() throws RecognitionException {
        TwigParser.concat_return retval = new TwigParser.concat_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken TILDE165=null;
        CommonToken TILDE167=null;
        TwigParser.concat_operand_return concat_operand164 = null;

        TwigParser.concat_operand_return concat_operand166 = null;

        TwigParser.concat_operand_return concat_operand168 = null;


        TwigCommonTree TILDE165_tree=null;
        TwigCommonTree TILDE167_tree=null;

        try {
            // TwigParser.g:197:3: ( concat_operand TILDE concat_operand ( TILDE concat_operand )* )
            // TwigParser.g:197:5: concat_operand TILDE concat_operand ( TILDE concat_operand )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_concat_operand_in_concat1081);
            concat_operand164=concat_operand();

            state._fsp--;

            adaptor.addChild(root_0, concat_operand164.getTree());
            TILDE165=(CommonToken)match(input,TILDE,FOLLOW_TILDE_in_concat1083); 
            TILDE165_tree = (TwigCommonTree)adaptor.create(TILDE165);
            adaptor.addChild(root_0, TILDE165_tree);

            pushFollow(FOLLOW_concat_operand_in_concat1085);
            concat_operand166=concat_operand();

            state._fsp--;

            adaptor.addChild(root_0, concat_operand166.getTree());
            // TwigParser.g:197:41: ( TILDE concat_operand )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==TILDE) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // TwigParser.g:197:42: TILDE concat_operand
            	    {
            	    TILDE167=(CommonToken)match(input,TILDE,FOLLOW_TILDE_in_concat1088); 
            	    TILDE167_tree = (TwigCommonTree)adaptor.create(TILDE167);
            	    adaptor.addChild(root_0, TILDE167_tree);

            	    pushFollow(FOLLOW_concat_operand_in_concat1090);
            	    concat_operand168=concat_operand();

            	    state._fsp--;

            	    adaptor.addChild(root_0, concat_operand168.getTree());

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // $ANTLR end "concat"

    public static class concat_operand_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concat_operand"
    // TwigParser.g:200:1: concat_operand : ( STRING_LITERAL | variable | method_chain ) ;
    public final TwigParser.concat_operand_return concat_operand() throws RecognitionException {
        TwigParser.concat_operand_return retval = new TwigParser.concat_operand_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL169=null;
        TwigParser.variable_return variable170 = null;

        TwigParser.method_chain_return method_chain171 = null;


        TwigCommonTree STRING_LITERAL169_tree=null;

        try {
            // TwigParser.g:201:3: ( ( STRING_LITERAL | variable | method_chain ) )
            // TwigParser.g:201:5: ( STRING_LITERAL | variable | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:201:5: ( STRING_LITERAL | variable | method_chain )
            int alt48=3;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // TwigParser.g:201:6: STRING_LITERAL
                    {
                    STRING_LITERAL169=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_concat_operand1108); 
                    STRING_LITERAL169_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL169);
                    adaptor.addChild(root_0, STRING_LITERAL169_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:201:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_concat_operand1112);
                    variable170=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable170.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:201:34: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_concat_operand1116);
                    method_chain171=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain171.getTree());

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
    // TwigParser.g:204:1: twig_not : NOT ( twig_ternary | variable | method_chain ) ;
    public final TwigParser.twig_not_return twig_not() throws RecognitionException {
        TwigParser.twig_not_return retval = new TwigParser.twig_not_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken NOT172=null;
        TwigParser.twig_ternary_return twig_ternary173 = null;

        TwigParser.variable_return variable174 = null;

        TwigParser.method_chain_return method_chain175 = null;


        TwigCommonTree NOT172_tree=null;

        try {
            // TwigParser.g:205:3: ( NOT ( twig_ternary | variable | method_chain ) )
            // TwigParser.g:205:5: NOT ( twig_ternary | variable | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            NOT172=(CommonToken)match(input,NOT,FOLLOW_NOT_in_twig_not1132); 
            NOT172_tree = (TwigCommonTree)adaptor.create(NOT172);
            adaptor.addChild(root_0, NOT172_tree);

            // TwigParser.g:205:9: ( twig_ternary | variable | method_chain )
            int alt49=3;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // TwigParser.g:205:10: twig_ternary
                    {
                    pushFollow(FOLLOW_twig_ternary_in_twig_not1135);
                    twig_ternary173=twig_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_ternary173.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:205:25: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_not1139);
                    variable174=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable174.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:205:36: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_not1143);
                    method_chain175=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain175.getTree());

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
    // TwigParser.g:208:1: array : ARRAY_START array_elements ARRAY_END ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ARRAY_START176=null;
        CommonToken ARRAY_END178=null;
        TwigParser.array_elements_return array_elements177 = null;


        TwigCommonTree ARRAY_START176_tree=null;
        TwigCommonTree ARRAY_END178_tree=null;

        try {
            // TwigParser.g:209:3: ( ARRAY_START array_elements ARRAY_END )
            // TwigParser.g:209:5: ARRAY_START array_elements ARRAY_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ARRAY_START176=(CommonToken)match(input,ARRAY_START,FOLLOW_ARRAY_START_in_array1159); 
            ARRAY_START176_tree = (TwigCommonTree)adaptor.create(ARRAY_START176);
            adaptor.addChild(root_0, ARRAY_START176_tree);

            pushFollow(FOLLOW_array_elements_in_array1161);
            array_elements177=array_elements();

            state._fsp--;

            adaptor.addChild(root_0, array_elements177.getTree());
            ARRAY_END178=(CommonToken)match(input,ARRAY_END,FOLLOW_ARRAY_END_in_array1163); 
            ARRAY_END178_tree = (TwigCommonTree)adaptor.create(ARRAY_END178);
            adaptor.addChild(root_0, ARRAY_END178_tree);


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
    // TwigParser.g:212:1: array_elements : array_element ( COMMA array_element )* ;
    public final TwigParser.array_elements_return array_elements() throws RecognitionException {
        TwigParser.array_elements_return retval = new TwigParser.array_elements_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA180=null;
        TwigParser.array_element_return array_element179 = null;

        TwigParser.array_element_return array_element181 = null;


        TwigCommonTree COMMA180_tree=null;

        try {
            // TwigParser.g:213:3: ( array_element ( COMMA array_element )* )
            // TwigParser.g:213:5: array_element ( COMMA array_element )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_array_element_in_array_elements1178);
            array_element179=array_element();

            state._fsp--;

            adaptor.addChild(root_0, array_element179.getTree());
            // TwigParser.g:213:19: ( COMMA array_element )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==COMMA) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // TwigParser.g:213:20: COMMA array_element
            	    {
            	    COMMA180=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_array_elements1181); 
            	    COMMA180_tree = (TwigCommonTree)adaptor.create(COMMA180);
            	    adaptor.addChild(root_0, COMMA180_tree);

            	    pushFollow(FOLLOW_array_element_in_array_elements1183);
            	    array_element181=array_element();

            	    state._fsp--;

            	    adaptor.addChild(root_0, array_element181.getTree());

            	    }
            	    break;

            	default :
            	    break loop50;
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
    // TwigParser.g:216:1: array_element : ( STRING | STRING_LITERAL | NUMBER | json );
    public final TwigParser.array_element_return array_element() throws RecognitionException {
        TwigParser.array_element_return retval = new TwigParser.array_element_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING182=null;
        CommonToken STRING_LITERAL183=null;
        CommonToken NUMBER184=null;
        TwigParser.json_return json185 = null;


        TwigCommonTree STRING182_tree=null;
        TwigCommonTree STRING_LITERAL183_tree=null;
        TwigCommonTree NUMBER184_tree=null;

        try {
            // TwigParser.g:217:3: ( STRING | STRING_LITERAL | NUMBER | json )
            int alt51=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt51=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt51=2;
                }
                break;
            case NUMBER:
                {
                alt51=3;
                }
                break;
            case JSON_START:
                {
                alt51=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // TwigParser.g:217:5: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING182=(CommonToken)match(input,STRING,FOLLOW_STRING_in_array_element1200); 
                    STRING182_tree = (TwigCommonTree)adaptor.create(STRING182);
                    adaptor.addChild(root_0, STRING182_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:217:14: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL183=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_array_element1204); 
                    STRING_LITERAL183_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL183);
                    adaptor.addChild(root_0, STRING_LITERAL183_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:217:31: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER184=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_array_element1208); 
                    NUMBER184_tree = (TwigCommonTree)adaptor.create(NUMBER184);
                    adaptor.addChild(root_0, NUMBER184_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:217:40: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_array_element1212);
                    json185=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json185.getTree());

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
    // TwigParser.g:220:1: variable : param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) ;
    public final TwigParser.variable_return variable() throws RecognitionException {
        TwigParser.variable_return retval = new TwigParser.variable_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;
        CommonToken DOT186=null;
        CommonToken STRING187=null;

        TwigCommonTree param_tree=null;
        TwigCommonTree DOT186_tree=null;
        TwigCommonTree STRING187_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // TwigParser.g:221:3: (param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) )
            // TwigParser.g:221:5: param= STRING ( DOT ( STRING ) )*
            {
            param=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable1229);  
            stream_STRING.add(param);

            // TwigParser.g:221:18: ( DOT ( STRING ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==DOT) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // TwigParser.g:221:19: DOT ( STRING )
            	    {
            	    DOT186=(CommonToken)match(input,DOT,FOLLOW_DOT_in_variable1232);  
            	    stream_DOT.add(DOT186);

            	    // TwigParser.g:221:23: ( STRING )
            	    // TwigParser.g:221:24: STRING
            	    {
            	    STRING187=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable1235);  
            	    stream_STRING.add(STRING187);


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
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
            // 222:5: -> ^( TWIG_VAR $param)
            {
                // TwigParser.g:222:7: ^( TWIG_VAR $param)
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
    // TwigParser.g:226:1: method_chain : method ( DOT method )* ;
    public final TwigParser.method_chain_return method_chain() throws RecognitionException {
        TwigParser.method_chain_return retval = new TwigParser.method_chain_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken DOT189=null;
        TwigParser.method_return method188 = null;

        TwigParser.method_return method190 = null;


        TwigCommonTree DOT189_tree=null;

        try {
            // TwigParser.g:227:3: ( method ( DOT method )* )
            // TwigParser.g:227:5: method ( DOT method )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_method_in_method_chain1267);
            method188=method();

            state._fsp--;

            adaptor.addChild(root_0, method188.getTree());
            // TwigParser.g:227:12: ( DOT method )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==DOT) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // TwigParser.g:227:13: DOT method
            	    {
            	    DOT189=(CommonToken)match(input,DOT,FOLLOW_DOT_in_method_chain1270); 
            	    DOT189_tree = (TwigCommonTree)adaptor.create(DOT189);
            	    adaptor.addChild(root_0, DOT189_tree);

            	    pushFollow(FOLLOW_method_in_method_chain1272);
            	    method190=method();

            	    state._fsp--;

            	    adaptor.addChild(root_0, method190.getTree());

            	    }
            	    break;

            	default :
            	    break loop53;
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
    // TwigParser.g:230:1: method : variable METHOD_START ( arguments )? METHOD_END ;
    public final TwigParser.method_return method() throws RecognitionException {
        TwigParser.method_return retval = new TwigParser.method_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken METHOD_START192=null;
        CommonToken METHOD_END194=null;
        TwigParser.variable_return variable191 = null;

        TwigParser.arguments_return arguments193 = null;


        TwigCommonTree METHOD_START192_tree=null;
        TwigCommonTree METHOD_END194_tree=null;

        try {
            // TwigParser.g:231:3: ( variable METHOD_START ( arguments )? METHOD_END )
            // TwigParser.g:231:5: variable METHOD_START ( arguments )? METHOD_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_in_method1289);
            variable191=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable191.getTree());
            METHOD_START192=(CommonToken)match(input,METHOD_START,FOLLOW_METHOD_START_in_method1291); 
            METHOD_START192_tree = (TwigCommonTree)adaptor.create(METHOD_START192);
            adaptor.addChild(root_0, METHOD_START192_tree);

            // TwigParser.g:231:27: ( arguments )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==JSON_START||LA54_0==NUMBER||LA54_0==STRING||LA54_0==STRING_LITERAL) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // TwigParser.g:231:27: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_method1293);
                    arguments193=arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, arguments193.getTree());

                    }
                    break;

            }

            METHOD_END194=(CommonToken)match(input,METHOD_END,FOLLOW_METHOD_END_in_method1296); 
            METHOD_END194_tree = (TwigCommonTree)adaptor.create(METHOD_END194);
            adaptor.addChild(root_0, METHOD_END194_tree);


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
    // TwigParser.g:234:1: arguments : argument ( COMMA ( argument ) )* ;
    public final TwigParser.arguments_return arguments() throws RecognitionException {
        TwigParser.arguments_return retval = new TwigParser.arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA196=null;
        TwigParser.argument_return argument195 = null;

        TwigParser.argument_return argument197 = null;


        TwigCommonTree COMMA196_tree=null;

        try {
            // TwigParser.g:235:3: ( argument ( COMMA ( argument ) )* )
            // TwigParser.g:235:5: argument ( COMMA ( argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_argument_in_arguments1312);
            argument195=argument();

            state._fsp--;

            adaptor.addChild(root_0, argument195.getTree());
            // TwigParser.g:235:15: ( COMMA ( argument ) )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==COMMA) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // TwigParser.g:235:16: COMMA ( argument )
            	    {
            	    COMMA196=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_arguments1316); 
            	    COMMA196_tree = (TwigCommonTree)adaptor.create(COMMA196);
            	    adaptor.addChild(root_0, COMMA196_tree);

            	    // TwigParser.g:235:22: ( argument )
            	    // TwigParser.g:235:23: argument
            	    {
            	    pushFollow(FOLLOW_argument_in_arguments1319);
            	    argument197=argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, argument197.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop55;
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
    // TwigParser.g:238:1: argument : ( literal_argument | json | NUMBER | variable );
    public final TwigParser.argument_return argument() throws RecognitionException {
        TwigParser.argument_return retval = new TwigParser.argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken NUMBER200=null;
        TwigParser.literal_argument_return literal_argument198 = null;

        TwigParser.json_return json199 = null;

        TwigParser.variable_return variable201 = null;


        TwigCommonTree NUMBER200_tree=null;

        try {
            // TwigParser.g:239:1: ( literal_argument | json | NUMBER | variable )
            int alt56=4;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt56=1;
                }
                break;
            case JSON_START:
                {
                alt56=2;
                }
                break;
            case NUMBER:
                {
                alt56=3;
                }
                break;
            case STRING:
                {
                alt56=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // TwigParser.g:239:3: literal_argument
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_argument_in_argument1333);
                    literal_argument198=literal_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, literal_argument198.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:239:22: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_argument1337);
                    json199=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json199.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:239:29: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER200=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_argument1341); 
                    NUMBER200_tree = (TwigCommonTree)adaptor.create(NUMBER200);
                    adaptor.addChild(root_0, NUMBER200_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:239:38: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_argument1345);
                    variable201=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable201.getTree());

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
    // TwigParser.g:242:1: literal_argument : param= STRING_LITERAL -> ^( LITERAL_ARG $param) ;
    public final TwigParser.literal_argument_return literal_argument() throws RecognitionException {
        TwigParser.literal_argument_return retval = new TwigParser.literal_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;

        TwigCommonTree param_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");

        try {
            // TwigParser.g:243:3: (param= STRING_LITERAL -> ^( LITERAL_ARG $param) )
            // TwigParser.g:243:5: param= STRING_LITERAL
            {
            param=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal_argument1358);  
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
            // 244:5: -> ^( LITERAL_ARG $param)
            {
                // TwigParser.g:244:8: ^( LITERAL_ARG $param)
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
    // TwigParser.g:247:1: json : JSON_START ( json_arguments )? JSON_END ;
    public final TwigParser.json_return json() throws RecognitionException {
        TwigParser.json_return retval = new TwigParser.json_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken JSON_START202=null;
        CommonToken JSON_END204=null;
        TwigParser.json_arguments_return json_arguments203 = null;


        TwigCommonTree JSON_START202_tree=null;
        TwigCommonTree JSON_END204_tree=null;

        try {
            // TwigParser.g:248:3: ( JSON_START ( json_arguments )? JSON_END )
            // TwigParser.g:248:5: JSON_START ( json_arguments )? JSON_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            JSON_START202=(CommonToken)match(input,JSON_START,FOLLOW_JSON_START_in_json1384); 
            JSON_START202_tree = (TwigCommonTree)adaptor.create(JSON_START202);
            adaptor.addChild(root_0, JSON_START202_tree);

            // TwigParser.g:248:16: ( json_arguments )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==STRING||LA57_0==STRING_LITERAL) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // TwigParser.g:248:16: json_arguments
                    {
                    pushFollow(FOLLOW_json_arguments_in_json1386);
                    json_arguments203=json_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, json_arguments203.getTree());

                    }
                    break;

            }

            JSON_END204=(CommonToken)match(input,JSON_END,FOLLOW_JSON_END_in_json1389); 
            JSON_END204_tree = (TwigCommonTree)adaptor.create(JSON_END204);
            adaptor.addChild(root_0, JSON_END204_tree);


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
    // TwigParser.g:251:1: json_arguments : json_argument ( COMMA ( json_argument ) )* ;
    public final TwigParser.json_arguments_return json_arguments() throws RecognitionException {
        TwigParser.json_arguments_return retval = new TwigParser.json_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA206=null;
        TwigParser.json_argument_return json_argument205 = null;

        TwigParser.json_argument_return json_argument207 = null;


        TwigCommonTree COMMA206_tree=null;

        try {
            // TwigParser.g:252:3: ( json_argument ( COMMA ( json_argument ) )* )
            // TwigParser.g:252:5: json_argument ( COMMA ( json_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_json_argument_in_json_arguments1404);
            json_argument205=json_argument();

            state._fsp--;

            adaptor.addChild(root_0, json_argument205.getTree());
            // TwigParser.g:252:19: ( COMMA ( json_argument ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==COMMA) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // TwigParser.g:252:20: COMMA ( json_argument )
            	    {
            	    COMMA206=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_json_arguments1407); 
            	    COMMA206_tree = (TwigCommonTree)adaptor.create(COMMA206);
            	    adaptor.addChild(root_0, COMMA206_tree);

            	    // TwigParser.g:252:26: ( json_argument )
            	    // TwigParser.g:252:27: json_argument
            	    {
            	    pushFollow(FOLLOW_json_argument_in_json_arguments1410);
            	    json_argument207=json_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, json_argument207.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop58;
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
    // TwigParser.g:255:1: json_argument : ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) ;
    public final TwigParser.json_argument_return json_argument() throws RecognitionException {
        TwigParser.json_argument_return retval = new TwigParser.json_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set208=null;
        CommonToken COLON209=null;
        CommonToken set210=null;

        TwigCommonTree set208_tree=null;
        TwigCommonTree COLON209_tree=null;
        TwigCommonTree set210_tree=null;

        try {
            // TwigParser.g:256:3: ( ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) )
            // TwigParser.g:256:5: ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set208=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set208));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // TwigParser.g:256:31: ( COLON )
            // TwigParser.g:256:32: COLON
            {
            COLON209=(CommonToken)match(input,COLON,FOLLOW_COLON_in_json_argument1437); 
            COLON209_tree = (TwigCommonTree)adaptor.create(COLON209);
            adaptor.addChild(root_0, COLON209_tree);


            }

            set210=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set210));
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


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA49 dfa49 = new DFA49(this);
    static final String DFA3_eotS =
        "\23\uffff";
    static final String DFA3_eofS =
        "\23\uffff";
    static final String DFA3_minS =
        "\1\33\1\7\15\uffff\1\66\2\uffff\1\7";
    static final String DFA3_maxS =
        "\1\66\1\70\15\uffff\1\66\2\uffff\1\70";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1"+
        "\16\1\uffff\1\1\1\17\1\uffff";
    static final String DFA3_specialS =
        "\23\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\14\1\2\1\3\1\4\1\5\1\6\1\7\2\uffff\2\10\1\11\1\15\1\16\1"+
            "\11\1\12\1\uffff\1\12\1\13\7\uffff\1\1",
            "\1\20\14\uffff\1\17\43\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\22",
            "",
            "",
            "\1\20\14\uffff\1\17\43\uffff\1\21"
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "85:1: twig_control : ( variable | twig_for | ENDFOR | ELSE | twig_if | twig_elseif | ENDIF | twig_macro | twig_import | twig_set | twig_include | twig_block | twig_extends | twig_use | assets );";
        }
    }
    static final String DFA7_eotS =
        "\111\uffff";
    static final String DFA7_eofS =
        "\111\uffff";
    static final String DFA7_minS =
        "\1\66\1\7\1\uffff\1\66\1\uffff\1\11\1\7\1\11\1\31\2\11\1\7\1\30"+
        "\1\25\1\11\2\66\1\uffff\1\11\1\31\2\11\1\66\1\11\1\10\1\25\1\11"+
        "\1\66\1\26\1\66\1\11\1\66\1\11\1\66\1\10\1\11\1\31\2\11\1\7\1\26"+
        "\1\25\1\30\1\25\1\11\3\66\1\11\1\31\2\11\1\66\1\11\1\25\1\26\1\25"+
        "\1\11\1\66\1\26\2\66\1\11\1\66\2\26\1\25\2\66\1\25\1\26\1\66\1\26";
    static final String DFA7_maxS =
        "\2\70\1\uffff\1\66\1\uffff\2\70\1\26\1\70\2\26\2\70\1\25\1\26\2"+
        "\66\1\uffff\1\26\1\70\2\26\1\70\1\26\1\24\1\25\1\26\1\66\1\31\1"+
        "\66\2\70\1\26\1\70\1\24\1\26\1\70\2\26\1\70\1\31\1\25\1\70\1\25"+
        "\1\26\1\66\2\70\1\26\1\70\2\26\1\70\1\26\1\25\1\31\1\25\1\26\1\66"+
        "\1\31\2\70\1\26\1\70\2\31\1\25\2\70\1\25\1\31\1\70\1\31";
    static final String DFA7_acceptS =
        "\2\uffff\1\3\1\uffff\1\1\14\uffff\1\2\67\uffff";
    static final String DFA7_specialS =
        "\111\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\1\uffff\1\2",
            "\1\4\1\5\1\uffff\1\4\6\uffff\1\2\2\uffff\1\3\27\uffff\1\4\7"+
            "\uffff\1\4\1\uffff\1\4\1\uffff\1\4",
            "",
            "\1\6",
            "",
            "\1\13\16\uffff\1\10\33\uffff\1\11\1\uffff\1\12\1\uffff\1\7",
            "\1\4\1\5\1\uffff\1\4\6\uffff\1\2\2\uffff\1\3\27\uffff\1\4\7"+
            "\uffff\1\4\1\uffff\1\4\1\uffff\1\4",
            "\1\13\14\uffff\1\14",
            "\1\16\34\uffff\1\15\1\uffff\1\15",
            "\1\13\14\uffff\1\14",
            "\1\13\12\uffff\1\17\1\uffff\1\14",
            "\1\21\2\uffff\1\21\6\uffff\1\2\2\uffff\1\20\27\uffff\1\21\7"+
            "\uffff\1\21\1\uffff\1\21\1\uffff\1\21",
            "\1\23\33\uffff\1\24\1\uffff\1\25\1\uffff\1\22",
            "\1\26",
            "\1\13\14\uffff\1\14",
            "\1\27",
            "\1\30",
            "",
            "\1\13\14\uffff\1\14",
            "\1\32\34\uffff\1\31\1\uffff\1\31",
            "\1\13\14\uffff\1\14",
            "\1\13\12\uffff\1\33\1\uffff\1\14",
            "\1\34\1\uffff\1\34",
            "\1\13\12\uffff\1\17\1\uffff\1\14",
            "\1\36\13\uffff\1\35",
            "\1\37",
            "\1\13\14\uffff\1\14",
            "\1\40",
            "\1\41\2\uffff\1\16",
            "\1\42",
            "\1\47\16\uffff\1\44\33\uffff\1\45\1\uffff\1\46\1\uffff\1\43",
            "\1\50\1\uffff\1\50",
            "\1\13\12\uffff\1\33\1\uffff\1\14",
            "\1\51\1\uffff\1\51",
            "\1\36\13\uffff\1\35",
            "\1\47\14\uffff\1\52",
            "\1\54\34\uffff\1\53\1\uffff\1\53",
            "\1\47\14\uffff\1\52",
            "\1\47\12\uffff\1\55\1\uffff\1\52",
            "\1\21\2\uffff\1\21\6\uffff\1\2\2\uffff\1\20\27\uffff\1\21\7"+
            "\uffff\1\21\1\uffff\1\21\1\uffff\1\21",
            "\1\56\2\uffff\1\32",
            "\1\57",
            "\1\61\33\uffff\1\62\1\uffff\1\63\1\uffff\1\60",
            "\1\64",
            "\1\47\14\uffff\1\52",
            "\1\65",
            "\1\66\1\uffff\1\66",
            "\1\67\1\uffff\1\67",
            "\1\47\14\uffff\1\52",
            "\1\71\34\uffff\1\70\1\uffff\1\70",
            "\1\47\14\uffff\1\52",
            "\1\47\12\uffff\1\72\1\uffff\1\52",
            "\1\73\1\uffff\1\73",
            "\1\47\12\uffff\1\55\1\uffff\1\52",
            "\1\74",
            "\1\41\2\uffff\1\16",
            "\1\75",
            "\1\47\14\uffff\1\52",
            "\1\76",
            "\1\77\2\uffff\1\54",
            "\1\100\1\uffff\1\100",
            "\1\101\1\uffff\1\101",
            "\1\47\12\uffff\1\72\1\uffff\1\52",
            "\1\102\1\uffff\1\102",
            "\1\56\2\uffff\1\32",
            "\1\103\2\uffff\1\71",
            "\1\104",
            "\1\105\1\uffff\1\105",
            "\1\106\1\uffff\1\106",
            "\1\107",
            "\1\77\2\uffff\1\54",
            "\1\110\1\uffff\1\110",
            "\1\103\2\uffff\1\71"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "105:5: ( variable | method_chain | concat )";
        }
    }
    static final String DFA12_eotS =
        "\10\uffff";
    static final String DFA12_eofS =
        "\10\uffff";
    static final String DFA12_minS =
        "\1\30\1\7\2\uffff\1\66\2\uffff\1\7";
    static final String DFA12_maxS =
        "\1\70\1\60\2\uffff\1\66\2\uffff\1\60";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\4\1\uffff\1\1\1\3\1\uffff";
    static final String DFA12_specialS =
        "\10\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\3\35\uffff\1\1\1\uffff\1\2",
            "\1\5\1\6\13\uffff\1\4\33\uffff\1\5",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\5\1\6\13\uffff\1\4\33\uffff\1\5"
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
            return "117:34: ( variable | STRING_LITERAL | method_chain | json )";
        }
    }
    static final String DFA20_eotS =
        "\161\uffff";
    static final String DFA20_eofS =
        "\161\uffff";
    static final String DFA20_minS =
        "\1\12\2\7\1\30\1\31\2\uffff\1\66\1\uffff\1\11\3\13\1\31\1\25\2\7"+
        "\1\11\1\31\2\11\1\7\1\30\1\7\1\25\1\13\1\66\1\uffff\1\30\1\25\1"+
        "\11\2\66\1\uffff\3\13\1\31\1\uffff\1\66\1\26\1\11\1\31\2\11\1\66"+
        "\1\11\1\10\1\25\1\13\1\26\1\66\1\25\1\11\1\66\1\26\1\66\1\11\2\66"+
        "\1\25\1\66\1\11\1\66\1\10\1\11\1\31\2\11\1\7\1\26\1\25\1\66\1\26"+
        "\1\25\1\30\1\25\1\11\3\66\1\26\2\66\1\11\1\31\2\11\1\66\1\11\1\25"+
        "\1\26\1\25\1\26\1\25\1\11\1\66\1\26\3\66\1\11\1\66\3\26\1\25\2\66"+
        "\1\25\1\26\1\66\1\26";
    static final String DFA20_maxS =
        "\1\70\2\26\2\70\2\uffff\1\66\1\uffff\1\70\3\26\1\70\1\25\3\26\1"+
        "\70\3\26\1\70\1\26\1\25\1\26\1\70\1\uffff\1\70\1\25\1\26\2\66\1"+
        "\uffff\3\26\1\70\1\uffff\1\70\1\31\1\26\1\70\2\26\1\70\1\26\1\24"+
        "\1\25\1\26\1\31\1\70\1\25\1\26\1\66\1\31\1\66\3\70\1\25\1\70\1\26"+
        "\1\70\1\24\1\26\1\70\3\26\1\31\1\25\1\70\1\31\1\25\1\70\1\25\1\26"+
        "\1\66\2\70\1\31\2\70\1\26\1\70\2\26\1\70\1\26\1\25\1\31\1\25\1\31"+
        "\1\25\1\26\1\66\1\31\3\70\1\26\1\70\3\31\1\25\2\70\1\25\1\31\1\70"+
        "\1\31";
    static final String DFA20_acceptS =
        "\5\uffff\1\1\1\6\1\uffff\1\2\22\uffff\1\5\5\uffff\1\3\4\uffff\1"+
        "\4\112\uffff";
    static final String DFA20_specialS =
        "\161\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\15\uffff\1\4\35\uffff\1\2\1\uffff\1\1",
            "\1\5\11\uffff\1\6\1\5\3\uffff\1\5",
            "\1\10\1\11\10\uffff\1\6\1\10\1\uffff\1\7\1\uffff\1\10",
            "\1\15\33\uffff\1\14\1\uffff\1\12\1\uffff\1\13",
            "\1\17\34\uffff\1\16\1\uffff\1\16",
            "",
            "",
            "\1\20",
            "",
            "\1\25\16\uffff\1\22\33\uffff\1\23\1\uffff\1\24\1\uffff\1\21",
            "\1\27\12\uffff\1\26",
            "\1\27\12\uffff\1\26",
            "\1\27\12\uffff\1\26",
            "\1\31\34\uffff\1\30\1\uffff\1\30",
            "\1\32",
            "\1\33\11\uffff\1\6\1\33\3\uffff\1\33",
            "\1\10\1\11\10\uffff\1\6\1\10\1\uffff\1\7\1\uffff\1\10",
            "\1\25\14\uffff\1\34",
            "\1\36\34\uffff\1\35\1\uffff\1\35",
            "\1\25\14\uffff\1\34",
            "\1\25\12\uffff\1\37\1\uffff\1\34",
            "\1\41\11\uffff\1\6\1\41\1\uffff\1\40\1\uffff\1\41",
            "\1\45\33\uffff\1\44\1\uffff\1\42\1\uffff\1\43",
            "\1\46\11\uffff\1\6\1\46\3\uffff\1\46",
            "\1\47",
            "\1\27\12\uffff\1\26",
            "\1\50\1\uffff\1\50",
            "",
            "\1\52\33\uffff\1\53\1\uffff\1\54\1\uffff\1\51",
            "\1\55",
            "\1\25\14\uffff\1\34",
            "\1\56",
            "\1\57",
            "",
            "\1\27\12\uffff\1\26",
            "\1\27\12\uffff\1\26",
            "\1\27\12\uffff\1\26",
            "\1\61\34\uffff\1\60\1\uffff\1\60",
            "",
            "\1\62\1\uffff\1\62",
            "\1\63\2\uffff\1\17",
            "\1\25\14\uffff\1\34",
            "\1\65\34\uffff\1\64\1\uffff\1\64",
            "\1\25\14\uffff\1\34",
            "\1\25\12\uffff\1\66\1\uffff\1\34",
            "\1\67\1\uffff\1\67",
            "\1\25\12\uffff\1\37\1\uffff\1\34",
            "\1\71\13\uffff\1\70",
            "\1\72",
            "\1\27\12\uffff\1\26",
            "\1\73\2\uffff\1\31",
            "\1\74\1\uffff\1\74",
            "\1\75",
            "\1\25\14\uffff\1\34",
            "\1\76",
            "\1\77\2\uffff\1\36",
            "\1\100",
            "\1\105\16\uffff\1\102\33\uffff\1\103\1\uffff\1\104\1\uffff"+
            "\1\101",
            "\1\106\1\uffff\1\106",
            "\1\107\1\uffff\1\107",
            "\1\110",
            "\1\111\1\uffff\1\111",
            "\1\25\12\uffff\1\66\1\uffff\1\34",
            "\1\112\1\uffff\1\112",
            "\1\71\13\uffff\1\70",
            "\1\105\14\uffff\1\113",
            "\1\115\34\uffff\1\114\1\uffff\1\114",
            "\1\105\14\uffff\1\113",
            "\1\105\12\uffff\1\116\1\uffff\1\113",
            "\1\41\11\uffff\1\6\1\41\1\uffff\1\40\1\uffff\1\41",
            "\1\117\2\uffff\1\61",
            "\1\120",
            "\1\121\1\uffff\1\121",
            "\1\122\2\uffff\1\65",
            "\1\123",
            "\1\125\33\uffff\1\126\1\uffff\1\127\1\uffff\1\124",
            "\1\130",
            "\1\105\14\uffff\1\113",
            "\1\131",
            "\1\132\1\uffff\1\132",
            "\1\133\1\uffff\1\133",
            "\1\63\2\uffff\1\17",
            "\1\134\1\uffff\1\134",
            "\1\135\1\uffff\1\135",
            "\1\105\14\uffff\1\113",
            "\1\137\34\uffff\1\136\1\uffff\1\136",
            "\1\105\14\uffff\1\113",
            "\1\105\12\uffff\1\140\1\uffff\1\113",
            "\1\141\1\uffff\1\141",
            "\1\105\12\uffff\1\116\1\uffff\1\113",
            "\1\142",
            "\1\73\2\uffff\1\31",
            "\1\143",
            "\1\77\2\uffff\1\36",
            "\1\144",
            "\1\105\14\uffff\1\113",
            "\1\145",
            "\1\146\2\uffff\1\115",
            "\1\147\1\uffff\1\147",
            "\1\150\1\uffff\1\150",
            "\1\151\1\uffff\1\151",
            "\1\105\12\uffff\1\140\1\uffff\1\113",
            "\1\152\1\uffff\1\152",
            "\1\117\2\uffff\1\61",
            "\1\122\2\uffff\1\65",
            "\1\153\2\uffff\1\137",
            "\1\154",
            "\1\155\1\uffff\1\155",
            "\1\156\1\uffff\1\156",
            "\1\157",
            "\1\146\2\uffff\1\115",
            "\1\160\1\uffff\1\160",
            "\1\153\2\uffff\1\137"
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
            return "133:5: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )";
        }
    }
    static final String DFA21_eotS =
        "\161\uffff";
    static final String DFA21_eofS =
        "\161\uffff";
    static final String DFA21_minS =
        "\1\12\2\7\1\30\1\31\2\uffff\1\66\1\uffff\1\11\3\13\1\31\1\25\2\7"+
        "\1\11\1\31\2\11\1\7\1\30\1\7\1\25\1\13\1\66\1\uffff\1\30\1\25\1"+
        "\11\2\66\1\uffff\3\13\1\31\1\uffff\1\66\1\26\1\11\1\31\2\11\1\66"+
        "\1\11\1\10\1\25\1\13\1\26\1\66\1\25\1\11\1\66\1\26\1\66\1\11\2\66"+
        "\1\25\1\66\1\11\1\66\1\10\1\11\1\31\2\11\1\7\1\26\1\25\1\66\1\26"+
        "\1\25\1\30\1\25\1\11\3\66\1\26\2\66\1\11\1\31\2\11\1\66\1\11\1\25"+
        "\1\26\1\25\1\26\1\25\1\11\1\66\1\26\3\66\1\11\1\66\3\26\1\25\2\66"+
        "\1\25\1\26\1\66\1\26";
    static final String DFA21_maxS =
        "\1\70\2\26\2\70\2\uffff\1\66\1\uffff\1\70\3\26\1\70\1\25\3\26\1"+
        "\70\3\26\1\70\1\26\1\25\1\26\1\70\1\uffff\1\70\1\25\1\26\2\66\1"+
        "\uffff\3\26\1\70\1\uffff\1\70\1\31\1\26\1\70\2\26\1\70\1\26\1\24"+
        "\1\25\1\26\1\31\1\70\1\25\1\26\1\66\1\31\1\66\3\70\1\25\1\70\1\26"+
        "\1\70\1\24\1\26\1\70\3\26\1\31\1\25\1\70\1\31\1\25\1\70\1\25\1\26"+
        "\1\66\2\70\1\31\2\70\1\26\1\70\2\26\1\70\1\26\1\25\1\31\1\25\1\31"+
        "\1\25\1\26\1\66\1\31\3\70\1\26\1\70\3\31\1\25\2\70\1\25\1\31\1\70"+
        "\1\31";
    static final String DFA21_acceptS =
        "\5\uffff\1\1\1\6\1\uffff\1\2\22\uffff\1\5\5\uffff\1\3\4\uffff\1"+
        "\4\112\uffff";
    static final String DFA21_specialS =
        "\161\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\15\uffff\1\4\35\uffff\1\2\1\uffff\1\1",
            "\1\5\11\uffff\1\6\1\5\3\uffff\1\5",
            "\1\10\1\11\10\uffff\1\6\1\10\1\uffff\1\7\1\uffff\1\10",
            "\1\15\33\uffff\1\14\1\uffff\1\12\1\uffff\1\13",
            "\1\17\34\uffff\1\16\1\uffff\1\16",
            "",
            "",
            "\1\20",
            "",
            "\1\25\16\uffff\1\22\33\uffff\1\23\1\uffff\1\24\1\uffff\1\21",
            "\1\27\12\uffff\1\26",
            "\1\27\12\uffff\1\26",
            "\1\27\12\uffff\1\26",
            "\1\31\34\uffff\1\30\1\uffff\1\30",
            "\1\32",
            "\1\33\11\uffff\1\6\1\33\3\uffff\1\33",
            "\1\10\1\11\10\uffff\1\6\1\10\1\uffff\1\7\1\uffff\1\10",
            "\1\25\14\uffff\1\34",
            "\1\36\34\uffff\1\35\1\uffff\1\35",
            "\1\25\14\uffff\1\34",
            "\1\25\12\uffff\1\37\1\uffff\1\34",
            "\1\41\11\uffff\1\6\1\41\1\uffff\1\40\1\uffff\1\41",
            "\1\45\33\uffff\1\44\1\uffff\1\42\1\uffff\1\43",
            "\1\46\11\uffff\1\6\1\46\3\uffff\1\46",
            "\1\47",
            "\1\27\12\uffff\1\26",
            "\1\50\1\uffff\1\50",
            "",
            "\1\52\33\uffff\1\53\1\uffff\1\54\1\uffff\1\51",
            "\1\55",
            "\1\25\14\uffff\1\34",
            "\1\56",
            "\1\57",
            "",
            "\1\27\12\uffff\1\26",
            "\1\27\12\uffff\1\26",
            "\1\27\12\uffff\1\26",
            "\1\61\34\uffff\1\60\1\uffff\1\60",
            "",
            "\1\62\1\uffff\1\62",
            "\1\63\2\uffff\1\17",
            "\1\25\14\uffff\1\34",
            "\1\65\34\uffff\1\64\1\uffff\1\64",
            "\1\25\14\uffff\1\34",
            "\1\25\12\uffff\1\66\1\uffff\1\34",
            "\1\67\1\uffff\1\67",
            "\1\25\12\uffff\1\37\1\uffff\1\34",
            "\1\71\13\uffff\1\70",
            "\1\72",
            "\1\27\12\uffff\1\26",
            "\1\73\2\uffff\1\31",
            "\1\74\1\uffff\1\74",
            "\1\75",
            "\1\25\14\uffff\1\34",
            "\1\76",
            "\1\77\2\uffff\1\36",
            "\1\100",
            "\1\105\16\uffff\1\102\33\uffff\1\103\1\uffff\1\104\1\uffff"+
            "\1\101",
            "\1\106\1\uffff\1\106",
            "\1\107\1\uffff\1\107",
            "\1\110",
            "\1\111\1\uffff\1\111",
            "\1\25\12\uffff\1\66\1\uffff\1\34",
            "\1\112\1\uffff\1\112",
            "\1\71\13\uffff\1\70",
            "\1\105\14\uffff\1\113",
            "\1\115\34\uffff\1\114\1\uffff\1\114",
            "\1\105\14\uffff\1\113",
            "\1\105\12\uffff\1\116\1\uffff\1\113",
            "\1\41\11\uffff\1\6\1\41\1\uffff\1\40\1\uffff\1\41",
            "\1\117\2\uffff\1\61",
            "\1\120",
            "\1\121\1\uffff\1\121",
            "\1\122\2\uffff\1\65",
            "\1\123",
            "\1\125\33\uffff\1\126\1\uffff\1\127\1\uffff\1\124",
            "\1\130",
            "\1\105\14\uffff\1\113",
            "\1\131",
            "\1\132\1\uffff\1\132",
            "\1\133\1\uffff\1\133",
            "\1\63\2\uffff\1\17",
            "\1\134\1\uffff\1\134",
            "\1\135\1\uffff\1\135",
            "\1\105\14\uffff\1\113",
            "\1\137\34\uffff\1\136\1\uffff\1\136",
            "\1\105\14\uffff\1\113",
            "\1\105\12\uffff\1\140\1\uffff\1\113",
            "\1\141\1\uffff\1\141",
            "\1\105\12\uffff\1\116\1\uffff\1\113",
            "\1\142",
            "\1\73\2\uffff\1\31",
            "\1\143",
            "\1\77\2\uffff\1\36",
            "\1\144",
            "\1\105\14\uffff\1\113",
            "\1\145",
            "\1\146\2\uffff\1\115",
            "\1\147\1\uffff\1\147",
            "\1\150\1\uffff\1\150",
            "\1\151\1\uffff\1\151",
            "\1\105\12\uffff\1\140\1\uffff\1\113",
            "\1\152\1\uffff\1\152",
            "\1\117\2\uffff\1\61",
            "\1\122\2\uffff\1\65",
            "\1\153\2\uffff\1\137",
            "\1\154",
            "\1\155\1\uffff\1\155",
            "\1\156\1\uffff\1\156",
            "\1\157",
            "\1\146\2\uffff\1\115",
            "\1\160\1\uffff\1\160",
            "\1\153\2\uffff\1\137"
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
            return "133:92: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )";
        }
    }
    static final String DFA23_eotS =
        "\11\uffff";
    static final String DFA23_eofS =
        "\11\uffff";
    static final String DFA23_minS =
        "\1\12\1\uffff\1\10\2\uffff\1\66\2\uffff\1\10";
    static final String DFA23_maxS =
        "\1\70\1\uffff\1\24\2\uffff\1\66\2\uffff\1\24";
    static final String DFA23_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\2\1\3\1\uffff";
    static final String DFA23_specialS =
        "\11\uffff}>";
    static final String[] DFA23_transitionS = {
            "\1\3\15\uffff\1\4\35\uffff\1\2\1\uffff\1\1",
            "",
            "\1\7\10\uffff\1\6\2\uffff\1\5",
            "",
            "",
            "\1\10",
            "",
            "",
            "\1\7\10\uffff\1\6\2\uffff\1\5"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "137:5: ( STRING_LITERAL | variable | method_chain | array | json )";
        }
    }
    static final String DFA24_eotS =
        "\11\uffff";
    static final String DFA24_eofS =
        "\11\uffff";
    static final String DFA24_minS =
        "\1\12\1\uffff\1\7\2\uffff\1\66\2\uffff\1\7";
    static final String DFA24_maxS =
        "\1\70\1\uffff\1\26\2\uffff\1\66\2\uffff\1\26";
    static final String DFA24_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\uffff\1\2\1\3\1\uffff";
    static final String DFA24_specialS =
        "\11\uffff}>";
    static final String[] DFA24_transitionS = {
            "\1\3\15\uffff\1\4\35\uffff\1\2\1\uffff\1\1",
            "",
            "\1\6\1\7\11\uffff\1\6\1\uffff\1\5\1\uffff\1\6",
            "",
            "",
            "\1\10",
            "",
            "",
            "\1\6\1\7\11\uffff\1\6\1\uffff\1\5\1\uffff\1\6"
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "137:69: ( STRING_LITERAL | variable | method_chain | array | json )";
        }
    }
    static final String DFA29_eotS =
        "\6\uffff";
    static final String DFA29_eofS =
        "\6\uffff";
    static final String DFA29_minS =
        "\1\66\1\7\1\66\2\uffff\1\7";
    static final String DFA29_maxS =
        "\1\66\1\24\1\66\2\uffff\1\24";
    static final String DFA29_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA29_specialS =
        "\6\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1",
            "\1\3\1\4\13\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\3\1\4\13\uffff\1\2"
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
            return "145:12: ( variable | method_chain )";
        }
    }
    static final String DFA31_eotS =
        "\111\uffff";
    static final String DFA31_eofS =
        "\111\uffff";
    static final String DFA31_minS =
        "\1\64\1\7\1\uffff\1\66\1\uffff\1\11\1\7\1\11\1\31\2\11\1\7\1\30"+
        "\1\25\1\11\2\66\1\uffff\1\11\1\31\2\11\1\66\1\11\1\10\1\25\1\11"+
        "\1\66\1\26\1\66\1\11\1\66\1\11\1\66\1\10\1\11\1\31\2\11\1\7\1\26"+
        "\1\25\1\30\1\25\1\11\3\66\1\11\1\31\2\11\1\66\1\11\1\25\1\26\1\25"+
        "\1\11\1\66\1\26\2\66\1\11\1\66\2\26\1\25\2\66\1\25\1\26\1\66\1\26";
    static final String DFA31_maxS =
        "\1\70\1\61\1\uffff\1\66\1\uffff\1\70\1\61\1\26\1\70\2\26\1\61\1"+
        "\70\1\25\1\26\2\66\1\uffff\1\26\1\70\2\26\1\70\1\26\1\24\1\25\1"+
        "\26\1\66\1\31\1\66\2\70\1\26\1\70\1\24\1\26\1\70\2\26\1\61\1\31"+
        "\1\25\1\70\1\25\1\26\1\66\2\70\1\26\1\70\2\26\1\70\1\26\1\25\1\31"+
        "\1\25\1\26\1\66\1\31\2\70\1\26\1\70\2\31\1\25\2\70\1\25\1\31\1\70"+
        "\1\31";
    static final String DFA31_acceptS =
        "\2\uffff\1\3\1\uffff\1\1\14\uffff\1\2\67\uffff";
    static final String DFA31_specialS =
        "\111\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\2\1\uffff\1\1\1\uffff\1\2",
            "\1\4\1\5\4\uffff\4\2\1\uffff\1\4\1\uffff\1\3\34\uffff\1\4",
            "",
            "\1\6",
            "",
            "\1\13\16\uffff\1\10\33\uffff\1\11\1\uffff\1\12\1\uffff\1\7",
            "\1\4\1\5\4\uffff\4\2\1\uffff\1\4\1\uffff\1\3\34\uffff\1\4",
            "\1\13\14\uffff\1\14",
            "\1\16\34\uffff\1\15\1\uffff\1\15",
            "\1\13\14\uffff\1\14",
            "\1\13\12\uffff\1\17\1\uffff\1\14",
            "\1\21\5\uffff\4\2\1\uffff\1\21\1\uffff\1\20\34\uffff\1\21",
            "\1\23\33\uffff\1\24\1\uffff\1\25\1\uffff\1\22",
            "\1\26",
            "\1\13\14\uffff\1\14",
            "\1\27",
            "\1\30",
            "",
            "\1\13\14\uffff\1\14",
            "\1\32\34\uffff\1\31\1\uffff\1\31",
            "\1\13\14\uffff\1\14",
            "\1\13\12\uffff\1\33\1\uffff\1\14",
            "\1\34\1\uffff\1\34",
            "\1\13\12\uffff\1\17\1\uffff\1\14",
            "\1\36\13\uffff\1\35",
            "\1\37",
            "\1\13\14\uffff\1\14",
            "\1\40",
            "\1\41\2\uffff\1\16",
            "\1\42",
            "\1\47\16\uffff\1\44\33\uffff\1\45\1\uffff\1\46\1\uffff\1\43",
            "\1\50\1\uffff\1\50",
            "\1\13\12\uffff\1\33\1\uffff\1\14",
            "\1\51\1\uffff\1\51",
            "\1\36\13\uffff\1\35",
            "\1\47\14\uffff\1\52",
            "\1\54\34\uffff\1\53\1\uffff\1\53",
            "\1\47\14\uffff\1\52",
            "\1\47\12\uffff\1\55\1\uffff\1\52",
            "\1\21\5\uffff\4\2\1\uffff\1\21\1\uffff\1\20\34\uffff\1\21",
            "\1\56\2\uffff\1\32",
            "\1\57",
            "\1\61\33\uffff\1\62\1\uffff\1\63\1\uffff\1\60",
            "\1\64",
            "\1\47\14\uffff\1\52",
            "\1\65",
            "\1\66\1\uffff\1\66",
            "\1\67\1\uffff\1\67",
            "\1\47\14\uffff\1\52",
            "\1\71\34\uffff\1\70\1\uffff\1\70",
            "\1\47\14\uffff\1\52",
            "\1\47\12\uffff\1\72\1\uffff\1\52",
            "\1\73\1\uffff\1\73",
            "\1\47\12\uffff\1\55\1\uffff\1\52",
            "\1\74",
            "\1\41\2\uffff\1\16",
            "\1\75",
            "\1\47\14\uffff\1\52",
            "\1\76",
            "\1\77\2\uffff\1\54",
            "\1\100\1\uffff\1\100",
            "\1\101\1\uffff\1\101",
            "\1\47\12\uffff\1\72\1\uffff\1\52",
            "\1\102\1\uffff\1\102",
            "\1\56\2\uffff\1\32",
            "\1\103\2\uffff\1\71",
            "\1\104",
            "\1\105\1\uffff\1\105",
            "\1\106\1\uffff\1\106",
            "\1\107",
            "\1\77\2\uffff\1\54",
            "\1\110\1\uffff\1\110",
            "\1\103\2\uffff\1\71"
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "149:10: ( variable | method_chain | eq_check )";
        }
    }
    static final String DFA32_eotS =
        "\111\uffff";
    static final String DFA32_eofS =
        "\111\uffff";
    static final String DFA32_minS =
        "\1\64\1\7\1\uffff\1\66\1\uffff\1\11\1\7\1\11\1\31\2\11\1\7\1\30"+
        "\1\25\1\11\2\66\1\uffff\1\11\1\31\2\11\1\66\1\11\1\10\1\25\1\11"+
        "\1\66\1\26\1\66\1\11\1\66\1\11\1\66\1\10\1\11\1\31\2\11\1\7\1\26"+
        "\1\25\1\30\1\25\1\11\3\66\1\11\1\31\2\11\1\66\1\11\1\25\1\26\1\25"+
        "\1\11\1\66\1\26\2\66\1\11\1\66\2\26\1\25\2\66\1\25\1\26\1\66\1\26";
    static final String DFA32_maxS =
        "\1\70\1\61\1\uffff\1\66\1\uffff\1\70\1\61\1\26\1\70\2\26\1\61\1"+
        "\70\1\25\1\26\2\66\1\uffff\1\26\1\70\2\26\1\70\1\26\1\24\1\25\1"+
        "\26\1\66\1\31\1\66\2\70\1\26\1\70\1\24\1\26\1\70\2\26\1\61\1\31"+
        "\1\25\1\70\1\25\1\26\1\66\2\70\1\26\1\70\2\26\1\70\1\26\1\25\1\31"+
        "\1\25\1\26\1\66\1\31\2\70\1\26\1\70\2\31\1\25\2\70\1\25\1\31\1\70"+
        "\1\31";
    static final String DFA32_acceptS =
        "\2\uffff\1\3\1\uffff\1\1\14\uffff\1\2\67\uffff";
    static final String DFA32_specialS =
        "\111\uffff}>";
    static final String[] DFA32_transitionS = {
            "\1\2\1\uffff\1\1\1\uffff\1\2",
            "\1\4\1\5\4\uffff\4\2\1\uffff\1\4\1\uffff\1\3\34\uffff\1\4",
            "",
            "\1\6",
            "",
            "\1\13\16\uffff\1\10\33\uffff\1\11\1\uffff\1\12\1\uffff\1\7",
            "\1\4\1\5\4\uffff\4\2\1\uffff\1\4\1\uffff\1\3\34\uffff\1\4",
            "\1\13\14\uffff\1\14",
            "\1\16\34\uffff\1\15\1\uffff\1\15",
            "\1\13\14\uffff\1\14",
            "\1\13\12\uffff\1\17\1\uffff\1\14",
            "\1\21\5\uffff\4\2\1\uffff\1\21\1\uffff\1\20\34\uffff\1\21",
            "\1\23\33\uffff\1\24\1\uffff\1\25\1\uffff\1\22",
            "\1\26",
            "\1\13\14\uffff\1\14",
            "\1\27",
            "\1\30",
            "",
            "\1\13\14\uffff\1\14",
            "\1\32\34\uffff\1\31\1\uffff\1\31",
            "\1\13\14\uffff\1\14",
            "\1\13\12\uffff\1\33\1\uffff\1\14",
            "\1\34\1\uffff\1\34",
            "\1\13\12\uffff\1\17\1\uffff\1\14",
            "\1\36\13\uffff\1\35",
            "\1\37",
            "\1\13\14\uffff\1\14",
            "\1\40",
            "\1\41\2\uffff\1\16",
            "\1\42",
            "\1\47\16\uffff\1\44\33\uffff\1\45\1\uffff\1\46\1\uffff\1\43",
            "\1\50\1\uffff\1\50",
            "\1\13\12\uffff\1\33\1\uffff\1\14",
            "\1\51\1\uffff\1\51",
            "\1\36\13\uffff\1\35",
            "\1\47\14\uffff\1\52",
            "\1\54\34\uffff\1\53\1\uffff\1\53",
            "\1\47\14\uffff\1\52",
            "\1\47\12\uffff\1\55\1\uffff\1\52",
            "\1\21\5\uffff\4\2\1\uffff\1\21\1\uffff\1\20\34\uffff\1\21",
            "\1\56\2\uffff\1\32",
            "\1\57",
            "\1\61\33\uffff\1\62\1\uffff\1\63\1\uffff\1\60",
            "\1\64",
            "\1\47\14\uffff\1\52",
            "\1\65",
            "\1\66\1\uffff\1\66",
            "\1\67\1\uffff\1\67",
            "\1\47\14\uffff\1\52",
            "\1\71\34\uffff\1\70\1\uffff\1\70",
            "\1\47\14\uffff\1\52",
            "\1\47\12\uffff\1\72\1\uffff\1\52",
            "\1\73\1\uffff\1\73",
            "\1\47\12\uffff\1\55\1\uffff\1\52",
            "\1\74",
            "\1\41\2\uffff\1\16",
            "\1\75",
            "\1\47\14\uffff\1\52",
            "\1\76",
            "\1\77\2\uffff\1\54",
            "\1\100\1\uffff\1\100",
            "\1\101\1\uffff\1\101",
            "\1\47\12\uffff\1\72\1\uffff\1\52",
            "\1\102\1\uffff\1\102",
            "\1\56\2\uffff\1\32",
            "\1\103\2\uffff\1\71",
            "\1\104",
            "\1\105\1\uffff\1\105",
            "\1\106\1\uffff\1\106",
            "\1\107",
            "\1\77\2\uffff\1\54",
            "\1\110\1\uffff\1\110",
            "\1\103\2\uffff\1\71"
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
            return "149:53: ( variable | method_chain | eq_check )";
        }
    }
    static final String DFA35_eotS =
        "\6\uffff";
    static final String DFA35_eofS =
        "\6\uffff";
    static final String DFA35_minS =
        "\1\66\1\7\1\66\2\uffff\1\7";
    static final String DFA35_maxS =
        "\1\66\1\24\1\66\2\uffff\1\24";
    static final String DFA35_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA35_specialS =
        "\6\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1",
            "\1\3\1\4\13\uffff\1\2",
            "\1\5",
            "",
            "",
            "\1\3\1\4\13\uffff\1\2"
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "153:12: ( variable | method_chain )";
        }
    }
    static final String DFA38_eotS =
        "\11\uffff";
    static final String DFA38_eofS =
        "\11\uffff";
    static final String DFA38_minS =
        "\1\64\2\7\2\uffff\1\66\2\uffff\1\7";
    static final String DFA38_maxS =
        "\1\70\1\23\1\24\2\uffff\1\66\2\uffff\1\24";
    static final String DFA38_acceptS =
        "\3\uffff\1\3\1\1\1\uffff\1\2\1\4\1\uffff";
    static final String DFA38_specialS =
        "\11\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\3\1\uffff\1\2\1\uffff\1\1",
            "\1\4\12\uffff\1\4\1\3",
            "\1\7\1\6\11\uffff\1\7\1\3\1\5",
            "",
            "",
            "\1\10",
            "",
            "",
            "\1\7\1\6\11\uffff\1\7\1\uffff\1\5"
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "164:1: for_value : ( STRING_LITERAL | method_chain | range | variable );";
        }
    }
    static final String DFA39_eotS =
        "\115\uffff";
    static final String DFA39_eofS =
        "\115\uffff";
    static final String DFA39_minS =
        "\1\64\2\15\1\10\3\uffff\1\66\1\uffff\1\11\1\10\1\11\1\31\2\11\1"+
        "\15\1\30\1\25\1\11\2\66\1\uffff\1\11\1\31\2\11\1\66\1\11\1\10\1"+
        "\25\1\11\1\66\1\26\1\66\1\11\1\66\1\11\1\66\1\10\1\11\1\31\2\11"+
        "\1\15\1\26\1\25\1\30\1\25\1\11\3\66\1\11\1\31\2\11\1\66\1\11\1\25"+
        "\1\26\1\25\1\11\1\66\1\26\2\66\1\11\1\66\2\26\1\25\2\66\1\25\1\26"+
        "\1\66\1\26";
    static final String DFA39_maxS =
        "\1\70\3\32\3\uffff\1\66\1\uffff\1\70\1\32\1\26\1\70\2\26\1\32\1"+
        "\70\1\25\1\26\2\66\1\uffff\1\26\1\70\2\26\1\70\1\26\1\24\1\25\1"+
        "\26\1\66\1\31\1\66\2\70\1\26\1\70\1\24\1\26\1\70\2\26\1\32\1\31"+
        "\1\25\1\70\1\25\1\26\1\66\2\70\1\26\1\70\2\26\1\70\1\26\1\25\1\31"+
        "\1\25\1\26\1\66\1\31\2\70\1\26\1\70\2\31\1\25\2\70\1\25\1\31\1\70"+
        "\1\31";
    static final String DFA39_acceptS =
        "\4\uffff\1\1\1\5\1\2\1\uffff\1\3\14\uffff\1\4\67\uffff";
    static final String DFA39_specialS =
        "\115\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "\4\5\11\uffff\1\4",
            "\4\5\11\uffff\1\6",
            "\1\11\4\uffff\4\5\3\uffff\1\7\5\uffff\1\10",
            "",
            "",
            "",
            "\1\12",
            "",
            "\1\17\16\uffff\1\14\33\uffff\1\15\1\uffff\1\16\1\uffff\1\13",
            "\1\11\4\uffff\4\5\3\uffff\1\7\5\uffff\1\10",
            "\1\17\14\uffff\1\20",
            "\1\22\34\uffff\1\21\1\uffff\1\21",
            "\1\17\14\uffff\1\20",
            "\1\17\12\uffff\1\23\1\uffff\1\20",
            "\4\5\3\uffff\1\24\5\uffff\1\25",
            "\1\27\33\uffff\1\30\1\uffff\1\31\1\uffff\1\26",
            "\1\32",
            "\1\17\14\uffff\1\20",
            "\1\33",
            "\1\34",
            "",
            "\1\17\14\uffff\1\20",
            "\1\36\34\uffff\1\35\1\uffff\1\35",
            "\1\17\14\uffff\1\20",
            "\1\17\12\uffff\1\37\1\uffff\1\20",
            "\1\40\1\uffff\1\40",
            "\1\17\12\uffff\1\23\1\uffff\1\20",
            "\1\42\13\uffff\1\41",
            "\1\43",
            "\1\17\14\uffff\1\20",
            "\1\44",
            "\1\45\2\uffff\1\22",
            "\1\46",
            "\1\53\16\uffff\1\50\33\uffff\1\51\1\uffff\1\52\1\uffff\1\47",
            "\1\54\1\uffff\1\54",
            "\1\17\12\uffff\1\37\1\uffff\1\20",
            "\1\55\1\uffff\1\55",
            "\1\42\13\uffff\1\41",
            "\1\53\14\uffff\1\56",
            "\1\60\34\uffff\1\57\1\uffff\1\57",
            "\1\53\14\uffff\1\56",
            "\1\53\12\uffff\1\61\1\uffff\1\56",
            "\4\5\3\uffff\1\24\5\uffff\1\25",
            "\1\62\2\uffff\1\36",
            "\1\63",
            "\1\65\33\uffff\1\66\1\uffff\1\67\1\uffff\1\64",
            "\1\70",
            "\1\53\14\uffff\1\56",
            "\1\71",
            "\1\72\1\uffff\1\72",
            "\1\73\1\uffff\1\73",
            "\1\53\14\uffff\1\56",
            "\1\75\34\uffff\1\74\1\uffff\1\74",
            "\1\53\14\uffff\1\56",
            "\1\53\12\uffff\1\76\1\uffff\1\56",
            "\1\77\1\uffff\1\77",
            "\1\53\12\uffff\1\61\1\uffff\1\56",
            "\1\100",
            "\1\45\2\uffff\1\22",
            "\1\101",
            "\1\53\14\uffff\1\56",
            "\1\102",
            "\1\103\2\uffff\1\60",
            "\1\104\1\uffff\1\104",
            "\1\105\1\uffff\1\105",
            "\1\53\12\uffff\1\76\1\uffff\1\56",
            "\1\106\1\uffff\1\106",
            "\1\62\2\uffff\1\36",
            "\1\107\2\uffff\1\75",
            "\1\110",
            "\1\111\1\uffff\1\111",
            "\1\112\1\uffff\1\112",
            "\1\113",
            "\1\103\2\uffff\1\60",
            "\1\114\1\uffff\1\114",
            "\1\107\2\uffff\1\75"
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "173:5: ( STRING_LITERAL | NUMBER | variable | method_chain | eq_check )";
        }
    }
    static final String DFA40_eotS =
        "\10\uffff";
    static final String DFA40_eofS =
        "\10\uffff";
    static final String DFA40_minS =
        "\1\64\2\uffff\1\10\1\66\2\uffff\1\10";
    static final String DFA40_maxS =
        "\1\70\2\uffff\1\25\1\66\2\uffff\1\25";
    static final String DFA40_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA40_specialS =
        "\10\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\6\13\uffff\1\4\1\5",
            "\1\7",
            "",
            "",
            "\1\6\13\uffff\1\4\1\5"
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "173:71: ( STRING_LITERAL | NUMBER | variable | method_chain )";
        }
    }
    static final String DFA41_eotS =
        "\10\uffff";
    static final String DFA41_eofS =
        "\10\uffff";
    static final String DFA41_minS =
        "\1\64\2\uffff\1\5\1\66\2\uffff\1\5";
    static final String DFA41_maxS =
        "\1\70\2\uffff\1\60\1\66\2\uffff\1\60";
    static final String DFA41_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA41_specialS =
        "\10\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\2\1\uffff\1\3\1\uffff\1\1",
            "",
            "",
            "\1\5\1\uffff\1\5\1\6\11\uffff\1\5\1\uffff\1\4\33\uffff\1\5",
            "\1\7",
            "",
            "",
            "\1\5\1\uffff\1\5\1\6\11\uffff\1\5\1\uffff\1\4\33\uffff\1\5"
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "173:129: ( STRING_LITERAL | NUMBER | variable | method_chain )";
        }
    }
    static final String DFA42_eotS =
        "\10\uffff";
    static final String DFA42_eofS =
        "\10\uffff";
    static final String DFA42_minS =
        "\1\64\1\10\2\uffff\1\66\2\uffff\1\10";
    static final String DFA42_maxS =
        "\1\70\1\24\2\uffff\1\66\2\uffff\1\24";
    static final String DFA42_acceptS =
        "\2\uffff\1\3\1\4\1\uffff\1\1\1\2\1\uffff";
    static final String DFA42_specialS =
        "\10\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\2\1\uffff\1\1\1\uffff\1\3",
            "\1\6\4\uffff\4\5\3\uffff\1\4",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\6\4\uffff\4\5\3\uffff\1\4"
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "178:5: ( variable | method_chain | NUMBER | STRING_LITERAL )";
        }
    }
    static final String DFA43_eotS =
        "\10\uffff";
    static final String DFA43_eofS =
        "\10\uffff";
    static final String DFA43_minS =
        "\1\64\1\7\2\uffff\1\66\2\uffff\1\7";
    static final String DFA43_maxS =
        "\1\70\1\61\2\uffff\1\66\2\uffff\1\61";
    static final String DFA43_acceptS =
        "\2\uffff\1\3\1\4\1\uffff\1\1\1\2\1\uffff";
    static final String DFA43_specialS =
        "\10\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\2\1\uffff\1\1\1\uffff\1\3",
            "\1\5\1\6\11\uffff\1\5\1\uffff\1\4\5\uffff\1\5\26\uffff\1\5",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\5\1\6\11\uffff\1\5\1\uffff\1\4\5\uffff\1\5\26\uffff\1\5"
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "178:95: ( variable | method_chain | NUMBER | STRING_LITERAL )";
        }
    }
    static final String DFA46_eotS =
        "\116\uffff";
    static final String DFA46_eofS =
        "\116\uffff";
    static final String DFA46_minS =
        "\1\12\1\5\1\uffff\1\5\2\uffff\1\66\1\uffff\1\11\2\uffff\1\5\1\11"+
        "\1\31\2\11\1\5\1\30\1\25\1\11\2\66\1\uffff\1\11\1\31\2\11\1\66\1"+
        "\11\1\10\1\25\1\11\1\66\1\26\1\66\1\11\1\66\1\11\1\66\1\10\1\11"+
        "\1\31\2\11\1\5\1\26\1\25\1\30\1\25\1\11\3\66\1\11\1\31\2\11\1\66"+
        "\1\11\1\25\1\26\1\25\1\11\1\66\1\26\2\66\1\11\1\66\2\26\1\25\2\66"+
        "\1\25\1\26\1\66\1\26";
    static final String DFA46_maxS =
        "\1\70\1\32\1\uffff\1\32\2\uffff\1\66\1\uffff\1\70\2\uffff\1\32\1"+
        "\26\1\70\2\26\1\32\1\70\1\25\1\26\2\66\1\uffff\1\26\1\70\2\26\1"+
        "\70\1\26\1\24\1\25\1\26\1\66\1\31\1\66\2\70\1\26\1\70\1\24\1\26"+
        "\1\70\2\26\1\32\1\31\1\25\1\70\1\25\1\26\1\66\2\70\1\26\1\70\2\26"+
        "\1\70\1\26\1\25\1\31\1\25\1\26\1\66\1\31\2\70\1\26\1\70\2\31\1\25"+
        "\2\70\1\25\1\31\1\70\1\31";
    static final String DFA46_acceptS =
        "\2\uffff\1\3\1\uffff\1\5\1\6\1\uffff\1\1\1\uffff\1\7\1\4\13\uffff"+
        "\1\2\67\uffff";
    static final String DFA46_specialS =
        "\116\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\2\41\uffff\1\5\7\uffff\1\4\1\uffff\1\1\1\uffff\1\3",
            "\1\7\1\uffff\1\7\1\10\4\uffff\4\4\1\11\1\7\1\uffff\1\6\5\uffff"+
            "\1\4",
            "",
            "\1\12\1\uffff\1\12\5\uffff\4\4\1\11\1\12\7\uffff\1\4",
            "",
            "",
            "\1\13",
            "",
            "\1\20\16\uffff\1\15\33\uffff\1\16\1\uffff\1\17\1\uffff\1\14",
            "",
            "",
            "\1\7\1\uffff\1\7\1\10\4\uffff\4\4\1\11\1\7\1\uffff\1\6\5\uffff"+
            "\1\4",
            "\1\20\14\uffff\1\21",
            "\1\23\34\uffff\1\22\1\uffff\1\22",
            "\1\20\14\uffff\1\21",
            "\1\20\12\uffff\1\24\1\uffff\1\21",
            "\1\26\1\uffff\1\26\5\uffff\4\4\1\11\1\26\1\uffff\1\25\5\uffff"+
            "\1\4",
            "\1\30\33\uffff\1\31\1\uffff\1\32\1\uffff\1\27",
            "\1\33",
            "\1\20\14\uffff\1\21",
            "\1\34",
            "\1\35",
            "",
            "\1\20\14\uffff\1\21",
            "\1\37\34\uffff\1\36\1\uffff\1\36",
            "\1\20\14\uffff\1\21",
            "\1\20\12\uffff\1\40\1\uffff\1\21",
            "\1\41\1\uffff\1\41",
            "\1\20\12\uffff\1\24\1\uffff\1\21",
            "\1\43\13\uffff\1\42",
            "\1\44",
            "\1\20\14\uffff\1\21",
            "\1\45",
            "\1\46\2\uffff\1\23",
            "\1\47",
            "\1\54\16\uffff\1\51\33\uffff\1\52\1\uffff\1\53\1\uffff\1\50",
            "\1\55\1\uffff\1\55",
            "\1\20\12\uffff\1\40\1\uffff\1\21",
            "\1\56\1\uffff\1\56",
            "\1\43\13\uffff\1\42",
            "\1\54\14\uffff\1\57",
            "\1\61\34\uffff\1\60\1\uffff\1\60",
            "\1\54\14\uffff\1\57",
            "\1\54\12\uffff\1\62\1\uffff\1\57",
            "\1\26\1\uffff\1\26\5\uffff\4\4\1\11\1\26\1\uffff\1\25\5\uffff"+
            "\1\4",
            "\1\63\2\uffff\1\37",
            "\1\64",
            "\1\66\33\uffff\1\67\1\uffff\1\70\1\uffff\1\65",
            "\1\71",
            "\1\54\14\uffff\1\57",
            "\1\72",
            "\1\73\1\uffff\1\73",
            "\1\74\1\uffff\1\74",
            "\1\54\14\uffff\1\57",
            "\1\76\34\uffff\1\75\1\uffff\1\75",
            "\1\54\14\uffff\1\57",
            "\1\54\12\uffff\1\77\1\uffff\1\57",
            "\1\100\1\uffff\1\100",
            "\1\54\12\uffff\1\62\1\uffff\1\57",
            "\1\101",
            "\1\46\2\uffff\1\23",
            "\1\102",
            "\1\54\14\uffff\1\57",
            "\1\103",
            "\1\104\2\uffff\1\61",
            "\1\105\1\uffff\1\105",
            "\1\106\1\uffff\1\106",
            "\1\54\12\uffff\1\77\1\uffff\1\57",
            "\1\107\1\uffff\1\107",
            "\1\63\2\uffff\1\37",
            "\1\110\2\uffff\1\76",
            "\1\111",
            "\1\112\1\uffff\1\112",
            "\1\113\1\uffff\1\113",
            "\1\114",
            "\1\104\2\uffff\1\61",
            "\1\115\1\uffff\1\115",
            "\1\110\2\uffff\1\76"
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "192:1: p_input : ( variable | method_chain | array | STRING_LITERAL | twig_ternary | twig_not | concat );";
        }
    }
    static final String DFA48_eotS =
        "\7\uffff";
    static final String DFA48_eofS =
        "\7\uffff";
    static final String DFA48_minS =
        "\1\66\1\uffff\1\5\1\66\2\uffff\1\5";
    static final String DFA48_maxS =
        "\1\70\1\uffff\1\70\1\66\2\uffff\1\70";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\3\1\uffff";
    static final String DFA48_specialS =
        "\7\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\2\1\uffff\1\1",
            "",
            "\1\4\1\uffff\1\4\1\5\1\uffff\1\4\6\uffff\2\4\1\uffff\1\3\27"+
            "\uffff\1\4\7\uffff\1\4\1\uffff\1\4\1\uffff\1\4",
            "\1\6",
            "",
            "",
            "\1\4\1\uffff\1\4\1\5\1\uffff\1\4\6\uffff\2\4\1\uffff\1\3\27"+
            "\uffff\1\4\7\uffff\1\4\1\uffff\1\4\1\uffff\1\4"
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "201:5: ( STRING_LITERAL | variable | method_chain )";
        }
    }
    static final String DFA49_eotS =
        "\111\uffff";
    static final String DFA49_eofS =
        "\111\uffff";
    static final String DFA49_minS =
        "\1\64\1\uffff\1\5\1\66\1\11\1\uffff\1\5\1\11\1\31\2\11\1\5\1\30"+
        "\1\25\1\11\2\66\1\uffff\1\11\1\31\2\11\1\66\1\11\1\10\1\25\1\11"+
        "\1\66\1\26\1\66\1\11\1\66\1\11\1\66\1\10\1\11\1\31\2\11\1\5\1\26"+
        "\1\25\1\30\1\25\1\11\3\66\1\11\1\31\2\11\1\66\1\11\1\25\1\26\1\25"+
        "\1\11\1\66\1\26\2\66\1\11\1\66\2\26\1\25\2\66\1\25\1\26\1\66\1\26";
    static final String DFA49_maxS =
        "\1\70\1\uffff\1\32\1\66\1\70\1\uffff\1\32\1\26\1\70\2\26\1\32\1"+
        "\70\1\25\1\26\2\66\1\uffff\1\26\1\70\2\26\1\70\1\26\1\24\1\25\1"+
        "\26\1\66\1\31\1\66\2\70\1\26\1\70\1\24\1\26\1\70\2\26\1\32\1\31"+
        "\1\25\1\70\1\25\1\26\1\66\2\70\1\26\1\70\2\26\1\70\1\26\1\25\1\31"+
        "\1\25\1\26\1\66\1\31\2\70\1\26\1\70\2\31\1\25\2\70\1\25\1\31\1\70"+
        "\1\31";
    static final String DFA49_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\13\uffff\1\3\67\uffff";
    static final String DFA49_specialS =
        "\111\uffff}>";
    static final String[] DFA49_transitionS = {
            "\1\1\1\uffff\1\2\1\uffff\1\1",
            "",
            "\1\5\1\uffff\1\5\1\4\4\uffff\4\1\1\uffff\1\5\1\uffff\1\3\5"+
            "\uffff\1\1",
            "\1\6",
            "\1\13\16\uffff\1\10\33\uffff\1\11\1\uffff\1\12\1\uffff\1\7",
            "",
            "\1\5\1\uffff\1\5\1\4\4\uffff\4\1\1\uffff\1\5\1\uffff\1\3\5"+
            "\uffff\1\1",
            "\1\13\14\uffff\1\14",
            "\1\16\34\uffff\1\15\1\uffff\1\15",
            "\1\13\14\uffff\1\14",
            "\1\13\12\uffff\1\17\1\uffff\1\14",
            "\1\21\1\uffff\1\21\5\uffff\4\1\1\uffff\1\21\1\uffff\1\20\5"+
            "\uffff\1\1",
            "\1\23\33\uffff\1\24\1\uffff\1\25\1\uffff\1\22",
            "\1\26",
            "\1\13\14\uffff\1\14",
            "\1\27",
            "\1\30",
            "",
            "\1\13\14\uffff\1\14",
            "\1\32\34\uffff\1\31\1\uffff\1\31",
            "\1\13\14\uffff\1\14",
            "\1\13\12\uffff\1\33\1\uffff\1\14",
            "\1\34\1\uffff\1\34",
            "\1\13\12\uffff\1\17\1\uffff\1\14",
            "\1\36\13\uffff\1\35",
            "\1\37",
            "\1\13\14\uffff\1\14",
            "\1\40",
            "\1\41\2\uffff\1\16",
            "\1\42",
            "\1\47\16\uffff\1\44\33\uffff\1\45\1\uffff\1\46\1\uffff\1\43",
            "\1\50\1\uffff\1\50",
            "\1\13\12\uffff\1\33\1\uffff\1\14",
            "\1\51\1\uffff\1\51",
            "\1\36\13\uffff\1\35",
            "\1\47\14\uffff\1\52",
            "\1\54\34\uffff\1\53\1\uffff\1\53",
            "\1\47\14\uffff\1\52",
            "\1\47\12\uffff\1\55\1\uffff\1\52",
            "\1\21\1\uffff\1\21\5\uffff\4\1\1\uffff\1\21\1\uffff\1\20\5"+
            "\uffff\1\1",
            "\1\56\2\uffff\1\32",
            "\1\57",
            "\1\61\33\uffff\1\62\1\uffff\1\63\1\uffff\1\60",
            "\1\64",
            "\1\47\14\uffff\1\52",
            "\1\65",
            "\1\66\1\uffff\1\66",
            "\1\67\1\uffff\1\67",
            "\1\47\14\uffff\1\52",
            "\1\71\34\uffff\1\70\1\uffff\1\70",
            "\1\47\14\uffff\1\52",
            "\1\47\12\uffff\1\72\1\uffff\1\52",
            "\1\73\1\uffff\1\73",
            "\1\47\12\uffff\1\55\1\uffff\1\52",
            "\1\74",
            "\1\41\2\uffff\1\16",
            "\1\75",
            "\1\47\14\uffff\1\52",
            "\1\76",
            "\1\77\2\uffff\1\54",
            "\1\100\1\uffff\1\100",
            "\1\101\1\uffff\1\101",
            "\1\47\12\uffff\1\72\1\uffff\1\52",
            "\1\102\1\uffff\1\102",
            "\1\56\2\uffff\1\32",
            "\1\103\2\uffff\1\71",
            "\1\104",
            "\1\105\1\uffff\1\105",
            "\1\106\1\uffff\1\106",
            "\1\107",
            "\1\77\2\uffff\1\54",
            "\1\110\1\uffff\1\110",
            "\1\103\2\uffff\1\71"
    };

    static final short[] DFA49_eot = DFA.unpackEncodedString(DFA49_eotS);
    static final short[] DFA49_eof = DFA.unpackEncodedString(DFA49_eofS);
    static final char[] DFA49_min = DFA.unpackEncodedStringToUnsignedChars(DFA49_minS);
    static final char[] DFA49_max = DFA.unpackEncodedStringToUnsignedChars(DFA49_maxS);
    static final short[] DFA49_accept = DFA.unpackEncodedString(DFA49_acceptS);
    static final short[] DFA49_special = DFA.unpackEncodedString(DFA49_specialS);
    static final short[][] DFA49_transition;

    static {
        int numStates = DFA49_transitionS.length;
        DFA49_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA49_transition[i] = DFA.unpackEncodedString(DFA49_transitionS[i]);
        }
    }

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = DFA49_eot;
            this.eof = DFA49_eof;
            this.min = DFA49_min;
            this.max = DFA49_max;
            this.accept = DFA49_accept;
            this.special = DFA49_special;
            this.transition = DFA49_transition;
        }
        public String getDescription() {
            return "205:9: ( twig_ternary | variable | method_chain )";
        }
    }
 

    public static final BitSet FOLLOW_twig_print_statement_in_twig_source69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_control_statement_in_twig_source73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTRL_OPEN_in_twig_control_statement89 = new BitSet(new long[]{0x00406FE7F8000080L});
    public static final BitSet FOLLOW_twig_control_in_twig_control_statement91 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_CTRL_CLOSE_in_twig_control_statement94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_control108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_for_in_twig_control112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDFOR_in_twig_control116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_twig_control120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_if_in_twig_control124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_elseif_in_twig_control128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDIF_in_twig_control132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_macro_in_twig_control136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_import_in_twig_control140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_set_in_twig_control144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_include_in_twig_control148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_block_in_twig_control152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_extends_in_twig_control156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_use_in_twig_control160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assets_in_twig_control164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_assets178 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_assets180 = new BitSet(new long[]{0x0100000000000002L});
    public static final BitSet FOLLOW_USE_in_twig_use198 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_use200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXTENDS_in_twig_extends213 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_extends215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_twig_block232 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_twig_block_param_in_twig_block234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDBLOCK_in_twig_block240 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_block242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_block_param260 = new BitSet(new long[]{0x0150100000000402L});
    public static final BitSet FOLLOW_method_chain_in_twig_block_param264 = new BitSet(new long[]{0x0150100000000402L});
    public static final BitSet FOLLOW_concat_in_twig_block_param268 = new BitSet(new long[]{0x0150100000000402L});
    public static final BitSet FOLLOW_twig_print_in_twig_block_param271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_twig_include287 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_include_ternary_in_twig_include290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_twig_include294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_ternary_in_include_ternary310 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_ternary312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement329 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement332 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_WITH_in_include_statement336 = new BitSet(new long[]{0x0140000001000000L});
    public static final BitSet FOLLOW_variable_in_include_statement339 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement343 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_method_chain_in_include_statement347 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_json_in_include_statement351 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_twig_set373 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set375 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_twig_set378 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set380 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ENDSET_in_twig_set387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_left_assignment_in_twig_assignment402 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ASIG_in_twig_assignment405 = new BitSet(new long[]{0x0140000001000400L});
    public static final BitSet FOLLOW_twig_right_assignment_in_twig_assignment408 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_PIPE_in_twig_assignment411 = new BitSet(new long[]{0x0140000001000400L});
    public static final BitSet FOLLOW_twig_right_assignment_in_twig_assignment413 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment434 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_twig_left_assignment437 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment439 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment458 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment462 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_method_chain_in_twig_right_assignment466 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment470 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment474 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment478 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_twig_right_assignment482 = new BitSet(new long[]{0x0140000001000400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment485 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment489 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_method_chain_in_twig_right_assignment493 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment497 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment501 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment505 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument524 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument528 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_method_chain_in_twig_tilde_argument532 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument536 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument540 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_TILDE_in_twig_tilde_argument543 = new BitSet(new long[]{0x0140000001000400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_tilde_argument554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_twig_import579 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import582 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_IMPORT_in_twig_import587 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import590 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_variable_in_twig_import594 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_TWIG_AS_in_twig_import598 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import601 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_twig_import604 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import606 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_MACRO_in_twig_macro628 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_macro631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_macro635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDMACRO_in_twig_macro641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_twig_if656 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_if661 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_method_chain_in_twig_if665 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_eq_check_in_twig_if669 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_PIPE_in_twig_if673 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_if676 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_method_chain_in_twig_if680 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_eq_check_in_twig_if684 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_IS_in_twig_if691 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_DEFINED_in_twig_if693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSEIF_in_twig_elseif710 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_elseif713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_elseif717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_twig_for733 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_for736 = new BitSet(new long[]{0x0000000800400000L});
    public static final BitSet FOLLOW_COMMA_in_twig_for739 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_for741 = new BitSet(new long[]{0x0000000800400000L});
    public static final BitSet FOLLOW_IN_in_twig_for746 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_for_arguments_in_twig_for748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_value_in_for_arguments763 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_PIPE_in_for_arguments766 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_for_value_in_for_arguments768 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_for_value786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_for_value790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_for_value794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_for_value798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_range813 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DDOT_in_range825 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_set_in_range827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary854 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary858 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary862 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary866 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_eq_check_in_twig_ternary870 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_QM_in_twig_ternary873 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary876 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary880 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary884 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary888 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COLON_in_twig_ternary891 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_ternary902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_eq_check923 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_method_chain_in_eq_check927 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_NUMBER_in_eq_check931 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_eq_check935 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_set_in_eq_check938 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_variable_in_eq_check955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_eq_check959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_eq_check963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_eq_check967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_OPEN_in_twig_print_statement988 = new BitSet(new long[]{0x0150100000000420L});
    public static final BitSet FOLLOW_twig_print_in_twig_print_statement990 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_PRINT_CLOSE_in_twig_print_statement993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_p_input_in_twig_print1020 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_PIPE_in_twig_print1023 = new BitSet(new long[]{0x0150100000000400L});
    public static final BitSet FOLLOW_p_input_in_twig_print1025 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_p_input1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_p_input1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_p_input1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_p_input1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_ternary_in_p_input1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_not_in_p_input1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concat_in_p_input1066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concat_operand_in_concat1081 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_TILDE_in_concat1083 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_concat_operand_in_concat1085 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_TILDE_in_concat1088 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_concat_operand_in_concat1090 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_concat_operand1108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_concat_operand1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_concat_operand1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_twig_not1132 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_twig_ternary_in_twig_not1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_not1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_not1143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_START_in_array1159 = new BitSet(new long[]{0x0150000001000000L});
    public static final BitSet FOLLOW_array_elements_in_array1161 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ARRAY_END_in_array1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_element_in_array_elements1178 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_array_elements1181 = new BitSet(new long[]{0x0150000001000000L});
    public static final BitSet FOLLOW_array_element_in_array_elements1183 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_STRING_in_array_element1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_array_element1204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_array_element1208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_array_element1212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_variable1229 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_DOT_in_variable1232 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_variable1235 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_method_in_method_chain1267 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_DOT_in_method_chain1270 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_method_in_method_chain1272 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_variable_in_method1289 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_METHOD_START_in_method1291 = new BitSet(new long[]{0x0150000001000200L});
    public static final BitSet FOLLOW_arguments_in_method1293 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_METHOD_END_in_method1296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_arguments1312 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_arguments1316 = new BitSet(new long[]{0x0150000001000000L});
    public static final BitSet FOLLOW_argument_in_arguments1319 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_literal_argument_in_argument1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_argument1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_argument1341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_argument1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal_argument1358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_START_in_json1384 = new BitSet(new long[]{0x0140000002000000L});
    public static final BitSet FOLLOW_json_arguments_in_json1386 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_JSON_END_in_json1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1404 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_json_arguments1407 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1410 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_set_in_json_argument1428 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COLON_in_json_argument1437 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_set_in_json_argument1440 = new BitSet(new long[]{0x0000000000000002L});

}