package org.eclipse.twig.core.parser.error;

import org.antlr.runtime.RecognitionException;

public interface IErrorReporter {

	void reportError(String header, String message, RecognitionException e);	
}
