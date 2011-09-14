package com.dubture.twig.ui.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.php.internal.ui.actions.SelectionHandler;



@SuppressWarnings("restriction")
public class SurroundWithHandler extends SelectionHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		final SurroundWithAction surroundWithAction = new SurroundWithAction();
		surroundWithAction.run(null);		

		return null;
	}

}
