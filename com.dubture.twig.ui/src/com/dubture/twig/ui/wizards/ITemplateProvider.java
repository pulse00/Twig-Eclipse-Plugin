package com.dubture.twig.ui.wizards;

import org.eclipse.dltk.core.IScriptFolder;
import org.eclipse.swt.widgets.Composite;

public interface ITemplateProvider
{

    void createContentControls(IScriptFolder iScriptFolder, Composite container);
    
    String getContents();

}
