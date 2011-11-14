/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.preferences;

import org.eclipse.php.internal.ui.IPHPHelpContextIds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.templates.TemplatePreferencePage;

import com.dubture.twig.ui.TwigUICorePlugin;


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
