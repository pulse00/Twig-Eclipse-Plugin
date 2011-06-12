package org.eclipse.twig.ui.editor.templates;

import org.eclipse.dltk.ui.templates.ScriptTemplateAccess;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.twig.ui.TwigUICorePlugin;


/**
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigTemplateAccess extends ScriptTemplateAccess {
	
	private static final String CUSTOM_TEMPLATES_KEY = "org.eclipse.twig.Templates"; //$NON-NLS-1$
	
	
	private static TwigTemplateAccess instance;

	public static TwigTemplateAccess getInstance() {
		if (instance == null) {
			instance = new TwigTemplateAccess();
		}

		System.err.println("get access instance");
		return instance;
	}
	
	

	@Override
	protected String getContextTypeId() {
		
		System.err.println("get context type id");
		return TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID;
	}

	@Override
	protected String getCustomTemplatesKey() {
		
		System.err.println("custom template key");

		return CUSTOM_TEMPLATES_KEY;
	}

	@Override
	protected IPreferenceStore getPreferenceStore() {

		
		System.err.println("get pref store");
		return TwigUICorePlugin.getDefault().getPreferenceStore();
	}

}
