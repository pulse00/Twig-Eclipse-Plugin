package org.eclipse.twig.core.compiler.ast.parser;


import java.io.BufferedReader;
import java.io.Reader;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.php.internal.core.compiler.ast.parser.AbstractPHPSourceParser;
import org.eclipse.twig.core.compiler.ast.parser.error.TwigErrorReporter;


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
	private IProblemReporter problemReporter;
	private TwigErrorReporter reporter;
	
	public static final String TWIG_OPEN = "{{";
	public static final String TWIG_CLOSE = "}}";


	public TwigSourceParser(String filename) {
		super(filename);
	}


	@Override
	public IModuleDeclaration parse(Reader in, IProblemReporter reporter,
			boolean useShortTags) throws Exception {


		this.problemReporter = reporter;
		BufferedReader br = new BufferedReader(in);
		this.reporter = new TwigErrorReporter(problemReporter, fileName);
		
		String line;
		
		int current = 0;

		int start = 0;
		int end = 0;
		int lineNumber = 0;
		
		while( (line = br.readLine()) != null) {
			
			lineNumber++;
			current += line.length();
			
			if (line.contains(TWIG_OPEN)) {

				start = end = 0;
				
				while( (start = line.indexOf(TWIG_OPEN)) >= 0) {
					
					end = line.indexOf(TWIG_CLOSE);
					
					if (end == -1) {
						//TODO: report error
						break;
					}
					
					String twig = line.substring(start, end+2);
					parseTwig(twig, current + start, lineNumber);
					
					if (line.length() > end +1) {						
						//TODO: report error
						break;
					}
					
					line = line.substring(end + 2);
					
				}
			}
			
			
		}
				
		//return an empty moduledeclaration
		return new ModuleDeclaration(0);		

	}
	
	
	private void parseTwig(String source, int offset, int line) {
		
		try {

			reporter.setOffset(offset, line);
			CharStream content = new ANTLRStringStream(source);
			TwigLexer lexer = new TwigLexer(content, reporter);

			TwigParser parser = new TwigParser(new CommonTokenStream(lexer));
			parser.setErrorReporter(reporter);

			parser.setTreeAdaptor(new TwigCommonTreeAdaptor());
			TwigParser.twig_print_statement_return root;

			root = parser.twig_print_statement();
			TwigCommonTree tree = (TwigCommonTree) root.getTree();
			TwigNodeVisitor visitor = new TwigNodeVisitor();
			tree.accept(visitor);


		} catch (Exception e) {

		}
	}
}