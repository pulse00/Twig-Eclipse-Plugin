/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.model;

import org.eclipse.dltk.core.ISourceModule;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class Template {

	private ISourceModule sourceModule;

	public ISourceModule getSourceModule() {
		return sourceModule;
	}

	public Template(ISourceModule sourceModule) {
		this.sourceModule = sourceModule;
	}

}
