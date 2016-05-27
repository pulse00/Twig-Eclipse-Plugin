package com.dubture.twig.core.codeassist;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;

public interface ICompletionContext {
	/**
	 * Returns whether this context is applicable for the position in the
	 * document
	 * 
	 * @param twig
	 *            template
	 * @param offset
	 * @return <code>true</code> if this context is valid for the current
	 *         position, otherwise <code>false</code>
	 */
	public boolean isValid(IDocument template, int offset, IProgressMonitor monitor);

	/**
	 * Whether this context may be applied only if it's the only context that
	 * was found.
	 * 
	 * @return <code>true</code> if this context is exclusive, otherwise
	 *         <code>false</code>
	 */
	public boolean isExclusive();

	/**
	 * This method is called by the completion engine when initializing this
	 * context
	 */
	public void init(ICompletionCompanion companion);
}
