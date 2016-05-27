/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.editors.text.EditorsUI;

/**
 * 
 * {@link TwigPreferenceInitializer} inserts default values in the
 * {@link IPreferenceStore} during startup.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class TwigPreferenceInitializer extends AbstractPreferenceInitializer {

	public TwigPreferenceInitializer() {

	}

	@Override
	public void initializeDefaultPreferences() {

		IPreferenceStore store = PreferenceConstants.getPreferenceStore();
		EditorsUI.useAnnotationsPreferencePage(store);
		EditorsUI.useQuickDiffPreferencePage(store);

		PreferenceConstants.initializeDefaultValues();

	}

}
