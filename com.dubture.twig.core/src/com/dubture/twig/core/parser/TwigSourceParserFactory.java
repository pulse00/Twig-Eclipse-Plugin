/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser;

import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.php.internal.core.compiler.ast.parser.PHPSourceParserFactory;

import com.dubture.twig.core.util.Debug;

/**
 * {@link TwigSourceParserFactory} overrides parse() for modules with the .twig
 * extension, otherwise delegates parsing to the {@link PHPSourceParserFactory}
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class TwigSourceParserFactory extends PHPSourceParserFactory
{

    public TwigSourceParserFactory()
    {

    }

    @Override
    public IModuleDeclaration parse(IModuleSource module,
            IProblemReporter reporter)
    {

        if (!module.getFileName().endsWith(".twig")) {
            return super.parse(module, reporter);
        }

        final String fileName = module.getFileName();
        TwigSourceParser parser = new TwigSourceParser(fileName);
        return parser.parse(module, reporter);

    }
}
