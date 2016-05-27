/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.parser.regions;

public interface TwigRegionTypes {

	public static final String TWIG_OPEN = "TWIG_OPEN"; //$NON-NLS-1$
	public static final String TWIG_CLOSETAG = "TWIG_CLOSETAG"; //$NON-NLS-1$
	public static final String TWIG_STMT_OPEN = "TWIG_STMT_OPEN"; //$NON-NLS-1$
	public static final String TWIG_STMT_CLOSE = "TWIG_STMT_CLOSE"; //$NON-NLS-1$
	public static final String TWIG_CONTENT = "TWIG_CONTENT"; //$NON-NLS-1$
	public static final String TWIG_COMMENT_OPEN = "TWIG_COMMENT_OPEN"; //$NON-NLS-1$
	public static final String TWIG_COMMENT_TEXT = "TWIG_COMMENT_TEXT"; //$NON-NLS-1$
	public static final String TWIG_COMMENT_CLOSE = "TWIG_COMMENT_CLOSE"; //$NON-NLS-1$
	public static final String TWIG_COMMENT = "TWIG_COMMENT"; //$NON-NLS-1$
	public static final String TWIG_VARIABLE = "TWIG_VARIABLE"; //$NON-NLS-1$
	public static final String TWIG_KEYWORD = "TWIG_KEYWORD"; //$NON-NLS-1$
	public static final String TWIG_BLOCKNAME = "TWIG_BLOCKNAME"; //$NON-NLS-1$

	public static final String TWIG_DELIMITER = "TWIG_DELIMITER"; //$NON-NLS-1$
	public static final String TWIG_WHITESPACE = "TWIG_WHITESPACE"; //$NON-NLS-1$
	public static final String TWIG_NUMBER = "TWIG_NUMBER"; //$NON-NLS-1$
	public static final String TWIG_LABEL = "TWIG_LABEL"; //$NON-NLS-1$
	public static final String TWIG_CONSTANT_ENCAPSED_STRING = "TWIG_CONSTANT_ENCAPSED_STRING"; //$NON-NLS-1$
	public static final String TWIG_DOUBLE_QUOTES_CONTENT = "TWIG_DOUBLE_QUOTES_CONTENT"; //$NON-NLS-1$
	public static final String TWIG_DOUBLE_QUOTES_START = "TWIG_DOUBLE_QUOTES_START"; //$NON-NLS-1$
	public static final String TWIG_DOUBLE_QUOTES_END = "TWIG_DOUBLE_QUOTES_END"; //$NON-NLS-1$
	public static final String TWIG_MINUS = "TWIG_MINUS"; //$NON-NLS-1$

	public static final String TWIG_SINGLE_QUOTES_START = "TWIG_SINGLE_QUOTES_START"; //$NON-NLS-1$
	public static final String TWIG_SINGLE_QUOTES_CONTENT = "TWIG_SINGLE_QUOTES_CONTENT"; //$NON-NLS-1$
	public static final String TWIG_SINGLE_QUOTES_END = "TWIG_SINGLE_QUOTES_END"; //$NON-NLS-1$

	public static final String TWIG_BACKTICK_END = "ST_TWIG_BACKTICK_END"; //$NON-NLS-1$
	public static final String TWIG_BACKTICK_START = "TWIG_BACKTICK_START"; //$NON-NLS-1$

	public static final String TWIG_HASH_START = "TWIG_HASH_START"; //$NON-NLS-1$
	public static final String TWIG_HASH_END = "TWIG_HASH_END"; //$NON-NLS-1$

	public static final String TWIG_INTERPOLATION_START = "TWIG_INTERPOLATION_START"; //$NON-NLS-1$
	public static final String TWIG_INTERPOLATION_END = "TWIG_INTERPOLATION_END"; //$NON-NLS-1$

	static final String PHP_SEMICOLON = "PHP_SEMICOLON"; //$NON-NLS-1$

	static final String PHP_STRING = "PHP_STRING"; //$NON-NLS-1$

	static final String PHP_CURLY_OPEN = "PHP_CURLY_OPEN"; //$NON-NLS-1$

	static final String PHP_CURLY_CLOSE = "PHP_CURLY_CLOSE"; //$NON-NLS-1$

	static final String PHP_CONSTANT_ENCAPSED_STRING = "PHP_CONSTANT_ENCAPSED_STRING"; //$NON-NLS-1$

	static final String PHP_ENCAPSED_AND_WHITESPACE = "PHP_ENCAPSED_AND_WHITESPACE"; //$NON-NLS-1$

	static final String WHITESPACE = "WHITESPACE"; //$NON-NLS-1$

	static final String UNKNOWN_TOKEN = "UNKNOWN_TOKEN"; //$NON-NLS-1$
}
