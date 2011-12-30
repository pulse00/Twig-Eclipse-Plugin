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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

import junit.framework.TestCase;

import org.eclipse.wst.sse.core.internal.parser.ContextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dubture.twig.core.documentModel.parser.TwigRegionContext;
import com.dubture.twig.core.documentModel.parser.TwigTokenizer;
import com.dubture.twig.core.documentModel.parser.regions.TwigScriptRegion;

/**
 * 
 * Tests for the {@link TwigTokenizer}
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class TokenizerTest extends TestCase
{

    private TwigTokenizer tokenizer;
    private Stack<ContextRegion> contextRegions;
    private Stack<ITextRegion> textRegions;
    private String tokens;

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

    /**
     * Load a test template.
     * 
     * @param path
     * @return
     */
    private String loadTemplate(String path)
    {

        try {

            String dir = System.getProperty("user.dir") + "/Resources/" + path;
            FileInputStream input = new FileInputStream(new File(dir));

            StringBuffer buffer = new StringBuffer();
            int ch;

            while ((ch = input.read()) != -1) {
                buffer.append((char) ch);
            }

            return buffer.toString();

        } catch (Exception e) {

        }

        fail();
        return null;

    }

    @Test
    public void testHighlighter()
    {

        try {
            tokens = "{{ some('function') }}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testComments()
    {

        try {

            tokens = "{# foobar #}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

            assertEquals(textRegions.size(), 3);
            assertEquals(textRegions.get(0).getType(),
                    TwigRegionContext.TWIG_COMMENT_OPEN);
            assertEquals(textRegions.get(1).getType(),
                    TwigRegionContext.TWIG_COMMENT);
            assertEquals(textRegions.get(2).getType(),
                    TwigRegionContext.TWIG_COMMENT_CLOSE);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testFullTemplate()
    {

        try {

            String[] regions = new String[]{"XML_DECLARATION_OPEN",
                    "XML_DOCTYPE_DECLARATION", "XML_DOCTYPE_NAME",
                    "XML_DECLARATION_CLOSE", "XML_CONTENT", "XML_TAG_OPEN",
                    "XML_TAG_NAME", "XML_TAG_CLOSE", "XML_CONTENT",
                    "XML_TAG_OPEN", "XML_TAG_NAME", "XML_TAG_CLOSE",
                    "XML_CONTENT", "XML_TAG_OPEN", "XML_TAG_NAME",
                    "XML_TAG_ATTRIBUTE_NAME", "XML_TAG_ATTRIBUTE_EQUALS",
                    "XML_TAG_ATTRIBUTE_VALUE", "XML_TAG_ATTRIBUTE_NAME",
                    "XML_TAG_ATTRIBUTE_EQUALS", "XML_TAG_ATTRIBUTE_VALUE",
                    "XML_EMPTY_TAG_CLOSE", "XML_CONTENT", "XML_TAG_OPEN",
                    "XML_TAG_NAME", "XML_TAG_CLOSE", "TWIG_STMT_OPEN",
                    "TWIG_CONTENT", "TWIG_STMT_CLOSE", "XML_CONTENT",
                    "TWIG_STMT_OPEN", "TWIG_CONTENT", "TWIG_STMT_CLOSE",
                    "XML_END_TAG_OPEN", "XML_TAG_NAME", "XML_TAG_CLOSE",
                    "XML_CONTENT", "TWIG_STMT_OPEN", "TWIG_CONTENT",
                    "TWIG_STMT_CLOSE", "TWIG_STMT_OPEN", "TWIG_CONTENT",
                    "TWIG_STMT_CLOSE", "XML_CONTENT", "XML_TAG_OPEN",
                    "XML_TAG_NAME", "XML_TAG_ATTRIBUTE_NAME",
                    "XML_TAG_ATTRIBUTE_EQUALS", "XML_TAG_ATTRIBUTE_VALUE",
                    "XML_TAG_ATTRIBUTE_NAME", "XML_TAG_ATTRIBUTE_EQUALS",
                    "XML_TAG_ATTRIBUTE_VALUE", "WHITE_SPACE",
                    "XML_EMPTY_TAG_CLOSE", "XML_CONTENT", "XML_END_TAG_OPEN",
                    "XML_TAG_NAME", "XML_TAG_CLOSE", "XML_CONTENT",
                    "XML_TAG_OPEN", "XML_TAG_NAME", "XML_TAG_CLOSE",
                    "XML_CONTENT", "XML_TAG_OPEN", "XML_TAG_NAME",
                    "XML_TAG_ATTRIBUTE_NAME", "XML_TAG_ATTRIBUTE_EQUALS",
                    "XML_TAG_ATTRIBUTE_VALUE", "XML_TAG_CLOSE", "XML_CONTENT",
                    "TWIG_OPEN", "TWIG_CONTENT", "TWIG_CLOSE",
                    "XML_END_TAG_OPEN", "XML_TAG_NAME", "XML_TAG_CLOSE",
                    "XML_CONTENT", "TWIG_STMT_OPEN", "TWIG_CONTENT",
                    "TWIG_STMT_CLOSE", "TWIG_STMT_OPEN", "TWIG_CONTENT",
                    "TWIG_STMT_CLOSE", "XML_CONTENT", "TWIG_STMT_OPEN",
                    "TWIG_CONTENT", "TWIG_STMT_CLOSE", "TWIG_STMT_OPEN",
                    "TWIG_CONTENT", "TWIG_STMT_CLOSE", "XML_CONTENT",
                    "XML_TAG_OPEN", "XML_TAG_NAME", "XML_TAG_ATTRIBUTE_NAME",
                    "XML_TAG_ATTRIBUTE_EQUALS", "XML_TAG_ATTRIBUTE_VALUE",
                    "XML_TAG_CLOSE", "XML_END_TAG_OPEN", "XML_TAG_NAME",
                    "XML_TAG_CLOSE", "XML_CONTENT", "TWIG_OPEN",
                    "TWIG_CONTENT", "TWIG_CLOSE", "XML_CONTENT",
                    "TWIG_COMMENT_OPEN", "TWIG_COMMENT", "TWIG_COMMENT_CLOSE",
                    "XML_CONTENT", "XML_END_TAG_OPEN", "XML_TAG_NAME",
                    "XML_TAG_CLOSE", "XML_CONTENT", "XML_END_TAG_OPEN",
                    "XML_TAG_NAME", "XML_TAG_CLOSE"};

            tokens = loadTemplate("full.twig");
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

            int i = 0;

            for (String region : regions) {
                assertEquals(region, textRegions.get(i++).getType());
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testMultipleStatementsOnSingleLine()
    {

        try {

            tokens = "Welcome {% endblock %}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void testEmbeddedRegion()
    {

        try {
            String tokens = "<a href=\"{{ }}\"></a>";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testMultiParams()
    {

        try {

            tokens = "{{ path('_ipsum',{'foo': 'bar'}) }}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

            assertEquals(textRegions.size(), 3);

            assertEquals(textRegions.get(0).getType(),
                    TwigRegionContext.TWIG_OPEN);
            assertEquals(textRegions.get(1).getType(),
                    TwigRegionContext.TWIG_CONTENT);
            assertEquals(textRegions.get(2).getType(),
                    TwigRegionContext.TWIG_CLOSE);

            TwigScriptRegion scriptRegion = (TwigScriptRegion) textRegions
                    .get(1);
            assertNotNull(scriptRegion);

            assertEquals(13, scriptRegion.getTokenCount());

            assertEquals(scriptRegion.getTwigToken(0).getType(),
                    TwigRegionContext.TWIG_WHITESPACE);
            assertEquals(scriptRegion.getTwigToken(1).getType(),
                    TwigRegionContext.TWIG_LABEL);
            assertEquals(scriptRegion.getTwigToken(2).getType(),
                    TwigRegionContext.TWIG_LABEL);
            assertEquals(scriptRegion.getTwigToken(7).getType(),
                    TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);
            assertEquals(scriptRegion.getTwigToken(17).getType(),
                    TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);

        } catch (Exception e) {

            fail();
        }
    }

    public void testMultilineComment()
    {

        try {

            tokens = "{# \naha \nsome \ntext #}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

            assertEquals(textRegions.size(), 3);
            assertEquals(textRegions.get(0).getType(),
                    TwigRegionContext.TWIG_COMMENT_OPEN);
            assertEquals(textRegions.get(1).getType(),
                    TwigRegionContext.TWIG_COMMENT);
            assertEquals(textRegions.get(2).getType(),
                    TwigRegionContext.TWIG_COMMENT_CLOSE);

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSinglelineComments()
    {

        try {

            tokens = "{# asdf #}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

            assertEquals(textRegions.size(), 3);
            assertEquals(textRegions.get(0).getType(),
                    TwigRegionContext.TWIG_COMMENT_OPEN);
            assertEquals(textRegions.get(1).getType(),
                    TwigRegionContext.TWIG_COMMENT);
            assertEquals(textRegions.get(2).getType(),
                    TwigRegionContext.TWIG_COMMENT_CLOSE);

        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testEmbeddedBlockStatement()
    {

        try {

            String[] regions = new String[]{"XML_TAG_OPEN", "XML_TAG_NAME",
                    "XML_TAG_ATTRIBUTE_NAME", "XML_TAG_ATTRIBUTE_EQUALS",
                    "XML_TAG_ATTRIBUTE_VALUE", "XML_TAG_CLOSE",
                    "XML_END_TAG_OPEN", "XML_TAG_NAME", "XML_TAG_CLOSE"};

            tokens = "<div id=\"{% block 'foobar' %}\"></div>";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

            for (int i = 0; i < regions.length; i++) {
                assertEquals(regions[i], textRegions.get(i).getType());
            }

            regions = new String[]{"XML_TAG_OPEN", "XML_TAG_NAME",
                    "XML_TAG_ATTRIBUTE_NAME", "XML_TAG_ATTRIBUTE_EQUALS"};
            tokens = "<div id=\" {% block 'foobar' %}\"></div>";

            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

            for (int i = 0; i < regions.length; i++) {
                assertEquals(regions[i], textRegions.get(i).getType());
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testEmbeddedDoubleQuotes()
    {

        testEmbeddedQuotes("<div id=\"{{ some.id  }}\"></div>");

    }

    @Test
    public void textEmbeddedSingleQuotes()
    {

        testEmbeddedQuotes("<div id='{{ some.id  }}'></div>");

    }

    private void testEmbeddedQuotes(String text)
    {

        try {

            tokens = text;
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

            assertEquals(textRegions.size(), 9);
            assertEquals(textRegions.get(0).getType(), "XML_TAG_OPEN");
            assertEquals(textRegions.get(1).getType(), "XML_TAG_NAME");
            assertEquals(textRegions.get(2).getType(), "XML_TAG_ATTRIBUTE_NAME");
            assertEquals(textRegions.get(3).getType(),
                    "XML_TAG_ATTRIBUTE_EQUALS");
            assertEquals(textRegions.get(4).getType(),
                    "XML_TAG_ATTRIBUTE_VALUE");
            assertEquals(textRegions.get(5).getType(), "XML_TAG_CLOSE");
            assertEquals(textRegions.get(6).getType(), "XML_END_TAG_OPEN");
            assertEquals(textRegions.get(7).getType(), "XML_TAG_NAME");
            assertEquals(textRegions.get(8).getType(), "XML_TAG_CLOSE");

        } catch (Exception e) {

            e.printStackTrace();
            fail();
        }

    }

    @Test
    public void testStatementKeyword()
    {

        try {

            tokens = "{%extends'::base.html.twig'%}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            contextRegions = new Stack<ContextRegion>();
            assertTrue(contextRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ContextRegion region = (ContextRegion) tokenizer.getNextToken();
                assertNotNull(region);
                contextRegions.push(region);
            }

            assertEquals(3, contextRegions.size());
            assertEquals(contextRegions.get(0).getType(),
                    TwigRegionContext.TWIG_STMT_OPEN);
            assertEquals(contextRegions.get(1).getType(),
                    TwigRegionContext.TWIG_CONTENT);
            assertEquals(contextRegions.get(2).getType(),
                    TwigRegionContext.TWIG_STMT_CLOSE);

            tokens = "{% use \"blocks.html\" with sidebar as base_sidebar %}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            contextRegions = new Stack<ContextRegion>();
            assertTrue(contextRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ContextRegion region = (ContextRegion) tokenizer.getNextToken();
                assertNotNull(region);
                contextRegions.push(region);
            }

            assertEquals(3, contextRegions.size());
            assertEquals(contextRegions.get(0).getType(),
                    TwigRegionContext.TWIG_STMT_OPEN);
            assertEquals(contextRegions.get(1).getType(),
                    TwigRegionContext.TWIG_CONTENT);
            assertEquals(contextRegions.get(2).getType(),
                    TwigRegionContext.TWIG_STMT_CLOSE);

        } catch (IOException e) {

            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testPrintInsideDiv()
    {

        try {

            tokens = "<div> {{ foo in bar }} </div>";
            tokenizer = new TwigTokenizer(tokens.toCharArray());

            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {

                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);

            }

            assertEquals(textRegions.size(), 11);

        } catch (Exception e) {

            fail();
        }
    }

    @Test
    public void testPrintOpenClose()
    {

        try {

            tokens = "{{ }}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());

            contextRegions = new Stack<ContextRegion>();
            assertTrue(contextRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ContextRegion region = (ContextRegion) tokenizer.getNextToken();
                assertNotNull(region);
                contextRegions.push(region);
            }

            assertEquals(contextRegions.get(0).getType(),
                    TwigRegionContext.TWIG_OPEN);
            assertEquals(contextRegions.get(1).getType(),
                    TwigRegionContext.TWIG_CONTENT);
            assertEquals(contextRegions.get(2).getType(),
                    TwigRegionContext.TWIG_CLOSE);
            assertTrue(contextRegions.get(1) instanceof TwigScriptRegion);

            TwigScriptRegion twigRegion = (TwigScriptRegion) contextRegions
                    .get(1);
            assertEquals(twigRegion.getTwigToken(0).getType(),
                    TwigRegionContext.TWIG_WHITESPACE);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testEmptyPrintStatement()
    {

        try {

            tokens = "  {{  }}  ";
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);
            tokenizer = new TwigTokenizer(tokens.toCharArray());

            ITextRegion region = null;

            while (!tokenizer.isEOF()) {
                region = tokenizer.getNextToken();
                assertNotNull(region);
                textRegions.push(region);

            }

            assertEquals(5, textRegions.size());
            TwigScriptRegion twigRegion = (TwigScriptRegion) textRegions.get(2);
            assertNotNull(twigRegion);
            assertEquals(twigRegion.getTwigToken(0).getType(),
                    TwigRegionContext.TWIG_WHITESPACE);

        } catch (Exception e) {

            e.printStackTrace();
            fail();

        }
    }

    @Test
    public void testPercentageAtEndOfStatement()
    {

        try {

            tokens = "{% for item in items %";
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);
            tokenizer = new TwigTokenizer(tokens.toCharArray());

            ITextRegion region = null;

            while (!tokenizer.isEOF()) {
                region = tokenizer.getNextToken();
                assertNotNull(region);
                textRegions.push(region);

            }

            assertEquals(2, textRegions.size());
            assertEquals(TwigRegionContext.TWIG_STMT_OPEN, textRegions.get(0)
                    .getType());
            assertEquals(TwigRegionContext.TWIG_CONTENT, textRegions.get(1)
                    .getType());

        } catch (Exception e) {

            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testPrintStatement()
    {

        try {
            tokens = "  {{ f";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);

            }

            assertEquals("XML_CONTENT", textRegions.get(0).getType());
            assertEquals(TwigRegionContext.TWIG_OPEN, textRegions.get(1)
                    .getType());
            assertEquals(TwigRegionContext.TWIG_CONTENT, textRegions.get(2)
                    .getType());
            assertEquals(3, textRegions.size());

        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testStatementOpenClose()
    {

        try {

            tokens = "{% foobar %}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            contextRegions = new Stack<ContextRegion>();
            assertTrue(contextRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ContextRegion region = (ContextRegion) tokenizer.getNextToken();
                contextRegions.push(region);
            }

            assertEquals(3, contextRegions.size());
            assertEquals(contextRegions.get(0).getType(),
                    TwigRegionContext.TWIG_STMT_OPEN);
            assertEquals(contextRegions.get(1).getType(),
                    TwigRegionContext.TWIG_CONTENT);
            assertEquals(contextRegions.get(2).getType(),
                    TwigRegionContext.TWIG_STMT_CLOSE);
            assertTrue(contextRegions.get(1) instanceof TwigScriptRegion);

            tokens = "{% foobar %}";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            contextRegions = new Stack<ContextRegion>();
            assertTrue(contextRegions.size() == 0);

            while (!tokenizer.isEOF()) {

                ContextRegion region = (ContextRegion) tokenizer.getNextToken();
                contextRegions.push(region);

            }

            assertEquals(3, contextRegions.size());
            assertEquals(contextRegions.get(0).getType(),
                    TwigRegionContext.TWIG_STMT_OPEN);
            assertEquals(contextRegions.get(1).getType(),
                    TwigRegionContext.TWIG_CONTENT);
            assertEquals(contextRegions.get(2).getType(),
                    TwigRegionContext.TWIG_STMT_CLOSE);
            assertTrue(contextRegions.get(1) instanceof TwigScriptRegion);

            tokens = "  {%   %}   ";
            tokenizer = new TwigTokenizer(tokens.toCharArray());
            textRegions = new Stack<ITextRegion>();
            assertTrue(textRegions.size() == 0);

            while (!tokenizer.isEOF()) {
                ITextRegion region = tokenizer.getNextToken();
                textRegions.push(region);
            }

            assertEquals(5, textRegions.size());
            assertEquals(textRegions.get(0).getType(), "XML_CONTENT");
            assertEquals(textRegions.get(1).getType(),
                    TwigRegionContext.TWIG_STMT_OPEN);
            assertEquals(textRegions.get(2).getType(),
                    TwigRegionContext.TWIG_CONTENT);
            assertEquals(textRegions.get(3).getType(),
                    TwigRegionContext.TWIG_STMT_CLOSE);
            assertEquals(textRegions.get(4).getType(), "XML_CONTENT");

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
