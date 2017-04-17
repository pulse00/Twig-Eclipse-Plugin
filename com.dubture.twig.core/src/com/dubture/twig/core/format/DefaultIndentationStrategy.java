/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.format;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.php.internal.core.format.IIndentationStrategy;
import org.eclipse.php.internal.core.util.text.PHPTextSequenceUtilities;
import org.eclipse.php.internal.core.util.text.TextSequence;
import org.eclipse.wst.sse.core.internal.parser.ContextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionContainer;

import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import com.dubture.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;

@SuppressWarnings("restriction")
public class DefaultIndentationStrategy implements IIndentationStrategy {

	/**
	 * Check if the line contains any non blank chars.
	 */
	protected static boolean isBlanks(final IStructuredDocument document, final int startOffset, final int endOffset,
			final int currentOffset) throws BadLocationException {
		return document.get(startOffset, endOffset - startOffset).trim().length() == 0
				|| document.get(startOffset, currentOffset - startOffset).trim().length() == 0;
	}

	public static int getIndentationBaseLine(final IStructuredDocument document, final int lineNumber, final int offset,
			boolean checkMultiLine) throws BadLocationException {
		int currLineIndex = lineNumber;
		while (currLineIndex >= 0) {
			final IRegion lineInfo = document.getLineInformation(currLineIndex);
			if (lineInfo.getLength() == 0) {
				// then its not indentation base for sure
				currLineIndex--;
				continue;
			}
			final int currLineEndOffset = lineInfo.getOffset() + lineInfo.getLength();
			final boolean isIndentationBase = isIndentationBase(document, Math.min(offset, currLineEndOffset), offset,
					currLineIndex, checkMultiLine);
			if (isIndentationBase)
				return currLineIndex;
			currLineIndex--;
		}
		return 0;
	}

	// go backward and look for any region except comment region or white space
	// region
	// in the given line
	private static ITextRegion getLastTokenRegion(final IStructuredDocument document, final IRegion line,
			final int forOffset) throws BadLocationException {
		int offset = forOffset;
		int lineStartOffset = line.getOffset();
		IStructuredDocumentRegion sdRegion = document.getRegionAtCharacterOffset(offset);
		if (sdRegion == null) {
			return null;
		}

		ITextRegion tRegion = sdRegion.getRegionAtCharacterOffset(offset);
		if (tRegion == null && offset == document.getLength()) {
			offset -= 1;
			tRegion = sdRegion.getRegionAtCharacterOffset(offset);
		}
		int regionStart = sdRegion.getStartOffset(tRegion);

		// in case of container we have the extract the PhpScriptRegion
		if (tRegion instanceof ITextRegionContainer) {
			ITextRegionContainer container = (ITextRegionContainer) tRegion;
			tRegion = container.getRegionAtCharacterOffset(offset);
			regionStart += tRegion.getStart();
		}

		if (tRegion instanceof ITwigScriptRegion) {
			ITwigScriptRegion scriptRegion = (ITwigScriptRegion) tRegion;
			tRegion = scriptRegion.getTwigToken(offset - regionStart);

			if (tRegion == null)
				return null;

			// go backward over the region to find a region (not comment nor
			// whitespace)
			// in the same line
			do {
				String token = tRegion.getType();
				if (regionStart + tRegion.getStart() >= forOffset) {
					// making sure the region found is not after the caret
					// (https://bugs.eclipse.org/bugs/show_bug.cgi?id=222019 -
					// caret before '{')
				} else if (!TwigPartitionTypes.isTwigCommentState(token) && token != TwigRegionTypes.WHITESPACE) {
					// not comment nor white space
					return tRegion;
				}
				tRegion = scriptRegion.getTwigToken(tRegion.getStart() - 1);
			} while (tRegion != null && tRegion.getStart() + regionStart > lineStartOffset);
		}

		return null;
	}

	private static boolean isIndentationBase(final IStructuredDocument document, final int checkedOffset,
			final int forOffset, int currLineIndex, boolean checkMultiLine) throws BadLocationException {
		final IRegion lineInfo = document.getLineInformationOfOffset(checkedOffset);
		int lineStart = lineInfo.getOffset();

		if (isBlanks(document, lineStart, checkedOffset, forOffset))
			return false;

		// need to get to the first tRegion - so that we wont get the state of
		// the
		// tRegion in the previos line
		while (Character.isWhitespace(document.getChar(lineStart)))
			lineStart++;

		// checked line beginning offset (after incrementing spaces in beginning
		final String checkedLineBeginState = FormatterUtils.getPartitionType(document, lineStart, true);

		// checked line end
		final String checkedLineEndState = FormatterUtils.getPartitionType(document, checkedOffset, true);

		// the current potential line for formatting begin offset
		final String forLineEndState = FormatterUtils.getPartitionType(document, forOffset);

		if (shouldNotConsiderAsIndentationBase(checkedLineBeginState, forLineEndState)
				|| checkMultiLine && isInMultiLineStatement(document, checkedLineBeginState, checkedLineEndState,
						checkedOffset, lineStart, currLineIndex))
			return false;

		// Fix bug #201688
		if (((checkedLineBeginState == TwigPartitionTypes.TWIG_COMMENT_TEXT))
				&& (checkedLineBeginState == forLineEndState)) {
			// the whole document
			final IStructuredDocumentRegion sdRegion = document.getRegionAtCharacterOffset(lineStart);
			// the whole PHP script
			ITextRegion phpScriptRegion = sdRegion.getRegionAtCharacterOffset(lineStart);
			int phpContentStartOffset = sdRegion.getStartOffset(phpScriptRegion);

			if (phpScriptRegion instanceof ITextRegionContainer) {
				ITextRegionContainer container = (ITextRegionContainer) phpScriptRegion;
				phpScriptRegion = container.getRegionAtCharacterOffset(lineStart);
				phpContentStartOffset += phpScriptRegion.getStart();
			}

			if (phpScriptRegion instanceof ITwigScriptRegion) {
				ITwigScriptRegion scriptRegion = (ITwigScriptRegion) phpScriptRegion;
				// the region we are trying to check if it is the indent base
				// for the line we need to format
				ContextRegion checkedRegion = (ContextRegion) scriptRegion
						.getTwigToken(lineStart - phpContentStartOffset);
				// the current region we need to format
				ContextRegion currentRegion = (ContextRegion) scriptRegion
						.getTwigToken(forOffset - phpContentStartOffset);
				String checkedType = checkedRegion.getType();
				String currentType = currentRegion.getType();
				// if we are in the beginning of a comment (DOC or Multi
				// comment) and we have before another
				// Doc comment or Multi comment, the base line we'll be the
				// beginning of the previous multi comment

				if (currentType.equals(TwigRegionTypes.TWIG_COMMENT_OPEN)
						|| currentType.equals(TwigRegionTypes.TWIG_COMMENT_CLOSE)) {
					return checkedType.equals(TwigRegionTypes.TWIG_COMMENT_OPEN)
							|| checkedType.equals(TwigRegionTypes.TWIG_COMMENT_CLOSE);
				}

			}
		}

		return lineShouldInedent(checkedLineBeginState, checkedLineEndState)
				|| forLineEndState == checkedLineBeginState;
	}

	private static boolean isInMultiLineStatement(IStructuredDocument document, String checkedLineBeginState,
			String checkedLineEndState, int checkedOffset, int lineStart, int currLineIndex) {
		// TODO if in phpdoc or php miltiline,return false;
		try {
			char[] line = document.get(lineStart, document.getLineLength(currLineIndex)).toCharArray();
			for (int i = 0; i < line.length; i++) {
				char c = line[i];
				if (Character.isWhitespace(c)) {
				} else {
					// move line start to first non blank char
					lineStart += i + 1;
					break;
				}
			}
		} catch (BadLocationException e) {
		}

		TextSequence textSequence = PHPTextSequenceUtilities.getStatement(lineStart,
				document.getRegionAtCharacterOffset(lineStart), true);
		if (textSequence != null
				&& isRegionTypeAllowedMultiline(
						FormatterUtils.getRegionType(document, textSequence.getOriginalOffset(0)))
				&& document.getLineOfOffset(textSequence.getOriginalOffset(0)) < currLineIndex) {
			return true;
		}

		return false;
	}

	/**
	 * a statement spanning multi line starts with a region of type
	 * regionType,the lines'(except 1st) indentation are same as/based on 1st
	 * line,then this this method return true,else return false.
	 *
	 * @param regionType
	 * @return
	 */
	private static boolean isRegionTypeAllowedMultiline(String regionType) {
		// TODO maybe there are other type need to be added
		return regionType != null && !TwigRegionTypes.TWIG_COMMENT_OPEN.equals(regionType);
	}

	public static boolean lineShouldInedent(final String beginState, final String endState) {
		return beginState == TwigPartitionTypes.TWIG_DEFAULT || endState == TwigPartitionTypes.TWIG_DEFAULT;
	}

	@Override
	public void placeMatchingBlanks(final IStructuredDocument document, final StringBuilder result,
			final int lineNumber, final int forOffset) throws BadLocationException {
		placeMatchingBlanksForStructuredDocument(document, result, lineNumber, forOffset);
	}

	public static void placeMatchingBlanksForStructuredDocument(final IStructuredDocument document,
			final StringBuilder result, final int lineNumber, final int forOffset) throws BadLocationException {
		boolean enterKeyPressed = document.getLineDelimiter().equals(result.toString());
		int lastNonEmptyLineIndex = getIndentationBaseLine(document, lineNumber, forOffset, false);
		final int indentationBaseLineIndex = getIndentationBaseLine(document, lineNumber, forOffset, true);
		final IRegion lastNonEmptyLine = document.getLineInformation(lastNonEmptyLineIndex);
		final IRegion indentationBaseLine = document.getLineInformation(indentationBaseLineIndex);
		final String blanks = FormatterUtils.getLineBlanks(document, indentationBaseLine);
		result.append(blanks);

		final int lastLineEndOffset = lastNonEmptyLine.getOffset() + lastNonEmptyLine.getLength();
		int offset;
		int line;
		if (forOffset < lastLineEndOffset) {
			offset = forOffset;
			line = lineNumber;
		} else {
			offset = lastLineEndOffset;
			line = lastNonEmptyLineIndex;
		}
		if (shouldIndent(document, offset, line)) {
			final int indentationSize = FormatPreferencesSupport.getInstance().getIndentationSize(document);
			final char indentationChar = FormatPreferencesSupport.getInstance().getIndentationChar(document);
			for (int i = 0; i < indentationSize; i++)
				result.append(indentationChar);
		} else {
			lastNonEmptyLineIndex = lineNumber;
			if (!enterKeyPressed && lastNonEmptyLineIndex > 0) {
				lastNonEmptyLineIndex--;
			}
			while (lastNonEmptyLineIndex >= 0) {
				IRegion lineInfo = document.getLineInformation(lastNonEmptyLineIndex);
				String content = document.get(lineInfo.getOffset(), lineInfo.getLength());
				if (content.trim().length() > 0) {
					break;
				}
				lastNonEmptyLineIndex--;
			}
			if (!isEndOfStatement(document, offset, lastNonEmptyLineIndex)) {
				if (enterKeyPressed) {
					// this line is one of multi line statement
					if (indentationBaseLineIndex == lastNonEmptyLineIndex) {
						// this only deal with "$a = 'aaa'.|","|" is the cursor
						// position when we press enter key
						placeStringIndentation(document, lastNonEmptyLineIndex, result);
					} else {
						// in multi line statement,when user press enter key,
						// we use the same indentation of the last non-empty
						// line.
						result.setLength(result.length() - blanks.length());
						IRegion lineInfo = document.getLineInformation(lastNonEmptyLineIndex);
						result.append(FormatterUtils.getLineBlanks(document, lineInfo));
					}
				} else {
					// in multi line statement,when user press enter key,
					// we use the same indentation of the last non-empty
					// line.
					result.setLength(result.length() - blanks.length());
					IRegion lineInfo = document.getLineInformation(lastNonEmptyLineIndex);
					result.append(FormatterUtils.getLineBlanks(document, lineInfo));
				}
			}
		}
	}

	private static boolean isEndOfStatement(IStructuredDocument document, int offset, int lineNumber) {
		try {
			IRegion lineInfo = document.getLineInformation(lineNumber);
			ITextRegion token = getLastTokenRegion(document, lineInfo, lineInfo.getOffset() + lineInfo.getLength());
			if (token == null)// comment
				return true;
			if (token.getType() == TwigRegionTypes.PHP_CURLY_CLOSE) {
				return true;
			}
		} catch (final BadLocationException e) {
		}
		return false;
	}

	private static void placeStringIndentation(final IStructuredDocument document, int lineNumber,
			StringBuilder result) {
		try {

			IRegion lineInfo = document.getLineInformation(lineNumber);
			int offset = lineInfo.getOffset() + lineInfo.getLength();
			final IStructuredDocumentRegion sdRegion = document.getRegionAtCharacterOffset(offset);
			ITextRegion token = getLastTokenRegion(document, lineInfo, offset);
			if (token == null)
				return;
			String tokenType = token.getType();

			if (tokenType == TwigRegionTypes.PHP_CURLY_OPEN)
				return;

			ITextRegion scriptRegion = sdRegion.getRegionAtCharacterOffset(offset);
			if (scriptRegion == null && offset == document.getLength()) {
				offset -= 1;
				scriptRegion = sdRegion.getRegionAtCharacterOffset(offset);
			}
			int regionStart = sdRegion.getStartOffset(scriptRegion);
			// in case of container we have the extract the PhpScriptRegion
			if (scriptRegion instanceof ITextRegionContainer) {
				ITextRegionContainer container = (ITextRegionContainer) scriptRegion;
				scriptRegion = container.getRegionAtCharacterOffset(offset);
				regionStart += scriptRegion.getStart();
			}
			if (scriptRegion instanceof ITwigScriptRegion) {
				if (tokenType == TwigRegionTypes.TWIG_DELIMITER
						&& document.getChar(regionStart + token.getStart()) == '.') {
					token = ((ITwigScriptRegion) scriptRegion).getTwigToken(token.getStart() - 1);
					if (token != null && token.getType() == TwigRegionTypes.PHP_CONSTANT_ENCAPSED_STRING) {
						boolean isToken = true;
						int currentOffset = regionStart + token.getStart() - 1;
						while (currentOffset >= lineInfo.getOffset()) {
							token = ((ITwigScriptRegion) scriptRegion).getTwigToken(token.getStart() - 1);
							tokenType = token.getType();
							if (isToken
									&& (tokenType == TwigRegionTypes.TWIG_DELIMITER
											&& document.getChar(regionStart + token.getStart()) == '.')
									|| !isToken && tokenType == TwigRegionTypes.PHP_CONSTANT_ENCAPSED_STRING) {
								currentOffset = regionStart + token.getStart() - 1;
							} else {
								break;
							}
						}
						for (int i = 0; i < regionStart + token.getEnd() - lineInfo.getOffset(); i++)
							result.append(' ');
					}
				}
			}
		} catch (final BadLocationException e) {
		}
	}

	static boolean shouldIndent(final IStructuredDocument document, int offset, final int lineNumber) {
		try {
			final IRegion lineInfo = document.getLineInformation(lineNumber);

			final IStructuredDocumentRegion sdRegion = document.getRegionAtCharacterOffset(offset);
			ITextRegion token = getLastTokenRegion(document, lineInfo, offset);
			if (token == null)
				return false;
			String tokenType = token.getType();

			if (tokenType == TwigRegionTypes.PHP_CURLY_OPEN)
				return true;

			ITextRegion scriptRegion = sdRegion.getRegionAtCharacterOffset(offset);
			if (scriptRegion == null && offset == document.getLength()) {
				offset -= 1;
				scriptRegion = sdRegion.getRegionAtCharacterOffset(offset);
			}
			int regionStart = sdRegion.getStartOffset(scriptRegion);
			// in case of container we have the extract the PhpScriptRegion
			if (scriptRegion instanceof ITextRegionContainer) {
				ITextRegionContainer container = (ITextRegionContainer) scriptRegion;
				scriptRegion = container.getRegionAtCharacterOffset(offset);
				regionStart += scriptRegion.getStart();
			}
			if (scriptRegion instanceof ITwigScriptRegion) {
				if (tokenType == TwigRegionTypes.TWIG_DELIMITER
						&& document.getChar(regionStart + token.getStart()) == ':') {
					// checking if the line starts with "case" or "default"
					int currentOffset = regionStart + token.getStart() - 1;
					while (currentOffset >= lineInfo.getOffset()) {
						token = ((ITwigScriptRegion) scriptRegion).getTwigToken(token.getStart() - 1);
						tokenType = token.getType();
						if (tokenType == TwigRegionTypes.TWIG_CONTENT)
							return true;
						currentOffset = regionStart + token.getStart() - 1;
					}
				}
			}
		} catch (final BadLocationException e) {
		}
		return false;
	}

	/**
	 * @since 2.2
	 */
	public static boolean shouldNotConsiderAsIndentationBase(final String currentState, final String forState) {
		return currentState != forState && (currentState == TwigPartitionTypes.TWIG_COMMENT_TEXT
				|| currentState == TwigPartitionTypes.TWIG_QUOTED_STRING);
	}

}
