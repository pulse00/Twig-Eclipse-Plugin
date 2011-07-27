package com.dubture.twig.ui.preferences;


import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.php.internal.ui.IPHPHelpContextIds;
import org.eclipse.php.internal.ui.preferences.AbstractPreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.PlatformUI;

import com.dubture.twig.ui.TwigUICorePlugin;

/**
 * 
 * Twig codeassist preference page.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigCodeassistPreferencePage extends AbstractPreferencePage {


	private Button autoclosePrintTags;
	private Button autocloseStatementTags;
	private Button autocreateStatementTags;


	public TwigCodeassistPreferencePage() {

		setPreferenceStore(TwigUICorePlugin.getDefault().getPreferenceStore());
		setDescription("Twig codeassist preferences"); //$NON-NLS-1$


	}
	
	protected void initializeValues() {
		
		super.initializeValues();
		IPreferenceStore store = TwigUICorePlugin.getDefault().getPreferenceStore();
		
		autoclosePrintTags.setSelection(store.getBoolean(PreferenceConstants.AUTOCLOSE_PRINT_TAGS));
		autocloseStatementTags.setSelection(store.getBoolean(PreferenceConstants.AUTOCLOSE_STATEMENT_TAGS));
		autocreateStatementTags.setSelection(store.getBoolean(PreferenceConstants.AUTOCREATE_STATEMENT_TAGS));
	}

	
	@Override
	protected Control createContents(Composite parent) {

		createMainBlock(parent);
		
		initializeValues();
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IPHPHelpContextIds.APPEARANCE_PREFERENCES);
		return null;		

	}
	
	protected void performDefaults() {
		
		IPreferenceStore store = DLTKUIPlugin.getDefault().getPreferenceStore();
		
		store.setValue(PreferenceConstants.AUTOCLOSE_PRINT_TAGS, true);
		store.setValue(PreferenceConstants.AUTOCLOSE_STATEMENT_TAGS, true);
		store.setValue(PreferenceConstants.AUTOCREATE_STATEMENT_TAGS, true);
		
		
		super.performDefaults();
	}

	
	public boolean performOk() {
		
		IPreferenceStore store = TwigUICorePlugin.getDefault().getPreferenceStore();
		
		store.setValue(PreferenceConstants.AUTOCLOSE_PRINT_TAGS,autoclosePrintTags.getSelection());
		store.setValue(PreferenceConstants.AUTOCLOSE_STATEMENT_TAGS,autocloseStatementTags.getSelection());
		store.setValue(PreferenceConstants.AUTOCREATE_STATEMENT_TAGS,autocreateStatementTags.getSelection());
		
		
		return super.performOk();
		
	}	

	private void createMainBlock(Composite parent) {

		
		Composite result = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = 0;
		layout.verticalSpacing = convertVerticalDLUsToPixels(10);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		result.setLayout(layout);

		Group doubleClickGroup = new Group(result, SWT.NONE);
		doubleClickGroup.setLayout(new GridLayout());
		doubleClickGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		doubleClickGroup
				.setText("Auto-close twig tags");
		

		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);

		autoclosePrintTags = new Button(doubleClickGroup, SWT.CHECK);
		autoclosePrintTags.setText("Print tags {{ }}"); //$NON-NLS-1$
		autoclosePrintTags.setLayoutData(gd);
		
		autocloseStatementTags = new Button(doubleClickGroup, SWT.CHECK);
		autocloseStatementTags.setText("Statement tags {% %}");
		autocloseStatementTags.setLayoutData(gd);
		
		
		autocreateStatementTags = new Button(doubleClickGroup, SWT.CHECK);
		autocreateStatementTags.setText("Autocreate Statements (%)");
		autocreateStatementTags.setLayoutData(gd);

	}



}