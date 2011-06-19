package org.eclipse.twig.test.testcases;


import java.io.File;
import java.io.FileInputStream;

import junit.framework.TestCase;

import org.eclipse.twig.core.compiler.ast.parser.CompilerAstLexer;
import org.eclipse.twig.core.compiler.ast.parser.CompilerAstParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwigParserTest extends TestCase {

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

		try {
			
			String dir = System.getProperty("user.dir") + "/Resources/test.twig";
			FileInputStream input = new FileInputStream(new File(dir));
			CompilerAstLexer lexer = new CompilerAstLexer(input);
			CompilerAstParser parser = new CompilerAstParser(lexer);
			parser.parse();
			
		} catch (Exception e) {

			fail();
			e.printStackTrace();
			
		}
	}
}