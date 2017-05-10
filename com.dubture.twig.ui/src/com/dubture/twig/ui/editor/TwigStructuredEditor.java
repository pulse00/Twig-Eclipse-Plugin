/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.dltk.core.IMember;
import org.eclipse.dltk.core.ISourceRange;
import org.eclipse.dltk.core.ISourceReference;
import org.eclipse.dltk.core.ModelException;
import org.eclipse.dltk.internal.ui.actions.CompositeActionGroup;
import org.eclipse.dltk.ui.DLTKUIPlugin;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.ISelectionValidator;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.ImageUtilities;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.wst.sse.ui.StructuredTextEditor;
import org.eclipse.wst.sse.ui.internal.StructuredTextViewer;
import org.eclipse.wst.sse.ui.internal.reconcile.ReconcileAnnotationKey;
import org.eclipse.wst.sse.ui.internal.reconcile.TemporaryAnnotation;

import com.dubture.twig.core.documentModel.dom.IImplForTwig;
import com.dubture.twig.core.documentModel.parser.TwigSourceParser;
import com.dubture.twig.core.search.IOccurrencesFinder;
import com.dubture.twig.core.search.IOccurrencesFinder.OccurrenceLocation;
import com.dubture.twig.ui.actions.TwigRefactorActionGroup;

/**
 *
 * A modified {@link PHPStructuredEditor} for Twig templates.
 *
 * Modifications concerning:
 *
 * - attaching {@link TwigSourceParser} instead of {@link PhpSourceParser} -
 * finding occurences
 *
 */
@SuppressWarnings({ "restriction", "unchecked" })
public class TwigStructuredEditor extends StructuredTextEditor {

	private OccurrencesFinderJob fOccurrencesFinderJob;
	/** The occurrences finder job canceler */
	private OccurrencesFinderJobCanceler fOccurrencesFinderJobCanceler;

	private ISelection fForcedMarkOccurrencesSelection;

	private CompositeActionGroup fContextMenuGroup;

	private TwigRefactorActionGroup refactorGroup = null;
	private CompositeActionGroup fActionGroups;

	/**
	 * Holds the current occurrence annotations.
	 *
	 * @since 3.4
	 */
	private Annotation[] fOccurrenceAnnotations = null;

	public TwigStructuredEditor() {
		setDocumentProvider(DLTKUIPlugin.getDocumentProvider());
	}

	private TwigRefactorActionGroup getRefactorGroup() {

		if (refactorGroup != null)
			return refactorGroup;

		refactorGroup = new TwigRefactorActionGroup(this);
		return refactorGroup;

	}

	@Override
	protected void createActions() {

		// ActionGroup jsg = new PHPSearchActionGroup(this);

		// We have to keep the context menu group separate to have better
		// control over positioning
		fActionGroups = new CompositeActionGroup(new ActionGroup[] { getRefactorGroup() });
		fContextMenuGroup = new CompositeActionGroup(new ActionGroup[] { getRefactorGroup() });
		super.createActions();
	}

	public ActionGroup getActionGroup() {
		return fActionGroups;
	}

	public CompositeActionGroup getContextMenuGroup() {
		return fContextMenuGroup;
	}

	@Override
	public void editorContextMenuAboutToShow(IMenuManager menu) {
		super.editorContextMenuAboutToShow(menu);

		if (fContextMenuGroup != null) {
			ActionContext context = new ActionContext(getSelectionProvider().getSelection());
			fContextMenuGroup.setContext(context);
			fContextMenuGroup.fillContextMenu(menu);
			fContextMenuGroup.setContext(null);
		}
	}

	/**
	 * TODO: check if this smarty code still applies in the twig editor. That's
	 * just copy/pasted from the smarty editor.
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

			// final IStorageEditorInput editorInput = (IStorageEditorInput)
			// input;
			// final IStorage storage = editorInput.getStorage();

			// if (storage instanceof ZipEntryStorage) {
			// resource = ((ZipEntryStorage) storage).getProject();
			// }
		}

		if (resource instanceof IFile) {

			String ext = resource.getFileExtension();

			// TODO: Get the associated content types for file extensions
			// from preferences
			if (ext != null && (ext.contains("twig") || ext.contains("html"))) {
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
		// if (isShowingOverrideIndicators()) {
		// installOverrideIndicator(true);
		// }
	}

	@Override
	protected StructuredTextViewer createStructedTextViewer(Composite parent, IVerticalRuler verticalRuler,
			int styles) {

		return new TwigStructuredTextViewer(this, parent, verticalRuler, getOverviewRuler(), isOverviewRulerVisible(),
				styles);
	}

	class OccurrencesFinderJobCanceler implements IDocumentListener, ITextInputListener {

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
				IDocument document = documentProvider.getDocument(getEditorInput());
				if (document != null)
					document.removeDocumentListener(this);
			}
		}

		/*
		 * @see
		 * org.eclipse.jface.text.IDocumentListener#documentAboutToBeChanged
		 * (org.eclipse.jface.text.DocumentEvent)
		 */
		@Override
		public void documentAboutToBeChanged(DocumentEvent event) {
			if (fOccurrencesFinderJob != null)
				fOccurrencesFinderJob.doCancel();
		}

		/*
		 * @see
		 * org.eclipse.jface.text.IDocumentListener#documentChanged(org.eclipse
		 * .jface.text.DocumentEvent)
		 */
		@Override
		public void documentChanged(DocumentEvent event) {
		}

		/*
		 * @see org.eclipse.jface.text.ITextInputListener#
		 * inputDocumentAboutToBeChanged (org.eclipse.jface.text.IDocument,
		 * org.eclipse.jface.text.IDocument)
		 */
		@Override
		public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
			if (oldInput == null)
				return;

			oldInput.removeDocumentListener(this);
		}

		/*
		 * @see
		 * org.eclipse.jface.text.ITextInputListener#inputDocumentChanged(org
		 * .eclipse.jface.text.IDocument, org.eclipse.jface.text.IDocument)
		 */
		@Override
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

		public OccurrencesFinderJob(IDocument document, OccurrenceLocation[] locations, ISelection selection) {
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
			return fCanceled || progressMonitor.isCanceled() || fPostSelectionValidator != null
					&& !(fPostSelectionValidator.isValid(fSelection) || fForcedMarkOccurrencesSelection == fSelection)
					|| LinkedModeModel.hasInstalledModel(fDocument);
		}

		/*
		 * @see Job#run(org.eclipse.core.runtime.IProgressMonitor)
		 */
		@Override
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

			IAnnotationModel annotationModel = documentProvider.getAnnotationModel(getEditorInput());
			if (annotationModel == null)
				return Status.CANCEL_STATUS;

			// Add occurrence annotations
			int length = fLocations.length;
			Map<Annotation, Position> annotationMap = new HashMap<>(length);
			for (int i = 0; i < length; i++) {

				if (isCanceled(progressMonitor))
					return Status.CANCEL_STATUS;

				OccurrenceLocation location = fLocations[i];
				Position position = new Position(location.getOffset(), location.getLength());

				String description = location.getDescription();
				String annotationType = (location.getFlags() == IOccurrencesFinder.F_WRITE_OCCURRENCE)
						? "org.eclipse.php.ui.occurrences.write" : "org.eclipse.php.ui.occurrences"; //$NON-NLS-1$ //$NON-NLS-2$

				// create an annotation to mark the occurrence
				ReconcileAnnotationKey reconcileAnnotationKey = new ReconcileAnnotationKey(null,
						PHPPartitionTypes.PHP_DEFAULT, ReconcileAnnotationKey.TOTAL);
				TemporaryAnnotation annotation = new TemporaryAnnotation(position, annotationType, description,
						reconcileAnnotationKey) {

					// Supply an occurrence image to display in the vertical
					// ruler
					@Override
					public void paint(GC gc, Canvas canvas, Rectangle r) {
						ImageUtilities.drawImage(
								PHPUiPlugin.getImageDescriptorRegistry().get(PHPPluginImages.DESC_OBJS_OCCURRENCES), gc,
								canvas, r, SWT.CENTER, SWT.TOP);
					}

				};
				annotationMap.put(annotation, position);
			}

			if (isCanceled(progressMonitor))
				return Status.CANCEL_STATUS;

			synchronized (getLockObject(annotationModel)) {
				if (annotationModel instanceof IAnnotationModelExtension) {
					((IAnnotationModelExtension) annotationModel).replaceAnnotations(fOccurrenceAnnotations,
							annotationMap);
				} else {
					removeTwigOccurrenceAnnotations();
					for (Map.Entry<Annotation, Position> entry : annotationMap.entrySet()) {
						annotationModel.addAnnotation(entry.getKey(), entry.getValue());
					}
				}
				fOccurrenceAnnotations = annotationMap.keySet().toArray(new Annotation[annotationMap.keySet().size()]);
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

		IAnnotationModel annotationModel = documentProvider.getAnnotationModel(getEditorInput());
		if (annotationModel == null || fOccurrenceAnnotations == null)
			return;

		synchronized (getLockObject(annotationModel)) {
			if (annotationModel instanceof IAnnotationModelExtension) {
				((IAnnotationModelExtension) annotationModel).replaceAnnotations(fOccurrenceAnnotations, null);
			} else {
				for (int i = 0, length = fOccurrenceAnnotations.length; i < length; i++)
					annotationModel.removeAnnotation(fOccurrenceAnnotations[i]);
			}
			fOccurrenceAnnotations = null;
		}
	}

	protected void uninstallOccurrencesFinder() {
		// TODO Auto-generated method stub
		// super.uninstallOccurrencesFinder();

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

	protected void setSelection(ISourceReference reference, boolean moveCursor) {
		if (getSelectionProvider() == null)
			return;

		final ISelection[] selections = new ISelection[1];
		Display.getDefault().syncExec(new Runnable() {
			@Override
			public void run() {
				selections[0] = getSelectionProvider().getSelection();
			}
		});

		if (selections[0] == null) {
			return;
		}

		final ISelection selection = selections[0];
		if (selection instanceof TextSelection) {
			TextSelection textSelection = (TextSelection) selection;
			if (textSelection instanceof IStructuredSelection) {
				Object firstElement = ((IStructuredSelection) textSelection).getFirstElement();
				if (firstElement instanceof IImplForTwig) {
					// ((IImplForTwig) firstElement)
					// .setModelElement(getModelElement());
				}
			}
			// PR 39995: [navigation] Forward history cleared after going back
			// in navigation history:
			// mark only in navigation history if the cursor is being moved
			// (which it isn't if
			// this is called from a PostSelectionEvent that should only update
			// the magnet)
			if (moveCursor && (textSelection.getOffset() != 0 || textSelection.getLength() != 0))
				markInNavigationHistory();
		}
		if (reference != null) {
			StyledText textWidget = null;
			ISourceViewer sourceViewer = getSourceViewer();
			if (sourceViewer != null)
				textWidget = sourceViewer.getTextWidget();
			if (textWidget == null)
				return;
			try {
				ISourceRange range = null;
				range = reference.getSourceRange();
				if (range == null)
					return;
				int offset = range.getOffset();
				int length = range.getLength();
				if (offset < 0 || length < 0)
					return;
				setHighlightRange(offset, length, moveCursor);
				if (!moveCursor)
					return;
				offset = -1;
				length = -1;
				if (reference instanceof IMember) {
					range = ((IMember) reference).getNameRange();
					if (range != null) {
						offset = range.getOffset();
						length = range.getLength();
					}
				}
				if (offset > -1 && length > 0) {
					try {
						textWidget.setRedraw(false);
						sourceViewer.revealRange(offset, length);
						sourceViewer.setSelectedRange(offset, length);
					} finally {
						textWidget.setRedraw(true);
					}
					markInNavigationHistory();
				}
			} catch (ModelException x) {
			} catch (IllegalArgumentException x) {
			}
		} else if (moveCursor) {
			resetHighlightRange();
			markInNavigationHistory();
		}
	}

	@Override
	public void dispose() {
		if (fActionGroups != null) {
			fActionGroups.dispose();
			fActionGroups = null;
		}
		super.dispose();
	}

	public IDocument getDocument() {
		if (getSourceViewer() != null) {
			return getSourceViewer().getDocument();
		}
		return null;
	}

}
