package org.eclipse.twig.core.codeassist;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.php.internal.core.codeassist.contexts.AbstractCompletionContext;
import org.eclipse.php.internal.core.documentModel.parser.PHPRegionContext;
import org.eclipse.php.internal.core.documentModel.parser.regions.IPhpScriptRegion;
import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import org.eclipse.wst.sse.core.internal.provisional.exceptions.ResourceAlreadyExists;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionCollection;

@SuppressWarnings("restriction")
public class TwigCompletionContext extends AbstractCompletionContext {

	private ITwigScriptRegion twigScriptRegion;

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
							
							System.err.println("got script region");
							
						} else {
														
							System.err.println("no script region");
							
						}

					}

				} 

			}

		} catch (ResourceAlreadyExists e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		



		System.err.println("is not valid");
		return false;


	}
	
	protected ITwigScriptRegion determineTwigRegion(IStructuredDocument document,
			ITextRegionCollection regionCollection, int offset) {
		ITextRegion textRegion = determineTextRegion(document,
				regionCollection, offset);
		
		
		
		/**
		 * @see doScanEndPhp method in TwigTokenizer
		 * needs some more jflex interaction :(
		 */
		twigScriptRegion = null;
		
		
		if (textRegion != null) {
			if (textRegion.getType() == TwigRegionContext.TWIG_OPEN) {
				return null;
			} else if (textRegion.getType() == TwigRegionContext.TWIG_CLOSE) {
				if (regionCollection.getStartOffset(textRegion) == offset) {
					textRegion = regionCollection
							.getRegionAtCharacterOffset(offset - 1);
				} else {
					return null;
				}
			}
		}

		
		System.out.println("region: " + textRegion.getClass());
		if (textRegion instanceof ITwigScriptRegion) {
			twigScriptRegion = (ITwigScriptRegion) textRegion;
		}

		return twigScriptRegion;
	}
	

}
