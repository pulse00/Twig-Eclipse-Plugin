/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.outline;

import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.core.SourceMethod;
import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.dltk.ui.ScriptElementLabels;
import org.eclipse.dltk.ui.viewsupport.AppearanceAwareLabelProvider;
import org.eclipse.dltk.ui.viewsupport.DecoratingModelLabelProvider;
import org.eclipse.dltk.ui.viewsupport.ScriptUILabelProvider;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.php.internal.ui.actions.SortAction;
import org.eclipse.php.internal.ui.outline.PHPContentOutlineConfiguration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wst.html.ui.views.contentoutline.HTMLContentOutlineConfiguration;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.xml.ui.internal.contentoutline.JFaceNodeContentProvider;
import org.eclipse.wst.xml.ui.internal.contentoutline.XMLNodeActionManager;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.TwigUICorePlugin;

/**
 *
 * A modified {@link PHPContentOutlineConfiguration} for Twig.
 *
 *
 *
 *
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigContentOutlineConfiguration extends HTMLContentOutlineConfiguration {
	private static final String OUTLINE_FILTER_PREF = "com.dubture.twig.ui.OutlinePage"; //$NON-NLS-1$
	protected TwigOutlineContentProvider fContentProvider = null;
	protected JFaceNodeContentProvider fContentProviderHTML = null;
	protected ILabelProvider fLabelProvider = null;
	protected TwigOutlineLabelProvider fLabelProviderHTML = null;
	static Object[] NO_CHILDREN = new Object[0];
	private SortAction sortAction;
	private ScriptUILabelProvider fSimpleLabelProvider;
	// private ShowGroupsAction fShowGroupsAction;
	private boolean fShowAttributes = false;
	protected IPreferenceStore fStore = DLTKUIPlugin.getDefault().getPreferenceStore();

	// private CustomFiltersActionGroup fCustomFiltersActionGroup;

	public TwigContentOutlineConfiguration() {
		super();
	}

	@Override
	protected IPreferenceStore getPreferenceStore() {
		return TwigUICorePlugin.getDefault().getPreferenceStore();
	}

	@Override
	protected String getOutlineFilterTarget() {
		return OUTLINE_FILTER_PREF;
	}

	protected IContributionItem[] createMenuContributions(final TreeViewer viewer) {
		IContributionItem[] items;

		// Custom filter group
		// if (fCustomFiltersActionGroup == null) {
		// fCustomFiltersActionGroup = new CustomFiltersActionGroup(
		// OUTLINE_PAGE, viewer); //$NON-NLS-1$
		// }
		//
		// final IContributionItem filtersItem = new
		// FilterActionGroupContributionItem(
		// fCustomFiltersActionGroup);

		items = super.createMenuContributions(viewer);

		// items = new IContributionItem[] {
		// /* filtersItem */};
		return items;
	}

	protected IContributionItem[] createToolbarContributions(final TreeViewer viewer) {
		IContributionItem[] items;
		// fShowGroupsAction = new ShowGroupsAction("Show Groups", viewer);
		// final IContributionItem showGroupsItem = new
		// ActionContributionItem(fShowGroupsAction); //$NON-NLS-1$

		// fixed bug 174653
		// use only the toggleLinking menu and dispose the others
		IContributionItem[] menuContributions = super.createMenuContributions(viewer);
		final IContributionItem toggleLinking = menuContributions[0];
		for (int i = 1; i < menuContributions.length; i++) {
			menuContributions[i].dispose();
		}
		sortAction = new SortAction(viewer);
		final IContributionItem sortItem = new ActionContributionItem(sortAction);

		items = super.createToolbarContributions(viewer);
		if (items == null)
			items = new IContributionItem[] { sortItem /* , showGroupsItem */ };
		else {
			final IContributionItem[] combinedItems = new IContributionItem[items.length + 2];
			System.arraycopy(items, 0, combinedItems, 0, items.length);
			combinedItems[items.length] = sortItem;
			// combinedItems[items.length + 1] = showGroupsItem;
			combinedItems[items.length + 1] = toggleLinking;
			items = combinedItems;
		}
		return items;

	}

	public void unconfigure(TreeViewer viewer) {
		// if (fShowGroupsAction != null) {
		// fShowGroupsAction.dispose();
		// }
		super.unconfigure(viewer);
	}

	public ILabelProvider getLabelProvider(final TreeViewer viewer) {

		if (fLabelProvider == null) {
			fLabelProvider = new DecoratingModelLabelProvider(new TwigAppearanceAwareLabelProvider(
					AppearanceAwareLabelProvider.DEFAULT_TEXTFLAGS | ScriptElementLabels.F_APP_TYPE_SIGNATURE
							| ScriptElementLabels.ALL_CATEGORY,
					AppearanceAwareLabelProvider.DEFAULT_IMAGEFLAGS, fStore));
		}

		if (fLabelProviderHTML == null) {
			fLabelProviderHTML = new TwigOutlineLabelProvider(fLabelProvider);
			fLabelProviderHTML.fShowAttributes = fShowAttributes;
		}
		return fLabelProviderHTML;
	}

	public ISelection getSelection(final TreeViewer viewer, final ISelection selection) {

		return super.getSelection(viewer, selection);
	}

	public ILabelProvider getStatusLineLabelProvider(TreeViewer treeViewer) {
		if (fSimpleLabelProvider == null) {
			fSimpleLabelProvider = new ScriptUILabelProvider();
			fSimpleLabelProvider.setTextFlags(ScriptElementLabels.DEFAULT_QUALIFIED
					| ScriptElementLabels.ROOT_POST_QUALIFIED | ScriptElementLabels.APPEND_ROOT_PATH
					| ScriptElementLabels.M_PARAMETER_TYPES | ScriptElementLabels.M_PARAMETER_NAMES
					| ScriptElementLabels.M_APP_RETURNTYPE | ScriptElementLabels.M_EXCEPTIONS
					| ScriptElementLabels.F_APP_TYPE_SIGNATURE | ScriptElementLabels.T_TYPE_PARAMETERS);
		}
		return fSimpleLabelProvider;
	}

	protected XMLNodeActionManager createNodeActionManager(TreeViewer treeViewer) {
		return new TwigNodeActionManager((IStructuredModel) treeViewer.getInput(), treeViewer);
	}

	protected void enableShowAttributes(boolean showAttributes, TreeViewer treeViewer) {
		super.enableShowAttributes(showAttributes, treeViewer);
		// fix bug #241111 - show attributes in outline
		if (fLabelProviderHTML != null) {
			// This option is only relevant for the HTML outline
			fLabelProviderHTML.fShowAttributes = showAttributes;
		}
		fShowAttributes = showAttributes;
	}

	class TwigAppearanceAwareLabelProvider extends AppearanceAwareLabelProvider {

		public TwigAppearanceAwareLabelProvider(IPreferenceStore store) {
			super(store);

		}

		public TwigAppearanceAwareLabelProvider(long textFlags, int imageFlags, IPreferenceStore store) {
			super(textFlags, imageFlags, store);

		}

		public String getText(Object element) {

			if (element instanceof SourceMethod) {

				SourceMethod m = (SourceMethod) element;
				String[] parameters;

				try {
					parameters = m.getParameterNames();

					if (parameters != null && parameters.length > 0) {
						return m.getElementName() + " - " + parameters[0];
					}

				} catch (ModelException e) {

					Logger.logException(e);
				}

				return m.getElementName();

			}

			return super.getText(element);
		}

		@Override
		public Image getImage(Object element) {

			return super.getImage(element);
		}
	}

	/*
	 * class FilterActionGroupContributionItem extends ContributionItem {
	 * 
	 * // private boolean fState; private CustomFiltersActionGroup fActionGroup;
	 * 
	 * public FilterActionGroupContributionItem( CustomFiltersActionGroup
	 * actionGroup) { super("filters"); fActionGroup = actionGroup; // fState=
	 * state; }
	 * 
	 * public void fill(Menu menu, int index) {
	 * 
	 * }
	 * 
	 * public boolean isDynamic() { return true; } }
	 */

}
