package org.eclipse.twig.core.util.text;

import org.eclipse.php.internal.core.documentModel.parser.regions.PHPRegionTypes;
import org.eclipse.php.internal.core.util.text.PHPTextSequenceUtilities;
import org.eclipse.php.internal.core.util.text.TextSequence;
import org.eclipse.php.internal.core.util.text.TextSequenceUtilities;
import org.eclipse.twig.core.documentModel.parser.TwigRegionContext;
import org.eclipse.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import org.eclipse.twig.core.log.Logger;
import org.eclipse.wst.sse.core.internal.parser.ContextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionCollection;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionContainer;

/**
 * 
 * Utility class for Twig statements.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigTextSequenceUtilities  {

	public static TextSequence getStatement(int offset,
			IStructuredDocumentRegion sdRegion, boolean removeComments) {

		int documentOffset = offset;
		if (documentOffset == sdRegion.getEndOffset()) {
			documentOffset -= 1;
		}
		ITextRegion tRegion = sdRegion
				.getRegionAtCharacterOffset(documentOffset);

		ITextRegionCollection container = sdRegion;

		if (tRegion instanceof ITextRegionContainer) {
			container = (ITextRegionContainer) tRegion;
			tRegion = container.getRegionAtCharacterOffset(offset);
		}
		if (tRegion != null && tRegion.getType() == TwigRegionContext.TWIG_CLOSE) {
			tRegion = container.getRegionAtCharacterOffset(container
					.getStartOffset()
					+ tRegion.getStart() - 1);
		}

		// This text region must be of type PhpScriptRegion:
		if (tRegion != null
				&& TwigTextSequenceUtilities.isTwigRegion(tRegion.getType())) {
			ITwigScriptRegion twigScriptRegion = (ITwigScriptRegion) tRegion;

			try {
				// Set default starting position to the beginning of the
				// PhpScriptRegion:
				int startOffset = container.getStartOffset()
						+ twigScriptRegion.getStart();

				// Now, search backwards for the statement start (in this
				// PhpScriptRegion):
				ITextRegion startTokenRegion;
				if (documentOffset == startOffset) {
					startTokenRegion = twigScriptRegion.getTwigToken(0);
				} else {
					startTokenRegion = twigScriptRegion.getTwigToken(offset
							- startOffset - 1);
				}
				while (true) {
					// If statement start is at the beginning of the PHP script
					// region:
					if (startTokenRegion.getStart() == 0) {
						break;
					}
					

					if (startTokenRegion.getType() == PHPRegionTypes.PHP_CURLY_CLOSE
							|| startTokenRegion.getType() == PHPRegionTypes.PHP_CURLY_OPEN
							|| startTokenRegion.getType() == PHPRegionTypes.PHP_SEMICOLON) {
						// Calculate starting position of the statement (it
						// should go right after this startTokenRegion):
						startOffset += startTokenRegion.getEnd();
						break;
					}
					startTokenRegion = twigScriptRegion
							.getTwigToken(startTokenRegion.getStart() - 1);
				}

				TextSequence textSequence = TextSequenceUtilities
						.createTextSequence(sdRegion, startOffset, offset
								- startOffset);

				// remove spaces from start.
				textSequence = textSequence.subTextSequence(PHPTextSequenceUtilities.readForwardSpaces(
						textSequence, 0), textSequence.length());

				return textSequence;

			} catch (Exception e) {
				Logger.logException(e);
			}
		}

		return null;
	}

	
	/**
	 * 
	 * Checks if a {@link ContextRegion} type is a 
	 * Twig region.
	 * {@link ContextRegion}
	 * 
	 * @param context
	 * @return
	 */
	private static boolean isTwigRegion(String context) {

		return (context == TwigRegionContext.TWIG_CONTENT || context == TwigRegionContext.TWIG_COMMENT);
	}


	public static int readIdentifierStartIndex(TextSequence textSequence, int startPosition) {

		while (startPosition > 0) {
			char ch = textSequence.charAt(startPosition - 1);
			if (!Character.isLetterOrDigit(ch) && ch != '_' /*&& ch != '.'*/) {
				break;
			}
			startPosition--;
		}
		
		return startPosition;

	}
	
	
	/**
	 * 
	 * Checks if the statment cursor is indide a function call, ie
	 * 
	 * {% path('| 
	 * 
	 * 
	 * @param statement
	 * @return
	 */
	public static boolean isInFunction(TextSequence statement) {
		
		int startOffset = statement.length()-1;		
		int quotesCount = 0;
		
		while(startOffset > 0) {

			char ch = statement.charAt(startOffset);					
			
			if (ch == '(') {
				return true;
			} else if ( (ch== '\'' || ch == '"') && quotesCount++ > 0)
				return false;
			
			startOffset--;
			
		}
		
		return false;		
		
	}

	/**
	 * 
	 * Check if the statement text is inside a field, ie
	 * 
	 * <pre>
	 * 
	 *   {{ foo. | 
	 * </pre>
	 * 
	 * 
	 * @param statement
	 * @return
	 */
	public static boolean isInField(TextSequence statement) {

		int startOffset = statement.length()-1;
		
		while(startOffset > 0) {

			char ch = statement.charAt(startOffset);		
			
			if (ch == '(') {
				return false;
			} else if (ch == '.')
				return true;
			
			startOffset--;
			
		}
		
		return false;
	}


	/**
	 * 
	 * Return the previous variable in a statement like {{ form. <-- returns "form"
	 * 
	 * @param statement
	 * @return
	 */
	public static String getVariable(TextSequence statement) {

		int startOffset = statement.length()-1;		
		int dotOffset = -1;
		
		while(startOffset > 0) {
			
			char current = statement.charAt(startOffset);
			
			if(current == '.') {
				dotOffset = startOffset;
			}
			
			if (dotOffset > -1 && (Character.isWhitespace(current)) /*|| current == '.'*/) {
				break;
			}
			
			startOffset--;
			
		}
		
		if (dotOffset > -1) {
			return statement.toString().substring(startOffset, dotOffset).toString();
		}
		
		return null;
	}
}