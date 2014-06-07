/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.core.IMethod;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.index2.search.ISearchEngine.MatchRule;
import org.eclipse.dltk.core.search.IDLTKSearchScope;
import org.eclipse.dltk.core.search.SearchEngine;
import org.eclipse.dltk.internal.core.SourceModule;
import org.eclipse.php.internal.core.codeassist.PHPSelectionEngine;
import org.eclipse.php.internal.core.model.PhpModelAccess;

import com.dubture.twig.core.ExtensionManager;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.Filter;
import com.dubture.twig.core.model.Function;
import com.dubture.twig.core.model.ITemplateResolver;
import com.dubture.twig.core.model.TwigModelAccess;
import com.dubture.twig.core.parser.SourceParserUtil;
import com.dubture.twig.core.parser.ast.node.BlockStatement;
import com.dubture.twig.core.parser.ast.node.TwigCallExpression;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.parser.ast.node.Variable;
import com.dubture.twig.core.parser.ast.visitor.TwigASTVisitor;
import com.dubture.twig.core.util.TwigModelUtils;

/**
 * 
 * Selects the following model elements:
 * 
 * - 'block' tags
 * - functions
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class SelectionEngine extends PHPSelectionEngine
{

    @Override
    public IModelElement[] select(IModuleSource sourceUnit, final int offset,
            int end)
    {
        
        if (TwigModelUtils.isTwigTemplate(sourceUnit.getFileName()) == false) {
            //return super.select(sourceUnit, offset, end);
        	return new IModelElement[] {};
        }
        
        ISourceModule source = (ISourceModule) sourceUnit.getModelElement();
        final IScriptProject project = source.getScriptProject();
        
        try {
            
            final TwigModuleDeclaration module = (TwigModuleDeclaration) SourceParserUtil.parseSourceModule((SourceModule)source);
            final List<IModelElement> elements = new ArrayList<IModelElement>();
            
            if (module == null) {
                return null;
            }
            
            module.traverse(new TwigASTVisitor()
            {
                @Override
                public boolean visit(TwigCallExpression s) throws Exception
                {
                    if (s.sourceStart() <= offset && s.sourceEnd() >= offset) {
                        Function[] functions = TwigModelAccess.getDefault().getFunctions(project);
                        
                        for (Function function : functions) {
                            if (function.getElementName().equals(s.getName())) {
                                IDLTKSearchScope scope = SearchEngine.createSearchScope(function.getSourceModule());
                                IMethod[] methods = PhpModelAccess.getDefault().findMethods(function.getInternalFunction(), MatchRule.EXACT, 0, 0, scope, null);
                                if (methods.length == 1) {
                                    elements.add(methods[0]);
                                }
                                return false;
                            }
                        }
                    }
                    
                    return true;
                }
                
                @Override
                public boolean visit(Variable s) throws Exception
                {
                    if (s.sourceStart() <= offset && s.sourceEnd() >= offset) {
                        for (Filter filter : TwigModelAccess.getDefault().getFilters(project)) {
                            if (filter.getElementName().equals(s.getValue())) {
                                
                                IDLTKSearchScope scope = SearchEngine.createSearchScope(filter.getSourceModule());
                                IMethod[] methods = PhpModelAccess.getDefault().findMethods(filter.getInternalFunction(), MatchRule.EXACT, 0, 0, scope, null);
                                if (methods.length == 1) {
                                    elements.add(methods[0]);
                                }
                                return false;
                            }
                        }
                    }
                    return true;
                }
                
                @Override
                public boolean visit(BlockStatement block) throws Exception
                {
                    if (block.isBlock() && block.getBlockName() != null 
                            && block.sourceStart() <= offset && (block.sourceEnd()+1) >= offset) {
                        String blockName = block.getBlockName().getValue();

                        for (ITemplateResolver resolver : ExtensionManager.getInstance().getTemplateProviders()) {
                            String path = TwigModelAccess.getDefault().getParentPath(module, project);
                            SourceModule sourceModule = resolver.revolePath(path, project);
                            List<com.dubture.twig.core.model.BlockName> blocks = TwigModelAccess.getDefault().findBlocks(sourceModule, project);
                            if (blocks != null) {
                                for (com.dubture.twig.core.model.BlockName parentBlockName : blocks) {
                                    if (blockName.equals(parentBlockName.getElementName())) {
                                        elements.add(parentBlockName);
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                    return true;
                }
            });
            
            if (elements.size() > 0) {
                return elements.toArray(new IModelElement[elements.size()]);
            }
            
        } catch (Exception e) {
            Logger.logException(e);
        }
        
        return null;
    }
}
