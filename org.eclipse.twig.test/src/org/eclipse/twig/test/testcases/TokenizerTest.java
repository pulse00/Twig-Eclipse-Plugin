package org.eclipse.twig.test.testcases;

import java.io.IOException;
import java.util.Stack;

import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.twig.core.documentModel.parser.TwigTokenizer;
import org.eclipse.wst.sse.core.internal.parser.ContextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.xml.core.internal.parser.regions.XMLContentRegion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


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
	private Stack<ContextRegion> regions;
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
	public void testStatementKeyword() {

		try {

			tokens = "{%extends'::base.html.twig'%}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			tokenCount = 0;

			regions = new Stack<ContextRegion>();
			assertTrue(regions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ContextRegion region = (ContextRegion) tokenizer.getNextToken();				
				assertNotNull(region);
				regions.push(region);
			}
			
			assertTrue(regions.size() == 4);
			assertEquals(regions.get(0).getType(), TwigRegionContext.TWIG_STMT_OPEN);
			assertEquals(regions.get(1).getType(), TwigRegionContext.TWIG_KEYWORD);
			assertEquals(regions.get(2).getType(), TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING);
			assertEquals(regions.get(3).getType(), TwigRegionContext.TWIG_STMT_CLOSE);
			
			tokens = "{% use \"blocks.html\" with sidebar as base_sidebar %}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());			
			tokenCount = 0;

			regions = new Stack<ContextRegion>();			
			assertTrue(regions.size() == 0);
			
			while(!tokenizer.isEOF()) {
				ContextRegion region = (ContextRegion) tokenizer.getNextToken();				
				assertNotNull(region);
				regions.push(region);
			}
			
			assertTrue(regions.size() == 16);
			assertEquals(regions.get(0).getType(), TwigRegionContext.TWIG_STMT_OPEN);
			assertEquals(regions.get(1).getType(), TwigRegionContext.TWIG_KEYWORD);
			assertEquals(regions.get(2).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(regions.get(3).getType(), TwigRegionContext.TWIG_DOUBLE_QUOTES_START);
			assertEquals(regions.get(4).getType(), TwigRegionContext.TWIG_DOUBLE_QUOTES_CONTENT);
			assertEquals(regions.get(5).getType(), TwigRegionContext.TWIG_DOUBLE_QUOTES_END);
			assertEquals(regions.get(6).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(regions.get(7).getType(), TwigRegionContext.TWIG_KEYWORD);
			assertEquals(regions.get(8).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(regions.get(9).getType(), TwigRegionContext.TWIG_LABEL);
			assertEquals(regions.get(10).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(regions.get(11).getType(), TwigRegionContext.TWIG_KEYWORD);
			assertEquals(regions.get(12).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(regions.get(13).getType(), TwigRegionContext.TWIG_LABEL);
			assertEquals(regions.get(14).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(regions.get(15).getType(), TwigRegionContext.TWIG_STMT_CLOSE);
			
			
			

		} catch (IOException e) {

			e.printStackTrace();
			fail();
		}
	}


	@Test
	public void testPrintOpenClose() {

		try {

			tokens = "{{ }}";
			tokenizer = new TwigTokenizer(tokens.toCharArray());

			regions = new Stack<ContextRegion>();
			assertTrue(regions.size() == 0);			

			while(!tokenizer.isEOF()) {

				ContextRegion region = (ContextRegion) tokenizer.getNextToken();				
				assertNotNull(region);
				regions.push(region);
			}


			assertEquals(regions.get(0).getType(), TwigRegionContext.TWIG_OPEN);
			assertEquals(regions.get(1).getType(), TwigRegionContext.TWIG_WHITESPACE);
			assertEquals(regions.get(2).getType(), TwigRegionContext.TWIG_CLOSE);					
			
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