/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.parser;

import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.php.core.compiler.PHPSourceElementRequestorExtension;

import com.dubture.twig.core.log.Logger;

/**
 * 
 * The {@link TwigSourceElementRequestorExtension} is called when a twig file is
 * opened and indexes all model elements inside the template.
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
public class TwigSourceElementRequestorExtension extends
        PHPSourceElementRequestorExtension
{

    public static String PRINT_START = "{{";
    public static String PRINT_END = "}}";
    public static String STMT_START = "{%";
    public static String STMT_END = "%}";

    private IElementRequestor requestor;

    public TwigSourceElementRequestorExtension()
    {

    }

    @Override
    public void setSourceModule(IModuleSource sourceModule)
    {

        try {

            super.setSourceModule(sourceModule);

            // if (sourceModule.getFileName().endsWith(".php"))
            // return;
            //
            // String source = sourceModule.getSourceContents();
            // requestor = getRequestor();
            // requestor.enterModule();
            //
            // parsePrints(source);
            // parseStatements(source);
            //
            // requestor.exitModule(0);

        } catch (Exception e) {

            Logger.logException(e);
        }
    }

    private void parsePrints(String source)
    {

        int start = source.indexOf(PRINT_START);
        int end = 0;

        while (start >= 0) {

            end = source.indexOf(PRINT_END, end);

            if (end >= 0)
                end += 2;

            if (end < 0) {
                break;
            }

            parseElements(start, end, source.substring(start, end));
            start = source.indexOf(PRINT_START, start + 2);

        }
    }

    private void parseStatements(String source)
    {

        int start = source.indexOf(STMT_START);
        int end = 0;

        while (start >= 0) {

            end = source.indexOf(STMT_END, end);

            if (end >= 0)
                end += 2;

            if (end < 0) {
                break;
            }

            parseElements(start, end, source.substring(start, end));
            start = source.indexOf(STMT_START, start + 2);

        }
    }

    private void parseElements(int start, int end, String source)
    {

        try {

            // TODO: REWRITE AFTER PARSER IMPLEMENTATION
            // CharStream content = new ANTLRStringStream(source);
            // DummyErrorReporter dummy = new DummyErrorReporter();
            // TwigLexer lexer = new TwigLexer(content, dummy);
            //
            // TwigParser parser = new TwigParser(new CommonTokenStream(lexer));
            // parser.setErrorReporter(dummy);
            //
            // parser.setTreeAdaptor(new TwigCommonTreeAdaptor());
            // TwigParser.twig_source_return root;
            //
            // root = parser.twig_source();
            // TwigCommonTree tree = (TwigCommonTree) root.getTree();
            //
            //
            // TwigIndexingVisitor visitor = new TwigIndexingVisitor(requestor,
            // start, getSourceModule().getModelElement());
            //
            // if (tree != null)
            // tree.accept(visitor);
            // else {
            // Logger.debugMSG("unable to create antlr commontree");
            // }

        } catch (Exception e) {
            Logger.logException(e);

        }
    }
}
