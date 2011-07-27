package com.dubture.twig.ui.editor.autoEdit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;

import com.dubture.twig.ui.TwigUICorePlugin;
import com.dubture.twig.ui.preferences.PreferenceConstants;


/**
 * 
 * Strategy for auto-closing twig tags.
 * 
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

						if (prefixedWith(document, command.offset, "{")) {							
							autoCloseStatementTag(node);
						} else if (prefixedWith(document, command.offset, " ")) {
							autoCreateStatementTag(node);
						}
					}
				
				}
			}
		} finally {
			if (model != null)
				model.releaseFromRead();
		}
	}


	/**
	 * Automatically create a twig statement tag
	 * and insert the cursor in the middle.
	 * 
	 * <pre>
	 * 
	 *   {% | %}
	 * </pre>
	 * 
	 */
	private boolean autoCreateStatementTag(IDOMNode node) {


		IPreferenceStore store = TwigUICorePlugin.getDefault().getPreferenceStore();
		boolean autocreate = store.getBoolean(PreferenceConstants.AUTOCREATE_STATEMENT_TAGS);
		
		if (autocreate == false || node == null)
			return true;

		command.text = "{%  %}"; //$NON-NLS-1$
		command.shiftsCaret = false;
		command.caretOffset = command.offset + 3;
		command.doit = false;		
		
		return true;
		
	}

	/**
	 * Automatically close an open twig statement tag
	 * and insert the cursor in the middle.
	 * 
	 * <pre>
	 * 
	 * 	 {|   <-- type "%" and get
	 * 
	 *   {% | %}
	 *   
	 * </pre>
	 * 
	 */
	private boolean autoCloseStatementTag(IDOMNode node) {

		IPreferenceStore store = TwigUICorePlugin.getDefault().getPreferenceStore();
		boolean autoclose = store.getBoolean(PreferenceConstants.AUTOCLOSE_STATEMENT_TAGS);

		if (autoclose == false || node == null)
			return true;

		command.text += "  %}"; //$NON-NLS-1$
		command.shiftsCaret = false;
		command.caretOffset = command.offset + 2;
		command.doit = false;
		return true;

	}


	/**
	 * Automatically close an open twig print tag
	 * and insert the cursor in the middle.
	 * 
	 * <pre>
	 * 
	 * 	 {|   <-- type "{" and get
	 * 
	 *   {{ | }}
	 *   
	 * </pre>
	 * 
	 */
	private void autoClosePrintTag(IDOMNode node) {

		IPreferenceStore store = TwigUICorePlugin.getDefault().getPreferenceStore();
		boolean autoclose = store.getBoolean(PreferenceConstants.AUTOCLOSE_PRINT_TAGS);
		
		if (autoclose == false)
			return;
		
		if (node != null
				&& prefixedWith(document, command.offset, "{")) { //$NON-NLS-1$ //$NON-NLS-2$

			command.text += "  }}"; //$NON-NLS-1$
			command.shiftsCaret = false;
			command.caretOffset = command.offset + 2;
			command.doit = false;

		}
	}



	private boolean prefixedWith(IDocument document, int offset, String string) {

		try {
			
			boolean larger = document.getLength() >= string.length();
			String prefix =  document.get(offset - string.length(), string.length());
			
			// we're at the beginning of the line and checking for whitespace
			if (prefix.length() == 0 && string.equals(" "))
				return true;
			
			return  larger && prefix.equals(string);
			
		} catch (Exception e) {
						
			return false;
		}
	}	

}
