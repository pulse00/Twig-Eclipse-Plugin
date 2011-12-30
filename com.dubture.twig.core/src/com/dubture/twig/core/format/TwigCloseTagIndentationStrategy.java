/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.format;

import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;

@SuppressWarnings("restriction")
public class TwigCloseTagIndentationStrategy extends DefaultIndentationStrategy
{

    public void placeMatchingBlanks(final IStructuredDocument document,
            final StringBuffer result, final int lineNumber, final int forOffset)
    {
        // Ignore default behavior (don't add previous line's blanks)
    }

}
