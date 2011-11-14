/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.preferences;


import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.php.internal.ui.IPHPHelpContextIds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;

import com.dubture.twig.core.TwigCoreConstants;
import com.dubture.twig.core.TwigCorePlugin;
import com.dubture.twig.ui.TwigUICorePlugin;


/**
 * 
 * The preference page for the Twig editor.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigEditorPreferencePage extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	
	public TwigEditorPreferencePage() {
		
		super(GRID);
		setPreferenceStore(TwigUICorePlugin.getDefault().getPreferenceStore());
		

	}

	@Override
	protected Control createContents(Composite parent) {

		
		createHeader(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IPHPHelpContextIds.EDITOR_PREFERENCES);		

		
		return super.createContents(parent);

	}
	
	
	

	private void createHeader(Composite contents) {
		
		
		final Shell shell = contents.getShell();
		String text = Messages.TwigEditorPreferencePage_0;
		Link link = new Link(contents, SWT.NONE);
		link.setText(text);
		link.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				PreferencesUtil.createPreferenceDialogOn(shell, "org.eclipse.php.ui.preferences.PHPEditorPreferencePage", null, null); //$NON-NLS-1$
			}
		});
		// TODO replace by link-specific tooltips when
		// bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=88866 gets fixed
		link.setToolTipText(Messages.TwigEditorPreferencePage_1);

		GridData gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
		gridData.widthHint = 150; // only expand further if anyone else requires it
		link.setLayoutData(gridData);
	}

	@Override
	public void init(IWorkbench workbench) {

		
	}

	@Override
	protected void createFieldEditors() {

		String[][] options;		
		
		// ProblemSeverity does not work in dltk < 3
		// so we disable it
		if (!TwigCorePlugin.getDefault().isDLTK3()) {
			
			MessageDialog.openWarning(getShell(), Messages.TwigEditorPreferencePage_2, Messages.TwigEditorPreferencePage_3);
			options = new String[][] 
					{ 
							{ TwigCoreConstants.SYNTAX_IGNORE, TwigCoreConstants.SYNTAX_IGNORE },				
					};			
			
		} else {
			options = new String[][] 
					{ 
							{ TwigCoreConstants.SYNTAX_ERROR, TwigCoreConstants.SYNTAX_ERROR }, 
							{ TwigCoreConstants.SYNTAX_WARNING, TwigCoreConstants.SYNTAX_WARNING },
							{ TwigCoreConstants.SYNTAX_IGNORE, TwigCoreConstants.SYNTAX_IGNORE },				
					};			
		}
		

		addField(new ComboFieldEditor(TwigCoreConstants.SYNTAX_PROBLEM_SEVERITY, Messages.TwigEditorPreferencePage_4, options, getFieldEditorParent()));		
		
	}
}
