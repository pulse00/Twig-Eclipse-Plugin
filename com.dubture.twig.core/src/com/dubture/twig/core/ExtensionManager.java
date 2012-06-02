/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.ITemplateResolver;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class ExtensionManager
{
    
    public static final String TEMPLATE_RESOLVER_ID = "com.dubture.twig.core.templateResolvers";
    
    private Map<String, List<?>> extensions = new HashMap<String, List<?>>();
    private static ExtensionManager instance = null;
    
    private ExtensionManager()
    {
        initResolvers();
    }
    
    private void initResolvers()
    {
        
        IConfigurationElement[] config = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(TEMPLATE_RESOLVER_ID);
        
        ArrayList<ITemplateResolver> resolvers = new ArrayList<ITemplateResolver>();

        try {
            for (IConfigurationElement e : config) {
                final Object object = e.createExecutableExtension("class");
                if (object instanceof ITemplateResolver) {
                    ITemplateResolver provider = (ITemplateResolver) object;
                    resolvers.add(provider);
                }
            }
        } catch (Exception e) {
            Logger.logException(e);
        }
        
        extensions.put(TEMPLATE_RESOLVER_ID, resolvers);
        
    }
    
    public static ExtensionManager getInstance()
    {
        if (instance == null) {
            instance = new ExtensionManager();
        }
        
        return instance;
    }
    
    @SuppressWarnings("unchecked")
    public List<ITemplateResolver> getProposalExtensions()
    {
        return (List<ITemplateResolver>) extensions.get(TEMPLATE_RESOLVER_ID);
    }

    @SuppressWarnings("unchecked")
    public List<ITemplateResolver> getTemplateProviders()
    {
        if (extensions.containsKey(TEMPLATE_RESOLVER_ID)) {
            return (List<ITemplateResolver>) extensions.get(TEMPLATE_RESOLVER_ID);
        }
        
        IConfigurationElement[] config = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(TEMPLATE_RESOLVER_ID);
        
         ArrayList<ITemplateResolver> providers = new ArrayList<ITemplateResolver>();

        try {
            for (IConfigurationElement e : config) {
                final Object object = e.createExecutableExtension("class");
                if (object instanceof ITemplateResolver) {
                    ITemplateResolver provider = (ITemplateResolver) object;
                    providers.add(provider);
                }
            }
        } catch (Exception e) {
            Logger.logException(e);
        }

        extensions.put(TEMPLATE_RESOLVER_ID, providers);
        return providers;
    } 

}
