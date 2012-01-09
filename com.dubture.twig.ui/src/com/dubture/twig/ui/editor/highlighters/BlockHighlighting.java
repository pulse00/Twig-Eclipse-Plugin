package com.dubture.twig.ui.editor.highlighters;

import org.eclipse.php.internal.ui.editor.highlighter.AbstractSemanticApply;

@SuppressWarnings("restriction")
public class BlockHighlighting extends AbstractSemanticHighlighting
{

    @Override
    public AbstractSemanticApply getSemanticApply()
    {
        return null;
    }

    @Override
    public void initDefaultPreferences()
    {
        
    }

    @Override
    public String getDisplayName()
    {
        return "Blocks";
    }

}
