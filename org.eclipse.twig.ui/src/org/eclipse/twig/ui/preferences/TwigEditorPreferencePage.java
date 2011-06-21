package org.eclipse.twig.ui.preferences;


import org.eclipse.core.runtime.Platform;
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
import org.eclipse.twig.core.TwigCoreConstants;
import org.eclipse.twig.core.TwigCorePlugin;
import org.eclipse.twig.ui.TwigUICorePlugin;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
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

	@Override
	public void init(IWorkbench workbench) {

		
	}

	@Override
	protected void createFieldEditors() {

		String[][] options;		
		
		// ProblemSeverity does not work in dltk < 3
		// so we disable it
		if (!TwigCorePlugin.getDefault().isDLTK3()) {
			
			MessageDialog.openWarning(getShell(), "Twig Warning", "Your eclipse version is not compatible with the validation API the Twig-Plugin uses. Please upgrade to Eclipse 3.7 or install DLTK 3.0");
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
		

		addField(new ComboFieldEditor(TwigCoreConstants.SYNTAX_PROBLEM_SEVERITY, "Syntax Errors", options, getFieldEditorParent()));		
		
	}
}