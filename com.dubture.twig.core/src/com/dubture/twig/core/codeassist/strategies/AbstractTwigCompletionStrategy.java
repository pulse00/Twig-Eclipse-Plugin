/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist.strategies;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.SourceRange;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

import com.dubture.twig.core.codeassist.ICompletionCompanion;
import com.dubture.twig.core.codeassist.ICompletionContext;
import com.dubture.twig.core.codeassist.ICompletionStrategy;
import com.dubture.twig.core.codeassist.context.AbstractTwigCompletionContext;

/**
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
public abstract class AbstractTwigCompletionStrategy implements ICompletionStrategy {
	private ICompletionContext fContext;
	private ICompletionCompanion fCompletionCompanion;

	public AbstractTwigCompletionStrategy(ICompletionContext context) {
		fContext = context;
	}

	public ICompletionContext getContext() {
		return fContext;
	}

	public ISourceRange getReplacementRange(ICompletionContext context) throws BadLocationException {

		AbstractTwigCompletionContext completionContext = (AbstractTwigCompletionContext) context;

		int length = completionContext.getPrefix().length();

		int start = completionContext.getOffset() - length;
		int prefixEnd = completionContext.getPrefixEnd();

		if (start + length < prefixEnd) {
			length = prefixEnd - start;
		}

		return new SourceRange(start, length);
	}

	@Override
	public void init(ICompletionCompanion companion) {
		this.fCompletionCompanion = companion;
	}

	public ICompletionCompanion getCompletionCompanion() {
		return fCompletionCompanion;
	}

}
