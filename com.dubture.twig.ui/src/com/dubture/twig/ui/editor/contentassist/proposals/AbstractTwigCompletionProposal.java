package com.dubture.twig.ui.editor.contentassist.proposals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.dltk.ui.text.completion.HTMLPrinter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension5;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension6;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.osgi.framework.Bundle;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.editor.contentassist.ICompletionProposalInfo;
import com.dubture.twig.ui.editor.contentassist.ITwigCompletionProposal;

public class AbstractTwigCompletionProposal implements ITwigCompletionProposal, ICompletionProposalExtension,
		ICompletionProposalExtension5, ICompletionProposalExtension6 {

	private int replacementOffset;
	private int replacementLength;
	private int cursorPosition;
	private String replacementString;
	private int relevance;
	private StyledString displayString;
	private Image image;
	private ICompletionProposalInfo proposalInfo;
	private IContextInformation contextInformation;
	private static String fgCSSStyles;

	public int getReplacementOffset() {
		return replacementOffset;
	}

	public void setReplacementOffset(int replacementOffset) {
		Assert.isTrue(replacementOffset >= 0);
		this.replacementOffset = replacementOffset;
	}

	public int getReplacementLength() {
		return replacementLength;
	}

	public void setReplacementLength(int replacementLength) {
		Assert.isTrue(replacementLength >= 0);
		this.replacementLength = replacementLength;
	}

	/**
	 * Gets the replacement string.
	 * 
	 * @return Returns a String
	 */
	public String getReplacementString() {
		return replacementString;
	}

	/**
	 * Sets the replacement string.
	 * 
	 * @param replacementString
	 *            The replacement string to set
	 */
	public void setReplacementString(String replacementString) {
		Assert.isNotNull(replacementString);
		this.replacementString = replacementString;
	}

	@Override
	public final void apply(IDocument document) {
		apply(document, (char) 0, getReplacementOffset() + getReplacementLength());
	}

	@Override
	public Point getSelection(IDocument document) {
		return new Point(getReplacementOffset() + getCursorPosition(), 0);
	}

	public void setCursorPosition(int cursorPosition) {
		Assert.isTrue(cursorPosition >= 0);
		this.cursorPosition = cursorPosition;
	}

	protected int getCursorPosition() {
		return cursorPosition;
	}

	@Override
	public String getAdditionalProposalInfo() {
		final Object info = getAdditionalProposalInfo(new NullProgressMonitor());
		return info != null ? info.toString() : null;
	}

	@Override
	public String getDisplayString() {
		if (displayString != null) {
			return displayString.toString();
		}
		return null;
	}

	@Override
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override

	public IContextInformation getContextInformation() {
		return this.contextInformation;
	}

	public void setContextInformation(IContextInformation contextInformation) {
		this.contextInformation = contextInformation;
	}

	@Override
	public StyledString getStyledDisplayString() {
		return displayString;
	}

	public void setStyledDisplayString(StyledString text) {
		displayString = text;
	}

	@Override
	public Object getAdditionalProposalInfo(IProgressMonitor monitor) {
		if (getProposalInfo() != null) {
			String info = getProposalInfo().getInfo(monitor);
			if (info != null && info.length() > 0) {
				StringBuffer buffer = new StringBuffer();
				HTMLPrinter.insertPageProlog(buffer, 0, getCSSStyles());
				buffer.append(info);
				HTMLPrinter.addPageEpilog(buffer);
				info = buffer.toString();
			}
			return info;
		}
		return null;
	}

	/**
	 * Returns the style sheet URL.
	 * 
	 * 
	 */
	protected String getCSSStyles() {
		if (fgCSSStyles == null) {
			Bundle bundle = Platform.getBundle(DLTKUIPlugin.getPluginId());
			URL url = bundle.getEntry("/DocumentationHoverStyleSheet.css"); //$NON-NLS-1$
			if (url != null) {
				try {
					url = FileLocator.toFileURL(url);
					BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
					StringBuffer buffer = new StringBuffer(200);
					String line = reader.readLine();
					while (line != null) {
						buffer.append(line);
						buffer.append('\n');
						line = reader.readLine();
					}
					fgCSSStyles = buffer.toString();
				} catch (IOException ex) {
					DLTKUIPlugin.log(ex);
				}
			}
		}
		String css = fgCSSStyles;
		if (css != null) {
			FontData fontData = JFaceResources.getFontRegistry()
					.getFontData(PreferenceConstants.APPEARANCE_DOCUMENTATION_FONT)[0];
			css = HTMLPrinter.convertTopLevelFont(css, fontData);
		}
		return css;
	}

	public ICompletionProposalInfo getProposalInfo() {
		return proposalInfo;
	}

	public void setProposalInfo(ICompletionProposalInfo proposalInfo) {
		this.proposalInfo = proposalInfo;
	}

	@Override
	public void apply(IDocument document, char trigger, int offset) {
		try {
			// patch replacement length
			int delta = offset - (getReplacementOffset() + getReplacementLength());
			if (delta > 0)
				setReplacementLength(getReplacementLength() + delta);

			if (trigger != (char) 0) {
				ensureTriggerAtCursorLocation(trigger);
			}
			String replacement = getReplacementString();

			replace(document, getReplacementOffset(), getReplacementLength(), replacement);

		} catch (BadLocationException x) {
			// ignore
		}
	}

	protected final void replace(IDocument document, int offset, int length, String string)
			throws BadLocationException {
		if (!document.get(offset, length).equals(string))
			document.replace(offset, length, string);
	}

	protected void ensureTriggerAtCursorLocation(char trigger) {
		String replacement = getReplacementString();

		// fix for PR #5533. Assumes that no eating takes place.
		if (getCursorPosition() > 0 && getCursorPosition() <= replacement.length()
				&& replacement.charAt(getCursorPosition() - 1) != trigger) {
			StringBuilder buffer = new StringBuilder(replacement);
			buffer.insert(getCursorPosition(), trigger);
			setReplacementString(buffer.toString());
			setCursorPosition(getCursorPosition() + 1);
		}
	}

	@Override
	public boolean isValidFor(IDocument document, int offset) {
		if (offset < getReplacementOffset()) {
			return false;
		}

		return validate(document, offset);
	}

	public boolean validate(IDocument document, int offset) {
		if (offset < getReplacementOffset()) {
			return false;
		}
		if (offset > getReplacementOffset()) {
			try {
				String prefix = document.get(getReplacementOffset(), offset - getReplacementOffset());
				if (!isValidPrefix(prefix, offset)) {
					return false;
				}
			} catch (BadLocationException e) {
				Logger.logException(e);
			}
		}

		return true;
	}

	public String getStringToCompute() {
		return getDisplayString();
	}

	public boolean isValidPrefix(String prefix, int offset) {
		return getStringToCompute().toLowerCase().startsWith(prefix.toLowerCase());
	}

	@Override
	public char[] getTriggerCharacters() {
		return null;
	}

	@Override
	public int getContextInformationPosition() {
		if (getContextInformation() == null)
			return getReplacementOffset() - 1;
		return getReplacementOffset() + getCursorPosition();
	}

	@Override
	public int getRelevance() {
		return relevance;
	}

	public void setRelevance(int relevance) {
		this.relevance = relevance;
	}

}
