package org.eclipse.twig.ui.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.php.internal.ui.PHPUiPlugin;
import org.eclipse.twig.ui.TwigUICorePlugin;
import org.eclipse.ui.internal.editors.text.EditorsPlugin;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.wst.sse.ui.internal.preferences.ui.ColorHelper;

/**
 * 
 * @see http://code.google.com/p/smartypdt/
 *
 */
@SuppressWarnings("restriction")
public class PreferenceConstants {


 	/**
	 * A named preference that controls the behavior when double clicking on a container in the folders view.
	 * <p>
	 * Value is of type <code>String</code>: possible values are <code>
	 * DOUBLE_CLICK_GOES_INTO</code> or <code>
	 * DOUBLE_CLICK_EXPANDS</code>.
	 * </p>
	 *
	 * @see #DOUBLE_CLICK_EXPANDS
	 * @see #DOUBLE_CLICK_GOES_INTO
	 */
	public static final String DOUBLE_CLICK = "phpviewDoubleclick"; //$NON-NLS-1$

	/**
	 * A string value used by the named preference <code>DOUBLE_CLICK</code>.
	 *
	 * @see #DOUBLE_CLICK
	 */
	public static final String DOUBLE_CLICK_EXPANDS = "phpviewDoubleclickExpands"; //$NON-NLS-1$

	/**
	 * A string value used by the named preference <code>DOUBLE_CLICK</code>.
	 *
	 * @see #DOUBLE_CLICK
	 */
	public static final String DOUBLE_CLICK_GOES_INTO = "phpviewGointo"; //$NON-NLS-1$

	/**
	 * A named preference that holds the color for the PHP boundary makers (open/close tags)
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_BOUNDARYMARKER_COLOR = "editorColorBoundarymaker"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the PHP boundary makers (open/close tags)
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_BOUNDARYMARKER_DEFAULT_COLOR = ColorHelper.getColorString(255, 0, 0);

	/**
	 * A named preference that holds the color for the PHP comments
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_COMMENT_COLOR = "editorColorComment"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the PHP comments
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_COMMENT_DEFAULT_COLOR = ColorHelper.getColorString(128, 128, 128);

	/**
	 * A named preference that holds the color for the TASK tag inside the comment
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_TASK_COLOR = "editorColorTask"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the TASK tag inside the comment
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_TASK_DEFAULT_COLOR = ColorHelper.getColorString(124, 165, 213) + " | | true"; //$NON-NLS-1$

	/**
	 * A named preference that holds the color for the heredoc
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_DOUBLE_QUOTED_COLOR = "editorColorHeredoc"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the heredoc
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_DOUBLE_QUOTED_DEFAULT_COLOR = ColorHelper.getColorString(0, 130, 130);

	/**
	 * A named preference that holds the color for the PHP keyword
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_LABEL_COLOR = "editorColorKeyword"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the PHP keyword
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_LABEL_DEFAULT_COLOR = ColorHelper.getColorString(0, 0, 255);

	/**
	 * A named preference that holds the color for the normal PHP text
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_NORMAL_COLOR = "codeStyleNormal"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the normal PHP text
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_NORMAL_DEFAULT_COLOR = ColorHelper.getColorString(0, 0, 0);

	/**
	 * A named preference that holds the color for the numbers
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_NUMBER_COLOR = "editorColorNumber"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the numbers
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_NUMBER_DEFAULT_COLOR = ColorHelper.getColorString(255, 0, 0);

	/**
	 * A named preference that holds the color for the PHPDoc comments
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_PHPDOC_COLOR = "editorColorPhpdoc"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the PHPDoc comments
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_PHPDOC_DEFAULT_COLOR = ColorHelper.getColorString(128, 128, 128) + " | | true"; //$NON-NLS-1$

	/**
	 * A named preference that holds the color for the PHP string
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_STRING_COLOR = "editorColorString"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the PHP string
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_STRING_DEFAULT_COLOR = ColorHelper.getColorString(0, 255, 0);

	/**
	 * A named preference that holds the color for the PHP variable
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_VARIABLE_COLOR = "editorColorVariable"; //$NON-NLS-1$

	/**
	 * A named preference that holds the default color for the PHP variable
	 * <p>
	 * Value is of type <code>String</code>.
	 * </p>
	 */
	public static final String EDITOR_VARIABLE_DEFAULT_COLOR = ColorHelper.getColorString(102, 0, 0);

	/**
	 * A named preference that defines the key for the hover modifiers.
	 */
	public static final String EDITOR_TEXT_HOVER_MODIFIERS = PHPUiPlugin.ID + "hoverModifiers"; //$NON-NLS-1$

	public static final String TEMPLATES_KEY = "org.eclipse.php.smarty.ui.editor.templates"; //$NON-NLS-1$	
	
	public static void initializeDefaultValues() {

		// Override Editor Preference defaults:
		IPreferenceStore editorStore = EditorsPlugin.getDefault().getPreferenceStore();

		// Show current line:
		editorStore.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_CURRENT_LINE, true);

		// Show line numbers:
		editorStore.setDefault(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_LINE_NUMBER_RULER, true);

		IPreferenceStore store = getPreferenceStore();

		// SyntaxColoringPage
		store.setDefault(EDITOR_NORMAL_COLOR, EDITOR_NORMAL_DEFAULT_COLOR);
		store.setDefault(EDITOR_BOUNDARYMARKER_COLOR, EDITOR_BOUNDARYMARKER_DEFAULT_COLOR);
		store.setDefault(EDITOR_LABEL_COLOR, EDITOR_LABEL_DEFAULT_COLOR);
		store.setDefault(EDITOR_VARIABLE_COLOR, EDITOR_VARIABLE_DEFAULT_COLOR);
		store.setDefault(EDITOR_STRING_COLOR, EDITOR_STRING_DEFAULT_COLOR);
		store.setDefault(EDITOR_NUMBER_COLOR, EDITOR_NUMBER_DEFAULT_COLOR);
		store.setDefault(EDITOR_DOUBLE_QUOTED_COLOR, EDITOR_DOUBLE_QUOTED_DEFAULT_COLOR);
		store.setDefault(EDITOR_COMMENT_COLOR, EDITOR_COMMENT_DEFAULT_COLOR);

	}	
	
	
	public static IPreferenceStore getPreferenceStore() {
		return TwigUICorePlugin.getDefault().getPreferenceStore();
	}
	

}
