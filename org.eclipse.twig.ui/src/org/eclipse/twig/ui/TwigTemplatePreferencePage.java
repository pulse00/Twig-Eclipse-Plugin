package org.eclipse.twig.ui;

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
public class TwigTemplatePreferencePage extends TemplatePreferencePage {

	public TwigTemplatePreferencePage() {
		
		TwigUICorePlugin plugin = TwigUICorePlugin.getDefault();
		
		setPreferenceStore(plugin.getPreferenceStore());
		setTemplateStore(plugin.getTemplateStore());
		setContextTypeRegistry(plugin.getTemplateContextRegistry());

	}
	


}