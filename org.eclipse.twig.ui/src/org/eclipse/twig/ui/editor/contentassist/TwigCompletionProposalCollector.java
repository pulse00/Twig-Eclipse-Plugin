package org.eclipse.twig.ui.editor.contentassist;

import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider;
import org.eclipse.dltk.ui.text.completion.IScriptCompletionProposal;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposal;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalCollector;
import org.eclipse.swt.graphics.Image;
import org.eclipse.twig.core.TwigNature;
import org.eclipse.twig.core.model.Filter;
import org.eclipse.twig.core.model.Function;
import org.eclipse.twig.core.model.Tag;
import org.eclipse.twig.core.model.Test;
import org.eclipse.twig.ui.contentassist.EmptyCompletionProposal;
import org.eclipse.twig.ui.contentassist.FilterProposalInfo;
import org.eclipse.twig.ui.contentassist.FunctionProposalInfo;
import org.eclipse.twig.ui.contentassist.TagProposalInfo;
import org.eclipse.twig.ui.contentassist.TestProposalInfo;
import org.eclipse.twig.ui.editor.TwigCompletionProposalLabelProvider;


/**
 * {@link TwigCompletionProposalCollector}
 * 
 *  
 *  
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


		IModelElement element = proposal.getModelElement();

		if (element == null) {
			return null;
		}
		
		// creates a proposal for a route
		if (element.getClass() == Tag.class) {
			return createTagProposal(proposal);
		} else if (element.getClass() == Filter.class) {
			return createFilterProposal(proposal);
		} else if (element.getClass() == Function.class) {			
			return createFunctionProposal(proposal);
		} else if (element.getClass() == Test.class) {			
			return createTestProposal(proposal);
		}
		
		
		return super.createScriptCompletionProposal(proposal);
	}
	
	private IScriptCompletionProposal createTestProposal(
			CompletionProposal proposal) {

		ScriptCompletionProposal scriptProposal = generateTwigProposal(proposal);
		scriptProposal.setRelevance(computeRelevance(proposal));
		scriptProposal.setProposalInfo(new TestProposalInfo(getSourceModule().getScriptProject(), proposal));
		return scriptProposal;								

	}
	
	
	private IScriptCompletionProposal createFunctionProposal(
			CompletionProposal proposal) {

		ScriptCompletionProposal scriptProposal = generateTwigProposal(proposal);
		scriptProposal.setRelevance(computeRelevance(proposal));
		scriptProposal.setProposalInfo(new FunctionProposalInfo(getSourceModule().getScriptProject(), proposal));
		return scriptProposal;								

	}


	private IScriptCompletionProposal createFilterProposal(
			CompletionProposal proposal) {

		ScriptCompletionProposal scriptProposal = generateTwigProposal(proposal);
		scriptProposal.setRelevance(computeRelevance(proposal));
		scriptProposal.setProposalInfo(new FilterProposalInfo(getSourceModule().getScriptProject(), proposal));
		return scriptProposal;								

	}


	private IScriptCompletionProposal createTagProposal(
			CompletionProposal proposal) {

		ScriptCompletionProposal scriptProposal = generateTwigProposal(proposal);
		scriptProposal.setRelevance(computeRelevance(proposal));
		scriptProposal.setProposalInfo(new TagProposalInfo(getSourceModule().getScriptProject(), proposal));
		return scriptProposal;								

	}
	
	private ScriptCompletionProposal generateTwigProposal(CompletionProposal typeProposal) {
		
		String completion = new String(typeProposal.getCompletion());
		int replaceStart = typeProposal.getReplaceStart();
		int length = getLength(typeProposal);
		Image image = getImage(((TwigCompletionProposalLabelProvider) getLabelProvider())
				.createTypeImageDescriptor(typeProposal));

		String displayString = ((TwigCompletionProposalLabelProvider) getLabelProvider())
				.createTypeProposalLabel(typeProposal);

		ScriptCompletionProposal scriptProposal = new EmptyCompletionProposal(completion, replaceStart, length, image, displayString, 0);

		return scriptProposal;
		
	}
	
}