/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Zend Technologies
 *******************************************************************************/

package com.dubture.twig.ui.editor.adapter;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wst.html.ui.internal.contentoutline.JFaceNodeAdapterForHTML;
import org.eclipse.wst.sse.core.internal.provisional.INodeNotifier;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.sse.core.internal.provisional.text.ITextRegion;
import org.eclipse.wst.xml.ui.internal.contentoutline.JFaceNodeAdapterFactory;
import org.w3c.dom.Node;

import com.dubture.twig.core.documentModel.TwigDOMModelParser;
import com.dubture.twig.core.documentModel.dom.ElementImplForTwig;
import com.dubture.twig.core.documentModel.parser.regions.TwigScriptRegion;
import com.dubture.twig.core.log.Logger;
import com.dubture.twig.ui.TwigPluginImages;

/**
 * This class was created in order to call a different refresh job then the
 * super class
 * 
 * @author guy.g
 * 
 */
public class JFaceNodeAdapterForTwig extends JFaceNodeAdapterForHTML {

	JFaceNodeAdapterFactory fAdapterFactory;
	private RefreshStructureJob fRefreshJob = null;

	public JFaceNodeAdapterForTwig(JFaceNodeAdapterFactory adapterFactory) {
		super(adapterFactory);
		fAdapterFactory = adapterFactory;
	}

	private synchronized RefreshStructureJob getRefreshJob() {
		if (fRefreshJob == null)
			fRefreshJob = new RefreshStructureJob();
		return fRefreshJob;
	}

	@Override
	public void notifyChanged(INodeNotifier notifier, int eventType, Object changedFeature, Object oldValue,
			Object newValue, int pos) {

		if (notifier instanceof Node) {
			Collection listeners = fAdapterFactory.getListeners();
			Iterator iterator = listeners.iterator();

			while (iterator.hasNext()) {
				Object listener = iterator.next();
				if ((listener instanceof StructuredViewer) && (eventType == INodeNotifier.STRUCTURE_CHANGED
						|| eventType == INodeNotifier.CONTENT_CHANGED || (eventType == INodeNotifier.CHANGE))) {
					// refresh on structural and "unknown" changes
					StructuredViewer structuredViewer = (StructuredViewer) listener;

					if (structuredViewer.getControl() != null) {
						getRefreshJob().refresh(structuredViewer, (Node) notifier);
					}
				}
			}
		}
	}

	@Override
	public String getLabelText(Object node) {
		if (node instanceof ElementImplForTwig) {
			ElementImplForTwig element = (ElementImplForTwig) node;
			if (TwigDOMModelParser.TWIG_STMT_TAG.equals(element.getNodeName())) {
				IStructuredDocumentRegion flatNode = element.getFirstStructuredDocumentRegion();
				if (flatNode.getNumberOfRegions() > 1) {
					ITextRegion scriptRegion = flatNode.getRegions().get(1);
					if (scriptRegion instanceof TwigScriptRegion) {
						TwigScriptRegion twig = (TwigScriptRegion) scriptRegion;
						if (twig.getTokenCount() > 0) {
							try {
								return flatNode.getText(scriptRegion)
										.substring(twig.getTwigToken(0).getStart(), twig.getTwigToken(0).getEnd())
										.trim();
							} catch (BadLocationException e) {
								Logger.logException(e);
							}
						}
					}

				}
			}
			return element.getTagName();
		}

		return super.getLabelText(node);
	}

	@Override
	public Image getLabelImage(Object node) {
		if (node instanceof ElementImplForTwig) {
			ElementImplForTwig element = (ElementImplForTwig) node;
			if (TwigDOMModelParser.TWIG_STMT_TAG.equals(element.getNodeName())) {
				return TwigPluginImages.get(TwigPluginImages.IMG_OBJS_STATEMENT);
			} else if (TwigDOMModelParser.TWIG_PRINT_TAG.equals(element.getNodeName())) {
				return TwigPluginImages.get(TwigPluginImages.IMG_OBJS_PRINT);
			}
		}
		return super.getLabelImage(node);
	}
}
