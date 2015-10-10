/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.outline;

import org.eclipse.dltk.internal.core.ModelElement;
import org.eclipse.dltk.internal.ui.actions.CompositeActionGroup;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.wst.html.ui.internal.contentoutline.HTMLNodeActionManager;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;

@SuppressWarnings("restriction")
public class TwigNodeActionManager extends HTMLNodeActionManager {

	// An action group used for generating the standard options
	private CompositeActionGroup fActionGroup = new CompositeActionGroup();

	public TwigNodeActionManager(IStructuredModel model, Viewer viewer) {
		super(model, viewer);
	}

	public void fillContextMenu(IMenuManager menuManager, ISelection selection) {
		// check the selection type - only if the underlying resource is a
		// ModelElement
		// the standard options are propagated
		if (selection instanceof TreeSelection) {
			Object firstElement = ((TreeSelection) selection).getFirstElement();
			if (firstElement instanceof ModelElement) {
				fActionGroup.fillContextMenu(menuManager);
				return;
			}
		}
		// if the selection is not a ModelElement - generate the HTML options
		super.fillContextMenu(menuManager, selection);
	}

}
