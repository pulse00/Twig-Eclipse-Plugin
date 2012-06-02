/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.php.internal.ui.actions.SelectionHandler;
import org.eclipse.php.internal.ui.editor.PHPStructuredEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

@SuppressWarnings("restriction")
public class SurroundWithHandler extends SelectionHandler implements IHandler
{

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        IEditorPart editor = HandlerUtil.getActiveEditor(event);
        
        if (editor instanceof PHPStructuredEditor) {
            final SurroundWithAction surroundWithAction = new SurroundWithAction((PHPStructuredEditor) editor);
            surroundWithAction.run();
        }
        
        return null;
    }

}
