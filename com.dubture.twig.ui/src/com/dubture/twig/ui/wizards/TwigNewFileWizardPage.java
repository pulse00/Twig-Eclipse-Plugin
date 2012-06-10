/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.wizards;

import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.dltk.core.IProjectFragment;
import org.eclipse.dltk.core.IScriptFolder;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.ProjectFragment;
import org.eclipse.dltk.ui.dialogs.StatusInfo;
import org.eclipse.dltk.ui.wizards.NewSourceModulePage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

import com.dubture.twig.core.TwigNature;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.extension.ExtensionManager;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the extension that matches the expected one (twig).
 */

@SuppressWarnings("restriction")
public class TwigNewFileWizardPage extends NewSourceModulePage
{
    private Text containerText;

    private Text fileText;

    private ISelection selection;

    private String filename = "";

    private List<ITemplateProvider> extensions;



    /**
     * Constructor for SampleNewWizardPage.
     *
     * @param pageName
     */
    public TwigNewFileWizardPage(ISelection selection)
    {
        this.selection = selection;
    }

    @Override
    protected void createContentControls(Composite container, int nColumns)
    {

        Label label = new Label(container, SWT.NULL);
        label.setText("&Source folder:");

        containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        containerText.setLayoutData(gd);
        containerText.addModifyListener(new ModifyListener()
        {
            public void modifyText(ModifyEvent e)
            {
                dialogChanged();
            }
        });

        Button button = new Button(container, SWT.PUSH);
        button.setText("Browse...");
        button.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                handleBrowse();
            }
        });
        label = new Label(container, SWT.NULL);
        label.setText("&File name:");

        fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        fileText.setLayoutData(gd);
        fileText.addModifyListener(new ModifyListener()
        {
            public void modifyText(ModifyEvent e)
            {
                filename = fileText.getText();
                dialogChanged();
            }
        });

        Label label2 = new Label(container, SWT.NONE);
        label2.setVisible(false);

        extensions = ExtensionManager.getInstance().getTemplateProviders();

        Logger.debugMSG("Creating extension controls");
        for (ITemplateProvider provider : extensions) {
            provider.createContentControls(getScriptFolder(), container);
        }

        initialize();
        dialogChanged();
        setControl(container);
    }

    /**
     * Tests if the current workbench selection is a suitable container to use.
     */

    private void initialize()
    {
        Logger.debugMSG("Initializing twig file wizard");

        if (selection != null && selection.isEmpty() == false
                && selection instanceof IStructuredSelection) {

            IStructuredSelection ssel = (IStructuredSelection) selection;

            if (ssel.size() > 1) {
                Logger.debugMSG("Selection container more than one elements.");
                return;
            }

            Object obj = ssel.getFirstElement();

            if (obj instanceof IScriptFolder) {

                Logger.debugMSG("Selection is scriptfolder");

                IScriptFolder folder = (IScriptFolder) obj;
                try {
                    String fullPath = folder.getUnderlyingResource().getFullPath().toString();
                    Logger.debugMSG("Setting container text to " + fullPath);
                    containerText.setText(fullPath);
                } catch (ModelException e) {
                    Logger.logException(e);
                }
            } else if (obj instanceof ProjectFragment) {

                IProjectFragment fragment = (IProjectFragment) obj;
                Logger.debugMSG("Selection is projectfragment");

                try {
                    String fullPath = fragment.getUnderlyingResource().getFullPath().toString();
                    Logger.debugMSG("Setting container text to " + fullPath);
                    containerText.setText(fullPath);
                } catch (ModelException e) {
                    Logger.logException(e);
                }

            } else if (obj instanceof IScriptProject) {
                IScriptProject proj = (IScriptProject) obj;
                Logger.debugMSG("Selection is scriptproject");
                containerText.setText(proj.getPath().toString());

            } else if (obj instanceof IFolder) {
                IFolder folder = (IFolder) obj;
                Logger.debugMSG("Selection is folder");
                containerText.setText(folder.getFullPath().toString());
            } else {
                Logger.debugMSG("Could not determine selection type");
                if (obj != null) {
                    Logger.debugMSG("type was " + obj.getClass());
                } else {
                    Logger.debugMSG("type was null");
                }
            }
        } else {
            Logger.debugMSG("File wizard couldn't retrieve selection");
        }

        Logger.debugMSG("Final container text: " + containerText.getText());

        fileText.setText("template.twig");
        fileText.forceFocus();
        fileText.setSelection(0, 8);

    }

    /**
     * Uses the standard container selection dialog to choose the new value for
     * the container field.
     */

    private void handleBrowse()
    {
        ContainerSelectionDialog dialog = new ContainerSelectionDialog(
                getShell(), ResourcesPlugin.getWorkspace().getRoot(), false,
                "Select new folder");
        if (dialog.open() == ContainerSelectionDialog.OK) {
            Object[] result = dialog.getResult();
            if (result.length == 1) {
                containerText.setText(((Path) result[0]).toString());
            }
        }
    }

    /**
     * Ensures that both text fields are set.
     */

    private void dialogChanged()
    {
        IResource container = ResourcesPlugin.getWorkspace().getRoot()
                .findMember(new Path(getContainerName()));
        String fileName = getFileName();

        if (getContainerName().length() == 0) {
            updateStatus("Folder must be specified");
            return;
        }
        if (container == null
                || (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
            updateStatus("Folder must exist");
            return;
        }
        if (!container.isAccessible()) {
            updateStatus("Project must be writable");
            return;
        }
        if (fileName.length() == 0) {
            updateStatus("File name must be specified");
            return;
        }
        if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
            updateStatus("File name must be valid");
            return;
        }
        // int dotLoc = fileName.lastIndexOf('.');
        // if (dotLoc != -1) {
        // String ext = fileName.substring(dotLoc + 1);
        // if (ext.equalsIgnoreCase("twig") == false) {
        // updateStatus("File extension must be \"twig\"");
        // return;
        // }
        // }
        updateStatus(new IStatus[]{new StatusInfo()});
    }

    private void updateStatus(String message)
    {
        setErrorMessage(message);
        setPageComplete(message == null);
    }

    public String getContainerName()
    {
        return getScriptFolderText();
    }

    public String getFileName()
    {
        return filename;
    }

    @Override
    protected String getPageTitle()
    {
        return "New Twig template";
    }

    @Override
    protected String getPageDescription()
    {
        return "Create a new twig template.";
    }

    @Override
    protected String getRequiredNature()
    {
        return TwigNature.NATURE_ID;
    }

    @Override
    protected String getFileContent(ISourceModule module) throws CoreException
    {

        if (extensions == null || extensions.size() == 0) {
            return "";
        }

        String content = "";

        for (ITemplateProvider provider : extensions) {
            content += provider.getContents();
        }
        return content;

    }
}
