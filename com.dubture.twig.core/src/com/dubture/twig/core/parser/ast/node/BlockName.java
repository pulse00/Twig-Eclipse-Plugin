/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core.parser.ast.node;

/**
 * @author sobert
 *
 */
public class BlockName extends Variable {

	/**
	 * @param startIndex
	 * @param stopIndex
	 * @param string
	 */
	public BlockName(int startIndex, int stopIndex, String string) {
		super(startIndex, stopIndex, string);

	}

}
