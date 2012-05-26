package com.dubture.twig.ui.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.editor.contentassist.ICompletionProposalProvider;

public class ExtensionManager
{
    
    public static final String PROPOSAL_PROVIDER_ID = "com.dubture.twig.ui.completionProposalProvider";
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
    
}
