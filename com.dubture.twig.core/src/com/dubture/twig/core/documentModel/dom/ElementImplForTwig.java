/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 * 
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.documentModel.dom;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.dltk.core.IModelElement;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.php.internal.core.documentModel.dom.NullValidator;
import org.eclipse.wst.html.core.internal.document.ElementStyleImpl;
import org.eclipse.wst.sse.core.internal.provisional.INodeAdapter;
import org.eclipse.wst.sse.core.internal.validate.ValidationAdapter;
import org.eclipse.wst.xml.core.internal.document.ElementImpl;
import org.eclipse.wst.xml.core.internal.validate.ValidationComponent;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.dubture.twig.core.documentModel.TwigDOMModelParser;
import com.dubture.twig.core.documentModel.parser.TwigRegionContext;
import com.dubture.twig.core.model.TwigModelAccess;

/**
 * 
 * 
 * 
 * @author Robert Gruendler <r.gruendler@gmail.com>
 * 
 */
@SuppressWarnings("restriction")
public class ElementImplForTwig extends ElementStyleImpl implements IAdaptable,
        IImplForTwig
{

    private static final String WORKBENCH_ADAPTER = "org.eclipse.ui.model.IWorkbenchAdapter";
    private IModelElement modelElement;
    private TwigModelAccess model = TwigModelAccess.getDefault();

    public ElementImplForTwig()
    {
        super();
    }

    @SuppressWarnings("rawtypes")
    public Object getAdapter(Class adapter)
    {
        if (adapter != null && adapter.getName().equals(WORKBENCH_ADAPTER)) {
            return null;
        }
        return Platform.getAdapterManager().getAdapter(this, adapter);
    }

    public ElementImplForTwig(ElementStyleImpl that)
    {
        super(that);
    }

    protected boolean isNestedClosed(String regionType)
    {
        return regionType == TwigRegionContext.TWIG_STMT_CLOSE;
    }

    public Node cloneNode(boolean deep)
    {
        ElementImpl cloned = new ElementImplForTwig(this);
        if (deep)
            cloneChildNodes(cloned, deep);
        return cloned;
    }

    /**
     * @see ElementStyleImpl#setOwnerDocument(Document) make this method package
     *      visible
     */
    protected void setOwnerDocument(Document ownerDocument)
    {
        super.setOwnerDocument(ownerDocument);
    }

    /**
     * @see setTagName(String) make this method package visible
     */
    protected void setTagName(String tagName)
    {
        super.setTagName(tagName);
    }

    public boolean isGlobalTag()
    {
        return isTwigTag() ? false : super.isGlobalTag();
    }

    /**
     * @return true if it is a twig element
     */
    public boolean isTwigTag()
    {

        boolean isTag = TwigDOMModelParser.TWIG_STMT_TAG.equals(getNodeName())
                || TwigDOMModelParser.TWIG_PRINT_TAG.equals(getNodeName());

        if (isTag)
            return true;

        IScriptProject project = modelElement != null ? modelElement
                .getScriptProject() : null;

        if (project == null) {
            return false;
        }

        return model.isTwigTag(project, getNodeName());

    }

    @SuppressWarnings("rawtypes")
    public INodeAdapter getExistingAdapter(Object type)
    {

        // no validation or validation propagation for PHP tags
        if (isTwigTag() && type instanceof Class
                && ValidationAdapter.class.isAssignableFrom((Class) type)) {
            return nullValidator;
        }
        return super.getExistingAdapter(type);
    }

    private final static ValidationComponent nullValidator = new NullValidator();

    public String getPrefix()
    {
        final String prefix = super.getPrefix();
        if (prefix == null && isTwigTag()) {
            return ""; //$NON-NLS-1$
        }
        return prefix;
    }

    public IModelElement getModelElement()
    {
        return modelElement;
    }

    public void setModelElement(IModelElement modelElement)
    {

        this.modelElement = modelElement;
    }

    @Override
    public boolean isStartTagClosed()
    {
        return isTwigTag() ? true : super.isStartTagClosed();
    }
}
