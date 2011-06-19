package org.eclipse.twig.core;

import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.php.internal.core.compiler.ast.parser.AbstractPHPSourceParser;
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
		
		System.err.println("create source parser factory");

	}

	@Override
	public ISourceParser createSourceParser() {

		return this;

	}

	@Override
	public IModuleDeclaration parse(IModuleSource module,
			IProblemReporter reporter) {

		if (!module.getFileName().endsWith(".twig")) {
			
			if (Debug.debugSourceParser)
				System.err.println("passing parse method to super implementation");
			
			return super.parse(module, reporter);
		}

		
		if (Debug.debugSourceParser)
			System.err.println("parse twig");
			
		
		final String fileName = module.getFileName();
		TwigSourceParser parser = new TwigSourceParser(fileName);		
		return parser.parse(module, reporter);		
		
	}
}