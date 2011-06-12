package org.eclipse.twig.core.documentModel.loader;

import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.php.internal.core.documentModel.loader.PHPDocumentLoader;
import org.eclipse.twig.core.documentModel.parser.TwigSourceParser;
import org.eclipse.twig.core.documentModel.parser.partitioner.TwigStructuredTextPartitioner;
import org.eclipse.wst.sse.core.internal.document.IDocumentLoader;
import org.eclipse.wst.sse.core.internal.ltk.parser.RegionParser;


/**
 * Provides the {@link TwigSourceParser} which
 * does the heavy lifting.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigDocumentLoader extends PHPDocumentLoader {
	
	
	@Override
	public RegionParser getParser() {
	
		TwigSourceParser parser = new TwigSourceParser();
		
		addHTMLishTag(parser, "script");
		addHTMLishTag(parser, "style");
		return parser;
	
	}
	
	@Override
	public IDocumentLoader newInstance() {

		return new TwigDocumentLoader();
	}
	
	@Override
	public IDocumentPartitioner getDefaultDocumentPartitioner() {
	
		return new TwigStructuredTextPartitioner();
	}

}
