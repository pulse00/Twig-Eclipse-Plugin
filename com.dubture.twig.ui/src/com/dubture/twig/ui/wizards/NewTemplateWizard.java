/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.wizards;

import org.eclipse.dltk.ui.wizards.NewSourceModulePage;
import org.eclipse.dltk.ui.wizards.NewSourceModuleWizard;

import com.dubture.twig.ui.TwigPluginImages;

/**
 * 
 */
public class NewTemplateWizard extends NewSourceModuleWizard
{

    public NewTemplateWizard()
    {
        setDefaultPageImageDescriptor(TwigPluginImages.DESC_WIZBAN_ADD_TWIG_FILE);       
    }
    
    @Override
    protected NewSourceModulePage createNewSourceModulePage()
    {
        return new TwigNewFileWizardPage(getSelection());        
    }
}
