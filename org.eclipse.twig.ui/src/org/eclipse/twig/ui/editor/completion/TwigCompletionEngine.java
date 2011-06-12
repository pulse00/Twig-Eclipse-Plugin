package org.eclipse.twig.ui.editor.completion;

import org.eclipse.dltk.codeassist.ScriptCompletionEngine;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.core.CompletionProposal;
import org.eclipse.dltk.core.DLTKCore;
import org.eclipse.dltk.core.IField;
import org.eclipse.dltk.core.IMethod;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IModelElementVisitor;
import org.eclipse.dltk.core.IType;
import org.eclipse.dltk.core.ModelException;


public class TwigCompletionEngine extends ScriptCompletionEngine {

	
	@Override
	public void complete(IModuleSource module, int position, int i) {

		
		
		
		System.err.println("#########################################");
		System.err.println("#############  COMPLETE  ############################");
		System.err.println("#########################################");		
		
		String[] keywords = new String[] { "and", "del", "for", "is", "raise",
				"assert", "elif", "from", "lambda", "break", "else", "global",
				"not", "try", "class", "except", "if", "or", "while",
				"continue", "exec", "import", "pass", "yield", "def",
				"finally", "in", "print", "self", "return" };
		for (int j = 0; j < keywords.length; j++) {
			createProposal(keywords[j], null);
		}
 
		// Completion for model elements.
		try {
			module.getModelElement().accept(new IModelElementVisitor() {
				public boolean visit(IModelElement element) {
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
