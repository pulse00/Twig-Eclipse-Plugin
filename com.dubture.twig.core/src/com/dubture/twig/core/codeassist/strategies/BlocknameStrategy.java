/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core.codeassist.strategies;

import java.util.List;

import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceModule;
import org.eclipse.dltk.internal.core.SourceRange;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.CodeAssistUtils;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.php.internal.core.typeinference.FakeField;

import com.dubture.twig.core.ExtensionManager;
import com.dubture.twig.core.codeassist.context.BlocknameContext;
import com.dubture.twig.core.model.ITemplateResolver;
import com.dubture.twig.core.parser.SourceParserUtil;
import com.dubture.twig.core.parser.ast.node.BlockName;
import com.dubture.twig.core.parser.ast.node.BlockStatement;
import com.dubture.twig.core.parser.ast.node.StringLiteral;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.parser.ast.node.Variable;

@SuppressWarnings({ "restriction", "deprecation" })
public class BlocknameStrategy extends KeywordStrategy {

	/**
	 * @param context
	 */
	public BlocknameStrategy(ICompletionContext context) {
		super(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dubture.twig.core.codeassist.strategies.KeywordStrategy#apply(org.
	 * eclipse.php.internal.core.codeassist.ICompletionReporter)
	 */
	@Override
	public void apply(ICompletionReporter reporter) throws Exception {

		BlocknameContext context = (BlocknameContext) getContext();

		TwigModuleDeclaration module = context.getModule();
		BlockStatement extendsBlock = module.getExtends();

		if (extendsBlock == null) {
			return;
		}

		StringLiteral literal = (StringLiteral) extendsBlock.getFirstChild();

		if (literal == null) {
			return;
		}

		String path = literal.getValue();
		List<ITemplateResolver> providers = ExtensionManager.getInstance().getTemplateProviders();

		String prefix = context.getPrefix();
		SourceRange range = getReplacementRange(context);

		for (ITemplateResolver resolver : providers) {

			SourceModule sourceModule = resolver.revolePath(path, context.getSourceModule().getScriptProject());
			TwigModuleDeclaration parent = (TwigModuleDeclaration) SourceParserUtil.parseSourceModule(sourceModule);

			if (parent != null) {
				for (BlockStatement block : parent.getBlocks()) {
					BlockName name = block.getName();
					if (name != null && "block".equals(name.getValue())) {
						Variable child = (Variable) block.getFirstChild();
						String value = child.getValue();

						if (CodeAssistUtils.startsWithIgnoreCase(value, prefix)) {
							FakeField field = new FakeField((ModelElement) context.getSourceModule(), value, 0);
							reporter.reportField(field, "", range, false);
						}
					}
				}
			}
		}
	}
}
