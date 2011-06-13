package org.eclipse.twig.core.templates;

import org.eclipse.core.resources.IFile;


/**
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigTemplate {

	private IFile file;
	
	
	public TwigTemplate(IFile file) {
		
		this.file = file;

	}


	public IFile getFile() {
		return file;
	}


}
