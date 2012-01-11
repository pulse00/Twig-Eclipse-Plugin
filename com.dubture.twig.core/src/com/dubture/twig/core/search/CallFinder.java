/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core.search;

import org.eclipse.dltk.ast.ASTNode;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.ast.node.TwigCallExpression;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class CallFinder extends AbstractOccurrencesFinder
{

    private TwigCallExpression call;
    
    @Override
    public String initialize(TwigModuleDeclaration astRoot, ASTNode selectedNode)
    {
        this.astRoot = astRoot;
        if (selectedNode instanceof TwigCallExpression) {
            call = (TwigCallExpression) selectedNode;
            return null;
        }
        return "Twig call expression finder";
    }
    
    
    @Override
    public boolean visit(TwigCallExpression s) throws Exception
    {
        if (call == null || !call.getName().equals(s.getName())) {
            // let the visitor traverse deeper inside the call
            // as there might still be occurrences inside
            return true;
        }
        
        int length = s.getName().length();
        OccurrenceLocation location = new OccurrenceLocation(s.sourceStart(),
                length, 0, "occurrence of " + s.getName());
        locations.add(location);
        
        return false;
    }
}
