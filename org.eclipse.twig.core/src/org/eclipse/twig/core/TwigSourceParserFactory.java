package org.eclipse.twig.core;

import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.ast.parser.ISourceParserFactory;
import org.eclipse.twig.core.documentModel.parser.TwigModuleSourceParser;


/**
 * 
 * 
 * {@link ISourceParserFactory} to instantiate the {@link TwigModuleSourceParser}
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigSourceParserFactory implements ISourceParserFactory {

	public TwigSourceParserFactory() {

	}

	@Override
	public ISourceParser createSourceParser() {

		return new TwigModuleSourceParser();
	}

}
