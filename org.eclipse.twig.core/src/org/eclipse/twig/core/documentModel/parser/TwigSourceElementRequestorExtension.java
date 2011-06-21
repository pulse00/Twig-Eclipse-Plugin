package org.eclipse.twig.core.documentModel.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.php.core.compiler.PHPSourceElementRequestorExtension;
import org.eclipse.twig.core.compiler.ast.parser.TwigCommonTree;
import org.eclipse.twig.core.compiler.ast.parser.TwigCommonTreeAdaptor;
import org.eclipse.twig.core.compiler.ast.parser.TwigLexer;
import org.eclipse.twig.core.compiler.ast.parser.TwigParser;



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

		
	public TwigSourceElementRequestorExtension() {
		
	}
	
	
	@Override
	public void setSourceModule(IModuleSource sourceModule) {
			
		try {
			
			IElementRequestor requestor = getRequestor();
			CharStream content = new ANTLRStringStream(sourceModule.getSourceContents());
			TwigLexer lexer = new TwigLexer(content);
			requestor.enterModule();

			TwigParser parser = new TwigParser(new CommonTokenStream(lexer));		

			parser.setTreeAdaptor(new TwigCommonTreeAdaptor());
			TwigParser.twig_source_return root;

			root = parser.twig_source();
			TwigCommonTree tree = (TwigCommonTree) root.getTree();
			TwigIndexingVisitor visitor = new TwigIndexingVisitor(requestor);
			tree.accept(visitor);
			requestor.exitModule(0);
			
		} catch (RecognitionException e) {

			e.printStackTrace();
		}
				
		super.setSourceModule(sourceModule);
	}
}