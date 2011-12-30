/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser;

import java.io.Reader;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.php.internal.core.compiler.ast.parser.AbstractPHPSourceParser;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.parser.ast.visitor.SourceParserVisitor;

/**
 * 
 * The {@link TwigSourceParser} is responsible for reporting syntax errors
 * during source parsing.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class TwigSourceParser extends AbstractPHPSourceParser implements
        ISourceParser
{

    // private String fileName;
    // private IProblemReporter problemReporter;
    // private TwigErrorReporter reporter;

    public static final String TWIG_OPEN = "{{";
    public static final String TWIG_CLOSE = "}}";

    public static final String STMT_OPEN = "{%";
    public static final String STMT_CLOSE = "%}";

    public TwigSourceParser(String filename)
    {
        super(filename);
    }

    @Override
    public IModuleDeclaration parse(Reader in, IProblemReporter reporter,
            boolean useShortTags) throws Exception
    {
        try {

            TwigModuleDeclaration module = SourceParserUtil.parseSourceModule(in);
            module.traverse(new SourceParserVisitor(reporter));
            
            return module;

        } catch (Exception e) {
            Logger.logException(e);
        }

        // return an empty moduledeclaration
        return new ModuleDeclaration(0);

    }
}
