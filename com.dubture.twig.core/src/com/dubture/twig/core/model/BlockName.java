/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core.model;

import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.model.LocalVariable;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class BlockName extends LocalVariable {
	/**
	 * @param parent
	 * @param name
	 * @param declarationSourceStart
	 * @param declarationSourceEnd
	 * @param nameStart
	 * @param nameEnd
	 * @param type
	 */
	public BlockName(IModelElement parent, String name, int declarationSourceStart, int declarationSourceEnd,
			int nameStart, int nameEnd, String type) {
		super(parent, name, declarationSourceStart, declarationSourceEnd, nameStart, nameEnd, type);
		// TODO Auto-generated constructor stub
	}

}
