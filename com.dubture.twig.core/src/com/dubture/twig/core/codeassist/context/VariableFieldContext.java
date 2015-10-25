/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist.context;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.core.util.text.TextSequence;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.util.text.TwigTextSequenceUtilities;

/**
 *
 * A {@link VariableFieldContext} detects completion of twig variables:
 *
 * <pre>
 *
 * {{ user.|
 *
 * </pre>
 *
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class VariableFieldContext extends AbstractTwigCompletionContext {

	private String variable = null;

	public String getVariable() {

		return variable;

	}

	@Override
	public boolean isValid(IDocument template, int offset, IProgressMonitor monitor) {
		if (!super.isValid(template, offset, monitor)) {
			return false;
		}

		try {

			TextSequence statement = getStatementText();

			if (TwigTextSequenceUtilities.isInField(statement)) {

				variable = TwigTextSequenceUtilities.getVariable(statement);
				return true;
			}

			return true;

		} catch (Exception e) {
			Logger.logException(e);
		}
		return false;
	}
}
