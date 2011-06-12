package org.eclipse.twig.ui.preferences;

import org.eclipse.php.internal.ui.IPHPHelpContextIds;
import org.eclipse.php.internal.ui.preferences.AbstractPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;


/**
 * 
 * The preference page for the Twig editor.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigEditorPreferencePage extends AbstractPreferencePage {

	public TwigEditorPreferencePage() {

	}

	@Override
	protected Control createContents(Composite parent) {

		createHeader(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IPHPHelpContextIds.EDITOR_PREFERENCES);
		return super.createContents(parent);		

	}

	private void createHeader(Composite contents) {
		final Shell shell = contents.getShell();
		String text = "Twig editor preferences. Note that some preferences may be set on the <a>PHP Editors</a> preference page.";
		Link link = new Link(contents, SWT.NONE);
		link.setText(text);
		link.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				PreferencesUtil.createPreferenceDialogOn(shell, "org.eclipse.php.ui.preferences.PHPEditorPreferencePage", null, null); //$NON-NLS-1$
			}
		});
		// TODO replace by link-specific tooltips when
		// bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=88866 gets fixed
		link.setToolTipText("Show the shared php editor preferences");

		GridData gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		gridData.widthHint = 150; // only expand further if anyone else requires it
		link.setLayoutData(gridData);
	}	

}
