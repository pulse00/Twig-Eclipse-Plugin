/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.parser.error;

import org.antlr.runtime.RecognitionException;

public class DummyErrorReporter implements IErrorReporter {

	@Override
	public void reportError(String header, String message,
			RecognitionException e) {

	}

}
