package org.eclipse.twig.test.testcases;

import java.io.IOException;
import java.util.Stack;

import junit.framework.TestCase;

import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.twig.core.documentModel.parser.TwigTokenizer;
import org.eclipse.twig.core.documentModel.parser.regions.TwigScriptRegion;
import org.eclipse.wst.sse.core.internal.parser.ContextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


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
public class TokenizerTest extends TestCase {

	private TwigTokenizer tokenizer;
	private Stack<ContextRegion> contextRegions;
	private Stack<ITextRegion> textRegions;
	private String tokens;
	
	
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();


	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test
	public void testEmbeddedRegion() {
		
		try {
			String tokens = "<a href=\"{{ }}\"></a>";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ITextRegion region = tokenizer.getNextToken();
				textRegions.push(region);
				System.err.println(region.getType());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	@Test
	public void testMultiParams() {
						
		try {
			
			tokens = "{{ path('_ipsum',{'foo': 'bar'}) }}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ITextRegion region = tokenizer.getNextToken();
				textRegions.push(region);
			}
			
			assertEquals(textRegions.size(), 3);
			
			assertEquals(textRegions.get(0).getType(), TwigRegionContext.TWIG_OPEN);
			assertEquals(textRegions.get(1).getType(), TwigRegionContext.TWIG_CONTENT);
			assertEquals(textRegions.get(2).getType(), TwigRegionContext.TWIG_CLOSE);
			
			TwigScriptRegion scriptRegion = (TwigScriptRegion) textRegions.get(1);			
			assertNotNull(scriptRegion);
			
			assertEquals(13, scriptRegion.getTokenCount());
			
			assertEquals(scriptRegion.getTwigToken(0).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(scriptRegion.getTwigToken(1).getType(), TwigRegionContext.TWIG_LABEL);
			assertEquals(scriptRegion.getTwigToken(2).getType(), TwigRegionContext.TWIG_LABEL);
			assertEquals(scriptRegion.getTwigToken(7).getType(), TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);			
			assertEquals(scriptRegion.getTwigToken(17).getType(), TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);			
			
		} catch (Exception e) {

			fail();
		}		
	}

	
	public void testMultilineComment() {
		
		try {

			tokens = "{# \naha \nsome \ntext #}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ITextRegion region = tokenizer.getNextToken();
				textRegions.push(region);
			}

			assertEquals(textRegions.size(), 3);
			assertEquals(textRegions.get(0).getType(), "TWIG_COMMENT_OPEN");			
			assertEquals(textRegions.get(1).getType(), "TWIG_COMMENT_TEXT");
			assertEquals(textRegions.get(2).getType(), "TWIG_COMMENT_CLOSE");
			
			
		} catch (Exception e) {			
			fail();
		}
	}
	
	
	@Test
	public void testSinglelineComments() {
		
		try {

			tokens = "{# asdf #}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ITextRegion region = tokenizer.getNextToken();
				textRegions.push(region);
			}

			assertEquals(textRegions.size(), 3);
			assertEquals(textRegions.get(0).getType(), "TWIG_COMMENT_OPEN");			
			assertEquals(textRegions.get(1).getType(), "TWIG_COMMENT_TEXT");
			assertEquals(textRegions.get(2).getType(), "TWIG_COMMENT_CLOSE");
			
			
		} catch (Exception e) {			
			fail();
		}
	}
	
	
	@Test
	public void testEmbeddedDoubleQuotes() {
		
		testEmbeddedQuotes("<div id=\"{{ some.id  }}\"></div>");
		
	}
	
	@Test
	public void textEmbeddedSingleQuotes() {
		
		testEmbeddedQuotes("<div id='{{ some.id  }}'></div>");
		
	}
	
	private void testEmbeddedQuotes(String text) {

		try {

			tokens = text;
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ITextRegion region = tokenizer.getNextToken();
				textRegions.push(region);
			}
			
			assertEquals(textRegions.size(), 9);			
			assertEquals(textRegions.get(0).getType(), "XML_TAG_OPEN");			
			assertEquals(textRegions.get(1).getType(), "XML_TAG_NAME");
			assertEquals(textRegions.get(2).getType(), "XML_TAG_ATTRIBUTE_NAME");
			assertEquals(textRegions.get(3).getType(), "XML_TAG_ATTRIBUTE_EQUALS");
			assertEquals(textRegions.get(4).getType(), "XML_TAG_ATTRIBUTE_VALUE");
			assertEquals(textRegions.get(5).getType(), "XML_TAG_CLOSE");
			assertEquals(textRegions.get(6).getType(), "XML_END_TAG_OPEN");
			assertEquals(textRegions.get(7).getType(), "XML_TAG_NAME");
			assertEquals(textRegions.get(8).getType(), "XML_TAG_CLOSE");
			
		} catch (Exception e) {

			fail();
		}
		
		
	}


	@Test
	public void testStatementKeyword() {

		try {

			tokens = "{%extends'::base.html.twig'%}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			contextRegions = new Stack<ContextRegion>();
			assertTrue(contextRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ContextRegion region = (ContextRegion) tokenizer.getNextToken();				
				assertNotNull(region);
				contextRegions.push(region);
			}
			
			assertEquals(3, contextRegions.size());
			assertEquals(contextRegions.get(0).getType(), TwigRegionContext.TWIG_STMT_OPEN);
			assertEquals(contextRegions.get(1).getType(), TwigRegionContext.TWIG_CONTENT);
			assertEquals(contextRegions.get(2).getType(), TwigRegionContext.TWIG_STMT_CLOSE);
			
			tokens = "{% use \"blocks.html\" with sidebar as base_sidebar %}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			contextRegions = new Stack<ContextRegion>();			
			assertTrue(contextRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ContextRegion region = (ContextRegion) tokenizer.getNextToken();				
				assertNotNull(region);
				contextRegions.push(region);
			}
			
			assertEquals(3, contextRegions.size());
			assertEquals(contextRegions.get(0).getType(), TwigRegionContext.TWIG_STMT_OPEN);
			assertEquals(contextRegions.get(1).getType(), TwigRegionContext.TWIG_CONTENT);
			assertEquals(contextRegions.get(2).getType(), TwigRegionContext.TWIG_STMT_CLOSE);
			
			

		} catch (IOException e) {

			e.printStackTrace();
			fail();
		}
	}
	
	
	@Test
	public void testPrintInsideDiv() {
		
		
		try {
		
			tokens = "<div> {{ foo in bar }} </div>";			
			tokenizer = new TwigTokenizer(tokens.toCharArray());

			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);			

			while(!tokenizer.isEOF()) {

				ITextRegion region =  tokenizer.getNextToken();
				textRegions.push(region);
				
			}
			
			assertEquals(textRegions.size(), 11);
			
			
		} catch (Exception e) {
			
			fail();
		}
	}


	@Test
	public void testPrintOpenClose() {

		try {

			tokens = "{{ }}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());

			contextRegions = new Stack<ContextRegion>();
			assertTrue(contextRegions.size() == 0);			

			while(!tokenizer.isEOF()) {
				ContextRegion region = (ContextRegion) tokenizer.getNextToken();
				System.err.println(region.getClass());
				assertNotNull(region);
				contextRegions.push(region);
			}

			assertEquals(contextRegions.get(0).getType(), TwigRegionContext.TWIG_OPEN);
			assertEquals(contextRegions.get(1).getType(), TwigRegionContext.TWIG_CONTENT);
			assertEquals(contextRegions.get(2).getType(), TwigRegionContext.TWIG_CLOSE);
			assertTrue(contextRegions.get(1) instanceof TwigScriptRegion);
			
			TwigScriptRegion twigRegion = (TwigScriptRegion) contextRegions.get(1);
			assertEquals(twigRegion.getTwigToken(0).getType(), TwigRegionContext.TWIG_WHITESPACE);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testEmptyPrintStatement() {
		
		
		try {
			
			tokens = "  {{  }}  ";
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);						
			tokenizer = new TwigTokenizer(tokens.toCharArray());			


			ITextRegion region = null;

			while(!tokenizer.isEOF()) {
				region = tokenizer.getNextToken();
				assertNotNull(region);				
				textRegions.push(region);

			}

			assertEquals(5, textRegions.size());			
			TwigScriptRegion twigRegion = (TwigScriptRegion) textRegions.get(2);
			assertNotNull(twigRegion);
			assertEquals(twigRegion.getTwigToken(0).getType(), TwigRegionContext.TWIG_WHITESPACE);
			
			
		} catch (Exception e) {

			e.printStackTrace();
			fail();
			
		}
	}
	
	@Test
	public void testPercentageAtEndOfStatement() {
		
		try {
			
			tokens = "{% for item in items %";			
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);						
			tokenizer = new TwigTokenizer(tokens.toCharArray());			

			ITextRegion region = null;

			while(!tokenizer.isEOF()) {
				region = tokenizer.getNextToken();
				assertNotNull(region);				
				textRegions.push(region);

			}
			
			assertEquals(2, textRegions.size());
			assertEquals(TwigRegionContext.TWIG_STMT_OPEN, textRegions.get(0).getType());
			assertEquals(TwigRegionContext.TWIG_CONTENT, textRegions.get(1).getType());
			
			
		} catch (Exception e) {

			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testPrintStatement() {
		
		try {
			tokens = "  {{ f";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);			

			while(!tokenizer.isEOF()) {
				ITextRegion region = tokenizer.getNextToken();
				textRegions.push(region);
				System.err.println("region: " + region.getType());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	@Test
	public void testStatementOpenClose() {

		try {

			tokens = "{% foobar %}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			contextRegions = new Stack<ContextRegion>();
			assertTrue(contextRegions.size() == 0);			

			while(!tokenizer.isEOF()) {
				ContextRegion region = (ContextRegion) tokenizer.getNextToken();
				contextRegions.push(region);
			}

			assertEquals(3, contextRegions.size());
			assertEquals(contextRegions.get(0).getType(), TwigRegionContext.TWIG_STMT_OPEN);
			assertEquals(contextRegions.get(1).getType(), TwigRegionContext.TWIG_CONTENT);
			assertEquals(contextRegions.get(2).getType(), TwigRegionContext.TWIG_STMT_CLOSE);
			assertTrue(contextRegions.get(1) instanceof TwigScriptRegion);
			
			tokens = "{% foobar %}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			contextRegions = new Stack<ContextRegion>();
			assertTrue(contextRegions.size() == 0);			

			while(!tokenizer.isEOF()) {

				ContextRegion region = (ContextRegion) tokenizer.getNextToken();
				contextRegions.push(region);

			}

			assertEquals(3, contextRegions.size());
			assertEquals(contextRegions.get(0).getType(), TwigRegionContext.TWIG_STMT_OPEN);
			assertEquals(contextRegions.get(1).getType(), TwigRegionContext.TWIG_CONTENT);
			assertEquals(contextRegions.get(2).getType(), TwigRegionContext.TWIG_STMT_CLOSE);
			assertTrue(contextRegions.get(1) instanceof TwigScriptRegion);
			
			
			tokens = "  {%   %}   ";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);			

			while(!tokenizer.isEOF()) {
				ITextRegion region = tokenizer.getNextToken();
				textRegions.push(region);
				System.out.println(region.getType());

			}
			
			assertEquals(4, textRegions.size());
			assertEquals(textRegions.get(0).getType(), TwigRegionContext.TWIG_STMT_OPEN);
			assertEquals(textRegions.get(1).getType(), TwigRegionContext.TWIG_CONTENT);
			assertEquals(textRegions.get(2).getType(), TwigRegionContext.TWIG_STMT_CLOSE);
			assertEquals(textRegions.get(3).getType(), "XML_CONTENT");
			assertTrue(textRegions.get(1) instanceof TwigScriptRegion);
			

			

		} catch (Exception e) {			
			e.printStackTrace();
			fail();
		}
	}
}