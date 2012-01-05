/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.parser;

import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.core.IModelElement;

import com.dubture.twig.core.index.ITwigElementRequestor.BlockInfo;
import com.dubture.twig.core.model.TwigModelAccess;

/**
 * 
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
public class TwigIndexingVisitor 
{

    private IElementRequestor requestor;
    private int offset;

    private BlockInfo block = null;
    private TwigModelAccess model = TwigModelAccess.getDefault();

    private IModelElement modelElement;

    public TwigIndexingVisitor(IElementRequestor requestor, int offset,
            IModelElement modelElement)
    {

        this.requestor = requestor;
        this.offset = offset;
        this.modelElement = modelElement;
    }


}
