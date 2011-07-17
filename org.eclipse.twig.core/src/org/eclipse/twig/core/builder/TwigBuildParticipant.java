package org.eclipse.twig.core.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.SourceParserUtil;
import org.eclipse.dltk.core.builder.IBuildContext;
import org.eclipse.dltk.core.builder.IBuildParticipant;
import org.eclipse.twig.core.log.Logger;
import org.eclipse.twig.core.model.Template;
import org.eclipse.twig.core.model.TwigModelAccess;

/**
 * 
 * 
 * The {@link TwigBuildParticipant} indexes all 
 * existing twig templates during the buildphase.
 * 
 * It parses the PHP sourcefiles for the following elements
 * and adds them to the model:
 * 
 * > Filters
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigBuildParticipant implements IBuildParticipant {
	
	private TwigModelAccess model = TwigModelAccess.getInstance();
	
	
	@Override
	public void build(IBuildContext context) throws CoreException {
		
		IFile file = context.getFile();
		ISourceModule sourceModule = context.getSourceModule();
		
		
		try {
			
			if (file.getFileExtension().equals("twig")) {
				model.addTemplate(new Template(sourceModule));
			} else if (file.getFileExtension().equals("php")) {
			
				
			}			
						
		} catch (Exception e) {
			Logger.logException(e);
		}

	}
}
