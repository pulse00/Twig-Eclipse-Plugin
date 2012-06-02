/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.editor.contentassist.ICompletionProposalProvider;
import com.dubture.twig.ui.wizards.ITemplateProvider;

/**
 * Manages plugin extensions.
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class ExtensionManager
{
    public static final String PROPOSAL_PROVIDER_ID = "com.dubture.twig.ui.completionProposalProvider";
    public static final String TEMPLATE_PROVIDER_ID = "com.dubture.twig.ui.templateProvider";
    
    private Map<String, List<?>> extensions = new HashMap<String, List<?>>();
    private static ExtensionManager instance = null;
    
    private ExtensionManager()
    {
        initProposals();
    }
    
    private void initProposals()
    {
        
        IConfigurationElement[] config = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(PROPOSAL_PROVIDER_ID);
        
        ArrayList<ICompletionProposalProvider> proposals = new ArrayList<ICompletionProposalProvider>();

        try {
            for (IConfigurationElement e : config) {
                final Object object = e.createExecutableExtension("class");
                if (object instanceof ICompletionProposalProvider) {
                    ICompletionProposalProvider provider = (ICompletionProposalProvider) object;
                    proposals.add(provider);
                }
            }
        } catch (Exception e) {
            Logger.logException(e);
        }
        
        extensions.put(PROPOSAL_PROVIDER_ID, proposals);
        
    }
    
    public static ExtensionManager getInstance()
    {
        if (instance == null) {
            instance = new ExtensionManager();
        }
        
        return instance;
    }
    
    @SuppressWarnings("unchecked")
    public List<ICompletionProposalProvider> getProposalExtensions()
    {
        return (List<ICompletionProposalProvider>) extensions.get(PROPOSAL_PROVIDER_ID);
    }

    @SuppressWarnings("unchecked")
    public List<ITemplateProvider> getTemplateProviders()
    {
        if (extensions.containsKey(TEMPLATE_PROVIDER_ID)) {
            return (List<ITemplateProvider>) extensions.get(TEMPLATE_PROVIDER_ID);
        }
        
        IConfigurationElement[] config = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(TEMPLATE_PROVIDER_ID);
        
         ArrayList<ITemplateProvider> providers = new ArrayList<ITemplateProvider>();

        try {
            for (IConfigurationElement e : config) {
                final Object object = e.createExecutableExtension("class");
                if (object instanceof ITemplateProvider) {
                    ITemplateProvider provider = (ITemplateProvider) object;
                    providers.add(provider);
                }
            }
        } catch (Exception e) {
            Logger.logException(e);
        }

        extensions.put(TEMPLATE_PROVIDER_ID, providers);
        return providers;
    }
}
