/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.templates;

import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.templates.ScriptTemplateContext;
import org.eclipse.dltk.ui.templates.ScriptTemplateContextType;
import org.eclipse.jface.text.IDocument;

/**
 *  
 *  The {@link TwigTemplateContextType} provides access
 *  to the twig templates.
 *  
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigTemplateContextType extends ScriptTemplateContextType {
	
	public static final String TWIG_CONTEXT_TYPE_ID = "twig"; //$NON-NLS-1$
	
	public TwigTemplateContextType() {
		super();
	}
 
	public TwigTemplateContextType(String id, String name) {
		super(id, name);
	}
 
	public TwigTemplateContextType(String id) {
		super(id);
	}	
	
	@Override
	public ScriptTemplateContext createContext(IDocument document, int offset, int length, ISourceModule sourceModule) {

		return new TwigTemplateContext(this, document, offset, length, sourceModule);
	}

}
