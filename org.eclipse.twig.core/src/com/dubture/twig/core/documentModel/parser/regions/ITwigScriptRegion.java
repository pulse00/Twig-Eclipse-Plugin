package org.eclipse.twig.core.documentModel.parser.regions;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;


/**
 * 
 * A TextRegion describing a Twig script region.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public interface ITwigScriptRegion extends ITextRegion {

	ITextRegion getTwigToken(int i) throws BadLocationException;
	ITextRegion[] getTwigTokens(int i, int j) throws BadLocationException;
	String getPartition(int internalOffset) throws BadLocationException;
	
	String getTwigTokenType(int offset) throws BadLocationException;	
		


}
