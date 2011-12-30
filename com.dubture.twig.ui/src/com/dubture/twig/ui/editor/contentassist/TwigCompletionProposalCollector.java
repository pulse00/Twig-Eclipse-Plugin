/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.contentassist;

import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.text.completion.CompletionProposalLabelProvider;
import org.eclipse.dltk.ui.text.completion.IScriptCompletionProposal;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposal;
import org.eclipse.jface.text.IDocument;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProposalCollector;
import org.eclipse.swt.graphics.Image;

import com.dubture.twig.core.TwigNature;
import com.dubture.twig.core.model.Filter;
import com.dubture.twig.core.model.Function;
import com.dubture.twig.core.model.Tag;
import com.dubture.twig.core.model.Test;
import com.dubture.twig.ui.contentassist.EmptyCompletionProposal;
import com.dubture.twig.ui.contentassist.FilterProposalInfo;
import com.dubture.twig.ui.contentassist.FunctionProposalInfo;
import com.dubture.twig.ui.contentassist.TagProposalInfo;
import com.dubture.twig.ui.contentassist.TestProposalInfo;
import com.dubture.twig.ui.editor.TwigCompletionProposalLabelProvider;

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
        PHPCompletionProposalCollector
{

    private TwigCompletionProposalLabelProvider lProvider = null;

    public TwigCompletionProposalCollector(IDocument document,
            ISourceModule cu, boolean explicit)
    {
        super(document, cu, explicit);

    }

    @Override
    public CompletionProposalLabelProvider getLabelProvider()
    {

        if (lProvider == null)
            lProvider = new TwigCompletionProposalLabelProvider();

        return lProvider;
    }

    @Override
    protected String getNatureId()
    {

        return TwigNature.NATURE_ID;

    }

    @Override
    protected IScriptCompletionProposal createScriptCompletionProposal(
            CompletionProposal proposal)
    {

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
            CompletionProposal proposal)
    {

        ScriptCompletionProposal scriptProposal = generateTwigProposal(proposal);
        scriptProposal.setRelevance(computeRelevance(proposal));
        scriptProposal.setProposalInfo(new TestProposalInfo(getSourceModule()
                .getScriptProject(), proposal));
        return scriptProposal;

    }

    private IScriptCompletionProposal createFunctionProposal(
            CompletionProposal proposal)
    {

        ScriptCompletionProposal scriptProposal = generateTwigProposal(proposal);
        scriptProposal.setRelevance(computeRelevance(proposal));
        scriptProposal.setProposalInfo(new FunctionProposalInfo(
                getSourceModule().getScriptProject(), proposal));
        return scriptProposal;

    }

    private IScriptCompletionProposal createFilterProposal(
            CompletionProposal proposal)
    {

        ScriptCompletionProposal scriptProposal = generateTwigProposal(proposal);
        scriptProposal.setRelevance(computeRelevance(proposal));
        scriptProposal.setProposalInfo(new FilterProposalInfo(getSourceModule()
                .getScriptProject(), proposal));
        return scriptProposal;

    }

    private IScriptCompletionProposal createTagProposal(
            CompletionProposal proposal)
    {

        ScriptCompletionProposal scriptProposal = generateTwigProposal(proposal);
        scriptProposal.setRelevance(computeRelevance(proposal));
        scriptProposal.setProposalInfo(new TagProposalInfo(getSourceModule()
                .getScriptProject(), proposal));
        return scriptProposal;

    }

    private ScriptCompletionProposal generateTwigProposal(
            CompletionProposal typeProposal)
    {

        String completion = new String(typeProposal.getCompletion());
        int replaceStart = typeProposal.getReplaceStart();
        int length = getLength(typeProposal);
        Image image = getImage(((TwigCompletionProposalLabelProvider) getLabelProvider())
                .createTypeImageDescriptor(typeProposal));

        String displayString = ((TwigCompletionProposalLabelProvider) getLabelProvider())
                .createTypeProposalLabel(typeProposal);

        ScriptCompletionProposal scriptProposal = new EmptyCompletionProposal(
                completion, replaceStart, length, image, displayString, 0);

        return scriptProposal;

    }

}
