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
import org.eclipse.php.internal.core.util.text.TextSequence;

import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.util.text.TwigTextSequenceUtilities;

/**
 * 
 * Completion context for local template variables, ie:
 * 
 * 
 * <pre>
 * 
 * 	{% for user in users %}
 *     {{ |  <--- completes user and users
 * 
 * 
 * </pre>
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class TemplateVariablesContext extends AbstractTwigCompletionContext
{

    @SuppressWarnings("restriction")
    @Override
    public boolean isValid(ISourceModule sourceModule, int offset,
            CompletionRequestor requestor)
    {

        if (super.isValid(sourceModule, offset, requestor)) {

            try {

                if (getPartitionType() == TwigPartitionTypes.TWIG_QUOTED_STRING)
                    return false;

                TextSequence sequence = getStatementText();

                if (TwigTextSequenceUtilities.isInField(sequence)) {
                    return false;
                }

                return true;

            } catch (Exception e) {
                Logger.logException(e);
            }
        }
        return false;
    }
}
