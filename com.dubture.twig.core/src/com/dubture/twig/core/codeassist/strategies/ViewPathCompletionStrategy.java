/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core.codeassist.strategies;

import java.util.List;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.SourceRange;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.php.core.codeassist.ICompletionContext;
import org.eclipse.php.internal.core.codeassist.ICompletionReporter;
import org.eclipse.php.internal.core.codeassist.strategies.MethodParameterKeywordStrategy;

import com.dubture.twig.core.codeassist.context.ViewPathContext;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.Template;
import com.dubture.twig.core.model.TwigModelAccess;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class ViewPathCompletionStrategy extends MethodParameterKeywordStrategy {

	/**
	 * @param context
	 */
	public ViewPathCompletionStrategy(ICompletionContext context) {
		super(context);
	}

	@Override
	public void apply(ICompletionReporter reporter) throws BadLocationException
	{
        ViewPathContext context = (ViewPathContext) getContext();       
        SourceRange range = getReplacementRange(context);
        
        TwigModelAccess model = TwigModelAccess.getDefault();
        ISourceModule sourceModule = context.getSourceModule();
        IScriptProject project = sourceModule.getScriptProject();
        
        try {
        	
	        List<Template> templates = model.getTemplates(project);
	        System.err.println(templates.size());
	        
	        for (Template template : templates) {
					System.err.println(template.getPath());
	        }
	        
        } catch (ModelException e) {
        	Logger.logException(e);
        }
        
//        CodeassistUtils.reportViewpath(reporter, (ViewPath) context.getViewPath(), 
//                context.getPrefix(), range, context.getSourceModule().getScriptProject());

	}	
}
