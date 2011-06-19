package org.eclipse.twig.test.testcases;


import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.twig.core.compiler.ast.parser.TwigCommonTree;
import org.eclipse.twig.core.compiler.ast.parser.TwigCommonTreeAdaptor;
import org.eclipse.twig.core.compiler.ast.parser.TwigLexer;
import org.eclipse.twig.core.compiler.ast.parser.TwigNodeVisitor;
import org.eclipse.twig.core.compiler.ast.parser.TwigParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwigParserTest extends TestCase {


	private TestErrorReporter reporter = new TestErrorReporter();


	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void test() {
		
		testTokenstream("<a href='{{ 'foo' | foo.bar }}'>foo</a>");

	}
	
	private void testTokenstream(String tokens) {
		
		try {

			
			CharStream content = new ANTLRStringStream(tokens);
			TwigLexer lexer = new TwigLexer(content, reporter);

			TwigParser parser = new TwigParser(new CommonTokenStream(lexer));
			parser.setErrorReporter(reporter);

			parser.setTreeAdaptor(new TwigCommonTreeAdaptor());
			TwigParser.twig_print_statement_return root;

			root = parser.twig_print_statement();
			TwigCommonTree tree = (TwigCommonTree) root.getTree();
			TwigNodeVisitor visitor = new TwigNodeVisitor();
			tree.accept(visitor);


			assertFalse("Parser has no errors", reporter.hasErrors());


		} catch (Exception e) {

			e.printStackTrace();
			fail();

		}
		
		
	}
}