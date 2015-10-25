/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.model;

import org.eclipse.dltk.core.IScriptProject;

public interface ITwigModelElement {

	int START_TAG = 800;
	int END_TAG = 801;
	int FILTER = 802;
	int FUNCTION = 803;
	int TEST = 804;
	int BLOCK = 805;
	int EXTENDS = 806;
	int TAG = 807;

	public String getElementName();

	public int getKind();

	public String getPhpClass();

	public String getDescription();

	public IScriptProject getScriptProject();
}
