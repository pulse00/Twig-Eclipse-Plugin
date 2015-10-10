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
import org.eclipse.php.internal.core.format.FormatterUtils;

@SuppressWarnings({ "restriction" })
public class FormatPreferencesSupport {

	private static FormatPreferencesSupport instance = null;

	public static FormatPreferencesSupport getInstance() {
		if (instance == null) {
			instance = new FormatPreferencesSupport();
		}
		return instance;
	}

	public int getIndentationSize(IDocument document) {
		return FormatterUtils.getFormatterCommonPrferences().getIndentationSize(document);
	}

	public char getIndentationChar(IDocument document) {
		return FormatterUtils.getFormatterCommonPrferences().getIndentationChar(document);
	}
}
