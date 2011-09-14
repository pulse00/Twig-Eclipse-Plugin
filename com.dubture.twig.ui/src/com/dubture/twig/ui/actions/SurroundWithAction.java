package com.dubture.twig.ui.actions;

import org.eclipse.dltk.core.IModelElement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class SurroundWithAction extends Action implements IObjectActionDelegate {

	private IModelElement[] fModelElement;
	private String lineDelim;

	@Override
	public void run(IAction action) {

		// Sorting the PHP code elements array by "first-line" position.
		// this will enable "right" order of iteration

		//		Arrays.sort(modelElement, new modelElementComparatorImplementation());

		// iterating the functions that need to add 'PHP Doc' bottoms-up - to
		// eliminate mutual interference


		
//		IEditorInput input;
//		try {
//			input = org.eclipse.php.internal.ui.util.EditorUtility.getEditorInput(modelElem);
//			
//		} catch (ModelException e) {
//			Logger.logException(e);
//			return;
//		}
//
//		IWorkbenchPage page = PHPUiPlugin.getActivePage();
//		IEditorPart editorPart;
//		try {
//			
//	
//			
//			editorPart = IDE.openEditor(page, input,
//					PHPUiConstants.PHP_EDITOR_ID);
//		} catch (PartInitException e) {
//			Logger.logException(e);
//			return;
//		}
//
//		if (editorPart instanceof ITextEditor) {
//			ITextEditor textEditor = (ITextEditor) editorPart;
//			IEditorInput editorInput = editorPart.getEditorInput();
//			IDocument document = textEditor.getDocumentProvider()
//					.getDocument(editorInput);
//			this.lineDelim = TextUtilities.getDefaultLineDelimiter(document);
//
//			String docBlockText = handleElement(textEditor, modelElem, document);
//			if (docBlockText == null) {
//				return;
//			}
//
//			EditorUtility.revealInEditor(textEditor, startPosition, docBlock.length());
//		}


	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		

	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		

	}

}
