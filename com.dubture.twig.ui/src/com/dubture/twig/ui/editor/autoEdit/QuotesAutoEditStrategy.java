/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.autoEdit;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.core.documentModel.parser.PHPRegionContext;
import org.eclipse.php.internal.core.documentModel.parser.regions.PHPRegionTypes;
import org.eclipse.php.internal.ui.Logger;
import org.eclipse.php.internal.ui.autoEdit.MatchingCharAutoEditStrategy;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionContainer;

import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import com.dubture.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;
import com.dubture.twig.core.format.FormatterUtils;

/**
 * 
 * A modified
 * {@link org.eclipse.php.internal.ui.autoEdit.QuotesAutoEditStrategy} to make
 * auto-closing quotes work with the Twig editor.
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
@SuppressWarnings("restriction")
public class QuotesAutoEditStrategy extends MatchingCharAutoEditStrategy {

	@Override
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {

		if (/* TypingPreferences.closeQuotes && */command.text != null) {
			int length = command.text.length();
			if (length == 0 && command.length == 1) {
				try {
					char removedChar = document.getChar(command.offset);
					if (isQuote(removedChar)) {
						deleteQuote((IStructuredDocument) document, command, removedChar);
					}

				} catch (BadLocationException e) {
					Logger.logException(e);
				}
			}
			if (length == 1) {
				char c = command.text.charAt(0);
				if (isQuote(c)) {
					autoAddPairQuote((IStructuredDocument) document, command, c);
				}
			}
		}
	}

	private void autoAddPairQuote(IStructuredDocument document, DocumentCommand command, char insertedChar) {
		int startOffset = command.offset;
		int endOffset = startOffset + command.length;

		try {
			String startState = FormatterUtils.getPartitionType(document, startOffset, true);
			String endState = FormatterUtils.getPartitionType(document, endOffset, true);
			if (startState == TwigPartitionTypes.TWIG_QUOTED_STRING || endState == TwigPartitionTypes.TWIG_QUOTED_STRING
					|| (startState == TwigPartitionTypes.TWIG_DEFAULT && endState == TwigPartitionTypes.TWIG_DEFAULT
							&& document.getChar(endOffset - 1) == '\'')) {
				if (endOffset < document.getLength() && startOffset == endOffset) {
					char nextChar = document.getChar(endOffset);
					if (insertedChar == nextChar) {
						char prevChar = document.getChar(startOffset - 1);
						if (prevChar != BACK_SLASH) {
							if (command.length == 0) {
								adjustDocumentOffset(command);
								command.text = ""; //$NON-NLS-1$
							} else {
								command.length++;
							}
						}
					} else {
						IStructuredDocumentRegion sdRegion = document.getRegionAtCharacterOffset(startOffset);
						ITextRegion tRegion = getPhpRegion(sdRegion, startOffset);
						// adding a specific char to close the qoute in case the
						// 2 following conditions fulfilled:
						// 1. The region ends with whitespace.
						// 2. The command offest is located at the end of the
						// region(include the region whitespace)
						int regionLength = tRegion.getLength();
						int regionTextLength = tRegion.getTextLength();
						if (regionTextLength != regionLength
								&& startOffset > getRegionStart(sdRegion, startOffset) + regionTextLength
								&& shouldAddClosingBracket(document, endOffset, true)) {
							command.text = command.text + insertedChar;
							// making the change in the documet ourselfs and
							// consuming the original command
							document.replace(command.offset, command.length, command.text);
							document.getUndoManager().disableUndoManagement();
							document.replace(command.offset + 1, 0, ""); //$NON-NLS-1$
							document.getUndoManager().enableUndoManagement();
							adjustDocumentOffset(command);// this will cause the
															// caret to be set
															// between the
															// quotes.
							command.length = 0;
							command.text = ""; //$NON-NLS-1$
						}
					}
				}
				return;
			}
			if (isQuoteAllowed(startState, insertedChar)) {
				if ((shouldAddClosingBracket(document, endOffset, true))) {
					int result = isMatchingCharNeeded(document, endOffset, insertedChar);
					if (result == MATCHING_BRACKET_NEEDED) {
						command.text = command.text + insertedChar;
						// making the change in ther documet ourselfs and
						// consuming the original command
						document.replace(command.offset, command.length, command.text);
						document.getUndoManager().disableUndoManagement();
						document.replace(command.offset + 1, 0, ""); //$NON-NLS-1$
						document.getUndoManager().enableUndoManagement();
						adjustDocumentOffset(command); // this will cause the
														// caret to be set
														// between the quotes.

						command.length = 0;
						command.text = ""; //$NON-NLS-1$
					}
				}
			}

		} catch (BadLocationException e) {
			Logger.logException(e);
			document.getUndoManager().enableUndoManagement();
		}
	}

	/*
	 * get php region by given IStructuredDocumentRegion and offset
	 */
	private ITextRegion getPhpRegion(IStructuredDocumentRegion sdRegion, int offset) throws BadLocationException {
		ITextRegion tRegion = sdRegion.getRegionAtCharacterOffset(offset);

		if (tRegion.getType().equals(PHPRegionContext.PHP_CLOSE)) {
			offset--;
			tRegion = sdRegion.getRegionAtCharacterOffset(offset);
		}

		int regionStart = sdRegion.getStartOffset(tRegion);
		// in case of container we have the extract the PHPScriptRegion
		if (tRegion instanceof ITextRegionContainer) {
			ITextRegionContainer container = (ITextRegionContainer) tRegion;
			tRegion = container.getRegionAtCharacterOffset(offset);
			regionStart += tRegion.getStart();
		}

		if (tRegion instanceof ITwigScriptRegion) {
			ITwigScriptRegion scriptRegion = (ITwigScriptRegion) tRegion;
			tRegion = scriptRegion.getTwigToken(offset - regionStart);
			return tRegion;
		}
		return null;
	}

	/*
	 * get php region by given IStructuredDocumentRegion and offset
	 */
	private int getRegionStart(IStructuredDocumentRegion sdRegion, int offset) throws BadLocationException {
		ITextRegion tRegion = sdRegion.getRegionAtCharacterOffset(offset);

		if (tRegion.getType().equals(PHPRegionContext.PHP_CLOSE)) {
			offset--;
			tRegion = sdRegion.getRegionAtCharacterOffset(offset);
		}

		int regionStart = sdRegion.getStartOffset(tRegion);
		// in case of container we have the extract the PHPScriptRegion
		if (tRegion instanceof ITextRegionContainer) {
			ITextRegionContainer container = (ITextRegionContainer) tRegion;
			tRegion = container.getRegionAtCharacterOffset(offset);
			regionStart += tRegion.getStart();
		}
		if (tRegion instanceof ITwigScriptRegion) {
			ITwigScriptRegion scriptRegion = (ITwigScriptRegion) tRegion;
			tRegion = scriptRegion.getTwigToken(offset - regionStart);
			regionStart += tRegion.getStart();
		}
		return regionStart;
	}

	/**
	 * returns true if the lexical state demands qoute balance
	 */
	private boolean isQuoteAllowed(String state, char quote) {
		return (state == TwigPartitionTypes.TWIG_DEFAULT) || (state == PHPRegionTypes.PHP_OPENTAG)
				|| (state == PHPRegionTypes.PHP_CLOSETAG);
	}

	public int isMatchingCharNeeded(IStructuredDocument document, int offset, char quoteChar) {
		try {
			String postCharState = FormatterUtils.getPartitionType(document, offset, true);
			if (!(postCharState == TwigPartitionTypes.TWIG_DEFAULT || postCharState == PHPRegionTypes.PHP_OPENTAG
					|| postCharState == PHPRegionTypes.PHP_CLOSETAG)) {
				if (isSpecialOpenCurlyInQuotes(document, offset)) {
					postCharState = FormatterUtils.getPartitionType(document, offset + 1);
				}
			}

			if (postCharState != TwigPartitionTypes.TWIG_DEFAULT && postCharState != PHPRegionTypes.PHP_OPENTAG
					&& postCharState != PHPRegionTypes.PHP_CLOSETAG) {
				return SEARCH_NOT_VALID;
			}
			if (FormatterUtils.getPartitionType(document,
					document.getLength() - 1) == TwigPartitionTypes.TWIG_QUOTED_STRING) {
				IStructuredDocumentRegion sdRegion = document.getLastStructuredDocumentRegion();
				ITextRegion tRegion = sdRegion.getLastRegion();
				char lastChar = document.getChar(sdRegion.getStartOffset() + tRegion.getTextEnd() - 1);
				if (lastChar != quoteChar) {
					return MATCHING_BRACKET_NOT_NEEDED;
				}
			}

		} catch (BadLocationException e) {
			Logger.logException(e);
		}
		return MATCHING_BRACKET_NEEDED;
	}

	private void deleteQuote(IStructuredDocument document, DocumentCommand command, char removedChar) {
		int offset = command.offset;

		IStructuredDocumentRegion sdRegion = document.getRegionAtCharacterOffset(offset);
		if (sdRegion == null || sdRegion.getType() != TwigRegionTypes.TWIG_CONTENT) {
			return;
		}
		try {
			ITextRegion tRegion = sdRegion.getRegionAtCharacterOffset(offset);
			int regionStart = sdRegion.getStartOffset(tRegion);
			// in case of container we have the extract the PHPScriptRegion
			if (tRegion instanceof ITextRegionContainer) {
				ITextRegionContainer container = (ITextRegionContainer) tRegion;
				tRegion = container.getRegionAtCharacterOffset(offset);
				regionStart += tRegion.getStart();
			}

			if (tRegion instanceof ITwigScriptRegion) {
				ITwigScriptRegion scriptRegion = (ITwigScriptRegion) tRegion;
				tRegion = scriptRegion.getTwigToken(offset - regionStart);

				if (tRegion == null || tRegion.getType() != TwigRegionTypes.TWIG_CONSTANT_ENCAPSED_STRING) {
					return;
				}

				if (offset != tRegion.getStart() + regionStart
						|| (tRegion.getTextLength() != 2 && !isBetweenBackquotes(sdRegion, offset))) {
					// looking only for the cases where the user is trying to
					// remove the first quote out of two coupled ones.
					return;
				}

				char nextChar = document.getChar(offset + 1);
				if (nextChar != removedChar) {
					return;
				}
				command.length = 2;
			}
		} catch (BadLocationException e) {
		}
	}

	// fixed bug 172149 - The offset changed according to the PHP script region
	// offset
	private boolean isBetweenBackquotes(IStructuredDocumentRegion sdRegion, int offset) throws BadLocationException {
		if (sdRegion.getParentDocument().getLength() <= offset) {
			return false;
		}
		ITextRegion quoteRegion = getPhpRegion(sdRegion, offset);
		if (quoteRegion == null || quoteRegion.getLength() > 1) {
			return false;
		}

		// fixed bug 197412
		if (sdRegion.getFullText().charAt(offset - sdRegion.getStartOffset()) != BACK_QUOTE) {
			return false;
		}

		quoteRegion = getPhpRegion(sdRegion, offset + 1);
		if (quoteRegion == null || quoteRegion.getLength() > 1) {
			return false;
		}

		// fixed bug 197412
		if (sdRegion.getFullText().charAt(offset + 1 - sdRegion.getStartOffset()) != BACK_QUOTE) {
			return false;
		}
		return true;
	}
}
