package org.eclipse.twig.core.compiler.ast.parser;


import java.io.Reader;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.php.internal.core.compiler.ast.parser.AbstractPHPSourceParser;

@SuppressWarnings("restriction")
public class TwigSourceParser extends AbstractPHPSourceParser implements
ISourceParser {

	private String fileName;


	public TwigSourceParser(String fileName2) {
		super(fileName2);
	}


	@Override
	public IModuleDeclaration parse(Reader in, IProblemReporter reporter,
			boolean useShortTags) throws Exception {

		CompilerAstLexer lexer = new CompilerAstLexer(in);
		lexer.setUseShortTags(true);
		CompilerAstParser parser = new CompilerAstParser(lexer);

		try {

			parser.setProblemReporter(reporter);

			parser.setFileName(fileName);

			parser.parse();
		} catch (Exception e) {
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=316077

			e.printStackTrace();
			// XXX: add recovery
			return new ModuleDeclaration(0);
		}
		return parser.getModuleDeclaration();

	}
}