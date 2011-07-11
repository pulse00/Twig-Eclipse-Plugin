package org.eclipse.twig.ui.editor.autoEdit;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.core.documentModel.partitioner.PHPPartitionTypes;
import org.eclipse.php.internal.core.format.FormatterUtils;
import org.eclipse.php.internal.ui.autoEdit.CaseDefaultAutoEditStrategy;
import org.eclipse.php.internal.ui.autoEdit.CurlyCloseAutoEditStrategy;
import org.eclipse.php.internal.ui.autoEdit.CurlyOpenAutoEditStrategy;
import org.eclipse.php.internal.ui.autoEdit.IndentLineAutoEditStrategy;
import org.eclipse.php.internal.ui.autoEdit.MatchingBracketAutoEditStrategy;
import org.eclipse.php.internal.ui.autoEdit.PHPAutoIndentStrategy;
import org.eclipse.php.internal.ui.autoEdit.PhpDocAutoIndentStrategy;
import org.eclipse.php.internal.ui.autoEdit.QuotesAutoEditStrategy;
import org.eclipse.php.internal.ui.autoEdit.TabAutoEditStrategy;
import org.eclipse.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;

/**
 * 
 * 
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
	private static IAutoEditStrategy caseDefaultAutoEditStrategy = new CaseDefaultAutoEditStrategy();
	private static IAutoEditStrategy docBlockAutoEditStrategy = new PhpDocAutoIndentStrategy();
	private static IAutoEditStrategy tabAutoEditStrategy = new TabAutoEditStrategy();
	private static IAutoEditStrategy autoIndentStrategy = new PHPAutoIndentStrategy();
	
	public void customizeDocumentCommand(IDocument document,
			DocumentCommand command) {
		
		if (command.text == null) {
			return;
		}
		String partitionType = FormatterUtils.getPartitionType(
				(IStructuredDocument) document, command.offset);

		if (partitionType.equals(PHPPartitionTypes.PHP_DOC)
				|| partitionType
						.equals(PHPPartitionTypes.PHP_MULTI_LINE_COMMENT)) {
			// case of multi line comment or php doc
			docBlockAutoEditStrategy
					.customizeDocumentCommand(document, command);
		} else if (partitionType.equals(TwigPartitionTypes.TWIG_QUOTED_STRING)) {
			indentLineAutoEditStrategy.customizeDocumentCommand(document,
					command);
			quotesAutoEditStrategy.customizeDocumentCommand(document, command);
		} else if (partitionType.equals(TwigPartitionTypes.TWIG_DEFAULT)
				|| partitionType
						.equals(TwigPartitionTypes.TWIG_COMMENT_TEXT)) {
			caseDefaultAutoEditStrategy.customizeDocumentCommand(document,
					command);
			matchingBracketAutoEditStrategy.customizeDocumentCommand(document,
					command);
			curlyOpenAutoEditStrategy.customizeDocumentCommand(document,
					command);
			curlyCloseAutoEditStrategy.customizeDocumentCommand(document,
					command);
			indentLineAutoEditStrategy.customizeDocumentCommand(document,
					command);
			tabAutoEditStrategy.customizeDocumentCommand(document, command);
			quotesAutoEditStrategy.customizeDocumentCommand(document, command);
			autoIndentStrategy.customizeDocumentCommand(document, command);
		}

	}

}
