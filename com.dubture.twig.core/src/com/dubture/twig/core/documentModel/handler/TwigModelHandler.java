/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.handler;

import org.eclipse.php.internal.core.documentModel.encoding.PHPDocumentCharsetDetector;
import org.eclipse.php.internal.core.documentModel.handler.PHPModelHandler;
import org.eclipse.php.internal.core.documentModel.loader.PHPModelLoader;
import org.eclipse.wst.html.core.internal.encoding.HTMLModelLoader;
import org.eclipse.wst.sse.core.internal.document.IDocumentCharsetDetector;
import org.eclipse.wst.sse.core.internal.document.IDocumentLoader;
import org.eclipse.wst.sse.core.internal.ltk.modelhandler.AbstractModelHandler;
import org.eclipse.wst.sse.core.internal.provisional.IModelLoader;

import com.dubture.twig.core.documentModel.loader.TwigDocumentLoader;
import com.dubture.twig.core.documentModel.loader.TwigModelLoader;
import com.dubture.twig.core.documentModel.provisional.contenttype.ContentTypeIdForTwig;

/**
 *
 *
 * The {@link TwigModelHandler} is the main entry point of the
 * org.eclipse.wst.sse.core.modelHandler extension point.
 *
 * It creates the {@link TwigModelLoader} and {@link TwigDocumentLoader}
 * instances.
 *
 * The most part of this procedure is basically copy-pasted from the
 * SmartyPlugin:
 *
 * http://code.google.com/p/smartypdt/
 *
 * The reason for this is described here:
 *
 * http://www.eclipse.org/forums/index.php/t/210550/
 *
 * and here
 *
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=296976
 *
 * It boils down to this:
 *
 * The grammar of the underlying XML Tokenizer is created using jflex
 * (http://jflex.de/) - namely version 1.2.2 which is not available anymore.
 *
 * The current version (1.4.3) of jflex does not compile the grammar, so i just
 * used the generated parser from the SmartyPlugin, as it was the only one which
 * extends the WTP HTML editor, instead of writing one from scratch - like the
 * Django plugin does: http://eclipse.kacprzak.org/
 *
 *
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigModelHandler extends AbstractModelHandler {

	private static String ModelHandlerID = "com.dubture.twig.core.documentModel.handler"; //$NON-NLS-1$

	public TwigModelHandler() {

		super();

		setId(ModelHandlerID);
		setAssociatedContentTypeId(ContentTypeIdForTwig.CONTENT_TYPE_ID_TWIG);

	}

	/*
	 * @Override public IModelLoader getModelLoader() {
	 *
	 * return new TwigModelLoader();
	 *
	 * }
	 */

	@Override
	public IDocumentCharsetDetector getEncodingDetector() {

		return new PHPDocumentCharsetDetector();
	}

	@Override
	public IDocumentLoader getDocumentLoader() {

		return new TwigDocumentLoader();
	}

	@Override
	public IModelLoader getModelLoader() {
		return new TwigModelLoader();
	}

}
