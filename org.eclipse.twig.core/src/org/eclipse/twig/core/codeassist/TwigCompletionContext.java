package org.eclipse.twig.core.codeassist;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.php.internal.core.codeassist.contexts.AbstractCompletionContext;
import org.eclipse.twig.core.TwigCorePlugin;
import org.eclipse.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionCollection;


/**
 * 
 * The {@link TwigCompletionContext} checks if we're inside a twig structure:
 * 
 * <pre>
 * 
 * 	{{ ... | ... }}
 * 
 *  or 
 *  
 *  {% ... | .. %}
 * 
 * </pre>
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class TwigCompletionContext extends AbstractCompletionContext {

	private ITwigScriptRegion twigScriptRegion;
	
	
	public ITwigScriptRegion getTwigScriptRegion() {
		return twigScriptRegion;
	}


	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {

		try {
			
			IStructuredDocument document = determineDocument(sourceModule, requestor);

			if (document != null) {

				IStructuredDocumentRegion structuredDocumentRegion = determineStructuredDocumentRegion(
						document, offset);

				if (structuredDocumentRegion != null) {

					ITextRegionCollection regionCollection = determineRegionCollection(document,
							structuredDocumentRegion, offset);

					if (regionCollection != null) {

						ITwigScriptRegion twigScriptRegion = determineTwigRegion(document,
								regionCollection, offset);
												
						if (twigScriptRegion != null) {							
							return true;

						}
					}
				} 
			}
		} catch (Exception e) {
			TwigCorePlugin.log(e);
		}		

		return false;

	}
	

	protected ITwigScriptRegion determineTwigRegion(IStructuredDocument document,
			ITextRegionCollection regionCollection, int offset) {
		
		
//		for (ITextRegion region : regionCollection.getRegions().toArray()) {
//			if(region instanceof TwigScriptRegion) {
//				ITwigScriptRegion twigRegion = (TwigScriptRegion) region;
//				System.err.println("twig region between " + twigRegion.getStart() + " " + twigRegion.getEnd());
//			} else {
//				System.out.println("normal region between " + region.getStart() + " " + region.getEnd());
//			}
//		}

		ITextRegion textRegion = determineTextRegion(document,
				regionCollection, offset);
		
		twigScriptRegion = null;
		
		if (textRegion instanceof ITwigScriptRegion) {
			twigScriptRegion = (ITwigScriptRegion) textRegion;
		}

		return twigScriptRegion;
	}
}