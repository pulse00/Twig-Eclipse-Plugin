package org.eclipse.twig.ui.editor;



import org.eclipse.php.internal.ui.editor.ActionContributorForPhp;

/**
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class ActionContributorForTwig extends ActionContributorForPhp {
	
	private static final String[] EDITOR_IDS = {
		"org.eclipse.twig.core.twigtemplate", "org.eclipse.wst.sse.ui.StructuredTextEditor" }; //$NON-NLS-1$ //$NON-NLS-2$
	
	
	protected String[] getExtensionIDs() {
		return EDITOR_IDS;
	}	

}
