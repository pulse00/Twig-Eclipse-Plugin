/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.statements.Statement;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class InLineHtml extends Statement
{

    /**
     * @param htmlleft
     * @param htmlright
     */
    public InLineHtml(int htmlleft, int htmlright)
    {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see org.eclipse.dltk.ast.statements.Statement#getKind()
     */
    @Override
    public int getKind()
    {
        // TODO Auto-generated method stub
        return 0;
    }

}
