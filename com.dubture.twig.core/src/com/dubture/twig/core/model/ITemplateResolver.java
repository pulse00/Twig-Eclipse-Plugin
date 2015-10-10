/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core.model;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.internal.core.SourceModule;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public interface ITemplateResolver {

	SourceModule revolePath(String path, IScriptProject project);

}
