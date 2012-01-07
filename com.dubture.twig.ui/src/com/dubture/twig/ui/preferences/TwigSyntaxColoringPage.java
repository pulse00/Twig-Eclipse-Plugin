/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.preferences;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.php.internal.core.PHPVersion;
import org.eclipse.php.internal.core.ast.nodes.ASTParser;
import org.eclipse.php.internal.core.ast.nodes.Program;
import org.eclipse.php.internal.ui.IPHPHelpContextIds;
import org.eclipse.php.internal.ui.editor.highlighter.AbstractSemanticHighlighting;
import org.eclipse.php.internal.ui.editor.input.NonExistingPHPFileEditorInput;
import org.eclipse.php.internal.ui.preferences.PHPSyntaxColoringPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.accessibility.ACC;
import org.eclipse.swt.accessibility.AccessibleAdapter;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.wst.sse.core.StructuredModelManager;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocument;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionCollection;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegionContainer;
import org.eclipse.wst.sse.ui.internal.SSEUIMessages;
import org.eclipse.wst.sse.ui.internal.preferences.OverlayPreferenceStore;
import org.eclipse.wst.sse.ui.internal.preferences.OverlayPreferenceStore.OverlayKey;
import org.eclipse.wst.sse.ui.internal.preferences.ui.ColorHelper;
import org.eclipse.wst.sse.ui.internal.util.EditorUtility;
import org.eclipse.wst.xml.ui.internal.XMLUIMessages;

import com.dubture.twig.core.documentModel.parser.TwigRegionContext;
import com.dubture.twig.core.documentModel.parser.regions.ITwigScriptRegion;
import com.dubture.twig.core.documentModel.parser.regions.TwigRegionTypes;
import com.dubture.twig.core.documentModel.provisional.contenttype.ContentTypeIdForTwig;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.TwigUICorePlugin;
import com.dubture.twig.ui.TwigUIMessages;
import com.dubture.twig.ui.editor.LineStyleProviderForTwig;

/**
 * 
 * The Twig Syntac color preference page. An adapted version of the
 * {@link PHPSyntaxColoringPage}.
 * 
 * 
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 * 
 */
@SuppressWarnings({"restriction", "rawtypes"})
public class TwigSyntaxColoringPage extends PreferencePage implements
        IWorkbenchPreferencePage
{

    private OverlayPreferenceStore fOverlayStore;

    private ColorSelector fForegroundColorEditor;
    private ColorSelector fBackgroundColorEditor;

    private final LineStyleProviderForTwig fStyleProvider;
    private Collection<String> fStylePreferenceKeys;

    private HashMap<String, String> fStyleToDescriptionMap;

    private Map<String, String> fContextToStyleMap;

    private Color fDefaultForeground;

    private Color fDefaultBackground;

    private StructuredViewer fStylesViewer;

    private Button fEnabler;

    private Label fForegroundLabel;

    private Label fBackgroundLabel;

    private Button fBold;

    private Button fItalic;

    private Button fStrike;

    private Button fUnderline;

    private Button fClearStyle;

    private StyledText fText;

    private IStructuredDocument fDocument;

    private static Map<String, Position[]> highlightingPositionMap;
    private static Map<String, HighlightingStyle> highlightingStyleMap;

    static class HighlightingStyle
    {

        /** Text attribute */
        private TextAttribute fTextAttribute;
        /** Enabled state */
        private boolean fIsEnabled;

        /**
         * Initialize with the given text attribute.
         * 
         * @param textAttribute
         *            The text attribute
         * @param isEnabled
         *            the enabled state
         */
        public HighlightingStyle(TextAttribute textAttribute, boolean isEnabled)
        {
            setTextAttribute(textAttribute);
            setEnabled(isEnabled);
        }

        /**
         * @return Returns the text attribute.
         */
        public TextAttribute getTextAttribute()
        {
            return fTextAttribute;
        }

        /**
         * @param textAttribute
         *            The background to set.
         */
        public void setTextAttribute(TextAttribute textAttribute)
        {
            fTextAttribute = textAttribute;
        }

        /**
         * @return the enabled state
         */
        public boolean isEnabled()
        {
            return fIsEnabled;
        }

        /**
         * @param isEnabled
         *            the new enabled state
         */
        public void setEnabled(boolean isEnabled)
        {
            fIsEnabled = isEnabled;
        }
    }

    public TwigSyntaxColoringPage()
    {

        fStyleProvider = new LineStyleProviderForTwig();

    }

    @Override
    public void init(IWorkbench workbench)
    {

        setDescription("Syntax Colors");

        fStyleToDescriptionMap = new HashMap<String, String>();
        fContextToStyleMap = new HashMap<String, String>();

        initStyleToDescriptionMap();
        initRegionContextToStyleMap();

        IPreferenceStore store = getPreferenceStore();
        OverlayKey[] keys = createOverlayStoreKeys();

        fOverlayStore = new OverlayPreferenceStore(store, keys);
        fOverlayStore.load();
        fOverlayStore.start();

        fStyleProvider.setColorPreferences(fOverlayStore);

    }

    @Override
    protected IPreferenceStore doGetPreferenceStore()
    {
        return PreferenceConstants.getPreferenceStore();
    }

    @Override
    public boolean performOk()
    {
        getOverlayStore().propagate();
        TwigUICorePlugin.getDefault().savePluginPreferences();
        return true;
    }

    @Override
    protected void performDefaults()
    {
        super.performDefaults();
        getOverlayStore().loadDefaults();
        applyStyles();
        fStylesViewer.setSelection(StructuredSelection.EMPTY);
        activate(null);
        fText.redraw();
    }

    private OverlayKey[] createOverlayStoreKeys()
    {

        List<OverlayKey> overlayKeys = new ArrayList<OverlayKey>();

        Iterator<String> i = getStylePreferenceKeys().iterator();
        while (i.hasNext()) {
            String key = i.next();
            overlayKeys.add(new OverlayPreferenceStore.OverlayKey(
                    OverlayPreferenceStore.STRING, key));
            overlayKeys.add(new OverlayPreferenceStore.OverlayKey(
                    OverlayPreferenceStore.BOOLEAN, PreferenceConstants
                            .getEnabledPreferenceKey(key)));
        }

        OverlayPreferenceStore.OverlayKey[] keys = new OverlayPreferenceStore.OverlayKey[overlayKeys
                .size()];

        overlayKeys.toArray(keys);
        return keys;
    }

    private Collection<String> getStylePreferenceKeys()
    {
        if (fStylePreferenceKeys == null) {
            List<String> styles = new ArrayList<String>();
            styles.add(PreferenceConstants.EDITOR_NORMAL_COLOR);
            styles.add(PreferenceConstants.EDITOR_BOUNDARYMARKER_COLOR);
            styles.add(PreferenceConstants.EDITOR_STMT_BOUNDARYMARKER_COLOR);
            styles.add(PreferenceConstants.EDITOR_VARIABLE_COLOR);
            styles.add(PreferenceConstants.EDITOR_STRING_COLOR);
            styles.add(PreferenceConstants.EDITOR_NUMBER_COLOR);
            styles.add(PreferenceConstants.EDITOR_COMMENT_COLOR);
            styles.add(PreferenceConstants.EDITOR_KEYWORD_COLOR);
            styles.add(PreferenceConstants.EDITOR_DOUBLE_QUOTED_COLOR);
            styles.add(PreferenceConstants.EDITOR_HASH_COLOR);
            styles.add(PreferenceConstants.EDITOR_INTERPOLATION_COLOR);

            fStylePreferenceKeys = styles;
        }
        return fStylePreferenceKeys;
    }

    private void initStyleToDescriptionMap()
    {
        fStyleToDescriptionMap.put(PreferenceConstants.EDITOR_NORMAL_COLOR,
                "Normal");
        fStyleToDescriptionMap.put(
                PreferenceConstants.EDITOR_BOUNDARYMARKER_COLOR, "Print tags");
        fStyleToDescriptionMap.put(
                PreferenceConstants.EDITOR_STMT_BOUNDARYMARKER_COLOR,
                "Block tags");

        fStyleToDescriptionMap.put(PreferenceConstants.EDITOR_LABEL_COLOR,
                "Label");
        fStyleToDescriptionMap.put(PreferenceConstants.EDITOR_VARIABLE_COLOR,
                "Variable");
        fStyleToDescriptionMap
                .put(PreferenceConstants.EDITOR_DOUBLE_QUOTED_COLOR,
                        "Double quotes");
        fStyleToDescriptionMap.put(PreferenceConstants.EDITOR_HASH_COLOR,
                "Hash");
        fStyleToDescriptionMap.put(PreferenceConstants.EDITOR_KEYWORD_COLOR,
                "Keyword");
        fStyleToDescriptionMap.put(PreferenceConstants.EDITOR_STRING_COLOR,
                "String");
        fStyleToDescriptionMap.put(PreferenceConstants.EDITOR_NUMBER_COLOR,
                "Number");
        fStyleToDescriptionMap.put(PreferenceConstants.EDITOR_COMMENT_COLOR,
                "Comment");
        fStyleToDescriptionMap.put(PreferenceConstants.EDITOR_INTERPOLATION_COLOR,
                "String Interpolation");
        

    }

    private void initRegionContextToStyleMap()
    {

        fContextToStyleMap = fStyleProvider.getTwigColorTypesMap();

    }

    private IPropertyChangeListener fHighlightingChangeListener = new IPropertyChangeListener()
    {

        public void propertyChange(PropertyChangeEvent event)
        {
            handleHighlightingPropertyChange(event);
        }
    };

    @Override
    protected Control createContents(final Composite parent)
    {

        initializeDialogUnits(parent);

        fDefaultForeground = parent.getDisplay().getSystemColor(
                SWT.COLOR_LIST_FOREGROUND);
        fDefaultBackground = parent.getDisplay().getSystemColor(
                SWT.COLOR_LIST_BACKGROUND);
        Composite pageComponent = createComposite(parent, 2);
        PlatformUI
                .getWorkbench()
                .getHelpSystem()
                .setHelp(pageComponent,
                        IPHPHelpContextIds.SYNTAX_COLORING_PREFERENCES);

        Link link = new Link(pageComponent, SWT.WRAP);
        String linkText = "Default colors and font can be configured on the <a href=\"org.eclipse.ui.preferencePages.GeneralTextEditor\">Text Editors</a> and on the <a href=\"org.eclipse.ui.preferencePages.ColorsAndFonts\">Colors and Fonts</a> preference pages.";
        link.setText(linkText);

        link.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                PreferencesUtil.createPreferenceDialogOn(parent.getShell(),
                        e.text, null, null);
            }
        });

        GridData linkData = new GridData(SWT.FILL, SWT.BEGINNING, true, false,
                2, 1);
        linkData.widthHint = 150; // only expand further if anyone else requires
        // it
        link.setLayoutData(linkData);

        new Label(pageComponent, SWT.NONE).setLayoutData(new GridData());
        new Label(pageComponent, SWT.NONE).setLayoutData(new GridData());

        SashForm editor = new SashForm(pageComponent, SWT.VERTICAL);
        GridData gridData2 = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData2.horizontalSpan = 2;
        editor.setLayoutData(gridData2);
        SashForm top = new SashForm(editor, SWT.HORIZONTAL);
        Composite styleEditor = createComposite(top, 1);
        ((GridLayout) styleEditor.getLayout()).marginRight = 5;
        ((GridLayout) styleEditor.getLayout()).marginLeft = 0;
        createLabel(styleEditor, XMLUIMessages.SyntaxColoringPage_0);
        fStylesViewer = createStylesViewer(styleEditor);
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData.horizontalIndent = 0;
        Iterator<String> iterator = fStyleToDescriptionMap.values().iterator();
        while (iterator.hasNext()) {
            gridData.widthHint = Math.max(gridData.widthHint,
                    convertWidthInCharsToPixels(iterator.next().toString()
                            .length()));
        }
        gridData.heightHint = convertHeightInCharsToPixels(5);
        fStylesViewer.getControl().setLayoutData(gridData);

        Composite editingComposite = createComposite(top, 1);
        ((GridLayout) styleEditor.getLayout()).marginLeft = 5;
        createLabel(editingComposite, ""); //$NON-NLS-1$

        fEnabler = createCheckbox(editingComposite,
                XMLUIMessages.SyntaxColoringPage_2);
        fEnabler.setEnabled(false);

        Composite editControls = createComposite(editingComposite, 2);
        ((GridLayout) editControls.getLayout()).marginLeft = 20;

        fForegroundLabel = createLabel(editControls,
                SSEUIMessages.Foreground_UI_);
        ((GridData) fForegroundLabel.getLayoutData()).verticalAlignment = SWT.CENTER;
        fForegroundLabel.setEnabled(false);

        fForegroundColorEditor = new ColorSelector(editControls);
        Button fForegroundColor = fForegroundColorEditor.getButton();
        GridData gd = new GridData(SWT.BEGINNING, SWT.FILL, false, false);
        fForegroundColor.setLayoutData(gd);
        fForegroundColorEditor.setEnabled(false);

        fBackgroundLabel = createLabel(editControls,
                SSEUIMessages.Background_UI_);
        ((GridData) fBackgroundLabel.getLayoutData()).verticalAlignment = SWT.CENTER;
        fBackgroundLabel.setEnabled(false);

        fBackgroundColorEditor = new ColorSelector(editControls);
        Button fBackgroundColor = fBackgroundColorEditor.getButton();
        gd = new GridData(SWT.BEGINNING, SWT.FILL, false, false);
        fBackgroundColor.setLayoutData(gd);
        fBackgroundColorEditor.setEnabled(false);

        fBold = createCheckbox(editControls, XMLUIMessages.SyntaxColoringPage_3);
        fBold.setEnabled(false);
        ((GridData) fBold.getLayoutData()).horizontalSpan = 2;
        fItalic = createCheckbox(editControls,
                XMLUIMessages.SyntaxColoringPage_4);
        fItalic.setEnabled(false);
        ((GridData) fItalic.getLayoutData()).horizontalSpan = 2;
        fStrike = createCheckbox(editControls,
                XMLUIMessages.SyntaxColoringPage_5);
        fStrike.setEnabled(false);
        ((GridData) fStrike.getLayoutData()).horizontalSpan = 2;
        fUnderline = createCheckbox(editControls,
                XMLUIMessages.SyntaxColoringPage_6);
        fUnderline.setEnabled(false);
        ((GridData) fUnderline.getLayoutData()).horizontalSpan = 2;
        fClearStyle = new Button(editingComposite, SWT.PUSH);
        fClearStyle.setText(SSEUIMessages.Restore_Default_UI_); //$NON-NLS-1$ = "Restore Default"
        fClearStyle.setLayoutData(new GridData(SWT.BEGINNING));
        ((GridData) fClearStyle.getLayoutData()).horizontalIndent = 20;
        fClearStyle.setEnabled(false);

        Composite sampleArea = createComposite(editor, 1);

        ((GridLayout) sampleArea.getLayout()).marginLeft = 5;
        ((GridLayout) sampleArea.getLayout()).marginTop = 5;
        createLabel(sampleArea, SSEUIMessages.Sample_text__UI_); //$NON-NLS-1$ = "&Sample text:"
        SourceViewer viewer = new SourceViewer(sampleArea, null, SWT.BORDER
                | SWT.LEFT_TO_RIGHT | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL
                | SWT.READ_ONLY);
        fText = viewer.getTextWidget();
        GridData gridData3 = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData3.widthHint = convertWidthInCharsToPixels(20);
        gridData3.heightHint = convertHeightInCharsToPixels(5);
        gridData3.horizontalSpan = 2;
        fText.setLayoutData(gridData3);
        fText.setEditable(false);
        fText.setFont(JFaceResources.getFont("org.eclipse.wst.sse.ui.textfont")); //$NON-NLS-1$
        fText.addKeyListener(getTextKeyListener());
        fText.addSelectionListener(getTextSelectionListener());
        fText.addMouseListener(getTextMouseListener());
        fText.addTraverseListener(getTraverseListener());
        setAccessible(fText, SSEUIMessages.Sample_text__UI_);
        fDocument = StructuredModelManager.getModelManager()
                .createStructuredDocumentFor(
                        ContentTypeIdForTwig.CONTENT_TYPE_ID_TWIG);
        fDocument.set(getExampleText());
        viewer.setDocument(fDocument);

        top.setWeights(new int[]{2, 1});
        editor.setWeights(new int[]{1, 1});
        PlatformUI
                .getWorkbench()
                .getHelpSystem()
                .setHelp(pageComponent,
                        IPHPHelpContextIds.SYNTAX_COLORING_PREFERENCES);

        fStylesViewer.setInput(getStylePreferenceKeys());

        fOverlayStore.addPropertyChangeListener(fHighlightingChangeListener);

        try {

            initHighlightingPositions();
            initHighlightingStyles();
            applyStyles();

        } catch (Exception e) {
            Logger.logException(e);
        }

        fStylesViewer
                .addSelectionChangedListener(new ISelectionChangedListener()
                {
                    public void selectionChanged(SelectionChangedEvent event)
                    {
                        if (!event.getSelection().isEmpty()) {
                            Object o = ((IStructuredSelection) event
                                    .getSelection()).getFirstElement();
                            String namedStyle = o.toString();

                            activate(namedStyle);
                            if (namedStyle == null)
                                return;
                        }
                    }
                });

        fForegroundColorEditor.addListener(new IPropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent event)
            {
                if (event.getProperty().equals(ColorSelector.PROP_COLORCHANGE)) {
                    Object o = ((IStructuredSelection) fStylesViewer
                            .getSelection()).getFirstElement();
                    String namedStyle = o.toString();

                    String prefString = getOverlayStore().getString(namedStyle);
                    String[] stylePrefs = ColorHelper
                            .unpackStylePreferences(prefString);
                    if (stylePrefs != null) {
                        String oldValue = stylePrefs[0];
                        // open color dialog to get new color
                        String newValue = ColorHelper
                                .toRGBString(fForegroundColorEditor
                                        .getColorValue());

                        if (!newValue.equals(oldValue)) {
                            stylePrefs[0] = newValue;
                            String newPrefString = ColorHelper
                                    .packStylePreferences(stylePrefs);
                            getOverlayStore().setValue(namedStyle,
                                    newPrefString);
                            applyStyles();
                            fText.redraw();
                        }
                    }
                }
            }
        });

        fBackgroundColorEditor.addListener(new IPropertyChangeListener()
        {
            public void propertyChange(PropertyChangeEvent event)
            {
                if (event.getProperty().equals(ColorSelector.PROP_COLORCHANGE)) {
                    Object o = ((IStructuredSelection) fStylesViewer
                            .getSelection()).getFirstElement();
                    String namedStyle = o.toString();

                    String prefString = getOverlayStore().getString(namedStyle);
                    String[] stylePrefs = ColorHelper
                            .unpackStylePreferences(prefString);
                    if (stylePrefs != null) {
                        String oldValue = stylePrefs[1];
                        // open color dialog to get new color
                        String newValue = ColorHelper
                                .toRGBString(fBackgroundColorEditor
                                        .getColorValue());

                        if (!newValue.equals(oldValue)) {
                            stylePrefs[1] = newValue;
                            String newPrefString = ColorHelper
                                    .packStylePreferences(stylePrefs);
                            getOverlayStore().setValue(namedStyle,
                                    newPrefString);
                            applyStyles();
                            fText.redraw();
                            activate(namedStyle);
                        }
                    }
                }
            }
        });

        fBold.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                super.widgetSelected(e);
                // get current (newly old) style
                Object o = ((IStructuredSelection) fStylesViewer.getSelection())
                        .getFirstElement();
                String namedStyle = o.toString();

                String prefString = getOverlayStore().getString(namedStyle);
                String[] stylePrefs = ColorHelper
                        .unpackStylePreferences(prefString);
                if (stylePrefs != null) {
                    String oldValue = stylePrefs[2];
                    String newValue = String.valueOf(fBold.getSelection());
                    if (!newValue.equals(oldValue)) {
                        stylePrefs[2] = newValue;
                        String newPrefString = ColorHelper
                                .packStylePreferences(stylePrefs);
                        getOverlayStore().setValue(namedStyle, newPrefString);
                        applyStyles();
                        fText.redraw();
                    }
                }
            }
        });

        fItalic.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                super.widgetSelected(e);
                // get current (newly old) style
                Object o = ((IStructuredSelection) fStylesViewer.getSelection())
                        .getFirstElement();
                String namedStyle = o.toString();
                String prefString = getOverlayStore().getString(namedStyle);
                String[] stylePrefs = ColorHelper
                        .unpackStylePreferences(prefString);
                if (stylePrefs != null) {
                    String oldValue = stylePrefs[3];
                    String newValue = String.valueOf(fItalic.getSelection());
                    if (!newValue.equals(oldValue)) {
                        stylePrefs[3] = newValue;
                        String newPrefString = ColorHelper
                                .packStylePreferences(stylePrefs);
                        getOverlayStore().setValue(namedStyle, newPrefString);
                        applyStyles();
                        fText.redraw();
                    }
                }
            }
        });

        fStrike.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                super.widgetSelected(e);
                // get current (newly old) style
                Object o = ((IStructuredSelection) fStylesViewer.getSelection())
                        .getFirstElement();
                String namedStyle = o.toString();
                String prefString = getOverlayStore().getString(namedStyle);
                String[] stylePrefs = ColorHelper
                        .unpackStylePreferences(prefString);
                if (stylePrefs != null) {
                    String oldValue = stylePrefs[4];
                    String newValue = String.valueOf(fStrike.getSelection());
                    if (!newValue.equals(oldValue)) {
                        stylePrefs[4] = newValue;
                        String newPrefString = ColorHelper
                                .packStylePreferences(stylePrefs);
                        getOverlayStore().setValue(namedStyle, newPrefString);
                        applyStyles();
                        fText.redraw();
                    }
                }
            }
        });

        fUnderline.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                super.widgetSelected(e);
                // get current (newly old) style
                Object o = ((IStructuredSelection) fStylesViewer.getSelection())
                        .getFirstElement();
                String namedStyle = o.toString();

                String prefString = getOverlayStore().getString(namedStyle);
                String[] stylePrefs = ColorHelper
                        .unpackStylePreferences(prefString);
                if (stylePrefs != null) {
                    String oldValue = stylePrefs[5];
                    String newValue = String.valueOf(fUnderline.getSelection());
                    if (!newValue.equals(oldValue)) {
                        stylePrefs[5] = newValue;
                        String newPrefString = ColorHelper
                                .packStylePreferences(stylePrefs);
                        getOverlayStore().setValue(namedStyle, newPrefString);
                        applyStyles();
                        fText.redraw();
                    }
                }
            }
        });

        fClearStyle.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent e)
            {
                if (fStylesViewer.getSelection().isEmpty())
                    return;
                String namedStyle = ((IStructuredSelection) fStylesViewer
                        .getSelection()).getFirstElement().toString();

                getOverlayStore().setToDefault(namedStyle);

                applyStyles();
                fText.redraw();
                activate(namedStyle);
            }
        });

        fEnabler.addSelectionListener(new SelectionAdapter()
        {

            public void widgetSelected(SelectionEvent e)
            {
                // get current (newly old) style
                Object o = ((IStructuredSelection) fStylesViewer.getSelection())
                        .getFirstElement();
                String namedStyle = o.toString();

                if (getStylePreferenceKeys().contains(namedStyle)) {
                    boolean enablement = fEnabler.getSelection();
                    switchEnablement(enablement);
                    getOverlayStore().setValue(
                            PreferenceConstants
                                    .getEnabledPreferenceKey(namedStyle),
                            enablement);
                }
            }

        });

        switchEnablement(false);
        return pageComponent;
    }

    private void initHighlightingStyles()
    {

        highlightingStyleMap = new HashMap<String, TwigSyntaxColoringPage.HighlightingStyle>();

    }

    private void initHighlightingPositions()
    {

        highlightingPositionMap = new HashMap<String, Position[]>();
        IPath stateLocation = TwigUICorePlugin.getDefault().getStateLocation();
        IPath path = stateLocation.append("/_" + "PHPSyntax"); //$NON-NLS-1$
        IFileStore fileStore = EFS.getLocalFileSystem().getStore(path);

        NonExistingPHPFileEditorInput input = new NonExistingPHPFileEditorInput(
                fileStore, "PHPSyntax");

        File realFile = ((NonExistingPHPFileEditorInput) input).getPath(input)
                .toFile();

        try {
            FileOutputStream fos = new FileOutputStream(realFile);
            fos.write(fDocument.get().getBytes());
            fos.close();
            DLTKUIPlugin.getDocumentProvider().connect(input);
            final ISourceModule sourceModule = DLTKUIPlugin
                    .getDocumentProvider().getWorkingCopy(input);
            if (sourceModule != null) {
                ASTParser parser = ASTParser.newParser(PHPVersion.PHP5_3,
                        sourceModule);
                parser.setSource(fDocument.get().toCharArray());

                final Program program = parser.createAST(null);
                List<AbstractSemanticHighlighting> highlightings = new ArrayList<AbstractSemanticHighlighting>();

                Collections.sort(highlightings);

                for (Iterator iterator = highlightings.iterator(); iterator
                        .hasNext();) {
                    AbstractSemanticHighlighting abstractSemanticHighlighting = (AbstractSemanticHighlighting) iterator
                            .next();
                    Position[] positions = abstractSemanticHighlighting
                            .consumes(program);

                    if (positions != null && positions.length > 0) {
                        highlightingPositionMap
                                .put(abstractSemanticHighlighting
                                        .getPreferenceKey(), positions);

                    }
                }
            }
            DLTKUIPlugin.getDocumentProvider().disconnect(input);
        } catch (CoreException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        realFile.delete();

    }

    private Composite createComposite(Composite parent, int numColumns)
    {
        Composite composite = new Composite(parent, SWT.NULL);

        // GridLayout
        GridLayout layout = new GridLayout();
        layout.numColumns = numColumns;
        layout.makeColumnsEqualWidth = false;
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        composite.setLayout(layout);

        // GridData
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
        composite.setLayoutData(data);
        return composite;
    }

    private Label createLabel(Composite parent, String text)
    {
        Label label = new Label(parent, SWT.WRAP);
        label.setText(text);
        GridData data = new GridData(SWT.FILL, SWT.FILL, false, false);
        label.setLayoutData(data);
        label.setBackground(parent.getBackground());
        return label;
    }

    private StructuredViewer createStylesViewer(Composite parent)
    {
        StructuredViewer stylesViewer = new ListViewer(parent, SWT.SINGLE
                | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
        stylesViewer
                .setComparator(new ViewerComparator(Collator.getInstance()));
        stylesViewer.setLabelProvider(new LabelProvider()
        {
            @Override
            public String getText(Object element)
            {
                Object description = fStyleToDescriptionMap.get(element);
                if (description != null)
                    return description.toString();

                return super.getText(element);
            }
        });
        stylesViewer.setContentProvider(new ITreeContentProvider()
        {
            public void dispose()
            {
            }

            public Object[] getChildren(Object parentElement)
            {
                return getStylePreferenceKeys().toArray();
            }

            public Object[] getElements(Object inputElement)
            {
                return getChildren(inputElement);
            }

            public Object getParent(Object element)
            {
                return getStylePreferenceKeys();
            }

            public boolean hasChildren(Object element)
            {
                return false;
            }

            public void inputChanged(Viewer viewer, Object oldInput,
                    Object newInput)
            {
            }
        });
        return stylesViewer;
    }

    Button createCheckbox(Composite parent, String label)
    {
        Button button = new Button(parent, SWT.CHECK);
        button.setText(label);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        return button;
    }

    private KeyListener getTextKeyListener()
    {
        return new KeyListener()
        {
            public void keyPressed(KeyEvent e)
            {
                if (e.widget instanceof StyledText) {
                    int x = ((StyledText) e.widget).getCaretOffset();
                    selectColorAtOffset(x);
                }
            }

            public void keyReleased(KeyEvent e)
            {
                if (e.widget instanceof StyledText) {
                    int x = ((StyledText) e.widget).getCaretOffset();
                    selectColorAtOffset(x);
                }
            }
        };
    }

    private MouseListener getTextMouseListener()
    {
        return new MouseListener()
        {
            public void mouseDoubleClick(MouseEvent e)
            {
            }

            public void mouseDown(MouseEvent e)
            {
            }

            public void mouseUp(MouseEvent e)
            {
                if (e.widget instanceof StyledText) {
                    int x = ((StyledText) e.widget).getCaretOffset();
                    selectColorAtOffset(x);
                }
            }
        };
    }

    private SelectionListener getTextSelectionListener()
    {
        return new SelectionListener()
        {
            public void widgetDefaultSelected(SelectionEvent e)
            {
                selectColorAtOffset(e.x);
                if (e.widget instanceof StyledText) {
                    ((StyledText) e.widget).setSelection(e.x);
                }
            }

            public void widgetSelected(SelectionEvent e)
            {
                selectColorAtOffset(e.x);
                if (e.widget instanceof StyledText) {
                    ((StyledText) e.widget).setSelection(e.x);
                }
            }
        };
    }

    private TraverseListener getTraverseListener()
    {
        return new TraverseListener()
        {
            /**
             * @see org.eclipse.swt.events.TraverseListener#keyTraversed(TraverseEvent)
             */
            public void keyTraversed(TraverseEvent e)
            {
                if (e.widget instanceof StyledText) {
                    if ((e.detail == SWT.TRAVERSE_TAB_NEXT)
                            || (e.detail == SWT.TRAVERSE_TAB_PREVIOUS))
                        e.doit = true;
                }
            }
        };
    }

    private void selectColorAtOffset(int offset)
    {
        String namedStyle = getNamedStyleAtOffset(offset);
        if (namedStyle != null) {
            fStylesViewer.setSelection(new StructuredSelection(namedStyle));
            fStylesViewer.reveal(namedStyle);
        } else {
            fStylesViewer.setSelection(StructuredSelection.EMPTY);
        }
        activate(namedStyle);
    }

    private String getNamedStyleAtOffset(int offset)
    {
        // ensure the offset is clean
        if (offset >= fDocument.getLength())
            return getNamedStyleAtOffset(fDocument.getLength() - 1);
        else if (offset < 0)
            return getNamedStyleAtOffset(0);

        if (highlightingPositionMap == null) {
            initHighlightingPositions();
        }

        for (Iterator iterator = highlightingPositionMap.keySet().iterator(); iterator
                .hasNext();) {
            String type = (String) iterator.next();
            Position[] positions = highlightingPositionMap.get(type);
            for (int i = 0; i < positions.length; i++) {
                if (offset >= positions[i].offset
                        && offset < positions[i].offset + positions[i].length) {
                    return type;
                }
            }
        }

        IStructuredDocumentRegion documentRegion = fDocument
                .getFirstStructuredDocumentRegion();
        while (documentRegion != null && !documentRegion.containsOffset(offset)) {
            documentRegion = documentRegion.getNext();
        }

        if (documentRegion != null) {
            String regionContext;
            ITextRegion interest = documentRegion
                    .getRegionAtCharacterOffset(offset);

            ITextRegionCollection container = documentRegion;
            if (interest instanceof ITextRegionContainer) {
                container = (ITextRegionContainer) interest;
                interest = container.getRegionAtCharacterOffset(offset);
            }

            if (interest.getType() == TwigRegionContext.TWIG_CONTENT) {
                ITwigScriptRegion phpScript = (ITwigScriptRegion) interest;
                try {
                    regionContext = phpScript
                            .getTwigTokenType(offset
                                    - container.getStartOffset()
                                    - phpScript.getStart());
                } catch (BadLocationException e) {
                    assert false;
                    return null;
                }
            } else if (interest.getType() == TwigRegionContext.TWIG_STMT_OPEN) {
                regionContext = TwigRegionTypes.TWIG_OPEN;
            } else if (interest.getType() == TwigRegionContext.TWIG_STMT_CLOSE) {
                regionContext = TwigRegionTypes.TWIG_CLOSETAG;
            } else {
                regionContext = interest.getType();
            }

            // find the named style (internal/selectable name) for that
            // context
            String namedStyle = fContextToStyleMap.get(regionContext);
            return namedStyle;
        }
        return null;
    }

    private void activate(String namedStyle)
    {
        Color foreground = fDefaultForeground;
        Color background = fDefaultBackground;
        if (namedStyle == null) {
            fEnabler.setEnabled(false);
            fClearStyle.setEnabled(false);
            fBold.setEnabled(false);
            fItalic.setEnabled(false);
            fStrike.setEnabled(false);
            fUnderline.setEnabled(false);
            fForegroundLabel.setEnabled(false);
            fBackgroundLabel.setEnabled(false);
            fForegroundColorEditor.setEnabled(false);
            fBackgroundColorEditor.setEnabled(false);
            fBold.setSelection(false);
            fItalic.setSelection(false);
            fStrike.setSelection(false);
            fUnderline.setSelection(false);
        } else {
            TextAttribute attribute = getAttributeFor(namedStyle);
            boolean enabled = true;

            enabled = getOverlayStore().getBoolean(
                    PreferenceConstants.getEnabledPreferenceKey(namedStyle));

            fEnabler.setSelection(enabled);
            fEnabler.setEnabled(true);
            fClearStyle.setEnabled(true);
            fBold.setEnabled(enabled);
            fItalic.setEnabled(enabled);
            fStrike.setEnabled(enabled);
            fUnderline.setEnabled(enabled);
            fForegroundLabel.setEnabled(enabled);
            fBackgroundLabel.setEnabled(enabled);
            fForegroundColorEditor.setEnabled(enabled);
            fBackgroundColorEditor.setEnabled(enabled);
            fBold.setSelection((attribute.getStyle() & SWT.BOLD) != 0);
            fItalic.setSelection((attribute.getStyle() & SWT.ITALIC) != 0);
            fStrike.setSelection((attribute.getStyle() & TextAttribute.STRIKETHROUGH) != 0);
            fUnderline
                    .setSelection((attribute.getStyle() & TextAttribute.UNDERLINE) != 0);
            if (attribute.getForeground() != null) {
                foreground = attribute.getForeground();
            }
            if (attribute.getBackground() != null) {
                background = attribute.getBackground();
            }
        }

        fForegroundColorEditor.setColorValue(foreground.getRGB());
        fBackgroundColorEditor.setColorValue(background.getRGB());

    }

    private OverlayPreferenceStore getOverlayStore()
    {
        return fOverlayStore;
    }

    private TextAttribute getAttributeFor(String namedStyle)
    {
        TextAttribute ta = new TextAttribute(fDefaultForeground,
                fDefaultBackground, SWT.NORMAL);

        if (namedStyle != null && fOverlayStore != null) {

            // note: "namedStyle" *is* the preference key
            String prefString = getOverlayStore().getString(namedStyle);
            String[] stylePrefs = ColorHelper
                    .unpackStylePreferences(prefString);
            if (stylePrefs != null) {
                RGB foreground = ColorHelper.toRGB(stylePrefs[0]);
                RGB background = ColorHelper.toRGB(stylePrefs[1]);

                int fontModifier = SWT.NORMAL;

                if (stylePrefs.length > 2) {
                    boolean on = Boolean.valueOf(stylePrefs[2]).booleanValue();
                    if (on)
                        fontModifier = fontModifier | SWT.BOLD;
                }
                if (stylePrefs.length > 3) {
                    boolean on = Boolean.valueOf(stylePrefs[3]).booleanValue();
                    if (on)
                        fontModifier = fontModifier | SWT.ITALIC;
                }
                if (stylePrefs.length > 4) {
                    boolean on = Boolean.valueOf(stylePrefs[4]).booleanValue();
                    if (on)
                        fontModifier = fontModifier
                                | TextAttribute.STRIKETHROUGH;
                }
                if (stylePrefs.length > 5) {
                    boolean on = Boolean.valueOf(stylePrefs[5]).booleanValue();
                    if (on)
                        fontModifier = fontModifier | TextAttribute.UNDERLINE;
                }

                ta = new TextAttribute((foreground != null)
                        ? EditorUtility.getColor(foreground)
                        : null, (background != null)
                        ? EditorUtility.getColor(background)
                        : null, fontModifier);
            }
        }
        return ta;
    }

    private void setAccessible(Control control, String name)
    {
        if (control == null)
            return;
        final String n = name;
        control.getAccessible().addAccessibleListener(new AccessibleAdapter()
        {
            @Override
            public void getName(AccessibleEvent e)
            {
                if (e.childID == ACC.CHILDID_SELF)
                    e.result = n;
            }
        });
    }

    private void switchEnablement(boolean b)
    {
        fBold.setEnabled(b);
        fItalic.setEnabled(b);
        fUnderline.setEnabled(b);
        fStrike.setEnabled(b);
        fBackgroundColorEditor.setEnabled(b);
        fForegroundColorEditor.setEnabled(b);
    }

    private String getExampleText()
    {
        return TwigUIMessages.ColorPage_CodeExample_0;
    }

    private void handleHighlightingPropertyChange(PropertyChangeEvent event)
    {
        String property = event.getProperty();
        if (property == null)
            return;
    }

    void applyStyles()
    {
        if (fText == null || fText.isDisposed())
            return;

        fStyleProvider.loadColors();

        IStructuredDocumentRegion documentRegion = fDocument
                .getFirstStructuredDocumentRegion();
        while (documentRegion != null) {
            final Collection<StyleRange> holdResults = new ArrayList<StyleRange>();
            fStyleProvider.prepareTextRegions(documentRegion, 0,
                    documentRegion.getEnd(), holdResults);

            for (Iterator<StyleRange> iter = holdResults.iterator(); iter
                    .hasNext();) {
                StyleRange element = iter.next();

                fText.setStyleRange(element);
            }

            documentRegion = documentRegion.getNext();
        }
    }

}
