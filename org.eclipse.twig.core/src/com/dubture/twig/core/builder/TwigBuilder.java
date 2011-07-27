package org.eclipse.twig.core.builder;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.builder.IBuildParticipant;
import org.eclipse.dltk.core.builder.IBuildParticipantFactory;


/**
 * 
 * {@link TwigBuilder} is an extension point to provide
 * the {@link IBuildParticipant} {@link TwigBuildParticipant}
 * to the DLTK builder.  
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigBuilder implements IBuildParticipantFactory {


	@Override
	public IBuildParticipant createBuildParticipant(IScriptProject project)
			throws CoreException {

		
		return new TwigBuildParticipant();
	}

}
