package org.eclipse.twig.core;

import org.eclipse.dltk.compiler.IElementRequestor.TypeInfo;
import org.eclipse.dltk.compiler.ISourceElementRequestor;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.core.AbstractSourceElementParser;


/**
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigSourceElementParser extends AbstractSourceElementParser {

	

	@Override
	public void parseSourceModule(IModuleSource module) {

		ISourceElementRequestor requestor = getRequestor();
		
		requestor.enterModule();
		
		TypeInfo info = new TypeInfo();
		info.name = "Twig type";
		requestor.enterType(info);
		requestor.exitType(0);
		requestor.exitModule(0);
		
		
		System.err.println("parse source module " + module);
	
	}
	
	@Override
	protected String getNatureId() {

		System.err.println("get parser nature");
		return TwigNature.NATURE_ID;
	}
}