/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.core.codeassist.ICompletionStrategy;
import org.eclipse.php.core.codeassist.ICompletionStrategyFactory;

import com.dubture.twig.core.codeassist.context.BlocknameContext;
import com.dubture.twig.core.codeassist.context.FilterContext;
import com.dubture.twig.core.codeassist.context.FunctionContext;
import com.dubture.twig.core.codeassist.context.KeywordContext;
import com.dubture.twig.core.codeassist.context.TagContext;
import com.dubture.twig.core.codeassist.context.TemplateVariablesContext;
import com.dubture.twig.core.codeassist.context.TestContext;
import com.dubture.twig.core.codeassist.context.VariableFieldContext;
import com.dubture.twig.core.codeassist.strategies.AbstractTwigCompletionStrategy;
import com.dubture.twig.core.codeassist.strategies.BlocknameStrategy;
import com.dubture.twig.core.codeassist.strategies.FilterStrategy;
import com.dubture.twig.core.codeassist.strategies.FunctionStrategy;
import com.dubture.twig.core.codeassist.strategies.KeywordStrategy;
import com.dubture.twig.core.codeassist.strategies.TagStrategy;
import com.dubture.twig.core.codeassist.strategies.TemplateVariablesStrategy;
import com.dubture.twig.core.codeassist.strategies.TestStrategy;
import com.dubture.twig.core.log.Logger;

/**
 * 
 * Factory for the twig completion strategies.
 * 
 * Calls the extensions which provide CompletionStrategies and merges them with
 * the internal twig strategies.
 * 
 * @see AbstractTwigCompletionStrategy
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
public class TwigCompletionStrategyFactory implements ICompletionStrategyFactory {

	private static final String STRATEGYFACTORY_ID = "com.dubture.twig.core.completionStrategyResolvers";

	@Override
	public ICompletionStrategy[] create(ICompletionContext[] contexts) {

		List<ICompletionStrategy> result = new LinkedList<ICompletionStrategy>();

		for (ICompletionContext context : contexts) {
			if (context.getClass() == KeywordContext.class) {
				result.add(new KeywordStrategy(context));
			} else if (context.getClass() == FilterContext.class) {
				result.add(new FilterStrategy(context));
			} else if (context.getClass() == VariableFieldContext.class) {
				// can't really do much in a plain twig context, this is the job
				// for extensions
				// result.add(new VariableFieldStrategy(context));
			} else if (context.getClass() == TemplateVariablesContext.class) {
				result.add(new TemplateVariablesStrategy(context));
			} else if (context.getClass() == FunctionContext.class) {
				result.add(new FunctionStrategy(context));
			} else if (context.getClass() == TagContext.class) {
				result.add(new TagStrategy(context));
			} else if (context.getClass() == TestContext.class) {
				result.add(new TestStrategy(context));
			} else if (context.getClass() == BlocknameContext.class) {
				result.add(new BlocknameStrategy(context));
			}
		}

		// load the strategies from extensions
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(STRATEGYFACTORY_ID);

		try {

			for (IConfigurationElement e : config) {

				final Object object = e.createExecutableExtension("class");

				if (object instanceof ITwigCompletionStrategyFactory) {
					ITwigCompletionStrategyFactory factory = (ITwigCompletionStrategyFactory) object;
					result.addAll(Arrays.asList(factory.create(contexts)));

				}
			}

		} catch (Exception e) {
			Logger.logException(e);
		}

		return (ICompletionStrategy[]) result.toArray(new ICompletionStrategy[result.size()]);

	}
}
