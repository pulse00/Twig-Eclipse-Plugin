package org.eclipse.twig.ui.editor.contentassist;

import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider;
import org.eclipse.dltk.ui.text.completion.IScriptCompletionProposal;
import org.eclipse.dltk.ui.text.completion.MethodProposalInfo;
import org.eclipse.dltk.ui.text.completion.ProposalInfo;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposal;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalCollector;
import org.eclipse.twig.core.TwigNature;
import org.eclipse.twig.ui.editor.TwigCompletionProposalLabelProvider;


/**
 * {@link TwigCompletionProposalCollector}
 * 
 *  
 *  Just here to provide the correct nature id.
 *  
 *  
 *  This class is currently not used, maybe we
 *  need to override stuff in here at some point
 *  so i'll leave it in here.
 * 
 * @deprecated
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigCompletionProposalCollector extends
		PHPCompletionProposalCollector {


	private TwigCompletionProposalLabelProvider lProvider = null;
	
	
	public TwigCompletionProposalCollector(IDocument document,
			ISourceModule cu, boolean explicit) {
		super(document, cu, explicit);

	}
	
	
	@Override
	public CompletionProposalLabelProvider getLabelProvider() {
		
		if (lProvider == null)
			lProvider = new TwigCompletionProposalLabelProvider();
		
		return lProvider;
	}

	@Override
	protected String getNatureId() {

		return TwigNature.NATURE_ID;

	}
	
	
	@Override
	protected IScriptCompletionProposal createScriptCompletionProposal(
			CompletionProposal proposal) {

		if (proposal.getKind() == CompletionProposal.METHOD_DECLARATION) {
			
			return createTwigMethodDeclarationProposal(proposal);
		}
		
		return super.createScriptCompletionProposal(proposal);
	}
	
	private ScriptCompletionProposal createTwigMethodDeclarationProposal(
			CompletionProposal proposal) {
		if (getSourceModule() == null
				|| getSourceModule().getScriptProject() == null) {
			return null;
		}

		String name = String.valueOf(proposal.getName());

		String[] paramTypes;

		paramTypes = new String[0];

		int start = proposal.getReplaceStart();
		
		int length = getLength(proposal);
		//String label = ((PHPCompletionProposalLabelProvider) getLabelProvider()).createOverrideMethodProposalLabel(proposal);
		
		ScriptCompletionProposal scriptProposal = createTwigParameterGuessingProposal(
				proposal, getSourceModule().getScriptProject(),
				getSourceModule(), name, paramTypes, start, length, "label",
				String.valueOf(proposal.getCompletion()),
				proposal.getExtraInfo());
		scriptProposal.setImage(getImage(getLabelProvider()
				.createMethodImageDescriptor(proposal)));

		ProposalInfo info = new MethodProposalInfo(getSourceModule()
				.getScriptProject(), proposal);
		scriptProposal.setProposalInfo(info);

		scriptProposal.setRelevance(computeRelevance(proposal));
		return scriptProposal;
	}
	
	
	private ScriptCompletionProposal createTwigParameterGuessingProposal(
			CompletionProposal proposal, IScriptProject scriptProject,
			ISourceModule sourceModule, String name, String[] paramTypes,
			int start, int length, String label, String string, Object extraInfo) {
		return new TwigParameterGuessingProposal(proposal, scriptProject,
				sourceModule, name, paramTypes, start, length, label, string,
				false, extraInfo);
	}
	
}