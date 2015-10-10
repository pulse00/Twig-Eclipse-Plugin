/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.builder.IBuildContext;
import org.eclipse.dltk.core.builder.IBuildParticipant;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.Template;
import com.dubture.twig.core.model.TwigModelAccess;
import com.dubture.twig.core.util.TwigModelUtils;

/**
 * 
 * 
 * The {@link TwigBuildParticipant} indexes all existing twig templates during
 * the buildphase.
 * 
 * It parses the PHP sourcefiles for the following elements and adds them to the
 * model:
 * 
 * > Filters
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public class TwigBuildParticipant implements IBuildParticipant {

	private TwigModelAccess model = TwigModelAccess.getDefault();

	@Override
	public void build(IBuildContext context) throws CoreException {

		IFile file = context.getFile();
		ISourceModule sourceModule = context.getSourceModule();

		try {
			if (file != null && TwigModelUtils.isTwigTemplate(file.getName())) {
				model.addTemplate(new Template(sourceModule));
			}
		} catch (Exception e) {
			Logger.logException(e);
		}
	}
}
