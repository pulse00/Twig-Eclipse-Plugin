package org.eclipse.twig.ui.editor.configuration;

import java.util.ArrayList;
import java.util.Vector;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewerExtension2;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.MultiPassContentFormatter;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.php.internal.core.format.FormatPreferencesSupport;
import org.eclipse.php.internal.core.format.PhpFormatProcessorImpl;
import org.eclipse.php.internal.ui.PHPUiPlugin;
import org.eclipse.php.internal.ui.autoEdit.MainAutoEditStrategy;
import org.eclipse.php.internal.ui.doubleclick.PHPDoubleClickStrategy;
import org.eclipse.php.internal.ui.editor.PHPStructuredTextViewer;
import org.eclipse.php.internal.ui.editor.configuration.PHPStructuredTextViewerConfiguration;
import org.eclipse.php.internal.ui.editor.contentassist.PHPCompletionProcessor;
import org.eclipse.php.internal.ui.text.hover.PHPEditorTextHoverDescriptor;
import org.eclipse.php.internal.ui.util.ElementCreationProxy;
import org.eclipse.twig.core.documentModel.parser.partitioner.TwigPartitionTypes;
import org.eclipse.twig.ui.editor.LineStyleProviderForTwig;
import org.eclipse.twig.ui.editor.autoEdit.CloseTagAutoEditStrategyTwig;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.wst.html.core.text.IHTMLPartitions;
import org.eclipse.wst.sse.ui.internal.contentassist.StructuredContentAssistant;
import org.eclipse.wst.sse.ui.internal.format.StructuredFormattingStrategy;
import org.eclipse.wst.sse.ui.internal.provisional.style.LineStyleProvider;


/**
 * 
 * Also copy/pasted from smarty.
 * 
 * TODO: review code and check if it can be cleaned up
 * for the twig plugin.
 * 
 * 
 * @see http://code.google.com/p/smartypdt/
 *
 */
@SuppressWarnings("restriction")
public class TwigStructuredTextViewerConfiguration extends PHPStructuredTextViewerConfiguration {

	private LineStyleProvider fLineStyleProvider;
	private IPropertyChangeListener propertyChangeListener;

	public TwigStructuredTextViewerConfiguration() {
		
		
	}
	
	
	

	/*
	 * Returns an array of all the contentTypes (partition names) supported
	 * by this editor. They include all those supported by HTML editor plus
	 * PHP.
	 */
	@Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		final String[] original = super.getConfiguredContentTypes(sourceViewer);
		final String[] configuredPartitions = TwigPartitionTypes.configuredPartitions;

		String[] result = new String[original.length + configuredPartitions.length];
		System.arraycopy(original, 0, result, 0, original.length);
		System.arraycopy(configuredPartitions, 0, result, original.length, configuredPartitions.length);

		return result;
	}

	public LineStyleProvider getLineStyleProvider() {
		if (fLineStyleProvider == null) {
			fLineStyleProvider = new LineStyleProviderForTwig();
		}
		return fLineStyleProvider;
	}

	@Override
	public LineStyleProvider[] getLineStyleProviders(ISourceViewer sourceViewer, String partitionType) {
		if (TwigPartitionTypes.isTwigPartition(partitionType)) {
			return new LineStyleProvider[] { getLineStyleProvider() };
		}
		return super.getLineStyleProviders(sourceViewer, partitionType);
	}

	@Override
	public IContentAssistProcessor[] getContentAssistProcessors(ISourceViewer sourceViewer, String partitionType) {
		IContentAssistProcessor[] processors = null;

		
//		System.err.println("get content assist processosr for " + partitionType);
		
		if (partitionType.equals(TwigPartitionTypes.TWIG_DEFAULT) /*||
				partitionType.equals(IHTMLPartitions.HTML_DEFAULT)*/) {
			ArrayList processorsList = getPHPDefaultProcessors(sourceViewer);
			processors = new IContentAssistProcessor[processorsList.size()];
			processorsList.toArray(processors);
			
//			System.err.println("#### is twig partition type #####");
			
		}else if(partitionType.equals(IHTMLPartitions.HTML_DEFAULT)){
			ArrayList processorsList = getPHPDefaultProcessors(sourceViewer);
			IContentAssistProcessor[] twigProcessors = new IContentAssistProcessor[processorsList.size()];
			processorsList.toArray(twigProcessors);
			IContentAssistProcessor[] phpProcessors = super.getContentAssistProcessors(sourceViewer, partitionType);
			processors = new IContentAssistProcessor[twigProcessors.length + phpProcessors.length]; 
			System.arraycopy(twigProcessors, 0, processors, 0, twigProcessors.length);
			System.arraycopy(phpProcessors, 0, processors, twigProcessors.length, phpProcessors.length);
		}else {
			processors = super.getContentAssistProcessors(sourceViewer, partitionType);
		}
		return processors;

	}

	private ArrayList processors = null;

	private ArrayList getPHPDefaultProcessors(ISourceViewer sourceViewer) {
		if (processors != null) {
			return processors;
		}
		processors = new ArrayList();
		ITextEditor textEditor = ((PHPStructuredTextViewer)sourceViewer).getTextEditor();
		processors.add(new PHPCompletionProcessor(textEditor, (ContentAssistant) getPHPContentAssistant(sourceViewer), TwigPartitionTypes.TWIG_DEFAULT));
		String processorsExtensionName = "org.eclipse.php.ui.phpContentAssistProcessor"; //$NON-NLS-1$

		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(processorsExtensionName);
		for (int i = 0; i < elements.length; i++) {
			IConfigurationElement element = elements[i];
			if (element.getName().equals("processor")) { //$NON-NLS-1$
				ElementCreationProxy ecProxy = new ElementCreationProxy(element, processorsExtensionName);
				IContentAssistProcessor processor = (IContentAssistProcessor) ecProxy.getObject();
				if (processor != null) {
					processors.add(processor);
				}
			}
		}

		return processors;
	}

	private StructuredContentAssistant fContentAssistant = null;

	public IContentAssistant getPHPContentAssistant(ISourceViewer sourceViewer) {
		return getPHPContentAssistant(sourceViewer, false);
	}

	private StructuredContentAssistant getPHPContentAssistantExtension() {
		StructuredContentAssistant rv = null;
		String extensionName = "org.eclipse.php.ui.phpContentAssistant"; //$NON-NLS-1$
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionName);
		for (int i = 0; i < elements.length; i++) {
			IConfigurationElement element = elements[i];
			if (element.getName().equals("contentAssistant")) { //$NON-NLS-1$
				ElementCreationProxy ecProxy = new ElementCreationProxy(element, extensionName);
				StructuredContentAssistant contentAssistant = (StructuredContentAssistant) ecProxy.getObject();
				if (contentAssistant != null) {
					rv = contentAssistant;
				}
			}
		}
		return rv;
	}

	@Override
	public String[] getDefaultPrefixes(ISourceViewer sourceViewer, String contentType) {
		return new String[] { "//", "#", "" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/*
	 * @see SourceViewerConfiguration#getConfiguredTextHoverStateMasks(ISourceViewer, String)
	 */
	@Override
	public int[] getConfiguredTextHoverStateMasks(ISourceViewer sourceViewer, String contentType) {
		PHPEditorTextHoverDescriptor[] hoverDescs = PHPUiPlugin.getDefault().getPHPEditorTextHoverDescriptors();
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
		System.arraycopy(stateMasks, 0, shortenedStateMasks, 0, stateMasksLength);
		return shortenedStateMasks;
	}


	/*
	 * @see SourceViewerConfiguration#getTextHover(ISourceViewer, String)
	 */
	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		return getTextHover(sourceViewer, contentType, ITextViewerExtension2.DEFAULT_HOVER_STATE_MASK);
	}



	@Override
	public IContentFormatter getContentFormatter(ISourceViewer sourceViewer) {
		IContentFormatter usedFormatter = null;

		String formatterExtensionName = "org.eclipse.php.ui.phpFormatterProcessor"; //$NON-NLS-1$
		IConfigurationElement[] elements = Platform.getExtensionRegistry().getConfigurationElementsFor(formatterExtensionName);
		for (int i = 0; i < elements.length; i++) {
			IConfigurationElement element = elements[i];
			if (element.getName().equals("processor")) { //$NON-NLS-1$
				ElementCreationProxy ecProxy = new ElementCreationProxy(element, formatterExtensionName);
				usedFormatter = (IContentFormatter) ecProxy.getObject();
			}
		}

		if (usedFormatter == null) {
			usedFormatter = new MultiPassContentFormatter(getConfiguredDocumentPartitioning(sourceViewer), IHTMLPartitions.HTML_DEFAULT);
			((MultiPassContentFormatter) usedFormatter).setMasterStrategy(new StructuredFormattingStrategy(new PhpFormatProcessorImpl()));
		}

		return usedFormatter;
	}

	private static final IAutoEditStrategy mainAutoEditStrategy = new MainAutoEditStrategy();
	private static final IAutoEditStrategy closeTagAutoEditStrategy = new CloseTagAutoEditStrategyTwig();
	private static final IAutoEditStrategy[] phpStrategies = new IAutoEditStrategy[] { mainAutoEditStrategy };

	@Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		if (contentType.equals(TwigPartitionTypes.TWIG_DEFAULT)) {
			return phpStrategies;
		}

		return getPhpAutoEditStrategy(sourceViewer, contentType);
	}

	private final IAutoEditStrategy[] getPhpAutoEditStrategy(ISourceViewer sourceViewer, String contentType) {
		final IAutoEditStrategy[] autoEditStrategies = super.getAutoEditStrategies(sourceViewer, contentType);
		final int length = autoEditStrategies.length;
		final IAutoEditStrategy[] augAutoEditStrategies = new IAutoEditStrategy[length + 1];
		System.arraycopy(autoEditStrategies, 0, augAutoEditStrategies, 0, length);
		augAutoEditStrategies[length] = closeTagAutoEditStrategy;
		
		
		System.err.println("get auto edit strategy from configuration");

		return augAutoEditStrategies;
	}

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, String contentType) {
		if (contentType == TwigPartitionTypes.TWIG_DEFAULT) {
			// use php's doubleclick strategy
			return new PHPDoubleClickStrategy();
		} else
			return super.getDoubleClickStrategy(sourceViewer, contentType);
	}

	@Override
	public String[] getIndentPrefixes(ISourceViewer sourceViewer, String contentType) {
		Vector vector = new Vector();

		// prefix[0] is either '\t' or ' ' x tabWidth, depending on preference
		char indentCharPref = FormatPreferencesSupport.getInstance().getIndentationChar(null);
		int indentationSize = FormatPreferencesSupport.getInstance().getIndentationSize(null);

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

}
