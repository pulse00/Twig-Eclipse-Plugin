/*
 * This file is part of the Twig Eclipse Plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;

import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import com.dubture.twig.core.log.Logger;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class BlocknameContext extends AbstractTwigCompletionContext
{

    /* (non-Javadoc)
     * @see com.dubture.twig.core.codeassist.context.AbstractTwigCompletionContext#isValid(org.eclipse.dltk.core.ISourceModule, int, org.eclipse.dltk.core.CompletionRequestor)
     */
    @Override
    public boolean isValid(ISourceModule sourceModule, int offset,
            CompletionRequestor requestor)
    {
        if (super.isValid(sourceModule, offset, requestor) == false) {
            return false;
        }
        
        try {
            if (getPartitionType() == TwigPartitionTypes.TWIG_QUOTED_STRING) {
                return false;
            }

            String prefix = getStatementText().toString();

            if (!prefix.contains(".") && !prefix.contains("\"")
                    && !prefix.contains("'")) {
                
                String previous = getPreviousWord();
                
                if (previous == null || "block".equals(previous) == false) {
                    return false;
                }
                
                return true;
            }
            
        } catch (Exception e) {
            Logger.logException(e);
        }
        
        return false;
    }
}
