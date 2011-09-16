package com.dubture.twig.ui.actions;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.php.internal.ui.IContextMenuConstants;
import org.eclipse.php.internal.ui.preferences.PreferenceConstants;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
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

	public void setContext(ActionContext context) {

		super.setContext(context);

		System.err.println("set context");
	}

	public void fillActionBars(IActionBars actionBar) {

		super.fillActionBars(actionBar);

		System.err.println("fill");
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
			System.err.println("append to group");
						
			menu.appendToGroup(IContextMenuConstants.GROUP_ADDITIONS, surroundAction);
		}		
	}



}
