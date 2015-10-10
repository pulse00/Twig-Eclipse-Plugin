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

import org.eclipse.dltk.ast.Modifiers;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.ast.statements.Statement;
import org.eclipse.dltk.compiler.IElementRequestor.FieldInfo;
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
import com.dubture.twig.core.util.TwigModelUtils;

/**
 *
 * The {@link TwigSourceElementRequestorExtension} is called when a twig file is
 * opened and indexes all model elements inside the template.
 *
 *
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
public class TwigSourceElementRequestorExtension extends PHPSourceElementRequestorExtension {

	public static String PRINT_START = "{{";
	public static String PRINT_END = "}}";
	public static String STMT_START = "{%";
	public static String STMT_END = "%}";

	@Override
	public void setSourceModule(IModuleSource sourceModule) {
		try {

			super.setSourceModule(sourceModule);

			if (TwigModelUtils.isTwigTemplate(sourceModule.getFileName()) == false)
				return;

			String source = sourceModule.getSourceContents();
			fRequestor.enterModule();

			final ModuleDeclaration decl = SourceParserUtil.parseSourceModule(new StringReader(source));

			decl.traverse(new TwigASTVisitor() {
				@Override
				public boolean visit(BlockStatement block) throws Exception {
					if (TwigCoreConstants.START_BLOCK.equals(block.getName().getValue())) {

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
						fRequestor.enterMethod(info);

						if (statements.size() > 1) {
							fRequestor.exitMethod(block.sourceEnd());
						}

					} else if (TwigCoreConstants.EXTENDS.equals(block.getName().getValue())) {

						Statement first = block.getFirstChild();

						if (first instanceof StringLiteral) {
							StringLiteral parent = (StringLiteral) first;
							String display = TwigCoreConstants.EXTENDS + " " + parent.getValue();
							fRequestor.acceptPackage(block.sourceStart(), block.sourceEnd(), display);
						}
					}
					return false;
				}
				/*
				 * 
				 * @Override public boolean visit(PrintStatement print) throws
				 * Exception { System.err.println("request print element");
				 * MethodInfo info = new MethodInfo(); info.nameSourceStart =
				 * print.sourceStart(); info.nameSourceEnd = print.sourceEnd();
				 * info.name = "var"; info.declarationStart =
				 * print.sourceStart();
				 * 
				 * fRequestor.enterMethod(info);
				 * 
				 * 
				 * 
				 * return true; }
				 * 
				 * @Override public boolean endvisit(PrintStatement s) throws
				 * Exception { fRequestor.exitMethod(s.sourceEnd()); return
				 * true; }
				 */

				@Override
				public boolean endvisit(BlockStatement block) throws Exception {
					if (TwigCoreConstants.END_BLOCK.equals(block.getName().getValue())) {
						fRequestor.exitMethod(block.sourceEnd());
					}
					return false;
				}

				@Override
				public boolean endvisit(Variable s) throws Exception {

					FieldInfo info = new FieldInfo();

					info.declarationStart = s.sourceStart();
					info.nameSourceStart = s.sourceStart();
					info.nameSourceEnd = s.sourceEnd();
					info.name = s.getValue();
					info.modifiers = Modifiers.AccPublic;

					fRequestor.enterField(info);

					fRequestor.exitField(s.sourceEnd());
					return false;
				}
			});

			fRequestor.exitModule(decl.sourceEnd());

		} catch (Exception e) {
			Logger.logException(e);
		}
	}
}
