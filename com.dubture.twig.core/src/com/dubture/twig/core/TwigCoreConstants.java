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
public class TwigCoreConstants
{

    public static final String SYNTAX_ERROR = "Error";
    public static final String SYNTAX_IGNORE = "Ignore";
    public static final String SYNTAX_WARNING = "Warning";
    public static final String SYNTAX_PROBLEM_SEVERITY = "syntax_problem_severity";

    // Twig core classes

    public static final String TWIG_EXTENSION = "Twig_Extension";
    public static final String TWIG_FILTER_FUNCTION = "Twig_Filter_Function";
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

}
