package org.eclipse.twig.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.twig.ui.PreferenceConstants;
import org.eclipse.ui.editors.text.EditorsUI;

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
