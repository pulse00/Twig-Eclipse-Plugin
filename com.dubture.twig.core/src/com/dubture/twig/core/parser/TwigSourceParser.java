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

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.php.internal.core.compiler.ast.parser.AbstractPHPSourceParser;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.ast.TwigLexer;
import com.dubture.twig.core.parser.ast.TwigParser;
import com.dubture.twig.core.parser.ast.TwigParser.template_return;
import com.dubture.twig.core.parser.ast.TwigTreeWalker;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.parser.error.TwigErrorReporter;


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

//	private String fileName;
//	private IProblemReporter problemReporter;
//	private TwigErrorReporter reporter;
	
	public static final String TWIG_OPEN = "{{";
	public static final String TWIG_CLOSE = "}}";

	public static final String STMT_OPEN = "{%";
	public static final String STMT_CLOSE = "%}";
	

	public TwigSourceParser(String filename) {
		super(filename);
	}


	@Override
	public IModuleDeclaration parse(Reader in, IProblemReporter reporter,
			boolean useShortTags) throws Exception {


		try {


			CharStream content = new ANTLRReaderStream(in);
			TwigLexer lexer = new TwigLexer(content);
			
			TwigParser parser = new TwigParser(new CommonTokenStream(lexer));			

			template_return template = parser.template();

			CommonTree tree = (CommonTree) template.getTree();			
			CommonTreeNodeStream nodeStream = new CommonTreeNodeStream(tree);		
			TwigTreeWalker walker = new TwigTreeWalker(nodeStream);
			
			TwigModuleDeclaration module = walker.module();
			

			try {
				module.traverse(new ASTVisitor() {
					
					@Override
					public boolean visitGeneral(ASTNode node) throws Exception {
//						System.err.println("visit");
						return super.visitGeneral(node);
					}
					
					@Override
					public void endvisitGeneral(ASTNode node) throws Exception {
//						System.err.println("endvisit");
						super.endvisitGeneral(node);
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}		
			


		} catch (Exception e) {
			Logger.logException(e);
		}		
				
		//return an empty moduledeclaration
		return new ModuleDeclaration(0);		

	}
}
