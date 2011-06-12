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

		return instance;
	}
	
	

	@Override
	protected String getContextTypeId() {
		
		return TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID;
	}

	@Override
	protected String getCustomTemplatesKey() {
		
		return CUSTOM_TEMPLATES_KEY;
		
	}

	@Override
	protected IPreferenceStore getPreferenceStore() {

		return TwigUICorePlugin.getDefault().getPreferenceStore();
	}

}
