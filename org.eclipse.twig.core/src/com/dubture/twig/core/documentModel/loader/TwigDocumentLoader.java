package com.dubture.twig.core.documentModel.loader;

import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.php.internal.core.documentModel.loader.PHPDocumentLoader;
import org.eclipse.php.internal.core.documentModel.parser.PhpStructuredDocumentReParser;
import org.eclipse.wst.sse.core.internal.document.IDocumentLoader;
import org.eclipse.wst.sse.core.internal.ltk.parser.RegionParser;
import org.eclipse.wst.sse.core.internal.provisional.document.IEncodedDocument;
import org.eclipse.wst.sse.core.internal.text.BasicStructuredDocument;

import com.dubture.twig.core.documentModel.parser.TwigSourceParser;
import com.dubture.twig.core.documentModel.parser.TwigStructuredDocumentReParser;
import com.dubture.twig.core.documentModel.parser.partitioner.TwigStructuredTextPartitioner;


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
	protected IEncodedDocument newEncodedDocument() {
		
		IEncodedDocument doc = super.newEncodedDocument();
		assert doc instanceof BasicStructuredDocument;
		((BasicStructuredDocument) doc)
				.setReParser(new TwigStructuredDocumentReParser());

		// doc.setPreferredLineDelimiter( "\n" );
		return doc;
	}
	
	
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