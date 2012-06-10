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

import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.parser.ast.node.Variable;

/**
 * Finds variable occurrences in a twig template.
 */
public class VariableFinder extends AbstractOccurrencesFinder
{
    private Variable selected = null;

    @Override
    public String initialize(TwigModuleDeclaration astRoot, ASTNode selectedNode)
    {
        this.astRoot = astRoot;
        if (selectedNode instanceof Variable) {
            selected = (Variable) selectedNode;
            return null;
        }

        return "Variable finder"; //$NON-NLS-1$;

    }

    @Override
    public boolean visit(Variable s) throws Exception
    {
        if (selected == null || !selected.getValue().equals(s.getValue())) {
            return false;
        }

        int length = s.sourceEnd() - s.sourceStart();
        OccurrenceLocation location = new OccurrenceLocation(s.sourceStart(),
                length, 0, "occurrence of " + s.getValue());
        locations.add(location);
        return false;
    }
}
