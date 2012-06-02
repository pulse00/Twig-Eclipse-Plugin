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

import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public interface ITemplateResolver
{
    
    TwigModuleDeclaration revolePath(String path, IScriptProject project);

}
