package com.dubture.twig.core.model;

public interface ITwigCallable extends ITwigModelElement {
	public String[] getParameterNames();

	public String getInternalFunction();
}
