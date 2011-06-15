package org.eclipse.twig.ui.editor.completion;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IField;
import org.eclipse.dltk.core.IMethod;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IModelElementVisitor;
import org.eclipse.dltk.core.IType;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.php.internal.core.codeassist.PHPCompletionEngine;


/**
 * 
 * The {@link TwigCompletionEngine} is responsible to provide
 * contextual code completion.
 * 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigCompletionEngine extends PHPCompletionEngine {

	private static final String COMPLETION_PROVIDER_ID = "org.eclipse.twig.completion.provider";
	

	private String[] keywords = new String[] { "as", "filter", "endfilter", "macro", "endmacro",
			"set", "import", "if", "elseif", "else", "endif", "for",
			"in", "endfor", "autoescape", "endautoescape", "true", "false", "include",
			"extends", "block", "endblock", "raw", "endraw", "spaceless",
			"endspaceless" };
	
	public TwigCompletionEngine() {
		super();
		
	}
	
	@Override
	public void complete(final IModuleSource module, final int position, final int i) {

		String ext = module.getModelElement().getResource().getFileExtension();
		
		if (!ext.equals("twig") && !ext.equals("html")) {
			
			if (ext.equals("php")) {
				super.complete(module, position, i);
			}
			return;
		}
		
		
//		for (int j = 0; j < keywords.length; j++) {
//			createProposal(keywords[j], null);
//		}
 
		// Completion for model elements.
		try {
			module.getModelElement().accept(new IModelElementVisitor() {
				
				
				public boolean visit(IModelElement element) {
					
				
					System.err.println("completing element: " + element.getElementName());
					if (element.getElementType() > IModelElement.SOURCE_MODULE) {
						createProposal(element.getElementName(), element);
					}
					return true;
				}
				
			});
		} catch (ModelException e) {
			if (DLTKCore.DEBUG) {
				e.printStackTrace();
			}
		}
		
		
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(COMPLETION_PROVIDER_ID);
		
		try {
			
			for (IConfigurationElement e : config) {
				
				final Object o = e.createExecutableExtension("class");
				
				if (o instanceof ITwigCompletionProvider) {
					
					ISafeRunnable runnable = new ISafeRunnable() {
						
						@Override
						public void run() throws Exception {
							ITwigCompletionProvider provider  = (ITwigCompletionProvider) o;							
							String[] proposals = provider.provideCompletions(module, position, i);
							
							for (String prop : proposals) {
								createProposal(prop, null);								
							}
							
						}
						
						@Override
						public void handleException(Throwable exception) {
							System.out.println("exception in extension!");							
						}
					};
					
					SafeRunner.run(runnable);										
				}
			}
			
		} catch (CoreException e) {
			
			e.printStackTrace();

		}
	}
	
	private void createProposal(String name, IModelElement element) {
		CompletionProposal proposal = null;
		try {
			if (element == null) {
				proposal = this.createProposal(CompletionProposal.KEYWORD,
						this.actualCompletionPosition);
			} else {
				switch (element.getElementType()) {
				case IModelElement.METHOD:
					proposal = this.createProposal(
							CompletionProposal.METHOD_DECLARATION,
							this.actualCompletionPosition);
					proposal.setFlags(((IMethod) element).getFlags());
					break;
				case IModelElement.FIELD:
					proposal = this.createProposal(
							CompletionProposal.FIELD_REF,
							this.actualCompletionPosition);
					proposal.setFlags(((IField) element).getFlags());
					break;
				case IModelElement.TYPE:
					proposal = this.createProposal(CompletionProposal.TYPE_REF,
							this.actualCompletionPosition);
					proposal.setFlags(((IType) element).getFlags());
					break;
				default:
					proposal = this.createProposal(CompletionProposal.KEYWORD,
							this.actualCompletionPosition);
					break;
				}
			}
			proposal.setName(name);
			proposal.setCompletion(name);
			proposal.setReplaceRange(actualCompletionPosition - offset,
					actualCompletionPosition - offset);
			proposal.setRelevance(20);
			proposal.setModelElement(element);
			this.requestor.accept(proposal);
		} catch (Exception e) {
		}
	}
}