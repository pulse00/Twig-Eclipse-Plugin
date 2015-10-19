/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor;

import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.wst.sse.ui.internal.StructuredTextViewer;

/**
 * 
 * {@link TwigStructuredTextViewer} can be used to override viewer behavior or
 * the {@link StructuredTextViewer}.
 * 
 * Not used at the moment.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class TwigStructuredTextViewer extends StructuredTextViewer {
	private SourceViewerConfiguration fViewerConfiguration;

	public TwigStructuredTextViewer(ITextEditor textEditor, Composite parent, IVerticalRuler verticalRuler,
			IOverviewRuler overviewRuler, boolean showAnnotationsOverview, int styles) {
		super(parent, verticalRuler, overviewRuler, showAnnotationsOverview, styles);

	}

	@Override
	public void doOperation(int operation) {
		// switch (operation) {
		// case CONTENTASSIST_PROPOSALS:
		// if (fViewerConfiguration != null) {
		// TwigStructuredTextViewerConfiguration
		// structuredTextViewerConfiguration =
		// (TwigStructuredTextViewerConfiguration) fViewerConfiguration;
		// IContentAssistProcessor[] all =
		// structuredTextViewerConfiguration.getContentAssistProcessors(this,
		// TwigPartitionTypes.TWIG_DEFAULT);
		// for (IContentAssistProcessor element : all) {
		// if (element instanceof PHPCompletionProcessor) {
		// ((PHPCompletionProcessor) element).setExplicit(true);
		// }
		// }
		// }
		// }
		super.doOperation(operation);
	}

	@Override
	public void configure(SourceViewerConfiguration configuration) {
		super.configure(configuration);
		fViewerConfiguration = configuration;
	}

	public SourceViewerConfiguration getViewerConfiguration() {
		return fViewerConfiguration;
	}

}
