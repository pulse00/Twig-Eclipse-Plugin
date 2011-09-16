package com.dubture.twig.ui.actions;

import org.eclipse.dltk.internal.ui.refactoring.actions.RenameModelElementAction;
import org.eclipse.dltk.internal.ui.refactoring.actions.RenameResourceAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchSite;

import com.dubture.twig.ui.editor.TwigStructuredEditor;

@SuppressWarnings("restriction")
public class SurroundWithAction extends Action implements ISelectionChangedListener {

	private TwigStructuredEditor fEditor;
	private IWorkbenchSite fSite;
	
	private ISelectionProvider fSpecialSelectionProvider;

	protected SurroundWithAction(IWorkbenchSite site) {
		
		setText("Surround with..."); 
		fSite = site;		

	}
	
	public SurroundWithAction(TwigStructuredEditor editor) {

		this(editor.getEditorSite());
		
		fEditor= editor;		
		
		
		
	}


	@Override
	public void selectionChanged(SelectionChangedEvent event) {

		
		
	}
	
	@Override
	public void run() {
		
		ISelection selection = getSelection();
		
		if (selection instanceof ITextSelection) {
			
			ITextSelection sel = (ITextSelection) selection;
			
			try {
				String[] lines = sel.getText().split("\n");
				fEditor.getDocument().replace(sel.getOffset(), 0, "");
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	public ISelection getSelection() {
		ISelectionProvider selectionProvider= getSelectionProvider();
		if (selectionProvider != null)
			return selectionProvider.getSelection();
		else
			return null;
	}
	
	
	public ISelectionProvider getSelectionProvider() {
		
		if (fSpecialSelectionProvider != null) {
			return fSpecialSelectionProvider;
		}
		return fSite.getSelectionProvider();
	}
	

}
