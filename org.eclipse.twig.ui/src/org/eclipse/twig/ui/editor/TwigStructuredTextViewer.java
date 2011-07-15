package org.eclipse.twig.ui.editor;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.php.internal.ui.editor.PHPStructuredTextViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.ITextEditor;


/**
 * 
 * {@link TwigStructuredTextViewer} can be used to override
 * viewer behavior or the {@link PHPStructuredTextViewer}. 
 * 
 * Not used at the moment.
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 *
 */
@SuppressWarnings("restriction")
public class TwigStructuredTextViewer extends PHPStructuredTextViewer {

	public TwigStructuredTextViewer(ITextEditor textEditor, Composite parent,
			IVerticalRuler verticalRuler, IOverviewRuler overviewRuler,
			boolean showAnnotationsOverview, int styles) {
		super(textEditor, parent, verticalRuler, overviewRuler,
				showAnnotationsOverview, styles);

	}
	
	
	@Override
	public void setDocument(IDocument document, IAnnotationModel annotationModel) {


		System.err.println("set doc 1");
		super.setDocument(document, annotationModel);
	}
	
	@Override
	public void setDocument(IDocument document,
			IAnnotationModel annotationModel, int modelRangeOffset,
			int modelRangeLength) {
	
		System.err.println("set doc");
		super.setDocument(document, annotationModel, modelRangeOffset, modelRangeLength);
	}
	

}