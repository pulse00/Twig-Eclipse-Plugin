package org.eclipse.twig.ui.editor.completion;

import org.eclipse.dltk.compiler.env.IModuleSource;

/**
 * 
 * {@link ITwigCompletionProvider} interface for the
 * extension point through which other extensions
 * can provide completions to the twig ui.
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public interface ITwigCompletionProvider {
	
		
	String [] provideCompletions(IModuleSource module, int position, int i);

}
