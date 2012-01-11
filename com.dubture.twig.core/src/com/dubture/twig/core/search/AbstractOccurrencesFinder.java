/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.php.internal.core.search.IOccurrencesFinder.OccurrenceLocation;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.parser.ast.visitor.TwigASTVisitor;

/**
 * 
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
abstract public class AbstractOccurrencesFinder extends TwigASTVisitor
        implements IOccurrencesFinder
{

    protected List<OccurrenceLocation> locations = new ArrayList<OccurrenceLocation>();
    protected TwigModuleDeclaration astRoot;
    protected ASTNode selectedNode;
    
    public String initialize(TwigModuleDeclaration astRoot, ASTNode selectedNode)
    {
        
        this.astRoot = astRoot;
        this.selectedNode = selectedNode;
        return null;
    }

    @Override
    public OccurrenceLocation[] getOccurrences()
    {
        locations = new ArrayList<OccurrenceLocation>();
        findOccurrences();
        if (locations.isEmpty())
            return null;

        return locations.toArray(new OccurrenceLocation[locations.size()]);

    }
    
    protected void findOccurrences()
    {
        try {
            if (astRoot != null) {
                astRoot.traverse(this);    
            }
        } catch (Exception e) {
            Logger.logException(e);
        }
    }
}
