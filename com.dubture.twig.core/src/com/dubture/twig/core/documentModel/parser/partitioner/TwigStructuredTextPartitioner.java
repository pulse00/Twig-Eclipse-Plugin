/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.parser.partitioner;

import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.wst.html.core.internal.text.StructuredTextPartitionerForHTML;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;

import com.dubture.twig.core.documentModel.parser.TwigRegionContext;

/**
 * 
 * 
 * @see http ://code.google.com/p/smartypdt/source/browse/trunk/org.eclipse.php.
 *      smarty
 *      .core/src/org/eclipse/php/smarty/internal/core/documentModel/parser/
 *      partitioner/SmartyStructuredTextPartitioner.java
 * 
 */
@SuppressWarnings("restriction")
public class TwigStructuredTextPartitioner extends StructuredTextPartitionerForHTML {

	public String getContentType(int offset, boolean preferOpenPartitions) {

		final ITypedRegion partition = getPartition(offset);
		return partition == null ? null : partition.getType();

	}

	@Override
	public String getContentType(int offset) {

		final ITypedRegion partition = getPartition(offset);
		return partition == null ? null : partition.getType();

	}

	@Override
	public String getPartitionType(ITextRegion region, int offset) {

		// if twig region
		final String type = region.getType();
		if (type.startsWith("TWIG_")) {
			if (type == TwigRegionContext.TWIG_COMMENT) {
				return TwigPartitionTypes.TWIG_COMMENT_TEXT;
			} else if (type == TwigRegionContext.TWIG_CONSTANT_ENCAPSED_STRING) {
				return TwigPartitionTypes.TWIG_STRING;
			} else if (type == TwigRegionContext.TWIG_DOUBLE_QUOTES_CONTENT) {
				return TwigPartitionTypes.TWIG_QUOTED_STRING;
			} else {
				return TwigPartitionTypes.TWIG_DEFAULT;
			}
		}

		// else do super
		return super.getPartitionType(region, offset);

	}

	/**
	 * to be abstract eventually
	 */
	@Override
	protected void initLegalContentTypes() {
		super.initLegalContentTypes();

		final int length = fSupportedTypes.length;
		final String[] types = new String[fSupportedTypes.length + 1];

		System.arraycopy(fSupportedTypes, 0, types, 0, length);
		types[length] = TwigPartitionTypes.TWIG_DEFAULT;

		fSupportedTypes = types;
	}

	public static String[] getConfiguredContentTypes() {
		return TwigPartitionTypes.configuredPartitions;
	}

	@Override
	public IDocumentPartitioner newInstance() {

		return new TwigStructuredTextPartitioner();
	}

	@Override
	public ITypedRegion getPartition(int offset) {

		// in case we are in the end of document
		// we return the partition of last region
		int docLength = fStructuredDocument.getLength();
		if (offset == docLength) {
			return super.getPartition(offset - 1);
		}
		return super.getPartition(offset);

	}

	@Override
	public ITypedRegion[] computePartitioning(int offset, int length) {
		// workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=268930
		ITypedRegion[] result = new ITypedRegion[0];
		try {
			result = super.computePartitioning(offset, length);
		} catch (NullPointerException e) {
		}
		return result;
	}

}
