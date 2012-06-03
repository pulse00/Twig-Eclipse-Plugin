/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.hyperlink;

import org.eclipse.dltk.core.IModelElement;

import org.eclipse.dltk.internal.ui.editor.EditorUtility;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.php.internal.core.PHPVersion;
import org.eclipse.php.internal.core.project.ProjectOptions;
import org.eclipse.php.internal.ui.editor.PHPStructuredEditor;

@SuppressWarnings("restriction")
public class FunctionHyperlinkDetector extends AbstractHyperlinkDetector
{

    public FunctionHyperlinkDetector()
    {
    }

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer,
            IRegion region, boolean canShowMultipleHyperlinks)
    {

        final PHPStructuredEditor editor = org.eclipse.php.internal.ui.util.EditorUtility
                .getPHPEditor(textViewer);
        if (editor == null) {
            return null;
        }

        if (region == null) {
            return null;
        }

        IModelElement input = EditorUtility.getEditorInputModelElement(editor,
                false);
        if (input == null) {
            return null;
        }

        PHPVersion phpVersion = ProjectOptions.getPhpVersion(input
                .getScriptProject().getProject());
        boolean namespacesSupported = phpVersion.isGreaterThan(PHPVersion.PHP5); // PHP
                                                                                    // 5.3
                                                                                    // and
                                                                                    // greater

        IDocument document = textViewer.getDocument();
        int offset = region.getOffset();
        
        return null;
    }

}
