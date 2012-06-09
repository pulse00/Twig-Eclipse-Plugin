/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.outline;

import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.ElementChangedEvent;
import org.eclipse.dltk.core.IElementChangedListener;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IModelElementDelta;
import org.eclipse.dltk.core.IParent;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.php.internal.core.util.OutlineFilter;
import org.eclipse.php.internal.ui.editor.PHPStructuredEditor;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 *
 *
 *
 *
 *
 *
 *
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigOutlineContentProvider implements ITreeContentProvider
{

    // outline tree viewer
    private TreeViewer fOutlineViewer;

    public TwigOutlineContentProvider(TreeViewer viewer)
    {
        super();
        fOutlineViewer = viewer;

        // fix bug 251682 - auto-expand outline view
        fOutlineViewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);

        inputChanged(fOutlineViewer, null, null);
    }

    // private Object[] NO_CLASS = new Object[] { new NoClassElement() };
    private ElementChangedListener fListener;

    public void dispose()
    {
        if (fListener != null) {
            DLTKCore.removeElementChangedListener(fListener);
            fListener = null;
        }
    }

    public Object[] getChildren(Object parent)
    {
        if (parent instanceof IParent) {
            IParent c = (IParent) parent;
            try {
                return OutlineFilter.filterChildrenForOutline(parent,
                        c.getChildren());
            } catch (ModelException x) {
                // https://bugs.eclipse.org/bugs/show_bug.cgi?id=38341
                // don't log NotExist exceptions as this is a valid case
                // since we might have been posted and the element
                // removed in the meantime.
                if (DLTKCore.DEBUG || !x.isDoesNotExist()) {
                    DLTKUIPlugin.log(x);
                }
            }
        }
        return TwigContentOutlineConfiguration.NO_CHILDREN;
    }

    public Object[] getElements(Object parent)
    {
        Object[] children = getChildren(parent);

        return children;
    }

    public Object getParent(Object child)
    {
        if (child instanceof IModelElement) {
            IModelElement e = (IModelElement) child;
            return e.getParent();
        }
        return null;
    }

    public boolean hasChildren(Object parent)
    {
        if (parent instanceof IParent) {
            IParent c = (IParent) parent;
            try {
                IModelElement[] children = OutlineFilter
                        .filter(c.getChildren());
                return (children != null && children.length > 0);
            } catch (ModelException x) {
                // https://bugs.eclipse.org/bugs/show_bug.cgi?id=38341
                // don't log NotExist exceptions as this is a valid case
                // since we might have been posted and the element
                // removed in the meantime.
                if (DLTKUIPlugin.isDebug() || !x.isDoesNotExist()) {
                    DLTKUIPlugin.log(x);
                }
            }
        }
        return false;
    }

    /*
     * @see IContentProvider#inputChanged(Viewer, Object, Object)
     */
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
    {

        // Check that the new input is valid
        boolean isCU = (newInput instanceof ISourceModule);
        // Add a listener if input is valid and there wasn't one
        if (isCU && fListener == null) {
            fListener = new ElementChangedListener();
            DLTKCore.addElementChangedListener(fListener);
        }
        // If the new input is not valid and there is a listener - remove it
        else if (!isCU && fListener != null) {
            DLTKCore.removeElementChangedListener(fListener);
            fListener = null;
        }
    }

    public boolean isDeleted(Object o)
    {
        return false;
    }

    /**
     * The element change listener of the java outline viewer.
     *
     * @see IElementChangedListener
     */
    protected class ElementChangedListener implements IElementChangedListener
    {

        private int useStatementsCount;
        private int useStatementsCountNew;

        public void elementChanged(final ElementChangedEvent e)
        {

            Control control = fOutlineViewer.getControl();
            if (control == null || control.isDisposed()) {
                return;
            }

            Display d = control.getDisplay();
            if (d != null) {
                d.asyncExec(new Runnable()
                {
                    public void run()
                    {
                        IWorkbenchWindow activeWorkbenchWindow = PlatformUI
                                .getWorkbench().getActiveWorkbenchWindow();
                        if (activeWorkbenchWindow != null) {
                            IWorkbenchPage activePage = activeWorkbenchWindow
                                    .getActivePage();
                            if (activePage != null) {
                                IEditorPart activeEditor = activePage
                                        .getActiveEditor();
                                if (activeEditor instanceof PHPStructuredEditor) {
                                    IModelElement base = ((PHPStructuredEditor) activeEditor)
                                            .getModelElement();

                                    IModelElementDelta delta = findElement(
                                            base, e.getDelta());
                                    if ((delta != null || e.getType() == ElementChangedEvent.POST_CHANGE)
                                            && fOutlineViewer != null
                                            && fOutlineViewer.getControl() != null
                                            && !fOutlineViewer.getControl()
                                                    .isDisposed()) {
                                        fOutlineViewer.refresh();
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }

        protected IModelElementDelta findElement(IModelElement unit,
                IModelElementDelta delta)
        {

            if (delta == null || unit == null) {
                return null;
            }

            IModelElement element = delta.getElement();

            if (unit.equals(element)) {
                if (isPossibleStructuralChange(delta)) {
                    return delta;
                }
                return null;
            }

            if (element.getElementType() > IModelElement.SOURCE_MODULE) {
                return null;
            }

            IModelElementDelta[] children = delta.getAffectedChildren();
            if (children == null || children.length == 0) {
                return null;
            }

            for (int i = 0; i < children.length; i++) {
                IModelElementDelta d = findElement(unit, children[i]);
                if (d != null) {
                    return d;
                }
            }

            return null;
        }

        private boolean isPossibleStructuralChange(IModelElementDelta cuDelta)
        {
            int oldValue = useStatementsCount;
            useStatementsCount = useStatementsCountNew;
            if (oldValue != useStatementsCountNew) {
                return true;
            }

            if (cuDelta.getKind() != IModelElementDelta.CHANGED) {
                return true; // add or remove
            }
            int flags = cuDelta.getFlags();
            if ((flags & IModelElementDelta.F_CHILDREN) != 0) {
                return true;
            }
            return (flags & (IModelElementDelta.F_CONTENT | IModelElementDelta.F_FINE_GRAINED)) == IModelElementDelta.F_CONTENT;
        }
    }

}
