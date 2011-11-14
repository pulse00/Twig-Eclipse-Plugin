/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.format;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.wst.html.core.internal.format.HTMLFormatProcessorImpl;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.format.IStructuredFormatter;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.w3c.dom.Node;

import com.dubture.twig.core.format.htmlFormatters.HTMLFormatterNoTwigFactory;

@SuppressWarnings("restriction")
public class TwigFormatProcessorImpl extends HTMLFormatProcessorImpl {

	// saving the paramenters of the formatting areas
	// so that if we are required to format only part of the php - we'll have
	// the data.

	protected String getFileExtension() {
		return "twig"; //$NON-NLS-1$
	}

	/**
	 * Overrites the getFormatter so now the formatter for php is PhpFormatter
	 * and the others get the default (html) formatter
	 */
	protected IStructuredFormatter getFormatter(Node node) {
		return HTMLFormatterNoTwigFactory.getInstance().createFormatter(node,
				getFormatPreferences());
	}

	protected void refreshFormatPreferences() {
		super.refreshFormatPreferences();
	}

	public void formatDocument(IDocument document, int start, int length)
			throws IOException, CoreException {

		if (document == null)
			return;

		if ((start >= 0) && (length >= 0)) {
			// the following if is the reason for not using the super (except
			// for saving the start and length)
			// the bug in the super is that in a multipass formatter the
			// document length is changed and thus
			// the test (start + length <= document.getLength()) is not valid
			// because it will always fail
			if ((start + length > document.getLength())) {
				if (start > document.getLength()) {
					return;
				}
				length = document.getLength() - start;
			}

			IStructuredModel structuredModel = null;
			// OutputStream outputStream = null;
			try {
				// setup structuredModel
				// Note: We are getting model for edit. Will save model if
				// model changed.
				structuredModel = StructuredModelManager.getModelManager()
						.getExistingModelForEdit(document);

				// format
				formatModel(structuredModel, start, length);

				// save model if needed
				if (structuredModel != null
						&& !structuredModel.isSharedForEdit()
						&& structuredModel.isSaveNeeded())
					structuredModel.save();
			} finally {
				// ensureClosed(outputStream, null);
				// release from model manager
				if (structuredModel != null)
					structuredModel.releaseFromEdit();
			}
		}
	}

	public void formatModel(IStructuredModel structuredModel, int start,
			int length) {
		HTMLFormatterNoTwigFactory.getInstance().start = start;
		HTMLFormatterNoTwigFactory.getInstance().length = length;
		super.formatModel(structuredModel, start, length);
	}	
}
