/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.parser;

import java.io.StringReader;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.IElementRequestor.MethodInfo;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.php.core.compiler.PHPSourceElementRequestorExtension;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.SourceParserUtil;
import com.dubture.twig.core.parser.ast.node.BlockStatement;
import com.dubture.twig.core.parser.ast.visitor.TwigASTVisitor;

/**
 * 
 * The {@link TwigSourceElementRequestorExtension} is called when a twig file is
 * opened and indexes all model elements inside the template.
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
public class TwigSourceElementRequestorExtension extends
        PHPSourceElementRequestorExtension
{

    public static String PRINT_START = "{{";
    public static String PRINT_END = "}}";
    public static String STMT_START = "{%";
    public static String STMT_END = "%}";

    private IElementRequestor requestor;

    public TwigSourceElementRequestorExtension()
    {

    }

    @Override
    public void setSourceModule(IModuleSource sourceModule)
    {

        try {

            super.setSourceModule(sourceModule);
            
             if (sourceModule.getFileName().endsWith(".php"))
                 return;
            
             String source = sourceModule.getSourceContents();
             requestor = getRequestor();
             requestor.enterModule();
             
             ModuleDeclaration decl = SourceParserUtil.parseSourceModule(new StringReader(source));
             
             decl.traverse(new TwigASTVisitor()
             {
                 
                @Override                
                public boolean visit(BlockStatement block) throws Exception
                {
                    if ("block".equals(block.getName())) {
                        MethodInfo info = new MethodInfo();                        
                        info.nameSourceStart = block.sourceStart();
                        info.nameSourceEnd = block.sourceEnd();
                        
                        System.err.println("block start " + block.sourceStart());
                        info.name = block.getName() + " (" + block.getBlockName() + ")";                    
                        requestor.enterMethod(info);                        
                    }
                    
                    return false;
                }
                
                @Override
                public boolean endvisit(BlockStatement block) throws Exception
                {
                    if ("endblock".equals(block.getName())) {                        
                        requestor.exitMethod(block.sourceStart());
                    }
                    
                    return false;
                }
                
            });
                        
             requestor.exitModule(0);

        } catch (Exception e) {

            Logger.logException(e);
        }
    }
}
