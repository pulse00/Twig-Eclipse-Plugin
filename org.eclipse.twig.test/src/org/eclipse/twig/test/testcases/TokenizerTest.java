package org.eclipse.twig.test.testcases;

import org.eclipse.twig.core.documentModel.parser.TwigTokenizer;
import org.eclipse.wst.sse.core.internal.parser.ContextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.util.Debug;
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
			
			
			String tokens = "{%  %}";
			TwigTokenizer tokenizer = new TwigTokenizer(tokens.toCharArray());
			
			System.out.println(tokens);
			while(!tokenizer.isEOF()) {				
				Object o = tokenizer.getNextToken();				
				if (o != null) {										
					System.err.println(o.toString());	
				} else {
					System.err.println("no token");
				}
			}

			tokens = "  {%   %}   ";
			tokenizer = new TwigTokenizer(tokens.toCharArray());
			
			System.out.println(tokens);
			while(!tokenizer.isEOF()) {				
				Object o = tokenizer.getNextToken();				
				if (o != null) {										
					System.err.println(o.toString());	
				} else {
					System.err.println("no token");
				}
			}
			

			
		} catch (Exception e) {
			
			e.printStackTrace();
			//fail();
		}
	}
}