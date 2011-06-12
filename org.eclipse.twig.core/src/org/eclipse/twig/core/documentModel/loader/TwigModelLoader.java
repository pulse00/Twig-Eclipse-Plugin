package org.eclipse.twig.core.documentModel.loader;

import org.eclipse.php.internal.core.documentModel.loader.PHPModelLoader;
import org.eclipse.wst.sse.core.internal.document.IDocumentLoader;
import org.eclipse.wst.sse.core.internal.provisional.IModelLoader;


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
public class TwigModelLoader extends PHPModelLoader {
	
	
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

}
