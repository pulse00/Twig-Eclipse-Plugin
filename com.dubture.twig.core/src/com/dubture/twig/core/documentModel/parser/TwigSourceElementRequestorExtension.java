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
import java.util.List;

import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.statements.Statement;
import org.eclipse.dltk.compiler.IElementRequestor;
import org.eclipse.dltk.compiler.IElementRequestor.MethodInfo;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.php.core.compiler.PHPSourceElementRequestorExtension;

import com.dubture.twig.core.TwigCoreConstants;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.SourceParserUtil;
import com.dubture.twig.core.parser.ast.node.BlockStatement;
import com.dubture.twig.core.parser.ast.node.StringLiteral;
import com.dubture.twig.core.parser.ast.node.Variable;
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

            final ModuleDeclaration decl = SourceParserUtil
                    .parseSourceModule(new StringReader(source));

            decl.traverse(new TwigASTVisitor()
            {
                @Override
                public boolean visit(BlockStatement block) throws Exception
                {
                    if (TwigCoreConstants.START_BLOCK.equals(block.getName())) {

                        Variable name = block.getBlockName();

                        if (name == null) {
                            return false;
                        }

                        List<?> statements = block.getChilds();

                        MethodInfo info = new MethodInfo();
                        info.nameSourceStart = name.sourceStart();
                        info.nameSourceEnd = name.sourceEnd() - 1;
                        info.declarationStart = block.sourceStart();

                        info.name = name.getValue();
                        requestor.enterMethod(info);

                        if (statements.size() > 1) {
                            requestor.exitMethod(block.sourceEnd());
                        }

                    } else if (TwigCoreConstants.EXTENDS.equals(block.getName())) {

                        Statement first = block.getFirstChild();

                        if (first instanceof StringLiteral) {
                            StringLiteral parent = (StringLiteral) first;
                            String display = TwigCoreConstants.EXTENDS + " " + parent.getValue();
                            requestor.acceptPackage(block.sourceStart(),
                                    block.sourceEnd(), display);
                        }
                    }
                    return false;
                }

                @Override
                public boolean endvisit(BlockStatement block) throws Exception
                {
                    if (TwigCoreConstants.END_BLOCK.equals(block.getName())) {
                        requestor.exitMethod(block.sourceEnd());
                    }
                    return false;
                }
            });

            requestor.exitModule(decl.sourceEnd());

        } catch (Exception e) {
             Logger.logException(e);
        }
    }
}
