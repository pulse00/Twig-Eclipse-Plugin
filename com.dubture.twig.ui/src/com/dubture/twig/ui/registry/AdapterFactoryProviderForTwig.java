/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Dawid Pakuła <zulus@w3des.net>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.ui.registry;

import org.eclipse.wst.html.ui.internal.registry.AdapterFactoryProviderForHTML;
import org.eclipse.wst.sse.core.internal.ltk.modelhandler.IDocumentTypeHandler;

import com.dubture.twig.core.documentModel.handler.TwigModelHandler;

public class AdapterFactoryProviderForTwig extends AdapterFactoryProviderForHTML {

	public boolean isFor(IDocumentTypeHandler contentTypeDescription) {
		return (contentTypeDescription instanceof TwigModelHandler);
	}
}
