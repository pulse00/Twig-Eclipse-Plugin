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
public class QuotesContext extends AbstractTwigCompletionContext
{

    @Override
    public boolean isValid(ISourceModule sourceModule, int offset,
            CompletionRequestor requestor)
    {

        if (super.isValid(sourceModule, offset, requestor)) {

            return getPartitionType() == TwigPartitionTypes.TWIG_QUOTED_STRING;

        }

        return false;
    }

}
