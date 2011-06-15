package org.eclipse.twig.core.documentModel.parser.partitioner;

import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.php.internal.core.documentModel.partitioner.PHPStructuredTextPartitioner;
import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;



/**
 * 
 * 
 * @see http://code.google.com/p/smartypdt/source/browse/trunk/org.eclipse.php.smarty.core/src/org/eclipse/php/smarty/internal/core/documentModel/parser/partitioner/SmartyStructuredTextPartitioner.java
 *
 */
@SuppressWarnings("restriction")
public class TwigStructuredTextPartitioner extends PHPStructuredTextPartitioner {



	@Override
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

		
//		System.err.println("get partition type");
//		System.out.println(region.toString());

		// if smarty region
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

}
