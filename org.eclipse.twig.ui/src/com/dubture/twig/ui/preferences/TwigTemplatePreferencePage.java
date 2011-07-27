package org.eclipse.twig.ui.preferences;

import org.eclipse.php.internal.ui.IPHPHelpContextIds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.twig.ui.TwigUICorePlugin;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;


/**
 * 
 * {@link TwigTemplatePreferencePage} contributes a preference page
 * for twig code assist templates.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigTemplatePreferencePage extends TemplatePreferencePage {

	public TwigTemplatePreferencePage() {
		
		TwigUICorePlugin plugin = TwigUICorePlugin.getDefault();
		
		setPreferenceStore(plugin.getPreferenceStore());
		setTemplateStore(plugin.getTemplateStore());
		setContextTypeRegistry(plugin.getTemplateContextRegistry());

	}


	public void performHelp() {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), IPHPHelpContextIds.TEMPLATES_PREFERENCES);
		getControl().notifyListeners(SWT.Help, new Event());
    }	


}