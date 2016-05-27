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

import org.eclipse.wst.sse.core.internal.PropagatingAdapter;
import org.eclipse.wst.sse.core.internal.ltk.modelhandler.IDocumentTypeHandler;
import org.eclipse.wst.sse.core.internal.model.FactoryRegistry;
import org.eclipse.wst.sse.core.internal.provisional.INodeAdapterFactory;
import org.eclipse.wst.sse.core.internal.provisional.IStructuredModel;
import org.eclipse.wst.sse.ui.internal.contentoutline.IJFaceNodeAdapter;
import org.eclipse.wst.sse.ui.internal.provisional.registry.AdapterFactoryProvider;
import org.eclipse.wst.sse.ui.internal.util.Assert;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMDocument;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMModel;

import com.dubture.twig.core.documentModel.handler.TwigModelHandler;

public class AdapterFactoryProviderForTwig implements AdapterFactoryProvider {

	/*
	 * @see AdapterFactoryProvider#addAdapterFactories(IStructuredModel)
	 */
	@Override
	public void addAdapterFactories(IStructuredModel structuredModel) {
		// these are the main factories, on model's factory registry
		addContentBasedFactories(structuredModel);
		// -------
		// Must update/add to propagating adapters here too
		addPropagatingAdapters(structuredModel);
	}

	protected void addContentBasedFactories(IStructuredModel structuredModel) {
		FactoryRegistry factoryRegistry = structuredModel.getFactoryRegistry();
		Assert.isNotNull(factoryRegistry, "Program Error: client caller must ensure model has factory registry"); //$NON-NLS-1$
		INodeAdapterFactory factory = null;
		factory = factoryRegistry.getFactoryFor(IJFaceNodeAdapter.class);
		if (factory == null) {
			factory = new JFaceNodeAdapterFactoryForTwig(IJFaceNodeAdapter.class, true);
			factoryRegistry.addFactory(factory);
		}
	}

	protected void addPropagatingAdapters(IStructuredModel structuredModel) {

		if (structuredModel instanceof IDOMModel) {
			IDOMModel xmlModel = (IDOMModel) structuredModel;
			IDOMDocument document = xmlModel.getDocument();
			PropagatingAdapter propagatingAdapter = (PropagatingAdapter) document
					.getAdapterFor(PropagatingAdapter.class);
			if (propagatingAdapter != null) {
				// what to do?
			}
		}
	}

	/*
	 * @see AdapterFactoryProvider#isFor(ContentTypeDescription)
	 */
	@Override
	public boolean isFor(IDocumentTypeHandler contentTypeDescription) {
		return (contentTypeDescription instanceof TwigModelHandler);
	}

	@Override
	public void reinitializeFactories(IStructuredModel structuredModel) {
	}
}
