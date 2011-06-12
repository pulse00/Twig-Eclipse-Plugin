package org.eclipse.twig.ui.editor.configuration;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.php.internal.ui.editor.templates.PhpTemplateProposal;
import org.eclipse.swt.graphics.Image;

@SuppressWarnings("restriction")
public class TwigTemplateProposal extends PhpTemplateProposal {

	public TwigTemplateProposal(Template template, TemplateContext context,
			IRegion region, Image image, int relevance) {
		super(template, context, region, image, relevance);
		


	}

}
