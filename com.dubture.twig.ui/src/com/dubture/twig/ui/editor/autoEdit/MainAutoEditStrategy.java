/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.autoEdit;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;

import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import com.dubture.twig.core.format.FormatterUtils;

/**
 * 
 * Modified {@link org.eclipse.php.internal.ui.autoEdit.MainAutoEditStrategy} to
 * work with Twig templates.
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
@SuppressWarnings("restriction")
public class MainAutoEditStrategy implements IAutoEditStrategy {

	private static IAutoEditStrategy indentLineAutoEditStrategy = new IndentLineAutoEditStrategy();
	private static IAutoEditStrategy curlyOpenAutoEditStrategy = new CurlyOpenAutoEditStrategy();
	private static IAutoEditStrategy curlyCloseAutoEditStrategy = new CurlyCloseAutoEditStrategy();
	private static IAutoEditStrategy matchingBracketAutoEditStrategy = new MatchingBracketAutoEditStrategy();
	private static IAutoEditStrategy quotesAutoEditStrategy = new QuotesAutoEditStrategy();

	private static IAutoEditStrategy tabAutoEditStrategy = new TabAutoEditStrategy();
	private static IAutoEditStrategy autoIndentStrategy = new TwigAutoIndentStrategy();

	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {

		if (command.text == null) {
			return;
		}
		String partitionType = FormatterUtils.getPartitionType((IStructuredDocument) document, command.offset);

		if (partitionType.equals(TwigPartitionTypes.TWIG_COMMENT_TEXT)) {
		} else if (partitionType.equals(TwigPartitionTypes.TWIG_QUOTED_STRING)) {
			indentLineAutoEditStrategy.customizeDocumentCommand(document, command);
			quotesAutoEditStrategy.customizeDocumentCommand(document, command);
		} else if (partitionType.equals(TwigPartitionTypes.TWIG_DEFAULT)
				|| partitionType.equals(TwigPartitionTypes.TWIG_COMMENT_TEXT)) {
			matchingBracketAutoEditStrategy.customizeDocumentCommand(document, command);
			curlyOpenAutoEditStrategy.customizeDocumentCommand(document, command);
			curlyCloseAutoEditStrategy.customizeDocumentCommand(document, command);
			indentLineAutoEditStrategy.customizeDocumentCommand(document, command);
			tabAutoEditStrategy.customizeDocumentCommand(document, command);
			quotesAutoEditStrategy.customizeDocumentCommand(document, command);
			autoIndentStrategy.customizeDocumentCommand(document, command);
		}

	}

}
