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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdapterFactory;

import com.dubture.twig.core.documentModel.dom.IImplForTwig;

/**
 * This adapter factory class is used to create a GenericActionFilter when
 * performing a right-click within the editor
 * 
 * @author yaronm
 */
public class TwigElementAdapterFactory implements IAdapterFactory {

	private static Map<Class<?>, Object> adapterType2Object = new HashMap<Class<?>, Object>(4);

	static {
		// adapterType2Object.put(IActionFilter.class, new
		// GenericActionFilter());
	}

	public TwigElementAdapterFactory() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		if (adaptableObject instanceof IImplForTwig) {

		}
		return (T) adapterType2Object.get(adapterType);
	}

	@Override
	public Class<?>[] getAdapterList() {
		Class<?>[] classArray = new Class[adapterType2Object.size()];
		adapterType2Object.entrySet().toArray(classArray);
		return classArray;
	}
}
