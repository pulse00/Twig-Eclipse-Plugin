package com.dubture.twig.core.model;

public interface IViewPath {

	public abstract String getTemplate();

	public abstract boolean isRoot();

	public abstract boolean isValid();

}