/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.contentassist;

import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposal;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposal;
import org.eclipse.swt.graphics.Image;

/**
 * A {@link ScriptCompletionProposal} for Symfony routes.
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
@SuppressWarnings("restriction")
public class EmptyCompletionProposal extends PHPCompletionProposal
{

    public EmptyCompletionProposal(String replacementString,
            int replacementOffset, int replacementLength, Image image,
            String displayString, int relevance)
    {
        super(replacementString, replacementOffset, replacementLength, image,
                displayString, relevance);

    }

    @Override
    public String getAdditionalProposalInfo()
    {

        return "";
    }

}
