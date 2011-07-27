package org.eclipse.twig.ui;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.ui.AbstractDLTKUILanguageToolkit;
import org.eclipse.dltk.ui.IDLTKUILanguageToolkit;
import org.eclipse.dltk.ui.ScriptElementLabels;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.twig.core.TwigLanguageToolkit;
import org.eclipse.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;

public class TwigUILanguageToolkit extends AbstractDLTKUILanguageToolkit {

	private static TwigUILanguageToolkit sToolkit = new TwigUILanguageToolkit();

	public static IDLTKUILanguageToolkit getInstance() {
		return sToolkit;
	}

	public IDLTKLanguageToolkit getCoreToolkit() {
		return TwigLanguageToolkit.getDefault();
	}

	public IPreferenceStore getPreferenceStore() {
		return TwigUICorePlugin.getDefault().getPreferenceStore();
	}

	public String getPartitioningId() {
		return TwigPartitionTypes.TWIG_DEFAULT;
	}

	public String getEditorId(Object inputElement) {
		return "org.eclipse.twig.editor";
	}

	

}