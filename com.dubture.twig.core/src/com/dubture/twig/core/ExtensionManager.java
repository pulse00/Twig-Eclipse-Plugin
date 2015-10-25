/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.dubture.twig.core.codeassist.ITwigCompletionContextResolver;
import com.dubture.twig.core.codeassist.ITwigCompletionStrategyFactory;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.ITemplateResolver;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class ExtensionManager {

	public static final String TEMPLATE_RESOLVER_ID = "com.dubture.twig.core.templateResolvers"; //$NON-NLS-1$

	public static final String COMPLETION_CONTEXT_RESOLVERS = "com.dubture.twig.core.completionContextResolvers"; //$NON-NLS-1$

	public static final String COMPLETION_STRATEGY_RESOLVERS = "com.dubture.twig.core.completionStrategyResolvers"; //$NON-NLS-1$

	private static final String ATTR_CLASS = "class"; //$NON-NLS-1$

	private Map<String, Object[]> extensions = new HashMap<String, Object[]>();
	private static ExtensionManager instance = null;

	private ExtensionManager() {

	}

	private void initTemplateResolvers() {

		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(TEMPLATE_RESOLVER_ID);

		List<ITemplateResolver> resolvers = new LinkedList<ITemplateResolver>();

		try {
			for (IConfigurationElement e : config) {
				final Object object = e.createExecutableExtension(ATTR_CLASS);
				if (object instanceof ITemplateResolver) {
					ITemplateResolver provider = (ITemplateResolver) object;
					resolvers.add(provider);
				}
			}
		} catch (Exception e) {
			Logger.logException(e);
		}
		extensions.put(TEMPLATE_RESOLVER_ID, resolvers.toArray(new ITemplateResolver[resolvers.size()]));
	}

	private void initContextResolvers() {

		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(COMPLETION_CONTEXT_RESOLVERS);

		List<ITwigCompletionContextResolver> resolvers = new LinkedList<ITwigCompletionContextResolver>();

		try {
			for (IConfigurationElement e : config) {
				final Object object = e.createExecutableExtension(ATTR_CLASS);
				if (object instanceof ITwigCompletionContextResolver) {
					resolvers.add((ITwigCompletionContextResolver) object);
				} else {
					Logger.log(Logger.ERROR,
							"Invalid class for TwigCompletionContextResolvers : " + object.getClass().getName());
				}
			}
		} catch (Exception e) {
			Logger.logException(e);
		}
		extensions.put(COMPLETION_CONTEXT_RESOLVERS,
				resolvers.toArray(new ITwigCompletionContextResolver[resolvers.size()]));
	}

	private void initStrategyResolvers() {

		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(COMPLETION_STRATEGY_RESOLVERS);

		List<ITwigCompletionStrategyFactory> resolvers = new LinkedList<ITwigCompletionStrategyFactory>();

		try {
			for (IConfigurationElement e : config) {
				final Object object = e.createExecutableExtension(ATTR_CLASS);
				if (object instanceof ITwigCompletionStrategyFactory) {
					resolvers.add((ITwigCompletionStrategyFactory) object);
				} else {
					Logger.log(Logger.ERROR,
							"Invalid class for TwigCompletionStrategyResolvers : " + object.getClass().getName());
				}
			}
		} catch (Exception e) {
			Logger.logException(e);
		}
		extensions.put(COMPLETION_STRATEGY_RESOLVERS,
				resolvers.toArray(new ITwigCompletionStrategyFactory[resolvers.size()]));
	}

	public static ExtensionManager getInstance() {
		if (instance == null) {
			instance = new ExtensionManager();
		}

		return instance;
	}

	public ITemplateResolver[] getTemplateProviders() {
		if (!extensions.containsKey(TEMPLATE_RESOLVER_ID)) {
			initTemplateResolvers();
		}
		return (ITemplateResolver[]) extensions.get(TEMPLATE_RESOLVER_ID);
	}

	public ITwigCompletionContextResolver[] getCompletionContextResolvers() {
		if (!extensions.containsKey(COMPLETION_CONTEXT_RESOLVERS)) {
			initContextResolvers();
		}
		return (ITwigCompletionContextResolver[]) extensions.get(COMPLETION_CONTEXT_RESOLVERS);
	}

	public ITwigCompletionStrategyFactory[] getCompletionStrategyResolvers() {
		if (!extensions.containsKey(COMPLETION_STRATEGY_RESOLVERS)) {
			initStrategyResolvers();
		}
		return (ITwigCompletionStrategyFactory[]) extensions.get(COMPLETION_STRATEGY_RESOLVERS);
	}

}
