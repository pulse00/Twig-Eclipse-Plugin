/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist;

import java.io.IOException;
import java.util.List;

import org.eclipse.dltk.ast.statements.Statement;
import org.eclipse.dltk.codeassist.ScriptSelectionEngine;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.SourceModule;

import com.dubture.twig.core.ExtensionManager;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.ITemplateResolver;
import com.dubture.twig.core.model.TwigModelAccess;
import com.dubture.twig.core.parser.SourceParserUtil;
import com.dubture.twig.core.parser.ast.node.BlockName;
import com.dubture.twig.core.parser.ast.node.BlockStatement;
import com.dubture.twig.core.parser.ast.node.StringLiteral;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.parser.ast.node.Variable;

/**
 * 
 * Selects {% block name %}  tags and opens the parent block for now.
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class SelectionEngine extends ScriptSelectionEngine
{

    @Override
    public IModelElement[] select(IModuleSource sourceUnit, int offset,
            int end)
    {
        
        ISourceModule source = (ISourceModule) sourceUnit.getModelElement();
        
        try {
            TwigModuleDeclaration module = (TwigModuleDeclaration) SourceParserUtil.parseSourceModule((SourceModule)source);
            
            if (module == null) {
                return null;
            }
            
            
            for (BlockStatement block : module.getBlocks()) {
                if (block.sourceStart() < offset && block.sourceEnd() > offset) {
                    BlockName name = block.getName();
                    if ("block".equals(name.getValue())) {
                        Statement child = block.getFirstChild();
                        String blockName = null;
                        if (child instanceof Variable) {
                            Variable var = (Variable) child;
                            blockName = var.getValue();
                        } else if (child instanceof StringLiteral) {
                            StringLiteral literal = (StringLiteral) child;
                            blockName = literal.getValue();
                        }
                        
                        if (blockName != null) {
                            for (ITemplateResolver resolver : ExtensionManager.getInstance().getTemplateProviders()) {
                                String path = TwigModelAccess.getDefault().getParentPath(module, source.getScriptProject());
                                SourceModule sourceModule = resolver.revolePath(path, source.getScriptProject());
                                List<com.dubture.twig.core.model.BlockName> blocks = TwigModelAccess.getDefault().findBlocks(sourceModule, source.getScriptProject());
                                
                                if (blocks != null) {
                                    for (com.dubture.twig.core.model.BlockName parentBlockName : blocks) {
                                        if (blockName.equals(parentBlockName.getElementName())) {
                                            return new IModelElement[] {parentBlockName};
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ModelException e) {
            Logger.logException(e);
        } catch (IOException e) {
            Logger.logException(e);
        }
        
        return null;
    }

}
