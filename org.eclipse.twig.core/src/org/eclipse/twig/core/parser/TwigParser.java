// $ANTLR 3.3 Nov 30, 2010 12:45:30 TwigParser.g 2011-07-05 23:25:53

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
    // TwigParser.g:104:1: twig_block_param : ( variable | method_chain ) ( twig_print )? ;
    public final TwigParser.twig_block_param_return twig_block_param() throws RecognitionException {
        TwigParser.twig_block_param_return retval = new TwigParser.twig_block_param_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        TwigParser.variable_return variable31 = null;

        TwigParser.method_chain_return method_chain32 = null;

        TwigParser.twig_print_return twig_print33 = null;



        try {
            // TwigParser.g:105:3: ( ( variable | method_chain ) ( twig_print )? )
            // TwigParser.g:105:5: ( variable | method_chain ) ( twig_print )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:105:5: ( variable | method_chain )
            int alt7=2;
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

            }

            // TwigParser.g:105:31: ( twig_print )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ARRAY_START||LA8_0==NOT||LA8_0==NUMBER||LA8_0==STRING||LA8_0==STRING_LITERAL) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // TwigParser.g:105:31: twig_print
                    {
                    pushFollow(FOLLOW_twig_print_in_twig_block_param267);
                    twig_print33=twig_print();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_print33.getTree());

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

        CommonToken INCLUDE34=null;
        TwigParser.include_ternary_return include_ternary35 = null;

        TwigParser.include_statement_return include_statement36 = null;


        TwigCommonTree INCLUDE34_tree=null;

        try {
            // TwigParser.g:109:3: ( INCLUDE ( include_ternary | include_statement ) )
            // TwigParser.g:109:5: INCLUDE ( include_ternary | include_statement )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            INCLUDE34=(CommonToken)match(input,INCLUDE,FOLLOW_INCLUDE_in_twig_include283); 
            INCLUDE34_tree = (TwigCommonTree)adaptor.create(INCLUDE34);
            adaptor.addChild(root_0, INCLUDE34_tree);

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
                    pushFollow(FOLLOW_include_ternary_in_twig_include286);
                    include_ternary35=include_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, include_ternary35.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:109:32: include_statement
                    {
                    pushFollow(FOLLOW_include_statement_in_twig_include290);
                    include_statement36=include_statement();

                    state._fsp--;

                    adaptor.addChild(root_0, include_statement36.getTree());

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

        CommonToken ONLY38=null;
        TwigParser.twig_ternary_return twig_ternary37 = null;


        TwigCommonTree ONLY38_tree=null;

        try {
            // TwigParser.g:113:3: ( twig_ternary ( ONLY )? )
            // TwigParser.g:113:5: twig_ternary ( ONLY )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_ternary_in_include_ternary306);
            twig_ternary37=twig_ternary();

            state._fsp--;

            adaptor.addChild(root_0, twig_ternary37.getTree());
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
                    ONLY38=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_ternary308); 
                    ONLY38_tree = (TwigCommonTree)adaptor.create(ONLY38);
                    adaptor.addChild(root_0, ONLY38_tree);


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

        CommonToken STRING_LITERAL39=null;
        CommonToken ONLY40=null;
        CommonToken WITH41=null;
        CommonToken STRING_LITERAL43=null;
        CommonToken ONLY46=null;
        TwigParser.variable_return variable42 = null;

        TwigParser.method_chain_return method_chain44 = null;

        TwigParser.json_return json45 = null;


        TwigCommonTree STRING_LITERAL39_tree=null;
        TwigCommonTree ONLY40_tree=null;
        TwigCommonTree WITH41_tree=null;
        TwigCommonTree STRING_LITERAL43_tree=null;
        TwigCommonTree ONLY46_tree=null;

        try {
            // TwigParser.g:117:3: ( ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )? )
            // TwigParser.g:117:5: ( STRING_LITERAL ) ( ONLY )? ( WITH ( variable | STRING_LITERAL | method_chain | json ) ( ONLY )? )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:117:5: ( STRING_LITERAL )
            // TwigParser.g:117:6: STRING_LITERAL
            {
            STRING_LITERAL39=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement325); 
            STRING_LITERAL39_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL39);
            adaptor.addChild(root_0, STRING_LITERAL39_tree);


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
                    ONLY40=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement328); 
                    ONLY40_tree = (TwigCommonTree)adaptor.create(ONLY40);
                    adaptor.addChild(root_0, ONLY40_tree);


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
                    WITH41=(CommonToken)match(input,WITH,FOLLOW_WITH_in_include_statement332); 
                    WITH41_tree = (TwigCommonTree)adaptor.create(WITH41);
                    adaptor.addChild(root_0, WITH41_tree);

                    // TwigParser.g:117:34: ( variable | STRING_LITERAL | method_chain | json )
                    int alt12=4;
                    alt12 = dfa12.predict(input);
                    switch (alt12) {
                        case 1 :
                            // TwigParser.g:117:35: variable
                            {
                            pushFollow(FOLLOW_variable_in_include_statement335);
                            variable42=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable42.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:117:46: STRING_LITERAL
                            {
                            STRING_LITERAL43=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_include_statement339); 
                            STRING_LITERAL43_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL43);
                            adaptor.addChild(root_0, STRING_LITERAL43_tree);


                            }
                            break;
                        case 3 :
                            // TwigParser.g:117:63: method_chain
                            {
                            pushFollow(FOLLOW_method_chain_in_include_statement343);
                            method_chain44=method_chain();

                            state._fsp--;

                            adaptor.addChild(root_0, method_chain44.getTree());

                            }
                            break;
                        case 4 :
                            // TwigParser.g:117:78: json
                            {
                            pushFollow(FOLLOW_json_in_include_statement347);
                            json45=json();

                            state._fsp--;

                            adaptor.addChild(root_0, json45.getTree());

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
                            ONLY46=(CommonToken)match(input,ONLY,FOLLOW_ONLY_in_include_statement350); 
                            ONLY46_tree = (TwigCommonTree)adaptor.create(ONLY46);
                            adaptor.addChild(root_0, ONLY46_tree);


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

        CommonToken SET47=null;
        CommonToken COMMA49=null;
        CommonToken ENDSET51=null;
        TwigParser.twig_assignment_return twig_assignment48 = null;

        TwigParser.twig_assignment_return twig_assignment50 = null;


        TwigCommonTree SET47_tree=null;
        TwigCommonTree COMMA49_tree=null;
        TwigCommonTree ENDSET51_tree=null;

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
                    SET47=(CommonToken)match(input,SET,FOLLOW_SET_in_twig_set369); 
                    SET47_tree = (TwigCommonTree)adaptor.create(SET47);
                    adaptor.addChild(root_0, SET47_tree);

                    pushFollow(FOLLOW_twig_assignment_in_twig_set371);
                    twig_assignment48=twig_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_assignment48.getTree());
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
                    	    COMMA49=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_set374); 
                    	    COMMA49_tree = (TwigCommonTree)adaptor.create(COMMA49);
                    	    adaptor.addChild(root_0, COMMA49_tree);

                    	    pushFollow(FOLLOW_twig_assignment_in_twig_set376);
                    	    twig_assignment50=twig_assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, twig_assignment50.getTree());

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

                    ENDSET51=(CommonToken)match(input,ENDSET,FOLLOW_ENDSET_in_twig_set383); 
                    ENDSET51_tree = (TwigCommonTree)adaptor.create(ENDSET51);
                    adaptor.addChild(root_0, ENDSET51_tree);


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

        CommonToken ASIG53=null;
        CommonToken PIPE55=null;
        TwigParser.twig_left_assignment_return twig_left_assignment52 = null;

        TwigParser.twig_right_assignment_return twig_right_assignment54 = null;

        TwigParser.twig_right_assignment_return twig_right_assignment56 = null;


        TwigCommonTree ASIG53_tree=null;
        TwigCommonTree PIPE55_tree=null;

        try {
            // TwigParser.g:125:3: ( twig_left_assignment ( ASIG ( twig_right_assignment ( PIPE twig_right_assignment )* ) )? )
            // TwigParser.g:125:6: twig_left_assignment ( ASIG ( twig_right_assignment ( PIPE twig_right_assignment )* ) )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_twig_left_assignment_in_twig_assignment398);
            twig_left_assignment52=twig_left_assignment();

            state._fsp--;

            adaptor.addChild(root_0, twig_left_assignment52.getTree());
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
                    ASIG53=(CommonToken)match(input,ASIG,FOLLOW_ASIG_in_twig_assignment401); 
                    ASIG53_tree = (TwigCommonTree)adaptor.create(ASIG53);
                    adaptor.addChild(root_0, ASIG53_tree);

                    // TwigParser.g:125:33: ( twig_right_assignment ( PIPE twig_right_assignment )* )
                    // TwigParser.g:125:34: twig_right_assignment ( PIPE twig_right_assignment )*
                    {
                    pushFollow(FOLLOW_twig_right_assignment_in_twig_assignment404);
                    twig_right_assignment54=twig_right_assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_right_assignment54.getTree());
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
                    	    PIPE55=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_assignment407); 
                    	    PIPE55_tree = (TwigCommonTree)adaptor.create(PIPE55);
                    	    adaptor.addChild(root_0, PIPE55_tree);

                    	    pushFollow(FOLLOW_twig_right_assignment_in_twig_assignment409);
                    	    twig_right_assignment56=twig_right_assignment();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, twig_right_assignment56.getTree());

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

        CommonToken COMMA58=null;
        TwigParser.variable_return variable57 = null;

        TwigParser.variable_return variable59 = null;


        TwigCommonTree COMMA58_tree=null;

        try {
            // TwigParser.g:129:3: ( ( variable ( COMMA variable )* ) )
            // TwigParser.g:129:5: ( variable ( COMMA variable )* )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            // TwigParser.g:129:5: ( variable ( COMMA variable )* )
            // TwigParser.g:129:6: variable ( COMMA variable )*
            {
            pushFollow(FOLLOW_variable_in_twig_left_assignment430);
            variable57=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable57.getTree());
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
            	    COMMA58=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_left_assignment433); 
            	    COMMA58_tree = (TwigCommonTree)adaptor.create(COMMA58);
            	    adaptor.addChild(root_0, COMMA58_tree);

            	    pushFollow(FOLLOW_variable_in_twig_left_assignment435);
            	    variable59=variable();

            	    state._fsp--;

            	    adaptor.addChild(root_0, variable59.getTree());

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

        CommonToken STRING_LITERAL60=null;
        CommonToken COMMA66=null;
        CommonToken STRING_LITERAL67=null;
        TwigParser.variable_return variable61 = null;

        TwigParser.method_chain_return method_chain62 = null;

        TwigParser.array_return array63 = null;

        TwigParser.json_return json64 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument65 = null;

        TwigParser.variable_return variable68 = null;

        TwigParser.method_chain_return method_chain69 = null;

        TwigParser.array_return array70 = null;

        TwigParser.json_return json71 = null;

        TwigParser.twig_tilde_argument_return twig_tilde_argument72 = null;


        TwigCommonTree STRING_LITERAL60_tree=null;
        TwigCommonTree COMMA66_tree=null;
        TwigCommonTree STRING_LITERAL67_tree=null;

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
                    STRING_LITERAL60=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment454); 
                    STRING_LITERAL60_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL60);
                    adaptor.addChild(root_0, STRING_LITERAL60_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:133:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_right_assignment458);
                    variable61=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable61.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:133:34: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_right_assignment462);
                    method_chain62=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain62.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:133:49: array
                    {
                    pushFollow(FOLLOW_array_in_twig_right_assignment466);
                    array63=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array63.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:133:57: json
                    {
                    pushFollow(FOLLOW_json_in_twig_right_assignment470);
                    json64=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json64.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:133:64: twig_tilde_argument
                    {
                    pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment474);
                    twig_tilde_argument65=twig_tilde_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_tilde_argument65.getTree());

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
            	    COMMA66=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_right_assignment478); 
            	    COMMA66_tree = (TwigCommonTree)adaptor.create(COMMA66);
            	    adaptor.addChild(root_0, COMMA66_tree);

            	    // TwigParser.g:133:92: ( STRING_LITERAL | variable | method_chain | array | json | twig_tilde_argument )
            	    int alt21=6;
            	    alt21 = dfa21.predict(input);
            	    switch (alt21) {
            	        case 1 :
            	            // TwigParser.g:133:93: STRING_LITERAL
            	            {
            	            STRING_LITERAL67=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_right_assignment481); 
            	            STRING_LITERAL67_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL67);
            	            adaptor.addChild(root_0, STRING_LITERAL67_tree);


            	            }
            	            break;
            	        case 2 :
            	            // TwigParser.g:133:110: variable
            	            {
            	            pushFollow(FOLLOW_variable_in_twig_right_assignment485);
            	            variable68=variable();

            	            state._fsp--;

            	            adaptor.addChild(root_0, variable68.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // TwigParser.g:133:121: method_chain
            	            {
            	            pushFollow(FOLLOW_method_chain_in_twig_right_assignment489);
            	            method_chain69=method_chain();

            	            state._fsp--;

            	            adaptor.addChild(root_0, method_chain69.getTree());

            	            }
            	            break;
            	        case 4 :
            	            // TwigParser.g:133:136: array
            	            {
            	            pushFollow(FOLLOW_array_in_twig_right_assignment493);
            	            array70=array();

            	            state._fsp--;

            	            adaptor.addChild(root_0, array70.getTree());

            	            }
            	            break;
            	        case 5 :
            	            // TwigParser.g:133:144: json
            	            {
            	            pushFollow(FOLLOW_json_in_twig_right_assignment497);
            	            json71=json();

            	            state._fsp--;

            	            adaptor.addChild(root_0, json71.getTree());

            	            }
            	            break;
            	        case 6 :
            	            // TwigParser.g:133:151: twig_tilde_argument
            	            {
            	            pushFollow(FOLLOW_twig_tilde_argument_in_twig_right_assignment501);
            	            twig_tilde_argument72=twig_tilde_argument();

            	            state._fsp--;

            	            adaptor.addChild(root_0, twig_tilde_argument72.getTree());

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

        CommonToken STRING_LITERAL73=null;
        CommonToken TILDE78=null;
        CommonToken STRING_LITERAL79=null;
        TwigParser.variable_return variable74 = null;

        TwigParser.method_chain_return method_chain75 = null;

        TwigParser.array_return array76 = null;

        TwigParser.json_return json77 = null;

        TwigParser.variable_return variable80 = null;

        TwigParser.method_chain_return method_chain81 = null;

        TwigParser.array_return array82 = null;

        TwigParser.json_return json83 = null;


        TwigCommonTree STRING_LITERAL73_tree=null;
        TwigCommonTree TILDE78_tree=null;
        TwigCommonTree STRING_LITERAL79_tree=null;

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
                    STRING_LITERAL73=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument520); 
                    STRING_LITERAL73_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL73);
                    adaptor.addChild(root_0, STRING_LITERAL73_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:137:23: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument524);
                    variable74=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable74.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:137:34: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_tilde_argument528);
                    method_chain75=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain75.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:137:49: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument532);
                    array76=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array76.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:137:57: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument536);
                    json77=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json77.getTree());

                    }
                    break;

            }

            TILDE78=(CommonToken)match(input,TILDE,FOLLOW_TILDE_in_twig_tilde_argument539); 
            TILDE78_tree = (TwigCommonTree)adaptor.create(TILDE78);
            adaptor.addChild(root_0, TILDE78_tree);

            // TwigParser.g:137:69: ( STRING_LITERAL | variable | method_chain | array | json )
            int alt24=5;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // TwigParser.g:137:70: STRING_LITERAL
                    {
                    STRING_LITERAL79=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_tilde_argument542); 
                    STRING_LITERAL79_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL79);
                    adaptor.addChild(root_0, STRING_LITERAL79_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:137:87: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_tilde_argument546);
                    variable80=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable80.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:137:98: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_tilde_argument550);
                    method_chain81=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain81.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:137:113: array
                    {
                    pushFollow(FOLLOW_array_in_twig_tilde_argument554);
                    array82=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array82.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:137:121: json
                    {
                    pushFollow(FOLLOW_json_in_twig_tilde_argument558);
                    json83=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json83.getTree());

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

        CommonToken FROM84=null;
        CommonToken STRING_LITERAL85=null;
        CommonToken IMPORT86=null;
        CommonToken STRING_LITERAL87=null;
        CommonToken TWIG_AS89=null;
        CommonToken STRING90=null;
        CommonToken COMMA91=null;
        CommonToken STRING92=null;
        TwigParser.variable_return variable88 = null;


        TwigCommonTree FROM84_tree=null;
        TwigCommonTree STRING_LITERAL85_tree=null;
        TwigCommonTree IMPORT86_tree=null;
        TwigCommonTree STRING_LITERAL87_tree=null;
        TwigCommonTree TWIG_AS89_tree=null;
        TwigCommonTree STRING90_tree=null;
        TwigCommonTree COMMA91_tree=null;
        TwigCommonTree STRING92_tree=null;

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
                    FROM84=(CommonToken)match(input,FROM,FOLLOW_FROM_in_twig_import575); 
                    FROM84_tree = (TwigCommonTree)adaptor.create(FROM84);
                    adaptor.addChild(root_0, FROM84_tree);

                    // TwigParser.g:141:11: ( STRING_LITERAL )
                    // TwigParser.g:141:12: STRING_LITERAL
                    {
                    STRING_LITERAL85=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import578); 
                    STRING_LITERAL85_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL85);
                    adaptor.addChild(root_0, STRING_LITERAL85_tree);


                    }


                    }
                    break;

            }

            IMPORT86=(CommonToken)match(input,IMPORT,FOLLOW_IMPORT_in_twig_import583); 
            IMPORT86_tree = (TwigCommonTree)adaptor.create(IMPORT86);
            adaptor.addChild(root_0, IMPORT86_tree);

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
                    STRING_LITERAL87=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_import586); 
                    STRING_LITERAL87_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL87);
                    adaptor.addChild(root_0, STRING_LITERAL87_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:141:55: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_import590);
                    variable88=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable88.getTree());

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
                    TWIG_AS89=(CommonToken)match(input,TWIG_AS,FOLLOW_TWIG_AS_in_twig_import594); 
                    TWIG_AS89_tree = (TwigCommonTree)adaptor.create(TWIG_AS89);
                    adaptor.addChild(root_0, TWIG_AS89_tree);

                    // TwigParser.g:141:74: ( STRING ( COMMA STRING )* )
                    // TwigParser.g:141:75: STRING ( COMMA STRING )*
                    {
                    STRING90=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import597); 
                    STRING90_tree = (TwigCommonTree)adaptor.create(STRING90);
                    adaptor.addChild(root_0, STRING90_tree);

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
                    	    COMMA91=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_import600); 
                    	    COMMA91_tree = (TwigCommonTree)adaptor.create(COMMA91);
                    	    adaptor.addChild(root_0, COMMA91_tree);

                    	    STRING92=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_import602); 
                    	    STRING92_tree = (TwigCommonTree)adaptor.create(STRING92);
                    	    adaptor.addChild(root_0, STRING92_tree);


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

        CommonToken MACRO93=null;
        CommonToken ENDMACRO96=null;
        TwigParser.variable_return variable94 = null;

        TwigParser.method_chain_return method_chain95 = null;


        TwigCommonTree MACRO93_tree=null;
        TwigCommonTree ENDMACRO96_tree=null;

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
                    MACRO93=(CommonToken)match(input,MACRO,FOLLOW_MACRO_in_twig_macro624); 
                    MACRO93_tree = (TwigCommonTree)adaptor.create(MACRO93);
                    adaptor.addChild(root_0, MACRO93_tree);

                    // TwigParser.g:145:12: ( variable | method_chain )
                    int alt29=2;
                    alt29 = dfa29.predict(input);
                    switch (alt29) {
                        case 1 :
                            // TwigParser.g:145:13: variable
                            {
                            pushFollow(FOLLOW_variable_in_twig_macro627);
                            variable94=variable();

                            state._fsp--;

                            adaptor.addChild(root_0, variable94.getTree());

                            }
                            break;
                        case 2 :
                            // TwigParser.g:145:24: method_chain
                            {
                            pushFollow(FOLLOW_method_chain_in_twig_macro631);
                            method_chain95=method_chain();

                            state._fsp--;

                            adaptor.addChild(root_0, method_chain95.getTree());

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

                    ENDMACRO96=(CommonToken)match(input,ENDMACRO,FOLLOW_ENDMACRO_in_twig_macro637); 
                    ENDMACRO96_tree = (TwigCommonTree)adaptor.create(ENDMACRO96);
                    adaptor.addChild(root_0, ENDMACRO96_tree);


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

        CommonToken IF97=null;
        CommonToken PIPE101=null;
        CommonToken IS105=null;
        CommonToken DEFINED106=null;
        TwigParser.variable_return variable98 = null;

        TwigParser.method_chain_return method_chain99 = null;

        TwigParser.eq_check_return eq_check100 = null;

        TwigParser.variable_return variable102 = null;

        TwigParser.method_chain_return method_chain103 = null;

        TwigParser.eq_check_return eq_check104 = null;


        TwigCommonTree IF97_tree=null;
        TwigCommonTree PIPE101_tree=null;
        TwigCommonTree IS105_tree=null;
        TwigCommonTree DEFINED106_tree=null;

        try {
            // TwigParser.g:149:3: ( IF ( ( variable | method_chain | eq_check ) ( PIPE ( variable | method_chain | eq_check ) )* ) ( IS DEFINED )? )
            // TwigParser.g:149:5: IF ( ( variable | method_chain | eq_check ) ( PIPE ( variable | method_chain | eq_check ) )* ) ( IS DEFINED )?
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            IF97=(CommonToken)match(input,IF,FOLLOW_IF_in_twig_if652); 
            IF97_tree = (TwigCommonTree)adaptor.create(IF97);
            adaptor.addChild(root_0, IF97_tree);

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
                    pushFollow(FOLLOW_variable_in_twig_if657);
                    variable98=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable98.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:149:22: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_if661);
                    method_chain99=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain99.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:149:37: eq_check
                    {
                    pushFollow(FOLLOW_eq_check_in_twig_if665);
                    eq_check100=eq_check();

                    state._fsp--;

                    adaptor.addChild(root_0, eq_check100.getTree());

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
            	    PIPE101=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_if669); 
            	    PIPE101_tree = (TwigCommonTree)adaptor.create(PIPE101);
            	    adaptor.addChild(root_0, PIPE101_tree);

            	    // TwigParser.g:149:53: ( variable | method_chain | eq_check )
            	    int alt32=3;
            	    alt32 = dfa32.predict(input);
            	    switch (alt32) {
            	        case 1 :
            	            // TwigParser.g:149:54: variable
            	            {
            	            pushFollow(FOLLOW_variable_in_twig_if672);
            	            variable102=variable();

            	            state._fsp--;

            	            adaptor.addChild(root_0, variable102.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // TwigParser.g:149:65: method_chain
            	            {
            	            pushFollow(FOLLOW_method_chain_in_twig_if676);
            	            method_chain103=method_chain();

            	            state._fsp--;

            	            adaptor.addChild(root_0, method_chain103.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // TwigParser.g:149:80: eq_check
            	            {
            	            pushFollow(FOLLOW_eq_check_in_twig_if680);
            	            eq_check104=eq_check();

            	            state._fsp--;

            	            adaptor.addChild(root_0, eq_check104.getTree());

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
                    IS105=(CommonToken)match(input,IS,FOLLOW_IS_in_twig_if687); 
                    IS105_tree = (TwigCommonTree)adaptor.create(IS105);
                    adaptor.addChild(root_0, IS105_tree);

                    DEFINED106=(CommonToken)match(input,DEFINED,FOLLOW_DEFINED_in_twig_if689); 
                    DEFINED106_tree = (TwigCommonTree)adaptor.create(DEFINED106);
                    adaptor.addChild(root_0, DEFINED106_tree);


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

        CommonToken ELSEIF107=null;
        TwigParser.variable_return variable108 = null;

        TwigParser.method_chain_return method_chain109 = null;


        TwigCommonTree ELSEIF107_tree=null;

        try {
            // TwigParser.g:153:3: ( ELSEIF ( variable | method_chain ) )
            // TwigParser.g:153:5: ELSEIF ( variable | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ELSEIF107=(CommonToken)match(input,ELSEIF,FOLLOW_ELSEIF_in_twig_elseif706); 
            ELSEIF107_tree = (TwigCommonTree)adaptor.create(ELSEIF107);
            adaptor.addChild(root_0, ELSEIF107_tree);

            // TwigParser.g:153:12: ( variable | method_chain )
            int alt35=2;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // TwigParser.g:153:13: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_elseif709);
                    variable108=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable108.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:153:24: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_elseif713);
                    method_chain109=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain109.getTree());

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

        CommonToken FOR110=null;
        CommonToken STRING111=null;
        CommonToken COMMA112=null;
        CommonToken STRING113=null;
        CommonToken IN114=null;
        TwigParser.for_arguments_return for_arguments115 = null;


        TwigCommonTree FOR110_tree=null;
        TwigCommonTree STRING111_tree=null;
        TwigCommonTree COMMA112_tree=null;
        TwigCommonTree STRING113_tree=null;
        TwigCommonTree IN114_tree=null;

        try {
            // TwigParser.g:157:3: ( FOR ( STRING ( COMMA STRING )* ) IN for_arguments )
            // TwigParser.g:157:5: FOR ( STRING ( COMMA STRING )* ) IN for_arguments
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            FOR110=(CommonToken)match(input,FOR,FOLLOW_FOR_in_twig_for729); 
            FOR110_tree = (TwigCommonTree)adaptor.create(FOR110);
            adaptor.addChild(root_0, FOR110_tree);

            // TwigParser.g:157:9: ( STRING ( COMMA STRING )* )
            // TwigParser.g:157:10: STRING ( COMMA STRING )*
            {
            STRING111=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_for732); 
            STRING111_tree = (TwigCommonTree)adaptor.create(STRING111);
            adaptor.addChild(root_0, STRING111_tree);

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
            	    COMMA112=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_twig_for735); 
            	    COMMA112_tree = (TwigCommonTree)adaptor.create(COMMA112);
            	    adaptor.addChild(root_0, COMMA112_tree);

            	    STRING113=(CommonToken)match(input,STRING,FOLLOW_STRING_in_twig_for737); 
            	    STRING113_tree = (TwigCommonTree)adaptor.create(STRING113);
            	    adaptor.addChild(root_0, STRING113_tree);


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            IN114=(CommonToken)match(input,IN,FOLLOW_IN_in_twig_for742); 
            IN114_tree = (TwigCommonTree)adaptor.create(IN114);
            adaptor.addChild(root_0, IN114_tree);

            pushFollow(FOLLOW_for_arguments_in_twig_for744);
            for_arguments115=for_arguments();

            state._fsp--;

            adaptor.addChild(root_0, for_arguments115.getTree());

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

        CommonToken PIPE117=null;
        TwigParser.for_value_return for_value116 = null;

        TwigParser.for_value_return for_value118 = null;


        TwigCommonTree PIPE117_tree=null;

        try {
            // TwigParser.g:161:3: ( for_value ( PIPE for_value )* )
            // TwigParser.g:161:5: for_value ( PIPE for_value )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_for_value_in_for_arguments759);
            for_value116=for_value();

            state._fsp--;

            adaptor.addChild(root_0, for_value116.getTree());
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
            	    PIPE117=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_for_arguments762); 
            	    PIPE117_tree = (TwigCommonTree)adaptor.create(PIPE117);
            	    adaptor.addChild(root_0, PIPE117_tree);

            	    pushFollow(FOLLOW_for_value_in_for_arguments764);
            	    for_value118=for_value();

            	    state._fsp--;

            	    adaptor.addChild(root_0, for_value118.getTree());

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

        CommonToken STRING_LITERAL119=null;
        TwigParser.method_chain_return method_chain120 = null;

        TwigParser.range_return range121 = null;

        TwigParser.variable_return variable122 = null;


        TwigCommonTree STRING_LITERAL119_tree=null;

        try {
            // TwigParser.g:165:3: ( STRING_LITERAL | method_chain | range | variable )
            int alt38=4;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // TwigParser.g:165:6: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL119=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_for_value782); 
                    STRING_LITERAL119_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL119);
                    adaptor.addChild(root_0, STRING_LITERAL119_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:165:23: method_chain
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_chain_in_for_value786);
                    method_chain120=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain120.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:165:38: range
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_range_in_for_value790);
                    range121=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range121.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:165:46: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_for_value794);
                    variable122=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable122.getTree());

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

        CommonToken set123=null;
        CommonToken DDOT124=null;
        CommonToken set125=null;

        TwigCommonTree set123_tree=null;
        TwigCommonTree DDOT124_tree=null;
        TwigCommonTree set125_tree=null;

        try {
            // TwigParser.g:169:3: ( ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING ) )
            // TwigParser.g:169:5: ( NUMBER | STRING_LITERAL | STRING ) DDOT ( NUMBER | STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set123=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set123));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            DDOT124=(CommonToken)match(input,DDOT,FOLLOW_DDOT_in_range821); 
            DDOT124_tree = (TwigCommonTree)adaptor.create(DDOT124);
            adaptor.addChild(root_0, DDOT124_tree);

            set125=(CommonToken)input.LT(1);
            if ( input.LA(1)==NUMBER||input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set125));
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

        CommonToken STRING_LITERAL126=null;
        CommonToken NUMBER127=null;
        CommonToken QM131=null;
        CommonToken STRING_LITERAL132=null;
        CommonToken NUMBER133=null;
        CommonToken COLON136=null;
        CommonToken STRING_LITERAL137=null;
        CommonToken NUMBER138=null;
        TwigParser.variable_return variable128 = null;

        TwigParser.method_chain_return method_chain129 = null;

        TwigParser.eq_check_return eq_check130 = null;

        TwigParser.variable_return variable134 = null;

        TwigParser.method_chain_return method_chain135 = null;

        TwigParser.variable_return variable139 = null;

        TwigParser.method_chain_return method_chain140 = null;


        TwigCommonTree STRING_LITERAL126_tree=null;
        TwigCommonTree NUMBER127_tree=null;
        TwigCommonTree QM131_tree=null;
        TwigCommonTree STRING_LITERAL132_tree=null;
        TwigCommonTree NUMBER133_tree=null;
        TwigCommonTree COLON136_tree=null;
        TwigCommonTree STRING_LITERAL137_tree=null;
        TwigCommonTree NUMBER138_tree=null;

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
                    STRING_LITERAL126=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary850); 
                    STRING_LITERAL126_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL126);
                    adaptor.addChild(root_0, STRING_LITERAL126_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:173:23: NUMBER
                    {
                    NUMBER127=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary854); 
                    NUMBER127_tree = (TwigCommonTree)adaptor.create(NUMBER127);
                    adaptor.addChild(root_0, NUMBER127_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:173:32: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary858);
                    variable128=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable128.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:173:43: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary862);
                    method_chain129=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain129.getTree());

                    }
                    break;
                case 5 :
                    // TwigParser.g:173:58: eq_check
                    {
                    pushFollow(FOLLOW_eq_check_in_twig_ternary866);
                    eq_check130=eq_check();

                    state._fsp--;

                    adaptor.addChild(root_0, eq_check130.getTree());

                    }
                    break;

            }

            QM131=(CommonToken)match(input,QM,FOLLOW_QM_in_twig_ternary869); 
            QM131_tree = (TwigCommonTree)adaptor.create(QM131);
            adaptor.addChild(root_0, QM131_tree);

            // TwigParser.g:173:71: ( STRING_LITERAL | NUMBER | variable | method_chain )
            int alt40=4;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // TwigParser.g:173:72: STRING_LITERAL
                    {
                    STRING_LITERAL132=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary872); 
                    STRING_LITERAL132_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL132);
                    adaptor.addChild(root_0, STRING_LITERAL132_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:173:89: NUMBER
                    {
                    NUMBER133=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary876); 
                    NUMBER133_tree = (TwigCommonTree)adaptor.create(NUMBER133);
                    adaptor.addChild(root_0, NUMBER133_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:173:98: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary880);
                    variable134=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable134.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:173:109: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary884);
                    method_chain135=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain135.getTree());

                    }
                    break;

            }

            COLON136=(CommonToken)match(input,COLON,FOLLOW_COLON_in_twig_ternary887); 
            COLON136_tree = (TwigCommonTree)adaptor.create(COLON136);
            adaptor.addChild(root_0, COLON136_tree);

            // TwigParser.g:173:129: ( STRING_LITERAL | NUMBER | variable | method_chain )
            int alt41=4;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // TwigParser.g:173:130: STRING_LITERAL
                    {
                    STRING_LITERAL137=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_twig_ternary890); 
                    STRING_LITERAL137_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL137);
                    adaptor.addChild(root_0, STRING_LITERAL137_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:173:147: NUMBER
                    {
                    NUMBER138=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_twig_ternary894); 
                    NUMBER138_tree = (TwigCommonTree)adaptor.create(NUMBER138);
                    adaptor.addChild(root_0, NUMBER138_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:173:156: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_ternary898);
                    variable139=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable139.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:173:167: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_ternary902);
                    method_chain140=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain140.getTree());

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

        CommonToken NUMBER143=null;
        CommonToken STRING_LITERAL144=null;
        CommonToken set145=null;
        CommonToken NUMBER148=null;
        CommonToken STRING_LITERAL149=null;
        TwigParser.variable_return variable141 = null;

        TwigParser.method_chain_return method_chain142 = null;

        TwigParser.variable_return variable146 = null;

        TwigParser.method_chain_return method_chain147 = null;


        TwigCommonTree NUMBER143_tree=null;
        TwigCommonTree STRING_LITERAL144_tree=null;
        TwigCommonTree set145_tree=null;
        TwigCommonTree NUMBER148_tree=null;
        TwigCommonTree STRING_LITERAL149_tree=null;

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
                    pushFollow(FOLLOW_variable_in_eq_check919);
                    variable141=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable141.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:178:17: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_eq_check923);
                    method_chain142=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain142.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:178:32: NUMBER
                    {
                    NUMBER143=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_eq_check927); 
                    NUMBER143_tree = (TwigCommonTree)adaptor.create(NUMBER143);
                    adaptor.addChild(root_0, NUMBER143_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:178:41: STRING_LITERAL
                    {
                    STRING_LITERAL144=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_eq_check931); 
                    STRING_LITERAL144_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL144);
                    adaptor.addChild(root_0, STRING_LITERAL144_tree);


                    }
                    break;

            }

            set145=(CommonToken)input.LT(1);
            if ( (input.LA(1)>=LARGER && input.LA(1)<=NOTEQUAL) ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set145));
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
                    pushFollow(FOLLOW_variable_in_eq_check951);
                    variable146=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable146.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:178:107: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_eq_check955);
                    method_chain147=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain147.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:178:122: NUMBER
                    {
                    NUMBER148=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_eq_check959); 
                    NUMBER148_tree = (TwigCommonTree)adaptor.create(NUMBER148);
                    adaptor.addChild(root_0, NUMBER148_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:178:131: STRING_LITERAL
                    {
                    STRING_LITERAL149=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_eq_check963); 
                    STRING_LITERAL149_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL149);
                    adaptor.addChild(root_0, STRING_LITERAL149_tree);


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

        CommonToken PRINT_OPEN150=null;
        CommonToken PRINT_CLOSE152=null;
        TwigParser.twig_print_return twig_print151 = null;


        TwigCommonTree PRINT_OPEN150_tree=null;
        TwigCommonTree PRINT_CLOSE152_tree=null;
        RewriteRuleTokenStream stream_PRINT_OPEN=new RewriteRuleTokenStream(adaptor,"token PRINT_OPEN");
        RewriteRuleTokenStream stream_PRINT_CLOSE=new RewriteRuleTokenStream(adaptor,"token PRINT_CLOSE");
        RewriteRuleSubtreeStream stream_twig_print=new RewriteRuleSubtreeStream(adaptor,"rule twig_print");
        try {
            // TwigParser.g:184:3: ( PRINT_OPEN ( twig_print )? PRINT_CLOSE -> ^( TWIG_PR_STMT ( twig_print )? ) )
            // TwigParser.g:184:6: PRINT_OPEN ( twig_print )? PRINT_CLOSE
            {
            PRINT_OPEN150=(CommonToken)match(input,PRINT_OPEN,FOLLOW_PRINT_OPEN_in_twig_print_statement984);  
            stream_PRINT_OPEN.add(PRINT_OPEN150);

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
                    pushFollow(FOLLOW_twig_print_in_twig_print_statement986);
                    twig_print151=twig_print();

                    state._fsp--;

                    stream_twig_print.add(twig_print151.getTree());

                    }
                    break;

            }

            PRINT_CLOSE152=(CommonToken)match(input,PRINT_CLOSE,FOLLOW_PRINT_CLOSE_in_twig_print_statement989);  
            stream_PRINT_CLOSE.add(PRINT_CLOSE152);



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

        CommonToken PIPE154=null;
        TwigParser.p_input_return p_input153 = null;

        TwigParser.p_input_return p_input155 = null;


        TwigCommonTree PIPE154_tree=null;

        try {
            // TwigParser.g:189:3: ( p_input ( PIPE p_input )* )
            // TwigParser.g:189:5: p_input ( PIPE p_input )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_p_input_in_twig_print1016);
            p_input153=p_input();

            state._fsp--;

            adaptor.addChild(root_0, p_input153.getTree());
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
            	    PIPE154=(CommonToken)match(input,PIPE,FOLLOW_PIPE_in_twig_print1019); 
            	    PIPE154_tree = (TwigCommonTree)adaptor.create(PIPE154);
            	    adaptor.addChild(root_0, PIPE154_tree);

            	    pushFollow(FOLLOW_p_input_in_twig_print1021);
            	    p_input155=p_input();

            	    state._fsp--;

            	    adaptor.addChild(root_0, p_input155.getTree());

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
    // TwigParser.g:192:1: p_input : ( variable | method_chain | array | STRING_LITERAL | twig_ternary | twig_not );
    public final TwigParser.p_input_return p_input() throws RecognitionException {
        TwigParser.p_input_return retval = new TwigParser.p_input_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING_LITERAL159=null;
        TwigParser.variable_return variable156 = null;

        TwigParser.method_chain_return method_chain157 = null;

        TwigParser.array_return array158 = null;

        TwigParser.twig_ternary_return twig_ternary160 = null;

        TwigParser.twig_not_return twig_not161 = null;


        TwigCommonTree STRING_LITERAL159_tree=null;

        try {
            // TwigParser.g:193:3: ( variable | method_chain | array | STRING_LITERAL | twig_ternary | twig_not )
            int alt46=6;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // TwigParser.g:193:5: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_p_input1038);
                    variable156=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable156.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:193:16: method_chain
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_method_chain_in_p_input1042);
                    method_chain157=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain157.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:193:31: array
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_array_in_p_input1046);
                    array158=array();

                    state._fsp--;

                    adaptor.addChild(root_0, array158.getTree());

                    }
                    break;
                case 4 :
                    // TwigParser.g:193:39: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL159=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_p_input1050); 
                    STRING_LITERAL159_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL159);
                    adaptor.addChild(root_0, STRING_LITERAL159_tree);


                    }
                    break;
                case 5 :
                    // TwigParser.g:193:56: twig_ternary
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_ternary_in_p_input1054);
                    twig_ternary160=twig_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_ternary160.getTree());

                    }
                    break;
                case 6 :
                    // TwigParser.g:193:71: twig_not
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_twig_not_in_p_input1058);
                    twig_not161=twig_not();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_not161.getTree());

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

    public static class twig_not_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "twig_not"
    // TwigParser.g:197:1: twig_not : NOT ( twig_ternary | variable | method_chain ) ;
    public final TwigParser.twig_not_return twig_not() throws RecognitionException {
        TwigParser.twig_not_return retval = new TwigParser.twig_not_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken NOT162=null;
        TwigParser.twig_ternary_return twig_ternary163 = null;

        TwigParser.variable_return variable164 = null;

        TwigParser.method_chain_return method_chain165 = null;


        TwigCommonTree NOT162_tree=null;

        try {
            // TwigParser.g:198:3: ( NOT ( twig_ternary | variable | method_chain ) )
            // TwigParser.g:198:5: NOT ( twig_ternary | variable | method_chain )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            NOT162=(CommonToken)match(input,NOT,FOLLOW_NOT_in_twig_not1076); 
            NOT162_tree = (TwigCommonTree)adaptor.create(NOT162);
            adaptor.addChild(root_0, NOT162_tree);

            // TwigParser.g:198:9: ( twig_ternary | variable | method_chain )
            int alt47=3;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // TwigParser.g:198:10: twig_ternary
                    {
                    pushFollow(FOLLOW_twig_ternary_in_twig_not1079);
                    twig_ternary163=twig_ternary();

                    state._fsp--;

                    adaptor.addChild(root_0, twig_ternary163.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:198:25: variable
                    {
                    pushFollow(FOLLOW_variable_in_twig_not1083);
                    variable164=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable164.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:198:36: method_chain
                    {
                    pushFollow(FOLLOW_method_chain_in_twig_not1087);
                    method_chain165=method_chain();

                    state._fsp--;

                    adaptor.addChild(root_0, method_chain165.getTree());

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
    // TwigParser.g:201:1: array : ARRAY_START array_elements ARRAY_END ;
    public final TwigParser.array_return array() throws RecognitionException {
        TwigParser.array_return retval = new TwigParser.array_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken ARRAY_START166=null;
        CommonToken ARRAY_END168=null;
        TwigParser.array_elements_return array_elements167 = null;


        TwigCommonTree ARRAY_START166_tree=null;
        TwigCommonTree ARRAY_END168_tree=null;

        try {
            // TwigParser.g:202:3: ( ARRAY_START array_elements ARRAY_END )
            // TwigParser.g:202:5: ARRAY_START array_elements ARRAY_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            ARRAY_START166=(CommonToken)match(input,ARRAY_START,FOLLOW_ARRAY_START_in_array1103); 
            ARRAY_START166_tree = (TwigCommonTree)adaptor.create(ARRAY_START166);
            adaptor.addChild(root_0, ARRAY_START166_tree);

            pushFollow(FOLLOW_array_elements_in_array1105);
            array_elements167=array_elements();

            state._fsp--;

            adaptor.addChild(root_0, array_elements167.getTree());
            ARRAY_END168=(CommonToken)match(input,ARRAY_END,FOLLOW_ARRAY_END_in_array1107); 
            ARRAY_END168_tree = (TwigCommonTree)adaptor.create(ARRAY_END168);
            adaptor.addChild(root_0, ARRAY_END168_tree);


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
    // TwigParser.g:205:1: array_elements : array_element ( COMMA array_element )* ;
    public final TwigParser.array_elements_return array_elements() throws RecognitionException {
        TwigParser.array_elements_return retval = new TwigParser.array_elements_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA170=null;
        TwigParser.array_element_return array_element169 = null;

        TwigParser.array_element_return array_element171 = null;


        TwigCommonTree COMMA170_tree=null;

        try {
            // TwigParser.g:206:3: ( array_element ( COMMA array_element )* )
            // TwigParser.g:206:5: array_element ( COMMA array_element )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_array_element_in_array_elements1122);
            array_element169=array_element();

            state._fsp--;

            adaptor.addChild(root_0, array_element169.getTree());
            // TwigParser.g:206:19: ( COMMA array_element )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==COMMA) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // TwigParser.g:206:20: COMMA array_element
            	    {
            	    COMMA170=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_array_elements1125); 
            	    COMMA170_tree = (TwigCommonTree)adaptor.create(COMMA170);
            	    adaptor.addChild(root_0, COMMA170_tree);

            	    pushFollow(FOLLOW_array_element_in_array_elements1127);
            	    array_element171=array_element();

            	    state._fsp--;

            	    adaptor.addChild(root_0, array_element171.getTree());

            	    }
            	    break;

            	default :
            	    break loop48;
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
    // TwigParser.g:209:1: array_element : ( STRING | STRING_LITERAL | NUMBER | json );
    public final TwigParser.array_element_return array_element() throws RecognitionException {
        TwigParser.array_element_return retval = new TwigParser.array_element_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken STRING172=null;
        CommonToken STRING_LITERAL173=null;
        CommonToken NUMBER174=null;
        TwigParser.json_return json175 = null;


        TwigCommonTree STRING172_tree=null;
        TwigCommonTree STRING_LITERAL173_tree=null;
        TwigCommonTree NUMBER174_tree=null;

        try {
            // TwigParser.g:210:3: ( STRING | STRING_LITERAL | NUMBER | json )
            int alt49=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt49=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt49=2;
                }
                break;
            case NUMBER:
                {
                alt49=3;
                }
                break;
            case JSON_START:
                {
                alt49=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // TwigParser.g:210:5: STRING
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING172=(CommonToken)match(input,STRING,FOLLOW_STRING_in_array_element1144); 
                    STRING172_tree = (TwigCommonTree)adaptor.create(STRING172);
                    adaptor.addChild(root_0, STRING172_tree);


                    }
                    break;
                case 2 :
                    // TwigParser.g:210:14: STRING_LITERAL
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    STRING_LITERAL173=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_array_element1148); 
                    STRING_LITERAL173_tree = (TwigCommonTree)adaptor.create(STRING_LITERAL173);
                    adaptor.addChild(root_0, STRING_LITERAL173_tree);


                    }
                    break;
                case 3 :
                    // TwigParser.g:210:31: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER174=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_array_element1152); 
                    NUMBER174_tree = (TwigCommonTree)adaptor.create(NUMBER174);
                    adaptor.addChild(root_0, NUMBER174_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:210:40: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_array_element1156);
                    json175=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json175.getTree());

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
    // TwigParser.g:213:1: variable : param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) ;
    public final TwigParser.variable_return variable() throws RecognitionException {
        TwigParser.variable_return retval = new TwigParser.variable_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;
        CommonToken DOT176=null;
        CommonToken STRING177=null;

        TwigCommonTree param_tree=null;
        TwigCommonTree DOT176_tree=null;
        TwigCommonTree STRING177_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");

        try {
            // TwigParser.g:214:3: (param= STRING ( DOT ( STRING ) )* -> ^( TWIG_VAR $param) )
            // TwigParser.g:214:5: param= STRING ( DOT ( STRING ) )*
            {
            param=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable1173);  
            stream_STRING.add(param);

            // TwigParser.g:214:18: ( DOT ( STRING ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==DOT) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // TwigParser.g:214:19: DOT ( STRING )
            	    {
            	    DOT176=(CommonToken)match(input,DOT,FOLLOW_DOT_in_variable1176);  
            	    stream_DOT.add(DOT176);

            	    // TwigParser.g:214:23: ( STRING )
            	    // TwigParser.g:214:24: STRING
            	    {
            	    STRING177=(CommonToken)match(input,STRING,FOLLOW_STRING_in_variable1179);  
            	    stream_STRING.add(STRING177);


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
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
            // 215:5: -> ^( TWIG_VAR $param)
            {
                // TwigParser.g:215:7: ^( TWIG_VAR $param)
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
    // TwigParser.g:219:1: method_chain : method ( DOT method )* ;
    public final TwigParser.method_chain_return method_chain() throws RecognitionException {
        TwigParser.method_chain_return retval = new TwigParser.method_chain_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken DOT179=null;
        TwigParser.method_return method178 = null;

        TwigParser.method_return method180 = null;


        TwigCommonTree DOT179_tree=null;

        try {
            // TwigParser.g:220:3: ( method ( DOT method )* )
            // TwigParser.g:220:5: method ( DOT method )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_method_in_method_chain1211);
            method178=method();

            state._fsp--;

            adaptor.addChild(root_0, method178.getTree());
            // TwigParser.g:220:12: ( DOT method )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==DOT) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // TwigParser.g:220:13: DOT method
            	    {
            	    DOT179=(CommonToken)match(input,DOT,FOLLOW_DOT_in_method_chain1214); 
            	    DOT179_tree = (TwigCommonTree)adaptor.create(DOT179);
            	    adaptor.addChild(root_0, DOT179_tree);

            	    pushFollow(FOLLOW_method_in_method_chain1216);
            	    method180=method();

            	    state._fsp--;

            	    adaptor.addChild(root_0, method180.getTree());

            	    }
            	    break;

            	default :
            	    break loop51;
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
    // TwigParser.g:223:1: method : variable METHOD_START ( arguments )? METHOD_END ;
    public final TwigParser.method_return method() throws RecognitionException {
        TwigParser.method_return retval = new TwigParser.method_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken METHOD_START182=null;
        CommonToken METHOD_END184=null;
        TwigParser.variable_return variable181 = null;

        TwigParser.arguments_return arguments183 = null;


        TwigCommonTree METHOD_START182_tree=null;
        TwigCommonTree METHOD_END184_tree=null;

        try {
            // TwigParser.g:224:3: ( variable METHOD_START ( arguments )? METHOD_END )
            // TwigParser.g:224:5: variable METHOD_START ( arguments )? METHOD_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_variable_in_method1233);
            variable181=variable();

            state._fsp--;

            adaptor.addChild(root_0, variable181.getTree());
            METHOD_START182=(CommonToken)match(input,METHOD_START,FOLLOW_METHOD_START_in_method1235); 
            METHOD_START182_tree = (TwigCommonTree)adaptor.create(METHOD_START182);
            adaptor.addChild(root_0, METHOD_START182_tree);

            // TwigParser.g:224:27: ( arguments )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==JSON_START||LA52_0==NUMBER||LA52_0==STRING||LA52_0==STRING_LITERAL) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // TwigParser.g:224:27: arguments
                    {
                    pushFollow(FOLLOW_arguments_in_method1237);
                    arguments183=arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, arguments183.getTree());

                    }
                    break;

            }

            METHOD_END184=(CommonToken)match(input,METHOD_END,FOLLOW_METHOD_END_in_method1240); 
            METHOD_END184_tree = (TwigCommonTree)adaptor.create(METHOD_END184);
            adaptor.addChild(root_0, METHOD_END184_tree);


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
    // TwigParser.g:227:1: arguments : argument ( COMMA ( argument ) )* ;
    public final TwigParser.arguments_return arguments() throws RecognitionException {
        TwigParser.arguments_return retval = new TwigParser.arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA186=null;
        TwigParser.argument_return argument185 = null;

        TwigParser.argument_return argument187 = null;


        TwigCommonTree COMMA186_tree=null;

        try {
            // TwigParser.g:228:3: ( argument ( COMMA ( argument ) )* )
            // TwigParser.g:228:5: argument ( COMMA ( argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_argument_in_arguments1256);
            argument185=argument();

            state._fsp--;

            adaptor.addChild(root_0, argument185.getTree());
            // TwigParser.g:228:15: ( COMMA ( argument ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==COMMA) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // TwigParser.g:228:16: COMMA ( argument )
            	    {
            	    COMMA186=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_arguments1260); 
            	    COMMA186_tree = (TwigCommonTree)adaptor.create(COMMA186);
            	    adaptor.addChild(root_0, COMMA186_tree);

            	    // TwigParser.g:228:22: ( argument )
            	    // TwigParser.g:228:23: argument
            	    {
            	    pushFollow(FOLLOW_argument_in_arguments1263);
            	    argument187=argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, argument187.getTree());

            	    }


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
    // $ANTLR end "arguments"

    public static class argument_return extends ParserRuleReturnScope {
        TwigCommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argument"
    // TwigParser.g:231:1: argument : ( literal_argument | json | NUMBER | variable );
    public final TwigParser.argument_return argument() throws RecognitionException {
        TwigParser.argument_return retval = new TwigParser.argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken NUMBER190=null;
        TwigParser.literal_argument_return literal_argument188 = null;

        TwigParser.json_return json189 = null;

        TwigParser.variable_return variable191 = null;


        TwigCommonTree NUMBER190_tree=null;

        try {
            // TwigParser.g:232:1: ( literal_argument | json | NUMBER | variable )
            int alt54=4;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt54=1;
                }
                break;
            case JSON_START:
                {
                alt54=2;
                }
                break;
            case NUMBER:
                {
                alt54=3;
                }
                break;
            case STRING:
                {
                alt54=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // TwigParser.g:232:3: literal_argument
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_literal_argument_in_argument1277);
                    literal_argument188=literal_argument();

                    state._fsp--;

                    adaptor.addChild(root_0, literal_argument188.getTree());

                    }
                    break;
                case 2 :
                    // TwigParser.g:232:22: json
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_json_in_argument1281);
                    json189=json();

                    state._fsp--;

                    adaptor.addChild(root_0, json189.getTree());

                    }
                    break;
                case 3 :
                    // TwigParser.g:232:29: NUMBER
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    NUMBER190=(CommonToken)match(input,NUMBER,FOLLOW_NUMBER_in_argument1285); 
                    NUMBER190_tree = (TwigCommonTree)adaptor.create(NUMBER190);
                    adaptor.addChild(root_0, NUMBER190_tree);


                    }
                    break;
                case 4 :
                    // TwigParser.g:232:38: variable
                    {
                    root_0 = (TwigCommonTree)adaptor.nil();

                    pushFollow(FOLLOW_variable_in_argument1289);
                    variable191=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable191.getTree());

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
    // TwigParser.g:235:1: literal_argument : param= STRING_LITERAL -> ^( LITERAL_ARG $param) ;
    public final TwigParser.literal_argument_return literal_argument() throws RecognitionException {
        TwigParser.literal_argument_return retval = new TwigParser.literal_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken param=null;

        TwigCommonTree param_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");

        try {
            // TwigParser.g:236:3: (param= STRING_LITERAL -> ^( LITERAL_ARG $param) )
            // TwigParser.g:236:5: param= STRING_LITERAL
            {
            param=(CommonToken)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal_argument1302);  
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
            // 237:5: -> ^( LITERAL_ARG $param)
            {
                // TwigParser.g:237:8: ^( LITERAL_ARG $param)
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
    // TwigParser.g:240:1: json : JSON_START ( json_arguments )? JSON_END ;
    public final TwigParser.json_return json() throws RecognitionException {
        TwigParser.json_return retval = new TwigParser.json_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken JSON_START192=null;
        CommonToken JSON_END194=null;
        TwigParser.json_arguments_return json_arguments193 = null;


        TwigCommonTree JSON_START192_tree=null;
        TwigCommonTree JSON_END194_tree=null;

        try {
            // TwigParser.g:241:3: ( JSON_START ( json_arguments )? JSON_END )
            // TwigParser.g:241:5: JSON_START ( json_arguments )? JSON_END
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            JSON_START192=(CommonToken)match(input,JSON_START,FOLLOW_JSON_START_in_json1328); 
            JSON_START192_tree = (TwigCommonTree)adaptor.create(JSON_START192);
            adaptor.addChild(root_0, JSON_START192_tree);

            // TwigParser.g:241:16: ( json_arguments )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==STRING||LA55_0==STRING_LITERAL) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // TwigParser.g:241:16: json_arguments
                    {
                    pushFollow(FOLLOW_json_arguments_in_json1330);
                    json_arguments193=json_arguments();

                    state._fsp--;

                    adaptor.addChild(root_0, json_arguments193.getTree());

                    }
                    break;

            }

            JSON_END194=(CommonToken)match(input,JSON_END,FOLLOW_JSON_END_in_json1333); 
            JSON_END194_tree = (TwigCommonTree)adaptor.create(JSON_END194);
            adaptor.addChild(root_0, JSON_END194_tree);


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
    // TwigParser.g:244:1: json_arguments : json_argument ( COMMA ( json_argument ) )* ;
    public final TwigParser.json_arguments_return json_arguments() throws RecognitionException {
        TwigParser.json_arguments_return retval = new TwigParser.json_arguments_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken COMMA196=null;
        TwigParser.json_argument_return json_argument195 = null;

        TwigParser.json_argument_return json_argument197 = null;


        TwigCommonTree COMMA196_tree=null;

        try {
            // TwigParser.g:245:3: ( json_argument ( COMMA ( json_argument ) )* )
            // TwigParser.g:245:5: json_argument ( COMMA ( json_argument ) )*
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            pushFollow(FOLLOW_json_argument_in_json_arguments1348);
            json_argument195=json_argument();

            state._fsp--;

            adaptor.addChild(root_0, json_argument195.getTree());
            // TwigParser.g:245:19: ( COMMA ( json_argument ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==COMMA) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // TwigParser.g:245:20: COMMA ( json_argument )
            	    {
            	    COMMA196=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_json_arguments1351); 
            	    COMMA196_tree = (TwigCommonTree)adaptor.create(COMMA196);
            	    adaptor.addChild(root_0, COMMA196_tree);

            	    // TwigParser.g:245:26: ( json_argument )
            	    // TwigParser.g:245:27: json_argument
            	    {
            	    pushFollow(FOLLOW_json_argument_in_json_arguments1354);
            	    json_argument197=json_argument();

            	    state._fsp--;

            	    adaptor.addChild(root_0, json_argument197.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
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
    // TwigParser.g:248:1: json_argument : ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) ;
    public final TwigParser.json_argument_return json_argument() throws RecognitionException {
        TwigParser.json_argument_return retval = new TwigParser.json_argument_return();
        retval.start = input.LT(1);

        TwigCommonTree root_0 = null;

        CommonToken set198=null;
        CommonToken COLON199=null;
        CommonToken set200=null;

        TwigCommonTree set198_tree=null;
        TwigCommonTree COLON199_tree=null;
        TwigCommonTree set200_tree=null;

        try {
            // TwigParser.g:249:3: ( ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING ) )
            // TwigParser.g:249:5: ( STRING_LITERAL | STRING ) ( COLON ) ( STRING_LITERAL | STRING )
            {
            root_0 = (TwigCommonTree)adaptor.nil();

            set198=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set198));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // TwigParser.g:249:31: ( COLON )
            // TwigParser.g:249:32: COLON
            {
            COLON199=(CommonToken)match(input,COLON,FOLLOW_COLON_in_json_argument1381); 
            COLON199_tree = (TwigCommonTree)adaptor.create(COLON199);
            adaptor.addChild(root_0, COLON199_tree);


            }

            set200=(CommonToken)input.LT(1);
            if ( input.LA(1)==STRING||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                adaptor.addChild(root_0, (TwigCommonTree)adaptor.create(set200));
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
    protected DFA47 dfa47 = new DFA47(this);
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
        "\6\uffff";
    static final String DFA7_eofS =
        "\6\uffff";
    static final String DFA7_minS =
        "\1\66\1\7\1\66\2\uffff\1\7";
    static final String DFA7_maxS =
        "\1\66\1\70\1\66\2\uffff\1\70";
    static final String DFA7_acceptS =
        "\3\uffff\1\1\1\2\1\uffff";
    static final String DFA7_specialS =
        "\6\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1",
            "\1\3\1\4\1\uffff\1\3\11\uffff\1\2\27\uffff\1\3\7\uffff\1\3"+
            "\1\uffff\1\3\1\uffff\1\3",
            "\1\5",
            "",
            "",
            "\1\3\1\4\1\uffff\1\3\11\uffff\1\2\27\uffff\1\3\7\uffff\1\3"+
            "\1\uffff\1\3\1\uffff\1\3"
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
            return "105:5: ( variable | method_chain )";
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
        "\115\uffff";
    static final String DFA46_eofS =
        "\115\uffff";
    static final String DFA46_minS =
        "\1\12\1\5\1\uffff\1\5\2\uffff\1\66\1\uffff\1\11\1\uffff\1\5\1\11"+
        "\1\31\2\11\1\5\1\30\1\25\1\11\2\66\1\uffff\1\11\1\31\2\11\1\66\1"+
        "\11\1\10\1\25\1\11\1\66\1\26\1\66\1\11\1\66\1\11\1\66\1\10\1\11"+
        "\1\31\2\11\1\5\1\26\1\25\1\30\1\25\1\11\3\66\1\11\1\31\2\11\1\66"+
        "\1\11\1\25\1\26\1\25\1\11\1\66\1\26\2\66\1\11\1\66\2\26\1\25\2\66"+
        "\1\25\1\26\1\66\1\26";
    static final String DFA46_maxS =
        "\1\70\1\32\1\uffff\1\32\2\uffff\1\66\1\uffff\1\70\1\uffff\1\32\1"+
        "\26\1\70\2\26\1\32\1\70\1\25\1\26\2\66\1\uffff\1\26\1\70\2\26\1"+
        "\70\1\26\1\24\1\25\1\26\1\66\1\31\1\66\2\70\1\26\1\70\1\24\1\26"+
        "\1\70\2\26\1\32\1\31\1\25\1\70\1\25\1\26\1\66\2\70\1\26\1\70\2\26"+
        "\1\70\1\26\1\25\1\31\1\25\1\26\1\66\1\31\2\70\1\26\1\70\2\31\1\25"+
        "\2\70\1\25\1\31\1\70\1\31";
    static final String DFA46_acceptS =
        "\2\uffff\1\3\1\uffff\1\5\1\6\1\uffff\1\1\1\uffff\1\4\13\uffff\1"+
        "\2\67\uffff";
    static final String DFA46_specialS =
        "\115\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\2\41\uffff\1\5\7\uffff\1\4\1\uffff\1\1\1\uffff\1\3",
            "\1\7\1\uffff\1\7\1\10\4\uffff\4\4\1\uffff\1\7\1\uffff\1\6\5"+
            "\uffff\1\4",
            "",
            "\1\11\1\uffff\1\11\5\uffff\4\4\1\uffff\1\11\7\uffff\1\4",
            "",
            "",
            "\1\12",
            "",
            "\1\17\16\uffff\1\14\33\uffff\1\15\1\uffff\1\16\1\uffff\1\13",
            "",
            "\1\7\1\uffff\1\7\1\10\4\uffff\4\4\1\uffff\1\7\1\uffff\1\6\5"+
            "\uffff\1\4",
            "\1\17\14\uffff\1\20",
            "\1\22\34\uffff\1\21\1\uffff\1\21",
            "\1\17\14\uffff\1\20",
            "\1\17\12\uffff\1\23\1\uffff\1\20",
            "\1\25\1\uffff\1\25\5\uffff\4\4\1\uffff\1\25\1\uffff\1\24\5"+
            "\uffff\1\4",
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
            "\1\25\1\uffff\1\25\5\uffff\4\4\1\uffff\1\25\1\uffff\1\24\5"+
            "\uffff\1\4",
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
            return "192:1: p_input : ( variable | method_chain | array | STRING_LITERAL | twig_ternary | twig_not );";
        }
    }
    static final String DFA47_eotS =
        "\111\uffff";
    static final String DFA47_eofS =
        "\111\uffff";
    static final String DFA47_minS =
        "\1\64\1\uffff\1\5\1\66\1\11\1\uffff\1\5\1\11\1\31\2\11\1\5\1\30"+
        "\1\25\1\11\2\66\1\uffff\1\11\1\31\2\11\1\66\1\11\1\10\1\25\1\11"+
        "\1\66\1\26\1\66\1\11\1\66\1\11\1\66\1\10\1\11\1\31\2\11\1\5\1\26"+
        "\1\25\1\30\1\25\1\11\3\66\1\11\1\31\2\11\1\66\1\11\1\25\1\26\1\25"+
        "\1\11\1\66\1\26\2\66\1\11\1\66\2\26\1\25\2\66\1\25\1\26\1\66\1\26";
    static final String DFA47_maxS =
        "\1\70\1\uffff\1\32\1\66\1\70\1\uffff\1\32\1\26\1\70\2\26\1\32\1"+
        "\70\1\25\1\26\2\66\1\uffff\1\26\1\70\2\26\1\70\1\26\1\24\1\25\1"+
        "\26\1\66\1\31\1\66\2\70\1\26\1\70\1\24\1\26\1\70\2\26\1\32\1\31"+
        "\1\25\1\70\1\25\1\26\1\66\2\70\1\26\1\70\2\26\1\70\1\26\1\25\1\31"+
        "\1\25\1\26\1\66\1\31\2\70\1\26\1\70\2\31\1\25\2\70\1\25\1\31\1\70"+
        "\1\31";
    static final String DFA47_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\13\uffff\1\3\67\uffff";
    static final String DFA47_specialS =
        "\111\uffff}>";
    static final String[] DFA47_transitionS = {
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

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "198:9: ( twig_ternary | variable | method_chain )";
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
    public static final BitSet FOLLOW_BLOCK_in_twig_block232 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_twig_block_param_in_twig_block234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDBLOCK_in_twig_block240 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_block242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_block_param260 = new BitSet(new long[]{0x0150100000000402L});
    public static final BitSet FOLLOW_method_chain_in_twig_block_param264 = new BitSet(new long[]{0x0150100000000402L});
    public static final BitSet FOLLOW_twig_print_in_twig_block_param267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_twig_include283 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_include_ternary_in_twig_include286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_include_statement_in_twig_include290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_ternary_in_include_ternary306 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_ternary308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement325 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement328 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_WITH_in_include_statement332 = new BitSet(new long[]{0x0140000001000000L});
    public static final BitSet FOLLOW_variable_in_include_statement335 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_include_statement339 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_method_chain_in_include_statement343 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_json_in_include_statement347 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_ONLY_in_include_statement350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_twig_set369 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set371 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_twig_set374 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_twig_assignment_in_twig_set376 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ENDSET_in_twig_set383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_left_assignment_in_twig_assignment398 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ASIG_in_twig_assignment401 = new BitSet(new long[]{0x0140000001000400L});
    public static final BitSet FOLLOW_twig_right_assignment_in_twig_assignment404 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_PIPE_in_twig_assignment407 = new BitSet(new long[]{0x0140000001000400L});
    public static final BitSet FOLLOW_twig_right_assignment_in_twig_assignment409 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment430 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_twig_left_assignment433 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_left_assignment435 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment454 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment458 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_method_chain_in_twig_right_assignment462 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment466 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment470 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment474 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_twig_right_assignment478 = new BitSet(new long[]{0x0140000001000400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_right_assignment481 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_variable_in_twig_right_assignment485 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_method_chain_in_twig_right_assignment489 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_array_in_twig_right_assignment493 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_json_in_twig_right_assignment497 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_twig_tilde_argument_in_twig_right_assignment501 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument520 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument524 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_method_chain_in_twig_tilde_argument528 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument532 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument536 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_TILDE_in_twig_tilde_argument539 = new BitSet(new long[]{0x0140000001000400L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_tilde_argument542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_tilde_argument546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_tilde_argument550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_twig_tilde_argument554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_twig_tilde_argument558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_twig_import575 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import578 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_IMPORT_in_twig_import583 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_import586 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_variable_in_twig_import590 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_TWIG_AS_in_twig_import594 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import597 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_twig_import600 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_import602 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_MACRO_in_twig_macro624 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_macro627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_macro631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENDMACRO_in_twig_macro637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_twig_if652 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_if657 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_method_chain_in_twig_if661 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_eq_check_in_twig_if665 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_PIPE_in_twig_if669 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_if672 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_method_chain_in_twig_if676 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_eq_check_in_twig_if680 = new BitSet(new long[]{0x0002000000040002L});
    public static final BitSet FOLLOW_IS_in_twig_if687 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_DEFINED_in_twig_if689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSEIF_in_twig_elseif706 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_variable_in_twig_elseif709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_elseif713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_twig_for729 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_for732 = new BitSet(new long[]{0x0000000800400000L});
    public static final BitSet FOLLOW_COMMA_in_twig_for735 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_twig_for737 = new BitSet(new long[]{0x0000000800400000L});
    public static final BitSet FOLLOW_IN_in_twig_for742 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_for_arguments_in_twig_for744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_value_in_for_arguments759 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_PIPE_in_for_arguments762 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_for_value_in_for_arguments764 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_for_value782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_for_value786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_for_value790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_for_value794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_range809 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DDOT_in_range821 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_set_in_range823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary850 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary854 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary858 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary862 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_eq_check_in_twig_ternary866 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_QM_in_twig_ternary869 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary872 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary876 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_variable_in_twig_ternary880 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary884 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COLON_in_twig_ternary887 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_twig_ternary890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_twig_ternary894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_ternary898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_ternary902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_eq_check919 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_method_chain_in_eq_check923 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_NUMBER_in_eq_check927 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_eq_check931 = new BitSet(new long[]{0x000000000001E000L});
    public static final BitSet FOLLOW_set_in_eq_check934 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_variable_in_eq_check951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_eq_check955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_eq_check959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_eq_check963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_OPEN_in_twig_print_statement984 = new BitSet(new long[]{0x0150100000000420L});
    public static final BitSet FOLLOW_twig_print_in_twig_print_statement986 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_PRINT_CLOSE_in_twig_print_statement989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_p_input_in_twig_print1016 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_PIPE_in_twig_print1019 = new BitSet(new long[]{0x0150100000000400L});
    public static final BitSet FOLLOW_p_input_in_twig_print1021 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_variable_in_p_input1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_p_input1042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_in_p_input1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_p_input1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_ternary_in_p_input1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_twig_not_in_p_input1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_twig_not1076 = new BitSet(new long[]{0x0150000000000000L});
    public static final BitSet FOLLOW_twig_ternary_in_twig_not1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_twig_not1083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_method_chain_in_twig_not1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARRAY_START_in_array1103 = new BitSet(new long[]{0x0150000001000000L});
    public static final BitSet FOLLOW_array_elements_in_array1105 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ARRAY_END_in_array1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_array_element_in_array_elements1122 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_array_elements1125 = new BitSet(new long[]{0x0150000001000000L});
    public static final BitSet FOLLOW_array_element_in_array_elements1127 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_STRING_in_array_element1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_array_element1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_array_element1152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_array_element1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_variable1173 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_DOT_in_variable1176 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_STRING_in_variable1179 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_method_in_method_chain1211 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_DOT_in_method_chain1214 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_method_in_method_chain1216 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_variable_in_method1233 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_METHOD_START_in_method1235 = new BitSet(new long[]{0x0150000001000200L});
    public static final BitSet FOLLOW_arguments_in_method1237 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_METHOD_END_in_method1240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_arguments1256 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_arguments1260 = new BitSet(new long[]{0x0150000001000000L});
    public static final BitSet FOLLOW_argument_in_arguments1263 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_literal_argument_in_argument1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_in_argument1281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_argument1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_argument1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_literal_argument1302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_JSON_START_in_json1328 = new BitSet(new long[]{0x0140000002000000L});
    public static final BitSet FOLLOW_json_arguments_in_json1330 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_JSON_END_in_json1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1348 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_COMMA_in_json_arguments1351 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_json_argument_in_json_arguments1354 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_set_in_json_argument1372 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_COLON_in_json_argument1381 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_set_in_json_argument1384 = new BitSet(new long[]{0x0000000000000002L});

}