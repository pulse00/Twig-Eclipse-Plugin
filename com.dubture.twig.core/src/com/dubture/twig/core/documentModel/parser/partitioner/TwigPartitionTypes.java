package com.dubture.twig.core.documentModel.parser.partitioner;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.php.internal.core.documentModel.parser.regions.IPhpScriptRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;

import com.dubture.twig.core.documentModel.parser.TwigRegionContext;
import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;


/**
 * 
 * 
 * @see http://code.google.com/p/smartypdt/source/browse/trunk/org.eclipse.php.smarty.core/src/org/eclipse/php/smarty/internal/core/documentModel/parser/partitioner/SmartyPartitionTypes.java
 *
 */
@SuppressWarnings("restriction")
public class TwigPartitionTypes {
	
	
	public static final String TWIG_DEFAULT = "com.dubture.twig.TWIG_DEFAULT"; //$NON-NLS-1$
	public static final String TWIG_COMMENT_TEXT = "com.dubture.twig.TWIG_COMMENT_TEXT"; //$NON-NLS-1$
	public static final String TWIG_STRING = "com.dubture.twig.TWIG_STRING"; //$NON-NLS-1$
	public static final String TWIG_QUOTED_STRING = "com.dubture.twig.TWIG_QUOTED_STRING"; //$NON-NLS-1$

	public final static String[] configuredPartitions = new String[] { TWIG_DEFAULT, TWIG_COMMENT_TEXT, TWIG_STRING, TWIG_QUOTED_STRING};

	public static boolean isTwigPartition(String regionType) {
		return regionType == TWIG_DEFAULT || regionType == TWIG_COMMENT_TEXT || regionType == TWIG_STRING || regionType == TWIG_QUOTED_STRING;
	}

	/**
	 * Returns starting region of the current partition
	 * 
	 * @param region Region containing current offset
	 * @param offset Current position relative to the containing region
	 * @return Starting region of the current partition
	 * @throws BadLocationException
	 */
	public static final ITextRegion getPartitionStartRegion(IPhpScriptRegion region, int offset) throws BadLocationException {
		String partitionType = region.getPartition(offset);
		ITextRegion internalRegion = region.getPhpToken(offset);
		ITextRegion startRegion = internalRegion;
		while (internalRegion.getStart() != 0) {
			internalRegion = region.getPhpToken(internalRegion.getStart() - 1);
			if (region.getPartition(internalRegion.getStart()) != partitionType) {
				break;
			}
			startRegion = internalRegion;
		}
		return startRegion;
	}

	/**
	 * Returns offset where the current partition starts
	 * 
	 * @param region Region containing current offset
	 * @param offset Current position relative to the containing region
	 * @return Starting offset of the current partition
	 * @throws BadLocationException
	 */
	public static final int getPartitionStart(IPhpScriptRegion region, int offset) throws BadLocationException {
		ITextRegion startRegion = getPartitionStartRegion(region, offset);
		return startRegion.getStart();
	}

	/**
	 * Returns region current partition ends on
	 * 
	 * @param region Region containing current offset
	 * @param offset Current position relative to the containing region
	 * @return Ending region of the current partition
	 * @throws BadLocationException
	 */
	public static final ITextRegion getPartitionEndRegion(IPhpScriptRegion region, int offset) throws BadLocationException {
		String partitionType = region.getPartition(offset);
		ITextRegion internalRegion = region.getPhpToken(offset);
		ITextRegion endRegion = internalRegion;
		while (internalRegion.getEnd() != region.getLength()) {
			internalRegion = region.getPhpToken(internalRegion.getEnd());
			if (region.getPartition(internalRegion.getStart()) != partitionType) {
				break;
			}
			endRegion = internalRegion;
		}
		return endRegion;
	}

	/**
	 * Returns offset where the current partition ends
	 * 
	 * @param region Region containing current offset
	 * @param offset Current position relative to the containing region
	 * @return Ending offset of the current partition
	 * @throws BadLocationException
	 */
	public static final int getPartitionEnd(IPhpScriptRegion region, int offset) throws BadLocationException {
		ITextRegion endRegion = getPartitionEndRegion(region, offset);
		return endRegion.getEnd();
	}

	/**
	 * Returns partition which corresponds to the provided offset
	 * 
	 * @param region Region containing current offset
	 * @param offset Current position relative to the containing region
	 * @return typed region containing partition
	 * @throws BadLocationException
	 */
	public static final ITypedRegion getPartition(IPhpScriptRegion region, int offset) throws BadLocationException {
		String partitionType = region.getPartition(offset);
		int startOffset = getPartitionStart(region, offset);
		int endOffset = getPartitionEnd(region, offset);
		return new TypedRegion(startOffset, endOffset - startOffset, partitionType);
	}

	public static boolean isTwigCommentState(String type) {
		// TODO Auto-generated method stub
		return type == TwigRegionTypes.TWIG_COMMENT;
	}

	public static boolean isTwigQuotesState(String type) {
		return type == TwigPartitionTypes.TWIG_QUOTED_STRING || type == TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING;		

	}	
}
