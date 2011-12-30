/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.search;

import com.dubture.twig.core.parser.ITwigNodeVisitor;
import com.dubture.twig.core.parser.TwigCommonTree;

/**
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class OpenCloseTagFinder extends AbstractOccurrencesFinder
{

    @Override
    protected ITwigNodeVisitor getVisitor(int offset)
    {

        return new OpenCloseTagVisitor(offset);
    }

    private class OpenCloseTagVisitor implements ITwigNodeVisitor
    {

        private final int offset;
        private int nestCount = 0;

        public OpenCloseTagVisitor(int offset)
        {

            this.offset = offset;

        }

        @Override
        public void beginVisit(TwigCommonTree node)
        {

        }

        @Override
        public void endVisit(TwigCommonTree node)
        {

        }
    }
}
