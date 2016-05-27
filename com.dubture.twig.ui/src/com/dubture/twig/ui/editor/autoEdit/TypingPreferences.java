/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.autoEdit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import com.dubture.twig.ui.TwigUICorePlugin;
import com.dubture.twig.ui.preferences.PreferenceConstants;

/**
 * 
 * 
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
public class TypingPreferences {

	static boolean closeQuotes;
	static boolean closeBrackets;
	static boolean closeCurlyBracket;

	static boolean addPhpCloseTag;
	static boolean addPhpForPhpStartTags;

	static {
		IPreferenceStore store = TwigUICorePlugin.getDefault().getPreferenceStore();

		closeQuotes = store.getBoolean(PreferenceConstants.EDITOR_CLOSE_STRINGS);
		closeBrackets = store.getBoolean(PreferenceConstants.EDITOR_CLOSE_BRACKETS);
		closeCurlyBracket = store.getBoolean(PreferenceConstants.EDITOR_CLOSE_BRACES);
		addPhpCloseTag = store.getBoolean(PreferenceConstants.EDITOR_ADD_PHPCLOSE_TAGS);
		addPhpForPhpStartTags = store.getBoolean(PreferenceConstants.EDITOR_ADD_PHP_FOR_PHPSTART_TAGS);
		store.addPropertyChangeListener(new IPropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent event) {
				String property = event.getProperty();
				if (property == PreferenceConstants.EDITOR_CLOSE_STRINGS) {
					closeQuotes = Boolean.valueOf((String) event.getNewValue()).booleanValue();
					return;
				}
				if (property == PreferenceConstants.EDITOR_CLOSE_BRACKETS) {
					closeBrackets = Boolean.valueOf((String) event.getNewValue()).booleanValue();
					return;
				}
				if (property == PreferenceConstants.EDITOR_CLOSE_BRACES) {
					closeCurlyBracket = Boolean.valueOf((String) event.getNewValue()).booleanValue();
					return;
				}
				if (property == PreferenceConstants.EDITOR_ADD_PHPCLOSE_TAGS) {
					addPhpCloseTag = Boolean.valueOf((String) event.getNewValue()).booleanValue();
					return;
				}
				if (property == PreferenceConstants.EDITOR_ADD_PHP_FOR_PHPSTART_TAGS) {
					addPhpForPhpStartTags = Boolean.valueOf((String) event.getNewValue()).booleanValue();
					return;
				}
			}
		});
	}
}
