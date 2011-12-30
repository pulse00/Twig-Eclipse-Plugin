/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.configuration;

import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;

/**
 * {@link TwigContributionContextTypeRegistry} returns the right contexttype
 * when php completions are requested in twig templates.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class TwigContributionContextTypeRegistry extends
        ContributionContextTypeRegistry
{

    @Override
    public TemplateContextType getContextType(String id)
    {

        // if (id.equals(PhpTemplateContextType.PHP_CONTEXT_TYPE_ID))
        // id = TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID;

        return super.getContextType(id);
    }

}
