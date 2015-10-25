/*
 * This file is part of the Twig Eclipse Plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.dubture.twig.core.codeassist.context;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;

import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.SourceParserUtil;
import com.dubture.twig.core.parser.ast.node.BlockStatement;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class BlocknameContext extends AbstractTwigCompletionContext {

	protected TwigModuleDeclaration module;

	@Override
	public boolean isValid(IDocument template, int offset, IProgressMonitor monitor) {
		if (!super.isValid(template, offset, monitor)) {
			return false;
		}

		try {
			if (getPartitionType() == TwigPartitionTypes.TWIG_QUOTED_STRING) {
				return false;
			}

			String prefix = getStatementText().toString();

			if (!prefix.contains(".") && !prefix.contains("\"") && !prefix.contains("'")) {

				String previous = getPreviousWord();

				if (previous == null || "block".equals(previous) == false) {
					return false;
				}

				module = (TwigModuleDeclaration) SourceParserUtil.parseSourceModule(template.get());

				for (BlockStatement block : module.getBlocks()) {
					if ("extends".equals(block.getName().getValue())) {
						return true;
					}
				}
				return false;
			}
		} catch (Exception e) {
			Logger.logException(e);
		}

		return false;
	}

	public TwigModuleDeclaration getModule() {
		return module;
	}
}
