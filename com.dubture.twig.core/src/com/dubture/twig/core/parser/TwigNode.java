/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser;

public class TwigNode {

	private int sourceStart;
	private int sourceEnd;
	private String name;
	private int type;

	public TwigNode(String name, int start, int end, int type) {

		this.name = name;
		sourceStart = start;
		sourceEnd = end;
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public int getSourceStart() {
		return sourceStart;
	}

	public int getSourceEnd() {
		return sourceEnd;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {

		return name + ", start: " + sourceStart + ", end: " + sourceEnd;
	}

}
