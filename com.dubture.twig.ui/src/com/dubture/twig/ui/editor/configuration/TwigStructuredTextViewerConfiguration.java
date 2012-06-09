/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.editor.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.internal.ui.text.ScriptWordFinder;
import org.eclipse.dltk.ui.viewsupport.ISelectionListenerWithAST;
import org.eclipse.dltk.ui.viewsupport.SelectionListenerWithASTManager;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISelectionValidator;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension2;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.ImageUtilities;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.php.internal.core.documentModel.partitioner.PHPPartitionTypes;
import org.eclipse.php.internal.ui.PHPUiPlugin;
import org.eclipse.php.internal.ui.doubleclick.PHPDoubleClickStrategy;
import org.eclipse.php.internal.ui.editor.PHPStructuredTextViewer;
import org.eclipse.php.internal.ui.editor.configuration.PHPStructuredTextViewerConfiguration;
import org.eclipse.php.internal.ui.editor.configuration.StructuredDocumentDamagerRepairer;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProcessor;
import org.eclipse.php.internal.ui.editor.hover.PHPTextHoverProxy;
import org.eclipse.php.internal.ui.text.hover.PHPEditorTextHoverDescriptor;
import org.eclipse.php.internal.ui.util.ElementCreationProxy;
import org.eclipse.php.internal.ui.util.PHPPluginImages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.wst.html.core.text.IHTMLPartitions;
import org.eclipse.wst.sse.ui.internal.StructuredTextViewer;
import org.eclipse.wst.sse.ui.internal.provisional.style.LineStyleProvider;
import org.eclipse.wst.sse.ui.internal.provisional.style.ReconcilerHighlighter;
import org.eclipse.wst.sse.ui.internal.provisional.style.StructuredPresentationReconciler;
import org.eclipse.wst.sse.ui.internal.reconcile.ReconcileAnnotationKey;
import org.eclipse.wst.sse.ui.internal.reconcile.TemporaryAnnotation;

import com.dubture.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import com.dubture.twig.core.format.FormatPreferencesSupport;
import com.dubture.twig.core.parser.ast.node.TwigModuleDeclaration;
import com.dubture.twig.core.search.IOccurrencesFinder;
import com.dubture.twig.core.search.IOccurrencesFinder.OccurrenceLocation;
import com.dubture.twig.core.search.CallFinder;
import com.dubture.twig.core.search.NodeFinder;
import com.dubture.twig.core.search.StringFinder;
import com.dubture.twig.core.search.VariableFinder;
import com.dubture.twig.ui.editor.LineStyleProviderForTwig;
import com.dubture.twig.ui.editor.autoEdit.CloseTagAutoEditStrategyTwig;
import com.dubture.twig.ui.editor.autoEdit.IndentLineAutoEditStrategy;
import com.dubture.twig.ui.editor.autoEdit.MainAutoEditStrategy;

/**
 *
 * A modified {@link PHPStructuredTextViewerConfiguration} for Twig templates.
 *
 * @author "Robert Gruendler <r.gruendler@gmail.com>"
 *
 */
@SuppressWarnings({"restriction", "unchecked", "rawtypes"})
public class TwigStructuredTextViewerConfiguration extends
        PHPStructuredTextViewerConfiguration
{

    private LineStyleProvider fLineStyleProvider;

    private static final IAutoEditStrategy indentLineAutoEditStrategy = new IndentLineAutoEditStrategy();
    private static final IAutoEditStrategy mainAutoEditStrategy = new MainAutoEditStrategy();
    private static final IAutoEditStrategy closeTagAutoEditStrategy = new CloseTagAutoEditStrategyTwig();
    private static final IAutoEditStrategy[] phpStrategies = new IAutoEditStrategy[]{mainAutoEditStrategy};

    private ReconcilerHighlighter fHighlighter = null;

    private OccurrencesFinderJob fOccurrencesFinderJob;

    private Annotation[] fOccurrenceAnnotations = null;

    private long fMarkOccurrenceModificationStamp = IDocumentExtension4.UNKNOWN_MODIFICATION_STAMP;

    private IRegion fMarkOccurrenceTargetRegion;

    private boolean fMarkOccurrenceAnnotations;

    private ISelection fForcedMarkOccurrencesSelection;

    public TwigStructuredTextViewerConfiguration()
    {

        fMarkOccurrenceAnnotations = true;

    }

    /*
     * Returns an array of all the contentTypes (partition names) supported by
     * this editor. They include all those supported by HTML editor plus Twig.
     */
    @Override
    public String[] getConfiguredContentTypes(ISourceViewer sourceViewer)
    {

        final String[] original = super.getConfiguredContentTypes(sourceViewer);
        final String[] configuredPartitions = TwigPartitionTypes.configuredPartitions;

        String[] result = new String[original.length
                + configuredPartitions.length];
        System.arraycopy(original, 0, result, 0, original.length);
        System.arraycopy(configuredPartitions, 0, result, original.length,
                configuredPartitions.length);

        return result;
    }

    public LineStyleProvider getLineStyleProvider()
    {
        if (fLineStyleProvider == null) {
            fLineStyleProvider = new LineStyleProviderForTwig();
        }
        return fLineStyleProvider;
    }

    @Override
    public LineStyleProvider[] getLineStyleProviders(
            ISourceViewer sourceViewer, String partitionType)
    {
        if (TwigPartitionTypes.isTwigPartition(partitionType)) {
            return new LineStyleProvider[]{getLineStyleProvider()};
        }
        return super.getLineStyleProviders(sourceViewer, partitionType);
    }

    @Override
    public IContentAssistProcessor[] getContentAssistProcessors(
            ISourceViewer sourceViewer, String partitionType)
    {
        IContentAssistProcessor[] processors = null;

        if (partitionType.equals(TwigPartitionTypes.TWIG_DEFAULT) /*
                                                                   * ||
                                                                   * partitionType
                                                                   * .equals(
                                                                   * IHTMLPartitions
                                                                   * .
                                                                   * HTML_DEFAULT
                                                                   * )
                                                                   */) {
            ArrayList processorsList = getTwigDefaultProcessors(sourceViewer);
            processors = new IContentAssistProcessor[processorsList.size()];
            processorsList.toArray(processors);

        } else if (partitionType.equals(IHTMLPartitions.HTML_DEFAULT)) {
            ArrayList processorsList = getTwigDefaultProcessors(sourceViewer);
            IContentAssistProcessor[] twigProcessors = new IContentAssistProcessor[processorsList
                    .size()];
            processorsList.toArray(twigProcessors);
            IContentAssistProcessor[] phpProcessors = super
                    .getContentAssistProcessors(sourceViewer, partitionType);
            processors = new IContentAssistProcessor[twigProcessors.length
                    + phpProcessors.length];
            System.arraycopy(twigProcessors, 0, processors, 0,
                    twigProcessors.length);
            System.arraycopy(phpProcessors, 0, processors,
                    twigProcessors.length, phpProcessors.length);
        } else {
            processors = super.getContentAssistProcessors(sourceViewer,
                    partitionType);
        }
        return processors;

    }

    private ArrayList processors = null;

    private ISourceViewer sourceViewer;

    private ArrayList getTwigDefaultProcessors(ISourceViewer sourceViewer)
    {
        if (processors != null) {
            return processors;
        }
        processors = new ArrayList();
        ITextEditor textEditor = ((PHPStructuredTextViewer) sourceViewer)
                .getTextEditor();
        processors.add(new PHPCompletionProcessor(textEditor,
                (ContentAssistant) getPHPContentAssistant(sourceViewer),
                TwigPartitionTypes.TWIG_DEFAULT));
        String processorsExtensionName = "org.eclipse.php.ui.phpContentAssistProcessor"; //$NON-NLS-1$

        IConfigurationElement[] elements = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(processorsExtensionName);
        for (int i = 0; i < elements.length; i++) {
            IConfigurationElement element = elements[i];
            if (element.getName().equals("processor")) { //$NON-NLS-1$
                ElementCreationProxy ecProxy = new ElementCreationProxy(
                        element, processorsExtensionName);
                IContentAssistProcessor processor = (IContentAssistProcessor) ecProxy
                        .getObject();
                if (processor != null) {
                    processors.add(processor);
                }
            }
        }

        return processors;
    }

    public IContentAssistant getPHPContentAssistant(ISourceViewer sourceViewer)
    {
        return getPHPContentAssistant(sourceViewer, false);
    }

    @Override
    public String[] getDefaultPrefixes(ISourceViewer sourceViewer,
            String contentType)
    {
        return new String[]{"//", "#", ""}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

    /*
     * @see
     * SourceViewerConfiguration#getConfiguredTextHoverStateMasks(ISourceViewer,
     * String)
     */
    @Override
    public int[] getConfiguredTextHoverStateMasks(ISourceViewer sourceViewer,
            String contentType)
    {
        PHPEditorTextHoverDescriptor[] hoverDescs = PHPUiPlugin.getDefault()
                .getPHPEditorTextHoverDescriptors();
        int stateMasks[] = new int[hoverDescs.length];
        int stateMasksLength = 0;
        for (int i = 0; i < hoverDescs.length; i++) {
            if (hoverDescs[i].isEnabled()) {
                int j = 0;
                int stateMask = hoverDescs[i].getStateMask();
                while (j < stateMasksLength) {
                    if (stateMasks[j] == stateMask)
                        break;
                    j++;
                }
                if (j == stateMasksLength)
                    stateMasks[stateMasksLength++] = stateMask;
            }
        }
        if (stateMasksLength == hoverDescs.length)
            return stateMasks;

        int[] shortenedStateMasks = new int[stateMasksLength];
        System.arraycopy(stateMasks, 0, shortenedStateMasks, 0,
                stateMasksLength);
        return shortenedStateMasks;
    }

    public ITextHover getTextHover(ISourceViewer sourceViewer,
            String contentType)
    {

        return getTextHover(sourceViewer, contentType,
                ITextViewerExtension2.DEFAULT_HOVER_STATE_MASK);
    }

    /*
     * @see SourceViewerConfiguration#getTextHover(ISourceViewer, String)
     */
    @Override
    public ITextHover getTextHover(ISourceViewer sourceViewer,
            String contentType, int stateMask)
    {

        if (!TwigPartitionTypes.isTwigPartition(contentType)) {
            return super.getTextHover(sourceViewer, contentType, stateMask);
        }

        if (sourceViewer instanceof PHPStructuredTextViewer) {
            PHPEditorTextHoverDescriptor[] hoverDescs = PHPUiPlugin
                    .getDefault().getPHPEditorTextHoverDescriptors();
            int i = 0;
            while (i < hoverDescs.length) {

                if (hoverDescs[i].isEnabled()
                        && hoverDescs[i].getStateMask() == stateMask) {

                    return new PHPTextHoverProxy(hoverDescs[i],
                            ((PHPStructuredTextViewer) sourceViewer)
                                    .getTextEditor(), fPreferenceStore);
                }
                i++;
            }
        }
        return null;

    }

    /*
     * @Override public IContentFormatter getContentFormatter(ISourceViewer
     * sourceViewer) { IContentFormatter usedFormatter = null;
     *
     * // System.err.println("get formatter"); // String formatterExtensionName
     * = "org.eclipse.php.ui.phpFormatterProcessor"; //$NON-NLS-1$ //
     * IConfigurationElement[] elements =
     * Platform.getExtensionRegistry().getConfigurationElementsFor
     * (formatterExtensionName); // for (int i = 0; i < elements.length; i++) {
     * // IConfigurationElement element = elements[i]; // if
     * (element.getName().equals("processor")) { //$NON-NLS-1$ //
     * ElementCreationProxy ecProxy = new ElementCreationProxy(element,
     * formatterExtensionName); // usedFormatter = (IContentFormatter)
     * ecProxy.getObject(); // } // } // // if (usedFormatter == null) { //
     * usedFormatter = new
     * MultiPassContentFormatter(getConfiguredDocumentPartitioning
     * (sourceViewer), IHTMLPartitions.HTML_DEFAULT); //
     * ((MultiPassContentFormatter) usedFormatter).setMasterStrategy(new
     * StructuredFormattingStrategy(new TwigFormatProcessorImpl())); // }
     *
     *
     * TwigContentFormatter formatter = new TwigContentFormatter(); return
     * formatter;
     *
     * }
     */

    @Override
    public IAutoEditStrategy[] getAutoEditStrategies(
            ISourceViewer sourceViewer, String contentType)
    {

        if (contentType.equals(TwigPartitionTypes.TWIG_DEFAULT)) {
            return phpStrategies;
        }

        return getTwigAutoEditStrategy(sourceViewer, contentType);
    }

    private final IAutoEditStrategy[] getTwigAutoEditStrategy(
            ISourceViewer sourceViewer, String contentType)
    {

        final IAutoEditStrategy[] autoEditStrategies = super
                .getAutoEditStrategies(sourceViewer, contentType);

        for (int i = 0; i < autoEditStrategies.length; i++) {
            if (autoEditStrategies[i] instanceof org.eclipse.php.internal.ui.autoEdit.IndentLineAutoEditStrategy) {
                autoEditStrategies[i] = indentLineAutoEditStrategy;
            }
        }

        final int length = autoEditStrategies.length;
        final IAutoEditStrategy[] newAutoEditStrategies = new IAutoEditStrategy[length + 1];
        System.arraycopy(autoEditStrategies, 0, newAutoEditStrategies, 0,
                length);
        newAutoEditStrategies[length] = closeTagAutoEditStrategy;

        return newAutoEditStrategies;
    }

    @Override
    public ITextDoubleClickStrategy getDoubleClickStrategy(
            ISourceViewer sourceViewer, String contentType)
    {
        if (contentType == TwigPartitionTypes.TWIG_DEFAULT) {
            // use php's doubleclick strategy
            return new PHPDoubleClickStrategy();
        } else
            return super.getDoubleClickStrategy(sourceViewer, contentType);
    }

    @Override
    public String[] getIndentPrefixes(ISourceViewer sourceViewer,
            String contentType)
    {
        Vector vector = new Vector();

        // prefix[0] is either '\t' or ' ' x tabWidth, depending on preference
        char indentCharPref = FormatPreferencesSupport.getInstance()
                .getIndentationChar(sourceViewer.getDocument());
        int indentationSize = FormatPreferencesSupport.getInstance()
                .getIndentationSize(sourceViewer.getDocument());

        for (int i = 0; i <= indentationSize; i++) {
            StringBuffer prefix = new StringBuffer();
            boolean appendTab = false;

            for (int j = 0; j + i < indentationSize; j++)
                prefix.append(indentCharPref);

            if (i != 0) {
                appendTab = true;
            }

            if (appendTab) {
                prefix.append('\t');
                vector.add(prefix.toString());
                // remove the tab so that indentation - tab is also an indent
                // prefix
                prefix.deleteCharAt(prefix.length() - 1);
            }
            vector.add(prefix.toString());
        }

        vector.add(""); //$NON-NLS-1$

        return (String[]) vector.toArray(new String[vector.size()]);
    }

    @Override
    public IPresentationReconciler getPresentationReconciler(
            ISourceViewer sourceViewer)
    {
        this.sourceViewer = sourceViewer;
        StructuredPresentationReconciler reconciler = new TwigStructuredPresentationReconciler();
        reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
        String[] contentTypes = getConfiguredContentTypes(sourceViewer);
        ITextEditor textEditor = ((PHPStructuredTextViewer) sourceViewer).getTextEditor();


        SelectionListenerWithASTManager.getDefault().addListener(textEditor, new ISelectionListenerWithAST()
        {

            @Override
            public void selectionChanged(IEditorPart part, ITextSelection selection,
                    ISourceModule module, IModuleDeclaration astRoot)
            {
                updateOccurrenceAnnotations(selection, (TwigModuleDeclaration) astRoot);
            }
        });



        if (contentTypes != null) {
            StructuredDocumentDamagerRepairer dr = null;

            for (int i = 0; i < contentTypes.length; i++) {
                if (fHighlighter != null) {
                    LineStyleProvider provider = fHighlighter
                            .getProvider(contentTypes[i]);
                    if (provider == null)
                        continue;

                    dr = new StructuredDocumentDamagerRepairer(provider);
                    dr.setDocument(sourceViewer.getDocument());
                    reconciler.setDamager(dr, contentTypes[i]);
                    reconciler.setRepairer(dr, contentTypes[i]);
                }
            }
        }

        return reconciler;
    }

    public void setHighlighter(ReconcilerHighlighter highlighter)
    {
        fHighlighter = highlighter;
        super.setHighlighter(highlighter);
    }

    public StructuredTextViewer getTextViewer() {

        return (PHPStructuredTextViewer) sourceViewer;
    }


    protected void updateOccurrenceAnnotations(ITextSelection selection, TwigModuleDeclaration astRoot) {


        if (fOccurrencesFinderJob != null)
            fOccurrencesFinderJob.cancel();

        if (!fMarkOccurrenceAnnotations)
            return;

        if (astRoot == null || selection == null || sourceViewer == null)
            return;

        IDocument document = sourceViewer.getDocument();

        if (document == null)
            return;

        if (document.getLength() != astRoot.sourceEnd()) {
            return;
        }

        boolean hasChanged = false;
        if (document instanceof IDocumentExtension4) {
            int offset = selection.getOffset();
            long currentModificationStamp = ((IDocumentExtension4) document)
                    .getModificationStamp();
            IRegion markOccurrenceTargetRegion = fMarkOccurrenceTargetRegion;
            hasChanged = currentModificationStamp != fMarkOccurrenceModificationStamp;
            if (markOccurrenceTargetRegion != null && !hasChanged) {
                if (markOccurrenceTargetRegion.getOffset() <= offset
                        && offset <= markOccurrenceTargetRegion.getOffset()
                                + markOccurrenceTargetRegion.getLength())
                    return;
            }
            fMarkOccurrenceTargetRegion = ScriptWordFinder.findWord(document,
                    offset);
            fMarkOccurrenceModificationStamp = currentModificationStamp;
        }

        OccurrenceLocation[] locations = null;

        ASTNode selectedNode = NodeFinder.perform(astRoot,
                selection.getOffset(), selection.getLength());

        if (locations == null) {
            IOccurrencesFinder finder = new VariableFinder();
            if (finder.initialize(astRoot, selectedNode) == null) {
                locations = finder.getOccurrences();
            }
        }

        if (locations == null || locations.length == 0) {
            IOccurrencesFinder finder = new CallFinder();
            if (finder.initialize(astRoot, selectedNode) == null) {
                locations = finder.getOccurrences();
            }
        }

        if (locations == null || locations.length == 0) {
            IOccurrencesFinder finder = new StringFinder();
            if (finder.initialize(astRoot, selectedNode) == null) {
                locations = finder.getOccurrences();
            }
        }

        if (locations == null) {
            return;
        }


        fOccurrencesFinderJob = new OccurrencesFinderJob(document, locations,
                selection);
        // fOccurrencesFinderJob.setPriority(Job.DECORATE);
        // fOccurrencesFinderJob.setSystem(true);
        // fOccurrencesFinderJob.schedule();
        fOccurrencesFinderJob.run(new NullProgressMonitor());

    }

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

//            if (getSelectionProvider() instanceof ISelectionValidator)
//                fPostSelectionValidator = (ISelectionValidator) getSelectionProvider();
//            else
//                fPostSelectionValidator = null;
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

            IAnnotationModel annotationModel = getTextViewer().getAnnotationModel();
            if (annotationModel == null)
                return Status.CANCEL_STATUS;

            if (fLocations ==  null) {
                return Status.CANCEL_STATUS;
            }
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
                    removeOccurrenceAnnotations();
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

    void removeOccurrenceAnnotations() {
        fMarkOccurrenceModificationStamp = IDocumentExtension4.UNKNOWN_MODIFICATION_STAMP;
        fMarkOccurrenceTargetRegion = null;

        IAnnotationModel annotationModel = getTextViewer().getAnnotationModel();
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
}
