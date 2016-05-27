/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.wizards;

import org.eclipse.dltk.core.IScriptFolder;
import org.eclipse.swt.widgets.Composite;

public interface ITemplateProvider {

	void createContentControls(IScriptFolder iScriptFolder, Composite container);

	String getContents();

}
