/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.parser.regions;


import java.io.IOException;
import java.io.Reader;
import java.util.ListIterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.core.PHPCorePlugin;
import org.eclipse.php.internal.core.documentModel.parser.Scanner.LexerState;
import org.eclipse.php.internal.core.documentModel.parser.regions.IPhpScriptRegion;
import org.eclipse.wst.sse.core.internal.parser.ForeignRegion;
import org.eclipse.wst.sse.core.internal.provisional.events.StructuredDocumentEvent;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.xml.core.internal.Logger;

import com.dubture.twig.core.documentModel.parser.AbstractTwigLexer;
import com.dubture.twig.core.documentModel.parser.TwigLexer;

/**
 * 
 * 
 * {@link ITwigScriptRegion} implementation.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigScriptRegion extends ForeignRegion implements ITwigScriptRegion {

	private static final String TWIG_SCRIPT = "Twig Script";

//	private int ST_PHP_LINE_COMMENT = -1;
	private int ST_TWIG_CONTENT = -1;

	private IProject project;

	private boolean isFullReparsed;
	
	private final TwigTokenContainer tokensContainer = new TwigTokenContainer();	
	
	public TwigScriptRegion(String newContext, int startOffset,
			IProject project, AbstractTwigLexer twigLexer, String lexerState) {
		
		super(newContext, startOffset, 0, 0, TwigScriptRegion.TWIG_SCRIPT);
		
		this.project = project;

		try {
			// we use reflection here since we don't know the constant value of
			// of this state in specific PHP version lexer
//			ST_PHP_LINE_COMMENT = twigLexer.getClass()
//					.getField("ST_PHP_LINE_COMMENT").getInt(twigLexer);
			
			
			ST_TWIG_CONTENT = twigLexer.getClass()
					.getField(lexerState).getInt(twigLexer);
		} catch (Exception e) {
			
			Logger.logException(e);
		}
		completeReparse(twigLexer);
		
		
	}
	
	public boolean isFullReparsed() {
		return isFullReparsed;
	}
	
	public String getPartition(int offset) throws BadLocationException {
		return tokensContainer.getPartitionType(offset);
	}
	
	
	
	private boolean startQuoted(final String text) {
		final int length = text.length();
		if (length == 0) {
			return false;
		}

		boolean isOdd = false;
		for (int index = 0; index < length; index++) {
			final char charAt = text.charAt(index);
			if (charAt == '"' || charAt == '\'') {
				isOdd = !isOdd;
			}
		}
		return isOdd;
	}
	
	private TwigLexer getTwigLexer(Reader stream, LexerState startState) {
		
		final TwigLexer lexer = new TwigLexer(stream);
		lexer.initialize(ST_TWIG_CONTENT);
		lexer.setPatterns(project);

		// set the wanted state
		if (startState != null) {
			startState.restoreState(lexer);
		}
		
		return lexer;
	}
	
	
	
	@Override
	public StructuredDocumentEvent updateRegion(Object requester,
			IStructuredDocumentRegion flatnode, String changes,
			int requestStart, int lengthToReplace) {
		isFullReparsed = true;
		try {
			final int offset = requestStart - flatnode.getStartOffset()
					- getStart();

			// support the <?php case
			if (offset < 4) {
				return null;
			}
			// checks for odd quotes
			final String deletedText = lengthToReplace == 0 ? "" : flatnode.getParentDocument().get(requestStart, lengthToReplace); //$NON-NLS-1$
			final int length = changes.length();
			if (startQuoted(deletedText) || startQuoted(changes)) {
				return null;
			}

			// get the region to re-parse
			ITextRegion tokenStart = tokensContainer.getToken(offset == 0 ? 0
					: offset - 1);
			ITextRegion tokenEnd = tokensContainer.getToken(offset
					+ lengthToReplace);

			// make sure, region to re-parse doesn't start with unknown token
			while (TwigRegionTypes.UNKNOWN_TOKEN.equals(tokenStart.getType())
					&& (tokenStart.getStart() > 0)) {
				tokenStart = tokensContainer.getToken(tokenStart.getStart() - 1);
			}

			// move sure, region to re-parse doesn't end with unknown token
			while (TwigRegionTypes.UNKNOWN_TOKEN.equals(tokenEnd.getType())
					&& (tokensContainer.getLastToken() != tokenEnd)) {
				tokenEnd = tokensContainer.getToken(tokenEnd.getEnd() + 1);
			}

			boolean shouldDeprecatedKeyword = false;
			int previousIndex = tokensContainer.twigTokens.indexOf(tokenStart) - 1;
			if (previousIndex >= 0) {
				ITextRegion previousRegion = tokensContainer.twigTokens
						.get(previousIndex);
				
				if (tokenStart.getType().equals(TwigRegionTypes.TWIG_COMMENT)
						&& tokenStart.getLength() == 1
						&& previousRegion.getType().equals(
								TwigRegionTypes.TWIG_COMMENT_OPEN)) {
					requestStart = previousRegion.getStart();
				}

			}

			int newTokenOffset = tokenStart.getStart();


			// get start and end states
			final LexerState startState = tokensContainer
					.getState(newTokenOffset);
			final LexerState endState = tokensContainer.getState(tokenEnd
					.getEnd() + 1);

			final TwigTokenContainer newContainer = new TwigTokenContainer();
			final TwigLexer twigLexer = getTwigLexer(new DocumentReader(
					flatnode, changes, requestStart, lengthToReplace,
					newTokenOffset), startState);

			Object state = startState;
			try {
				String yylex = twigLexer.getNextToken();
				if (shouldDeprecatedKeyword
						&& TwigTokenContainer.isKeyword(yylex)) {
					yylex = TwigRegionTypes.PHP_STRING;
				}
				int yylength;
				final int toOffset = offset + length;
				while (yylex != null && newTokenOffset <= toOffset && (yylex != TwigRegionTypes.TWIG_COMMENT_CLOSE && yylex != TwigRegionTypes.TWIG_CLOSETAG && yylex != TwigRegionTypes.TWIG_STMT_CLOSE)) {
					
					yylength = twigLexer.getLength();
					newContainer.addLast(yylex, newTokenOffset, yylength,
							yylength, state);
					newTokenOffset += yylength;
					state = twigLexer.createLexicalStateMemento();
					yylex = twigLexer.getNextToken();
				}
				if (yylex == TwigRegionTypes.WHITESPACE) {
					yylength = twigLexer.getLength();
					newContainer.adjustWhitespace(yylex, newTokenOffset,
							yylength, yylength, state);
				}
			} catch (IOException e) {
				Logger.logException(e);
			}

			// if the fast reparser couldn't lex - - reparse all
			if (newContainer.isEmpty()) {
				return null;
			}

			// if the two streams end with the same lexer sate -
			// 1. replace the regions
			// 2. adjust next regions start location
			// 3. update state changes
			final int size = length - lengthToReplace;
			final int end = newContainer.getLastToken().getEnd();

			if (!state.equals(endState) || tokenEnd.getEnd() + size != end) {
				return null;
			}

			// 1. replace the regions
			final ListIterator oldIterator = tokensContainer
					.removeTokensSubList(tokenStart, tokenEnd);
			ITextRegion[] newTokens = newContainer.getTwigTokens(); // now, add
			// the new
			// ones
			for (int i = 0; i < newTokens.length; i++) {
				oldIterator.add(newTokens[i]);
			}

			// 2. adjust next regions start location
			while (oldIterator.hasNext()) {
				final ITextRegion adjust = (ITextRegion) oldIterator.next();
				adjust.adjustStart(size);
			}

			// 3. update state changes
			tokensContainer.updateStateChanges(newContainer,
					tokenStart.getStart(), end);
			isFullReparsed = false;

			return super.updateRegion(requester, flatnode, changes,
					requestStart, lengthToReplace);

		} catch (BadLocationException e) {
			PHPCorePlugin.log(e);
			return null; // causes to full reparse in this case
		}
	}
	
	
	public int getTokenCount() {
		
		return tokensContainer.size();
		
	}
	
	

	private void completeReparse(AbstractTwigLexer twigLexer) {
		setTwigtokens(twigLexer);
		
	}



	private void setTwigtokens(AbstractTwigLexer lexer) {
		setLength(0);
		setTextLength(0);

		isFullReparsed = true;
		assert lexer != null;
		
		int s = 0;

		int start = 0;
		this.tokensContainer.getModelForCreation();
		this.tokensContainer.reset();
		try {
			Object state = lexer.createLexicalStateMemento();
			String yylex = lexer.getNextToken();
			int yylength = 0;
			while (yylex != null && (yylex != TwigRegionTypes.TWIG_COMMENT_CLOSE && yylex != TwigRegionTypes.TWIG_CLOSETAG && yylex != TwigRegionTypes.TWIG_STMT_CLOSE)) {
				
				yylength = lexer.getLength();
				this.tokensContainer.addLast(yylex, start, yylength, yylength, state);
				start += yylength;
				state = lexer.createLexicalStateMemento();
				yylex = lexer.getNextToken();


			}
			
			adjustLength(start);
			adjustTextLength(start);


		} catch (Exception e) {
			
			Logger.logException(e);

		} finally {

			this.tokensContainer.releaseModelFromCreation();
		}
	}



	@Override
	public ITextRegion getTwigToken(int offset) throws BadLocationException {
 
		return tokensContainer.getToken(offset);

	}
	
	/**
	 * @see IPhpScriptRegion#getPhpTokens(int, int)
	 */
	public final ITextRegion[] getTwigTokens(int offset, int length)
			throws BadLocationException {
		return tokensContainer.getTokens(offset, length);
	}
	
	/**
	 * Returns a stream that represents the new text We have three regions: 1)
	 * the php region before the change 2) the change 3) the php region after
	 * the region without the deleted text
	 * 
	 * @param flatnode
	 * @param change
	 * @param requestStart
	 * @param lengthToReplace
	 * @param newTokenOffset
	 */
	private class DocumentReader extends Reader {

		private static final String BAD_LOCATION_ERROR = "Bad location error "; //$NON-NLS-1$

		final private IStructuredDocument parent;
		final private int startPhpRegion;
		final private int endPhpRegion;
		final private int changeLength;
		final private String change;
		final private int requestStart;
		final private int lengthToReplace;

		private int index;
		private int internalIndex = 0;

		public DocumentReader(final IStructuredDocumentRegion flatnode,
				final String change, final int requestStart,
				final int lengthToReplace, final int newTokenOffset) {
			this.parent = flatnode.getParentDocument();
			this.startPhpRegion = flatnode.getStart() + getStart();
			this.endPhpRegion = startPhpRegion + getLength();
			this.changeLength = change.length();
			this.index = startPhpRegion + newTokenOffset;
			this.change = change;
			this.requestStart = requestStart;
			this.lengthToReplace = lengthToReplace;
		}

		@Override
		public int read() throws IOException {
			try {
				// state 1)
				if (index < requestStart) {
					return parent.getChar(index++);
				} // state 2)
				if (internalIndex < changeLength) {
					return change.charAt(internalIndex++);
				}
				// skip the delted text
				if (index < requestStart + lengthToReplace) {
					index = requestStart + lengthToReplace;
				}
				// state 3)
				return index < endPhpRegion ? parent.getChar(index++) : -1;

			} catch (BadLocationException e) {
				throw new IOException(DocumentReader.BAD_LOCATION_ERROR);
			}
		}

		@Override
		public int read(char[] b, int off, int len) throws IOException {
			/**
			 * For boosting performance - Read only 80 characters from the
			 * buffer as the changes are usually small
			 * 
			 * Start of change
			 */
			len = len > 80 ? 80 : len;
			/**
			 * End of change
			 */

			if (b == null) {
				throw new NullPointerException();
			} else if ((off < 0) || (off > b.length) || (len < 0)
					|| ((off + len) > b.length) || ((off + len) < 0)) {
				throw new IndexOutOfBoundsException();
			} else if (len == 0) {
				return 0;
			}

			int c = read();
			if (c == -1) {
				return -1;
			}
			b[off] = (char) c;

			int i = 1;
			try {
				for (; i < len; i++) {
					c = read();
					if (c == -1) {
						break;
					}
					if (b != null) {
						b[off + i] = (char) c;
					}
				}
			} catch (IOException ee) {
			}
			return i;
		}

		@Override
		public void close() throws IOException {
		}
	}

	/**
	 * Returns a stream that represents the document
	 * 
	 * @param StructuredDocument
	 * @param start
	 * @param length
	 */
	public static class BlockDocumentReader extends Reader {

		private static final String BAD_LOCATION_ERROR = "Bad location error "; //$NON-NLS-1$

		final private IDocument parent;
		private int startPhpRegion;
		final private int endPhpRegion;

		public BlockDocumentReader(final IDocument parent,
				final int startPhpRegion, final int length) {
			this.parent = parent;
			this.startPhpRegion = startPhpRegion;
			this.endPhpRegion = startPhpRegion + length;
		}

		@Override
		public int read() throws IOException {
			try {
				return startPhpRegion < endPhpRegion ? parent
						.getChar(startPhpRegion++) : -1;
			} catch (BadLocationException e) {
				throw new IOException(BAD_LOCATION_ERROR + startPhpRegion);
			}
		}

		@Override
		public int read(char[] b, int off, int len) throws IOException {
			if (b == null) {
				throw new NullPointerException();
			} else if ((off < 0) || (off > b.length) || (len < 0)
					|| ((off + len) > b.length) || ((off + len) < 0)) {
				throw new IndexOutOfBoundsException();
			} else if (len == 0) {
				return 0;
			}

			int c = read();
			if (c == -1) {
				return -1;
			}
			b[off] = (char) c;

			int i = 1;
			try {
				for (; i < len; i++) {
					c = read();
					if (c == -1) {
						break;
					}
					if (b != null) {
						b[off + i] = (char) c;
					}
				}
			} catch (IOException ee) {
			}
			return i;
		}

		@Override
		public void close() throws IOException {
		}
	}
	
	public final String getTwigTokenType(int offset) throws BadLocationException {
		final ITextRegion tokenForOffset = getTwigToken(offset);
		return tokenForOffset == null ? null : tokenForOffset.getType();
	}
	
	
}
