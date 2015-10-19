package com.dubture.twig.ui.editor.contentassist;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.wst.sse.ui.preferences.AbstractCompletionProposalCategoriesConfiguration;

import com.dubture.twig.ui.TwigUICorePlugin;
import com.dubture.twig.ui.preferences.PreferenceConstants;

public class TwigCompletionProposalCategoriesConfiguration extends AbstractCompletionProposalCategoriesConfiguration {

	public TwigCompletionProposalCategoriesConfiguration() {
	}

	@Override
	public boolean hasAssociatedPropertiesPage() {
		return false;
	}

	@Override
	public String getPropertiesPageID() {
		// XXX Introduce twig properties page
		return null;
	}

	@Override
	protected IPreferenceStore getPreferenceStore() {
		return TwigUICorePlugin.getDefault().getPreferenceStore();
	}

	/**
	 * @see org.eclipse.wst.sse.ui.preferences.AbstractCompletionProposalCategoriesConfiguration#getShouldNotDisplayOnDefaultPagePrefKey()
	 */
	@Override
	protected String getShouldNotDisplayOnDefaultPagePrefKey() {
		return PreferenceConstants.CONTENT_ASSIST_DO_NOT_DISPLAY_ON_DEFAULT_PAGE;
	}

	/**
	 * @see org.eclipse.wst.sse.ui.preferences.AbstractCompletionProposalCategoriesConfiguration#getShouldNotDisplayOnOwnPagePrefKey()
	 */
	@Override
	protected String getShouldNotDisplayOnOwnPagePrefKey() {
		return PreferenceConstants.CONTENT_ASSIST_DO_NOT_DISPLAY_ON_OWN_PAGE;
	}

	/**
	 * @see org.eclipse.wst.sse.ui.preferences.AbstractCompletionProposalCategoriesConfiguration#getPageSortOrderPrefKey()
	 */
	@Override
	protected String getPageSortOrderPrefKey() {
		return PreferenceConstants.CONTENT_ASSIST_OWN_PAGE_SORT_ORDER;
	}

	/**
	 * @see org.eclipse.wst.sse.ui.preferences.AbstractCompletionProposalCategoriesConfiguration#getDefaultPageSortOrderPrefKey()
	 */
	@Override
	protected String getDefaultPageSortOrderPrefKey() {
		return PreferenceConstants.CONTENT_ASSIST_DEFAULT_PAGE_SORT_ORDER;
	}
}
