package com.dubture.twig.core.codeassist;

import java.io.IOException;

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
                                TwigModuleDeclaration parent = TwigModelAccess.getDefault().getParent(module, source.getScriptProject());
                                for (BlockStatement parentBlock : parent.getBlocks()) {
                                    if (parentBlock.isBlock() && blockName.equals(parentBlock.getTag())) {
                                        
//                                        return new IModelElement[] { parentBlock };
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
