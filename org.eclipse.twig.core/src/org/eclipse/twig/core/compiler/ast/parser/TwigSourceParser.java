package org.eclipse.twig.core.compiler.ast.parser;


import java.io.Reader;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.php.internal.core.compiler.ast.parser.AbstractPHPSourceParser;


/**
 * 
 * The {@link TwigSourceParser} is responsible for 
 * reporting syntax errors during source parsing.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigSourceParser extends AbstractPHPSourceParser implements
ISourceParser {

	private String fileName;


	public TwigSourceParser(String filename) {
		super(filename);
	}


	@Override
	public IModuleDeclaration parse(Reader in, IProblemReporter reporter,
			boolean useShortTags) throws Exception {

		return new ModuleDeclaration(0);
		
//		CompilerAstLexer lexer = new CompilerAstLexer(in);
//		CompilerAstParser parser = new CompilerAstParser(lexer);
//
//		try {
//
//			parser.setProblemReporter(reporter);
//			parser.setFileName(fileName);
//			parser.parse();
//			
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			// XXX: add recovery
//			return new ModuleDeclaration(0);
//		}
//		return parser.getModuleDeclaration();

	}
}