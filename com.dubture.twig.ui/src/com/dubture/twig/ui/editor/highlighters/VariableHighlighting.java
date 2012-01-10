/*
 * This file is part of the Twig Eclipse Plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.ui.editor.highlighters;

import com.dubture.twig.core.parser.ast.node.Variable;
import com.dubture.twig.ui.editor.highlighter.AbstractSemanticApply;
import com.dubture.twig.ui.editor.highlighter.AbstractSemanticHighlighting;

public class VariableHighlighting extends AbstractSemanticHighlighting
{
    protected class VariableApply extends AbstractSemanticApply
    {
        @Override
        public boolean visit(Variable var) throws Exception
        {
            highlight(var);
            return false;
        }
    }

    @Override
    public AbstractSemanticApply getSemanticApply()
    {
        return new VariableApply();
    }

    @Override
    public void initDefaultPreferences()
    {

    }

    @Override
    public String getDisplayName()
    {
        return "Variables";
    }
}
