/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;
import org.eclipse.jface.text.formatter.MultiPassContentFormatter;
import org.eclipse.php.ui.format.PHPFormatProcessorProxy;
import org.eclipse.wst.html.core.internal.format.HTMLFormatProcessorImpl;
import org.eclipse.wst.html.core.text.IHTMLPartitions;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredPartitioning;
import org.eclipse.wst.sse.ui.internal.format.StructuredFormattingStrategy;

import com.dubture.twig.core.format.TwigFormatProcessorImpl;
import com.dubture.twig.ui.TwigUICorePlugin;

public class TwigContentFormatter implements IContentFormatter
{

    @Override
    public void format(IDocument document, IRegion region)
    {

        IFile file = TwigUICorePlugin.getDefault().getFile(document);
        IProject project = null;
        if (file != null) {
            project = file.getProject();
        }

        if (isFormatFile()) {
            MultiPassContentFormatter pdtFormatter = new MultiPassContentFormatter(
                    IStructuredPartitioning.DEFAULT_STRUCTURED_PARTITIONING,
                    IHTMLPartitions.HTML_DEFAULT);
            pdtFormatter.setMasterStrategy(new StructuredFormattingStrategy(
                    new HTMLFormatProcessorImpl()));
            pdtFormatter.format(document, region);
        } else {
            StructuredTextMultiPassContentFormatter pdtFormatter = new StructuredTextMultiPassContentFormatter(
                    IStructuredPartitioning.DEFAULT_STRUCTURED_PARTITIONING,
                    IHTMLPartitions.HTML_DEFAULT);
            pdtFormatter.setMasterStrategy(new StructuredFormattingStrategy(
                    new TwigFormatProcessorImpl()));
            pdtFormatter.format(document, region);
            // pdtFormatter.format(document, region);
        }

    }

    @Override
    public IFormattingStrategy getFormattingStrategy(String contentType)
    {
        // TODO Auto-generated method stub
        return null;

    }

    private boolean isFormatFile()
    {
        StackTraceElement[] stackTraces = new Exception().getStackTrace();
        for (StackTraceElement stackTrace : stackTraces) {
            if (stackTrace.getClassName().equals(
                    PHPFormatProcessorProxy.class.getName())) {
                if (stackTrace.getMethodName().equals("formatFile")) {
                    return true;
                }
            }
        }
        return false;
    }

}
