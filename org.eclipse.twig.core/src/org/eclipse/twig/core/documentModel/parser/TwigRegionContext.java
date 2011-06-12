package org.eclipse.twig.core.documentModel.parser;


/**
 * 
 * @see http://code.google.com/p/smartypdt/source/browse/trunk/org.eclipse.php.smarty.core/src/org/eclipse/php/smarty/internal/core/documentModel/parser/SmartyRegionContext.java
 *
 */
public interface TwigRegionContext {

	public static final String TWIG_OPEN = "TWIG_OPEN"; //$NON-NLS-1$
	public static final String TWIG_CLOSE = "TWIG_CLOSE"; //$NON-NLS-1$
	public static final String TWIG_CONTENT = "TWIG_CONTENT"; //$NON-NLS-1$
	public static final String TWIG_COMMENT = "TWIG_COMMENT"; //$NON-NLS-1$
	public static final String TWIG_VARIABLE = "TWIG_VARIABLE"; //$NON-NLS-1$
	public static final String TWIG_DELIMITER = "TWIG_DELIMITER"; //$NON-NLS-1$
	public static final String TWIG_WHITESPACE = "TWIG_WHITESPACE"; //$NON-NLS-1$
	public static final String TWIG_NUMBER = "TWIG_NUMBER"; //$NON-NLS-1$	
	public static final String TWIG_LABEL = "TWIG_LABEL"; //$NON-NLS-1$
	public static final String TWIG_CONSTANT_ENCAPSED_STRING = "TWIG_CONSTANT_ENCAPSED_STRING"; //$NON-NLS-1$
	public static final String TWIG_DOUBLE_QUOTES_CONTENT = "TWIG_DOUBLE_QUOTES_CONTENT"; //$NON-NLS-1$	
	public static final String TWIG_DOUBLE_QUOTES_START = "TWIG_DOUBLE_QUOTES_START"; //$NON-NLS-1$
	public static final String TWIG_DOUBLE_QUOTES_END = "TWIG_DOUBLE_QUOTES_END"; //$NON-NLS-1$
	public static final String TWIG_BACKTICK_END = "ST_TWIG_BACKTICK_END"; //$NON-NLS-1$	
	public static final String TWIG_BACKTICK_START = "TWIG_BACKTICK_START"; //$NON-NLS-1$		

}
