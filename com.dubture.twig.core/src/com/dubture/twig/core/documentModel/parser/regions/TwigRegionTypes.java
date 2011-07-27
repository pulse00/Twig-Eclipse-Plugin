package com.dubture.twig.core.documentModel.parser.regions;

public interface TwigRegionTypes {
	
	
	public static final String TWIG_OPEN 							= "TWIG_OPEN"; //$NON-NLS-1$
	public static final String TWIG_CLOSETAG 						= "TWIG_CLOSETAG"; //$NON-NLS-1$
	public static final String TWIG_STMT_OPEN 						= "TWIG_STMT_OPEN"; //$NON-NLS-1$
	public static final String TWIG_STMT_CLOSE 						= "TWIG_STMT_CLOSE"; //$NON-NLS-1$	
	public static final String TWIG_CONTENT 						= "TWIG_CONTENT"; //$NON-NLS-1$
	public static final String TWIG_COMMENT_OPEN 					= "TWIG_COMMENT_OPEN"; //$NON-NLS-1$
	public static final String TWIG_COMMENT_TEXT 					= "TWIG_COMMENT_TEXT"; //$NON-NLS-1$	
	public static final String TWIG_COMMENT_CLOSE 					= "TWIG_COMMENT_CLOSE"; //$NON-NLS-1$	
	public static final String TWIG_COMMENT 						= "TWIG_COMMENT"; //$NON-NLS-1$
	public static final String TWIG_VARIABLE 						= "TWIG_VARIABLE"; //$NON-NLS-1$
	public static final String TWIG_KEYWORD 						= "TWIG_KEYWORD"; //$NON-NLS-1$	
	public static final String TWIG_DELIMITER 						= "TWIG_DELIMITER"; //$NON-NLS-1$
	public static final String TWIG_WHITESPACE 						= "TWIG_WHITESPACE"; //$NON-NLS-1$
	public static final String TWIG_NUMBER 							= "TWIG_NUMBER"; //$NON-NLS-1$	
	public static final String TWIG_LABEL 							= "TWIG_LABEL"; //$NON-NLS-1$
	public static final String TWIG_CONSTANT_ENCAPSED_STRING 		= "TWIG_CONSTANT_ENCAPSED_STRING"; //$NON-NLS-1$
	public static final String TWIG_DOUBLE_QUOTES_CONTENT 			= "TWIG_DOUBLE_QUOTES_CONTENT"; //$NON-NLS-1$	
	public static final String TWIG_DOUBLE_QUOTES_START 			= "TWIG_DOUBLE_QUOTES_START"; //$NON-NLS-1$
	public static final String TWIG_DOUBLE_QUOTES_END 				= "TWIG_DOUBLE_QUOTES_END"; //$NON-NLS-1$
	public static final String TWIG_MINUS			 				= "TWIG_MINUS"; //$NON-NLS-1$
	
	public static final String TWIG_SINGLE_QUOTES_START 			= "TWIG_SINGLE_QUOTES_START"; //$NON-NLS-1$
	public static final String TWIG_SINGLE_QUOTES_CONTENT 			= "TWIG_SINGLE_QUOTES_CONTENT"; //$NON-NLS-1$	
	public static final String TWIG_SINGLE_QUOTES_END	 			= "TWIG_SINGLE_QUOTES_END"; //$NON-NLS-1$
	
	public static final String TWIG_BACKTICK_END 					= "ST_TWIG_BACKTICK_END"; //$NON-NLS-1$	
	public static final String TWIG_BACKTICK_START 					= "TWIG_BACKTICK_START"; //$NON-NLS-1$		
	
	public static final String TWIG_JSON_START 						= "TWIG_JSON_START"; //$NON-NLS-1$
	public static final String TWIG_JSON_END 						= "TWIG_JSON_END"; //$NON-NLS-1$	
	
	
	static final String PHP_KEYWORD = "PHP_KEYWORD"; //$NON-NLS-1$

	static final String PHP_OBJECT_OPERATOR = "PHP_OBJECT_OPERATOR"; //$//$NON-NLS-N$

	static final String PHP_SEMICOLON = "PHP_SEMICOLON"; //$NON-NLS-1$

	static final String PHP_NUMBER = "PHP_NUMBER"; //$NON-NLS-1$
	
	static final String PHP_PAAMAYIM_NEKUDOTAYIM = "PHP_PAAMAYIM_NEKUDOTAYIM"; //$NON-NLS-1$

	static final String PHP_NS_SEPARATOR = "PHP_NS_SEPARATOR"; //$NON-NLS-1$

	static final String PHP_EXTENDS = "PHP_EXTENDS"; //$NON-NLS-1$

	static final String PHP_VAR_COMMENT = "PHP_VAR_COMMENT"; //$NON-NLS-1$

	static final String PHP_FOR = "PHP_FOR"; //$NON-NLS-1$
	
	static final String PHP_ENDFOR = "PHP_ENDFOR"; //$//$NON-NLS-N$

	static final String PHP_STRING = "PHP_STRING"; //$NON-NLS-1$

	static final String PHP_AS = "PHP_AS"; //$NON-NLS-1$

	static final String PHP_DEFAULT = "PHP_DEFAULT"; //$NON-NLS-1$

	static final String PHP_VARIABLE = "PHP_VARIABLE"; //$NON-NLS-1$

	static final String PHP_CURLY_OPEN = "PHP_CURLY_OPEN"; //$NON-NLS-1$

	static final String PHP_ENDIF = "PHP_ENDIF"; //$NON-NLS-1$

	static final String PHP_ELSEIF = "PHP_ELSEIF"; //$NON-NLS-1$

	static final String PHP_CURLY_CLOSE = "PHP_CURLY_CLOSE"; //$NON-NLS-1$

	static final String PHP_ELSE = "PHP_ELSE"; //$NON-NLS-1$

	static final String PHP_CONSTANT_ENCAPSED_STRING = "PHP_CONSTANT_ENCAPSED_STRING"; //$NON-NLS-1$

	static final String PHP_ENCAPSED_AND_WHITESPACE = "PHP_ENCAPSED_AND_WHITESPACE"; //$NON-NLS-1$

	static final String WHITESPACE = "WHITESPACE"; //$NON-NLS-1$

	static final String PHP_LOGICAL_AND = "PHP_LOGICAL_AND"; //$NON-NLS-1$

	static final String PHP_LOGICAL_OR = "PHP_LOGICAL_OR"; //$NON-NLS-1$

	static final String PHP_NOT = "PHP_NOT"; //$NON-NLS-1$

	static final String PHP_LOGICAL_XOR = "PHP_LOGICAL_XOR"; //$NON-NLS-1$

	static final String PHP_VAR = "PHP_VAR"; //$NON-NLS-1$

	static final String PHP_IF = "PHP_IF"; //$NON-NLS-1$

	static final String PHP_COMMENT = "PHP_COMMENT"; //$NON-NLS-1$

	static final String PHP_COMMENT_START = "PHP_COMMENT_START"; //$NON-NLS-1$

	static final String PHP_COMMENT_END = "PHP_COMMENT_END"; //$NON-NLS-1$

	static final String PHP_LINE_COMMENT = "PHP_LINE_COMMENT"; //$NON-NLS-1$

	static final String PHPDOC_COMMENT = "PHPDOC_COMMENT"; //$NON-NLS-1$

	static final String PHPDOC_COMMENT_START = "PHPDOC_COMMENT_START"; //$NON-NLS-1$

	static final String PHPDOC_COMMENT_END = "PHPDOC_COMMENT_END"; //$NON-NLS-1$

	static final String UNKNOWN_TOKEN = "UNKNOWN_TOKEN"; //$NON-NLS-1$

	static final String PHP_HEREDOC_TAG = "PHP_HEREDOC_TAG"; //$NON-NLS-1$

	static final String PHP_TOKEN = "PHP_TOKEN"; //$NON-NLS-1$

	static final String PHP_OPERATOR = "PHP_OPERATOR"; //$NON-NLS-1$

	static final String PHP__METHOD__ = "PHP__METHOD__"; //$NON-NLS-1$

	static final String PHP_TRUE = "PHP_TRUE"; //$NON-NLS-1$

	static final String PHP_FALSE = "PHP_FALSE"; //$NON-NLS-1$

}