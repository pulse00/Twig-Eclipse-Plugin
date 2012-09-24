/*
* This file is part of the Twig Eclipse Plugin.
*
* (c) Robert Gruendler <r.gruendler@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/
package com.dubture.twig.core.codeassist.context;

import org.eclipse.dltk.core.CompletionRequestor;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.php.internal.core.util.text.TextSequence;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.model.ViewPath;
import com.dubture.twig.core.util.text.TwigTextSequenceUtilities;

/**
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
public class ViewPathContext extends QuotesContext {
	
	private ViewPath viewPath;

	/* (non-Javadoc)
	 * @see com.dubture.twig.core.codeassist.context.QuotesContext#isValid(org.eclipse.dltk.core.ISourceModule, int, org.eclipse.dltk.core.CompletionRequestor)
	 */
	@Override
	public boolean isValid(ISourceModule sourceModule, int offset,
			CompletionRequestor requestor) {
		
		if (!super.isValid(sourceModule, offset, requestor)) {
			return false;
		}
		
		 try {				 
				 
			 TextSequence statement = getStatementText();

			 if (!requestor.getClass().getName().contains("Twig")) {
			     return false;
			 }
			 if (TwigTextSequenceUtilities.isInFunction(statement)) {
				 return false;
			 }
			 
			 int startOffset = TwigTextSequenceUtilities.readViewPathStartIndex(statement);
			 String path = getDocument().getText().substring(statement.getOriginalOffset(startOffset), offset);
			 
			 if (path != null) {								
				 viewPath = new ViewPath(path);
				 return true;
			 }
			 
		} catch (Exception e) {
			Logger.logException(e);
		}
		
		return false;
	}
}
