package com.dubture.twig.ui.actions;

import org.eclipse.dltk.internal.corext.refactoring.RefactoringExecutionStarter;
import org.eclipse.dltk.internal.ui.refactoring.RefactoringExecutionHelper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IWorkbenchSite;

import com.dubture.twig.core.log.Logger;
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
				String newText = "{% for item in items %}\n"; 
				for (String line : lines) {
					newText += "\t" + line + "\n";					
				}

				newText += "{% endfor %}\n";
				fEditor.getDocument().replace(sel.getOffset(), sel.getLength(), newText);
				
			} catch (BadLocationException e) {

				Logger.logException(e);

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
