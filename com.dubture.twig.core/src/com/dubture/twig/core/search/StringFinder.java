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

import com.dubture.twig.core.parser.ast.node.StringLiteral;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.search.IOccurrencesFinder.OccurrenceLocation;

/**
 * 
 * Finds String occurrences.
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class StringFinder extends AbstractOccurrencesFinder
{
    
    private StringLiteral string;

    @Override
    public String initialize(TwigModuleDeclaration astRoot, ASTNode selectedNode)
    {
        this.astRoot = astRoot;
        
        if (selectedNode instanceof StringLiteral) {
            string = (StringLiteral) selectedNode;
            return null;
        }
        
        return "Find string occurrences";
    }
    
    @Override
    public boolean visit(StringLiteral s) throws Exception
    {
        if (astRoot == null || string == null || !string.getValue().equals(s.getValue())) {
            return false;
        }
        
        int length = s.sourceEnd() - s.sourceStart();
        OccurrenceLocation location = new OccurrenceLocation(s.sourceStart(),
                length, 0, "occurrence of " + s.getValue());
        locations.add(location);
        return false;
        
    }
}
