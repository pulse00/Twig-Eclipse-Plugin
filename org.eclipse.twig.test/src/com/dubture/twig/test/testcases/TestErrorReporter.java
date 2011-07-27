package com.dubture.twig.test.testcases;

import org.antlr.runtime.RecognitionException;

import com.dubture.twig.core.parser.error.IErrorReporter;

public class TestErrorReporter implements IErrorReporter {

	
	private int errorCount = 0;
	
	@Override
	public void reportError(String header, String message,
			RecognitionException e) {

		
		System.err.println(header + " " + message);
		errorCount++;

	}
	
	
	public int getErrors() {
		
		return errorCount;		
		
	}
	
	public boolean hasErrors() {
		
		
		return errorCount > 0;
	}

}
