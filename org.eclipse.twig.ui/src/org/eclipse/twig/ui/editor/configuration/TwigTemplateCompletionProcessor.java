package org.eclipse.twig.ui.editor.configuration;



import org.eclipse.dltk.ui.templates.ScriptTemplateAccess;
import org.eclipse.dltk.ui.text.completion.ScriptContentAssistInvocationContext;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.php.internal.ui.editor.templates.PhpTemplateCompletionProcessor;
import org.eclipse.php.internal.ui.util.PHPPluginImages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.twig.ui.TwigUICorePlugin;
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
public class TwigTemplateCompletionProcessor extends /*PhpTemplateCompletionProcessor*/ PhpTemplateCompletionProcessor {

	public TwigTemplateCompletionProcessor(ScriptContentAssistInvocationContext context) {
		
		super(context);
		setContextTypeId(TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID);
		

	}
	
	@Override
	protected ScriptTemplateAccess getTemplateAccess() {

		return TwigTemplateAccess.getInstance();
	}
	
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
	
		ICompletionProposal[] prop = super.computeCompletionProposals(viewer, offset); 
		return prop;
	}
	
	@Override
	protected String getContextTypeId() {
		
		return TwigTemplateContextType.TWIG_CONTEXT_TYPE_ID;
	}
	
	
//	@Override
//	protected ICompletionProposal createProposal(Template template,
//			TemplateContext context, IRegion region, int relevance) {
//
//		return new TwigTemplateProposal(template, context, region, getImage(template), relevance);
//		
//	}
	
	
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
