/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

import com.dubture.indexing.core.IndexingCorePlugin;

public class TwigNature implements IProjectNature {

	public static final String NATURE_ID = TwigCorePlugin.PLUGIN_ID + ".TwigNature";

	private IProject project;

	@Override
	public void configure() throws CoreException {
		if (project == null) {
			return;
		}
		IndexingCorePlugin.getDefault().setupBuilder(project);
	}

	@Override
	public void deconfigure() throws CoreException {
		// TODO drop indexing builder if no longer necessary
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

}
