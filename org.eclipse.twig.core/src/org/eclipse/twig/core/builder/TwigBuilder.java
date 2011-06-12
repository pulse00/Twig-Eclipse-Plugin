package org.eclipse.twig.core.builder;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.builder.IBuildParticipant;
import org.eclipse.dltk.core.builder.IBuildParticipantFactory;

public class TwigBuilder implements IBuildParticipantFactory {


	@Override
	public IBuildParticipant createBuildParticipant(IScriptProject project)
			throws CoreException {

		return new TwigBuildParticipant();
	}

}
