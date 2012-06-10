/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.format;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Preferences;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.core.PHPCoreConstants;
import org.eclipse.php.internal.core.PHPCorePlugin;
import org.eclipse.php.internal.core.preferences.IPreferencesPropagatorListener;
import org.eclipse.php.internal.core.preferences.PreferencePropagatorFactory;
import org.eclipse.php.internal.core.preferences.PreferencesPropagator;
import org.eclipse.php.internal.core.preferences.PreferencesPropagatorEvent;
import org.eclipse.php.internal.core.preferences.PreferencesSupport;
import org.eclipse.wst.sse.core.StructuredModelManager;

import com.dubture.twig.core.documentModel.DOMModelForTwig;

@SuppressWarnings({"restriction", "deprecation"})
public class FormatPreferencesSupport
{

    private IDocument fLastDocument = null;
    private IProject fLastProject = null;

    private char indentationChar;
    private int indentationSize;

    private PreferencesSupport preferencesSupport = null;
    private PreferencesPropagatorListener listener = null;

    private boolean preferencesChanged = false;

    private PreferencesPropagator preferencesPropagator;

    private static final String NODES_QUALIFIER = PHPCorePlugin.ID;
    private static final Preferences store = PHPCorePlugin.getDefault()
            .getPluginPreferences();

    private FormatPreferencesSupport()
    {

        preferencesPropagator = PreferencePropagatorFactory
                .getPreferencePropagator(NODES_QUALIFIER, store);
        preferencesSupport = new PreferencesSupport(PHPCorePlugin.ID, store);
    }

    private static FormatPreferencesSupport instance = null;

    public static FormatPreferencesSupport getInstance()
    {
        if (instance == null) {
            instance = new FormatPreferencesSupport();
        }
        return instance;
    }

    public int getIndentationSize(IDocument document)
    {
        if (!verifyValidity(document)) {
            String indentSize = preferencesSupport
                    .getWorkspacePreferencesValue(PHPCoreConstants.FORMATTER_INDENTATION_SIZE);
            if (indentSize == null) {
                return 1;
            }
            return Integer.valueOf(indentSize).intValue();
        }
        return indentationSize;
    }

    public char getIndentationChar(IDocument document)
    {
        if (!verifyValidity(document)) {
            String useTab = preferencesSupport
                    .getWorkspacePreferencesValue(PHPCoreConstants.FORMATTER_USE_TABS);
            if (useTab == null) {
                return '\t';
            }
            return (Boolean.valueOf(useTab).booleanValue()) ? '\t' : ' ';
        }
        return indentationChar;
    }

    private boolean verifyValidity(IDocument document)
    {
        if (fLastDocument != document) {
            DOMModelForTwig editorModel = null;
            try {
                try {

                    editorModel = (DOMModelForTwig) StructuredModelManager
                            .getModelManager()
                            .getExistingModelForRead(document);

                } catch (ClassCastException e) {

                }

                // The PHPMergeViewer can be used outside Editor.
                // E.g. the preview page.
                // In those cases, the editroModel is null.
                // Do the check and return in null case.
                if (editorModel == null) {
                    return false;
                }

                String baseLocation = editorModel.getBaseLocation();
                // The baseLocation may be a path on disk or relative to the
                // workspace root. Don't translate on-disk paths to
                // in-workspace resources.
                IPath basePath = new Path(baseLocation);
                IFile file = null;
                if (basePath.segmentCount() > 1) {
                    file = ResourcesPlugin.getWorkspace().getRoot()
                            .getFile(basePath);
                    if (!file.exists()) {
                        file = null;
                    }
                }
                if (file == null) {
                    return false;
                }

                IProject project = file.getProject();
                if (fLastProject != project) {
                    fLastProject = project;
                    verifyListening();
                }
            } finally {
                if (editorModel != null)
                    editorModel.releaseFromRead();
            }
        }

        if (fLastDocument != document || preferencesChanged) {
            String useTab = preferencesSupport.getPreferencesValue(
                    PHPCoreConstants.FORMATTER_USE_TABS, null, fLastProject);
            String indentSize = preferencesSupport.getPreferencesValue(
                    PHPCoreConstants.FORMATTER_INDENTATION_SIZE, null,
                    fLastProject);

            indentationChar = (Boolean.valueOf(useTab).booleanValue())
                    ? '\t'
                    : ' ';
            indentationSize = Integer.valueOf(indentSize).intValue();

            preferencesChanged = false;
            fLastDocument = document;
        }
        return true;
    }

    private void verifyListening()
    {
        if (listener != null) {
            preferencesPropagator.removePropagatorListener(listener,
                    PHPCoreConstants.FORMATTER_USE_TABS);
            preferencesPropagator.removePropagatorListener(listener,
                    PHPCoreConstants.FORMATTER_INDENTATION_SIZE);
        }

        listener = new PreferencesPropagatorListener(fLastProject);
        preferencesPropagator.addPropagatorListener(listener,
                PHPCoreConstants.FORMATTER_USE_TABS);
        preferencesPropagator.addPropagatorListener(listener,
                PHPCoreConstants.FORMATTER_INDENTATION_SIZE);
    }

    private class PreferencesPropagatorListener implements
            IPreferencesPropagatorListener
    {

        private IProject project;

        public PreferencesPropagatorListener(IProject project)
        {
            this.project = project;
        }

        public void preferencesEventOccured(PreferencesPropagatorEvent event)
        {
            preferencesChanged = true;
        }

        public IProject getProject()
        {
            return project;
        }

    }

}
