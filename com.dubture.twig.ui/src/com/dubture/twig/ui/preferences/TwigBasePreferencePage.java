/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.preferences;

import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PreferencesUtil;

/**
 * The base Twig preference page.
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 */
public class TwigBasePreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

	public TwigBasePreferencePage() {
		super();
		setPreferenceStore(DLTKUIPlugin.getDefault().getPreferenceStore());
		setDescription("Code Formatting:");
	}

	@Override
	public void init(IWorkbench workbench) {

	}

	@Override
	protected Control createContents(Composite parent) {

		initializeDialogUnits(parent);

		Composite result = new Composite(parent, SWT.NONE);
		GridLayout layout = GridLayoutFactory.fillDefaults().numColumns(1).create();
		result.setLayout(layout);

		Link link = new Link(result, SWT.WRAP);
		link.setText(
				"The Twig Editor shares its settings with the PHP formatter options. See the PHP <a>Code Style</a> preference page to configure it.");
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String id = "org.eclipse.php.ui.preferences.PHPFormatterPreferencePage";
				PreferenceDialog preferenceDialog = PreferencesUtil.createPreferenceDialogOn(getShell(), id,
						new String[] {}, null);
				preferenceDialog.open();
			}
		});

		GridDataFactory.fillDefaults().grab(true, false).hint(400, SWT.DEFAULT).applyTo(link);

		return result;
	}
}
