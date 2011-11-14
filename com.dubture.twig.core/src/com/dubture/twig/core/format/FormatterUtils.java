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
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionContainer;

import com.dubture.twig.core.TwigCorePlugin;
import com.dubture.twig.core.documentModel.parser.TwigRegionContext;
import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import com.dubture.twig.core.documentModel.parser.partitioner.TwigStructuredTextPartitioner;
import com.dubture.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;


/**
 * 
 * 
 * Adapted from the {@link org.eclipse.php.internal.core.format.FormatterUtils}
 * to retrieve correct Twig regions.
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class FormatterUtils {
	
	private static TwigStructuredTextPartitioner partitioner = new TwigStructuredTextPartitioner();

	public static String getRegionType(IStructuredDocument document, int offset) {
		try {
			IStructuredDocumentRegion sdRegion = document
					.getRegionAtCharacterOffset(offset);
			if (sdRegion == null) {
				return null;
			}

			ITextRegion tRegion = sdRegion.getRegionAtCharacterOffset(offset);
			if (tRegion == null && offset == document.getLength()) {
				offset -= 1;
				tRegion = sdRegion.getRegionAtCharacterOffset(offset);
			}
			// in case the cursor on the beginning of '?>' tag
			// we decrease the offset to get the PhpScriptRegion
			if (tRegion.getType().equals(TwigRegionContext.TWIG_CLOSE) || 
					tRegion.getType().equals(TwigRegionContext.TWIG_STMT_CLOSE)) {
				tRegion = sdRegion.getRegionAtCharacterOffset(offset - 1);
			}

			int regionStart = sdRegion.getStartOffset(tRegion);

			// in case of container we have the extract the TwigScriptRegion
			if (tRegion != null && tRegion instanceof ITextRegionContainer) {
				ITextRegionContainer container = (ITextRegionContainer) tRegion;
				tRegion = container.getRegionAtCharacterOffset(offset);
				regionStart += tRegion.getStart();
			}

			if (tRegion != null && tRegion instanceof ITwigScriptRegion) {
				ITwigScriptRegion scriptRegion = (ITwigScriptRegion) tRegion;
				int regionOffset = offset - regionStart;
				ITextRegion innerRegion = scriptRegion
						.getTwigToken(regionOffset);
				return innerRegion.getType();
			}
		} catch (final BadLocationException e) {
		} catch (final Exception e1) {
			TwigCorePlugin.log(e1);
		}

		return null;
	}

	public static String getPartitionType(IStructuredDocument document,
			int offset, boolean perferOpenPartitions) {
		try {
			IStructuredDocumentRegion sdRegion = document
					.getRegionAtCharacterOffset(offset);
			if (sdRegion == null) {
				return null;
			}

			ITextRegion tRegion = sdRegion.getRegionAtCharacterOffset(offset);
			if (tRegion == null && offset == document.getLength()) {
				offset -= 1;
				tRegion = sdRegion.getRegionAtCharacterOffset(offset);
			}
			// in case the cursor on the beginning of '?>' tag
			// we decrease the offset to get the PhpScriptRegion
			if (tRegion.getType().equals(TwigRegionContext.TWIG_CLOSE) ||
					tRegion.getType().equals(TwigRegionContext.TWIG_STMT_CLOSE)) {
				tRegion = sdRegion.getRegionAtCharacterOffset(offset - 1);
			}
			
			int regionStart = sdRegion.getStartOffset(tRegion);

			// in case of container we have the extract the PhpScriptRegion
			if (tRegion != null && tRegion instanceof ITextRegionContainer) {
				ITextRegionContainer container = (ITextRegionContainer) tRegion;
				tRegion = container.getRegionAtCharacterOffset(offset);
				regionStart += tRegion.getStart();
			}

			if (tRegion != null && tRegion instanceof ITwigScriptRegion) {
				ITwigScriptRegion scriptRegion = (ITwigScriptRegion) tRegion;
				int regionOffset = offset - regionStart;
				ITextRegion innerRegion = scriptRegion
						.getTwigToken(regionOffset);
				String partition = scriptRegion.getPartition(regionOffset);
				// check if the offset is in the start of the php token
				// because if so this means we're at PHP_DEFAULT partition type
				if (offset
						- (sdRegion.getStart() + regionStart + innerRegion
								.getStart()) == 0) {
					String regionType = innerRegion.getType();
					// except for cases we're inside the fragments of comments
					if (TwigPartitionTypes.isTwigCommentState(regionType)
							|| regionType != TwigRegionTypes.TWIG_COMMENT_OPEN) {
						return partition;
					}

					return TwigPartitionTypes.TWIG_DEFAULT;
				}
				return partition;
			}
		} catch (final BadLocationException e) {
			
		} catch (final Exception e1) {
			TwigCorePlugin.log(e1);
		}
		partitioner.connect(document);

		return partitioner.getContentType(offset, perferOpenPartitions);
	}

	public static String getPartitionType(IStructuredDocument document,
			int offset) {
		return getPartitionType(document, offset, false);
	}

	private static StringBuffer helpBuffer = new StringBuffer(50);

	/**
	 * Return the blanks at the start of the line.
	 */
	public static String getLineBlanks(IStructuredDocument document,
			IRegion lineInfo) throws BadLocationException {
		helpBuffer.setLength(0);
		int startOffset = lineInfo.getOffset();
		int length = lineInfo.getLength();
		char[] line = document.get(startOffset, length).toCharArray();
		for (int i = 0; i < line.length; i++) {
			char c = line[i];
			if (Character.isWhitespace(c)) {
				helpBuffer.append(c);
			} else {
				break;
			}
		}
		return helpBuffer.toString();
	}

	/**
	 * Returns the previous php structured document. Special cases : 1) previous
	 * is null - returns null 2) previous is not PHP region - returns the last
	 * region of the last php block
	 * 
	 * @param currentStructuredDocumentRegion
	 */
	public static IStructuredDocumentRegion getLastTwigStructuredDocumentRegion(
			IStructuredDocumentRegion currentStructuredDocumentRegion) {
		assert currentStructuredDocumentRegion != null;

		// get last region
		currentStructuredDocumentRegion = currentStructuredDocumentRegion
				.getPrevious();

		// search for last php block (then returns the last region)
		while (currentStructuredDocumentRegion != null
				&& currentStructuredDocumentRegion.getType() != TwigRegionContext.TWIG_CONTENT) {
			currentStructuredDocumentRegion = currentStructuredDocumentRegion
					.getPrevious();
		}

		return currentStructuredDocumentRegion;
	}	

}
