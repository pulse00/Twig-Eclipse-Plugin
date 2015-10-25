/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;

import com.dubture.twig.core.codeassist.context.AbstractTwigCompletionContext;
import com.dubture.twig.core.codeassist.context.BlocknameContext;
import com.dubture.twig.core.codeassist.context.FilterContext;
import com.dubture.twig.core.codeassist.context.FunctionContext;
import com.dubture.twig.core.codeassist.context.KeywordContext;
import com.dubture.twig.core.codeassist.context.QuotesContext;
import com.dubture.twig.core.codeassist.context.TagContext;
import com.dubture.twig.core.codeassist.context.TemplateVariablesContext;
import com.dubture.twig.core.codeassist.context.TestContext;
import com.dubture.twig.core.codeassist.context.VariableFieldContext;

/**
 * 
 * Factory for the {@link ICompletionContext}.
 * 
 * 
 * Collects CompletionContexts from extension points and merges them to the
 * internal ones.
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
public class TwigCompletionContextResolver implements ITwigCompletionContextResolver {

	public TwigCompletionContextResolver() {
	}

	@Override
	public ICompletionContext[] createContexts(IProject project) {

		List<ICompletionContext> contexts = new ArrayList<ICompletionContext>();

		contexts.add(new AbstractTwigCompletionContext());
		contexts.add(new KeywordContext());
		contexts.add(new FilterContext());
		contexts.add(new VariableFieldContext());
		contexts.add(new TemplateVariablesContext());
		contexts.add(new QuotesContext());
		contexts.add(new FunctionContext());
		contexts.add(new TagContext());
		contexts.add(new TestContext());
		contexts.add(new BlocknameContext());

		return contexts.toArray(new ICompletionContext[contexts.size()]);

	}
}
