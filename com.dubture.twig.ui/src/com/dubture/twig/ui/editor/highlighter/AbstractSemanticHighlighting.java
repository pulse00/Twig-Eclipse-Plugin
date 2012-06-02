/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.highlighter;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.declarations.ModuleDeclaration;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.Position;
import org.eclipse.php.internal.ui.editor.PHPStructuredEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.ui.ISemanticHighlighting;
import org.eclipse.wst.sse.ui.ISemanticHighlightingExtension2;

import com.dubture.twig.core.log.Logger;
import com.dubture.twig.core.parser.SourceParserUtil;
import com.dubture.twig.ui.TwigUICorePlugin;
import com.dubture.twig.ui.editor.SemanticHighlightingStyle;
import com.dubture.twig.ui.preferences.PreferenceConstants;

@SuppressWarnings("restriction")
public abstract class AbstractSemanticHighlighting implements ISemanticHighlighting,
        ISemanticHighlightingExtension2, Comparable<AbstractSemanticHighlighting>
{

    private ISourceModule sourceModule = null;

    private SemanticHighlightingStyle style = new SemanticHighlightingStyle(
            getPreferenceKey());

    private List<Position> list;

    private final String preferenceKey = this.getClass().getName();

    public String getPreferenceKey() {
        return preferenceKey;
    }

    public SemanticHighlightingStyle getStyle() {
        return style;
    }

    public ISourceModule getSourceModule() {
        if (sourceModule == null) {
            throw new IllegalStateException("Source module cannot be null");
        }
        return sourceModule;
    }

    protected AbstractSemanticHighlighting highlight(ISourceRange range) {
        if (range == null) {
            throw new IllegalArgumentException("Range cannot be null");
        }
        return highlight(range.getOffset(), range.getLength());
    }

    protected AbstractSemanticHighlighting highlight(ASTNode node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        return highlight(node.sourceStart(), (node.sourceEnd()-node.sourceStart()));
    }

    protected AbstractSemanticHighlighting highlight(int start, int length) {
        if (list == null) {
            throw new IllegalStateException();
        }
        list.add(new Position(start, length));
        return this;
    }

    public Position[] consumes(ModuleDeclaration program) {
        if (program != null) {
            list = new ArrayList<Position>();
            
            try {
                AbstractSemanticApply apply = getSemanticApply();
                program.traverse(apply);
            } catch (Exception e) {
                Logger.logException(e);
            } 
            
            return list.toArray(new Position[list.size()]);
        }
        return new Position[0];
    }

    public Position[] consumes(IStructuredDocumentRegion region) {
        if (region.getStart() == 0) {
            ModuleDeclaration program = getProgram(region);
            return consumes(program);
        }
        return new Position[0];
    }

    protected ModuleDeclaration getProgram(final IStructuredDocumentRegion region) {// region.getParentDocument().get()
        sourceModule = null;
        // resolve current sourceModule
        PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
            public void run() {
                IWorkbenchPage page = TwigUICorePlugin.getActivePage();
                if (page != null) {
                    IEditorPart editor = page.getActiveEditor();
                    if (editor instanceof PHPStructuredEditor) {
                        PHPStructuredEditor phpStructuredEditor = (PHPStructuredEditor) editor;
                        if (phpStructuredEditor.getTextViewer() != null
                                && phpStructuredEditor != null
                                && phpStructuredEditor.getDocument() == region
                                        .getParentDocument()) {
                            if (phpStructuredEditor != null
                                    && phpStructuredEditor.getTextViewer() != null) {
                                sourceModule = (ISourceModule) phpStructuredEditor
                                        .getModelElement();
                            }
                        }
                    }
                }
            }
        });

        ModuleDeclaration module = null;
        try {
            if (sourceModule != null) {
                module = SourceParserUtil.parseSourceModule(sourceModule.getSource());
            }
        } catch (Exception e) {
            Logger.logException(e);
        }
        return module;
    }

    public String getBoldPreferenceKey() {
        return PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_PREFIX
                + preferenceKey
                + PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_BOLD_SUFFIX;
    }

    public String getColorPreferenceKey() {
        return PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_PREFIX
                + preferenceKey
                + PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_COLOR_SUFFIX;
    }

    public String getBackgroundColorPreferenceKey() {
        return PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_PREFIX
                + preferenceKey
                + PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_BGCOLOR_SUFFIX;
    }

    public String getEnabledPreferenceKey() {
        return PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_PREFIX
                + preferenceKey
                + PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_ENABLED_SUFFIX;
    }

    public String getItalicPreferenceKey() {
        return PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_PREFIX
                + preferenceKey
                + PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_ITALIC_SUFFIX;
    }

    public IPreferenceStore getPreferenceStore() {
        return PreferenceConstants.getPreferenceStore();
    }

    public String getStrikethroughPreferenceKey() {
        return PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_PREFIX
                + preferenceKey
                + PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_STRIKETHROUGH_SUFFIX;
    }

    public String getUnderlinePreferenceKey() {
        return PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_PREFIX
                + preferenceKey
                + PreferenceConstants.EDITOR_SEMANTIC_HIGHLIGHTING_UNDERLINE_SUFFIX;
    }

    public abstract AbstractSemanticApply getSemanticApply();

    public abstract void initDefaultPreferences();

    public int compareTo(AbstractSemanticHighlighting highlighter) {
        return getPriority() - highlighter.getPriority();
    }

    public int getPriority() {
        return 100;
    }

    @Override
    abstract public String getDisplayName();
}
