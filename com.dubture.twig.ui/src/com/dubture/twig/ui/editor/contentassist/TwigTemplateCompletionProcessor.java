/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ui.templates.ScriptTemplateAccess;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.php.internal.ui.editor.templates.PHPTemplateCompletionProcessor;
import org.eclipse.php.internal.ui.util.PHPPluginImages;
import org.eclipse.swt.graphics.Image;

import com.dubture.twig.ui.TwigUICorePlugin;
import com.dubture.twig.ui.editor.templates.TwigTemplateAccess;
import com.dubture.twig.ui.editor.templates.TwigTemplateContextType;

/**
 * 
 * {@link TwigTemplateCompletionProcessor} is responsible to provide completions
 * for built-in or user-contributed code templates.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class TwigTemplateCompletionProcessor extends PHPTemplateCompletionProcessor {

	public TwigTemplateCompletionProcessor(ScriptContentAssistInvocationContext context, boolean explicit) {

		super(context, explicit);
		setContextTypeId(TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID);

	}

	@Override
	protected ScriptTemplateAccess getTemplateAccess() {

		return TwigTemplateAccess.getInstance();
	}

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {

		ITextSelection selection = (ITextSelection) viewer.getSelectionProvider().getSelection();

		// adjust offset to end of normalized selection
		if (selection.getOffset() == offset)
			offset = selection.getOffset() + selection.getLength();

		String prefix = extractPrefix(viewer, offset);
		if (!isValidPrefix(prefix)) {
			return new ICompletionProposal[0];
		}
		IRegion region = new Region(offset - prefix.length(), prefix.length());

		TemplateContext context = createContext(viewer, region);
		if (context == null) {
			return new ICompletionProposal[0];
		}
		List<TemplateProposal> matches = new ArrayList<>();

		Template[] templates = getTemplates(context.getContextType().getId());
		for (int i = 0; i < templates.length; i++) {
			Template template = templates[i];
			try {
				context.getContextType().validate(template.getPattern());
			} catch (TemplateException e) {
				continue;
			}
			if (isMatchingTemplate(template, prefix, context))
				matches.add(
						(TemplateProposal) createProposal(template, context, region, getRelevance(template, prefix)));
		}

		// Collections.sort(matches, comparator);

		final IInformationControlCreator controlCreator = getInformationControlCreator();
		for (TemplateProposal proposal : matches) {
			proposal.setInformationControlCreator(controlCreator);
		}

		return matches.toArray(new ICompletionProposal[matches.size()]);

	}

	@Override
	protected String getContextTypeId() {

		return TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID;
	}

	@Override
	protected Image getImage(Template template) {

		return TwigUICorePlugin.getImageDescriptorRegistry().get(PHPPluginImages.DESC_TEMPLATE);

	}

	@Override
	protected ContextTypeRegistry getTemplateContextRegistry() {

		return TwigUICorePlugin.getDefault().getTemplateContextRegistry();

	}

	@Override
	protected TemplateStore getTemplateStore() {

		return TwigUICorePlugin.getDefault().getTemplateStore();
	}

}
