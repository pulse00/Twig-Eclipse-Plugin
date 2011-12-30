/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.outline;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.php.internal.ui.PHPUiPlugin;
import org.eclipse.php.internal.ui.preferences.PreferenceConstants;

@SuppressWarnings("restriction")
public class ChangeOutlineModeAction extends Action
{

    private int mode;
    private TwigContentOutlineConfiguration contentOutlineConfiguration;
    private TreeViewer viewer;

    public ChangeOutlineModeAction(String label, int mode,
            TwigContentOutlineConfiguration contentOutlineConfiguration,
            TreeViewer viewer)
    {
        super(label, AS_RADIO_BUTTON); //$NON-NLS-1$
        this.mode = mode;
        this.contentOutlineConfiguration = contentOutlineConfiguration;
        this.viewer = viewer;
        int prefMode = PHPUiPlugin.getDefault().getPreferenceStore()
                .getInt(PreferenceConstants.PREF_OUTLINEMODE); //$NON-NLS-1$
        setChecked(prefMode == mode);
    }

    public void run()
    {

        contentOutlineConfiguration.setMode(mode);
        contentOutlineConfiguration.getContentProvider(viewer);
        contentOutlineConfiguration.getLabelProvider(viewer);
        viewer.refresh(false);
        PHPUiPlugin.getDefault().getPreferenceStore()
                .setValue(PreferenceConstants.PREF_OUTLINEMODE, mode);
    }

}
