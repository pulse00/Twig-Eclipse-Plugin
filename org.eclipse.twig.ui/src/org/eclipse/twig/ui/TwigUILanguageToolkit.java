package org.eclipse.twig.ui;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.ui.AbstractDLTKUILanguageToolkit;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.twig.core.TwigLanguageToolkit;
import org.eclipse.twig.ui.preferences.PreferenceConstants;

public class TwigUILanguageToolkit extends AbstractDLTKUILanguageToolkit {

	@Override
	public IDLTKLanguageToolkit getCoreToolkit() {

		return TwigLanguageToolkit.getDefault();

	}

	@Override
	public IPreferenceStore getPreferenceStore() {

		return PreferenceConstants.getPreferenceStore();

	}

}
