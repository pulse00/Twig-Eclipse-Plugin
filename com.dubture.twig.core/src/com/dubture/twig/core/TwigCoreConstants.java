/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core;

/**
 * 
 * CoreConstants.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public interface TwigCoreConstants {

	public static final String SYNTAX_ERROR = "Error";
	public static final String SYNTAX_IGNORE = "Ignore";
	public static final String SYNTAX_WARNING = "Warning";
	public static final String SYNTAX_PROBLEM_SEVERITY = "syntax_problem_severity";

	// Twig core tags
	public static final String START_BLOCK = "block";
	public static final String END_BLOCK = "endblock";
	public static final String EXTENDS = "extends";

	// Twig core classes
	public static final String TWIG_EXTENSION = "Twig_Extension";
	public static final String TWIG_FILTER_FUNCTION = "Twig_Filter_Function";
	public static final String TWIG_FILTER_METHOD = "Twig_Filter_Method";
	public static final String TWIG_FUNCTION_METHOD = "Twig_Function_Method";
	public static final String TWIG_FUNCTION_FUNCTION = "Twig_Function_Function";
	public static final String TWIG_TEST_FUNCTION = "Twig_Test_Function";
	public static final String TWIG_TOKEN_PARSER = "Twig_TokenParser";

	// / Twig core method names
	public static final String GET_FILTERS = "getFilters";
	public static final String GET_FUNCTIONS = "getFunctions";
	public static final String GET_TESTS = "getTests";
	public static final String PARSE_TOKEN_METHOD = "parse";
	public static final String PARSE_GET_TAG_METHOD = "getTag";
	public static final String PARSE_SUB = "subparse";

	/**
	 * A named preference that controls if the PHP code assist gets auto
	 * activated.
	 * <p>
	 * Value is of type <code>Boolean</code>.
	 * </p>
	 */
	public final static String CODEASSIST_AUTOACTIVATION = "contentAssistAutoactivation"; //$NON-NLS-1$

	/**
	 * A name preference that holds the auto activation delay time in
	 * milliseconds.
	 * <p>
	 * Value is of type <code>Integer</code>.
	 * </p>
	 */
	public final static String CODEASSIST_AUTOACTIVATION_DELAY = "contentAssistAutoactivationDelay"; //$NON-NLS-1$

	/**
	 * A named preference that controls if the php code assist inserts a
	 * proposal automatically if only one proposal is available.
	 * <p>
	 * Value is of type <code>Boolean</code>.
	 * </p>
	 */
	public final static String CODEASSIST_AUTOINSERT = "contentAssistAutoinsert"; //$NON-NLS-1$

}
