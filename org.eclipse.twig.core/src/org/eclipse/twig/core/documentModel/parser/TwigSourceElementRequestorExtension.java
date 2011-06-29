package org.eclipse.twig.core.documentModel.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.php.core.compiler.PHPSourceElementRequestorExtension;
import org.eclipse.twig.core.parser.TwigCommonTree;
import org.eclipse.twig.core.parser.TwigCommonTreeAdaptor;
import org.eclipse.twig.core.parser.TwigLexer;
import org.eclipse.twig.core.parser.TwigParser;



/**
 * 
 * The {@link TwigSourceElementRequestorExtension} is called 
 * when a twig file is opened and indexes all model elements 
 * inside the template.
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
public class TwigSourceElementRequestorExtension extends
		PHPSourceElementRequestorExtension {

	
	public static String PRINT_START = "{{";
	public static String PRINT_END = "}}";
	public static String STMT_START = "{%";
	public static String STMT_END = "%}";
	
	private IElementRequestor requestor;
		
	public TwigSourceElementRequestorExtension() {
		
	}
	
	
	@Override
	public void setSourceModule(IModuleSource sourceModule) {
			
		try {
			
			String source = sourceModule.getSourceContents();
			requestor = getRequestor();
			requestor.enterModule();
			
			parsePrints(source);
			parseStatements(source);
			
			requestor.exitModule(0);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
				
		super.setSourceModule(sourceModule);
	}
	
	private void parsePrints(String source) {
		
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
	
	
	private void parseStatements(String source) {
		
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


	private void parseElements(int start, int end, String source) {

		try {

			CharStream content = new ANTLRStringStream(source);
			TwigLexer lexer = new TwigLexer(content);

			TwigParser parser = new TwigParser(new CommonTokenStream(lexer));		

			parser.setTreeAdaptor(new TwigCommonTreeAdaptor());
			TwigParser.twig_source_return root;

			root = parser.twig_source();
			TwigCommonTree tree = (TwigCommonTree) root.getTree();
			TwigIndexingVisitor visitor = new TwigIndexingVisitor(requestor, start);
			tree.accept(visitor);
			
		} catch (Exception e) {
//			e.printStackTrace();
//			System.err.println("twig source parser requestor: " + e.getMessage());
		}
	}
}