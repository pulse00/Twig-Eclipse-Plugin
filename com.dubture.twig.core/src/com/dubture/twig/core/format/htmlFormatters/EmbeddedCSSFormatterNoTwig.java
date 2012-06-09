/*******************************************************************************
 * This file is part of the Twig eclipse plugin.
 *
 * (c) Robert Gruendler <r.gruendler@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 ******************************************************************************/
package com.dubture.twig.core.format.htmlFormatters;

import org.eclipse.wst.html.core.internal.format.EmbeddedCSSFormatter;
import org.eclipse.wst.html.core.internal.format.HTMLTextFormatter;
import org.eclipse.wst.html.core.internal.provisional.HTMLFormatContraints;
import org.eclipse.wst.sse.core.internal.format.IStructuredFormatter;
import org.eclipse.wst.sse.core.internal.provisional.text.IStructuredDocumentRegion;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMNode;
import org.w3c.dom.Node;

@SuppressWarnings({"restriction", "deprecation"})
public class EmbeddedCSSFormatterNoTwig extends EmbeddedCSSFormatter
{

    /**
    */
    protected void formatChildNodes(IDOMNode node,
            HTMLFormatContraints contraints)
    {
        if (node == null)
            return;
        if (!node.hasChildNodes())
            return;

        // concat adjacent texts
        node.normalize();

        // disable sibling indent during formatting all the children
        boolean indent = false;
        if (contraints != null) {
            indent = contraints.getFormatWithSiblingIndent();
            contraints.setFormatWithSiblingIndent(false);
        }

        boolean insertBreak = true;
        IDOMNode child = (IDOMNode) node.getFirstChild();
        while (child != null) {
            if (child.getParentNode() != node)
                break;
            IDOMNode next = (IDOMNode) child.getNextSibling();

            if (insertBreak && canInsertBreakBefore(child)) {
                insertBreakBefore(child, contraints);
            }

            IStructuredFormatter formatter = HTMLFormatterNoTwigFactory
                    .getInstance().createFormatter(child,
                            getFormatPreferences());
            if (formatter != null) {
                if (formatter instanceof HTMLFormatterNoTwig) {
                    HTMLFormatterNoTwig htmlFormatter = (HTMLFormatterNoTwig) formatter;
                    htmlFormatter.formatNode(child, contraints);
                } else {
                    formatter.format(child);
                }
            }

            if (canInsertBreakAfter(child)) {
                insertBreakAfter(child, contraints);
                insertBreak = false; // not to insert twice
            } else {
                insertBreak = true;
            }

            child = next;
        }

        if (contraints != null)
            contraints.setFormatWithSiblingIndent(indent);
    }

    /**
    */
    protected void insertBreakAfter(IDOMNode node,
            HTMLFormatContraints contraints)
    {
        if (node == null)
            return;
        if (node.getNodeType() == Node.TEXT_NODE)
            return;
        Node parent = node.getParentNode();
        if (parent == null)
            return;
        Node next = node.getNextSibling();

        String spaces = null;
        if (next == null) { // last spaces
            // use parent indent for the end tag
            spaces = getBreakSpaces(parent);
        } else if (next.getNodeType() == Node.TEXT_NODE) {
            if (contraints != null && contraints.getFormatWithSiblingIndent()) {
                IDOMNode text = (IDOMNode) next;
                IStructuredFormatter formatter = HTMLFormatterNoTwigFactory
                        .getInstance().createFormatter(text,
                                getFormatPreferences());
                if (formatter instanceof HTMLTextFormatterNoTwig) {
                    HTMLTextFormatterNoTwig textFormatter = (HTMLTextFormatterNoTwig) formatter;
                    textFormatter.formatText(text, contraints,
                            HTMLTextFormatter.FORMAT_HEAD);
                }
            }
            return;
        } else {
            spaces = getBreakSpaces(node);
        }
        if (spaces == null || spaces.length() == 0)
            return;

        replaceSource(node.getModel(), node.getEndOffset(), 0, spaces);
        setWidth(contraints, spaces);
    }

    /**
    */
    protected void insertBreakBefore(IDOMNode node,
            HTMLFormatContraints contraints)
    {
        if (node == null)
            return;
        if (node.getNodeType() == Node.TEXT_NODE)
            return;
        Node parent = node.getParentNode();
        if (parent == null)
            return;
        Node prev = node.getPreviousSibling();

        String spaces = null;
        if (prev != null && prev.getNodeType() == Node.TEXT_NODE) {
            if (contraints != null && contraints.getFormatWithSiblingIndent()) {
                IDOMNode text = (IDOMNode) prev;
                IStructuredFormatter formatter = HTMLFormatterNoTwigFactory
                        .getInstance().createFormatter(text,
                                getFormatPreferences());
                if (formatter instanceof HTMLTextFormatterNoTwig) {
                    HTMLTextFormatterNoTwig textFormatter = (HTMLTextFormatterNoTwig) formatter;
                    textFormatter.formatText(text, contraints,
                            HTMLTextFormatter.FORMAT_TAIL);

                    if (node.hasChildNodes()) { // container
                        formatChildNodes(node, contraints);
                    } else { // leaf
                        IStructuredDocumentRegion flatNode = node
                                .getStartStructuredDocumentRegion();
                        if (flatNode != null) {
                            String source = flatNode.getText();
                            if (source != null && source.length() > 0) {
                                setWidth(contraints, source);
                            }
                        }
                    }

                }
            }
            return;
        } else {
            spaces = getBreakSpaces(node);
        }
        if (spaces == null || spaces.length() == 0)
            return;

        replaceSource(node.getModel(), node.getStartOffset(), 0, spaces);
        setWidth(contraints, spaces);
    }
}
