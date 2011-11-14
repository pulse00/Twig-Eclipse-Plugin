/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.actions;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.php.internal.ui.IContextMenuConstants;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

import com.dubture.twig.ui.editor.TwigStructuredEditor;

public class TwigRefactorActionGroup extends ActionGroup {

	private SurroundWithAction surroundAction;
	private TwigStructuredEditor fEditor;

	public TwigRefactorActionGroup(TwigStructuredEditor editor) {
		Assert.isNotNull(editor);
		this.fEditor = editor;


		surroundAction = new SurroundWithAction(editor);


	}


	@Override
	public void fillContextMenu(IMenuManager menu) {

		//super.fillContextMenu(menu);

		IMenuManager target = menu;
		IMenuManager searchSubMenu = null;
		if (fEditor != null) {
			String groupName = "SearchMessages.group_search";
			searchSubMenu = new MenuManager(groupName,
					ITextEditorActionConstants.GROUP_FIND);
			searchSubMenu.add(new GroupMarker(
					ITextEditorActionConstants.GROUP_FIND));
			target = searchSubMenu;
		}

//		if (searchSubMenu != null) {
//			fOccurrencesGroup.fillContextMenu(target);
//			searchSubMenu.add(new Separator());
//		}

		// no other way to find out if we have added items.
		if (searchSubMenu != null && searchSubMenu.getItems().length > 2) {
			menu.appendToGroup(ITextEditorActionConstants.GROUP_FIND,
					searchSubMenu);
		}


		IContributionItem item = menu.find(IContextMenuConstants.GROUP_ADDITIONS);
		if (item != null) {
			menu.appendToGroup(IContextMenuConstants.GROUP_ADDITIONS, surroundAction);
		}		
	}



}
