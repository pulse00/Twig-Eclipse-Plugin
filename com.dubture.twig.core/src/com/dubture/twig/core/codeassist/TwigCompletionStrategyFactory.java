/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist;

import java.util.LinkedList;
import java.util.List;

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
public class TwigCompletionStrategyFactory implements ITwigCompletionStrategyFactory {

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

		return result.toArray(new ICompletionStrategy[result.size()]);
	}
}
