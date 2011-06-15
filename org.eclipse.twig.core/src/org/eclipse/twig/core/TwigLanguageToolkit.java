package org.eclipse.twig.core;

import org.eclipse.dltk.core.AbstractLanguageToolkit;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;

/**
 * The {@link IDLTKLanguageToolkit} to provide twig language
 * features. 
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TwigLanguageToolkit extends AbstractLanguageToolkit {

	private static TwigLanguageToolkit toolkit;
	
	public static IDLTKLanguageToolkit getDefault() {
		
		if (toolkit == null)
			toolkit = new TwigLanguageToolkit();
		
		return toolkit;
	}
	
	@Override
	public String getLanguageContentType() {

		return "org.eclipse.twig.core.twigtemplate";
		
	}

	@Override
	public String getNatureId() {

		return TwigNature.NATURE_ID;
	}

	@Override
	public String getLanguageName() {

		return "Twig";

	}
}