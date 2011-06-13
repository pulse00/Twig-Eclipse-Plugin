package org.eclipse.twig.core.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.core.builder.IBuildContext;
import org.eclipse.dltk.core.builder.IBuildParticipant;
import org.eclipse.twig.core.templates.TemplateManager;
import org.eclipse.twig.core.templates.TwigTemplate;

/**
 * 
 * 
 * The {@link TwigBuildParticipant} indexes all 
 * existing twig templates.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigBuildParticipant implements IBuildParticipant {
	
	private TemplateManager manager = TemplateManager.getInstance();
	
	
	@Override
	public void build(IBuildContext context) throws CoreException {
		
		IFile file = context.getFile();
		
		if (file.getFileExtension().equals("twig")) {
			manager.addTemplate(new TwigTemplate(file));			
		}
	}
}
