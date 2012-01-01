/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.test.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.BufferedTreeNodeStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.Expression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dubture.twig.core.parser.ast.TwigLexer;
import com.dubture.twig.core.parser.ast.TwigParser;
import com.dubture.twig.core.parser.ast.TwigParser.template_return;
import com.dubture.twig.core.parser.ast.TwigTreeWalker;
import com.dubture.twig.core.parser.ast.node.BlockStatement;
import com.dubture.twig.core.parser.ast.node.IdentNode;
import com.dubture.twig.core.parser.ast.node.StringLiteral;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;

public class TwigParserTest extends TestCase
{

    @Before
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    @After
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }
    
    
    public void testStatement(String statement, String name, List<Expression> children) throws RecognitionException 
    {

        CharStream charstream = new ANTLRStringStream(statement);
        TwigLexer lexer = new TwigLexer(charstream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        TwigParser parser = new TwigParser(tokenStream);

        template_return template = parser.template();
        System.err.println("BUILT TREE");

        CommonTree tree = (CommonTree) template.getTree();
        System.err.println(tree.toStringTree());
        
        BufferedTreeNodeStream nodeStream = new BufferedTreeNodeStream(tree);
        TwigTreeWalker walker = new TwigTreeWalker(nodeStream);
        
        TwigModuleDeclaration module = walker.module();
        
//        dot -Tpng graph.dot > output.png
        DOTTreeGenerator gen = new DOTTreeGenerator();
        StringTemplate dot = gen.toDOT(tree);

        try {
            
            String cur = new File(".").getAbsolutePath();
                        
            FileOutputStream fos = new FileOutputStream(cur +  "/graph.dot");
            fos.write(dot.toString().getBytes());
        } catch (FileNotFoundException e1) {

            e1.printStackTrace();
        } catch (IOException e1) {

            e1.printStackTrace();
        }
        
        List<?> statements = module.getStatements();        
        
//        assertEquals(1, statements.size());
        
        BlockStatement block = (BlockStatement) statements.get(0);
        
//        assertNotNull(block);        
//        assertEquals(name, block.getName());
        
        int i = 0;
        
        List childs = block.getChilds();
        
        
        
        for (Object object : block.getChilds()) {
            
            System.err.println(children.get(i++));
            System.err.println(object);
//            assertTrue(object.equals(children.get(i)));
            
        }
        
        
        try {
//            System.err.println("-- TRAVERSING");
            module.traverse(new ASTVisitor()
            {

                @Override
                public boolean visitGeneral(ASTNode node) throws Exception
                {
//                     System.err.println("visit " + node.getClass());
                    return super.visitGeneral(node);
                }

                @Override
                public void endvisitGeneral(ASTNode node) throws Exception
                {
//                     System.err.println("endvisit " + node.getClass());
                    super.endvisitGeneral(node);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        

        
        
        
        
    }
    
    @Test
    public void testNewParser()
    {
        try {

            testStatement("{% foo ? 'bar' : 'aha' %}", 
                    "metaHttpEquiv", 
                    new ArrayList<Expression>(Arrays.asList(
                            new StringLiteral(17, 30, "Content-Type"),
                            new IdentNode(32, 37, "with"),
                            new StringLiteral(38, 55, "text/html; charset=utf-8")
                    )
            ));
            
        } catch (RecognitionException e) {            
//            fail("Error parsing template");
        }
    }

    @Test
    public void testStringLiterals()
    {

        assertValidTokenstream("{% metaHttpEquiv 'Content-Type' with 'text/html; charset=utf-8' %}");

    }

    @Test
    public void testVariableAccess()
    {

        assertValidTokenstream("{{ entity.subject }}");
        assertValidTokenstream("{{ path('post_show', { 'id': entity.id }) }}");

    }

    @Test
    public void testEmbedded()
    {

        assertValidTokenstream("{{ '{% for entity in entities %}' }}");
        assertValidTokenstream("{{ '{{ entity.'~ field|replace({'_': ''}) ~' }}' }}");
        // TODO: handle escaped and embedded strings...
        // assertValidTokenstream("{{ \"{{ path('\"~ route_prefix ~\"_\"~ action ~\"', { 'id': entity.id }) }}\" }}");
        // assertValidTokenstream("{{ '{{ entity.'~ field|replace({'_': ''}) ~'|date(\'Y-m-d H:i:s\') }}' }}");

    }

    @Test
    public void testIn()
    {

        assertValidTokenstream("{%- if loop.first and ('show' in actions) %}");

    }

    @Test
    public void testSet()
    {

        assertValidTokenstream("{% set previous_count = exception.allPrevious|length %}");
    }

    @Test
    public void testUse()
    {

        assertValidTokenstream("{% use \"form_div_layout.html.twig\" %}");

    }

    @Test
    public void testComplexPipeWithJson()
    {

        assertValidTokenstream("{{ exception.message|replace({\"n\": '<br />'})|format_file_from_text }}");

    }

    @Test
    public void testAssets()
    {

        assertValidTokenstream("{% stylesheets 'stylesheet1.css' 'stylesheet2.css' '@TestBundle/Resources/css/bundle.css' %}");

    }

    @Test
    public void testTernaryPrint()
    {

        assertValidTokenstream("{{ 200 == collector.statuscode ? '#759e1a' : '#a33' }}");

    }

    @Test
    public void testIsDefined()
    {

        assertValidTokenstream("{% if collector.controller.class is defined %}");

    }

    @Test
    public void testFormMethod()
    {

        assertValidTokenstream("{{ form_row(form.email) }}");

    }

    @Test
    public void testChainingMethod()
    {

        assertValidTokenstream("{{ headLink().setStylesheet(\"/css/site.css\")|raw }}");

    }

    @Test
    public void testExtends()
    {

        assertValidTokenstream("{% extends \"AcmeDemoBundle::layout.html.twig\" %}");

    }

    @Test
    public void testEmptyControlStatement()
    {

        assertValidTokenstream("{% %}");

    }

    @Test
    public void testEmptyPrint()
    {

        assertValidTokenstream("{{  }}");

    }

    @Test
    public void testPrintPipe()
    {

        assertValidTokenstream("{{ kenny | gun }}");

    }

    @Test
    public void testBlock()
    {

        assertValidTokenstream("{% block sidebar %}");
        assertValidTokenstream("{% endblock %}");
        assertValidTokenstream("{% endblock form_errors %}");
        assertValidTokenstream("{% block title pagetitle|title %}");

    }

    @Test
    public void testForStatement()
    {

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
    public void testIfStatement()
    {

        assertValidTokenstream("{% if kenny.sick %}");
        assertValidTokenstream("{% else %}");
        assertValidTokenstream("{% elseif kenny.dead %}");
        assertValidTokenstream("{% elseif kill(kenny) %}");
        assertValidTokenstream("{% endif %}");
        assertValidTokenstream("{% if errors|length > 0 %}");

    }

    @Test
    public void testMacro()
    {

        assertValidTokenstream("{% import \"forms.html\" as forms %}");

    }

    @Test
    public void testImport()
    {

        assertValidTokenstream("{% macro input(name, value, type, size) %}");
        assertValidTokenstream("{% endmacro %}");
        assertValidTokenstream("{% from 'forms.html' import input as input_field, textarea %}");

    }

    @Test
    public void testPipe()
    {

        assertValidTokenstream("{{ 'foo' | foo.bar }}");

    }

    @Test
    public void testFunction()
    {

        assertValidTokenstream("{{ post.published_at | date(\"m/d/Y\") }}");

    }

    @Test
    public void testMultipleFunctionParameters()
    {

        assertValidTokenstream("{{ \"I like %s and %s.\"|format(foo, \"bar\") }}");

    }

    @Test
    public void testJsonParameters()
    {

        // TODO: properly remove global backtracking
        // http://www.antlr.org/wiki/display/ANTLR3/How+to+remove+global+backtracking+from+your+grammar
        //
        // if method_chain is added to the json_arguments in the grammar, the
        // following error is produces
        // by antlr during parser generation:
        // TwigParser.g:95:3: [fatal] rule twig_control_body has non-LL(*)
        // decision due to recursive rule
        // invocations reachable from alts 10,12. Resolve by left-factoring or
        // using syntactic predicates
        // or using backtrack=true option.

        // assertValidTokenstream("{% set attr = attr|merge({'data-prototype': form_row(prototype) }) %}");

        assertValidTokenstream("{{ \"I like %this% and %that%.\"|replace({'%this%': foo, '%that%': \"bar\"}) }}");

        // TODO: make nested json arguments work
        // assertValidTokenstream("{{ form_row(form.body, {'attr' : { 'class' : 'myClass' } } ) }}");

    }

    @Test
    public void testArray()
    {

        assertValidTokenstream("{{ [1, 2, 3]|join('|') }}");
        assertValidTokenstream("{% set foo = [1, {\"foo\": \"bar\"}] %}");

    }

    @Test
    public void testMethods()
    {

        assertValidTokenstream("{{ forms.input('username') }}");

    }

    @Test
    public void testAssignment()
    {

        assertValidTokenstream("{% set foo = 'foo' %}");
        assertValidTokenstream("{% set foo = [1, 2] %}");
        assertValidTokenstream("{% set foo = {'foo': 'bar'} %}");
        assertValidTokenstream("{% set foo = 'foo' ~ 'bar' %}");
        assertValidTokenstream("{% set foo, bar = 'foo', 'bar' %}");

    }

    @Test
    public void testInclude()
    {

        assertValidTokenstream("{% include 'foo' with {'foo': 'bar'} %}");
        assertValidTokenstream("{% include 'foo' with vars %}");
        assertValidTokenstream("{% include 'foo' with {'foo': 'bar'} only %}");
        assertValidTokenstream("{% include 'foo' only %}");
        assertValidTokenstream("{% include ajax ? 'ajax.html' : 'not_ajax.html' %}");

    }

    private void assertValidTokenstream(String tokens)
    {

        try {
            // TODO: implement tests with new parser
            assertTrue(true);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
