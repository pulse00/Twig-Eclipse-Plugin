/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.popup.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.dubture.twig.core.TwigNature;
import com.dubture.twig.core.log.Logger;

/**
 *
 * Toggle the TwigNature.
 *
 *
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class AddRemoveTwigNatureAction implements IObjectActionDelegate
{

    private ISelection selection;
    private Object[] fTarget;

    /**
     * Constructor for Action1.
     */
    public AddRemoveTwigNatureAction()
    {
        super();
    }

    /**
     * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
     */
    public void setActivePart(IAction action, IWorkbenchPart targetPart)
    {
        targetPart.getSite().getShell();
    }

    /**
     * @see IActionDelegate#run(IAction)
     */
    @SuppressWarnings("rawtypes")
    public void run(IAction action)
    {

        if (selection instanceof IStructuredSelection) {
            for (Iterator it = ((IStructuredSelection) selection).iterator(); it
                    .hasNext();) {
                Object element = it.next();
                IProject project = null;
                if (element instanceof IProject) {
                    project = (IProject) element;
                } else if (element instanceof IAdaptable) {
                    project = (IProject) ((IAdaptable) element)
                            .getAdapter(IProject.class);
                }
                if (project != null) {
                    toggleNature(project);
                }
            }
        }

    }

    /**
     * @see IActionDelegate#selectionChanged(IAction, ISelection)
     */
    public void selectionChanged(IAction action, ISelection selection)
    {

        if (selection instanceof IStructuredSelection) {
            fTarget = ((IStructuredSelection) selection).toArray();
            boolean enabled = true;
            for (Object obj : fTarget) {
                if (!(obj instanceof IProject) && !(obj instanceof IScriptProject)) {
                    enabled = false;
                    break;
                }

                IProject project = null;

                if (obj instanceof IProject) {
                    project = (IProject) obj;
                } else {
                    project = ((IScriptProject)obj).getProject();
                }

                try {
                    if (!project.isAccessible()
                            || project.hasNature(TwigNature.NATURE_ID)) {
                        enabled = false;
                        break;
                    }
                } catch (CoreException e) {
                    enabled = false;
                    Logger.logException(e);
                }
            }
            action.setEnabled(enabled);
        } else {
            fTarget = null;
            action.setEnabled(false);
        }

        this.selection = selection;
    }

    private void toggleNature(IProject project)
    {
        try {

            IProjectDescription description = project.getDescription();
            String[] natures = description.getNatureIds();

            for (int i = 0; i < natures.length; ++i) {
                if (TwigNature.NATURE_ID.equals(natures[i])) {
                    // Remove the nature
                    String[] newNatures = new String[natures.length - 1];
                    System.arraycopy(natures, 0, newNatures, 0, i);
                    System.arraycopy(natures, i + 1, newNatures, i,
                            natures.length - i - 1);
                    description.setNatureIds(newNatures);
                    project.setDescription(description, null);
                    return;
                }
            }

            // Add the nature
            String[] newNatures = new String[natures.length + 1];
            System.arraycopy(natures, 0, newNatures, 0, natures.length);
            newNatures[natures.length] = TwigNature.NATURE_ID;
            description.setNatureIds(newNatures);
            project.setDescription(description, null);

        } catch (CoreException e) {

            Logger.logException(e);
        }
    }
}
