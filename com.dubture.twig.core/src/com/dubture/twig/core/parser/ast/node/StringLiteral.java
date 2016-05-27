/*
 * This file is part of the Twig Eclipse Plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.core.parser.ast.node;

import org.eclipse.dltk.ast.expressions.Literal;

public class StringLiteral extends Literal {

	/**
	 * @param start
	 * @param end
	 * @param string
	 */
	public StringLiteral(int start, int end, String string) {
		super(start, end);
		fLiteralValue = string;
	}

	@Override
	public int getKind() {
		return ASTNodeKinds.STRING_LITERAL;
	}

	@Override
	public String toString() {
		return String.format("[StringLiteral %d - %d] : %s", sourceStart(), sourceEnd(), fLiteralValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof StringLiteral)) {
			return false;
		}

		StringLiteral other = (StringLiteral) obj;

		boolean equal = other.sourceStart() == sourceStart() && other.sourceEnd() == sourceEnd()
				&& other.getValue().equals(getValue());

		return equal;

	}

	@Override
	public String getValue() {
		String val = super.getValue();

		if (val != null) {
			val = val.replaceAll("'", "").replaceAll("\"", "");
		}

		return val;
	}
}
