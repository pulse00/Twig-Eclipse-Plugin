/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist;

import org.eclipse.core.resources.IProject;

/**
 * Interface for the completionContextResolvers extension point.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
public interface ITwigCompletionContextResolver {
	public static ICompletionContext[] NO_CONTEXTS = {};

	ICompletionContext[] createContexts(IProject project);

}
