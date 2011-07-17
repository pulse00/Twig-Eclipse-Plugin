package org.eclipse.twig.ui.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISelectionValidator;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.ImageUtilities;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.php.internal.core.ast.nodes.Program;
import org.eclipse.php.internal.core.documentModel.parser.PhpSourceParser;
import org.eclipse.php.internal.core.documentModel.partitioner.PHPPartitionTypes;
import org.eclipse.php.internal.ui.PHPUiPlugin;
import org.eclipse.php.internal.ui.editor.PHPStructuredEditor;
import org.eclipse.php.internal.ui.util.PHPPluginImages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.twig.core.documentModel.parser.TwigSourceParser;
import org.eclipse.twig.core.log.Logger;
import org.eclipse.twig.core.parser.TwigNode;
import org.eclipse.twig.core.parser.TwigParser;
import org.eclipse.twig.core.search.IOccurrencesFinder;
import org.eclipse.twig.core.search.IOccurrencesFinder.OccurrenceLocation;
import org.eclipse.twig.core.search.LocalVariableOccurrencesFinder;
import org.eclipse.twig.core.search.NodeFinder;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.internal.StructuredTextViewer;
import org.eclipse.wst.sse.ui.internal.reconcile.ReconcileAnnotationKey;
import org.eclipse.wst.sse.ui.internal.reconcile.TemporaryAnnotation;


/**
 * 
 * A modified {@link PHPStructuredEditor} for Twig templates.
 * 
 * Modifications concerning:
 *
 * - attaching {@link TwigSourceParser} instead of {@link PhpSourceParser}
 * - finding occurences 
 *
 */
@SuppressWarnings({"restriction", "unchecked"})
public class TwigStructuredEditor extends PHPStructuredEditor {

	private OccurrencesFinderJob fOccurrencesFinderJob;
	/** The occurrences finder job canceler */
	private OccurrencesFinderJobCanceler fOccurrencesFinderJobCanceler;
	
	private ISelection fForcedMarkOccurrencesSelection;
	
	/**
	 * Holds the current occurrence annotations.
	 * 
	 * @since 3.4
	 */
	private Annotation[] fOccurrenceAnnotations = null;
	
	private long fMarkOccurrenceModificationStamp = IDocumentExtension4.UNKNOWN_MODIFICATION_STAMP;
	/**
	 * The region of the word under the caret used to when computing the current
	 * occurrence markings.
	 * 
	 * @since 3.4
	 */
	private IRegion fMarkOccurrenceTargetRegion;
	


	public TwigStructuredEditor() {

	}

	/**
	 * TODO: check if this smarty code still applies in the twig
	 * editor. That's just copy/pasted from the smarty editor.
	 */
	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {

		IResource resource = null;
		if (input instanceof IFileEditorInput) {
			// This is the existing workspace file
			final IFileEditorInput fileInput = (IFileEditorInput) input;
			resource = fileInput.getFile();
		} else if (input instanceof IStorageEditorInput) {
			// This kind of editor input usually means non-workspace file, like
			// PHP file which comes from include path, remote file which comes
			// from
			// Web server while debugging, file from ZIP archive, etc...

			//			final IStorageEditorInput editorInput = (IStorageEditorInput) input;
			//			final IStorage storage = editorInput.getStorage();

			//			if (storage instanceof ZipEntryStorage) {
			//				resource = ((ZipEntryStorage) storage).getProject();
			//			}
		}

		if (resource instanceof IFile) {

			String ext = resource.getFileExtension();

			//TODO: make this configurable via preferences
			if ("twig".equals(ext) || "html".equals(ext)) {

				TwigSourceParser.editFile.set(resource);
				super.doSetInput(input);

			} else {
				super.doSetInput(input);
			}
		} else {
			super.doSetInput(input);
		}

		ImageDescriptor imageDescriptor = input.getImageDescriptor();
		if (imageDescriptor != null) {
			setTitleImage(JFaceResources.getResources().createImageWithDefault(imageDescriptor));
		}
		if (isShowingOverrideIndicators()) {
			installOverrideIndicator(true);
		}		
	}

	@Override
	protected StructuredTextViewer createStructedTextViewer(Composite parent,
			IVerticalRuler verticalRuler, int styles) {

		return new TwigStructuredTextViewer(this, parent, verticalRuler,
				getOverviewRuler(), isOverviewRulerVisible(), styles);
	}

	@Override
	protected void updateOccurrenceAnnotations(ITextSelection selection,
			Program astRoot) {

		super.updateOccurrenceAnnotations(selection, astRoot);
		
		if (astRoot == null || selection == null)
			return;

		IDocument document = getSourceViewer().getDocument();
		if (document == null)
			return;

		// TODO: see the method comment, need to be removed once
		// PHPStructuredEditor#aboutToBeChangedEvent is used
		if (document.getLength() != astRoot.getEnd()) {
			return;
		}

		//boolean hasChanged = false;
		
//		if (document instanceof IDocumentExtension4) {
//			int offset = selection.getOffset();
//			long currentModificationStamp = ((IDocumentExtension4) document)
//					.getModificationStamp();
//			IRegion markOccurrenceTargetRegion = fMarkOccurrenceTargetRegion;
//			hasChanged = currentModificationStamp != fMarkOccurrenceModificationStamp;
//			if (markOccurrenceTargetRegion != null && !hasChanged) {
//				if (markOccurrenceTargetRegion.getOffset() <= offset
//						&& offset <= markOccurrenceTargetRegion.getOffset()
//								+ markOccurrenceTargetRegion.getLength())
//					return;
//			}
//			fMarkOccurrenceTargetRegion = ScriptWordFinder.findWord(document,
//					offset);
//			fMarkOccurrenceModificationStamp = currentModificationStamp;
//		}

		OccurrenceLocation[] locations = null;
		ISourceModule module = (ISourceModule) getModelElement();
		
		String source;
		try {
			source = module.getSource();
		} catch (ModelException e) {
			Logger.logException(e);
			return;		
		}

		NodeFinder nodeFinder = new NodeFinder();
		
		TwigNode node = nodeFinder.find(source, selection.getOffset());
		
		if (node == null)
			return;


		if (node.getType() == TwigParser.STRING) {
			
			IOccurrencesFinder finder = new LocalVariableOccurrencesFinder();

			if (finder.initialize(source, node) == null) {
				locations = finder.getOccurrences();
			}
			
		}/* else if (node.getType() == TwigParser.BLOCK) {
			
			IOccurrencesFinder finder = new OpenCloseTagFinder();
			
			if (finder.initialize(source, node) == null) {				
				locations = finder.getOccurrences();
			}
		}*/
		

		if (locations == null)
			return;
		
		removeTwigOccurrenceAnnotations();
		
		fOccurrencesFinderJob = new OccurrencesFinderJob(document, locations,
				selection);
		fOccurrencesFinderJob.run(new NullProgressMonitor());
		
		
	}

	class OccurrencesFinderJobCanceler implements IDocumentListener,
	ITextInputListener {

		public void install() {
			ISourceViewer sourceViewer = getSourceViewer();
			if (sourceViewer == null)
				return;

			StyledText text = sourceViewer.getTextWidget();
			if (text == null || text.isDisposed())
				return;

			sourceViewer.addTextInputListener(this);

			IDocument document = sourceViewer.getDocument();
			if (document != null)
				document.addDocumentListener(this);
		}

		public void uninstall() {
			ISourceViewer sourceViewer = getSourceViewer();
			if (sourceViewer != null)
				sourceViewer.removeTextInputListener(this);

			IDocumentProvider documentProvider = getDocumentProvider();
			if (documentProvider != null) {
				IDocument document = documentProvider
						.getDocument(getEditorInput());
				if (document != null)
					document.removeDocumentListener(this);
			}
		}

		/*
		 * @see
		 * org.eclipse.jface.text.IDocumentListener#documentAboutToBeChanged
		 * (org.eclipse.jface.text.DocumentEvent)
		 */
		public void documentAboutToBeChanged(DocumentEvent event) {
			if (fOccurrencesFinderJob != null)
				fOccurrencesFinderJob.doCancel();
		}

		/*
		 * @see
		 * org.eclipse.jface.text.IDocumentListener#documentChanged(org.eclipse
		 * .jface.text.DocumentEvent)
		 */
		public void documentChanged(DocumentEvent event) {
		}

		/*
		 * @see
		 * org.eclipse.jface.text.ITextInputListener#inputDocumentAboutToBeChanged
		 * (org.eclipse.jface.text.IDocument, org.eclipse.jface.text.IDocument)
		 */
		public void inputDocumentAboutToBeChanged(IDocument oldInput,
				IDocument newInput) {
			if (oldInput == null)
				return;

			oldInput.removeDocumentListener(this);
		}

		/*
		 * @see
		 * org.eclipse.jface.text.ITextInputListener#inputDocumentChanged(org
		 * .eclipse.jface.text.IDocument, org.eclipse.jface.text.IDocument)
		 */
		public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
			if (newInput == null)
				return;
			newInput.addDocumentListener(this);
		}
	}	


	/**
	 * Finds and marks occurrence annotations.
	 * 
	 * @since 3.0
	 */
	class OccurrencesFinderJob extends Job {

		private final IDocument fDocument;
		private final ISelection fSelection;
		private final ISelectionValidator fPostSelectionValidator;
		private boolean fCanceled = false;
		private final OccurrenceLocation[] fLocations;

		public OccurrencesFinderJob(IDocument document,
				OccurrenceLocation[] locations, ISelection selection) {
			super("mark occrrences job name"); // TODO should externals
			fDocument = document;
			fSelection = selection;
			fLocations = locations;

			if (getSelectionProvider() instanceof ISelectionValidator)
				fPostSelectionValidator = (ISelectionValidator) getSelectionProvider();
			else
				fPostSelectionValidator = null;
		}

		// cannot use cancel() because it is declared final
		void doCancel() {
			fCanceled = true;
			cancel();
		}

		private boolean isCanceled(IProgressMonitor progressMonitor) {
			return fCanceled
					|| progressMonitor.isCanceled()
					|| fPostSelectionValidator != null
					&& !(fPostSelectionValidator.isValid(fSelection) || fForcedMarkOccurrencesSelection == fSelection)
					|| LinkedModeModel.hasInstalledModel(fDocument);
		}

		/*
		 * @see Job#run(org.eclipse.core.runtime.IProgressMonitor)
		 */
		public IStatus run(IProgressMonitor progressMonitor) {
			if (isCanceled(progressMonitor))
				return Status.CANCEL_STATUS;

			ITextViewer textViewer = getTextViewer();
			if (textViewer == null)
				return Status.CANCEL_STATUS;

			IDocument document = textViewer.getDocument();
			if (document == null)
				return Status.CANCEL_STATUS;

			IDocumentProvider documentProvider = getDocumentProvider();
			if (documentProvider == null)
				return Status.CANCEL_STATUS;

			IAnnotationModel annotationModel = documentProvider
					.getAnnotationModel(getEditorInput());
			if (annotationModel == null)
				return Status.CANCEL_STATUS;

			// Add occurrence annotations
			int length = fLocations.length;
			Map<Annotation, Position> annotationMap = new HashMap<Annotation, Position>(
					length);
			for (int i = 0; i < length; i++) {

				if (isCanceled(progressMonitor))
					return Status.CANCEL_STATUS;

				OccurrenceLocation location = fLocations[i];
				Position position = new Position(location.getOffset(),
						location.getLength());

				String description = location.getDescription();
				String annotationType = (location.getFlags() == IOccurrencesFinder.F_WRITE_OCCURRENCE) ? "org.eclipse.php.ui.occurrences.write" : "org.eclipse.php.ui.occurrences"; //$NON-NLS-1$ //$NON-NLS-2$

				// create an annotation to mark the occurrence
				ReconcileAnnotationKey reconcileAnnotationKey = new ReconcileAnnotationKey(
						null, PHPPartitionTypes.PHP_DEFAULT,
						ReconcileAnnotationKey.TOTAL);
				TemporaryAnnotation annotation = new TemporaryAnnotation(
						position, annotationType, description,
						reconcileAnnotationKey) {

					// Supply an occurrence image to display in the vertical
					// ruler
					@Override
					public void paint(GC gc, Canvas canvas, Rectangle r) {
						ImageUtilities.drawImage(
								PHPUiPlugin.getImageDescriptorRegistry().get(
										PHPPluginImages.DESC_OBJS_OCCURRENCES),
										gc, canvas, r, SWT.CENTER, SWT.TOP);
					}

				};
				annotationMap.put(annotation, position);
			}

			if (isCanceled(progressMonitor))
				return Status.CANCEL_STATUS;

			synchronized (getLockObject(annotationModel)) {
				if (annotationModel instanceof IAnnotationModelExtension) {
					((IAnnotationModelExtension) annotationModel)
					.replaceAnnotations(fOccurrenceAnnotations,
							annotationMap);
				} else {
					removeTwigOccurrenceAnnotations();
					for (Map.Entry<Annotation, Position> entry : annotationMap
							.entrySet()) {
						annotationModel.addAnnotation(entry.getKey(),
								entry.getValue());
					}
				}
				fOccurrenceAnnotations = annotationMap.keySet().toArray(
						new Annotation[annotationMap.keySet().size()]);
			}

			return Status.OK_STATUS;
		}
	}
	
	private Object getLockObject(IAnnotationModel annotationModel) {
		if (annotationModel instanceof ISynchronizable) {
			Object lock = ((ISynchronizable) annotationModel).getLockObject();
			if (lock != null)
				return lock;
		}
		return annotationModel;
	}
	
	private void removeTwigOccurrenceAnnotations() {
		
		IDocumentProvider documentProvider = getDocumentProvider();
		if (documentProvider == null)
			return;

		IAnnotationModel annotationModel = documentProvider
				.getAnnotationModel(getEditorInput());
		if (annotationModel == null || fOccurrenceAnnotations == null)
			return;

		synchronized (getLockObject(annotationModel)) {
			if (annotationModel instanceof IAnnotationModelExtension) {
				((IAnnotationModelExtension) annotationModel)
						.replaceAnnotations(fOccurrenceAnnotations, null);
			} else {
				for (int i = 0, length = fOccurrenceAnnotations.length; i < length; i++)
					annotationModel.removeAnnotation(fOccurrenceAnnotations[i]);
			}
			fOccurrenceAnnotations = null;
		}
	}
	
	@Override
	protected void uninstallOccurrencesFinder() {
		// TODO Auto-generated method stub
		super.uninstallOccurrencesFinder();
		
		if (fOccurrencesFinderJob != null) {
			fOccurrencesFinderJob.cancel();
			fOccurrencesFinderJob = null;
		}

		if (fOccurrencesFinderJobCanceler != null) {
			fOccurrencesFinderJobCanceler.uninstall();
			fOccurrencesFinderJobCanceler = null;
		}

		removeTwigOccurrenceAnnotations();
	}
}