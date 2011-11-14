/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.codeassist;

import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.strategies.AbstractCompletionStrategy;


/**
 * 
 * Interface for the completionStrategyResolvers extension point.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public interface ITwigCompletionStrategyFactory {
	
	AbstractCompletionStrategy[] create(ICompletionContext[] contexts);	

}
