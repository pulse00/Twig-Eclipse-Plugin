package org.eclipse.twig.test.testcases;

import org.eclipse.twig.core.documentModel.parser.TwigTokenizer;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

@SuppressWarnings("restriction")
public class TokenizerTest extends TestCase {

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
			
			String tokens = "{{ }}";
			TwigTokenizer tokenizer = new TwigTokenizer(tokens.toCharArray());
			
			int regions = 0;
			
			while(!tokenizer.isEOF()) {				
				ITextRegion region = tokenizer.getNextToken();				
				assertNotNull(region);
				regions++;			
			}
			
			assertEquals(regions, 3);
			
		} catch (Exception e) {
			fail();
		}
	}
}