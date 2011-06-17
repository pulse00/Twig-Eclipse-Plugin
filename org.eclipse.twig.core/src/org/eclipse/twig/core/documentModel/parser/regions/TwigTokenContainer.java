package org.eclipse.twig.core.documentModel.parser.regions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.php.internal.core.documentModel.parser.Scanner.LexerState;
import org.eclipse.twig.core.documentModel.parser.AbstractTwigLexer;
import org.eclipse.wst.sse.core.internal.parser.ContextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;

@SuppressWarnings("restriction")
public class TwigTokenContainer {

	// holds Twig tokens
	protected final LinkedList<ContextRegion> twigTokens = new LinkedList<ContextRegion>(); // of
	// ITextRegion

	// holds the location and state, where the lexical anlyzer state was changed
	protected final LinkedList<LexerStateChange> lexerStateChanges = new LinkedList<LexerStateChange>(); // of
	// LexerStateChanged

	// holds the iterator for the twig tokens linked list
	// this iterator follows the localization principle
	// i.e. the user usually works in the same area of the document
	protected ListIterator<ContextRegion> tokensIterator = null;

	public void getModelForCreation() {
		tokensIterator = null;

	}
	
	
	public int size() {
		
		return twigTokens.size();
		
	}

	public void reset() {
		this.twigTokens.clear();
		this.lexerStateChanges.clear();		
	}
	
	protected final ITextRegion getLastToken() {
		return twigTokens.getLast();
	}
	
	
	protected LexerStateChange getLastChange() {
		return lexerStateChanges.getLast();
	}
	

	public synchronized void addLast(String yylex, int start, int yylengthLength, int yylength, Object lexerState) {


		assert (twigTokens.size() == 0 || getLastToken().getEnd() == start)
		&& tokensIterator == null;

		if (twigTokens.size() > 0) {
			ContextRegion lastContextRegion = (ContextRegion) twigTokens
					.get(twigTokens.size() - 1);
		}
		// if state was change - we add a new token and add state
		if (lexerStateChanges.size() == 0
				|| !getLastChange().state.equals(lexerState)) {
			int textLength = (AbstractTwigLexer.WHITESPACE.equals(yylex)) ? 0
					: yylengthLength;

			final ContextRegion contextRegion = new ContextRegion(yylex, start,
					textLength, yylength);
			twigTokens.addLast(contextRegion);
			lexerStateChanges.addLast(new LexerStateChange(
					(LexerState) lexerState, contextRegion));
			return;
		}

		assert twigTokens.size() > 0;
		// if we can only adjust the previous token size
		if (yylex == AbstractTwigLexer.WHITESPACE) {
			final ITextRegion last = twigTokens.getLast();
			last.adjustLength(yylength);
		} else { // else - add as a new token
			final ContextRegion contextRegion = new ContextRegion(yylex, start,
					yylengthLength, yylength);
			twigTokens.addLast(contextRegion);
		}		

	}

	public void releaseModelFromCreation() {
		tokensIterator = twigTokens.listIterator();

	}

	/**
	 * This node represent a change in the lexer state during lexical analysis
	 */
	protected static final class LexerStateChange {
		public final LexerState state;
		public final ITextRegion firstRegion;

		public LexerStateChange(final LexerState state,
				final ITextRegion firstRegion) {
			assert firstRegion != null && state != null;

			this.state = state;
			this.firstRegion = firstRegion;
		}

		public final int getOffset() {
			return firstRegion.getStart();
		}

		public int hashCode() {
			return 31 + ((state == null) ? 0 : state.hashCode());
		}

		public boolean equals(Object obj) {
			assert state != null && obj.getClass() == LexerState.class;

			if (this.state == obj)
				return true;
			return state.equals((LexerState) obj);
		}

		public final String toString() {
			return "[" + getOffset() + "] - " + this.state.getTopState(); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	
	public synchronized ITextRegion getToken(int offset)
			throws BadLocationException {
		
		assert tokensIterator != null;
		
		if (twigTokens.isEmpty()) {
			return null;
		}

		// we have at least one region...
		checkBadLocation(offset);

		// smart searching
		ITextRegion result = tokensIterator.hasNext() ? tokensIterator.next()
				: tokensIterator.previous();
		ITextRegion oldResult = result;
		if (isInside(result, offset)) {
			return result;
		}

		if (result != null && offset >= result.getEnd()) { // if the offset is
															// beyond - go fetch
			// from next
			while (tokensIterator.hasNext() && !isInside(result, offset)) {
				if (result == null) {
					return oldResult;
				} else {
					oldResult = result;
				}
				result = tokensIterator.next();

			}
		} else { // else go fetch from previous
			while (tokensIterator.hasPrevious() && !isInside(result, offset)) {
				if (result == null) {
					return oldResult;
				} else {
					oldResult = result;
				}
				result = tokensIterator.previous();
			}
			// moves the iterator to the next one
			if (tokensIterator.hasNext()) {
				tokensIterator.next();
			}
		}

		return result;
	}
	
	private final boolean isInside(ITextRegion region, int offset) {
		return region != null && region.getStart() <= offset
				&& offset < region.getEnd();
	}
	
	
	protected final void checkBadLocation(int offset)
			throws BadLocationException {
		ITextRegion lastRegion = getLastToken();
		if (offset < 0 || lastRegion.getEnd() < offset) {
			throw new BadLocationException(
					"offset " + offset + " is out of [0, " + lastRegion.getEnd() + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}
	
	
	public synchronized ITextRegion[] getTokens(final int offset,
			final int length) throws BadLocationException {
		assert length >= 0;
		List<ITextRegion> result = new ArrayList<ITextRegion>(); // list of
		// ITextRegion

		ITextRegion token = getToken(offset);
		if (token != null) {
			result.add(token);
		}

		while (tokensIterator.hasNext() && token != null
				&& token.getEnd() <= offset + length) {
			token = tokensIterator.next();
			result.add(token);
		}

		return result.toArray(new ITextRegion[result.size()]);
	}
	
	


}
