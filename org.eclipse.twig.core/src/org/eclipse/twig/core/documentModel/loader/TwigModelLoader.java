package org.eclipse.twig.core.documentModel.loader;

import org.eclipse.twig.core.documentModel.DOMModelForTwig;
import org.eclipse.wst.html.core.internal.encoding.HTMLModelLoader;
import org.eclipse.wst.sse.core.internal.document.IDocumentLoader;
import org.eclipse.wst.sse.core.internal.provisional.IModelLoader;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;


/**
 * 
 * 
 * Provides the {@link TwigModelLoader} instance
 * and creates the {@link TwigDocumentLoader}.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigModelLoader extends HTMLModelLoader {
	
	
	@Override
	public IDocumentLoader getDocumentLoader() {

		if (documentLoaderInstance == null) {
			documentLoaderInstance = new TwigDocumentLoader();
		}
		return documentLoaderInstance;
	}
	
	@Override
	public IModelLoader newInstance() {

		return new TwigModelLoader();
	}
	
	public IStructuredModel newModel() {
		return new DOMModelForTwig();
	}	

}
