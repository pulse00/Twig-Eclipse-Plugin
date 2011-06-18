package org.eclipse.twig.test.testcases;


import junit.framework.TestCase;

import org.eclipse.twig.core.documentModel.provisional.contenttype.ContentTypeIdForTwig;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionCollection;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void test() {

		try {
			IStructuredModel model = createModel(ContentTypeIdForTwig.CONTENT_TYPE_ID_TWIG);	

			IStructuredDocument  fDoc = model.getStructuredDocument();
			String fText = "{{Êfor item in items }}";
			//String fText = "<?php $fo; ?>";
			fDoc.set(fText);			
			IStructuredDocumentRegion[] regions = fDoc.getStructuredDocumentRegions();
			int offset = 8;



			for (IStructuredDocumentRegion region : regions) {

				ITextRegionCollection regionCollection = region;

				ITextRegion textRegion = determineTextRegion(fDoc, region, offset);

				if (textRegion != null) {

					System.err.println("+++ " + textRegion.getType());
				} else {
					System.err.println("no textregion");
				}

				if (textRegion instanceof ITextRegionContainer) {
					regionCollection = (ITextRegionContainer) textRegion;
				}

				System.err.println(region.getType()  + " " + region.getClass());
			}





			System.err.println("regions: " + regions.length);
		} catch (Exception e) {

			e.printStackTrace();
			fail();

		}


	}

	protected ITextRegion determineTextRegion(IStructuredDocument document,
			ITextRegionCollection regionCollection, int offset) {
		ITextRegion textRegion;
		// in case we are at the end of the document, asking for completion

		System.err.println("collection: " + regionCollection.getText());
		if (offset == document.getLength()) {
			textRegion = regionCollection.getLastRegion();
		} else {
			textRegion = regionCollection.getRegionAtCharacterOffset(offset);
		}
		return textRegion;
	}


	private IStructuredModel createModel(String contentTypeID) {

		IModelManager manager = StructuredModelManager.getModelManager();
		return manager.createUnManagedStructuredModelFor(contentTypeID);

	}
}