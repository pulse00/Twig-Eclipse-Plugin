package org.eclipse.twig.ui.editor.autoEdit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.ui.Logger;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;


/**
 * 
 * Strategy for auto-closing twig tags.
 * 
 * TODO: Create preference page to turn this feature on and off
 * for different tags.
 * 
 * TODO: Add auto-close feature for single percentage charaterc:
 * 
 * <pre>
 * 
 *  %  <--- auto-creates {% | %} with the cursor in the center.
 * 
 * </pre>
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class CloseTagAutoEditStrategyTwig implements IAutoEditStrategy  {


	private IDocument document;
	private DocumentCommand command;


	@Override
	public void customizeDocumentCommand(IDocument doc,
			DocumentCommand comm) {

		document = doc;
		command = comm;

		IStructuredModel model = null;
		try {
			model = StructuredModelManager.getModelManager()
					.getExistingModelForRead(document);

			if (model != null) {
				if (command.text != null) {
					
					IDOMNode node = (IDOMNode) model
							.getIndexedRegion(command.offset - 1);
					
					if (command.text.equals("{")) { //$NON-NLS-1$
						autoClosePrintTag(node);
					} else if (command.text.equals("%")) {  //$NON-NLS-1$

						autoCloseStatementTag(node);						
						
					}
				}
			}
		} finally {
			if (model != null)
				model.releaseFromRead();
		}
	}


	private void autoCloseStatementTag(IDOMNode node) {

		if (node != null
				&& prefixedWithTwig(document, command.offset, "{")) { //$NON-NLS-1$ //$NON-NLS-2$

			command.text += "  %}"; //$NON-NLS-1$
			command.shiftsCaret = false;
			command.caretOffset = command.offset + 2;
			command.doit = false;

		}
		
	}


	private void autoClosePrintTag(IDOMNode node) {

		if (node != null
				&& prefixedWithTwig(document, command.offset, "{")) { //$NON-NLS-1$ //$NON-NLS-2$

			command.text += "  }}"; //$NON-NLS-1$
			command.shiftsCaret = false;
			command.caretOffset = command.offset + 2;
			command.doit = false;

		}
	}



	private boolean prefixedWithTwig(IDocument document, int offset, String string) {

		try {
			return document.getLength() >= string.length()
					&& document.get(offset - string.length(), string.length())
					.equals(string);
		} catch (BadLocationException e) {
			Logger.logException(e);
			return false;
		}
	}	

}
