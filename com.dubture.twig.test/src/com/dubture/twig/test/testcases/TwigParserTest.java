/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.test.testcases;


import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dubture.twig.core.parser.TwigCommonTree;
import com.dubture.twig.core.parser.TwigCommonTreeAdaptor;
import com.dubture.twig.core.parser.TwigLexer;
import com.dubture.twig.core.parser.TwigNodeVisitor;
import com.dubture.twig.core.parser.TwigParser;

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
	public void testStringLiterals() {
		
		
		assertValidTokenstream("{% metaHttpEquiv 'Content-Type' with 'text/html; charset=utf-8' %}");
		
	}
	
	@Test
	public void testVariableAccess() {
		
		assertValidTokenstream("{{ entity.subject }}");
		assertValidTokenstream("{{ path('post_show', { 'id': entity.id }) }}");
		
		
	}
	
	@Test
	public void testEmbedded() {
		
		assertValidTokenstream("{{ '{% for entity in entities %}' }}");
		assertValidTokenstream("{{ '{{ entity.'~ field|replace({'_': ''}) ~' }}' }}");
		//TODO: handle escaped and embedded strings...
//		assertValidTokenstream("{{ \"{{ path('\"~ route_prefix ~\"_\"~ action ~\"', { 'id': entity.id }) }}\" }}");
//		assertValidTokenstream("{{ '{{ entity.'~ field|replace({'_': ''}) ~'|date(\'Y-m-d H:i:s\') }}' }}");
		
		
	}
	
	
	@Test
	public void testIn() {
		
		
		assertValidTokenstream("{%- if loop.first and ('show' in actions) %}");
		
	}
	
	
	@Test
	public void testSet() {
		
		
		assertValidTokenstream("{% set previous_count = exception.allPrevious|length %}");
	}
	
	
	@Test
	public void testUse() {
		
		
		assertValidTokenstream("{% use \"form_div_layout.html.twig\" %}");
		
	}
	
	@Test
	public void testComplexPipeWithJson() {
		
		assertValidTokenstream("{{ exception.message|replace({\"n\": '<br />'})|format_file_from_text }}");
		
	}
	
	@Test
	public void testAssets() {
		
		assertValidTokenstream("{% stylesheets 'stylesheet1.css' 'stylesheet2.css' '@TestBundle/Resources/css/bundle.css' %}");
		
	}
	
	
	@Test
	public void testTernaryPrint() {
		
		assertValidTokenstream("{{ 200 == collector.statuscode ? '#759e1a' : '#a33' }}");
		
		
	}
	
	@Test
	public void testIsDefined() {
		
		assertValidTokenstream("{% if collector.controller.class is defined %}");
		
		
	}
	
	@Test
	public void testFormMethod() {		
		
		assertValidTokenstream("{{ form_row(form.email) }}");
		
	}
	
	
	@Test
	public void testChainingMethod() {
		
		assertValidTokenstream("{{ headLink().setStylesheet(\"/css/site.css\")|raw }}");		
		
		
	}
	
	@Test
	public void testExtends() {
		
		assertValidTokenstream("{% extends \"AcmeDemoBundle::layout.html.twig\" %}");
		
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
	public void testPrintPipe() {
		
		assertValidTokenstream("{{ kenny | gun }}");
		
	}
	
	@Test
	public void testBlock() {
		
		assertValidTokenstream("{% block sidebar %}");
		assertValidTokenstream("{% endblock %}");
		assertValidTokenstream("{% endblock form_errors %}");
		assertValidTokenstream("{% block title pagetitle|title %}");
		
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
		assertValidTokenstream("{% for i, previous in exception.allPrevious %}");

	}
	
	
	@Test
	public void testIfStatement() {

		assertValidTokenstream("{% if kenny.sick %}");
		assertValidTokenstream("{% else %}");
		assertValidTokenstream("{% elseif kenny.dead %}");
		assertValidTokenstream("{% elseif kill(kenny) %}");
		assertValidTokenstream("{% endif %}");
		assertValidTokenstream("{% if errors|length > 0 %}");
		
		
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
		
		//TODO: make nested json arguments work
		//assertValidTokenstream("{{ form_row(form.body, {'attr' : { 'class' : 'myClass' } } ) }}");

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
			
			assertNotNull(tree);
			
			tree.accept(visitor);

			assertFalse("Parser has no errors", reporter.hasErrors());


		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
