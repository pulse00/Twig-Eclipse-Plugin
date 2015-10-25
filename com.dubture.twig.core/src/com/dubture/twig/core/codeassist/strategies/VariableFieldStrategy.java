/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist.strategies;

import com.dubture.twig.core.codeassist.ICompletionContext;
import com.dubture.twig.core.codeassist.ICompletionReporter;
import com.dubture.twig.core.codeassist.context.VariableFieldContext;

/**
 * 
 * 
 * @see VariableFieldContext
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
public class VariableFieldStrategy extends AbstractTwigCompletionStrategy {

	public VariableFieldStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		// VariableFieldContext ctx = (VariableFieldContext) getContext();

	}
}
