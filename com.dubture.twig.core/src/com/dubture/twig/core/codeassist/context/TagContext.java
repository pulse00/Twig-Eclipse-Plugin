/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;

/**
 * 
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class TagContext extends KeywordContext {

	@Override
	public boolean isValid(ISourceModule sourceModule, int offset, CompletionRequestor requestor) {

		if (super.isValid(sourceModule, offset, requestor)) {

			// TODO: check if we're in a {% %} statement region

			return true;

		}

		return false;
	}

}
