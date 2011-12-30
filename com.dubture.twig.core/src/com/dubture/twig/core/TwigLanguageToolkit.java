/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.dltk.core.AbstractLanguageToolkit;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;

import com.dubture.twig.core.documentModel.provisional.contenttype.ContentTypeIdForTwig;

public class TwigLanguageToolkit extends AbstractLanguageToolkit
{

    private static TwigLanguageToolkit toolkit = new TwigLanguageToolkit();

    protected String getCorePluginID()
    {
        return TwigCorePlugin.PLUGIN_ID;
    }

    public String[] getLanguageFileExtensions()
    {

        IContentType type = Platform.getContentTypeManager().getContentType(
                ContentTypeIdForTwig.CONTENT_TYPE_ID_TWIG);

        return type.getFileSpecs(IContentType.FILE_EXTENSION_SPEC);
    }

    public String getLanguageName()
    {
        return "Twig";
    }

    public String getNatureId()
    {
        return TwigNature.NATURE_ID;
    }

    public String getLanguageContentType()
    {
        return ContentTypeIdForTwig.CONTENT_TYPE_ID_TWIG;
    }

    public static IDLTKLanguageToolkit getDefault()
    {
        return toolkit;
    }

}
