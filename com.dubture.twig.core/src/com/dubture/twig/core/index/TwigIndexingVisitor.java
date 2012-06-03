/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core.index;

import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.index2.IIndexingRequestor;
import org.eclipse.dltk.core.index2.IIndexingRequestor.ReferenceInfo;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.ITwigModelElement;
import com.dubture.twig.core.parser.ast.node.BlockName;
import com.dubture.twig.core.parser.ast.node.BlockStatement;
import com.dubture.twig.core.parser.ast.node.StringLiteral;
import com.dubture.twig.core.parser.ast.node.Variable;
import com.dubture.twig.core.parser.ast.visitor.TwigASTVisitor;

/**
 * Indexes extends and block tags for now.
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 */
public class TwigIndexingVisitor extends TwigASTVisitor
{
    
    private IIndexingRequestor requestor;
    private ISourceModule module;
    
    BlockStatement currentTag = null;
    BlockStatement extendsTag = null;
    BlockStatement blockTag = null;
    

    public TwigIndexingVisitor(IIndexingRequestor requestor, ISourceModule module)
    {
        this.requestor = requestor;
        this.module = module;
        
    }
    
    @Override
    public boolean visit(BlockName s) throws Exception
    {
        if (currentTag != null) {
            if (currentTag.isBlock()) {
                blockTag = currentTag;
            } else if (currentTag.isExtends()) {
                extendsTag = currentTag;
            }
        }
        return false;
    }
    
    @Override
    public boolean visit(BlockStatement block) throws Exception
    {
        currentTag = block;
        return true;
    }
    
    @Override
    public boolean endvisit(BlockStatement block) throws Exception
    {
        currentTag = null;
        extendsTag = null;
        blockTag = null;
        return true;
    }
    
    @Override
    public boolean visit(Variable s) throws Exception
    {
        if (blockTag != null) {
            Logger.debugMSG("Indexing block reference " + s.getValue()  + " in " + module.getElementName() + " / " + module.getScriptProject().getElementName());
            
            
            ReferenceInfo info = new ReferenceInfo(ITwigModelElement.BLOCK, s.sourceStart(), s.sourceEnd() - s.sourceStart(), s.getValue(), null, null);
            requestor.addReference(info);
        }
        
        return false;
    }
    
    @Override
    public boolean visit(StringLiteral s) throws Exception
    {
        if (extendsTag != null) {
            Logger.debugMSG("Indexing extends reference " + s.getValue());
            ReferenceInfo info = new ReferenceInfo(ITwigModelElement.EXTENDS, s.sourceStart(), s.sourceEnd() - s.sourceStart(), s.getValue(), null, null);      
            requestor.addReference(info);
        }
        return false;
    }
}
