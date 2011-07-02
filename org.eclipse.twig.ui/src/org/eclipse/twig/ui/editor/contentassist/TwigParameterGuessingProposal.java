package org.eclipse.twig.ui.editor.contentassist;

import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IMethod;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.link.ILinkedModeListener;
import org.eclipse.jface.text.link.InclusivePositionUpdater;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.link.LinkedModeUI;
import org.eclipse.jface.text.link.LinkedPosition;
import org.eclipse.jface.text.link.LinkedPositionGroup;
import org.eclipse.jface.text.link.ProposalPosition;
import org.eclipse.php.internal.ui.PHPUiPlugin;
import org.eclipse.php.internal.ui.editor.contentassist.IPHPCompletionProposalExtension;
import org.eclipse.php.internal.ui.editor.contentassist.PHPOverrideCompletionProposal;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.texteditor.link.EditorLinkedModeUI;

/**
 * 
 * 
 *  This class is currently not used, maybe we
 *  need to override stuff in here at some point
 *  so i'll leave it in here.
 *  
 *  @deprecated
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigParameterGuessingProposal extends
	PHPOverrideCompletionProposal implements
	IPHPCompletionProposalExtension {

	private static final String PARENS = "()";
	private static final char[] NO_TRIGGERS = new char[0];
	protected static final String LPAREN = "("; //$NON-NLS-1$
	protected static final String RPAREN = ")"; //$NON-NLS-1$
	protected static final String COMMA = ", "; //$NON-NLS-1$
	protected static final String SPACE = " "; //$NON-NLS-1$
	private CompletionProposal fProposal;
	private IMethod method;
	private final boolean fFillBestGuess;
	private boolean fReplacementStringComputed = false;
	private Object extraInfo;
	private boolean fReplacementLengthComputed;
	private String alias = null;	
	
	
	private ICompletionProposal[][] fChoices; // initialized by
	// guessParameters()
	private Position[] fPositions; // initialized by guessParameters()

	private IRegion fSelectedRegion; // initialized by apply()
	private IPositionUpdater fUpdater;

	public TwigParameterGuessingProposal(CompletionProposal proposal,
			IScriptProject jproject, ISourceModule cu, String methodName,
			String[] paramTypes, int start, int length, String displayName,
			String completionProposal, boolean fillBestGuess, Object extraInfo) {
		super(jproject, cu, methodName, paramTypes, start, length, displayName,
				completionProposal);
		
		
		
		this.extraInfo = extraInfo;		
		this.fProposal = proposal;
		method = (IMethod) fProposal.getModelElement();
		this.fFillBestGuess = fillBestGuess;
		this.extraInfo = extraInfo;		

	}

	@Override
	public Object getExtraInfo() {

		return extraInfo;
	}
	
	public void apply(IDocument document, char trigger, int offset) {
		try {
			

			dealSuffix(document, offset);
			super.apply(document, trigger, offset);

			int baseOffset = getReplacementOffset();
			
			String replacement = getReplacementString();

			if (fPositions != null && fPositions.length > 0
					&& getTextViewer() != null) {

				LinkedModeModel model = new LinkedModeModel();

				for (int i = 0; i < fPositions.length; i++) {
					LinkedPositionGroup group = new LinkedPositionGroup();
					int positionOffset = fPositions[i].getOffset();
					int positionLength = fPositions[i].getLength();

					if (fChoices[i].length < 2) {
						group.addPosition(new LinkedPosition(document,
								positionOffset, positionLength,
								LinkedPositionGroup.NO_STOP));
					} else {
						ensurePositionCategoryInstalled(document, model);
						document.addPosition(getCategory(), fPositions[i]);
						group.addPosition(new ProposalPosition(document,
								positionOffset, positionLength,
								LinkedPositionGroup.NO_STOP, fChoices[i]));
					}
					model.addGroup(group);
				}

				model.forceInstall();

				LinkedModeUI ui = new EditorLinkedModeUI(model, getTextViewer());
				ui.setExitPosition(getTextViewer(),
						baseOffset + replacement.length(), 0, Integer.MAX_VALUE);
				ui.setExitPolicy(new ExitPolicy(')', document));
				ui.setCyclingMode(LinkedModeUI.CYCLE_WHEN_NO_PARENT);
				ui.setDoContextInfo(true);
				ui.enter();
				fSelectedRegion = ui.getSelectedRegion();

			} else {
				fSelectedRegion = new Region(baseOffset + getCursorPosition(),
						0);
			}

		} catch (BadLocationException e) {
			ensurePositionCategoryRemoved(document);
			PHPUiPlugin.log(e);
			openErrorDialog(e);
		} catch (BadPositionCategoryException e) {
			ensurePositionCategoryRemoved(document);
			PHPUiPlugin.log(e);
			openErrorDialog(e);
		}
	}
	
	private void dealSuffix(IDocument document, int offset) {
		String replacement = getReplacementString();
		if (replacement.endsWith(RPAREN)) {
			if (cursorInBrackets(document, offset + 1)) {
				setReplacementLength(getReplacementLength() + 2);
			}
		} else {
			// deal with case that a method that do not have parameters but with
			// append with parameters when using insert mode,for example
			// getA|($a),we should generate getA()($a) instead of getA($a),but
			// for getA|(),we should generate getA()
			if (insertCompletion() && !cursorInBrackets(document, offset + 1)) {
				replacement = replacement + PARENS;
				setReplacementString(replacement);
			}
		}
	}
	
	protected boolean isValidPrefix(String prefix) {
		

		return true;
//		initAlias();
//		String replacementString = null;
//		if (alias != null) {
//			replacementString = getAlias();
//		} else {
//			replacementString = super.getReplacementString();
//		}
//		return isPrefix(prefix, replacementString);
	}
	
	private void ensurePositionCategoryInstalled(final IDocument document,
			LinkedModeModel model) {
		if (!document.containsPositionCategory(getCategory())) {
			document.addPositionCategory(getCategory());
			fUpdater = new InclusivePositionUpdater(getCategory());
			document.addPositionUpdater(fUpdater);

			model.addLinkingListener(new ILinkedModeListener() {

				/*
				 * @see
				 * org.eclipse.jface.text.link.ILinkedModeListener#left(org.
				 * eclipse.jface.text.link.LinkedModeModel, int)
				 */
				public void left(LinkedModeModel environment, int flags) {
					ensurePositionCategoryRemoved(document);
				}

				public void suspend(LinkedModeModel environment) {
				}

				public void resume(LinkedModeModel environment, int flags) {
				}
			});
		}
	}

	private void ensurePositionCategoryRemoved(IDocument document) {
		if (document.containsPositionCategory(getCategory())) {
			try {
				document.removePositionCategory(getCategory());
			} catch (BadPositionCategoryException e) {
				// ignore
			}
			document.removePositionUpdater(fUpdater);
		}
	}

	private String getCategory() {
		return "ParameterGuessingProposal_" + toString(); //$NON-NLS-1$
	}
	
	
	private void openErrorDialog(Exception e) {
		Shell shell = getTextViewer().getTextWidget().getShell();
		MessageDialog.openError(shell, "Error guessing parameters",
				e.getMessage());
	}
	
	
	private boolean cursorInBrackets(IDocument document, int offset) {
		String nextWord = null;
		try {
			nextWord = document.get(offset - 1, 2);// "()".length()
		} catch (BadLocationException e) {
		}
		return PARENS.equals(nextWord);
	}
	

}
