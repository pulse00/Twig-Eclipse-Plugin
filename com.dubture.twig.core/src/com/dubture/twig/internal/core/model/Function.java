/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.internal.core.model;

import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.core.SourceMethod;
import org.eclipse.php.internal.core.compiler.ast.nodes.Scalar;

import com.dubture.twig.core.model.IFunction;

/**
 * 
 * ... DLTK {@link SourceMethod} is private ....
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class Function extends TwigCallable implements IFunction {
	public Function(ModelElement parent, String name) {
		super(parent, name);
		if (parent != null) {
			setScriptProject(parent.getScriptProject());
		}
	}

	public Function(Scalar scalar) {
		super(null, scalar.getValue().replaceAll("['\"]", ""));

	}

	public Function(String elementName) {
		super(null, elementName);
	}

	@Override
	public int getKind() {
		return FUNCTION;
	}
}
