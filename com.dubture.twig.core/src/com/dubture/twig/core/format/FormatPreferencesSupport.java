/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.format;

import org.eclipse.jface.text.IDocument;

public class FormatPreferencesSupport {

	private static FormatPreferencesSupport instance = null;

	public static FormatPreferencesSupport getInstance() {
		if (instance == null) {
			instance = new FormatPreferencesSupport();
		}
		return instance;
	}

	public int getIndentationSize(IDocument document) {
		return 4;
	}

	public char getIndentationChar(IDocument document) {
		return ' ';
	}
}
