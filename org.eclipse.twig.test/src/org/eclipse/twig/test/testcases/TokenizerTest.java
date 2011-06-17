package org.eclipse.twig.test.testcases;

import java.io.IOException;
import java.util.Stack;

import junit.framework.TestCase;

import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.twig.core.documentModel.parser.TwigTokenizer;
import org.eclipse.wst.sse.core.internal.parser.ContextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.xml.core.internal.parser.regions.XMLContentRegion;
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
	private int tokenCount;


	@Before
	protected void setUp() throws Exception {
		super.setUp();


	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test
	public void testRegions() {

		try {

			tokens = "{{ for item in items }}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			
			while(!tokenizer.isEOF()) {
				ITextRegion region = tokenizer.getNextToken();
				System.err.println(region.getType());

			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
			fail();
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
			
			assertEquals(textRegions.size(), 15);
			
			assertEquals(textRegions.get(0).getType(), TwigRegionContext.TWIG_OPEN);
			assertEquals(textRegions.get(1).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(textRegions.get(2).getType(), TwigRegionContext.TWIG_LABEL);
			assertEquals(textRegions.get(3).getType(), TwigRegionContext.TWIG_DELIMITER);
			assertEquals(textRegions.get(4).getType(), TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);
			assertEquals(textRegions.get(5).getType(), TwigRegionContext.TWIG_DELIMITER);
			assertEquals(textRegions.get(6).getType(), TwigRegionContext.TWIG_JSON_START);
			assertEquals(textRegions.get(7).getType(), TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);
			assertEquals(textRegions.get(8).getType(), TwigRegionContext.TWIG_DELIMITER);
			assertEquals(textRegions.get(9).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(textRegions.get(10).getType(), TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);
			assertEquals(textRegions.get(11).getType(), TwigRegionContext.TWIG_JSON_END);
			assertEquals(textRegions.get(12).getType(), TwigRegionContext.TWIG_DELIMITER);
			assertEquals(textRegions.get(13).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(textRegions.get(14).getType(), TwigRegionContext.TWIG_CLOSE);
			
			
			tokens = "{{ path('_ipsum',{ \"foo\": 'bar' }) }}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			textRegions = new Stack<ITextRegion>();
			assertTrue(textRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ITextRegion region = tokenizer.getNextToken();
				textRegions.push(region);
			}
			

			assertEquals(textRegions.size(), 19);
			assertEquals(textRegions.get(0).getType(), TwigRegionContext.TWIG_OPEN);
			assertEquals(textRegions.get(1).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(textRegions.get(2).getType(), TwigRegionContext.TWIG_LABEL);
			assertEquals(textRegions.get(3).getType(), TwigRegionContext.TWIG_DELIMITER);
			assertEquals(textRegions.get(4).getType(), TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);
			assertEquals(textRegions.get(5).getType(), TwigRegionContext.TWIG_DELIMITER);
			assertEquals(textRegions.get(6).getType(), TwigRegionContext.TWIG_JSON_START);
			assertEquals(textRegions.get(7).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(textRegions.get(8).getType(), TwigRegionContext.TWIG_DOUBLE_QUOTES_START);
			assertEquals(textRegions.get(9).getType(), TwigRegionContext.TWIG_DOUBLE_QUOTES_CONTENT);
			assertEquals(textRegions.get(10).getType(), TwigRegionContext.TWIG_DOUBLE_QUOTES_END);
			assertEquals(textRegions.get(11).getType(), TwigRegionContext.TWIG_DELIMITER);
			assertEquals(textRegions.get(12).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(textRegions.get(13).getType(), TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);
			assertEquals(textRegions.get(14).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(textRegions.get(15).getType(), TwigRegionContext.TWIG_JSON_END);
			assertEquals(textRegions.get(16).getType(), TwigRegionContext.TWIG_DELIMITER);
			assertEquals(textRegions.get(17).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(textRegions.get(18).getType(), TwigRegionContext.TWIG_CLOSE);			
			
			
		} catch (Exception e) {

			fail();
		}		
	}

	
	public void testMultilineComment() {
		
		try {

			tokens = "{# \naha \nsome \ntext #}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			tokenCount = 0;

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

			tokens = "{# aha #}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			tokenCount = 0;

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
			tokenCount = 0;

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
			tokenCount = 0;

			contextRegions = new Stack<ContextRegion>();
			assertTrue(contextRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ContextRegion region = (ContextRegion) tokenizer.getNextToken();				
				assertNotNull(region);
				contextRegions.push(region);
			}
			
			assertTrue(contextRegions.size() == 4);
			assertEquals(contextRegions.get(0).getType(), TwigRegionContext.TWIG_STMT_OPEN);
			assertEquals(contextRegions.get(1).getType(), TwigRegionContext.TWIG_KEYWORD);
			assertEquals(contextRegions.get(2).getType(), TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);
			assertEquals(contextRegions.get(3).getType(), TwigRegionContext.TWIG_STMT_CLOSE);
			
			tokens = "{% use \"blocks.html\" with sidebar as base_sidebar %}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			tokenCount = 0;

			contextRegions = new Stack<ContextRegion>();			
			assertTrue(contextRegions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ContextRegion region = (ContextRegion) tokenizer.getNextToken();				
				assertNotNull(region);
				contextRegions.push(region);
			}
			
			assertTrue(contextRegions.size() == 16);
			assertEquals(contextRegions.get(0).getType(), TwigRegionContext.TWIG_STMT_OPEN);
			assertEquals(contextRegions.get(1).getType(), TwigRegionContext.TWIG_KEYWORD);
			assertEquals(contextRegions.get(2).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(contextRegions.get(3).getType(), TwigRegionContext.TWIG_DOUBLE_QUOTES_START);
			assertEquals(contextRegions.get(4).getType(), TwigRegionContext.TWIG_DOUBLE_QUOTES_CONTENT);
			assertEquals(contextRegions.get(5).getType(), TwigRegionContext.TWIG_DOUBLE_QUOTES_END);
			assertEquals(contextRegions.get(6).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(contextRegions.get(7).getType(), TwigRegionContext.TWIG_KEYWORD);
			assertEquals(contextRegions.get(8).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(contextRegions.get(9).getType(), TwigRegionContext.TWIG_LABEL);
			assertEquals(contextRegions.get(10).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(contextRegions.get(11).getType(), TwigRegionContext.TWIG_KEYWORD);
			assertEquals(contextRegions.get(12).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(contextRegions.get(13).getType(), TwigRegionContext.TWIG_LABEL);
			assertEquals(contextRegions.get(14).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(contextRegions.get(15).getType(), TwigRegionContext.TWIG_STMT_CLOSE);
			
			
			

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
			
			assertEquals(textRegions.size(), 17);
			
			
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
				assertNotNull(region);
				contextRegions.push(region);
			}


			assertEquals(contextRegions.get(0).getType(), TwigRegionContext.TWIG_OPEN);
			assertEquals(contextRegions.get(1).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(contextRegions.get(2).getType(), TwigRegionContext.TWIG_CLOSE);					
			
			tokens = "  {{  }}  ";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			tokenCount = 0;


			ITextRegion region = null;

			while(!tokenizer.isEOF()) {

				region = tokenizer.getNextToken();				
				assertNotNull(region);

				switch (tokenCount++) {

				case 0:
					XMLContentRegion xmlStart = (XMLContentRegion) region;
					assertNotNull(xmlStart);
					break;

				case 1:
					assertEquals(region.getType(), TwigRegionContext.TWIG_OPEN);
					break;

				case 2:
					assertEquals(region.getType(), TwigRegionContext.TWIG_WHITESPACE);
					break;

				case 3:
					assertEquals(region.getType(), TwigRegionContext.TWIG_CLOSE);					
					break;

				case 4:
					XMLContentRegion xmlEnd = (XMLContentRegion) region;
					assertNotNull(xmlEnd);
					break;

				default:
					fail();
					break;
				}				
			}

			assertEquals(tokenCount, 5);


		} catch (Exception e) {

			e.printStackTrace();
			fail();
		}
	}


	@Test
	public void testStatementOpenClose() {

		try {

			tokens = "{%  %}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			tokenCount = 0;

			while(!tokenizer.isEOF()) {

				ContextRegion region = (ContextRegion) tokenizer.getNextToken();				
				assertNotNull(region);

				switch (tokenCount++) {

				case 0:					
					assertEquals(region.getType(), TwigRegionContext.TWIG_STMT_OPEN);
					break;

				case 1:
					assertEquals(region.getType(), TwigRegionContext.TWIG_STMT_CLOSE);
					break;

				default:
					fail();
					break;
				}				
			}

			assertEquals(tokenCount, 2);

			tokens = "  {%   %}   ";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			tokenCount = 0;


			ITextRegion region = null;


			while(!tokenizer.isEOF()) {

				switch (tokenCount++) {

				case 0:					

					region = (ContextRegion) tokenizer.getNextToken();					
					assertNotNull(region);					
					assertEquals(region.getType(), TwigRegionContext.TWIG_STMT_OPEN);
					break;

				case 1:
					region = (ContextRegion) tokenizer.getNextToken();
					assertNotNull(region);										
					assertEquals(region.getType(), TwigRegionContext.TWIG_STMT_CLOSE);
					break;

				case 2:

					region = (XMLContentRegion) tokenizer.getNextToken();
					assertNotNull(region);					
					break;

				default:
					fail();
					break;
				}				
			}

			assertEquals(tokenCount, 3);			

		} catch (Exception e) {			
			e.printStackTrace();
			fail();
		}
	}
}