package org.eclipse.twig.core;

import org.eclipse.dltk.core.AbstractLanguageToolkit;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;

public class TwigLanguageToolkit extends AbstractLanguageToolkit {

	private static TwigLanguageToolkit toolkit;
	
	public static IDLTKLanguageToolkit getDefault() {
		
		if (toolkit == null)
			toolkit = new TwigLanguageToolkit();
		
		return toolkit;
	}
	
	@Override
	public String getLanguageContentType() {

		System.err.println("get content type");
		return "org.eclipse.twig.core.twigtemplate";
		
	}

	@Override
	public String getNatureId() {

		System.err.println("get language id");
		return TwigNature.NATURE_ID;
	}

	@Override
	public String getLanguageName() {

		System.err.println("get language name");
		return "Twig";

	}

}
