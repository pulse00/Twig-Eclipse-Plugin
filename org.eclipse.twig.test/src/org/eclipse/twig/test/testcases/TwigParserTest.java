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
	public void testEmptyControlStatement() {
		
		assertValidTokenstream("{% %}");
		
	}
	
	
	@Test
	public void testEmptyPrint() {
		
		assertValidTokenstream("{{  }}");
		
	}
	
	
	@Test
	public void testForStatement() {
		
		
		assertValidTokenstream("{% for item in items %}");
		assertValidTokenstream("{% for i in 0..10 %}");
		assertValidTokenstream("{% for key in value %}");
		assertValidTokenstream("{% for letter in 'a'..'z' %}");
		assertValidTokenstream("{% for letter in 'a'|upper..'z'|upper %}");
		assertValidTokenstream("{% for i in range(0, 10, 2) %}");
		assertValidTokenstream("{% endfor %}");
		assertValidTokenstream("{% else %}");

	}
	
	
	@Test
	public void testIfStatement() {

		assertValidTokenstream("{% if kenny.sick %}");
		assertValidTokenstream("{% else %}");
		assertValidTokenstream("{% elseif kenny.dead %}");
		assertValidTokenstream("{% elseif kill(kenny) %}");
		assertValidTokenstream("{% endif %}");
		
		
	}
	
	@Test
	public void testMacro() {
		
		assertValidTokenstream("{% import \"forms.html\" as forms %}");		
		
	}
	
	@Test
	public void testImport() {
		
		assertValidTokenstream("{% macro input(name, value, type, size) %}");
		assertValidTokenstream("{% endmacro %}");		
		assertValidTokenstream("{% from 'forms.html' import input as input_field, textarea %}");
	
		
	}
	

	@Test
	public void testPipe() {
		
		assertValidTokenstream("{{ 'foo' | foo.bar }}");

	}
	
	@Test
	public void testFunction() {
		
		assertValidTokenstream("{{ post.published_at | date(\"m/d/Y\") }}");

	}
	
	@Test
	public void testMultipleFunctionParameters() {
		
		assertValidTokenstream("{{ \"I like %s and %s.\"|format(foo, \"bar\") }}");

	}
	
	@Test
	public void testJsonParameters() {
		
		assertValidTokenstream("{{ \"I like %this% and %that%.\"|replace({'%this%': foo, '%that%': \"bar\"}) }}");

	}
	
	@Test
	public void testArray() {
		
		assertValidTokenstream("{{ [1, 2, 3]|join('|') }}");
		assertValidTokenstream("{% set foo = [1, {\"foo\": \"bar\"}] %}");

	}

	@Test
	public void testMethods() {
		
		assertValidTokenstream("{{ forms.input('username') }}");
		
	}
	
	@Test
	public void testAssignment() {
		
		
		assertValidTokenstream("{% set foo = 'foo' %}");
		assertValidTokenstream("{% set foo = [1, 2] %}");
		assertValidTokenstream("{% set foo = {'foo': 'bar'} %}");
		assertValidTokenstream("{% set foo = 'foo' ~ 'bar' %}");
		assertValidTokenstream("{% set foo, bar = 'foo', 'bar' %}");
		
	}
	
	
	@Test	
	public void testInclude() {
		
		assertValidTokenstream("{% include 'foo' with {'foo': 'bar'} %}");
		assertValidTokenstream("{% include 'foo' with vars %}");
		assertValidTokenstream("{% include 'foo' with {'foo': 'bar'} only %}");
		assertValidTokenstream("{% include 'foo' only %}");
		assertValidTokenstream("{% include ajax ? 'ajax.html' : 'not_ajax.html' %}");		
		
	}
	
	
	private void assertValidTokenstream(String tokens) {
	
		try {

			CharStream content = new ANTLRStringStream(tokens);
			TwigLexer lexer = new TwigLexer(content, reporter);

			TwigParser parser = new TwigParser(new CommonTokenStream(lexer));
			parser.setErrorReporter(reporter);

			parser.setTreeAdaptor(new TwigCommonTreeAdaptor());
			TwigParser.twig_source_return root;

			root = parser.twig_source();
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