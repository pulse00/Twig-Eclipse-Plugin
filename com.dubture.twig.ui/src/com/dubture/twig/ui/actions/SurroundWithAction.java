/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.php.internal.ui.editor.PHPStructuredEditor;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.wst.sse.ui.StructuredTextEditor;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.editor.TwigStructuredEditor;

@SuppressWarnings("restriction")
public class SurroundWithAction extends Action implements
        ISelectionChangedListener
{

    private StructuredTextEditor fEditor;
    private IWorkbenchSite fSite;

    private ISelectionProvider fSpecialSelectionProvider;

    protected SurroundWithAction(IWorkbenchSite site)
    {

        setText("Surround with...");
        fSite = site;

    }

    public SurroundWithAction(StructuredTextEditor editor)
    {

        this(editor.getEditorSite());

        fEditor = editor;

    }

    @Override
    public void selectionChanged(SelectionChangedEvent event)
    {

    }

    @Override
    public void run()
    {

        ISelection selection = getSelection();

        if (selection instanceof ITextSelection) {

            ITextSelection sel = (ITextSelection) selection;

            System.err.println(sel);

            try {

                String[] lines = sel.getText().split("\n");
                String newText = "{% for item in items %}\n";
                for (String line : lines) {
                    newText += "\t" + line + "\n";
                }

                newText += "{% endfor %}\n";
                getDocument().replace(sel.getOffset(), sel.getLength(),
                        newText);

            } catch (BadLocationException e) {

                Logger.logException(e);

            }
        }
    }
    
    private IDocument getDocument() {
    	if (fEditor instanceof PHPStructuredEditor) {
    		return ((PHPStructuredEditor) fEditor).getDocument();
    	} else if (fEditor instanceof TwigStructuredEditor) {
    		return ((TwigStructuredEditor) fEditor).getDocument();
    	}
    	
    	return null;
    }

    public ISelection getSelection()
    {
        ISelectionProvider selectionProvider = getSelectionProvider();
        if (selectionProvider != null)
            return selectionProvider.getSelection();
        else
            return null;
    }

    public ISelectionProvider getSelectionProvider()
    {

        if (fSpecialSelectionProvider != null) {
            return fSpecialSelectionProvider;
        }
        return fSite.getSelectionProvider();
    }

}
