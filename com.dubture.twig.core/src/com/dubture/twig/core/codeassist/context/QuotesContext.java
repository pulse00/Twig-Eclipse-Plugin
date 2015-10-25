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

import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;

/**
 * 
 * A context for staying inside a twig quotes string, ie
 * 
 * 
 * <pre>
 * 
 *   {{ path('|    <--- quotes context
 * 
 * </pre>
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class QuotesContext extends AbstractTwigCompletionContext {

	@Override
	public boolean isValid(IDocument template, int offset, IProgressMonitor monitor) {
		if (!super.isValid(template, offset, monitor)) {
			return false;
		}

		return getPartitionType() == TwigPartitionTypes.TWIG_QUOTED_STRING;
	}

}
