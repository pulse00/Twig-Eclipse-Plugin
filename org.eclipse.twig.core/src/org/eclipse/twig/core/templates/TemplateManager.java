package org.eclipse.twig.core.templates;

import java.util.Stack;


/**
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class TemplateManager {
		
	
	private static TemplateManager instance;
	
	
	private Stack<TwigTemplate> templates = new Stack<TwigTemplate>();
	
	
	private TemplateManager() { 
		
		
	}
	
	
	public static TemplateManager getInstance() {
		
		if (instance == null) {
			instance = new TemplateManager();
		}
		
		return instance;
		
	}


	public void addTemplate(TwigTemplate twigTemplate) {

		templates.push(twigTemplate);
		
	}
	

}
