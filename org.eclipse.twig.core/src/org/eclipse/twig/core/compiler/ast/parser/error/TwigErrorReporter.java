package org.eclipse.twig.core.compiler.ast.parser.error;

import org.antlr.runtime.RecognitionException;

public class TwigErrorReporter implements IErrorReporter {

	@Override
	public void reportError(String header, String message,
			RecognitionException e) {

		System.err.println("report " + header + " " + message);

	}

}
