package com.dubture.twig.test.testcases;


import junit.framework.TestCase;

import org.eclipse.php.internal.core.util.text.TextSequence;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dubture.twig.core.documentModel.provisional.contenttype.ContentTypeIdForTwig;
import com.dubture.twig.core.util.text.TwigTextSequenceUtilities;


/**
 * 
 * Tests for the {@link TwigTextSequenceUtilities} 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigTextSequenceUtilitiesTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test
	public void testStatement() {

		try {
			IStructuredModel model = createModel(ContentTypeIdForTwig.CONTENT_TYPE_ID_TWIG);	

			IStructuredDocument  fDoc = model.getStructuredDocument();
			String fText = "{% for item in items %}";
			fDoc.set(fText);			
			IStructuredDocumentRegion[] regions = fDoc.getStructuredDocumentRegions();
			
			assertEquals(4, regions.length);
			int offset = 8;

			TextSequence statement = TwigTextSequenceUtilities.getStatement(offset, regions[0], false);
			assertEquals("for i", statement.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	

	@Test
	public void testPrint() {

		try {
			IStructuredModel model = createModel(ContentTypeIdForTwig.CONTENT_TYPE_ID_TWIG);	

			IStructuredDocument  fDoc = model.getStructuredDocument();
			String fText = "{{ item.href }}";
			fDoc.set(fText);			
			IStructuredDocumentRegion[] regions = fDoc.getStructuredDocumentRegions();
			
			assertEquals(1, regions.length);
			int offset = 8;

			TextSequence statement = TwigTextSequenceUtilities.getStatement(offset, regions[0], false);
			assertEquals("item.", statement.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
	}
	
	
	@Test
	public void testSinglePrint() {
		
		
		
		try {
			IStructuredModel model = createModel(ContentTypeIdForTwig.CONTENT_TYPE_ID_TWIG);	

			IStructuredDocument  fDoc = model.getStructuredDocument();
			String fText = "{{ endblock }}";
			fDoc.set(fText);			
			IStructuredDocumentRegion[] regions = fDoc.getStructuredDocumentRegions();
			
			assertEquals(1, regions.length);
			int offset = 5;

			TextSequence statement = TwigTextSequenceUtilities.getStatement(offset, regions[0], false);
			assertEquals("en", statement.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}
		
		
	}
	

	private IStructuredModel createModel(String contentTypeID) {

		IModelManager manager = StructuredModelManager.getModelManager();
		return manager.createUnManagedStructuredModelFor(contentTypeID);

	}
}