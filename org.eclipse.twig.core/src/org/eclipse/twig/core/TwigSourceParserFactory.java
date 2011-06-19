package org.eclipse.twig.core;

import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.php.internal.core.compiler.ast.parser.PHPSourceParserFactory;
import org.eclipse.twig.core.compiler.ast.parser.TwigSourceParser;
import org.eclipse.twig.core.util.Debug;

/**
 * {@link TwigSourceParserFactory} overrides parse()
 * for modules with the .twig extension, otherwise
 * delegates parsing to the {@link PHPSourceParserFactory}
 *  
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigSourceParserFactory extends PHPSourceParserFactory {

	public TwigSourceParserFactory() {

	}


	@Override
	public IModuleDeclaration parse(IModuleSource module,
			IProblemReporter reporter) {

		if (!module.getFileName().endsWith(".twig")) {
			return super.parse(module, reporter);
		}
		
		final String fileName = module.getFileName();
		TwigSourceParser parser = new TwigSourceParser(fileName);		
		return parser.parse(module, reporter);		
		
	}
}