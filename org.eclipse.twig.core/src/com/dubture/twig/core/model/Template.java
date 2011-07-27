package org.eclipse.twig.core.model;

import org.eclipse.dltk.core.ISourceModule;


/**
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class Template {


	private ISourceModule sourceModule;
	
	
	public ISourceModule getSourceModule() {
		return sourceModule;
	}


	public Template(ISourceModule sourceModule) {
		
		this.sourceModule = sourceModule;

	}




}
