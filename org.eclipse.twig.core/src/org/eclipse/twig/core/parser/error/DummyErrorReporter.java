package org.eclipse.twig.core.parser.error;

import org.antlr.runtime.RecognitionException;

public class DummyErrorReporter implements IErrorReporter {

	@Override
	public void reportError(String header, String message,
			RecognitionException e) {

	}

}
