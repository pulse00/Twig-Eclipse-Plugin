package org.eclipse.twig.core.codeassist.context;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.core.PHPVersion;
import org.eclipse.php.internal.core.codeassist.CompletionCompanion;
import org.eclipse.php.internal.core.codeassist.IPHPCompletionRequestor;
import org.eclipse.php.internal.core.codeassist.contexts.AbstractCompletionContext;
import org.eclipse.php.internal.core.documentModel.parser.regions.PHPRegionTypes;
import org.eclipse.php.internal.core.documentModel.partitioner.PHPPartitionTypes;
import org.eclipse.php.internal.core.util.text.PHPTextSequenceUtilities;
import org.eclipse.php.internal.core.util.text.TextSequence;
import org.eclipse.twig.core.TwigCorePlugin;
import org.eclipse.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import org.eclipse.twig.core.model.Template;
import org.eclipse.twig.core.model.TwigModelAccess;
import org.eclipse.twig.core.util.Debug;
import org.eclipse.twig.core.util.text.TwigTextSequenceUtilities;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.core.internal.provisional.exceptions.ResourceAlreadyExists;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionCollection;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionContainer;


/**
 * 
 * The {@link AbstractTwigCompletionContext} checks if we're inside a twig structure:
 * 
 * <pre>
 * 
 * 	{{ ... | ... }}
 * 
 *  or 
 *  
 *  {% ... | .. %}
 * 
 * </pre>
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings("restriction")
public class AbstractTwigCompletionContext extends AbstractCompletionContext {


	private IStructuredDocument document;
	private CompletionCompanion companion;
	private CompletionRequestor requestor;
	private ISourceModule sourceModule;
	private int offset;
	private PHPVersion phpVersion;
	private IStructuredDocumentRegion structuredDocumentRegion;
	private ITextRegionCollection regionCollection;
	private ITwigScriptRegion twigScriptRegion;
	private String partitionType;
	private Template twigTemplate;
	
	public void init(CompletionCompanion companion) {
		this.companion = companion;
	}

	protected CompletionCompanion getCompanion() {
		return companion;
	}
	
	
	public ITwigScriptRegion getTwigScriptRegion() {
		return twigScriptRegion;
	}
	
	
	public Template getTemplate() {
				
		return twigTemplate;
		
	}
	


	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {

		try {
			
			this.requestor = requestor;
			this.sourceModule = sourceModule;
			this.offset = offset;
			
			if (sourceModule.getUnderlyingResource().getFileExtension().equals("php")) {				
				return false;
			}

			document = determineDocument(sourceModule, requestor);

			if (document != null) {

				structuredDocumentRegion = determineStructuredDocumentRegion(
						document, offset);

				if (structuredDocumentRegion != null) {

					regionCollection = determineRegionCollection(document,
							structuredDocumentRegion, offset);

					if (regionCollection != null) {

						twigScriptRegion = determineTwigRegion(document,
								regionCollection, offset);
												
						if (twigScriptRegion != null) {
							
							partitionType = determinePartitionType(
									regionCollection, twigScriptRegion, offset);
														
							
							twigTemplate = TwigModelAccess.getInstance().getTemplate(sourceModule);
							return true;

						}
					}
				} 
			}
		} catch (Exception e) {
			TwigCorePlugin.log(e);
		}		

		return false;

	}
	
	protected String determinePartitionType(
			ITextRegionCollection regionCollection,
			ITwigScriptRegion twigScriptRegion, int offset)
			throws BadLocationException {

		int internalOffset = offset - regionCollection.getStartOffset()
				- twigScriptRegion.getStart() - 1;
		String partitionType = twigScriptRegion.getPartition(internalOffset);

		// if we are at the begining of multi-line comment or docBlock then we
		// should get completion.
		if (partitionType == PHPPartitionTypes.PHP_MULTI_LINE_COMMENT
				|| partitionType == PHPPartitionTypes.PHP_DOC) {
			String regionType = twigScriptRegion.getTwigToken(internalOffset)
					.getType();
			if (regionType == PHPRegionTypes.PHP_COMMENT_START
					|| regionType == PHPRegionTypes.PHPDOC_COMMENT_START) {
				if (twigScriptRegion.getTwigToken(internalOffset).getStart() == internalOffset) {
					partitionType = twigScriptRegion
							.getPartition(internalOffset - 1);
				}
			}
		}
		return partitionType;
	}

	

	protected ITwigScriptRegion determineTwigRegion(IStructuredDocument document,
			ITextRegionCollection regionCollection, int offset) {
		
		ITextRegion textRegion = determineTextRegion(document,
				regionCollection, offset);
		
		twigScriptRegion = null;
		
		if (textRegion instanceof ITwigScriptRegion) {
			twigScriptRegion = (ITwigScriptRegion) textRegion;
		}

		return twigScriptRegion;
	}
	
	
	public boolean isExclusive() {
		return false;
	}

	/**
	 * Determines the structured document region of the place in PHP code where
	 * completion was requested
	 * 
	 * @return structured document region or <code>null</code> in case it could
	 *         not be determined
	 */
	protected IStructuredDocumentRegion determineStructuredDocumentRegion(
			IStructuredDocument document, int offset) {

		IStructuredDocumentRegion sdRegion = null;
		IStructuredDocumentRegion[] regions = document.getStructuredDocumentRegions();
		

		int lastOffset = offset;
		// find the structured document region:
		while (sdRegion == null && lastOffset >= 0) {
			sdRegion = document.getRegionAtCharacterOffset(lastOffset);
			lastOffset--;
		}

		return sdRegion;
	}

	/**
	 * Determines the relevant region collection of the place in PHP code where
	 * completion was requested
	 * 
	 * @return text region collection or <code>null</code> in case it could not
	 *         be determined
	 */
	protected ITextRegionCollection determineRegionCollection(
			IStructuredDocument document, IStructuredDocumentRegion sdRegion,
			int offset) {
		ITextRegionCollection regionCollection = sdRegion;

		ITextRegion textRegion = determineTextRegion(document, sdRegion, offset);
		if (textRegion instanceof ITextRegionContainer) {
			regionCollection = (ITextRegionContainer) textRegion;
		}
		return regionCollection;
	}

	/**
	 * Determines the text region from the text region collection and offset
	 * 
	 * @param regionCollection
	 * @param offset
	 */
	protected ITextRegion determineTextRegion(IStructuredDocument document,
			ITextRegionCollection regionCollection, int offset) {
		ITextRegion textRegion;
		// in case we are at the end of the document, asking for completion
		if (offset == document.getLength()) {
			textRegion = regionCollection.getLastRegion();
		} else {
			textRegion = regionCollection.getRegionAtCharacterOffset(offset);
		}
		return textRegion;
	}



	/**
	 * Determines the document associated with the editor where code assist has
	 * been invoked.
	 * 
	 * @param module
	 *            Source module ({@link ISourceModule})
	 * @param requestor
	 *            Completion requestor ({@link CompletionRequestor})
	 * @return structured document or <code>null</code> if it couldn't be found
	 * @throws CoreException
	 * @throws IOException
	 * @throws ResourceAlreadyExists
	 */
	protected IStructuredDocument determineDocument(ISourceModule module,
			CompletionRequestor requestor) throws ResourceAlreadyExists,
			IOException, CoreException {
		IStructuredDocument document = null;

		if (requestor instanceof IPHPCompletionRequestor) {
			IDocument d = ((IPHPCompletionRequestor) requestor).getDocument();
			if (d instanceof IStructuredDocument) {
				document = (IStructuredDocument) d;
			}
		}
		if (document == null) {
			IStructuredModel structuredModel = null;
			try {
				IFile file = (IFile) module.getResource();
				if (file != null) {
					if (file.exists()) {
						structuredModel = StructuredModelManager
								.getModelManager()
								.getExistingModelForRead(file);
						if (structuredModel != null) {
							document = structuredModel.getStructuredDocument();
						} else {
							document = StructuredModelManager.getModelManager()
									.createStructuredDocumentFor(file);
						}
					} else {
						document = StructuredModelManager.getModelManager()
								.createNewStructuredDocumentFor(file);
						document.set(module.getSource());
					}
				}
			} finally {
				if (structuredModel != null) {
					structuredModel.releaseFromRead();
				}
			}
		}

		return document;
	}

	/**
	 * Returns PHP version of the file where code assist was requested
	 * 
	 * @return PHP version
	 * @see #isValid(ISourceModule, int, CompletionRequestor)
	 */
	public PHPVersion getPhpVersion() {
		return phpVersion;
	}

	/**
	 * Returns the file where code assist was requested
	 * 
	 * @return source module
	 * @see #isValid(ISourceModule, int, CompletionRequestor)
	 */
	public ISourceModule getSourceModule() {
		return sourceModule;
	}

	/**
	 * Returns document associated with the editor where code assist was
	 * requested
	 * 
	 * @return document
	 * @see #isValid(ISourceModule, int, CompletionRequestor)
	 */
	public IStructuredDocument getDocument() {
		return document;
	}

	/**
	 * Returns the relevant region collection of the place in PHP code where
	 * completion was requested
	 * 
	 * @return text region collection
	 * @see #isValid(ISourceModule, int, CompletionRequestor)
	 */
	public ITextRegionCollection getRegionCollection() {
		return regionCollection;
	}

	/**
	 * Returns the PHP script region of PHP code where completion was requested
	 * 
	 * @return php script region (see {@link ItwigScriptRegion})
	 * @see #isValid(ISourceModule, int, CompletionRequestor)
	 */
	public ITwigScriptRegion gettwigScriptRegion() {
		return twigScriptRegion;
	}

	/**
	 * Returns partition type of the code where cursor is located.
	 * 
	 * @return partition type (see {@link PHPRegionTypes})
	 * @see #isValid(ISourceModule, int, CompletionRequestor)
	 */
	public String getPartitionType() {
		return partitionType;
	}

	/**
	 * Returns the statement text that is before the cursor
	 * 
	 * @return statement text
	 * @see #isValid(ISourceModule, int, CompletionRequestor)
	 */
	public TextSequence getStatementText() {
		
		return TwigTextSequenceUtilities.getStatement(offset,
				structuredDocumentRegion, true);
	}

	/**
	 * Returns whether there are whitespace characters before the cursor where
	 * code assist was being invoked
	 * 
	 * @return <code>true</code> if there are whitespace characters before the
	 *         cursor
	 */
	public boolean hasWhitespaceBeforeCursor() {
		TextSequence statementText = getStatementText();
		
		assert statementText != null;

		// determine whether there are whitespaces before the cursor
		int statementLength = statementText.length();
		int statementEnd = PHPTextSequenceUtilities.readBackwardSpaces(
				statementText, statementLength);
		return statementLength != statementEnd;
	}

	/**
	 * Returns completion requestor
	 * 
	 * @return completion requestor (see {@link CompletionRequestor})
	 * @see #isValid(ISourceModule, int, CompletionRequestor)
	 */
	public CompletionRequestor getCompletionRequestor() {
		return requestor;
	}

	/**
	 * Returns offset of the cursor position when code assist was invoked
	 * 
	 * @return offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * Returns previous word before the cursor position
	 * 
	 * @throws BadLocationException
	 */
	public String getPreviousWord() throws BadLocationException {
		TextSequence statementText = getStatementText();

		int statementLength = statementText.length();
		int wordEnd = PHPTextSequenceUtilities.readBackwardSpaces(
				statementText, statementLength); // read whitespace
		int wordStart = PHPTextSequenceUtilities.readIdentifierStartIndex(
				phpVersion, statementText, wordEnd, true);
		if (wordStart < 0 || wordEnd < 0 || wordStart > wordEnd) {
			return "";
		}
		String previousWord = statementText.subSequence(wordStart, wordEnd)
				.toString();

		if (hasWhitespaceBeforeCursor()) {
			return previousWord;
		}

		wordEnd = PHPTextSequenceUtilities.readBackwardSpaces(statementText,
				wordStart - 1); // read whitespace
		wordStart = PHPTextSequenceUtilities.readIdentifierStartIndex(
				phpVersion, statementText, wordEnd, true);
		if (wordStart < 0 || wordEnd < 0 || wordStart > wordEnd) {
			return "";
		}
		previousWord = statementText.subSequence(wordStart, wordEnd).toString();

		return previousWord;
	}

	/**
	 * Returns previous word before the cursor position
	 * 
	 * @throws BadLocationException
	 */
	public String getPreviousWord(int times) throws BadLocationException {
		TextSequence statementText = getStatementText();

		int statementLength = statementText.length();
		int wordEnd = PHPTextSequenceUtilities.readBackwardSpaces(
				statementText, statementLength); // read whitespace
		int wordStart = PHPTextSequenceUtilities.readIdentifierStartIndex(
				phpVersion, statementText, wordEnd, true);

		for (int i = 0; i < times - 1; i++) {
			statementLength = wordStart;
			wordEnd = PHPTextSequenceUtilities.readBackwardSpaces(
					statementText, statementLength); // read whitespace
			wordStart = PHPTextSequenceUtilities.readIdentifierStartIndex(
					phpVersion, statementText, wordEnd, true);

		}
		if (wordStart < 0 || wordEnd < 0 || wordStart > wordEnd) {
			return "";
		}
		String previousWord = statementText.subSequence(wordStart, wordEnd)
				.toString();

		if (hasWhitespaceBeforeCursor()) {
			return previousWord;
		}

		wordEnd = PHPTextSequenceUtilities.readBackwardSpaces(statementText,
				wordStart - 1); // read whitespace
		wordStart = PHPTextSequenceUtilities.readIdentifierStartIndex(
				phpVersion, statementText, wordEnd, true);
		if (wordStart < 0 || wordEnd < 0 || wordStart > wordEnd) {
			return "";
		}
		previousWord = statementText.subSequence(wordStart, wordEnd).toString();

		return previousWord;
	}

	/**
	 * Returns PHP token under offset
	 * 
	 * @return PHP token
	 * @throws BadLocationException
	 */
	public ITextRegion getTwigToken() throws BadLocationException {
		return getTwigToken(offset);
	}

	public ITextRegion getTwigToken(int offset) throws BadLocationException {
		return twigScriptRegion.getTwigToken(offset
				- regionCollection.getStartOffset()
				- twigScriptRegion.getStart() - 1);
	}

	/**
	 * Returns the word on which code assist was invoked
	 * 
	 * @return prefix
	 * @throws BadLocationException
	 */
	public String getPrefix() throws BadLocationException {
		return getPrefixWithoutProcessing();
	}

	public String getPrefixWithoutProcessing() {
		
		if (hasWhitespaceBeforeCursor()) {
			return ""; //$NON-NLS-1$
		}
		TextSequence statementText = getStatementText();
		int statementLength = statementText.length();
		int prefixEnd = PHPTextSequenceUtilities.readBackwardSpaces(
				statementText, statementLength); // read whitespace
		
		int prefixStart = TwigTextSequenceUtilities.readIdentifierStartIndex(statementText, prefixEnd);
		
		return statementText.subSequence(prefixStart, prefixEnd).toString();
	}

	/**
	 * Returns the end of the word on which code assist was invoked
	 * 
	 * @return
	 * @throws BadLocationException
	 */
	public int getPrefixEnd() throws BadLocationException {
		ITextRegion phpToken = getTwigToken();
		int endOffset = regionCollection.getStartOffset()
				+ twigScriptRegion.getStart() + phpToken.getTextEnd();
		if (phpToken.getType() == PHPRegionTypes.PHP_CONSTANT_ENCAPSED_STRING) {
			--endOffset;
		}
		return endOffset;
	}

	/**
	 * Returns next PHP token after offset
	 * 
	 * @return PHP token
	 * @throws BadLocationException
	 */
	public ITextRegion getNextTwigToken() throws BadLocationException {
		
		ITextRegion twigToken = getTwigToken();
		do {
			twigToken = twigScriptRegion.getTwigToken(twigToken.getEnd());
			if (!PHPPartitionTypes.isPHPCommentState(twigToken.getType())
					&& twigToken.getType() != PHPRegionTypes.WHITESPACE) {
				break;
			}
		} while (twigToken.getEnd() < twigScriptRegion.getLength());

		return twigToken;
		
	}

	public ITextRegion getNextTwigToken(int times) throws BadLocationException {
		ITextRegion twigToken = null;
		int offset = this.offset;
		while (times-- > 0) {
			twigToken = getTwigToken(offset);
			do {
				twigToken = twigScriptRegion.getTwigToken(twigToken.getEnd());
				if (!PHPPartitionTypes.isPHPCommentState(twigToken.getType())
						&& twigToken.getType() != PHPRegionTypes.WHITESPACE) {
					break;
				}
			} while (twigToken.getEnd() < twigScriptRegion.getLength());
			if (twigToken == null) {
				return null;
			} else {
				offset = regionCollection.getStartOffset()
						+ twigScriptRegion.getStart() + twigToken.getEnd();
			}
		}

		return twigToken;
	}

	/**
	 * Returns next word after the cursor position
	 * 
	 * @throws BadLocationException
	 */
	public String getNextWord() throws BadLocationException {
		ITextRegion nextTwigToken = getNextTwigToken();
		return document
				.get(regionCollection.getStartOffset()
						+ twigScriptRegion.getStart() + nextTwigToken.getStart(),
						nextTwigToken.getTextLength());
	}

	public String getNextWord(int times) throws BadLocationException {
		ITextRegion nextTwigToken = getNextTwigToken(times);
		return document
				.get(regionCollection.getStartOffset()
						+ twigScriptRegion.getStart() + nextTwigToken.getStart(),
						nextTwigToken.getTextLength());
	}

	/**
	 * Returns next word after the cursor position
	 * 
	 * @throws BadLocationException
	 */
	public char getNextChar() throws BadLocationException {
		// if the current location is the end of the document,we return ' ' to
		// avoid the BadLocationException
		if (document.getLength() == offset) {
			return ' ';
		}
		return document.getChar(offset);
	}	
}