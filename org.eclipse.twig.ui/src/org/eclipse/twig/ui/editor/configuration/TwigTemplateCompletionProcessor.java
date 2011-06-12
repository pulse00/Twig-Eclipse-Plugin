package org.eclipse.twig.ui.editor.configuration;

import org.eclipse.dltk.ui.templates.ScriptTemplateAccess;
import org.eclipse.dltk.ui.templates.ScriptTemplateCompletionProcessor;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.twig.ui.editor.templates.TwigTemplateAccess;
import org.eclipse.twig.ui.editor.templates.TwigTemplateContextType;

/**
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigTemplateCompletionProcessor extends
	ScriptTemplateCompletionProcessor {

	public TwigTemplateCompletionProcessor(
			ScriptContentAssistInvocationContext context) {
		
		super(context);
		//setContextTypeId(TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID);
		
		System.err.println("create coompletion processor");		

	}
	
	
	
	
	@Override
	protected ScriptTemplateAccess getTemplateAccess() {

		
		System.err.println("get tempalte access");
		return TwigTemplateAccess.getInstance();
	}
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
	
		
		System.err.println("compute");
		
		ICompletionProposal[] prop =super.computeCompletionProposals(viewer, offset); 
		
		
		System.err.println(prop.length);
		
		
		return prop;
	}
	
	@Override
	protected String getContextTypeId() {
		
		System.err.println("get context type");
		return TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID;
	}
	
	@Override
	protected ICompletionProposal createProposal(Template template,
			TemplateContext context, IRegion region, int relevance) {


		System.err.println("create twig template proposal");
		return new TwigTemplateProposal(template, context, region, getImage(template), relevance);
		
	}
	
	
//	@Override
//	protected Image getImage(Template template) {
//
//		return TwigUICorePlugin.getImageDescriptorRegistry().get(PHPPluginImages.DESC_TEMPLATE);
//
//	}
	
//	@Override
//	protected ContextTypeRegistry getTemplateContextRegistry() {
//	
//		return TwigUICorePlugin.getDefault().getTemplateContextRegistry();
//	
//	}
//	
//	@Override
//	protected TemplateStore getTemplateStore() {
//		
//		return TwigUICorePlugin.getDefault().getTemplateStore();
//	}

}
