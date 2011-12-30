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
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.templates.TemplateContextType;

/**
 * Context for Twig code templates.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class TwigTemplateContext extends ScriptTemplateContext
{

    protected TwigTemplateContext(TemplateContextType type, IDocument document,
            int completionOffset, int completionLength,
            ISourceModule sourceModule)
    {
        super(type, document, completionOffset, completionLength, sourceModule);

    }

}
