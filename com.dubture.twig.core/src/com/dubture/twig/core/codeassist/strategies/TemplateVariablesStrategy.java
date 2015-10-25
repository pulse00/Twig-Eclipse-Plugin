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

/**
 * 
 * Completes local variables in templates
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings({ "restriction", "deprecation" })
public class TemplateVariablesStrategy extends AbstractTwigCompletionStrategy {

	public TemplateVariablesStrategy(ICompletionContext context) {
		super(context);

	}

	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		// ICompletionContext context = getContext();
		// AbstractTwigCompletionContext abstractContext =
		// (AbstractTwigCompletionContext) context;
		// String prefix = abstractContext.getPrefix();
		//
		// IField[] fields =
		// PHPModelUtils.getFileFields(abstractContext.getSourceModule(),
		// prefix, false, null);
		//
		// SourceRange replaceRange = getReplacementRange(context);
		//
		// for (IModelElement var : fields) {
		// if (CodeAssistUtils.startsWithIgnoreCase(var.getElementName(),
		// prefix))
		// reporter.reportField((IField) var, "", replaceRange, false);
		// }

	}
}
